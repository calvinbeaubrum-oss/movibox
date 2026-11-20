package okhttp3.internal.http2;

import com.google.android.gms.common.api.Api;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.a;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

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
public final class Http2Reader implements Closeable {
    public static final Companion Companion = new Companion(null);
    private static final Logger logger;
    private final boolean client;
    private final ContinuationSource continuation;
    private final Hpack.Reader hpackReader;
    private final BufferedSource source;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Logger getLogger() {
            return Http2Reader.logger;
        }

        public final int lengthWithoutPadding(int i11, int i12, int i13) throws IOException {
            if ((i12 & 8) != 0) {
                i11--;
            }
            if (i13 <= i11) {
                return i11 - i13;
            }
            throw new IOException("PROTOCOL_ERROR padding " + i13 + " > remaining length " + i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class ContinuationSource implements Source {
        private int flags;
        private int left;
        private int length;
        private int padding;
        private final BufferedSource source;
        private int streamId;

        public ContinuationSource(BufferedSource source) {
            Intrinsics.g(source, "source");
            this.source = source;
        }

        private final void readContinuationHeader() throws IOException {
            int i11 = this.streamId;
            int medium = Util.readMedium(this.source);
            this.left = medium;
            this.length = medium;
            int iAnd = Util.and(this.source.readByte(), 255);
            this.flags = Util.and(this.source.readByte(), 255);
            Companion companion = Http2Reader.Companion;
            if (companion.getLogger().isLoggable(Level.FINE)) {
                companion.getLogger().fine(Http2.INSTANCE.frameLog(true, this.streamId, this.length, iAnd, this.flags));
            }
            int i12 = this.source.readInt() & Api.BaseClientBuilder.API_PRIORITY_OTHER;
            this.streamId = i12;
            if (iAnd == 9) {
                if (i12 != i11) {
                    throw new IOException("TYPE_CONTINUATION streamId changed");
                }
            } else {
                throw new IOException(iAnd + " != TYPE_CONTINUATION");
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        public final int getFlags() {
            return this.flags;
        }

        public final int getLeft() {
            return this.left;
        }

        public final int getLength() {
            return this.length;
        }

        public final int getPadding() {
            return this.padding;
        }

        public final int getStreamId() {
            return this.streamId;
        }

        @Override // okio.Source
        public long read(Buffer sink, long j11) throws IOException {
            Intrinsics.g(sink, "sink");
            while (true) {
                int i11 = this.left;
                if (i11 != 0) {
                    long j12 = this.source.read(sink, Math.min(j11, i11));
                    if (j12 == -1) {
                        return -1L;
                    }
                    this.left -= (int) j12;
                    return j12;
                }
                this.source.skip(this.padding);
                this.padding = 0;
                if ((this.flags & 4) != 0) {
                    return -1L;
                }
                readContinuationHeader();
            }
        }

        public final void setFlags(int i11) {
            this.flags = i11;
        }

        public final void setLeft(int i11) {
            this.left = i11;
        }

        public final void setLength(int i11) {
            this.length = i11;
        }

        public final void setPadding(int i11) {
            this.padding = i11;
        }

        public final void setStreamId(int i11) {
            this.streamId = i11;
        }

        @Override // okio.Source
        public Timeout timeout() {
            return this.source.timeout();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public interface Handler {
        void ackSettings();

        void alternateService(int i11, String str, ByteString byteString, String str2, int i12, long j11);

        void data(boolean z11, int i11, BufferedSource bufferedSource, int i12) throws IOException;

        void goAway(int i11, ErrorCode errorCode, ByteString byteString);

        void headers(boolean z11, int i11, int i12, List<Header> list);

        void ping(boolean z11, int i11, int i12);

        void priority(int i11, int i12, int i13, boolean z11);

        void pushPromise(int i11, int i12, List<Header> list) throws IOException;

        void rstStream(int i11, ErrorCode errorCode);

        void settings(boolean z11, Settings settings);

        void windowUpdate(int i11, long j11);
    }

    static {
        Logger logger2 = Logger.getLogger(Http2.class.getName());
        Intrinsics.f(logger2, "Logger.getLogger(Http2::class.java.name)");
        logger = logger2;
    }

    public Http2Reader(BufferedSource source, boolean z11) {
        Intrinsics.g(source, "source");
        this.source = source;
        this.client = z11;
        ContinuationSource continuationSource = new ContinuationSource(source);
        this.continuation = continuationSource;
        this.hpackReader = new Hpack.Reader(continuationSource, 4096, 0, 4, null);
    }

    private final void readData(Handler handler, int i11, int i12, int i13) throws IOException {
        if (i13 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_DATA streamId == 0");
        }
        boolean z11 = (i12 & 1) != 0;
        if ((i12 & 32) != 0) {
            throw new IOException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA");
        }
        int iAnd = (i12 & 8) != 0 ? Util.and(this.source.readByte(), 255) : 0;
        handler.data(z11, i13, this.source, Companion.lengthWithoutPadding(i11, i12, iAnd));
        this.source.skip(iAnd);
    }

    private final void readGoAway(Handler handler, int i11, int i12, int i13) throws IOException {
        if (i11 < 8) {
            throw new IOException("TYPE_GOAWAY length < 8: " + i11);
        }
        if (i13 != 0) {
            throw new IOException("TYPE_GOAWAY streamId != 0");
        }
        int i14 = this.source.readInt();
        int i15 = this.source.readInt();
        int i16 = i11 - 8;
        ErrorCode errorCodeFromHttp2 = ErrorCode.Companion.fromHttp2(i15);
        if (errorCodeFromHttp2 == null) {
            throw new IOException("TYPE_GOAWAY unexpected error code: " + i15);
        }
        ByteString byteString = ByteString.EMPTY;
        if (i16 > 0) {
            byteString = this.source.readByteString(i16);
        }
        handler.goAway(i14, errorCodeFromHttp2, byteString);
    }

    private final List<Header> readHeaderBlock(int i11, int i12, int i13, int i14) throws IOException {
        this.continuation.setLeft(i11);
        ContinuationSource continuationSource = this.continuation;
        continuationSource.setLength(continuationSource.getLeft());
        this.continuation.setPadding(i12);
        this.continuation.setFlags(i13);
        this.continuation.setStreamId(i14);
        this.hpackReader.readHeaders();
        return this.hpackReader.getAndResetHeaderList();
    }

    private final void readHeaders(Handler handler, int i11, int i12, int i13) throws IOException {
        if (i13 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
        }
        boolean z11 = (i12 & 1) != 0;
        int iAnd = (i12 & 8) != 0 ? Util.and(this.source.readByte(), 255) : 0;
        if ((i12 & 32) != 0) {
            readPriority(handler, i13);
            i11 -= 5;
        }
        handler.headers(z11, i13, -1, readHeaderBlock(Companion.lengthWithoutPadding(i11, i12, iAnd), iAnd, i12, i13));
    }

    private final void readPing(Handler handler, int i11, int i12, int i13) throws IOException {
        if (i11 != 8) {
            throw new IOException("TYPE_PING length != 8: " + i11);
        }
        if (i13 != 0) {
            throw new IOException("TYPE_PING streamId != 0");
        }
        handler.ping((i12 & 1) != 0, this.source.readInt(), this.source.readInt());
    }

    private final void readPriority(Handler handler, int i11) throws IOException {
        int i12 = this.source.readInt();
        handler.priority(i11, i12 & Api.BaseClientBuilder.API_PRIORITY_OTHER, Util.and(this.source.readByte(), 255) + 1, (i12 & ((int) 2147483648L)) != 0);
    }

    private final void readPriority(Handler handler, int i11, int i12, int i13) throws IOException {
        if (i11 == 5) {
            if (i13 == 0) {
                throw new IOException("TYPE_PRIORITY streamId == 0");
            }
            readPriority(handler, i13);
        } else {
            throw new IOException("TYPE_PRIORITY length: " + i11 + " != 5");
        }
    }

    private final void readPushPromise(Handler handler, int i11, int i12, int i13) throws IOException {
        if (i13 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
        }
        int iAnd = (i12 & 8) != 0 ? Util.and(this.source.readByte(), 255) : 0;
        handler.pushPromise(i13, this.source.readInt() & Api.BaseClientBuilder.API_PRIORITY_OTHER, readHeaderBlock(Companion.lengthWithoutPadding(i11 - 4, i12, iAnd), iAnd, i12, i13));
    }

    private final void readRstStream(Handler handler, int i11, int i12, int i13) throws IOException {
        if (i11 != 4) {
            throw new IOException("TYPE_RST_STREAM length: " + i11 + " != 4");
        }
        if (i13 == 0) {
            throw new IOException("TYPE_RST_STREAM streamId == 0");
        }
        int i14 = this.source.readInt();
        ErrorCode errorCodeFromHttp2 = ErrorCode.Companion.fromHttp2(i14);
        if (errorCodeFromHttp2 != null) {
            handler.rstStream(i13, errorCodeFromHttp2);
            return;
        }
        throw new IOException("TYPE_RST_STREAM unexpected error code: " + i14);
    }

    private final void readSettings(Handler handler, int i11, int i12, int i13) throws IOException {
        if (i13 != 0) {
            throw new IOException("TYPE_SETTINGS streamId != 0");
        }
        if ((i12 & 1) != 0) {
            if (i11 != 0) {
                throw new IOException("FRAME_SIZE_ERROR ack frame should be empty!");
            }
            handler.ackSettings();
            return;
        }
        if (i11 % 6 != 0) {
            throw new IOException("TYPE_SETTINGS length % 6 != 0: " + i11);
        }
        Settings settings = new Settings();
        IntProgression intProgressionQ = a.q(a.r(0, i11), 6);
        int iG = intProgressionQ.g();
        int i14 = intProgressionQ.i();
        int iR = intProgressionQ.r();
        if (iR < 0 ? iG >= i14 : iG <= i14) {
            while (true) {
                int iAnd = Util.and(this.source.readShort(), Settings.DEFAULT_INITIAL_WINDOW_SIZE);
                int i15 = this.source.readInt();
                if (iAnd != 2) {
                    if (iAnd == 3) {
                        iAnd = 4;
                    } else if (iAnd != 4) {
                        if (iAnd == 5 && (i15 < 16384 || i15 > 16777215)) {
                            throw new IOException("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: " + i15);
                        }
                    } else {
                        if (i15 < 0) {
                            throw new IOException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1");
                        }
                        iAnd = 7;
                    }
                } else if (i15 != 0 && i15 != 1) {
                    throw new IOException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1");
                }
                settings.set(iAnd, i15);
                if (iG != i14) {
                    iG += iR;
                }
            }
        }
        handler.settings(false, settings);
    }

    private final void readWindowUpdate(Handler handler, int i11, int i12, int i13) throws IOException {
        if (i11 != 4) {
            throw new IOException("TYPE_WINDOW_UPDATE length !=4: " + i11);
        }
        long jAnd = Util.and(this.source.readInt(), 2147483647L);
        if (jAnd == 0) {
            throw new IOException("windowSizeIncrement was 0");
        }
        handler.windowUpdate(i13, jAnd);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.source.close();
    }

    public final boolean nextFrame(boolean z11, Handler handler) throws IOException {
        Intrinsics.g(handler, "handler");
        try {
            this.source.require(9L);
            int medium = Util.readMedium(this.source);
            if (medium > 16384) {
                throw new IOException("FRAME_SIZE_ERROR: " + medium);
            }
            int iAnd = Util.and(this.source.readByte(), 255);
            int iAnd2 = Util.and(this.source.readByte(), 255);
            int i11 = this.source.readInt() & Api.BaseClientBuilder.API_PRIORITY_OTHER;
            Logger logger2 = logger;
            if (logger2.isLoggable(Level.FINE)) {
                logger2.fine(Http2.INSTANCE.frameLog(true, i11, medium, iAnd, iAnd2));
            }
            if (z11 && iAnd != 4) {
                throw new IOException("Expected a SETTINGS frame but was " + Http2.INSTANCE.formattedType$okhttp(iAnd));
            }
            switch (iAnd) {
                case 0:
                    readData(handler, medium, iAnd2, i11);
                    return true;
                case 1:
                    readHeaders(handler, medium, iAnd2, i11);
                    return true;
                case 2:
                    readPriority(handler, medium, iAnd2, i11);
                    return true;
                case 3:
                    readRstStream(handler, medium, iAnd2, i11);
                    return true;
                case 4:
                    readSettings(handler, medium, iAnd2, i11);
                    return true;
                case 5:
                    readPushPromise(handler, medium, iAnd2, i11);
                    return true;
                case 6:
                    readPing(handler, medium, iAnd2, i11);
                    return true;
                case 7:
                    readGoAway(handler, medium, iAnd2, i11);
                    return true;
                case 8:
                    readWindowUpdate(handler, medium, iAnd2, i11);
                    return true;
                default:
                    this.source.skip(medium);
                    return true;
            }
        } catch (EOFException unused) {
            return false;
        }
    }

    public final void readConnectionPreface(Handler handler) throws IOException {
        Intrinsics.g(handler, "handler");
        if (this.client) {
            if (!nextFrame(true, handler)) {
                throw new IOException("Required SETTINGS preface not received");
            }
            return;
        }
        BufferedSource bufferedSource = this.source;
        ByteString byteString = Http2.CONNECTION_PREFACE;
        ByteString byteString2 = bufferedSource.readByteString(byteString.size());
        Logger logger2 = logger;
        if (logger2.isLoggable(Level.FINE)) {
            logger2.fine(Util.format("<< CONNECTION " + byteString2.hex(), new Object[0]));
        }
        if (!Intrinsics.b(byteString, byteString2)) {
            throw new IOException("Expected a connection header but was " + byteString2.utf8());
        }
    }
}
