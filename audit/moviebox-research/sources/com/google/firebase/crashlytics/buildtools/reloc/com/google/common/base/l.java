package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class l {
    public static String a(int i11, int i12, String str) {
        if (i11 < 0) {
            return x("%s (%s) must not be negative", str, Integer.valueOf(i11));
        }
        if (i12 >= 0) {
            return x("%s (%s) must be less than size (%s)", str, Integer.valueOf(i11), Integer.valueOf(i12));
        }
        throw new IllegalArgumentException("negative size: " + i12);
    }

    public static String b(int i11, int i12, String str) {
        if (i11 < 0) {
            return x("%s (%s) must not be negative", str, Integer.valueOf(i11));
        }
        if (i12 >= 0) {
            return x("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i11), Integer.valueOf(i12));
        }
        throw new IllegalArgumentException("negative size: " + i12);
    }

    public static String c(int i11, int i12, int i13) {
        if (i11 < 0 || i11 > i13) {
            return b(i11, i13, "start index");
        }
        return (i12 < 0 || i12 > i13) ? b(i12, i13, "end index") : x("end index (%s) must not be less than start index (%s)", Integer.valueOf(i12), Integer.valueOf(i11));
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

    public static void f(boolean z11, String str, int i11) {
        if (!z11) {
            throw new IllegalArgumentException(x(str, Integer.valueOf(i11)));
        }
    }

    public static void g(boolean z11, String str, int i11, int i12) {
        if (!z11) {
            throw new IllegalArgumentException(x(str, Integer.valueOf(i11), Integer.valueOf(i12)));
        }
    }

    public static void h(boolean z11, String str, long j11) {
        if (!z11) {
            throw new IllegalArgumentException(x(str, Long.valueOf(j11)));
        }
    }

    public static void i(boolean z11, String str, long j11, long j12) {
        if (!z11) {
            throw new IllegalArgumentException(x(str, Long.valueOf(j11), Long.valueOf(j12)));
        }
    }

    public static void j(boolean z11, String str, Object obj) {
        if (!z11) {
            throw new IllegalArgumentException(x(str, obj));
        }
    }

    public static void k(boolean z11, String str, Object obj, Object obj2) {
        if (!z11) {
            throw new IllegalArgumentException(x(str, obj, obj2));
        }
    }

    public static int l(int i11, int i12) {
        return m(i11, i12, "index");
    }

    public static int m(int i11, int i12, String str) {
        if (i11 < 0 || i11 >= i12) {
            throw new IndexOutOfBoundsException(a(i11, i12, str));
        }
        return i11;
    }

    public static <T> T n(T t11) {
        t11.getClass();
        return t11;
    }

    public static <T> T o(T t11, Object obj) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static <T> T p(T t11, String str, Object obj, Object obj2) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException(x(str, obj, obj2));
    }

    public static int q(int i11, int i12) {
        return r(i11, i12, "index");
    }

    public static int r(int i11, int i12, String str) {
        if (i11 < 0 || i11 > i12) {
            throw new IndexOutOfBoundsException(b(i11, i12, str));
        }
        return i11;
    }

    public static void s(int i11, int i12, int i13) {
        if (i11 < 0 || i12 < i11 || i12 > i13) {
            throw new IndexOutOfBoundsException(c(i11, i12, i13));
        }
    }

    public static void t(boolean z11) {
        if (!z11) {
            throw new IllegalStateException();
        }
    }

    public static void u(boolean z11, Object obj) {
        if (!z11) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void v(boolean z11, String str, int i11) {
        if (!z11) {
            throw new IllegalStateException(x(str, Integer.valueOf(i11)));
        }
    }

    public static void w(boolean z11, String str, Object obj) {
        if (!z11) {
            throw new IllegalStateException(x(str, obj));
        }
    }

    public static String x(String str, Object... objArr) {
        int iIndexOf;
        String strValueOf = String.valueOf(str);
        int i11 = 0;
        if (objArr == null) {
            objArr = new Object[]{"(Object[])null"};
        }
        StringBuilder sb2 = new StringBuilder(strValueOf.length() + (objArr.length * 16));
        int i12 = 0;
        while (i11 < objArr.length && (iIndexOf = strValueOf.indexOf("%s", i12)) != -1) {
            sb2.append((CharSequence) strValueOf, i12, iIndexOf);
            sb2.append(objArr[i11]);
            i12 = iIndexOf + 2;
            i11++;
        }
        sb2.append((CharSequence) strValueOf, i12, strValueOf.length());
        if (i11 < objArr.length) {
            sb2.append(" [");
            sb2.append(objArr[i11]);
            for (int i13 = i11 + 1; i13 < objArr.length; i13++) {
                sb2.append(", ");
                sb2.append(objArr[i13]);
            }
            sb2.append(']');
        }
        return sb2.toString();
    }
}
