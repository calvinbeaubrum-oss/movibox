package gg;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class c<T> implements b<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c<Object> f65498b = new c<>(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f65499a;

    public c(T t11) {
        this.f65499a = t11;
    }

    public static <T> b<T> a(T t11) {
        return new c(d.c(t11, "instance cannot be null"));
    }

    @Override // u10.a
    public T get() {
        return this.f65499a;
    }
}
