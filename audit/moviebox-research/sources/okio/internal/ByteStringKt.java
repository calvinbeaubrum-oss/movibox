package okio.internal;

import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.l;
import okio.Base64;
import okio.Buffer;
import okio.ByteString;
import okio.Platform;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class ByteStringKt {
    private static final char[] HEX_DIGIT_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX INFO: Access modifiers changed from: private */
    public static final int codePointIndexToCharIndex(byte[] bArr, int i11) {
        byte b11;
        int i12;
        int length = bArr.length;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        while (i13 < length) {
            byte b12 = bArr[i13];
            if (b12 >= 0) {
                int i16 = i15 + 1;
                if (i15 == i11) {
                    return i14;
                }
                if ((b12 != 10 && b12 != 13 && ((b12 >= 0 && 31 >= b12) || (127 <= b12 && 159 >= b12))) || b12 == 65533) {
                    return -1;
                }
                i14 += b12 < 65536 ? 1 : 2;
                i13++;
                while (true) {
                    i15 = i16;
                    if (i13 >= length || (b11 = bArr[i13]) < 0) {
                        break;
                    }
                    i13++;
                    i16 = i15 + 1;
                    if (i15 == i11) {
                        return i14;
                    }
                    if ((b11 != 10 && b11 != 13 && ((b11 >= 0 && 31 >= b11) || (127 <= b11 && 159 >= b11))) || b11 == 65533) {
                        return -1;
                    }
                    i14 += b11 < 65536 ? 1 : 2;
                }
            } else if ((b12 >> 5) == -2) {
                int i17 = i13 + 1;
                if (length <= i17) {
                    if (i15 == i11) {
                        return i14;
                    }
                    return -1;
                }
                byte b13 = bArr[i17];
                if ((b13 & 192) != 128) {
                    if (i15 == i11) {
                        return i14;
                    }
                    return -1;
                }
                int i18 = (b12 << 6) ^ (b13 ^ 3968);
                if (i18 < 128) {
                    if (i15 == i11) {
                        return i14;
                    }
                    return -1;
                }
                int i19 = i15 + 1;
                if (i15 == i11) {
                    return i14;
                }
                if ((i18 != 10 && i18 != 13 && ((i18 >= 0 && 31 >= i18) || (127 <= i18 && 159 >= i18))) || i18 == 65533) {
                    return -1;
                }
                i14 += i18 < 65536 ? 1 : 2;
                Unit unit = Unit.f68710a;
                i13 += 2;
                i15 = i19;
            } else {
                if ((b12 >> 4) == -2) {
                    int i21 = i13 + 2;
                    if (length <= i21) {
                        if (i15 == i11) {
                            return i14;
                        }
                        return -1;
                    }
                    byte b14 = bArr[i13 + 1];
                    if ((b14 & 192) != 128) {
                        if (i15 == i11) {
                            return i14;
                        }
                        return -1;
                    }
                    byte b15 = bArr[i21];
                    if ((b15 & 192) != 128) {
                        if (i15 == i11) {
                            return i14;
                        }
                        return -1;
                    }
                    int i22 = (b12 << Ascii.FF) ^ ((b15 ^ (-123008)) ^ (b14 << 6));
                    if (i22 < 2048) {
                        if (i15 == i11) {
                            return i14;
                        }
                        return -1;
                    }
                    if (55296 <= i22 && 57343 >= i22) {
                        if (i15 == i11) {
                            return i14;
                        }
                        return -1;
                    }
                    i12 = i15 + 1;
                    if (i15 == i11) {
                        return i14;
                    }
                    if ((i22 != 10 && i22 != 13 && ((i22 >= 0 && 31 >= i22) || (127 <= i22 && 159 >= i22))) || i22 == 65533) {
                        return -1;
                    }
                    i14 += i22 < 65536 ? 1 : 2;
                    Unit unit2 = Unit.f68710a;
                    i13 += 3;
                } else {
                    if ((b12 >> 3) != -2) {
                        if (i15 == i11) {
                            return i14;
                        }
                        return -1;
                    }
                    int i23 = i13 + 3;
                    if (length <= i23) {
                        if (i15 == i11) {
                            return i14;
                        }
                        return -1;
                    }
                    byte b16 = bArr[i13 + 1];
                    if ((b16 & 192) != 128) {
                        if (i15 == i11) {
                            return i14;
                        }
                        return -1;
                    }
                    byte b17 = bArr[i13 + 2];
                    if ((b17 & 192) != 128) {
                        if (i15 == i11) {
                            return i14;
                        }
                        return -1;
                    }
                    byte b18 = bArr[i23];
                    if ((b18 & 192) != 128) {
                        if (i15 == i11) {
                            return i14;
                        }
                        return -1;
                    }
                    int i24 = (b12 << Ascii.DC2) ^ (((b18 ^ 3678080) ^ (b17 << 6)) ^ (b16 << Ascii.FF));
                    if (i24 > 1114111) {
                        if (i15 == i11) {
                            return i14;
                        }
                        return -1;
                    }
                    if (55296 <= i24 && 57343 >= i24) {
                        if (i15 == i11) {
                            return i14;
                        }
                        return -1;
                    }
                    if (i24 < 65536) {
                        if (i15 == i11) {
                            return i14;
                        }
                        return -1;
                    }
                    i12 = i15 + 1;
                    if (i15 == i11) {
                        return i14;
                    }
                    if ((i24 != 10 && i24 != 13 && ((i24 >= 0 && 31 >= i24) || (127 <= i24 && 159 >= i24))) || i24 == 65533) {
                        return -1;
                    }
                    i14 += i24 < 65536 ? 1 : 2;
                    Unit unit3 = Unit.f68710a;
                    i13 += 4;
                }
                i15 = i12;
            }
        }
        return i14;
    }

    public static final String commonBase64(ByteString commonBase64) {
        Intrinsics.g(commonBase64, "$this$commonBase64");
        return Base64.encodeBase64$default(commonBase64.getData$okio(), null, 1, null);
    }

    public static final String commonBase64Url(ByteString commonBase64Url) {
        Intrinsics.g(commonBase64Url, "$this$commonBase64Url");
        return Base64.encodeBase64(commonBase64Url.getData$okio(), Base64.getBASE64_URL_SAFE());
    }

    public static final int commonCompareTo(ByteString commonCompareTo, ByteString other) {
        Intrinsics.g(commonCompareTo, "$this$commonCompareTo");
        Intrinsics.g(other, "other");
        int size = commonCompareTo.size();
        int size2 = other.size();
        int iMin = Math.min(size, size2);
        for (int i11 = 0; i11 < iMin; i11++) {
            int i12 = commonCompareTo.getByte(i11) & 255;
            int i13 = other.getByte(i11) & 255;
            if (i12 != i13) {
                return i12 < i13 ? -1 : 1;
            }
        }
        if (size == size2) {
            return 0;
        }
        return size < size2 ? -1 : 1;
    }

    public static final ByteString commonDecodeBase64(String commonDecodeBase64) {
        Intrinsics.g(commonDecodeBase64, "$this$commonDecodeBase64");
        byte[] bArrDecodeBase64ToArray = Base64.decodeBase64ToArray(commonDecodeBase64);
        if (bArrDecodeBase64ToArray != null) {
            return new ByteString(bArrDecodeBase64ToArray);
        }
        return null;
    }

    public static final ByteString commonDecodeHex(String commonDecodeHex) {
        Intrinsics.g(commonDecodeHex, "$this$commonDecodeHex");
        if (!(commonDecodeHex.length() % 2 == 0)) {
            throw new IllegalArgumentException(("Unexpected hex string: " + commonDecodeHex).toString());
        }
        int length = commonDecodeHex.length() / 2;
        byte[] bArr = new byte[length];
        for (int i11 = 0; i11 < length; i11++) {
            int i12 = i11 * 2;
            bArr[i11] = (byte) ((decodeHexDigit(commonDecodeHex.charAt(i12)) << 4) + decodeHexDigit(commonDecodeHex.charAt(i12 + 1)));
        }
        return new ByteString(bArr);
    }

    public static final ByteString commonEncodeUtf8(String commonEncodeUtf8) {
        Intrinsics.g(commonEncodeUtf8, "$this$commonEncodeUtf8");
        ByteString byteString = new ByteString(Platform.asUtf8ToByteArray(commonEncodeUtf8));
        byteString.setUtf8$okio(commonEncodeUtf8);
        return byteString;
    }

    public static final boolean commonEndsWith(ByteString commonEndsWith, ByteString suffix) {
        Intrinsics.g(commonEndsWith, "$this$commonEndsWith");
        Intrinsics.g(suffix, "suffix");
        return commonEndsWith.rangeEquals(commonEndsWith.size() - suffix.size(), suffix, 0, suffix.size());
    }

    public static final boolean commonEndsWith(ByteString commonEndsWith, byte[] suffix) {
        Intrinsics.g(commonEndsWith, "$this$commonEndsWith");
        Intrinsics.g(suffix, "suffix");
        return commonEndsWith.rangeEquals(commonEndsWith.size() - suffix.length, suffix, 0, suffix.length);
    }

    public static final boolean commonEquals(ByteString commonEquals, Object obj) {
        Intrinsics.g(commonEquals, "$this$commonEquals");
        if (obj == commonEquals) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == commonEquals.getData$okio().length && byteString.rangeEquals(0, commonEquals.getData$okio(), 0, commonEquals.getData$okio().length)) {
                return true;
            }
        }
        return false;
    }

    public static final byte commonGetByte(ByteString commonGetByte, int i11) {
        Intrinsics.g(commonGetByte, "$this$commonGetByte");
        return commonGetByte.getData$okio()[i11];
    }

    public static final int commonGetSize(ByteString commonGetSize) {
        Intrinsics.g(commonGetSize, "$this$commonGetSize");
        return commonGetSize.getData$okio().length;
    }

    public static final int commonHashCode(ByteString commonHashCode) {
        Intrinsics.g(commonHashCode, "$this$commonHashCode");
        int hashCode$okio = commonHashCode.getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int iHashCode = Arrays.hashCode(commonHashCode.getData$okio());
        commonHashCode.setHashCode$okio(iHashCode);
        return iHashCode;
    }

    public static final String commonHex(ByteString commonHex) {
        Intrinsics.g(commonHex, "$this$commonHex");
        char[] cArr = new char[commonHex.getData$okio().length * 2];
        int i11 = 0;
        for (byte b11 : commonHex.getData$okio()) {
            int i12 = i11 + 1;
            cArr[i11] = getHEX_DIGIT_CHARS()[(b11 >> 4) & 15];
            i11 += 2;
            cArr[i12] = getHEX_DIGIT_CHARS()[b11 & Ascii.SI];
        }
        return new String(cArr);
    }

    public static final int commonIndexOf(ByteString commonIndexOf, byte[] other, int i11) {
        Intrinsics.g(commonIndexOf, "$this$commonIndexOf");
        Intrinsics.g(other, "other");
        int length = commonIndexOf.getData$okio().length - other.length;
        int iMax = Math.max(i11, 0);
        if (iMax > length) {
            return -1;
        }
        while (!Util.arrayRangeEquals(commonIndexOf.getData$okio(), iMax, other, 0, other.length)) {
            if (iMax == length) {
                return -1;
            }
            iMax++;
        }
        return iMax;
    }

    public static final byte[] commonInternalArray(ByteString commonInternalArray) {
        Intrinsics.g(commonInternalArray, "$this$commonInternalArray");
        return commonInternalArray.getData$okio();
    }

    public static final int commonLastIndexOf(ByteString commonLastIndexOf, ByteString other, int i11) {
        Intrinsics.g(commonLastIndexOf, "$this$commonLastIndexOf");
        Intrinsics.g(other, "other");
        return commonLastIndexOf.lastIndexOf(other.internalArray$okio(), i11);
    }

    public static final int commonLastIndexOf(ByteString commonLastIndexOf, byte[] other, int i11) {
        Intrinsics.g(commonLastIndexOf, "$this$commonLastIndexOf");
        Intrinsics.g(other, "other");
        for (int iMin = Math.min(i11, commonLastIndexOf.getData$okio().length - other.length); iMin >= 0; iMin--) {
            if (Util.arrayRangeEquals(commonLastIndexOf.getData$okio(), iMin, other, 0, other.length)) {
                return iMin;
            }
        }
        return -1;
    }

    public static final ByteString commonOf(byte[] data) {
        Intrinsics.g(data, "data");
        byte[] bArrCopyOf = Arrays.copyOf(data, data.length);
        Intrinsics.f(bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        return new ByteString(bArrCopyOf);
    }

    public static final boolean commonRangeEquals(ByteString commonRangeEquals, int i11, ByteString other, int i12, int i13) {
        Intrinsics.g(commonRangeEquals, "$this$commonRangeEquals");
        Intrinsics.g(other, "other");
        return other.rangeEquals(i12, commonRangeEquals.getData$okio(), i11, i13);
    }

    public static final boolean commonRangeEquals(ByteString commonRangeEquals, int i11, byte[] other, int i12, int i13) {
        Intrinsics.g(commonRangeEquals, "$this$commonRangeEquals");
        Intrinsics.g(other, "other");
        return i11 >= 0 && i11 <= commonRangeEquals.getData$okio().length - i13 && i12 >= 0 && i12 <= other.length - i13 && Util.arrayRangeEquals(commonRangeEquals.getData$okio(), i11, other, i12, i13);
    }

    public static final boolean commonStartsWith(ByteString commonStartsWith, ByteString prefix) {
        Intrinsics.g(commonStartsWith, "$this$commonStartsWith");
        Intrinsics.g(prefix, "prefix");
        return commonStartsWith.rangeEquals(0, prefix, 0, prefix.size());
    }

    public static final boolean commonStartsWith(ByteString commonStartsWith, byte[] prefix) {
        Intrinsics.g(commonStartsWith, "$this$commonStartsWith");
        Intrinsics.g(prefix, "prefix");
        return commonStartsWith.rangeEquals(0, prefix, 0, prefix.length);
    }

    public static final ByteString commonSubstring(ByteString commonSubstring, int i11, int i12) {
        Intrinsics.g(commonSubstring, "$this$commonSubstring");
        if (!(i11 >= 0)) {
            throw new IllegalArgumentException("beginIndex < 0".toString());
        }
        if (i12 <= commonSubstring.getData$okio().length) {
            if (i12 - i11 >= 0) {
                return (i11 == 0 && i12 == commonSubstring.getData$okio().length) ? commonSubstring : new ByteString(ArraysKt___ArraysJvmKt.q(commonSubstring.getData$okio(), i11, i12));
            }
            throw new IllegalArgumentException("endIndex < beginIndex".toString());
        }
        throw new IllegalArgumentException(("endIndex > length(" + commonSubstring.getData$okio().length + ')').toString());
    }

    public static final ByteString commonToAsciiLowercase(ByteString commonToAsciiLowercase) {
        byte b11;
        Intrinsics.g(commonToAsciiLowercase, "$this$commonToAsciiLowercase");
        for (int i11 = 0; i11 < commonToAsciiLowercase.getData$okio().length; i11++) {
            byte b12 = commonToAsciiLowercase.getData$okio()[i11];
            byte b13 = (byte) 65;
            if (b12 >= b13 && b12 <= (b11 = (byte) 90)) {
                byte[] data$okio = commonToAsciiLowercase.getData$okio();
                byte[] bArrCopyOf = Arrays.copyOf(data$okio, data$okio.length);
                Intrinsics.f(bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
                bArrCopyOf[i11] = (byte) (b12 + 32);
                for (int i12 = i11 + 1; i12 < bArrCopyOf.length; i12++) {
                    byte b14 = bArrCopyOf[i12];
                    if (b14 >= b13 && b14 <= b11) {
                        bArrCopyOf[i12] = (byte) (b14 + 32);
                    }
                }
                return new ByteString(bArrCopyOf);
            }
        }
        return commonToAsciiLowercase;
    }

    public static final ByteString commonToAsciiUppercase(ByteString commonToAsciiUppercase) {
        byte b11;
        Intrinsics.g(commonToAsciiUppercase, "$this$commonToAsciiUppercase");
        for (int i11 = 0; i11 < commonToAsciiUppercase.getData$okio().length; i11++) {
            byte b12 = commonToAsciiUppercase.getData$okio()[i11];
            byte b13 = (byte) 97;
            if (b12 >= b13 && b12 <= (b11 = (byte) 122)) {
                byte[] data$okio = commonToAsciiUppercase.getData$okio();
                byte[] bArrCopyOf = Arrays.copyOf(data$okio, data$okio.length);
                Intrinsics.f(bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
                bArrCopyOf[i11] = (byte) (b12 - 32);
                for (int i12 = i11 + 1; i12 < bArrCopyOf.length; i12++) {
                    byte b14 = bArrCopyOf[i12];
                    if (b14 >= b13 && b14 <= b11) {
                        bArrCopyOf[i12] = (byte) (b14 - 32);
                    }
                }
                return new ByteString(bArrCopyOf);
            }
        }
        return commonToAsciiUppercase;
    }

    public static final byte[] commonToByteArray(ByteString commonToByteArray) {
        Intrinsics.g(commonToByteArray, "$this$commonToByteArray");
        byte[] data$okio = commonToByteArray.getData$okio();
        byte[] bArrCopyOf = Arrays.copyOf(data$okio, data$okio.length);
        Intrinsics.f(bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        return bArrCopyOf;
    }

    public static final ByteString commonToByteString(byte[] commonToByteString, int i11, int i12) {
        Intrinsics.g(commonToByteString, "$this$commonToByteString");
        Util.checkOffsetAndCount(commonToByteString.length, i11, i12);
        return new ByteString(ArraysKt___ArraysJvmKt.q(commonToByteString, i11, i12 + i11));
    }

    public static final String commonToString(ByteString byteString) {
        ByteString commonToString = byteString;
        Intrinsics.g(commonToString, "$this$commonToString");
        if (byteString.getData$okio().length == 0) {
            return "[size=0]";
        }
        int iCodePointIndexToCharIndex = codePointIndexToCharIndex(byteString.getData$okio(), 64);
        if (iCodePointIndexToCharIndex != -1) {
            String strUtf8 = byteString.utf8();
            if (strUtf8 == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String strSubstring = strUtf8.substring(0, iCodePointIndexToCharIndex);
            Intrinsics.f(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            String strF = l.F(l.F(l.F(strSubstring, "\\", "\\\\", false, 4, null), "\n", "\\n", false, 4, null), "\r", "\\r", false, 4, null);
            if (iCodePointIndexToCharIndex >= strUtf8.length()) {
                return "[text=" + strF + ']';
            }
            return "[size=" + byteString.getData$okio().length + " text=" + strF + "…]";
        }
        if (byteString.getData$okio().length <= 64) {
            return "[hex=" + byteString.hex() + ']';
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[size=");
        sb2.append(byteString.getData$okio().length);
        sb2.append(" hex=");
        if (64 <= byteString.getData$okio().length) {
            if (64 != byteString.getData$okio().length) {
                commonToString = new ByteString(ArraysKt___ArraysJvmKt.q(byteString.getData$okio(), 0, 64));
            }
            sb2.append(commonToString.hex());
            sb2.append("…]");
            return sb2.toString();
        }
        throw new IllegalArgumentException(("endIndex > length(" + byteString.getData$okio().length + ')').toString());
    }

    public static final String commonUtf8(ByteString commonUtf8) {
        Intrinsics.g(commonUtf8, "$this$commonUtf8");
        String utf8$okio = commonUtf8.getUtf8$okio();
        if (utf8$okio != null) {
            return utf8$okio;
        }
        String utf8String = Platform.toUtf8String(commonUtf8.internalArray$okio());
        commonUtf8.setUtf8$okio(utf8String);
        return utf8String;
    }

    public static final void commonWrite(ByteString commonWrite, Buffer buffer, int i11, int i12) {
        Intrinsics.g(commonWrite, "$this$commonWrite");
        Intrinsics.g(buffer, "buffer");
        buffer.write(commonWrite.getData$okio(), i11, i12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int decodeHexDigit(char c11) {
        if ('0' <= c11 && '9' >= c11) {
            return c11 - '0';
        }
        if ('a' <= c11 && 'f' >= c11) {
            return c11 - 'W';
        }
        if ('A' <= c11 && 'F' >= c11) {
            return c11 - '7';
        }
        throw new IllegalArgumentException("Unexpected hex digit: " + c11);
    }

    public static final char[] getHEX_DIGIT_CHARS() {
        return HEX_DIGIT_CHARS;
    }
}
