package okhttp3.internal.ws;

import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.f;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.l;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.EventListener;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class RealWebSocket implements WebSocket, WebSocketReader.FrameCallback {
    private static final long CANCEL_AFTER_CLOSE_MILLIS = 60000;
    public static final long DEFAULT_MINIMUM_DEFLATE_SIZE = 1024;
    private static final long MAX_QUEUE_SIZE = 16777216;
    private boolean awaitingPong;
    private Call call;
    private boolean enqueuedClose;
    private WebSocketExtensions extensions;
    private boolean failed;
    private final String key;
    private final WebSocketListener listener;
    private final ArrayDeque<Object> messageAndCloseQueue;
    private long minimumDeflateSize;
    private String name;
    private final Request originalRequest;
    private final long pingIntervalMillis;
    private final ArrayDeque<ByteString> pongQueue;
    private long queueSize;
    private final Random random;
    private WebSocketReader reader;
    private int receivedCloseCode;
    private String receivedCloseReason;
    private int receivedPingCount;
    private int receivedPongCount;
    private int sentPingCount;
    private Streams streams;
    private TaskQueue taskQueue;
    private WebSocketWriter writer;
    private Task writerTask;
    public static final Companion Companion = new Companion(null);
    private static final List<Protocol> ONLY_HTTP1 = f.e(Protocol.HTTP_1_1);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Close {
        private final long cancelAfterCloseMillis;
        private final int code;
        private final ByteString reason;

        public Close(int i11, ByteString byteString, long j11) {
            this.code = i11;
            this.reason = byteString;
            this.cancelAfterCloseMillis = j11;
        }

        public final long getCancelAfterCloseMillis() {
            return this.cancelAfterCloseMillis;
        }

        public final int getCode() {
            return this.code;
        }

        public final ByteString getReason() {
            return this.reason;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Message {
        private final ByteString data;
        private final int formatOpcode;

        public Message(int i11, ByteString data) {
            Intrinsics.g(data, "data");
            this.formatOpcode = i11;
            this.data = data;
        }

        public final ByteString getData() {
            return this.data;
        }

        public final int getFormatOpcode() {
            return this.formatOpcode;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static abstract class Streams implements Closeable {
        private final boolean client;
        private final BufferedSink sink;
        private final BufferedSource source;

        public Streams(boolean z11, BufferedSource source, BufferedSink sink) {
            Intrinsics.g(source, "source");
            Intrinsics.g(sink, "sink");
            this.client = z11;
            this.source = source;
            this.sink = sink;
        }

        public final boolean getClient() {
            return this.client;
        }

        public final BufferedSink getSink() {
            return this.sink;
        }

        public final BufferedSource getSource() {
            return this.source;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public final class WriterTask extends Task {
        public WriterTask() {
            super(RealWebSocket.this.name + " writer", false, 2, null);
        }

        @Override // okhttp3.internal.concurrent.Task
        public long runOnce() {
            try {
                return RealWebSocket.this.writeOneFrame$okhttp() ? 0L : -1L;
            } catch (IOException e11) {
                RealWebSocket.this.failWebSocket(e11, null);
                return -1L;
            }
        }
    }

    public RealWebSocket(TaskRunner taskRunner, Request originalRequest, WebSocketListener listener, Random random, long j11, WebSocketExtensions webSocketExtensions, long j12) {
        Intrinsics.g(taskRunner, "taskRunner");
        Intrinsics.g(originalRequest, "originalRequest");
        Intrinsics.g(listener, "listener");
        Intrinsics.g(random, "random");
        this.originalRequest = originalRequest;
        this.listener = listener;
        this.random = random;
        this.pingIntervalMillis = j11;
        this.extensions = webSocketExtensions;
        this.minimumDeflateSize = j12;
        this.taskQueue = taskRunner.newQueue();
        this.pongQueue = new ArrayDeque<>();
        this.messageAndCloseQueue = new ArrayDeque<>();
        this.receivedCloseCode = -1;
        if (!Intrinsics.b("GET", originalRequest.method())) {
            throw new IllegalArgumentException(("Request must be GET: " + originalRequest.method()).toString());
        }
        ByteString.Companion companion = ByteString.Companion;
        byte[] bArr = new byte[16];
        random.nextBytes(bArr);
        Unit unit = Unit.f68710a;
        this.key = ByteString.Companion.of$default(companion, bArr, 0, 0, 3, null).base64();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isValid(WebSocketExtensions webSocketExtensions) {
        if (webSocketExtensions.unknownValues || webSocketExtensions.clientMaxWindowBits != null) {
            return false;
        }
        Integer num = webSocketExtensions.serverMaxWindowBits;
        if (num == null) {
            return true;
        }
        int iIntValue = num.intValue();
        return 8 <= iIntValue && 15 >= iIntValue;
    }

    private final void runWriter() {
        if (!Util.assertionsEnabled || Thread.holdsLock(this)) {
            Task task = this.writerTask;
            if (task != null) {
                TaskQueue.schedule$default(this.taskQueue, task, 0L, 2, null);
                return;
            }
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Thread ");
        Thread threadCurrentThread = Thread.currentThread();
        Intrinsics.f(threadCurrentThread, "Thread.currentThread()");
        sb2.append(threadCurrentThread.getName());
        sb2.append(" MUST hold lock on ");
        sb2.append(this);
        throw new AssertionError(sb2.toString());
    }

    private final synchronized boolean send(ByteString byteString, int i11) {
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

    public final void awaitTermination(long j11, TimeUnit timeUnit) throws InterruptedException {
        Intrinsics.g(timeUnit, "timeUnit");
        this.taskQueue.idleLatch().await(j11, timeUnit);
    }

    @Override // okhttp3.WebSocket
    public void cancel() {
        Call call = this.call;
        Intrinsics.d(call);
        call.cancel();
    }

    public final void checkUpgradeSuccess$okhttp(Response response, Exchange exchange) throws IOException {
        Intrinsics.g(response, "response");
        if (response.code() != 101) {
            throw new ProtocolException("Expected HTTP 101 response but was '" + response.code() + ' ' + response.message() + '\'');
        }
        String strHeader$default = Response.header$default(response, "Connection", null, 2, null);
        if (!l.v("Upgrade", strHeader$default, true)) {
            throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + strHeader$default + '\'');
        }
        String strHeader$default2 = Response.header$default(response, "Upgrade", null, 2, null);
        if (!l.v("websocket", strHeader$default2, true)) {
            throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + strHeader$default2 + '\'');
        }
        String strHeader$default3 = Response.header$default(response, "Sec-WebSocket-Accept", null, 2, null);
        String strBase64 = ByteString.Companion.encodeUtf8(this.key + WebSocketProtocol.ACCEPT_MAGIC).sha1().base64();
        if (!(!Intrinsics.b(strBase64, strHeader$default3))) {
            if (exchange == null) {
                throw new ProtocolException("Web Socket exchange missing: bad interceptor?");
            }
            return;
        }
        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + strBase64 + "' but was '" + strHeader$default3 + '\'');
    }

    @Override // okhttp3.WebSocket
    public boolean close(int i11, String str) {
        return close(i11, str, 60000L);
    }

    public final synchronized boolean close(int i11, String str, long j11) {
        ByteString byteStringEncodeUtf8;
        try {
            WebSocketProtocol.INSTANCE.validateCloseCode(i11);
            if (str != null) {
                byteStringEncodeUtf8 = ByteString.Companion.encodeUtf8(str);
                if (!(((long) byteStringEncodeUtf8.size()) <= 123)) {
                    throw new IllegalArgumentException(("reason.size() > 123: " + str).toString());
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

    public final void connect(OkHttpClient client) {
        Intrinsics.g(client, "client");
        if (this.originalRequest.header("Sec-WebSocket-Extensions") != null) {
            failWebSocket(new ProtocolException("Request header not permitted: 'Sec-WebSocket-Extensions'"), null);
            return;
        }
        OkHttpClient okHttpClientBuild = client.newBuilder().eventListener(EventListener.NONE).protocols(ONLY_HTTP1).build();
        final Request requestBuild = this.originalRequest.newBuilder().header("Upgrade", "websocket").header("Connection", "Upgrade").header("Sec-WebSocket-Key", this.key).header("Sec-WebSocket-Version", PrepareException.ERROR_WARMUP_DOWNLOAD_EXCEPTION).header("Sec-WebSocket-Extensions", "permessage-deflate").build();
        RealCall realCall = new RealCall(okHttpClientBuild, requestBuild, true);
        this.call = realCall;
        Intrinsics.d(realCall);
        realCall.enqueue(new Callback() { // from class: okhttp3.internal.ws.RealWebSocket.connect.1
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException e11) {
                Intrinsics.g(call, "call");
                Intrinsics.g(e11, "e");
                RealWebSocket.this.failWebSocket(e11, null);
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                Intrinsics.g(call, "call");
                Intrinsics.g(response, "response");
                Exchange exchange = response.exchange();
                try {
                    RealWebSocket.this.checkUpgradeSuccess$okhttp(response, exchange);
                    Intrinsics.d(exchange);
                    Streams streamsNewWebSocketStreams = exchange.newWebSocketStreams();
                    WebSocketExtensions webSocketExtensions = WebSocketExtensions.Companion.parse(response.headers());
                    RealWebSocket.this.extensions = webSocketExtensions;
                    if (!RealWebSocket.this.isValid(webSocketExtensions)) {
                        synchronized (RealWebSocket.this) {
                            RealWebSocket.this.messageAndCloseQueue.clear();
                            RealWebSocket.this.close(1010, "unexpected Sec-WebSocket-Extensions in response header");
                        }
                    }
                    try {
                        RealWebSocket.this.initReaderAndWriter(Util.okHttpName + " WebSocket " + requestBuild.url().redact(), streamsNewWebSocketStreams);
                        RealWebSocket.this.getListener$okhttp().onOpen(RealWebSocket.this, response);
                        RealWebSocket.this.loopReader();
                    } catch (Exception e11) {
                        RealWebSocket.this.failWebSocket(e11, null);
                    }
                } catch (IOException e12) {
                    if (exchange != null) {
                        exchange.webSocketUpgradeFailed();
                    }
                    RealWebSocket.this.failWebSocket(e12, response);
                    Util.closeQuietly(response);
                }
            }
        });
    }

    public final void failWebSocket(Exception e11, Response response) {
        Intrinsics.g(e11, "e");
        synchronized (this) {
            if (this.failed) {
                return;
            }
            this.failed = true;
            Streams streams = this.streams;
            this.streams = null;
            WebSocketReader webSocketReader = this.reader;
            this.reader = null;
            WebSocketWriter webSocketWriter = this.writer;
            this.writer = null;
            this.taskQueue.shutdown();
            Unit unit = Unit.f68710a;
            try {
                this.listener.onFailure(this, e11, response);
            } finally {
                if (streams != null) {
                    Util.closeQuietly(streams);
                }
                if (webSocketReader != null) {
                    Util.closeQuietly(webSocketReader);
                }
                if (webSocketWriter != null) {
                    Util.closeQuietly(webSocketWriter);
                }
            }
        }
    }

    public final WebSocketListener getListener$okhttp() {
        return this.listener;
    }

    public final void initReaderAndWriter(final String name, final Streams streams) throws IOException {
        Intrinsics.g(name, "name");
        Intrinsics.g(streams, "streams");
        final WebSocketExtensions webSocketExtensions = this.extensions;
        Intrinsics.d(webSocketExtensions);
        synchronized (this) {
            try {
                this.name = name;
                this.streams = streams;
                this.writer = new WebSocketWriter(streams.getClient(), streams.getSink(), this.random, webSocketExtensions.perMessageDeflate, webSocketExtensions.noContextTakeover(streams.getClient()), this.minimumDeflateSize);
                this.writerTask = new WriterTask();
                long j11 = this.pingIntervalMillis;
                if (j11 != 0) {
                    final long nanos = TimeUnit.MILLISECONDS.toNanos(j11);
                    final String str = name + " ping";
                    this.taskQueue.schedule(new Task(str) { // from class: okhttp3.internal.ws.RealWebSocket$initReaderAndWriter$$inlined$synchronized$lambda$1
                        @Override // okhttp3.internal.concurrent.Task
                        public long runOnce() {
                            this.writePingFrame$okhttp();
                            return nanos;
                        }
                    }, nanos);
                }
                if (!this.messageAndCloseQueue.isEmpty()) {
                    runWriter();
                }
                Unit unit = Unit.f68710a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        this.reader = new WebSocketReader(streams.getClient(), streams.getSource(), this, webSocketExtensions.perMessageDeflate, webSocketExtensions.noContextTakeover(!streams.getClient()));
    }

    public final void loopReader() throws IOException {
        while (this.receivedCloseCode == -1) {
            WebSocketReader webSocketReader = this.reader;
            Intrinsics.d(webSocketReader);
            webSocketReader.processNextFrame();
        }
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadClose(int i11, String reason) {
        Streams streams;
        WebSocketReader webSocketReader;
        WebSocketWriter webSocketWriter;
        Intrinsics.g(reason, "reason");
        if (!(i11 != -1)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        synchronized (this) {
            try {
                if (!(this.receivedCloseCode == -1)) {
                    throw new IllegalStateException("already closed".toString());
                }
                this.receivedCloseCode = i11;
                this.receivedCloseReason = reason;
                streams = null;
                if (this.enqueuedClose && this.messageAndCloseQueue.isEmpty()) {
                    Streams streams2 = this.streams;
                    this.streams = null;
                    webSocketReader = this.reader;
                    this.reader = null;
                    webSocketWriter = this.writer;
                    this.writer = null;
                    this.taskQueue.shutdown();
                    streams = streams2;
                } else {
                    webSocketReader = null;
                    webSocketWriter = null;
                }
                Unit unit = Unit.f68710a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        try {
            this.listener.onClosing(this, i11, reason);
            if (streams != null) {
                this.listener.onClosed(this, i11, reason);
            }
        } finally {
            if (streams != null) {
                Util.closeQuietly(streams);
            }
            if (webSocketReader != null) {
                Util.closeQuietly(webSocketReader);
            }
            if (webSocketWriter != null) {
                Util.closeQuietly(webSocketWriter);
            }
        }
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(String text) throws IOException {
        Intrinsics.g(text, "text");
        this.listener.onMessage(this, text);
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(ByteString bytes) throws IOException {
        Intrinsics.g(bytes, "bytes");
        this.listener.onMessage(this, bytes);
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPing(ByteString payload) {
        try {
            Intrinsics.g(payload, "payload");
            if (!this.failed && (!this.enqueuedClose || !this.messageAndCloseQueue.isEmpty())) {
                this.pongQueue.add(payload);
                runWriter();
                this.receivedPingCount++;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPong(ByteString payload) {
        Intrinsics.g(payload, "payload");
        this.receivedPongCount++;
        this.awaitingPong = false;
    }

    public final synchronized boolean pong(ByteString payload) {
        try {
            Intrinsics.g(payload, "payload");
            if (!this.failed && (!this.enqueuedClose || !this.messageAndCloseQueue.isEmpty())) {
                this.pongQueue.add(payload);
                runWriter();
                return true;
            }
            return false;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final boolean processNextFrame() throws IOException {
        try {
            WebSocketReader webSocketReader = this.reader;
            Intrinsics.d(webSocketReader);
            webSocketReader.processNextFrame();
            return this.receivedCloseCode == -1;
        } catch (Exception e11) {
            failWebSocket(e11, null);
            return false;
        }
    }

    @Override // okhttp3.WebSocket
    public synchronized long queueSize() {
        return this.queueSize;
    }

    public final synchronized int receivedPingCount() {
        return this.receivedPingCount;
    }

    public final synchronized int receivedPongCount() {
        return this.receivedPongCount;
    }

    @Override // okhttp3.WebSocket
    public Request request() {
        return this.originalRequest;
    }

    @Override // okhttp3.WebSocket
    public boolean send(String text) {
        Intrinsics.g(text, "text");
        return send(ByteString.Companion.encodeUtf8(text), 1);
    }

    @Override // okhttp3.WebSocket
    public boolean send(ByteString bytes) {
        Intrinsics.g(bytes, "bytes");
        return send(bytes, 2);
    }

    public final synchronized int sentPingCount() {
        return this.sentPingCount;
    }

    public final void tearDown() throws InterruptedException {
        this.taskQueue.shutdown();
        this.taskQueue.idleLatch().await(10L, TimeUnit.SECONDS);
    }

    /* JADX WARN: Code duplicated, block: B:62:0x0186  */
    /* JADX WARN: Code duplicated, block: B:65:0x0191  */
    /* JADX WARN: Code duplicated, block: B:68:0x019c  */
    /* JADX WARN: Code duplicated, block: B:97:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v15, types: [T, okhttp3.internal.ws.RealWebSocket$Streams] */
    /* JADX WARN: Type inference failed for: r2v16, types: [T, okhttp3.internal.ws.WebSocketReader] */
    /* JADX WARN: Type inference failed for: r2v17, types: [T, okhttp3.internal.ws.WebSocketWriter] */
    /* JADX WARN: Type inference failed for: r3v16, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v2, types: [T, java.lang.String] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final boolean writeOneFrame$okhttp() throws Throwable {
        final Ref.ObjectRef objectRef;
        final Ref.ObjectRef objectRef2;
        Ref.ObjectRef objectRef3;
        Ref.ObjectRef objectRef4;
        Ref.ObjectRef objectRef5;
        Ref.ObjectRef objectRef6;
        Streams streams;
        WebSocketReader webSocketReader;
        WebSocketWriter webSocketWriter;
        final Ref.ObjectRef objectRef7 = new Ref.ObjectRef();
        objectRef7.element = null;
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = -1;
        final Ref.ObjectRef objectRef8 = new Ref.ObjectRef();
        objectRef8.element = null;
        final Ref.ObjectRef objectRef9 = new Ref.ObjectRef();
        objectRef9.element = null;
        Ref.ObjectRef objectRef10 = new Ref.ObjectRef();
        objectRef10.element = null;
        Ref.ObjectRef objectRef11 = new Ref.ObjectRef();
        objectRef11.element = null;
        synchronized (this) {
            try {
                if (this.failed) {
                    return false;
                }
                final WebSocketWriter webSocketWriter2 = this.writer;
                final ByteString byteStringPoll = this.pongQueue.poll();
                if (byteStringPoll == null) {
                    ?? Poll = this.messageAndCloseQueue.poll();
                    objectRef7.element = Poll;
                    if (Poll instanceof Close) {
                        int i11 = this.receivedCloseCode;
                        intRef.element = i11;
                        objectRef8.element = this.receivedCloseReason;
                        if (i11 != -1) {
                            objectRef9.element = this.streams;
                            this.streams = null;
                            objectRef10.element = this.reader;
                            this.reader = null;
                            objectRef11.element = this.writer;
                            this.writer = null;
                            this.taskQueue.shutdown();
                            objectRef = objectRef11;
                            objectRef2 = objectRef10;
                        } else {
                            T t11 = objectRef7.element;
                            if (t11 == 0) {
                                throw new NullPointerException("null cannot be cast to non-null type okhttp3.internal.ws.RealWebSocket.Close");
                            }
                            long cancelAfterCloseMillis = ((Close) t11).getCancelAfterCloseMillis();
                            TaskQueue taskQueue = this.taskQueue;
                            final String str = this.name + " cancel";
                            final boolean z11 = true;
                            objectRef = objectRef11;
                            objectRef2 = objectRef10;
                            taskQueue.schedule(new Task(str, z11) { // from class: okhttp3.internal.ws.RealWebSocket$writeOneFrame$$inlined$synchronized$lambda$1
                                @Override // okhttp3.internal.concurrent.Task
                                public long runOnce() {
                                    this.cancel();
                                    return -1L;
                                }
                            }, TimeUnit.MILLISECONDS.toNanos(cancelAfterCloseMillis));
                        }
                    } else {
                        objectRef = objectRef11;
                        objectRef2 = objectRef10;
                        if (Poll == 0) {
                            return false;
                        }
                    }
                } else {
                    objectRef = objectRef11;
                    objectRef2 = objectRef10;
                }
                Unit unit = Unit.f68710a;
                ByteString byteString = byteStringPoll;
                try {
                    if (byteString == null) {
                        WebSocketWriter webSocketWriter3 = webSocketWriter2;
                        T t12 = objectRef7.element;
                        if (t12 instanceof Message) {
                            if (t12 == 0) {
                                throw new NullPointerException("null cannot be cast to non-null type okhttp3.internal.ws.RealWebSocket.Message");
                            }
                            Message message = (Message) t12;
                            Intrinsics.d(webSocketWriter3);
                            webSocketWriter3.writeMessageFrame(message.getFormatOpcode(), message.getData());
                            synchronized (this) {
                                this.queueSize -= (long) message.getData().size();
                            }
                            Streams streams2 = (Streams) objectRef5.element;
                            if (streams2 != null) {
                                Util.closeQuietly(streams2);
                            }
                            WebSocketReader webSocketReader2 = (WebSocketReader) objectRef4.element;
                            if (webSocketReader2 != null) {
                                Util.closeQuietly(webSocketReader2);
                            }
                            WebSocketWriter webSocketWriter4 = (WebSocketWriter) objectRef3.element;
                            if (webSocketWriter4 != null) {
                                Util.closeQuietly(webSocketWriter4);
                            }
                            throw th;
                        }
                        boolean z12 = t12 instanceof Close;
                        try {
                            if (!z12) {
                                throw new AssertionError();
                            }
                            if (t12 == 0) {
                                throw new NullPointerException("null cannot be cast to non-null type okhttp3.internal.ws.RealWebSocket.Close");
                            }
                            Close close = (Close) t12;
                            Intrinsics.d(webSocketWriter3);
                            webSocketWriter3.writeClose(close.getCode(), close.getReason());
                            Ref.ObjectRef objectRef12 = objectRef9;
                            try {
                                Streams streams3 = (Streams) objectRef12.element;
                                objectRef6 = objectRef12;
                                if (streams3 != null) {
                                    WebSocketListener webSocketListener = this.listener;
                                    int i12 = intRef.element;
                                    String str2 = (String) objectRef8.element;
                                    Intrinsics.d(str2);
                                    webSocketListener.onClosed(this, i12, str2);
                                    objectRef6 = objectRef12;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                objectRef3 = objectRef;
                                objectRef4 = objectRef2;
                                objectRef5 = objectRef12;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            objectRef5 = webSocketWriter3;
                            objectRef4 = z12;
                            objectRef3 = byteString;
                        }
                        streams = (Streams) objectRef6.element;
                        if (streams != null) {
                            Util.closeQuietly(streams);
                        }
                        webSocketReader = (WebSocketReader) objectRef2.element;
                        if (webSocketReader != null) {
                            Util.closeQuietly(webSocketReader);
                        }
                        webSocketWriter = (WebSocketWriter) objectRef.element;
                        if (webSocketWriter != null) {
                            return true;
                        }
                        Util.closeQuietly(webSocketWriter);
                        return true;
                    }
                    Intrinsics.d(webSocketWriter2);
                    webSocketWriter2.writePong(byteString);
                    objectRef6 = objectRef9;
                    streams = (Streams) objectRef6.element;
                    if (streams != null) {
                        Util.closeQuietly(streams);
                    }
                    webSocketReader = (WebSocketReader) objectRef2.element;
                    if (webSocketReader != null) {
                        Util.closeQuietly(webSocketReader);
                    }
                    webSocketWriter = (WebSocketWriter) objectRef.element;
                    if (webSocketWriter != null) {
                        return true;
                    }
                    Util.closeQuietly(webSocketWriter);
                    return true;
                } catch (Throwable th4) {
                    th = th4;
                    objectRef3 = objectRef;
                    objectRef4 = objectRef2;
                    objectRef5 = objectRef9;
                }
            } catch (Throwable th5) {
                throw th5;
            }
        }
    }

    public final void writePingFrame$okhttp() {
        synchronized (this) {
            try {
                if (this.failed) {
                    return;
                }
                WebSocketWriter webSocketWriter = this.writer;
                if (webSocketWriter != null) {
                    int i11 = this.awaitingPong ? this.sentPingCount : -1;
                    this.sentPingCount++;
                    this.awaitingPong = true;
                    Unit unit = Unit.f68710a;
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
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
