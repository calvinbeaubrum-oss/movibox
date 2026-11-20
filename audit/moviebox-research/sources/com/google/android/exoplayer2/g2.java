package com.google.android.exoplayer2;

import android.os.Handler;
import androidx.annotation.Nullable;
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
/* JADX INFO: loaded from: classes4.dex */
public final class g2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final qg.u1 f33229a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d f33233e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.google.android.exoplayer2.source.j.a f33234f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.google.android.exoplayer2.drm.b.a f33235g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final HashMap<c, b> f33236h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Set<c> f33237i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f33239k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    public com.google.android.exoplayer2.upstream.k0 f33240l;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public nh.e0 f33238j = new nh.e0.a(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IdentityHashMap<com.google.android.exoplayer2.source.h, c> f33231c = new IdentityHashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<Object, c> f33232d = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<c> f33230b = new ArrayList();

    /* JADX INFO: compiled from: source.java */
    public final class a implements com.google.android.exoplayer2.source.j, com.google.android.exoplayer2.drm.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f33241a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public com.google.android.exoplayer2.source.j.a f33242b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public com.google.android.exoplayer2.drm.b.a f33243c;

        public a(c cVar) {
            this.f33242b = g2.this.f33234f;
            this.f33243c = g2.this.f33235g;
            this.f33241a = cVar;
        }

        @Override // com.google.android.exoplayer2.source.j
        public void A(int i11, @Nullable com.google.android.exoplayer2.source.i.b bVar, nh.n nVar, nh.o oVar, IOException iOException, boolean z11) {
            if (G(i11, bVar)) {
                this.f33242b.y(nVar, oVar, iOException, z11);
            }
        }

        @Override // com.google.android.exoplayer2.source.j
        public void B(int i11, @Nullable com.google.android.exoplayer2.source.i.b bVar, nh.n nVar, nh.o oVar) {
            if (G(i11, bVar)) {
                this.f33242b.v(nVar, oVar);
            }
        }

        @Override // com.google.android.exoplayer2.drm.b
        public void C(int i11, @Nullable com.google.android.exoplayer2.source.i.b bVar) {
            if (G(i11, bVar)) {
                this.f33243c.h();
            }
        }

        @Override // com.google.android.exoplayer2.drm.b
        public void D(int i11, @Nullable com.google.android.exoplayer2.source.i.b bVar, int i12) {
            if (G(i11, bVar)) {
                this.f33243c.k(i12);
            }
        }

        @Override // com.google.android.exoplayer2.drm.b
        public void E(int i11, @Nullable com.google.android.exoplayer2.source.i.b bVar) {
            if (G(i11, bVar)) {
                this.f33243c.m();
            }
        }

        @Override // com.google.android.exoplayer2.drm.b
        public void F(int i11, @Nullable com.google.android.exoplayer2.source.i.b bVar) {
            if (G(i11, bVar)) {
                this.f33243c.j();
            }
        }

        public final boolean G(int i11, @Nullable com.google.android.exoplayer2.source.i.b bVar) {
            com.google.android.exoplayer2.source.i.b bVarN;
            if (bVar != null) {
                bVarN = g2.n(this.f33241a, bVar);
                if (bVarN == null) {
                    return false;
                }
            } else {
                bVarN = null;
            }
            int iR = g2.r(this.f33241a, i11);
            com.google.android.exoplayer2.source.j.a aVar = this.f33242b;
            if (aVar.f34233a != iR || !com.google.android.exoplayer2.util.o0.c(aVar.f34234b, bVarN)) {
                this.f33242b = g2.this.f33234f.F(iR, bVarN, 0L);
            }
            com.google.android.exoplayer2.drm.b.a aVar2 = this.f33243c;
            if (aVar2.f33165a == iR && com.google.android.exoplayer2.util.o0.c(aVar2.f33166b, bVarN)) {
                return true;
            }
            this.f33243c = g2.this.f33235g.u(iR, bVarN);
            return true;
        }

        @Override // com.google.android.exoplayer2.source.j
        public void f(int i11, @Nullable com.google.android.exoplayer2.source.i.b bVar, nh.n nVar, nh.o oVar) {
            if (G(i11, bVar)) {
                this.f33242b.B(nVar, oVar);
            }
        }

        @Override // com.google.android.exoplayer2.source.j
        public void p(int i11, @Nullable com.google.android.exoplayer2.source.i.b bVar, nh.o oVar) {
            if (G(i11, bVar)) {
                this.f33242b.E(oVar);
            }
        }

        @Override // com.google.android.exoplayer2.source.j
        public void q(int i11, @Nullable com.google.android.exoplayer2.source.i.b bVar, nh.n nVar, nh.o oVar) {
            if (G(i11, bVar)) {
                this.f33242b.s(nVar, oVar);
            }
        }

        @Override // com.google.android.exoplayer2.drm.b
        public void u(int i11, @Nullable com.google.android.exoplayer2.source.i.b bVar) {
            if (G(i11, bVar)) {
                this.f33243c.i();
            }
        }

        @Override // com.google.android.exoplayer2.drm.b
        public /* synthetic */ void v(int i11, com.google.android.exoplayer2.source.i.b bVar) {
            sg.k.a(this, i11, bVar);
        }

        @Override // com.google.android.exoplayer2.source.j
        public void w(int i11, @Nullable com.google.android.exoplayer2.source.i.b bVar, nh.o oVar) {
            if (G(i11, bVar)) {
                this.f33242b.j(oVar);
            }
        }

        @Override // com.google.android.exoplayer2.drm.b
        public void y(int i11, @Nullable com.google.android.exoplayer2.source.i.b bVar, Exception exc) {
            if (G(i11, bVar)) {
                this.f33243c.l(exc);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.google.android.exoplayer2.source.i f33245a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.google.android.exoplayer2.source.i.c f33246b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final a f33247c;

        public b(com.google.android.exoplayer2.source.i iVar, com.google.android.exoplayer2.source.i.c cVar, a aVar) {
            this.f33245a = iVar;
            this.f33246b = cVar;
            this.f33247c = aVar;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c implements e2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.google.android.exoplayer2.source.g f33248a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f33251d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f33252e;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<com.google.android.exoplayer2.source.i.b> f33250c = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f33249b = new Object();

        public c(com.google.android.exoplayer2.source.i iVar, boolean z11) {
            this.f33248a = new com.google.android.exoplayer2.source.g(iVar, z11);
        }

        @Override // com.google.android.exoplayer2.e2
        public Object a() {
            return this.f33249b;
        }

        @Override // com.google.android.exoplayer2.e2
        public j3 b() {
            return this.f33248a.P();
        }

        public void c(int i11) {
            this.f33251d = i11;
            this.f33252e = false;
            this.f33250c.clear();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface d {
        void a();
    }

    public g2(d dVar, qg.a aVar, Handler handler, qg.u1 u1Var) {
        this.f33229a = u1Var;
        this.f33233e = dVar;
        com.google.android.exoplayer2.source.j.a aVar2 = new com.google.android.exoplayer2.source.j.a();
        this.f33234f = aVar2;
        com.google.android.exoplayer2.drm.b.a aVar3 = new com.google.android.exoplayer2.drm.b.a();
        this.f33235g = aVar3;
        this.f33236h = new HashMap<>();
        this.f33237i = new HashSet();
        aVar2.g(handler, aVar);
        aVar3.g(handler, aVar);
    }

    public static Object m(Object obj) {
        return com.google.android.exoplayer2.a.B(obj);
    }

    @Nullable
    public static com.google.android.exoplayer2.source.i.b n(c cVar, com.google.android.exoplayer2.source.i.b bVar) {
        for (int i11 = 0; i11 < cVar.f33250c.size(); i11++) {
            if (cVar.f33250c.get(i11).f71963d == bVar.f71963d) {
                return bVar.c(p(cVar, bVar.f71960a));
            }
        }
        return null;
    }

    public static Object o(Object obj) {
        return com.google.android.exoplayer2.a.C(obj);
    }

    public static Object p(c cVar, Object obj) {
        return com.google.android.exoplayer2.a.E(cVar.f33249b, obj);
    }

    public static int r(c cVar, int i11) {
        return i11 + cVar.f33251d;
    }

    public j3 A(int i11, int i12, nh.e0 e0Var) {
        com.google.android.exoplayer2.util.a.a(i11 >= 0 && i11 <= i12 && i12 <= q());
        this.f33238j = e0Var;
        B(i11, i12);
        return i();
    }

    public final void B(int i11, int i12) {
        for (int i13 = i12 - 1; i13 >= i11; i13--) {
            c cVarRemove = this.f33230b.remove(i13);
            this.f33232d.remove(cVarRemove.f33249b);
            g(i13, -cVarRemove.f33248a.P().t());
            cVarRemove.f33252e = true;
            if (this.f33239k) {
                u(cVarRemove);
            }
        }
    }

    public j3 C(List<c> list, nh.e0 e0Var) {
        B(0, this.f33230b.size());
        return f(this.f33230b.size(), list, e0Var);
    }

    public j3 D(nh.e0 e0Var) {
        int iQ = q();
        if (e0Var.getLength() != iQ) {
            e0Var = e0Var.cloneAndClear().cloneAndInsert(0, iQ);
        }
        this.f33238j = e0Var;
        return i();
    }

    public j3 f(int i11, List<c> list, nh.e0 e0Var) {
        if (!list.isEmpty()) {
            this.f33238j = e0Var;
            for (int i12 = i11; i12 < list.size() + i11; i12++) {
                c cVar = list.get(i12 - i11);
                if (i12 > 0) {
                    c cVar2 = this.f33230b.get(i12 - 1);
                    cVar.c(cVar2.f33251d + cVar2.f33248a.P().t());
                } else {
                    cVar.c(0);
                }
                g(i12, cVar.f33248a.P().t());
                this.f33230b.add(i12, cVar);
                this.f33232d.put(cVar.f33249b, cVar);
                if (this.f33239k) {
                    x(cVar);
                    if (this.f33231c.isEmpty()) {
                        this.f33237i.add(cVar);
                    } else {
                        j(cVar);
                    }
                }
            }
        }
        return i();
    }

    public final void g(int i11, int i12) {
        while (i11 < this.f33230b.size()) {
            this.f33230b.get(i11).f33251d += i12;
            i11++;
        }
    }

    public com.google.android.exoplayer2.source.h h(com.google.android.exoplayer2.source.i.b bVar, com.google.android.exoplayer2.upstream.b bVar2, long j11) {
        Object objO = o(bVar.f71960a);
        com.google.android.exoplayer2.source.i.b bVarC = bVar.c(m(bVar.f71960a));
        c cVar = (c) com.google.android.exoplayer2.util.a.e(this.f33232d.get(objO));
        l(cVar);
        cVar.f33250c.add(bVarC);
        com.google.android.exoplayer2.source.f fVarE = cVar.f33248a.e(bVarC, bVar2, j11);
        this.f33231c.put(fVarE, cVar);
        k();
        return fVarE;
    }

    public j3 i() {
        if (this.f33230b.isEmpty()) {
            return j3.f33359a;
        }
        int iT = 0;
        for (int i11 = 0; i11 < this.f33230b.size(); i11++) {
            c cVar = this.f33230b.get(i11);
            cVar.f33251d = iT;
            iT += cVar.f33248a.P().t();
        }
        return new s2(this.f33230b, this.f33238j);
    }

    public final void j(c cVar) {
        b bVar = this.f33236h.get(cVar);
        if (bVar != null) {
            bVar.f33245a.p(bVar.f33246b);
        }
    }

    public final void k() {
        Iterator<c> it = this.f33237i.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next.f33250c.isEmpty()) {
                j(next);
                it.remove();
            }
        }
    }

    public final void l(c cVar) {
        this.f33237i.add(cVar);
        b bVar = this.f33236h.get(cVar);
        if (bVar != null) {
            bVar.f33245a.m(bVar.f33246b);
        }
    }

    public int q() {
        return this.f33230b.size();
    }

    public boolean s() {
        return this.f33239k;
    }

    public final /* synthetic */ void t(com.google.android.exoplayer2.source.i iVar, j3 j3Var) {
        this.f33233e.a();
    }

    public final void u(c cVar) {
        if (cVar.f33252e && cVar.f33250c.isEmpty()) {
            b bVar = (b) com.google.android.exoplayer2.util.a.e(this.f33236h.remove(cVar));
            bVar.f33245a.f(bVar.f33246b);
            bVar.f33245a.i(bVar.f33247c);
            bVar.f33245a.r(bVar.f33247c);
            this.f33237i.remove(cVar);
        }
    }

    public j3 v(int i11, int i12, int i13, nh.e0 e0Var) {
        com.google.android.exoplayer2.util.a.a(i11 >= 0 && i11 <= i12 && i12 <= q() && i13 >= 0);
        this.f33238j = e0Var;
        if (i11 == i12 || i11 == i13) {
            return i();
        }
        int iMin = Math.min(i11, i13);
        int iMax = Math.max(((i12 - i11) + i13) - 1, i12 - 1);
        int iT = this.f33230b.get(iMin).f33251d;
        com.google.android.exoplayer2.util.o0.B0(this.f33230b, i11, i12, i13);
        while (iMin <= iMax) {
            c cVar = this.f33230b.get(iMin);
            cVar.f33251d = iT;
            iT += cVar.f33248a.P().t();
            iMin++;
        }
        return i();
    }

    public void w(@Nullable com.google.android.exoplayer2.upstream.k0 k0Var) {
        com.google.android.exoplayer2.util.a.g(!this.f33239k);
        this.f33240l = k0Var;
        for (int i11 = 0; i11 < this.f33230b.size(); i11++) {
            c cVar = this.f33230b.get(i11);
            x(cVar);
            this.f33237i.add(cVar);
        }
        this.f33239k = true;
    }

    public final void x(c cVar) {
        com.google.android.exoplayer2.source.g gVar = cVar.f33248a;
        com.google.android.exoplayer2.source.i.c cVar2 = new com.google.android.exoplayer2.source.i.c() { // from class: com.google.android.exoplayer2.f2
            @Override // com.google.android.exoplayer2.source.i.c
            public final void a(com.google.android.exoplayer2.source.i iVar, j3 j3Var) {
                this.f33225a.t(iVar, j3Var);
            }
        };
        a aVar = new a(cVar);
        this.f33236h.put(cVar, new b(gVar, cVar2, aVar));
        gVar.h(com.google.android.exoplayer2.util.o0.y(), aVar);
        gVar.q(com.google.android.exoplayer2.util.o0.y(), aVar);
        gVar.o(cVar2, this.f33240l, this.f33229a);
    }

    public void y() {
        for (b bVar : this.f33236h.values()) {
            try {
                bVar.f33245a.f(bVar.f33246b);
            } catch (RuntimeException e11) {
                com.google.android.exoplayer2.util.s.d("MediaSourceList", "Failed to release child source.", e11);
            }
            bVar.f33245a.i(bVar.f33247c);
            bVar.f33245a.r(bVar.f33247c);
        }
        this.f33236h.clear();
        this.f33237i.clear();
        this.f33239k = false;
    }

    public void z(com.google.android.exoplayer2.source.h hVar) {
        c cVar = (c) com.google.android.exoplayer2.util.a.e(this.f33231c.remove(hVar));
        cVar.f33248a.k(hVar);
        cVar.f33250c.remove(((com.google.android.exoplayer2.source.f) hVar).f33928a);
        if (!this.f33231c.isEmpty()) {
            k();
        }
        u(cVar);
    }
}
