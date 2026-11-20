package okio.internal;

import java.io.EOFException;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.RealBufferedSink;
import okio.Sink;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class RealBufferedSinkKt {
    public static final void commonClose(RealBufferedSink commonClose) throws Throwable {
        Intrinsics.g(commonClose, "$this$commonClose");
        if (commonClose.closed) {
            return;
        }
        if (commonClose.bufferField.size() > 0) {
            Sink sink = commonClose.sink;
            Buffer buffer = commonClose.bufferField;
            sink.write(buffer, buffer.size());
        }
        th = null;
        try {
            commonClose.sink.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        commonClose.closed = true;
        if (th != null) {
            throw th;
        }
    }

    public static final BufferedSink commonEmit(RealBufferedSink commonEmit) throws IOException {
        Intrinsics.g(commonEmit, "$this$commonEmit");
        if (!(!commonEmit.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        long size = commonEmit.bufferField.size();
        if (size > 0) {
            commonEmit.sink.write(commonEmit.bufferField, size);
        }
        return commonEmit;
    }

    public static final BufferedSink commonEmitCompleteSegments(RealBufferedSink commonEmitCompleteSegments) throws IOException {
        Intrinsics.g(commonEmitCompleteSegments, "$this$commonEmitCompleteSegments");
        if (!(!commonEmitCompleteSegments.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        long jCompleteSegmentByteCount = commonEmitCompleteSegments.bufferField.completeSegmentByteCount();
        if (jCompleteSegmentByteCount > 0) {
            commonEmitCompleteSegments.sink.write(commonEmitCompleteSegments.bufferField, jCompleteSegmentByteCount);
        }
        return commonEmitCompleteSegments;
    }

    public static final void commonFlush(RealBufferedSink commonFlush) throws IOException {
        Intrinsics.g(commonFlush, "$this$commonFlush");
        if (!(!commonFlush.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        if (commonFlush.bufferField.size() > 0) {
            Sink sink = commonFlush.sink;
            Buffer buffer = commonFlush.bufferField;
            sink.write(buffer, buffer.size());
        }
        commonFlush.sink.flush();
    }

    public static final Timeout commonTimeout(RealBufferedSink commonTimeout) {
        Intrinsics.g(commonTimeout, "$this$commonTimeout");
        return commonTimeout.sink.timeout();
    }

    public static final String commonToString(RealBufferedSink commonToString) {
        Intrinsics.g(commonToString, "$this$commonToString");
        return "buffer(" + commonToString.sink + ')';
    }

    public static final BufferedSink commonWrite(RealBufferedSink commonWrite, ByteString byteString) {
        Intrinsics.g(commonWrite, "$this$commonWrite");
        Intrinsics.g(byteString, "byteString");
        if (!(!commonWrite.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        commonWrite.bufferField.write(byteString);
        return commonWrite.emitCompleteSegments();
    }

    public static final BufferedSink commonWrite(RealBufferedSink commonWrite, ByteString byteString, int i11, int i12) {
        Intrinsics.g(commonWrite, "$this$commonWrite");
        Intrinsics.g(byteString, "byteString");
        if (!(!commonWrite.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        commonWrite.bufferField.write(byteString, i11, i12);
        return commonWrite.emitCompleteSegments();
    }

    public static final BufferedSink commonWrite(RealBufferedSink commonWrite, Source source, long j11) throws IOException {
        Intrinsics.g(commonWrite, "$this$commonWrite");
        Intrinsics.g(source, "source");
        while (j11 > 0) {
            long j12 = source.read(commonWrite.bufferField, j11);
            if (j12 == -1) {
                throw new EOFException();
            }
            j11 -= j12;
            commonWrite.emitCompleteSegments();
        }
        return commonWrite;
    }

    public static final BufferedSink commonWrite(RealBufferedSink commonWrite, byte[] source) {
        Intrinsics.g(commonWrite, "$this$commonWrite");
        Intrinsics.g(source, "source");
        if (!(!commonWrite.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        commonWrite.bufferField.write(source);
        return commonWrite.emitCompleteSegments();
    }

    public static final BufferedSink commonWrite(RealBufferedSink commonWrite, byte[] source, int i11, int i12) {
        Intrinsics.g(commonWrite, "$this$commonWrite");
        Intrinsics.g(source, "source");
        if (!(!commonWrite.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        commonWrite.bufferField.write(source, i11, i12);
        return commonWrite.emitCompleteSegments();
    }

    public static final void commonWrite(RealBufferedSink commonWrite, Buffer source, long j11) throws IOException {
        Intrinsics.g(commonWrite, "$this$commonWrite");
        Intrinsics.g(source, "source");
        if (!(!commonWrite.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        commonWrite.bufferField.write(source, j11);
        commonWrite.emitCompleteSegments();
    }

    public static final long commonWriteAll(RealBufferedSink commonWriteAll, Source source) throws IOException {
        Intrinsics.g(commonWriteAll, "$this$commonWriteAll");
        Intrinsics.g(source, "source");
        long j11 = 0;
        while (true) {
            long j12 = source.read(commonWriteAll.bufferField, 8192);
            if (j12 == -1) {
                return j11;
            }
            j11 += j12;
            commonWriteAll.emitCompleteSegments();
        }
    }

    public static final BufferedSink commonWriteByte(RealBufferedSink commonWriteByte, int i11) {
        Intrinsics.g(commonWriteByte, "$this$commonWriteByte");
        if (!(!commonWriteByte.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        commonWriteByte.bufferField.writeByte(i11);
        return commonWriteByte.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteDecimalLong(RealBufferedSink commonWriteDecimalLong, long j11) {
        Intrinsics.g(commonWriteDecimalLong, "$this$commonWriteDecimalLong");
        if (!(!commonWriteDecimalLong.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        commonWriteDecimalLong.bufferField.writeDecimalLong(j11);
        return commonWriteDecimalLong.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteHexadecimalUnsignedLong(RealBufferedSink commonWriteHexadecimalUnsignedLong, long j11) {
        Intrinsics.g(commonWriteHexadecimalUnsignedLong, "$this$commonWriteHexadecimalUnsignedLong");
        if (!(!commonWriteHexadecimalUnsignedLong.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        commonWriteHexadecimalUnsignedLong.bufferField.writeHexadecimalUnsignedLong(j11);
        return commonWriteHexadecimalUnsignedLong.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteInt(RealBufferedSink commonWriteInt, int i11) {
        Intrinsics.g(commonWriteInt, "$this$commonWriteInt");
        if (!(!commonWriteInt.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        commonWriteInt.bufferField.writeInt(i11);
        return commonWriteInt.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteIntLe(RealBufferedSink commonWriteIntLe, int i11) {
        Intrinsics.g(commonWriteIntLe, "$this$commonWriteIntLe");
        if (!(!commonWriteIntLe.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        commonWriteIntLe.bufferField.writeIntLe(i11);
        return commonWriteIntLe.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteLong(RealBufferedSink commonWriteLong, long j11) {
        Intrinsics.g(commonWriteLong, "$this$commonWriteLong");
        if (!(!commonWriteLong.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        commonWriteLong.bufferField.writeLong(j11);
        return commonWriteLong.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteLongLe(RealBufferedSink commonWriteLongLe, long j11) {
        Intrinsics.g(commonWriteLongLe, "$this$commonWriteLongLe");
        if (!(!commonWriteLongLe.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        commonWriteLongLe.bufferField.writeLongLe(j11);
        return commonWriteLongLe.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteShort(RealBufferedSink commonWriteShort, int i11) {
        Intrinsics.g(commonWriteShort, "$this$commonWriteShort");
        if (!(!commonWriteShort.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        commonWriteShort.bufferField.writeShort(i11);
        return commonWriteShort.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteShortLe(RealBufferedSink commonWriteShortLe, int i11) {
        Intrinsics.g(commonWriteShortLe, "$this$commonWriteShortLe");
        if (!(!commonWriteShortLe.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        commonWriteShortLe.bufferField.writeShortLe(i11);
        return commonWriteShortLe.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteUtf8(RealBufferedSink commonWriteUtf8, String string) {
        Intrinsics.g(commonWriteUtf8, "$this$commonWriteUtf8");
        Intrinsics.g(string, "string");
        if (!(!commonWriteUtf8.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        commonWriteUtf8.bufferField.writeUtf8(string);
        return commonWriteUtf8.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteUtf8(RealBufferedSink commonWriteUtf8, String string, int i11, int i12) {
        Intrinsics.g(commonWriteUtf8, "$this$commonWriteUtf8");
        Intrinsics.g(string, "string");
        if (!(!commonWriteUtf8.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        commonWriteUtf8.bufferField.writeUtf8(string, i11, i12);
        return commonWriteUtf8.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteUtf8CodePoint(RealBufferedSink commonWriteUtf8CodePoint, int i11) {
        Intrinsics.g(commonWriteUtf8CodePoint, "$this$commonWriteUtf8CodePoint");
        if (!(!commonWriteUtf8CodePoint.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        commonWriteUtf8CodePoint.bufferField.writeUtf8CodePoint(i11);
        return commonWriteUtf8CodePoint.emitCompleteSegments();
    }
}
