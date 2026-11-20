package okhttp3.internal.http2;

import com.google.android.gms.common.api.Api;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;

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
public final class Http2Writer implements Closeable {
    public static final Companion Companion = new Companion(null);
    private static final Logger logger = Logger.getLogger(Http2.class.getName());
    private final boolean client;
    private boolean closed;
    private final Buffer hpackBuffer;
    private final Hpack.Writer hpackWriter;
    private int maxFrameSize;
    private final BufferedSink sink;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public Http2Writer(BufferedSink sink, boolean z11) {
        Intrinsics.g(sink, "sink");
        this.sink = sink;
        this.client = z11;
        Buffer buffer = new Buffer();
        this.hpackBuffer = buffer;
        this.maxFrameSize = 16384;
        this.hpackWriter = new Hpack.Writer(0, false, buffer, 3, null);
    }

    private final void writeContinuationFrames(int i11, long j11) throws IOException {
        while (j11 > 0) {
            long jMin = Math.min(this.maxFrameSize, j11);
            j11 -= jMin;
            frameHeader(i11, (int) jMin, 9, j11 == 0 ? 4 : 0);
            this.sink.write(this.hpackBuffer, jMin);
        }
    }

    public final synchronized void applyAndAckSettings(Settings peerSettings) throws IOException {
        try {
            Intrinsics.g(peerSettings, "peerSettings");
            if (this.closed) {
                throw new IOException("closed");
            }
            this.maxFrameSize = peerSettings.getMaxFrameSize(this.maxFrameSize);
            if (peerSettings.getHeaderTableSize() != -1) {
                this.hpackWriter.resizeHeaderTable(peerSettings.getHeaderTableSize());
            }
            frameHeader(0, 0, 4, 1);
            this.sink.flush();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.closed = true;
        this.sink.close();
    }

    public final synchronized void connectionPreface() throws IOException {
        try {
            if (this.closed) {
                throw new IOException("closed");
            }
            if (this.client) {
                Logger logger2 = logger;
                if (logger2.isLoggable(Level.FINE)) {
                    logger2.fine(Util.format(">> CONNECTION " + Http2.CONNECTION_PREFACE.hex(), new Object[0]));
                }
                this.sink.write(Http2.CONNECTION_PREFACE);
                this.sink.flush();
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized void data(boolean z11, int i11, Buffer buffer, int i12) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        dataFrame(i11, z11 ? 1 : 0, buffer, i12);
    }

    public final void dataFrame(int i11, int i12, Buffer buffer, int i13) throws IOException {
        frameHeader(i11, i13, 0, i12);
        if (i13 > 0) {
            BufferedSink bufferedSink = this.sink;
            Intrinsics.d(buffer);
            bufferedSink.write(buffer, i13);
        }
    }

    public final synchronized void flush() throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        this.sink.flush();
    }

    public final void frameHeader(int i11, int i12, int i13, int i14) throws IOException {
        Logger logger2 = logger;
        if (logger2.isLoggable(Level.FINE)) {
            logger2.fine(Http2.INSTANCE.frameLog(false, i11, i12, i13, i14));
        }
        if (!(i12 <= this.maxFrameSize)) {
            throw new IllegalArgumentException(("FRAME_SIZE_ERROR length > " + this.maxFrameSize + ": " + i12).toString());
        }
        if (!((((int) 2147483648L) & i11) == 0)) {
            throw new IllegalArgumentException(("reserved bit set: " + i11).toString());
        }
        Util.writeMedium(this.sink, i12);
        this.sink.writeByte(i13 & 255);
        this.sink.writeByte(i14 & 255);
        this.sink.writeInt(i11 & Api.BaseClientBuilder.API_PRIORITY_OTHER);
    }

    public final Hpack.Writer getHpackWriter() {
        return this.hpackWriter;
    }

    public final synchronized void goAway(int i11, ErrorCode errorCode, byte[] debugData) throws IOException {
        try {
            Intrinsics.g(errorCode, "errorCode");
            Intrinsics.g(debugData, "debugData");
            if (this.closed) {
                throw new IOException("closed");
            }
            if (!(errorCode.getHttpCode() != -1)) {
                throw new IllegalArgumentException("errorCode.httpCode == -1".toString());
            }
            frameHeader(0, debugData.length + 8, 7, 0);
            this.sink.writeInt(i11);
            this.sink.writeInt(errorCode.getHttpCode());
            if (!(debugData.length == 0)) {
                this.sink.write(debugData);
            }
            this.sink.flush();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized void headers(boolean z11, int i11, List<Header> headerBlock) throws IOException {
        Intrinsics.g(headerBlock, "headerBlock");
        if (this.closed) {
            throw new IOException("closed");
        }
        this.hpackWriter.writeHeaders(headerBlock);
        long size = this.hpackBuffer.size();
        long jMin = Math.min(this.maxFrameSize, size);
        int i12 = size == jMin ? 4 : 0;
        if (z11) {
            i12 |= 1;
        }
        frameHeader(i11, (int) jMin, 1, i12);
        this.sink.write(this.hpackBuffer, jMin);
        if (size > jMin) {
            writeContinuationFrames(i11, size - jMin);
        }
    }

    public final int maxDataLength() {
        return this.maxFrameSize;
    }

    public final synchronized void ping(boolean z11, int i11, int i12) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        frameHeader(0, 8, 6, z11 ? 1 : 0);
        this.sink.writeInt(i11);
        this.sink.writeInt(i12);
        this.sink.flush();
    }

    public final synchronized void pushPromise(int i11, int i12, List<Header> requestHeaders) throws IOException {
        Intrinsics.g(requestHeaders, "requestHeaders");
        if (this.closed) {
            throw new IOException("closed");
        }
        this.hpackWriter.writeHeaders(requestHeaders);
        long size = this.hpackBuffer.size();
        int iMin = (int) Math.min(((long) this.maxFrameSize) - 4, size);
        long j11 = iMin;
        frameHeader(i11, iMin + 4, 5, size == j11 ? 4 : 0);
        this.sink.writeInt(i12 & Api.BaseClientBuilder.API_PRIORITY_OTHER);
        this.sink.write(this.hpackBuffer, j11);
        if (size > j11) {
            writeContinuationFrames(i11, size - j11);
        }
    }

    public final synchronized void rstStream(int i11, ErrorCode errorCode) throws IOException {
        Intrinsics.g(errorCode, "errorCode");
        if (this.closed) {
            throw new IOException("closed");
        }
        if (!(errorCode.getHttpCode() != -1)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        frameHeader(i11, 4, 3, 0);
        this.sink.writeInt(errorCode.getHttpCode());
        this.sink.flush();
    }

    public final synchronized void settings(Settings settings) throws IOException {
        int i11;
        try {
            Intrinsics.g(settings, "settings");
            if (this.closed) {
                throw new IOException("closed");
            }
            int i12 = 0;
            frameHeader(0, settings.size() * 6, 4, 0);
            while (i12 < 10) {
                if (settings.isSet(i12)) {
                    if (i12 != 4) {
                        i11 = i12 != 7 ? i12 : 4;
                    } else {
                        i11 = 3;
                    }
                    this.sink.writeShort(i11);
                    this.sink.writeInt(settings.get(i12));
                }
                i12++;
            }
            this.sink.flush();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized void windowUpdate(int i11, long j11) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        if (!(j11 != 0 && j11 <= 2147483647L)) {
            throw new IllegalArgumentException(("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: " + j11).toString());
        }
        frameHeader(i11, 4, 8, 0);
        this.sink.writeInt((int) j11);
        this.sink.flush();
    }
}
