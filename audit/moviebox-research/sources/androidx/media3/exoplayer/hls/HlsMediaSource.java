package androidx.media3.exoplayer.hls;

import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.media3.common.StreamKey;
import androidx.media3.common.b0;
import androidx.media3.common.c0;
import androidx.media3.exoplayer.hls.playlist.HlsPlaylistTracker;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import i4.u;
import java.io.IOException;
import java.util.List;
import p4.g0;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class HlsMediaSource extends androidx.media3.exoplayer.source.a implements HlsPlaylistTracker.c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final g f10338h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final f f10339i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final p4.d f10340j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final androidx.media3.exoplayer.drm.c f10341k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final androidx.media3.exoplayer.upstream.m f10342l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f10343m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f10344n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f10345o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final HlsPlaylistTracker f10346p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final long f10347q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final long f10348r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public b0.g f10349s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @Nullable
    public c4.o f10350t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public b0 f10351u;

    /* JADX INFO: compiled from: source.java */
    public static final class Factory implements androidx.media3.exoplayer.source.l.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f f10352a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public g f10353b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public k4.f f10354c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public HlsPlaylistTracker.a f10355d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public p4.d f10356e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Nullable
        public androidx.media3.exoplayer.upstream.f.a f10357f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public u f10358g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public androidx.media3.exoplayer.upstream.m f10359h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f10360i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f10361j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f10362k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public long f10363l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public long f10364m;

        public Factory(androidx.media3.datasource.a.InterfaceC0090a interfaceC0090a) {
            this(new c(interfaceC0090a));
        }

        public Factory(f fVar) {
            this.f10352a = (f) z3.a.e(fVar);
            this.f10358g = new androidx.media3.exoplayer.drm.a();
            this.f10354c = new k4.a();
            this.f10355d = androidx.media3.exoplayer.hls.playlist.a.f10496q;
            this.f10353b = g.f10414a;
            this.f10359h = new androidx.media3.exoplayer.upstream.k();
            this.f10356e = new p4.e();
            this.f10361j = 1;
            this.f10363l = C.TIME_UNSET;
            this.f10360i = true;
        }

        @Override // androidx.media3.exoplayer.source.l.a
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public HlsMediaSource c(b0 b0Var) {
            z3.a.e(b0Var.f8951b);
            k4.f fVar = this.f10354c;
            List<StreamKey> list = b0Var.f8951b.f9050d;
            k4.f dVar = !list.isEmpty() ? new k4.d(fVar, list) : fVar;
            androidx.media3.exoplayer.upstream.f.a aVar = this.f10357f;
            if (aVar != null) {
                aVar.a(b0Var);
            }
            f fVar2 = this.f10352a;
            g gVar = this.f10353b;
            p4.d dVar2 = this.f10356e;
            androidx.media3.exoplayer.drm.c cVarA = this.f10358g.a(b0Var);
            androidx.media3.exoplayer.upstream.m mVar = this.f10359h;
            return new HlsMediaSource(b0Var, fVar2, gVar, dVar2, null, cVarA, mVar, this.f10355d.a(this.f10352a, mVar, dVar), this.f10363l, this.f10360i, this.f10361j, this.f10362k, this.f10364m);
        }

        @Override // androidx.media3.exoplayer.source.l.a
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public Factory b(boolean z11) {
            this.f10353b.b(z11);
            return this;
        }

        @Override // androidx.media3.exoplayer.source.l.a
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public Factory f(androidx.media3.exoplayer.upstream.f.a aVar) {
            this.f10357f = (androidx.media3.exoplayer.upstream.f.a) z3.a.e(aVar);
            return this;
        }

        @Override // androidx.media3.exoplayer.source.l.a
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public Factory d(u uVar) {
            this.f10358g = (u) z3.a.f(uVar, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        @Override // androidx.media3.exoplayer.source.l.a
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public Factory e(androidx.media3.exoplayer.upstream.m mVar) {
            this.f10359h = (androidx.media3.exoplayer.upstream.m) z3.a.f(mVar, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        @Override // androidx.media3.exoplayer.source.l.a
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public Factory a(o5.s.a aVar) {
            this.f10353b.a((o5.s.a) z3.a.e(aVar));
            return this;
        }
    }

    static {
        c0.a("media3.exoplayer.hls");
    }

    public HlsMediaSource(b0 b0Var, f fVar, g gVar, p4.d dVar, @Nullable androidx.media3.exoplayer.upstream.f fVar2, androidx.media3.exoplayer.drm.c cVar, androidx.media3.exoplayer.upstream.m mVar, HlsPlaylistTracker hlsPlaylistTracker, long j11, boolean z11, int i11, boolean z12, long j12) {
        this.f10351u = b0Var;
        this.f10349s = b0Var.f8953d;
        this.f10339i = fVar;
        this.f10338h = gVar;
        this.f10340j = dVar;
        this.f10341k = cVar;
        this.f10342l = mVar;
        this.f10346p = hlsPlaylistTracker;
        this.f10347q = j11;
        this.f10343m = z11;
        this.f10344n = i11;
        this.f10345o = z12;
        this.f10348r = j12;
    }

    @Nullable
    public static androidx.media3.exoplayer.hls.playlist.b.C0100b E(List<androidx.media3.exoplayer.hls.playlist.b.C0100b> list, long j11) {
        androidx.media3.exoplayer.hls.playlist.b.C0100b c0100b = null;
        for (int i11 = 0; i11 < list.size(); i11++) {
            androidx.media3.exoplayer.hls.playlist.b.C0100b c0100b2 = list.get(i11);
            long j12 = c0100b2.f10554f;
            if (j12 > j11 || !c0100b2.f10543m) {
                if (j12 > j11) {
                    break;
                }
            } else {
                c0100b = c0100b2;
            }
        }
        return c0100b;
    }

    public static androidx.media3.exoplayer.hls.playlist.b.d F(List<androidx.media3.exoplayer.hls.playlist.b.d> list, long j11) {
        return list.get(u0.e(list, Long.valueOf(j11), true, true));
    }

    public static long I(androidx.media3.exoplayer.hls.playlist.b bVar, long j11) {
        long j12;
        androidx.media3.exoplayer.hls.playlist.b.f fVar = bVar.f10542v;
        long j13 = bVar.f10525e;
        if (j13 != C.TIME_UNSET) {
            j12 = bVar.f10541u - j13;
        } else {
            long j14 = fVar.f10564d;
            if (j14 == C.TIME_UNSET || bVar.f10534n == C.TIME_UNSET) {
                long j15 = fVar.f10563c;
                j12 = j15 != C.TIME_UNSET ? j15 : bVar.f10533m * 3;
            } else {
                j12 = j14;
            }
        }
        return j12 + j11;
    }

    @Override // androidx.media3.exoplayer.source.a
    public void B() {
        this.f10346p.stop();
        this.f10341k.release();
    }

    public final g0 C(androidx.media3.exoplayer.hls.playlist.b bVar, long j11, long j12, h hVar) {
        long jB = bVar.f10528h - this.f10346p.b();
        long j13 = bVar.f10535o ? jB + bVar.f10541u : -9223372036854775807L;
        long jG = G(bVar);
        long j14 = this.f10349s.f9028a;
        J(bVar, u0.q(j14 != C.TIME_UNSET ? u0.S0(j14) : I(bVar, jG), jG, bVar.f10541u + jG));
        return new g0(j11, j12, C.TIME_UNSET, j13, bVar.f10541u, jB, H(bVar, jG), true, !bVar.f10535o, bVar.f10524d == 2 && bVar.f10526f, hVar, a(), this.f10349s);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x002e  */
    public final g0 D(androidx.media3.exoplayer.hls.playlist.b bVar, long j11, long j12, h hVar) {
        long j13;
        if (bVar.f10525e == C.TIME_UNSET || bVar.f10538r.isEmpty()) {
            j13 = 0;
        } else if (bVar.f10527g) {
            j13 = bVar.f10525e;
        } else {
            long j14 = bVar.f10525e;
            if (j14 == bVar.f10541u) {
                j13 = bVar.f10525e;
            } else {
                j13 = F(bVar.f10538r, j14).f10554f;
            }
        }
        long j15 = j13;
        long j16 = bVar.f10541u;
        return new g0(j11, j12, C.TIME_UNSET, j16, j16, 0L, j15, true, false, true, hVar, a(), null);
    }

    public final long G(androidx.media3.exoplayer.hls.playlist.b bVar) {
        if (bVar.f10536p) {
            return u0.S0(u0.i0(this.f10347q)) - bVar.d();
        }
        return 0L;
    }

    public final long H(androidx.media3.exoplayer.hls.playlist.b bVar, long j11) {
        long jS0 = bVar.f10525e;
        if (jS0 == C.TIME_UNSET) {
            jS0 = (bVar.f10541u + j11) - u0.S0(this.f10349s.f9028a);
        }
        if (bVar.f10527g) {
            return jS0;
        }
        androidx.media3.exoplayer.hls.playlist.b.C0100b c0100bE = E(bVar.f10539s, jS0);
        if (c0100bE != null) {
            return c0100bE.f10554f;
        }
        if (bVar.f10538r.isEmpty()) {
            return 0L;
        }
        androidx.media3.exoplayer.hls.playlist.b.d dVarF = F(bVar.f10538r, jS0);
        androidx.media3.exoplayer.hls.playlist.b.C0100b c0100bE2 = E(dVarF.f10549n, jS0);
        return c0100bE2 != null ? c0100bE2.f10554f : dVarF.f10554f;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x002a  */
    public final void J(androidx.media3.exoplayer.hls.playlist.b bVar, long j11) {
        boolean z11;
        b0.g gVar = a().f8953d;
        if (gVar.f9031d == -3.4028235E38f && gVar.f9032e == -3.4028235E38f) {
            androidx.media3.exoplayer.hls.playlist.b.f fVar = bVar.f10542v;
            if (fVar.f10563c == C.TIME_UNSET && fVar.f10564d == C.TIME_UNSET) {
                z11 = true;
            } else {
                z11 = false;
            }
        } else {
            z11 = false;
        }
        this.f10349s = new b0.g.a().k(u0.B1(j11)).j(z11 ? 1.0f : this.f10349s.f9031d).h(z11 ? 1.0f : this.f10349s.f9032e).f();
    }

    @Override // androidx.media3.exoplayer.source.l
    public synchronized b0 a() {
        return this.f10351u;
    }

    @Override // androidx.media3.exoplayer.hls.playlist.HlsPlaylistTracker.c
    public void g(androidx.media3.exoplayer.hls.playlist.b bVar) {
        long jB1 = bVar.f10536p ? u0.B1(bVar.f10528h) : -9223372036854775807L;
        int i11 = bVar.f10524d;
        long j11 = (i11 == 2 || i11 == 1) ? jB1 : -9223372036854775807L;
        h hVar = new h((androidx.media3.exoplayer.hls.playlist.c) z3.a.e(this.f10346p.c()), bVar);
        A(this.f10346p.f() ? C(bVar, j11, jB1, hVar) : D(bVar, j11, jB1, hVar));
    }

    @Override // androidx.media3.exoplayer.source.l
    public androidx.media3.exoplayer.source.k h(androidx.media3.exoplayer.source.l.b bVar, androidx.media3.exoplayer.upstream.b bVar2, long j11) {
        androidx.media3.exoplayer.source.m.a aVarU = u(bVar);
        return new l(this.f10338h, this.f10346p, this.f10339i, this.f10350t, null, this.f10341k, s(bVar), this.f10342l, aVarU, bVar2, this.f10340j, this.f10343m, this.f10344n, this.f10345o, x(), this.f10348r);
    }

    @Override // androidx.media3.exoplayer.source.l
    public void l(androidx.media3.exoplayer.source.k kVar) {
        ((l) kVar).u();
    }

    @Override // androidx.media3.exoplayer.source.l
    public void maybeThrowSourceInfoRefreshError() throws IOException {
        this.f10346p.h();
    }

    @Override // androidx.media3.exoplayer.source.a, androidx.media3.exoplayer.source.l
    public synchronized void n(b0 b0Var) {
        this.f10351u = b0Var;
    }

    @Override // androidx.media3.exoplayer.source.a, androidx.media3.exoplayer.source.l
    public boolean q(b0 b0Var) {
        b0 b0VarA = a();
        b0.h hVar = (b0.h) z3.a.e(b0VarA.f8951b);
        b0.h hVar2 = b0Var.f8951b;
        return hVar2 != null && hVar2.f9047a.equals(hVar.f9047a) && hVar2.f9050d.equals(hVar.f9050d) && u0.c(hVar2.f9049c, hVar.f9049c) && b0VarA.f8953d.equals(b0Var.f8953d);
    }

    @Override // androidx.media3.exoplayer.source.a
    public void z(@Nullable c4.o oVar) {
        this.f10350t = oVar;
        this.f10341k.a((Looper) z3.a.e(Looper.myLooper()), x());
        this.f10341k.prepare();
        this.f10346p.j(((b0.h) z3.a.e(a().f8951b)).f9047a, u(null), this);
    }
}
