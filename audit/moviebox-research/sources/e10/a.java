package e10;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class a<T> implements u10.a<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f63622c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile u10.a<T> f63623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Object f63624b = f63622c;

    public a(u10.a<T> aVar) {
        this.f63623a = aVar;
    }

    public static <P extends u10.a<T>, T> u10.a<T> a(P p11) {
        b.b(p11);
        return p11 instanceof a ? p11 : new a(p11);
    }

    public static Object b(Object obj, Object obj2) {
        if (obj == f63622c || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    @Override // u10.a
    public T get() {
        T t11 = (T) this.f63624b;
        Object obj = f63622c;
        if (t11 == obj) {
            synchronized (this) {
                try {
                    t11 = (T) this.f63624b;
                    if (t11 == obj) {
                        t11 = this.f63623a.get();
                        this.f63624b = b(this.f63624b, t11);
                        this.f63623a = null;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return t11;
    }
}
