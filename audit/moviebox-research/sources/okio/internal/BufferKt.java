package okio.internal;

import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.gms.common.api.Api;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import java.io.EOFException;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.connection.RealConnection;
import okio.Buffer;
import okio.ByteString;
import okio.Options;
import okio.Platform;
import okio.Segment;
import okio.SegmentPool;
import okio.SegmentedByteString;
import okio.Sink;
import okio.Source;
import okio.Utf8;
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
public final class BufferKt {
    private static final byte[] HEX_DIGIT_BYTES = Platform.asUtf8ToByteArray("0123456789abcdef");
    public static final long OVERFLOW_DIGIT_START = -7;
    public static final long OVERFLOW_ZONE = -922337203685477580L;
    public static final int SEGMENTING_THRESHOLD = 4096;

    public static final void commonClear(Buffer commonClear) throws EOFException {
        Intrinsics.g(commonClear, "$this$commonClear");
        commonClear.skip(commonClear.size());
    }

    public static final void commonClose(Buffer.UnsafeCursor commonClose) {
        Intrinsics.g(commonClose, "$this$commonClose");
        if (!(commonClose.buffer != null)) {
            throw new IllegalStateException("not attached to a buffer".toString());
        }
        commonClose.buffer = null;
        commonClose.setSegment$okio(null);
        commonClose.offset = -1L;
        commonClose.data = null;
        commonClose.start = -1;
        commonClose.end = -1;
    }

    public static final long commonCompleteSegmentByteCount(Buffer commonCompleteSegmentByteCount) {
        Intrinsics.g(commonCompleteSegmentByteCount, "$this$commonCompleteSegmentByteCount");
        long size = commonCompleteSegmentByteCount.size();
        if (size == 0) {
            return 0L;
        }
        Segment segment = commonCompleteSegmentByteCount.head;
        Intrinsics.d(segment);
        Segment segment2 = segment.prev;
        Intrinsics.d(segment2);
        int i11 = segment2.limit;
        return (i11 >= 8192 || !segment2.owner) ? size : size - ((long) (i11 - segment2.pos));
    }

    public static final Buffer commonCopy(Buffer commonCopy) {
        Intrinsics.g(commonCopy, "$this$commonCopy");
        Buffer buffer = new Buffer();
        if (commonCopy.size() == 0) {
            return buffer;
        }
        Segment segment = commonCopy.head;
        Intrinsics.d(segment);
        Segment segmentSharedCopy = segment.sharedCopy();
        buffer.head = segmentSharedCopy;
        segmentSharedCopy.prev = segmentSharedCopy;
        segmentSharedCopy.next = segmentSharedCopy;
        for (Segment segment2 = segment.next; segment2 != segment; segment2 = segment2.next) {
            Segment segment3 = segmentSharedCopy.prev;
            Intrinsics.d(segment3);
            Intrinsics.d(segment2);
            segment3.push(segment2.sharedCopy());
        }
        buffer.setSize$okio(commonCopy.size());
        return buffer;
    }

    public static final Buffer commonCopyTo(Buffer commonCopyTo, Buffer out, long j11, long j12) {
        Intrinsics.g(commonCopyTo, "$this$commonCopyTo");
        Intrinsics.g(out, "out");
        Util.checkOffsetAndCount(commonCopyTo.size(), j11, j12);
        if (j12 == 0) {
            return commonCopyTo;
        }
        out.setSize$okio(out.size() + j12);
        Segment segment = commonCopyTo.head;
        while (true) {
            Intrinsics.d(segment);
            int i11 = segment.limit;
            int i12 = segment.pos;
            if (j11 < i11 - i12) {
                break;
            }
            j11 -= (long) (i11 - i12);
            segment = segment.next;
        }
        while (j12 > 0) {
            Intrinsics.d(segment);
            Segment segmentSharedCopy = segment.sharedCopy();
            int i13 = segmentSharedCopy.pos + ((int) j11);
            segmentSharedCopy.pos = i13;
            segmentSharedCopy.limit = Math.min(i13 + ((int) j12), segmentSharedCopy.limit);
            Segment segment2 = out.head;
            if (segment2 == null) {
                segmentSharedCopy.prev = segmentSharedCopy;
                segmentSharedCopy.next = segmentSharedCopy;
                out.head = segmentSharedCopy;
            } else {
                Intrinsics.d(segment2);
                Segment segment3 = segment2.prev;
                Intrinsics.d(segment3);
                segment3.push(segmentSharedCopy);
            }
            j12 -= (long) (segmentSharedCopy.limit - segmentSharedCopy.pos);
            segment = segment.next;
            j11 = 0;
        }
        return commonCopyTo;
    }

    public static final boolean commonEquals(Buffer commonEquals, Object obj) {
        Intrinsics.g(commonEquals, "$this$commonEquals");
        if (commonEquals == obj) {
            return true;
        }
        if (!(obj instanceof Buffer)) {
            return false;
        }
        Buffer buffer = (Buffer) obj;
        if (commonEquals.size() != buffer.size()) {
            return false;
        }
        if (commonEquals.size() == 0) {
            return true;
        }
        Segment segment = commonEquals.head;
        Intrinsics.d(segment);
        Segment segment2 = buffer.head;
        Intrinsics.d(segment2);
        int i11 = segment.pos;
        int i12 = segment2.pos;
        long j11 = 0;
        while (j11 < commonEquals.size()) {
            long jMin = Math.min(segment.limit - i11, segment2.limit - i12);
            long j12 = 0;
            while (j12 < jMin) {
                int i13 = i11 + 1;
                int i14 = i12 + 1;
                if (segment.data[i11] != segment2.data[i12]) {
                    return false;
                }
                j12++;
                i11 = i13;
                i12 = i14;
            }
            if (i11 == segment.limit) {
                segment = segment.next;
                Intrinsics.d(segment);
                i11 = segment.pos;
            }
            if (i12 == segment2.limit) {
                segment2 = segment2.next;
                Intrinsics.d(segment2);
                i12 = segment2.pos;
            }
            j11 += jMin;
        }
        return true;
    }

    public static final long commonExpandBuffer(Buffer.UnsafeCursor commonExpandBuffer, int i11) {
        Intrinsics.g(commonExpandBuffer, "$this$commonExpandBuffer");
        if (!(i11 > 0)) {
            throw new IllegalArgumentException(("minByteCount <= 0: " + i11).toString());
        }
        if (!(i11 <= 8192)) {
            throw new IllegalArgumentException(("minByteCount > Segment.SIZE: " + i11).toString());
        }
        Buffer buffer = commonExpandBuffer.buffer;
        if (buffer == null) {
            throw new IllegalStateException("not attached to a buffer".toString());
        }
        if (!commonExpandBuffer.readWrite) {
            throw new IllegalStateException("expandBuffer() only permitted for read/write buffers".toString());
        }
        long size = buffer.size();
        Segment segmentWritableSegment$okio = buffer.writableSegment$okio(i11);
        int i12 = 8192 - segmentWritableSegment$okio.limit;
        segmentWritableSegment$okio.limit = 8192;
        long j11 = i12;
        buffer.setSize$okio(size + j11);
        commonExpandBuffer.setSegment$okio(segmentWritableSegment$okio);
        commonExpandBuffer.offset = size;
        commonExpandBuffer.data = segmentWritableSegment$okio.data;
        commonExpandBuffer.start = 8192 - i12;
        commonExpandBuffer.end = 8192;
        return j11;
    }

    public static final byte commonGet(Buffer commonGet, long j11) {
        Intrinsics.g(commonGet, "$this$commonGet");
        Util.checkOffsetAndCount(commonGet.size(), j11, 1L);
        Segment segment = commonGet.head;
        if (segment == null) {
            Intrinsics.d(null);
            throw null;
        }
        if (commonGet.size() - j11 < j11) {
            long size = commonGet.size();
            while (size > j11) {
                segment = segment.prev;
                Intrinsics.d(segment);
                size -= (long) (segment.limit - segment.pos);
            }
            Intrinsics.d(segment);
            return segment.data[(int) ((((long) segment.pos) + j11) - size)];
        }
        long j12 = 0;
        while (true) {
            long j13 = ((long) (segment.limit - segment.pos)) + j12;
            if (j13 > j11) {
                Intrinsics.d(segment);
                return segment.data[(int) ((((long) segment.pos) + j11) - j12)];
            }
            segment = segment.next;
            Intrinsics.d(segment);
            j12 = j13;
        }
    }

    public static final int commonHashCode(Buffer commonHashCode) {
        Intrinsics.g(commonHashCode, "$this$commonHashCode");
        Segment segment = commonHashCode.head;
        if (segment == null) {
            return 0;
        }
        int i11 = 1;
        do {
            int i12 = segment.limit;
            for (int i13 = segment.pos; i13 < i12; i13++) {
                i11 = (i11 * 31) + segment.data[i13];
            }
            segment = segment.next;
            Intrinsics.d(segment);
        } while (segment != commonHashCode.head);
        return i11;
    }

    public static final long commonIndexOf(Buffer commonIndexOf, byte b11, long j11, long j12) {
        Segment segment;
        int i11;
        Intrinsics.g(commonIndexOf, "$this$commonIndexOf");
        long size = 0;
        if (!(0 <= j11 && j12 >= j11)) {
            throw new IllegalArgumentException(("size=" + commonIndexOf.size() + " fromIndex=" + j11 + " toIndex=" + j12).toString());
        }
        if (j12 > commonIndexOf.size()) {
            j12 = commonIndexOf.size();
        }
        if (j11 == j12 || (segment = commonIndexOf.head) == null) {
            return -1L;
        }
        if (commonIndexOf.size() - j11 < j11) {
            size = commonIndexOf.size();
            while (size > j11) {
                segment = segment.prev;
                Intrinsics.d(segment);
                size -= (long) (segment.limit - segment.pos);
            }
            while (size < j12) {
                byte[] bArr = segment.data;
                int iMin = (int) Math.min(segment.limit, (((long) segment.pos) + j12) - size);
                i11 = (int) ((((long) segment.pos) + j11) - size);
                while (i11 < iMin) {
                    if (bArr[i11] != b11) {
                        i11++;
                    }
                }
                size += (long) (segment.limit - segment.pos);
                segment = segment.next;
                Intrinsics.d(segment);
                j11 = size;
            }
            return -1L;
        }
        while (true) {
            long j13 = ((long) (segment.limit - segment.pos)) + size;
            if (j13 > j11) {
                break;
            }
            segment = segment.next;
            Intrinsics.d(segment);
            size = j13;
        }
        while (size < j12) {
            byte[] bArr2 = segment.data;
            int iMin2 = (int) Math.min(segment.limit, (((long) segment.pos) + j12) - size);
            i11 = (int) ((((long) segment.pos) + j11) - size);
            while (i11 < iMin2) {
                if (bArr2[i11] != b11) {
                    i11++;
                }
            }
            size += (long) (segment.limit - segment.pos);
            segment = segment.next;
            Intrinsics.d(segment);
            j11 = size;
        }
        return -1L;
        return ((long) (i11 - segment.pos)) + size;
    }

    public static final long commonIndexOf(Buffer commonIndexOf, ByteString bytes, long j11) {
        long size;
        int i11;
        long j12 = j11;
        Intrinsics.g(commonIndexOf, "$this$commonIndexOf");
        Intrinsics.g(bytes, "bytes");
        if (!(bytes.size() > 0)) {
            throw new IllegalArgumentException("bytes is empty".toString());
        }
        long j13 = 0;
        if (!(j12 >= 0)) {
            throw new IllegalArgumentException(("fromIndex < 0: " + j12).toString());
        }
        Segment segment = commonIndexOf.head;
        if (segment == null) {
            return -1L;
        }
        if (commonIndexOf.size() - j12 < j12) {
            size = commonIndexOf.size();
            while (size > j12) {
                segment = segment.prev;
                Intrinsics.d(segment);
                size -= (long) (segment.limit - segment.pos);
            }
            byte[] bArrInternalArray$okio = bytes.internalArray$okio();
            byte b11 = bArrInternalArray$okio[0];
            int size2 = bytes.size();
            long size3 = (commonIndexOf.size() - ((long) size2)) + 1;
            while (size < size3) {
                byte[] bArr = segment.data;
                int iMin = (int) Math.min(segment.limit, (((long) segment.pos) + size3) - size);
                i11 = (int) ((((long) segment.pos) + j12) - size);
                while (i11 < iMin) {
                    if (bArr[i11] != b11 || !rangeEquals(segment, i11 + 1, bArrInternalArray$okio, 1, size2)) {
                        i11++;
                    }
                }
                size += (long) (segment.limit - segment.pos);
                segment = segment.next;
                Intrinsics.d(segment);
                j12 = size;
            }
            return -1L;
        }
        while (true) {
            long j14 = ((long) (segment.limit - segment.pos)) + j13;
            if (j14 > j12) {
                break;
            }
            segment = segment.next;
            Intrinsics.d(segment);
            j13 = j14;
        }
        byte[] bArrInternalArray$okio2 = bytes.internalArray$okio();
        byte b12 = bArrInternalArray$okio2[0];
        int size4 = bytes.size();
        long size5 = (commonIndexOf.size() - ((long) size4)) + 1;
        size = j13;
        while (size < size5) {
            byte[] bArr2 = segment.data;
            long j15 = size5;
            int iMin2 = (int) Math.min(segment.limit, (((long) segment.pos) + size5) - size);
            i11 = (int) ((((long) segment.pos) + j12) - size);
            while (i11 < iMin2) {
                if (bArr2[i11] == b12 && rangeEquals(segment, i11 + 1, bArrInternalArray$okio2, 1, size4)) {
                }
                i11++;
            }
            size += (long) (segment.limit - segment.pos);
            segment = segment.next;
            Intrinsics.d(segment);
            size5 = j15;
            j12 = size;
        }
        return -1L;
        return ((long) (i11 - segment.pos)) + size;
    }

    public static final long commonIndexOfElement(Buffer commonIndexOfElement, ByteString targetBytes, long j11) {
        int i11;
        int i12;
        Intrinsics.g(commonIndexOfElement, "$this$commonIndexOfElement");
        Intrinsics.g(targetBytes, "targetBytes");
        long size = 0;
        if (!(j11 >= 0)) {
            throw new IllegalArgumentException(("fromIndex < 0: " + j11).toString());
        }
        Segment segment = commonIndexOfElement.head;
        if (segment == null) {
            return -1L;
        }
        if (commonIndexOfElement.size() - j11 < j11) {
            size = commonIndexOfElement.size();
            while (size > j11) {
                segment = segment.prev;
                Intrinsics.d(segment);
                size -= (long) (segment.limit - segment.pos);
            }
            if (targetBytes.size() == 2) {
                byte b11 = targetBytes.getByte(0);
                byte b12 = targetBytes.getByte(1);
                while (size < commonIndexOfElement.size()) {
                    byte[] bArr = segment.data;
                    i11 = (int) ((((long) segment.pos) + j11) - size);
                    int i13 = segment.limit;
                    while (true) {
                        if (i11 >= i13) {
                            size += (long) (segment.limit - segment.pos);
                            segment = segment.next;
                            Intrinsics.d(segment);
                            j11 = size;
                        } else {
                            byte b13 = bArr[i11];
                            if (b13 == b11 || b13 == b12) {
                                i12 = segment.pos;
                            } else {
                                i11++;
                            }
                        }
                    }
                }
            } else {
                byte[] bArrInternalArray$okio = targetBytes.internalArray$okio();
                while (size < commonIndexOfElement.size()) {
                    byte[] bArr2 = segment.data;
                    i11 = (int) ((((long) segment.pos) + j11) - size);
                    int i14 = segment.limit;
                    while (true) {
                        if (i11 < i14) {
                            byte b14 = bArr2[i11];
                            int length = bArrInternalArray$okio.length;
                            int i15 = 0;
                            while (true) {
                                if (i15 >= length) {
                                    i11++;
                                } else if (b14 == bArrInternalArray$okio[i15]) {
                                    i12 = segment.pos;
                                } else {
                                    i15++;
                                }
                            }
                        } else {
                            size += (long) (segment.limit - segment.pos);
                            segment = segment.next;
                            Intrinsics.d(segment);
                            j11 = size;
                        }
                    }
                }
            }
            return -1L;
        }
        while (true) {
            long j12 = ((long) (segment.limit - segment.pos)) + size;
            if (j12 > j11) {
                break;
            }
            segment = segment.next;
            Intrinsics.d(segment);
            size = j12;
        }
        if (targetBytes.size() == 2) {
            byte b15 = targetBytes.getByte(0);
            byte b16 = targetBytes.getByte(1);
            while (size < commonIndexOfElement.size()) {
                byte[] bArr3 = segment.data;
                i11 = (int) ((((long) segment.pos) + j11) - size);
                int i16 = segment.limit;
                while (true) {
                    if (i11 >= i16) {
                        size += (long) (segment.limit - segment.pos);
                        segment = segment.next;
                        Intrinsics.d(segment);
                        j11 = size;
                    } else {
                        byte b17 = bArr3[i11];
                        if (b17 == b15 || b17 == b16) {
                            i12 = segment.pos;
                        } else {
                            i11++;
                        }
                    }
                }
            }
        } else {
            byte[] bArrInternalArray$okio2 = targetBytes.internalArray$okio();
            while (size < commonIndexOfElement.size()) {
                byte[] bArr4 = segment.data;
                i11 = (int) ((((long) segment.pos) + j11) - size);
                int i17 = segment.limit;
                while (true) {
                    if (i11 < i17) {
                        byte b18 = bArr4[i11];
                        int length2 = bArrInternalArray$okio2.length;
                        int i18 = 0;
                        while (true) {
                            if (i18 >= length2) {
                                i11++;
                            } else if (b18 == bArrInternalArray$okio2[i18]) {
                                i12 = segment.pos;
                            } else {
                                i18++;
                            }
                        }
                    } else {
                        size += (long) (segment.limit - segment.pos);
                        segment = segment.next;
                        Intrinsics.d(segment);
                        j11 = size;
                    }
                }
            }
        }
        return -1L;
        return ((long) (i11 - i12)) + size;
    }

    public static final int commonNext(Buffer.UnsafeCursor commonNext) {
        Intrinsics.g(commonNext, "$this$commonNext");
        long j11 = commonNext.offset;
        Buffer buffer = commonNext.buffer;
        Intrinsics.d(buffer);
        if (!(j11 != buffer.size())) {
            throw new IllegalStateException("no more bytes".toString());
        }
        long j12 = commonNext.offset;
        return commonNext.seek(j12 == -1 ? 0L : j12 + ((long) (commonNext.end - commonNext.start)));
    }

    public static final boolean commonRangeEquals(Buffer commonRangeEquals, long j11, ByteString bytes, int i11, int i12) {
        Intrinsics.g(commonRangeEquals, "$this$commonRangeEquals");
        Intrinsics.g(bytes, "bytes");
        if (j11 < 0 || i11 < 0 || i12 < 0 || commonRangeEquals.size() - j11 < i12 || bytes.size() - i11 < i12) {
            return false;
        }
        for (int i13 = 0; i13 < i12; i13++) {
            if (commonRangeEquals.getByte(((long) i13) + j11) != bytes.getByte(i11 + i13)) {
                return false;
            }
        }
        return true;
    }

    public static final int commonRead(Buffer commonRead, byte[] sink) {
        Intrinsics.g(commonRead, "$this$commonRead");
        Intrinsics.g(sink, "sink");
        return commonRead.read(sink, 0, sink.length);
    }

    public static final int commonRead(Buffer commonRead, byte[] sink, int i11, int i12) {
        Intrinsics.g(commonRead, "$this$commonRead");
        Intrinsics.g(sink, "sink");
        Util.checkOffsetAndCount(sink.length, i11, i12);
        Segment segment = commonRead.head;
        if (segment == null) {
            return -1;
        }
        int iMin = Math.min(i12, segment.limit - segment.pos);
        byte[] bArr = segment.data;
        int i13 = segment.pos;
        ArraysKt___ArraysJvmKt.h(bArr, sink, i11, i13, i13 + iMin);
        segment.pos += iMin;
        commonRead.setSize$okio(commonRead.size() - ((long) iMin));
        if (segment.pos == segment.limit) {
            commonRead.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return iMin;
    }

    public static final long commonRead(Buffer commonRead, Buffer sink, long j11) {
        Intrinsics.g(commonRead, "$this$commonRead");
        Intrinsics.g(sink, "sink");
        if (!(j11 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j11).toString());
        }
        if (commonRead.size() == 0) {
            return -1L;
        }
        if (j11 > commonRead.size()) {
            j11 = commonRead.size();
        }
        sink.write(commonRead, j11);
        return j11;
    }

    public static final long commonReadAll(Buffer commonReadAll, Sink sink) throws IOException {
        Intrinsics.g(commonReadAll, "$this$commonReadAll");
        Intrinsics.g(sink, "sink");
        long size = commonReadAll.size();
        if (size > 0) {
            sink.write(commonReadAll, size);
        }
        return size;
    }

    public static final Buffer.UnsafeCursor commonReadAndWriteUnsafe(Buffer commonReadAndWriteUnsafe, Buffer.UnsafeCursor unsafeCursor) {
        Intrinsics.g(commonReadAndWriteUnsafe, "$this$commonReadAndWriteUnsafe");
        Intrinsics.g(unsafeCursor, "unsafeCursor");
        if (!(unsafeCursor.buffer == null)) {
            throw new IllegalStateException("already attached to a buffer".toString());
        }
        unsafeCursor.buffer = commonReadAndWriteUnsafe;
        unsafeCursor.readWrite = true;
        return unsafeCursor;
    }

    public static final byte commonReadByte(Buffer commonReadByte) throws EOFException {
        Intrinsics.g(commonReadByte, "$this$commonReadByte");
        if (commonReadByte.size() == 0) {
            throw new EOFException();
        }
        Segment segment = commonReadByte.head;
        Intrinsics.d(segment);
        int i11 = segment.pos;
        int i12 = segment.limit;
        int i13 = i11 + 1;
        byte b11 = segment.data[i11];
        commonReadByte.setSize$okio(commonReadByte.size() - 1);
        if (i13 == i12) {
            commonReadByte.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = i13;
        }
        return b11;
    }

    public static final byte[] commonReadByteArray(Buffer commonReadByteArray) {
        Intrinsics.g(commonReadByteArray, "$this$commonReadByteArray");
        return commonReadByteArray.readByteArray(commonReadByteArray.size());
    }

    public static final byte[] commonReadByteArray(Buffer commonReadByteArray, long j11) throws EOFException {
        Intrinsics.g(commonReadByteArray, "$this$commonReadByteArray");
        if (!(j11 >= 0 && j11 <= ((long) Api.BaseClientBuilder.API_PRIORITY_OTHER))) {
            throw new IllegalArgumentException(("byteCount: " + j11).toString());
        }
        if (commonReadByteArray.size() < j11) {
            throw new EOFException();
        }
        byte[] bArr = new byte[(int) j11];
        commonReadByteArray.readFully(bArr);
        return bArr;
    }

    public static final ByteString commonReadByteString(Buffer commonReadByteString) {
        Intrinsics.g(commonReadByteString, "$this$commonReadByteString");
        return commonReadByteString.readByteString(commonReadByteString.size());
    }

    public static final ByteString commonReadByteString(Buffer commonReadByteString, long j11) throws EOFException {
        Intrinsics.g(commonReadByteString, "$this$commonReadByteString");
        if (!(j11 >= 0 && j11 <= ((long) Api.BaseClientBuilder.API_PRIORITY_OTHER))) {
            throw new IllegalArgumentException(("byteCount: " + j11).toString());
        }
        if (commonReadByteString.size() < j11) {
            throw new EOFException();
        }
        if (j11 < 4096) {
            return new ByteString(commonReadByteString.readByteArray(j11));
        }
        ByteString byteStringSnapshot = commonReadByteString.snapshot((int) j11);
        commonReadByteString.skip(j11);
        return byteStringSnapshot;
    }

    public static final long commonReadDecimalLong(Buffer commonReadDecimalLong) throws EOFException {
        Intrinsics.g(commonReadDecimalLong, "$this$commonReadDecimalLong");
        if (commonReadDecimalLong.size() == 0) {
            throw new EOFException();
        }
        int i11 = 0;
        long j11 = -7;
        boolean z11 = false;
        long j12 = 0;
        boolean z12 = false;
        do {
            Segment segment = commonReadDecimalLong.head;
            Intrinsics.d(segment);
            byte[] bArr = segment.data;
            int i12 = segment.pos;
            int i13 = segment.limit;
            while (i12 < i13) {
                byte b11 = bArr[i12];
                byte b12 = (byte) 48;
                if (b11 >= b12 && b11 <= ((byte) 57)) {
                    int i14 = b12 - b11;
                    if (j12 < OVERFLOW_ZONE || (j12 == OVERFLOW_ZONE && i14 < j11)) {
                        Buffer bufferWriteByte = new Buffer().writeDecimalLong(j12).writeByte((int) b11);
                        if (!z11) {
                            bufferWriteByte.readByte();
                        }
                        throw new NumberFormatException("Number too large: " + bufferWriteByte.readUtf8());
                    }
                    j12 = (j12 * 10) + ((long) i14);
                } else {
                    if (b11 != ((byte) 45) || i11 != 0) {
                        if (i11 != 0) {
                            z12 = true;
                            break;
                        }
                        throw new NumberFormatException("Expected leading [0-9] or '-' character but was 0x" + Util.toHexString(b11));
                    }
                    j11--;
                    z11 = true;
                }
                i12++;
                i11++;
            }
            if (i12 == i13) {
                commonReadDecimalLong.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i12;
            }
            if (z12) {
                break;
            }
        } while (commonReadDecimalLong.head != null);
        commonReadDecimalLong.setSize$okio(commonReadDecimalLong.size() - ((long) i11));
        return z11 ? j12 : -j12;
    }

    public static final void commonReadFully(Buffer commonReadFully, Buffer sink, long j11) throws EOFException {
        Intrinsics.g(commonReadFully, "$this$commonReadFully");
        Intrinsics.g(sink, "sink");
        if (commonReadFully.size() >= j11) {
            sink.write(commonReadFully, j11);
        } else {
            sink.write(commonReadFully, commonReadFully.size());
            throw new EOFException();
        }
    }

    public static final void commonReadFully(Buffer commonReadFully, byte[] sink) throws EOFException {
        Intrinsics.g(commonReadFully, "$this$commonReadFully");
        Intrinsics.g(sink, "sink");
        int i11 = 0;
        while (i11 < sink.length) {
            int i12 = commonReadFully.read(sink, i11, sink.length - i11);
            if (i12 == -1) {
                throw new EOFException();
            }
            i11 += i12;
        }
    }

    public static final long commonReadHexadecimalUnsignedLong(Buffer commonReadHexadecimalUnsignedLong) throws EOFException {
        int i11;
        Intrinsics.g(commonReadHexadecimalUnsignedLong, "$this$commonReadHexadecimalUnsignedLong");
        if (commonReadHexadecimalUnsignedLong.size() == 0) {
            throw new EOFException();
        }
        int i12 = 0;
        long j11 = 0;
        boolean z11 = false;
        do {
            Segment segment = commonReadHexadecimalUnsignedLong.head;
            Intrinsics.d(segment);
            byte[] bArr = segment.data;
            int i13 = segment.pos;
            int i14 = segment.limit;
            while (i13 < i14) {
                byte b11 = bArr[i13];
                byte b12 = (byte) 48;
                if (b11 < b12 || b11 > ((byte) 57)) {
                    byte b13 = (byte) 97;
                    if ((b11 < b13 || b11 > ((byte) 102)) && (b11 < (b13 = (byte) 65) || b11 > ((byte) 70))) {
                        if (i12 != 0) {
                            z11 = true;
                            break;
                        }
                        throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + Util.toHexString(b11));
                    }
                    i11 = (b11 - b13) + 10;
                } else {
                    i11 = b11 - b12;
                }
                if (((-1152921504606846976L) & j11) != 0) {
                    throw new NumberFormatException("Number too large: " + new Buffer().writeHexadecimalUnsignedLong(j11).writeByte((int) b11).readUtf8());
                }
                j11 = (j11 << 4) | ((long) i11);
                i13++;
                i12++;
            }
            if (i13 == i14) {
                commonReadHexadecimalUnsignedLong.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i13;
            }
            if (z11) {
                break;
            }
        } while (commonReadHexadecimalUnsignedLong.head != null);
        commonReadHexadecimalUnsignedLong.setSize$okio(commonReadHexadecimalUnsignedLong.size() - ((long) i12));
        return j11;
    }

    public static final int commonReadInt(Buffer commonReadInt) throws EOFException {
        Intrinsics.g(commonReadInt, "$this$commonReadInt");
        if (commonReadInt.size() < 4) {
            throw new EOFException();
        }
        Segment segment = commonReadInt.head;
        Intrinsics.d(segment);
        int i11 = segment.pos;
        int i12 = segment.limit;
        if (i12 - i11 < 4) {
            return (commonReadInt.readByte() & 255) | ((commonReadInt.readByte() & 255) << 24) | ((commonReadInt.readByte() & 255) << 16) | ((commonReadInt.readByte() & 255) << 8);
        }
        byte[] bArr = segment.data;
        int i13 = i11 + 3;
        int i14 = ((bArr[i11 + 1] & 255) << 16) | ((bArr[i11] & 255) << 24) | ((bArr[i11 + 2] & 255) << 8);
        int i15 = i11 + 4;
        int i16 = (bArr[i13] & 255) | i14;
        commonReadInt.setSize$okio(commonReadInt.size() - 4);
        if (i15 == i12) {
            commonReadInt.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = i15;
        }
        return i16;
    }

    public static final long commonReadLong(Buffer commonReadLong) throws EOFException {
        Intrinsics.g(commonReadLong, "$this$commonReadLong");
        if (commonReadLong.size() < 8) {
            throw new EOFException();
        }
        Segment segment = commonReadLong.head;
        Intrinsics.d(segment);
        int i11 = segment.pos;
        int i12 = segment.limit;
        if (i12 - i11 < 8) {
            return ((((long) commonReadLong.readInt()) & 4294967295L) << 32) | (4294967295L & ((long) commonReadLong.readInt()));
        }
        byte[] bArr = segment.data;
        int i13 = i11 + 7;
        long j11 = ((((long) bArr[i11 + 3]) & 255) << 32) | ((((long) bArr[i11]) & 255) << 56) | ((((long) bArr[i11 + 1]) & 255) << 48) | ((((long) bArr[i11 + 2]) & 255) << 40) | ((((long) bArr[i11 + 4]) & 255) << 24) | ((((long) bArr[i11 + 5]) & 255) << 16) | ((((long) bArr[i11 + 6]) & 255) << 8);
        int i14 = i11 + 8;
        long j12 = j11 | (((long) bArr[i13]) & 255);
        commonReadLong.setSize$okio(commonReadLong.size() - 8);
        if (i14 == i12) {
            commonReadLong.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = i14;
        }
        return j12;
    }

    public static final short commonReadShort(Buffer commonReadShort) throws EOFException {
        Intrinsics.g(commonReadShort, "$this$commonReadShort");
        if (commonReadShort.size() < 2) {
            throw new EOFException();
        }
        Segment segment = commonReadShort.head;
        Intrinsics.d(segment);
        int i11 = segment.pos;
        int i12 = segment.limit;
        if (i12 - i11 < 2) {
            return (short) ((commonReadShort.readByte() & 255) | ((commonReadShort.readByte() & 255) << 8));
        }
        byte[] bArr = segment.data;
        int i13 = i11 + 1;
        int i14 = (bArr[i11] & 255) << 8;
        int i15 = i11 + 2;
        int i16 = (bArr[i13] & 255) | i14;
        commonReadShort.setSize$okio(commonReadShort.size() - 2);
        if (i15 == i12) {
            commonReadShort.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = i15;
        }
        return (short) i16;
    }

    public static final Buffer.UnsafeCursor commonReadUnsafe(Buffer commonReadUnsafe, Buffer.UnsafeCursor unsafeCursor) {
        Intrinsics.g(commonReadUnsafe, "$this$commonReadUnsafe");
        Intrinsics.g(unsafeCursor, "unsafeCursor");
        if (!(unsafeCursor.buffer == null)) {
            throw new IllegalStateException("already attached to a buffer".toString());
        }
        unsafeCursor.buffer = commonReadUnsafe;
        unsafeCursor.readWrite = false;
        return unsafeCursor;
    }

    public static final String commonReadUtf8(Buffer commonReadUtf8, long j11) throws EOFException {
        Intrinsics.g(commonReadUtf8, "$this$commonReadUtf8");
        if (!(j11 >= 0 && j11 <= ((long) Api.BaseClientBuilder.API_PRIORITY_OTHER))) {
            throw new IllegalArgumentException(("byteCount: " + j11).toString());
        }
        if (commonReadUtf8.size() < j11) {
            throw new EOFException();
        }
        if (j11 == 0) {
            return "";
        }
        Segment segment = commonReadUtf8.head;
        Intrinsics.d(segment);
        int i11 = segment.pos;
        if (((long) i11) + j11 > segment.limit) {
            return _Utf8Kt.commonToUtf8String$default(commonReadUtf8.readByteArray(j11), 0, 0, 3, null);
        }
        int i12 = (int) j11;
        String strCommonToUtf8String = _Utf8Kt.commonToUtf8String(segment.data, i11, i11 + i12);
        segment.pos += i12;
        commonReadUtf8.setSize$okio(commonReadUtf8.size() - j11);
        if (segment.pos == segment.limit) {
            commonReadUtf8.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return strCommonToUtf8String;
    }

    public static final int commonReadUtf8CodePoint(Buffer commonReadUtf8CodePoint) throws EOFException {
        int i11;
        int i12;
        int i13;
        Intrinsics.g(commonReadUtf8CodePoint, "$this$commonReadUtf8CodePoint");
        if (commonReadUtf8CodePoint.size() == 0) {
            throw new EOFException();
        }
        byte b11 = commonReadUtf8CodePoint.getByte(0L);
        if ((b11 & 128) == 0) {
            i11 = b11 & Ascii.DEL;
            i12 = 1;
            i13 = 0;
        } else if ((b11 & 224) == 192) {
            i11 = b11 & Ascii.US;
            i12 = 2;
            i13 = 128;
        } else if ((b11 & 240) == 224) {
            i11 = b11 & Ascii.SI;
            i12 = 3;
            i13 = 2048;
        } else {
            if ((b11 & 248) != 240) {
                commonReadUtf8CodePoint.skip(1L);
                return Utf8.REPLACEMENT_CODE_POINT;
            }
            i11 = b11 & 7;
            i12 = 4;
            i13 = 65536;
        }
        long j11 = i12;
        if (commonReadUtf8CodePoint.size() < j11) {
            throw new EOFException("size < " + i12 + ": " + commonReadUtf8CodePoint.size() + " (to read code point prefixed 0x" + Util.toHexString(b11) + ')');
        }
        for (int i14 = 1; i14 < i12; i14++) {
            long j12 = i14;
            byte b12 = commonReadUtf8CodePoint.getByte(j12);
            if ((b12 & 192) != 128) {
                commonReadUtf8CodePoint.skip(j12);
                return Utf8.REPLACEMENT_CODE_POINT;
            }
            i11 = (i11 << 6) | (b12 & Utf8.REPLACEMENT_BYTE);
        }
        commonReadUtf8CodePoint.skip(j11);
        if (i11 > 1114111) {
            return Utf8.REPLACEMENT_CODE_POINT;
        }
        return ((55296 <= i11 && 57343 >= i11) || i11 < i13) ? Utf8.REPLACEMENT_CODE_POINT : i11;
    }

    public static final String commonReadUtf8Line(Buffer commonReadUtf8Line) {
        Intrinsics.g(commonReadUtf8Line, "$this$commonReadUtf8Line");
        long jIndexOf = commonReadUtf8Line.indexOf((byte) 10);
        if (jIndexOf != -1) {
            return readUtf8Line(commonReadUtf8Line, jIndexOf);
        }
        if (commonReadUtf8Line.size() != 0) {
            return commonReadUtf8Line.readUtf8(commonReadUtf8Line.size());
        }
        return null;
    }

    public static final String commonReadUtf8LineStrict(Buffer commonReadUtf8LineStrict, long j11) throws EOFException {
        Intrinsics.g(commonReadUtf8LineStrict, "$this$commonReadUtf8LineStrict");
        if (!(j11 >= 0)) {
            throw new IllegalArgumentException(("limit < 0: " + j11).toString());
        }
        long j12 = j11 != Long.MAX_VALUE ? j11 + 1 : Long.MAX_VALUE;
        byte b11 = (byte) 10;
        long jIndexOf = commonReadUtf8LineStrict.indexOf(b11, 0L, j12);
        if (jIndexOf != -1) {
            return readUtf8Line(commonReadUtf8LineStrict, jIndexOf);
        }
        if (j12 < commonReadUtf8LineStrict.size() && commonReadUtf8LineStrict.getByte(j12 - 1) == ((byte) 13) && commonReadUtf8LineStrict.getByte(j12) == b11) {
            return readUtf8Line(commonReadUtf8LineStrict, j12);
        }
        Buffer buffer = new Buffer();
        commonReadUtf8LineStrict.copyTo(buffer, 0L, Math.min(32, commonReadUtf8LineStrict.size()));
        throw new EOFException("\\n not found: limit=" + Math.min(commonReadUtf8LineStrict.size(), j11) + " content=" + buffer.readByteString().hex() + (char) 8230);
    }

    public static final long commonResizeBuffer(Buffer.UnsafeCursor commonResizeBuffer, long j11) {
        Intrinsics.g(commonResizeBuffer, "$this$commonResizeBuffer");
        Buffer buffer = commonResizeBuffer.buffer;
        if (buffer == null) {
            throw new IllegalStateException("not attached to a buffer".toString());
        }
        if (!commonResizeBuffer.readWrite) {
            throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers".toString());
        }
        long size = buffer.size();
        int i11 = 1;
        if (j11 <= size) {
            if (!(j11 >= 0)) {
                throw new IllegalArgumentException(("newSize < 0: " + j11).toString());
            }
            long j12 = size - j11;
            while (j12 > 0) {
                Segment segment = buffer.head;
                Intrinsics.d(segment);
                Segment segment2 = segment.prev;
                Intrinsics.d(segment2);
                int i12 = segment2.limit;
                long j13 = i12 - segment2.pos;
                if (j13 > j12) {
                    segment2.limit = i12 - ((int) j12);
                    break;
                }
                buffer.head = segment2.pop();
                SegmentPool.recycle(segment2);
                j12 -= j13;
            }
            commonResizeBuffer.setSegment$okio(null);
            commonResizeBuffer.offset = j11;
            commonResizeBuffer.data = null;
            commonResizeBuffer.start = -1;
            commonResizeBuffer.end = -1;
        } else if (j11 > size) {
            long j14 = j11 - size;
            boolean z11 = true;
            while (j14 > 0) {
                Segment segmentWritableSegment$okio = buffer.writableSegment$okio(i11);
                int iMin = (int) Math.min(j14, 8192 - segmentWritableSegment$okio.limit);
                segmentWritableSegment$okio.limit += iMin;
                j14 -= (long) iMin;
                if (z11) {
                    commonResizeBuffer.setSegment$okio(segmentWritableSegment$okio);
                    commonResizeBuffer.offset = size;
                    commonResizeBuffer.data = segmentWritableSegment$okio.data;
                    int i13 = segmentWritableSegment$okio.limit;
                    commonResizeBuffer.start = i13 - iMin;
                    commonResizeBuffer.end = i13;
                    z11 = false;
                }
                i11 = 1;
            }
        }
        buffer.setSize$okio(j11);
        return size;
    }

    public static final int commonSeek(Buffer.UnsafeCursor commonSeek, long j11) {
        Segment segmentPush;
        Intrinsics.g(commonSeek, "$this$commonSeek");
        Buffer buffer = commonSeek.buffer;
        if (buffer == null) {
            throw new IllegalStateException("not attached to a buffer".toString());
        }
        if (j11 < -1 || j11 > buffer.size()) {
            throw new ArrayIndexOutOfBoundsException("offset=" + j11 + " > size=" + buffer.size());
        }
        if (j11 == -1 || j11 == buffer.size()) {
            commonSeek.setSegment$okio(null);
            commonSeek.offset = j11;
            commonSeek.data = null;
            commonSeek.start = -1;
            commonSeek.end = -1;
            return -1;
        }
        long size = buffer.size();
        Segment segment$okio = buffer.head;
        long j12 = 0;
        if (commonSeek.getSegment$okio() != null) {
            long j13 = commonSeek.offset;
            int i11 = commonSeek.start;
            Segment segment$okio2 = commonSeek.getSegment$okio();
            Intrinsics.d(segment$okio2);
            long j14 = j13 - ((long) (i11 - segment$okio2.pos));
            if (j14 > j11) {
                segmentPush = segment$okio;
                segment$okio = commonSeek.getSegment$okio();
                size = j14;
            } else {
                segmentPush = commonSeek.getSegment$okio();
                j12 = j14;
            }
        } else {
            segmentPush = segment$okio;
        }
        if (size - j11 > j11 - j12) {
            while (true) {
                Intrinsics.d(segmentPush);
                int i12 = segmentPush.limit;
                int i13 = segmentPush.pos;
                if (j11 < ((long) (i12 - i13)) + j12) {
                    break;
                }
                j12 += (long) (i12 - i13);
                segmentPush = segmentPush.next;
            }
        } else {
            while (size > j11) {
                Intrinsics.d(segment$okio);
                segment$okio = segment$okio.prev;
                Intrinsics.d(segment$okio);
                size -= (long) (segment$okio.limit - segment$okio.pos);
            }
            j12 = size;
            segmentPush = segment$okio;
        }
        if (commonSeek.readWrite) {
            Intrinsics.d(segmentPush);
            if (segmentPush.shared) {
                Segment segmentUnsharedCopy = segmentPush.unsharedCopy();
                if (buffer.head == segmentPush) {
                    buffer.head = segmentUnsharedCopy;
                }
                segmentPush = segmentPush.push(segmentUnsharedCopy);
                Segment segment = segmentPush.prev;
                Intrinsics.d(segment);
                segment.pop();
            }
        }
        commonSeek.setSegment$okio(segmentPush);
        commonSeek.offset = j11;
        Intrinsics.d(segmentPush);
        commonSeek.data = segmentPush.data;
        int i14 = segmentPush.pos + ((int) (j11 - j12));
        commonSeek.start = i14;
        int i15 = segmentPush.limit;
        commonSeek.end = i15;
        return i15 - i14;
    }

    public static final int commonSelect(Buffer commonSelect, Options options) throws EOFException {
        Intrinsics.g(commonSelect, "$this$commonSelect");
        Intrinsics.g(options, "options");
        int iSelectPrefix$default = selectPrefix$default(commonSelect, options, false, 2, null);
        if (iSelectPrefix$default == -1) {
            return -1;
        }
        commonSelect.skip(options.getByteStrings$okio()[iSelectPrefix$default].size());
        return iSelectPrefix$default;
    }

    public static final void commonSkip(Buffer commonSkip, long j11) throws EOFException {
        Intrinsics.g(commonSkip, "$this$commonSkip");
        while (j11 > 0) {
            Segment segment = commonSkip.head;
            if (segment == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j11, segment.limit - segment.pos);
            long j12 = iMin;
            commonSkip.setSize$okio(commonSkip.size() - j12);
            j11 -= j12;
            int i11 = segment.pos + iMin;
            segment.pos = i11;
            if (i11 == segment.limit) {
                commonSkip.head = segment.pop();
                SegmentPool.recycle(segment);
            }
        }
    }

    public static final ByteString commonSnapshot(Buffer commonSnapshot) {
        Intrinsics.g(commonSnapshot, "$this$commonSnapshot");
        if (commonSnapshot.size() <= ((long) Api.BaseClientBuilder.API_PRIORITY_OTHER)) {
            return commonSnapshot.snapshot((int) commonSnapshot.size());
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + commonSnapshot.size()).toString());
    }

    public static final ByteString commonSnapshot(Buffer commonSnapshot, int i11) {
        Intrinsics.g(commonSnapshot, "$this$commonSnapshot");
        if (i11 == 0) {
            return ByteString.EMPTY;
        }
        Util.checkOffsetAndCount(commonSnapshot.size(), 0L, i11);
        Segment segment = commonSnapshot.head;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i13 < i11) {
            Intrinsics.d(segment);
            int i15 = segment.limit;
            int i16 = segment.pos;
            if (i15 == i16) {
                throw new AssertionError("s.limit == s.pos");
            }
            i13 += i15 - i16;
            i14++;
            segment = segment.next;
        }
        byte[][] bArr = new byte[i14][];
        int[] iArr = new int[i14 * 2];
        Segment segment2 = commonSnapshot.head;
        int i17 = 0;
        while (i12 < i11) {
            Intrinsics.d(segment2);
            bArr[i17] = segment2.data;
            i12 += segment2.limit - segment2.pos;
            iArr[i17] = Math.min(i12, i11);
            iArr[i17 + i14] = segment2.pos;
            segment2.shared = true;
            i17++;
            segment2 = segment2.next;
        }
        return new SegmentedByteString(bArr, iArr);
    }

    public static final Segment commonWritableSegment(Buffer commonWritableSegment, int i11) {
        Intrinsics.g(commonWritableSegment, "$this$commonWritableSegment");
        if (!(i11 >= 1 && i11 <= 8192)) {
            throw new IllegalArgumentException("unexpected capacity".toString());
        }
        Segment segment = commonWritableSegment.head;
        if (segment != null) {
            Intrinsics.d(segment);
            Segment segment2 = segment.prev;
            Intrinsics.d(segment2);
            return (segment2.limit + i11 > 8192 || !segment2.owner) ? segment2.push(SegmentPool.take()) : segment2;
        }
        Segment segmentTake = SegmentPool.take();
        commonWritableSegment.head = segmentTake;
        segmentTake.prev = segmentTake;
        segmentTake.next = segmentTake;
        return segmentTake;
    }

    public static final Buffer commonWrite(Buffer commonWrite, ByteString byteString, int i11, int i12) {
        Intrinsics.g(commonWrite, "$this$commonWrite");
        Intrinsics.g(byteString, "byteString");
        byteString.write$okio(commonWrite, i11, i12);
        return commonWrite;
    }

    public static final Buffer commonWrite(Buffer commonWrite, Source source, long j11) throws IOException {
        Intrinsics.g(commonWrite, "$this$commonWrite");
        Intrinsics.g(source, "source");
        while (j11 > 0) {
            long j12 = source.read(commonWrite, j11);
            if (j12 == -1) {
                throw new EOFException();
            }
            j11 -= j12;
        }
        return commonWrite;
    }

    public static final Buffer commonWrite(Buffer commonWrite, byte[] source) {
        Intrinsics.g(commonWrite, "$this$commonWrite");
        Intrinsics.g(source, "source");
        return commonWrite.write(source, 0, source.length);
    }

    public static final Buffer commonWrite(Buffer commonWrite, byte[] source, int i11, int i12) {
        Intrinsics.g(commonWrite, "$this$commonWrite");
        Intrinsics.g(source, "source");
        long j11 = i12;
        Util.checkOffsetAndCount(source.length, i11, j11);
        int i13 = i12 + i11;
        while (i11 < i13) {
            Segment segmentWritableSegment$okio = commonWrite.writableSegment$okio(1);
            int iMin = Math.min(i13 - i11, 8192 - segmentWritableSegment$okio.limit);
            int i14 = i11 + iMin;
            ArraysKt___ArraysJvmKt.h(source, segmentWritableSegment$okio.data, segmentWritableSegment$okio.limit, i11, i14);
            segmentWritableSegment$okio.limit += iMin;
            i11 = i14;
        }
        commonWrite.setSize$okio(commonWrite.size() + j11);
        return commonWrite;
    }

    public static final void commonWrite(Buffer commonWrite, Buffer source, long j11) {
        Segment segment;
        Intrinsics.g(commonWrite, "$this$commonWrite");
        Intrinsics.g(source, "source");
        if (!(source != commonWrite)) {
            throw new IllegalArgumentException("source == this".toString());
        }
        Util.checkOffsetAndCount(source.size(), 0L, j11);
        while (j11 > 0) {
            Segment segment2 = source.head;
            Intrinsics.d(segment2);
            int i11 = segment2.limit;
            Segment segment3 = source.head;
            Intrinsics.d(segment3);
            if (j11 < i11 - segment3.pos) {
                Segment segment4 = commonWrite.head;
                if (segment4 != null) {
                    Intrinsics.d(segment4);
                    segment = segment4.prev;
                } else {
                    segment = null;
                }
                if (segment != null && segment.owner) {
                    if ((((long) segment.limit) + j11) - ((long) (segment.shared ? 0 : segment.pos)) <= 8192) {
                        Segment segment5 = source.head;
                        Intrinsics.d(segment5);
                        segment5.writeTo(segment, (int) j11);
                        source.setSize$okio(source.size() - j11);
                        commonWrite.setSize$okio(commonWrite.size() + j11);
                        return;
                    }
                }
                Segment segment6 = source.head;
                Intrinsics.d(segment6);
                source.head = segment6.split((int) j11);
            }
            Segment segment7 = source.head;
            Intrinsics.d(segment7);
            long j12 = segment7.limit - segment7.pos;
            source.head = segment7.pop();
            Segment segment8 = commonWrite.head;
            if (segment8 == null) {
                commonWrite.head = segment7;
                segment7.prev = segment7;
                segment7.next = segment7;
            } else {
                Intrinsics.d(segment8);
                Segment segment9 = segment8.prev;
                Intrinsics.d(segment9);
                segment9.push(segment7).compact();
            }
            source.setSize$okio(source.size() - j12);
            commonWrite.setSize$okio(commonWrite.size() + j12);
            j11 -= j12;
        }
    }

    public static /* synthetic */ Buffer commonWrite$default(Buffer commonWrite, ByteString byteString, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i11 = 0;
        }
        if ((i13 & 4) != 0) {
            i12 = byteString.size();
        }
        Intrinsics.g(commonWrite, "$this$commonWrite");
        Intrinsics.g(byteString, "byteString");
        byteString.write$okio(commonWrite, i11, i12);
        return commonWrite;
    }

    public static final long commonWriteAll(Buffer commonWriteAll, Source source) throws IOException {
        Intrinsics.g(commonWriteAll, "$this$commonWriteAll");
        Intrinsics.g(source, "source");
        long j11 = 0;
        while (true) {
            long j12 = source.read(commonWriteAll, 8192);
            if (j12 == -1) {
                return j11;
            }
            j11 += j12;
        }
    }

    public static final Buffer commonWriteByte(Buffer commonWriteByte, int i11) {
        Intrinsics.g(commonWriteByte, "$this$commonWriteByte");
        Segment segmentWritableSegment$okio = commonWriteByte.writableSegment$okio(1);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i12 = segmentWritableSegment$okio.limit;
        segmentWritableSegment$okio.limit = i12 + 1;
        bArr[i12] = (byte) i11;
        commonWriteByte.setSize$okio(commonWriteByte.size() + 1);
        return commonWriteByte;
    }

    public static final Buffer commonWriteDecimalLong(Buffer commonWriteDecimalLong, long j11) {
        boolean z11;
        Intrinsics.g(commonWriteDecimalLong, "$this$commonWriteDecimalLong");
        if (j11 == 0) {
            return commonWriteDecimalLong.writeByte(48);
        }
        int i11 = 1;
        if (j11 < 0) {
            j11 = -j11;
            if (j11 < 0) {
                return commonWriteDecimalLong.writeUtf8("-9223372036854775808");
            }
            z11 = true;
        } else {
            z11 = false;
        }
        if (j11 < 100000000) {
            if (j11 < 10000) {
                if (j11 >= 100) {
                    i11 = j11 < 1000 ? 3 : 4;
                } else if (j11 >= 10) {
                    i11 = 2;
                }
            } else if (j11 < 1000000) {
                i11 = j11 < 100000 ? 5 : 6;
            } else {
                i11 = j11 < 10000000 ? 7 : 8;
            }
        } else if (j11 < 1000000000000L) {
            if (j11 < RealConnection.IDLE_CONNECTION_HEALTHY_NS) {
                i11 = j11 < C.NANOS_PER_SECOND ? 9 : 10;
            } else {
                i11 = j11 < 100000000000L ? 11 : 12;
            }
        } else if (j11 < 1000000000000000L) {
            if (j11 < 10000000000000L) {
                i11 = 13;
            } else {
                i11 = j11 < 100000000000000L ? 14 : 15;
            }
        } else if (j11 < 100000000000000000L) {
            i11 = j11 < 10000000000000000L ? 16 : 17;
        } else {
            i11 = j11 < 1000000000000000000L ? 18 : 19;
        }
        if (z11) {
            i11++;
        }
        Segment segmentWritableSegment$okio = commonWriteDecimalLong.writableSegment$okio(i11);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i12 = segmentWritableSegment$okio.limit + i11;
        while (j11 != 0) {
            long j12 = 10;
            i12--;
            bArr[i12] = getHEX_DIGIT_BYTES()[(int) (j11 % j12)];
            j11 /= j12;
        }
        if (z11) {
            bArr[i12 - 1] = (byte) 45;
        }
        segmentWritableSegment$okio.limit += i11;
        commonWriteDecimalLong.setSize$okio(commonWriteDecimalLong.size() + ((long) i11));
        return commonWriteDecimalLong;
    }

    public static final Buffer commonWriteHexadecimalUnsignedLong(Buffer commonWriteHexadecimalUnsignedLong, long j11) {
        Intrinsics.g(commonWriteHexadecimalUnsignedLong, "$this$commonWriteHexadecimalUnsignedLong");
        if (j11 == 0) {
            return commonWriteHexadecimalUnsignedLong.writeByte(48);
        }
        long j12 = (j11 >>> 1) | j11;
        long j13 = j12 | (j12 >>> 2);
        long j14 = j13 | (j13 >>> 4);
        long j15 = j14 | (j14 >>> 8);
        long j16 = j15 | (j15 >>> 16);
        long j17 = j16 | (j16 >>> 32);
        long j18 = j17 - ((j17 >>> 1) & 6148914691236517205L);
        long j19 = ((j18 >>> 2) & 3689348814741910323L) + (j18 & 3689348814741910323L);
        long j21 = ((j19 >>> 4) + j19) & 1085102592571150095L;
        long j22 = j21 + (j21 >>> 8);
        long j23 = j22 + (j22 >>> 16);
        int i11 = (int) ((((j23 & 63) + ((j23 >>> 32) & 63)) + ((long) 3)) / ((long) 4));
        Segment segmentWritableSegment$okio = commonWriteHexadecimalUnsignedLong.writableSegment$okio(i11);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i12 = segmentWritableSegment$okio.limit;
        for (int i13 = (i12 + i11) - 1; i13 >= i12; i13--) {
            bArr[i13] = getHEX_DIGIT_BYTES()[(int) (15 & j11)];
            j11 >>>= 4;
        }
        segmentWritableSegment$okio.limit += i11;
        commonWriteHexadecimalUnsignedLong.setSize$okio(commonWriteHexadecimalUnsignedLong.size() + ((long) i11));
        return commonWriteHexadecimalUnsignedLong;
    }

    public static final Buffer commonWriteInt(Buffer commonWriteInt, int i11) {
        Intrinsics.g(commonWriteInt, "$this$commonWriteInt");
        Segment segmentWritableSegment$okio = commonWriteInt.writableSegment$okio(4);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i12 = segmentWritableSegment$okio.limit;
        bArr[i12] = (byte) ((i11 >>> 24) & 255);
        bArr[i12 + 1] = (byte) ((i11 >>> 16) & 255);
        bArr[i12 + 2] = (byte) ((i11 >>> 8) & 255);
        bArr[i12 + 3] = (byte) (i11 & 255);
        segmentWritableSegment$okio.limit = i12 + 4;
        commonWriteInt.setSize$okio(commonWriteInt.size() + 4);
        return commonWriteInt;
    }

    public static final Buffer commonWriteLong(Buffer commonWriteLong, long j11) {
        Intrinsics.g(commonWriteLong, "$this$commonWriteLong");
        Segment segmentWritableSegment$okio = commonWriteLong.writableSegment$okio(8);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i11 = segmentWritableSegment$okio.limit;
        bArr[i11] = (byte) ((j11 >>> 56) & 255);
        bArr[i11 + 1] = (byte) ((j11 >>> 48) & 255);
        bArr[i11 + 2] = (byte) ((j11 >>> 40) & 255);
        bArr[i11 + 3] = (byte) ((j11 >>> 32) & 255);
        bArr[i11 + 4] = (byte) ((j11 >>> 24) & 255);
        bArr[i11 + 5] = (byte) ((j11 >>> 16) & 255);
        bArr[i11 + 6] = (byte) ((j11 >>> 8) & 255);
        bArr[i11 + 7] = (byte) (j11 & 255);
        segmentWritableSegment$okio.limit = i11 + 8;
        commonWriteLong.setSize$okio(commonWriteLong.size() + 8);
        return commonWriteLong;
    }

    public static final Buffer commonWriteShort(Buffer commonWriteShort, int i11) {
        Intrinsics.g(commonWriteShort, "$this$commonWriteShort");
        Segment segmentWritableSegment$okio = commonWriteShort.writableSegment$okio(2);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i12 = segmentWritableSegment$okio.limit;
        bArr[i12] = (byte) ((i11 >>> 8) & 255);
        bArr[i12 + 1] = (byte) (i11 & 255);
        segmentWritableSegment$okio.limit = i12 + 2;
        commonWriteShort.setSize$okio(commonWriteShort.size() + 2);
        return commonWriteShort;
    }

    public static final Buffer commonWriteUtf8(Buffer commonWriteUtf8, String string, int i11, int i12) {
        Intrinsics.g(commonWriteUtf8, "$this$commonWriteUtf8");
        Intrinsics.g(string, "string");
        if (!(i11 >= 0)) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i11).toString());
        }
        if (!(i12 >= i11)) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i12 + " < " + i11).toString());
        }
        if (!(i12 <= string.length())) {
            throw new IllegalArgumentException(("endIndex > string.length: " + i12 + " > " + string.length()).toString());
        }
        while (i11 < i12) {
            char cCharAt = string.charAt(i11);
            if (cCharAt < 128) {
                Segment segmentWritableSegment$okio = commonWriteUtf8.writableSegment$okio(1);
                byte[] bArr = segmentWritableSegment$okio.data;
                int i13 = segmentWritableSegment$okio.limit - i11;
                int iMin = Math.min(i12, 8192 - i13);
                int i14 = i11 + 1;
                bArr[i11 + i13] = (byte) cCharAt;
                while (i14 < iMin) {
                    char cCharAt2 = string.charAt(i14);
                    if (cCharAt2 >= 128) {
                        break;
                    }
                    bArr[i14 + i13] = (byte) cCharAt2;
                    i14++;
                }
                int i15 = segmentWritableSegment$okio.limit;
                int i16 = (i13 + i14) - i15;
                segmentWritableSegment$okio.limit = i15 + i16;
                commonWriteUtf8.setSize$okio(commonWriteUtf8.size() + ((long) i16));
                i11 = i14;
            } else {
                if (cCharAt < 2048) {
                    Segment segmentWritableSegment$okio2 = commonWriteUtf8.writableSegment$okio(2);
                    byte[] bArr2 = segmentWritableSegment$okio2.data;
                    int i17 = segmentWritableSegment$okio2.limit;
                    bArr2[i17] = (byte) ((cCharAt >> 6) | PsExtractor.AUDIO_STREAM);
                    bArr2[i17 + 1] = (byte) ((cCharAt & '?') | 128);
                    segmentWritableSegment$okio2.limit = i17 + 2;
                    commonWriteUtf8.setSize$okio(commonWriteUtf8.size() + 2);
                } else if (cCharAt < 55296 || cCharAt > 57343) {
                    Segment segmentWritableSegment$okio3 = commonWriteUtf8.writableSegment$okio(3);
                    byte[] bArr3 = segmentWritableSegment$okio3.data;
                    int i18 = segmentWritableSegment$okio3.limit;
                    bArr3[i18] = (byte) ((cCharAt >> '\f') | 224);
                    bArr3[i18 + 1] = (byte) ((63 & (cCharAt >> 6)) | 128);
                    bArr3[i18 + 2] = (byte) ((cCharAt & '?') | 128);
                    segmentWritableSegment$okio3.limit = i18 + 3;
                    commonWriteUtf8.setSize$okio(commonWriteUtf8.size() + 3);
                } else {
                    int i19 = i11 + 1;
                    char cCharAt3 = i19 < i12 ? string.charAt(i19) : (char) 0;
                    if (cCharAt > 56319 || 56320 > cCharAt3 || 57343 < cCharAt3) {
                        commonWriteUtf8.writeByte(63);
                        i11 = i19;
                    } else {
                        int i21 = (((cCharAt & 1023) << 10) | (cCharAt3 & 1023)) + 65536;
                        Segment segmentWritableSegment$okio4 = commonWriteUtf8.writableSegment$okio(4);
                        byte[] bArr4 = segmentWritableSegment$okio4.data;
                        int i22 = segmentWritableSegment$okio4.limit;
                        bArr4[i22] = (byte) ((i21 >> 18) | 240);
                        bArr4[i22 + 1] = (byte) (((i21 >> 12) & 63) | 128);
                        bArr4[i22 + 2] = (byte) (((i21 >> 6) & 63) | 128);
                        bArr4[i22 + 3] = (byte) ((i21 & 63) | 128);
                        segmentWritableSegment$okio4.limit = i22 + 4;
                        commonWriteUtf8.setSize$okio(commonWriteUtf8.size() + 4);
                        i11 += 2;
                    }
                }
                i11++;
            }
        }
        return commonWriteUtf8;
    }

    public static final Buffer commonWriteUtf8CodePoint(Buffer commonWriteUtf8CodePoint, int i11) {
        Intrinsics.g(commonWriteUtf8CodePoint, "$this$commonWriteUtf8CodePoint");
        if (i11 < 128) {
            commonWriteUtf8CodePoint.writeByte(i11);
        } else if (i11 < 2048) {
            Segment segmentWritableSegment$okio = commonWriteUtf8CodePoint.writableSegment$okio(2);
            byte[] bArr = segmentWritableSegment$okio.data;
            int i12 = segmentWritableSegment$okio.limit;
            bArr[i12] = (byte) ((i11 >> 6) | PsExtractor.AUDIO_STREAM);
            bArr[i12 + 1] = (byte) ((i11 & 63) | 128);
            segmentWritableSegment$okio.limit = i12 + 2;
            commonWriteUtf8CodePoint.setSize$okio(commonWriteUtf8CodePoint.size() + 2);
        } else if (55296 <= i11 && 57343 >= i11) {
            commonWriteUtf8CodePoint.writeByte(63);
        } else if (i11 < 65536) {
            Segment segmentWritableSegment$okio2 = commonWriteUtf8CodePoint.writableSegment$okio(3);
            byte[] bArr2 = segmentWritableSegment$okio2.data;
            int i13 = segmentWritableSegment$okio2.limit;
            bArr2[i13] = (byte) ((i11 >> 12) | 224);
            bArr2[i13 + 1] = (byte) (((i11 >> 6) & 63) | 128);
            bArr2[i13 + 2] = (byte) ((i11 & 63) | 128);
            segmentWritableSegment$okio2.limit = i13 + 3;
            commonWriteUtf8CodePoint.setSize$okio(commonWriteUtf8CodePoint.size() + 3);
        } else {
            if (i11 > 1114111) {
                throw new IllegalArgumentException("Unexpected code point: 0x" + Util.toHexString(i11));
            }
            Segment segmentWritableSegment$okio3 = commonWriteUtf8CodePoint.writableSegment$okio(4);
            byte[] bArr3 = segmentWritableSegment$okio3.data;
            int i14 = segmentWritableSegment$okio3.limit;
            bArr3[i14] = (byte) ((i11 >> 18) | 240);
            bArr3[i14 + 1] = (byte) (((i11 >> 12) & 63) | 128);
            bArr3[i14 + 2] = (byte) (((i11 >> 6) & 63) | 128);
            bArr3[i14 + 3] = (byte) ((i11 & 63) | 128);
            segmentWritableSegment$okio3.limit = i14 + 4;
            commonWriteUtf8CodePoint.setSize$okio(commonWriteUtf8CodePoint.size() + 4);
        }
        return commonWriteUtf8CodePoint;
    }

    public static final byte[] getHEX_DIGIT_BYTES() {
        return HEX_DIGIT_BYTES;
    }

    public static final boolean rangeEquals(Segment segment, int i11, byte[] bytes, int i12, int i13) {
        Intrinsics.g(segment, "segment");
        Intrinsics.g(bytes, "bytes");
        int i14 = segment.limit;
        byte[] bArr = segment.data;
        while (i12 < i13) {
            if (i11 == i14) {
                segment = segment.next;
                Intrinsics.d(segment);
                byte[] bArr2 = segment.data;
                bArr = bArr2;
                i11 = segment.pos;
                i14 = segment.limit;
            }
            if (bArr[i11] != bytes[i12]) {
                return false;
            }
            i11++;
            i12++;
        }
        return true;
    }

    public static final String readUtf8Line(Buffer readUtf8Line, long j11) throws EOFException {
        Intrinsics.g(readUtf8Line, "$this$readUtf8Line");
        if (j11 > 0) {
            long j12 = j11 - 1;
            if (readUtf8Line.getByte(j12) == ((byte) 13)) {
                String utf8 = readUtf8Line.readUtf8(j12);
                readUtf8Line.skip(2L);
                return utf8;
            }
        }
        String utf9 = readUtf8Line.readUtf8(j11);
        readUtf8Line.skip(1L);
        return utf9;
    }

    public static final <T> T seek(Buffer seek, long j11, Function2<? super Segment, ? super Long, ? extends T> lambda) {
        Intrinsics.g(seek, "$this$seek");
        Intrinsics.g(lambda, "lambda");
        Segment segment = seek.head;
        if (segment == null) {
            return lambda.invoke(null, -1L);
        }
        if (seek.size() - j11 < j11) {
            long size = seek.size();
            while (size > j11) {
                segment = segment.prev;
                Intrinsics.d(segment);
                size -= (long) (segment.limit - segment.pos);
            }
            return lambda.invoke(segment, Long.valueOf(size));
        }
        long j12 = 0;
        while (true) {
            long j13 = ((long) (segment.limit - segment.pos)) + j12;
            if (j13 > j11) {
                return lambda.invoke(segment, Long.valueOf(j12));
            }
            segment = segment.next;
            Intrinsics.d(segment);
            j12 = j13;
        }
    }

    public static final int selectPrefix(Buffer selectPrefix, Options options, boolean z11) {
        int i11;
        int i12;
        Segment segment;
        int i13;
        int i14;
        Intrinsics.g(selectPrefix, "$this$selectPrefix");
        Intrinsics.g(options, "options");
        Segment segment2 = selectPrefix.head;
        if (segment2 == null) {
            return z11 ? -2 : -1;
        }
        byte[] bArr = segment2.data;
        int i15 = segment2.pos;
        int i16 = segment2.limit;
        int[] trie$okio = options.getTrie$okio();
        Segment segment3 = segment2;
        int i17 = 0;
        int i18 = -1;
        loop0: while (true) {
            int i19 = i17 + 1;
            int i21 = trie$okio[i17];
            int i22 = i17 + 2;
            int i23 = trie$okio[i19];
            if (i23 != -1) {
                i18 = i23;
            }
            if (segment3 == null) {
                break;
            }
            if (i21 >= 0) {
                i11 = i15 + 1;
                int i24 = bArr[i15] & 255;
                int i25 = i22 + i21;
                while (i22 != i25) {
                    if (i24 == trie$okio[i22]) {
                        i12 = trie$okio[i22 + i21];
                        if (i11 == i16) {
                            segment3 = segment3.next;
                            Intrinsics.d(segment3);
                            i11 = segment3.pos;
                            bArr = segment3.data;
                            i16 = segment3.limit;
                            if (segment3 == segment2) {
                                segment3 = null;
                            }
                        }
                    } else {
                        i22++;
                    }
                }
                return i18;
            }
            int i26 = i22 + (i21 * (-1));
            while (true) {
                int i27 = i15 + 1;
                int i28 = i22 + 1;
                if ((bArr[i15] & 255) != trie$okio[i22]) {
                    return i18;
                }
                boolean z12 = i28 == i26;
                if (i27 == i16) {
                    Intrinsics.d(segment3);
                    Segment segment4 = segment3.next;
                    Intrinsics.d(segment4);
                    i14 = segment4.pos;
                    byte[] bArr2 = segment4.data;
                    i13 = segment4.limit;
                    if (segment4 != segment2) {
                        segment = segment4;
                        bArr = bArr2;
                    } else {
                        if (!z12) {
                            break loop0;
                        }
                        bArr = bArr2;
                        segment = null;
                    }
                } else {
                    segment = segment3;
                    i13 = i16;
                    i14 = i27;
                }
                if (z12) {
                    i12 = trie$okio[i28];
                    i11 = i14;
                    i16 = i13;
                    segment3 = segment;
                    break;
                }
                i15 = i14;
                i16 = i13;
                segment3 = segment;
                i22 = i28;
            }
            if (i12 >= 0) {
                return i12;
            }
            i17 = -i12;
            i15 = i11;
        }
        if (z11) {
            return -2;
        }
        return i18;
    }

    public static /* synthetic */ int selectPrefix$default(Buffer buffer, Options options, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        return selectPrefix(buffer, options, z11);
    }
}
