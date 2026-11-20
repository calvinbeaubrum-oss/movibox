package androidx.media3.exoplayer;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.media3.common.m0.b f10067a = new androidx.media3.common.m0.b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.media3.common.m0.c f10068b = new androidx.media3.common.m0.c();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e4.a f10069c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final z3.j f10070d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final z1.a f10071e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f10072f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f10073g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f10074h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public z1 f10075i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public z1 f10076j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public z1 f10077k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f10078l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    public Object f10079m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f10080n;

    public c2(e4.a aVar, z3.j jVar, z1.a aVar2) {
        this.f10069c = aVar;
        this.f10070d = jVar;
        this.f10071e = aVar2;
    }

    public static androidx.media3.exoplayer.source.l.b E(androidx.media3.common.m0 m0Var, Object obj, long j11, long j12, androidx.media3.common.m0.c cVar, androidx.media3.common.m0.b bVar) {
        m0Var.h(obj, bVar);
        m0Var.n(bVar.f9295c, cVar);
        Object objE = obj;
        for (int iB = m0Var.b(obj); z(bVar) && iB <= cVar.f9324p; iB++) {
            m0Var.g(iB, bVar, true);
            objE = z3.a.e(bVar.f9294b);
        }
        m0Var.h(objE, bVar);
        int iE = bVar.e(j11);
        return iE == -1 ? new androidx.media3.exoplayer.source.l.b(objE, j12, bVar.d(j11)) : new androidx.media3.exoplayer.source.l.b(objE, iE, bVar.l(iE), j12);
    }

    public static boolean z(androidx.media3.common.m0.b bVar) {
        int iC = bVar.c();
        if (iC == 0) {
            return false;
        }
        if ((iC == 1 && bVar.r(0)) || !bVar.s(bVar.p())) {
            return false;
        }
        long jI = 0;
        if (bVar.e(0L) != -1) {
            return false;
        }
        if (bVar.f9296d == 0) {
            return true;
        }
        int i11 = iC - (bVar.r(iC + (-1)) ? 2 : 1);
        for (int i12 = 0; i12 <= i11; i12++) {
            jI += bVar.i(i12);
        }
        return bVar.f9296d <= jI;
    }

    public final /* synthetic */ void A(ImmutableList.a aVar, androidx.media3.exoplayer.source.l.b bVar) {
        this.f10069c.q(aVar.m(), bVar);
    }

    public final void B() {
        final ImmutableList.a aVarBuilder = ImmutableList.builder();
        for (z1 z1VarJ = this.f10075i; z1VarJ != null; z1VarJ = z1VarJ.j()) {
            aVarBuilder.a(z1VarJ.f11775f.f9824a);
        }
        z1 z1Var = this.f10076j;
        final androidx.media3.exoplayer.source.l.b bVar = z1Var == null ? null : z1Var.f11775f.f9824a;
        this.f10070d.post(new Runnable() { // from class: androidx.media3.exoplayer.b2
            @Override // java.lang.Runnable
            public final void run() {
                this.f9999a.A(aVarBuilder, bVar);
            }
        });
    }

    public void C(long j11) {
        z1 z1Var = this.f10077k;
        if (z1Var != null) {
            z1Var.s(j11);
        }
    }

    public boolean D(z1 z1Var) {
        z3.a.i(z1Var);
        boolean z11 = false;
        if (z1Var.equals(this.f10077k)) {
            return false;
        }
        this.f10077k = z1Var;
        while (z1Var.j() != null) {
            z1Var = (z1) z3.a.e(z1Var.j());
            if (z1Var == this.f10076j) {
                this.f10076j = this.f10075i;
                z11 = true;
            }
            z1Var.t();
            this.f10078l--;
        }
        ((z1) z3.a.e(this.f10077k)).w(null);
        B();
        return z11;
    }

    public androidx.media3.exoplayer.source.l.b F(androidx.media3.common.m0 m0Var, Object obj, long j11) {
        long jG = G(m0Var, obj);
        m0Var.h(obj, this.f10067a);
        m0Var.n(this.f10067a.f9295c, this.f10068b);
        boolean z11 = false;
        for (int iB = m0Var.b(obj); iB >= this.f10068b.f9323o; iB--) {
            m0Var.g(iB, this.f10067a, true);
            boolean z12 = this.f10067a.c() > 0;
            z11 |= z12;
            androidx.media3.common.m0.b bVar = this.f10067a;
            if (bVar.e(bVar.f9296d) != -1) {
                obj = z3.a.e(this.f10067a.f9294b);
            }
            if (z11 && (!z12 || this.f10067a.f9296d != 0)) {
                break;
            }
        }
        return E(m0Var, obj, j11, jG, this.f10068b, this.f10067a);
    }

    public final long G(androidx.media3.common.m0 m0Var, Object obj) {
        int iB;
        int i11 = m0Var.h(obj, this.f10067a).f9295c;
        Object obj2 = this.f10079m;
        if (obj2 != null && (iB = m0Var.b(obj2)) != -1 && m0Var.f(iB, this.f10067a).f9295c == i11) {
            return this.f10080n;
        }
        for (z1 z1VarJ = this.f10075i; z1VarJ != null; z1VarJ = z1VarJ.j()) {
            if (z1VarJ.f11771b.equals(obj)) {
                return z1VarJ.f11775f.f9824a.f11212d;
            }
        }
        for (z1 z1VarJ2 = this.f10075i; z1VarJ2 != null; z1VarJ2 = z1VarJ2.j()) {
            int iB2 = m0Var.b(z1VarJ2.f11771b);
            if (iB2 != -1 && m0Var.f(iB2, this.f10067a).f9295c == i11) {
                return z1VarJ2.f11775f.f9824a.f11212d;
            }
        }
        long j11 = this.f10072f;
        this.f10072f = 1 + j11;
        if (this.f10075i == null) {
            this.f10079m = obj;
            this.f10080n = j11;
        }
        return j11;
    }

    public boolean H() {
        z1 z1Var = this.f10077k;
        return z1Var == null || (!z1Var.f11775f.f9832i && z1Var.q() && this.f10077k.f11775f.f9828e != C.TIME_UNSET && this.f10078l < 100);
    }

    public final boolean I(androidx.media3.common.m0 m0Var) {
        z1 z1VarJ = this.f10075i;
        if (z1VarJ == null) {
            return true;
        }
        int iB = m0Var.b(z1VarJ.f11771b);
        while (true) {
            iB = m0Var.d(iB, this.f10067a, this.f10068b, this.f10073g, this.f10074h);
            while (((z1) z3.a.e(z1VarJ)).j() != null && !z1VarJ.f11775f.f9830g) {
                z1VarJ = z1VarJ.j();
            }
            z1 z1VarJ2 = z1VarJ.j();
            if (iB == -1 || z1VarJ2 == null || m0Var.b(z1VarJ2.f11771b) != iB) {
                break;
            }
            z1VarJ = z1VarJ2;
        }
        boolean zD = D(z1VarJ);
        z1VarJ.f11775f = t(m0Var, z1VarJ.f11775f);
        return !zD;
    }

    public boolean J(androidx.media3.common.m0 m0Var, long j11, long j12) {
        a2 a2VarT;
        z1 z1VarJ = this.f10075i;
        z1 z1Var = null;
        while (z1VarJ != null) {
            a2 a2Var = z1VarJ.f11775f;
            if (z1Var != null) {
                a2 a2VarJ = j(m0Var, z1Var, j11);
                if (a2VarJ != null && e(a2Var, a2VarJ)) {
                    a2VarT = a2VarJ;
                }
                return !D(z1Var);
            }
            a2VarT = t(m0Var, a2Var);
            z1VarJ.f11775f = a2VarT.a(a2Var.f9826c);
            if (!d(a2Var.f9828e, a2VarT.f9828e)) {
                z1VarJ.A();
                long j13 = a2VarT.f9828e;
                return (D(z1VarJ) || (z1VarJ == this.f10076j && !z1VarJ.f11775f.f9829f && ((j12 > Long.MIN_VALUE ? 1 : (j12 == Long.MIN_VALUE ? 0 : -1)) == 0 || (j12 > ((j13 > C.TIME_UNSET ? 1 : (j13 == C.TIME_UNSET ? 0 : -1)) == 0 ? Long.MAX_VALUE : z1VarJ.z(j13)) ? 1 : (j12 == ((j13 > C.TIME_UNSET ? 1 : (j13 == C.TIME_UNSET ? 0 : -1)) == 0 ? Long.MAX_VALUE : z1VarJ.z(j13)) ? 0 : -1)) >= 0))) ? false : true;
            }
            z1Var = z1VarJ;
            z1VarJ = z1VarJ.j();
        }
        return true;
    }

    public boolean K(androidx.media3.common.m0 m0Var, int i11) {
        this.f10073g = i11;
        return I(m0Var);
    }

    public boolean L(androidx.media3.common.m0 m0Var, boolean z11) {
        this.f10074h = z11;
        return I(m0Var);
    }

    @Nullable
    public z1 b() {
        z1 z1Var = this.f10075i;
        if (z1Var == null) {
            return null;
        }
        if (z1Var == this.f10076j) {
            this.f10076j = z1Var.j();
        }
        this.f10075i.t();
        int i11 = this.f10078l - 1;
        this.f10078l = i11;
        if (i11 == 0) {
            this.f10077k = null;
            z1 z1Var2 = this.f10075i;
            this.f10079m = z1Var2.f11771b;
            this.f10080n = z1Var2.f11775f.f9824a.f11212d;
        }
        this.f10075i = this.f10075i.j();
        B();
        return this.f10075i;
    }

    public z1 c() {
        this.f10076j = ((z1) z3.a.i(this.f10076j)).j();
        B();
        return (z1) z3.a.i(this.f10076j);
    }

    public final boolean d(long j11, long j12) {
        return j11 == C.TIME_UNSET || j11 == j12;
    }

    public final boolean e(a2 a2Var, a2 a2Var2) {
        return a2Var.f9825b == a2Var2.f9825b && a2Var.f9824a.equals(a2Var2.f9824a);
    }

    public void f() {
        if (this.f10078l == 0) {
            return;
        }
        z1 z1VarJ = (z1) z3.a.i(this.f10075i);
        this.f10079m = z1VarJ.f11771b;
        this.f10080n = z1VarJ.f11775f.f9824a.f11212d;
        while (z1VarJ != null) {
            z1VarJ.t();
            z1VarJ = z1VarJ.j();
        }
        this.f10075i = null;
        this.f10077k = null;
        this.f10076j = null;
        this.f10078l = 0;
        B();
    }

    public z1 g(a2 a2Var) {
        z1 z1Var = this.f10077k;
        z1 z1VarA = this.f10071e.a(a2Var, z1Var == null ? 1000000000000L : (z1Var.l() + this.f10077k.f11775f.f9828e) - a2Var.f9825b);
        z1 z1Var2 = this.f10077k;
        if (z1Var2 != null) {
            z1Var2.w(z1VarA);
        } else {
            this.f10075i = z1VarA;
            this.f10076j = z1VarA;
        }
        this.f10079m = null;
        this.f10077k = z1VarA;
        this.f10078l++;
        B();
        return z1VarA;
    }

    @Nullable
    public final a2 h(s2 s2Var) {
        return m(s2Var.f11065a, s2Var.f11066b, s2Var.f11067c, s2Var.f11082r);
    }

    @Nullable
    public final a2 i(androidx.media3.common.m0 m0Var, z1 z1Var, long j11) {
        long j12;
        long j13;
        Object obj;
        long j14;
        long j15;
        long j16;
        a2 a2Var = z1Var.f11775f;
        int iD = m0Var.d(m0Var.b(a2Var.f9824a.f11209a), this.f10067a, this.f10068b, this.f10073g, this.f10074h);
        if (iD == -1) {
            return null;
        }
        int i11 = m0Var.g(iD, this.f10067a, true).f9295c;
        Object objE = z3.a.e(this.f10067a.f9294b);
        long j17 = a2Var.f9824a.f11212d;
        if (m0Var.n(i11, this.f10068b).f9323o == iD) {
            Pair<Object, Long> pairK = m0Var.k(this.f10068b, this.f10067a, i11, C.TIME_UNSET, Math.max(0L, j11));
            if (pairK == null) {
                return null;
            }
            Object obj2 = pairK.first;
            long jLongValue = ((Long) pairK.second).longValue();
            z1 z1VarJ = z1Var.j();
            if (z1VarJ == null || !z1VarJ.f11771b.equals(obj2)) {
                j16 = this.f10072f;
                this.f10072f = 1 + j16;
            } else {
                j16 = z1VarJ.f11775f.f9824a.f11212d;
            }
            j12 = j16;
            j13 = -9223372036854775807L;
            obj = obj2;
            j14 = jLongValue;
        } else {
            j12 = j17;
            j13 = 0;
            obj = objE;
            j14 = 0;
        }
        androidx.media3.exoplayer.source.l.b bVarE = E(m0Var, obj, j14, j12, this.f10068b, this.f10067a);
        if (j13 == C.TIME_UNSET || a2Var.f9826c == C.TIME_UNSET) {
            j15 = j14;
        } else {
            boolean zU = u(a2Var.f9824a.f11209a, m0Var);
            if (bVarE.b() && zU) {
                j13 = a2Var.f9826c;
            } else if (zU) {
                j15 = a2Var.f9826c;
            }
            j15 = j14;
        }
        return m(m0Var, bVarE, j13, j15);
    }

    @Nullable
    public final a2 j(androidx.media3.common.m0 m0Var, z1 z1Var, long j11) {
        a2 a2Var = z1Var.f11775f;
        long jL = (z1Var.l() + a2Var.f9828e) - j11;
        return a2Var.f9830g ? i(m0Var, z1Var, jL) : k(m0Var, z1Var, jL);
    }

    @Nullable
    public final a2 k(androidx.media3.common.m0 m0Var, z1 z1Var, long j11) {
        a2 a2Var = z1Var.f11775f;
        androidx.media3.exoplayer.source.l.b bVar = a2Var.f9824a;
        m0Var.h(bVar.f11209a, this.f10067a);
        if (!bVar.b()) {
            int i11 = bVar.f11213e;
            if (i11 != -1 && this.f10067a.r(i11)) {
                return i(m0Var, z1Var, j11);
            }
            int iL = this.f10067a.l(bVar.f11213e);
            boolean z11 = this.f10067a.s(bVar.f11213e) && this.f10067a.h(bVar.f11213e, iL) == 3;
            if (iL == this.f10067a.a(bVar.f11213e) || z11) {
                return o(m0Var, bVar.f11209a, p(m0Var, bVar.f11209a, bVar.f11213e), a2Var.f9828e, bVar.f11212d);
            }
            return n(m0Var, bVar.f11209a, bVar.f11213e, iL, a2Var.f9828e, bVar.f11212d);
        }
        int i12 = bVar.f11210b;
        int iA = this.f10067a.a(i12);
        if (iA == -1) {
            return null;
        }
        int iM = this.f10067a.m(i12, bVar.f11211c);
        if (iM < iA) {
            return n(m0Var, bVar.f11209a, i12, iM, a2Var.f9826c, bVar.f11212d);
        }
        long jLongValue = a2Var.f9826c;
        if (jLongValue == C.TIME_UNSET) {
            androidx.media3.common.m0.c cVar = this.f10068b;
            androidx.media3.common.m0.b bVar2 = this.f10067a;
            Pair<Object, Long> pairK = m0Var.k(cVar, bVar2, bVar2.f9295c, C.TIME_UNSET, Math.max(0L, j11));
            if (pairK == null) {
                return null;
            }
            jLongValue = ((Long) pairK.second).longValue();
        }
        return o(m0Var, bVar.f11209a, Math.max(p(m0Var, bVar.f11209a, bVar.f11210b), jLongValue), a2Var.f9826c, bVar.f11212d);
    }

    @Nullable
    public z1 l() {
        return this.f10077k;
    }

    @Nullable
    public final a2 m(androidx.media3.common.m0 m0Var, androidx.media3.exoplayer.source.l.b bVar, long j11, long j12) {
        m0Var.h(bVar.f11209a, this.f10067a);
        return bVar.b() ? n(m0Var, bVar.f11209a, bVar.f11210b, bVar.f11211c, j11, bVar.f11212d) : o(m0Var, bVar.f11209a, j12, j11, bVar.f11212d);
    }

    public final a2 n(androidx.media3.common.m0 m0Var, Object obj, int i11, int i12, long j11, long j12) {
        androidx.media3.exoplayer.source.l.b bVar = new androidx.media3.exoplayer.source.l.b(obj, i11, i12, j12);
        long jB = m0Var.h(bVar.f11209a, this.f10067a).b(bVar.f11210b, bVar.f11211c);
        long jG = i12 == this.f10067a.l(i11) ? this.f10067a.g() : 0L;
        return new a2(bVar, (jB == C.TIME_UNSET || jG < jB) ? jG : Math.max(0L, jB - 1), j11, C.TIME_UNSET, jB, this.f10067a.s(bVar.f11210b), false, false, false);
    }

    /* JADX WARN: Code duplicated, block: B:44:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:51:0x00b9  */
    public final a2 o(androidx.media3.common.m0 m0Var, Object obj, long j11, long j12, long j13) {
        boolean z11;
        long j14;
        long jF;
        long j15;
        long jMax = j11;
        m0Var.h(obj, this.f10067a);
        int iD = this.f10067a.d(jMax);
        boolean z12 = iD != -1 && this.f10067a.r(iD);
        if (iD == -1) {
            if (this.f10067a.c() > 0) {
                androidx.media3.common.m0.b bVar = this.f10067a;
                z11 = bVar.s(bVar.p());
            }
        } else {
            if (this.f10067a.s(iD)) {
                long jF2 = this.f10067a.f(iD);
                androidx.media3.common.m0.b bVar2 = this.f10067a;
                if (jF2 == bVar2.f9296d && bVar2.q(iD)) {
                    iD = -1;
                }
            }
        }
        androidx.media3.exoplayer.source.l.b bVar3 = new androidx.media3.exoplayer.source.l.b(obj, j13, iD);
        boolean zV = v(bVar3);
        boolean zX = x(m0Var, bVar3);
        boolean zW = w(m0Var, bVar3, zV);
        boolean z13 = (iD == -1 || !this.f10067a.s(iD) || z12) ? false : true;
        if (iD == -1 || z12) {
            if (z11) {
                jF = this.f10067a.f9296d;
            } else {
                j14 = -9223372036854775807L;
            }
            if (j14 != C.TIME_UNSET || j14 == Long.MIN_VALUE) {
                j15 = this.f10067a.f9296d;
            } else {
                j15 = j14;
            }
            if (j15 != C.TIME_UNSET && jMax >= j15) {
                jMax = Math.max(0L, j15 - ((long) ((zW && z11) ? 0 : 1)));
            }
            return new a2(bVar3, jMax, j12, j14, j15, z13, zV, zX, zW);
        }
        jF = this.f10067a.f(iD);
        j14 = jF;
        if (j14 != C.TIME_UNSET) {
            j15 = this.f10067a.f9296d;
        } else {
            j15 = this.f10067a.f9296d;
        }
        if (j15 != C.TIME_UNSET) {
            jMax = Math.max(0L, j15 - ((long) ((zW && z11) ? 0 : 1)));
        }
        return new a2(bVar3, jMax, j12, j14, j15, z13, zV, zX, zW);
    }

    public final long p(androidx.media3.common.m0 m0Var, Object obj, int i11) {
        m0Var.h(obj, this.f10067a);
        long jF = this.f10067a.f(i11);
        return jF == Long.MIN_VALUE ? this.f10067a.f9296d : jF + this.f10067a.i(i11);
    }

    @Nullable
    public a2 q(long j11, s2 s2Var) {
        z1 z1Var = this.f10077k;
        return z1Var == null ? h(s2Var) : j(s2Var.f11065a, z1Var, j11);
    }

    @Nullable
    public z1 r() {
        return this.f10075i;
    }

    @Nullable
    public z1 s() {
        return this.f10076j;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0062  */
    /* JADX WARN: Code duplicated, block: B:23:0x006c  */
    /* JADX WARN: Code duplicated, block: B:28:0x007b  */
    public a2 t(androidx.media3.common.m0 m0Var, a2 a2Var) {
        long jK;
        long j11;
        int i11;
        boolean zS;
        int i12;
        androidx.media3.exoplayer.source.l.b bVar = a2Var.f9824a;
        boolean zV = v(bVar);
        boolean zX = x(m0Var, bVar);
        boolean zW = w(m0Var, bVar, zV);
        m0Var.h(a2Var.f9824a.f11209a, this.f10067a);
        long jF = (bVar.b() || (i12 = bVar.f11213e) == -1) ? -9223372036854775807L : this.f10067a.f(i12);
        if (!bVar.b()) {
            if (jF == C.TIME_UNSET || jF == Long.MIN_VALUE) {
                jK = this.f10067a.k();
            } else {
                j11 = jF;
            }
            if (bVar.b()) {
                zS = this.f10067a.s(bVar.f11210b);
            } else {
                i11 = bVar.f11213e;
                if (i11 == -1 && this.f10067a.s(i11)) {
                    zS = true;
                } else {
                    zS = false;
                }
            }
            return new a2(bVar, a2Var.f9825b, a2Var.f9826c, jF, j11, zS, zV, zX, zW);
        }
        jK = this.f10067a.b(bVar.f11210b, bVar.f11211c);
        j11 = jK;
        if (bVar.b()) {
            zS = this.f10067a.s(bVar.f11210b);
        } else {
            i11 = bVar.f11213e;
            if (i11 == -1) {
                zS = false;
            } else {
                zS = false;
            }
        }
        return new a2(bVar, a2Var.f9825b, a2Var.f9826c, jF, j11, zS, zV, zX, zW);
    }

    public final boolean u(Object obj, androidx.media3.common.m0 m0Var) {
        int iC = m0Var.h(obj, this.f10067a).c();
        int iP = this.f10067a.p();
        return iC > 0 && this.f10067a.s(iP) && (iC > 1 || this.f10067a.f(iP) != Long.MIN_VALUE);
    }

    public final boolean v(androidx.media3.exoplayer.source.l.b bVar) {
        return !bVar.b() && bVar.f11213e == -1;
    }

    public final boolean w(androidx.media3.common.m0 m0Var, androidx.media3.exoplayer.source.l.b bVar, boolean z11) {
        int iB = m0Var.b(bVar.f11209a);
        return !m0Var.n(m0Var.f(iB, this.f10067a).f9295c, this.f10068b).f9317i && m0Var.r(iB, this.f10067a, this.f10068b, this.f10073g, this.f10074h) && z11;
    }

    public final boolean x(androidx.media3.common.m0 m0Var, androidx.media3.exoplayer.source.l.b bVar) {
        if (v(bVar)) {
            return m0Var.n(m0Var.h(bVar.f11209a, this.f10067a).f9295c, this.f10068b).f9324p == m0Var.b(bVar.f11209a);
        }
        return false;
    }

    public boolean y(androidx.media3.exoplayer.source.k kVar) {
        z1 z1Var = this.f10077k;
        return z1Var != null && z1Var.f11770a == kVar;
    }
}
