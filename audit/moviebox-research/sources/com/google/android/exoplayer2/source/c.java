package com.google.android.exoplayer2.source;

import android.os.Handler;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.j3;
import com.google.android.exoplayer2.upstream.k0;
import com.google.android.exoplayer2.util.o0;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class c<T> extends com.google.android.exoplayer2.source.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final HashMap<T, b<T>> f33779i = new HashMap<>();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public Handler f33780j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public k0 f33781k;

    /* JADX INFO: compiled from: source.java */
    public final class a implements j, com.google.android.exoplayer2.drm.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f33782a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public j.a f33783b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public com.google.android.exoplayer2.drm.b.a f33784c;

        public a(T t11) {
            this.f33783b = c.this.v(null);
            this.f33784c = c.this.t(null);
            this.f33782a = t11;
        }

        private boolean G(int i11, @Nullable i.b bVar) {
            i.b bVarF;
            if (bVar != null) {
                bVarF = c.this.F(this.f33782a, bVar);
                if (bVarF == null) {
                    return false;
                }
            } else {
                bVarF = null;
            }
            int iH = c.this.H(this.f33782a, i11);
            j.a aVar = this.f33783b;
            if (aVar.f34233a != iH || !o0.c(aVar.f34234b, bVarF)) {
                this.f33783b = c.this.u(iH, bVarF, 0L);
            }
            com.google.android.exoplayer2.drm.b.a aVar2 = this.f33784c;
            if (aVar2.f33165a == iH && o0.c(aVar2.f33166b, bVarF)) {
                return true;
            }
            this.f33784c = c.this.s(iH, bVarF);
            return true;
        }

        @Override // com.google.android.exoplayer2.source.j
        public void A(int i11, @Nullable i.b bVar, nh.n nVar, nh.o oVar, IOException iOException, boolean z11) {
            if (G(i11, bVar)) {
                this.f33783b.y(nVar, H(oVar), iOException, z11);
            }
        }

        @Override // com.google.android.exoplayer2.source.j
        public void B(int i11, @Nullable i.b bVar, nh.n nVar, nh.o oVar) {
            if (G(i11, bVar)) {
                this.f33783b.v(nVar, H(oVar));
            }
        }

        @Override // com.google.android.exoplayer2.drm.b
        public void C(int i11, @Nullable i.b bVar) {
            if (G(i11, bVar)) {
                this.f33784c.h();
            }
        }

        @Override // com.google.android.exoplayer2.drm.b
        public void D(int i11, @Nullable i.b bVar, int i12) {
            if (G(i11, bVar)) {
                this.f33784c.k(i12);
            }
        }

        @Override // com.google.android.exoplayer2.drm.b
        public void E(int i11, @Nullable i.b bVar) {
            if (G(i11, bVar)) {
                this.f33784c.m();
            }
        }

        @Override // com.google.android.exoplayer2.drm.b
        public void F(int i11, @Nullable i.b bVar) {
            if (G(i11, bVar)) {
                this.f33784c.j();
            }
        }

        public final nh.o H(nh.o oVar) {
            long jG = c.this.G(this.f33782a, oVar.f71958f);
            long jG2 = c.this.G(this.f33782a, oVar.f71959g);
            return (jG == oVar.f71958f && jG2 == oVar.f71959g) ? oVar : new nh.o(oVar.f71953a, oVar.f71954b, oVar.f71955c, oVar.f71956d, oVar.f71957e, jG, jG2);
        }

        @Override // com.google.android.exoplayer2.source.j
        public void f(int i11, @Nullable i.b bVar, nh.n nVar, nh.o oVar) {
            if (G(i11, bVar)) {
                this.f33783b.B(nVar, H(oVar));
            }
        }

        @Override // com.google.android.exoplayer2.source.j
        public void p(int i11, @Nullable i.b bVar, nh.o oVar) {
            if (G(i11, bVar)) {
                this.f33783b.E(H(oVar));
            }
        }

        @Override // com.google.android.exoplayer2.source.j
        public void q(int i11, @Nullable i.b bVar, nh.n nVar, nh.o oVar) {
            if (G(i11, bVar)) {
                this.f33783b.s(nVar, H(oVar));
            }
        }

        @Override // com.google.android.exoplayer2.drm.b
        public void u(int i11, @Nullable i.b bVar) {
            if (G(i11, bVar)) {
                this.f33784c.i();
            }
        }

        @Override // com.google.android.exoplayer2.drm.b
        public /* synthetic */ void v(int i11, i.b bVar) {
            sg.k.a(this, i11, bVar);
        }

        @Override // com.google.android.exoplayer2.source.j
        public void w(int i11, @Nullable i.b bVar, nh.o oVar) {
            if (G(i11, bVar)) {
                this.f33783b.j(H(oVar));
            }
        }

        @Override // com.google.android.exoplayer2.drm.b
        public void y(int i11, @Nullable i.b bVar, Exception exc) {
            if (G(i11, bVar)) {
                this.f33784c.l(exc);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final i f33786a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final i.c f33787b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c<T>.a f33788c;

        public b(i iVar, i.c cVar, c<T>.a aVar) {
            this.f33786a = iVar;
            this.f33787b = cVar;
            this.f33788c = aVar;
        }
    }

    @Override // com.google.android.exoplayer2.source.a
    @CallSuper
    public void B(@Nullable k0 k0Var) {
        this.f33781k = k0Var;
        this.f33780j = o0.w();
    }

    @Override // com.google.android.exoplayer2.source.a
    @CallSuper
    public void D() {
        for (b<T> bVar : this.f33779i.values()) {
            bVar.f33786a.f(bVar.f33787b);
            bVar.f33786a.i(bVar.f33788c);
            bVar.f33786a.r(bVar.f33788c);
        }
        this.f33779i.clear();
    }

    @Nullable
    public i.b F(T t11, i.b bVar) {
        return bVar;
    }

    public long G(T t11, long j11) {
        return j11;
    }

    public int H(T t11, int i11) {
        return i11;
    }

    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public abstract void I(T t11, i iVar, j3 j3Var);

    public final void K(final T t11, i iVar) {
        com.google.android.exoplayer2.util.a.a(!this.f33779i.containsKey(t11));
        i.c cVar = new i.c() { // from class: nh.b
            @Override // com.google.android.exoplayer2.source.i.c
            public final void a(com.google.android.exoplayer2.source.i iVar2, j3 j3Var) {
                this.f71898a.I(t11, iVar2, j3Var);
            }
        };
        a aVar = new a(t11);
        this.f33779i.put(t11, new b<>(iVar, cVar, aVar));
        iVar.h((Handler) com.google.android.exoplayer2.util.a.e(this.f33780j), aVar);
        iVar.q((Handler) com.google.android.exoplayer2.util.a.e(this.f33780j), aVar);
        iVar.o(cVar, this.f33781k, z());
        if (A()) {
            return;
        }
        iVar.p(cVar);
    }

    @Override // com.google.android.exoplayer2.source.i
    @CallSuper
    public void maybeThrowSourceInfoRefreshError() throws IOException {
        Iterator<b<T>> it = this.f33779i.values().iterator();
        while (it.hasNext()) {
            it.next().f33786a.maybeThrowSourceInfoRefreshError();
        }
    }

    @Override // com.google.android.exoplayer2.source.a
    @CallSuper
    public void x() {
        for (b<T> bVar : this.f33779i.values()) {
            bVar.f33786a.p(bVar.f33787b);
        }
    }

    @Override // com.google.android.exoplayer2.source.a
    @CallSuper
    public void y() {
        for (b<T> bVar : this.f33779i.values()) {
            bVar.f33786a.m(bVar.f33787b);
        }
    }
}
