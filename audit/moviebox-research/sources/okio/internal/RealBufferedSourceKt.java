package okio.internal;

import java.io.EOFException;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.a;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Options;
import okio.PeekSource;
import okio.RealBufferedSource;
import okio.Sink;
import okio.Timeout;
import okio.Util;

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
public final class RealBufferedSourceKt {
    public static final void commonClose(RealBufferedSource commonClose) throws IOException {
        Intrinsics.g(commonClose, "$this$commonClose");
        if (commonClose.closed) {
            return;
        }
        commonClose.closed = true;
        commonClose.source.close();
        commonClose.bufferField.clear();
    }

    public static final boolean commonExhausted(RealBufferedSource commonExhausted) {
        Intrinsics.g(commonExhausted, "$this$commonExhausted");
        if (!commonExhausted.closed) {
            return commonExhausted.bufferField.exhausted() && commonExhausted.source.read(commonExhausted.bufferField, (long) 8192) == -1;
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final long commonIndexOf(RealBufferedSource commonIndexOf, byte b11, long j11, long j12) {
        Intrinsics.g(commonIndexOf, "$this$commonIndexOf");
        if (!(!commonIndexOf.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        if (!(0 <= j11 && j12 >= j11)) {
            throw new IllegalArgumentException(("fromIndex=" + j11 + " toIndex=" + j12).toString());
        }
        while (j11 < j12) {
            long jIndexOf = commonIndexOf.bufferField.indexOf(b11, j11, j12);
            if (jIndexOf != -1) {
                return jIndexOf;
            }
            long size = commonIndexOf.bufferField.size();
            if (size >= j12 || commonIndexOf.source.read(commonIndexOf.bufferField, 8192) == -1) {
                break;
            }
            j11 = Math.max(j11, size);
        }
        return -1L;
    }

    public static final long commonIndexOf(RealBufferedSource commonIndexOf, ByteString bytes, long j11) throws IOException {
        Intrinsics.g(commonIndexOf, "$this$commonIndexOf");
        Intrinsics.g(bytes, "bytes");
        if (!(!commonIndexOf.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            long jIndexOf = commonIndexOf.bufferField.indexOf(bytes, j11);
            if (jIndexOf != -1) {
                return jIndexOf;
            }
            long size = commonIndexOf.bufferField.size();
            if (commonIndexOf.source.read(commonIndexOf.bufferField, 8192) == -1) {
                return -1L;
            }
            j11 = Math.max(j11, (size - ((long) bytes.size())) + 1);
        }
    }

    public static final long commonIndexOfElement(RealBufferedSource commonIndexOfElement, ByteString targetBytes, long j11) {
        Intrinsics.g(commonIndexOfElement, "$this$commonIndexOfElement");
        Intrinsics.g(targetBytes, "targetBytes");
        if (!(!commonIndexOfElement.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            long jIndexOfElement = commonIndexOfElement.bufferField.indexOfElement(targetBytes, j11);
            if (jIndexOfElement != -1) {
                return jIndexOfElement;
            }
            long size = commonIndexOfElement.bufferField.size();
            if (commonIndexOfElement.source.read(commonIndexOfElement.bufferField, 8192) == -1) {
                return -1L;
            }
            j11 = Math.max(j11, size);
        }
    }

    public static final BufferedSource commonPeek(RealBufferedSource commonPeek) {
        Intrinsics.g(commonPeek, "$this$commonPeek");
        return Okio.buffer(new PeekSource(commonPeek));
    }

    public static final boolean commonRangeEquals(RealBufferedSource commonRangeEquals, long j11, ByteString bytes, int i11, int i12) {
        Intrinsics.g(commonRangeEquals, "$this$commonRangeEquals");
        Intrinsics.g(bytes, "bytes");
        if (!(!commonRangeEquals.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        if (j11 < 0 || i11 < 0 || i12 < 0 || bytes.size() - i11 < i12) {
            return false;
        }
        for (int i13 = 0; i13 < i12; i13++) {
            long j12 = ((long) i13) + j11;
            if (!commonRangeEquals.request(1 + j12) || commonRangeEquals.bufferField.getByte(j12) != bytes.getByte(i11 + i13)) {
                return false;
            }
        }
        return true;
    }

    public static final int commonRead(RealBufferedSource commonRead, byte[] sink, int i11, int i12) {
        Intrinsics.g(commonRead, "$this$commonRead");
        Intrinsics.g(sink, "sink");
        long j11 = i12;
        Util.checkOffsetAndCount(sink.length, i11, j11);
        if (commonRead.bufferField.size() == 0 && commonRead.source.read(commonRead.bufferField, 8192) == -1) {
            return -1;
        }
        return commonRead.bufferField.read(sink, i11, (int) Math.min(j11, commonRead.bufferField.size()));
    }

    public static final long commonRead(RealBufferedSource commonRead, Buffer sink, long j11) {
        Intrinsics.g(commonRead, "$this$commonRead");
        Intrinsics.g(sink, "sink");
        if (!(j11 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j11).toString());
        }
        if (!(true ^ commonRead.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        if (commonRead.bufferField.size() == 0 && commonRead.source.read(commonRead.bufferField, 8192) == -1) {
            return -1L;
        }
        return commonRead.bufferField.read(sink, Math.min(j11, commonRead.bufferField.size()));
    }

    public static final long commonReadAll(RealBufferedSource commonReadAll, Sink sink) throws IOException {
        Intrinsics.g(commonReadAll, "$this$commonReadAll");
        Intrinsics.g(sink, "sink");
        long j11 = 0;
        while (commonReadAll.source.read(commonReadAll.bufferField, 8192) != -1) {
            long jCompleteSegmentByteCount = commonReadAll.bufferField.completeSegmentByteCount();
            if (jCompleteSegmentByteCount > 0) {
                j11 += jCompleteSegmentByteCount;
                sink.write(commonReadAll.bufferField, jCompleteSegmentByteCount);
            }
        }
        if (commonReadAll.bufferField.size() <= 0) {
            return j11;
        }
        long size = j11 + commonReadAll.bufferField.size();
        Buffer buffer = commonReadAll.bufferField;
        sink.write(buffer, buffer.size());
        return size;
    }

    public static final byte commonReadByte(RealBufferedSource commonReadByte) throws EOFException {
        Intrinsics.g(commonReadByte, "$this$commonReadByte");
        commonReadByte.require(1L);
        return commonReadByte.bufferField.readByte();
    }

    public static final byte[] commonReadByteArray(RealBufferedSource commonReadByteArray) throws IOException {
        Intrinsics.g(commonReadByteArray, "$this$commonReadByteArray");
        commonReadByteArray.bufferField.writeAll(commonReadByteArray.source);
        return commonReadByteArray.bufferField.readByteArray();
    }

    public static final byte[] commonReadByteArray(RealBufferedSource commonReadByteArray, long j11) throws EOFException {
        Intrinsics.g(commonReadByteArray, "$this$commonReadByteArray");
        commonReadByteArray.require(j11);
        return commonReadByteArray.bufferField.readByteArray(j11);
    }

    public static final ByteString commonReadByteString(RealBufferedSource commonReadByteString) throws IOException {
        Intrinsics.g(commonReadByteString, "$this$commonReadByteString");
        commonReadByteString.bufferField.writeAll(commonReadByteString.source);
        return commonReadByteString.bufferField.readByteString();
    }

    public static final ByteString commonReadByteString(RealBufferedSource commonReadByteString, long j11) throws EOFException {
        Intrinsics.g(commonReadByteString, "$this$commonReadByteString");
        commonReadByteString.require(j11);
        return commonReadByteString.bufferField.readByteString(j11);
    }

    public static final long commonReadDecimalLong(RealBufferedSource commonReadDecimalLong) throws EOFException {
        Intrinsics.g(commonReadDecimalLong, "$this$commonReadDecimalLong");
        commonReadDecimalLong.require(1L);
        long j11 = 0;
        while (true) {
            long j12 = j11 + 1;
            if (!commonReadDecimalLong.request(j12)) {
                break;
            }
            byte b11 = commonReadDecimalLong.bufferField.getByte(j11);
            if ((b11 < ((byte) 48) || b11 > ((byte) 57)) && !(j11 == 0 && b11 == ((byte) 45))) {
                if (j11 != 0) {
                    break;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Expected leading [0-9] or '-' character but was 0x");
                String string = Integer.toString(b11, a.a(a.a(16)));
                Intrinsics.f(string, "java.lang.Integer.toStri…(this, checkRadix(radix))");
                sb2.append(string);
                throw new NumberFormatException(sb2.toString());
            }
            j11 = j12;
        }
        return commonReadDecimalLong.bufferField.readDecimalLong();
    }

    public static final void commonReadFully(RealBufferedSource commonReadFully, Buffer sink, long j11) throws IOException {
        Intrinsics.g(commonReadFully, "$this$commonReadFully");
        Intrinsics.g(sink, "sink");
        try {
            commonReadFully.require(j11);
            commonReadFully.bufferField.readFully(sink, j11);
        } catch (EOFException e11) {
            sink.writeAll(commonReadFully.bufferField);
            throw e11;
        }
    }

    public static final void commonReadFully(RealBufferedSource commonReadFully, byte[] sink) throws EOFException {
        Intrinsics.g(commonReadFully, "$this$commonReadFully");
        Intrinsics.g(sink, "sink");
        try {
            commonReadFully.require(sink.length);
            commonReadFully.bufferField.readFully(sink);
        } catch (EOFException e11) {
            int i11 = 0;
            while (commonReadFully.bufferField.size() > 0) {
                Buffer buffer = commonReadFully.bufferField;
                int i12 = buffer.read(sink, i11, (int) buffer.size());
                if (i12 == -1) {
                    throw new AssertionError();
                }
                i11 += i12;
            }
            throw e11;
        }
    }

    public static final long commonReadHexadecimalUnsignedLong(RealBufferedSource commonReadHexadecimalUnsignedLong) throws EOFException {
        Intrinsics.g(commonReadHexadecimalUnsignedLong, "$this$commonReadHexadecimalUnsignedLong");
        commonReadHexadecimalUnsignedLong.require(1L);
        int i11 = 0;
        while (true) {
            int i12 = i11 + 1;
            if (!commonReadHexadecimalUnsignedLong.request(i12)) {
                break;
            }
            byte b11 = commonReadHexadecimalUnsignedLong.bufferField.getByte(i11);
            if ((b11 < ((byte) 48) || b11 > ((byte) 57)) && ((b11 < ((byte) 97) || b11 > ((byte) 102)) && (b11 < ((byte) 65) || b11 > ((byte) 70)))) {
                if (i11 != 0) {
                    break;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Expected leading [0-9a-fA-F] character but was 0x");
                String string = Integer.toString(b11, a.a(a.a(16)));
                Intrinsics.f(string, "java.lang.Integer.toStri…(this, checkRadix(radix))");
                sb2.append(string);
                throw new NumberFormatException(sb2.toString());
            }
            i11 = i12;
        }
        return commonReadHexadecimalUnsignedLong.bufferField.readHexadecimalUnsignedLong();
    }

    public static final int commonReadInt(RealBufferedSource commonReadInt) throws EOFException {
        Intrinsics.g(commonReadInt, "$this$commonReadInt");
        commonReadInt.require(4L);
        return commonReadInt.bufferField.readInt();
    }

    public static final int commonReadIntLe(RealBufferedSource commonReadIntLe) throws EOFException {
        Intrinsics.g(commonReadIntLe, "$this$commonReadIntLe");
        commonReadIntLe.require(4L);
        return commonReadIntLe.bufferField.readIntLe();
    }

    public static final long commonReadLong(RealBufferedSource commonReadLong) throws EOFException {
        Intrinsics.g(commonReadLong, "$this$commonReadLong");
        commonReadLong.require(8L);
        return commonReadLong.bufferField.readLong();
    }

    public static final long commonReadLongLe(RealBufferedSource commonReadLongLe) throws EOFException {
        Intrinsics.g(commonReadLongLe, "$this$commonReadLongLe");
        commonReadLongLe.require(8L);
        return commonReadLongLe.bufferField.readLongLe();
    }

    public static final short commonReadShort(RealBufferedSource commonReadShort) throws EOFException {
        Intrinsics.g(commonReadShort, "$this$commonReadShort");
        commonReadShort.require(2L);
        return commonReadShort.bufferField.readShort();
    }

    public static final short commonReadShortLe(RealBufferedSource commonReadShortLe) throws EOFException {
        Intrinsics.g(commonReadShortLe, "$this$commonReadShortLe");
        commonReadShortLe.require(2L);
        return commonReadShortLe.bufferField.readShortLe();
    }

    public static final String commonReadUtf8(RealBufferedSource commonReadUtf8) throws IOException {
        Intrinsics.g(commonReadUtf8, "$this$commonReadUtf8");
        commonReadUtf8.bufferField.writeAll(commonReadUtf8.source);
        return commonReadUtf8.bufferField.readUtf8();
    }

    public static final String commonReadUtf8(RealBufferedSource commonReadUtf8, long j11) throws EOFException {
        Intrinsics.g(commonReadUtf8, "$this$commonReadUtf8");
        commonReadUtf8.require(j11);
        return commonReadUtf8.bufferField.readUtf8(j11);
    }

    public static final int commonReadUtf8CodePoint(RealBufferedSource commonReadUtf8CodePoint) throws EOFException {
        Intrinsics.g(commonReadUtf8CodePoint, "$this$commonReadUtf8CodePoint");
        commonReadUtf8CodePoint.require(1L);
        byte b11 = commonReadUtf8CodePoint.bufferField.getByte(0L);
        if ((b11 & 224) == 192) {
            commonReadUtf8CodePoint.require(2L);
        } else if ((b11 & 240) == 224) {
            commonReadUtf8CodePoint.require(3L);
        } else if ((b11 & 248) == 240) {
            commonReadUtf8CodePoint.require(4L);
        }
        return commonReadUtf8CodePoint.bufferField.readUtf8CodePoint();
    }

    public static final String commonReadUtf8Line(RealBufferedSource commonReadUtf8Line) {
        Intrinsics.g(commonReadUtf8Line, "$this$commonReadUtf8Line");
        long jIndexOf = commonReadUtf8Line.indexOf((byte) 10);
        if (jIndexOf != -1) {
            return BufferKt.readUtf8Line(commonReadUtf8Line.bufferField, jIndexOf);
        }
        if (commonReadUtf8Line.bufferField.size() != 0) {
            return commonReadUtf8Line.readUtf8(commonReadUtf8Line.bufferField.size());
        }
        return null;
    }

    public static final String commonReadUtf8LineStrict(RealBufferedSource commonReadUtf8LineStrict, long j11) throws EOFException {
        Intrinsics.g(commonReadUtf8LineStrict, "$this$commonReadUtf8LineStrict");
        if (!(j11 >= 0)) {
            throw new IllegalArgumentException(("limit < 0: " + j11).toString());
        }
        long j12 = j11 == Long.MAX_VALUE ? Long.MAX_VALUE : j11 + 1;
        byte b11 = (byte) 10;
        long jIndexOf = commonReadUtf8LineStrict.indexOf(b11, 0L, j12);
        if (jIndexOf != -1) {
            return BufferKt.readUtf8Line(commonReadUtf8LineStrict.bufferField, jIndexOf);
        }
        if (j12 < Long.MAX_VALUE && commonReadUtf8LineStrict.request(j12) && commonReadUtf8LineStrict.bufferField.getByte(j12 - 1) == ((byte) 13) && commonReadUtf8LineStrict.request(1 + j12) && commonReadUtf8LineStrict.bufferField.getByte(j12) == b11) {
            return BufferKt.readUtf8Line(commonReadUtf8LineStrict.bufferField, j12);
        }
        Buffer buffer = new Buffer();
        Buffer buffer2 = commonReadUtf8LineStrict.bufferField;
        buffer2.copyTo(buffer, 0L, Math.min(32, buffer2.size()));
        throw new EOFException("\\n not found: limit=" + Math.min(commonReadUtf8LineStrict.bufferField.size(), j11) + " content=" + buffer.readByteString().hex() + "…");
    }

    public static final boolean commonRequest(RealBufferedSource commonRequest, long j11) {
        Intrinsics.g(commonRequest, "$this$commonRequest");
        if (!(j11 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j11).toString());
        }
        if (!(!commonRequest.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (commonRequest.bufferField.size() < j11) {
            if (commonRequest.source.read(commonRequest.bufferField, 8192) == -1) {
                return false;
            }
        }
        return true;
    }

    public static final void commonRequire(RealBufferedSource commonRequire, long j11) throws EOFException {
        Intrinsics.g(commonRequire, "$this$commonRequire");
        if (!commonRequire.request(j11)) {
            throw new EOFException();
        }
    }

    public static final int commonSelect(RealBufferedSource commonSelect, Options options) throws EOFException {
        Intrinsics.g(commonSelect, "$this$commonSelect");
        Intrinsics.g(options, "options");
        if (!(!commonSelect.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        do {
            int iSelectPrefix = BufferKt.selectPrefix(commonSelect.bufferField, options, true);
            if (iSelectPrefix != -2) {
                if (iSelectPrefix == -1) {
                    return -1;
                }
                commonSelect.bufferField.skip(options.getByteStrings$okio()[iSelectPrefix].size());
                return iSelectPrefix;
            }
        } while (commonSelect.source.read(commonSelect.bufferField, 8192) != -1);
        return -1;
    }

    public static final void commonSkip(RealBufferedSource commonSkip, long j11) throws EOFException {
        Intrinsics.g(commonSkip, "$this$commonSkip");
        if (!(!commonSkip.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (j11 > 0) {
            if (commonSkip.bufferField.size() == 0 && commonSkip.source.read(commonSkip.bufferField, 8192) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j11, commonSkip.bufferField.size());
            commonSkip.bufferField.skip(jMin);
            j11 -= jMin;
        }
    }

    public static final Timeout commonTimeout(RealBufferedSource commonTimeout) {
        Intrinsics.g(commonTimeout, "$this$commonTimeout");
        return commonTimeout.source.timeout();
    }

    public static final String commonToString(RealBufferedSource commonToString) {
        Intrinsics.g(commonToString, "$this$commonToString");
        return "buffer(" + commonToString.source + ')';
    }
}
