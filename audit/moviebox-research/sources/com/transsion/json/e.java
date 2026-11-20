package com.transsion.json;

import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class e implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Iterator[] f52944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f52945b = 0;

    public e(Set... setArr) {
        this.f52944a = new Iterator[setArr.length];
        for (int i11 = 0; i11 < setArr.length; i11++) {
            this.f52944a[i11] = setArr[i11].iterator();
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.f52944a[this.f52945b].hasNext()) {
            return true;
        }
        int i11 = this.f52945b + 1;
        this.f52945b = i11;
        Iterator[] itArr = this.f52944a;
        return i11 < itArr.length && itArr[i11].hasNext();
    }

    @Override // java.util.Iterator
    public Object next() {
        return this.f52944a[this.f52945b].next();
    }

    @Override // java.util.Iterator
    public void remove() {
        this.f52944a[this.f52945b].remove();
    }
}
