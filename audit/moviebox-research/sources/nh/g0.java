package nh;

import android.util.SparseArray;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class g0<V> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.google.android.exoplayer2.util.i<V> f71925c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SparseArray<V> f71924b = new SparseArray<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f71923a = -1;

    public g0(com.google.android.exoplayer2.util.i<V> iVar) {
        this.f71925c = iVar;
    }

    public void a(int i11, V v11) {
        if (this.f71923a == -1) {
            com.google.android.exoplayer2.util.a.g(this.f71924b.size() == 0);
            this.f71923a = 0;
        }
        if (this.f71924b.size() > 0) {
            SparseArray<V> sparseArray = this.f71924b;
            int iKeyAt = sparseArray.keyAt(sparseArray.size() - 1);
            com.google.android.exoplayer2.util.a.a(i11 >= iKeyAt);
            if (iKeyAt == i11) {
                com.google.android.exoplayer2.util.i<V> iVar = this.f71925c;
                SparseArray<V> sparseArray2 = this.f71924b;
                iVar.accept(sparseArray2.valueAt(sparseArray2.size() - 1));
            }
        }
        this.f71924b.append(i11, v11);
    }

    public void b() {
        for (int i11 = 0; i11 < this.f71924b.size(); i11++) {
            this.f71925c.accept(this.f71924b.valueAt(i11));
        }
        this.f71923a = -1;
        this.f71924b.clear();
    }

    public void c(int i11) {
        for (int size = this.f71924b.size() - 1; size >= 0 && i11 < this.f71924b.keyAt(size); size--) {
            this.f71925c.accept(this.f71924b.valueAt(size));
            this.f71924b.removeAt(size);
        }
        this.f71923a = this.f71924b.size() > 0 ? Math.min(this.f71923a, this.f71924b.size() - 1) : -1;
    }

    public void d(int i11) {
        int i12 = 0;
        while (i12 < this.f71924b.size() - 1) {
            int i13 = i12 + 1;
            if (i11 < this.f71924b.keyAt(i13)) {
                return;
            }
            this.f71925c.accept(this.f71924b.valueAt(i12));
            this.f71924b.removeAt(i12);
            int i14 = this.f71923a;
            if (i14 > 0) {
                this.f71923a = i14 - 1;
            }
            i12 = i13;
        }
    }

    public V e(int i11) {
        if (this.f71923a == -1) {
            this.f71923a = 0;
        }
        while (true) {
            int i12 = this.f71923a;
            if (i12 <= 0 || i11 >= this.f71924b.keyAt(i12)) {
                break;
            }
            this.f71923a--;
        }
        while (this.f71923a < this.f71924b.size() - 1 && i11 >= this.f71924b.keyAt(this.f71923a + 1)) {
            this.f71923a++;
        }
        return this.f71924b.valueAt(this.f71923a);
    }

    public V f() {
        SparseArray<V> sparseArray = this.f71924b;
        return sparseArray.valueAt(sparseArray.size() - 1);
    }

    public boolean g() {
        return this.f71924b.size() == 0;
    }
}
