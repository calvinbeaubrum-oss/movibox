package androidx.compose.ui.graphics;

import androidx.compose.ui.graphics.colorspace.Rgb;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.internal.ws.WebSocketProtocol;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class y1 {
    /* JADX WARN: Code duplicated, block: B:102:0x014a  */
    /* JADX WARN: Code duplicated, block: B:103:0x014c  */
    /* JADX WARN: Code duplicated, block: B:105:0x0152  */
    /* JADX WARN: Code duplicated, block: B:107:0x015c  */
    /* JADX WARN: Code duplicated, block: B:112:0x0174  */
    /* JADX WARN: Code duplicated, block: B:116:0x017b  */
    /* JADX WARN: Code duplicated, block: B:119:0x0188 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:121:0x018b  */
    /* JADX WARN: Code duplicated, block: B:123:0x0190  */
    /* JADX WARN: Code duplicated, block: B:125:0x0194  */
    /* JADX WARN: Code duplicated, block: B:127:0x0199 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:128:0x019b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:129:0x019d  */
    /* JADX WARN: Code duplicated, block: B:131:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:133:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:134:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:136:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:138:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:143:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:147:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:81:0x0111  */
    /* JADX WARN: Code duplicated, block: B:85:0x0118  */
    /* JADX WARN: Code duplicated, block: B:88:0x0126 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:89:0x0128  */
    /* JADX WARN: Code duplicated, block: B:90:0x012b  */
    /* JADX WARN: Code duplicated, block: B:92:0x012f  */
    /* JADX WARN: Code duplicated, block: B:94:0x0133  */
    /* JADX WARN: Code duplicated, block: B:95:0x0137 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:96:0x0139 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:97:0x013b  */
    /* JADX WARN: Code duplicated, block: B:99:0x0144  */
    public static final long a(float f11, float f12, float f13, float f14, androidx.compose.ui.graphics.colorspace.c cVar) {
        int i11;
        int i12;
        int i13;
        float f15;
        float fE;
        int iFloatToRawIntBits;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i21;
        int i22;
        float f16;
        float fE2;
        int iFloatToRawIntBits2;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        int i31;
        float f17;
        if (cVar.i()) {
            float f18 = f14 < 0.0f ? 0.0f : f14;
            if (f18 > 1.0f) {
                f18 = 1.0f;
            }
            int i32 = ((int) ((f18 * 255.0f) + 0.5f)) << 24;
            float f19 = f11 < 0.0f ? 0.0f : f11;
            if (f19 > 1.0f) {
                f19 = 1.0f;
            }
            int i33 = i32 | (((int) ((f19 * 255.0f) + 0.5f)) << 16);
            float f21 = f12 < 0.0f ? 0.0f : f12;
            if (f21 > 1.0f) {
                f21 = 1.0f;
            }
            int i34 = i33 | (((int) ((f21 * 255.0f) + 0.5f)) << 8);
            f17 = f13 >= 0.0f ? f13 : 0.0f;
            return w1.h(ULong.b(ULong.b(i34 | ((int) (((f17 <= 1.0f ? f17 : 1.0f) * 255.0f) + 0.5f))) << 32));
        }
        if (!(cVar.c() == 3)) {
            j4.a("Color only works with ColorSpaces with 3 components");
        }
        int iD = cVar.d();
        if (!(iD != -1)) {
            j4.a("Unknown color space, please use a color space in ColorSpaces");
        }
        float f22 = cVar.f(0);
        float fE3 = cVar.e(0);
        if (f11 >= f22) {
            f22 = f11;
        }
        if (f22 <= fE3) {
            fE3 = f22;
        }
        int iFloatToRawIntBits3 = Float.floatToRawIntBits(fE3);
        int i35 = iFloatToRawIntBits3 >>> 31;
        int i36 = (iFloatToRawIntBits3 >>> 23) & 255;
        int i37 = iFloatToRawIntBits3 & 8388607;
        int i38 = 31;
        if (i36 == 255) {
            i12 = i37 != 0 ? 512 : 0;
            i11 = 31;
        } else {
            i11 = i36 - 112;
            if (i11 >= 31) {
                i12 = 0;
                i11 = 49;
            } else {
                if (i11 > 0) {
                    int i39 = i37 >> 13;
                    if ((iFloatToRawIntBits3 & 4096) != 0) {
                        i13 = (((i11 << 10) | i39) + 1) | (i35 << 15);
                    } else {
                        i12 = i39;
                    }
                    short s11 = (short) i13;
                    f15 = cVar.f(1);
                    fE = cVar.e(1);
                    if (f12 >= f15) {
                        f15 = f12;
                    }
                    if (f15 <= fE) {
                        fE = f15;
                    }
                    iFloatToRawIntBits = Float.floatToRawIntBits(fE);
                    i14 = iFloatToRawIntBits >>> 31;
                    i15 = (iFloatToRawIntBits >>> 23) & 255;
                    i16 = iFloatToRawIntBits & 8388607;
                    if (i15 == 255) {
                        if (i16 != 0) {
                            i19 = 512;
                        } else {
                            i19 = 0;
                        }
                        i17 = 31;
                    } else {
                        i17 = i15 - 112;
                        if (i17 >= 31) {
                            i19 = 0;
                            i17 = 49;
                        } else {
                            if (i17 <= 0) {
                                i18 = i16 >> 13;
                                if ((iFloatToRawIntBits & 4096) != 0) {
                                    i21 = (((i17 << 10) | i18) + 1) | (i14 << 15);
                                } else {
                                    i19 = i18;
                                }
                                short s12 = (short) i21;
                                f16 = cVar.f(2);
                                fE2 = cVar.e(2);
                                if (f13 >= f16) {
                                    f16 = f13;
                                }
                                if (f16 <= fE2) {
                                    fE2 = f16;
                                }
                                iFloatToRawIntBits2 = Float.floatToRawIntBits(fE2);
                                i23 = iFloatToRawIntBits2 >>> 31;
                                i24 = (iFloatToRawIntBits2 >>> 23) & 255;
                                i25 = 8388607 & iFloatToRawIntBits2;
                                if (i24 == 255) {
                                    i28 = i25 == 0 ? 0 : 512;
                                } else {
                                    i26 = i24 - 112;
                                    if (i26 >= 31) {
                                        i38 = 49;
                                    } else {
                                        if (i26 <= 0) {
                                            i27 = i25 >> 13;
                                            if ((iFloatToRawIntBits2 & 4096) != 0) {
                                                i29 = (((i26 << 10) | i27) + 1) | (i23 << 15);
                                            } else {
                                                i28 = i27;
                                                i38 = i26;
                                            }
                                            short s13 = (short) i29;
                                            f17 = f14 >= 0.0f ? f14 : 0.0f;
                                            return w1.h(ULong.b((((long) iD) & 63) | ((((long) ((int) (((f17 <= 1.0f ? f17 : 1.0f) * 1023.0f) + 0.5f))) & 1023) << 6) | ((((long) s11) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) s12) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | ((WebSocketProtocol.PAYLOAD_SHORT_MAX & ((long) s13)) << 16)));
                                        }
                                        if (i26 >= -10) {
                                            i31 = (i25 | 8388608) >> (1 - i26);
                                            if ((i31 & 4096) != 0) {
                                                i31 += 8192;
                                            }
                                            i28 = i31 >> 13;
                                            i38 = 0;
                                        } else {
                                            i38 = 0;
                                        }
                                    }
                                    i28 = 0;
                                }
                                i29 = (i23 << 15) | (i38 << 10) | i28;
                                short s14 = (short) i29;
                                if (f14 >= 0.0f) {
                                }
                                return w1.h(ULong.b((((long) iD) & 63) | ((((long) ((int) (((f17 <= 1.0f ? f17 : 1.0f) * 1023.0f) + 0.5f))) & 1023) << 6) | ((((long) s11) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) s12) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | ((WebSocketProtocol.PAYLOAD_SHORT_MAX & ((long) s14)) << 16)));
                            }
                            if (i17 >= -10) {
                                i22 = (i16 | 8388608) >> (1 - i17);
                                if ((i22 & 4096) != 0) {
                                    i22 += 8192;
                                }
                                i19 = i22 >> 13;
                            } else {
                                i19 = 0;
                            }
                            i17 = 0;
                        }
                    }
                    i21 = i19 | (i14 << 15) | (i17 << 10);
                    short s15 = (short) i21;
                    f16 = cVar.f(2);
                    fE2 = cVar.e(2);
                    if (f13 >= f16) {
                        f16 = f13;
                    }
                    if (f16 <= fE2) {
                        fE2 = f16;
                    }
                    iFloatToRawIntBits2 = Float.floatToRawIntBits(fE2);
                    i23 = iFloatToRawIntBits2 >>> 31;
                    i24 = (iFloatToRawIntBits2 >>> 23) & 255;
                    i25 = 8388607 & iFloatToRawIntBits2;
                    if (i24 == 255) {
                        i28 = i25 == 0 ? 0 : 512;
                    } else {
                        i26 = i24 - 112;
                        if (i26 >= 31) {
                            i38 = 49;
                        } else {
                            if (i26 <= 0) {
                                i27 = i25 >> 13;
                                if ((iFloatToRawIntBits2 & 4096) != 0) {
                                    i29 = (((i26 << 10) | i27) + 1) | (i23 << 15);
                                } else {
                                    i28 = i27;
                                    i38 = i26;
                                }
                                short s16 = (short) i29;
                                if (f14 >= 0.0f) {
                                }
                                return w1.h(ULong.b((((long) iD) & 63) | ((((long) ((int) (((f17 <= 1.0f ? f17 : 1.0f) * 1023.0f) + 0.5f))) & 1023) << 6) | ((((long) s11) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) s15) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | ((WebSocketProtocol.PAYLOAD_SHORT_MAX & ((long) s16)) << 16)));
                            }
                            if (i26 >= -10) {
                                i31 = (i25 | 8388608) >> (1 - i26);
                                if ((i31 & 4096) != 0) {
                                    i31 += 8192;
                                }
                                i28 = i31 >> 13;
                                i38 = 0;
                            } else {
                                i38 = 0;
                            }
                        }
                        i28 = 0;
                    }
                    i29 = (i23 << 15) | (i38 << 10) | i28;
                    short s17 = (short) i29;
                    if (f14 >= 0.0f) {
                    }
                    return w1.h(ULong.b((((long) iD) & 63) | ((((long) ((int) (((f17 <= 1.0f ? f17 : 1.0f) * 1023.0f) + 0.5f))) & 1023) << 6) | ((((long) s11) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) s15) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | ((WebSocketProtocol.PAYLOAD_SHORT_MAX & ((long) s17)) << 16)));
                }
                if (i11 >= -10) {
                    int i40 = (i37 | 8388608) >> (1 - i11);
                    if ((i40 & 4096) != 0) {
                        i40 += 8192;
                    }
                    i12 = i40 >> 13;
                } else {
                    i12 = 0;
                }
                i11 = 0;
            }
        }
        i13 = i12 | (i35 << 15) | (i11 << 10);
        short s18 = (short) i13;
        f15 = cVar.f(1);
        fE = cVar.e(1);
        if (f12 >= f15) {
            f15 = f12;
        }
        if (f15 <= fE) {
            fE = f15;
        }
        iFloatToRawIntBits = Float.floatToRawIntBits(fE);
        i14 = iFloatToRawIntBits >>> 31;
        i15 = (iFloatToRawIntBits >>> 23) & 255;
        i16 = iFloatToRawIntBits & 8388607;
        if (i15 == 255) {
            if (i16 != 0) {
                i19 = 512;
            } else {
                i19 = 0;
            }
            i17 = 31;
        } else {
            i17 = i15 - 112;
            if (i17 >= 31) {
                i19 = 0;
                i17 = 49;
            } else {
                if (i17 <= 0) {
                    i18 = i16 >> 13;
                    if ((iFloatToRawIntBits & 4096) != 0) {
                        i21 = (((i17 << 10) | i18) + 1) | (i14 << 15);
                    } else {
                        i19 = i18;
                    }
                    short s19 = (short) i21;
                    f16 = cVar.f(2);
                    fE2 = cVar.e(2);
                    if (f13 >= f16) {
                        f16 = f13;
                    }
                    if (f16 <= fE2) {
                        fE2 = f16;
                    }
                    iFloatToRawIntBits2 = Float.floatToRawIntBits(fE2);
                    i23 = iFloatToRawIntBits2 >>> 31;
                    i24 = (iFloatToRawIntBits2 >>> 23) & 255;
                    i25 = 8388607 & iFloatToRawIntBits2;
                    if (i24 == 255) {
                        i28 = i25 == 0 ? 0 : 512;
                    } else {
                        i26 = i24 - 112;
                        if (i26 >= 31) {
                            i38 = 49;
                        } else {
                            if (i26 <= 0) {
                                i27 = i25 >> 13;
                                if ((iFloatToRawIntBits2 & 4096) != 0) {
                                    i29 = (((i26 << 10) | i27) + 1) | (i23 << 15);
                                } else {
                                    i28 = i27;
                                    i38 = i26;
                                }
                                short s110 = (short) i29;
                                if (f14 >= 0.0f) {
                                }
                                return w1.h(ULong.b((((long) iD) & 63) | ((((long) ((int) (((f17 <= 1.0f ? f17 : 1.0f) * 1023.0f) + 0.5f))) & 1023) << 6) | ((((long) s18) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) s19) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | ((WebSocketProtocol.PAYLOAD_SHORT_MAX & ((long) s110)) << 16)));
                            }
                            if (i26 >= -10) {
                                i31 = (i25 | 8388608) >> (1 - i26);
                                if ((i31 & 4096) != 0) {
                                    i31 += 8192;
                                }
                                i28 = i31 >> 13;
                                i38 = 0;
                            } else {
                                i38 = 0;
                            }
                        }
                        i28 = 0;
                    }
                    i29 = (i23 << 15) | (i38 << 10) | i28;
                    short s111 = (short) i29;
                    if (f14 >= 0.0f) {
                    }
                    return w1.h(ULong.b((((long) iD) & 63) | ((((long) ((int) (((f17 <= 1.0f ? f17 : 1.0f) * 1023.0f) + 0.5f))) & 1023) << 6) | ((((long) s18) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) s19) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | ((WebSocketProtocol.PAYLOAD_SHORT_MAX & ((long) s111)) << 16)));
                }
                if (i17 >= -10) {
                    i22 = (i16 | 8388608) >> (1 - i17);
                    if ((i22 & 4096) != 0) {
                        i22 += 8192;
                    }
                    i19 = i22 >> 13;
                } else {
                    i19 = 0;
                }
                i17 = 0;
            }
        }
        i21 = i19 | (i14 << 15) | (i17 << 10);
        short s112 = (short) i21;
        f16 = cVar.f(2);
        fE2 = cVar.e(2);
        if (f13 >= f16) {
            f16 = f13;
        }
        if (f16 <= fE2) {
            fE2 = f16;
        }
        iFloatToRawIntBits2 = Float.floatToRawIntBits(fE2);
        i23 = iFloatToRawIntBits2 >>> 31;
        i24 = (iFloatToRawIntBits2 >>> 23) & 255;
        i25 = 8388607 & iFloatToRawIntBits2;
        if (i24 == 255) {
            i28 = i25 == 0 ? 0 : 512;
        } else {
            i26 = i24 - 112;
            if (i26 >= 31) {
                i38 = 49;
            } else {
                if (i26 <= 0) {
                    i27 = i25 >> 13;
                    if ((iFloatToRawIntBits2 & 4096) != 0) {
                        i29 = (((i26 << 10) | i27) + 1) | (i23 << 15);
                    } else {
                        i28 = i27;
                        i38 = i26;
                    }
                    short s113 = (short) i29;
                    if (f14 >= 0.0f) {
                    }
                    return w1.h(ULong.b((((long) iD) & 63) | ((((long) ((int) (((f17 <= 1.0f ? f17 : 1.0f) * 1023.0f) + 0.5f))) & 1023) << 6) | ((((long) s18) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) s112) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | ((WebSocketProtocol.PAYLOAD_SHORT_MAX & ((long) s113)) << 16)));
                }
                if (i26 >= -10) {
                    i31 = (i25 | 8388608) >> (1 - i26);
                    if ((i31 & 4096) != 0) {
                        i31 += 8192;
                    }
                    i28 = i31 >> 13;
                    i38 = 0;
                } else {
                    i38 = 0;
                }
            }
            i28 = 0;
        }
        i29 = (i23 << 15) | (i38 << 10) | i28;
        short s114 = (short) i29;
        if (f14 >= 0.0f) {
        }
        return w1.h(ULong.b((((long) iD) & 63) | ((((long) ((int) (((f17 <= 1.0f ? f17 : 1.0f) * 1023.0f) + 0.5f))) & 1023) << 6) | ((((long) s18) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) s112) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | ((WebSocketProtocol.PAYLOAD_SHORT_MAX & ((long) s114)) << 16)));
    }

    public static final long b(int i11) {
        return w1.h(ULong.b(ULong.b(i11) << 32));
    }

    public static final long c(int i11, int i12, int i13, int i14) {
        return b(((i11 & 255) << 16) | ((i14 & 255) << 24) | ((i12 & 255) << 8) | (i13 & 255));
    }

    public static final long d(long j11) {
        return w1.h(ULong.b(j11 << 32));
    }

    public static /* synthetic */ long e(float f11, float f12, float f13, float f14, androidx.compose.ui.graphics.colorspace.c cVar, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            f14 = 1.0f;
        }
        if ((i11 & 16) != 0) {
            cVar = androidx.compose.ui.graphics.colorspace.g.f4027a.w();
        }
        return a(f11, f12, f13, f14, cVar);
    }

    public static /* synthetic */ long f(int i11, int i12, int i13, int i14, int i15, Object obj) {
        if ((i15 & 8) != 0) {
            i14 = 255;
        }
        return c(i11, i12, i13, i14);
    }

    /* JADX WARN: Code duplicated, block: B:31:0x009e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:32:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:33:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:35:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:37:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:38:0x00af A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:39:0x00b1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:40:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:42:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:45:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:46:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:48:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:50:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:54:0x00ea A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:56:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:58:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:60:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:61:0x00f9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:62:0x00fb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:63:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:65:0x0106  */
    /* JADX WARN: Code duplicated, block: B:68:0x010d  */
    /* JADX WARN: Code duplicated, block: B:70:0x0113  */
    public static final long g(float f11, float f12, float f13, float f14, androidx.compose.ui.graphics.colorspace.c cVar) {
        int i11;
        int i12;
        int i13;
        int iFloatToRawIntBits;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i21;
        int i22;
        int iFloatToRawIntBits2;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        if (cVar.i()) {
            return w1.h(ULong.b(ULong.b((((((int) ((f14 * 255.0f) + 0.5f)) << 24) | (((int) ((f11 * 255.0f) + 0.5f)) << 16)) | (((int) ((f12 * 255.0f) + 0.5f)) << 8)) | ((int) ((255.0f * f13) + 0.5f))) << 32));
        }
        int iFloatToRawIntBits3 = Float.floatToRawIntBits(f11);
        int i29 = iFloatToRawIntBits3 >>> 31;
        int i31 = (iFloatToRawIntBits3 >>> 23) & 255;
        int i32 = iFloatToRawIntBits3 & 8388607;
        int i33 = 0;
        if (i31 == 255) {
            i12 = i32 != 0 ? 512 : 0;
            i11 = 31;
        } else {
            i11 = i31 - 112;
            if (i11 >= 31) {
                i12 = 0;
                i11 = 49;
            } else {
                if (i11 > 0) {
                    int i34 = i32 >> 13;
                    if ((iFloatToRawIntBits3 & 4096) != 0) {
                        i13 = (((i11 << 10) | i34) + 1) | (i29 << 15);
                    } else {
                        i12 = i34;
                    }
                    short s11 = (short) i13;
                    iFloatToRawIntBits = Float.floatToRawIntBits(f12);
                    i14 = iFloatToRawIntBits >>> 31;
                    i15 = (iFloatToRawIntBits >>> 23) & 255;
                    i16 = iFloatToRawIntBits & 8388607;
                    if (i15 == 255) {
                        if (i16 != 0) {
                            i19 = 512;
                        } else {
                            i19 = 0;
                        }
                        i17 = 31;
                    } else {
                        i17 = i15 - 112;
                        if (i17 >= 31) {
                            i19 = 0;
                            i17 = 49;
                        } else {
                            if (i17 <= 0) {
                                i18 = i16 >> 13;
                                if ((iFloatToRawIntBits & 4096) != 0) {
                                    i21 = (((i17 << 10) | i18) + 1) | (i14 << 15);
                                } else {
                                    i19 = i18;
                                }
                                short s12 = (short) i21;
                                iFloatToRawIntBits2 = Float.floatToRawIntBits(f13);
                                i23 = iFloatToRawIntBits2 >>> 31;
                                i24 = (iFloatToRawIntBits2 >>> 23) & 255;
                                i25 = 8388607 & iFloatToRawIntBits2;
                                if (i24 == 255) {
                                    i33 = i25 == 0 ? 0 : 512;
                                    i26 = 31;
                                } else {
                                    i26 = i24 - 112;
                                    if (i26 >= 31) {
                                        i26 = 49;
                                    } else {
                                        if (i26 <= 0) {
                                            i33 = i25 >> 13;
                                            if ((iFloatToRawIntBits2 & 4096) != 0) {
                                                i27 = (((i26 << 10) | i33) + 1) | (i23 << 15);
                                            }
                                            return w1.h(ULong.b(((((long) s12) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | ((((long) s11) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) ((short) i27)) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 16) | ((((long) ((int) ((Math.max(0.0f, Math.min(f14, 1.0f)) * 1023.0f) + 0.5f))) & 1023) << 6) | (((long) cVar.d()) & 63)));
                                        }
                                        if (i26 >= -10) {
                                            i28 = (i25 | 8388608) >> (1 - i26);
                                            if ((i28 & 4096) != 0) {
                                                i28 += 8192;
                                            }
                                            i33 = i28 >> 13;
                                        }
                                        i26 = 0;
                                    }
                                }
                                i27 = (i23 << 15) | (i26 << 10) | i33;
                                return w1.h(ULong.b(((((long) s12) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | ((((long) s11) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) ((short) i27)) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 16) | ((((long) ((int) ((Math.max(0.0f, Math.min(f14, 1.0f)) * 1023.0f) + 0.5f))) & 1023) << 6) | (((long) cVar.d()) & 63)));
                            }
                            if (i17 >= -10) {
                                i22 = (i16 | 8388608) >> (1 - i17);
                                if ((i22 & 4096) != 0) {
                                    i22 += 8192;
                                }
                                i19 = i22 >> 13;
                            } else {
                                i19 = 0;
                            }
                            i17 = 0;
                        }
                    }
                    i21 = i19 | (i14 << 15) | (i17 << 10);
                    short s13 = (short) i21;
                    iFloatToRawIntBits2 = Float.floatToRawIntBits(f13);
                    i23 = iFloatToRawIntBits2 >>> 31;
                    i24 = (iFloatToRawIntBits2 >>> 23) & 255;
                    i25 = 8388607 & iFloatToRawIntBits2;
                    if (i24 == 255) {
                        i33 = i25 == 0 ? 0 : 512;
                        i26 = 31;
                    } else {
                        i26 = i24 - 112;
                        if (i26 >= 31) {
                            i26 = 49;
                        } else {
                            if (i26 <= 0) {
                                i33 = i25 >> 13;
                                if ((iFloatToRawIntBits2 & 4096) != 0) {
                                    i27 = (((i26 << 10) | i33) + 1) | (i23 << 15);
                                }
                                return w1.h(ULong.b(((((long) s13) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | ((((long) s11) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) ((short) i27)) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 16) | ((((long) ((int) ((Math.max(0.0f, Math.min(f14, 1.0f)) * 1023.0f) + 0.5f))) & 1023) << 6) | (((long) cVar.d()) & 63)));
                            }
                            if (i26 >= -10) {
                                i28 = (i25 | 8388608) >> (1 - i26);
                                if ((i28 & 4096) != 0) {
                                    i28 += 8192;
                                }
                                i33 = i28 >> 13;
                            }
                            i26 = 0;
                        }
                    }
                    i27 = (i23 << 15) | (i26 << 10) | i33;
                    return w1.h(ULong.b(((((long) s13) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | ((((long) s11) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) ((short) i27)) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 16) | ((((long) ((int) ((Math.max(0.0f, Math.min(f14, 1.0f)) * 1023.0f) + 0.5f))) & 1023) << 6) | (((long) cVar.d()) & 63)));
                }
                if (i11 >= -10) {
                    int i35 = (i32 | 8388608) >> (1 - i11);
                    if ((i35 & 4096) != 0) {
                        i35 += 8192;
                    }
                    i12 = i35 >> 13;
                } else {
                    i12 = 0;
                }
                i11 = 0;
            }
        }
        i13 = i12 | (i29 << 15) | (i11 << 10);
        short s14 = (short) i13;
        iFloatToRawIntBits = Float.floatToRawIntBits(f12);
        i14 = iFloatToRawIntBits >>> 31;
        i15 = (iFloatToRawIntBits >>> 23) & 255;
        i16 = iFloatToRawIntBits & 8388607;
        if (i15 == 255) {
            if (i16 != 0) {
                i19 = 512;
            } else {
                i19 = 0;
            }
            i17 = 31;
        } else {
            i17 = i15 - 112;
            if (i17 >= 31) {
                i19 = 0;
                i17 = 49;
            } else {
                if (i17 <= 0) {
                    i18 = i16 >> 13;
                    if ((iFloatToRawIntBits & 4096) != 0) {
                        i21 = (((i17 << 10) | i18) + 1) | (i14 << 15);
                    } else {
                        i19 = i18;
                    }
                    short s15 = (short) i21;
                    iFloatToRawIntBits2 = Float.floatToRawIntBits(f13);
                    i23 = iFloatToRawIntBits2 >>> 31;
                    i24 = (iFloatToRawIntBits2 >>> 23) & 255;
                    i25 = 8388607 & iFloatToRawIntBits2;
                    if (i24 == 255) {
                        i33 = i25 == 0 ? 0 : 512;
                        i26 = 31;
                    } else {
                        i26 = i24 - 112;
                        if (i26 >= 31) {
                            i26 = 49;
                        } else {
                            if (i26 <= 0) {
                                i33 = i25 >> 13;
                                if ((iFloatToRawIntBits2 & 4096) != 0) {
                                    i27 = (((i26 << 10) | i33) + 1) | (i23 << 15);
                                }
                                return w1.h(ULong.b(((((long) s15) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | ((((long) s14) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) ((short) i27)) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 16) | ((((long) ((int) ((Math.max(0.0f, Math.min(f14, 1.0f)) * 1023.0f) + 0.5f))) & 1023) << 6) | (((long) cVar.d()) & 63)));
                            }
                            if (i26 >= -10) {
                                i28 = (i25 | 8388608) >> (1 - i26);
                                if ((i28 & 4096) != 0) {
                                    i28 += 8192;
                                }
                                i33 = i28 >> 13;
                            }
                            i26 = 0;
                        }
                    }
                    i27 = (i23 << 15) | (i26 << 10) | i33;
                    return w1.h(ULong.b(((((long) s15) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | ((((long) s14) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) ((short) i27)) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 16) | ((((long) ((int) ((Math.max(0.0f, Math.min(f14, 1.0f)) * 1023.0f) + 0.5f))) & 1023) << 6) | (((long) cVar.d()) & 63)));
                }
                if (i17 >= -10) {
                    i22 = (i16 | 8388608) >> (1 - i17);
                    if ((i22 & 4096) != 0) {
                        i22 += 8192;
                    }
                    i19 = i22 >> 13;
                } else {
                    i19 = 0;
                }
                i17 = 0;
            }
        }
        i21 = i19 | (i14 << 15) | (i17 << 10);
        short s16 = (short) i21;
        iFloatToRawIntBits2 = Float.floatToRawIntBits(f13);
        i23 = iFloatToRawIntBits2 >>> 31;
        i24 = (iFloatToRawIntBits2 >>> 23) & 255;
        i25 = 8388607 & iFloatToRawIntBits2;
        if (i24 == 255) {
            i33 = i25 == 0 ? 0 : 512;
            i26 = 31;
        } else {
            i26 = i24 - 112;
            if (i26 >= 31) {
                i26 = 49;
            } else {
                if (i26 <= 0) {
                    i33 = i25 >> 13;
                    if ((iFloatToRawIntBits2 & 4096) != 0) {
                        i27 = (((i26 << 10) | i33) + 1) | (i23 << 15);
                    }
                    return w1.h(ULong.b(((((long) s16) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | ((((long) s14) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) ((short) i27)) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 16) | ((((long) ((int) ((Math.max(0.0f, Math.min(f14, 1.0f)) * 1023.0f) + 0.5f))) & 1023) << 6) | (((long) cVar.d()) & 63)));
                }
                if (i26 >= -10) {
                    i28 = (i25 | 8388608) >> (1 - i26);
                    if ((i28 & 4096) != 0) {
                        i28 += 8192;
                    }
                    i33 = i28 >> 13;
                }
                i26 = 0;
            }
        }
        i27 = (i23 << 15) | (i26 << 10) | i33;
        return w1.h(ULong.b(((((long) s16) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | ((((long) s14) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) ((short) i27)) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 16) | ((((long) ((int) ((Math.max(0.0f, Math.min(f14, 1.0f)) * 1023.0f) + 0.5f))) & 1023) << 6) | (((long) cVar.d()) & 63)));
    }

    public static final long h(long j11, long j12) {
        long jI = w1.i(j11, w1.p(j12));
        float fN = w1.n(j12);
        float fN2 = w1.n(jI);
        float f11 = 1.0f - fN2;
        float f12 = (fN * f11) + fN2;
        return g(f12 == 0.0f ? 0.0f : ((w1.r(jI) * fN2) + ((w1.r(j12) * fN) * f11)) / f12, f12 == 0.0f ? 0.0f : ((w1.q(jI) * fN2) + ((w1.q(j12) * fN) * f11)) / f12, f12 != 0.0f ? ((w1.o(jI) * fN2) + ((w1.o(j12) * fN) * f11)) / f12 : 0.0f, f12, w1.p(j12));
    }

    public static final float i(long j11) {
        androidx.compose.ui.graphics.colorspace.c cVarP = w1.p(j11);
        if (!androidx.compose.ui.graphics.colorspace.b.e(cVarP.g(), androidx.compose.ui.graphics.colorspace.b.f4018a.b())) {
            j4.a("The specified color must be encoded in an RGB color space. The supplied color space is " + ((Object) androidx.compose.ui.graphics.colorspace.b.h(cVarP.g())));
        }
        Intrinsics.e(cVarP, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
        androidx.compose.ui.graphics.colorspace.j jVarI = ((Rgb) cVarP).I();
        float fA = (float) ((jVarI.a(w1.r(j11)) * 0.2126d) + (jVarI.a(w1.q(j11)) * 0.7152d) + (jVarI.a(w1.o(j11)) * 0.0722d));
        if (fA < 0.0f) {
            fA = 0.0f;
        }
        if (fA > 1.0f) {
            return 1.0f;
        }
        return fA;
    }

    public static final int j(long j11) {
        return (int) ULong.b(w1.i(j11, androidx.compose.ui.graphics.colorspace.g.f4027a.w()) >>> 32);
    }
}
