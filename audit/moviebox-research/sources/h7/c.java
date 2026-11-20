package h7;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b<T> f66372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public y6.a<?, ?> f66373b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public T f66374c;

    public c() {
        this.f66372a = new b<>();
        this.f66374c = null;
    }

    public c(@Nullable T t11) {
        this.f66372a = new b<>();
        this.f66374c = t11;
    }

    @Nullable
    public T a(b<T> bVar) {
        return this.f66374c;
    }

    @Nullable
    public final T b(float f11, float f12, T t11, T t12, float f13, float f14, float f15) {
        return a(this.f66372a.h(f11, f12, t11, t12, f13, f14, f15));
    }

    public final void c(@Nullable y6.a<?, ?> aVar) {
        this.f66373b = aVar;
    }
}
