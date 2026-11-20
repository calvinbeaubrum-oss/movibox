package com.mbridge.msdk.thrid.okhttp.internal.ws;

import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.mbridge.msdk.thrid.okhttp.Call;
import com.mbridge.msdk.thrid.okhttp.Callback;
import com.mbridge.msdk.thrid.okhttp.EventListener;
import com.mbridge.msdk.thrid.okhttp.OkHttpClient;
import com.mbridge.msdk.thrid.okhttp.Protocol;
import com.mbridge.msdk.thrid.okhttp.Request;
import com.mbridge.msdk.thrid.okhttp.Response;
import com.mbridge.msdk.thrid.okhttp.WebSocket;
import com.mbridge.msdk.thrid.okhttp.WebSocketListener;
import com.mbridge.msdk.thrid.okhttp.internal.Internal;
import com.mbridge.msdk.thrid.okhttp.internal.Util;
import com.mbridge.msdk.thrid.okhttp.internal.connection.StreamAllocation;
import com.mbridge.msdk.thrid.okio.BufferedSink;
import com.mbridge.msdk.thrid.okio.BufferedSource;
import com.mbridge.msdk.thrid.okio.ByteString;
import com.mbridge.msdk.thrid.okio.Okio;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class RealWebSocket implements WebSocket, WebSocketReader.FrameCallback {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long CANCEL_AFTER_CLOSE_MILLIS = 60000;
    private static final long MAX_QUEUE_SIZE = 16777216;
    private static final List<Protocol> ONLY_HTTP1 = Collections.singletonList(Protocol.HTTP_1_1);
    private boolean awaitingPong;
    private Call call;
    private ScheduledFuture<?> cancelFuture;
    private boolean enqueuedClose;
    private ScheduledExecutorService executor;
    private boolean failed;
    private final String key;
    final WebSocketListener listener;
    private final Request originalRequest;
    private final long pingIntervalMillis;
    private long queueSize;
    private final Random random;
    private WebSocketReader reader;
    private String receivedCloseReason;
    private int receivedPingCount;
    private int receivedPongCount;
    private int sentPingCount;
    private Streams streams;
    private WebSocketWriter writer;
    private final Runnable writerRunnable;
    private final ArrayDeque<ByteString> pongQueue = new ArrayDeque<>();
    private final ArrayDeque<Object> messageAndCloseQueue = new ArrayDeque<>();
    private int receivedCloseCode = -1;

    /* JADX INFO: compiled from: source.java */
    public final class CancelRunnable implements Runnable {
        public CancelRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RealWebSocket.this.cancel();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class Close {
        final long cancelAfterCloseMillis;
        final int code;
        final ByteString reason;

        public Close(int i11, ByteString byteString, long j11) {
            this.code = i11;
            this.reason = byteString;
            this.cancelAfterCloseMillis = j11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class Message {
        final ByteString data;
        final int formatOpcode;

        public Message(int i11, ByteString byteString) {
            this.formatOpcode = i11;
            this.data = byteString;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class PingRunnable implements Runnable {
        public PingRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RealWebSocket.this.writePingFrame();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class Streams implements Closeable {
        public final boolean client;
        public final BufferedSink sink;
        public final BufferedSource source;

        public Streams(boolean z11, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            this.client = z11;
            this.source = bufferedSource;
            this.sink = bufferedSink;
        }
    }

    public RealWebSocket(Request request, WebSocketListener webSocketListener, Random random, long j11) {
        if (!"GET".equals(request.method())) {
            throw new IllegalArgumentException("Request must be GET: " + request.method());
        }
        this.originalRequest = request;
        this.listener = webSocketListener;
        this.random = random;
        this.pingIntervalMillis = j11;
        byte[] bArr = new byte[16];
        random.nextBytes(bArr);
        this.key = ByteString.of(bArr).base64();
        this.writerRunnable = new Runnable() { // from class: com.mbridge.msdk.thrid.okhttp.internal.ws.RealWebSocket.1
            @Override // java.lang.Runnable
            public void run() {
                do {
                    try {
                    } catch (IOException e11) {
                        RealWebSocket.this.failWebSocket(e11, null);
                        return;
                    }
                } while (RealWebSocket.this.writeOneFrame());
            }
        };
    }

    private void runWriter() {
        ScheduledExecutorService scheduledExecutorService = this.executor;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.execute(this.writerRunnable);
        }
    }

    private synchronized boolean send(ByteString byteString, int i11) {
        if (!this.failed && !this.enqueuedClose) {
            if (this.queueSize + ((long) byteString.size()) > MAX_QUEUE_SIZE) {
                close(1001, null);
                return false;
            }
            this.queueSize += (long) byteString.size();
            this.messageAndCloseQueue.add(new Message(i11, byteString));
            runWriter();
            return true;
        }
        return false;
    }

    public void awaitTermination(int i11, TimeUnit timeUnit) throws InterruptedException {
        this.executor.awaitTermination(i11, timeUnit);
    }

    @Override // com.mbridge.msdk.thrid.okhttp.WebSocket
    public void cancel() {
        this.call.cancel();
    }

    public void checkResponse(Response response) throws ProtocolException {
        if (response.code() != 101) {
            throw new ProtocolException("Expected HTTP 101 response but was '" + response.code() + " " + response.message() + "'");
        }
        String strHeader = response.header("Connection");
        if (!"Upgrade".equalsIgnoreCase(strHeader)) {
            throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + strHeader + "'");
        }
        String strHeader2 = response.header("Upgrade");
        if (!"websocket".equalsIgnoreCase(strHeader2)) {
            throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + strHeader2 + "'");
        }
        String strHeader3 = response.header("Sec-WebSocket-Accept");
        String strBase64 = ByteString.encodeUtf8(this.key + okhttp3.internal.ws.WebSocketProtocol.ACCEPT_MAGIC).sha1().base64();
        if (strBase64.equals(strHeader3)) {
            return;
        }
        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + strBase64 + "' but was '" + strHeader3 + "'");
    }

    @Override // com.mbridge.msdk.thrid.okhttp.WebSocket
    public boolean close(int i11, String str) {
        return close(i11, str, 60000L);
    }

    public synchronized boolean close(int i11, String str, long j11) {
        ByteString byteStringEncodeUtf8;
        try {
            WebSocketProtocol.validateCloseCode(i11);
            if (str != null) {
                byteStringEncodeUtf8 = ByteString.encodeUtf8(str);
                if (byteStringEncodeUtf8.size() > 123) {
                    throw new IllegalArgumentException("reason.size() > 123: " + str);
                }
            } else {
                byteStringEncodeUtf8 = null;
            }
            if (!this.failed && !this.enqueuedClose) {
                this.enqueuedClose = true;
                this.messageAndCloseQueue.add(new Close(i11, byteStringEncodeUtf8, j11));
                runWriter();
                return true;
            }
            return false;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public void connect(OkHttpClient okHttpClient) {
        OkHttpClient okHttpClientBuild = okHttpClient.newBuilder().eventListener(EventListener.NONE).protocols(ONLY_HTTP1).build();
        final Request requestBuild = this.originalRequest.newBuilder().header("Upgrade", "websocket").header("Connection", "Upgrade").header("Sec-WebSocket-Key", this.key).header("Sec-WebSocket-Version", PrepareException.ERROR_WARMUP_DOWNLOAD_EXCEPTION).build();
        Call callNewWebSocketCall = Internal.instance.newWebSocketCall(okHttpClientBuild, requestBuild);
        this.call = callNewWebSocketCall;
        callNewWebSocketCall.timeout().clearTimeout();
        this.call.enqueue(new Callback() { // from class: com.mbridge.msdk.thrid.okhttp.internal.ws.RealWebSocket.2
            @Override // com.mbridge.msdk.thrid.okhttp.Callback
            public void onFailure(Call call, IOException iOException) {
                RealWebSocket.this.failWebSocket(iOException, null);
            }

            @Override // com.mbridge.msdk.thrid.okhttp.Callback
            public void onResponse(Call call, Response response) {
                try {
                    RealWebSocket.this.checkResponse(response);
                    StreamAllocation streamAllocation = Internal.instance.streamAllocation(call);
                    streamAllocation.noNewStreams();
                    Streams streamsNewWebSocketStreams = streamAllocation.connection().newWebSocketStreams(streamAllocation);
                    try {
                        RealWebSocket realWebSocket = RealWebSocket.this;
                        realWebSocket.listener.onOpen(realWebSocket, response);
                        RealWebSocket.this.initReaderAndWriter("OkHttp WebSocket " + requestBuild.url().redact(), streamsNewWebSocketStreams);
                        streamAllocation.connection().socket().setSoTimeout(0);
                        RealWebSocket.this.loopReader();
                    } catch (Exception e11) {
                        RealWebSocket.this.failWebSocket(e11, null);
                    }
                } catch (ProtocolException e12) {
                    RealWebSocket.this.failWebSocket(e12, response);
                    Util.closeQuietly(response);
                }
            }
        });
    }

    public void failWebSocket(Exception exc, Response response) {
        synchronized (this) {
            try {
                if (this.failed) {
                    return;
                }
                this.failed = true;
                Streams streams = this.streams;
                this.streams = null;
                ScheduledFuture<?> scheduledFuture = this.cancelFuture;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                }
                ScheduledExecutorService scheduledExecutorService = this.executor;
                if (scheduledExecutorService != null) {
                    scheduledExecutorService.shutdown();
                }
                try {
                    this.listener.onFailure(this, exc, response);
                } finally {
                    Util.closeQuietly(streams);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void initReaderAndWriter(String str, Streams streams) throws IOException {
        synchronized (this) {
            try {
                this.streams = streams;
                this.writer = new WebSocketWriter(streams.client, streams.sink, this.random);
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, Util.threadFactory(str, false));
                this.executor = scheduledThreadPoolExecutor;
                if (this.pingIntervalMillis != 0) {
                    PingRunnable pingRunnable = new PingRunnable();
                    long j11 = this.pingIntervalMillis;
                    scheduledThreadPoolExecutor.scheduleAtFixedRate(pingRunnable, j11, j11, TimeUnit.MILLISECONDS);
                }
                if (!this.messageAndCloseQueue.isEmpty()) {
                    runWriter();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        this.reader = new WebSocketReader(streams.client, streams.source, this);
    }

    public void loopReader() throws IOException {
        while (this.receivedCloseCode == -1) {
            this.reader.processNextFrame();
        }
    }

    @Override // com.mbridge.msdk.thrid.okhttp.internal.ws.WebSocketReader.FrameCallback
    public void onReadClose(int i11, String str) {
        Streams streams;
        if (i11 == -1) {
            throw new IllegalArgumentException();
        }
        synchronized (this) {
            try {
                if (this.receivedCloseCode != -1) {
                    throw new IllegalStateException("already closed");
                }
                this.receivedCloseCode = i11;
                this.receivedCloseReason = str;
                streams = null;
                if (this.enqueuedClose && this.messageAndCloseQueue.isEmpty()) {
                    Streams streams2 = this.streams;
                    this.streams = null;
                    ScheduledFuture<?> scheduledFuture = this.cancelFuture;
                    if (scheduledFuture != null) {
                        scheduledFuture.cancel(false);
                    }
                    this.executor.shutdown();
                    streams = streams2;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        try {
            this.listener.onClosing(this, i11, str);
            if (streams != null) {
                this.listener.onClosed(this, i11, str);
            }
        } finally {
            Util.closeQuietly(streams);
        }
    }

    @Override // com.mbridge.msdk.thrid.okhttp.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(ByteString byteString) throws IOException {
        this.listener.onMessage(this, byteString);
    }

    @Override // com.mbridge.msdk.thrid.okhttp.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(String str) throws IOException {
        this.listener.onMessage(this, str);
    }

    @Override // com.mbridge.msdk.thrid.okhttp.internal.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPing(ByteString byteString) {
        try {
            if (!this.failed && (!this.enqueuedClose || !this.messageAndCloseQueue.isEmpty())) {
                this.pongQueue.add(byteString);
                runWriter();
                this.receivedPingCount++;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // com.mbridge.msdk.thrid.okhttp.internal.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPong(ByteString byteString) {
        this.receivedPongCount++;
        this.awaitingPong = false;
    }

    public synchronized boolean pong(ByteString byteString) {
        try {
            if (!this.failed && (!this.enqueuedClose || !this.messageAndCloseQueue.isEmpty())) {
                this.pongQueue.add(byteString);
                runWriter();
                return true;
            }
            return false;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public boolean processNextFrame() throws IOException {
        try {
            this.reader.processNextFrame();
            return this.receivedCloseCode == -1;
        } catch (Exception e11) {
            failWebSocket(e11, null);
            return false;
        }
    }

    @Override // com.mbridge.msdk.thrid.okhttp.WebSocket
    public synchronized long queueSize() {
        return this.queueSize;
    }

    public synchronized int receivedPingCount() {
        return this.receivedPingCount;
    }

    public synchronized int receivedPongCount() {
        return this.receivedPongCount;
    }

    @Override // com.mbridge.msdk.thrid.okhttp.WebSocket
    public Request request() {
        return this.originalRequest;
    }

    @Override // com.mbridge.msdk.thrid.okhttp.WebSocket
    public boolean send(ByteString byteString) {
        if (byteString != null) {
            return send(byteString, 2);
        }
        throw new NullPointerException("bytes == null");
    }

    @Override // com.mbridge.msdk.thrid.okhttp.WebSocket
    public boolean send(String str) {
        if (str != null) {
            return send(ByteString.encodeUtf8(str), 1);
        }
        throw new NullPointerException("text == null");
    }

    public synchronized int sentPingCount() {
        return this.sentPingCount;
    }

    public void tearDown() throws InterruptedException {
        ScheduledFuture<?> scheduledFuture = this.cancelFuture;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.executor.shutdown();
        this.executor.awaitTermination(10L, TimeUnit.SECONDS);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0059 A[Catch: all -> 0x005d, TRY_ENTER, TryCatch #2 {all -> 0x005d, blocks: (B:26:0x0059, B:29:0x005f, B:31:0x0063, B:32:0x007f, B:38:0x008e, B:39:0x008f, B:41:0x0093, B:43:0x009e, B:46:0x00a8, B:47:0x00ad, B:33:0x0080, B:34:0x008a), top: B:55:0x0057, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x005f A[Catch: all -> 0x005d, TryCatch #2 {all -> 0x005d, blocks: (B:26:0x0059, B:29:0x005f, B:31:0x0063, B:32:0x007f, B:38:0x008e, B:39:0x008f, B:41:0x0093, B:43:0x009e, B:46:0x00a8, B:47:0x00ad, B:33:0x0080, B:34:0x008a), top: B:55:0x0057, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x0063 A[Catch: all -> 0x005d, TryCatch #2 {all -> 0x005d, blocks: (B:26:0x0059, B:29:0x005f, B:31:0x0063, B:32:0x007f, B:38:0x008e, B:39:0x008f, B:41:0x0093, B:43:0x009e, B:46:0x00a8, B:47:0x00ad, B:33:0x0080, B:34:0x008a), top: B:55:0x0057, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x008f A[Catch: all -> 0x005d, TryCatch #2 {all -> 0x005d, blocks: (B:26:0x0059, B:29:0x005f, B:31:0x0063, B:32:0x007f, B:38:0x008e, B:39:0x008f, B:41:0x0093, B:43:0x009e, B:46:0x00a8, B:47:0x00ad, B:33:0x0080, B:34:0x008a), top: B:55:0x0057, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x0093 A[Catch: all -> 0x005d, TryCatch #2 {all -> 0x005d, blocks: (B:26:0x0059, B:29:0x005f, B:31:0x0063, B:32:0x007f, B:38:0x008e, B:39:0x008f, B:41:0x0093, B:43:0x009e, B:46:0x00a8, B:47:0x00ad, B:33:0x0080, B:34:0x008a), top: B:55:0x0057, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x009e A[Catch: all -> 0x005d, TRY_LEAVE, TryCatch #2 {all -> 0x005d, blocks: (B:26:0x0059, B:29:0x005f, B:31:0x0063, B:32:0x007f, B:38:0x008e, B:39:0x008f, B:41:0x0093, B:43:0x009e, B:46:0x00a8, B:47:0x00ad, B:33:0x0080, B:34:0x008a), top: B:55:0x0057, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x00a8 A[Catch: all -> 0x005d, TRY_ENTER, TryCatch #2 {all -> 0x005d, blocks: (B:26:0x0059, B:29:0x005f, B:31:0x0063, B:32:0x007f, B:38:0x008e, B:39:0x008f, B:41:0x0093, B:43:0x009e, B:46:0x00a8, B:47:0x00ad, B:33:0x0080, B:34:0x008a), top: B:55:0x0057, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x0080 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public boolean writeOneFrame() throws IOException {
        Streams streams;
        String str;
        int i11;
        ByteString byteString;
        synchronized (this) {
            try {
                if (this.failed) {
                    return false;
                }
                WebSocketWriter webSocketWriter = this.writer;
                ByteString byteStringPoll = this.pongQueue.poll();
                Object obj = null;
                try {
                    if (byteStringPoll == null) {
                        Object objPoll = this.messageAndCloseQueue.poll();
                        if (objPoll instanceof Close) {
                            i11 = this.receivedCloseCode;
                            str = this.receivedCloseReason;
                            if (i11 != -1) {
                                streams = this.streams;
                                this.streams = null;
                                this.executor.shutdown();
                            } else {
                                this.cancelFuture = this.executor.schedule(new CancelRunnable(), ((Close) objPoll).cancelAfterCloseMillis, TimeUnit.MILLISECONDS);
                                streams = null;
                            }
                            obj = objPoll;
                        } else {
                            if (objPoll == null) {
                                return false;
                            }
                            streams = null;
                            str = null;
                            obj = objPoll;
                        }
                        if (byteStringPoll != null) {
                            webSocketWriter.writePong(byteStringPoll);
                        } else if (obj instanceof Message) {
                            byteString = ((Message) obj).data;
                            BufferedSink bufferedSinkBuffer = Okio.buffer(webSocketWriter.newMessageSink(((Message) obj).formatOpcode, byteString.size()));
                            bufferedSinkBuffer.write(byteString);
                            bufferedSinkBuffer.close();
                            synchronized (this) {
                                this.queueSize -= (long) byteString.size();
                            }
                        } else {
                            if (obj instanceof Close) {
                                throw new AssertionError();
                            }
                            Close close = (Close) obj;
                            webSocketWriter.writeClose(close.code, close.reason);
                            if (streams != null) {
                                this.listener.onClosed(this, i11, str);
                            }
                        }
                        Util.closeQuietly(streams);
                        return true;
                    }
                    streams = null;
                    str = null;
                    if (byteStringPoll != null) {
                        webSocketWriter.writePong(byteStringPoll);
                    } else if (obj instanceof Message) {
                        byteString = ((Message) obj).data;
                        BufferedSink bufferedSinkBuffer2 = Okio.buffer(webSocketWriter.newMessageSink(((Message) obj).formatOpcode, byteString.size()));
                        bufferedSinkBuffer2.write(byteString);
                        bufferedSinkBuffer2.close();
                        synchronized (this) {
                            this.queueSize -= (long) byteString.size();
                        }
                    } else {
                        if (obj instanceof Close) {
                            throw new AssertionError();
                        }
                        Close close2 = (Close) obj;
                        webSocketWriter.writeClose(close2.code, close2.reason);
                        if (streams != null) {
                            this.listener.onClosed(this, i11, str);
                        }
                    }
                    Util.closeQuietly(streams);
                    return true;
                } catch (Throwable th2) {
                    Util.closeQuietly(streams);
                    throw th2;
                }
                i11 = -1;
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    public void writePingFrame() {
        synchronized (this) {
            try {
                if (this.failed) {
                    return;
                }
                WebSocketWriter webSocketWriter = this.writer;
                int i11 = this.awaitingPong ? this.sentPingCount : -1;
                this.sentPingCount++;
                this.awaitingPong = true;
                if (i11 == -1) {
                    try {
                        webSocketWriter.writePing(ByteString.EMPTY);
                        return;
                    } catch (IOException e11) {
                        failWebSocket(e11, null);
                        return;
                    }
                }
                failWebSocket(new SocketTimeoutException("sent ping but didn't receive pong within " + this.pingIntervalMillis + "ms (after " + (i11 - 1) + " successful ping/pongs)"), null);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
