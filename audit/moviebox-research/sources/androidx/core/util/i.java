package androidx.core.util;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Locale;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i {
    public static void a(boolean z11) {
        if (!z11) {
            throw new IllegalArgumentException();
        }
    }

    public static void b(boolean z11, @NonNull Object obj) {
        if (!z11) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static int c(int i11, int i12, int i13, @NonNull String str) {
        if (i11 < i12) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", str, Integer.valueOf(i12), Integer.valueOf(i13)));
        }
        if (i11 <= i13) {
            return i11;
        }
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", str, Integer.valueOf(i12), Integer.valueOf(i13)));
    }

    public static int d(int i11) {
        if (i11 >= 0) {
            return i11;
        }
        throw new IllegalArgumentException();
    }

    public static int e(int i11, @Nullable String str) {
        if (i11 >= 0) {
            return i11;
        }
        throw new IllegalArgumentException(str);
    }

    public static int f(int i11, int i12) {
        if ((i11 & i12) == i11) {
            return i11;
        }
        throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(i11) + ", but only 0x" + Integer.toHexString(i12) + " are allowed");
    }

    @NonNull
    public static <T> T g(@Nullable T t11) {
        t11.getClass();
        return t11;
    }

    @NonNull
    public static <T> T h(@Nullable T t11, @NonNull Object obj) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static void i(boolean z11, @Nullable String str) {
        if (!z11) {
            throw new IllegalStateException(str);
        }
    }

    @NonNull
    public static <T extends CharSequence> T j(@Nullable T t11, @NonNull Object obj) {
        if (TextUtils.isEmpty(t11)) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
        return t11;
    }
}
