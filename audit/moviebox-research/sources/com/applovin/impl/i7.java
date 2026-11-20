package com.applovin.impl;

import java.io.EOFException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class i7 implements qo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f19638a = new byte[4096];

    @Override // com.applovin.impl.qo
    public /* synthetic */ int a(g5 g5Var, int i11, boolean z11) {
        return g20.a(this, g5Var, i11, z11);
    }

    @Override // com.applovin.impl.qo
    public int a(g5 g5Var, int i11, boolean z11, int i12) throws EOFException {
        int iA = g5Var.a(this.f19638a, 0, Math.min(this.f19638a.length, i11));
        if (iA != -1) {
            return iA;
        }
        if (z11) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // com.applovin.impl.qo
    public void a(long j11, int i11, int i12, int i13, qo.a aVar) {
    }

    @Override // com.applovin.impl.qo
    public /* synthetic */ void a(bh bhVar, int i11) {
        g20.b(this, bhVar, i11);
    }

    @Override // com.applovin.impl.qo
    public void a(bh bhVar, int i11, int i12) {
        bhVar.g(i11);
    }

    @Override // com.applovin.impl.qo
    public void a(f9 f9Var) {
    }
}
