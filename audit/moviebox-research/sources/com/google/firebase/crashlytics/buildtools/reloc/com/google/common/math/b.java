package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.math;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class b {
    public static double a(double d11) {
        l.d(!Double.isNaN(d11));
        if (d11 > 0.0d) {
            return d11;
        }
        return 0.0d;
    }

    public static long b(double d11) {
        l.e(c(d11), "not a normal value");
        int exponent = Math.getExponent(d11);
        long jDoubleToRawLongBits = Double.doubleToRawLongBits(d11) & 4503599627370495L;
        return exponent == -1023 ? jDoubleToRawLongBits << 1 : jDoubleToRawLongBits | 4503599627370496L;
    }

    public static boolean c(double d11) {
        return Math.getExponent(d11) <= 1023;
    }
}
