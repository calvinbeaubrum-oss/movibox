package z3;

import android.text.TextUtils;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static void a(boolean z11) {
        if (!z11) {
            throw new IllegalArgumentException();
        }
    }

    public static void b(boolean z11, Object obj) {
        if (!z11) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static int c(int i11, int i12, int i13) {
        if (i11 < i12 || i11 >= i13) {
            throw new IndexOutOfBoundsException();
        }
        return i11;
    }

    public static String d(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException();
        }
        return str;
    }

    public static <T> T e(@Nullable T t11) {
        t11.getClass();
        return t11;
    }

    public static <T> T f(@Nullable T t11, Object obj) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static void g(boolean z11) {
        if (!z11) {
            throw new IllegalStateException();
        }
    }

    public static void h(boolean z11, Object obj) {
        if (!z11) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static <T> T i(@Nullable T t11) {
        if (t11 != null) {
            return t11;
        }
        throw new IllegalStateException();
    }

    public static <T> T j(@Nullable T t11, Object obj) {
        if (t11 != null) {
            return t11;
        }
        throw new IllegalStateException(String.valueOf(obj));
    }
}
