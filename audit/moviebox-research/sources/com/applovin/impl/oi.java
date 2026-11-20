package com.applovin.impl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class oi extends ib {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final oi f21553i = new oi(new Object[0], 0, null, 0, 0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final transient Object[] f21554c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final transient Object[] f21555d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final transient int f21556f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final transient int f21557g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final transient int f21558h;

    public oi(Object[] objArr, int i11, Object[] objArr2, int i12, int i13) {
        this.f21554c = objArr;
        this.f21555d = objArr2;
        this.f21556f = i12;
        this.f21557g = i11;
        this.f21558h = i13;
    }

    @Override // com.applovin.impl.cb
    public int a(Object[] objArr, int i11) {
        System.arraycopy(this.f21554c, 0, objArr, i11, this.f21558h);
        return i11 + this.f21558h;
    }

    @Override // com.applovin.impl.cb
    public Object[] b() {
        return this.f21554c;
    }

    @Override // com.applovin.impl.cb
    public int c() {
        return this.f21558h;
    }

    @Override // com.applovin.impl.cb, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        Object[] objArr = this.f21555d;
        if (obj == null || objArr == null) {
            return false;
        }
        int iA = ka.a(obj);
        while (true) {
            int i11 = iA & this.f21556f;
            Object obj2 = objArr[i11];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            iA = i11 + 1;
        }
    }

    @Override // com.applovin.impl.cb
    public int d() {
        return 0;
    }

    @Override // com.applovin.impl.cb
    public boolean e() {
        return false;
    }

    @Override // com.applovin.impl.ib
    public eb f() {
        return eb.b(this.f21554c, this.f21558h);
    }

    @Override // com.applovin.impl.ib
    public boolean g() {
        return true;
    }

    @Override // com.applovin.impl.ib, java.util.Collection, java.util.Set
    public int hashCode() {
        return this.f21557g;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public pp iterator() {
        return a().iterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f21558h;
    }
}
