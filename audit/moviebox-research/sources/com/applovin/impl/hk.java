package com.applovin.impl;

import com.applovin.exoplayer2.common.base.Preconditions;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class hk extends ib {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final transient Object f19501c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private transient int f19502d;

    public hk(Object obj) {
        this.f19501c = Preconditions.checkNotNull(obj);
    }

    public hk(Object obj, int i11) {
        this.f19501c = obj;
        this.f19502d = i11;
    }

    @Override // com.applovin.impl.cb
    public int a(Object[] objArr, int i11) {
        objArr[i11] = this.f19501c;
        return i11 + 1;
    }

    @Override // com.applovin.impl.cb, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return this.f19501c.equals(obj);
    }

    @Override // com.applovin.impl.cb
    public boolean e() {
        return false;
    }

    @Override // com.applovin.impl.ib
    public eb f() {
        return eb.a(this.f19501c);
    }

    @Override // com.applovin.impl.ib
    public boolean g() {
        return this.f19502d != 0;
    }

    @Override // com.applovin.impl.ib, java.util.Collection, java.util.Set
    public final int hashCode() {
        int i11 = this.f19502d;
        if (i11 != 0) {
            return i11;
        }
        int iHashCode = this.f19501c.hashCode();
        this.f19502d = iHashCode;
        return iHashCode;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public pp iterator() {
        return xb.a(this.f19501c);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return '[' + this.f19501c.toString() + ']';
    }
}
