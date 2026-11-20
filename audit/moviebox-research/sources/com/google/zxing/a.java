package com.google.zxing;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f41461a;

    public a(e eVar) {
        this.f41461a = eVar;
    }

    public abstract a a(e eVar);

    public abstract hm.b b() throws NotFoundException;

    public abstract hm.a c(int i11, hm.a aVar) throws NotFoundException;

    public final int d() {
        return this.f41461a.a();
    }

    public final e e() {
        return this.f41461a;
    }

    public final int f() {
        return this.f41461a.d();
    }
}
