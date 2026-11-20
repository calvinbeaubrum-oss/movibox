package cg;

import androidx.annotation.Nullable;
import com.google.android.datatransport.Priority;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class d<T> {
    public static <T> d<T> e(T t11) {
        return new a(null, t11, Priority.DEFAULT, null);
    }

    public static <T> d<T> f(T t11, @Nullable e eVar) {
        return new a(null, t11, Priority.DEFAULT, eVar);
    }

    public static <T> d<T> g(T t11) {
        return new a(null, t11, Priority.HIGHEST, null);
    }

    @Nullable
    public abstract Integer a();

    public abstract T b();

    public abstract Priority c();

    @Nullable
    public abstract e d();
}
