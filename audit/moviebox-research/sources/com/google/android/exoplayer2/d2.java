package com.google.android.exoplayer2;

import android.os.Handler;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class d2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j3.b f33013a = new j3.b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j3.d f33014b = new j3.d();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final qg.a f33015c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f33016d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f33017e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f33018f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f33019g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public a2 f33020h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public a2 f33021i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public a2 f33022j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f33023k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    public Object f33024l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f33025m;

    public d2(qg.a aVar, Handler handler) {
        this.f33015c = aVar;
        this.f33016d = handler;
    }

    public static com.google.android.exoplayer2.source.i.b A(j3 j3Var, Object obj, long j11, long j12, j3.d dVar, j3.b bVar) {
        j3Var.l(obj, bVar);
        j3Var.r(bVar.f33364c, dVar);
        int iF = j3Var.f(obj);
        Object objE = obj;
        while (bVar.f33365d == 0 && bVar.f() > 0 && bVar.t(bVar.r()) && bVar.h(0L) == -1) {
            int i11 = iF + 1;
            if (iF >= dVar.f33392q) {
                break;
            }
            j3Var.k(i11, bVar, true);
            objE = com.google.android.exoplayer2.util.a.e(bVar.f33363b);
            iF = i11;
        }
        j3Var.l(objE, bVar);
        int iH = bVar.h(j11);
        return iH == -1 ? new com.google.android.exoplayer2.source.i.b(objE, j12, bVar.g(j11)) : new com.google.android.exoplayer2.source.i.b(objE, iH, bVar.n(iH), j12);
    }

    public com.google.android.exoplayer2.source.i.b B(j3 j3Var, Object obj, long j11) {
        long jC = C(j3Var, obj);
        j3Var.l(obj, this.f33013a);
        j3Var.r(this.f33013a.f33364c, this.f33014b);
        boolean z11 = false;
        for (int iF = j3Var.f(obj); iF >= this.f33014b.f33391p; iF--) {
            j3Var.k(iF, this.f33013a, true);
            boolean z12 = this.f33013a.f() > 0;
            z11 |= z12;
            j3.b bVar = this.f33013a;
            if (bVar.h(bVar.f33365d) != -1) {
                obj = com.google.android.exoplayer2.util.a.e(this.f33013a.f33363b);
            }
            if (z11 && (!z12 || this.f33013a.f33365d != 0)) {
                break;
            }
        }
        return A(j3Var, obj, j11, jC, this.f33014b, this.f33013a);
    }

    public final long C(j3 j3Var, Object obj) {
        int iF;
        int i11 = j3Var.l(obj, this.f33013a).f33364c;
        Object obj2 = this.f33024l;
        if (obj2 != null && (iF = j3Var.f(obj2)) != -1 && j3Var.j(iF, this.f33013a).f33364c == i11) {
            return this.f33025m;
        }
        for (a2 a2VarJ = this.f33020h; a2VarJ != null; a2VarJ = a2VarJ.j()) {
            if (a2VarJ.f32687b.equals(obj)) {
                return a2VarJ.f32691f.f32977a.f71963d;
            }
        }
        for (a2 a2VarJ2 = this.f33020h; a2VarJ2 != null; a2VarJ2 = a2VarJ2.j()) {
            int iF2 = j3Var.f(a2VarJ2.f32687b);
            if (iF2 != -1 && j3Var.j(iF2, this.f33013a).f33364c == i11) {
                return a2VarJ2.f32691f.f32977a.f71963d;
            }
        }
        long j11 = this.f33017e;
        this.f33017e = 1 + j11;
        if (this.f33020h == null) {
            this.f33024l = obj;
            this.f33025m = j11;
        }
        return j11;
    }

    public boolean D() {
        a2 a2Var = this.f33022j;
        return a2Var == null || (!a2Var.f32691f.f32985i && a2Var.q() && this.f33022j.f32691f.f32981e != C.TIME_UNSET && this.f33023k < 100);
    }

    public final boolean E(j3 j3Var) {
        a2 a2VarJ = this.f33020h;
        if (a2VarJ == null) {
            return true;
        }
        int iF = j3Var.f(a2VarJ.f32687b);
        while (true) {
            iF = j3Var.h(iF, this.f33013a, this.f33014b, this.f33018f, this.f33019g);
            while (a2VarJ.j() != null && !a2VarJ.f32691f.f32983g) {
                a2VarJ = a2VarJ.j();
            }
            a2 a2VarJ2 = a2VarJ.j();
            if (iF == -1 || a2VarJ2 == null || j3Var.f(a2VarJ2.f32687b) != iF) {
                break;
            }
            a2VarJ = a2VarJ2;
        }
        boolean z11 = z(a2VarJ);
        a2VarJ.f32691f = r(j3Var, a2VarJ.f32691f);
        return !z11;
    }

    public boolean F(j3 j3Var, long j11, long j12) {
        b2 b2VarR;
        a2 a2VarJ = this.f33020h;
        a2 a2Var = null;
        while (a2VarJ != null) {
            b2 b2Var = a2VarJ.f32691f;
            if (a2Var != null) {
                b2 b2VarI = i(j3Var, a2Var, j11);
                if (b2VarI != null && e(b2Var, b2VarI)) {
                    b2VarR = b2VarI;
                }
                return !z(a2Var);
            }
            b2VarR = r(j3Var, b2Var);
            a2VarJ.f32691f = b2VarR.a(b2Var.f32979c);
            if (!d(b2Var.f32981e, b2VarR.f32981e)) {
                a2VarJ.A();
                long j13 = b2VarR.f32981e;
                return (z(a2VarJ) || (a2VarJ == this.f33021i && !a2VarJ.f32691f.f32982f && ((j12 > Long.MIN_VALUE ? 1 : (j12 == Long.MIN_VALUE ? 0 : -1)) == 0 || (j12 > ((j13 > C.TIME_UNSET ? 1 : (j13 == C.TIME_UNSET ? 0 : -1)) == 0 ? Long.MAX_VALUE : a2VarJ.z(j13)) ? 1 : (j12 == ((j13 > C.TIME_UNSET ? 1 : (j13 == C.TIME_UNSET ? 0 : -1)) == 0 ? Long.MAX_VALUE : a2VarJ.z(j13)) ? 0 : -1)) >= 0))) ? false : true;
            }
            a2Var = a2VarJ;
            a2VarJ = a2VarJ.j();
        }
        return true;
    }

    public boolean G(j3 j3Var, int i11) {
        this.f33018f = i11;
        return E(j3Var);
    }

    public boolean H(j3 j3Var, boolean z11) {
        this.f33019g = z11;
        return E(j3Var);
    }

    @Nullable
    public a2 b() {
        a2 a2Var = this.f33020h;
        if (a2Var == null) {
            return null;
        }
        if (a2Var == this.f33021i) {
            this.f33021i = a2Var.j();
        }
        this.f33020h.t();
        int i11 = this.f33023k - 1;
        this.f33023k = i11;
        if (i11 == 0) {
            this.f33022j = null;
            a2 a2Var2 = this.f33020h;
            this.f33024l = a2Var2.f32687b;
            this.f33025m = a2Var2.f32691f.f32977a.f71963d;
        }
        this.f33020h = this.f33020h.j();
        x();
        return this.f33020h;
    }

    public a2 c() {
        a2 a2Var = this.f33021i;
        com.google.android.exoplayer2.util.a.g((a2Var == null || a2Var.j() == null) ? false : true);
        this.f33021i = this.f33021i.j();
        x();
        return this.f33021i;
    }

    public final boolean d(long j11, long j12) {
        return j11 == C.TIME_UNSET || j11 == j12;
    }

    public final boolean e(b2 b2Var, b2 b2Var2) {
        return b2Var.f32978b == b2Var2.f32978b && b2Var.f32977a.equals(b2Var2.f32977a);
    }

    public void f() {
        if (this.f33023k == 0) {
            return;
        }
        a2 a2VarJ = (a2) com.google.android.exoplayer2.util.a.i(this.f33020h);
        this.f33024l = a2VarJ.f32687b;
        this.f33025m = a2VarJ.f32691f.f32977a.f71963d;
        while (a2VarJ != null) {
            a2VarJ.t();
            a2VarJ = a2VarJ.j();
        }
        this.f33020h = null;
        this.f33022j = null;
        this.f33021i = null;
        this.f33023k = 0;
        x();
    }

    public a2 g(y2[] y2VarArr, fi.b0 b0Var, com.google.android.exoplayer2.upstream.b bVar, g2 g2Var, b2 b2Var, fi.c0 c0Var) {
        a2 a2Var = this.f33022j;
        a2 a2Var2 = new a2(y2VarArr, a2Var == null ? 1000000000000L : (a2Var.l() + this.f33022j.f32691f.f32981e) - b2Var.f32978b, b0Var, bVar, g2Var, b2Var, c0Var);
        a2 a2Var3 = this.f33022j;
        if (a2Var3 != null) {
            a2Var3.w(a2Var2);
        } else {
            this.f33020h = a2Var2;
            this.f33021i = a2Var2;
        }
        this.f33024l = null;
        this.f33022j = a2Var2;
        this.f33023k++;
        x();
        return a2Var2;
    }

    @Nullable
    public final b2 h(k2 k2Var) {
        return k(k2Var.f33404a, k2Var.f33405b, k2Var.f33406c, k2Var.f33421r);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:37:0x00e5  */
    @Nullable
    public final b2 i(j3 j3Var, a2 a2Var, long j11) {
        long j12;
        long j13;
        long j14;
        long j15;
        boolean z11;
        long j16;
        b2 b2Var = a2Var.f32691f;
        long jL = (a2Var.l() + b2Var.f32981e) - j11;
        if (!b2Var.f32983g) {
            com.google.android.exoplayer2.source.i.b bVar = b2Var.f32977a;
            j3Var.l(bVar.f71960a, this.f33013a);
            if (!bVar.b()) {
                int iN = this.f33013a.n(bVar.f71964e);
                boolean z12 = this.f33013a.t(bVar.f71964e) && this.f33013a.k(bVar.f71964e, iN) == 3;
                if (iN == this.f33013a.d(bVar.f71964e) || z12) {
                    return m(j3Var, bVar.f71960a, n(j3Var, bVar.f71960a, bVar.f71964e), b2Var.f32981e, bVar.f71963d);
                }
                return l(j3Var, bVar.f71960a, bVar.f71964e, iN, b2Var.f32981e, bVar.f71963d);
            }
            int i11 = bVar.f71961b;
            int iD = this.f33013a.d(i11);
            if (iD == -1) {
                return null;
            }
            int iO = this.f33013a.o(i11, bVar.f71962c);
            if (iO < iD) {
                return l(j3Var, bVar.f71960a, i11, iO, b2Var.f32979c, bVar.f71963d);
            }
            long jLongValue = b2Var.f32979c;
            if (jLongValue == C.TIME_UNSET) {
                j3.d dVar = this.f33014b;
                j3.b bVar2 = this.f33013a;
                Pair<Object, Long> pairO = j3Var.o(dVar, bVar2, bVar2.f33364c, C.TIME_UNSET, Math.max(0L, jL));
                if (pairO == null) {
                    return null;
                }
                jLongValue = ((Long) pairO.second).longValue();
            }
            return m(j3Var, bVar.f71960a, Math.max(n(j3Var, bVar.f71960a, bVar.f71961b), jLongValue), b2Var.f32979c, bVar.f71963d);
        }
        int iH = j3Var.h(j3Var.f(b2Var.f32977a.f71960a), this.f33013a, this.f33014b, this.f33018f, this.f33019g);
        if (iH == -1) {
            return null;
        }
        int i12 = j3Var.k(iH, this.f33013a, true).f33364c;
        Object objE = com.google.android.exoplayer2.util.a.e(this.f33013a.f33363b);
        long j17 = b2Var.f32977a.f71963d;
        if (j3Var.r(i12, this.f33014b).f33391p == iH) {
            Pair<Object, Long> pairO2 = j3Var.o(this.f33014b, this.f33013a, i12, C.TIME_UNSET, Math.max(0L, jL));
            if (pairO2 == null) {
                return null;
            }
            objE = pairO2.first;
            long jLongValue2 = ((Long) pairO2.second).longValue();
            a2 a2VarJ = a2Var.j();
            if (a2VarJ == null || !a2VarJ.f32687b.equals(objE)) {
                j16 = this.f33017e;
                this.f33017e = 1 + j16;
            } else {
                j16 = a2VarJ.f32691f.f32977a.f71963d;
            }
            j12 = jLongValue2;
            j13 = -9223372036854775807L;
            j17 = j16;
        } else {
            j12 = 0;
            j13 = 0;
        }
        com.google.android.exoplayer2.source.i.b bVarA = A(j3Var, objE, j12, j17, this.f33014b, this.f33013a);
        if (j13 == C.TIME_UNSET || b2Var.f32979c == C.TIME_UNSET) {
            j14 = j12;
            j15 = j13;
        } else {
            if (j3Var.l(b2Var.f32977a.f71960a, this.f33013a).f() > 0) {
                j3.b bVar3 = this.f33013a;
                z11 = bVar3.t(bVar3.r());
            }
            if (bVarA.b() && z11) {
                j15 = b2Var.f32979c;
                j14 = j12;
            } else {
                if (z11) {
                    j14 = b2Var.f32979c;
                } else {
                    j14 = j12;
                }
                j15 = j13;
            }
        }
        return k(j3Var, bVarA, j15, j14);
    }

    @Nullable
    public a2 j() {
        return this.f33022j;
    }

    @Nullable
    public final b2 k(j3 j3Var, com.google.android.exoplayer2.source.i.b bVar, long j11, long j12) {
        j3Var.l(bVar.f71960a, this.f33013a);
        return bVar.b() ? l(j3Var, bVar.f71960a, bVar.f71961b, bVar.f71962c, j11, bVar.f71963d) : m(j3Var, bVar.f71960a, j12, j11, bVar.f71963d);
    }

    public final b2 l(j3 j3Var, Object obj, int i11, int i12, long j11, long j12) {
        com.google.android.exoplayer2.source.i.b bVar = new com.google.android.exoplayer2.source.i.b(obj, i11, i12, j12);
        long jE = j3Var.l(bVar.f71960a, this.f33013a).e(bVar.f71961b, bVar.f71962c);
        long j13 = i12 == this.f33013a.n(i11) ? this.f33013a.j() : 0L;
        return new b2(bVar, (jE == C.TIME_UNSET || j13 < jE) ? j13 : Math.max(0L, jE - 1), j11, C.TIME_UNSET, jE, this.f33013a.t(bVar.f71961b), false, false, false);
    }

    /* JADX WARN: Code duplicated, block: B:37:0x0096  */
    public final b2 m(j3 j3Var, Object obj, long j11, long j12, long j13) {
        boolean z11;
        long j14;
        long jI;
        long j15;
        long jMax = j11;
        j3Var.l(obj, this.f33013a);
        int iG = this.f33013a.g(jMax);
        int i11 = 1;
        if (iG == -1) {
            if (this.f33013a.f() > 0) {
                j3.b bVar = this.f33013a;
                z11 = bVar.t(bVar.r());
            }
        } else {
            if (this.f33013a.t(iG)) {
                long jI2 = this.f33013a.i(iG);
                j3.b bVar2 = this.f33013a;
                if (jI2 == bVar2.f33365d && bVar2.s(iG)) {
                    iG = -1;
                }
            }
        }
        com.google.android.exoplayer2.source.i.b bVar3 = new com.google.android.exoplayer2.source.i.b(obj, j13, iG);
        boolean zS = s(bVar3);
        boolean zU = u(j3Var, bVar3);
        boolean zT = t(j3Var, bVar3, zS);
        boolean z12 = iG != -1 && this.f33013a.t(iG);
        if (iG == -1) {
            if (z11) {
                jI = this.f33013a.f33365d;
            } else {
                j14 = -9223372036854775807L;
            }
            if (j14 != C.TIME_UNSET || j14 == Long.MIN_VALUE) {
                j15 = this.f33013a.f33365d;
            } else {
                j15 = j14;
            }
            if (j15 != C.TIME_UNSET && jMax >= j15) {
                if (!zT && z11) {
                    i11 = 0;
                }
                jMax = Math.max(0L, j15 - ((long) i11));
            }
            return new b2(bVar3, jMax, j12, j14, j15, z12, zS, zU, zT);
        }
        jI = this.f33013a.i(iG);
        j14 = jI;
        if (j14 != C.TIME_UNSET) {
            j15 = this.f33013a.f33365d;
        } else {
            j15 = this.f33013a.f33365d;
        }
        if (j15 != C.TIME_UNSET) {
            if (!zT) {
                i11 = 0;
            }
            jMax = Math.max(0L, j15 - ((long) i11));
        }
        return new b2(bVar3, jMax, j12, j14, j15, z12, zS, zU, zT);
    }

    public final long n(j3 j3Var, Object obj, int i11) {
        j3Var.l(obj, this.f33013a);
        long jI = this.f33013a.i(i11);
        return jI == Long.MIN_VALUE ? this.f33013a.f33365d : jI + this.f33013a.l(i11);
    }

    @Nullable
    public b2 o(long j11, k2 k2Var) {
        a2 a2Var = this.f33022j;
        return a2Var == null ? h(k2Var) : i(k2Var.f33404a, a2Var, j11);
    }

    @Nullable
    public a2 p() {
        return this.f33020h;
    }

    @Nullable
    public a2 q() {
        return this.f33021i;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0062  */
    /* JADX WARN: Code duplicated, block: B:23:0x006c  */
    /* JADX WARN: Code duplicated, block: B:28:0x007b  */
    public b2 r(j3 j3Var, b2 b2Var) {
        long jM;
        long j11;
        int i11;
        boolean zT;
        int i12;
        com.google.android.exoplayer2.source.i.b bVar = b2Var.f32977a;
        boolean zS = s(bVar);
        boolean zU = u(j3Var, bVar);
        boolean zT2 = t(j3Var, bVar, zS);
        j3Var.l(b2Var.f32977a.f71960a, this.f33013a);
        long jI = (bVar.b() || (i12 = bVar.f71964e) == -1) ? -9223372036854775807L : this.f33013a.i(i12);
        if (!bVar.b()) {
            if (jI == C.TIME_UNSET || jI == Long.MIN_VALUE) {
                jM = this.f33013a.m();
            } else {
                j11 = jI;
            }
            if (bVar.b()) {
                zT = this.f33013a.t(bVar.f71961b);
            } else {
                i11 = bVar.f71964e;
                if (i11 == -1 && this.f33013a.t(i11)) {
                    zT = true;
                } else {
                    zT = false;
                }
            }
            return new b2(bVar, b2Var.f32978b, b2Var.f32979c, jI, j11, zT, zS, zU, zT2);
        }
        jM = this.f33013a.e(bVar.f71961b, bVar.f71962c);
        j11 = jM;
        if (bVar.b()) {
            zT = this.f33013a.t(bVar.f71961b);
        } else {
            i11 = bVar.f71964e;
            if (i11 == -1) {
                zT = false;
            } else {
                zT = false;
            }
        }
        return new b2(bVar, b2Var.f32978b, b2Var.f32979c, jI, j11, zT, zS, zU, zT2);
    }

    public final boolean s(com.google.android.exoplayer2.source.i.b bVar) {
        return !bVar.b() && bVar.f71964e == -1;
    }

    public final boolean t(j3 j3Var, com.google.android.exoplayer2.source.i.b bVar, boolean z11) {
        int iF = j3Var.f(bVar.f71960a);
        return !j3Var.r(j3Var.j(iF, this.f33013a).f33364c, this.f33014b).f33385j && j3Var.v(iF, this.f33013a, this.f33014b, this.f33018f, this.f33019g) && z11;
    }

    public final boolean u(j3 j3Var, com.google.android.exoplayer2.source.i.b bVar) {
        if (s(bVar)) {
            return j3Var.r(j3Var.l(bVar.f71960a, this.f33013a).f33364c, this.f33014b).f33392q == j3Var.f(bVar.f71960a);
        }
        return false;
    }

    public boolean v(com.google.android.exoplayer2.source.h hVar) {
        a2 a2Var = this.f33022j;
        return a2Var != null && a2Var.f32686a == hVar;
    }

    public final /* synthetic */ void w(ImmutableList.a aVar, com.google.android.exoplayer2.source.i.b bVar) {
        this.f33015c.z(aVar.m(), bVar);
    }

    public final void x() {
        final ImmutableList.a aVarBuilder = ImmutableList.builder();
        for (a2 a2VarJ = this.f33020h; a2VarJ != null; a2VarJ = a2VarJ.j()) {
            aVarBuilder.a(a2VarJ.f32691f.f32977a);
        }
        a2 a2Var = this.f33021i;
        final com.google.android.exoplayer2.source.i.b bVar = a2Var == null ? null : a2Var.f32691f.f32977a;
        this.f33016d.post(new Runnable() { // from class: com.google.android.exoplayer2.c2
            @Override // java.lang.Runnable
            public final void run() {
                this.f33007a.w(aVarBuilder, bVar);
            }
        });
    }

    public void y(long j11) {
        a2 a2Var = this.f33022j;
        if (a2Var != null) {
            a2Var.s(j11);
        }
    }

    public boolean z(a2 a2Var) {
        boolean z11 = false;
        com.google.android.exoplayer2.util.a.g(a2Var != null);
        if (a2Var.equals(this.f33022j)) {
            return false;
        }
        this.f33022j = a2Var;
        while (a2Var.j() != null) {
            a2Var = a2Var.j();
            if (a2Var == this.f33021i) {
                this.f33021i = this.f33020h;
                z11 = true;
            }
            a2Var.t();
            this.f33023k--;
        }
        this.f33022j.w(null);
        x();
        return z11;
    }
}
