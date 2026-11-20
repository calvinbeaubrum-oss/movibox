package com.applovin.impl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class dl extends h9 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f18462b;

    public dl(l8 l8Var, long j11) {
        super(l8Var);
        b1.a(l8Var.f() >= j11);
        this.f18462b = j11;
    }

    @Override // com.applovin.impl.h9, com.applovin.impl.l8
    public long a() {
        return super.a() - this.f18462b;
    }

    @Override // com.applovin.impl.h9, com.applovin.impl.l8
    public long d() {
        return super.d() - this.f18462b;
    }

    @Override // com.applovin.impl.h9, com.applovin.impl.l8
    public long f() {
        return super.f() - this.f18462b;
    }
}
