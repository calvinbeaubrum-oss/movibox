package com.applovin.impl;

import android.os.Handler;
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
/* JADX INFO: loaded from: classes3.dex */
final class fe {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d f18970d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ce.a f18971e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final a7.a f18972f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final HashMap f18973g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Set f18974h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f18976j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private xo f18977k;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private wj f18975i = new wj.a(0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final IdentityHashMap f18968b = new IdentityHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map f18969c = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f18967a = new ArrayList();

    /* JADX INFO: compiled from: source.java */
    public final class a implements ce, a7 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c f18978a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ce.a f18979b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private a7.a f18980c;

        public a(c cVar) {
            this.f18979b = fe.this.f18971e;
            this.f18980c = fe.this.f18972f;
            this.f18978a = cVar;
        }

        private boolean f(int i11, be.a aVar) {
            be.a aVarB;
            if (aVar != null) {
                aVarB = fe.b(this.f18978a, aVar);
                if (aVarB == null) {
                    return false;
                }
            } else {
                aVarB = null;
            }
            int iB = fe.b(this.f18978a, i11);
            ce.a aVar2 = this.f18979b;
            if (aVar2.f18180a != iB || !xp.a(aVar2.f18181b, aVarB)) {
                this.f18979b = fe.this.f18971e.a(iB, aVarB, 0L);
            }
            a7.a aVar3 = this.f18980c;
            if (aVar3.f17463a == iB && xp.a(aVar3.f17464b, aVarB)) {
                return true;
            }
            this.f18980c = fe.this.f18972f.a(iB, aVarB);
            return true;
        }

        @Override // com.applovin.impl.a7
        public void a(int i11, be.a aVar) {
            if (f(i11, aVar)) {
                this.f18980c.b();
            }
        }

        @Override // com.applovin.impl.a7
        public void a(int i11, be.a aVar, int i12) {
            if (f(i11, aVar)) {
                this.f18980c.a(i12);
            }
        }

        @Override // com.applovin.impl.ce
        public void a(int i11, be.a aVar, nc ncVar, ud udVar) {
            if (f(i11, aVar)) {
                this.f18979b.a(ncVar, udVar);
            }
        }

        @Override // com.applovin.impl.ce
        public void a(int i11, be.a aVar, nc ncVar, ud udVar, IOException iOException, boolean z11) {
            if (f(i11, aVar)) {
                this.f18979b.a(ncVar, udVar, iOException, z11);
            }
        }

        @Override // com.applovin.impl.ce
        public void a(int i11, be.a aVar, ud udVar) {
            if (f(i11, aVar)) {
                this.f18979b.a(udVar);
            }
        }

        @Override // com.applovin.impl.a7
        public void a(int i11, be.a aVar, Exception exc) {
            if (f(i11, aVar)) {
                this.f18980c.a(exc);
            }
        }

        @Override // com.applovin.impl.a7
        public void b(int i11, be.a aVar) {
            if (f(i11, aVar)) {
                this.f18980c.d();
            }
        }

        @Override // com.applovin.impl.ce
        public void b(int i11, be.a aVar, nc ncVar, ud udVar) {
            if (f(i11, aVar)) {
                this.f18979b.c(ncVar, udVar);
            }
        }

        @Override // com.applovin.impl.a7
        public void c(int i11, be.a aVar) {
            if (f(i11, aVar)) {
                this.f18980c.c();
            }
        }

        @Override // com.applovin.impl.ce
        public void c(int i11, be.a aVar, nc ncVar, ud udVar) {
            if (f(i11, aVar)) {
                this.f18979b.b(ncVar, udVar);
            }
        }

        @Override // com.applovin.impl.a7
        public void d(int i11, be.a aVar) {
            if (f(i11, aVar)) {
                this.f18980c.a();
            }
        }

        @Override // com.applovin.impl.a7
        public /* synthetic */ void e(int i11, be.a aVar) {
            js.a(this, i11, aVar);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final be f18982a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final be.b f18983b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final a f18984c;

        public b(be beVar, be.b bVar, a aVar) {
            this.f18982a = beVar;
            this.f18983b = bVar;
            this.f18984c = aVar;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c implements ee {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xc f18985a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f18988d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f18989e;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List f18987c = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f18986b = new Object();

        public c(be beVar, boolean z11) {
            this.f18985a = new xc(beVar, z11);
        }

        @Override // com.applovin.impl.ee
        public Object a() {
            return this.f18986b;
        }

        public void a(int i11) {
            this.f18988d = i11;
            this.f18989e = false;
            this.f18987c.clear();
        }

        @Override // com.applovin.impl.ee
        public fo b() {
            return this.f18985a.i();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface d {
        void a();
    }

    public fe(d dVar, r0 r0Var, Handler handler) {
        this.f18970d = dVar;
        ce.a aVar = new ce.a();
        this.f18971e = aVar;
        a7.a aVar2 = new a7.a();
        this.f18972f = aVar2;
        this.f18973g = new HashMap();
        this.f18974h = new HashSet();
        if (r0Var != null) {
            aVar.a(handler, r0Var);
            aVar2.a(handler, r0Var);
        }
    }

    private static Object a(c cVar, Object obj) {
        return com.applovin.impl.b.a(cVar.f18986b, obj);
    }

    private static Object a(Object obj) {
        return com.applovin.impl.b.c(obj);
    }

    private void a(int i11, int i12) {
        while (i11 < this.f18967a.size()) {
            ((c) this.f18967a.get(i11)).f18988d += i12;
            i11++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(be beVar, fo foVar) {
        this.f18970d.a();
    }

    private void a(c cVar) {
        b bVar = (b) this.f18973g.get(cVar);
        if (bVar != null) {
            bVar.f18982a.a(bVar.f18983b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(c cVar, int i11) {
        return i11 + cVar.f18988d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static be.a b(c cVar, be.a aVar) {
        for (int i11 = 0; i11 < cVar.f18987c.size(); i11++) {
            if (((be.a) cVar.f18987c.get(i11)).f24656d == aVar.f24656d) {
                return aVar.b(a(cVar, aVar.f24653a));
            }
        }
        return null;
    }

    private static Object b(Object obj) {
        return com.applovin.impl.b.d(obj);
    }

    private void b() {
        Iterator it = this.f18974h.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar.f18987c.isEmpty()) {
                a(cVar);
                it.remove();
            }
        }
    }

    private void b(int i11, int i12) {
        for (int i13 = i12 - 1; i13 >= i11; i13--) {
            c cVar = (c) this.f18967a.remove(i13);
            this.f18969c.remove(cVar.f18986b);
            a(i13, -cVar.f18985a.i().b());
            cVar.f18989e = true;
            if (this.f18976j) {
                c(cVar);
            }
        }
    }

    private void b(c cVar) {
        this.f18974h.add(cVar);
        b bVar = (b) this.f18973g.get(cVar);
        if (bVar != null) {
            bVar.f18982a.b(bVar.f18983b);
        }
    }

    private void c(c cVar) {
        if (cVar.f18989e && cVar.f18987c.isEmpty()) {
            b bVar = (b) b1.a((b) this.f18973g.remove(cVar));
            bVar.f18982a.c(bVar.f18983b);
            bVar.f18982a.a((ce) bVar.f18984c);
            bVar.f18982a.a((a7) bVar.f18984c);
            this.f18974h.remove(cVar);
        }
    }

    private void d(c cVar) {
        xc xcVar = cVar.f18985a;
        be.b bVar = new be.b() { // from class: com.applovin.impl.ov
            @Override // com.applovin.impl.be.b
            public final void a(be beVar, fo foVar) {
                this.f21622a.a(beVar, foVar);
            }
        };
        a aVar = new a(cVar);
        this.f18973g.put(cVar, new b(xcVar, bVar, aVar));
        xcVar.a(xp.b(), (ce) aVar);
        xcVar.a(xp.b(), (a7) aVar);
        xcVar.a(bVar, this.f18977k);
    }

    public fo a() {
        if (this.f18967a.isEmpty()) {
            return fo.f19028a;
        }
        int iB = 0;
        for (int i11 = 0; i11 < this.f18967a.size(); i11++) {
            c cVar = (c) this.f18967a.get(i11);
            cVar.f18988d = iB;
            iB += cVar.f18985a.i().b();
        }
        return new sh(this.f18967a, this.f18975i);
    }

    public fo a(int i11, int i12, wj wjVar) {
        b1.a(i11 >= 0 && i11 <= i12 && i12 <= c());
        this.f18975i = wjVar;
        b(i11, i12);
        return a();
    }

    public fo a(int i11, List list, wj wjVar) {
        if (!list.isEmpty()) {
            this.f18975i = wjVar;
            for (int i12 = i11; i12 < list.size() + i11; i12++) {
                c cVar = (c) list.get(i12 - i11);
                if (i12 > 0) {
                    c cVar2 = (c) this.f18967a.get(i12 - 1);
                    cVar.a(cVar2.f18988d + cVar2.f18985a.i().b());
                } else {
                    cVar.a(0);
                }
                a(i12, cVar.f18985a.i().b());
                this.f18967a.add(i12, cVar);
                this.f18969c.put(cVar.f18986b, cVar);
                if (this.f18976j) {
                    d(cVar);
                    if (this.f18968b.isEmpty()) {
                        this.f18974h.add(cVar);
                    } else {
                        a(cVar);
                    }
                }
            }
        }
        return a();
    }

    public fo a(wj wjVar) {
        int iC = c();
        if (wjVar.a() != iC) {
            wjVar = wjVar.d().b(0, iC);
        }
        this.f18975i = wjVar;
        return a();
    }

    public fo a(List list, wj wjVar) {
        b(0, this.f18967a.size());
        return a(this.f18967a.size(), list, wjVar);
    }

    public wd a(be.a aVar, n0 n0Var, long j11) {
        Object objB = b(aVar.f24653a);
        be.a aVarB = aVar.b(a(aVar.f24653a));
        c cVar = (c) b1.a((c) this.f18969c.get(objB));
        b(cVar);
        cVar.f18987c.add(aVarB);
        wc wcVarA = cVar.f18985a.a(aVarB, n0Var, j11);
        this.f18968b.put(wcVarA, cVar);
        b();
        return wcVarA;
    }

    public void a(wd wdVar) {
        c cVar = (c) b1.a((c) this.f18968b.remove(wdVar));
        cVar.f18985a.a(wdVar);
        cVar.f18987c.remove(((wc) wdVar).f24080a);
        if (!this.f18968b.isEmpty()) {
            b();
        }
        c(cVar);
    }

    public void a(xo xoVar) {
        b1.b(!this.f18976j);
        this.f18977k = xoVar;
        for (int i11 = 0; i11 < this.f18967a.size(); i11++) {
            c cVar = (c) this.f18967a.get(i11);
            d(cVar);
            this.f18974h.add(cVar);
        }
        this.f18976j = true;
    }

    public int c() {
        return this.f18967a.size();
    }

    public boolean d() {
        return this.f18976j;
    }

    public void e() {
        for (b bVar : this.f18973g.values()) {
            try {
                bVar.f18982a.c(bVar.f18983b);
            } catch (RuntimeException e11) {
                pc.a("MediaSourceList", "Failed to release child source.", e11);
            }
            bVar.f18982a.a((ce) bVar.f18984c);
            bVar.f18982a.a((a7) bVar.f18984c);
        }
        this.f18973g.clear();
        this.f18974h.clear();
        this.f18976j = false;
    }
}
