package p4;

import android.util.SparseArray;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h0<V> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final z3.h<V> f73564c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SparseArray<V> f73563b = new SparseArray<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f73562a = -1;

    public h0(z3.h<V> hVar) {
        this.f73564c = hVar;
    }

    public void a(int i11, V v11) {
        if (this.f73562a == -1) {
            z3.a.g(this.f73563b.size() == 0);
            this.f73562a = 0;
        }
        if (this.f73563b.size() > 0) {
            SparseArray<V> sparseArray = this.f73563b;
            int iKeyAt = sparseArray.keyAt(sparseArray.size() - 1);
            z3.a.a(i11 >= iKeyAt);
            if (iKeyAt == i11) {
                z3.h<V> hVar = this.f73564c;
                SparseArray<V> sparseArray2 = this.f73563b;
                hVar.accept(sparseArray2.valueAt(sparseArray2.size() - 1));
            }
        }
        this.f73563b.append(i11, v11);
    }

    public void b() {
        for (int i11 = 0; i11 < this.f73563b.size(); i11++) {
            this.f73564c.accept(this.f73563b.valueAt(i11));
        }
        this.f73562a = -1;
        this.f73563b.clear();
    }

    public void c(int i11) {
        for (int size = this.f73563b.size() - 1; size >= 0 && i11 < this.f73563b.keyAt(size); size--) {
            this.f73564c.accept(this.f73563b.valueAt(size));
            this.f73563b.removeAt(size);
        }
        this.f73562a = this.f73563b.size() > 0 ? Math.min(this.f73562a, this.f73563b.size() - 1) : -1;
    }

    public void d(int i11) {
        int i12 = 0;
        while (i12 < this.f73563b.size() - 1) {
            int i13 = i12 + 1;
            if (i11 < this.f73563b.keyAt(i13)) {
                return;
            }
            this.f73564c.accept(this.f73563b.valueAt(i12));
            this.f73563b.removeAt(i12);
            int i14 = this.f73562a;
            if (i14 > 0) {
                this.f73562a = i14 - 1;
            }
            i12 = i13;
        }
    }

    public V e(int i11) {
        if (this.f73562a == -1) {
            this.f73562a = 0;
        }
        while (true) {
            int i12 = this.f73562a;
            if (i12 <= 0 || i11 >= this.f73563b.keyAt(i12)) {
                break;
            }
            this.f73562a--;
        }
        while (this.f73562a < this.f73563b.size() - 1 && i11 >= this.f73563b.keyAt(this.f73562a + 1)) {
            this.f73562a++;
        }
        return this.f73563b.valueAt(this.f73562a);
    }

    public V f() {
        SparseArray<V> sparseArray = this.f73563b;
        return sparseArray.valueAt(sparseArray.size() - 1);
    }

    public boolean g() {
        return this.f73563b.size() == 0;
    }
}
