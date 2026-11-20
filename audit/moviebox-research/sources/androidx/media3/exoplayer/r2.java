package androidx.media3.exoplayer;

import android.util.Pair;
import androidx.annotation.Nullable;
import e4.x3;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class r2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x3 f10979a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d f10983e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final e4.a f10986h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final z3.j f10987i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f10989k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    public c4.o f10990l;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public p4.f0 f10988j = new p4.f0.a(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IdentityHashMap<androidx.media3.exoplayer.source.k, c> f10981c = new IdentityHashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<Object, c> f10982d = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<c> f10980b = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashMap<c, b> f10984f = new HashMap<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Set<c> f10985g = new HashSet();

    /* JADX INFO: compiled from: source.java */
    public final class a implements androidx.media3.exoplayer.source.m, androidx.media3.exoplayer.drm.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f10991a;

        public a(c cVar) {
            this.f10991a = cVar;
        }

        @Override // androidx.media3.exoplayer.source.m
        public void A(int i11, @Nullable androidx.media3.exoplayer.source.l.b bVar, final p4.n nVar, final p4.o oVar) {
            final Pair<Integer, androidx.media3.exoplayer.source.l.b> pairU = U(i11, bVar);
            if (pairU != null) {
                r2.this.f10987i.post(new Runnable() { // from class: androidx.media3.exoplayer.j2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f10643a.d0(pairU, nVar, oVar);
                    }
                });
            }
        }

        @Override // androidx.media3.exoplayer.source.m
        public void B(int i11, @Nullable androidx.media3.exoplayer.source.l.b bVar, final p4.n nVar, final p4.o oVar) {
            final Pair<Integer, androidx.media3.exoplayer.source.l.b> pairU = U(i11, bVar);
            if (pairU != null) {
                r2.this.f10987i.post(new Runnable() { // from class: androidx.media3.exoplayer.n2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f10785a.f0(pairU, nVar, oVar);
                    }
                });
            }
        }

        @Override // androidx.media3.exoplayer.source.m
        public void D(int i11, @Nullable androidx.media3.exoplayer.source.l.b bVar, final p4.o oVar) {
            final Pair<Integer, androidx.media3.exoplayer.source.l.b> pairU = U(i11, bVar);
            if (pairU != null) {
                r2.this.f10987i.post(new Runnable() { // from class: androidx.media3.exoplayer.i2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f10633a.g0(pairU, oVar);
                    }
                });
            }
        }

        @Override // androidx.media3.exoplayer.source.m
        public void E(int i11, @Nullable androidx.media3.exoplayer.source.l.b bVar, final p4.o oVar) {
            final Pair<Integer, androidx.media3.exoplayer.source.l.b> pairU = U(i11, bVar);
            if (pairU != null) {
                r2.this.f10987i.post(new Runnable() { // from class: androidx.media3.exoplayer.l2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f10668a.V(pairU, oVar);
                    }
                });
            }
        }

        @Override // androidx.media3.exoplayer.drm.b
        public void F(int i11, @Nullable androidx.media3.exoplayer.source.l.b bVar) {
            final Pair<Integer, androidx.media3.exoplayer.source.l.b> pairU = U(i11, bVar);
            if (pairU != null) {
                r2.this.f10987i.post(new Runnable() { // from class: androidx.media3.exoplayer.o2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f10796a.b0(pairU);
                    }
                });
            }
        }

        @Override // androidx.media3.exoplayer.source.m
        public void H(int i11, @Nullable androidx.media3.exoplayer.source.l.b bVar, final p4.n nVar, final p4.o oVar, final IOException iOException, final boolean z11) {
            final Pair<Integer, androidx.media3.exoplayer.source.l.b> pairU = U(i11, bVar);
            if (pairU != null) {
                r2.this.f10987i.post(new Runnable() { // from class: androidx.media3.exoplayer.p2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f10948a.e0(pairU, nVar, oVar, iOException, z11);
                    }
                });
            }
        }

        @Nullable
        public final Pair<Integer, androidx.media3.exoplayer.source.l.b> U(int i11, @Nullable androidx.media3.exoplayer.source.l.b bVar) {
            androidx.media3.exoplayer.source.l.b bVar2 = null;
            if (bVar != null) {
                androidx.media3.exoplayer.source.l.b bVarN = r2.n(this.f10991a, bVar);
                if (bVarN == null) {
                    return null;
                }
                bVar2 = bVarN;
            }
            return Pair.create(Integer.valueOf(r2.s(this.f10991a, i11)), bVar2);
        }

        public final /* synthetic */ void V(Pair pair, p4.o oVar) {
            r2.this.f10986h.E(((Integer) pair.first).intValue(), (androidx.media3.exoplayer.source.l.b) pair.second, oVar);
        }

        public final /* synthetic */ void W(Pair pair) {
            r2.this.f10986h.f(((Integer) pair.first).intValue(), (androidx.media3.exoplayer.source.l.b) pair.second);
        }

        public final /* synthetic */ void X(Pair pair) {
            r2.this.f10986h.u(((Integer) pair.first).intValue(), (androidx.media3.exoplayer.source.l.b) pair.second);
        }

        public final /* synthetic */ void Y(Pair pair) {
            r2.this.f10986h.z(((Integer) pair.first).intValue(), (androidx.media3.exoplayer.source.l.b) pair.second);
        }

        public final /* synthetic */ void Z(Pair pair, int i11) {
            r2.this.f10986h.p(((Integer) pair.first).intValue(), (androidx.media3.exoplayer.source.l.b) pair.second, i11);
        }

        public final /* synthetic */ void a0(Pair pair, Exception exc) {
            r2.this.f10986h.v(((Integer) pair.first).intValue(), (androidx.media3.exoplayer.source.l.b) pair.second, exc);
        }

        public final /* synthetic */ void b0(Pair pair) {
            r2.this.f10986h.F(((Integer) pair.first).intValue(), (androidx.media3.exoplayer.source.l.b) pair.second);
        }

        public final /* synthetic */ void c0(Pair pair, p4.n nVar, p4.o oVar) {
            r2.this.f10986h.y(((Integer) pair.first).intValue(), (androidx.media3.exoplayer.source.l.b) pair.second, nVar, oVar);
        }

        public final /* synthetic */ void d0(Pair pair, p4.n nVar, p4.o oVar) {
            r2.this.f10986h.A(((Integer) pair.first).intValue(), (androidx.media3.exoplayer.source.l.b) pair.second, nVar, oVar);
        }

        public final /* synthetic */ void e0(Pair pair, p4.n nVar, p4.o oVar, IOException iOException, boolean z11) {
            r2.this.f10986h.H(((Integer) pair.first).intValue(), (androidx.media3.exoplayer.source.l.b) pair.second, nVar, oVar, iOException, z11);
        }

        @Override // androidx.media3.exoplayer.drm.b
        public void f(int i11, @Nullable androidx.media3.exoplayer.source.l.b bVar) {
            final Pair<Integer, androidx.media3.exoplayer.source.l.b> pairU = U(i11, bVar);
            if (pairU != null) {
                r2.this.f10987i.post(new Runnable() { // from class: androidx.media3.exoplayer.h2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f10331a.W(pairU);
                    }
                });
            }
        }

        public final /* synthetic */ void f0(Pair pair, p4.n nVar, p4.o oVar) {
            r2.this.f10986h.B(((Integer) pair.first).intValue(), (androidx.media3.exoplayer.source.l.b) pair.second, nVar, oVar);
        }

        public final /* synthetic */ void g0(Pair pair, p4.o oVar) {
            r2.this.f10986h.D(((Integer) pair.first).intValue(), (androidx.media3.exoplayer.source.l.b) z3.a.e((androidx.media3.exoplayer.source.l.b) pair.second), oVar);
        }

        @Override // androidx.media3.exoplayer.drm.b
        public void p(int i11, @Nullable androidx.media3.exoplayer.source.l.b bVar, final int i12) {
            final Pair<Integer, androidx.media3.exoplayer.source.l.b> pairU = U(i11, bVar);
            if (pairU != null) {
                r2.this.f10987i.post(new Runnable() { // from class: androidx.media3.exoplayer.m2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f10689a.Z(pairU, i12);
                    }
                });
            }
        }

        @Override // androidx.media3.exoplayer.drm.b
        public /* synthetic */ void r(int i11, androidx.media3.exoplayer.source.l.b bVar) {
            i4.k.a(this, i11, bVar);
        }

        @Override // androidx.media3.exoplayer.drm.b
        public void u(int i11, @Nullable androidx.media3.exoplayer.source.l.b bVar) {
            final Pair<Integer, androidx.media3.exoplayer.source.l.b> pairU = U(i11, bVar);
            if (pairU != null) {
                r2.this.f10987i.post(new Runnable() { // from class: androidx.media3.exoplayer.q2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f10968a.X(pairU);
                    }
                });
            }
        }

        @Override // androidx.media3.exoplayer.drm.b
        public void v(int i11, @Nullable androidx.media3.exoplayer.source.l.b bVar, final Exception exc) {
            final Pair<Integer, androidx.media3.exoplayer.source.l.b> pairU = U(i11, bVar);
            if (pairU != null) {
                r2.this.f10987i.post(new Runnable() { // from class: androidx.media3.exoplayer.f2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f10312a.a0(pairU, exc);
                    }
                });
            }
        }

        @Override // androidx.media3.exoplayer.source.m
        public void y(int i11, @Nullable androidx.media3.exoplayer.source.l.b bVar, final p4.n nVar, final p4.o oVar) {
            final Pair<Integer, androidx.media3.exoplayer.source.l.b> pairU = U(i11, bVar);
            if (pairU != null) {
                r2.this.f10987i.post(new Runnable() { // from class: androidx.media3.exoplayer.k2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f10651a.c0(pairU, nVar, oVar);
                    }
                });
            }
        }

        @Override // androidx.media3.exoplayer.drm.b
        public void z(int i11, @Nullable androidx.media3.exoplayer.source.l.b bVar) {
            final Pair<Integer, androidx.media3.exoplayer.source.l.b> pairU = U(i11, bVar);
            if (pairU != null) {
                r2.this.f10987i.post(new Runnable() { // from class: androidx.media3.exoplayer.g2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f10326a.Y(pairU);
                    }
                });
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final androidx.media3.exoplayer.source.l f10993a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final androidx.media3.exoplayer.source.l.c f10994b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final a f10995c;

        public b(androidx.media3.exoplayer.source.l lVar, androidx.media3.exoplayer.source.l.c cVar, a aVar) {
            this.f10993a = lVar;
            this.f10994b = cVar;
            this.f10995c = aVar;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c implements d2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final androidx.media3.exoplayer.source.j f10996a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f10999d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f11000e;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<androidx.media3.exoplayer.source.l.b> f10998c = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f10997b = new Object();

        public c(androidx.media3.exoplayer.source.l lVar, boolean z11) {
            this.f10996a = new androidx.media3.exoplayer.source.j(lVar, z11);
        }

        @Override // androidx.media3.exoplayer.d2
        public Object a() {
            return this.f10997b;
        }

        @Override // androidx.media3.exoplayer.d2
        public androidx.media3.common.m0 b() {
            return this.f10996a.W();
        }

        public void c(int i11) {
            this.f10999d = i11;
            this.f11000e = false;
            this.f10998c.clear();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface d {
        void a();
    }

    public r2(d dVar, e4.a aVar, z3.j jVar, x3 x3Var) {
        this.f10979a = x3Var;
        this.f10983e = dVar;
        this.f10986h = aVar;
        this.f10987i = jVar;
    }

    public static Object m(Object obj) {
        return androidx.media3.exoplayer.a.v(obj);
    }

    @Nullable
    public static androidx.media3.exoplayer.source.l.b n(c cVar, androidx.media3.exoplayer.source.l.b bVar) {
        for (int i11 = 0; i11 < cVar.f10998c.size(); i11++) {
            if (cVar.f10998c.get(i11).f11212d == bVar.f11212d) {
                return bVar.a(p(cVar, bVar.f11209a));
            }
        }
        return null;
    }

    public static Object o(Object obj) {
        return androidx.media3.exoplayer.a.w(obj);
    }

    public static Object p(c cVar, Object obj) {
        return androidx.media3.exoplayer.a.y(cVar.f10997b, obj);
    }

    public static int s(c cVar, int i11) {
        return i11 + cVar.f10999d;
    }

    public void A(androidx.media3.exoplayer.source.k kVar) {
        c cVar = (c) z3.a.e(this.f10981c.remove(kVar));
        cVar.f10996a.l(kVar);
        cVar.f10998c.remove(((androidx.media3.exoplayer.source.i) kVar).f11188a);
        if (!this.f10981c.isEmpty()) {
            k();
        }
        v(cVar);
    }

    public androidx.media3.common.m0 B(int i11, int i12, p4.f0 f0Var) {
        z3.a.a(i11 >= 0 && i11 <= i12 && i12 <= r());
        this.f10988j = f0Var;
        C(i11, i12);
        return i();
    }

    public final void C(int i11, int i12) {
        for (int i13 = i12 - 1; i13 >= i11; i13--) {
            c cVarRemove = this.f10980b.remove(i13);
            this.f10982d.remove(cVarRemove.f10997b);
            g(i13, -cVarRemove.f10996a.W().p());
            cVarRemove.f11000e = true;
            if (this.f10989k) {
                v(cVarRemove);
            }
        }
    }

    public androidx.media3.common.m0 D(List<c> list, p4.f0 f0Var) {
        C(0, this.f10980b.size());
        return f(this.f10980b.size(), list, f0Var);
    }

    public androidx.media3.common.m0 E(p4.f0 f0Var) {
        int iR = r();
        if (f0Var.getLength() != iR) {
            f0Var = f0Var.cloneAndClear().cloneAndInsert(0, iR);
        }
        this.f10988j = f0Var;
        return i();
    }

    public androidx.media3.common.m0 F(int i11, int i12, List<androidx.media3.common.b0> list) {
        z3.a.a(i11 >= 0 && i11 <= i12 && i12 <= r());
        z3.a.a(list.size() == i12 - i11);
        for (int i13 = i11; i13 < i12; i13++) {
            this.f10980b.get(i13).f10996a.n(list.get(i13 - i11));
        }
        return i();
    }

    public androidx.media3.common.m0 f(int i11, List<c> list, p4.f0 f0Var) {
        if (!list.isEmpty()) {
            this.f10988j = f0Var;
            for (int i12 = i11; i12 < list.size() + i11; i12++) {
                c cVar = list.get(i12 - i11);
                if (i12 > 0) {
                    c cVar2 = this.f10980b.get(i12 - 1);
                    cVar.c(cVar2.f10999d + cVar2.f10996a.W().p());
                } else {
                    cVar.c(0);
                }
                g(i12, cVar.f10996a.W().p());
                this.f10980b.add(i12, cVar);
                this.f10982d.put(cVar.f10997b, cVar);
                if (this.f10989k) {
                    y(cVar);
                    if (this.f10981c.isEmpty()) {
                        this.f10985g.add(cVar);
                    } else {
                        j(cVar);
                    }
                }
            }
        }
        return i();
    }

    public final void g(int i11, int i12) {
        while (i11 < this.f10980b.size()) {
            this.f10980b.get(i11).f10999d += i12;
            i11++;
        }
    }

    public androidx.media3.exoplayer.source.k h(androidx.media3.exoplayer.source.l.b bVar, androidx.media3.exoplayer.upstream.b bVar2, long j11) {
        Object objO = o(bVar.f11209a);
        androidx.media3.exoplayer.source.l.b bVarA = bVar.a(m(bVar.f11209a));
        c cVar = (c) z3.a.e(this.f10982d.get(objO));
        l(cVar);
        cVar.f10998c.add(bVarA);
        androidx.media3.exoplayer.source.i iVarT = cVar.f10996a.h(bVarA, bVar2, j11);
        this.f10981c.put(iVarT, cVar);
        k();
        return iVarT;
    }

    public androidx.media3.common.m0 i() {
        if (this.f10980b.isEmpty()) {
            return androidx.media3.common.m0.f9282a;
        }
        int iP = 0;
        for (int i11 = 0; i11 < this.f10980b.size(); i11++) {
            c cVar = this.f10980b.get(i11);
            cVar.f10999d = iP;
            iP += cVar.f10996a.W().p();
        }
        return new u2(this.f10980b, this.f10988j);
    }

    public final void j(c cVar) {
        b bVar = this.f10984f.get(cVar);
        if (bVar != null) {
            bVar.f10993a.p(bVar.f10994b);
        }
    }

    public final void k() {
        Iterator<c> it = this.f10985g.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next.f10998c.isEmpty()) {
                j(next);
                it.remove();
            }
        }
    }

    public final void l(c cVar) {
        this.f10985g.add(cVar);
        b bVar = this.f10984f.get(cVar);
        if (bVar != null) {
            bVar.f10993a.m(bVar.f10994b);
        }
    }

    public p4.f0 q() {
        return this.f10988j;
    }

    public int r() {
        return this.f10980b.size();
    }

    public boolean t() {
        return this.f10989k;
    }

    public final /* synthetic */ void u(androidx.media3.exoplayer.source.l lVar, androidx.media3.common.m0 m0Var) {
        this.f10983e.a();
    }

    public final void v(c cVar) {
        if (cVar.f11000e && cVar.f10998c.isEmpty()) {
            b bVar = (b) z3.a.e(this.f10984f.remove(cVar));
            bVar.f10993a.o(bVar.f10994b);
            bVar.f10993a.f(bVar.f10995c);
            bVar.f10993a.k(bVar.f10995c);
            this.f10985g.remove(cVar);
        }
    }

    public androidx.media3.common.m0 w(int i11, int i12, int i13, p4.f0 f0Var) {
        z3.a.a(i11 >= 0 && i11 <= i12 && i12 <= r() && i13 >= 0);
        this.f10988j = f0Var;
        if (i11 == i12 || i11 == i13) {
            return i();
        }
        int iMin = Math.min(i11, i13);
        int iMax = Math.max(((i12 - i11) + i13) - 1, i12 - 1);
        int iP = this.f10980b.get(iMin).f10999d;
        z3.u0.R0(this.f10980b, i11, i12, i13);
        while (iMin <= iMax) {
            c cVar = this.f10980b.get(iMin);
            cVar.f10999d = iP;
            iP += cVar.f10996a.W().p();
            iMin++;
        }
        return i();
    }

    public void x(@Nullable c4.o oVar) {
        z3.a.g(!this.f10989k);
        this.f10990l = oVar;
        for (int i11 = 0; i11 < this.f10980b.size(); i11++) {
            c cVar = this.f10980b.get(i11);
            y(cVar);
            this.f10985g.add(cVar);
        }
        this.f10989k = true;
    }

    public final void y(c cVar) {
        androidx.media3.exoplayer.source.j jVar = cVar.f10996a;
        androidx.media3.exoplayer.source.l.c cVar2 = new androidx.media3.exoplayer.source.l.c() { // from class: androidx.media3.exoplayer.e2
            @Override // androidx.media3.exoplayer.source.l.c
            public final void a(androidx.media3.exoplayer.source.l lVar, androidx.media3.common.m0 m0Var) {
                this.f10310a.u(lVar, m0Var);
            }
        };
        a aVar = new a(cVar);
        this.f10984f.put(cVar, new b(jVar, cVar2, aVar));
        jVar.e(z3.u0.C(), aVar);
        jVar.j(z3.u0.C(), aVar);
        jVar.i(cVar2, this.f10990l, this.f10979a);
    }

    public void z() {
        for (b bVar : this.f10984f.values()) {
            try {
                bVar.f10993a.o(bVar.f10994b);
            } catch (RuntimeException e11) {
                z3.o.d("MediaSourceList", "Failed to release child source.", e11);
            }
            bVar.f10993a.f(bVar.f10995c);
            bVar.f10993a.k(bVar.f10995c);
        }
        this.f10984f.clear();
        this.f10985g.clear();
        this.f10989k = false;
    }
}
