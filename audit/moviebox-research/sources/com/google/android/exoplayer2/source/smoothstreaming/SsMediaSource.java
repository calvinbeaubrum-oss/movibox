package com.google.android.exoplayer2.source.smoothstreaming;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.k1;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.h;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.source.j;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.google.android.exoplayer2.u1;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.a0;
import com.google.android.exoplayer2.upstream.b0;
import com.google.android.exoplayer2.upstream.k;
import com.google.android.exoplayer2.upstream.k0;
import com.google.android.exoplayer2.upstream.v;
import com.google.android.exoplayer2.upstream.z;
import com.google.android.exoplayer2.util.o0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import nh.d;
import nh.e;
import nh.f0;
import nh.n;
import nh.o;
import sg.u;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class SsMediaSource extends com.google.android.exoplayer2.source.a implements Loader.b<b0<com.google.android.exoplayer2.source.smoothstreaming.manifest.a>> {
    public com.google.android.exoplayer2.source.smoothstreaming.manifest.a A;
    public Handler B;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f34660i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Uri f34661j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final u1.h f34662k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final u1 f34663l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final k.a f34664m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final b.a f34665n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final d f34666o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final com.google.android.exoplayer2.drm.c f34667p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final z f34668q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final long f34669r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final j.a f34670s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final b0.a<? extends com.google.android.exoplayer2.source.smoothstreaming.manifest.a> f34671t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ArrayList<c> f34672u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public k f34673v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Loader f34674w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public a0 f34675x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @Nullable
    public k0 f34676y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f34677z;

    /* JADX INFO: compiled from: source.java */
    public static final class Factory implements i.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b.a f34678a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public final k.a f34679b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public d f34680c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public u f34681d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public z f34682e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f34683f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Nullable
        public b0.a<? extends com.google.android.exoplayer2.source.smoothstreaming.manifest.a> f34684g;

        public Factory(b.a aVar, @Nullable k.a aVar2) {
            this.f34678a = (b.a) com.google.android.exoplayer2.util.a.e(aVar);
            this.f34679b = aVar2;
            this.f34681d = new com.google.android.exoplayer2.drm.a();
            this.f34682e = new v();
            this.f34683f = 30000L;
            this.f34680c = new e();
        }

        public Factory(k.a aVar) {
            this(new com.google.android.exoplayer2.source.smoothstreaming.a.C0370a(aVar), aVar);
        }

        @Override // com.google.android.exoplayer2.source.i.a
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public SsMediaSource a(u1 u1Var) {
            com.google.android.exoplayer2.util.a.e(u1Var.f34776b);
            b0.a ssManifestParser = this.f34684g;
            if (ssManifestParser == null) {
                ssManifestParser = new SsManifestParser();
            }
            List<StreamKey> list = u1Var.f34776b.f34842d;
            return new SsMediaSource(u1Var, null, this.f34679b, !list.isEmpty() ? new com.google.android.exoplayer2.offline.d(ssManifestParser, list) : ssManifestParser, this.f34678a, this.f34680c, this.f34681d.a(u1Var), this.f34682e, this.f34683f);
        }

        @Override // com.google.android.exoplayer2.source.i.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Factory b(u uVar) {
            this.f34681d = (u) com.google.android.exoplayer2.util.a.f(uVar, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        @Override // com.google.android.exoplayer2.source.i.a
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Factory c(z zVar) {
            this.f34682e = (z) com.google.android.exoplayer2.util.a.f(zVar, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }
    }

    static {
        k1.a("goog.exo.smoothstreaming");
    }

    public SsMediaSource(u1 u1Var, @Nullable com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar, @Nullable k.a aVar2, @Nullable b0.a<? extends com.google.android.exoplayer2.source.smoothstreaming.manifest.a> aVar3, b.a aVar4, d dVar, com.google.android.exoplayer2.drm.c cVar, z zVar, long j11) {
        com.google.android.exoplayer2.util.a.g(aVar == null || !aVar.f34745d);
        this.f34663l = u1Var;
        u1.h hVar = (u1.h) com.google.android.exoplayer2.util.a.e(u1Var.f34776b);
        this.f34662k = hVar;
        this.A = aVar;
        this.f34661j = hVar.f34839a.equals(Uri.EMPTY) ? null : o0.B(hVar.f34839a);
        this.f34664m = aVar2;
        this.f34671t = aVar3;
        this.f34665n = aVar4;
        this.f34666o = dVar;
        this.f34667p = cVar;
        this.f34668q = zVar;
        this.f34669r = j11;
        this.f34670s = v(null);
        this.f34660i = aVar != null;
        this.f34672u = new ArrayList<>();
    }

    @Override // com.google.android.exoplayer2.source.a
    public void B(@Nullable k0 k0Var) {
        this.f34676y = k0Var;
        this.f34667p.prepare();
        this.f34667p.b(Looper.myLooper(), z());
        if (this.f34660i) {
            this.f34675x = new a0.a();
            I();
            return;
        }
        this.f34673v = this.f34664m.createDataSource();
        Loader loader = new Loader("SsMediaSource");
        this.f34674w = loader;
        this.f34675x = loader;
        this.B = o0.w();
        K();
    }

    @Override // com.google.android.exoplayer2.source.a
    public void D() {
        this.A = this.f34660i ? this.A : null;
        this.f34673v = null;
        this.f34677z = 0L;
        Loader loader = this.f34674w;
        if (loader != null) {
            loader.k();
            this.f34674w = null;
        }
        Handler handler = this.B;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.B = null;
        }
        this.f34667p.release();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
    public void j(b0<com.google.android.exoplayer2.source.smoothstreaming.manifest.a> b0Var, long j11, long j12, boolean z11) {
        n nVar = new n(b0Var.f35256a, b0Var.f35257b, b0Var.d(), b0Var.b(), j11, j12, b0Var.a());
        this.f34668q.b(b0Var.f35256a);
        this.f34670s.q(nVar, b0Var.f35258c);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
    public void l(b0<com.google.android.exoplayer2.source.smoothstreaming.manifest.a> b0Var, long j11, long j12) {
        n nVar = new n(b0Var.f35256a, b0Var.f35257b, b0Var.d(), b0Var.b(), j11, j12, b0Var.a());
        this.f34668q.b(b0Var.f35256a);
        this.f34670s.t(nVar, b0Var.f35258c);
        this.A = b0Var.c();
        this.f34677z = j11 - j12;
        I();
        J();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public Loader.c n(b0<com.google.android.exoplayer2.source.smoothstreaming.manifest.a> b0Var, long j11, long j12, IOException iOException, int i11) {
        n nVar = new n(b0Var.f35256a, b0Var.f35257b, b0Var.d(), b0Var.b(), j11, j12, b0Var.a());
        long jC = this.f34668q.c(new z.c(nVar, new o(b0Var.f35258c), iOException, i11));
        Loader.c cVarG = jC == C.TIME_UNSET ? Loader.f35232g : Loader.g(false, jC);
        boolean z11 = !cVarG.c();
        this.f34670s.x(nVar, b0Var.f35258c, iOException, z11);
        if (z11) {
            this.f34668q.b(b0Var.f35256a);
        }
        return cVarG;
    }

    public final void I() {
        f0 f0Var;
        for (int i11 = 0; i11 < this.f34672u.size(); i11++) {
            this.f34672u.get(i11).l(this.A);
        }
        long jMax = Long.MIN_VALUE;
        long jMax2 = Long.MAX_VALUE;
        for (com.google.android.exoplayer2.source.smoothstreaming.manifest.a.b bVar : this.A.f34747f) {
            if (bVar.f34763k > 0) {
                jMax2 = Math.min(jMax2, bVar.e(0));
                jMax = Math.max(jMax, bVar.e(bVar.f34763k - 1) + bVar.c(bVar.f34763k - 1));
            }
        }
        if (jMax2 == Long.MAX_VALUE) {
            long j11 = this.A.f34745d ? -9223372036854775807L : 0L;
            com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar = this.A;
            boolean z11 = aVar.f34745d;
            f0Var = new f0(j11, 0L, 0L, 0L, true, z11, z11, aVar, this.f34663l);
        } else {
            com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar2 = this.A;
            if (aVar2.f34745d) {
                long j12 = aVar2.f34749h;
                if (j12 != C.TIME_UNSET && j12 > 0) {
                    jMax2 = Math.max(jMax2, jMax - j12);
                }
                long j13 = jMax2;
                long j14 = jMax - j13;
                long jC0 = j14 - o0.C0(this.f34669r);
                if (jC0 < 5000000) {
                    jC0 = Math.min(5000000L, j14 / 2);
                }
                f0Var = new f0(C.TIME_UNSET, j14, j13, jC0, true, true, true, this.A, this.f34663l);
            } else {
                long j15 = aVar2.f34748g;
                long j16 = j15 != C.TIME_UNSET ? j15 : jMax - jMax2;
                f0Var = new f0(jMax2 + j16, j16, jMax2, 0L, true, false, false, this.A, this.f34663l);
            }
        }
        C(f0Var);
    }

    public final void J() {
        if (this.A.f34745d) {
            this.B.postDelayed(new Runnable() { // from class: uh.a
                @Override // java.lang.Runnable
                public final void run() {
                    this.f78558a.K();
                }
            }, Math.max(0L, (this.f34677z + 5000) - SystemClock.elapsedRealtime()));
        }
    }

    public final void K() {
        if (this.f34674w.h()) {
            return;
        }
        b0 b0Var = new b0(this.f34673v, this.f34661j, 4, this.f34671t);
        this.f34670s.z(new n(b0Var.f35256a, b0Var.f35257b, this.f34674w.m(b0Var, this, this.f34668q.a(b0Var.f35258c))), b0Var.f35258c);
    }

    @Override // com.google.android.exoplayer2.source.i
    public u1 a() {
        return this.f34663l;
    }

    @Override // com.google.android.exoplayer2.source.i
    public h e(i.b bVar, com.google.android.exoplayer2.upstream.b bVar2, long j11) {
        j.a aVarV = v(bVar);
        c cVar = new c(this.A, this.f34665n, this.f34676y, this.f34666o, this.f34667p, t(bVar), this.f34668q, aVarV, this.f34675x, bVar2);
        this.f34672u.add(cVar);
        return cVar;
    }

    @Override // com.google.android.exoplayer2.source.i
    public void k(h hVar) {
        ((c) hVar).k();
        this.f34672u.remove(hVar);
    }

    @Override // com.google.android.exoplayer2.source.i
    public void maybeThrowSourceInfoRefreshError() throws IOException {
        this.f34675x.maybeThrowError();
    }
}
