package bu;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class h<T> extends g<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f14412c;

    public h(int i11) {
        super(i11);
        this.f14412c = new Object();
    }

    @Override // bu.g, bu.f
    public T acquire() {
        T t11;
        synchronized (this.f14412c) {
            t11 = (T) super.acquire();
        }
        return t11;
    }

    @Override // bu.g, bu.f
    public boolean release(T t11) {
        boolean zRelease;
        synchronized (this.f14412c) {
            zRelease = super.release(t11);
        }
        return zRelease;
    }
}
