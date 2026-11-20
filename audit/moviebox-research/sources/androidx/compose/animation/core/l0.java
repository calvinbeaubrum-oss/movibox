package androidx.compose.animation.core;

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
public final class l0 {
    public static final long a(double d11, double d12, double d13, double d14, double d15) {
        double dSqrt = 2.0d * d12 * Math.sqrt(d11);
        double d16 = (dSqrt * dSqrt) - (4.0d * d11);
        double d17 = -dSqrt;
        s sVarA = t.a(d16);
        sVarA.f2134a += d17;
        sVarA.f2134a *= 0.5d;
        sVarA.f2135b *= 0.5d;
        s sVarA2 = t.a(d16);
        double d18 = -1;
        sVarA2.f2134a *= d18;
        sVarA2.f2135b *= d18;
        sVarA2.f2134a += d17;
        sVarA2.f2134a *= 0.5d;
        sVarA2.f2135b *= 0.5d;
        return d(sVarA, sVarA2, d12, d13, d14, d15);
    }

    public static final long b(float f11, float f12, float f13, float f14, float f15) {
        if (f12 == 0.0f) {
            return 9223372036854L;
        }
        return a(f11, f12, f13, f14, f15);
    }

    public static final double c(s sVar, double d11, double d12, double d13) {
        double d14 = d13;
        double dF = sVar.f();
        double d15 = dF * d11;
        double d16 = d12 - d15;
        double dLog = Math.log(Math.abs(d14 / d11)) / dF;
        double dLog2 = Math.log(Math.abs(d14 / d16));
        double dLog3 = dLog2;
        for (int i11 = 0; i11 < 6; i11++) {
            dLog3 = dLog2 - Math.log(Math.abs(dLog3 / dF));
        }
        double d17 = dLog3 / dF;
        if (!((Double.isInfinite(dLog) || Double.isNaN(dLog)) ? false : true)) {
            dLog = d17;
        } else if (!(!((Double.isInfinite(d17) || Double.isNaN(d17)) ? false : true))) {
            dLog = Math.max(dLog, d17);
        }
        double d18 = (-(d15 + d16)) / (dF * d16);
        double d19 = dF * d18;
        double dExp = (Math.exp(d19) * d11) + (d16 * d18 * Math.exp(d19));
        if (Double.isNaN(d18) || d18 <= 0.0d) {
            d14 = -d14;
        } else if (d18 <= 0.0d || (-dExp) >= d14) {
            dLog = (-(2.0d / dF)) - (d11 / d16);
        } else {
            if (d16 < 0.0d && d11 > 0.0d) {
                dLog = 0.0d;
            }
            d14 = -d14;
        }
        double dAbs = Double.MAX_VALUE;
        int i12 = 0;
        while (dAbs > 0.001d && i12 < 100) {
            i12++;
            double d21 = dF * dLog;
            double d22 = d14;
            double dExp2 = dLog - ((((d11 + (d16 * dLog)) * Math.exp(d21)) + d14) / ((((((double) 1) + d21) * d16) + d15) * Math.exp(d21)));
            dAbs = Math.abs(dLog - dExp2);
            dLog = dExp2;
            d14 = d22;
        }
        return dLog;
    }

    public static final long d(s sVar, s sVar2, double d11, double d12, double d13, double d14) {
        double dG;
        double d15 = d12;
        if (d13 == 0.0d && d15 == 0.0d) {
            return 0L;
        }
        if (d13 < 0.0d) {
            d15 = -d15;
        }
        double dAbs = Math.abs(d13);
        if (d11 > 1.0d) {
            dG = e(sVar, sVar2, dAbs, d15, d14);
        } else {
            dG = d11 < 1.0d ? g(sVar, dAbs, d15, d14) : c(sVar, dAbs, d15, d14);
        }
        return (long) (dG * 1000.0d);
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00ca A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:41:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:44:0x00da  */
    public static final double e(s sVar, s sVar2, double d11, double d12, double d13) {
        double dLog;
        double d14;
        double d15;
        double d16;
        int i11;
        double d17 = d13;
        double dF = sVar.f();
        double dF2 = sVar2.f();
        double d18 = dF - dF2;
        double d19 = ((dF * d11) - d12) / d18;
        double d21 = d11 - d19;
        double dLog2 = Math.log(Math.abs(d17 / d21)) / dF;
        double dLog3 = Math.log(Math.abs(d17 / d19)) / dF2;
        if (!((Double.isInfinite(dLog2) || Double.isNaN(dLog2)) ? false : true)) {
            dLog = dLog3;
        } else {
            if (!(!((Double.isInfinite(dLog3) || Double.isNaN(dLog3)) ? false : true))) {
                dLog2 = Math.max(dLog2, dLog3);
            }
            dLog = dLog2;
        }
        double d22 = d21 * dF;
        double dLog4 = Math.log(d22 / ((-d19) * dF2)) / (dF2 - dF);
        if (!Double.isNaN(dLog4) && dLog4 > 0.0d) {
            if (dLog4 > 0.0d) {
                d14 = d19;
                if ((-f(d21, dF, dLog4, d19, dF2)) < d17) {
                    if (d14 > 0.0d && d21 < 0.0d) {
                        dLog = 0.0d;
                    }
                }
                d15 = d14 * dF2;
                if (Math.abs((Math.exp(dF * dLog) * d22) + (Math.exp(dF2 * dLog) * d15)) < 1.0E-4d) {
                    return dLog;
                }
                d16 = Double.MAX_VALUE;
                i11 = 0;
                while (d16 > 0.001d && i11 < 100) {
                    i11++;
                    double d23 = dF * dLog;
                    double d24 = dF2 * dLog;
                    double dExp = dLog - ((((Math.exp(d23) * d21) + (Math.exp(d24) * d14)) + d17) / ((Math.exp(d23) * d22) + (Math.exp(d24) * d15)));
                    double dAbs = Math.abs(dLog - dExp);
                    dLog = dExp;
                    d16 = dAbs;
                }
                return dLog;
            }
            d14 = d19;
            dLog = Math.log((-((d14 * dF2) * dF2)) / (d22 * dF)) / d18;
            d15 = d14 * dF2;
            if (Math.abs((Math.exp(dF * dLog) * d22) + (Math.exp(dF2 * dLog) * d15)) < 1.0E-4d) {
                return dLog;
            }
            d16 = Double.MAX_VALUE;
            i11 = 0;
            while (d16 > 0.001d) {
                i11++;
                double d25 = dF * dLog;
                double d26 = dF2 * dLog;
                double dExp2 = dLog - ((((Math.exp(d25) * d21) + (Math.exp(d26) * d14)) + d17) / ((Math.exp(d25) * d22) + (Math.exp(d26) * d15)));
                double dAbs2 = Math.abs(dLog - dExp2);
                dLog = dExp2;
                d16 = dAbs2;
            }
            return dLog;
        }
        d14 = d19;
        d17 = -d17;
        d15 = d14 * dF2;
        if (Math.abs((Math.exp(dF * dLog) * d22) + (Math.exp(dF2 * dLog) * d15)) < 1.0E-4d) {
            return dLog;
        }
        d16 = Double.MAX_VALUE;
        i11 = 0;
        while (d16 > 0.001d) {
            i11++;
            double d27 = dF * dLog;
            double d28 = dF2 * dLog;
            double dExp3 = dLog - ((((Math.exp(d27) * d21) + (Math.exp(d28) * d14)) + d17) / ((Math.exp(d27) * d22) + (Math.exp(d28) * d15)));
            double dAbs3 = Math.abs(dLog - dExp3);
            dLog = dExp3;
            d16 = dAbs3;
        }
        return dLog;
    }

    public static final double f(double d11, double d12, double d13, double d14, double d15) {
        return (d11 * Math.exp(d12 * d13)) + (d14 * Math.exp(d15 * d13));
    }

    public static final double g(s sVar, double d11, double d12, double d13) {
        double dF = sVar.f();
        double dE = (d12 - (dF * d11)) / sVar.e();
        return Math.log(d13 / Math.sqrt((d11 * d11) + (dE * dE))) / dF;
    }
}
