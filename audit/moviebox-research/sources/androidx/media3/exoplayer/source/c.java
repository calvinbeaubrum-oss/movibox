package androidx.media3.exoplayer.source;

import android.os.Handler;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.media3.common.m0;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class c<T> extends androidx.media3.exoplayer.source.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final HashMap<T, b<T>> f11134h = new HashMap<>();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public Handler f11135i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public c4.o f11136j;

    /* JADX INFO: compiled from: source.java */
    public final class a implements m, androidx.media3.exoplayer.drm.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f11137a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public m.a f11138b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public androidx.media3.exoplayer.drm.b.a f11139c;

        public a(T t11) {
            this.f11138b = c.this.u(null);
            this.f11139c = c.this.s(null);
            this.f11137a = t11;
        }

        @Override // androidx.media3.exoplayer.source.m
        public void A(int i11, @Nullable l.b bVar, p4.n nVar, p4.o oVar) {
            if (I(i11, bVar)) {
                this.f11138b.u(nVar, J(oVar, bVar));
            }
        }

        @Override // androidx.media3.exoplayer.source.m
        public void B(int i11, @Nullable l.b bVar, p4.n nVar, p4.o oVar) {
            if (I(i11, bVar)) {
                this.f11138b.A(nVar, J(oVar, bVar));
            }
        }

        @Override // androidx.media3.exoplayer.source.m
        public void D(int i11, @Nullable l.b bVar, p4.o oVar) {
            if (I(i11, bVar)) {
                this.f11138b.D(J(oVar, bVar));
            }
        }

        @Override // androidx.media3.exoplayer.source.m
        public void E(int i11, @Nullable l.b bVar, p4.o oVar) {
            if (I(i11, bVar)) {
                this.f11138b.i(J(oVar, bVar));
            }
        }

        @Override // androidx.media3.exoplayer.drm.b
        public void F(int i11, @Nullable l.b bVar) {
            if (I(i11, bVar)) {
                this.f11139c.m();
            }
        }

        @Override // androidx.media3.exoplayer.source.m
        public void H(int i11, @Nullable l.b bVar, p4.n nVar, p4.o oVar, IOException iOException, boolean z11) {
            if (I(i11, bVar)) {
                this.f11138b.x(nVar, J(oVar, bVar), iOException, z11);
            }
        }

        public final boolean I(int i11, @Nullable l.b bVar) {
            l.b bVarD;
            if (bVar != null) {
                bVarD = c.this.D(this.f11137a, bVar);
                if (bVarD == null) {
                    return false;
                }
            } else {
                bVarD = null;
            }
            int iF = c.this.F(this.f11137a, i11);
            m.a aVar = this.f11138b;
            if (aVar.f11214a != iF || !u0.c(aVar.f11215b, bVarD)) {
                this.f11138b = c.this.t(iF, bVarD);
            }
            androidx.media3.exoplayer.drm.b.a aVar2 = this.f11139c;
            if (aVar2.f10287a == iF && u0.c(aVar2.f10288b, bVarD)) {
                return true;
            }
            this.f11139c = c.this.r(iF, bVarD);
            return true;
        }

        public final p4.o J(p4.o oVar, @Nullable l.b bVar) {
            long jE = c.this.E(this.f11137a, oVar.f73591f, bVar);
            long jE2 = c.this.E(this.f11137a, oVar.f73592g, bVar);
            return (jE == oVar.f73591f && jE2 == oVar.f73592g) ? oVar : new p4.o(oVar.f73586a, oVar.f73587b, oVar.f73588c, oVar.f73589d, oVar.f73590e, jE, jE2);
        }

        @Override // androidx.media3.exoplayer.drm.b
        public void f(int i11, @Nullable l.b bVar) {
            if (I(i11, bVar)) {
                this.f11139c.h();
            }
        }

        @Override // androidx.media3.exoplayer.drm.b
        public void p(int i11, @Nullable l.b bVar, int i12) {
            if (I(i11, bVar)) {
                this.f11139c.k(i12);
            }
        }

        @Override // androidx.media3.exoplayer.drm.b
        public /* synthetic */ void r(int i11, l.b bVar) {
            i4.k.a(this, i11, bVar);
        }

        @Override // androidx.media3.exoplayer.drm.b
        public void u(int i11, @Nullable l.b bVar) {
            if (I(i11, bVar)) {
                this.f11139c.i();
            }
        }

        @Override // androidx.media3.exoplayer.drm.b
        public void v(int i11, @Nullable l.b bVar, Exception exc) {
            if (I(i11, bVar)) {
                this.f11139c.l(exc);
            }
        }

        @Override // androidx.media3.exoplayer.source.m
        public void y(int i11, @Nullable l.b bVar, p4.n nVar, p4.o oVar) {
            if (I(i11, bVar)) {
                this.f11138b.r(nVar, J(oVar, bVar));
            }
        }

        @Override // androidx.media3.exoplayer.drm.b
        public void z(int i11, @Nullable l.b bVar) {
            if (I(i11, bVar)) {
                this.f11139c.j();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l f11141a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final l.c f11142b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c<T>.a f11143c;

        public b(l lVar, l.c cVar, c<T>.a aVar) {
            this.f11141a = lVar;
            this.f11142b = cVar;
            this.f11143c = aVar;
        }
    }

    @Override // androidx.media3.exoplayer.source.a
    @CallSuper
    public void B() {
        for (b<T> bVar : this.f11134h.values()) {
            bVar.f11141a.o(bVar.f11142b);
            bVar.f11141a.f(bVar.f11143c);
            bVar.f11141a.k(bVar.f11143c);
        }
        this.f11134h.clear();
    }

    @Nullable
    public abstract l.b D(T t11, l.b bVar);

    public long E(T t11, long j11, @Nullable l.b bVar) {
        return j11;
    }

    public int F(T t11, int i11) {
        return i11;
    }

    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public abstract void G(T t11, l lVar, m0 m0Var);

    public final void I(final T t11, l lVar) {
        z3.a.a(!this.f11134h.containsKey(t11));
        l.c cVar = new l.c() { // from class: p4.b
            @Override // androidx.media3.exoplayer.source.l.c
            public final void a(androidx.media3.exoplayer.source.l lVar2, m0 m0Var) {
                this.f73529a.G(t11, lVar2, m0Var);
            }
        };
        a aVar = new a(t11);
        this.f11134h.put(t11, new b<>(lVar, cVar, aVar));
        lVar.e((Handler) z3.a.e(this.f11135i), aVar);
        lVar.j((Handler) z3.a.e(this.f11135i), aVar);
        lVar.i(cVar, this.f11136j, x());
        if (y()) {
            return;
        }
        lVar.p(cVar);
    }

    @Override // androidx.media3.exoplayer.source.l
    @CallSuper
    public void maybeThrowSourceInfoRefreshError() throws IOException {
        Iterator<b<T>> it = this.f11134h.values().iterator();
        while (it.hasNext()) {
            it.next().f11141a.maybeThrowSourceInfoRefreshError();
        }
    }

    @Override // androidx.media3.exoplayer.source.a
    @CallSuper
    public void v() {
        for (b<T> bVar : this.f11134h.values()) {
            bVar.f11141a.p(bVar.f11142b);
        }
    }

    @Override // androidx.media3.exoplayer.source.a
    @CallSuper
    public void w() {
        for (b<T> bVar : this.f11134h.values()) {
            bVar.f11141a.m(bVar.f11142b);
        }
    }

    @Override // androidx.media3.exoplayer.source.a
    @CallSuper
    public void z(@Nullable c4.o oVar) {
        this.f11136j = oVar;
        this.f11135i = u0.A();
    }
}
