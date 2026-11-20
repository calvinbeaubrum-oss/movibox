package com.applovin.impl;

import com.applovin.exoplayer2.common.base.Ascii;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class j implements q7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ah f19782a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final bh f19783b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f19784c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f19785d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private qo f19786e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f19787f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f19788g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f19789h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f19790i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private f9 f19791j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f19792k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f19793l;

    public j() {
        this(null);
    }

    public j(String str) {
        ah ahVar = new ah(new byte[128]);
        this.f19782a = ahVar;
        this.f19783b = new bh(ahVar.f17657a);
        this.f19787f = 0;
        this.f19793l = C.TIME_UNSET;
        this.f19784c = str;
    }

    private boolean a(bh bhVar, byte[] bArr, int i11) {
        int iMin = Math.min(bhVar.a(), i11 - this.f19788g);
        bhVar.a(bArr, this.f19788g, iMin);
        int i12 = this.f19788g + iMin;
        this.f19788g = i12;
        return i12 == i11;
    }

    private boolean b(bh bhVar) {
        while (true) {
            if (bhVar.a() <= 0) {
                return false;
            }
            if (this.f19789h) {
                int iW = bhVar.w();
                if (iW == 119) {
                    this.f19789h = false;
                    return true;
                }
                this.f19789h = iW == 11;
            } else {
                this.f19789h = bhVar.w() == 11;
            }
        }
    }

    private void c() {
        this.f19782a.c(0);
        k.b bVarA = k.a(this.f19782a);
        f9 f9Var = this.f19791j;
        if (f9Var == null || bVarA.f20046d != f9Var.f18913z || bVarA.f20045c != f9Var.A || !xp.a((Object) bVarA.f20043a, (Object) f9Var.f18900m)) {
            f9 f9VarA = new f9.b().c(this.f19785d).f(bVarA.f20043a).c(bVarA.f20046d).n(bVarA.f20045c).e(this.f19784c).a();
            this.f19791j = f9VarA;
            this.f19786e.a(f9VarA);
        }
        this.f19792k = bVarA.f20047e;
        this.f19790i = (((long) bVarA.f20048f) * 1000000) / ((long) this.f19791j.A);
    }

    @Override // com.applovin.impl.q7
    public void a() {
        this.f19787f = 0;
        this.f19788g = 0;
        this.f19789h = false;
        this.f19793l = C.TIME_UNSET;
    }

    @Override // com.applovin.impl.q7
    public void a(long j11, int i11) {
        if (j11 != C.TIME_UNSET) {
            this.f19793l = j11;
        }
    }

    @Override // com.applovin.impl.q7
    public void a(bh bhVar) {
        b1.b(this.f19786e);
        while (bhVar.a() > 0) {
            int i11 = this.f19787f;
            if (i11 != 0) {
                if (i11 != 1) {
                    if (i11 == 2) {
                        int iMin = Math.min(bhVar.a(), this.f19792k - this.f19788g);
                        this.f19786e.a(bhVar, iMin);
                        int i12 = this.f19788g + iMin;
                        this.f19788g = i12;
                        int i13 = this.f19792k;
                        if (i12 == i13) {
                            long j11 = this.f19793l;
                            if (j11 != C.TIME_UNSET) {
                                this.f19786e.a(j11, 1, i13, 0, null);
                                this.f19793l += this.f19790i;
                            }
                            this.f19787f = 0;
                        }
                    }
                } else if (a(bhVar, this.f19783b.c(), 128)) {
                    c();
                    this.f19783b.f(0);
                    this.f19786e.a(this.f19783b, 128);
                    this.f19787f = 2;
                }
            } else if (b(bhVar)) {
                this.f19787f = 1;
                this.f19783b.c()[0] = Ascii.VT;
                this.f19783b.c()[1] = 119;
                this.f19788g = 2;
            }
        }
    }

    @Override // com.applovin.impl.q7
    public void a(m8 m8Var, dp.d dVar) {
        dVar.a();
        this.f19785d = dVar.b();
        this.f19786e = m8Var.a(dVar.c(), 1);
    }

    @Override // com.applovin.impl.q7
    public void b() {
    }
}
