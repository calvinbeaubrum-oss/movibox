package com.google.common.base;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class m {
    public static void A(boolean z11, String str, Object obj, Object obj2) {
        if (!z11) {
            throw new IllegalStateException(p.c(str, obj, obj2));
        }
    }

    public static String a(int i11, int i12, String str) {
        if (i11 < 0) {
            return p.c("%s (%s) must not be negative", str, Integer.valueOf(i11));
        }
        if (i12 >= 0) {
            return p.c("%s (%s) must be less than size (%s)", str, Integer.valueOf(i11), Integer.valueOf(i12));
        }
        throw new IllegalArgumentException("negative size: " + i12);
    }

    public static String b(int i11, int i12, String str) {
        if (i11 < 0) {
            return p.c("%s (%s) must not be negative", str, Integer.valueOf(i11));
        }
        if (i12 >= 0) {
            return p.c("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i11), Integer.valueOf(i12));
        }
        throw new IllegalArgumentException("negative size: " + i12);
    }

    public static String c(int i11, int i12, int i13) {
        if (i11 < 0 || i11 > i13) {
            return b(i11, i13, "start index");
        }
        return (i12 < 0 || i12 > i13) ? b(i12, i13, "end index") : p.c("end index (%s) must not be less than start index (%s)", Integer.valueOf(i12), Integer.valueOf(i11));
    }

    public static void d(boolean z11) {
        if (!z11) {
            throw new IllegalArgumentException();
        }
    }

    public static void e(boolean z11, Object obj) {
        if (!z11) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void f(boolean z11, String str, char c11) {
        if (!z11) {
            throw new IllegalArgumentException(p.c(str, Character.valueOf(c11)));
        }
    }

    public static void g(boolean z11, String str, int i11) {
        if (!z11) {
            throw new IllegalArgumentException(p.c(str, Integer.valueOf(i11)));
        }
    }

    public static void h(boolean z11, String str, int i11, int i12) {
        if (!z11) {
            throw new IllegalArgumentException(p.c(str, Integer.valueOf(i11), Integer.valueOf(i12)));
        }
    }

    public static void i(boolean z11, String str, long j11) {
        if (!z11) {
            throw new IllegalArgumentException(p.c(str, Long.valueOf(j11)));
        }
    }

    public static void j(boolean z11, String str, long j11, long j12) {
        if (!z11) {
            throw new IllegalArgumentException(p.c(str, Long.valueOf(j11), Long.valueOf(j12)));
        }
    }

    public static void k(boolean z11, String str, Object obj) {
        if (!z11) {
            throw new IllegalArgumentException(p.c(str, obj));
        }
    }

    public static void l(boolean z11, String str, Object obj, Object obj2) {
        if (!z11) {
            throw new IllegalArgumentException(p.c(str, obj, obj2));
        }
    }

    public static void m(boolean z11, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (!z11) {
            throw new IllegalArgumentException(p.c(str, obj, obj2, obj3, obj4));
        }
    }

    public static int n(int i11, int i12) {
        return o(i11, i12, "index");
    }

    public static int o(int i11, int i12, String str) {
        if (i11 < 0 || i11 >= i12) {
            throw new IndexOutOfBoundsException(a(i11, i12, str));
        }
        return i11;
    }

    public static <T> T p(T t11) {
        t11.getClass();
        return t11;
    }

    public static <T> T q(T t11, Object obj) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static <T> T r(T t11, String str, Object obj) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException(p.c(str, obj));
    }

    public static int s(int i11, int i12) {
        return t(i11, i12, "index");
    }

    public static int t(int i11, int i12, String str) {
        if (i11 < 0 || i11 > i12) {
            throw new IndexOutOfBoundsException(b(i11, i12, str));
        }
        return i11;
    }

    public static void u(int i11, int i12, int i13) {
        if (i11 < 0 || i12 < i11 || i12 > i13) {
            throw new IndexOutOfBoundsException(c(i11, i12, i13));
        }
    }

    public static void v(boolean z11) {
        if (!z11) {
            throw new IllegalStateException();
        }
    }

    public static void w(boolean z11, Object obj) {
        if (!z11) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void x(boolean z11, String str, int i11) {
        if (!z11) {
            throw new IllegalStateException(p.c(str, Integer.valueOf(i11)));
        }
    }

    public static void y(boolean z11, String str, long j11) {
        if (!z11) {
            throw new IllegalStateException(p.c(str, Long.valueOf(j11)));
        }
    }

    public static void z(boolean z11, String str, Object obj) {
        if (!z11) {
            throw new IllegalStateException(p.c(str, obj));
        }
    }
}
