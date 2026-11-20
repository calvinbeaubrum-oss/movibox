package okio.internal;

import com.applovin.exoplayer2.common.base.Ascii;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8;

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
public final class _Utf8Kt {
    public static final byte[] commonAsUtf8ToByteArray(String commonAsUtf8ToByteArray) {
        int i11;
        char cCharAt;
        Intrinsics.g(commonAsUtf8ToByteArray, "$this$commonAsUtf8ToByteArray");
        byte[] bArr = new byte[commonAsUtf8ToByteArray.length() * 4];
        int length = commonAsUtf8ToByteArray.length();
        int i12 = 0;
        while (i12 < length) {
            char cCharAt2 = commonAsUtf8ToByteArray.charAt(i12);
            if (Intrinsics.i(cCharAt2, 128) >= 0) {
                int length2 = commonAsUtf8ToByteArray.length();
                int i13 = i12;
                while (i12 < length2) {
                    char cCharAt3 = commonAsUtf8ToByteArray.charAt(i12);
                    if (Intrinsics.i(cCharAt3, 128) < 0) {
                        int i14 = i13 + 1;
                        bArr[i13] = (byte) cCharAt3;
                        i12++;
                        while (i12 < length2 && Intrinsics.i(commonAsUtf8ToByteArray.charAt(i12), 128) < 0) {
                            bArr[i14] = (byte) commonAsUtf8ToByteArray.charAt(i12);
                            i12++;
                            i14++;
                        }
                        i13 = i14;
                    } else {
                        if (Intrinsics.i(cCharAt3, 2048) < 0) {
                            bArr[i13] = (byte) ((cCharAt3 >> 6) | PsExtractor.AUDIO_STREAM);
                            i13 += 2;
                            bArr[i13 + 1] = (byte) ((cCharAt3 & '?') | 128);
                        } else if (55296 > cCharAt3 || 57343 < cCharAt3) {
                            bArr[i13] = (byte) ((cCharAt3 >> '\f') | 224);
                            bArr[i13 + 1] = (byte) (((cCharAt3 >> 6) & 63) | 128);
                            i13 += 3;
                            bArr[i13 + 2] = (byte) ((cCharAt3 & '?') | 128);
                        } else if (Intrinsics.i(cCharAt3, 56319) > 0 || length2 <= (i11 = i12 + 1) || 56320 > (cCharAt = commonAsUtf8ToByteArray.charAt(i11)) || 57343 < cCharAt) {
                            bArr[i13] = Utf8.REPLACEMENT_BYTE;
                            i12++;
                            i13++;
                        } else {
                            int iCharAt = ((cCharAt3 << '\n') + commonAsUtf8ToByteArray.charAt(i11)) - 56613888;
                            bArr[i13] = (byte) ((iCharAt >> 18) | 240);
                            bArr[i13 + 1] = (byte) (((iCharAt >> 12) & 63) | 128);
                            bArr[i13 + 2] = (byte) (((iCharAt >> 6) & 63) | 128);
                            i13 += 4;
                            bArr[i13 + 3] = (byte) ((iCharAt & 63) | 128);
                            i12 += 2;
                        }
                        i12++;
                    }
                }
                byte[] bArrCopyOf = Arrays.copyOf(bArr, i13);
                Intrinsics.f(bArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
                return bArrCopyOf;
            }
            bArr[i12] = (byte) cCharAt2;
            i12++;
        }
        byte[] bArrCopyOf2 = Arrays.copyOf(bArr, commonAsUtf8ToByteArray.length());
        Intrinsics.f(bArrCopyOf2, "java.util.Arrays.copyOf(this, newSize)");
        return bArrCopyOf2;
    }

    public static final String commonToUtf8String(byte[] commonToUtf8String, int i11, int i12) {
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18 = i11;
        Intrinsics.g(commonToUtf8String, "$this$commonToUtf8String");
        if (i18 < 0 || i12 > commonToUtf8String.length || i18 > i12) {
            throw new ArrayIndexOutOfBoundsException("size=" + commonToUtf8String.length + " beginIndex=" + i18 + " endIndex=" + i12);
        }
        char[] cArr = new char[i12 - i18];
        int i19 = 0;
        while (i18 < i12) {
            byte b11 = commonToUtf8String[i18];
            if (b11 >= 0) {
                i13 = i19 + 1;
                cArr[i19] = (char) b11;
                i18++;
                while (i18 < i12) {
                    byte b12 = commonToUtf8String[i18];
                    if (b12 < 0) {
                        break;
                    }
                    i18++;
                    cArr[i13] = (char) b12;
                    i13++;
                }
            } else if ((b11 >> 5) == -2) {
                int i21 = i18 + 1;
                if (i12 <= i21) {
                    i13 = i19 + 1;
                    cArr[i19] = (char) Utf8.REPLACEMENT_CODE_POINT;
                } else {
                    byte b13 = commonToUtf8String[i21];
                    if ((b13 & 192) == 128) {
                        int i22 = (b11 << 6) ^ (b13 ^ 3968);
                        if (i22 < 128) {
                            i13 = i19 + 1;
                            cArr[i19] = (char) Utf8.REPLACEMENT_CODE_POINT;
                        } else {
                            i13 = i19 + 1;
                            cArr[i19] = (char) i22;
                        }
                        Unit unit = Unit.f68710a;
                        i18 += i14;
                    } else {
                        i13 = i19 + 1;
                        cArr[i19] = (char) Utf8.REPLACEMENT_CODE_POINT;
                    }
                }
                Unit unit2 = Unit.f68710a;
                i18 += i14;
            } else if ((b11 >> 4) == -2) {
                int i23 = i18 + 2;
                if (i12 <= i23) {
                    i13 = i19 + 1;
                    cArr[i19] = (char) Utf8.REPLACEMENT_CODE_POINT;
                    Unit unit3 = Unit.f68710a;
                    int i24 = i18 + 1;
                    i14 = (i12 <= i24 || (commonToUtf8String[i24] & 192) != 128) ? 1 : 2;
                } else {
                    byte b14 = commonToUtf8String[i18 + 1];
                    if ((b14 & 192) == 128) {
                        byte b15 = commonToUtf8String[i23];
                        if ((b15 & 192) == 128) {
                            int i25 = (b11 << Ascii.FF) ^ ((b15 ^ (-123008)) ^ (b14 << 6));
                            if (i25 < 2048) {
                                i13 = i19 + 1;
                                cArr[i19] = (char) Utf8.REPLACEMENT_CODE_POINT;
                            } else if (55296 <= i25 && 57343 >= i25) {
                                i13 = i19 + 1;
                                cArr[i19] = (char) Utf8.REPLACEMENT_CODE_POINT;
                            } else {
                                i13 = i19 + 1;
                                cArr[i19] = (char) i25;
                            }
                            Unit unit4 = Unit.f68710a;
                            i14 = 3;
                        } else {
                            i13 = i19 + 1;
                            cArr[i19] = (char) Utf8.REPLACEMENT_CODE_POINT;
                            Unit unit5 = Unit.f68710a;
                        }
                    } else {
                        i13 = i19 + 1;
                        cArr[i19] = (char) Utf8.REPLACEMENT_CODE_POINT;
                        Unit unit6 = Unit.f68710a;
                    }
                }
                i18 += i14;
            } else {
                if ((b11 >> 3) == -2) {
                    int i26 = i18 + 3;
                    if (i12 <= i26) {
                        i15 = i19 + 1;
                        cArr[i19] = Utf8.REPLACEMENT_CHARACTER;
                        Unit unit7 = Unit.f68710a;
                        int i27 = i18 + 1;
                        if (i12 <= i27 || (commonToUtf8String[i27] & 192) != 128) {
                            i17 = 1;
                        } else {
                            int i28 = i18 + 2;
                            i17 = (i12 <= i28 || (commonToUtf8String[i28] & 192) != 128) ? 2 : 3;
                        }
                    } else {
                        byte b16 = commonToUtf8String[i18 + 1];
                        if ((b16 & 192) == 128) {
                            byte b17 = commonToUtf8String[i18 + 2];
                            if ((b17 & 192) == 128) {
                                byte b18 = commonToUtf8String[i26];
                                if ((b18 & 192) == 128) {
                                    int i29 = (b11 << Ascii.DC2) ^ (((b18 ^ 3678080) ^ (b17 << 6)) ^ (b16 << Ascii.FF));
                                    if (i29 > 1114111) {
                                        i15 = i19 + 1;
                                        cArr[i19] = Utf8.REPLACEMENT_CHARACTER;
                                    } else {
                                        if ((55296 <= i29 && 57343 >= i29) || i29 < 65536) {
                                            i15 = i19 + 1;
                                            cArr[i19] = Utf8.REPLACEMENT_CHARACTER;
                                        } else {
                                            if (i29 != 65533) {
                                                cArr[i19] = (char) ((i29 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                                                i16 = i19 + 2;
                                                cArr[i19 + 1] = (char) ((i29 & 1023) + Utf8.LOG_SURROGATE_HEADER);
                                            } else {
                                                cArr[i19] = Utf8.REPLACEMENT_CHARACTER;
                                                i16 = i19 + 1;
                                            }
                                            Unit unit8 = Unit.f68710a;
                                            i15 = i16;
                                        }
                                        i17 = 4;
                                    }
                                    Unit unit9 = Unit.f68710a;
                                    i17 = 4;
                                } else {
                                    i15 = i19 + 1;
                                    cArr[i19] = Utf8.REPLACEMENT_CHARACTER;
                                    Unit unit10 = Unit.f68710a;
                                }
                            } else {
                                i15 = i19 + 1;
                                cArr[i19] = Utf8.REPLACEMENT_CHARACTER;
                                Unit unit11 = Unit.f68710a;
                            }
                        } else {
                            i15 = i19 + 1;
                            cArr[i19] = Utf8.REPLACEMENT_CHARACTER;
                            Unit unit12 = Unit.f68710a;
                            i17 = 1;
                        }
                    }
                    i18 += i17;
                } else {
                    i15 = i19 + 1;
                    cArr[i19] = Utf8.REPLACEMENT_CHARACTER;
                    i18++;
                }
                i19 = i15;
            }
            i19 = i13;
        }
        return new String(cArr, 0, i19);
    }

    public static /* synthetic */ String commonToUtf8String$default(byte[] bArr, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = 0;
        }
        if ((i13 & 2) != 0) {
            i12 = bArr.length;
        }
        return commonToUtf8String(bArr, i11, i12);
    }
}
