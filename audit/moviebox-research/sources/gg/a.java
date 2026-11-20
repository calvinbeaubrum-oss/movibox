package gg;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a<T> implements u10.a<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f65495c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile u10.a<T> f65496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Object f65497b = f65495c;

    public a(u10.a<T> aVar) {
        this.f65496a = aVar;
    }

    public static <P extends u10.a<T>, T> u10.a<T> a(P p11) {
        d.b(p11);
        return p11 instanceof a ? p11 : new a(p11);
    }

    private static Object b(Object obj, Object obj2) {
        if (obj == f65495c || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    @Override // u10.a
    public T get() {
        T t11 = (T) this.f65497b;
        Object obj = f65495c;
        if (t11 == obj) {
            synchronized (this) {
                try {
                    t11 = (T) this.f65497b;
                    if (t11 == obj) {
                        t11 = this.f65496a.get();
                        this.f65497b = b(this.f65497b, t11);
                        this.f65496a = null;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return t11;
    }
}
