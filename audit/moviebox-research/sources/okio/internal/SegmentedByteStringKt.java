package okio.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ByteString;
import okio.Segment;
import okio.SegmentedByteString;
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
public final class SegmentedByteStringKt {
    public static final int binarySearch(int[] binarySearch, int i11, int i12, int i13) {
        Intrinsics.g(binarySearch, "$this$binarySearch");
        int i14 = i13 - 1;
        while (i12 <= i14) {
            int i15 = (i12 + i14) >>> 1;
            int i16 = binarySearch[i15];
            if (i16 < i11) {
                i12 = i15 + 1;
            } else {
                if (i16 <= i11) {
                    return i15;
                }
                i14 = i15 - 1;
            }
        }
        return (-i12) - 1;
    }

    public static final boolean commonEquals(SegmentedByteString commonEquals, Object obj) {
        Intrinsics.g(commonEquals, "$this$commonEquals");
        if (obj == commonEquals) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == commonEquals.size() && commonEquals.rangeEquals(0, byteString, 0, commonEquals.size())) {
                return true;
            }
        }
        return false;
    }

    public static final int commonGetSize(SegmentedByteString commonGetSize) {
        Intrinsics.g(commonGetSize, "$this$commonGetSize");
        return commonGetSize.getDirectory$okio()[commonGetSize.getSegments$okio().length - 1];
    }

    public static final int commonHashCode(SegmentedByteString commonHashCode) {
        Intrinsics.g(commonHashCode, "$this$commonHashCode");
        int hashCode$okio = commonHashCode.getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int length = commonHashCode.getSegments$okio().length;
        int i11 = 0;
        int i12 = 0;
        int i13 = 1;
        while (i11 < length) {
            int i14 = commonHashCode.getDirectory$okio()[length + i11];
            int i15 = commonHashCode.getDirectory$okio()[i11];
            byte[] bArr = commonHashCode.getSegments$okio()[i11];
            int i16 = (i15 - i12) + i14;
            while (i14 < i16) {
                i13 = (i13 * 31) + bArr[i14];
                i14++;
            }
            i11++;
            i12 = i15;
        }
        commonHashCode.setHashCode$okio(i13);
        return i13;
    }

    public static final byte commonInternalGet(SegmentedByteString commonInternalGet, int i11) {
        Intrinsics.g(commonInternalGet, "$this$commonInternalGet");
        Util.checkOffsetAndCount(commonInternalGet.getDirectory$okio()[commonInternalGet.getSegments$okio().length - 1], i11, 1L);
        int iSegment = segment(commonInternalGet, i11);
        return commonInternalGet.getSegments$okio()[iSegment][(i11 - (iSegment == 0 ? 0 : commonInternalGet.getDirectory$okio()[iSegment - 1])) + commonInternalGet.getDirectory$okio()[commonInternalGet.getSegments$okio().length + iSegment]];
    }

    public static final boolean commonRangeEquals(SegmentedByteString commonRangeEquals, int i11, ByteString other, int i12, int i13) {
        Intrinsics.g(commonRangeEquals, "$this$commonRangeEquals");
        Intrinsics.g(other, "other");
        if (i11 < 0 || i11 > commonRangeEquals.size() - i13) {
            return false;
        }
        int i14 = i13 + i11;
        int iSegment = segment(commonRangeEquals, i11);
        while (i11 < i14) {
            int i15 = iSegment == 0 ? 0 : commonRangeEquals.getDirectory$okio()[iSegment - 1];
            int i16 = commonRangeEquals.getDirectory$okio()[iSegment] - i15;
            int i17 = commonRangeEquals.getDirectory$okio()[commonRangeEquals.getSegments$okio().length + iSegment];
            int iMin = Math.min(i14, i16 + i15) - i11;
            if (!other.rangeEquals(i12, commonRangeEquals.getSegments$okio()[iSegment], i17 + (i11 - i15), iMin)) {
                return false;
            }
            i12 += iMin;
            i11 += iMin;
            iSegment++;
        }
        return true;
    }

    public static final boolean commonRangeEquals(SegmentedByteString commonRangeEquals, int i11, byte[] other, int i12, int i13) {
        Intrinsics.g(commonRangeEquals, "$this$commonRangeEquals");
        Intrinsics.g(other, "other");
        if (i11 < 0 || i11 > commonRangeEquals.size() - i13 || i12 < 0 || i12 > other.length - i13) {
            return false;
        }
        int i14 = i13 + i11;
        int iSegment = segment(commonRangeEquals, i11);
        while (i11 < i14) {
            int i15 = iSegment == 0 ? 0 : commonRangeEquals.getDirectory$okio()[iSegment - 1];
            int i16 = commonRangeEquals.getDirectory$okio()[iSegment] - i15;
            int i17 = commonRangeEquals.getDirectory$okio()[commonRangeEquals.getSegments$okio().length + iSegment];
            int iMin = Math.min(i14, i16 + i15) - i11;
            if (!Util.arrayRangeEquals(commonRangeEquals.getSegments$okio()[iSegment], i17 + (i11 - i15), other, i12, iMin)) {
                return false;
            }
            i12 += iMin;
            i11 += iMin;
            iSegment++;
        }
        return true;
    }

    public static final ByteString commonSubstring(SegmentedByteString commonSubstring, int i11, int i12) {
        Intrinsics.g(commonSubstring, "$this$commonSubstring");
        if (!(i11 >= 0)) {
            throw new IllegalArgumentException(("beginIndex=" + i11 + " < 0").toString());
        }
        if (!(i12 <= commonSubstring.size())) {
            throw new IllegalArgumentException(("endIndex=" + i12 + " > length(" + commonSubstring.size() + ')').toString());
        }
        int i13 = i12 - i11;
        if (!(i13 >= 0)) {
            throw new IllegalArgumentException(("endIndex=" + i12 + " < beginIndex=" + i11).toString());
        }
        if (i11 == 0 && i12 == commonSubstring.size()) {
            return commonSubstring;
        }
        if (i11 == i12) {
            return ByteString.EMPTY;
        }
        int iSegment = segment(commonSubstring, i11);
        int iSegment2 = segment(commonSubstring, i12 - 1);
        byte[][] bArr = (byte[][]) ArraysKt___ArraysJvmKt.r(commonSubstring.getSegments$okio(), iSegment, iSegment2 + 1);
        int[] iArr = new int[bArr.length * 2];
        if (iSegment <= iSegment2) {
            int i14 = iSegment;
            int i15 = 0;
            while (true) {
                iArr[i15] = Math.min(commonSubstring.getDirectory$okio()[i14] - i11, i13);
                int i16 = i15 + 1;
                iArr[i15 + bArr.length] = commonSubstring.getDirectory$okio()[commonSubstring.getSegments$okio().length + i14];
                if (i14 == iSegment2) {
                    break;
                }
                i14++;
                i15 = i16;
            }
        }
        int i17 = iSegment != 0 ? commonSubstring.getDirectory$okio()[iSegment - 1] : 0;
        int length = bArr.length;
        iArr[length] = iArr[length] + (i11 - i17);
        return new SegmentedByteString(bArr, iArr);
    }

    public static final byte[] commonToByteArray(SegmentedByteString commonToByteArray) {
        Intrinsics.g(commonToByteArray, "$this$commonToByteArray");
        byte[] bArr = new byte[commonToByteArray.size()];
        int length = commonToByteArray.getSegments$okio().length;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i11 < length) {
            int i14 = commonToByteArray.getDirectory$okio()[length + i11];
            int i15 = commonToByteArray.getDirectory$okio()[i11];
            int i16 = i15 - i12;
            ArraysKt___ArraysJvmKt.h(commonToByteArray.getSegments$okio()[i11], bArr, i13, i14, i14 + i16);
            i13 += i16;
            i11++;
            i12 = i15;
        }
        return bArr;
    }

    public static final void commonWrite(SegmentedByteString commonWrite, Buffer buffer, int i11, int i12) {
        Intrinsics.g(commonWrite, "$this$commonWrite");
        Intrinsics.g(buffer, "buffer");
        int i13 = i11 + i12;
        int iSegment = segment(commonWrite, i11);
        while (i11 < i13) {
            int i14 = iSegment == 0 ? 0 : commonWrite.getDirectory$okio()[iSegment - 1];
            int i15 = commonWrite.getDirectory$okio()[iSegment] - i14;
            int i16 = commonWrite.getDirectory$okio()[commonWrite.getSegments$okio().length + iSegment];
            int iMin = Math.min(i13, i15 + i14) - i11;
            int i17 = i16 + (i11 - i14);
            Segment segment = new Segment(commonWrite.getSegments$okio()[iSegment], i17, i17 + iMin, true, false);
            Segment segment2 = buffer.head;
            if (segment2 == null) {
                segment.prev = segment;
                segment.next = segment;
                buffer.head = segment;
            } else {
                Intrinsics.d(segment2);
                Segment segment3 = segment2.prev;
                Intrinsics.d(segment3);
                segment3.push(segment);
            }
            i11 += iMin;
            iSegment++;
        }
        buffer.setSize$okio(buffer.size() + ((long) i12));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void forEachSegment(SegmentedByteString segmentedByteString, int i11, int i12, Function3<? super byte[], ? super Integer, ? super Integer, Unit> function3) {
        int iSegment = segment(segmentedByteString, i11);
        while (i11 < i12) {
            int i13 = iSegment == 0 ? 0 : segmentedByteString.getDirectory$okio()[iSegment - 1];
            int i14 = segmentedByteString.getDirectory$okio()[iSegment] - i13;
            int i15 = segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + iSegment];
            int iMin = Math.min(i12, i14 + i13) - i11;
            function3.invoke(segmentedByteString.getSegments$okio()[iSegment], Integer.valueOf(i15 + (i11 - i13)), Integer.valueOf(iMin));
            i11 += iMin;
            iSegment++;
        }
    }

    public static final void forEachSegment(SegmentedByteString forEachSegment, Function3<? super byte[], ? super Integer, ? super Integer, Unit> action) {
        Intrinsics.g(forEachSegment, "$this$forEachSegment");
        Intrinsics.g(action, "action");
        int length = forEachSegment.getSegments$okio().length;
        int i11 = 0;
        int i12 = 0;
        while (i11 < length) {
            int i13 = forEachSegment.getDirectory$okio()[length + i11];
            int i14 = forEachSegment.getDirectory$okio()[i11];
            action.invoke(forEachSegment.getSegments$okio()[i11], Integer.valueOf(i13), Integer.valueOf(i14 - i12));
            i11++;
            i12 = i14;
        }
    }

    public static final int segment(SegmentedByteString segment, int i11) {
        Intrinsics.g(segment, "$this$segment");
        int iBinarySearch = binarySearch(segment.getDirectory$okio(), i11 + 1, 0, segment.getSegments$okio().length);
        return iBinarySearch >= 0 ? iBinarySearch : ~iBinarySearch;
    }
}
