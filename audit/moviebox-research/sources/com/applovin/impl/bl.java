package com.applovin.impl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class bl implements gd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l3 f17987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f17988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f17989c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f17990d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ph f17991f = ph.f21775d;

    public bl(l3 l3Var) {
        this.f17987a = l3Var;
    }

    @Override // com.applovin.impl.gd
    public ph a() {
        return this.f17991f;
    }

    public void a(long j11) {
        this.f17989c = j11;
        if (this.f17988b) {
            this.f17990d = this.f17987a.c();
        }
    }

    @Override // com.applovin.impl.gd
    public void a(ph phVar) {
        if (this.f17988b) {
            a(p());
        }
        this.f17991f = phVar;
    }

    public void b() {
        if (this.f17988b) {
            return;
        }
        this.f17990d = this.f17987a.c();
        this.f17988b = true;
    }

    public void c() {
        if (this.f17988b) {
            a(p());
            this.f17988b = false;
        }
    }

    @Override // com.applovin.impl.gd
    public long p() {
        long j11 = this.f17989c;
        if (!this.f17988b) {
            return j11;
        }
        long jC = this.f17987a.c() - this.f17990d;
        ph phVar = this.f17991f;
        return j11 + (phVar.f21777a == 1.0f ? t2.a(jC) : phVar.a(jC));
    }
}
