package okio;

import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: okio.-Base64, reason: invalid class name */
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
@JvmName
public final class Base64 {
    private static final byte[] BASE64;
    private static final byte[] BASE64_URL_SAFE;

    static {
        ByteString.Companion companion = ByteString.Companion;
        BASE64 = companion.encodeUtf8("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").getData$okio();
        BASE64_URL_SAFE = companion.encodeUtf8("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").getData$okio();
    }

    public static final byte[] decodeBase64ToArray(String decodeBase64ToArray) {
        int i11;
        char cCharAt;
        Intrinsics.g(decodeBase64ToArray, "$this$decodeBase64ToArray");
        int length = decodeBase64ToArray.length();
        while (length > 0 && ((cCharAt = decodeBase64ToArray.charAt(length - 1)) == '=' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == ' ' || cCharAt == '\t')) {
            length--;
        }
        int i12 = (int) ((((long) length) * 6) / 8);
        byte[] bArr = new byte[i12];
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        for (int i16 = 0; i16 < length; i16++) {
            char cCharAt2 = decodeBase64ToArray.charAt(i16);
            if ('A' <= cCharAt2 && 'Z' >= cCharAt2) {
                i11 = cCharAt2 - 'A';
            } else if ('a' <= cCharAt2 && 'z' >= cCharAt2) {
                i11 = cCharAt2 - 'G';
            } else if ('0' <= cCharAt2 && '9' >= cCharAt2) {
                i11 = cCharAt2 + 4;
            } else if (cCharAt2 == '+' || cCharAt2 == '-') {
                i11 = 62;
            } else {
                if (cCharAt2 == '/' || cCharAt2 == '_') {
                    i11 = 63;
                } else if (cCharAt2 != '\n' && cCharAt2 != '\r' && cCharAt2 != ' ' && cCharAt2 != '\t') {
                    return null;
                }
            }
            i14 = (i14 << 6) | i11;
            i13++;
            if (i13 % 4 == 0) {
                bArr[i15] = (byte) (i14 >> 16);
                int i17 = i15 + 2;
                bArr[i15 + 1] = (byte) (i14 >> 8);
                i15 += 3;
                bArr[i17] = (byte) i14;
            }
        }
        int i18 = i13 % 4;
        if (i18 == 1) {
            return null;
        }
        if (i18 == 2) {
            bArr[i15] = (byte) ((i14 << 12) >> 16);
            i15++;
        } else if (i18 == 3) {
            int i19 = i14 << 6;
            int i21 = i15 + 1;
            bArr[i15] = (byte) (i19 >> 16);
            i15 += 2;
            bArr[i21] = (byte) (i19 >> 8);
        }
        if (i15 == i12) {
            return bArr;
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, i15);
        Intrinsics.f(bArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
        return bArrCopyOf;
    }

    public static final String encodeBase64(byte[] encodeBase64, byte[] map) {
        Intrinsics.g(encodeBase64, "$this$encodeBase64");
        Intrinsics.g(map, "map");
        byte[] bArr = new byte[((encodeBase64.length + 2) / 3) * 4];
        int length = encodeBase64.length - (encodeBase64.length % 3);
        int i11 = 0;
        int i12 = 0;
        while (i11 < length) {
            byte b11 = encodeBase64[i11];
            int i13 = i11 + 2;
            byte b12 = encodeBase64[i11 + 1];
            i11 += 3;
            byte b13 = encodeBase64[i13];
            bArr[i12] = map[(b11 & 255) >> 2];
            bArr[i12 + 1] = map[((b11 & 3) << 4) | ((b12 & 255) >> 4)];
            int i14 = i12 + 3;
            bArr[i12 + 2] = map[((b12 & Ascii.SI) << 2) | ((b13 & 255) >> 6)];
            i12 += 4;
            bArr[i14] = map[b13 & Utf8.REPLACEMENT_BYTE];
        }
        int length2 = encodeBase64.length - length;
        if (length2 == 1) {
            byte b14 = encodeBase64[i11];
            bArr[i12] = map[(b14 & 255) >> 2];
            bArr[i12 + 1] = map[(b14 & 3) << 4];
            byte b15 = (byte) 61;
            bArr[i12 + 2] = b15;
            bArr[i12 + 3] = b15;
        } else if (length2 == 2) {
            int i15 = i11 + 1;
            byte b16 = encodeBase64[i11];
            byte b17 = encodeBase64[i15];
            bArr[i12] = map[(b16 & 255) >> 2];
            bArr[i12 + 1] = map[((b16 & 3) << 4) | ((b17 & 255) >> 4)];
            bArr[i12 + 2] = map[(b17 & Ascii.SI) << 2];
            bArr[i12 + 3] = (byte) 61;
        }
        return Platform.toUtf8String(bArr);
    }

    public static /* synthetic */ String encodeBase64$default(byte[] bArr, byte[] bArr2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            bArr2 = BASE64;
        }
        return encodeBase64(bArr, bArr2);
    }

    public static final byte[] getBASE64() {
        return BASE64;
    }

    public static final byte[] getBASE64_URL_SAFE() {
        return BASE64_URL_SAFE;
    }
}
