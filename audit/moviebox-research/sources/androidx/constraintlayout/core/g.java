package androidx.constraintlayout.core;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class g<T> implements f<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f6372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6373b;

    public g(int i11) {
        if (i11 <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.f6372a = new Object[i11];
    }

    @Override // androidx.constraintlayout.core.f
    public void a(T[] tArr, int i11) {
        if (i11 > tArr.length) {
            i11 = tArr.length;
        }
        for (int i12 = 0; i12 < i11; i12++) {
            T t11 = tArr[i12];
            int i13 = this.f6373b;
            Object[] objArr = this.f6372a;
            if (i13 < objArr.length) {
                objArr[i13] = t11;
                this.f6373b = i13 + 1;
            }
        }
    }

    @Override // androidx.constraintlayout.core.f
    public T acquire() {
        int i11 = this.f6373b;
        if (i11 <= 0) {
            return null;
        }
        int i12 = i11 - 1;
        Object[] objArr = this.f6372a;
        T t11 = (T) objArr[i12];
        objArr[i12] = null;
        this.f6373b = i11 - 1;
        return t11;
    }

    @Override // androidx.constraintlayout.core.f
    public boolean release(T t11) {
        int i11 = this.f6373b;
        Object[] objArr = this.f6372a;
        if (i11 >= objArr.length) {
            return false;
        }
        objArr[i11] = t11;
        this.f6373b = i11 + 1;
        return true;
    }
}
