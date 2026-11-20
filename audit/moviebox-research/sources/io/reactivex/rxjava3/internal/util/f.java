package io.reactivex.rxjava3.internal.util;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class f<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f67553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f67554b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f67555c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f67556d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public T[] f67557e;

    public f() {
        this(16, 0.75f);
    }

    public f(int i11, float f11) {
        this.f67553a = f11;
        int iA = g.a(i11);
        this.f67554b = iA - 1;
        this.f67556d = (int) (f11 * iA);
        this.f67557e = (T[]) new Object[iA];
    }

    public static int c(int i11) {
        int i12 = i11 * (-1640531527);
        return i12 ^ (i12 >>> 16);
    }

    public boolean a(T t11) {
        T t12;
        T[] tArr = this.f67557e;
        int i11 = this.f67554b;
        int iC = c(t11.hashCode()) & i11;
        T t13 = tArr[iC];
        if (t13 != null) {
            if (t13.equals(t11)) {
                return false;
            }
            do {
                iC = (iC + 1) & i11;
                t12 = tArr[iC];
                if (t12 == null) {
                }
            } while (!t12.equals(t11));
            return false;
        }
        tArr[iC] = t11;
        int i12 = this.f67555c + 1;
        this.f67555c = i12;
        if (i12 >= this.f67556d) {
            d();
        }
        return true;
    }

    public Object[] b() {
        return this.f67557e;
    }

    public void d() {
        T t11;
        T[] tArr = this.f67557e;
        int length = tArr.length;
        int i11 = length << 1;
        int i12 = i11 - 1;
        T[] tArr2 = (T[]) new Object[i11];
        int i13 = this.f67555c;
        while (true) {
            int i14 = i13 - 1;
            if (i13 == 0) {
                this.f67554b = i12;
                this.f67556d = (int) (i11 * this.f67553a);
                this.f67557e = tArr2;
                return;
            }
            do {
                length--;
                t11 = tArr[length];
            } while (t11 == null);
            int iC = c(t11.hashCode()) & i12;
            if (tArr2[iC] != null) {
                do {
                    iC = (iC + 1) & i12;
                } while (tArr2[iC] != null);
            }
            tArr2[iC] = tArr[length];
            i13 = i14;
        }
    }

    public boolean e(T t11) {
        T t12;
        T[] tArr = this.f67557e;
        int i11 = this.f67554b;
        int iC = c(t11.hashCode()) & i11;
        T t13 = tArr[iC];
        if (t13 == null) {
            return false;
        }
        if (t13.equals(t11)) {
            return f(iC, tArr, i11);
        }
        do {
            iC = (iC + 1) & i11;
            t12 = tArr[iC];
            if (t12 == null) {
                return false;
            }
        } while (!t12.equals(t11));
        return f(iC, tArr, i11);
    }

    public boolean f(int i11, T[] tArr, int i12) {
        int i13;
        T t11;
        this.f67555c--;
        while (true) {
            int i14 = i11 + 1;
            while (true) {
                i13 = i14 & i12;
                t11 = tArr[i13];
                if (t11 != null) {
                    int iC = c(t11.hashCode()) & i12;
                    if (i11 > i13) {
                        if (i11 >= iC && iC > i13) {
                            break;
                        }
                        i14 = i13 + 1;
                    } else {
                        if (i11 >= iC || iC > i13) {
                            break;
                        }
                        i14 = i13 + 1;
                    }
                } else {
                    tArr[i11] = null;
                    return true;
                }
            }
            tArr[i11] = t11;
            i11 = i13;
        }
    }
}
