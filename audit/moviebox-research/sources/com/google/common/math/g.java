package com.google.common.math;

import java.math.RoundingMode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class g {
    public static void a(boolean z11, double d11, RoundingMode roundingMode) {
        if (z11) {
            return;
        }
        throw new ArithmeticException("rounded value is out of range for input " + d11 + " and rounding mode " + roundingMode);
    }

    public static void b(boolean z11, String str, int i11, int i12) {
        if (z11) {
            return;
        }
        throw new ArithmeticException("overflow: " + str + "(" + i11 + ", " + i12 + ")");
    }

    public static void c(boolean z11, String str, long j11, long j12) {
        if (z11) {
            return;
        }
        throw new ArithmeticException("overflow: " + str + "(" + j11 + ", " + j12 + ")");
    }

    public static long d(String str, long j11) {
        if (j11 >= 0) {
            return j11;
        }
        throw new IllegalArgumentException(str + " (" + j11 + ") must be >= 0");
    }

    public static int e(String str, int i11) {
        if (i11 > 0) {
            return i11;
        }
        throw new IllegalArgumentException(str + " (" + i11 + ") must be > 0");
    }

    public static void f(boolean z11) {
        if (!z11) {
            throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
        }
    }
}
