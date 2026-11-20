package bu;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class g<T> implements f<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f14410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f14411b;

    public g(int i11) {
        if (i11 <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.f14410a = new Object[i11];
    }

    public final boolean a(T t11) {
        for (int i11 = 0; i11 < this.f14411b; i11++) {
            if (this.f14410a[i11] == t11) {
                return true;
            }
        }
        return false;
    }

    @Override // bu.f
    public T acquire() {
        int i11 = this.f14411b;
        if (i11 <= 0) {
            return null;
        }
        int i12 = i11 - 1;
        Object[] objArr = this.f14410a;
        T t11 = (T) objArr[i12];
        objArr[i12] = null;
        this.f14411b = i12;
        return t11;
    }

    @Override // bu.f
    public boolean release(T t11) {
        if (a(t11)) {
            throw new IllegalStateException("Already in the pool!");
        }
        int i11 = this.f14411b;
        Object[] objArr = this.f14410a;
        if (i11 >= objArr.length) {
            return false;
        }
        objArr[i11] = t11;
        this.f14411b = i11 + 1;
        return true;
    }
}
