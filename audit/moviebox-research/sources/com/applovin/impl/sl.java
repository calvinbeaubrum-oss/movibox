package com.applovin.impl;

import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class sl extends zg implements nl {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private nl f23118d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f23119f;

    @Override // com.applovin.impl.nl
    public int a() {
        return ((nl) b1.a(this.f23118d)).a();
    }

    @Override // com.applovin.impl.nl
    public int a(long j11) {
        return ((nl) b1.a(this.f23118d)).a(j11 - this.f23119f);
    }

    @Override // com.applovin.impl.nl
    public long a(int i11) {
        return ((nl) b1.a(this.f23118d)).a(i11) + this.f23119f;
    }

    public void a(long j11, nl nlVar, long j12) {
        this.f24865b = j11;
        this.f23118d = nlVar;
        if (j12 != Long.MAX_VALUE) {
            j11 = j12;
        }
        this.f23119f = j11;
    }

    @Override // com.applovin.impl.nl
    public List b(long j11) {
        return ((nl) b1.a(this.f23118d)).b(j11 - this.f23119f);
    }

    @Override // com.applovin.impl.l2
    public void b() {
        super.b();
        this.f23118d = null;
    }
}
