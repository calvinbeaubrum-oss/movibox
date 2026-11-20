package com.applovin.impl;

import com.applovin.exoplayer2.common.base.Preconditions;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
class mi extends eb {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final eb f21163f = new mi(new Object[0], 0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final transient Object[] f21164c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final transient int f21165d;

    public mi(Object[] objArr, int i11) {
        this.f21164c = objArr;
        this.f21165d = i11;
    }

    @Override // com.applovin.impl.eb, com.applovin.impl.cb
    public int a(Object[] objArr, int i11) {
        System.arraycopy(this.f21164c, 0, objArr, i11, this.f21165d);
        return i11 + this.f21165d;
    }

    @Override // com.applovin.impl.cb
    public Object[] b() {
        return this.f21164c;
    }

    @Override // com.applovin.impl.cb
    public int c() {
        return this.f21165d;
    }

    @Override // com.applovin.impl.cb
    public int d() {
        return 0;
    }

    @Override // com.applovin.impl.cb
    public boolean e() {
        return false;
    }

    @Override // java.util.List
    public Object get(int i11) {
        Preconditions.checkElementIndex(i11, this.f21165d);
        return this.f21164c[i11];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f21165d;
    }
}
