package androidx.core.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class d {
    public static boolean a(@Nullable Object obj, @Nullable Object obj2) {
        return Objects.equals(obj, obj2);
    }

    public static int b(@Nullable Object... objArr) {
        return Objects.hash(objArr);
    }

    @NonNull
    public static <T> T c(@Nullable T t11) {
        t11.getClass();
        return t11;
    }

    @NonNull
    public static <T> T d(@Nullable T t11, @NonNull String str) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException(str);
    }

    @Nullable
    public static String e(@Nullable Object obj, @Nullable String str) {
        return obj != null ? obj.toString() : str;
    }
}
