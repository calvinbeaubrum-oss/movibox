package com.applovin.impl;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Collections;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class bc implements q7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f17892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final bh f17893b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ah f17894c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private qo f17895d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f17896e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private f9 f17897f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f17898g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f17899h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f17900i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f17901j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f17902k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f17903l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f17904m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f17905n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f17906o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f17907p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f17908q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f17909r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private long f17910s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f17911t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private String f17912u;

    public bc(String str) {
        this.f17892a = str;
        bh bhVar = new bh(1024);
        this.f17893b = bhVar;
        this.f17894c = new ah(bhVar.c());
        this.f17902k = C.TIME_UNSET;
    }

    private static long a(ah ahVar) {
        return ahVar.a((ahVar.a(2) + 1) * 8);
    }

    private void a(int i11) {
        this.f17893b.d(i11);
        this.f17894c.a(this.f17893b.c());
    }

    private void a(ah ahVar, int i11) {
        int iE = ahVar.e();
        if ((iE & 7) == 0) {
            this.f17893b.f(iE >> 3);
        } else {
            ahVar.a(this.f17893b.c(), 0, i11 * 8);
            this.f17893b.f(0);
        }
        this.f17895d.a(this.f17893b, i11);
        long j11 = this.f17902k;
        if (j11 != C.TIME_UNSET) {
            this.f17895d.a(j11, 1, i11, 0, null);
            this.f17902k += this.f17910s;
        }
    }

    private void b(ah ahVar) throws dh {
        if (!ahVar.f()) {
            this.f17903l = true;
            f(ahVar);
        } else if (!this.f17903l) {
            return;
        }
        if (this.f17904m != 0) {
            throw dh.a(null, null);
        }
        if (this.f17905n != 0) {
            throw dh.a(null, null);
        }
        a(ahVar, e(ahVar));
        if (this.f17907p) {
            ahVar.d((int) this.f17908q);
        }
    }

    private int c(ah ahVar) throws dh {
        int iB = ahVar.b();
        a.b bVarA = a.a(ahVar, true);
        this.f17912u = bVarA.f17406c;
        this.f17909r = bVarA.f17404a;
        this.f17911t = bVarA.f17405b;
        return iB - ahVar.b();
    }

    private void d(ah ahVar) {
        int iA = ahVar.a(3);
        this.f17906o = iA;
        if (iA == 0) {
            ahVar.d(8);
            return;
        }
        if (iA == 1) {
            ahVar.d(9);
            return;
        }
        if (iA == 3 || iA == 4 || iA == 5) {
            ahVar.d(6);
        } else {
            if (iA != 6 && iA != 7) {
                throw new IllegalStateException();
            }
            ahVar.d(1);
        }
    }

    private int e(ah ahVar) throws dh {
        int iA;
        if (this.f17906o != 0) {
            throw dh.a(null, null);
        }
        int i11 = 0;
        do {
            iA = ahVar.a(8);
            i11 += iA;
        } while (iA == 255);
        return i11;
    }

    private void f(ah ahVar) throws dh {
        boolean zF;
        int iA = ahVar.a(1);
        int iA2 = iA == 1 ? ahVar.a(1) : 0;
        this.f17904m = iA2;
        if (iA2 != 0) {
            throw dh.a(null, null);
        }
        if (iA == 1) {
            a(ahVar);
        }
        if (!ahVar.f()) {
            throw dh.a(null, null);
        }
        this.f17905n = ahVar.a(6);
        int iA3 = ahVar.a(4);
        int iA4 = ahVar.a(3);
        if (iA3 != 0 || iA4 != 0) {
            throw dh.a(null, null);
        }
        if (iA == 0) {
            int iE = ahVar.e();
            int iC = c(ahVar);
            ahVar.c(iE);
            byte[] bArr = new byte[(iC + 7) / 8];
            ahVar.a(bArr, 0, iC);
            f9 f9VarA = new f9.b().c(this.f17896e).f(MimeTypes.AUDIO_AAC).a(this.f17912u).c(this.f17911t).n(this.f17909r).a(Collections.singletonList(bArr)).e(this.f17892a).a();
            if (!f9VarA.equals(this.f17897f)) {
                this.f17897f = f9VarA;
                this.f17910s = 1024000000 / ((long) f9VarA.A);
                this.f17895d.a(f9VarA);
            }
        } else {
            ahVar.d(((int) a(ahVar)) - c(ahVar));
        }
        d(ahVar);
        boolean zF2 = ahVar.f();
        this.f17907p = zF2;
        this.f17908q = 0L;
        if (zF2) {
            if (iA == 1) {
                this.f17908q = a(ahVar);
            } else {
                do {
                    zF = ahVar.f();
                    this.f17908q = (this.f17908q << 8) + ((long) ahVar.a(8));
                } while (zF);
            }
        }
        if (ahVar.f()) {
            ahVar.d(8);
        }
    }

    @Override // com.applovin.impl.q7
    public void a() {
        this.f17898g = 0;
        this.f17902k = C.TIME_UNSET;
        this.f17903l = false;
    }

    @Override // com.applovin.impl.q7
    public void a(long j11, int i11) {
        if (j11 != C.TIME_UNSET) {
            this.f17902k = j11;
        }
    }

    @Override // com.applovin.impl.q7
    public void a(bh bhVar) throws dh {
        b1.b(this.f17895d);
        while (bhVar.a() > 0) {
            int i11 = this.f17898g;
            if (i11 != 0) {
                if (i11 == 1) {
                    int iW = bhVar.w();
                    if ((iW & 224) == 224) {
                        this.f17901j = iW;
                        this.f17898g = 2;
                    } else if (iW != 86) {
                        this.f17898g = 0;
                    }
                } else if (i11 == 2) {
                    int iW2 = ((this.f17901j & (-225)) << 8) | bhVar.w();
                    this.f17900i = iW2;
                    if (iW2 > this.f17893b.c().length) {
                        a(this.f17900i);
                    }
                    this.f17899h = 0;
                    this.f17898g = 3;
                } else {
                    if (i11 != 3) {
                        throw new IllegalStateException();
                    }
                    int iMin = Math.min(bhVar.a(), this.f17900i - this.f17899h);
                    bhVar.a(this.f17894c.f17657a, this.f17899h, iMin);
                    int i12 = this.f17899h + iMin;
                    this.f17899h = i12;
                    if (i12 == this.f17900i) {
                        this.f17894c.c(0);
                        b(this.f17894c);
                        this.f17898g = 0;
                    }
                }
            } else if (bhVar.w() == 86) {
                this.f17898g = 1;
            }
        }
    }

    @Override // com.applovin.impl.q7
    public void a(m8 m8Var, dp.d dVar) {
        dVar.a();
        this.f17895d = m8Var.a(dVar.c(), 1);
        this.f17896e = dVar.b();
    }

    @Override // com.applovin.impl.q7
    public void b() {
    }
}
