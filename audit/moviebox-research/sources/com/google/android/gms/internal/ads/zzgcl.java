package com.google.android.gms.internal.ads;

import java.math.RoundingMode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgcl {
    static {
        Math.log(2.0d);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:37:0x007e  */
    /* JADX WARN: Code duplicated, block: B:40:0x0089  */
    /* JADX WARN: Code duplicated, block: B:41:0x008b  */
    /* JADX WARN: Code duplicated, block: B:45:0x0093  */
    /* JADX WARN: Code duplicated, block: B:48:0x0098  */
    /* JADX WARN: Code duplicated, block: B:50:0x009a  */
    /* JADX WARN: Instruction removed from duplicated block: B:50:0x009a, please report this as an issue */
    public static long zza(double d11, RoundingMode roundingMode) {
        double dRint;
        long j11;
        long j12;
        boolean z11;
        if (!zzgcm.zza(d11)) {
            throw new ArithmeticException("input is infinite or NaN");
        }
        switch (zzgck.zza[roundingMode.ordinal()]) {
            case 1:
                zzgcr.zzb(zzb(d11));
                dRint = d11;
                if ((-9.223372036854776E18d) - dRint < 1.0d) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11 && (dRint < 9.223372036854776E18d)) {
                    return (long) dRint;
                }
                throw new ArithmeticException("rounded value is out of range for input " + d11 + " and rounding mode " + String.valueOf(roundingMode));
            case 2:
                if (d11 >= 0.0d || zzb(d11)) {
                    dRint = d11;
                } else {
                    j11 = (long) d11;
                    j12 = -1;
                    dRint = j11 + j12;
                }
                if ((-9.223372036854776E18d) - dRint < 1.0d) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11 && (dRint < 9.223372036854776E18d)) {
                    return (long) dRint;
                }
                throw new ArithmeticException("rounded value is out of range for input " + d11 + " and rounding mode " + String.valueOf(roundingMode));
            case 3:
                if (d11 <= 0.0d || zzb(d11)) {
                    dRint = d11;
                } else {
                    j11 = (long) d11;
                    j12 = 1;
                    dRint = j11 + j12;
                }
                if ((-9.223372036854776E18d) - dRint < 1.0d) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11 && (dRint < 9.223372036854776E18d)) {
                    return (long) dRint;
                }
                throw new ArithmeticException("rounded value is out of range for input " + d11 + " and rounding mode " + String.valueOf(roundingMode));
            case 4:
                dRint = d11;
                if ((-9.223372036854776E18d) - dRint < 1.0d) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11 && (dRint < 9.223372036854776E18d)) {
                    return (long) dRint;
                }
                throw new ArithmeticException("rounded value is out of range for input " + d11 + " and rounding mode " + String.valueOf(roundingMode));
            case 5:
                if (zzb(d11)) {
                    dRint = d11;
                } else {
                    dRint = ((long) d11) + ((long) (d11 > 0.0d ? 1 : -1));
                }
                if ((-9.223372036854776E18d) - dRint < 1.0d) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11 && (dRint < 9.223372036854776E18d)) {
                    return (long) dRint;
                }
                throw new ArithmeticException("rounded value is out of range for input " + d11 + " and rounding mode " + String.valueOf(roundingMode));
            case 6:
                dRint = Math.rint(d11);
                if ((-9.223372036854776E18d) - dRint < 1.0d) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11 && (dRint < 9.223372036854776E18d)) {
                    return (long) dRint;
                }
                throw new ArithmeticException("rounded value is out of range for input " + d11 + " and rounding mode " + String.valueOf(roundingMode));
            case 7:
                dRint = Math.rint(d11);
                if (Math.abs(d11 - dRint) == 0.5d) {
                    dRint = Math.copySign(0.5d, d11) + d11;
                }
                if ((-9.223372036854776E18d) - dRint < 1.0d) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11 && (dRint < 9.223372036854776E18d)) {
                    return (long) dRint;
                }
                throw new ArithmeticException("rounded value is out of range for input " + d11 + " and rounding mode " + String.valueOf(roundingMode));
            case 8:
                dRint = Math.rint(d11);
                if (Math.abs(d11 - dRint) == 0.5d) {
                    dRint = d11;
                }
                if ((-9.223372036854776E18d) - dRint < 1.0d) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11 && (dRint < 9.223372036854776E18d)) {
                    return (long) dRint;
                }
                throw new ArithmeticException("rounded value is out of range for input " + d11 + " and rounding mode " + String.valueOf(roundingMode));
            default:
                throw new AssertionError();
        }
    }

    public static boolean zzb(double d11) {
        if (!zzgcm.zza(d11)) {
            return false;
        }
        if (d11 == 0.0d) {
            return true;
        }
        zzfxe.zzf(zzgcm.zza(d11), "not a normal value");
        int exponent = Math.getExponent(d11);
        long jDoubleToRawLongBits = Double.doubleToRawLongBits(d11) & 4503599627370495L;
        return 52 - Long.numberOfTrailingZeros(exponent == -1023 ? jDoubleToRawLongBits + jDoubleToRawLongBits : jDoubleToRawLongBits | 4503599627370496L) <= Math.getExponent(d11);
    }
}
