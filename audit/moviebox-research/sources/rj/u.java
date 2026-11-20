package rj;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class u<T> implements bl.b<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f75576c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Object f75577a = f75576c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile bl.b<T> f75578b;

    public u(bl.b<T> bVar) {
        this.f75578b = bVar;
    }

    @Override // bl.b
    public T get() {
        T t11 = (T) this.f75577a;
        Object obj = f75576c;
        if (t11 == obj) {
            synchronized (this) {
                try {
                    t11 = (T) this.f75577a;
                    if (t11 == obj) {
                        t11 = this.f75578b.get();
                        this.f75577a = t11;
                        this.f75578b = null;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return t11;
    }
}
