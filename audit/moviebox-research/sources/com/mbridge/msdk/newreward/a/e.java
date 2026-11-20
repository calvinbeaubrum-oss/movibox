package com.mbridge.msdk.newreward.a;

import com.mbridge.msdk.newout.RewardVideoListener;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class e {
    private RewardVideoListener I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f46091a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f46092b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f46093c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f46094d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f46095e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f46096f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f46097g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f46098h;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f46101k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f46103m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f46104n;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f46109s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private String f46110t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f46111u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private String f46112v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private String f46113w;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f46115y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private long f46116z;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f46099i = 2;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f46100j = 60000;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f46102l = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f46105o = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f46106p = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f46107q = 0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f46108r = false;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private String f46114x = "";
    private boolean A = false;
    private boolean B = false;
    private boolean C = false;
    private com.mbridge.msdk.newreward.function.f.a D = new com.mbridge.msdk.newreward.function.f.a();
    private com.mbridge.msdk.newreward.function.f.d E = new com.mbridge.msdk.newreward.function.f.d();
    private com.mbridge.msdk.newreward.function.f.e F = new com.mbridge.msdk.newreward.function.f.e();
    private com.mbridge.msdk.newreward.function.f.c G = new com.mbridge.msdk.newreward.function.f.c();
    private int H = 25000;

    public e(boolean z11, int i11, String str, String str2, boolean z12) {
        this.f46094d = z11;
        this.f46111u = i11;
        this.f46109s = str;
        this.f46110t = str2;
        this.f46101k = z12;
    }

    public final String A() {
        return this.f46109s;
    }

    public final RewardVideoListener B() {
        return this.I;
    }

    public final int C() {
        return this.f46096f;
    }

    public final int D() {
        return this.f46094d ? 2 : 3;
    }

    public final int E() {
        return this.f46095e;
    }

    public final int F() {
        return this.f46099i;
    }

    public final int G() {
        int i11 = this.H;
        if (i11 <= 0) {
            return 25000;
        }
        return i11;
    }

    public final int H() {
        return this.f46100j;
    }

    public final boolean I() {
        return this.f46101k;
    }

    public final long J() {
        com.mbridge.msdk.newreward.function.f.a aVar = this.D;
        if (aVar != null && aVar.b() != null && this.D.b().n() > 0) {
            return this.D.b().n();
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        com.mbridge.msdk.videocommon.d.a aVarA = this.F.a();
        return (aVarA == null ? 3600000L : aVarA.f()) + jCurrentTimeMillis;
    }

    public final void a() {
        this.f46106p++;
    }

    public final void a(int i11) {
        this.f46095e = i11;
    }

    public final void a(int i11, int i12, int i13) {
        this.f46096f = i11;
        this.f46097g = i12;
        this.f46098h = i13;
    }

    public final void a(long j11) {
        this.f46104n = j11;
    }

    public final void a(RewardVideoListener rewardVideoListener) {
        this.I = rewardVideoListener;
    }

    public final void a(com.mbridge.msdk.newreward.function.f.a aVar) {
        this.D = aVar;
    }

    public final void a(com.mbridge.msdk.newreward.function.f.e eVar) {
        this.F = eVar;
    }

    public final void a(String str) {
        this.f46114x = str;
    }

    public final void a(boolean z11) {
        this.f46105o = z11;
    }

    public final void b() {
        this.f46107q++;
    }

    public final void b(int i11) {
        this.f46115y = i11;
    }

    public final void b(long j11) {
        this.f46103m = j11;
    }

    public final void b(String str) {
        this.f46112v = str;
    }

    public final void b(boolean z11) {
        this.f46102l = z11;
    }

    public final void c(int i11) {
        this.f46092b = i11;
    }

    public final void c(long j11) {
        this.f46116z = j11;
    }

    public final void c(String str) {
        this.f46113w = str;
    }

    public final void c(boolean z11) {
        this.f46108r = z11;
    }

    public final boolean c() {
        return this.f46105o;
    }

    public final long d() {
        return this.f46104n;
    }

    public final void d(int i11) {
        this.f46099i = i11;
    }

    public final void d(String str) {
        this.f46093c = str;
    }

    public final void d(boolean z11) {
        this.C = z11;
    }

    public final long e() {
        return this.f46103m;
    }

    public final void e(int i11) {
        this.H = i11;
    }

    public final void e(boolean z11) {
        this.B = z11;
    }

    public final void f(int i11) {
        this.f46100j = i11;
    }

    public final void f(boolean z11) {
        this.A = z11;
    }

    public final boolean f() {
        return this.f46102l;
    }

    public final boolean g() {
        return this.f46108r;
    }

    public final int h() {
        return this.f46097g;
    }

    public final int i() {
        return this.f46098h;
    }

    public final boolean j() {
        return this.C;
    }

    public final boolean k() {
        return this.B;
    }

    public final boolean l() {
        return this.A;
    }

    public final long m() {
        return this.f46116z;
    }

    public final int n() {
        return this.f46111u;
    }

    public final String o() {
        return this.f46114x;
    }

    public final com.mbridge.msdk.newreward.function.f.e p() {
        return this.F;
    }

    public final int q() {
        return this.f46115y;
    }

    public final com.mbridge.msdk.newreward.function.f.c r() {
        return this.G;
    }

    public final int s() {
        return this.f46092b;
    }

    public final String t() {
        return this.f46112v;
    }

    public final String u() {
        return this.f46113w;
    }

    public final com.mbridge.msdk.newreward.function.f.a v() {
        return this.D;
    }

    public final com.mbridge.msdk.newreward.function.f.d w() {
        return this.E;
    }

    public final String x() {
        return this.f46093c;
    }

    public final String y() {
        return this.f46110t;
    }

    public final boolean z() {
        return this.f46094d;
    }
}
