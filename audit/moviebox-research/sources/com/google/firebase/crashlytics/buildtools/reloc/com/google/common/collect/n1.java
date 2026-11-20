package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class n1 {
    public static void a(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("null key in entry: null=" + obj2);
        }
        if (obj2 != null) {
            return;
        }
        throw new NullPointerException("null value in entry: " + obj + "=null");
    }

    public static int b(int i11, String str) {
        if (i11 >= 0) {
            return i11;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + i11);
    }

    public static long c(long j11, String str) {
        if (j11 >= 0) {
            return j11;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + j11);
    }

    public static void d(int i11, String str) {
        if (i11 > 0) {
            return;
        }
        throw new IllegalArgumentException(str + " must be positive but was: " + i11);
    }

    public static void e(boolean z11) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.u(z11, "no calls to next() since the last call to remove()");
    }
}
