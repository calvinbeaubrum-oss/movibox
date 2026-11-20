package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.source.hls.f;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.source.j;
import com.google.android.exoplayer2.upstream.HttpDataSource$InvalidResponseCodeException;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.b0;
import com.google.android.exoplayer2.upstream.k;
import com.google.android.exoplayer2.upstream.z;
import com.google.android.exoplayer2.util.o0;
import com.google.android.gms.common.api.Api;
import com.google.common.collect.e0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import nh.n;
import nh.o;
import sh.e;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a implements HlsPlaylistTracker, Loader.b<b0<e>> {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final HlsPlaylistTracker.a f34133q = new HlsPlaylistTracker.a() { // from class: sh.b
        @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.a
        public final HlsPlaylistTracker a(com.google.android.exoplayer2.source.hls.f fVar, z zVar, f fVar2) {
            return new com.google.android.exoplayer2.source.hls.playlist.a(fVar, zVar, fVar2);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f34134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final sh.f f34135b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final z f34136c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap<Uri, c> f34137d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CopyOnWriteArrayList<HlsPlaylistTracker.b> f34138f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final double f34139g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public j.a f34140h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public Loader f34141i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public Handler f34142j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public HlsPlaylistTracker.c f34143k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    public d f34144l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    public Uri f34145m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    public com.google.android.exoplayer2.source.hls.playlist.c f34146n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f34147o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f34148p;

    /* JADX INFO: compiled from: source.java */
    public class b implements HlsPlaylistTracker.b {
        public b() {
        }

        @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.b
        public boolean b(Uri uri, z.c cVar, boolean z11) {
            c cVar2;
            if (a.this.f34146n == null) {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                List<d.b> list = ((d) o0.j(a.this.f34144l)).f34205e;
                int i11 = 0;
                for (int i12 = 0; i12 < list.size(); i12++) {
                    c cVar3 = (c) a.this.f34137d.get(list.get(i12).f34218a);
                    if (cVar3 != null && jElapsedRealtime < cVar3.f34157i) {
                        i11++;
                    }
                }
                z.b bVarD = a.this.f34136c.d(new z.a(1, 0, a.this.f34144l.f34205e.size(), i11), cVar);
                if (bVarD != null && bVarD.f35525a == 2 && (cVar2 = (c) a.this.f34137d.get(uri)) != null) {
                    cVar2.h(bVarD.f35526b);
                }
            }
            return false;
        }

        @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.b
        public void c() {
            a.this.f34138f.remove(this);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class c implements Loader.b<b0<e>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f34150a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Loader f34151b = new Loader("DefaultHlsPlaylistTracker:MediaPlaylist");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final k f34152c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public com.google.android.exoplayer2.source.hls.playlist.c f34153d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f34154f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f34155g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f34156h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public long f34157i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f34158j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @Nullable
        public IOException f34159k;

        public c(Uri uri) {
            this.f34150a = uri;
            this.f34152c = a.this.f34134a.a(4);
        }

        public final boolean h(long j11) {
            this.f34157i = SystemClock.elapsedRealtime() + j11;
            return this.f34150a.equals(a.this.f34145m) && !a.this.L();
        }

        public final Uri i() {
            com.google.android.exoplayer2.source.hls.playlist.c cVar = this.f34153d;
            if (cVar != null) {
                com.google.android.exoplayer2.source.hls.playlist.c.f fVar = cVar.f34179v;
                if (fVar.f34198a != C.TIME_UNSET || fVar.f34202e) {
                    Uri.Builder builderBuildUpon = this.f34150a.buildUpon();
                    com.google.android.exoplayer2.source.hls.playlist.c cVar2 = this.f34153d;
                    if (cVar2.f34179v.f34202e) {
                        builderBuildUpon.appendQueryParameter("_HLS_msn", String.valueOf(cVar2.f34168k + ((long) cVar2.f34175r.size())));
                        com.google.android.exoplayer2.source.hls.playlist.c cVar3 = this.f34153d;
                        if (cVar3.f34171n != C.TIME_UNSET) {
                            List<com.google.android.exoplayer2.source.hls.playlist.c.b> list = cVar3.f34176s;
                            int size = list.size();
                            if (!list.isEmpty() && ((com.google.android.exoplayer2.source.hls.playlist.c.b) e0.g(list)).f34181n) {
                                size--;
                            }
                            builderBuildUpon.appendQueryParameter("_HLS_part", String.valueOf(size));
                        }
                    }
                    com.google.android.exoplayer2.source.hls.playlist.c.f fVar2 = this.f34153d.f34179v;
                    if (fVar2.f34198a != C.TIME_UNSET) {
                        builderBuildUpon.appendQueryParameter("_HLS_skip", fVar2.f34199b ? "v2" : "YES");
                    }
                    return builderBuildUpon.build();
                }
            }
            return this.f34150a;
        }

        @Nullable
        public com.google.android.exoplayer2.source.hls.playlist.c k() {
            return this.f34153d;
        }

        public boolean m() {
            int i11;
            if (this.f34153d == null) {
                return false;
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long jMax = Math.max(30000L, o0.f1(this.f34153d.f34178u));
            com.google.android.exoplayer2.source.hls.playlist.c cVar = this.f34153d;
            return cVar.f34172o || (i11 = cVar.f34161d) == 2 || i11 == 1 || this.f34154f + jMax > jElapsedRealtime;
        }

        public final /* synthetic */ void o(Uri uri) {
            this.f34158j = false;
            q(uri);
        }

        public void p() {
            r(this.f34150a);
        }

        public final void q(Uri uri) {
            b0 b0Var = new b0(this.f34152c, uri, 4, a.this.f34135b.b(a.this.f34144l, this.f34153d));
            a.this.f34140h.z(new n(b0Var.f35256a, b0Var.f35257b, this.f34151b.m(b0Var, this, a.this.f34136c.a(b0Var.f35258c))), b0Var.f35258c);
        }

        public final void r(final Uri uri) {
            this.f34157i = 0L;
            if (this.f34158j || this.f34151b.i() || this.f34151b.h()) {
                return;
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (jElapsedRealtime >= this.f34156h) {
                q(uri);
            } else {
                this.f34158j = true;
                a.this.f34142j.postDelayed(new Runnable() { // from class: sh.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f76355a.o(uri);
                    }
                }, this.f34156h - jElapsedRealtime);
            }
        }

        public void s() throws IOException {
            this.f34151b.maybeThrowError();
            IOException iOException = this.f34159k;
            if (iOException != null) {
                throw iOException;
            }
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
        public void j(b0<e> b0Var, long j11, long j12, boolean z11) {
            n nVar = new n(b0Var.f35256a, b0Var.f35257b, b0Var.d(), b0Var.b(), j11, j12, b0Var.a());
            a.this.f34136c.b(b0Var.f35256a);
            a.this.f34140h.q(nVar, 4);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public void l(b0<e> b0Var, long j11, long j12) {
            e eVarC = b0Var.c();
            n nVar = new n(b0Var.f35256a, b0Var.f35257b, b0Var.d(), b0Var.b(), j11, j12, b0Var.a());
            if (eVarC instanceof com.google.android.exoplayer2.source.hls.playlist.c) {
                w((com.google.android.exoplayer2.source.hls.playlist.c) eVarC, nVar);
                a.this.f34140h.t(nVar, 4);
            } else {
                this.f34159k = ParserException.createForMalformedManifest("Loaded playlist has unexpected type.", null);
                a.this.f34140h.x(nVar, 4, this.f34159k, true);
            }
            a.this.f34136c.b(b0Var.f35256a);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
        public Loader.c n(b0<e> b0Var, long j11, long j12, IOException iOException, int i11) {
            Loader.c cVarG;
            n nVar = new n(b0Var.f35256a, b0Var.f35257b, b0Var.d(), b0Var.b(), j11, j12, b0Var.a());
            boolean z11 = iOException instanceof HlsPlaylistParser.DeltaUpdateException;
            if ((b0Var.d().getQueryParameter("_HLS_msn") != null) || z11) {
                int i12 = iOException instanceof HttpDataSource$InvalidResponseCodeException ? ((HttpDataSource$InvalidResponseCodeException) iOException).responseCode : Api.BaseClientBuilder.API_PRIORITY_OTHER;
                if (z11 || i12 == 400 || i12 == 503) {
                    this.f34156h = SystemClock.elapsedRealtime();
                    p();
                    ((j.a) o0.j(a.this.f34140h)).x(nVar, b0Var.f35258c, iOException, true);
                    return Loader.f35231f;
                }
            }
            z.c cVar = new z.c(nVar, new o(b0Var.f35258c), iOException, i11);
            if (a.this.N(this.f34150a, cVar, false)) {
                long jC = a.this.f34136c.c(cVar);
                cVarG = jC != C.TIME_UNSET ? Loader.g(false, jC) : Loader.f35232g;
            } else {
                cVarG = Loader.f35231f;
            }
            boolean z12 = !cVarG.c();
            a.this.f34140h.x(nVar, b0Var.f35258c, iOException, z12);
            if (z12) {
                a.this.f34136c.b(b0Var.f35256a);
            }
            return cVarG;
        }

        public final void w(com.google.android.exoplayer2.source.hls.playlist.c cVar, n nVar) {
            boolean z11;
            long j11;
            com.google.android.exoplayer2.source.hls.playlist.c cVar2 = this.f34153d;
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.f34154f = jElapsedRealtime;
            com.google.android.exoplayer2.source.hls.playlist.c cVarG = a.this.G(cVar2, cVar);
            this.f34153d = cVarG;
            IOException playlistStuckException = null;
            if (cVarG != cVar2) {
                this.f34159k = null;
                this.f34155g = jElapsedRealtime;
                a.this.R(this.f34150a, cVarG);
            } else if (!cVarG.f34172o) {
                long size = cVar.f34168k + ((long) cVar.f34175r.size());
                com.google.android.exoplayer2.source.hls.playlist.c cVar3 = this.f34153d;
                if (size < cVar3.f34168k) {
                    playlistStuckException = new HlsPlaylistTracker.PlaylistResetException(this.f34150a);
                    z11 = true;
                } else {
                    double d11 = jElapsedRealtime - this.f34155g;
                    double dF1 = o0.f1(cVar3.f34170m) * a.this.f34139g;
                    z11 = false;
                    if (d11 > dF1) {
                        playlistStuckException = new HlsPlaylistTracker.PlaylistStuckException(this.f34150a);
                    }
                }
                if (playlistStuckException != null) {
                    this.f34159k = playlistStuckException;
                    a.this.N(this.f34150a, new z.c(nVar, new o(4), playlistStuckException, 1), z11);
                }
            }
            com.google.android.exoplayer2.source.hls.playlist.c cVar4 = this.f34153d;
            if (cVar4.f34179v.f34202e) {
                j11 = 0;
            } else {
                j11 = cVar4 != cVar2 ? cVar4.f34170m : cVar4.f34170m / 2;
            }
            this.f34156h = jElapsedRealtime + o0.f1(j11);
            if ((this.f34153d.f34171n != C.TIME_UNSET || this.f34150a.equals(a.this.f34145m)) && !this.f34153d.f34172o) {
                r(i());
            }
        }

        public void x() {
            this.f34151b.k();
        }
    }

    public a(f fVar, z zVar, sh.f fVar2) {
        this(fVar, zVar, fVar2, 3.5d);
    }

    public a(f fVar, z zVar, sh.f fVar2, double d11) {
        this.f34134a = fVar;
        this.f34135b = fVar2;
        this.f34136c = zVar;
        this.f34139g = d11;
        this.f34138f = new CopyOnWriteArrayList<>();
        this.f34137d = new HashMap<>();
        this.f34148p = C.TIME_UNSET;
    }

    public static com.google.android.exoplayer2.source.hls.playlist.c.d F(com.google.android.exoplayer2.source.hls.playlist.c cVar, com.google.android.exoplayer2.source.hls.playlist.c cVar2) {
        int i11 = (int) (cVar2.f34168k - cVar.f34168k);
        List<com.google.android.exoplayer2.source.hls.playlist.c.d> list = cVar.f34175r;
        if (i11 < list.size()) {
            return list.get(i11);
        }
        return null;
    }

    public final void E(List<Uri> list) {
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            Uri uri = list.get(i11);
            this.f34137d.put(uri, new c(uri));
        }
    }

    public final com.google.android.exoplayer2.source.hls.playlist.c G(@Nullable com.google.android.exoplayer2.source.hls.playlist.c cVar, com.google.android.exoplayer2.source.hls.playlist.c cVar2) {
        if (cVar2.e(cVar)) {
            return cVar2.b(I(cVar, cVar2), H(cVar, cVar2));
        }
        return cVar2.f34172o ? cVar.c() : cVar;
    }

    public final int H(@Nullable com.google.android.exoplayer2.source.hls.playlist.c cVar, com.google.android.exoplayer2.source.hls.playlist.c cVar2) {
        com.google.android.exoplayer2.source.hls.playlist.c.d dVarF;
        if (cVar2.f34166i) {
            return cVar2.f34167j;
        }
        com.google.android.exoplayer2.source.hls.playlist.c cVar3 = this.f34146n;
        int i11 = cVar3 != null ? cVar3.f34167j : 0;
        return (cVar == null || (dVarF = F(cVar, cVar2)) == null) ? i11 : (cVar.f34167j + dVarF.f34190d) - cVar2.f34175r.get(0).f34190d;
    }

    public final long I(@Nullable com.google.android.exoplayer2.source.hls.playlist.c cVar, com.google.android.exoplayer2.source.hls.playlist.c cVar2) {
        if (cVar2.f34173p) {
            return cVar2.f34165h;
        }
        com.google.android.exoplayer2.source.hls.playlist.c cVar3 = this.f34146n;
        long j11 = cVar3 != null ? cVar3.f34165h : 0L;
        if (cVar == null) {
            return j11;
        }
        int size = cVar.f34175r.size();
        com.google.android.exoplayer2.source.hls.playlist.c.d dVarF = F(cVar, cVar2);
        if (dVarF != null) {
            return cVar.f34165h + dVarF.f34191f;
        }
        return ((long) size) == cVar2.f34168k - cVar.f34168k ? cVar.d() : j11;
    }

    public final Uri J(Uri uri) {
        com.google.android.exoplayer2.source.hls.playlist.c.C0367c c0367c;
        com.google.android.exoplayer2.source.hls.playlist.c cVar = this.f34146n;
        if (cVar == null || !cVar.f34179v.f34202e || (c0367c = cVar.f34177t.get(uri)) == null) {
            return uri;
        }
        Uri.Builder builderBuildUpon = uri.buildUpon();
        builderBuildUpon.appendQueryParameter("_HLS_msn", String.valueOf(c0367c.f34183b));
        int i11 = c0367c.f34184c;
        if (i11 != -1) {
            builderBuildUpon.appendQueryParameter("_HLS_part", String.valueOf(i11));
        }
        return builderBuildUpon.build();
    }

    public final boolean K(Uri uri) {
        List<d.b> list = this.f34144l.f34205e;
        for (int i11 = 0; i11 < list.size(); i11++) {
            if (uri.equals(list.get(i11).f34218a)) {
                return true;
            }
        }
        return false;
    }

    public final boolean L() {
        List<d.b> list = this.f34144l.f34205e;
        int size = list.size();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        for (int i11 = 0; i11 < size; i11++) {
            c cVar = (c) com.google.android.exoplayer2.util.a.e(this.f34137d.get(list.get(i11).f34218a));
            if (jElapsedRealtime > cVar.f34157i) {
                Uri uri = cVar.f34150a;
                this.f34145m = uri;
                cVar.r(J(uri));
                return true;
            }
        }
        return false;
    }

    public final void M(Uri uri) {
        if (uri.equals(this.f34145m) || !K(uri)) {
            return;
        }
        com.google.android.exoplayer2.source.hls.playlist.c cVar = this.f34146n;
        if (cVar == null || !cVar.f34172o) {
            this.f34145m = uri;
            c cVar2 = this.f34137d.get(uri);
            com.google.android.exoplayer2.source.hls.playlist.c cVar3 = cVar2.f34153d;
            if (cVar3 == null || !cVar3.f34172o) {
                cVar2.r(J(uri));
            } else {
                this.f34146n = cVar3;
                this.f34143k.g(cVar3);
            }
        }
    }

    public final boolean N(Uri uri, z.c cVar, boolean z11) {
        Iterator<HlsPlaylistTracker.b> it = this.f34138f.iterator();
        boolean z12 = false;
        while (it.hasNext()) {
            z12 |= !it.next().b(uri, cVar, z11);
        }
        return z12;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
    public void j(b0<e> b0Var, long j11, long j12, boolean z11) {
        n nVar = new n(b0Var.f35256a, b0Var.f35257b, b0Var.d(), b0Var.b(), j11, j12, b0Var.a());
        this.f34136c.b(b0Var.f35256a);
        this.f34140h.q(nVar, 4);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
    public void l(b0<e> b0Var, long j11, long j12) {
        e eVarC = b0Var.c();
        boolean z11 = eVarC instanceof com.google.android.exoplayer2.source.hls.playlist.c;
        d dVarD = z11 ? d.d(eVarC.f76359a) : (d) eVarC;
        this.f34144l = dVarD;
        this.f34145m = dVarD.f34205e.get(0).f34218a;
        this.f34138f.add(new b());
        E(dVarD.f34204d);
        n nVar = new n(b0Var.f35256a, b0Var.f35257b, b0Var.d(), b0Var.b(), j11, j12, b0Var.a());
        c cVar = this.f34137d.get(this.f34145m);
        if (z11) {
            cVar.w((com.google.android.exoplayer2.source.hls.playlist.c) eVarC, nVar);
        } else {
            cVar.p();
        }
        this.f34136c.b(b0Var.f35256a);
        this.f34140h.t(nVar, 4);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public Loader.c n(b0<e> b0Var, long j11, long j12, IOException iOException, int i11) {
        n nVar = new n(b0Var.f35256a, b0Var.f35257b, b0Var.d(), b0Var.b(), j11, j12, b0Var.a());
        long jC = this.f34136c.c(new z.c(nVar, new o(b0Var.f35258c), iOException, i11));
        boolean z11 = jC == C.TIME_UNSET;
        this.f34140h.x(nVar, b0Var.f35258c, iOException, z11);
        if (z11) {
            this.f34136c.b(b0Var.f35256a);
        }
        return z11 ? Loader.f35232g : Loader.g(false, jC);
    }

    public final void R(Uri uri, com.google.android.exoplayer2.source.hls.playlist.c cVar) {
        if (uri.equals(this.f34145m)) {
            if (this.f34146n == null) {
                this.f34147o = !cVar.f34172o;
                this.f34148p = cVar.f34165h;
            }
            this.f34146n = cVar;
            this.f34143k.g(cVar);
        }
        Iterator<HlsPlaylistTracker.b> it = this.f34138f.iterator();
        while (it.hasNext()) {
            it.next().c();
        }
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void a(Uri uri) throws IOException {
        this.f34137d.get(uri).s();
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public long b() {
        return this.f34148p;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    @Nullable
    public d c() {
        return this.f34144l;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void d(Uri uri) {
        this.f34137d.get(uri).p();
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public boolean e(Uri uri) {
        return this.f34137d.get(uri).m();
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public boolean f() {
        return this.f34147o;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public boolean g(Uri uri, long j11) {
        c cVar = this.f34137d.get(uri);
        if (cVar != null) {
            return !cVar.h(j11);
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void h() throws IOException {
        Loader loader = this.f34141i;
        if (loader != null) {
            loader.maybeThrowError();
        }
        Uri uri = this.f34145m;
        if (uri != null) {
            a(uri);
        }
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    @Nullable
    public com.google.android.exoplayer2.source.hls.playlist.c i(Uri uri, boolean z11) {
        com.google.android.exoplayer2.source.hls.playlist.c cVarK = this.f34137d.get(uri).k();
        if (cVarK != null && z11) {
            M(uri);
        }
        return cVarK;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void k(HlsPlaylistTracker.b bVar) {
        this.f34138f.remove(bVar);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void m(HlsPlaylistTracker.b bVar) {
        com.google.android.exoplayer2.util.a.e(bVar);
        this.f34138f.add(bVar);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void o(Uri uri, j.a aVar, HlsPlaylistTracker.c cVar) {
        this.f34142j = o0.w();
        this.f34140h = aVar;
        this.f34143k = cVar;
        b0 b0Var = new b0(this.f34134a.a(4), uri, 4, this.f34135b.a());
        com.google.android.exoplayer2.util.a.g(this.f34141i == null);
        Loader loader = new Loader("DefaultHlsPlaylistTracker:MultivariantPlaylist");
        this.f34141i = loader;
        aVar.z(new n(b0Var.f35256a, b0Var.f35257b, loader.m(b0Var, this, this.f34136c.a(b0Var.f35258c))), b0Var.f35258c);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void stop() {
        this.f34145m = null;
        this.f34146n = null;
        this.f34144l = null;
        this.f34148p = C.TIME_UNSET;
        this.f34141i.k();
        this.f34141i = null;
        Iterator<c> it = this.f34137d.values().iterator();
        while (it.hasNext()) {
            it.next().x();
        }
        this.f34142j.removeCallbacksAndMessages(null);
        this.f34142j = null;
        this.f34137d.clear();
    }
}
