package com.google.common.math;

import java.math.RoundingMode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final double f38770a = Math.log(2.0d);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final double[] f38771b = {1.0d, 2.0922789888E13d, 2.631308369336935E35d, 1.2413915592536073E61d, 1.2688693218588417E89d, 7.156945704626381E118d, 9.916779348709496E149d, 1.974506857221074E182d, 3.856204823625804E215d, 5.5502938327393044E249d, 4.7147236359920616E284d};

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f38772a;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            f38772a = iArr;
            try {
                iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f38772a[RoundingMode.FLOOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f38772a[RoundingMode.CEILING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f38772a[RoundingMode.DOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f38772a[RoundingMode.UP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f38772a[RoundingMode.HALF_EVEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f38772a[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f38772a[RoundingMode.HALF_DOWN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public static boolean a(double d11) {
        return c.c(d11) && (d11 == 0.0d || 52 - Long.numberOfTrailingZeros(c.b(d11)) <= Math.getExponent(d11));
    }

    public static double b(double d11, RoundingMode roundingMode) {
        if (!c.c(d11)) {
            throw new ArithmeticException("input is infinite or NaN");
        }
        switch (a.f38772a[roundingMode.ordinal()]) {
            case 1:
                g.f(a(d11));
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
        g.a(((-9.223372036854776E18d) - dB < 1.0d) & (dB < 9.223372036854776E18d), d11, roundingMode);
        return (long) dB;
    }
}
