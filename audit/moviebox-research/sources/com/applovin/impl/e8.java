package com.applovin.impl;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import com.applovin.exoplayer2.common.base.Supplier;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class e8 implements Handler.Callback, wd.a, vo.a, fe.d, h6.a, rh.a {
    private boolean A;
    private boolean B;
    private boolean C;
    private boolean D;
    private boolean E;
    private int F;
    private boolean G;
    private boolean H;
    private boolean I;
    private boolean J;
    private int K;
    private h L;
    private long M;
    private int N;
    private boolean O;
    private a8 P;
    private long Q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final qi[] f18605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set f18606b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ri[] f18607c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final vo f18608d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final wo f18609f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final lc f18610g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final y1 f18611h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ja f18612i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final HandlerThread f18613j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Looper f18614k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final fo.d f18615l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final fo.b f18616m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final long f18617n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final boolean f18618o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final h6 f18619p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final ArrayList f18620q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final l3 f18621r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final f f18622s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final ae f18623t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final fe f18624u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final kc f18625v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final long f18626w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private jj f18627x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private oh f18628y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private e f18629z;

    /* JADX INFO: compiled from: source.java */
    public class a implements qi.a {
        public a() {
        }

        @Override // com.applovin.impl.qi.a
        public void a() {
            e8.this.f18612i.c(2);
        }

        @Override // com.applovin.impl.qi.a
        public void a(long j11) {
            if (j11 >= AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS) {
                e8.this.I = true;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f18631a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final wj f18632b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f18633c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f18634d;

        private b(List list, wj wjVar, int i11, long j11) {
            this.f18631a = list;
            this.f18632b = wjVar;
            this.f18633c = i11;
            this.f18634d = j11;
        }

        public /* synthetic */ b(List list, wj wjVar, int i11, long j11, a aVar) {
            this(list, wjVar, i11, j11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c {
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d implements Comparable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final rh f18635a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f18636b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f18637c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Object f18638d;

        public d(rh rhVar) {
            this.f18635a = rhVar;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(d dVar) {
            Object obj = this.f18638d;
            if ((obj == null) != (dVar.f18638d == null)) {
                return obj != null ? -1 : 1;
            }
            if (obj == null) {
                return 0;
            }
            int i11 = this.f18636b - dVar.f18636b;
            return i11 != 0 ? i11 : xp.a(this.f18637c, dVar.f18637c);
        }

        public void a(int i11, long j11, Object obj) {
            this.f18636b = i11;
            this.f18637c = j11;
            this.f18638d = obj;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f18639a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public oh f18640b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f18641c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f18642d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f18643e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f18644f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f18645g;

        public e(oh ohVar) {
            this.f18640b = ohVar;
        }

        public void a(int i11) {
            this.f18639a |= i11 > 0;
            this.f18641c += i11;
        }

        public void a(oh ohVar) {
            this.f18639a |= this.f18640b != ohVar;
            this.f18640b = ohVar;
        }

        public void b(int i11) {
            this.f18639a = true;
            this.f18644f = true;
            this.f18645g = i11;
        }

        public void c(int i11) {
            if (this.f18642d && this.f18643e != 5) {
                b1.a(i11 == 5);
                return;
            }
            this.f18639a = true;
            this.f18642d = true;
            this.f18643e = i11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface f {
        void a(e eVar);
    }

    /* JADX INFO: compiled from: source.java */
    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final be.a f18646a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f18647b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f18648c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f18649d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f18650e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f18651f;

        public g(be.a aVar, long j11, long j12, boolean z11, boolean z12, boolean z13) {
            this.f18646a = aVar;
            this.f18647b = j11;
            this.f18648c = j12;
            this.f18649d = z11;
            this.f18650e = z12;
            this.f18651f = z13;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final fo f18652a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f18653b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f18654c;

        public h(fo foVar, int i11, long j11) {
            this.f18652a = foVar;
            this.f18653b = i11;
            this.f18654c = j11;
        }
    }

    public e8(qi[] qiVarArr, vo voVar, wo woVar, lc lcVar, y1 y1Var, int i11, boolean z11, r0 r0Var, jj jjVar, kc kcVar, long j11, boolean z12, Looper looper, l3 l3Var, f fVar) {
        this.f18622s = fVar;
        this.f18605a = qiVarArr;
        this.f18608d = voVar;
        this.f18609f = woVar;
        this.f18610g = lcVar;
        this.f18611h = y1Var;
        this.F = i11;
        this.G = z11;
        this.f18627x = jjVar;
        this.f18625v = kcVar;
        this.f18626w = j11;
        this.Q = j11;
        this.B = z12;
        this.f18621r = l3Var;
        this.f18617n = lcVar.d();
        this.f18618o = lcVar.a();
        oh ohVarA = oh.a(woVar);
        this.f18628y = ohVarA;
        this.f18629z = new e(ohVarA);
        this.f18607c = new ri[qiVarArr.length];
        for (int i12 = 0; i12 < qiVarArr.length; i12++) {
            qiVarArr[i12].b(i12);
            this.f18607c[i12] = qiVarArr[i12].n();
        }
        this.f18619p = new h6(this, l3Var);
        this.f18620q = new ArrayList();
        this.f18606b = rj.b();
        this.f18615l = new fo.d();
        this.f18616m = new fo.b();
        voVar.a(this, y1Var);
        this.O = true;
        Handler handler = new Handler(looper);
        this.f18623t = new ae(r0Var, handler);
        this.f18624u = new fe(this, r0Var, handler);
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:Playback", -16);
        this.f18613j = handlerThread;
        handlerThread.start();
        Looper looper2 = handlerThread.getLooper();
        this.f18614k = looper2;
        this.f18612i = l3Var.a(looper2, this);
    }

    private void A() throws a8 {
        float f11 = this.f18619p.a().f21777a;
        xd xdVarF = this.f18623t.f();
        boolean z11 = true;
        for (xd xdVarE = this.f18623t.e(); xdVarE != null && xdVarE.f24298d; xdVarE = xdVarE.d()) {
            wo woVarB = xdVarE.b(f11, this.f18628y.f21534a);
            if (!woVarB.a(xdVarE.i())) {
                if (z11) {
                    xd xdVarE2 = this.f18623t.e();
                    boolean zA = this.f18623t.a(xdVarE2);
                    boolean[] zArr = new boolean[this.f18605a.length];
                    long jA = xdVarE2.a(woVarB, this.f18628y.f21552s, zA, zArr);
                    oh ohVar = this.f18628y;
                    boolean z12 = (ohVar.f21538e == 4 || jA == ohVar.f21552s) ? false : true;
                    oh ohVar2 = this.f18628y;
                    this.f18628y = a(ohVar2.f21535b, jA, ohVar2.f21536c, ohVar2.f21537d, z12, 5);
                    if (z12) {
                        c(jA);
                    }
                    boolean[] zArr2 = new boolean[this.f18605a.length];
                    int i11 = 0;
                    while (true) {
                        qi[] qiVarArr = this.f18605a;
                        if (i11 >= qiVarArr.length) {
                            break;
                        }
                        qi qiVar = qiVarArr[i11];
                        boolean zC = c(qiVar);
                        zArr2[i11] = zC;
                        cj cjVar = xdVarE2.f24297c[i11];
                        if (zC) {
                            if (cjVar != qiVar.o()) {
                                a(qiVar);
                            } else if (zArr[i11]) {
                                qiVar.a(this.M);
                            }
                        }
                        i11++;
                    }
                    a(zArr2);
                } else {
                    this.f18623t.a(xdVarE);
                    if (xdVarE.f24298d) {
                        xdVarE.a(woVarB, Math.max(xdVarE.f24300f.f24836b, xdVarE.d(this.M)), false);
                    }
                }
                a(true);
                if (this.f18628y.f21538e != 4) {
                    m();
                    K();
                    this.f18612i.c(2);
                    return;
                }
                return;
            }
            if (xdVarE == xdVarF) {
                z11 = false;
            }
        }
    }

    private void B() {
        xd xdVarE = this.f18623t.e();
        this.C = xdVarE != null && xdVarE.f24300f.f24842h && this.B;
    }

    private boolean C() {
        xd xdVarE;
        xd xdVarD;
        return E() && !this.C && (xdVarE = this.f18623t.e()) != null && (xdVarD = xdVarE.d()) != null && this.M >= xdVarD.g() && xdVarD.f24301g;
    }

    private boolean D() {
        if (!j()) {
            return false;
        }
        xd xdVarD = this.f18623t.d();
        return this.f18610g.a(xdVarD == this.f18623t.e() ? xdVarD.d(this.M) : xdVarD.d(this.M) - xdVarD.f24300f.f24836b, b(xdVarD.e()), this.f18619p.a().f21777a);
    }

    private boolean E() {
        oh ohVar = this.f18628y;
        return ohVar.f21545l && ohVar.f21546m == 0;
    }

    private void F() {
        this.D = false;
        this.f18619p.b();
        for (qi qiVar : this.f18605a) {
            if (c(qiVar)) {
                qiVar.start();
            }
        }
    }

    private void H() {
        this.f18619p.c();
        for (qi qiVar : this.f18605a) {
            if (c(qiVar)) {
                b(qiVar);
            }
        }
    }

    private void I() {
        xd xdVarD = this.f18623t.d();
        boolean z11 = this.E || (xdVarD != null && xdVarD.f24295a.a());
        oh ohVar = this.f18628y;
        if (z11 != ohVar.f21540g) {
            this.f18628y = ohVar.a(z11);
        }
    }

    private void J() throws a8 {
        if (this.f18628y.f21534a.c() || !this.f18624u.d()) {
            return;
        }
        o();
        q();
        r();
        p();
    }

    private void K() {
        xd xdVarE = this.f18623t.e();
        if (xdVarE == null) {
            return;
        }
        long jH = xdVarE.f24298d ? xdVarE.f24295a.h() : -9223372036854775807L;
        if (jH != C.TIME_UNSET) {
            c(jH);
            if (jH != this.f18628y.f21552s) {
                oh ohVar = this.f18628y;
                this.f18628y = a(ohVar.f21535b, jH, ohVar.f21536c, jH, true, 5);
            }
        } else {
            long jB = this.f18619p.b(xdVarE != this.f18623t.f());
            this.M = jB;
            long jD = xdVarE.d(jB);
            b(this.f18628y.f21552s, jD);
            this.f18628y.f21552s = jD;
        }
        this.f18628y.f21550q = this.f18623t.d().c();
        this.f18628y.f21551r = h();
        oh ohVar2 = this.f18628y;
        if (ohVar2.f21545l && ohVar2.f21538e == 3 && a(ohVar2.f21534a, ohVar2.f21535b) && this.f18628y.f21547n.f21777a == 1.0f) {
            float fA = this.f18625v.a(e(), h());
            if (this.f18619p.a().f21777a != fA) {
                this.f18619p.a(this.f18628y.f21547n.a(fA));
                a(this.f18628y.f21547n, this.f18619p.a().f21777a, false, false);
            }
        }
    }

    private long a(be.a aVar, long j11, boolean z11) {
        return a(aVar, j11, this.f18623t.e() != this.f18623t.f(), z11);
    }

    private long a(be.a aVar, long j11, boolean z11, boolean z12) throws a8 {
        H();
        this.D = false;
        if (z12 || this.f18628y.f21538e == 3) {
            c(2);
        }
        xd xdVarE = this.f18623t.e();
        xd xdVarD = xdVarE;
        while (xdVarD != null && !aVar.equals(xdVarD.f24300f.f24835a)) {
            xdVarD = xdVarD.d();
        }
        if (z11 || xdVarE != xdVarD || (xdVarD != null && xdVarD.e(j11) < 0)) {
            for (qi qiVar : this.f18605a) {
                a(qiVar);
            }
            if (xdVarD != null) {
                while (this.f18623t.e() != xdVarD) {
                    this.f18623t.a();
                }
                this.f18623t.a(xdVarD);
                xdVarD.c(0L);
                d();
            }
        }
        if (xdVarD != null) {
            this.f18623t.a(xdVarD);
            if (!xdVarD.f24298d) {
                xdVarD.f24300f = xdVarD.f24300f.b(j11);
            } else if (xdVarD.f24299e) {
                j11 = xdVarD.f24295a.a(j11);
                xdVarD.f24295a.a(j11 - this.f18617n, this.f18618o);
            }
            c(j11);
            m();
        } else {
            this.f18623t.c();
            c(j11);
        }
        a(false);
        this.f18612i.c(2);
        return j11;
    }

    private long a(fo foVar, Object obj, long j11) {
        foVar.a(foVar.a(obj, this.f18616m).f19033c, this.f18615l);
        fo.d dVar = this.f18615l;
        if (dVar.f19051g != C.TIME_UNSET && dVar.e()) {
            fo.d dVar2 = this.f18615l;
            if (dVar2.f19054j) {
                return t2.a(dVar2.a() - this.f18615l.f19051g) - (j11 + this.f18616m.e());
            }
        }
        return C.TIME_UNSET;
    }

    private Pair a(fo foVar) {
        long jB = 0;
        if (foVar.c()) {
            return Pair.create(oh.a(), 0L);
        }
        Pair pairA = foVar.a(this.f18615l, this.f18616m, foVar.a(this.G), C.TIME_UNSET);
        be.a aVarA = this.f18623t.a(foVar, pairA.first, 0L);
        long jLongValue = ((Long) pairA.second).longValue();
        if (aVarA.a()) {
            foVar.a(aVarA.f24653a, this.f18616m);
            if (aVarA.f24655c == this.f18616m.d(aVarA.f24654b)) {
                jB = this.f18616m.b();
            }
        } else {
            jB = jLongValue;
        }
        return Pair.create(aVarA, Long.valueOf(jB));
    }

    private static Pair a(fo foVar, h hVar, boolean z11, int i11, boolean z12, fo.d dVar, fo.b bVar) {
        Object objA;
        fo foVar2 = hVar.f18652a;
        if (foVar.c()) {
            return null;
        }
        fo foVar3 = foVar2.c() ? foVar : foVar2;
        try {
            Pair pairA = foVar3.a(dVar, bVar, hVar.f18653b, hVar.f18654c);
            if (foVar.equals(foVar3)) {
                return pairA;
            }
            if (foVar.a(pairA.first) != -1) {
                return (foVar3.a(pairA.first, bVar).f19036g && foVar3.a(bVar.f19033c, dVar).f19060p == foVar3.a(pairA.first)) ? foVar.a(dVar, bVar, foVar.a(pairA.first, bVar).f19033c, hVar.f18654c) : pairA;
            }
            if (z11 && (objA = a(dVar, bVar, i11, z12, pairA.first, foVar3, foVar)) != null) {
                return foVar.a(dVar, bVar, foVar.a(objA, bVar).f19033c, C.TIME_UNSET);
            }
            return null;
        } catch (IndexOutOfBoundsException unused) {
        }
    }

    private static g a(fo foVar, oh ohVar, h hVar, ae aeVar, int i11, boolean z11, fo.d dVar, fo.b bVar) {
        be.a aVar;
        int i12;
        int iA;
        int iA2;
        boolean z12;
        boolean z13;
        boolean z14;
        int iA3;
        boolean z15;
        long j11;
        int i13;
        boolean z16;
        if (foVar.c()) {
            return new g(oh.a(), 0L, C.TIME_UNSET, false, true, false);
        }
        be.a aVar2 = ohVar.f21535b;
        Object obj = aVar2.f24653a;
        boolean zA = a(ohVar, bVar);
        long jLongValue = (ohVar.f21535b.a() || zA) ? ohVar.f21536c : ohVar.f21552s;
        boolean z17 = false;
        if (hVar != null) {
            aVar = aVar2;
            i12 = -1;
            Pair pairA = a(foVar, hVar, true, i11, z11, dVar, bVar);
            if (pairA == null) {
                iA2 = foVar.a(z11);
                aVar = aVar;
                z12 = false;
                z13 = true;
                z14 = false;
            } else {
                if (hVar.f18654c == C.TIME_UNSET) {
                    iA2 = foVar.a(pairA.first, bVar).f19033c;
                    jLongValue = jLongValue;
                    z16 = false;
                } else {
                    obj = pairA.first;
                    jLongValue = ((Long) pairA.second).longValue();
                    z16 = true;
                    iA2 = -1;
                }
                z14 = z16;
                z12 = ohVar.f21538e == 4;
                z13 = false;
            }
        } else {
            aVar = aVar2;
            i12 = -1;
            if (ohVar.f21534a.c()) {
                iA3 = foVar.a(z11);
            } else {
                if (foVar.a(obj) == -1) {
                    Object objA = a(dVar, bVar, i11, z11, obj, ohVar.f21534a, foVar);
                    if (objA == null) {
                        iA = foVar.a(z11);
                        aVar = aVar;
                        z15 = true;
                    } else {
                        iA = foVar.a(objA, bVar).f19033c;
                    }
                    iA2 = iA;
                    z13 = z15;
                    z12 = false;
                    z14 = false;
                } else if (jLongValue == C.TIME_UNSET) {
                    iA3 = foVar.a(obj, bVar).f19033c;
                } else if (zA) {
                    aVar = aVar;
                    ohVar.f21534a.a(aVar.f24653a, bVar);
                    if (ohVar.f21534a.a(bVar.f19033c, dVar).f19060p == ohVar.f21534a.a(aVar.f24653a)) {
                        Pair pairA2 = foVar.a(dVar, bVar, foVar.a(obj, bVar).f19033c, jLongValue + bVar.e());
                        obj = pairA2.first;
                        jLongValue = ((Long) pairA2.second).longValue();
                    } else {
                        jLongValue = jLongValue;
                    }
                    iA2 = -1;
                    z12 = false;
                    z13 = false;
                    z14 = true;
                } else {
                    iA = -1;
                }
                z15 = false;
                iA2 = iA;
                z13 = z15;
                z12 = false;
                z14 = false;
            }
            iA2 = iA3;
            aVar = aVar;
            z12 = false;
            z13 = false;
            z14 = false;
        }
        if (iA2 != i12) {
            Pair pairA3 = foVar.a(dVar, bVar, iA2, C.TIME_UNSET);
            obj = pairA3.first;
            jLongValue = ((Long) pairA3.second).longValue();
            j11 = -9223372036854775807L;
        } else {
            j11 = jLongValue;
        }
        be.a aVarA = aeVar.a(foVar, obj, jLongValue);
        boolean z18 = aVarA.f24657e == i12 || ((i13 = aVar.f24657e) != i12 && aVarA.f24654b >= i13);
        boolean zEquals = aVar.f24653a.equals(obj);
        boolean z19 = zEquals && !aVar.a() && !aVarA.a() && z18;
        foVar.a(obj, bVar);
        if (zEquals && !zA && jLongValue == j11 && ((aVarA.a() && bVar.f(aVarA.f24654b)) || (aVar.a() && bVar.f(aVar.f24654b)))) {
            z17 = true;
        }
        if (z19 || z17) {
            aVarA = aVar;
        }
        if (aVarA.a()) {
            if (aVarA.equals(aVar)) {
                jLongValue = ohVar.f21552s;
            } else {
                foVar.a(aVarA.f24653a, bVar);
                jLongValue = aVarA.f24655c == bVar.d(aVarA.f24654b) ? bVar.b() : 0L;
            }
        }
        return new g(aVarA, jLongValue, j11, z12, z13, z14);
    }

    private eb a(h8[] h8VarArr) {
        eb.a aVar = new eb.a();
        boolean z11 = false;
        for (h8 h8Var : h8VarArr) {
            if (h8Var != null) {
                bf bfVar = h8Var.a(0).f18898k;
                if (bfVar == null) {
                    aVar.b(new bf(new bf.b[0]));
                } else {
                    aVar.b(bfVar);
                    z11 = true;
                }
            }
        }
        return z11 ? aVar.a() : eb.h();
    }

    private oh a(be.a aVar, long j11, long j12, long j13, boolean z11, int i11) {
        List listH;
        po poVar;
        wo woVar;
        this.O = (!this.O && j11 == this.f18628y.f21552s && aVar.equals(this.f18628y.f21535b)) ? false : true;
        B();
        oh ohVar = this.f18628y;
        po poVar2 = ohVar.f21541h;
        wo woVar2 = ohVar.f21542i;
        List list = ohVar.f21543j;
        if (this.f18624u.d()) {
            xd xdVarE = this.f18623t.e();
            po poVarH = xdVarE == null ? po.f21808d : xdVarE.h();
            wo woVarI = xdVarE == null ? this.f18609f : xdVarE.i();
            eb ebVarA = a(woVarI.f24152c);
            if (xdVarE != null) {
                zd zdVar = xdVarE.f24300f;
                if (zdVar.f24837c != j12) {
                    xdVarE.f24300f = zdVar.a(j12);
                }
            }
            poVar = poVarH;
            woVar = woVarI;
            listH = ebVarA;
        } else if (aVar.equals(this.f18628y.f21535b)) {
            listH = list;
            poVar = poVar2;
            woVar = woVar2;
        } else {
            poVar = po.f21808d;
            woVar = this.f18609f;
            listH = eb.h();
        }
        if (z11) {
            this.f18629z.c(i11);
        }
        return this.f18628y.a(aVar, j11, j12, j13, h(), poVar, woVar, listH);
    }

    public static Object a(fo.d dVar, fo.b bVar, int i11, boolean z11, Object obj, fo foVar, fo foVar2) {
        int iA = foVar.a(obj);
        int iA2 = foVar.a();
        int iA3 = iA;
        int iA4 = -1;
        for (int i12 = 0; i12 < iA2 && iA4 == -1; i12++) {
            iA3 = foVar.a(iA3, bVar, dVar, i11, z11);
            if (iA3 == -1) {
                break;
            }
            iA4 = foVar2.a(foVar.b(iA3));
        }
        if (iA4 == -1) {
            return null;
        }
        return foVar2.b(iA4);
    }

    private void a(float f11) {
        for (xd xdVarE = this.f18623t.e(); xdVarE != null; xdVarE = xdVarE.d()) {
            for (h8 h8Var : xdVarE.i().f24152c) {
                if (h8Var != null) {
                    h8Var.a(f11);
                }
            }
        }
    }

    private void a(int i11, int i12, wj wjVar) throws Throwable {
        this.f18629z.a(1);
        a(this.f18624u.a(i11, i12, wjVar), false);
    }

    private void a(int i11, boolean z11) throws a8 {
        qi qiVar = this.f18605a[i11];
        if (c(qiVar)) {
            return;
        }
        xd xdVarF = this.f18623t.f();
        boolean z12 = xdVarF == this.f18623t.e();
        wo woVarI = xdVarF.i();
        si siVar = woVarI.f24151b[i11];
        f9[] f9VarArrA = a(woVarI.f24152c[i11]);
        boolean z13 = E() && this.f18628y.f21538e == 3;
        boolean z14 = !z11 && z13;
        this.K++;
        this.f18606b.add(qiVar);
        qiVar.a(siVar, f9VarArrA, xdVarF.f24297c[i11], this.M, z14, z12, xdVarF.g(), xdVarF.f());
        qiVar.a(11, new a());
        this.f18619p.b(qiVar);
        if (z13) {
            qiVar.start();
        }
    }

    private synchronized void a(Supplier supplier, long j11) {
        long jC = this.f18621r.c() + j11;
        boolean z11 = false;
        while (!((Boolean) supplier.get()).booleanValue() && j11 > 0) {
            try {
                this.f18621r.b();
                wait(j11);
            } catch (InterruptedException unused) {
                z11 = true;
            }
            j11 = jC - this.f18621r.c();
        }
        if (z11) {
            Thread.currentThread().interrupt();
        }
    }

    private void a(b bVar) throws Throwable {
        this.f18629z.a(1);
        if (bVar.f18633c != -1) {
            this.L = new h(new sh(bVar.f18631a, bVar.f18632b), bVar.f18633c, bVar.f18634d);
        }
        a(this.f18624u.a(bVar.f18631a, bVar.f18632b), false);
    }

    private void a(b bVar, int i11) throws Throwable {
        this.f18629z.a(1);
        fe feVar = this.f18624u;
        if (i11 == -1) {
            i11 = feVar.c();
        }
        a(feVar.a(i11, bVar.f18631a, bVar.f18632b), false);
    }

    private void a(c cVar) {
        this.f18629z.a(1);
        throw null;
    }

    private void a(h hVar) throws Throwable {
        long j11;
        long j12;
        boolean z11;
        be.a aVar;
        long j13;
        long jA;
        long j14;
        oh ohVar;
        int i11;
        this.f18629z.a(1);
        Pair pairA = a(this.f18628y.f21534a, hVar, true, this.F, this.G, this.f18615l, this.f18616m);
        if (pairA == null) {
            Pair pairA2 = a(this.f18628y.f21534a);
            aVar = (be.a) pairA2.first;
            long jLongValue = ((Long) pairA2.second).longValue();
            z11 = !this.f18628y.f21534a.c();
            j12 = jLongValue;
            j11 = -9223372036854775807L;
        } else {
            Object obj = pairA.first;
            long jLongValue2 = ((Long) pairA.second).longValue();
            j11 = hVar.f18654c == C.TIME_UNSET ? -9223372036854775807L : jLongValue2;
            be.a aVarA = this.f18623t.a(this.f18628y.f21534a, obj, jLongValue2);
            if (aVarA.a()) {
                this.f18628y.f21534a.a(aVarA.f24653a, this.f18616m);
                jLongValue2 = this.f18616m.d(aVarA.f24654b) == aVarA.f24655c ? this.f18616m.b() : 0L;
            } else {
                if (hVar.f18654c != C.TIME_UNSET) {
                    j12 = jLongValue2;
                    z11 = false;
                }
                aVar = aVarA;
            }
            j12 = jLongValue2;
            z11 = true;
            aVar = aVarA;
        }
        try {
            if (!this.f18628y.f21534a.c()) {
                if (pairA == null) {
                    if (this.f18628y.f21538e != 1) {
                        c(4);
                    }
                    a(false, true, false, true);
                } else {
                    if (aVar.equals(this.f18628y.f21535b)) {
                        xd xdVarE = this.f18623t.e();
                        jA = (xdVarE == null || !xdVarE.f24298d || j12 == 0) ? j12 : xdVarE.f24295a.a(j12, this.f18627x);
                        if (t2.b(jA) == t2.b(this.f18628y.f21552s) && ((i11 = (ohVar = this.f18628y).f21538e) == 2 || i11 == 3)) {
                            long j15 = ohVar.f21552s;
                            this.f18628y = a(aVar, j15, j11, j15, z11, 2);
                            return;
                        }
                    } else {
                        jA = j12;
                    }
                    long jA2 = a(aVar, jA, this.f18628y.f21538e == 4);
                    boolean z12 = (j12 != jA2) | z11;
                    try {
                        oh ohVar2 = this.f18628y;
                        fo foVar = ohVar2.f21534a;
                        a(foVar, aVar, foVar, ohVar2.f21535b, j11);
                        z11 = z12;
                        j14 = jA2;
                    } catch (Throwable th2) {
                        th = th2;
                        z11 = z12;
                        j13 = jA2;
                        this.f18628y = a(aVar, j13, j11, j13, z11, 2);
                        throw th;
                    }
                }
                this.f18628y = a(aVar, j14, j11, j14, z11, 2);
            }
            this.L = hVar;
            j14 = j12;
            this.f18628y = a(aVar, j14, j11, j14, z11, 2);
        } catch (Throwable th3) {
            th = th3;
            j13 = j12;
        }
    }

    private void a(fo foVar, be.a aVar, fo foVar2, be.a aVar2, long j11) {
        if (foVar.c() || !a(foVar, aVar)) {
            float f11 = this.f18619p.a().f21777a;
            ph phVar = this.f18628y.f21547n;
            if (f11 != phVar.f21777a) {
                this.f18619p.a(phVar);
                return;
            }
            return;
        }
        foVar.a(foVar.a(aVar.f24653a, this.f18616m).f19033c, this.f18615l);
        this.f18625v.a((td.f) xp.a(this.f18615l.f19056l));
        if (j11 != C.TIME_UNSET) {
            this.f18625v.a(a(foVar, aVar.f24653a, j11));
            return;
        }
        if (xp.a(!foVar2.c() ? foVar2.a(foVar2.a(aVar2.f24653a, this.f18616m).f19033c, this.f18615l).f19046a : null, this.f18615l.f19046a)) {
            return;
        }
        this.f18625v.a(C.TIME_UNSET);
    }

    private static void a(fo foVar, d dVar, fo.d dVar2, fo.b bVar) {
        int i11 = foVar.a(foVar.a(dVar.f18638d, bVar).f19033c, dVar2).f19061q;
        Object obj = foVar.a(i11, bVar, true).f19032b;
        long j11 = bVar.f19034d;
        dVar.a(i11, j11 != C.TIME_UNSET ? j11 - 1 : Long.MAX_VALUE, obj);
    }

    private void a(fo foVar, fo foVar2) {
        if (foVar.c() && foVar2.c()) {
            return;
        }
        for (int size = this.f18620q.size() - 1; size >= 0; size--) {
            if (!a((d) this.f18620q.get(size), foVar, foVar2, this.F, this.G, this.f18615l, this.f18616m)) {
                ((d) this.f18620q.get(size)).f18635a.a(false);
                this.f18620q.remove(size);
            }
        }
        Collections.sort(this.f18620q);
    }

    private void a(fo foVar, boolean z11) throws Throwable {
        boolean z12;
        g gVarA = a(foVar, this.f18628y, this.L, this.f18623t, this.F, this.G, this.f18615l, this.f18616m);
        be.a aVar = gVarA.f18646a;
        long j11 = gVarA.f18648c;
        boolean z13 = gVarA.f18649d;
        long jA = gVarA.f18647b;
        boolean z14 = (this.f18628y.f21535b.equals(aVar) && jA == this.f18628y.f21552s) ? false : true;
        h hVar = null;
        long j12 = C.TIME_UNSET;
        try {
            if (gVarA.f18650e) {
                if (this.f18628y.f21538e != 1) {
                    c(4);
                }
                a(false, false, false, true);
            }
            try {
                if (z14) {
                    z12 = false;
                    if (!foVar.c()) {
                        for (xd xdVarE = this.f18623t.e(); xdVarE != null; xdVarE = xdVarE.d()) {
                            if (xdVarE.f24300f.f24835a.equals(aVar)) {
                                xdVarE.f24300f = this.f18623t.a(foVar, xdVarE.f24300f);
                                xdVarE.m();
                            }
                        }
                        jA = a(aVar, jA, z13);
                    }
                } else {
                    try {
                        z12 = false;
                        if (!this.f18623t.a(foVar, this.M, f())) {
                            c(false);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        hVar = null;
                        oh ohVar = this.f18628y;
                        fo foVar2 = ohVar.f21534a;
                        be.a aVar2 = ohVar.f21535b;
                        if (gVarA.f18651f) {
                            j12 = jA;
                        }
                        h hVar2 = hVar;
                        a(foVar, aVar, foVar2, aVar2, j12);
                        if (z14 || j11 != this.f18628y.f21536c) {
                            oh ohVar2 = this.f18628y;
                            Object obj = ohVar2.f21535b.f24653a;
                            fo foVar3 = ohVar2.f21534a;
                            this.f18628y = a(aVar, jA, j11, this.f18628y.f21537d, z14 && z11 && !foVar3.c() && !foVar3.a(obj, this.f18616m).f19036g, foVar.a(obj) == -1 ? 4 : 3);
                        }
                        B();
                        a(foVar, this.f18628y.f21534a);
                        this.f18628y = this.f18628y.a(foVar);
                        if (!foVar.c()) {
                            this.L = hVar2;
                        }
                        a(false);
                        throw th;
                    }
                }
                oh ohVar3 = this.f18628y;
                a(foVar, aVar, ohVar3.f21534a, ohVar3.f21535b, gVarA.f18651f ? jA : -9223372036854775807L);
                if (z14 || j11 != this.f18628y.f21536c) {
                    oh ohVar4 = this.f18628y;
                    Object obj2 = ohVar4.f21535b.f24653a;
                    fo foVar4 = ohVar4.f21534a;
                    this.f18628y = a(aVar, jA, j11, this.f18628y.f21537d, z14 && z11 && !foVar4.c() && !foVar4.a(obj2, this.f18616m).f19036g, foVar.a(obj2) == -1 ? 4 : 3);
                }
                B();
                a(foVar, this.f18628y.f21534a);
                this.f18628y = this.f18628y.a(foVar);
                if (!foVar.c()) {
                    this.L = null;
                }
                a(z12);
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    private void a(jj jjVar) {
        this.f18627x = jjVar;
    }

    private void a(ph phVar, float f11, boolean z11, boolean z12) {
        if (z11) {
            if (z12) {
                this.f18629z.a(1);
            }
            this.f18628y = this.f18628y.a(phVar);
        }
        a(phVar.f21777a);
        for (qi qiVar : this.f18605a) {
            if (qiVar != null) {
                qiVar.a(f11, phVar.f21777a);
            }
        }
    }

    private void a(ph phVar, boolean z11) {
        a(phVar, phVar.f21777a, true, z11);
    }

    private void a(po poVar, wo woVar) {
        this.f18610g.a(this.f18605a, poVar, woVar.f24152c);
    }

    private void a(qi qiVar) {
        if (c(qiVar)) {
            this.f18619p.a(qiVar);
            b(qiVar);
            qiVar.f();
            this.K--;
        }
    }

    private void a(qi qiVar, long j11) {
        qiVar.g();
        if (qiVar instanceof bo) {
            ((bo) qiVar).c(j11);
        }
    }

    private void a(wj wjVar) throws Throwable {
        this.f18629z.a(1);
        a(this.f18624u.a(wjVar), false);
    }

    private void a(IOException iOException, int i11) {
        a8 a8VarA = a8.a(iOException, i11);
        xd xdVarE = this.f18623t.e();
        if (xdVarE != null) {
            a8VarA = a8VarA.a(xdVarE.f24300f.f24835a);
        }
        pc.a("ExoPlayerImplInternal", "Playback error", a8VarA);
        a(false, false);
        this.f18628y = this.f18628y.a(a8VarA);
    }

    private void a(boolean z11) {
        xd xdVarD = this.f18623t.d();
        be.a aVar = xdVarD == null ? this.f18628y.f21535b : xdVarD.f24300f.f24835a;
        boolean z12 = !this.f18628y.f21544k.equals(aVar);
        if (z12) {
            this.f18628y = this.f18628y.a(aVar);
        }
        oh ohVar = this.f18628y;
        ohVar.f21550q = xdVarD == null ? ohVar.f21552s : xdVarD.c();
        this.f18628y.f21551r = h();
        if ((z12 || z11) && xdVarD != null && xdVarD.f24298d) {
            a(xdVarD.h(), xdVarD.i());
        }
    }

    private void a(boolean z11, int i11, boolean z12, int i12) {
        this.f18629z.a(z12 ? 1 : 0);
        this.f18629z.b(i12);
        this.f18628y = this.f18628y.a(z11, i11);
        this.D = false;
        b(z11);
        if (!E()) {
            H();
            K();
            return;
        }
        int i13 = this.f18628y.f21538e;
        if (i13 == 3) {
            F();
            this.f18612i.c(2);
        } else if (i13 == 2) {
            this.f18612i.c(2);
        }
    }

    private void a(boolean z11, AtomicBoolean atomicBoolean) {
        if (this.H != z11) {
            this.H = z11;
            if (!z11) {
                for (qi qiVar : this.f18605a) {
                    if (!c(qiVar) && this.f18606b.remove(qiVar)) {
                        qiVar.reset();
                    }
                }
            }
        }
        if (atomicBoolean != null) {
            synchronized (this) {
                atomicBoolean.set(true);
                notifyAll();
            }
        }
    }

    private void a(boolean z11, boolean z12) {
        a(z11 || !this.H, false, true, false);
        this.f18629z.a(z12 ? 1 : 0);
        this.f18610g.c();
        c(1);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00a3 A[PHI: r4 r5 r7
  0x00a3: PHI (r4v3 com.applovin.impl.be$a) = (r4v2 com.applovin.impl.be$a), (r4v8 com.applovin.impl.be$a) binds: [B:30:0x0076, B:32:0x009b] A[DONT_GENERATE, DONT_INLINE]
  0x00a3: PHI (r5v2 long) = (r5v1 long), (r5v4 long) binds: [B:30:0x0076, B:32:0x009b] A[DONT_GENERATE, DONT_INLINE]
  0x00a3: PHI (r7v3 long) = (r7v2 long), (r7v5 long) binds: [B:30:0x0076, B:32:0x009b] A[DONT_GENERATE, DONT_INLINE]] */
    private void a(boolean z11, boolean z12, boolean z13, boolean z14) {
        be.a aVar;
        long j11;
        boolean z15;
        this.f18612i.b(2);
        this.P = null;
        this.D = false;
        this.f18619p.c();
        this.M = 0L;
        for (qi qiVar : this.f18605a) {
            try {
                a(qiVar);
            } catch (a8 | RuntimeException e11) {
                pc.a("ExoPlayerImplInternal", "Disable failed.", e11);
            }
        }
        if (z11) {
            for (qi qiVar2 : this.f18605a) {
                if (this.f18606b.remove(qiVar2)) {
                    try {
                        qiVar2.reset();
                    } catch (RuntimeException e12) {
                        pc.a("ExoPlayerImplInternal", "Reset failed.", e12);
                    }
                }
            }
        }
        this.K = 0;
        oh ohVar = this.f18628y;
        be.a aVar2 = ohVar.f21535b;
        long jLongValue = ohVar.f21552s;
        long j12 = (this.f18628y.f21535b.a() || a(this.f18628y, this.f18616m)) ? this.f18628y.f21536c : this.f18628y.f21552s;
        if (z12) {
            this.L = null;
            Pair pairA = a(this.f18628y.f21534a);
            aVar2 = (be.a) pairA.first;
            jLongValue = ((Long) pairA.second).longValue();
            boolean zEquals = aVar2.equals(this.f18628y.f21535b);
            j12 = C.TIME_UNSET;
            if (zEquals) {
                aVar = aVar2;
                j11 = jLongValue;
                z15 = false;
            } else {
                z15 = true;
                aVar = aVar2;
                j11 = jLongValue;
            }
        } else {
            aVar = aVar2;
            j11 = jLongValue;
            z15 = false;
        }
        this.f18623t.c();
        this.E = false;
        oh ohVar2 = this.f18628y;
        fo foVar = ohVar2.f21534a;
        int i11 = ohVar2.f21538e;
        a8 a8Var = z14 ? null : ohVar2.f21539f;
        po poVar = z15 ? po.f21808d : ohVar2.f21541h;
        wo woVar = z15 ? this.f18609f : ohVar2.f21542i;
        List listH = z15 ? eb.h() : ohVar2.f21543j;
        oh ohVar3 = this.f18628y;
        this.f18628y = new oh(foVar, aVar, j12, j11, i11, a8Var, false, poVar, woVar, listH, aVar, ohVar3.f21545l, ohVar3.f21546m, ohVar3.f21547n, j11, 0L, j11, this.J, false);
        if (z13) {
            this.f18624u.e();
        }
    }

    private void a(boolean[] zArr) throws a8 {
        xd xdVarF = this.f18623t.f();
        wo woVarI = xdVarF.i();
        for (int i11 = 0; i11 < this.f18605a.length; i11++) {
            if (!woVarI.a(i11) && this.f18606b.remove(this.f18605a[i11])) {
                this.f18605a[i11].reset();
            }
        }
        for (int i12 = 0; i12 < this.f18605a.length; i12++) {
            if (woVarI.a(i12)) {
                a(i12, zArr[i12]);
            }
        }
        xdVarF.f24301g = true;
    }

    private boolean a(long j11, long j12) {
        if (this.J && this.I) {
            return false;
        }
        c(j11, j12);
        return true;
    }

    private static boolean a(d dVar, fo foVar, fo foVar2, int i11, boolean z11, fo.d dVar2, fo.b bVar) {
        Object obj = dVar.f18638d;
        if (obj == null) {
            Pair pairA = a(foVar, new h(dVar.f18635a.f(), dVar.f18635a.h(), dVar.f18635a.d() == Long.MIN_VALUE ? C.TIME_UNSET : t2.a(dVar.f18635a.d())), false, i11, z11, dVar2, bVar);
            if (pairA == null) {
                return false;
            }
            dVar.a(foVar.a(pairA.first), ((Long) pairA.second).longValue(), pairA.first);
            if (dVar.f18635a.d() == Long.MIN_VALUE) {
                a(foVar, dVar, dVar2, bVar);
            }
            return true;
        }
        int iA = foVar.a(obj);
        if (iA == -1) {
            return false;
        }
        if (dVar.f18635a.d() == Long.MIN_VALUE) {
            a(foVar, dVar, dVar2, bVar);
            return true;
        }
        dVar.f18636b = iA;
        foVar2.a(dVar.f18638d, bVar);
        if (bVar.f19036g && foVar2.a(bVar.f19033c, dVar2).f19060p == foVar2.a(dVar.f18638d)) {
            Pair pairA2 = foVar.a(dVar2, bVar, foVar.a(dVar.f18638d, bVar).f19033c, dVar.f18637c + bVar.e());
            dVar.a(foVar.a(pairA2.first), ((Long) pairA2.second).longValue(), pairA2.first);
        }
        return true;
    }

    private boolean a(fo foVar, be.a aVar) {
        if (aVar.a() || foVar.c()) {
            return false;
        }
        foVar.a(foVar.a(aVar.f24653a, this.f18616m).f19033c, this.f18615l);
        if (!this.f18615l.e()) {
            return false;
        }
        fo.d dVar = this.f18615l;
        return dVar.f19054j && dVar.f19051g != C.TIME_UNSET;
    }

    private static boolean a(oh ohVar, fo.b bVar) {
        be.a aVar = ohVar.f21535b;
        fo foVar = ohVar.f21534a;
        return foVar.c() || foVar.a(aVar.f24653a, bVar).f19036g;
    }

    private boolean a(qi qiVar, xd xdVar) {
        xd xdVarD = xdVar.d();
        return xdVar.f24300f.f24840f && xdVarD.f24298d && ((qiVar instanceof bo) || qiVar.i() >= xdVarD.g());
    }

    private static f9[] a(h8 h8Var) {
        int iB = h8Var != null ? h8Var.b() : 0;
        f9[] f9VarArr = new f9[iB];
        for (int i11 = 0; i11 < iB; i11++) {
            f9VarArr[i11] = h8Var.a(i11);
        }
        return f9VarArr;
    }

    private long b(long j11) {
        xd xdVarD = this.f18623t.d();
        if (xdVarD == null) {
            return 0L;
        }
        return Math.max(0L, j11 - xdVarD.d(this.M));
    }

    private void b() throws a8 {
        c(true);
    }

    private void b(int i11) throws a8 {
        this.F = i11;
        if (!this.f18623t.a(this.f18628y.f21534a, i11)) {
            c(true);
        }
        a(false);
    }

    private void b(long j11, long j12) {
        e8 e8Var;
        d dVar;
        if (this.f18620q.isEmpty() || this.f18628y.f21535b.a()) {
            return;
        }
        if (this.O) {
            j11--;
            this.O = false;
        }
        oh ohVar = this.f18628y;
        int iA = ohVar.f21534a.a(ohVar.f21535b.f24653a);
        int iMin = Math.min(this.N, this.f18620q.size());
        d dVar2 = iMin > 0 ? (d) this.f18620q.get(iMin - 1) : null;
        while (dVar2 != null) {
            int i11 = dVar2.f18636b;
            if (i11 <= iA && (i11 != iA || dVar2.f18637c <= j11)) {
                break;
            }
            int i12 = iMin - 1;
            dVar2 = i12 > 0 ? (d) this.f18620q.get(iMin - 2) : null;
            iMin = i12;
        }
        if (iMin < this.f18620q.size()) {
            dVar = (d) this.f18620q.get(iMin);
            e8Var = this;
        } else {
            e8Var = this;
            dVar = null;
        }
        while (dVar != null && dVar.f18638d != null) {
            int i13 = dVar.f18636b;
            if (i13 >= iA && (i13 != iA || dVar.f18637c > j11)) {
                break;
            }
            iMin++;
            if (iMin < e8Var.f18620q.size()) {
                dVar = (d) e8Var.f18620q.get(iMin);
            } else {
                e8Var = e8Var;
                dVar = null;
            }
        }
        while (dVar != null && dVar.f18638d != null && dVar.f18636b == iA) {
            long j13 = dVar.f18637c;
            if (j13 <= j11 || j13 > j12) {
                break;
            }
            try {
                e8Var.e(dVar.f18635a);
                if (dVar.f18635a.a() || dVar.f18635a.i()) {
                    e8Var.f18620q.remove(iMin);
                } else {
                    iMin++;
                }
                dVar = iMin < e8Var.f18620q.size() ? (d) e8Var.f18620q.get(iMin) : null;
            } catch (Throwable th2) {
                if (dVar.f18635a.a() || dVar.f18635a.i()) {
                    e8Var.f18620q.remove(iMin);
                }
                throw th2;
            }
        }
        e8Var.N = iMin;
    }

    private void b(ph phVar) {
        this.f18619p.a(phVar);
        a(this.f18619p.a(), true);
    }

    private void b(qi qiVar) {
        if (qiVar.b() == 2) {
            qiVar.stop();
        }
    }

    private void b(rh rhVar) {
        if (rhVar.i()) {
            return;
        }
        try {
            rhVar.e().a(rhVar.g(), rhVar.c());
        } finally {
            rhVar.a(true);
        }
    }

    private void b(wd wdVar) {
        if (this.f18623t.a(wdVar)) {
            this.f18623t.a(this.M);
            m();
        }
    }

    private void b(boolean z11) {
        for (xd xdVarE = this.f18623t.e(); xdVarE != null; xdVarE = xdVarE.d()) {
            for (h8 h8Var : xdVarE.i().f24152c) {
                if (h8Var != null) {
                    h8Var.a(z11);
                }
            }
        }
    }

    private void c() throws a8 {
        boolean z11;
        boolean z12;
        int i11;
        boolean z13;
        long jA = this.f18621r.a();
        J();
        int i12 = this.f18628y.f21538e;
        if (i12 == 1 || i12 == 4) {
            this.f18612i.b(2);
            return;
        }
        xd xdVarE = this.f18623t.e();
        if (xdVarE == null) {
            c(jA, 10L);
            return;
        }
        ko.a("doSomeWork");
        K();
        if (xdVarE.f24298d) {
            long jElapsedRealtime = SystemClock.elapsedRealtime() * 1000;
            xdVarE.f24295a.a(this.f18628y.f21552s - this.f18617n, this.f18618o);
            int i13 = 0;
            z11 = true;
            z12 = true;
            while (true) {
                qi[] qiVarArr = this.f18605a;
                if (i13 >= qiVarArr.length) {
                    break;
                }
                qi qiVar = qiVarArr[i13];
                if (c(qiVar)) {
                    qiVar.a(this.M, jElapsedRealtime);
                    z11 = z11 && qiVar.c();
                    boolean z14 = xdVarE.f24297c[i13] != qiVar.o();
                    boolean z15 = z14 || (!z14 && qiVar.j()) || qiVar.d() || qiVar.c();
                    z12 = z12 && z15;
                    if (!z15) {
                        qiVar.h();
                    }
                }
                i13++;
            }
        } else {
            xdVarE.f24295a.f();
            z11 = true;
            z12 = true;
        }
        long j11 = xdVarE.f24300f.f24839e;
        boolean z16 = z11 && xdVarE.f24298d && (j11 == C.TIME_UNSET || j11 <= this.f18628y.f21552s);
        if (z16 && this.C) {
            this.C = false;
            a(false, this.f18628y.f21546m, false, 5);
        }
        if (z16 && xdVarE.f24300f.f24843i) {
            c(4);
            H();
        } else if (this.f18628y.f21538e == 2 && h(z12)) {
            c(3);
            this.P = null;
            if (E()) {
                F();
            }
        } else if (this.f18628y.f21538e == 3 && (this.K != 0 ? !z12 : !k())) {
            this.D = E();
            c(2);
            if (this.D) {
                u();
                this.f18625v.a();
            }
            H();
        }
        if (this.f18628y.f21538e == 2) {
            int i14 = 0;
            while (true) {
                qi[] qiVarArr2 = this.f18605a;
                if (i14 >= qiVarArr2.length) {
                    break;
                }
                if (c(qiVarArr2[i14]) && this.f18605a[i14].o() == xdVarE.f24297c[i14]) {
                    this.f18605a[i14].h();
                }
                i14++;
            }
            oh ohVar = this.f18628y;
            if (!ohVar.f21540g && ohVar.f21551r < 500000 && j()) {
                throw new IllegalStateException("Playback stuck buffering and not loading");
            }
        }
        boolean z17 = this.J;
        oh ohVar2 = this.f18628y;
        if (z17 != ohVar2.f21548o) {
            this.f18628y = ohVar2.b(z17);
        }
        if ((E() && this.f18628y.f21538e == 3) || (i11 = this.f18628y.f21538e) == 2) {
            z13 = !a(jA, 10L);
        } else {
            if (this.K == 0 || i11 == 4) {
                this.f18612i.b(2);
            } else {
                c(jA, 1000L);
            }
            z13 = false;
        }
        oh ohVar3 = this.f18628y;
        if (ohVar3.f21549p != z13) {
            this.f18628y = ohVar3.c(z13);
        }
        this.I = false;
        ko.a();
    }

    private void c(int i11) {
        oh ohVar = this.f18628y;
        if (ohVar.f21538e != i11) {
            this.f18628y = ohVar.a(i11);
        }
    }

    private void c(long j11) {
        xd xdVarE = this.f18623t.e();
        if (xdVarE != null) {
            j11 = xdVarE.e(j11);
        }
        this.M = j11;
        this.f18619p.a(j11);
        for (qi qiVar : this.f18605a) {
            if (c(qiVar)) {
                qiVar.a(this.M);
            }
        }
        t();
    }

    private void c(long j11, long j12) {
        this.f18612i.b(2);
        this.f18612i.a(2, j11 + j12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(rh rhVar) {
        try {
            b(rhVar);
        } catch (a8 e11) {
            pc.a("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", e11);
            throw new RuntimeException(e11);
        }
    }

    private void c(wd wdVar) throws a8 {
        if (this.f18623t.a(wdVar)) {
            xd xdVarD = this.f18623t.d();
            xdVarD.a(this.f18619p.a().f21777a, this.f18628y.f21534a);
            a(xdVarD.h(), xdVarD.i());
            if (xdVarD == this.f18623t.e()) {
                c(xdVarD.f24300f.f24836b);
                d();
                oh ohVar = this.f18628y;
                be.a aVar = ohVar.f21535b;
                long j11 = xdVarD.f24300f.f24836b;
                this.f18628y = a(aVar, j11, ohVar.f21536c, j11, false, 5);
            }
            m();
        }
    }

    private void c(boolean z11) throws a8 {
        be.a aVar = this.f18623t.e().f24300f.f24835a;
        long jA = a(aVar, this.f18628y.f21552s, true, false);
        if (jA != this.f18628y.f21552s) {
            oh ohVar = this.f18628y;
            this.f18628y = a(aVar, jA, ohVar.f21536c, ohVar.f21537d, z11, 5);
        }
    }

    private static boolean c(qi qiVar) {
        return qiVar.b() != 0;
    }

    private void d() throws a8 {
        a(new boolean[this.f18605a.length]);
    }

    private void d(long j11) {
        for (qi qiVar : this.f18605a) {
            if (qiVar.o() != null) {
                a(qiVar, j11);
            }
        }
    }

    private void d(rh rhVar) {
        if (rhVar.d() == C.TIME_UNSET) {
            e(rhVar);
            return;
        }
        if (this.f18628y.f21534a.c()) {
            this.f18620q.add(new d(rhVar));
            return;
        }
        d dVar = new d(rhVar);
        fo foVar = this.f18628y.f21534a;
        if (!a(dVar, foVar, foVar, this.F, this.G, this.f18615l, this.f18616m)) {
            rhVar.a(false);
        } else {
            this.f18620q.add(dVar);
            Collections.sort(this.f18620q);
        }
    }

    private void d(boolean z11) {
        if (z11 == this.J) {
            return;
        }
        this.J = z11;
        oh ohVar = this.f18628y;
        int i11 = ohVar.f21538e;
        if (z11 || i11 == 4 || i11 == 1) {
            this.f18628y = ohVar.b(z11);
        } else {
            this.f18612i.c(2);
        }
    }

    private long e() {
        oh ohVar = this.f18628y;
        return a(ohVar.f21534a, ohVar.f21535b.f24653a, ohVar.f21552s);
    }

    private void e(rh rhVar) {
        if (rhVar.b() != this.f18614k) {
            this.f18612i.a(15, rhVar).a();
            return;
        }
        b(rhVar);
        int i11 = this.f18628y.f21538e;
        if (i11 == 3 || i11 == 2) {
            this.f18612i.c(2);
        }
    }

    private void e(boolean z11) throws a8 {
        this.B = z11;
        B();
        if (!this.C || this.f18623t.f() == this.f18623t.e()) {
            return;
        }
        c(true);
        a(false);
    }

    private long f() {
        xd xdVarF = this.f18623t.f();
        if (xdVarF == null) {
            return 0L;
        }
        long jF = xdVarF.f();
        if (!xdVarF.f24298d) {
            return jF;
        }
        int i11 = 0;
        while (true) {
            qi[] qiVarArr = this.f18605a;
            if (i11 >= qiVarArr.length) {
                return jF;
            }
            if (c(qiVarArr[i11]) && this.f18605a[i11].o() == xdVarF.f24297c[i11]) {
                long jI = this.f18605a[i11].i();
                if (jI == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                }
                jF = Math.max(jI, jF);
            }
            i11++;
        }
    }

    private void f(final rh rhVar) {
        Looper looperB = rhVar.b();
        if (looperB.getThread().isAlive()) {
            this.f18621r.a(looperB, null).a(new Runnable() { // from class: com.applovin.impl.ev
                @Override // java.lang.Runnable
                public final void run() {
                    this.f18784a.c(rhVar);
                }
            });
        } else {
            pc.d("TAG", "Trying to send message on a dead thread.");
            rhVar.a(false);
        }
    }

    private void g(boolean z11) throws a8 {
        this.G = z11;
        if (!this.f18623t.a(this.f18628y.f21534a, z11)) {
            c(true);
        }
        a(false);
    }

    private long h() {
        return b(this.f18628y.f21550q);
    }

    private boolean h(boolean z11) {
        if (this.K == 0) {
            return k();
        }
        if (!z11) {
            return false;
        }
        oh ohVar = this.f18628y;
        if (!ohVar.f21540g) {
            return true;
        }
        long jB = a(ohVar.f21534a, this.f18623t.e().f24300f.f24835a) ? this.f18625v.b() : C.TIME_UNSET;
        xd xdVarD = this.f18623t.d();
        return (xdVarD.j() && xdVarD.f24300f.f24843i) || (xdVarD.f24300f.f24835a.a() && !xdVarD.f24298d) || this.f18610g.a(h(), this.f18619p.a().f21777a, this.D, jB);
    }

    private boolean i() {
        xd xdVarF = this.f18623t.f();
        if (!xdVarF.f24298d) {
            return false;
        }
        int i11 = 0;
        while (true) {
            qi[] qiVarArr = this.f18605a;
            if (i11 >= qiVarArr.length) {
                return true;
            }
            qi qiVar = qiVarArr[i11];
            cj cjVar = xdVarF.f24297c[i11];
            if (qiVar.o() != cjVar || (cjVar != null && !qiVar.j() && !a(qiVar, xdVarF))) {
                return false;
            }
            i11++;
        }
    }

    private boolean j() {
        xd xdVarD = this.f18623t.d();
        return (xdVarD == null || xdVarD.e() == Long.MIN_VALUE) ? false : true;
    }

    private boolean k() {
        xd xdVarE = this.f18623t.e();
        long j11 = xdVarE.f24300f.f24839e;
        return xdVarE.f24298d && (j11 == C.TIME_UNSET || this.f18628y.f21552s < j11 || !E());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean l() {
        return Boolean.valueOf(this.A);
    }

    private void m() {
        boolean zD = D();
        this.E = zD;
        if (zD) {
            this.f18623t.d().a(this.M);
        }
        I();
    }

    private void n() {
        this.f18629z.a(this.f18628y);
        if (this.f18629z.f18639a) {
            this.f18622s.a(this.f18629z);
            this.f18629z = new e(this.f18628y);
        }
    }

    private void o() {
        zd zdVarA;
        this.f18623t.a(this.M);
        if (this.f18623t.h() && (zdVarA = this.f18623t.a(this.M, this.f18628y)) != null) {
            xd xdVarA = this.f18623t.a(this.f18607c, this.f18608d, this.f18610g.b(), this.f18624u, zdVarA, this.f18609f);
            xdVarA.f24295a.a(this, zdVarA.f24836b);
            if (this.f18623t.e() == xdVarA) {
                c(xdVarA.g());
            }
            a(false);
        }
        if (!this.E) {
            m();
        } else {
            this.E = j();
            I();
        }
    }

    private void p() {
        boolean z11 = false;
        while (C()) {
            if (z11) {
                n();
            }
            xd xdVarE = this.f18623t.e();
            xd xdVarA = this.f18623t.a();
            zd zdVar = xdVarA.f24300f;
            be.a aVar = zdVar.f24835a;
            long j11 = zdVar.f24836b;
            oh ohVarA = a(aVar, j11, zdVar.f24837c, j11, true, 0);
            this.f18628y = ohVarA;
            fo foVar = ohVarA.f21534a;
            a(foVar, xdVarA.f24300f.f24835a, foVar, xdVarE.f24300f.f24835a, C.TIME_UNSET);
            B();
            K();
            z11 = true;
        }
    }

    private void q() {
        xd xdVarF = this.f18623t.f();
        if (xdVarF == null) {
            return;
        }
        int i11 = 0;
        if (xdVarF.d() != null && !this.C) {
            if (i()) {
                if (xdVarF.d().f24298d || this.M >= xdVarF.d().g()) {
                    wo woVarI = xdVarF.i();
                    xd xdVarB = this.f18623t.b();
                    wo woVarI2 = xdVarB.i();
                    if (xdVarB.f24298d && xdVarB.f24295a.h() != C.TIME_UNSET) {
                        d(xdVarB.g());
                        return;
                    }
                    for (int i12 = 0; i12 < this.f18605a.length; i12++) {
                        boolean zA = woVarI.a(i12);
                        boolean zA2 = woVarI2.a(i12);
                        if (zA && !this.f18605a[i12].k()) {
                            boolean z11 = this.f18607c[i12].e() == -2;
                            si siVar = woVarI.f24151b[i12];
                            si siVar2 = woVarI2.f24151b[i12];
                            if (!zA2 || !siVar2.equals(siVar) || z11) {
                                a(this.f18605a[i12], xdVarB.g());
                            }
                        }
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (!xdVarF.f24300f.f24843i && !this.C) {
            return;
        }
        while (true) {
            qi[] qiVarArr = this.f18605a;
            if (i11 >= qiVarArr.length) {
                return;
            }
            qi qiVar = qiVarArr[i11];
            cj cjVar = xdVarF.f24297c[i11];
            if (cjVar != null && qiVar.o() == cjVar && qiVar.j()) {
                long j11 = xdVarF.f24300f.f24839e;
                a(qiVar, (j11 == C.TIME_UNSET || j11 == Long.MIN_VALUE) ? -9223372036854775807L : xdVarF.f() + xdVarF.f24300f.f24839e);
            }
            i11++;
        }
    }

    private void r() throws a8 {
        xd xdVarF = this.f18623t.f();
        if (xdVarF == null || this.f18623t.e() == xdVarF || xdVarF.f24301g || !z()) {
            return;
        }
        d();
    }

    private void s() throws Throwable {
        a(this.f18624u.a(), true);
    }

    private void t() {
        for (xd xdVarE = this.f18623t.e(); xdVarE != null; xdVarE = xdVarE.d()) {
            for (h8 h8Var : xdVarE.i().f24152c) {
                if (h8Var != null) {
                    h8Var.j();
                }
            }
        }
    }

    private void u() {
        for (xd xdVarE = this.f18623t.e(); xdVarE != null; xdVarE = xdVarE.d()) {
            for (h8 h8Var : xdVarE.i().f24152c) {
                if (h8Var != null) {
                    h8Var.k();
                }
            }
        }
    }

    private void w() {
        this.f18629z.a(1);
        a(false, false, false, true);
        this.f18610g.f();
        c(this.f18628y.f21534a.c() ? 4 : 2);
        this.f18624u.a(this.f18611h.a());
        this.f18612i.c(2);
    }

    private void y() {
        a(true, false, true, false);
        this.f18610g.e();
        c(1);
        this.f18613j.quit();
        synchronized (this) {
            this.A = true;
            notifyAll();
        }
    }

    private boolean z() {
        xd xdVarF = this.f18623t.f();
        wo woVarI = xdVarF.i();
        int i11 = 0;
        boolean z11 = false;
        while (true) {
            qi[] qiVarArr = this.f18605a;
            if (i11 >= qiVarArr.length) {
                return !z11;
            }
            qi qiVar = qiVarArr[i11];
            if (c(qiVar)) {
                boolean z12 = qiVar.o() != xdVarF.f24297c[i11];
                if (!woVarI.a(i11) || z12) {
                    if (!qiVar.k()) {
                        qiVar.a(a(woVarI.f24152c[i11]), xdVarF.f24297c[i11], xdVarF.g(), xdVarF.f());
                    } else if (qiVar.c()) {
                        a(qiVar);
                    } else {
                        z11 = true;
                    }
                }
            }
            i11++;
        }
    }

    public void G() {
        this.f18612i.d(6).a();
    }

    @Override // com.applovin.impl.fe.d
    public void a() {
        this.f18612i.c(22);
    }

    public void a(int i11) {
        this.f18612i.a(11, i11, 0).a();
    }

    public void a(long j11) {
        this.Q = j11;
    }

    public void a(fo foVar, int i11, long j11) {
        this.f18612i.a(3, new h(foVar, i11, j11)).a();
    }

    @Override // com.applovin.impl.h6.a
    public void a(ph phVar) {
        this.f18612i.a(16, phVar).a();
    }

    @Override // com.applovin.impl.rh.a
    public synchronized void a(rh rhVar) {
        if (!this.A && this.f18613j.isAlive()) {
            this.f18612i.a(14, rhVar).a();
            return;
        }
        pc.d("ExoPlayerImplInternal", "Ignoring messages sent after release.");
        rhVar.a(false);
    }

    @Override // com.applovin.impl.wd.a
    public void a(wd wdVar) {
        this.f18612i.a(8, wdVar).a();
    }

    public void a(List list, int i11, long j11, wj wjVar) {
        this.f18612i.a(17, new b(list, wjVar, i11, j11, null)).a();
    }

    public void a(boolean z11, int i11) {
        this.f18612i.a(1, z11 ? 1 : 0, i11).a();
    }

    public void b(int i11, int i12, wj wjVar) {
        this.f18612i.a(20, i11, i12, wjVar).a();
    }

    @Override // com.applovin.impl.pj.a
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public void a(wd wdVar) {
        this.f18612i.a(9, wdVar).a();
    }

    public void f(boolean z11) {
        this.f18612i.a(12, z11 ? 1 : 0, 0).a();
    }

    public Looper g() {
        return this.f18614k;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) throws Throwable {
        xd xdVarF;
        int i11 = 1000;
        try {
            switch (message.what) {
                case 0:
                    w();
                    break;
                case 1:
                    a(message.arg1 != 0, message.arg2, true, 1);
                    break;
                case 2:
                    c();
                    break;
                case 3:
                    a((h) message.obj);
                    break;
                case 4:
                    b((ph) message.obj);
                    break;
                case 5:
                    a((jj) message.obj);
                    break;
                case 6:
                    a(false, true);
                    break;
                case 7:
                    y();
                    return true;
                case 8:
                    c((wd) message.obj);
                    break;
                case 9:
                    b((wd) message.obj);
                    break;
                case 10:
                    A();
                    break;
                case 11:
                    b(message.arg1);
                    break;
                case 12:
                    g(message.arg1 != 0);
                    break;
                case 13:
                    a(message.arg1 != 0, (AtomicBoolean) message.obj);
                    break;
                case 14:
                    d((rh) message.obj);
                    break;
                case 15:
                    f((rh) message.obj);
                    break;
                case 16:
                    a((ph) message.obj, false);
                    break;
                case 17:
                    a((b) message.obj);
                    break;
                case 18:
                    a((b) message.obj, message.arg1);
                    break;
                case 19:
                    d8.a(message.obj);
                    a((c) null);
                    break;
                case 20:
                    a(message.arg1, message.arg2, (wj) message.obj);
                    break;
                case 21:
                    a((wj) message.obj);
                    break;
                case 22:
                    s();
                    break;
                case 23:
                    e(message.arg1 != 0);
                    break;
                case 24:
                    d(message.arg1 == 1);
                    break;
                case 25:
                    b();
                    break;
                default:
                    return false;
            }
        } catch (a8 e11) {
            e = e11;
            if (e.f17470d == 1 && (xdVarF = this.f18623t.f()) != null) {
                e = e.a(xdVarF.f24300f.f24835a);
            }
            if (e.f17476k && this.P == null) {
                pc.c("ExoPlayerImplInternal", "Recoverable renderer error", e);
                this.P = e;
                ja jaVar = this.f18612i;
                jaVar.a(jaVar.a(25, e));
            } else {
                a8 a8Var = this.P;
                if (a8Var != null) {
                    a8Var.addSuppressed(e);
                    e = this.P;
                }
                pc.a("ExoPlayerImplInternal", "Playback error", e);
                a(true, false);
                this.f18628y = this.f18628y.a(e);
            }
        } catch (dh e12) {
            int i12 = e12.f18448b;
            if (i12 == 1) {
                i11 = e12.f18447a ? 3001 : 3003;
            } else if (i12 == 4) {
                i11 = e12.f18447a ? 3002 : 3004;
            }
            a(e12, i11);
        } catch (j5 e13) {
            a(e13, e13.f19855a);
        } catch (z6.a e14) {
            a(e14, e14.f24814a);
        } catch (IOException e15) {
            a(e15, 2000);
        } catch (RuntimeException e16) {
            a8 a8VarA = a8.a(e16, ((e16 instanceof IllegalStateException) || (e16 instanceof IllegalArgumentException)) ? 1004 : 1000);
            pc.a("ExoPlayerImplInternal", "Playback error", a8VarA);
            a(true, false);
            this.f18628y = this.f18628y.a(a8VarA);
        }
        n();
        return true;
    }

    public void v() {
        this.f18612i.d(0).a();
    }

    public synchronized boolean x() {
        if (!this.A && this.f18613j.isAlive()) {
            this.f18612i.c(7);
            a(new Supplier() { // from class: com.applovin.impl.fv
                @Override // com.applovin.exoplayer2.common.base.Supplier
                public final Object get() {
                    return this.f19127a.l();
                }
            }, this.f18626w);
            return this.A;
        }
        return true;
    }
}
