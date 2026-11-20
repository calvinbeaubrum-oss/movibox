package com.applovin.impl;

import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.SurfaceView;
import android.view.TextureView;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class c8 extends d2 {
    private jj A;
    private wj B;
    private boolean C;
    private qh.b D;
    private vd E;
    private vd F;
    private oh G;
    private int H;
    private int I;
    private long J;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final wo f18116b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final qh.b f18117c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final qi[] f18118d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final vo f18119e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ja f18120f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final e8.f f18121g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final e8 f18122h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final hc f18123i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final CopyOnWriteArraySet f18124j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final fo.b f18125k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final List f18126l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final boolean f18127m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final de f18128n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final r0 f18129o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Looper f18130p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final y1 f18131q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final long f18132r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final long f18133s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final l3 f18134t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f18135u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f18136v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f18137w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f18138x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f18139y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f18140z;

    /* JADX INFO: compiled from: source.java */
    public static final class a implements ee {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f18141a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private fo f18142b;

        public a(Object obj, fo foVar) {
            this.f18141a = obj;
            this.f18142b = foVar;
        }

        @Override // com.applovin.impl.ee
        public Object a() {
            return this.f18141a;
        }

        @Override // com.applovin.impl.ee
        public fo b() {
            return this.f18142b;
        }
    }

    public c8(qi[] qiVarArr, vo voVar, de deVar, lc lcVar, y1 y1Var, r0 r0Var, boolean z11, jj jjVar, long j11, long j12, kc kcVar, long j13, boolean z12, l3 l3Var, Looper looper, qh qhVar, qh.b bVar) {
        pc.c("ExoPlayerImpl", "Init " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.15.1] [" + xp.f24376e + "]");
        b1.b(qiVarArr.length > 0);
        this.f18118d = (qi[]) b1.a(qiVarArr);
        this.f18119e = (vo) b1.a(voVar);
        this.f18128n = deVar;
        this.f18131q = y1Var;
        this.f18129o = r0Var;
        this.f18127m = z11;
        this.A = jjVar;
        this.f18132r = j11;
        this.f18133s = j12;
        this.C = z12;
        this.f18130p = looper;
        this.f18134t = l3Var;
        this.f18135u = 0;
        final qh qhVar2 = qhVar != null ? qhVar : this;
        this.f18123i = new hc(looper, l3Var, new hc.b() { // from class: com.applovin.impl.st
            @Override // com.applovin.impl.hc.b
            public final void a(Object obj, b9 b9Var) {
                c8.a(qhVar2, (qh.c) obj, b9Var);
            }
        });
        this.f18124j = new CopyOnWriteArraySet();
        this.f18126l = new ArrayList();
        this.B = new wj.a(0);
        wo woVar = new wo(new si[qiVarArr.length], new h8[qiVarArr.length], null);
        this.f18116b = woVar;
        this.f18125k = new fo.b();
        qh.b bVarA = new qh.b.a().a(1, 2, 12, 13, 14, 15, 16, 17, 18, 19).a(28, voVar.b()).a(bVar).a();
        this.f18117c = bVarA;
        this.D = new qh.b.a().a(bVarA).a(3).a(9).a();
        vd vdVar = vd.H;
        this.E = vdVar;
        this.F = vdVar;
        this.H = -1;
        this.f18120f = l3Var.a(looper, null);
        e8.f fVar = new e8.f() { // from class: com.applovin.impl.du
            @Override // com.applovin.impl.e8.f
            public final void a(e8.e eVar) {
                this.f18509a.c(eVar);
            }
        };
        this.f18121g = fVar;
        this.G = oh.a(woVar);
        if (r0Var != null) {
            r0Var.a(qhVar2, looper);
            b((qh.e) r0Var);
            y1Var.a(new Handler(looper), r0Var);
        }
        this.f18122h = new e8(qiVarArr, voVar, woVar, lcVar, y1Var, this.f18135u, this.f18136v, r0Var, jjVar, kcVar, j13, z12, looper, l3Var, fVar);
    }

    private fo R() {
        return new sh(this.f18126l, this.B);
    }

    private int U() {
        if (this.G.f21534a.c()) {
            return this.H;
        }
        oh ohVar = this.G;
        return ohVar.f21534a.a(ohVar.f21535b.f24653a, this.f18125k).f19033c;
    }

    private void X() {
        qh.b bVar = this.D;
        qh.b bVarA = a(this.f18117c);
        this.D = bVarA;
        if (bVarA.equals(bVar)) {
            return;
        }
        this.f18123i.a(13, new hc.a() { // from class: com.applovin.impl.hu
            @Override // com.applovin.impl.hc.a
            public final void a(Object obj) {
                this.f19543a.d((qh.c) obj);
            }
        });
    }

    private long a(fo foVar, be.a aVar, long j11) {
        foVar.a(aVar.f24653a, this.f18125k);
        return j11 + this.f18125k.e();
    }

    private long a(oh ohVar) {
        if (ohVar.f21534a.c()) {
            return t2.a(this.J);
        }
        return ohVar.f21535b.a() ? ohVar.f21552s : a(ohVar.f21534a, ohVar.f21535b, ohVar.f21552s);
    }

    private Pair a(fo foVar, int i11, long j11) {
        if (foVar.c()) {
            this.H = i11;
            if (j11 == C.TIME_UNSET) {
                j11 = 0;
            }
            this.J = j11;
            this.I = 0;
            return null;
        }
        if (i11 == -1 || i11 >= foVar.b()) {
            i11 = foVar.a(this.f18136v);
            j11 = foVar.a(i11, this.f18341a).b();
        }
        return foVar.a(this.f18341a, this.f18125k, i11, t2.a(j11));
    }

    private Pair a(fo foVar, fo foVar2) {
        long jG = g();
        if (foVar.c() || foVar2.c()) {
            boolean z11 = !foVar.c() && foVar2.c();
            int iU = z11 ? -1 : U();
            if (z11) {
                jG = -9223372036854775807L;
            }
            return a(foVar2, iU, jG);
        }
        Pair pairA = foVar.a(this.f18341a, this.f18125k, t(), t2.a(jG));
        Object obj = ((Pair) xp.a(pairA)).first;
        if (foVar2.a(obj) != -1) {
            return pairA;
        }
        Object objA = e8.a(this.f18341a, this.f18125k, this.f18135u, this.f18136v, obj, foVar, foVar2);
        if (objA == null) {
            return a(foVar2, -1, C.TIME_UNSET);
        }
        foVar2.a(objA, this.f18125k);
        int i11 = this.f18125k.f19033c;
        return a(foVar2, i11, foVar2.a(i11, this.f18341a).b());
    }

    private Pair a(oh ohVar, oh ohVar2, boolean z11, int i11, boolean z12) {
        fo foVar = ohVar2.f21534a;
        fo foVar2 = ohVar.f21534a;
        if (foVar2.c() && foVar.c()) {
            return new Pair(Boolean.FALSE, -1);
        }
        int i12 = 3;
        if (foVar2.c() != foVar.c()) {
            return new Pair(Boolean.TRUE, 3);
        }
        if (foVar.a(foVar.a(ohVar2.f21535b.f24653a, this.f18125k).f19033c, this.f18341a).f19046a.equals(foVar2.a(foVar2.a(ohVar.f21535b.f24653a, this.f18125k).f19033c, this.f18341a).f19046a)) {
            return (z11 && i11 == 0 && ohVar2.f21535b.f24656d < ohVar.f21535b.f24656d) ? new Pair(Boolean.TRUE, 0) : new Pair(Boolean.FALSE, -1);
        }
        if (z11 && i11 == 0) {
            i12 = 1;
        } else if (z11 && i11 == 1) {
            i12 = 2;
        } else if (!z12) {
            throw new IllegalStateException();
        }
        return new Pair(Boolean.TRUE, Integer.valueOf(i12));
    }

    private oh a(int i11, int i12) {
        b1.a(i11 >= 0 && i12 >= i11 && i12 <= this.f18126l.size());
        int iT = t();
        fo foVarN = n();
        int size = this.f18126l.size();
        this.f18137w++;
        b(i11, i12);
        fo foVarR = R();
        oh ohVarA = a(this.G, foVarR, a(foVarN, foVarR));
        int i13 = ohVarA.f21538e;
        if (i13 != 1 && i13 != 4 && i11 < i12 && i12 == size && iT >= ohVarA.f21534a.b()) {
            ohVarA = ohVarA.a(4);
        }
        this.f18122h.b(i11, i12, this.B);
        return ohVarA;
    }

    private oh a(oh ohVar, fo foVar, Pair pair) {
        oh ohVarA;
        b1.a(foVar.c() || pair != null);
        fo foVar2 = ohVar.f21534a;
        oh ohVarA2 = ohVar.a(foVar);
        if (foVar.c()) {
            be.a aVarA = oh.a();
            long jA = t2.a(this.J);
            oh ohVarA3 = ohVarA2.a(aVarA, jA, jA, jA, 0L, po.f21808d, this.f18116b, eb.h()).a(aVarA);
            ohVarA3.f21550q = ohVarA3.f21552s;
            return ohVarA3;
        }
        Object obj = ohVarA2.f21535b.f24653a;
        boolean z11 = !obj.equals(((Pair) xp.a(pair)).first);
        be.a aVar = z11 ? new be.a(pair.first) : ohVarA2.f21535b;
        long jLongValue = ((Long) pair.second).longValue();
        long jA2 = t2.a(g());
        if (!foVar2.c()) {
            jA2 -= foVar2.a(obj, this.f18125k).e();
        }
        if (z11 || jLongValue < jA2) {
            b1.b(!aVar.a());
            oh ohVarA4 = ohVarA2.a(r0, jLongValue, jLongValue, jLongValue, 0L, z11 ? po.f21808d : ohVarA2.f21541h, z11 ? this.f18116b : ohVarA2.f21542i, z11 ? eb.h() : ohVarA2.f21543j).a(aVar);
            ohVarA4.f21550q = jLongValue;
            return ohVarA4;
        }
        if (jLongValue == jA2) {
            int iA = foVar.a(ohVarA2.f21544k.f24653a);
            if (iA != -1 && foVar.a(iA, this.f18125k).f19033c == foVar.a(aVar.f24653a, this.f18125k).f19033c) {
                return ohVarA2;
            }
            foVar.a(aVar.f24653a, this.f18125k);
            long jA3 = aVar.a() ? this.f18125k.a(aVar.f24654b, aVar.f24655c) : this.f18125k.f19034d;
            ohVarA = ohVarA2.a(aVar, ohVarA2.f21552s, ohVarA2.f21552s, ohVarA2.f21537d, jA3 - ohVarA2.f21552s, ohVarA2.f21541h, ohVarA2.f21542i, ohVarA2.f21543j).a(aVar);
            ohVarA.f21550q = jA3;
        } else {
            b1.b(!aVar.a());
            long jMax = Math.max(0L, ohVarA2.f21551r - (jLongValue - jA2));
            long j11 = ohVarA2.f21550q;
            if (ohVarA2.f21544k.equals(ohVarA2.f21535b)) {
                j11 = jLongValue + jMax;
            }
            ohVarA = ohVarA2.a(aVar, jLongValue, jLongValue, jLongValue, jMax, ohVarA2.f21541h, ohVarA2.f21542i, ohVarA2.f21543j);
            ohVarA.f21550q = j11;
        }
        return ohVarA;
    }

    private qh.f a(int i11, oh ohVar, int i12) {
        int i13;
        Object obj;
        td tdVar;
        Object obj2;
        int i14;
        long jB;
        long jA;
        long jB2;
        long j11;
        fo.b bVar = new fo.b();
        if (ohVar.f21534a.c()) {
            i13 = i12;
            obj = null;
            tdVar = null;
            obj2 = null;
            i14 = -1;
        } else {
            Object obj3 = ohVar.f21535b.f24653a;
            ohVar.f21534a.a(obj3, bVar);
            int i15 = bVar.f19033c;
            int iA = ohVar.f21534a.a(obj3);
            Object obj4 = ohVar.f21534a.a(i15, this.f18341a).f19046a;
            tdVar = this.f18341a.f19048c;
            obj2 = obj3;
            i14 = iA;
            obj = obj4;
            i13 = i15;
        }
        if (i11 == 0) {
            jB = bVar.f19035f + bVar.f19034d;
            if (ohVar.f21535b.a()) {
                be.a aVar = ohVar.f21535b;
                jA = bVar.a(aVar.f24654b, aVar.f24655c);
                jB2 = b(ohVar);
                long j12 = jB2;
                j11 = jA;
                jB = j12;
            } else {
                if (ohVar.f21535b.f24657e != -1 && this.G.f21535b.a()) {
                    jB = b(this.G);
                }
                j11 = jB;
            }
        } else if (ohVar.f21535b.a()) {
            jA = ohVar.f21552s;
            jB2 = b(ohVar);
            long j13 = jB2;
            j11 = jA;
            jB = j13;
        } else {
            jB = bVar.f19035f + ohVar.f21552s;
            j11 = jB;
        }
        long jB3 = t2.b(j11);
        long jB4 = t2.b(jB);
        be.a aVar2 = ohVar.f21535b;
        return new qh.f(obj, i13, tdVar, obj2, i14, jB3, jB4, aVar2.f24654b, aVar2.f24655c);
    }

    private List a(int i11, List list) {
        ArrayList arrayList = new ArrayList();
        for (int i12 = 0; i12 < list.size(); i12++) {
            fe.c cVar = new fe.c((be) list.get(i12), this.f18127m);
            arrayList.add(cVar);
            this.f18126l.add(i12 + i11, new a(cVar.f18986b, cVar.f18985a.i()));
        }
        this.B = this.B.b(i11, arrayList.size());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(int i11, qh.f fVar, qh.f fVar2, qh.c cVar) {
        cVar.e(i11);
        cVar.a(fVar, fVar2, i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(e8.e eVar) {
        long j11;
        boolean z11;
        long jA;
        int i11 = this.f18137w - eVar.f18641c;
        this.f18137w = i11;
        boolean z12 = true;
        if (eVar.f18642d) {
            this.f18138x = eVar.f18643e;
            this.f18139y = true;
        }
        if (eVar.f18644f) {
            this.f18140z = eVar.f18645g;
        }
        if (i11 == 0) {
            fo foVar = eVar.f18640b.f21534a;
            if (!this.G.f21534a.c() && foVar.c()) {
                this.H = -1;
                this.J = 0L;
                this.I = 0;
            }
            if (!foVar.c()) {
                List listD = ((sh) foVar).d();
                b1.b(listD.size() == this.f18126l.size());
                for (int i12 = 0; i12 < listD.size(); i12++) {
                    ((a) this.f18126l.get(i12)).f18142b = (fo) listD.get(i12);
                }
            }
            if (this.f18139y) {
                if (eVar.f18640b.f21535b.equals(this.G.f21535b) && eVar.f18640b.f21537d == this.G.f21552s) {
                    z12 = false;
                }
                if (z12) {
                    if (foVar.c() || eVar.f18640b.f21535b.a()) {
                        jA = eVar.f18640b.f21537d;
                    } else {
                        oh ohVar = eVar.f18640b;
                        jA = a(foVar, ohVar.f21535b, ohVar.f21537d);
                    }
                    j11 = jA;
                } else {
                    j11 = -9223372036854775807L;
                }
                z11 = z12;
            } else {
                j11 = -9223372036854775807L;
                z11 = false;
            }
            this.f18139y = false;
            a(eVar.f18640b, 1, this.f18140z, false, z11, this.f18138x, j11, -1);
        }
    }

    private void a(final oh ohVar, final int i11, final int i12, boolean z11, boolean z12, final int i13, long j11, int i14) {
        oh ohVar2 = this.G;
        this.G = ohVar;
        Pair pairA = a(ohVar, ohVar2, z12, i13, !ohVar2.f21534a.equals(ohVar.f21534a));
        boolean zBooleanValue = ((Boolean) pairA.first).booleanValue();
        final int iIntValue = ((Integer) pairA.second).intValue();
        vd vdVarA = this.E;
        final td tdVar = null;
        if (zBooleanValue) {
            if (!ohVar.f21534a.c()) {
                tdVar = ohVar.f21534a.a(ohVar.f21534a.a(ohVar.f21535b.f24653a, this.f18125k).f19033c, this.f18341a).f19048c;
            }
            vdVarA = tdVar != null ? tdVar.f23249d : vd.H;
        }
        if (!ohVar2.f21543j.equals(ohVar.f21543j)) {
            vdVarA = vdVarA.a().a(ohVar.f21543j).a();
        }
        boolean z13 = !vdVarA.equals(this.E);
        this.E = vdVarA;
        if (!ohVar2.f21534a.equals(ohVar.f21534a)) {
            this.f18123i.a(0, new hc.a() { // from class: com.applovin.impl.lu
                @Override // com.applovin.impl.hc.a
                public final void a(Object obj) {
                    c8.b(ohVar, i11, (qh.c) obj);
                }
            });
        }
        if (z12) {
            final qh.f fVarA = a(i13, ohVar2, i14);
            final qh.f fVarD = d(j11);
            this.f18123i.a(11, new hc.a() { // from class: com.applovin.impl.vt
                @Override // com.applovin.impl.hc.a
                public final void a(Object obj) {
                    c8.a(i13, fVarA, fVarD, (qh.c) obj);
                }
            });
        }
        if (zBooleanValue) {
            this.f18123i.a(1, new hc.a() { // from class: com.applovin.impl.wt
                @Override // com.applovin.impl.hc.a
                public final void a(Object obj) {
                    ((qh.c) obj).a(tdVar, iIntValue);
                }
            });
        }
        if (ohVar2.f21539f != ohVar.f21539f) {
            this.f18123i.a(10, new hc.a() { // from class: com.applovin.impl.xt
                @Override // com.applovin.impl.hc.a
                public final void a(Object obj) {
                    c8.a(ohVar, (qh.c) obj);
                }
            });
            if (ohVar.f21539f != null) {
                this.f18123i.a(10, new hc.a() { // from class: com.applovin.impl.yt
                    @Override // com.applovin.impl.hc.a
                    public final void a(Object obj) {
                        c8.b(ohVar, (qh.c) obj);
                    }
                });
            }
        }
        wo woVar = ohVar2.f21542i;
        wo woVar2 = ohVar.f21542i;
        if (woVar != woVar2) {
            this.f18119e.a(woVar2.f24153d);
            final to toVar = new to(ohVar.f21542i.f24152c);
            this.f18123i.a(2, new hc.a() { // from class: com.applovin.impl.zt
                @Override // com.applovin.impl.hc.a
                public final void a(Object obj) {
                    c8.a(ohVar, toVar, (qh.c) obj);
                }
            });
        }
        if (z13) {
            final vd vdVar = this.E;
            this.f18123i.a(14, new hc.a() { // from class: com.applovin.impl.au
                @Override // com.applovin.impl.hc.a
                public final void a(Object obj) {
                    ((qh.c) obj).a(vdVar);
                }
            });
        }
        if (ohVar2.f21540g != ohVar.f21540g) {
            this.f18123i.a(3, new hc.a() { // from class: com.applovin.impl.bu
                @Override // com.applovin.impl.hc.a
                public final void a(Object obj) {
                    c8.c(ohVar, (qh.c) obj);
                }
            });
        }
        if (ohVar2.f21538e != ohVar.f21538e || ohVar2.f21545l != ohVar.f21545l) {
            this.f18123i.a(-1, new hc.a() { // from class: com.applovin.impl.cu
                @Override // com.applovin.impl.hc.a
                public final void a(Object obj) {
                    c8.d(ohVar, (qh.c) obj);
                }
            });
        }
        if (ohVar2.f21538e != ohVar.f21538e) {
            this.f18123i.a(4, new hc.a() { // from class: com.applovin.impl.eu
                @Override // com.applovin.impl.hc.a
                public final void a(Object obj) {
                    c8.e(ohVar, (qh.c) obj);
                }
            });
        }
        if (ohVar2.f21545l != ohVar.f21545l) {
            this.f18123i.a(5, new hc.a() { // from class: com.applovin.impl.mu
                @Override // com.applovin.impl.hc.a
                public final void a(Object obj) {
                    c8.a(ohVar, i12, (qh.c) obj);
                }
            });
        }
        if (ohVar2.f21546m != ohVar.f21546m) {
            this.f18123i.a(6, new hc.a() { // from class: com.applovin.impl.nu
                @Override // com.applovin.impl.hc.a
                public final void a(Object obj) {
                    c8.f(ohVar, (qh.c) obj);
                }
            });
        }
        if (c(ohVar2) != c(ohVar)) {
            this.f18123i.a(7, new hc.a() { // from class: com.applovin.impl.ou
                @Override // com.applovin.impl.hc.a
                public final void a(Object obj) {
                    c8.g(ohVar, (qh.c) obj);
                }
            });
        }
        if (!ohVar2.f21547n.equals(ohVar.f21547n)) {
            this.f18123i.a(12, new hc.a() { // from class: com.applovin.impl.tt
                @Override // com.applovin.impl.hc.a
                public final void a(Object obj) {
                    c8.h(ohVar, (qh.c) obj);
                }
            });
        }
        if (z11) {
            this.f18123i.a(-1, new hc.a() { // from class: com.applovin.impl.ut
                @Override // com.applovin.impl.hc.a
                public final void a(Object obj) {
                    ((qh.c) obj).b();
                }
            });
        }
        X();
        this.f18123i.a();
        if (ohVar2.f21548o != ohVar.f21548o) {
            Iterator it = this.f18124j.iterator();
            while (it.hasNext()) {
                ((b8) it.next()).f(ohVar.f21548o);
            }
        }
        if (ohVar2.f21549p != ohVar.f21549p) {
            Iterator it2 = this.f18124j.iterator();
            while (it2.hasNext()) {
                ((b8) it2.next()).g(ohVar.f21549p);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(oh ohVar, int i11, qh.c cVar) {
        cVar.a(ohVar.f21545l, i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(oh ohVar, qh.c cVar) {
        cVar.b(ohVar.f21539f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(oh ohVar, to toVar, qh.c cVar) {
        cVar.a(ohVar.f21541h, toVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(qh qhVar, qh.c cVar, b9 b9Var) {
        cVar.a(qhVar, new qh.d(b9Var));
    }

    private void a(List list, int i11, long j11, boolean z11) {
        int i12;
        long j12;
        int iU = U();
        long currentPosition = getCurrentPosition();
        this.f18137w++;
        if (!this.f18126l.isEmpty()) {
            b(0, this.f18126l.size());
        }
        List listA = a(0, list);
        fo foVarR = R();
        if (!foVarR.c() && i11 >= foVarR.b()) {
            throw new bb(foVarR, i11, j11);
        }
        if (z11) {
            int iA = foVarR.a(this.f18136v);
            j12 = C.TIME_UNSET;
            i12 = iA;
        } else if (i11 == -1) {
            i12 = iU;
            j12 = currentPosition;
        } else {
            i12 = i11;
            j12 = j11;
        }
        oh ohVarA = a(this.G, foVarR, a(foVarR, i12, j12));
        int i13 = ohVarA.f21538e;
        if (i12 != -1 && i13 != 1) {
            i13 = (foVarR.c() || i12 >= foVarR.b()) ? 4 : 2;
        }
        oh ohVarA2 = ohVarA.a(i13);
        this.f18122h.a(listA, i12, t2.a(j12), this.B);
        a(ohVarA2, 0, 1, false, (this.G.f21535b.f24653a.equals(ohVarA2.f21535b.f24653a) || this.G.f21534a.c()) ? false : true, 4, a(ohVarA2), -1);
    }

    private static long b(oh ohVar) {
        fo.d dVar = new fo.d();
        fo.b bVar = new fo.b();
        ohVar.f21534a.a(ohVar.f21535b.f24653a, bVar);
        return ohVar.f21536c == C.TIME_UNSET ? ohVar.f21534a.a(bVar.f19033c, dVar).c() : bVar.e() + ohVar.f21536c;
    }

    private void b(int i11, int i12) {
        for (int i13 = i12 - 1; i13 >= i11; i13--) {
            this.f18126l.remove(i13);
        }
        this.B = this.B.a(i11, i12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(oh ohVar, int i11, qh.c cVar) {
        cVar.a(ohVar.f21534a, i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(oh ohVar, qh.c cVar) {
        cVar.a(ohVar.f21539f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(qh.c cVar) {
        cVar.a(this.E);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(final e8.e eVar) {
        this.f18120f.a(new Runnable() { // from class: com.applovin.impl.gu
            @Override // java.lang.Runnable
            public final void run() {
                this.f19300a.b(eVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(oh ohVar, qh.c cVar) {
        cVar.e(ohVar.f21540g);
        cVar.c(ohVar.f21540g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(qh.c cVar) {
        cVar.a(a8.a(new g8(1), 1003));
    }

    private static boolean c(oh ohVar) {
        return ohVar.f21538e == 3 && ohVar.f21545l && ohVar.f21546m == 0;
    }

    private qh.f d(long j11) {
        Object obj;
        td tdVar;
        Object obj2;
        int iA;
        int iT = t();
        if (this.G.f21534a.c()) {
            obj = null;
            tdVar = null;
            obj2 = null;
            iA = -1;
        } else {
            oh ohVar = this.G;
            Object obj3 = ohVar.f21535b.f24653a;
            ohVar.f21534a.a(obj3, this.f18125k);
            iA = this.G.f21534a.a(obj3);
            obj2 = obj3;
            obj = this.G.f21534a.a(iT, this.f18341a).f19046a;
            tdVar = this.f18341a.f19048c;
        }
        long jB = t2.b(j11);
        long jB2 = this.G.f21535b.a() ? t2.b(b(this.G)) : jB;
        be.a aVar = this.G.f21535b;
        return new qh.f(obj, iT, tdVar, obj2, iA, jB, jB2, aVar.f24654b, aVar.f24655c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(oh ohVar, qh.c cVar) {
        cVar.b(ohVar.f21545l, ohVar.f21538e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(qh.c cVar) {
        cVar.a(this.D);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(oh ohVar, qh.c cVar) {
        cVar.b(ohVar.f21538e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(oh ohVar, qh.c cVar) {
        cVar.a(ohVar.f21546m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g(oh ohVar, qh.c cVar) {
        cVar.d(c(ohVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h(oh ohVar, qh.c cVar) {
        cVar.a(ohVar.f21547n);
    }

    @Override // com.applovin.impl.qh
    public to A() {
        return new to(this.G.f21542i.f24152c);
    }

    @Override // com.applovin.impl.qh
    public vd C() {
        return this.E;
    }

    @Override // com.applovin.impl.qh
    public int E() {
        if (d()) {
            return this.G.f21535b.f24654b;
        }
        return -1;
    }

    @Override // com.applovin.impl.qh
    public long F() {
        return this.f18132r;
    }

    public boolean S() {
        return this.G.f21549p;
    }

    @Override // com.applovin.impl.qh
    /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
    public eb x() {
        return eb.h();
    }

    @Override // com.applovin.impl.qh
    /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
    public a8 c() {
        return this.G.f21539f;
    }

    public void W() {
        pc.c("ExoPlayerImpl", "Release " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.15.1] [" + xp.f24376e + "] [" + f8.a() + "]");
        if (!this.f18122h.x()) {
            this.f18123i.b(10, new hc.a() { // from class: com.applovin.impl.ku
                @Override // com.applovin.impl.hc.a
                public final void a(Object obj) {
                    c8.c((qh.c) obj);
                }
            });
        }
        this.f18123i.b();
        this.f18120f.a((Object) null);
        r0 r0Var = this.f18129o;
        if (r0Var != null) {
            this.f18131q.a(r0Var);
        }
        oh ohVarA = this.G.a(1);
        this.G = ohVarA;
        oh ohVarA2 = ohVarA.a(ohVarA.f21535b);
        this.G = ohVarA2;
        ohVarA2.f21550q = ohVarA2.f21552s;
        this.G.f21551r = 0L;
    }

    @Override // com.applovin.impl.qh
    public ph a() {
        return this.G.f21547n;
    }

    public rh a(rh.b bVar) {
        return new rh(this.f18122h, bVar, this.G.f21534a, t(), this.f18134t, this.f18122h.g());
    }

    @Override // com.applovin.impl.qh
    public void a(final int i11) {
        if (this.f18135u != i11) {
            this.f18135u = i11;
            this.f18122h.a(i11);
            this.f18123i.a(8, new hc.a() { // from class: com.applovin.impl.fu
                @Override // com.applovin.impl.hc.a
                public final void a(Object obj) {
                    ((qh.c) obj).c(i11);
                }
            });
            X();
            this.f18123i.a();
        }
    }

    @Override // com.applovin.impl.qh
    public void a(int i11, long j11) {
        fo foVar = this.G.f21534a;
        if (i11 < 0 || (!foVar.c() && i11 >= foVar.b())) {
            throw new bb(foVar, i11, j11);
        }
        this.f18137w++;
        if (d()) {
            pc.d("ExoPlayerImpl", "seekTo ignored because an ad is playing");
            e8.e eVar = new e8.e(this.G);
            eVar.a(1);
            this.f18121g.a(eVar);
            return;
        }
        int i12 = o() != 1 ? 2 : 1;
        int iT = t();
        oh ohVarA = a(this.G.a(i12), foVar, a(foVar, i11, j11));
        this.f18122h.a(foVar, i11, t2.a(j11));
        a(ohVarA, 0, 1, true, true, 1, a(ohVarA), iT);
    }

    @Override // com.applovin.impl.qh
    public void a(SurfaceView surfaceView) {
    }

    @Override // com.applovin.impl.qh
    public void a(TextureView textureView) {
    }

    public void a(b8 b8Var) {
        this.f18124j.add(b8Var);
    }

    public void a(be beVar) {
        a(Collections.singletonList(beVar));
    }

    public void a(bf bfVar) {
        vd vdVarA = this.E.a().a(bfVar).a();
        if (vdVarA.equals(this.E)) {
            return;
        }
        this.E = vdVarA;
        this.f18123i.b(14, new hc.a() { // from class: com.applovin.impl.ju
            @Override // com.applovin.impl.hc.a
            public final void a(Object obj) {
                this.f20030a.b((qh.c) obj);
            }
        });
    }

    public void a(qh.c cVar) {
        this.f18123i.a(cVar);
    }

    @Override // com.applovin.impl.qh
    public void a(qh.e eVar) {
        e(eVar);
    }

    public void a(List list) {
        a(list, true);
    }

    public void a(List list, boolean z11) {
        a(list, -1, C.TIME_UNSET, z11);
    }

    @Override // com.applovin.impl.qh
    public void a(boolean z11) {
        a(z11, 0, 1);
    }

    public void a(boolean z11, int i11, int i12) {
        oh ohVar = this.G;
        if (ohVar.f21545l == z11 && ohVar.f21546m == i11) {
            return;
        }
        this.f18137w++;
        oh ohVarA = ohVar.a(z11, i11);
        this.f18122h.a(z11, i11);
        a(ohVarA, 0, i12, false, false, 5, C.TIME_UNSET, -1);
    }

    public void a(boolean z11, a8 a8Var) {
        oh ohVarA;
        if (z11) {
            ohVarA = a(0, this.f18126l.size()).a((a8) null);
        } else {
            oh ohVar = this.G;
            ohVarA = ohVar.a(ohVar.f21535b);
            ohVarA.f21550q = ohVarA.f21552s;
            ohVarA.f21551r = 0L;
        }
        oh ohVarA2 = ohVarA.a(1);
        if (a8Var != null) {
            ohVarA2 = ohVarA2.a(a8Var);
        }
        oh ohVar2 = ohVarA2;
        this.f18137w++;
        this.f18122h.G();
        a(ohVar2, 0, 1, false, ohVar2.f21534a.c() && !this.G.f21534a.c(), 4, a(ohVar2), -1);
    }

    @Override // com.applovin.impl.qh
    public void b() {
        oh ohVar = this.G;
        if (ohVar.f21538e != 1) {
            return;
        }
        oh ohVarA = ohVar.a((a8) null);
        oh ohVarA2 = ohVarA.a(ohVarA.f21534a.c() ? 4 : 2);
        this.f18137w++;
        this.f18122h.v();
        a(ohVarA2, 1, 1, false, false, 5, C.TIME_UNSET, -1);
    }

    @Override // com.applovin.impl.qh
    public void b(SurfaceView surfaceView) {
    }

    @Override // com.applovin.impl.qh
    public void b(TextureView textureView) {
    }

    @Override // com.applovin.impl.qh
    public void b(qh.e eVar) {
        a((qh.c) eVar);
    }

    @Override // com.applovin.impl.qh
    public void b(final boolean z11) {
        if (this.f18136v != z11) {
            this.f18136v = z11;
            this.f18122h.f(z11);
            this.f18123i.a(9, new hc.a() { // from class: com.applovin.impl.iu
                @Override // com.applovin.impl.hc.a
                public final void a(Object obj) {
                    ((qh.c) obj).b(z11);
                }
            });
            X();
            this.f18123i.a();
        }
    }

    public void c(long j11) {
        this.f18122h.a(j11);
    }

    @Override // com.applovin.impl.qh
    public boolean d() {
        return this.G.f21535b.a();
    }

    @Override // com.applovin.impl.qh
    public long e() {
        return this.f18133s;
    }

    public void e(qh.c cVar) {
        this.f18123i.b(cVar);
    }

    @Override // com.applovin.impl.qh
    public int f() {
        if (d()) {
            return this.G.f21535b.f24655c;
        }
        return -1;
    }

    @Override // com.applovin.impl.qh
    public long g() {
        if (!d()) {
            return getCurrentPosition();
        }
        oh ohVar = this.G;
        ohVar.f21534a.a(ohVar.f21535b.f24653a, this.f18125k);
        oh ohVar2 = this.G;
        return ohVar2.f21536c == C.TIME_UNSET ? ohVar2.f21534a.a(t(), this.f18341a).b() : this.f18125k.d() + t2.b(this.G.f21536c);
    }

    @Override // com.applovin.impl.qh
    public long getCurrentPosition() {
        return t2.b(a(this.G));
    }

    @Override // com.applovin.impl.qh
    public long getDuration() {
        if (!d()) {
            return G();
        }
        oh ohVar = this.G;
        be.a aVar = ohVar.f21535b;
        ohVar.f21534a.a(aVar.f24653a, this.f18125k);
        return t2.b(this.f18125k.a(aVar.f24654b, aVar.f24655c));
    }

    @Override // com.applovin.impl.qh
    public long h() {
        return t2.b(this.G.f21551r);
    }

    @Override // com.applovin.impl.qh
    public qh.b i() {
        return this.D;
    }

    @Override // com.applovin.impl.qh
    public int j() {
        return this.G.f21546m;
    }

    @Override // com.applovin.impl.qh
    public po k() {
        return this.G.f21541h;
    }

    @Override // com.applovin.impl.qh
    public boolean l() {
        return this.G.f21545l;
    }

    @Override // com.applovin.impl.qh
    public int m() {
        return this.f18135u;
    }

    @Override // com.applovin.impl.qh
    public fo n() {
        return this.G.f21534a;
    }

    @Override // com.applovin.impl.qh
    public int o() {
        return this.G.f21538e;
    }

    @Override // com.applovin.impl.qh
    public Looper p() {
        return this.f18130p;
    }

    @Override // com.applovin.impl.qh
    public long q() {
        return 3000L;
    }

    @Override // com.applovin.impl.qh
    public boolean r() {
        return this.f18136v;
    }

    @Override // com.applovin.impl.qh
    public long s() {
        if (this.G.f21534a.c()) {
            return this.J;
        }
        oh ohVar = this.G;
        if (ohVar.f21544k.f24656d != ohVar.f21535b.f24656d) {
            return ohVar.f21534a.a(t(), this.f18341a).d();
        }
        long j11 = ohVar.f21550q;
        if (this.G.f21544k.a()) {
            oh ohVar2 = this.G;
            fo.b bVarA = ohVar2.f21534a.a(ohVar2.f21544k.f24653a, this.f18125k);
            long jB = bVarA.b(this.G.f21544k.f24654b);
            j11 = jB == Long.MIN_VALUE ? bVarA.f19034d : jB;
        }
        oh ohVar3 = this.G;
        return t2.b(a(ohVar3.f21534a, ohVar3.f21544k, j11));
    }

    @Override // com.applovin.impl.qh
    public int t() {
        int iU = U();
        if (iU == -1) {
            return 0;
        }
        return iU;
    }

    @Override // com.applovin.impl.qh
    public int v() {
        if (this.G.f21534a.c()) {
            return this.I;
        }
        oh ohVar = this.G;
        return ohVar.f21534a.a(ohVar.f21535b.f24653a);
    }

    @Override // com.applovin.impl.qh
    public xq z() {
        return xq.f24387f;
    }
}
