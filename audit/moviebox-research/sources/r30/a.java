package r30;

import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class a implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object[] f75112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f75113b = 0;

    public a(Object[] objArr) {
        this.f75112a = objArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f75113b != this.f75112a.length;
    }

    @Override // java.util.Iterator
    public Object next() {
        Object[] objArr = this.f75112a;
        int i11 = this.f75113b;
        this.f75113b = i11 + 1;
        return objArr[i11];
    }

    @Override // java.util.Iterator
    public void remove() {
    }
}
