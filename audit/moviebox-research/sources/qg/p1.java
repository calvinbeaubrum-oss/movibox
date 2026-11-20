package qg;

import android.os.Looper;
import android.util.SparseArray;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.PointerIconCompat;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.j3;
import com.google.android.exoplayer2.m2;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.n2;
import com.google.android.exoplayer2.o3;
import com.google.android.exoplayer2.z1;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class p1 implements qg.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.android.exoplayer2.util.e f74671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j3.b f74672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j3.d f74673c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f74674d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SparseArray<c.a> f74675f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.google.android.exoplayer2.util.r<c> f74676g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public n2 f74677h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.google.android.exoplayer2.util.o f74678i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f74679j;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final j3.b f74680a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ImmutableList<com.google.android.exoplayer2.source.i.b> f74681b = ImmutableList.of();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ImmutableMap<com.google.android.exoplayer2.source.i.b, j3> f74682c = ImmutableMap.of();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public com.google.android.exoplayer2.source.i.b f74683d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public com.google.android.exoplayer2.source.i.b f74684e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public com.google.android.exoplayer2.source.i.b f74685f;

        public a(j3.b bVar) {
            this.f74680a = bVar;
        }

        @Nullable
        public static com.google.android.exoplayer2.source.i.b c(n2 n2Var, ImmutableList<com.google.android.exoplayer2.source.i.b> immutableList, @Nullable com.google.android.exoplayer2.source.i.b bVar, j3.b bVar2) {
            j3 currentTimeline = n2Var.getCurrentTimeline();
            int currentPeriodIndex = n2Var.getCurrentPeriodIndex();
            Object objQ = currentTimeline.u() ? null : currentTimeline.q(currentPeriodIndex);
            int iG = (n2Var.isPlayingAd() || currentTimeline.u()) ? -1 : currentTimeline.j(currentPeriodIndex, bVar2).g(com.google.android.exoplayer2.util.o0.C0(n2Var.getCurrentPosition()) - bVar2.q());
            for (int i11 = 0; i11 < immutableList.size(); i11++) {
                com.google.android.exoplayer2.source.i.b bVar3 = immutableList.get(i11);
                if (i(bVar3, objQ, n2Var.isPlayingAd(), n2Var.getCurrentAdGroupIndex(), n2Var.getCurrentAdIndexInAdGroup(), iG)) {
                    return bVar3;
                }
            }
            if (immutableList.isEmpty() && bVar != null) {
                if (i(bVar, objQ, n2Var.isPlayingAd(), n2Var.getCurrentAdGroupIndex(), n2Var.getCurrentAdIndexInAdGroup(), iG)) {
                    return bVar;
                }
            }
            return null;
        }

        public static boolean i(com.google.android.exoplayer2.source.i.b bVar, @Nullable Object obj, boolean z11, int i11, int i12, int i13) {
            if (bVar.f71960a.equals(obj)) {
                return (z11 && bVar.f71961b == i11 && bVar.f71962c == i12) || (!z11 && bVar.f71961b == -1 && bVar.f71964e == i13);
            }
            return false;
        }

        public final void b(ImmutableMap.b<com.google.android.exoplayer2.source.i.b, j3> bVar, @Nullable com.google.android.exoplayer2.source.i.b bVar2, j3 j3Var) {
            if (bVar2 == null) {
                return;
            }
            if (j3Var.f(bVar2.f71960a) != -1) {
                bVar.g(bVar2, j3Var);
                return;
            }
            j3 j3Var2 = this.f74682c.get(bVar2);
            if (j3Var2 != null) {
                bVar.g(bVar2, j3Var2);
            }
        }

        @Nullable
        public com.google.android.exoplayer2.source.i.b d() {
            return this.f74683d;
        }

        @Nullable
        public com.google.android.exoplayer2.source.i.b e() {
            if (this.f74681b.isEmpty()) {
                return null;
            }
            return (com.google.android.exoplayer2.source.i.b) com.google.common.collect.e0.g(this.f74681b);
        }

        @Nullable
        public j3 f(com.google.android.exoplayer2.source.i.b bVar) {
            return this.f74682c.get(bVar);
        }

        @Nullable
        public com.google.android.exoplayer2.source.i.b g() {
            return this.f74684e;
        }

        @Nullable
        public com.google.android.exoplayer2.source.i.b h() {
            return this.f74685f;
        }

        public void j(n2 n2Var) {
            this.f74683d = c(n2Var, this.f74681b, this.f74684e, this.f74680a);
        }

        public void k(List<com.google.android.exoplayer2.source.i.b> list, @Nullable com.google.android.exoplayer2.source.i.b bVar, n2 n2Var) {
            this.f74681b = ImmutableList.copyOf((Collection) list);
            if (!list.isEmpty()) {
                this.f74684e = list.get(0);
                this.f74685f = (com.google.android.exoplayer2.source.i.b) com.google.android.exoplayer2.util.a.e(bVar);
            }
            if (this.f74683d == null) {
                this.f74683d = c(n2Var, this.f74681b, this.f74684e, this.f74680a);
            }
            m(n2Var.getCurrentTimeline());
        }

        public void l(n2 n2Var) {
            this.f74683d = c(n2Var, this.f74681b, this.f74684e, this.f74680a);
            m(n2Var.getCurrentTimeline());
        }

        public final void m(j3 j3Var) {
            ImmutableMap.b<com.google.android.exoplayer2.source.i.b, j3> bVarBuilder = ImmutableMap.builder();
            if (this.f74681b.isEmpty()) {
                b(bVarBuilder, this.f74684e, j3Var);
                if (!com.google.common.base.j.a(this.f74685f, this.f74684e)) {
                    b(bVarBuilder, this.f74685f, j3Var);
                }
                if (!com.google.common.base.j.a(this.f74683d, this.f74684e) && !com.google.common.base.j.a(this.f74683d, this.f74685f)) {
                    b(bVarBuilder, this.f74683d, j3Var);
                }
            } else {
                for (int i11 = 0; i11 < this.f74681b.size(); i11++) {
                    b(bVarBuilder, this.f74681b.get(i11), j3Var);
                }
                if (!this.f74681b.contains(this.f74683d)) {
                    b(bVarBuilder, this.f74683d, j3Var);
                }
            }
            this.f74682c = bVarBuilder.d();
        }
    }

    public p1(com.google.android.exoplayer2.util.e eVar) {
        this.f74671a = (com.google.android.exoplayer2.util.e) com.google.android.exoplayer2.util.a.e(eVar);
        this.f74676g = new com.google.android.exoplayer2.util.r<>(com.google.android.exoplayer2.util.o0.Q(), eVar, new com.google.android.exoplayer2.util.r.b() { // from class: qg.m0
            @Override // com.google.android.exoplayer2.util.r.b
            public final void a(Object obj, com.google.android.exoplayer2.util.m mVar) {
                p1.a1((c) obj, mVar);
            }
        });
        j3.b bVar = new j3.b();
        this.f74672b = bVar;
        this.f74673c = new j3.d();
        this.f74674d = new a(bVar);
        this.f74675f = new SparseArray<>();
    }

    public static /* synthetic */ void P1(c.a aVar, int i11, n2.e eVar, n2.e eVar2, c cVar) {
        cVar.J(aVar, i11);
        cVar.S(aVar, eVar, eVar2, i11);
    }

    public static /* synthetic */ void a1(c cVar, com.google.android.exoplayer2.util.m mVar) {
    }

    public static /* synthetic */ void b2(c.a aVar, String str, long j11, long j12, c cVar) {
        cVar.t0(aVar, str, j11);
        cVar.R(aVar, str, j12, j11);
        cVar.w(aVar, 2, str, j11);
    }

    public static /* synthetic */ void d1(c.a aVar, String str, long j11, long j12, c cVar) {
        cVar.t(aVar, str, j11);
        cVar.H(aVar, str, j12, j11);
        cVar.w(aVar, 1, str, j11);
    }

    public static /* synthetic */ void d2(c.a aVar, com.google.android.exoplayer2.decoder.e eVar, c cVar) {
        cVar.r(aVar, eVar);
        cVar.i0(aVar, 2, eVar);
    }

    public static /* synthetic */ void e2(c.a aVar, com.google.android.exoplayer2.decoder.e eVar, c cVar) {
        cVar.X(aVar, eVar);
        cVar.f(aVar, 2, eVar);
    }

    public static /* synthetic */ void f1(c.a aVar, com.google.android.exoplayer2.decoder.e eVar, c cVar) {
        cVar.p0(aVar, eVar);
        cVar.i0(aVar, 1, eVar);
    }

    public static /* synthetic */ void g1(c.a aVar, com.google.android.exoplayer2.decoder.e eVar, c cVar) {
        cVar.D(aVar, eVar);
        cVar.f(aVar, 1, eVar);
    }

    public static /* synthetic */ void g2(c.a aVar, com.google.android.exoplayer2.m1 m1Var, com.google.android.exoplayer2.decoder.g gVar, c cVar) {
        cVar.N(aVar, m1Var);
        cVar.n(aVar, m1Var, gVar);
        cVar.K(aVar, 2, m1Var);
    }

    public static /* synthetic */ void h1(c.a aVar, com.google.android.exoplayer2.m1 m1Var, com.google.android.exoplayer2.decoder.g gVar, c cVar) {
        cVar.a0(aVar, m1Var);
        cVar.l0(aVar, m1Var, gVar);
        cVar.K(aVar, 1, m1Var);
    }

    public static /* synthetic */ void h2(c.a aVar, com.google.android.exoplayer2.video.y yVar, c cVar) {
        cVar.c(aVar, yVar);
        cVar.g0(aVar, yVar.f35863a, yVar.f35864b, yVar.f35865c, yVar.f35866d);
    }

    public static /* synthetic */ void v1(c.a aVar, int i11, c cVar) {
        cVar.z0(aVar);
        cVar.h0(aVar, i11);
    }

    public static /* synthetic */ void z1(c.a aVar, boolean z11, c cVar) {
        cVar.n0(aVar, z11);
        cVar.v0(aVar, z11);
    }

    @Override // com.google.android.exoplayer2.source.j
    public final void A(int i11, @Nullable com.google.android.exoplayer2.source.i.b bVar, final nh.n nVar, final nh.o oVar, final IOException iOException, final boolean z11) {
        final c.a aVarW0 = W0(i11, bVar);
        m2(aVarW0, 1003, new com.google.android.exoplayer2.util.r.a() { // from class: qg.l0
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).d0(aVarW0, nVar, oVar, iOException, z11);
            }
        });
    }

    @Override // com.google.android.exoplayer2.source.j
    public final void B(int i11, @Nullable com.google.android.exoplayer2.source.i.b bVar, final nh.n nVar, final nh.o oVar) {
        final c.a aVarW0 = W0(i11, bVar);
        m2(aVarW0, 1001, new com.google.android.exoplayer2.util.r.a() { // from class: qg.a1
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).i(aVarW0, nVar, oVar);
            }
        });
    }

    @Override // com.google.android.exoplayer2.drm.b
    public final void C(int i11, @Nullable com.google.android.exoplayer2.source.i.b bVar) {
        final c.a aVarW0 = W0(i11, bVar);
        m2(aVarW0, 1023, new com.google.android.exoplayer2.util.r.a() { // from class: qg.d1
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).c0(aVarW0);
            }
        });
    }

    @Override // com.google.android.exoplayer2.drm.b
    public final void D(int i11, @Nullable com.google.android.exoplayer2.source.i.b bVar, final int i12) {
        final c.a aVarW0 = W0(i11, bVar);
        m2(aVarW0, 1022, new com.google.android.exoplayer2.util.r.a() { // from class: qg.q0
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                p1.v1(aVarW0, i12, (c) obj);
            }
        });
    }

    @Override // com.google.android.exoplayer2.drm.b
    public final void E(int i11, @Nullable com.google.android.exoplayer2.source.i.b bVar) {
        final c.a aVarW0 = W0(i11, bVar);
        m2(aVarW0, 1027, new com.google.android.exoplayer2.util.r.a() { // from class: qg.s
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).v(aVarW0);
            }
        });
    }

    @Override // com.google.android.exoplayer2.drm.b
    public final void F(int i11, @Nullable com.google.android.exoplayer2.source.i.b bVar) {
        final c.a aVarW0 = W0(i11, bVar);
        m2(aVarW0, InputDeviceCompat.SOURCE_GAMEPAD, new com.google.android.exoplayer2.util.r.a() { // from class: qg.i1
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).E(aVarW0);
            }
        });
    }

    public final c.a S0() {
        return U0(this.f74674d.d());
    }

    public final c.a T0(j3 j3Var, int i11, @Nullable com.google.android.exoplayer2.source.i.b bVar) {
        com.google.android.exoplayer2.source.i.b bVar2 = j3Var.u() ? null : bVar;
        long jElapsedRealtime = this.f74671a.elapsedRealtime();
        boolean z11 = j3Var.equals(this.f74677h.getCurrentTimeline()) && i11 == this.f74677h.u();
        long jE = 0;
        if (bVar2 == null || !bVar2.b()) {
            if (z11) {
                jE = this.f74677h.getContentPosition();
            } else if (!j3Var.u()) {
                jE = j3Var.r(i11, this.f74673c).e();
            }
        } else if (z11 && this.f74677h.getCurrentAdGroupIndex() == bVar2.f71961b && this.f74677h.getCurrentAdIndexInAdGroup() == bVar2.f71962c) {
            jE = this.f74677h.getCurrentPosition();
        }
        return new c.a(jElapsedRealtime, j3Var, i11, bVar2, jE, this.f74677h.getCurrentTimeline(), this.f74677h.u(), this.f74674d.d(), this.f74677h.getCurrentPosition(), this.f74677h.d());
    }

    public final c.a U0(@Nullable com.google.android.exoplayer2.source.i.b bVar) {
        com.google.android.exoplayer2.util.a.e(this.f74677h);
        j3 j3VarF = bVar == null ? null : this.f74674d.f(bVar);
        if (bVar != null && j3VarF != null) {
            return T0(j3VarF, j3VarF.l(bVar.f71960a, this.f74672b).f33364c, bVar);
        }
        int iU = this.f74677h.u();
        j3 currentTimeline = this.f74677h.getCurrentTimeline();
        if (iU >= currentTimeline.t()) {
            currentTimeline = j3.f33359a;
        }
        return T0(currentTimeline, iU, null);
    }

    public final c.a V0() {
        return U0(this.f74674d.e());
    }

    public final c.a W0(int i11, @Nullable com.google.android.exoplayer2.source.i.b bVar) {
        com.google.android.exoplayer2.util.a.e(this.f74677h);
        if (bVar != null) {
            return this.f74674d.f(bVar) != null ? U0(bVar) : T0(j3.f33359a, i11, bVar);
        }
        j3 currentTimeline = this.f74677h.getCurrentTimeline();
        if (i11 >= currentTimeline.t()) {
            currentTimeline = j3.f33359a;
        }
        return T0(currentTimeline, i11, null);
    }

    public final c.a X0() {
        return U0(this.f74674d.g());
    }

    public final c.a Y0() {
        return U0(this.f74674d.h());
    }

    public final c.a Z0(@Nullable PlaybackException playbackException) {
        nh.p pVar;
        return (!(playbackException instanceof ExoPlaybackException) || (pVar = ((ExoPlaybackException) playbackException).mediaPeriodId) == null) ? S0() : U0(new com.google.android.exoplayer2.source.i.b(pVar));
    }

    @Override // qg.a
    public final void a(final Exception exc) {
        final c.a aVarY0 = Y0();
        m2(aVarY0, PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, new com.google.android.exoplayer2.util.r.a() { // from class: qg.v
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).a(aVarY0, exc);
            }
        });
    }

    @Override // qg.a
    public final void b(final String str) {
        final c.a aVarY0 = Y0();
        m2(aVarY0, PointerIconCompat.TYPE_ZOOM_OUT, new com.google.android.exoplayer2.util.r.a() { // from class: qg.g
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).m0(aVarY0, str);
            }
        });
    }

    @Override // qg.a
    public final void c(final String str) {
        final c.a aVarY0 = Y0();
        m2(aVarY0, 1012, new com.google.android.exoplayer2.util.r.a() { // from class: qg.q
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).Q(aVarY0, str);
            }
        });
    }

    @Override // qg.a
    public final void d(final long j11) {
        final c.a aVarY0 = Y0();
        m2(aVarY0, 1010, new com.google.android.exoplayer2.util.r.a() { // from class: qg.r
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).q(aVarY0, j11);
            }
        });
    }

    @Override // qg.a
    public final void e(final Exception exc) {
        final c.a aVarY0 = Y0();
        m2(aVarY0, 1030, new com.google.android.exoplayer2.util.r.a() { // from class: qg.l1
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).O(aVarY0, exc);
            }
        });
    }

    @Override // com.google.android.exoplayer2.source.j
    public final void f(int i11, @Nullable com.google.android.exoplayer2.source.i.b bVar, final nh.n nVar, final nh.o oVar) {
        final c.a aVarW0 = W0(i11, bVar);
        m2(aVarW0, 1000, new com.google.android.exoplayer2.util.r.a() { // from class: qg.t0
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).B(aVarW0, nVar, oVar);
            }
        });
    }

    @Override // qg.a
    public final void g(final Object obj, final long j11) {
        final c.a aVarY0 = Y0();
        m2(aVarY0, 26, new com.google.android.exoplayer2.util.r.a() { // from class: qg.c1
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj2) {
                ((c) obj2).f0(aVarY0, obj, j11);
            }
        });
    }

    @Override // qg.a
    public final void h(final Exception exc) {
        final c.a aVarY0 = Y0();
        m2(aVarY0, 1029, new com.google.android.exoplayer2.util.r.a() { // from class: qg.n0
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).x0(aVarY0, exc);
            }
        });
    }

    @Override // qg.a
    public final void i(final int i11, final long j11, final long j12) {
        final c.a aVarY0 = Y0();
        m2(aVarY0, 1011, new com.google.android.exoplayer2.util.r.a() { // from class: qg.b1
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).I(aVarY0, i11, j11, j12);
            }
        });
    }

    @Override // qg.a
    public final void j(final long j11, final int i11) {
        final c.a aVarX0 = X0();
        m2(aVarX0, PointerIconCompat.TYPE_GRABBING, new com.google.android.exoplayer2.util.r.a() { // from class: qg.m1
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).k(aVarX0, j11, i11);
            }
        });
    }

    @Override // qg.a
    public final void k(final com.google.android.exoplayer2.decoder.e eVar) {
        final c.a aVarY0 = Y0();
        m2(aVarY0, PointerIconCompat.TYPE_CROSSHAIR, new com.google.android.exoplayer2.util.r.a() { // from class: qg.e0
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                p1.g1(aVarY0, eVar, (c) obj);
            }
        });
    }

    public final /* synthetic */ void k2(n2 n2Var, c cVar, com.google.android.exoplayer2.util.m mVar) {
        cVar.u(n2Var, new c.b(mVar, this.f74675f));
    }

    @Override // qg.a
    public final void l(final com.google.android.exoplayer2.m1 m1Var, @Nullable final com.google.android.exoplayer2.decoder.g gVar) {
        final c.a aVarY0 = Y0();
        m2(aVarY0, PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, new com.google.android.exoplayer2.util.r.a() { // from class: qg.p0
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                p1.g2(aVarY0, m1Var, gVar, (c) obj);
            }
        });
    }

    public final void l2() {
        final c.a aVarS0 = S0();
        m2(aVarS0, 1028, new com.google.android.exoplayer2.util.r.a() { // from class: qg.f1
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).Y(aVarS0);
            }
        });
        this.f74676g.j();
    }

    @Override // qg.a
    public final void m() {
        if (this.f74679j) {
            return;
        }
        final c.a aVarS0 = S0();
        this.f74679j = true;
        m2(aVarS0, -1, new com.google.android.exoplayer2.util.r.a() { // from class: qg.n1
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).u0(aVarS0);
            }
        });
    }

    public final void m2(c.a aVar, int i11, com.google.android.exoplayer2.util.r.a<c> aVar2) {
        this.f74675f.put(i11, aVar);
        this.f74676g.l(i11, aVar2);
    }

    @Override // qg.a
    public final void n(final com.google.android.exoplayer2.decoder.e eVar) {
        final c.a aVarX0 = X0();
        m2(aVarX0, PointerIconCompat.TYPE_GRAB, new com.google.android.exoplayer2.util.r.a() { // from class: qg.b0
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                p1.d2(aVarX0, eVar, (c) obj);
            }
        });
    }

    @Override // qg.a
    public final void o(final com.google.android.exoplayer2.decoder.e eVar) {
        final c.a aVarX0 = X0();
        m2(aVarX0, PointerIconCompat.TYPE_ALL_SCROLL, new com.google.android.exoplayer2.util.r.a() { // from class: qg.o0
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                p1.f1(aVarX0, eVar, (c) obj);
            }
        });
    }

    @Override // qg.a
    public final void onAudioDecoderInitialized(final String str, final long j11, final long j12) {
        final c.a aVarY0 = Y0();
        m2(aVarY0, PointerIconCompat.TYPE_TEXT, new com.google.android.exoplayer2.util.r.a() { // from class: qg.m
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                p1.d1(aVarY0, str, j12, j11, (c) obj);
            }
        });
    }

    @Override // com.google.android.exoplayer2.n2.d
    public void onAvailableCommandsChanged(final n2.b bVar) {
        final c.a aVarS0 = S0();
        m2(aVarS0, 13, new com.google.android.exoplayer2.util.r.a() { // from class: qg.g0
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).s0(aVarS0, bVar);
            }
        });
    }

    @Override // com.google.android.exoplayer2.upstream.e.a
    public final void onBandwidthSample(final int i11, final long j11, final long j12) {
        final c.a aVarV0 = V0();
        m2(aVarV0, PointerIconCompat.TYPE_CELL, new com.google.android.exoplayer2.util.r.a() { // from class: qg.k1
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).e0(aVarV0, i11, j11, j12);
            }
        });
    }

    @Override // com.google.android.exoplayer2.n2.d
    public void onCues(final List<vh.b> list) {
        final c.a aVarS0 = S0();
        m2(aVarS0, 27, new com.google.android.exoplayer2.util.r.a() { // from class: qg.y0
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).d(aVarS0, list);
            }
        });
    }

    @Override // com.google.android.exoplayer2.n2.d
    public void onCues(final vh.f fVar) {
        final c.a aVarS0 = S0();
        m2(aVarS0, 27, new com.google.android.exoplayer2.util.r.a() { // from class: qg.j0
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).j0(aVarS0, fVar);
            }
        });
    }

    @Override // com.google.android.exoplayer2.n2.d
    public void onDeviceInfoChanged(final com.google.android.exoplayer2.n nVar) {
        final c.a aVarS0 = S0();
        m2(aVarS0, 29, new com.google.android.exoplayer2.util.r.a() { // from class: qg.o
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).w0(aVarS0, nVar);
            }
        });
    }

    @Override // com.google.android.exoplayer2.n2.d
    public void onDeviceVolumeChanged(final int i11, final boolean z11) {
        final c.a aVarS0 = S0();
        m2(aVarS0, 30, new com.google.android.exoplayer2.util.r.a() { // from class: qg.i
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).A(aVarS0, i11, z11);
            }
        });
    }

    @Override // qg.a
    public final void onDroppedFrames(final int i11, final long j11) {
        final c.a aVarX0 = X0();
        m2(aVarX0, PointerIconCompat.TYPE_ZOOM_IN, new com.google.android.exoplayer2.util.r.a() { // from class: qg.a0
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).P(aVarX0, i11, j11);
            }
        });
    }

    @Override // com.google.android.exoplayer2.n2.d
    public void onEvents(n2 n2Var, n2.c cVar) {
    }

    @Override // com.google.android.exoplayer2.n2.d
    public final void onIsLoadingChanged(final boolean z11) {
        final c.a aVarS0 = S0();
        m2(aVarS0, 3, new com.google.android.exoplayer2.util.r.a() { // from class: qg.r0
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                p1.z1(aVarS0, z11, (c) obj);
            }
        });
    }

    @Override // com.google.android.exoplayer2.n2.d
    public void onIsPlayingChanged(final boolean z11) {
        final c.a aVarS0 = S0();
        m2(aVarS0, 7, new com.google.android.exoplayer2.util.r.a() { // from class: qg.u
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).h(aVarS0, z11);
            }
        });
    }

    @Override // com.google.android.exoplayer2.n2.d
    public void onLoadingChanged(boolean z11) {
    }

    @Override // com.google.android.exoplayer2.n2.d
    public final void onMediaItemTransition(@Nullable final com.google.android.exoplayer2.u1 u1Var, final int i11) {
        final c.a aVarS0 = S0();
        m2(aVarS0, 1, new com.google.android.exoplayer2.util.r.a() { // from class: qg.z
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).F(aVarS0, u1Var, i11);
            }
        });
    }

    @Override // com.google.android.exoplayer2.n2.d
    public void onMediaMetadataChanged(final z1 z1Var) {
        final c.a aVarS0 = S0();
        m2(aVarS0, 14, new com.google.android.exoplayer2.util.r.a() { // from class: qg.g1
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).x(aVarS0, z1Var);
            }
        });
    }

    @Override // com.google.android.exoplayer2.n2.d
    public final void onMetadata(final Metadata metadata) {
        final c.a aVarS0 = S0();
        m2(aVarS0, 28, new com.google.android.exoplayer2.util.r.a() { // from class: qg.d
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).o(aVarS0, metadata);
            }
        });
    }

    @Override // com.google.android.exoplayer2.n2.d
    public final void onPlayWhenReadyChanged(final boolean z11, final int i11) {
        final c.a aVarS0 = S0();
        m2(aVarS0, 5, new com.google.android.exoplayer2.util.r.a() { // from class: qg.i0
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).e(aVarS0, z11, i11);
            }
        });
    }

    @Override // com.google.android.exoplayer2.n2.d
    public final void onPlaybackParametersChanged(final m2 m2Var) {
        final c.a aVarS0 = S0();
        m2(aVarS0, 12, new com.google.android.exoplayer2.util.r.a() { // from class: qg.s0
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).y(aVarS0, m2Var);
            }
        });
    }

    @Override // com.google.android.exoplayer2.n2.d
    public final void onPlaybackStateChanged(final int i11) {
        final c.a aVarS0 = S0();
        m2(aVarS0, 4, new com.google.android.exoplayer2.util.r.a() { // from class: qg.v0
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).Z(aVarS0, i11);
            }
        });
    }

    @Override // com.google.android.exoplayer2.n2.d
    public final void onPlaybackSuppressionReasonChanged(final int i11) {
        final c.a aVarS0 = S0();
        m2(aVarS0, 6, new com.google.android.exoplayer2.util.r.a() { // from class: qg.x
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).q0(aVarS0, i11);
            }
        });
    }

    @Override // com.google.android.exoplayer2.n2.d
    public final void onPlayerError(final PlaybackException playbackException) {
        final c.a aVarZ0 = Z0(playbackException);
        m2(aVarZ0, 10, new com.google.android.exoplayer2.util.r.a() { // from class: qg.l
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).k0(aVarZ0, playbackException);
            }
        });
    }

    @Override // com.google.android.exoplayer2.n2.d
    public void onPlayerErrorChanged(@Nullable final PlaybackException playbackException) {
        final c.a aVarZ0 = Z0(playbackException);
        m2(aVarZ0, 10, new com.google.android.exoplayer2.util.r.a() { // from class: qg.f
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).z(aVarZ0, playbackException);
            }
        });
    }

    @Override // com.google.android.exoplayer2.n2.d
    public final void onPlayerStateChanged(final boolean z11, final int i11) {
        final c.a aVarS0 = S0();
        m2(aVarS0, -1, new com.google.android.exoplayer2.util.r.a() { // from class: qg.y
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).L(aVarS0, z11, i11);
            }
        });
    }

    @Override // com.google.android.exoplayer2.n2.d
    public void onPositionDiscontinuity(int i11) {
    }

    @Override // com.google.android.exoplayer2.n2.d
    public final void onPositionDiscontinuity(final n2.e eVar, final n2.e eVar2, final int i11) {
        if (i11 == 1) {
            this.f74679j = false;
        }
        this.f74674d.j((n2) com.google.android.exoplayer2.util.a.e(this.f74677h));
        final c.a aVarS0 = S0();
        m2(aVarS0, 11, new com.google.android.exoplayer2.util.r.a() { // from class: qg.z0
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                p1.P1(aVarS0, i11, eVar, eVar2, (c) obj);
            }
        });
    }

    @Override // com.google.android.exoplayer2.n2.d
    public void onRenderedFirstFrame() {
    }

    @Override // com.google.android.exoplayer2.n2.d
    public final void onRepeatModeChanged(final int i11) {
        final c.a aVarS0 = S0();
        m2(aVarS0, 8, new com.google.android.exoplayer2.util.r.a() { // from class: qg.f0
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).V(aVarS0, i11);
            }
        });
    }

    @Override // com.google.android.exoplayer2.n2.d
    public final void onSeekProcessed() {
        final c.a aVarS0 = S0();
        m2(aVarS0, -1, new com.google.android.exoplayer2.util.r.a() { // from class: qg.x0
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).l(aVarS0);
            }
        });
    }

    @Override // com.google.android.exoplayer2.n2.d
    public final void onShuffleModeEnabledChanged(final boolean z11) {
        final c.a aVarS0 = S0();
        m2(aVarS0, 9, new com.google.android.exoplayer2.util.r.a() { // from class: qg.h
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).b0(aVarS0, z11);
            }
        });
    }

    @Override // com.google.android.exoplayer2.n2.d
    public final void onSkipSilenceEnabledChanged(final boolean z11) {
        final c.a aVarY0 = Y0();
        m2(aVarY0, 23, new com.google.android.exoplayer2.util.r.a() { // from class: qg.j1
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).b(aVarY0, z11);
            }
        });
    }

    @Override // com.google.android.exoplayer2.n2.d
    public final void onSurfaceSizeChanged(final int i11, final int i12) {
        final c.a aVarY0 = Y0();
        m2(aVarY0, 24, new com.google.android.exoplayer2.util.r.a() { // from class: qg.h0
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).p(aVarY0, i11, i12);
            }
        });
    }

    @Override // com.google.android.exoplayer2.n2.d
    public final void onTimelineChanged(j3 j3Var, final int i11) {
        this.f74674d.l((n2) com.google.android.exoplayer2.util.a.e(this.f74677h));
        final c.a aVarS0 = S0();
        m2(aVarS0, 0, new com.google.android.exoplayer2.util.r.a() { // from class: qg.w0
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).T(aVarS0, i11);
            }
        });
    }

    @Override // com.google.android.exoplayer2.n2.d
    public void onTrackSelectionParametersChanged(final fi.z zVar) {
        final c.a aVarS0 = S0();
        m2(aVarS0, 19, new com.google.android.exoplayer2.util.r.a() { // from class: qg.o1
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).C(aVarS0, zVar);
            }
        });
    }

    @Override // com.google.android.exoplayer2.n2.d
    public void onTracksChanged(final o3 o3Var) {
        final c.a aVarS0 = S0();
        m2(aVarS0, 2, new com.google.android.exoplayer2.util.r.a() { // from class: qg.t
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).G(aVarS0, o3Var);
            }
        });
    }

    @Override // qg.a
    public final void onVideoDecoderInitialized(final String str, final long j11, final long j12) {
        final c.a aVarY0 = Y0();
        m2(aVarY0, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, new com.google.android.exoplayer2.util.r.a() { // from class: qg.e
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                p1.b2(aVarY0, str, j12, j11, (c) obj);
            }
        });
    }

    @Override // com.google.android.exoplayer2.n2.d
    public final void onVideoSizeChanged(final com.google.android.exoplayer2.video.y yVar) {
        final c.a aVarY0 = Y0();
        m2(aVarY0, 25, new com.google.android.exoplayer2.util.r.a() { // from class: qg.e1
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                p1.h2(aVarY0, yVar, (c) obj);
            }
        });
    }

    @Override // com.google.android.exoplayer2.n2.d
    public final void onVolumeChanged(final float f11) {
        final c.a aVarY0 = Y0();
        m2(aVarY0, 22, new com.google.android.exoplayer2.util.r.a() { // from class: qg.k0
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).s(aVarY0, f11);
            }
        });
    }

    @Override // com.google.android.exoplayer2.source.j
    public final void p(int i11, @Nullable com.google.android.exoplayer2.source.i.b bVar, final nh.o oVar) {
        final c.a aVarW0 = W0(i11, bVar);
        m2(aVarW0, 1005, new com.google.android.exoplayer2.util.r.a() { // from class: qg.d0
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).U(aVarW0, oVar);
            }
        });
    }

    @Override // com.google.android.exoplayer2.source.j
    public final void q(int i11, @Nullable com.google.android.exoplayer2.source.i.b bVar, final nh.n nVar, final nh.o oVar) {
        final c.a aVarW0 = W0(i11, bVar);
        m2(aVarW0, 1002, new com.google.android.exoplayer2.util.r.a() { // from class: qg.n
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).g(aVarW0, nVar, oVar);
            }
        });
    }

    @Override // qg.a
    @CallSuper
    public void r(final n2 n2Var, Looper looper) {
        com.google.android.exoplayer2.util.a.g(this.f74677h == null || this.f74674d.f74681b.isEmpty());
        this.f74677h = (n2) com.google.android.exoplayer2.util.a.e(n2Var);
        this.f74678i = this.f74671a.createHandler(looper, null);
        this.f74676g = this.f74676g.e(looper, new com.google.android.exoplayer2.util.r.b() { // from class: qg.p
            @Override // com.google.android.exoplayer2.util.r.b
            public final void a(Object obj, com.google.android.exoplayer2.util.m mVar) {
                this.f74666a.k2(n2Var, (c) obj, mVar);
            }
        });
    }

    @Override // qg.a
    @CallSuper
    public void release() {
        ((com.google.android.exoplayer2.util.o) com.google.android.exoplayer2.util.a.i(this.f74678i)).post(new Runnable() { // from class: qg.k
            @Override // java.lang.Runnable
            public final void run() {
                this.f74631a.l2();
            }
        });
    }

    @Override // qg.a
    public final void s(final com.google.android.exoplayer2.m1 m1Var, @Nullable final com.google.android.exoplayer2.decoder.g gVar) {
        final c.a aVarY0 = Y0();
        m2(aVarY0, PointerIconCompat.TYPE_VERTICAL_TEXT, new com.google.android.exoplayer2.util.r.a() { // from class: qg.c0
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                p1.h1(aVarY0, m1Var, gVar, (c) obj);
            }
        });
    }

    @Override // qg.a
    public final void t(final com.google.android.exoplayer2.decoder.e eVar) {
        final c.a aVarY0 = Y0();
        m2(aVarY0, PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW, new com.google.android.exoplayer2.util.r.a() { // from class: qg.j
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                p1.e2(aVarY0, eVar, (c) obj);
            }
        });
    }

    @Override // com.google.android.exoplayer2.drm.b
    public final void u(int i11, @Nullable com.google.android.exoplayer2.source.i.b bVar) {
        final c.a aVarW0 = W0(i11, bVar);
        m2(aVarW0, 1026, new com.google.android.exoplayer2.util.r.a() { // from class: qg.h1
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).y0(aVarW0);
            }
        });
    }

    @Override // com.google.android.exoplayer2.drm.b
    public /* synthetic */ void v(int i11, com.google.android.exoplayer2.source.i.b bVar) {
        sg.k.a(this, i11, bVar);
    }

    @Override // com.google.android.exoplayer2.source.j
    public final void w(int i11, @Nullable com.google.android.exoplayer2.source.i.b bVar, final nh.o oVar) {
        final c.a aVarW0 = W0(i11, bVar);
        m2(aVarW0, 1004, new com.google.android.exoplayer2.util.r.a() { // from class: qg.w
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).r0(aVarW0, oVar);
            }
        });
    }

    @Override // qg.a
    @CallSuper
    public void x(c cVar) {
        com.google.android.exoplayer2.util.a.e(cVar);
        this.f74676g.c(cVar);
    }

    @Override // com.google.android.exoplayer2.drm.b
    public final void y(int i11, @Nullable com.google.android.exoplayer2.source.i.b bVar, final Exception exc) {
        final c.a aVarW0 = W0(i11, bVar);
        m2(aVarW0, 1024, new com.google.android.exoplayer2.util.r.a() { // from class: qg.u0
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((c) obj).o0(aVarW0, exc);
            }
        });
    }

    @Override // qg.a
    public final void z(List<com.google.android.exoplayer2.source.i.b> list, @Nullable com.google.android.exoplayer2.source.i.b bVar) {
        this.f74674d.k(list, bVar, (n2) com.google.android.exoplayer2.util.a.e(this.f74677h));
    }
}
