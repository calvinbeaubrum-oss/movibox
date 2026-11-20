package com.applovin.impl;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class z1 implements p1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected p1.a f24738b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected p1.a f24739c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private p1.a f24740d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private p1.a f24741e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ByteBuffer f24742f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ByteBuffer f24743g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f24744h;

    public z1() {
        ByteBuffer byteBuffer = p1.f21632a;
        this.f24742f = byteBuffer;
        this.f24743g = byteBuffer;
        p1.a aVar = p1.a.f21633e;
        this.f24740d = aVar;
        this.f24741e = aVar;
        this.f24738b = aVar;
        this.f24739c = aVar;
    }

    @Override // com.applovin.impl.p1
    public final p1.a a(p1.a aVar) {
        this.f24740d = aVar;
        this.f24741e = b(aVar);
        return f() ? this.f24741e : p1.a.f21633e;
    }

    public final ByteBuffer a(int i11) {
        if (this.f24742f.capacity() < i11) {
            this.f24742f = ByteBuffer.allocateDirect(i11).order(ByteOrder.nativeOrder());
        } else {
            this.f24742f.clear();
        }
        ByteBuffer byteBuffer = this.f24742f;
        this.f24743g = byteBuffer;
        return byteBuffer;
    }

    public final boolean a() {
        return this.f24743g.hasRemaining();
    }

    public abstract p1.a b(p1.a aVar);

    @Override // com.applovin.impl.p1
    public final void b() {
        this.f24743g = p1.f21632a;
        this.f24744h = false;
        this.f24738b = this.f24740d;
        this.f24739c = this.f24741e;
        g();
    }

    @Override // com.applovin.impl.p1
    public boolean c() {
        return this.f24744h && this.f24743g == p1.f21632a;
    }

    @Override // com.applovin.impl.p1
    public ByteBuffer d() {
        ByteBuffer byteBuffer = this.f24743g;
        this.f24743g = p1.f21632a;
        return byteBuffer;
    }

    @Override // com.applovin.impl.p1
    public final void e() {
        this.f24744h = true;
        h();
    }

    @Override // com.applovin.impl.p1
    public boolean f() {
        return this.f24741e != p1.a.f21633e;
    }

    public void g() {
    }

    public void h() {
    }

    public void i() {
    }

    @Override // com.applovin.impl.p1
    public final void reset() {
        b();
        this.f24742f = p1.f21632a;
        p1.a aVar = p1.a.f21633e;
        this.f24740d = aVar;
        this.f24741e = aVar;
        this.f24738b = aVar;
        this.f24739c = aVar;
        i();
    }
}
