package com.applovin.impl;

import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class eh implements gj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private f9 f18724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ho f18725b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private qo f18726c;

    public eh(String str) {
        this.f18724a = new f9.b().f(str).a();
    }

    private void a() {
        b1.b(this.f18725b);
        xp.a(this.f18726c);
    }

    @Override // com.applovin.impl.gj
    public void a(bh bhVar) {
        a();
        long jB = this.f18725b.b();
        long jC = this.f18725b.c();
        if (jB == C.TIME_UNSET || jC == C.TIME_UNSET) {
            return;
        }
        f9 f9Var = this.f18724a;
        if (jC != f9Var.f18904q) {
            f9 f9VarA = f9Var.a().a(jC).a();
            this.f18724a = f9VarA;
            this.f18726c.a(f9VarA);
        }
        int iA = bhVar.a();
        this.f18726c.a(bhVar, iA);
        this.f18726c.a(jB, 1, iA, 0, null);
    }

    @Override // com.applovin.impl.gj
    public void a(ho hoVar, m8 m8Var, dp.d dVar) {
        this.f18725b = hoVar;
        dVar.a();
        qo qoVarA = m8Var.a(dVar.c(), 5);
        this.f18726c = qoVarA;
        qoVarA.a(this.f18724a);
    }
}
