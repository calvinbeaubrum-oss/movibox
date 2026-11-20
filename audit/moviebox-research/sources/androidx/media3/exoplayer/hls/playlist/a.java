package androidx.media3.exoplayer.hls.playlist;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import androidx.media3.common.ParserException;
import androidx.media3.datasource.HttpDataSource;
import androidx.media3.exoplayer.hls.f;
import androidx.media3.exoplayer.hls.playlist.HlsPlaylistTracker;
import androidx.media3.exoplayer.upstream.Loader;
import androidx.media3.exoplayer.upstream.m;
import androidx.media3.exoplayer.upstream.o;
import com.google.android.gms.common.api.Api;
import com.google.common.collect.e0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import k4.e;
import p4.n;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements HlsPlaylistTracker, Loader.b<o<e>> {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final HlsPlaylistTracker.a f10496q = new HlsPlaylistTracker.a() { // from class: k4.b
        @Override // androidx.media3.exoplayer.hls.playlist.HlsPlaylistTracker.a
        public final HlsPlaylistTracker a(androidx.media3.exoplayer.hls.f fVar, m mVar, f fVar2) {
            return new androidx.media3.exoplayer.hls.playlist.a(fVar, mVar, fVar2);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f10497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k4.f f10498b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m f10499c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap<Uri, c> f10500d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CopyOnWriteArrayList<HlsPlaylistTracker.b> f10501f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final double f10502g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public androidx.media3.exoplayer.source.m.a f10503h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public Loader f10504i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public Handler f10505j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public HlsPlaylistTracker.c f10506k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    public androidx.media3.exoplayer.hls.playlist.c f10507l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    public Uri f10508m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    public androidx.media3.exoplayer.hls.playlist.b f10509n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f10510o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f10511p;

    /* JADX INFO: compiled from: source.java */
    public class b implements HlsPlaylistTracker.b {
        public b() {
        }

        @Override // androidx.media3.exoplayer.hls.playlist.HlsPlaylistTracker.b
        public void c() {
            a.this.f10501f.remove(this);
        }

        @Override // androidx.media3.exoplayer.hls.playlist.HlsPlaylistTracker.b
        public boolean d(Uri uri, m.c cVar, boolean z11) {
            c cVar2;
            if (a.this.f10509n == null) {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                List<androidx.media3.exoplayer.hls.playlist.c.b> list = ((androidx.media3.exoplayer.hls.playlist.c) u0.i(a.this.f10507l)).f10568e;
                int i11 = 0;
                for (int i12 = 0; i12 < list.size(); i12++) {
                    c cVar3 = (c) a.this.f10500d.get(list.get(i12).f10581a);
                    if (cVar3 != null && jElapsedRealtime < cVar3.f10520i) {
                        i11++;
                    }
                }
                m.b bVarD = a.this.f10499c.d(new m.a(1, 0, a.this.f10507l.f10568e.size(), i11), cVar);
                if (bVarD != null && bVarD.f11494a == 2 && (cVar2 = (c) a.this.f10500d.get(uri)) != null) {
                    cVar2.h(bVarD.f11495b);
                }
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class c implements Loader.b<o<e>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f10513a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Loader f10514b = new Loader("DefaultHlsPlaylistTracker:MediaPlaylist");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final androidx.media3.datasource.a f10515c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public androidx.media3.exoplayer.hls.playlist.b f10516d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f10517f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f10518g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f10519h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public long f10520i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f10521j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @Nullable
        public IOException f10522k;

        public c(Uri uri) {
            this.f10513a = uri;
            this.f10515c = a.this.f10497a.a(4);
        }

        public final boolean h(long j11) {
            this.f10520i = SystemClock.elapsedRealtime() + j11;
            return this.f10513a.equals(a.this.f10508m) && !a.this.L();
        }

        public final Uri i() {
            androidx.media3.exoplayer.hls.playlist.b bVar = this.f10516d;
            if (bVar != null) {
                androidx.media3.exoplayer.hls.playlist.b.f fVar = bVar.f10542v;
                if (fVar.f10561a != C.TIME_UNSET || fVar.f10565e) {
                    Uri.Builder builderBuildUpon = this.f10513a.buildUpon();
                    androidx.media3.exoplayer.hls.playlist.b bVar2 = this.f10516d;
                    if (bVar2.f10542v.f10565e) {
                        builderBuildUpon.appendQueryParameter("_HLS_msn", String.valueOf(bVar2.f10531k + ((long) bVar2.f10538r.size())));
                        androidx.media3.exoplayer.hls.playlist.b bVar3 = this.f10516d;
                        if (bVar3.f10534n != C.TIME_UNSET) {
                            List<androidx.media3.exoplayer.hls.playlist.b.C0100b> list = bVar3.f10539s;
                            int size = list.size();
                            if (!list.isEmpty() && ((androidx.media3.exoplayer.hls.playlist.b.C0100b) e0.g(list)).f10544n) {
                                size--;
                            }
                            builderBuildUpon.appendQueryParameter("_HLS_part", String.valueOf(size));
                        }
                    }
                    androidx.media3.exoplayer.hls.playlist.b.f fVar2 = this.f10516d.f10542v;
                    if (fVar2.f10561a != C.TIME_UNSET) {
                        builderBuildUpon.appendQueryParameter("_HLS_skip", fVar2.f10562b ? "v2" : "YES");
                    }
                    return builderBuildUpon.build();
                }
            }
            return this.f10513a;
        }

        @Nullable
        public androidx.media3.exoplayer.hls.playlist.b j() {
            return this.f10516d;
        }

        public boolean l() {
            int i11;
            if (this.f10516d == null) {
                return false;
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long jMax = Math.max(30000L, u0.B1(this.f10516d.f10541u));
            androidx.media3.exoplayer.hls.playlist.b bVar = this.f10516d;
            return bVar.f10535o || (i11 = bVar.f10524d) == 2 || i11 == 1 || this.f10517f + jMax > jElapsedRealtime;
        }

        public final /* synthetic */ void m(Uri uri) {
            this.f10521j = false;
            q(uri);
        }

        public void p() {
            r(this.f10513a);
        }

        public final void q(Uri uri) {
            o oVar = new o(this.f10515c, uri, 4, a.this.f10498b.b(a.this.f10507l, this.f10516d));
            a.this.f10503h.y(new n(oVar.f11500a, oVar.f11501b, this.f10514b.m(oVar, this, a.this.f10499c.a(oVar.f11502c))), oVar.f11502c);
        }

        public final void r(final Uri uri) {
            this.f10520i = 0L;
            if (this.f10521j || this.f10514b.i() || this.f10514b.h()) {
                return;
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (jElapsedRealtime >= this.f10519h) {
                q(uri);
            } else {
                this.f10521j = true;
                a.this.f10505j.postDelayed(new Runnable() { // from class: k4.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f68235a.m(uri);
                    }
                }, this.f10519h - jElapsedRealtime);
            }
        }

        public void s() throws IOException {
            this.f10514b.maybeThrowError();
            IOException iOException = this.f10522k;
            if (iOException != null) {
                throw iOException;
            }
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.b
        /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
        public void o(o<e> oVar, long j11, long j12, boolean z11) {
            n nVar = new n(oVar.f11500a, oVar.f11501b, oVar.d(), oVar.b(), j11, j12, oVar.a());
            a.this.f10499c.b(oVar.f11500a);
            a.this.f10503h.p(nVar, 4);
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.b
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public void n(o<e> oVar, long j11, long j12) {
            e eVarC = oVar.c();
            n nVar = new n(oVar.f11500a, oVar.f11501b, oVar.d(), oVar.b(), j11, j12, oVar.a());
            if (eVarC instanceof androidx.media3.exoplayer.hls.playlist.b) {
                w((androidx.media3.exoplayer.hls.playlist.b) eVarC, nVar);
                a.this.f10503h.s(nVar, 4);
            } else {
                this.f10522k = ParserException.createForMalformedManifest("Loaded playlist has unexpected type.", null);
                a.this.f10503h.w(nVar, 4, this.f10522k, true);
            }
            a.this.f10499c.b(oVar.f11500a);
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.b
        /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
        public Loader.c k(o<e> oVar, long j11, long j12, IOException iOException, int i11) {
            Loader.c cVarG;
            n nVar = new n(oVar.f11500a, oVar.f11501b, oVar.d(), oVar.b(), j11, j12, oVar.a());
            boolean z11 = iOException instanceof HlsPlaylistParser.DeltaUpdateException;
            if ((oVar.d().getQueryParameter("_HLS_msn") != null) || z11) {
                int i12 = iOException instanceof HttpDataSource.InvalidResponseCodeException ? ((HttpDataSource.InvalidResponseCodeException) iOException).responseCode : Api.BaseClientBuilder.API_PRIORITY_OTHER;
                if (z11 || i12 == 400 || i12 == 503) {
                    this.f10519h = SystemClock.elapsedRealtime();
                    p();
                    ((androidx.media3.exoplayer.source.m.a) u0.i(a.this.f10503h)).w(nVar, oVar.f11502c, iOException, true);
                    return Loader.f11436f;
                }
            }
            m.c cVar = new m.c(nVar, new p4.o(oVar.f11502c), iOException, i11);
            if (a.this.N(this.f10513a, cVar, false)) {
                long jC = a.this.f10499c.c(cVar);
                cVarG = jC != C.TIME_UNSET ? Loader.g(false, jC) : Loader.f11437g;
            } else {
                cVarG = Loader.f11436f;
            }
            boolean z12 = !cVarG.c();
            a.this.f10503h.w(nVar, oVar.f11502c, iOException, z12);
            if (z12) {
                a.this.f10499c.b(oVar.f11500a);
            }
            return cVarG;
        }

        public final void w(androidx.media3.exoplayer.hls.playlist.b bVar, n nVar) {
            boolean z11;
            long j11;
            androidx.media3.exoplayer.hls.playlist.b bVar2 = this.f10516d;
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.f10517f = jElapsedRealtime;
            androidx.media3.exoplayer.hls.playlist.b bVarG = a.this.G(bVar2, bVar);
            this.f10516d = bVarG;
            IOException playlistStuckException = null;
            if (bVarG != bVar2) {
                this.f10522k = null;
                this.f10518g = jElapsedRealtime;
                a.this.R(this.f10513a, bVarG);
            } else if (!bVarG.f10535o) {
                long size = bVar.f10531k + ((long) bVar.f10538r.size());
                androidx.media3.exoplayer.hls.playlist.b bVar3 = this.f10516d;
                if (size < bVar3.f10531k) {
                    playlistStuckException = new HlsPlaylistTracker.PlaylistResetException(this.f10513a);
                    z11 = true;
                } else {
                    double d11 = jElapsedRealtime - this.f10518g;
                    double dB1 = u0.B1(bVar3.f10533m) * a.this.f10502g;
                    z11 = false;
                    if (d11 > dB1) {
                        playlistStuckException = new HlsPlaylistTracker.PlaylistStuckException(this.f10513a);
                    }
                }
                if (playlistStuckException != null) {
                    this.f10522k = playlistStuckException;
                    a.this.N(this.f10513a, new m.c(nVar, new p4.o(4), playlistStuckException, 1), z11);
                }
            }
            androidx.media3.exoplayer.hls.playlist.b bVar4 = this.f10516d;
            if (bVar4.f10542v.f10565e) {
                j11 = 0;
            } else {
                j11 = bVar4 != bVar2 ? bVar4.f10533m : bVar4.f10533m / 2;
            }
            this.f10519h = (jElapsedRealtime + u0.B1(j11)) - nVar.f73584f;
            if ((this.f10516d.f10534n != C.TIME_UNSET || this.f10513a.equals(a.this.f10508m)) && !this.f10516d.f10535o) {
                r(i());
            }
        }

        public void x() {
            this.f10514b.k();
        }
    }

    public a(f fVar, m mVar, k4.f fVar2) {
        this(fVar, mVar, fVar2, 3.5d);
    }

    public a(f fVar, m mVar, k4.f fVar2, double d11) {
        this.f10497a = fVar;
        this.f10498b = fVar2;
        this.f10499c = mVar;
        this.f10502g = d11;
        this.f10501f = new CopyOnWriteArrayList<>();
        this.f10500d = new HashMap<>();
        this.f10511p = C.TIME_UNSET;
    }

    public static androidx.media3.exoplayer.hls.playlist.b.d F(androidx.media3.exoplayer.hls.playlist.b bVar, androidx.media3.exoplayer.hls.playlist.b bVar2) {
        int i11 = (int) (bVar2.f10531k - bVar.f10531k);
        List<androidx.media3.exoplayer.hls.playlist.b.d> list = bVar.f10538r;
        if (i11 < list.size()) {
            return list.get(i11);
        }
        return null;
    }

    public final void E(List<Uri> list) {
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            Uri uri = list.get(i11);
            this.f10500d.put(uri, new c(uri));
        }
    }

    public final androidx.media3.exoplayer.hls.playlist.b G(@Nullable androidx.media3.exoplayer.hls.playlist.b bVar, androidx.media3.exoplayer.hls.playlist.b bVar2) {
        if (bVar2.e(bVar)) {
            return bVar2.b(I(bVar, bVar2), H(bVar, bVar2));
        }
        return bVar2.f10535o ? bVar.c() : bVar;
    }

    public final int H(@Nullable androidx.media3.exoplayer.hls.playlist.b bVar, androidx.media3.exoplayer.hls.playlist.b bVar2) {
        androidx.media3.exoplayer.hls.playlist.b.d dVarF;
        if (bVar2.f10529i) {
            return bVar2.f10530j;
        }
        androidx.media3.exoplayer.hls.playlist.b bVar3 = this.f10509n;
        int i11 = bVar3 != null ? bVar3.f10530j : 0;
        return (bVar == null || (dVarF = F(bVar, bVar2)) == null) ? i11 : (bVar.f10530j + dVarF.f10553d) - bVar2.f10538r.get(0).f10553d;
    }

    public final long I(@Nullable androidx.media3.exoplayer.hls.playlist.b bVar, androidx.media3.exoplayer.hls.playlist.b bVar2) {
        if (bVar2.f10536p) {
            return bVar2.f10528h;
        }
        androidx.media3.exoplayer.hls.playlist.b bVar3 = this.f10509n;
        long j11 = bVar3 != null ? bVar3.f10528h : 0L;
        if (bVar == null) {
            return j11;
        }
        int size = bVar.f10538r.size();
        androidx.media3.exoplayer.hls.playlist.b.d dVarF = F(bVar, bVar2);
        if (dVarF != null) {
            return bVar.f10528h + dVarF.f10554f;
        }
        return ((long) size) == bVar2.f10531k - bVar.f10531k ? bVar.d() : j11;
    }

    public final Uri J(Uri uri) {
        androidx.media3.exoplayer.hls.playlist.b.c cVar;
        androidx.media3.exoplayer.hls.playlist.b bVar = this.f10509n;
        if (bVar == null || !bVar.f10542v.f10565e || (cVar = bVar.f10540t.get(uri)) == null) {
            return uri;
        }
        Uri.Builder builderBuildUpon = uri.buildUpon();
        builderBuildUpon.appendQueryParameter("_HLS_msn", String.valueOf(cVar.f10546b));
        int i11 = cVar.f10547c;
        if (i11 != -1) {
            builderBuildUpon.appendQueryParameter("_HLS_part", String.valueOf(i11));
        }
        return builderBuildUpon.build();
    }

    public final boolean K(Uri uri) {
        List<androidx.media3.exoplayer.hls.playlist.c.b> list = this.f10507l.f10568e;
        for (int i11 = 0; i11 < list.size(); i11++) {
            if (uri.equals(list.get(i11).f10581a)) {
                return true;
            }
        }
        return false;
    }

    public final boolean L() {
        List<androidx.media3.exoplayer.hls.playlist.c.b> list = this.f10507l.f10568e;
        int size = list.size();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        for (int i11 = 0; i11 < size; i11++) {
            c cVar = (c) z3.a.e(this.f10500d.get(list.get(i11).f10581a));
            if (jElapsedRealtime > cVar.f10520i) {
                Uri uri = cVar.f10513a;
                this.f10508m = uri;
                cVar.r(J(uri));
                return true;
            }
        }
        return false;
    }

    public final void M(Uri uri) {
        if (uri.equals(this.f10508m) || !K(uri)) {
            return;
        }
        androidx.media3.exoplayer.hls.playlist.b bVar = this.f10509n;
        if (bVar == null || !bVar.f10535o) {
            this.f10508m = uri;
            c cVar = this.f10500d.get(uri);
            androidx.media3.exoplayer.hls.playlist.b bVar2 = cVar.f10516d;
            if (bVar2 == null || !bVar2.f10535o) {
                cVar.r(J(uri));
            } else {
                this.f10509n = bVar2;
                this.f10506k.g(bVar2);
            }
        }
    }

    public final boolean N(Uri uri, m.c cVar, boolean z11) {
        Iterator<HlsPlaylistTracker.b> it = this.f10501f.iterator();
        boolean z12 = false;
        while (it.hasNext()) {
            z12 |= !it.next().d(uri, cVar, z11);
        }
        return z12;
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.b
    /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
    public void o(o<e> oVar, long j11, long j12, boolean z11) {
        n nVar = new n(oVar.f11500a, oVar.f11501b, oVar.d(), oVar.b(), j11, j12, oVar.a());
        this.f10499c.b(oVar.f11500a);
        this.f10503h.p(nVar, 4);
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.b
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
    public void n(o<e> oVar, long j11, long j12) {
        e eVarC = oVar.c();
        boolean z11 = eVarC instanceof androidx.media3.exoplayer.hls.playlist.b;
        androidx.media3.exoplayer.hls.playlist.c cVarD = z11 ? androidx.media3.exoplayer.hls.playlist.c.d(eVarC.f68239a) : (androidx.media3.exoplayer.hls.playlist.c) eVarC;
        this.f10507l = cVarD;
        this.f10508m = cVarD.f10568e.get(0).f10581a;
        this.f10501f.add(new b());
        E(cVarD.f10567d);
        n nVar = new n(oVar.f11500a, oVar.f11501b, oVar.d(), oVar.b(), j11, j12, oVar.a());
        c cVar = this.f10500d.get(this.f10508m);
        if (z11) {
            cVar.w((androidx.media3.exoplayer.hls.playlist.b) eVarC, nVar);
        } else {
            cVar.p();
        }
        this.f10499c.b(oVar.f11500a);
        this.f10503h.s(nVar, 4);
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.b
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public Loader.c k(o<e> oVar, long j11, long j12, IOException iOException, int i11) {
        n nVar = new n(oVar.f11500a, oVar.f11501b, oVar.d(), oVar.b(), j11, j12, oVar.a());
        long jC = this.f10499c.c(new m.c(nVar, new p4.o(oVar.f11502c), iOException, i11));
        boolean z11 = jC == C.TIME_UNSET;
        this.f10503h.w(nVar, oVar.f11502c, iOException, z11);
        if (z11) {
            this.f10499c.b(oVar.f11500a);
        }
        return z11 ? Loader.f11437g : Loader.g(false, jC);
    }

    public final void R(Uri uri, androidx.media3.exoplayer.hls.playlist.b bVar) {
        if (uri.equals(this.f10508m)) {
            if (this.f10509n == null) {
                this.f10510o = !bVar.f10535o;
                this.f10511p = bVar.f10528h;
            }
            this.f10509n = bVar;
            this.f10506k.g(bVar);
        }
        Iterator<HlsPlaylistTracker.b> it = this.f10501f.iterator();
        while (it.hasNext()) {
            it.next().c();
        }
    }

    @Override // androidx.media3.exoplayer.hls.playlist.HlsPlaylistTracker
    public void a(Uri uri) throws IOException {
        this.f10500d.get(uri).s();
    }

    @Override // androidx.media3.exoplayer.hls.playlist.HlsPlaylistTracker
    public long b() {
        return this.f10511p;
    }

    @Override // androidx.media3.exoplayer.hls.playlist.HlsPlaylistTracker
    @Nullable
    public androidx.media3.exoplayer.hls.playlist.c c() {
        return this.f10507l;
    }

    @Override // androidx.media3.exoplayer.hls.playlist.HlsPlaylistTracker
    public void d(Uri uri) {
        this.f10500d.get(uri).p();
    }

    @Override // androidx.media3.exoplayer.hls.playlist.HlsPlaylistTracker
    public boolean e(Uri uri) {
        return this.f10500d.get(uri).l();
    }

    @Override // androidx.media3.exoplayer.hls.playlist.HlsPlaylistTracker
    public boolean f() {
        return this.f10510o;
    }

    @Override // androidx.media3.exoplayer.hls.playlist.HlsPlaylistTracker
    public boolean g(Uri uri, long j11) {
        c cVar = this.f10500d.get(uri);
        if (cVar != null) {
            return !cVar.h(j11);
        }
        return false;
    }

    @Override // androidx.media3.exoplayer.hls.playlist.HlsPlaylistTracker
    public void h() throws IOException {
        Loader loader = this.f10504i;
        if (loader != null) {
            loader.maybeThrowError();
        }
        Uri uri = this.f10508m;
        if (uri != null) {
            a(uri);
        }
    }

    @Override // androidx.media3.exoplayer.hls.playlist.HlsPlaylistTracker
    @Nullable
    public androidx.media3.exoplayer.hls.playlist.b i(Uri uri, boolean z11) {
        androidx.media3.exoplayer.hls.playlist.b bVarJ = this.f10500d.get(uri).j();
        if (bVarJ != null && z11) {
            M(uri);
        }
        return bVarJ;
    }

    @Override // androidx.media3.exoplayer.hls.playlist.HlsPlaylistTracker
    public void j(Uri uri, androidx.media3.exoplayer.source.m.a aVar, HlsPlaylistTracker.c cVar) {
        this.f10505j = u0.A();
        this.f10503h = aVar;
        this.f10506k = cVar;
        o oVar = new o(this.f10497a.a(4), uri, 4, this.f10498b.a());
        z3.a.g(this.f10504i == null);
        Loader loader = new Loader("DefaultHlsPlaylistTracker:MultivariantPlaylist");
        this.f10504i = loader;
        aVar.y(new n(oVar.f11500a, oVar.f11501b, loader.m(oVar, this, this.f10499c.a(oVar.f11502c))), oVar.f11502c);
    }

    @Override // androidx.media3.exoplayer.hls.playlist.HlsPlaylistTracker
    public void l(HlsPlaylistTracker.b bVar) {
        this.f10501f.remove(bVar);
    }

    @Override // androidx.media3.exoplayer.hls.playlist.HlsPlaylistTracker
    public void m(HlsPlaylistTracker.b bVar) {
        z3.a.e(bVar);
        this.f10501f.add(bVar);
    }

    @Override // androidx.media3.exoplayer.hls.playlist.HlsPlaylistTracker
    public void stop() {
        this.f10508m = null;
        this.f10509n = null;
        this.f10507l = null;
        this.f10511p = C.TIME_UNSET;
        this.f10504i.k();
        this.f10504i = null;
        Iterator<c> it = this.f10500d.values().iterator();
        while (it.hasNext()) {
            it.next().x();
        }
        this.f10505j.removeCallbacksAndMessages(null);
        this.f10505j = null;
        this.f10500d.clear();
    }
}
