package com.applovin.impl;

import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class m implements q7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ah f20544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final bh f20545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f20546c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f20547d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private qo f20548e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f20549f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f20550g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f20551h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f20552i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f20553j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private f9 f20554k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f20555l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f20556m;

    public m() {
        this(null);
    }

    public m(String str) {
        ah ahVar = new ah(new byte[16]);
        this.f20544a = ahVar;
        this.f20545b = new bh(ahVar.f17657a);
        this.f20549f = 0;
        this.f20550g = 0;
        this.f20551h = false;
        this.f20552i = false;
        this.f20556m = C.TIME_UNSET;
        this.f20546c = str;
    }

    private boolean a(bh bhVar, byte[] bArr, int i11) {
        int iMin = Math.min(bhVar.a(), i11 - this.f20550g);
        bhVar.a(bArr, this.f20550g, iMin);
        int i12 = this.f20550g + iMin;
        this.f20550g = i12;
        return i12 == i11;
    }

    private boolean b(bh bhVar) {
        while (true) {
            if (bhVar.a() <= 0) {
                return false;
            }
            if (this.f20551h) {
                int iW = bhVar.w();
                this.f20551h = iW == 172;
                if (iW == 64 || iW == 65) {
                    this.f20552i = iW == 65;
                    return true;
                }
            } else {
                this.f20551h = bhVar.w() == 172;
            }
        }
    }

    private void c() {
        this.f20544a.c(0);
        n.b bVarA = n.a(this.f20544a);
        f9 f9Var = this.f20554k;
        if (f9Var == null || bVarA.f21215c != f9Var.f18913z || bVarA.f21214b != f9Var.A || !"audio/ac4".equals(f9Var.f18900m)) {
            f9 f9VarA = new f9.b().c(this.f20547d).f("audio/ac4").c(bVarA.f21215c).n(bVarA.f21214b).e(this.f20546c).a();
            this.f20554k = f9VarA;
            this.f20548e.a(f9VarA);
        }
        this.f20555l = bVarA.f21216d;
        this.f20553j = (((long) bVarA.f21217e) * 1000000) / ((long) this.f20554k.A);
    }

    @Override // com.applovin.impl.q7
    public void a() {
        this.f20549f = 0;
        this.f20550g = 0;
        this.f20551h = false;
        this.f20552i = false;
        this.f20556m = C.TIME_UNSET;
    }

    @Override // com.applovin.impl.q7
    public void a(long j11, int i11) {
        if (j11 != C.TIME_UNSET) {
            this.f20556m = j11;
        }
    }

    @Override // com.applovin.impl.q7
    public void a(bh bhVar) {
        b1.b(this.f20548e);
        while (bhVar.a() > 0) {
            int i11 = this.f20549f;
            if (i11 != 0) {
                if (i11 != 1) {
                    if (i11 == 2) {
                        int iMin = Math.min(bhVar.a(), this.f20555l - this.f20550g);
                        this.f20548e.a(bhVar, iMin);
                        int i12 = this.f20550g + iMin;
                        this.f20550g = i12;
                        int i13 = this.f20555l;
                        if (i12 == i13) {
                            long j11 = this.f20556m;
                            if (j11 != C.TIME_UNSET) {
                                this.f20548e.a(j11, 1, i13, 0, null);
                                this.f20556m += this.f20553j;
                            }
                            this.f20549f = 0;
                        }
                    }
                } else if (a(bhVar, this.f20545b.c(), 16)) {
                    c();
                    this.f20545b.f(0);
                    this.f20548e.a(this.f20545b, 16);
                    this.f20549f = 2;
                }
            } else if (b(bhVar)) {
                this.f20549f = 1;
                this.f20545b.c()[0] = -84;
                this.f20545b.c()[1] = (byte) (this.f20552i ? 65 : 64);
                this.f20550g = 2;
            }
        }
    }

    @Override // com.applovin.impl.q7
    public void a(m8 m8Var, dp.d dVar) {
        dVar.a();
        this.f20547d = dVar.b();
        this.f20548e = m8Var.a(dVar.c(), 1);
    }

    @Override // com.applovin.impl.q7
    public void b() {
    }
}
