package com.applovin.impl;

import android.os.Handler;
import java.io.IOException;
import java.util.HashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b4 extends c2 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final HashMap f17818g = new HashMap();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Handler f17819h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private xo f17820i;

    /* JADX INFO: compiled from: source.java */
    public final class a implements ce, a7 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f17821a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ce.a f17822b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private a7.a f17823c;

        public a(Object obj) {
            this.f17822b = b4.this.b((be.a) null);
            this.f17823c = b4.this.a((be.a) null);
            this.f17821a = obj;
        }

        private ud a(ud udVar) {
            long jA = b4.this.a(this.f17821a, udVar.f23570f);
            long jA2 = b4.this.a(this.f17821a, udVar.f23571g);
            return (jA == udVar.f23570f && jA2 == udVar.f23571g) ? udVar : new ud(udVar.f23565a, udVar.f23566b, udVar.f23567c, udVar.f23568d, udVar.f23569e, jA, jA2);
        }

        private boolean f(int i11, be.a aVar) {
            be.a aVarA;
            if (aVar != null) {
                aVarA = b4.this.a(this.f17821a, aVar);
                if (aVarA == null) {
                    return false;
                }
            } else {
                aVarA = null;
            }
            int iA = b4.this.a(this.f17821a, i11);
            ce.a aVar2 = this.f17822b;
            if (aVar2.f18180a != iA || !xp.a(aVar2.f18181b, aVarA)) {
                this.f17822b = b4.this.a(iA, aVarA, 0L);
            }
            a7.a aVar3 = this.f17823c;
            if (aVar3.f17463a == iA && xp.a(aVar3.f17464b, aVarA)) {
                return true;
            }
            this.f17823c = b4.this.a(iA, aVarA);
            return true;
        }

        @Override // com.applovin.impl.a7
        public void a(int i11, be.a aVar) {
            if (f(i11, aVar)) {
                this.f17823c.b();
            }
        }

        @Override // com.applovin.impl.a7
        public void a(int i11, be.a aVar, int i12) {
            if (f(i11, aVar)) {
                this.f17823c.a(i12);
            }
        }

        @Override // com.applovin.impl.ce
        public void a(int i11, be.a aVar, nc ncVar, ud udVar) {
            if (f(i11, aVar)) {
                this.f17822b.a(ncVar, a(udVar));
            }
        }

        @Override // com.applovin.impl.ce
        public void a(int i11, be.a aVar, nc ncVar, ud udVar, IOException iOException, boolean z11) {
            if (f(i11, aVar)) {
                this.f17822b.a(ncVar, a(udVar), iOException, z11);
            }
        }

        @Override // com.applovin.impl.ce
        public void a(int i11, be.a aVar, ud udVar) {
            if (f(i11, aVar)) {
                this.f17822b.a(a(udVar));
            }
        }

        @Override // com.applovin.impl.a7
        public void a(int i11, be.a aVar, Exception exc) {
            if (f(i11, aVar)) {
                this.f17823c.a(exc);
            }
        }

        @Override // com.applovin.impl.a7
        public void b(int i11, be.a aVar) {
            if (f(i11, aVar)) {
                this.f17823c.d();
            }
        }

        @Override // com.applovin.impl.ce
        public void b(int i11, be.a aVar, nc ncVar, ud udVar) {
            if (f(i11, aVar)) {
                this.f17822b.c(ncVar, a(udVar));
            }
        }

        @Override // com.applovin.impl.a7
        public void c(int i11, be.a aVar) {
            if (f(i11, aVar)) {
                this.f17823c.c();
            }
        }

        @Override // com.applovin.impl.ce
        public void c(int i11, be.a aVar, nc ncVar, ud udVar) {
            if (f(i11, aVar)) {
                this.f17822b.b(ncVar, a(udVar));
            }
        }

        @Override // com.applovin.impl.a7
        public void d(int i11, be.a aVar) {
            if (f(i11, aVar)) {
                this.f17823c.a();
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
        public final be f17825a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final be.b f17826b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final a f17827c;

        public b(be beVar, be.b bVar, a aVar) {
            this.f17825a = beVar;
            this.f17826b = bVar;
            this.f17827c = aVar;
        }
    }

    public int a(Object obj, int i11) {
        return i11;
    }

    public long a(Object obj, long j11) {
        return j11;
    }

    public abstract be.a a(Object obj, be.a aVar);

    @Override // com.applovin.impl.c2
    public void a(xo xoVar) {
        this.f17820i = xoVar;
        this.f17819h = xp.a();
    }

    public final void a(final Object obj, be beVar) {
        b1.a(!this.f17818g.containsKey(obj));
        be.b bVar = new be.b() { // from class: com.applovin.impl.bt
            @Override // com.applovin.impl.be.b
            public final void a(be beVar2, fo foVar) {
                this.f18052a.a(obj, beVar2, foVar);
            }
        };
        a aVar = new a(obj);
        this.f17818g.put(obj, new b(beVar, bVar, aVar));
        beVar.a((Handler) b1.a(this.f17819h), (ce) aVar);
        beVar.a((Handler) b1.a(this.f17819h), (a7) aVar);
        beVar.a(bVar, this.f17820i);
        if (g()) {
            return;
        }
        beVar.a(bVar);
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public abstract void a(Object obj, be beVar, fo foVar);

    @Override // com.applovin.impl.c2
    public void e() {
        for (b bVar : this.f17818g.values()) {
            bVar.f17825a.a(bVar.f17826b);
        }
    }

    @Override // com.applovin.impl.c2
    public void f() {
        for (b bVar : this.f17818g.values()) {
            bVar.f17825a.b(bVar.f17826b);
        }
    }

    @Override // com.applovin.impl.c2
    public void h() {
        for (b bVar : this.f17818g.values()) {
            bVar.f17825a.c(bVar.f17826b);
            bVar.f17825a.a((ce) bVar.f17827c);
            bVar.f17825a.a((a7) bVar.f17827c);
        }
        this.f17818g.clear();
    }
}
