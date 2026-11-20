package com.applovin.impl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class jg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f19948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f19949b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f19950c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f19951d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f19952e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f19953f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f19954g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f19955h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f19956i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int[] f19957j = new int[255];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final bh f19958k = new bh(255);

    public void a() {
        this.f19948a = 0;
        this.f19949b = 0;
        this.f19950c = 0L;
        this.f19951d = 0L;
        this.f19952e = 0L;
        this.f19953f = 0L;
        this.f19954g = 0;
        this.f19955h = 0;
        this.f19956i = 0;
    }

    public boolean a(l8 l8Var) {
        return a(l8Var, -1L);
    }

    public boolean a(l8 l8Var, long j11) {
        b1.a(l8Var.f() == l8Var.d());
        this.f19958k.d(4);
        while (true) {
            if ((j11 != -1 && l8Var.f() + 4 >= j11) || !n8.a(l8Var, this.f19958k.c(), 0, 4, true)) {
                break;
            }
            this.f19958k.f(0);
            if (this.f19958k.y() == 1332176723) {
                l8Var.b();
                return true;
            }
            l8Var.a(1);
        }
        do {
            if (j11 != -1 && l8Var.f() >= j11) {
                break;
            }
        } while (l8Var.b(1) != -1);
        return false;
    }

    public boolean a(l8 l8Var, boolean z11) throws dh {
        a();
        this.f19958k.d(27);
        if (!n8.a(l8Var, this.f19958k.c(), 0, 27, z11) || this.f19958k.y() != 1332176723) {
            return false;
        }
        int iW = this.f19958k.w();
        this.f19948a = iW;
        if (iW != 0) {
            if (z11) {
                return false;
            }
            throw dh.a("unsupported bit stream revision");
        }
        this.f19949b = this.f19958k.w();
        this.f19950c = this.f19958k.n();
        this.f19951d = this.f19958k.p();
        this.f19952e = this.f19958k.p();
        this.f19953f = this.f19958k.p();
        int iW2 = this.f19958k.w();
        this.f19954g = iW2;
        this.f19955h = iW2 + 27;
        this.f19958k.d(iW2);
        if (!n8.a(l8Var, this.f19958k.c(), 0, this.f19954g, z11)) {
            return false;
        }
        for (int i11 = 0; i11 < this.f19954g; i11++) {
            this.f19957j[i11] = this.f19958k.w();
            this.f19956i += this.f19957j[i11];
        }
        return true;
    }
}
