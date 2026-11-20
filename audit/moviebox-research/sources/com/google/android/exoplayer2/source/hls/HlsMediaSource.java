package com.google.android.exoplayer2.source.hls;

import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.k1;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.u1;
import com.google.android.exoplayer2.upstream.k0;
import com.google.android.exoplayer2.upstream.v;
import com.google.android.exoplayer2.upstream.z;
import com.google.android.exoplayer2.util.o0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.util.List;
import nh.f0;
import sg.u;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class HlsMediaSource extends com.google.android.exoplayer2.source.a implements HlsPlaylistTracker.c {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final g f33951i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final u1.h f33952j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final f f33953k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final nh.d f33954l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final com.google.android.exoplayer2.drm.c f33955m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final z f33956n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f33957o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f33958p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f33959q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final HlsPlaylistTracker f33960r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final long f33961s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final u1 f33962t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public u1.g f33963u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @Nullable
    public k0 f33964v;

    /* JADX INFO: compiled from: source.java */
    public static final class Factory implements com.google.android.exoplayer2.source.i.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f f33965a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public g f33966b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public sh.f f33967c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public HlsPlaylistTracker.a f33968d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public nh.d f33969e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public u f33970f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public z f33971g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f33972h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f33973i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f33974j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public long f33975k;

        public Factory(f fVar) {
            this.f33965a = (f) com.google.android.exoplayer2.util.a.e(fVar);
            this.f33970f = new com.google.android.exoplayer2.drm.a();
            this.f33967c = new sh.a();
            this.f33968d = com.google.android.exoplayer2.source.hls.playlist.a.f34133q;
            this.f33966b = g.f34019a;
            this.f33971g = new v();
            this.f33969e = new nh.e();
            this.f33973i = 1;
            this.f33975k = C.TIME_UNSET;
            this.f33972h = true;
        }

        public Factory(com.google.android.exoplayer2.upstream.k.a aVar) {
            this(new c(aVar));
        }

        @Override // com.google.android.exoplayer2.source.i.a
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public HlsMediaSource a(u1 u1Var) {
            com.google.android.exoplayer2.util.a.e(u1Var.f34776b);
            sh.f dVar = this.f33967c;
            List<StreamKey> list = u1Var.f34776b.f34842d;
            if (!list.isEmpty()) {
                dVar = new sh.d(dVar, list);
            }
            f fVar = this.f33965a;
            g gVar = this.f33966b;
            nh.d dVar2 = this.f33969e;
            com.google.android.exoplayer2.drm.c cVarA = this.f33970f.a(u1Var);
            z zVar = this.f33971g;
            return new HlsMediaSource(u1Var, fVar, gVar, dVar2, cVarA, zVar, this.f33968d.a(this.f33965a, zVar, dVar), this.f33975k, this.f33972h, this.f33973i, this.f33974j);
        }

        @Override // com.google.android.exoplayer2.source.i.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Factory b(u uVar) {
            this.f33970f = (u) com.google.android.exoplayer2.util.a.f(uVar, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        @Override // com.google.android.exoplayer2.source.i.a
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Factory c(z zVar) {
            this.f33971g = (z) com.google.android.exoplayer2.util.a.f(zVar, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }
    }

    static {
        k1.a("goog.exo.hls");
    }

    public HlsMediaSource(u1 u1Var, f fVar, g gVar, nh.d dVar, com.google.android.exoplayer2.drm.c cVar, z zVar, HlsPlaylistTracker hlsPlaylistTracker, long j11, boolean z11, int i11, boolean z12) {
        this.f33952j = (u1.h) com.google.android.exoplayer2.util.a.e(u1Var.f34776b);
        this.f33962t = u1Var;
        this.f33963u = u1Var.f34778d;
        this.f33953k = fVar;
        this.f33951i = gVar;
        this.f33954l = dVar;
        this.f33955m = cVar;
        this.f33956n = zVar;
        this.f33960r = hlsPlaylistTracker;
        this.f33961s = j11;
        this.f33957o = z11;
        this.f33958p = i11;
        this.f33959q = z12;
    }

    @Nullable
    public static com.google.android.exoplayer2.source.hls.playlist.c.b G(List<com.google.android.exoplayer2.source.hls.playlist.c.b> list, long j11) {
        com.google.android.exoplayer2.source.hls.playlist.c.b bVar = null;
        for (int i11 = 0; i11 < list.size(); i11++) {
            com.google.android.exoplayer2.source.hls.playlist.c.b bVar2 = list.get(i11);
            long j12 = bVar2.f34191f;
            if (j12 > j11 || !bVar2.f34180m) {
                if (j12 > j11) {
                    break;
                }
            } else {
                bVar = bVar2;
            }
        }
        return bVar;
    }

    public static com.google.android.exoplayer2.source.hls.playlist.c.d H(List<com.google.android.exoplayer2.source.hls.playlist.c.d> list, long j11) {
        return list.get(o0.g(list, Long.valueOf(j11), true, true));
    }

    public static long K(com.google.android.exoplayer2.source.hls.playlist.c cVar, long j11) {
        long j12;
        com.google.android.exoplayer2.source.hls.playlist.c.f fVar = cVar.f34179v;
        long j13 = cVar.f34162e;
        if (j13 != C.TIME_UNSET) {
            j12 = cVar.f34178u - j13;
        } else {
            long j14 = fVar.f34201d;
            if (j14 == C.TIME_UNSET || cVar.f34171n == C.TIME_UNSET) {
                long j15 = fVar.f34200c;
                j12 = j15 != C.TIME_UNSET ? j15 : cVar.f34170m * 3;
            } else {
                j12 = j14;
            }
        }
        return j12 + j11;
    }

    @Override // com.google.android.exoplayer2.source.a
    public void B(@Nullable k0 k0Var) {
        this.f33964v = k0Var;
        this.f33955m.prepare();
        this.f33955m.b((Looper) com.google.android.exoplayer2.util.a.e(Looper.myLooper()), z());
        this.f33960r.o(this.f33952j.f34839a, v(null), this);
    }

    @Override // com.google.android.exoplayer2.source.a
    public void D() {
        this.f33960r.stop();
        this.f33955m.release();
    }

    public final f0 E(com.google.android.exoplayer2.source.hls.playlist.c cVar, long j11, long j12, h hVar) {
        long jB = cVar.f34165h - this.f33960r.b();
        long j13 = cVar.f34172o ? jB + cVar.f34178u : -9223372036854775807L;
        long jI = I(cVar);
        long j14 = this.f33963u.f34829a;
        L(cVar, o0.r(j14 != C.TIME_UNSET ? o0.C0(j14) : K(cVar, jI), jI, cVar.f34178u + jI));
        return new f0(j11, j12, C.TIME_UNSET, j13, cVar.f34178u, jB, J(cVar, jI), true, !cVar.f34172o, cVar.f34161d == 2 && cVar.f34163f, hVar, this.f33962t, this.f33963u);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x002e  */
    public final f0 F(com.google.android.exoplayer2.source.hls.playlist.c cVar, long j11, long j12, h hVar) {
        long j13;
        if (cVar.f34162e == C.TIME_UNSET || cVar.f34175r.isEmpty()) {
            j13 = 0;
        } else if (cVar.f34164g) {
            j13 = cVar.f34162e;
        } else {
            long j14 = cVar.f34162e;
            if (j14 == cVar.f34178u) {
                j13 = cVar.f34162e;
            } else {
                j13 = H(cVar.f34175r, j14).f34191f;
            }
        }
        long j15 = j13;
        long j16 = cVar.f34178u;
        return new f0(j11, j12, C.TIME_UNSET, j16, j16, 0L, j15, true, false, true, hVar, this.f33962t, null);
    }

    public final long I(com.google.android.exoplayer2.source.hls.playlist.c cVar) {
        if (cVar.f34173p) {
            return o0.C0(o0.b0(this.f33961s)) - cVar.d();
        }
        return 0L;
    }

    public final long J(com.google.android.exoplayer2.source.hls.playlist.c cVar, long j11) {
        long jC0 = cVar.f34162e;
        if (jC0 == C.TIME_UNSET) {
            jC0 = (cVar.f34178u + j11) - o0.C0(this.f33963u.f34829a);
        }
        if (cVar.f34164g) {
            return jC0;
        }
        com.google.android.exoplayer2.source.hls.playlist.c.b bVarG = G(cVar.f34176s, jC0);
        if (bVarG != null) {
            return bVarG.f34191f;
        }
        if (cVar.f34175r.isEmpty()) {
            return 0L;
        }
        com.google.android.exoplayer2.source.hls.playlist.c.d dVarH = H(cVar.f34175r, jC0);
        com.google.android.exoplayer2.source.hls.playlist.c.b bVarG2 = G(dVarH.f34186n, jC0);
        return bVarG2 != null ? bVarG2.f34191f : dVarH.f34191f;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0028  */
    public final void L(com.google.android.exoplayer2.source.hls.playlist.c cVar, long j11) {
        boolean z11;
        u1.g gVar = this.f33962t.f34778d;
        if (gVar.f34832d == -3.4028235E38f && gVar.f34833f == -3.4028235E38f) {
            com.google.android.exoplayer2.source.hls.playlist.c.f fVar = cVar.f34179v;
            if (fVar.f34200c == C.TIME_UNSET && fVar.f34201d == C.TIME_UNSET) {
                z11 = true;
            } else {
                z11 = false;
            }
        } else {
            z11 = false;
        }
        this.f33963u = new u1.g.a().k(o0.f1(j11)).j(z11 ? 1.0f : this.f33963u.f34832d).h(z11 ? 1.0f : this.f33963u.f34833f).f();
    }

    @Override // com.google.android.exoplayer2.source.i
    public u1 a() {
        return this.f33962t;
    }

    @Override // com.google.android.exoplayer2.source.i
    public com.google.android.exoplayer2.source.h e(com.google.android.exoplayer2.source.i.b bVar, com.google.android.exoplayer2.upstream.b bVar2, long j11) {
        com.google.android.exoplayer2.source.j.a aVarV = v(bVar);
        return new k(this.f33951i, this.f33960r, this.f33953k, this.f33964v, this.f33955m, t(bVar), this.f33956n, aVarV, bVar2, this.f33954l, this.f33957o, this.f33958p, this.f33959q, z());
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.c
    public void g(com.google.android.exoplayer2.source.hls.playlist.c cVar) {
        long jF1 = cVar.f34173p ? o0.f1(cVar.f34165h) : -9223372036854775807L;
        int i11 = cVar.f34161d;
        long j11 = (i11 == 2 || i11 == 1) ? jF1 : -9223372036854775807L;
        h hVar = new h((com.google.android.exoplayer2.source.hls.playlist.d) com.google.android.exoplayer2.util.a.e(this.f33960r.c()), cVar);
        C(this.f33960r.f() ? E(cVar, j11, jF1, hVar) : F(cVar, j11, jF1, hVar));
    }

    @Override // com.google.android.exoplayer2.source.i
    public void k(com.google.android.exoplayer2.source.h hVar) {
        ((k) hVar).q();
    }

    @Override // com.google.android.exoplayer2.source.i
    public void maybeThrowSourceInfoRefreshError() throws IOException {
        this.f33960r.h();
    }
}
