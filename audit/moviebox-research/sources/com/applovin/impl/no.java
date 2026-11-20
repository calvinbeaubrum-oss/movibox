package com.applovin.impl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class no {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l6 f21383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f21384b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f21385c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f21386d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f21387e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f21388f;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f21395m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public mo f21397o;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f21399q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f21400r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f21401s;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long[] f21389g = new long[0];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int[] f21390h = new int[0];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int[] f21391i = new int[0];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int[] f21392j = new int[0];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long[] f21393k = new long[0];

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean[] f21394l = new boolean[0];

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean[] f21396n = new boolean[0];

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final bh f21398p = new bh();

    public long a(int i11) {
        return this.f21393k[i11] + ((long) this.f21392j[i11]);
    }

    public void a() {
        this.f21387e = 0;
        this.f21400r = 0L;
        this.f21401s = false;
        this.f21395m = false;
        this.f21399q = false;
        this.f21397o = null;
    }

    public void a(int i11, int i12) {
        this.f21387e = i11;
        this.f21388f = i12;
        if (this.f21390h.length < i11) {
            this.f21389g = new long[i11];
            this.f21390h = new int[i11];
        }
        if (this.f21391i.length < i12) {
            int i13 = (i12 * 125) / 100;
            this.f21391i = new int[i13];
            this.f21392j = new int[i13];
            this.f21393k = new long[i13];
            this.f21394l = new boolean[i13];
            this.f21396n = new boolean[i13];
        }
    }

    public void a(bh bhVar) {
        bhVar.a(this.f21398p.c(), 0, this.f21398p.e());
        this.f21398p.f(0);
        this.f21399q = false;
    }

    public void a(l8 l8Var) {
        l8Var.d(this.f21398p.c(), 0, this.f21398p.e());
        this.f21398p.f(0);
        this.f21399q = false;
    }

    public void b(int i11) {
        this.f21398p.d(i11);
        this.f21395m = true;
        this.f21399q = true;
    }

    public boolean c(int i11) {
        return this.f21395m && this.f21396n[i11];
    }
}
