package com.mbridge.msdk.thrid.okhttp.internal.http2;

import com.google.android.gms.common.api.Api;
import com.mbridge.msdk.thrid.okhttp.Protocol;
import com.mbridge.msdk.thrid.okhttp.internal.NamedRunnable;
import com.mbridge.msdk.thrid.okhttp.internal.Util;
import com.mbridge.msdk.thrid.okhttp.internal.platform.Platform;
import com.mbridge.msdk.thrid.okio.Buffer;
import com.mbridge.msdk.thrid.okio.BufferedSink;
import com.mbridge.msdk.thrid.okio.BufferedSource;
import com.mbridge.msdk.thrid.okio.ByteString;
import com.mbridge.msdk.thrid.okio.Okio;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class Http2Connection implements Closeable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int AWAIT_PING = 3;
    static final int DEGRADED_PING = 2;
    static final long DEGRADED_PONG_TIMEOUT_NS = 1000000000;
    static final int INTERVAL_PING = 1;
    static final int OKHTTP_CLIENT_WINDOW_SIZE = 16777216;
    private static final ExecutorService listenerExecutor = new ThreadPoolExecutor(0, Api.BaseClientBuilder.API_PRIORITY_OTHER, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp Http2Connection", true));
    long bytesLeftInWriteWindow;
    final boolean client;
    final Set<Integer> currentPushRequests;
    final String hostname;
    int lastGoodStreamId;
    final Listener listener;
    int nextStreamId;
    final Settings peerSettings;
    private final ExecutorService pushExecutor;
    final PushObserver pushObserver;
    final ReaderRunnable readerRunnable;
    private boolean shutdown;
    final Socket socket;
    final Http2Writer writer;
    private final ScheduledExecutorService writerExecutor;
    final Map<Integer, Http2Stream> streams = new LinkedHashMap();
    private long intervalPingsSent = 0;
    private long intervalPongsReceived = 0;
    private long degradedPingsSent = 0;
    private long degradedPongsReceived = 0;
    private long awaitPingsSent = 0;
    private long awaitPongsReceived = 0;
    private long degradedPongDeadlineNs = 0;
    long unacknowledgedBytesRead = 0;
    Settings okHttpSettings = new Settings();

    /* JADX INFO: compiled from: source.java */
    public static class Builder {
        boolean client;
        String hostname;
        int pingIntervalMillis;
        BufferedSink sink;
        Socket socket;
        BufferedSource source;
        Listener listener = Listener.REFUSE_INCOMING_STREAMS;
        PushObserver pushObserver = PushObserver.CANCEL;

        public Builder(boolean z11) {
            this.client = z11;
        }

        public Http2Connection build() {
            return new Http2Connection(this);
        }

        public Builder listener(Listener listener) {
            this.listener = listener;
            return this;
        }

        public Builder pingIntervalMillis(int i11) {
            this.pingIntervalMillis = i11;
            return this;
        }

        public Builder pushObserver(PushObserver pushObserver) {
            this.pushObserver = pushObserver;
            return this;
        }

        public Builder socket(Socket socket) throws IOException {
            return socket(socket, ((InetSocketAddress) socket.getRemoteSocketAddress()).getHostName(), Okio.buffer(Okio.source(socket)), Okio.buffer(Okio.sink(socket)));
        }

        public Builder socket(Socket socket, String str, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            this.socket = socket;
            this.hostname = str;
            this.source = bufferedSource;
            this.sink = bufferedSink;
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class IntervalPingRunnable extends NamedRunnable {
        public IntervalPingRunnable() {
            super("OkHttp %s ping", Http2Connection.this.hostname);
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.NamedRunnable
        public void execute() {
            boolean z11;
            synchronized (Http2Connection.this) {
                if (Http2Connection.this.intervalPongsReceived < Http2Connection.this.intervalPingsSent) {
                    z11 = true;
                } else {
                    Http2Connection.access$208(Http2Connection.this);
                    z11 = false;
                }
            }
            if (z11) {
                Http2Connection.this.failConnection();
            } else {
                Http2Connection.this.writePing(false, 1, 0);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class Listener {
        public static final Listener REFUSE_INCOMING_STREAMS = new Listener() { // from class: com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection.Listener.1
            @Override // com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection.Listener
            public void onStream(Http2Stream http2Stream) throws IOException {
                http2Stream.close(ErrorCode.REFUSED_STREAM);
            }
        };

        public void onSettings(Http2Connection http2Connection) {
        }

        public abstract void onStream(Http2Stream http2Stream) throws IOException;
    }

    /* JADX INFO: compiled from: source.java */
    public final class PingRunnable extends NamedRunnable {
        final int payload1;
        final int payload2;
        final boolean reply;

        public PingRunnable(boolean z11, int i11, int i12) {
            super("OkHttp %s ping %08x%08x", Http2Connection.this.hostname, Integer.valueOf(i11), Integer.valueOf(i12));
            this.reply = z11;
            this.payload1 = i11;
            this.payload2 = i12;
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.NamedRunnable
        public void execute() {
            Http2Connection.this.writePing(this.reply, this.payload1, this.payload2);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class ReaderRunnable extends NamedRunnable implements Http2Reader.Handler {
        final Http2Reader reader;

        public ReaderRunnable(Http2Reader http2Reader) {
            super("OkHttp %s", Http2Connection.this.hostname);
            this.reader = http2Reader;
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Reader.Handler
        public void ackSettings() {
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Reader.Handler
        public void alternateService(int i11, String str, ByteString byteString, String str2, int i12, long j11) {
        }

        public void applyAndAckSettings(boolean z11, Settings settings) {
            Http2Stream[] http2StreamArr;
            long j11;
            synchronized (Http2Connection.this.writer) {
                synchronized (Http2Connection.this) {
                    try {
                        int initialWindowSize = Http2Connection.this.peerSettings.getInitialWindowSize();
                        if (z11) {
                            Http2Connection.this.peerSettings.clear();
                        }
                        Http2Connection.this.peerSettings.merge(settings);
                        int initialWindowSize2 = Http2Connection.this.peerSettings.getInitialWindowSize();
                        http2StreamArr = null;
                        if (initialWindowSize2 == -1 || initialWindowSize2 == initialWindowSize) {
                            j11 = 0;
                        } else {
                            j11 = initialWindowSize2 - initialWindowSize;
                            if (!Http2Connection.this.streams.isEmpty()) {
                                http2StreamArr = (Http2Stream[]) Http2Connection.this.streams.values().toArray(new Http2Stream[Http2Connection.this.streams.size()]);
                            }
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                try {
                    Http2Connection http2Connection = Http2Connection.this;
                    http2Connection.writer.applyAndAckSettings(http2Connection.peerSettings);
                } catch (IOException unused) {
                    Http2Connection.this.failConnection();
                }
            }
            if (http2StreamArr != null) {
                for (Http2Stream http2Stream : http2StreamArr) {
                    synchronized (http2Stream) {
                        http2Stream.addBytesToWriteWindow(j11);
                    }
                }
            }
            Http2Connection.listenerExecutor.execute(new NamedRunnable("OkHttp %s settings", Http2Connection.this.hostname) { // from class: com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection.ReaderRunnable.3
                @Override // com.mbridge.msdk.thrid.okhttp.internal.NamedRunnable
                public void execute() {
                    Http2Connection http2Connection2 = Http2Connection.this;
                    http2Connection2.listener.onSettings(http2Connection2);
                }
            });
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Reader.Handler
        public void data(boolean z11, int i11, BufferedSource bufferedSource, int i12) throws IOException {
            if (Http2Connection.this.pushedStream(i11)) {
                Http2Connection.this.pushDataLater(i11, bufferedSource, i12, z11);
                return;
            }
            Http2Stream stream = Http2Connection.this.getStream(i11);
            if (stream == null) {
                Http2Connection.this.writeSynResetLater(i11, ErrorCode.PROTOCOL_ERROR);
                long j11 = i12;
                Http2Connection.this.updateConnectionFlowControl(j11);
                bufferedSource.skip(j11);
                return;
            }
            stream.receiveData(bufferedSource, i12);
            if (z11) {
                stream.receiveFin();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
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
        @Override // com.mbridge.msdk.thrid.okhttp.internal.NamedRunnable
        public void execute() throws Throwable {
            ErrorCode errorCode;
            ErrorCode errorCode2 = ErrorCode.INTERNAL_ERROR;
            try {
                try {
                    try {
                        this.reader.readConnectionPreface(this);
                        while (this.reader.nextFrame(false, this)) {
                        }
                        ErrorCode errorCode3 = ErrorCode.NO_ERROR;
                        try {
                            errorCode2 = ErrorCode.CANCEL;
                            Http2Connection.this.close(errorCode3, errorCode2);
                            errorCode = errorCode3;
                        } catch (IOException unused) {
                            errorCode2 = ErrorCode.PROTOCOL_ERROR;
                            Http2Connection http2Connection = Http2Connection.this;
                            http2Connection.close(errorCode2, errorCode2);
                            errorCode = http2Connection;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            Http2Connection.this.close(errorCode, errorCode2);
                        } catch (IOException unused2) {
                        }
                        Util.closeQuietly(this.reader);
                        throw th;
                    }
                } catch (IOException unused3) {
                } catch (Throwable th3) {
                    th = th3;
                    errorCode = errorCode2;
                    Http2Connection.this.close(errorCode, errorCode2);
                    Util.closeQuietly(this.reader);
                    throw th;
                }
            } catch (IOException unused4) {
            }
            Util.closeQuietly(this.reader);
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Reader.Handler
        public void goAway(int i11, ErrorCode errorCode, ByteString byteString) {
            Http2Stream[] http2StreamArr;
            byteString.size();
            synchronized (Http2Connection.this) {
                http2StreamArr = (Http2Stream[]) Http2Connection.this.streams.values().toArray(new Http2Stream[Http2Connection.this.streams.size()]);
                Http2Connection.this.shutdown = true;
            }
            for (Http2Stream http2Stream : http2StreamArr) {
                if (http2Stream.getId() > i11 && http2Stream.isLocallyInitiated()) {
                    http2Stream.receiveRstStream(ErrorCode.REFUSED_STREAM);
                    Http2Connection.this.removeStream(http2Stream.getId());
                }
            }
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Reader.Handler
        public void headers(boolean z11, int i11, int i12, List<Header> list) {
            if (Http2Connection.this.pushedStream(i11)) {
                Http2Connection.this.pushHeadersLater(i11, list, z11);
                return;
            }
            synchronized (Http2Connection.this) {
                try {
                    Http2Stream stream = Http2Connection.this.getStream(i11);
                    if (stream != null) {
                        stream.receiveHeaders(list);
                        if (z11) {
                            stream.receiveFin();
                            return;
                        }
                        return;
                    }
                    if (Http2Connection.this.shutdown) {
                        return;
                    }
                    Http2Connection http2Connection = Http2Connection.this;
                    if (i11 <= http2Connection.lastGoodStreamId) {
                        return;
                    }
                    if (i11 % 2 == http2Connection.nextStreamId % 2) {
                        return;
                    }
                    final Http2Stream http2Stream = new Http2Stream(i11, Http2Connection.this, false, z11, Util.toHeaders(list));
                    Http2Connection http2Connection2 = Http2Connection.this;
                    http2Connection2.lastGoodStreamId = i11;
                    http2Connection2.streams.put(Integer.valueOf(i11), http2Stream);
                    Http2Connection.listenerExecutor.execute(new NamedRunnable("OkHttp %s stream %d", new Object[]{Http2Connection.this.hostname, Integer.valueOf(i11)}) { // from class: com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection.ReaderRunnable.1
                        @Override // com.mbridge.msdk.thrid.okhttp.internal.NamedRunnable
                        public void execute() {
                            try {
                                Http2Connection.this.listener.onStream(http2Stream);
                            } catch (IOException e11) {
                                Platform.get().log(4, "Http2Connection.Listener failure for " + Http2Connection.this.hostname, e11);
                                try {
                                    http2Stream.close(ErrorCode.PROTOCOL_ERROR);
                                } catch (IOException unused) {
                                }
                            }
                        }
                    });
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Reader.Handler
        public void ping(boolean z11, int i11, int i12) {
            if (!z11) {
                try {
                    Http2Connection.this.writerExecutor.execute(Http2Connection.this.new PingRunnable(true, i11, i12));
                    return;
                } catch (RejectedExecutionException unused) {
                    return;
                }
            }
            synchronized (Http2Connection.this) {
                try {
                    if (i11 == 1) {
                        Http2Connection.access$108(Http2Connection.this);
                    } else if (i11 == 2) {
                        Http2Connection.access$608(Http2Connection.this);
                    } else if (i11 == 3) {
                        Http2Connection.access$708(Http2Connection.this);
                        Http2Connection.this.notifyAll();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Reader.Handler
        public void priority(int i11, int i12, int i13, boolean z11) {
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Reader.Handler
        public void pushPromise(int i11, int i12, List<Header> list) {
            Http2Connection.this.pushRequestLater(i12, list);
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Reader.Handler
        public void rstStream(int i11, ErrorCode errorCode) {
            if (Http2Connection.this.pushedStream(i11)) {
                Http2Connection.this.pushResetLater(i11, errorCode);
                return;
            }
            Http2Stream http2StreamRemoveStream = Http2Connection.this.removeStream(i11);
            if (http2StreamRemoveStream != null) {
                http2StreamRemoveStream.receiveRstStream(errorCode);
            }
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Reader.Handler
        public void settings(final boolean z11, final Settings settings) {
            try {
                Http2Connection.this.writerExecutor.execute(new NamedRunnable("OkHttp %s ACK Settings", new Object[]{Http2Connection.this.hostname}) { // from class: com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection.ReaderRunnable.2
                    @Override // com.mbridge.msdk.thrid.okhttp.internal.NamedRunnable
                    public void execute() {
                        ReaderRunnable.this.applyAndAckSettings(z11, settings);
                    }
                });
            } catch (RejectedExecutionException unused) {
            }
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Reader.Handler
        public void windowUpdate(int i11, long j11) {
            if (i11 == 0) {
                synchronized (Http2Connection.this) {
                    Http2Connection http2Connection = Http2Connection.this;
                    http2Connection.bytesLeftInWriteWindow += j11;
                    http2Connection.notifyAll();
                }
                return;
            }
            Http2Stream stream = Http2Connection.this.getStream(i11);
            if (stream != null) {
                synchronized (stream) {
                    stream.addBytesToWriteWindow(j11);
                }
            }
        }
    }

    public Http2Connection(Builder builder) {
        Settings settings = new Settings();
        this.peerSettings = settings;
        this.currentPushRequests = new LinkedHashSet();
        this.pushObserver = builder.pushObserver;
        boolean z11 = builder.client;
        this.client = z11;
        this.listener = builder.listener;
        int i11 = z11 ? 1 : 2;
        this.nextStreamId = i11;
        if (z11) {
            this.nextStreamId = i11 + 2;
        }
        if (z11) {
            this.okHttpSettings.set(7, 16777216);
        }
        String str = builder.hostname;
        this.hostname = str;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, Util.threadFactory(Util.format("OkHttp %s Writer", str), false));
        this.writerExecutor = scheduledThreadPoolExecutor;
        if (builder.pingIntervalMillis != 0) {
            IntervalPingRunnable intervalPingRunnable = new IntervalPingRunnable();
            int i12 = builder.pingIntervalMillis;
            scheduledThreadPoolExecutor.scheduleAtFixedRate(intervalPingRunnable, i12, i12, TimeUnit.MILLISECONDS);
        }
        this.pushExecutor = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory(Util.format("OkHttp %s Push Observer", str), true));
        settings.set(7, okhttp3.internal.http2.Settings.DEFAULT_INITIAL_WINDOW_SIZE);
        settings.set(5, 16384);
        this.bytesLeftInWriteWindow = settings.getInitialWindowSize();
        this.socket = builder.socket;
        this.writer = new Http2Writer(builder.sink, z11);
        this.readerRunnable = new ReaderRunnable(new Http2Reader(builder.source, z11));
    }

    public static /* synthetic */ long access$108(Http2Connection http2Connection) {
        long j11 = http2Connection.intervalPongsReceived;
        http2Connection.intervalPongsReceived = 1 + j11;
        return j11;
    }

    public static /* synthetic */ long access$208(Http2Connection http2Connection) {
        long j11 = http2Connection.intervalPingsSent;
        http2Connection.intervalPingsSent = 1 + j11;
        return j11;
    }

    public static /* synthetic */ long access$608(Http2Connection http2Connection) {
        long j11 = http2Connection.degradedPongsReceived;
        http2Connection.degradedPongsReceived = 1 + j11;
        return j11;
    }

    public static /* synthetic */ long access$708(Http2Connection http2Connection) {
        long j11 = http2Connection.awaitPongsReceived;
        http2Connection.awaitPongsReceived = 1 + j11;
        return j11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void failConnection() {
        try {
            ErrorCode errorCode = ErrorCode.PROTOCOL_ERROR;
            close(errorCode, errorCode);
        } catch (IOException unused) {
        }
    }

    private Http2Stream newStream(int i11, List<Header> list, boolean z11) throws IOException {
        int i12;
        Http2Stream http2Stream;
        boolean z12;
        boolean z13 = !z11;
        synchronized (this.writer) {
            try {
                synchronized (this) {
                    try {
                        if (this.nextStreamId > 1073741823) {
                            shutdown(ErrorCode.REFUSED_STREAM);
                        }
                        if (this.shutdown) {
                            throw new ConnectionShutdownException();
                        }
                        i12 = this.nextStreamId;
                        this.nextStreamId = i12 + 2;
                        http2Stream = new Http2Stream(i12, this, z13, false, null);
                        z12 = !z11 || this.bytesLeftInWriteWindow == 0 || http2Stream.bytesLeftInWriteWindow == 0;
                        if (http2Stream.isOpen()) {
                            this.streams.put(Integer.valueOf(i12), http2Stream);
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                if (i11 == 0) {
                    this.writer.synStream(z13, i12, i11, list);
                } else {
                    if (this.client) {
                        throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
                    }
                    this.writer.pushPromise(i11, i12, list);
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
        if (z12) {
            this.writer.flush();
        }
        return http2Stream;
    }

    private synchronized void pushExecutorExecute(NamedRunnable namedRunnable) {
        if (!this.shutdown) {
            this.pushExecutor.execute(namedRunnable);
        }
    }

    public synchronized void awaitPong() throws InterruptedException {
        while (this.awaitPongsReceived < this.awaitPingsSent) {
            wait();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        close(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
    }

    public void close(ErrorCode errorCode, ErrorCode errorCode2) throws IOException {
        Http2Stream[] http2StreamArr = null;
        try {
            shutdown(errorCode);
            e = null;
        } catch (IOException e11) {
            e = e11;
        }
        synchronized (this) {
            try {
                if (!this.streams.isEmpty()) {
                    http2StreamArr = (Http2Stream[]) this.streams.values().toArray(new Http2Stream[this.streams.size()]);
                    this.streams.clear();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (http2StreamArr != null) {
            for (Http2Stream http2Stream : http2StreamArr) {
                try {
                    http2Stream.close(errorCode2);
                } catch (IOException e12) {
                    if (e != null) {
                        e = e12;
                    }
                }
            }
        }
        try {
            this.writer.close();
        } catch (IOException e13) {
            if (e == null) {
                e = e13;
            }
        }
        try {
            this.socket.close();
        } catch (IOException e14) {
            e = e14;
        }
        this.writerExecutor.shutdown();
        this.pushExecutor.shutdown();
        if (e != null) {
            throw e;
        }
    }

    public void flush() throws IOException {
        this.writer.flush();
    }

    public Protocol getProtocol() {
        return Protocol.HTTP_2;
    }

    public synchronized Http2Stream getStream(int i11) {
        return this.streams.get(Integer.valueOf(i11));
    }

    public synchronized boolean isHealthy(long j11) {
        if (this.shutdown) {
            return false;
        }
        return this.degradedPongsReceived >= this.degradedPingsSent || j11 < this.degradedPongDeadlineNs;
    }

    public synchronized int maxConcurrentStreams() {
        return this.peerSettings.getMaxConcurrentStreams(Api.BaseClientBuilder.API_PRIORITY_OTHER);
    }

    public Http2Stream newStream(List<Header> list, boolean z11) throws IOException {
        return newStream(0, list, z11);
    }

    public synchronized int openStreamCount() {
        return this.streams.size();
    }

    public void pushDataLater(final int i11, BufferedSource bufferedSource, final int i12, final boolean z11) throws IOException {
        final Buffer buffer = new Buffer();
        long j11 = i12;
        bufferedSource.require(j11);
        bufferedSource.read(buffer, j11);
        if (buffer.size() == j11) {
            pushExecutorExecute(new NamedRunnable("OkHttp %s Push Data[%s]", new Object[]{this.hostname, Integer.valueOf(i11)}) { // from class: com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection.6
                @Override // com.mbridge.msdk.thrid.okhttp.internal.NamedRunnable
                public void execute() {
                    try {
                        boolean zOnData = Http2Connection.this.pushObserver.onData(i11, buffer, i12, z11);
                        if (zOnData) {
                            Http2Connection.this.writer.rstStream(i11, ErrorCode.CANCEL);
                        }
                        if (zOnData || z11) {
                            synchronized (Http2Connection.this) {
                                Http2Connection.this.currentPushRequests.remove(Integer.valueOf(i11));
                            }
                        }
                    } catch (IOException unused) {
                    }
                }
            });
            return;
        }
        throw new IOException(buffer.size() + " != " + i12);
    }

    public void pushHeadersLater(final int i11, final List<Header> list, final boolean z11) {
        try {
            pushExecutorExecute(new NamedRunnable("OkHttp %s Push Headers[%s]", new Object[]{this.hostname, Integer.valueOf(i11)}) { // from class: com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection.5
                @Override // com.mbridge.msdk.thrid.okhttp.internal.NamedRunnable
                public void execute() {
                    boolean zOnHeaders = Http2Connection.this.pushObserver.onHeaders(i11, list, z11);
                    if (zOnHeaders) {
                        try {
                            Http2Connection.this.writer.rstStream(i11, ErrorCode.CANCEL);
                        } catch (IOException unused) {
                            return;
                        }
                    }
                    if (zOnHeaders || z11) {
                        synchronized (Http2Connection.this) {
                            try {
                                Http2Connection.this.currentPushRequests.remove(Integer.valueOf(i11));
                            } catch (Throwable th2) {
                                throw th2;
                            }
                        }
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        }
    }

    public void pushRequestLater(final int i11, final List<Header> list) {
        synchronized (this) {
            try {
                if (this.currentPushRequests.contains(Integer.valueOf(i11))) {
                    writeSynResetLater(i11, ErrorCode.PROTOCOL_ERROR);
                    return;
                }
                this.currentPushRequests.add(Integer.valueOf(i11));
                try {
                    pushExecutorExecute(new NamedRunnable("OkHttp %s Push Request[%s]", new Object[]{this.hostname, Integer.valueOf(i11)}) { // from class: com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection.4
                        @Override // com.mbridge.msdk.thrid.okhttp.internal.NamedRunnable
                        public void execute() {
                            if (Http2Connection.this.pushObserver.onRequest(i11, list)) {
                                try {
                                    Http2Connection.this.writer.rstStream(i11, ErrorCode.CANCEL);
                                    synchronized (Http2Connection.this) {
                                        try {
                                            Http2Connection.this.currentPushRequests.remove(Integer.valueOf(i11));
                                        } catch (Throwable th2) {
                                            throw th2;
                                        }
                                    }
                                } catch (IOException unused) {
                                }
                            }
                        }
                    });
                } catch (RejectedExecutionException unused) {
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void pushResetLater(final int i11, final ErrorCode errorCode) {
        pushExecutorExecute(new NamedRunnable("OkHttp %s Push Reset[%s]", new Object[]{this.hostname, Integer.valueOf(i11)}) { // from class: com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection.7
            @Override // com.mbridge.msdk.thrid.okhttp.internal.NamedRunnable
            public void execute() {
                Http2Connection.this.pushObserver.onReset(i11, errorCode);
                synchronized (Http2Connection.this) {
                    Http2Connection.this.currentPushRequests.remove(Integer.valueOf(i11));
                }
            }
        });
    }

    public Http2Stream pushStream(int i11, List<Header> list, boolean z11) throws IOException {
        if (this.client) {
            throw new IllegalStateException("Client cannot push requests.");
        }
        return newStream(i11, list, z11);
    }

    public boolean pushedStream(int i11) {
        return i11 != 0 && (i11 & 1) == 0;
    }

    public synchronized Http2Stream removeStream(int i11) {
        Http2Stream http2StreamRemove;
        http2StreamRemove = this.streams.remove(Integer.valueOf(i11));
        notifyAll();
        return http2StreamRemove;
    }

    public void sendDegradedPingLater() {
        synchronized (this) {
            try {
                long j11 = this.degradedPongsReceived;
                long j12 = this.degradedPingsSent;
                if (j11 < j12) {
                    return;
                }
                this.degradedPingsSent = j12 + 1;
                this.degradedPongDeadlineNs = System.nanoTime() + 1000000000;
                try {
                    this.writerExecutor.execute(new NamedRunnable("OkHttp %s ping", this.hostname) { // from class: com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection.3
                        @Override // com.mbridge.msdk.thrid.okhttp.internal.NamedRunnable
                        public void execute() {
                            Http2Connection.this.writePing(false, 2, 0);
                        }
                    });
                } catch (RejectedExecutionException unused) {
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void setSettings(Settings settings) throws IOException {
        synchronized (this.writer) {
            synchronized (this) {
                if (this.shutdown) {
                    throw new ConnectionShutdownException();
                }
                this.okHttpSettings.merge(settings);
            }
            this.writer.settings(settings);
        }
    }

    public void shutdown(ErrorCode errorCode) throws IOException {
        synchronized (this.writer) {
            synchronized (this) {
                if (this.shutdown) {
                    return;
                }
                this.shutdown = true;
                this.writer.goAway(this.lastGoodStreamId, errorCode, Util.EMPTY_BYTE_ARRAY);
            }
        }
    }

    public void start() throws IOException {
        start(true);
    }

    public void start(boolean z11) throws IOException {
        if (z11) {
            this.writer.connectionPreface();
            this.writer.settings(this.okHttpSettings);
            int initialWindowSize = this.okHttpSettings.getInitialWindowSize();
            if (initialWindowSize != 65535) {
                this.writer.windowUpdate(0, initialWindowSize - okhttp3.internal.http2.Settings.DEFAULT_INITIAL_WINDOW_SIZE);
            }
        }
        new Thread(this.readerRunnable).start();
    }

    public synchronized void updateConnectionFlowControl(long j11) {
        long j12 = this.unacknowledgedBytesRead + j11;
        this.unacknowledgedBytesRead = j12;
        if (j12 >= this.okHttpSettings.getInitialWindowSize() / 2) {
            writeWindowUpdateLater(0, this.unacknowledgedBytesRead);
            this.unacknowledgedBytesRead = 0L;
        }
    }

    public void writeData(int i11, boolean z11, Buffer buffer, long j11) throws IOException {
        long j12;
        int iMin;
        long j13;
        if (j11 == 0) {
            this.writer.data(z11, i11, buffer, 0);
            return;
        }
        while (j11 > 0) {
            synchronized (this) {
                while (true) {
                    try {
                        try {
                            j12 = this.bytesLeftInWriteWindow;
                            if (j12 <= 0) {
                                if (!this.streams.containsKey(Integer.valueOf(i11))) {
                                    throw new IOException("stream closed");
                                }
                                wait();
                            }
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                            throw new InterruptedIOException();
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                iMin = Math.min((int) Math.min(j11, j12), this.writer.maxDataLength());
                j13 = iMin;
                this.bytesLeftInWriteWindow -= j13;
            }
            j11 -= j13;
            this.writer.data(z11 && j11 == 0, i11, buffer, iMin);
        }
    }

    public void writePing() {
        synchronized (this) {
            this.awaitPingsSent++;
        }
        writePing(false, 3, 1330343787);
    }

    public void writePing(boolean z11, int i11, int i12) {
        try {
            this.writer.ping(z11, i11, i12);
        } catch (IOException unused) {
            failConnection();
        }
    }

    public void writePingAndAwaitPong() throws InterruptedException {
        writePing();
        awaitPong();
    }

    public void writeSynReply(int i11, boolean z11, List<Header> list) throws IOException {
        this.writer.synReply(z11, i11, list);
    }

    public void writeSynReset(int i11, ErrorCode errorCode) throws IOException {
        this.writer.rstStream(i11, errorCode);
    }

    public void writeSynResetLater(final int i11, final ErrorCode errorCode) {
        try {
            this.writerExecutor.execute(new NamedRunnable("OkHttp %s stream %d", new Object[]{this.hostname, Integer.valueOf(i11)}) { // from class: com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection.1
                @Override // com.mbridge.msdk.thrid.okhttp.internal.NamedRunnable
                public void execute() {
                    try {
                        Http2Connection.this.writeSynReset(i11, errorCode);
                    } catch (IOException unused) {
                        Http2Connection.this.failConnection();
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        }
    }

    public void writeWindowUpdateLater(final int i11, final long j11) {
        try {
            this.writerExecutor.execute(new NamedRunnable("OkHttp Window Update %s stream %d", new Object[]{this.hostname, Integer.valueOf(i11)}) { // from class: com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection.2
                @Override // com.mbridge.msdk.thrid.okhttp.internal.NamedRunnable
                public void execute() {
                    try {
                        Http2Connection.this.writer.windowUpdate(i11, j11);
                    } catch (IOException unused) {
                        Http2Connection.this.failConnection();
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        }
    }
}
