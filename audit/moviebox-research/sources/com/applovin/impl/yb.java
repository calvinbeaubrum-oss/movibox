package com.applovin.impl;

import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class yb implements k8 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private m8 f24577b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f24578c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f24579d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f24580e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private nf f24582g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private l8 f24583h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private dl f24584i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private pf f24585j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final bh f24576a = new bh(6);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f24581f = -1;

    private static nf a(String str, long j11) {
        mf mfVarA;
        if (j11 == -1 || (mfVarA = hs.a(str)) == null) {
            return null;
        }
        return mfVarA.a(j11);
    }

    private void a(bf.b... bVarArr) {
        ((m8) b1.a(this.f24577b)).a(1024, 4).a(new f9.b().b("image/jpeg").a(new bf(bVarArr)).a());
    }

    private void b() {
        a(new bf.b[0]);
        ((m8) b1.a(this.f24577b)).c();
        this.f24577b.a(new ij.b(C.TIME_UNSET));
        this.f24578c = 6;
    }

    private void b(l8 l8Var) {
        this.f24576a.d(2);
        l8Var.c(this.f24576a.c(), 0, 2);
        l8Var.c(this.f24576a.C() - 2);
    }

    private int c(l8 l8Var) {
        this.f24576a.d(2);
        l8Var.c(this.f24576a.c(), 0, 2);
        return this.f24576a.C();
    }

    private void c() {
        a((bf.b) b1.a(this.f24582g));
        this.f24578c = 5;
    }

    private void d(l8 l8Var) {
        this.f24576a.d(2);
        l8Var.d(this.f24576a.c(), 0, 2);
        int iC = this.f24576a.C();
        this.f24579d = iC;
        if (iC == 65498) {
            if (this.f24581f != -1) {
                this.f24578c = 4;
                return;
            } else {
                b();
                return;
            }
        }
        if ((iC < 65488 || iC > 65497) && iC != 65281) {
            this.f24578c = 1;
        }
    }

    private void e(l8 l8Var) {
        String strT;
        if (this.f24579d == 65505) {
            bh bhVar = new bh(this.f24580e);
            l8Var.d(bhVar.c(), 0, this.f24580e);
            if (this.f24582g == null && "http://ns.adobe.com/xap/1.0/".equals(bhVar.t()) && (strT = bhVar.t()) != null) {
                nf nfVarA = a(strT, l8Var.a());
                this.f24582g = nfVarA;
                if (nfVarA != null) {
                    this.f24581f = nfVarA.f21330d;
                }
            }
        } else {
            l8Var.a(this.f24580e);
        }
        this.f24578c = 0;
    }

    private void f(l8 l8Var) {
        this.f24576a.d(2);
        l8Var.d(this.f24576a.c(), 0, 2);
        this.f24580e = this.f24576a.C() - 2;
        this.f24578c = 2;
    }

    private void g(l8 l8Var) {
        if (!l8Var.b(this.f24576a.c(), 0, 1, true)) {
            b();
            return;
        }
        l8Var.b();
        if (this.f24585j == null) {
            this.f24585j = new pf();
        }
        dl dlVar = new dl(l8Var, this.f24581f);
        this.f24584i = dlVar;
        if (!this.f24585j.a(dlVar)) {
            b();
        } else {
            this.f24585j.a(new el(this.f24581f, (m8) b1.a(this.f24577b)));
            c();
        }
    }

    @Override // com.applovin.impl.k8
    public int a(l8 l8Var, th thVar) {
        int i11 = this.f24578c;
        if (i11 == 0) {
            d(l8Var);
            return 0;
        }
        if (i11 == 1) {
            f(l8Var);
            return 0;
        }
        if (i11 == 2) {
            e(l8Var);
            return 0;
        }
        if (i11 == 4) {
            long jF = l8Var.f();
            long j11 = this.f24581f;
            if (jF != j11) {
                thVar.f23379a = j11;
                return 1;
            }
            g(l8Var);
            return 0;
        }
        if (i11 != 5) {
            if (i11 == 6) {
                return -1;
            }
            throw new IllegalStateException();
        }
        if (this.f24584i == null || l8Var != this.f24583h) {
            this.f24583h = l8Var;
            this.f24584i = new dl(l8Var, this.f24581f);
        }
        int iA = ((pf) b1.a(this.f24585j)).a(this.f24584i, thVar);
        if (iA == 1) {
            thVar.f23379a += this.f24581f;
        }
        return iA;
    }

    @Override // com.applovin.impl.k8
    public void a() {
        pf pfVar = this.f24585j;
        if (pfVar != null) {
            pfVar.a();
        }
    }

    @Override // com.applovin.impl.k8
    public void a(long j11, long j12) {
        if (j11 == 0) {
            this.f24578c = 0;
            this.f24585j = null;
        } else if (this.f24578c == 5) {
            ((pf) b1.a(this.f24585j)).a(j11, j12);
        }
    }

    @Override // com.applovin.impl.k8
    public void a(m8 m8Var) {
        this.f24577b = m8Var;
    }

    @Override // com.applovin.impl.k8
    public boolean a(l8 l8Var) {
        if (c(l8Var) != 65496) {
            return false;
        }
        int iC = c(l8Var);
        this.f24579d = iC;
        if (iC == 65504) {
            b(l8Var);
            this.f24579d = c(l8Var);
        }
        if (this.f24579d != 65505) {
            return false;
        }
        l8Var.c(2);
        this.f24576a.d(6);
        l8Var.c(this.f24576a.c(), 0, 6);
        return this.f24576a.y() == 1165519206 && this.f24576a.C() == 0;
    }
}
