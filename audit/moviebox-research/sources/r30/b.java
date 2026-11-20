package r30;

import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class b implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f75114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f75115b;

    public b(int i11) {
        this.f75115b = i11;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f75114a < this.f75115b;
    }

    @Override // java.util.Iterator
    public Object next() {
        int i11 = this.f75114a;
        this.f75114a = i11 + 1;
        return Integer.valueOf(i11);
    }

    @Override // java.util.Iterator
    public void remove() {
    }
}
