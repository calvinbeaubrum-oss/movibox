package e4;

import android.os.Looper;
import android.util.SparseArray;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.PointerIconCompat;
import androidx.media3.common.Metadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.audio.AudioSink;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class q1 implements e4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z3.d f63920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.media3.common.m0.b f63921b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final androidx.media3.common.m0.c f63922c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f63923d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SparseArray<c.a> f63924f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public z3.n<c> f63925g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public androidx.media3.common.h0 f63926h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public z3.j f63927i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f63928j;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final androidx.media3.common.m0.b f63929a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ImmutableList<androidx.media3.exoplayer.source.l.b> f63930b = ImmutableList.of();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ImmutableMap<androidx.media3.exoplayer.source.l.b, androidx.media3.common.m0> f63931c = ImmutableMap.of();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public androidx.media3.exoplayer.source.l.b f63932d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public androidx.media3.exoplayer.source.l.b f63933e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public androidx.media3.exoplayer.source.l.b f63934f;

        public a(androidx.media3.common.m0.b bVar) {
            this.f63929a = bVar;
        }

        @Nullable
        public static androidx.media3.exoplayer.source.l.b c(androidx.media3.common.h0 h0Var, ImmutableList<androidx.media3.exoplayer.source.l.b> immutableList, @Nullable androidx.media3.exoplayer.source.l.b bVar, androidx.media3.common.m0.b bVar2) {
            androidx.media3.common.m0 currentTimeline = h0Var.getCurrentTimeline();
            int currentPeriodIndex = h0Var.getCurrentPeriodIndex();
            Object objM = currentTimeline.q() ? null : currentTimeline.m(currentPeriodIndex);
            int iD = (h0Var.isPlayingAd() || currentTimeline.q()) ? -1 : currentTimeline.f(currentPeriodIndex, bVar2).d(z3.u0.S0(h0Var.getCurrentPosition()) - bVar2.o());
            for (int i11 = 0; i11 < immutableList.size(); i11++) {
                androidx.media3.exoplayer.source.l.b bVar3 = immutableList.get(i11);
                if (i(bVar3, objM, h0Var.isPlayingAd(), h0Var.getCurrentAdGroupIndex(), h0Var.getCurrentAdIndexInAdGroup(), iD)) {
                    return bVar3;
                }
            }
            if (immutableList.isEmpty() && bVar != null) {
                if (i(bVar, objM, h0Var.isPlayingAd(), h0Var.getCurrentAdGroupIndex(), h0Var.getCurrentAdIndexInAdGroup(), iD)) {
                    return bVar;
                }
            }
            return null;
        }

        public static boolean i(androidx.media3.exoplayer.source.l.b bVar, @Nullable Object obj, boolean z11, int i11, int i12, int i13) {
            if (bVar.f11209a.equals(obj)) {
                return (z11 && bVar.f11210b == i11 && bVar.f11211c == i12) || (!z11 && bVar.f11210b == -1 && bVar.f11213e == i13);
            }
            return false;
        }

        public final void b(ImmutableMap.b<androidx.media3.exoplayer.source.l.b, androidx.media3.common.m0> bVar, @Nullable androidx.media3.exoplayer.source.l.b bVar2, androidx.media3.common.m0 m0Var) {
            if (bVar2 == null) {
                return;
            }
            if (m0Var.b(bVar2.f11209a) != -1) {
                bVar.g(bVar2, m0Var);
                return;
            }
            androidx.media3.common.m0 m0Var2 = this.f63931c.get(bVar2);
            if (m0Var2 != null) {
                bVar.g(bVar2, m0Var2);
            }
        }

        @Nullable
        public androidx.media3.exoplayer.source.l.b d() {
            return this.f63932d;
        }

        @Nullable
        public androidx.media3.exoplayer.source.l.b e() {
            if (this.f63930b.isEmpty()) {
                return null;
            }
            return (androidx.media3.exoplayer.source.l.b) com.google.common.collect.e0.g(this.f63930b);
        }

        @Nullable
        public androidx.media3.common.m0 f(androidx.media3.exoplayer.source.l.b bVar) {
            return this.f63931c.get(bVar);
        }

        @Nullable
        public androidx.media3.exoplayer.source.l.b g() {
            return this.f63933e;
        }

        @Nullable
        public androidx.media3.exoplayer.source.l.b h() {
            return this.f63934f;
        }

        public void j(androidx.media3.common.h0 h0Var) {
            this.f63932d = c(h0Var, this.f63930b, this.f63933e, this.f63929a);
        }

        public void k(List<androidx.media3.exoplayer.source.l.b> list, @Nullable androidx.media3.exoplayer.source.l.b bVar, androidx.media3.common.h0 h0Var) {
            this.f63930b = ImmutableList.copyOf((Collection) list);
            if (!list.isEmpty()) {
                this.f63933e = list.get(0);
                this.f63934f = (androidx.media3.exoplayer.source.l.b) z3.a.e(bVar);
            }
            if (this.f63932d == null) {
                this.f63932d = c(h0Var, this.f63930b, this.f63933e, this.f63929a);
            }
            m(h0Var.getCurrentTimeline());
        }

        public void l(androidx.media3.common.h0 h0Var) {
            this.f63932d = c(h0Var, this.f63930b, this.f63933e, this.f63929a);
            m(h0Var.getCurrentTimeline());
        }

        public final void m(androidx.media3.common.m0 m0Var) {
            ImmutableMap.b<androidx.media3.exoplayer.source.l.b, androidx.media3.common.m0> bVarBuilder = ImmutableMap.builder();
            if (this.f63930b.isEmpty()) {
                b(bVarBuilder, this.f63933e, m0Var);
                if (!com.google.common.base.j.a(this.f63934f, this.f63933e)) {
                    b(bVarBuilder, this.f63934f, m0Var);
                }
                if (!com.google.common.base.j.a(this.f63932d, this.f63933e) && !com.google.common.base.j.a(this.f63932d, this.f63934f)) {
                    b(bVarBuilder, this.f63932d, m0Var);
                }
            } else {
                for (int i11 = 0; i11 < this.f63930b.size(); i11++) {
                    b(bVarBuilder, this.f63930b.get(i11), m0Var);
                }
                if (!this.f63930b.contains(this.f63932d)) {
                    b(bVarBuilder, this.f63932d, m0Var);
                }
            }
            this.f63931c = bVarBuilder.d();
        }
    }

    public q1(z3.d dVar) {
        this.f63920a = (z3.d) z3.a.e(dVar);
        this.f63925g = new z3.n<>(z3.u0.V(), dVar, new z3.n.b() { // from class: e4.f
            @Override // z3.n.b
            public final void a(Object obj, androidx.media3.common.s sVar) {
                q1.d1((c) obj, sVar);
            }
        });
        androidx.media3.common.m0.b bVar = new androidx.media3.common.m0.b();
        this.f63921b = bVar;
        this.f63922c = new androidx.media3.common.m0.c();
        this.f63923d = new a(bVar);
        this.f63924f = new SparseArray<>();
    }

    public static /* synthetic */ void A1(c.a aVar, int i11, c cVar) {
        cVar.v(aVar);
        cVar.A(aVar, i11);
    }

    public static /* synthetic */ void E1(c.a aVar, boolean z11, c cVar) {
        cVar.E(aVar, z11);
        cVar.o(aVar, z11);
    }

    public static /* synthetic */ void U1(c.a aVar, int i11, androidx.media3.common.h0.e eVar, androidx.media3.common.h0.e eVar2, c cVar) {
        cVar.l(aVar, i11);
        cVar.K(aVar, eVar, eVar2, i11);
    }

    public static /* synthetic */ void d1(c cVar, androidx.media3.common.s sVar) {
    }

    public static /* synthetic */ void f2(c.a aVar, String str, long j11, long j12, c cVar) {
        cVar.Y(aVar, str, j11);
        cVar.x(aVar, str, j12, j11);
    }

    public static /* synthetic */ void g1(c.a aVar, String str, long j11, long j12, c cVar) {
        cVar.U(aVar, str, j11);
        cVar.n(aVar, str, j12, j11);
    }

    public static /* synthetic */ void k1(c.a aVar, androidx.media3.common.y yVar, androidx.media3.exoplayer.o oVar, c cVar) {
        cVar.m(aVar, yVar);
        cVar.W(aVar, yVar, oVar);
    }

    public static /* synthetic */ void k2(c.a aVar, androidx.media3.common.y yVar, androidx.media3.exoplayer.o oVar, c cVar) {
        cVar.h0(aVar, yVar);
        cVar.T(aVar, yVar, oVar);
    }

    public static /* synthetic */ void l2(c.a aVar, androidx.media3.common.t0 t0Var, c cVar) {
        cVar.j0(aVar, t0Var);
        cVar.r0(aVar, t0Var.f9449a, t0Var.f9450b, t0Var.f9451c, t0Var.f9452d);
    }

    @Override // androidx.media3.exoplayer.source.m
    public final void A(int i11, @Nullable androidx.media3.exoplayer.source.l.b bVar, final p4.n nVar, final p4.o oVar) {
        final c.a aVarZ0 = Z0(i11, bVar);
        q2(aVarZ0, 1001, new z3.n.a() { // from class: e4.j0
            @Override // z3.n.a
            public final void invoke(Object obj) {
                ((c) obj).k0(aVarZ0, nVar, oVar);
            }
        });
    }

    @Override // androidx.media3.exoplayer.source.m
    public final void B(int i11, @Nullable androidx.media3.exoplayer.source.l.b bVar, final p4.n nVar, final p4.o oVar) {
        final c.a aVarZ0 = Z0(i11, bVar);
        q2(aVarZ0, 1000, new z3.n.a() { // from class: e4.z
            @Override // z3.n.a
            public final void invoke(Object obj) {
                ((c) obj).F(aVarZ0, nVar, oVar);
            }
        });
    }

    @Override // e4.a
    @CallSuper
    public void C(c cVar) {
        z3.a.e(cVar);
        this.f63925g.c(cVar);
    }

    @Override // androidx.media3.exoplayer.source.m
    public final void D(int i11, @Nullable androidx.media3.exoplayer.source.l.b bVar, final p4.o oVar) {
        final c.a aVarZ0 = Z0(i11, bVar);
        q2(aVarZ0, 1005, new z3.n.a() { // from class: e4.w0
            @Override // z3.n.a
            public final void invoke(Object obj) {
                ((c) obj).f0(aVarZ0, oVar);
            }
        });
    }

    @Override // androidx.media3.exoplayer.source.m
    public final void E(int i11, @Nullable androidx.media3.exoplayer.source.l.b bVar, final p4.o oVar) {
        final c.a aVarZ0 = Z0(i11, bVar);
        q2(aVarZ0, 1004, new z3.n.a() { // from class: e4.a1
            @Override // z3.n.a
            public final void invoke(Object obj) {
                ((c) obj).s0(aVarZ0, oVar);
            }
        });
    }

    @Override // androidx.media3.exoplayer.drm.b
    public final void F(int i11, @Nullable androidx.media3.exoplayer.source.l.b bVar) {
        final c.a aVarZ0 = Z0(i11, bVar);
        q2(aVarZ0, 1027, new z3.n.a() { // from class: e4.y0
            @Override // z3.n.a
            public final void invoke(Object obj) {
                ((c) obj).a0(aVarZ0);
            }
        });
    }

    @Override // e4.a
    @CallSuper
    public void G(final androidx.media3.common.h0 h0Var, Looper looper) {
        z3.a.g(this.f63926h == null || this.f63923d.f63930b.isEmpty());
        this.f63926h = (androidx.media3.common.h0) z3.a.e(h0Var);
        this.f63927i = this.f63920a.createHandler(looper, null);
        this.f63925g = this.f63925g.e(looper, new z3.n.b() { // from class: e4.r
            @Override // z3.n.b
            public final void a(Object obj, androidx.media3.common.s sVar) {
                this.f63935a.o2(h0Var, (c) obj, sVar);
            }
        });
    }

    @Override // androidx.media3.exoplayer.source.m
    public final void H(int i11, @Nullable androidx.media3.exoplayer.source.l.b bVar, final p4.n nVar, final p4.o oVar, final IOException iOException, final boolean z11) {
        final c.a aVarZ0 = Z0(i11, bVar);
        q2(aVarZ0, 1003, new z3.n.a() { // from class: e4.o
            @Override // z3.n.a
            public final void invoke(Object obj) {
                ((c) obj).m0(aVarZ0, nVar, oVar, iOException, z11);
            }
        });
    }

    public final c.a V0() {
        return X0(this.f63923d.d());
    }

    public final c.a W0(androidx.media3.common.m0 m0Var, int i11, @Nullable androidx.media3.exoplayer.source.l.b bVar) {
        androidx.media3.exoplayer.source.l.b bVar2 = m0Var.q() ? null : bVar;
        long jElapsedRealtime = this.f63920a.elapsedRealtime();
        boolean z11 = m0Var.equals(this.f63926h.getCurrentTimeline()) && i11 == this.f63926h.u();
        long jB = 0;
        if (bVar2 == null || !bVar2.b()) {
            if (z11) {
                jB = this.f63926h.getContentPosition();
            } else if (!m0Var.q()) {
                jB = m0Var.n(i11, this.f63922c).b();
            }
        } else if (z11 && this.f63926h.getCurrentAdGroupIndex() == bVar2.f11210b && this.f63926h.getCurrentAdIndexInAdGroup() == bVar2.f11211c) {
            jB = this.f63926h.getCurrentPosition();
        }
        return new c.a(jElapsedRealtime, m0Var, i11, bVar2, jB, this.f63926h.getCurrentTimeline(), this.f63926h.u(), this.f63923d.d(), this.f63926h.getCurrentPosition(), this.f63926h.d());
    }

    public final c.a X0(@Nullable androidx.media3.exoplayer.source.l.b bVar) {
        z3.a.e(this.f63926h);
        androidx.media3.common.m0 m0VarF = bVar == null ? null : this.f63923d.f(bVar);
        if (bVar != null && m0VarF != null) {
            return W0(m0VarF, m0VarF.h(bVar.f11209a, this.f63921b).f9295c, bVar);
        }
        int iU = this.f63926h.u();
        androidx.media3.common.m0 currentTimeline = this.f63926h.getCurrentTimeline();
        if (iU >= currentTimeline.p()) {
            currentTimeline = androidx.media3.common.m0.f9282a;
        }
        return W0(currentTimeline, iU, null);
    }

    public final c.a Y0() {
        return X0(this.f63923d.e());
    }

    public final c.a Z0(int i11, @Nullable androidx.media3.exoplayer.source.l.b bVar) {
        z3.a.e(this.f63926h);
        if (bVar != null) {
            return this.f63923d.f(bVar) != null ? X0(bVar) : W0(androidx.media3.common.m0.f9282a, i11, bVar);
        }
        androidx.media3.common.m0 currentTimeline = this.f63926h.getCurrentTimeline();
        if (i11 >= currentTimeline.p()) {
            currentTimeline = androidx.media3.common.m0.f9282a;
        }
        return W0(currentTimeline, i11, null);
    }

    @Override // e4.a
    public final void a(final Exception exc) {
        final c.a aVarB1 = b1();
        q2(aVarB1, PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, new z3.n.a() { // from class: e4.j
            @Override // z3.n.a
            public final void invoke(Object obj) {
                ((c) obj).d(aVarB1, exc);
            }
        });
    }

    public final c.a a1() {
        return X0(this.f63923d.g());
    }

    @Override // e4.a
    public final void b(final String str) {
        final c.a aVarB1 = b1();
        q2(aVarB1, PointerIconCompat.TYPE_ZOOM_OUT, new z3.n.a() { // from class: e4.o1
            @Override // z3.n.a
            public final void invoke(Object obj) {
                ((c) obj).L(aVarB1, str);
            }
        });
    }

    public final c.a b1() {
        return X0(this.f63923d.h());
    }

    @Override // e4.a
    public final void c(final String str) {
        final c.a aVarB1 = b1();
        q2(aVarB1, 1012, new z3.n.a() { // from class: e4.g1
            @Override // z3.n.a
            public final void invoke(Object obj) {
                ((c) obj).Q(aVarB1, str);
            }
        });
    }

    public final c.a c1(@Nullable PlaybackException playbackException) {
        androidx.media3.exoplayer.source.l.b bVar;
        return (!(playbackException instanceof ExoPlaybackException) || (bVar = ((ExoPlaybackException) playbackException).mediaPeriodId) == null) ? V0() : X0(bVar);
    }

    @Override // e4.a
    public final void d(final long j11) {
        final c.a aVarB1 = b1();
        q2(aVarB1, 1010, new z3.n.a() { // from class: e4.q0
            @Override // z3.n.a
            public final void invoke(Object obj) {
                ((c) obj).G(aVarB1, j11);
            }
        });
    }

    @Override // e4.a
    public final void e(final Exception exc) {
        final c.a aVarB1 = b1();
        q2(aVarB1, 1030, new z3.n.a() { // from class: e4.i
            @Override // z3.n.a
            public final void invoke(Object obj) {
                ((c) obj).R(aVarB1, exc);
            }
        });
    }

    @Override // androidx.media3.exoplayer.drm.b
    public final void f(int i11, @Nullable androidx.media3.exoplayer.source.l.b bVar) {
        final c.a aVarZ0 = Z0(i11, bVar);
        q2(aVarZ0, 1023, new z3.n.a() { // from class: e4.h1
            @Override // z3.n.a
            public final void invoke(Object obj) {
                ((c) obj).P(aVarZ0);
            }
        });
    }

    @Override // e4.a
    public final void g(final Object obj, final long j11) {
        final c.a aVarB1 = b1();
        q2(aVarB1, 26, new z3.n.a() { // from class: e4.d1
            @Override // z3.n.a
            public final void invoke(Object obj2) {
                ((c) obj2).g(aVarB1, obj, j11);
            }
        });
    }

    @Override // e4.a
    public final void h(final Exception exc) {
        final c.a aVarB1 = b1();
        q2(aVarB1, 1029, new z3.n.a() { // from class: e4.p
            @Override // z3.n.a
            public final void invoke(Object obj) {
                ((c) obj).q(aVarB1, exc);
            }
        });
    }

    @Override // e4.a
    public final void i(final int i11, final long j11, final long j12) {
        final c.a aVarB1 = b1();
        q2(aVarB1, 1011, new z3.n.a() { // from class: e4.x0
            @Override // z3.n.a
            public final void invoke(Object obj) {
                ((c) obj).h(aVarB1, i11, j11, j12);
            }
        });
    }

    @Override // e4.a
    public final void j(final long j11, final int i11) {
        final c.a aVarA1 = a1();
        q2(aVarA1, PointerIconCompat.TYPE_GRABBING, new z3.n.a() { // from class: e4.d
            @Override // z3.n.a
            public final void invoke(Object obj) {
                ((c) obj).w0(aVarA1, j11, i11);
            }
        });
    }

    @Override // e4.a
    public void k(final AudioSink.a aVar) {
        final c.a aVarB1 = b1();
        q2(aVarB1, 1031, new z3.n.a() { // from class: e4.f1
            @Override // z3.n.a
            public final void invoke(Object obj) {
                ((c) obj).O(aVarB1, aVar);
            }
        });
    }

    @Override // e4.a
    public void l(final AudioSink.a aVar) {
        final c.a aVarB1 = b1();
        q2(aVarB1, 1032, new z3.n.a() { // from class: e4.j1
            @Override // z3.n.a
            public final void invoke(Object obj) {
                ((c) obj).Z(aVarB1, aVar);
            }
        });
    }

    @Override // e4.a
    public final void m() {
        if (this.f63928j) {
            return;
        }
        final c.a aVarV0 = V0();
        this.f63928j = true;
        q2(aVarV0, -1, new z3.n.a() { // from class: e4.r0
            @Override // z3.n.a
            public final void invoke(Object obj) {
                ((c) obj).p(aVarV0);
            }
        });
    }

    @Override // e4.a
    public final void n(final androidx.media3.exoplayer.n nVar) {
        final c.a aVarB1 = b1();
        q2(aVarB1, PointerIconCompat.TYPE_CROSSHAIR, new z3.n.a() { // from class: e4.c0
            @Override // z3.n.a
            public final void invoke(Object obj) {
                ((c) obj).C(aVarB1, nVar);
            }
        });
    }

    @Override // e4.a
    public final void o(final androidx.media3.exoplayer.n nVar) {
        final c.a aVarB1 = b1();
        q2(aVarB1, PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW, new z3.n.a() { // from class: e4.w
            @Override // z3.n.a
            public final void invoke(Object obj) {
                ((c) obj).I(aVarB1, nVar);
            }
        });
    }

    public final /* synthetic */ void o2(androidx.media3.common.h0 h0Var, c cVar, androidx.media3.common.s sVar) {
        cVar.e0(h0Var, new c.b(sVar, this.f63924f));
    }

    @Override // e4.a
    public final void onAudioDecoderInitialized(final String str, final long j11, final long j12) {
        final c.a aVarB1 = b1();
        q2(aVarB1, PointerIconCompat.TYPE_TEXT, new z3.n.a() { // from class: e4.b0
            @Override // z3.n.a
            public final void invoke(Object obj) {
                q1.g1(aVarB1, str, j12, j11, (c) obj);
            }
        });
    }

    @Override // androidx.media3.common.h0.d
    public void onAvailableCommandsChanged(final androidx.media3.common.h0.b bVar) {
        final c.a aVarV0 = V0();
        q2(aVarV0, 13, new z3.n.a() { // from class: e4.l
            @Override // z3.n.a
            public final void invoke(Object obj) {
                ((c) obj).f(aVarV0, bVar);
            }
        });
    }

    @Override // androidx.media3.exoplayer.upstream.e.a
    public final void onBandwidthSample(final int i11, final long j11, final long j12) {
        final c.a aVarY0 = Y0();
        q2(aVarY0, PointerIconCompat.TYPE_CELL, new z3.n.a() { // from class: e4.i1
            @Override // z3.n.a
            public final void invoke(Object obj) {
                ((c) obj).i(aVarY0, i11, j11, j12);
            }
        });
    }

    @Override // androidx.media3.common.h0.d
    public void onCues(final List<y3.a> list) {
        final c.a aVarV0 = V0();
        q2(aVarV0, 27, new z3.n.a() { // from class: e4.s
            @Override // z3.n.a
            public final void invoke(Object obj) {
                ((c) obj).b(aVarV0, list);
            }
        });
    }

    @Override // androidx.media3.common.h0.d
    public void onCues(final y3.b bVar) {
        final c.a aVarV0 = V0();
        q2(aVarV0, 27, new z3.n.a() { // from class: e4.d0
            @Override // z3.n.a
            public final void invoke(Object obj) {
                ((c) obj).y(aVarV0, bVar);
            }
        });
    }

    @Override // androidx.media3.common.h0.d
    public void onDeviceInfoChanged(final androidx.media3.common.o oVar) {
        final c.a aVarV0 = V0();
        q2(aVarV0, 29, new z3.n.a() { // from class: e4.m
            @Override // z3.n.a
            public final void invoke(Object obj) {
                ((c) obj).v0(aVarV0, oVar);
            }
        });
    }

    @Override // androidx.media3.common.h0.d
    public void onDeviceVolumeChanged(final int i11, final boolean z11) {
        final c.a aVarV0 = V0();
        q2(aVarV0, 30, new z3.n.a() { // from class: e4.q
            @Override // z3.n.a
            public final void invoke(Object obj) {
                ((c) obj).u(aVarV0, i11, z11);
            }
        });
    }

    @Override // e4.a
    public final void onDroppedFrames(final int i11, final long j11) {
        final c.a aVarA1 = a1();
        q2(aVarA1, PointerIconCompat.TYPE_ZOOM_IN, new z3.n.a() { // from class: e4.v
            @Override // z3.n.a
            public final void invoke(Object obj) {
                ((c) obj).l0(aVarA1, i11, j11);
            }
        });
    }

    @Override // androidx.media3.common.h0.d
    public void onEvents(androidx.media3.common.h0 h0Var, androidx.media3.common.h0.c cVar) {
    }

    @Override // androidx.media3.common.h0.d
    public final void onIsLoadingChanged(final boolean z11) {
        final c.a aVarV0 = V0();
        q2(aVarV0, 3, new z3.n.a() { // from class: e4.v0
            @Override // z3.n.a
            public final void invoke(Object obj) {
                q1.E1(aVarV0, z11, (c) obj);
            }
        });
    }

    @Override // androidx.media3.common.h0.d
    public void onIsPlayingChanged(final boolean z11) {
        final c.a aVarV0 = V0();
        q2(aVarV0, 7, new z3.n.a() { // from class: e4.f0
            @Override // z3.n.a
            public final void invoke(Object obj) {
                ((c) obj).e(aVarV0, z11);
            }
        });
    }

    @Override // androidx.media3.common.h0.d
    public void onLoadingChanged(boolean z11) {
    }

    @Override // androidx.media3.common.h0.d
    public final void onMediaItemTransition(@Nullable final androidx.media3.common.b0 b0Var, final int i11) {
        final c.a aVarV0 = V0();
        q2(aVarV0, 1, new z3.n.a() { // from class: e4.i0
            @Override // z3.n.a
            public final void invoke(Object obj) {
                ((c) obj).V(aVarV0, b0Var, i11);
            }
        });
    }

    @Override // androidx.media3.common.h0.d
    public void onMediaMetadataChanged(final androidx.media3.common.d0 d0Var) {
        final c.a aVarV0 = V0();
        q2(aVarV0, 14, new z3.n.a() { // from class: e4.m0
            @Override // z3.n.a
            public final void invoke(Object obj) {
                ((c) obj).b0(aVarV0, d0Var);
            }
        });
    }

    @Override // androidx.media3.common.h0.d
    public final void onMetadata(final Metadata metadata) {
        final c.a aVarV0 = V0();
        q2(aVarV0, 28, new z3.n.a() { // from class: e4.a0
            @Override // z3.n.a
            public final void invoke(Object obj) {
                ((c) obj).w(aVarV0, metadata);
            }
        });
    }

    @Override // androidx.media3.common.h0.d
    public final void onPlayWhenReadyChanged(final boolean z11, final int i11) {
        final c.a aVarV0 = V0();
        q2(aVarV0, 5, new z3.n.a() { // from class: e4.e0
            @Override // z3.n.a
            public final void invoke(Object obj) {
                ((c) obj).j(aVarV0, z11, i11);
            }
        });
    }

    @Override // androidx.media3.common.h0.d
    public final void onPlaybackParametersChanged(final androidx.media3.common.g0 g0Var) {
        final c.a aVarV0 = V0();
        q2(aVarV0, 12, new z3.n.a() { // from class: e4.e
            @Override // z3.n.a
            public final void invoke(Object obj) {
                ((c) obj).u0(aVarV0, g0Var);
            }
        });
    }

    @Override // androidx.media3.common.h0.d
    public final void onPlaybackStateChanged(final int i11) {
        final c.a aVarV0 = V0();
        q2(aVarV0, 4, new z3.n.a() { // from class: e4.h0
            @Override // z3.n.a
            public final void invoke(Object obj) {
                ((c) obj).S(aVarV0, i11);
            }
        });
    }

    @Override // androidx.media3.common.h0.d
    public final void onPlaybackSuppressionReasonChanged(final int i11) {
        final c.a aVarV0 = V0();
        q2(aVarV0, 6, new z3.n.a() { // from class: e4.k0
            @Override // z3.n.a
            public final void invoke(Object obj) {
                ((c) obj).H(aVarV0, i11);
            }
        });
    }

    @Override // androidx.media3.common.h0.d
    public final void onPlayerError(final PlaybackException playbackException) {
        final c.a aVarC1 = c1(playbackException);
        q2(aVarC1, 10, new z3.n.a() { // from class: e4.y
            @Override // z3.n.a
            public final void invoke(Object obj) {
                ((c) obj).t(aVarC1, playbackException);
            }
        });
    }

    @Override // androidx.media3.common.h0.d
    public void onPlayerErrorChanged(@Nullable final PlaybackException playbackException) {
        final c.a aVarC1 = c1(playbackException);
        q2(aVarC1, 10, new z3.n.a() { // from class: e4.l0
            @Override // z3.n.a
            public final void invoke(Object obj) {
                ((c) obj).r(aVarC1, playbackException);
            }
        });
    }

    @Override // androidx.media3.common.h0.d
    public final void onPlayerStateChanged(final boolean z11, final int i11) {
        final c.a aVarV0 = V0();
        q2(aVarV0, -1, new z3.n.a() { // from class: e4.m1
            @Override // z3.n.a
            public final void invoke(Object obj) {
                ((c) obj).X(aVarV0, z11, i11);
            }
        });
    }

    @Override // androidx.media3.common.h0.d
    public void onPositionDiscontinuity(int i11) {
    }

    @Override // androidx.media3.common.h0.d
    public final void onPositionDiscontinuity(final androidx.media3.common.h0.e eVar, final androidx.media3.common.h0.e eVar2, final int i11) {
        if (i11 == 1) {
            this.f63928j = false;
        }
        this.f63923d.j((androidx.media3.common.h0) z3.a.e(this.f63926h));
        final c.a aVarV0 = V0();
        q2(aVarV0, 11, new z3.n.a() { // from class: e4.k
            @Override // z3.n.a
            public final void invoke(Object obj) {
                q1.U1(aVarV0, i11, eVar, eVar2, (c) obj);
            }
        });
    }

    @Override // androidx.media3.common.h0.d
    public void onRenderedFirstFrame() {
    }

    @Override // androidx.media3.common.h0.d
    public final void onRepeatModeChanged(final int i11) {
        final c.a aVarV0 = V0();
        q2(aVarV0, 8, new z3.n.a() { // from class: e4.h
            @Override // z3.n.a
            public final void invoke(Object obj) {
                ((c) obj).i0(aVarV0, i11);
            }
        });
    }

    @Override // androidx.media3.common.h0.d
    public final void onShuffleModeEnabledChanged(final boolean z11) {
        final c.a aVarV0 = V0();
        q2(aVarV0, 9, new z3.n.a() { // from class: e4.g0
            @Override // z3.n.a
            public final void invoke(Object obj) {
                ((c) obj).M(aVarV0, z11);
            }
        });
    }

    @Override // androidx.media3.common.h0.d
    public final void onSkipSilenceEnabledChanged(final boolean z11) {
        final c.a aVarB1 = b1();
        q2(aVarB1, 23, new z3.n.a() { // from class: e4.k1
            @Override // z3.n.a
            public final void invoke(Object obj) {
                ((c) obj).c(aVarB1, z11);
            }
        });
    }

    @Override // androidx.media3.common.h0.d
    public final void onSurfaceSizeChanged(final int i11, final int i12) {
        final c.a aVarB1 = b1();
        q2(aVarB1, 24, new z3.n.a() { // from class: e4.t0
            @Override // z3.n.a
            public final void invoke(Object obj) {
                ((c) obj).J(aVarB1, i11, i12);
            }
        });
    }

    @Override // androidx.media3.common.h0.d
    public final void onTimelineChanged(androidx.media3.common.m0 m0Var, final int i11) {
        this.f63923d.l((androidx.media3.common.h0) z3.a.e(this.f63926h));
        final c.a aVarV0 = V0();
        q2(aVarV0, 0, new z3.n.a() { // from class: e4.u
            @Override // z3.n.a
            public final void invoke(Object obj) {
                ((c) obj).d0(aVarV0, i11);
            }
        });
    }

    @Override // androidx.media3.common.h0.d
    public void onTrackSelectionParametersChanged(final androidx.media3.common.p0 p0Var) {
        final c.a aVarV0 = V0();
        q2(aVarV0, 19, new z3.n.a() { // from class: e4.g
            @Override // z3.n.a
            public final void invoke(Object obj) {
                ((c) obj).c0(aVarV0, p0Var);
            }
        });
    }

    @Override // androidx.media3.common.h0.d
    public void onTracksChanged(final androidx.media3.common.q0 q0Var) {
        final c.a aVarV0 = V0();
        q2(aVarV0, 2, new z3.n.a() { // from class: e4.n
            @Override // z3.n.a
            public final void invoke(Object obj) {
                ((c) obj).n0(aVarV0, q0Var);
            }
        });
    }

    @Override // e4.a
    public final void onVideoDecoderInitialized(final String str, final long j11, final long j12) {
        final c.a aVarB1 = b1();
        q2(aVarB1, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, new z3.n.a() { // from class: e4.t
            @Override // z3.n.a
            public final void invoke(Object obj) {
                q1.f2(aVarB1, str, j12, j11, (c) obj);
            }
        });
    }

    @Override // androidx.media3.common.h0.d
    public final void onVideoSizeChanged(final androidx.media3.common.t0 t0Var) {
        final c.a aVarB1 = b1();
        q2(aVarB1, 25, new z3.n.a() { // from class: e4.c1
            @Override // z3.n.a
            public final void invoke(Object obj) {
                q1.l2(aVarB1, t0Var, (c) obj);
            }
        });
    }

    @Override // androidx.media3.common.h0.d
    public final void onVolumeChanged(final float f11) {
        final c.a aVarB1 = b1();
        q2(aVarB1, 22, new z3.n.a() { // from class: e4.p1
            @Override // z3.n.a
            public final void invoke(Object obj) {
                ((c) obj).N(aVarB1, f11);
            }
        });
    }

    @Override // androidx.media3.exoplayer.drm.b
    public final void p(int i11, @Nullable androidx.media3.exoplayer.source.l.b bVar, final int i12) {
        final c.a aVarZ0 = Z0(i11, bVar);
        q2(aVarZ0, 1022, new z3.n.a() { // from class: e4.z0
            @Override // z3.n.a
            public final void invoke(Object obj) {
                q1.A1(aVarZ0, i12, (c) obj);
            }
        });
    }

    public final void p2() {
        final c.a aVarV0 = V0();
        q2(aVarV0, 1028, new z3.n.a() { // from class: e4.b1
            @Override // z3.n.a
            public final void invoke(Object obj) {
                ((c) obj).t0(aVarV0);
            }
        });
        this.f63925g.j();
    }

    @Override // e4.a
    public final void q(List<androidx.media3.exoplayer.source.l.b> list, @Nullable androidx.media3.exoplayer.source.l.b bVar) {
        this.f63923d.k(list, bVar, (androidx.media3.common.h0) z3.a.e(this.f63926h));
    }

    public final void q2(c.a aVar, int i11, z3.n.a<c> aVar2) {
        this.f63924f.put(i11, aVar);
        this.f63925g.l(i11, aVar2);
    }

    @Override // androidx.media3.exoplayer.drm.b
    public /* synthetic */ void r(int i11, androidx.media3.exoplayer.source.l.b bVar) {
        i4.k.a(this, i11, bVar);
    }

    @Override // e4.a
    @CallSuper
    public void release() {
        ((z3.j) z3.a.i(this.f63927i)).post(new Runnable() { // from class: e4.p0
            @Override // java.lang.Runnable
            public final void run() {
                this.f63912a.p2();
            }
        });
    }

    @Override // e4.a
    public final void s(final androidx.media3.common.y yVar, @Nullable final androidx.media3.exoplayer.o oVar) {
        final c.a aVarB1 = b1();
        q2(aVarB1, PointerIconCompat.TYPE_VERTICAL_TEXT, new z3.n.a() { // from class: e4.n0
            @Override // z3.n.a
            public final void invoke(Object obj) {
                q1.k1(aVarB1, yVar, oVar, (c) obj);
            }
        });
    }

    @Override // e4.a
    public final void t(final androidx.media3.exoplayer.n nVar) {
        final c.a aVarA1 = a1();
        q2(aVarA1, PointerIconCompat.TYPE_ALL_SCROLL, new z3.n.a() { // from class: e4.o0
            @Override // z3.n.a
            public final void invoke(Object obj) {
                ((c) obj).D(aVarA1, nVar);
            }
        });
    }

    @Override // androidx.media3.exoplayer.drm.b
    public final void u(int i11, @Nullable androidx.media3.exoplayer.source.l.b bVar) {
        final c.a aVarZ0 = Z0(i11, bVar);
        q2(aVarZ0, 1026, new z3.n.a() { // from class: e4.l1
            @Override // z3.n.a
            public final void invoke(Object obj) {
                ((c) obj).s(aVarZ0);
            }
        });
    }

    @Override // androidx.media3.exoplayer.drm.b
    public final void v(int i11, @Nullable androidx.media3.exoplayer.source.l.b bVar, final Exception exc) {
        final c.a aVarZ0 = Z0(i11, bVar);
        q2(aVarZ0, 1024, new z3.n.a() { // from class: e4.u0
            @Override // z3.n.a
            public final void invoke(Object obj) {
                ((c) obj).z(aVarZ0, exc);
            }
        });
    }

    @Override // e4.a
    public final void w(final androidx.media3.common.y yVar, @Nullable final androidx.media3.exoplayer.o oVar) {
        final c.a aVarB1 = b1();
        q2(aVarB1, PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, new z3.n.a() { // from class: e4.n1
            @Override // z3.n.a
            public final void invoke(Object obj) {
                q1.k2(aVarB1, yVar, oVar, (c) obj);
            }
        });
    }

    @Override // e4.a
    public final void x(final androidx.media3.exoplayer.n nVar) {
        final c.a aVarA1 = a1();
        q2(aVarA1, PointerIconCompat.TYPE_GRAB, new z3.n.a() { // from class: e4.s0
            @Override // z3.n.a
            public final void invoke(Object obj) {
                ((c) obj).g0(aVarA1, nVar);
            }
        });
    }

    @Override // androidx.media3.exoplayer.source.m
    public final void y(int i11, @Nullable androidx.media3.exoplayer.source.l.b bVar, final p4.n nVar, final p4.o oVar) {
        final c.a aVarZ0 = Z0(i11, bVar);
        q2(aVarZ0, 1002, new z3.n.a() { // from class: e4.x
            @Override // z3.n.a
            public final void invoke(Object obj) {
                ((c) obj).B(aVarZ0, nVar, oVar);
            }
        });
    }

    @Override // androidx.media3.exoplayer.drm.b
    public final void z(int i11, @Nullable androidx.media3.exoplayer.source.l.b bVar) {
        final c.a aVarZ0 = Z0(i11, bVar);
        q2(aVarZ0, InputDeviceCompat.SOURCE_GAMEPAD, new z3.n.a() { // from class: e4.e1
            @Override // z3.n.a
            public final void invoke(Object obj) {
                ((c) obj).k(aVarZ0);
            }
        });
    }
}
