package com.applovin.impl;

import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class bp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f18024a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f18027d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f18028e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f18029f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ho f18025b = new ho(0);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f18030g = C.TIME_UNSET;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f18031h = C.TIME_UNSET;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f18032i = C.TIME_UNSET;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final bh f18026c = new bh();

    public bp(int i11) {
        this.f18024a = i11;
    }

    private int a(l8 l8Var) {
        this.f18026c.a(xp.f24377f);
        this.f18027d = true;
        l8Var.b();
        return 0;
    }

    private long a(bh bhVar, int i11) {
        int iE = bhVar.e();
        for (int iD = bhVar.d(); iD < iE; iD++) {
            if (bhVar.c()[iD] == 71) {
                long jA = ep.a(bhVar, iD, i11);
                if (jA != C.TIME_UNSET) {
                    return jA;
                }
            }
        }
        return C.TIME_UNSET;
    }

    private int b(l8 l8Var, th thVar, int i11) {
        int iMin = (int) Math.min(this.f18024a, l8Var.a());
        long j11 = 0;
        if (l8Var.f() != j11) {
            thVar.f23379a = j11;
            return 1;
        }
        this.f18026c.d(iMin);
        l8Var.b();
        l8Var.c(this.f18026c.c(), 0, iMin);
        this.f18030g = a(this.f18026c, i11);
        this.f18028e = true;
        return 0;
    }

    private long b(bh bhVar, int i11) {
        int iD = bhVar.d();
        int iE = bhVar.e();
        for (int i12 = iE - 188; i12 >= iD; i12--) {
            if (ep.a(bhVar.c(), iD, iE, i12)) {
                long jA = ep.a(bhVar, i12, i11);
                if (jA != C.TIME_UNSET) {
                    return jA;
                }
            }
        }
        return C.TIME_UNSET;
    }

    private int c(l8 l8Var, th thVar, int i11) {
        long jA = l8Var.a();
        int iMin = (int) Math.min(this.f18024a, jA);
        long j11 = jA - ((long) iMin);
        if (l8Var.f() != j11) {
            thVar.f23379a = j11;
            return 1;
        }
        this.f18026c.d(iMin);
        l8Var.b();
        l8Var.c(this.f18026c.c(), 0, iMin);
        this.f18031h = b(this.f18026c, i11);
        this.f18029f = true;
        return 0;
    }

    public int a(l8 l8Var, th thVar, int i11) {
        if (i11 <= 0) {
            return a(l8Var);
        }
        if (!this.f18029f) {
            return c(l8Var, thVar, i11);
        }
        if (this.f18031h == C.TIME_UNSET) {
            return a(l8Var);
        }
        if (!this.f18028e) {
            return b(l8Var, thVar, i11);
        }
        long j11 = this.f18030g;
        if (j11 == C.TIME_UNSET) {
            return a(l8Var);
        }
        long jB = this.f18025b.b(this.f18031h) - this.f18025b.b(j11);
        this.f18032i = jB;
        if (jB < 0) {
            pc.d("TsDurationReader", "Invalid duration: " + this.f18032i + ". Using TIME_UNSET instead.");
            this.f18032i = C.TIME_UNSET;
        }
        return a(l8Var);
    }

    public long a() {
        return this.f18032i;
    }

    public ho b() {
        return this.f18025b;
    }

    public boolean c() {
        return this.f18027d;
    }
}
