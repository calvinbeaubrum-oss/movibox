package com.applovin.impl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class h6 implements gd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final bl f19376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f19377b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private qi f19378c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private gd f19379d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f19380f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f19381g;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(ph phVar);
    }

    public h6(a aVar, l3 l3Var) {
        this.f19377b = aVar;
        this.f19376a = new bl(l3Var);
    }

    private boolean a(boolean z11) {
        qi qiVar = this.f19378c;
        return qiVar == null || qiVar.c() || (!this.f19378c.d() && (z11 || this.f19378c.j()));
    }

    private void c(boolean z11) {
        if (a(z11)) {
            this.f19380f = true;
            if (this.f19381g) {
                this.f19376a.b();
                return;
            }
            return;
        }
        gd gdVar = (gd) b1.a(this.f19379d);
        long jP = gdVar.p();
        if (this.f19380f) {
            if (jP < this.f19376a.p()) {
                this.f19376a.c();
                return;
            } else {
                this.f19380f = false;
                if (this.f19381g) {
                    this.f19376a.b();
                }
            }
        }
        this.f19376a.a(jP);
        ph phVarA = gdVar.a();
        if (phVarA.equals(this.f19376a.a())) {
            return;
        }
        this.f19376a.a(phVarA);
        this.f19377b.a(phVarA);
    }

    @Override // com.applovin.impl.gd
    public ph a() {
        gd gdVar = this.f19379d;
        return gdVar != null ? gdVar.a() : this.f19376a.a();
    }

    public void a(long j11) {
        this.f19376a.a(j11);
    }

    @Override // com.applovin.impl.gd
    public void a(ph phVar) {
        gd gdVar = this.f19379d;
        if (gdVar != null) {
            gdVar.a(phVar);
            phVar = this.f19379d.a();
        }
        this.f19376a.a(phVar);
    }

    public void a(qi qiVar) {
        if (qiVar == this.f19378c) {
            this.f19379d = null;
            this.f19378c = null;
            this.f19380f = true;
        }
    }

    public long b(boolean z11) {
        c(z11);
        return p();
    }

    public void b() {
        this.f19381g = true;
        this.f19376a.b();
    }

    public void b(qi qiVar) throws a8 {
        gd gdVar;
        gd gdVarL = qiVar.l();
        if (gdVarL == null || gdVarL == (gdVar = this.f19379d)) {
            return;
        }
        if (gdVar != null) {
            throw a8.a(new IllegalStateException("Multiple renderer media clocks enabled."));
        }
        this.f19379d = gdVarL;
        this.f19378c = qiVar;
        gdVarL.a(this.f19376a.a());
    }

    public void c() {
        this.f19381g = false;
        this.f19376a.c();
    }

    @Override // com.applovin.impl.gd
    public long p() {
        return this.f19380f ? this.f19376a.p() : ((gd) b1.a(this.f19379d)).p();
    }
}
