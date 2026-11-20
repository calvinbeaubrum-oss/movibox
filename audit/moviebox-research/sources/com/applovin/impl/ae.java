package com.applovin.impl;

import android.os.Handler;
import android.util.Pair;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class ae {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final fo.b f17637a = new fo.b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final fo.d f17638b = new fo.d();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final r0 f17639c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Handler f17640d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f17641e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f17642f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f17643g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private xd f17644h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private xd f17645i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private xd f17646j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f17647k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Object f17648l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f17649m;

    public ae(r0 r0Var, Handler handler) {
        this.f17639c = r0Var;
        this.f17640d = handler;
    }

    private long a(fo foVar, Object obj) {
        int iA;
        int i11 = foVar.a(obj, this.f17637a).f19033c;
        Object obj2 = this.f17648l;
        if (obj2 != null && (iA = foVar.a(obj2)) != -1 && foVar.a(iA, this.f17637a).f19033c == i11) {
            return this.f17649m;
        }
        for (xd xdVarD = this.f17644h; xdVarD != null; xdVarD = xdVarD.d()) {
            if (xdVarD.f24296b.equals(obj)) {
                return xdVarD.f24300f.f24835a.f24656d;
            }
        }
        for (xd xdVarD2 = this.f17644h; xdVarD2 != null; xdVarD2 = xdVarD2.d()) {
            int iA2 = foVar.a(xdVarD2.f24296b);
            if (iA2 != -1 && foVar.a(iA2, this.f17637a).f19033c == i11) {
                return xdVarD2.f24300f.f24835a.f24656d;
            }
        }
        long j11 = this.f17641e;
        this.f17641e = 1 + j11;
        if (this.f17644h == null) {
            this.f17648l = obj;
            this.f17649m = j11;
        }
        return j11;
    }

    private long a(fo foVar, Object obj, int i11) {
        foVar.a(obj, this.f17637a);
        long jB = this.f17637a.b(i11);
        return jB == Long.MIN_VALUE ? this.f17637a.f19034d : jB + this.f17637a.c(i11);
    }

    private static be.a a(fo foVar, Object obj, long j11, long j12, fo.b bVar) {
        foVar.a(obj, bVar);
        int iB = bVar.b(j11);
        return iB == -1 ? new be.a(obj, j12, bVar.a(j11)) : new be.a(obj, iB, bVar.d(iB), j12);
    }

    private zd a(fo foVar, be.a aVar, long j11, long j12) {
        foVar.a(aVar.f24653a, this.f17637a);
        return aVar.a() ? a(foVar, aVar.f24653a, aVar.f24654b, aVar.f24655c, j11, aVar.f24656d) : a(foVar, aVar.f24653a, j12, j11, aVar.f24656d);
    }

    private zd a(fo foVar, xd xdVar, long j11) {
        long j12;
        zd zdVar = xdVar.f24300f;
        long jF = (xdVar.f() + zdVar.f24839e) - j11;
        if (zdVar.f24841g) {
            long j13 = 0;
            int iA = foVar.a(foVar.a(zdVar.f24835a.f24653a), this.f17637a, this.f17638b, this.f17642f, this.f17643g);
            if (iA == -1) {
                return null;
            }
            int i11 = foVar.a(iA, this.f17637a, true).f19033c;
            Object obj = this.f17637a.f19032b;
            long j14 = zdVar.f24835a.f24656d;
            if (foVar.a(i11, this.f17638b).f19060p == iA) {
                Pair pairA = foVar.a(this.f17638b, this.f17637a, i11, C.TIME_UNSET, Math.max(0L, jF));
                if (pairA == null) {
                    return null;
                }
                obj = pairA.first;
                long jLongValue = ((Long) pairA.second).longValue();
                xd xdVarD = xdVar.d();
                if (xdVarD == null || !xdVarD.f24296b.equals(obj)) {
                    j14 = this.f17641e;
                    this.f17641e = 1 + j14;
                } else {
                    j14 = xdVarD.f24300f.f24835a.f24656d;
                }
                j12 = jLongValue;
                j13 = C.TIME_UNSET;
            } else {
                j12 = 0;
            }
            return a(foVar, a(foVar, obj, j12, j14, this.f17637a), j13, j12);
        }
        be.a aVar = zdVar.f24835a;
        foVar.a(aVar.f24653a, this.f17637a);
        if (!aVar.a()) {
            int iD = this.f17637a.d(aVar.f24657e);
            if (iD != this.f17637a.a(aVar.f24657e)) {
                return a(foVar, aVar.f24653a, aVar.f24657e, iD, zdVar.f24839e, aVar.f24656d);
            }
            return a(foVar, aVar.f24653a, a(foVar, aVar.f24653a, aVar.f24657e), zdVar.f24839e, aVar.f24656d);
        }
        int i12 = aVar.f24654b;
        int iA2 = this.f17637a.a(i12);
        if (iA2 == -1) {
            return null;
        }
        int iB = this.f17637a.b(i12, aVar.f24655c);
        if (iB < iA2) {
            return a(foVar, aVar.f24653a, i12, iB, zdVar.f24837c, aVar.f24656d);
        }
        long jLongValue2 = zdVar.f24837c;
        if (jLongValue2 == C.TIME_UNSET) {
            fo.d dVar = this.f17638b;
            fo.b bVar = this.f17637a;
            Pair pairA2 = foVar.a(dVar, bVar, bVar.f19033c, C.TIME_UNSET, Math.max(0L, jF));
            if (pairA2 == null) {
                return null;
            }
            jLongValue2 = ((Long) pairA2.second).longValue();
        }
        return a(foVar, aVar.f24653a, Math.max(a(foVar, aVar.f24653a, aVar.f24654b), jLongValue2), zdVar.f24837c, aVar.f24656d);
    }

    private zd a(fo foVar, Object obj, int i11, int i12, long j11, long j12) {
        be.a aVar = new be.a(obj, i11, i12, j12);
        long jA = foVar.a(aVar.f24653a, this.f17637a).a(aVar.f24654b, aVar.f24655c);
        long jB = i12 == this.f17637a.d(i11) ? this.f17637a.b() : 0L;
        return new zd(aVar, (jA == C.TIME_UNSET || jB < jA) ? jB : Math.max(0L, jA - 1), j11, C.TIME_UNSET, jA, this.f17637a.f(aVar.f24654b), false, false, false);
    }

    private zd a(fo foVar, Object obj, long j11, long j12, long j13) {
        long jMax = j11;
        foVar.a(obj, this.f17637a);
        int iA = this.f17637a.a(jMax);
        be.a aVar = new be.a(obj, j13, iA);
        boolean zA = a(aVar);
        boolean zA2 = a(foVar, aVar);
        boolean zA3 = a(foVar, aVar, zA);
        boolean z11 = iA != -1 && this.f17637a.f(iA);
        long jB = iA != -1 ? this.f17637a.b(iA) : -9223372036854775807L;
        long j14 = (jB == C.TIME_UNSET || jB == Long.MIN_VALUE) ? this.f17637a.f19034d : jB;
        if (j14 != C.TIME_UNSET && jMax >= j14) {
            jMax = Math.max(0L, j14 - 1);
        }
        return new zd(aVar, jMax, j12, jB, j14, z11, zA, zA2, zA3);
    }

    private zd a(oh ohVar) {
        return a(ohVar.f21534a, ohVar.f21535b, ohVar.f21536c, ohVar.f21552s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(eb.a aVar, be.a aVar2) {
        this.f17639c.a(aVar.a(), aVar2);
    }

    private boolean a(long j11, long j12) {
        return j11 == C.TIME_UNSET || j11 == j12;
    }

    private boolean a(be.a aVar) {
        return !aVar.a() && aVar.f24657e == -1;
    }

    private boolean a(fo foVar) {
        xd xdVarD = this.f17644h;
        if (xdVarD == null) {
            return true;
        }
        int iA = foVar.a(xdVarD.f24296b);
        while (true) {
            iA = foVar.a(iA, this.f17637a, this.f17638b, this.f17642f, this.f17643g);
            while (xdVarD.d() != null && !xdVarD.f24300f.f24841g) {
                xdVarD = xdVarD.d();
            }
            xd xdVarD2 = xdVarD.d();
            if (iA == -1 || xdVarD2 == null || foVar.a(xdVarD2.f24296b) != iA) {
                break;
            }
            xdVarD = xdVarD2;
        }
        boolean zA = a(xdVarD);
        xdVarD.f24300f = a(foVar, xdVarD.f24300f);
        return !zA;
    }

    private boolean a(fo foVar, be.a aVar) {
        if (a(aVar)) {
            return foVar.a(foVar.a(aVar.f24653a, this.f17637a).f19033c, this.f17638b).f19061q == foVar.a(aVar.f24653a);
        }
        return false;
    }

    private boolean a(fo foVar, be.a aVar, boolean z11) {
        int iA = foVar.a(aVar.f24653a);
        return !foVar.a(foVar.a(iA, this.f17637a).f19033c, this.f17638b).f19054j && foVar.b(iA, this.f17637a, this.f17638b, this.f17642f, this.f17643g) && z11;
    }

    private boolean a(zd zdVar, zd zdVar2) {
        return zdVar.f24836b == zdVar2.f24836b && zdVar.f24835a.equals(zdVar2.f24835a);
    }

    private void g() {
        if (this.f17639c != null) {
            final eb.a aVarF = eb.f();
            for (xd xdVarD = this.f17644h; xdVarD != null; xdVarD = xdVarD.d()) {
                aVarF.b(xdVarD.f24300f.f24835a);
            }
            xd xdVar = this.f17645i;
            final be.a aVar = xdVar == null ? null : xdVar.f24300f.f24835a;
            this.f17640d.post(new Runnable() { // from class: com.applovin.impl.rs
                @Override // java.lang.Runnable
                public final void run() {
                    this.f22189a.a(aVarF, aVar);
                }
            });
        }
    }

    public be.a a(fo foVar, Object obj, long j11) {
        return a(foVar, obj, j11, a(foVar, obj), this.f17637a);
    }

    public xd a() {
        xd xdVar = this.f17644h;
        if (xdVar == null) {
            return null;
        }
        if (xdVar == this.f17645i) {
            this.f17645i = xdVar.d();
        }
        this.f17644h.l();
        int i11 = this.f17647k - 1;
        this.f17647k = i11;
        if (i11 == 0) {
            this.f17646j = null;
            xd xdVar2 = this.f17644h;
            this.f17648l = xdVar2.f24296b;
            this.f17649m = xdVar2.f24300f.f24835a.f24656d;
        }
        this.f17644h = this.f17644h.d();
        g();
        return this.f17644h;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x001c  */
    public xd a(ri[] riVarArr, vo voVar, n0 n0Var, fe feVar, zd zdVar, wo woVar) {
        long jF;
        xd xdVar = this.f17646j;
        if (xdVar != null) {
            jF = (xdVar.f() + this.f17646j.f24300f.f24839e) - zdVar.f24836b;
        } else if (zdVar.f24835a.a()) {
            jF = zdVar.f24837c;
            if (jF == C.TIME_UNSET) {
                jF = 0;
            }
        } else {
            jF = 0;
        }
        xd xdVar2 = new xd(riVarArr, jF, voVar, n0Var, feVar, zdVar, woVar);
        xd xdVar3 = this.f17646j;
        if (xdVar3 != null) {
            xdVar3.a(xdVar2);
        } else {
            this.f17644h = xdVar2;
            this.f17645i = xdVar2;
        }
        this.f17648l = null;
        this.f17646j = xdVar2;
        this.f17647k++;
        g();
        return xdVar2;
    }

    public zd a(long j11, oh ohVar) {
        xd xdVar = this.f17646j;
        return xdVar == null ? a(ohVar) : a(ohVar.f21534a, xdVar, j11);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0062  */
    /* JADX WARN: Code duplicated, block: B:23:0x006c  */
    /* JADX WARN: Code duplicated, block: B:28:0x007b  */
    public zd a(fo foVar, zd zdVar) {
        long jC;
        long j11;
        int i11;
        boolean zF;
        int i12;
        be.a aVar = zdVar.f24835a;
        boolean zA = a(aVar);
        boolean zA2 = a(foVar, aVar);
        boolean zA3 = a(foVar, aVar, zA);
        foVar.a(zdVar.f24835a.f24653a, this.f17637a);
        long jB = (aVar.a() || (i12 = aVar.f24657e) == -1) ? -9223372036854775807L : this.f17637a.b(i12);
        if (!aVar.a()) {
            if (jB == C.TIME_UNSET || jB == Long.MIN_VALUE) {
                jC = this.f17637a.c();
            } else {
                j11 = jB;
            }
            if (aVar.a()) {
                zF = this.f17637a.f(aVar.f24654b);
            } else {
                i11 = aVar.f24657e;
                if (i11 == -1 && this.f17637a.f(i11)) {
                    zF = true;
                } else {
                    zF = false;
                }
            }
            return new zd(aVar, zdVar.f24836b, zdVar.f24837c, jB, j11, zF, zA, zA2, zA3);
        }
        jC = this.f17637a.a(aVar.f24654b, aVar.f24655c);
        j11 = jC;
        if (aVar.a()) {
            zF = this.f17637a.f(aVar.f24654b);
        } else {
            i11 = aVar.f24657e;
            if (i11 == -1) {
                zF = false;
            } else {
                zF = false;
            }
        }
        return new zd(aVar, zdVar.f24836b, zdVar.f24837c, jB, j11, zF, zA, zA2, zA3);
    }

    public void a(long j11) {
        xd xdVar = this.f17646j;
        if (xdVar != null) {
            xdVar.b(j11);
        }
    }

    public boolean a(fo foVar, int i11) {
        this.f17642f = i11;
        return a(foVar);
    }

    public boolean a(fo foVar, long j11, long j12) {
        boolean zA;
        zd zdVarA;
        xd xdVarD = this.f17644h;
        xd xdVar = null;
        while (xdVarD != null) {
            zd zdVar = xdVarD.f24300f;
            if (xdVar != null) {
                zd zdVarA2 = a(foVar, xdVar, j11);
                if (zdVarA2 == null) {
                    zA = a(xdVar);
                } else if (a(zdVar, zdVarA2)) {
                    zdVarA = zdVarA2;
                } else {
                    zA = a(xdVar);
                }
                return !zA;
            }
            zdVarA = a(foVar, zdVar);
            xdVarD.f24300f = zdVarA.a(zdVar.f24837c);
            if (!a(zdVar.f24839e, zdVarA.f24839e)) {
                xdVarD.m();
                long j13 = zdVarA.f24839e;
                return (a(xdVarD) || (xdVarD == this.f17645i && !xdVarD.f24300f.f24840f && ((j12 > Long.MIN_VALUE ? 1 : (j12 == Long.MIN_VALUE ? 0 : -1)) == 0 || (j12 > ((j13 > C.TIME_UNSET ? 1 : (j13 == C.TIME_UNSET ? 0 : -1)) == 0 ? Long.MAX_VALUE : xdVarD.e(j13)) ? 1 : (j12 == ((j13 > C.TIME_UNSET ? 1 : (j13 == C.TIME_UNSET ? 0 : -1)) == 0 ? Long.MAX_VALUE : xdVarD.e(j13)) ? 0 : -1)) >= 0))) ? false : true;
            }
            xdVar = xdVarD;
            xdVarD = xdVarD.d();
        }
        return true;
    }

    public boolean a(fo foVar, boolean z11) {
        this.f17643g = z11;
        return a(foVar);
    }

    public boolean a(wd wdVar) {
        xd xdVar = this.f17646j;
        return xdVar != null && xdVar.f24295a == wdVar;
    }

    public boolean a(xd xdVar) {
        boolean z11 = false;
        b1.b(xdVar != null);
        if (xdVar.equals(this.f17646j)) {
            return false;
        }
        this.f17646j = xdVar;
        while (xdVar.d() != null) {
            xdVar = xdVar.d();
            if (xdVar == this.f17645i) {
                this.f17645i = this.f17644h;
                z11 = true;
            }
            xdVar.l();
            this.f17647k--;
        }
        this.f17646j.a((xd) null);
        g();
        return z11;
    }

    public xd b() {
        xd xdVar = this.f17645i;
        b1.b((xdVar == null || xdVar.d() == null) ? false : true);
        this.f17645i = this.f17645i.d();
        g();
        return this.f17645i;
    }

    public void c() {
        if (this.f17647k == 0) {
            return;
        }
        xd xdVarD = (xd) b1.b(this.f17644h);
        this.f17648l = xdVarD.f24296b;
        this.f17649m = xdVarD.f24300f.f24835a.f24656d;
        while (xdVarD != null) {
            xdVarD.l();
            xdVarD = xdVarD.d();
        }
        this.f17644h = null;
        this.f17646j = null;
        this.f17645i = null;
        this.f17647k = 0;
        g();
    }

    public xd d() {
        return this.f17646j;
    }

    public xd e() {
        return this.f17644h;
    }

    public xd f() {
        return this.f17645i;
    }

    public boolean h() {
        xd xdVar = this.f17646j;
        return xdVar == null || (!xdVar.f24300f.f24843i && xdVar.j() && this.f17646j.f24300f.f24839e != C.TIME_UNSET && this.f17647k < 100);
    }
}
