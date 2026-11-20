package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;

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
public final class Http2Connection implements Closeable {
    public static final int AWAIT_PING = 3;
    public static final Companion Companion = new Companion(null);
    private static final Settings DEFAULT_SETTINGS;
    public static final int DEGRADED_PING = 2;
    public static final int DEGRADED_PONG_TIMEOUT_NS = 1000000000;
    public static final int INTERVAL_PING = 1;
    public static final int OKHTTP_CLIENT_WINDOW_SIZE = 16777216;
    private long awaitPingsSent;
    private long awaitPongsReceived;
    private final boolean client;
    private final String connectionName;
    private final Set<Integer> currentPushRequests;
    private long degradedPingsSent;
    private long degradedPongDeadlineNs;
    private long degradedPongsReceived;
    private long intervalPingsSent;
    private long intervalPongsReceived;
    private boolean isShutdown;
    private int lastGoodStreamId;
    private final Listener listener;
    private int nextStreamId;
    private final Settings okHttpSettings;
    private Settings peerSettings;
    private final PushObserver pushObserver;
    private final TaskQueue pushQueue;
    private long readBytesAcknowledged;
    private long readBytesTotal;
    private final ReaderRunnable readerRunnable;
    private final TaskQueue settingsListenerQueue;
    private final Socket socket;
    private final Map<Integer, Http2Stream> streams;
    private final TaskRunner taskRunner;
    private long writeBytesMaximum;
    private long writeBytesTotal;
    private final Http2Writer writer;
    private final TaskQueue writerQueue;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Builder {
        private boolean client;
        public String connectionName;
        private Listener listener;
        private int pingIntervalMillis;
        private PushObserver pushObserver;
        public BufferedSink sink;
        public Socket socket;
        public BufferedSource source;
        private final TaskRunner taskRunner;

        public Builder(boolean z11, TaskRunner taskRunner) {
            Intrinsics.g(taskRunner, "taskRunner");
            this.client = z11;
            this.taskRunner = taskRunner;
            this.listener = Listener.REFUSE_INCOMING_STREAMS;
            this.pushObserver = PushObserver.CANCEL;
        }

        public static /* synthetic */ Builder socket$default(Builder builder, Socket socket, String str, BufferedSource bufferedSource, BufferedSink bufferedSink, int i11, Object obj) throws IOException {
            if ((i11 & 2) != 0) {
                str = Util.peerName(socket);
            }
            if ((i11 & 4) != 0) {
                bufferedSource = Okio.buffer(Okio.source(socket));
            }
            if ((i11 & 8) != 0) {
                bufferedSink = Okio.buffer(Okio.sink(socket));
            }
            return builder.socket(socket, str, bufferedSource, bufferedSink);
        }

        public final Http2Connection build() {
            return new Http2Connection(this);
        }

        public final boolean getClient$okhttp() {
            return this.client;
        }

        public final String getConnectionName$okhttp() {
            String str = this.connectionName;
            if (str == null) {
                Intrinsics.y("connectionName");
            }
            return str;
        }

        public final Listener getListener$okhttp() {
            return this.listener;
        }

        public final int getPingIntervalMillis$okhttp() {
            return this.pingIntervalMillis;
        }

        public final PushObserver getPushObserver$okhttp() {
            return this.pushObserver;
        }

        public final BufferedSink getSink$okhttp() {
            BufferedSink bufferedSink = this.sink;
            if (bufferedSink == null) {
                Intrinsics.y("sink");
            }
            return bufferedSink;
        }

        public final Socket getSocket$okhttp() {
            Socket socket = this.socket;
            if (socket == null) {
                Intrinsics.y("socket");
            }
            return socket;
        }

        public final BufferedSource getSource$okhttp() {
            BufferedSource bufferedSource = this.source;
            if (bufferedSource == null) {
                Intrinsics.y("source");
            }
            return bufferedSource;
        }

        public final TaskRunner getTaskRunner$okhttp() {
            return this.taskRunner;
        }

        public final Builder listener(Listener listener) {
            Intrinsics.g(listener, "listener");
            this.listener = listener;
            return this;
        }

        public final Builder pingIntervalMillis(int i11) {
            this.pingIntervalMillis = i11;
            return this;
        }

        public final Builder pushObserver(PushObserver pushObserver) {
            Intrinsics.g(pushObserver, "pushObserver");
            this.pushObserver = pushObserver;
            return this;
        }

        public final void setClient$okhttp(boolean z11) {
            this.client = z11;
        }

        public final void setConnectionName$okhttp(String str) {
            Intrinsics.g(str, "<set-?>");
            this.connectionName = str;
        }

        public final void setListener$okhttp(Listener listener) {
            Intrinsics.g(listener, "<set-?>");
            this.listener = listener;
        }

        public final void setPingIntervalMillis$okhttp(int i11) {
            this.pingIntervalMillis = i11;
        }

        public final void setPushObserver$okhttp(PushObserver pushObserver) {
            Intrinsics.g(pushObserver, "<set-?>");
            this.pushObserver = pushObserver;
        }

        public final void setSink$okhttp(BufferedSink bufferedSink) {
            Intrinsics.g(bufferedSink, "<set-?>");
            this.sink = bufferedSink;
        }

        public final void setSocket$okhttp(Socket socket) {
            Intrinsics.g(socket, "<set-?>");
            this.socket = socket;
        }

        public final void setSource$okhttp(BufferedSource bufferedSource) {
            Intrinsics.g(bufferedSource, "<set-?>");
            this.source = bufferedSource;
        }

        @JvmOverloads
        public final Builder socket(Socket socket) throws IOException {
            return socket$default(this, socket, null, null, null, 14, null);
        }

        @JvmOverloads
        public final Builder socket(Socket socket, String str) throws IOException {
            return socket$default(this, socket, str, null, null, 12, null);
        }

        @JvmOverloads
        public final Builder socket(Socket socket, String str, BufferedSource bufferedSource) throws IOException {
            return socket$default(this, socket, str, bufferedSource, null, 8, null);
        }

        @JvmOverloads
        public final Builder socket(Socket socket, String peerName, BufferedSource source, BufferedSink sink) throws IOException {
            String str;
            Intrinsics.g(socket, "socket");
            Intrinsics.g(peerName, "peerName");
            Intrinsics.g(source, "source");
            Intrinsics.g(sink, "sink");
            this.socket = socket;
            if (this.client) {
                str = Util.okHttpName + ' ' + peerName;
            } else {
                str = "MockWebServer " + peerName;
            }
            this.connectionName = str;
            this.source = source;
            this.sink = sink;
            return this;
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

        public final Settings getDEFAULT_SETTINGS() {
            return Http2Connection.DEFAULT_SETTINGS;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static abstract class Listener {
        public static final Companion Companion = new Companion(null);

        @JvmField
        public static final Listener REFUSE_INCOMING_STREAMS = new Listener() { // from class: okhttp3.internal.http2.Http2Connection$Listener$Companion$REFUSE_INCOMING_STREAMS$1
            @Override // okhttp3.internal.http2.Http2Connection.Listener
            public void onStream(Http2Stream stream) throws IOException {
                Intrinsics.g(stream, "stream");
                stream.close(ErrorCode.REFUSED_STREAM, null);
            }
        };

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public void onSettings(Http2Connection connection, Settings settings) {
            Intrinsics.g(connection, "connection");
            Intrinsics.g(settings, "settings");
        }

        public abstract void onStream(Http2Stream http2Stream) throws IOException;
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public final class ReaderRunnable implements Http2Reader.Handler, Function0<Unit> {
        private final Http2Reader reader;
        final /* synthetic */ Http2Connection this$0;

        public ReaderRunnable(Http2Connection http2Connection, Http2Reader reader) {
            Intrinsics.g(reader, "reader");
            this.this$0 = http2Connection;
            this.reader = reader;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void ackSettings() {
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void alternateService(int i11, String origin, ByteString protocol, String host, int i12, long j11) {
            Intrinsics.g(origin, "origin");
            Intrinsics.g(protocol, "protocol");
            Intrinsics.g(host, "host");
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1, types: [T, okhttp3.internal.http2.Settings] */
        /* JADX WARN: Type inference failed for: r2v14 */
        /* JADX WARN: Type inference failed for: r2v15 */
        public final void applyAndAckSettings(final boolean z11, final Settings settings) {
            Http2Connection http2Connection;
            ?? r11;
            T t11;
            Intrinsics.g(settings, "settings");
            final Ref.LongRef longRef = new Ref.LongRef();
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            synchronized (this.this$0.getWriter()) {
                Http2Connection http2Connection2 = this.this$0;
                synchronized (http2Connection2) {
                    try {
                        Settings peerSettings = this.this$0.getPeerSettings();
                        if (z11) {
                            r11 = settings;
                        } else {
                            Settings settings2 = new Settings();
                            settings2.merge(peerSettings);
                            settings2.merge(settings);
                            Unit unit = Unit.f68710a;
                            r11 = settings2;
                        }
                        objectRef2.element = r11;
                        long initialWindowSize = ((long) r11.getInitialWindowSize()) - ((long) peerSettings.getInitialWindowSize());
                        longRef.element = initialWindowSize;
                        if (initialWindowSize == 0 || this.this$0.getStreams$okhttp().isEmpty()) {
                            t11 = 0;
                        } else {
                            Object[] array = this.this$0.getStreams$okhttp().values().toArray(new Http2Stream[0]);
                            if (array == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                            }
                            t11 = (Http2Stream[]) array;
                        }
                        objectRef.element = t11;
                        this.this$0.setPeerSettings((Settings) objectRef2.element);
                        TaskQueue taskQueue = this.this$0.settingsListenerQueue;
                        final String str = this.this$0.getConnectionName$okhttp() + " onSettings";
                        final boolean z12 = true;
                        http2Connection = http2Connection2;
                        try {
                            taskQueue.schedule(new Task(str, z12) { // from class: okhttp3.internal.http2.Http2Connection$ReaderRunnable$applyAndAckSettings$$inlined$synchronized$lambda$1
                                /* JADX WARN: Multi-variable type inference failed */
                                @Override // okhttp3.internal.concurrent.Task
                                public long runOnce() {
                                    this.this$0.getListener$okhttp().onSettings(this.this$0, (Settings) objectRef2.element);
                                    return -1L;
                                }
                            }, 0L);
                            Unit unit2 = Unit.f68710a;
                            try {
                                this.this$0.getWriter().applyAndAckSettings((Settings) objectRef2.element);
                            } catch (IOException e11) {
                                this.this$0.failConnection(e11);
                            }
                            Unit unit3 = Unit.f68710a;
                        } catch (Throwable th2) {
                            th = th2;
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        http2Connection = http2Connection2;
                    }
                }
            }
            T t12 = objectRef.element;
            if (((Http2Stream[]) t12) != null) {
                Http2Stream[] http2StreamArr = (Http2Stream[]) t12;
                Intrinsics.d(http2StreamArr);
                for (Http2Stream http2Stream : http2StreamArr) {
                    synchronized (http2Stream) {
                        http2Stream.addBytesToWriteWindow(longRef.element);
                        Unit unit4 = Unit.f68710a;
                    }
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void data(boolean z11, int i11, BufferedSource source, int i12) throws IOException {
            Intrinsics.g(source, "source");
            if (this.this$0.pushedStream$okhttp(i11)) {
                this.this$0.pushDataLater$okhttp(i11, source, i12, z11);
                return;
            }
            Http2Stream stream = this.this$0.getStream(i11);
            if (stream == null) {
                this.this$0.writeSynResetLater$okhttp(i11, ErrorCode.PROTOCOL_ERROR);
                long j11 = i12;
                this.this$0.updateConnectionFlowControl$okhttp(j11);
                source.skip(j11);
                return;
            }
            stream.receiveData(source, i12);
            if (z11) {
                stream.receiveHeaders(Util.EMPTY_HEADERS, true);
            }
        }

        public final Http2Reader getReader$okhttp() {
            return this.reader;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void goAway(int i11, ErrorCode errorCode, ByteString debugData) {
            int i12;
            Http2Stream[] http2StreamArr;
            Intrinsics.g(errorCode, "errorCode");
            Intrinsics.g(debugData, "debugData");
            debugData.size();
            synchronized (this.this$0) {
                Object[] array = this.this$0.getStreams$okhttp().values().toArray(new Http2Stream[0]);
                if (array == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
                http2StreamArr = (Http2Stream[]) array;
                this.this$0.isShutdown = true;
                Unit unit = Unit.f68710a;
            }
            for (Http2Stream http2Stream : http2StreamArr) {
                if (http2Stream.getId() > i11 && http2Stream.isLocallyInitiated()) {
                    http2Stream.receiveRstStream(ErrorCode.REFUSED_STREAM);
                    this.this$0.removeStream$okhttp(http2Stream.getId());
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void headers(final boolean z11, final int i11, int i12, final List<Header> headerBlock) {
            Intrinsics.g(headerBlock, "headerBlock");
            if (this.this$0.pushedStream$okhttp(i11)) {
                this.this$0.pushHeadersLater$okhttp(i11, headerBlock, z11);
                return;
            }
            synchronized (this.this$0) {
                final Http2Stream stream = this.this$0.getStream(i11);
                if (stream != null) {
                    Unit unit = Unit.f68710a;
                    stream.receiveHeaders(Util.toHeaders(headerBlock), z11);
                    return;
                }
                if (this.this$0.isShutdown) {
                    return;
                }
                if (i11 <= this.this$0.getLastGoodStreamId$okhttp()) {
                    return;
                }
                if (i11 % 2 == this.this$0.getNextStreamId$okhttp() % 2) {
                    return;
                }
                final Http2Stream http2Stream = new Http2Stream(i11, this.this$0, false, z11, Util.toHeaders(headerBlock));
                this.this$0.setLastGoodStreamId$okhttp(i11);
                this.this$0.getStreams$okhttp().put(Integer.valueOf(i11), http2Stream);
                TaskQueue taskQueueNewQueue = this.this$0.taskRunner.newQueue();
                final String str = this.this$0.getConnectionName$okhttp() + '[' + i11 + "] onStream";
                final boolean z12 = true;
                taskQueueNewQueue.schedule(new Task(str, z12) { // from class: okhttp3.internal.http2.Http2Connection$ReaderRunnable$headers$$inlined$synchronized$lambda$1
                    @Override // okhttp3.internal.concurrent.Task
                    public long runOnce() {
                        try {
                            this.this$0.getListener$okhttp().onStream(http2Stream);
                            return -1L;
                        } catch (IOException e11) {
                            Platform.Companion.get().log("Http2Connection.Listener failure for " + this.this$0.getConnectionName$okhttp(), 4, e11);
                            try {
                                http2Stream.close(ErrorCode.PROTOCOL_ERROR, e11);
                                return -1L;
                            } catch (IOException unused) {
                                return -1L;
                            }
                        }
                    }
                }, 0L);
            }
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() throws Throwable {
            invoke2();
            return Unit.f68710a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [okhttp3.internal.http2.ErrorCode] */
        /* JADX WARN: Type inference failed for: r0v3 */
        /* JADX WARN: Type inference failed for: r0v5, types: [java.io.Closeable, okhttp3.internal.http2.Http2Reader] */
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
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public void invoke2() throws Throwable {
            ErrorCode errorCode;
            ErrorCode errorCode2 = ErrorCode.INTERNAL_ERROR;
            IOException e11 = null;
            try {
                try {
                    this.reader.readConnectionPreface(this);
                    while (this.reader.nextFrame(false, this)) {
                    }
                    ErrorCode errorCode3 = ErrorCode.NO_ERROR;
                    try {
                        this.this$0.close$okhttp(errorCode3, ErrorCode.CANCEL, null);
                        errorCode = errorCode3;
                    } catch (IOException e12) {
                        e11 = e12;
                        ErrorCode errorCode4 = ErrorCode.PROTOCOL_ERROR;
                        Http2Connection http2Connection = this.this$0;
                        http2Connection.close$okhttp(errorCode4, errorCode4, e11);
                        errorCode = http2Connection;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    this.this$0.close$okhttp(errorCode, errorCode2, e11);
                    Util.closeQuietly(this.reader);
                    throw th;
                }
            } catch (IOException e13) {
                e11 = e13;
            } catch (Throwable th3) {
                th = th3;
                errorCode = errorCode2;
                this.this$0.close$okhttp(errorCode, errorCode2, e11);
                Util.closeQuietly(this.reader);
                throw th;
            }
            errorCode2 = this.reader;
            Util.closeQuietly((Closeable) errorCode2);
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void ping(boolean z11, final int i11, final int i12) {
            if (!z11) {
                TaskQueue taskQueue = this.this$0.writerQueue;
                final String str = this.this$0.getConnectionName$okhttp() + " ping";
                final boolean z12 = true;
                taskQueue.schedule(new Task(str, z12) { // from class: okhttp3.internal.http2.Http2Connection$ReaderRunnable$ping$$inlined$execute$1
                    @Override // okhttp3.internal.concurrent.Task
                    public long runOnce() {
                        this.this$0.writePing(true, i11, i12);
                        return -1L;
                    }
                }, 0L);
                return;
            }
            synchronized (this.this$0) {
                try {
                    if (i11 == 1) {
                        this.this$0.intervalPongsReceived++;
                    } else if (i11 != 2) {
                        if (i11 == 3) {
                            this.this$0.awaitPongsReceived++;
                            Http2Connection http2Connection = this.this$0;
                            if (http2Connection == null) {
                                throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                            }
                            http2Connection.notifyAll();
                        }
                        Unit unit = Unit.f68710a;
                    } else {
                        this.this$0.degradedPongsReceived++;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void priority(int i11, int i12, int i13, boolean z11) {
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void pushPromise(int i11, int i12, List<Header> requestHeaders) {
            Intrinsics.g(requestHeaders, "requestHeaders");
            this.this$0.pushRequestLater$okhttp(i12, requestHeaders);
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void rstStream(int i11, ErrorCode errorCode) {
            Intrinsics.g(errorCode, "errorCode");
            if (this.this$0.pushedStream$okhttp(i11)) {
                this.this$0.pushResetLater$okhttp(i11, errorCode);
                return;
            }
            Http2Stream http2StreamRemoveStream$okhttp = this.this$0.removeStream$okhttp(i11);
            if (http2StreamRemoveStream$okhttp != null) {
                http2StreamRemoveStream$okhttp.receiveRstStream(errorCode);
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void settings(final boolean z11, final Settings settings) {
            Intrinsics.g(settings, "settings");
            TaskQueue taskQueue = this.this$0.writerQueue;
            final String str = this.this$0.getConnectionName$okhttp() + " applyAndAckSettings";
            final boolean z12 = true;
            taskQueue.schedule(new Task(str, z12) { // from class: okhttp3.internal.http2.Http2Connection$ReaderRunnable$settings$$inlined$execute$1
                @Override // okhttp3.internal.concurrent.Task
                public long runOnce() {
                    this.applyAndAckSettings(z11, settings);
                    return -1L;
                }
            }, 0L);
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void windowUpdate(int i11, long j11) {
            if (i11 != 0) {
                Http2Stream stream = this.this$0.getStream(i11);
                if (stream != null) {
                    synchronized (stream) {
                        stream.addBytesToWriteWindow(j11);
                        Unit unit = Unit.f68710a;
                    }
                    return;
                }
                return;
            }
            synchronized (this.this$0) {
                Http2Connection http2Connection = this.this$0;
                http2Connection.writeBytesMaximum = http2Connection.getWriteBytesMaximum() + j11;
                Http2Connection http2Connection2 = this.this$0;
                if (http2Connection2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                }
                http2Connection2.notifyAll();
                Unit unit2 = Unit.f68710a;
            }
        }
    }

    static {
        Settings settings = new Settings();
        settings.set(7, Settings.DEFAULT_INITIAL_WINDOW_SIZE);
        settings.set(5, 16384);
        DEFAULT_SETTINGS = settings;
    }

    public Http2Connection(Builder builder) {
        Intrinsics.g(builder, "builder");
        boolean client$okhttp = builder.getClient$okhttp();
        this.client = client$okhttp;
        this.listener = builder.getListener$okhttp();
        this.streams = new LinkedHashMap();
        String connectionName$okhttp = builder.getConnectionName$okhttp();
        this.connectionName = connectionName$okhttp;
        this.nextStreamId = builder.getClient$okhttp() ? 3 : 2;
        TaskRunner taskRunner$okhttp = builder.getTaskRunner$okhttp();
        this.taskRunner = taskRunner$okhttp;
        TaskQueue taskQueueNewQueue = taskRunner$okhttp.newQueue();
        this.writerQueue = taskQueueNewQueue;
        this.pushQueue = taskRunner$okhttp.newQueue();
        this.settingsListenerQueue = taskRunner$okhttp.newQueue();
        this.pushObserver = builder.getPushObserver$okhttp();
        Settings settings = new Settings();
        if (builder.getClient$okhttp()) {
            settings.set(7, 16777216);
        }
        Unit unit = Unit.f68710a;
        this.okHttpSettings = settings;
        Settings settings2 = DEFAULT_SETTINGS;
        this.peerSettings = settings2;
        this.writeBytesMaximum = settings2.getInitialWindowSize();
        this.socket = builder.getSocket$okhttp();
        this.writer = new Http2Writer(builder.getSink$okhttp(), client$okhttp);
        this.readerRunnable = new ReaderRunnable(this, new Http2Reader(builder.getSource$okhttp(), client$okhttp));
        this.currentPushRequests = new LinkedHashSet();
        if (builder.getPingIntervalMillis$okhttp() != 0) {
            final long nanos = TimeUnit.MILLISECONDS.toNanos(builder.getPingIntervalMillis$okhttp());
            final String str = connectionName$okhttp + " ping";
            taskQueueNewQueue.schedule(new Task(str) { // from class: okhttp3.internal.http2.Http2Connection$$special$$inlined$schedule$1
                @Override // okhttp3.internal.concurrent.Task
                public long runOnce() {
                    boolean z11;
                    synchronized (this) {
                        if (this.intervalPongsReceived < this.intervalPingsSent) {
                            z11 = true;
                        } else {
                            this.intervalPingsSent++;
                            z11 = false;
                        }
                    }
                    if (z11) {
                        this.failConnection(null);
                        return -1L;
                    }
                    this.writePing(false, 1, 0);
                    return nanos;
                }
            }, nanos);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void failConnection(IOException iOException) {
        ErrorCode errorCode = ErrorCode.PROTOCOL_ERROR;
        close$okhttp(errorCode, errorCode, iOException);
    }

    private final Http2Stream newStream(int i11, List<Header> list, boolean z11) throws IOException {
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
                        if (this.isShutdown) {
                            throw new ConnectionShutdownException();
                        }
                        i12 = this.nextStreamId;
                        this.nextStreamId = i12 + 2;
                        http2Stream = new Http2Stream(i12, this, z13, false, null);
                        z12 = !z11 || this.writeBytesTotal >= this.writeBytesMaximum || http2Stream.getWriteBytesTotal() >= http2Stream.getWriteBytesMaximum();
                        if (http2Stream.isOpen()) {
                            this.streams.put(Integer.valueOf(i12), http2Stream);
                        }
                        Unit unit = Unit.f68710a;
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                if (i11 == 0) {
                    this.writer.headers(z13, i12, list);
                } else {
                    if (!(true ^ this.client)) {
                        throw new IllegalArgumentException("client streams shouldn't have associated stream IDs".toString());
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

    public static /* synthetic */ void start$default(Http2Connection http2Connection, boolean z11, TaskRunner taskRunner, int i11, Object obj) throws IOException {
        if ((i11 & 1) != 0) {
            z11 = true;
        }
        if ((i11 & 2) != 0) {
            taskRunner = TaskRunner.INSTANCE;
        }
        http2Connection.start(z11, taskRunner);
    }

    public final synchronized void awaitPong() throws InterruptedException {
        while (this.awaitPongsReceived < this.awaitPingsSent) {
            wait();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        close$okhttp(ErrorCode.NO_ERROR, ErrorCode.CANCEL, null);
    }

    public final void close$okhttp(ErrorCode connectionCode, ErrorCode streamCode, IOException iOException) {
        int i11;
        Http2Stream[] http2StreamArr;
        Intrinsics.g(connectionCode, "connectionCode");
        Intrinsics.g(streamCode, "streamCode");
        if (Util.assertionsEnabled && Thread.holdsLock(this)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Thread ");
            Thread threadCurrentThread = Thread.currentThread();
            Intrinsics.f(threadCurrentThread, "Thread.currentThread()");
            sb2.append(threadCurrentThread.getName());
            sb2.append(" MUST NOT hold lock on ");
            sb2.append(this);
            throw new AssertionError(sb2.toString());
        }
        try {
            shutdown(connectionCode);
        } catch (IOException unused) {
        }
        synchronized (this) {
            try {
                if (!this.streams.isEmpty()) {
                    Object[] array = this.streams.values().toArray(new Http2Stream[0]);
                    if (array == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                    http2StreamArr = (Http2Stream[]) array;
                    this.streams.clear();
                } else {
                    http2StreamArr = null;
                }
                Unit unit = Unit.f68710a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (http2StreamArr != null) {
            for (Http2Stream http2Stream : http2StreamArr) {
                try {
                    http2Stream.close(streamCode, iOException);
                } catch (IOException unused2) {
                }
            }
        }
        try {
            this.writer.close();
        } catch (IOException unused3) {
        }
        try {
            this.socket.close();
        } catch (IOException unused4) {
        }
        this.writerQueue.shutdown();
        this.pushQueue.shutdown();
        this.settingsListenerQueue.shutdown();
    }

    public final void flush() throws IOException {
        this.writer.flush();
    }

    public final boolean getClient$okhttp() {
        return this.client;
    }

    public final String getConnectionName$okhttp() {
        return this.connectionName;
    }

    public final int getLastGoodStreamId$okhttp() {
        return this.lastGoodStreamId;
    }

    public final Listener getListener$okhttp() {
        return this.listener;
    }

    public final int getNextStreamId$okhttp() {
        return this.nextStreamId;
    }

    public final Settings getOkHttpSettings() {
        return this.okHttpSettings;
    }

    public final Settings getPeerSettings() {
        return this.peerSettings;
    }

    public final long getReadBytesAcknowledged() {
        return this.readBytesAcknowledged;
    }

    public final long getReadBytesTotal() {
        return this.readBytesTotal;
    }

    public final ReaderRunnable getReaderRunnable() {
        return this.readerRunnable;
    }

    public final Socket getSocket$okhttp() {
        return this.socket;
    }

    public final synchronized Http2Stream getStream(int i11) {
        return this.streams.get(Integer.valueOf(i11));
    }

    public final Map<Integer, Http2Stream> getStreams$okhttp() {
        return this.streams;
    }

    public final long getWriteBytesMaximum() {
        return this.writeBytesMaximum;
    }

    public final long getWriteBytesTotal() {
        return this.writeBytesTotal;
    }

    public final Http2Writer getWriter() {
        return this.writer;
    }

    public final synchronized boolean isHealthy(long j11) {
        if (this.isShutdown) {
            return false;
        }
        return this.degradedPongsReceived >= this.degradedPingsSent || j11 < this.degradedPongDeadlineNs;
    }

    public final Http2Stream newStream(List<Header> requestHeaders, boolean z11) throws IOException {
        Intrinsics.g(requestHeaders, "requestHeaders");
        return newStream(0, requestHeaders, z11);
    }

    public final synchronized int openStreamCount() {
        return this.streams.size();
    }

    public final void pushDataLater$okhttp(final int i11, BufferedSource source, final int i12, final boolean z11) throws IOException {
        Intrinsics.g(source, "source");
        final Buffer buffer = new Buffer();
        long j11 = i12;
        source.require(j11);
        source.read(buffer, j11);
        TaskQueue taskQueue = this.pushQueue;
        final String str = this.connectionName + '[' + i11 + "] onData";
        final boolean z12 = true;
        taskQueue.schedule(new Task(str, z12) { // from class: okhttp3.internal.http2.Http2Connection$pushDataLater$$inlined$execute$1
            @Override // okhttp3.internal.concurrent.Task
            public long runOnce() {
                try {
                    boolean zOnData = this.pushObserver.onData(i11, buffer, i12, z11);
                    if (zOnData) {
                        this.getWriter().rstStream(i11, ErrorCode.CANCEL);
                    }
                    if (!zOnData && !z11) {
                        return -1L;
                    }
                    synchronized (this) {
                        this.currentPushRequests.remove(Integer.valueOf(i11));
                    }
                    return -1L;
                } catch (IOException unused) {
                    return -1L;
                }
            }
        }, 0L);
    }

    public final void pushHeadersLater$okhttp(final int i11, final List<Header> requestHeaders, final boolean z11) {
        Intrinsics.g(requestHeaders, "requestHeaders");
        TaskQueue taskQueue = this.pushQueue;
        final String str = this.connectionName + '[' + i11 + "] onHeaders";
        final boolean z12 = true;
        taskQueue.schedule(new Task(str, z12) { // from class: okhttp3.internal.http2.Http2Connection$pushHeadersLater$$inlined$execute$1
            @Override // okhttp3.internal.concurrent.Task
            public long runOnce() {
                boolean zOnHeaders = this.pushObserver.onHeaders(i11, requestHeaders, z11);
                if (zOnHeaders) {
                    try {
                        this.getWriter().rstStream(i11, ErrorCode.CANCEL);
                    } catch (IOException unused) {
                        return -1L;
                    }
                }
                if (!zOnHeaders && !z11) {
                    return -1L;
                }
                synchronized (this) {
                    this.currentPushRequests.remove(Integer.valueOf(i11));
                }
                return -1L;
            }
        }, 0L);
    }

    public final void pushRequestLater$okhttp(final int i11, final List<Header> requestHeaders) {
        Intrinsics.g(requestHeaders, "requestHeaders");
        synchronized (this) {
            if (this.currentPushRequests.contains(Integer.valueOf(i11))) {
                writeSynResetLater$okhttp(i11, ErrorCode.PROTOCOL_ERROR);
                return;
            }
            this.currentPushRequests.add(Integer.valueOf(i11));
            TaskQueue taskQueue = this.pushQueue;
            final String str = this.connectionName + '[' + i11 + "] onRequest";
            final boolean z11 = true;
            taskQueue.schedule(new Task(str, z11) { // from class: okhttp3.internal.http2.Http2Connection$pushRequestLater$$inlined$execute$1
                @Override // okhttp3.internal.concurrent.Task
                public long runOnce() {
                    if (!this.pushObserver.onRequest(i11, requestHeaders)) {
                        return -1L;
                    }
                    try {
                        this.getWriter().rstStream(i11, ErrorCode.CANCEL);
                        synchronized (this) {
                            this.currentPushRequests.remove(Integer.valueOf(i11));
                        }
                        return -1L;
                    } catch (IOException unused) {
                        return -1L;
                    }
                }
            }, 0L);
        }
    }

    public final void pushResetLater$okhttp(final int i11, final ErrorCode errorCode) {
        Intrinsics.g(errorCode, "errorCode");
        TaskQueue taskQueue = this.pushQueue;
        final String str = this.connectionName + '[' + i11 + "] onReset";
        final boolean z11 = true;
        taskQueue.schedule(new Task(str, z11) { // from class: okhttp3.internal.http2.Http2Connection$pushResetLater$$inlined$execute$1
            @Override // okhttp3.internal.concurrent.Task
            public long runOnce() {
                this.pushObserver.onReset(i11, errorCode);
                synchronized (this) {
                    this.currentPushRequests.remove(Integer.valueOf(i11));
                    Unit unit = Unit.f68710a;
                }
                return -1L;
            }
        }, 0L);
    }

    public final Http2Stream pushStream(int i11, List<Header> requestHeaders, boolean z11) throws IOException {
        Intrinsics.g(requestHeaders, "requestHeaders");
        if (!this.client) {
            return newStream(i11, requestHeaders, z11);
        }
        throw new IllegalStateException("Client cannot push requests.".toString());
    }

    public final boolean pushedStream$okhttp(int i11) {
        return i11 != 0 && (i11 & 1) == 0;
    }

    public final synchronized Http2Stream removeStream$okhttp(int i11) {
        Http2Stream http2StreamRemove;
        http2StreamRemove = this.streams.remove(Integer.valueOf(i11));
        notifyAll();
        return http2StreamRemove;
    }

    public final void sendDegradedPingLater$okhttp() {
        synchronized (this) {
            long j11 = this.degradedPongsReceived;
            long j12 = this.degradedPingsSent;
            if (j11 < j12) {
                return;
            }
            this.degradedPingsSent = j12 + 1;
            this.degradedPongDeadlineNs = System.nanoTime() + ((long) DEGRADED_PONG_TIMEOUT_NS);
            Unit unit = Unit.f68710a;
            TaskQueue taskQueue = this.writerQueue;
            final String str = this.connectionName + " ping";
            final boolean z11 = true;
            taskQueue.schedule(new Task(str, z11) { // from class: okhttp3.internal.http2.Http2Connection$sendDegradedPingLater$$inlined$execute$1
                @Override // okhttp3.internal.concurrent.Task
                public long runOnce() {
                    this.writePing(false, 2, 0);
                    return -1L;
                }
            }, 0L);
        }
    }

    public final void setLastGoodStreamId$okhttp(int i11) {
        this.lastGoodStreamId = i11;
    }

    public final void setNextStreamId$okhttp(int i11) {
        this.nextStreamId = i11;
    }

    public final void setPeerSettings(Settings settings) {
        Intrinsics.g(settings, "<set-?>");
        this.peerSettings = settings;
    }

    public final void setSettings(Settings settings) throws IOException {
        Intrinsics.g(settings, "settings");
        synchronized (this.writer) {
            synchronized (this) {
                if (this.isShutdown) {
                    throw new ConnectionShutdownException();
                }
                this.okHttpSettings.merge(settings);
                Unit unit = Unit.f68710a;
            }
            this.writer.settings(settings);
        }
    }

    public final void shutdown(ErrorCode statusCode) throws IOException {
        Intrinsics.g(statusCode, "statusCode");
        synchronized (this.writer) {
            synchronized (this) {
                if (this.isShutdown) {
                    return;
                }
                this.isShutdown = true;
                int i11 = this.lastGoodStreamId;
                Unit unit = Unit.f68710a;
                this.writer.goAway(i11, statusCode, Util.EMPTY_BYTE_ARRAY);
            }
        }
    }

    @JvmOverloads
    public final void start() throws IOException {
        start$default(this, false, null, 3, null);
    }

    @JvmOverloads
    public final void start(boolean z11) throws IOException {
        start$default(this, z11, null, 2, null);
    }

    @JvmOverloads
    public final void start(boolean z11, TaskRunner taskRunner) throws IOException {
        Intrinsics.g(taskRunner, "taskRunner");
        if (z11) {
            this.writer.connectionPreface();
            this.writer.settings(this.okHttpSettings);
            int initialWindowSize = this.okHttpSettings.getInitialWindowSize();
            if (initialWindowSize != 65535) {
                this.writer.windowUpdate(0, initialWindowSize - Settings.DEFAULT_INITIAL_WINDOW_SIZE);
            }
        }
        TaskQueue taskQueueNewQueue = taskRunner.newQueue();
        String str = this.connectionName;
        taskQueueNewQueue.schedule(new TaskQueue.AnonymousClass1(this.readerRunnable, str, true, str, true), 0L);
    }

    public final synchronized void updateConnectionFlowControl$okhttp(long j11) {
        long j12 = this.readBytesTotal + j11;
        this.readBytesTotal = j12;
        long j13 = j12 - this.readBytesAcknowledged;
        if (j13 >= this.okHttpSettings.getInitialWindowSize() / 2) {
            writeWindowUpdateLater$okhttp(0, j13);
            this.readBytesAcknowledged += j13;
        }
    }

    public final void writeData(int i11, boolean z11, Buffer buffer, long j11) throws IOException {
        long j12;
        long j13;
        int iMin;
        long j14;
        if (j11 == 0) {
            this.writer.data(z11, i11, buffer, 0);
            return;
        }
        while (j11 > 0) {
            synchronized (this) {
                while (true) {
                    try {
                        try {
                            j12 = this.writeBytesTotal;
                            j13 = this.writeBytesMaximum;
                            if (j12 >= j13) {
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
                    throw th2;
                }
                iMin = Math.min((int) Math.min(j11, j13 - j12), this.writer.maxDataLength());
                j14 = iMin;
                this.writeBytesTotal += j14;
                Unit unit = Unit.f68710a;
            }
            j11 -= j14;
            this.writer.data(z11 && j11 == 0, i11, buffer, iMin);
        }
    }

    public final void writeHeaders$okhttp(int i11, boolean z11, List<Header> alternating) throws IOException {
        Intrinsics.g(alternating, "alternating");
        this.writer.headers(z11, i11, alternating);
    }

    public final void writePing() throws InterruptedException {
        synchronized (this) {
            this.awaitPingsSent++;
        }
        writePing(false, 3, 1330343787);
    }

    public final void writePing(boolean z11, int i11, int i12) {
        try {
            this.writer.ping(z11, i11, i12);
        } catch (IOException e11) {
            failConnection(e11);
        }
    }

    public final void writePingAndAwaitPong() throws InterruptedException {
        writePing();
        awaitPong();
    }

    public final void writeSynReset$okhttp(int i11, ErrorCode statusCode) throws IOException {
        Intrinsics.g(statusCode, "statusCode");
        this.writer.rstStream(i11, statusCode);
    }

    public final void writeSynResetLater$okhttp(final int i11, final ErrorCode errorCode) {
        Intrinsics.g(errorCode, "errorCode");
        TaskQueue taskQueue = this.writerQueue;
        final String str = this.connectionName + '[' + i11 + "] writeSynReset";
        final boolean z11 = true;
        taskQueue.schedule(new Task(str, z11) { // from class: okhttp3.internal.http2.Http2Connection$writeSynResetLater$$inlined$execute$1
            @Override // okhttp3.internal.concurrent.Task
            public long runOnce() {
                try {
                    this.writeSynReset$okhttp(i11, errorCode);
                    return -1L;
                } catch (IOException e11) {
                    this.failConnection(e11);
                    return -1L;
                }
            }
        }, 0L);
    }

    public final void writeWindowUpdateLater$okhttp(final int i11, final long j11) {
        TaskQueue taskQueue = this.writerQueue;
        final String str = this.connectionName + '[' + i11 + "] windowUpdate";
        final boolean z11 = true;
        taskQueue.schedule(new Task(str, z11) { // from class: okhttp3.internal.http2.Http2Connection$writeWindowUpdateLater$$inlined$execute$1
            @Override // okhttp3.internal.concurrent.Task
            public long runOnce() {
                try {
                    this.getWriter().windowUpdate(i11, j11);
                    return -1L;
                } catch (IOException e11) {
                    this.failConnection(e11);
                    return -1L;
                }
            }
        }, 0L);
    }
}
