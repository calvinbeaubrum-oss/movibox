package fk;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class a {
    public static void a(boolean z11, String str) {
        if (!z11) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void b(boolean z11, String str, Object... objArr) {
        if (!z11) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static <T extends CharSequence> T c(T t11, String str) {
        if (t11 == null) {
            throw new IllegalArgumentException(str + " may not be null");
        }
        if (t11.length() == 0) {
            throw new IllegalArgumentException(str + " may not be empty");
        }
        if (!f.a(t11)) {
            return t11;
        }
        throw new IllegalArgumentException(str + " may not contain blanks");
    }

    public static <T extends CharSequence> T d(T t11, String str) {
        if (t11 == null) {
            throw new IllegalArgumentException(str + " may not be null");
        }
        if (!f.b(t11)) {
            return t11;
        }
        throw new IllegalArgumentException(str + " may not be blank");
    }

    public static <T extends CharSequence> T e(T t11, String str) {
        if (t11 == null) {
            throw new IllegalArgumentException(str + " may not be null");
        }
        if (!f.c(t11)) {
            return t11;
        }
        throw new IllegalArgumentException(str + " may not be empty");
    }

    public static int f(int i11, String str) {
        if (i11 >= 0) {
            return i11;
        }
        throw new IllegalArgumentException(str + " may not be negative");
    }

    public static <T> T g(T t11, String str) {
        if (t11 != null) {
            return t11;
        }
        throw new IllegalArgumentException(str + " may not be null");
    }
}
