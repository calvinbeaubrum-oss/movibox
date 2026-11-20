package okio;

import com.applovin.exoplayer2.common.base.Ascii;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

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
public final class Utf8 {
    public static final int HIGH_SURROGATE_HEADER = 55232;
    public static final int LOG_SURROGATE_HEADER = 56320;
    public static final int MASK_2BYTES = 3968;
    public static final int MASK_3BYTES = -123008;
    public static final int MASK_4BYTES = 3678080;
    public static final byte REPLACEMENT_BYTE = 63;
    public static final char REPLACEMENT_CHARACTER = 65533;
    public static final int REPLACEMENT_CODE_POINT = 65533;

    public static final boolean isIsoControl(int i11) {
        return (i11 >= 0 && 31 >= i11) || (127 <= i11 && 159 >= i11);
    }

    public static final boolean isUtf8Continuation(byte b11) {
        return (b11 & 192) == 128;
    }

    public static final int process2Utf8Bytes(byte[] process2Utf8Bytes, int i11, int i12, Function1<? super Integer, Unit> yield) {
        Intrinsics.g(process2Utf8Bytes, "$this$process2Utf8Bytes");
        Intrinsics.g(yield, "yield");
        int i13 = i11 + 1;
        Integer numValueOf = Integer.valueOf(REPLACEMENT_CODE_POINT);
        if (i12 <= i13) {
            yield.invoke(numValueOf);
            return 1;
        }
        byte b11 = process2Utf8Bytes[i11];
        byte b12 = process2Utf8Bytes[i13];
        if ((b12 & 192) != 128) {
            yield.invoke(numValueOf);
            return 1;
        }
        int i14 = (b12 ^ 3968) ^ (b11 << 6);
        if (i14 < 128) {
            yield.invoke(numValueOf);
            return 2;
        }
        yield.invoke(Integer.valueOf(i14));
        return 2;
    }

    public static final int process3Utf8Bytes(byte[] process3Utf8Bytes, int i11, int i12, Function1<? super Integer, Unit> yield) {
        Intrinsics.g(process3Utf8Bytes, "$this$process3Utf8Bytes");
        Intrinsics.g(yield, "yield");
        int i13 = i11 + 2;
        Integer numValueOf = Integer.valueOf(REPLACEMENT_CODE_POINT);
        if (i12 <= i13) {
            yield.invoke(numValueOf);
            int i14 = i11 + 1;
            return (i12 <= i14 || (process3Utf8Bytes[i14] & 192) != 128) ? 1 : 2;
        }
        byte b11 = process3Utf8Bytes[i11];
        byte b12 = process3Utf8Bytes[i11 + 1];
        if ((b12 & 192) != 128) {
            yield.invoke(numValueOf);
            return 1;
        }
        byte b13 = process3Utf8Bytes[i13];
        if ((b13 & 192) != 128) {
            yield.invoke(numValueOf);
            return 2;
        }
        int i15 = ((b13 ^ (-123008)) ^ (b12 << 6)) ^ (b11 << Ascii.FF);
        if (i15 < 2048) {
            yield.invoke(numValueOf);
            return 3;
        }
        if (55296 <= i15 && 57343 >= i15) {
            yield.invoke(numValueOf);
            return 3;
        }
        yield.invoke(Integer.valueOf(i15));
        return 3;
    }

    public static final int process4Utf8Bytes(byte[] process4Utf8Bytes, int i11, int i12, Function1<? super Integer, Unit> yield) {
        Intrinsics.g(process4Utf8Bytes, "$this$process4Utf8Bytes");
        Intrinsics.g(yield, "yield");
        int i13 = i11 + 3;
        Integer numValueOf = Integer.valueOf(REPLACEMENT_CODE_POINT);
        if (i12 <= i13) {
            yield.invoke(numValueOf);
            int i14 = i11 + 1;
            if (i12 <= i14 || (process4Utf8Bytes[i14] & 192) != 128) {
                return 1;
            }
            int i15 = i11 + 2;
            return (i12 <= i15 || (process4Utf8Bytes[i15] & 192) != 128) ? 2 : 3;
        }
        byte b11 = process4Utf8Bytes[i11];
        byte b12 = process4Utf8Bytes[i11 + 1];
        if ((b12 & 192) != 128) {
            yield.invoke(numValueOf);
            return 1;
        }
        byte b13 = process4Utf8Bytes[i11 + 2];
        if ((b13 & 192) != 128) {
            yield.invoke(numValueOf);
            return 2;
        }
        byte b14 = process4Utf8Bytes[i13];
        if ((b14 & 192) != 128) {
            yield.invoke(numValueOf);
            return 3;
        }
        int i16 = (((b14 ^ 3678080) ^ (b13 << 6)) ^ (b12 << Ascii.FF)) ^ (b11 << Ascii.DC2);
        if (i16 > 1114111) {
            yield.invoke(numValueOf);
            return 4;
        }
        if (55296 <= i16 && 57343 >= i16) {
            yield.invoke(numValueOf);
            return 4;
        }
        if (i16 < 65536) {
            yield.invoke(numValueOf);
            return 4;
        }
        yield.invoke(Integer.valueOf(i16));
        return 4;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0045  */
    public static final void processUtf16Chars(byte[] processUtf16Chars, int i11, int i12, Function1<? super Character, Unit> yield) {
        Intrinsics.g(processUtf16Chars, "$this$processUtf16Chars");
        Intrinsics.g(yield, "yield");
        while (i11 < i12) {
            byte b11 = processUtf16Chars[i11];
            if (b11 >= 0) {
                yield.invoke(Character.valueOf((char) b11));
                i11++;
                while (i11 < i12) {
                    byte b12 = processUtf16Chars[i11];
                    if (b12 < 0) {
                        break;
                    }
                    i11++;
                    yield.invoke(Character.valueOf((char) b12));
                }
            } else {
                int i13 = 2;
                if ((b11 >> 5) == -2) {
                    int i14 = i11 + 1;
                    if (i12 > i14) {
                        byte b13 = processUtf16Chars[i14];
                        if ((b13 & 192) == 128) {
                            int i15 = (b11 << 6) ^ (b13 ^ 3968);
                            yield.invoke(Character.valueOf(i15 < 128 ? (char) REPLACEMENT_CODE_POINT : (char) i15));
                            Unit unit = Unit.f68710a;
                        }
                        i11 += i13;
                    }
                    yield.invoke(Character.valueOf((char) REPLACEMENT_CODE_POINT));
                    Unit unit2 = Unit.f68710a;
                    i13 = 1;
                    i11 += i13;
                } else if ((b11 >> 4) == -2) {
                    int i16 = i11 + 2;
                    if (i12 <= i16) {
                        yield.invoke(Character.valueOf((char) REPLACEMENT_CODE_POINT));
                        Unit unit3 = Unit.f68710a;
                        int i17 = i11 + 1;
                        if (i12 <= i17 || (processUtf16Chars[i17] & 192) != 128) {
                            i13 = 1;
                        }
                    } else {
                        byte b14 = processUtf16Chars[i11 + 1];
                        if ((b14 & 192) == 128) {
                            byte b15 = processUtf16Chars[i16];
                            if ((b15 & 192) == 128) {
                                int i18 = (b11 << Ascii.FF) ^ ((b15 ^ (-123008)) ^ (b14 << 6));
                                yield.invoke(Character.valueOf((i18 >= 2048 && (55296 > i18 || 57343 < i18)) ? (char) i18 : (char) REPLACEMENT_CODE_POINT));
                                Unit unit4 = Unit.f68710a;
                                i13 = 3;
                            } else {
                                yield.invoke(Character.valueOf((char) REPLACEMENT_CODE_POINT));
                                Unit unit5 = Unit.f68710a;
                            }
                        } else {
                            yield.invoke(Character.valueOf((char) REPLACEMENT_CODE_POINT));
                            Unit unit6 = Unit.f68710a;
                            i13 = 1;
                        }
                    }
                    i11 += i13;
                } else if ((b11 >> 3) == -2) {
                    int i19 = i11 + 3;
                    if (i12 <= i19) {
                        yield.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
                        Unit unit7 = Unit.f68710a;
                        int i21 = i11 + 1;
                        if (i12 <= i21 || (processUtf16Chars[i21] & 192) != 128) {
                            i13 = 1;
                        } else {
                            int i22 = i11 + 2;
                            if (i12 > i22 && (processUtf16Chars[i22] & 192) == 128) {
                                i13 = 3;
                            }
                        }
                    } else {
                        byte b16 = processUtf16Chars[i11 + 1];
                        if ((b16 & 192) == 128) {
                            byte b17 = processUtf16Chars[i11 + 2];
                            if ((b17 & 192) == 128) {
                                byte b18 = processUtf16Chars[i19];
                                if ((b18 & 192) == 128) {
                                    int i23 = (b11 << Ascii.DC2) ^ (((b18 ^ 3678080) ^ (b17 << 6)) ^ (b16 << Ascii.FF));
                                    if (i23 <= 1114111 && ((55296 > i23 || 57343 < i23) && i23 >= 65536 && i23 != 65533)) {
                                        yield.invoke(Character.valueOf((char) ((i23 >>> 10) + HIGH_SURROGATE_HEADER)));
                                        yield.invoke(Character.valueOf((char) ((i23 & 1023) + LOG_SURROGATE_HEADER)));
                                    } else {
                                        yield.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
                                    }
                                    Unit unit8 = Unit.f68710a;
                                    i13 = 4;
                                } else {
                                    yield.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
                                    Unit unit9 = Unit.f68710a;
                                    i13 = 3;
                                }
                            } else {
                                yield.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
                                Unit unit10 = Unit.f68710a;
                            }
                        } else {
                            yield.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
                            Unit unit11 = Unit.f68710a;
                            i13 = 1;
                        }
                    }
                    i11 += i13;
                } else {
                    yield.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
                    i11++;
                }
            }
        }
    }

    public static final void processUtf8Bytes(String processUtf8Bytes, int i11, int i12, Function1<? super Byte, Unit> yield) {
        int i13;
        char cCharAt;
        Intrinsics.g(processUtf8Bytes, "$this$processUtf8Bytes");
        Intrinsics.g(yield, "yield");
        while (i11 < i12) {
            char cCharAt2 = processUtf8Bytes.charAt(i11);
            if (Intrinsics.i(cCharAt2, 128) < 0) {
                yield.invoke(Byte.valueOf((byte) cCharAt2));
                i11++;
                while (i11 < i12 && Intrinsics.i(processUtf8Bytes.charAt(i11), 128) < 0) {
                    yield.invoke(Byte.valueOf((byte) processUtf8Bytes.charAt(i11)));
                    i11++;
                }
            } else {
                if (Intrinsics.i(cCharAt2, 2048) < 0) {
                    yield.invoke(Byte.valueOf((byte) ((cCharAt2 >> 6) | PsExtractor.AUDIO_STREAM)));
                    yield.invoke(Byte.valueOf((byte) ((cCharAt2 & '?') | 128)));
                } else if (55296 > cCharAt2 || 57343 < cCharAt2) {
                    yield.invoke(Byte.valueOf((byte) ((cCharAt2 >> '\f') | 224)));
                    yield.invoke(Byte.valueOf((byte) (((cCharAt2 >> 6) & 63) | 128)));
                    yield.invoke(Byte.valueOf((byte) ((cCharAt2 & '?') | 128)));
                } else if (Intrinsics.i(cCharAt2, 56319) > 0 || i12 <= (i13 = i11 + 1) || 56320 > (cCharAt = processUtf8Bytes.charAt(i13)) || 57343 < cCharAt) {
                    yield.invoke(Byte.valueOf(REPLACEMENT_BYTE));
                } else {
                    int iCharAt = ((cCharAt2 << '\n') + processUtf8Bytes.charAt(i13)) - 56613888;
                    yield.invoke(Byte.valueOf((byte) ((iCharAt >> 18) | 240)));
                    yield.invoke(Byte.valueOf((byte) (((iCharAt >> 12) & 63) | 128)));
                    yield.invoke(Byte.valueOf((byte) (((iCharAt >> 6) & 63) | 128)));
                    yield.invoke(Byte.valueOf((byte) ((iCharAt & 63) | 128)));
                    i11 += 2;
                }
                i11++;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0042  */
    public static final void processUtf8CodePoints(byte[] processUtf8CodePoints, int i11, int i12, Function1<? super Integer, Unit> yield) {
        Intrinsics.g(processUtf8CodePoints, "$this$processUtf8CodePoints");
        Intrinsics.g(yield, "yield");
        while (i11 < i12) {
            byte b11 = processUtf8CodePoints[i11];
            if (b11 >= 0) {
                yield.invoke(Integer.valueOf(b11));
                i11++;
                while (i11 < i12) {
                    byte b12 = processUtf8CodePoints[i11];
                    if (b12 < 0) {
                        break;
                    }
                    i11++;
                    yield.invoke(Integer.valueOf(b12));
                }
            } else {
                int i13 = 2;
                if ((b11 >> 5) == -2) {
                    int i14 = i11 + 1;
                    if (i12 > i14) {
                        byte b13 = processUtf8CodePoints[i14];
                        if ((b13 & 192) == 128) {
                            int i15 = (b11 << 6) ^ (b13 ^ 3968);
                            yield.invoke(i15 < 128 ? Integer.valueOf(REPLACEMENT_CODE_POINT) : Integer.valueOf(i15));
                            Unit unit = Unit.f68710a;
                        }
                        i11 += i13;
                    }
                    yield.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                    Unit unit2 = Unit.f68710a;
                    i13 = 1;
                    i11 += i13;
                } else if ((b11 >> 4) == -2) {
                    int i16 = i11 + 2;
                    if (i12 <= i16) {
                        yield.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                        Unit unit3 = Unit.f68710a;
                        int i17 = i11 + 1;
                        if (i12 <= i17 || (processUtf8CodePoints[i17] & 192) != 128) {
                            i13 = 1;
                        }
                    } else {
                        byte b14 = processUtf8CodePoints[i11 + 1];
                        if ((b14 & 192) == 128) {
                            byte b15 = processUtf8CodePoints[i16];
                            if ((b15 & 192) == 128) {
                                int i18 = (b11 << Ascii.FF) ^ ((b15 ^ (-123008)) ^ (b14 << 6));
                                yield.invoke((i18 >= 2048 && (55296 > i18 || 57343 < i18)) ? Integer.valueOf(i18) : Integer.valueOf(REPLACEMENT_CODE_POINT));
                                Unit unit4 = Unit.f68710a;
                                i13 = 3;
                            } else {
                                yield.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                                Unit unit5 = Unit.f68710a;
                            }
                        } else {
                            yield.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                            Unit unit6 = Unit.f68710a;
                            i13 = 1;
                        }
                    }
                    i11 += i13;
                } else if ((b11 >> 3) == -2) {
                    int i19 = i11 + 3;
                    if (i12 <= i19) {
                        yield.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                        Unit unit7 = Unit.f68710a;
                        int i21 = i11 + 1;
                        if (i12 <= i21 || (processUtf8CodePoints[i21] & 192) != 128) {
                            i13 = 1;
                        } else {
                            int i22 = i11 + 2;
                            if (i12 > i22 && (processUtf8CodePoints[i22] & 192) == 128) {
                                i13 = 3;
                            }
                        }
                    } else {
                        byte b16 = processUtf8CodePoints[i11 + 1];
                        if ((b16 & 192) == 128) {
                            byte b17 = processUtf8CodePoints[i11 + 2];
                            if ((b17 & 192) == 128) {
                                byte b18 = processUtf8CodePoints[i19];
                                if ((b18 & 192) == 128) {
                                    int i23 = (b11 << Ascii.DC2) ^ (((b18 ^ 3678080) ^ (b17 << 6)) ^ (b16 << Ascii.FF));
                                    yield.invoke((i23 <= 1114111 && (55296 > i23 || 57343 < i23) && i23 >= 65536) ? Integer.valueOf(i23) : Integer.valueOf(REPLACEMENT_CODE_POINT));
                                    Unit unit8 = Unit.f68710a;
                                    i13 = 4;
                                } else {
                                    yield.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                                    Unit unit9 = Unit.f68710a;
                                    i13 = 3;
                                }
                            } else {
                                yield.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                                Unit unit10 = Unit.f68710a;
                            }
                        } else {
                            yield.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                            Unit unit11 = Unit.f68710a;
                            i13 = 1;
                        }
                    }
                    i11 += i13;
                } else {
                    yield.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                    i11++;
                }
            }
        }
    }

    @JvmOverloads
    @JvmName
    public static final long size(String str) {
        return size$default(str, 0, 0, 3, null);
    }

    @JvmOverloads
    @JvmName
    public static final long size(String str, int i11) {
        return size$default(str, i11, 0, 2, null);
    }

    @JvmOverloads
    @JvmName
    public static final long size(String utf8Size, int i11, int i12) {
        int i13;
        Intrinsics.g(utf8Size, "$this$utf8Size");
        if (!(i11 >= 0)) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i11).toString());
        }
        if (!(i12 >= i11)) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i12 + " < " + i11).toString());
        }
        if (!(i12 <= utf8Size.length())) {
            throw new IllegalArgumentException(("endIndex > string.length: " + i12 + " > " + utf8Size.length()).toString());
        }
        long j11 = 0;
        while (i11 < i12) {
            char cCharAt = utf8Size.charAt(i11);
            if (cCharAt < 128) {
                j11++;
            } else {
                if (cCharAt < 2048) {
                    i13 = 2;
                } else if (cCharAt < 55296 || cCharAt > 57343) {
                    i13 = 3;
                } else {
                    int i14 = i11 + 1;
                    char cCharAt2 = i14 < i12 ? utf8Size.charAt(i14) : (char) 0;
                    if (cCharAt > 56319 || cCharAt2 < 56320 || cCharAt2 > 57343) {
                        j11++;
                        i11 = i14;
                    } else {
                        j11 += (long) 4;
                        i11 += 2;
                    }
                }
                j11 += (long) i13;
            }
            i11++;
        }
        return j11;
    }

    public static /* synthetic */ long size$default(String str, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = 0;
        }
        if ((i13 & 2) != 0) {
            i12 = str.length();
        }
        return size(str, i11, i12);
    }
}
