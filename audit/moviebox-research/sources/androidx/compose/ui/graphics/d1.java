package androidx.compose.ui.graphics;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

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
public final class d1 {
    public static final long b(float f11, float f12, float f13, float f14, float[] fArr, int i11) {
        float f15 = (f12 - f11) * 3.0f;
        float f16 = (f13 - f12) * 3.0f;
        float f17 = (f14 - f13) * 3.0f;
        int iF = f(f15, f16, f17, fArr, i11);
        float f18 = (f16 - f15) * 2.0f;
        int iG = iF + g((-f18) / (((f17 - f16) * 2.0f) - f18), fArr, i11 + iF);
        float fMin = Math.min(f11, f14);
        float fMax = Math.max(f11, f14);
        for (int i12 = 0; i12 < iG; i12++) {
            float fD = d(f11, f12, f13, f14, fArr[i12]);
            fMin = Math.min(fMin, fD);
            fMax = Math.max(fMax, fD);
        }
        return androidx.collection.g.a(fMin, fMax);
    }

    public static final float c(float f11, float f12, float f13) {
        return ((((((f11 - f12) + 0.33333334f) * f13) + (f12 - (2.0f * f11))) * f13) + f11) * 3.0f * f13;
    }

    public static final float d(float f11, float f12, float f13, float f14, float f15) {
        float f16 = (f14 + ((f12 - f13) * 3.0f)) - f11;
        return (((((f16 * f15) + (((f13 - (2.0f * f12)) + f11) * 3.0f)) * f15) + ((f12 - f11) * 3.0f)) * f15) + f11;
    }

    /* JADX WARN: Code duplicated, block: B:104:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:27:0x0090  */
    /* JADX WARN: Code duplicated, block: B:62:0x0123  */
    /* JADX WARN: Code duplicated, block: B:76:0x0150  */
    public static final float e(float f11, float f12, float f13, float f14) {
        double d11 = f11;
        double d12 = ((d11 - (((double) f12) * 2.0d)) + ((double) f13)) * 3.0d;
        double d13 = ((double) (f12 - f11)) * 3.0d;
        double d14 = ((double) (-f11)) + (((double) (f12 - f13)) * 3.0d) + ((double) f14);
        if (Math.abs(d14 - 0.0d) < 1.0E-7d) {
            if (Math.abs(d12 - 0.0d) < 1.0E-7d) {
                if (Math.abs(d13 - 0.0d) < 1.0E-7d) {
                    return Float.NaN;
                }
                float f15 = (float) ((-d11) / d13);
                if (f15 < 0.0f) {
                    if (f15 >= -8.34465E-7f) {
                        return 0.0f;
                    }
                } else {
                    if (f15 <= 1.0f) {
                        return f15;
                    }
                    if (f15 <= 1.0000008f) {
                        return 1.0f;
                    }
                }
                return Float.NaN;
            }
            double dSqrt = Math.sqrt((d13 * d13) - ((4.0d * d12) * d11));
            double d15 = d12 * 2.0d;
            float f16 = (float) ((dSqrt - d13) / d15);
            if (f16 < 0.0f) {
                if (f16 >= -8.34465E-7f) {
                    f16 = 0.0f;
                } else {
                    f16 = Float.NaN;
                }
            } else if (f16 > 1.0f) {
                if (f16 <= 1.0000008f) {
                    f16 = 1.0f;
                } else {
                    f16 = Float.NaN;
                }
            }
            if (!Float.isNaN(f16)) {
                return f16;
            }
            float f17 = (float) (((-d13) - dSqrt) / d15);
            if (f17 < 0.0f) {
                if (f17 >= -8.34465E-7f) {
                    return 0.0f;
                }
            } else {
                if (f17 <= 1.0f) {
                    return f17;
                }
                if (f17 <= 1.0000008f) {
                    return 1.0f;
                }
            }
            return Float.NaN;
        }
        double d16 = d12 / d14;
        double d17 = d13 / d14;
        double d18 = d11 / d14;
        double d19 = ((d17 * 3.0d) - (d16 * d16)) / 9.0d;
        double d21 = (((((2.0d * d16) * d16) * d16) - ((9.0d * d16) * d17)) + (d18 * 27.0d)) / 54.0d;
        double d22 = d19 * d19 * d19;
        double d23 = (d21 * d21) + d22;
        double d24 = d16 / 3.0d;
        if (d23 >= 0.0d) {
            if (d23 != 0.0d) {
                double dSqrt2 = Math.sqrt(d23);
                float fA = (float) (((double) (s2.b.a((float) ((-d21) + dSqrt2)) - s2.b.a((float) (d21 + dSqrt2)))) - d24);
                if (fA < 0.0f) {
                    if (fA >= -8.34465E-7f) {
                        return 0.0f;
                    }
                } else {
                    if (fA <= 1.0f) {
                        return fA;
                    }
                    if (fA <= 1.0000008f) {
                        return 1.0f;
                    }
                }
                return Float.NaN;
            }
            float f18 = -s2.b.a((float) d21);
            float f19 = (float) d24;
            float f21 = (2.0f * f18) - f19;
            if (f21 < 0.0f) {
                if (f21 >= -8.34465E-7f) {
                    f21 = 0.0f;
                } else {
                    f21 = Float.NaN;
                }
            } else if (f21 > 1.0f) {
                if (f21 <= 1.0000008f) {
                    f21 = 1.0f;
                } else {
                    f21 = Float.NaN;
                }
            }
            if (!Float.isNaN(f21)) {
                return f21;
            }
            float f22 = (-f18) - f19;
            if (f22 < 0.0f) {
                if (f22 >= -8.34465E-7f) {
                    return 0.0f;
                }
            } else {
                if (f22 <= 1.0f) {
                    return f22;
                }
                if (f22 <= 1.0000008f) {
                    return 1.0f;
                }
            }
            return Float.NaN;
        }
        double dSqrt3 = Math.sqrt(-d22);
        double d25 = (-d21) / dSqrt3;
        if (d25 < -1.0d) {
            d25 = -1.0d;
        }
        if (d25 > 1.0d) {
            d25 = 1.0d;
        }
        double dAcos = Math.acos(d25);
        double dA = s2.b.a((float) dSqrt3) * 2.0f;
        float fCos = (float) ((Math.cos(dAcos / 3.0d) * dA) - d24);
        if (fCos < 0.0f) {
            if (fCos >= -8.34465E-7f) {
                fCos = 0.0f;
            } else {
                fCos = Float.NaN;
            }
        } else if (fCos > 1.0f) {
            if (fCos <= 1.0000008f) {
                fCos = 1.0f;
            } else {
                fCos = Float.NaN;
            }
        }
        if (!Float.isNaN(fCos)) {
            return fCos;
        }
        float fCos2 = (float) ((Math.cos((6.283185307179586d + dAcos) / 3.0d) * dA) - d24);
        if (fCos2 < 0.0f) {
            if (fCos2 >= -8.34465E-7f) {
                fCos2 = 0.0f;
            } else {
                fCos2 = Float.NaN;
            }
        } else if (fCos2 > 1.0f) {
            if (fCos2 <= 1.0000008f) {
                fCos2 = 1.0f;
            } else {
                fCos2 = Float.NaN;
            }
        }
        if (!Float.isNaN(fCos2)) {
            return fCos2;
        }
        float fCos3 = (float) ((dA * Math.cos((dAcos + 12.566370614359172d) / 3.0d)) - d24);
        if (fCos3 < 0.0f) {
            if (fCos3 >= -8.34465E-7f) {
                return 0.0f;
            }
        } else {
            if (fCos3 <= 1.0f) {
                return fCos3;
            }
            if (fCos3 <= 1.0000008f) {
                return 1.0f;
            }
        }
        return Float.NaN;
    }

    public static final int f(float f11, float f12, float f13, float[] fArr, int i11) {
        double d11 = f11;
        double d12 = f12;
        double d13 = f13;
        double d14 = d12 * 2.0d;
        double d15 = (d11 - d14) + d13;
        if (d15 == 0.0d) {
            if (d12 == d13) {
                return 0;
            }
            return g((float) ((d14 - d13) / (d14 - (d13 * 2.0d))), fArr, i11);
        }
        double d16 = -Math.sqrt((d12 * d12) - (d13 * d11));
        double d17 = (-d11) + d12;
        int iG = g((float) ((-(d16 + d17)) / d15), fArr, i11);
        int iG2 = iG + g((float) ((d16 - d17) / d15), fArr, i11 + iG);
        if (iG2 > 1) {
            float f14 = fArr[i11];
            int i12 = i11 + 1;
            float f15 = fArr[i12];
            if (f14 > f15) {
                fArr[i11] = f15;
                fArr[i12] = f14;
            } else if (f14 == f15) {
                return iG2 - 1;
            }
        }
        return iG2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x000f  */
    public static final int g(float f11, float[] fArr, int i11) {
        if (f11 < 0.0f) {
            if (f11 >= -8.34465E-7f) {
                f11 = 0.0f;
            } else {
                f11 = Float.NaN;
            }
        } else if (f11 > 1.0f) {
            if (f11 <= 1.0000008f) {
                f11 = 1.0f;
            } else {
                f11 = Float.NaN;
            }
        }
        fArr[i11] = f11;
        return !Float.isNaN(f11) ? 1 : 0;
    }
}
