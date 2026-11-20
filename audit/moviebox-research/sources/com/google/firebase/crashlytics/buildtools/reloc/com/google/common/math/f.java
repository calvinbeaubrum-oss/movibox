package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.math;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class f {
    public static void a(boolean z11) {
        if (!z11) {
            throw new ArithmeticException("not in range");
        }
    }

    public static void b(boolean z11, String str, int i11, int i12) {
        if (z11) {
            return;
        }
        throw new ArithmeticException("overflow: " + str + "(" + i11 + ", " + i12 + ")");
    }

    public static int c(String str, int i11) {
        if (i11 > 0) {
            return i11;
        }
        throw new IllegalArgumentException(str + " (" + i11 + ") must be > 0");
    }

    public static void d(boolean z11) {
        if (!z11) {
            throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
        }
    }
}
