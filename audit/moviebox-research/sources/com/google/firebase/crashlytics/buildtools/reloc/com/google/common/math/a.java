package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.math;

import java.math.RoundingMode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final double f39840a = Math.log(2.0d);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final double[] f39841b = {1.0d, 2.0922789888E13d, 2.631308369336935E35d, 1.2413915592536073E61d, 1.2688693218588417E89d, 7.156945704626381E118d, 9.916779348709496E149d, 1.974506857221074E182d, 3.856204823625804E215d, 5.5502938327393044E249d, 4.7147236359920616E284d};

    /* JADX INFO: renamed from: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.math.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class C0418a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f39842a;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            f39842a = iArr;
            try {
                iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f39842a[RoundingMode.FLOOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f39842a[RoundingMode.CEILING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f39842a[RoundingMode.DOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f39842a[RoundingMode.UP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f39842a[RoundingMode.HALF_EVEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f39842a[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f39842a[RoundingMode.HALF_DOWN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public static boolean a(double d11) {
        return b.c(d11) && (d11 == 0.0d || 52 - Long.numberOfTrailingZeros(b.b(d11)) <= Math.getExponent(d11));
    }

    public static double b(double d11, RoundingMode roundingMode) {
        if (!b.c(d11)) {
            throw new ArithmeticException("input is infinite or NaN");
        }
        switch (C0418a.f39842a[roundingMode.ordinal()]) {
            case 1:
                f.d(a(d11));
                return d11;
            case 2:
                return (d11 >= 0.0d || a(d11)) ? d11 : ((long) d11) - 1;
            case 3:
                return (d11 <= 0.0d || a(d11)) ? d11 : ((long) d11) + 1;
            case 4:
                return d11;
            case 5:
                if (a(d11)) {
                    return d11;
                }
                return ((long) d11) + ((long) (d11 > 0.0d ? 1 : -1));
            case 6:
                return Math.rint(d11);
            case 7:
                double dRint = Math.rint(d11);
                return Math.abs(d11 - dRint) == 0.5d ? d11 + Math.copySign(0.5d, d11) : dRint;
            case 8:
                double dRint2 = Math.rint(d11);
                return Math.abs(d11 - dRint2) == 0.5d ? d11 : dRint2;
            default:
                throw new AssertionError();
        }
    }

    public static long c(double d11, RoundingMode roundingMode) {
        double dB = b(d11, roundingMode);
        f.a((dB < 9.223372036854776E18d) & ((-9.223372036854776E18d) - dB < 1.0d));
        return (long) dB;
    }
}
