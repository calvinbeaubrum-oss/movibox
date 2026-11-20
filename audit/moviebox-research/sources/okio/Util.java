package okio;

import com.applovin.exoplayer2.common.base.Ascii;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import okio.internal.ByteStringKt;

/* JADX INFO: renamed from: okio.-Util, reason: invalid class name */
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@JvmName
public final class Util {
    public static final int and(byte b11, int i11) {
        return b11 & i11;
    }

    public static final long and(byte b11, long j11) {
        return ((long) b11) & j11;
    }

    public static final long and(int i11, long j11) {
        return ((long) i11) & j11;
    }

    public static final boolean arrayRangeEquals(byte[] a11, int i11, byte[] b11, int i12, int i13) {
        Intrinsics.g(a11, "a");
        Intrinsics.g(b11, "b");
        for (int i14 = 0; i14 < i13; i14++) {
            if (a11[i14 + i11] != b11[i14 + i12]) {
                return false;
            }
        }
        return true;
    }

    public static final void checkOffsetAndCount(long j11, long j12, long j13) {
        if ((j12 | j13) < 0 || j12 > j11 || j11 - j12 < j13) {
            throw new ArrayIndexOutOfBoundsException("size=" + j11 + " offset=" + j12 + " byteCount=" + j13);
        }
    }

    public static final int leftRotate(int i11, int i12) {
        return (i11 >>> (32 - i12)) | (i11 << i12);
    }

    public static final long minOf(int i11, long j11) {
        return Math.min(i11, j11);
    }

    public static final long minOf(long j11, int i11) {
        return Math.min(j11, i11);
    }

    public static final int reverseBytes(int i11) {
        return ((i11 & 255) << 24) | (((-16777216) & i11) >>> 24) | ((16711680 & i11) >>> 8) | ((65280 & i11) << 8);
    }

    public static final long reverseBytes(long j11) {
        return ((j11 & 255) << 56) | (((-72057594037927936L) & j11) >>> 56) | ((71776119061217280L & j11) >>> 40) | ((280375465082880L & j11) >>> 24) | ((1095216660480L & j11) >>> 8) | ((4278190080L & j11) << 8) | ((16711680 & j11) << 24) | ((65280 & j11) << 40);
    }

    public static final short reverseBytes(short s11) {
        return (short) (((s11 & 255) << 8) | ((65280 & s11) >>> 8));
    }

    public static final long rightRotate(long j11, int i11) {
        return (j11 << (64 - i11)) | (j11 >>> i11);
    }

    public static final int shl(byte b11, int i11) {
        return b11 << i11;
    }

    public static final int shr(byte b11, int i11) {
        return b11 >> i11;
    }

    public static final String toHexString(byte b11) {
        return new String(new char[]{ByteStringKt.getHEX_DIGIT_CHARS()[(b11 >> 4) & 15], ByteStringKt.getHEX_DIGIT_CHARS()[b11 & Ascii.SI]});
    }

    public static final String toHexString(int i11) {
        if (i11 == 0) {
            return "0";
        }
        int i12 = 0;
        char[] cArr = {ByteStringKt.getHEX_DIGIT_CHARS()[(i11 >> 28) & 15], ByteStringKt.getHEX_DIGIT_CHARS()[(i11 >> 24) & 15], ByteStringKt.getHEX_DIGIT_CHARS()[(i11 >> 20) & 15], ByteStringKt.getHEX_DIGIT_CHARS()[(i11 >> 16) & 15], ByteStringKt.getHEX_DIGIT_CHARS()[(i11 >> 12) & 15], ByteStringKt.getHEX_DIGIT_CHARS()[(i11 >> 8) & 15], ByteStringKt.getHEX_DIGIT_CHARS()[(i11 >> 4) & 15], ByteStringKt.getHEX_DIGIT_CHARS()[i11 & 15]};
        while (i12 < 8 && cArr[i12] == '0') {
            i12++;
        }
        return new String(cArr, i12, 8 - i12);
    }

    public static final String toHexString(long j11) {
        if (j11 == 0) {
            return "0";
        }
        int i11 = 0;
        char[] cArr = {ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j11 >> 60) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j11 >> 56) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j11 >> 52) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j11 >> 48) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j11 >> 44) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j11 >> 40) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j11 >> 36) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j11 >> 32) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j11 >> 28) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j11 >> 24) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j11 >> 20) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j11 >> 16) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j11 >> 12) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j11 >> 8) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j11 >> 4) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) (j11 & 15)]};
        while (i11 < 16 && cArr[i11] == '0') {
            i11++;
        }
        return new String(cArr, i11, 16 - i11);
    }

    public static final byte xor(byte b11, byte b12) {
        return (byte) (b11 ^ b12);
    }
}
