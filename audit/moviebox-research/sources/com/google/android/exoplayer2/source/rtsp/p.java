package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.b3;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.n1;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.util.o0;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.net.BindException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.net.SocketFactory;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class p implements com.google.android.exoplayer2.source.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.b f34569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f34570b = o0.w();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f34571c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RtspClient f34572d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<e> f34573f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<d> f34574g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c f34575h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.google.android.exoplayer2.source.rtsp.c.a f34576i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.google.android.exoplayer2.source.h.a f34577j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ImmutableList<nh.i0> f34578k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    public IOException f34579l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    public RtspMediaSource.RtspPlaybackException f34580m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f34581n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f34582o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f34583p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f34584q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f34585r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f34586s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f34587t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f34588u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f34589v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f34590w;

    /* JADX INFO: compiled from: source.java */
    public final class b implements tg.n, Loader.b<com.google.android.exoplayer2.source.rtsp.e>, com.google.android.exoplayer2.source.p.d, RtspClient.e, RtspClient.d {
        public b() {
        }

        @Override // com.google.android.exoplayer2.source.rtsp.RtspClient.e
        public void a(String str, @Nullable Throwable th2) {
            p.this.f34579l = th2 == null ? new IOException(str) : new IOException(str, th2);
        }

        @Override // com.google.android.exoplayer2.source.p.d
        public void b(m1 m1Var) {
            Handler handler = p.this.f34570b;
            final p pVar = p.this;
            handler.post(new Runnable() { // from class: com.google.android.exoplayer2.source.rtsp.q
                @Override // java.lang.Runnable
                public final void run() {
                    p.t(pVar);
                }
            });
        }

        @Override // com.google.android.exoplayer2.source.rtsp.RtspClient.d
        public void c(RtspMediaSource.RtspPlaybackException rtspPlaybackException) {
            p.this.f34580m = rtspPlaybackException;
        }

        @Override // com.google.android.exoplayer2.source.rtsp.RtspClient.d
        public void d() {
            p.this.f34572d.x0(0L);
        }

        @Override // com.google.android.exoplayer2.source.rtsp.RtspClient.d
        public void e(long j11, ImmutableList<f0> immutableList) {
            ArrayList arrayList = new ArrayList(immutableList.size());
            for (int i11 = 0; i11 < immutableList.size(); i11++) {
                arrayList.add((String) com.google.android.exoplayer2.util.a.e(immutableList.get(i11).f34492c.getPath()));
            }
            for (int i12 = 0; i12 < p.this.f34574g.size(); i12++) {
                if (!arrayList.contains(((d) p.this.f34574g.get(i12)).c().getPath())) {
                    p.this.f34575h.a();
                    if (p.this.I()) {
                        p.this.f34585r = true;
                        p.this.f34582o = C.TIME_UNSET;
                        p.this.f34581n = C.TIME_UNSET;
                        p.this.f34583p = C.TIME_UNSET;
                    }
                }
            }
            for (int i13 = 0; i13 < immutableList.size(); i13++) {
                f0 f0Var = immutableList.get(i13);
                com.google.android.exoplayer2.source.rtsp.e eVarG = p.this.G(f0Var.f34492c);
                if (eVarG != null) {
                    eVarG.f(f0Var.f34490a);
                    eVarG.e(f0Var.f34491b);
                    if (p.this.I() && p.this.f34582o == p.this.f34581n) {
                        eVarG.d(j11, f0Var.f34490a);
                    }
                }
            }
            if (!p.this.I()) {
                if (p.this.f34583p != C.TIME_UNSET) {
                    p pVar = p.this;
                    pVar.seekToUs(pVar.f34583p);
                    p.this.f34583p = C.TIME_UNSET;
                    return;
                }
                return;
            }
            if (p.this.f34582o == p.this.f34581n) {
                p.this.f34582o = C.TIME_UNSET;
                p.this.f34581n = C.TIME_UNSET;
            } else {
                p.this.f34582o = C.TIME_UNSET;
                p pVar2 = p.this;
                pVar2.seekToUs(pVar2.f34581n);
            }
        }

        @Override // tg.n
        public void endTracks() {
            Handler handler = p.this.f34570b;
            final p pVar = p.this;
            handler.post(new Runnable() { // from class: com.google.android.exoplayer2.source.rtsp.r
                @Override // java.lang.Runnable
                public final void run() {
                    p.t(pVar);
                }
            });
        }

        @Override // com.google.android.exoplayer2.source.rtsp.RtspClient.e
        public void f(d0 d0Var, ImmutableList<t> immutableList) {
            for (int i11 = 0; i11 < immutableList.size(); i11++) {
                t tVar = immutableList.get(i11);
                p pVar = p.this;
                e eVar = pVar.new e(tVar, i11, pVar.f34576i);
                p.this.f34573f.add(eVar);
                eVar.j();
            }
            p.this.f34575h.b(d0Var);
        }

        @Override // tg.n
        public void g(tg.b0 b0Var) {
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public void j(com.google.android.exoplayer2.source.rtsp.e eVar, long j11, long j12, boolean z11) {
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
        public void l(com.google.android.exoplayer2.source.rtsp.e eVar, long j11, long j12) {
            if (p.this.getBufferedPositionUs() == 0) {
                if (p.this.f34590w) {
                    return;
                }
                p.this.N();
                p.this.f34590w = true;
                return;
            }
            for (int i11 = 0; i11 < p.this.f34573f.size(); i11++) {
                e eVar2 = (e) p.this.f34573f.get(i11);
                if (eVar2.f34596a.f34593b == eVar) {
                    eVar2.c();
                    return;
                }
            }
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public Loader.c n(com.google.android.exoplayer2.source.rtsp.e eVar, long j11, long j12, IOException iOException, int i11) {
            if (!p.this.f34587t) {
                p.this.f34579l = iOException;
            } else if (!(iOException.getCause() instanceof BindException)) {
                p.this.f34580m = new RtspMediaSource.RtspPlaybackException(eVar.f34465b.f34608b.toString(), iOException);
            } else if (p.b(p.this) < 3) {
                return Loader.f35229d;
            }
            return Loader.f35231f;
        }

        @Override // tg.n
        public tg.e0 track(int i11, int i12) {
            return ((e) com.google.android.exoplayer2.util.a.e((e) p.this.f34573f.get(i11))).f34598c;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface c {
        void a();

        void b(d0 d0Var);
    }

    /* JADX INFO: compiled from: source.java */
    public final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final t f34592a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.google.android.exoplayer2.source.rtsp.e f34593b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public String f34594c;

        public d(t tVar, int i11, com.google.android.exoplayer2.source.rtsp.c.a aVar) {
            this.f34592a = tVar;
            this.f34593b = new com.google.android.exoplayer2.source.rtsp.e(i11, tVar, new com.google.android.exoplayer2.source.rtsp.e.a() { // from class: com.google.android.exoplayer2.source.rtsp.s
                @Override // com.google.android.exoplayer2.source.rtsp.e.a
                public final void a(String str, c cVar) {
                    this.f34606a.f(str, cVar);
                }
            }, p.this.f34571c, aVar);
        }

        public Uri c() {
            return this.f34593b.f34465b.f34608b;
        }

        public String d() {
            com.google.android.exoplayer2.util.a.i(this.f34594c);
            return this.f34594c;
        }

        public boolean e() {
            return this.f34594c != null;
        }

        public final /* synthetic */ void f(String str, com.google.android.exoplayer2.source.rtsp.c cVar) {
            this.f34594c = str;
            u.b bVarG = cVar.g();
            if (bVarG != null) {
                p.this.f34572d.q0(cVar.d(), bVarG);
                p.this.f34590w = true;
            }
            p.this.K();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f34596a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Loader f34597b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.google.android.exoplayer2.source.p f34598c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f34599d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f34600e;

        public e(t tVar, int i11, com.google.android.exoplayer2.source.rtsp.c.a aVar) {
            this.f34596a = p.this.new d(tVar, i11, aVar);
            this.f34597b = new Loader("ExoPlayer:RtspMediaPeriod:RtspLoaderWrapper " + i11);
            com.google.android.exoplayer2.source.p pVarL = com.google.android.exoplayer2.source.p.l(p.this.f34569a);
            this.f34598c = pVarL;
            pVarL.d0(p.this.f34571c);
        }

        public void c() {
            if (this.f34599d) {
                return;
            }
            this.f34596a.f34593b.cancelLoad();
            this.f34599d = true;
            p.this.R();
        }

        public long d() {
            return this.f34598c.z();
        }

        public boolean e() {
            return this.f34598c.K(this.f34599d);
        }

        public int f(n1 n1Var, DecoderInputBuffer decoderInputBuffer, int i11) {
            return this.f34598c.S(n1Var, decoderInputBuffer, i11, this.f34599d);
        }

        public void g() {
            if (this.f34600e) {
                return;
            }
            this.f34597b.k();
            this.f34598c.T();
            this.f34600e = true;
        }

        public void h(long j11) {
            if (this.f34599d) {
                return;
            }
            this.f34596a.f34593b.c();
            this.f34598c.V();
            this.f34598c.b0(j11);
        }

        public int i(long j11) {
            int iE = this.f34598c.E(j11, this.f34599d);
            this.f34598c.e0(iE);
            return iE;
        }

        public void j() {
            this.f34597b.m(this.f34596a.f34593b, p.this.f34571c, 0);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class f implements nh.d0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f34602a;

        public f(int i11) {
            this.f34602a = i11;
        }

        @Override // nh.d0
        public int b(n1 n1Var, DecoderInputBuffer decoderInputBuffer, int i11) {
            return p.this.L(this.f34602a, n1Var, decoderInputBuffer, i11);
        }

        @Override // nh.d0
        public boolean isReady() {
            return p.this.H(this.f34602a);
        }

        @Override // nh.d0
        public void maybeThrowError() throws RtspMediaSource.RtspPlaybackException {
            if (p.this.f34580m != null) {
                throw p.this.f34580m;
            }
        }

        @Override // nh.d0
        public int skipData(long j11) {
            return p.this.P(this.f34602a, j11);
        }
    }

    public p(com.google.android.exoplayer2.upstream.b bVar, com.google.android.exoplayer2.source.rtsp.c.a aVar, Uri uri, c cVar, String str, SocketFactory socketFactory, boolean z11) {
        this.f34569a = bVar;
        this.f34576i = aVar;
        this.f34575h = cVar;
        b bVar2 = new b();
        this.f34571c = bVar2;
        this.f34572d = new RtspClient(bVar2, bVar2, str, uri, socketFactory, z11);
        this.f34573f = new ArrayList();
        this.f34574g = new ArrayList();
        this.f34582o = C.TIME_UNSET;
        this.f34581n = C.TIME_UNSET;
        this.f34583p = C.TIME_UNSET;
    }

    public static ImmutableList<nh.i0> F(ImmutableList<e> immutableList) {
        ImmutableList.a aVar = new ImmutableList.a();
        for (int i11 = 0; i11 < immutableList.size(); i11++) {
            aVar.a(new nh.i0(Integer.toString(i11), (m1) com.google.android.exoplayer2.util.a.e(immutableList.get(i11).f34598c.F())));
        }
        return aVar.m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        if (this.f34586s || this.f34587t) {
            return;
        }
        for (int i11 = 0; i11 < this.f34573f.size(); i11++) {
            if (this.f34573f.get(i11).f34598c.F() == null) {
                return;
            }
        }
        this.f34587t = true;
        this.f34578k = F(ImmutableList.copyOf((Collection) this.f34573f));
        ((com.google.android.exoplayer2.source.h.a) com.google.android.exoplayer2.util.a.e(this.f34577j)).h(this);
    }

    private boolean O(long j11) {
        for (int i11 = 0; i11 < this.f34573f.size(); i11++) {
            if (!this.f34573f.get(i11).f34598c.Z(j11, false)) {
                return false;
            }
        }
        return true;
    }

    private boolean Q() {
        return this.f34585r;
    }

    public static /* synthetic */ int b(p pVar) {
        int i11 = pVar.f34589v;
        pVar.f34589v = i11 + 1;
        return i11;
    }

    public static /* synthetic */ void t(p pVar) {
        pVar.J();
    }

    @Nullable
    public final com.google.android.exoplayer2.source.rtsp.e G(Uri uri) {
        for (int i11 = 0; i11 < this.f34573f.size(); i11++) {
            if (!this.f34573f.get(i11).f34599d) {
                d dVar = this.f34573f.get(i11).f34596a;
                if (dVar.c().equals(uri)) {
                    return dVar.f34593b;
                }
            }
        }
        return null;
    }

    public boolean H(int i11) {
        return !Q() && this.f34573f.get(i11).e();
    }

    public final boolean I() {
        return this.f34582o != C.TIME_UNSET;
    }

    public final void K() {
        boolean zE = true;
        for (int i11 = 0; i11 < this.f34574g.size(); i11++) {
            zE &= this.f34574g.get(i11).e();
        }
        if (zE && this.f34588u) {
            this.f34572d.v0(this.f34574g);
        }
    }

    public int L(int i11, n1 n1Var, DecoderInputBuffer decoderInputBuffer, int i12) {
        if (Q()) {
            return -3;
        }
        return this.f34573f.get(i11).f(n1Var, decoderInputBuffer, i12);
    }

    public void M() {
        for (int i11 = 0; i11 < this.f34573f.size(); i11++) {
            this.f34573f.get(i11).g();
        }
        o0.n(this.f34572d);
        this.f34586s = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void N() {
        this.f34572d.s0();
        com.google.android.exoplayer2.source.rtsp.c.a aVarB = this.f34576i.b();
        if (aVarB == null) {
            this.f34580m = new RtspMediaSource.RtspPlaybackException("No fallback data channel factory for TCP retry");
            return;
        }
        ArrayList arrayList = new ArrayList(this.f34573f.size());
        ArrayList arrayList2 = new ArrayList(this.f34574g.size());
        for (int i11 = 0; i11 < this.f34573f.size(); i11++) {
            e eVar = this.f34573f.get(i11);
            if (eVar.f34599d) {
                arrayList.add(eVar);
            } else {
                e eVar2 = new e(eVar.f34596a.f34592a, i11, aVarB);
                arrayList.add(eVar2);
                eVar2.j();
                if (this.f34574g.contains(eVar.f34596a)) {
                    arrayList2.add(eVar2.f34596a);
                }
            }
        }
        ImmutableList immutableListCopyOf = ImmutableList.copyOf((Collection) this.f34573f);
        this.f34573f.clear();
        this.f34573f.addAll(arrayList);
        this.f34574g.clear();
        this.f34574g.addAll(arrayList2);
        for (int i12 = 0; i12 < immutableListCopyOf.size(); i12++) {
            ((e) immutableListCopyOf.get(i12)).c();
        }
    }

    public int P(int i11, long j11) {
        if (Q()) {
            return -3;
        }
        return this.f34573f.get(i11).i(j11);
    }

    public final void R() {
        this.f34584q = true;
        for (int i11 = 0; i11 < this.f34573f.size(); i11++) {
            this.f34584q &= this.f34573f.get(i11).f34599d;
        }
    }

    @Override // com.google.android.exoplayer2.source.h
    public long a(long j11, b3 b3Var) {
        return j11;
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public boolean continueLoading(long j11) {
        return isLoading();
    }

    @Override // com.google.android.exoplayer2.source.h
    public void discardBuffer(long j11, boolean z11) {
        if (I()) {
            return;
        }
        for (int i11 = 0; i11 < this.f34573f.size(); i11++) {
            e eVar = this.f34573f.get(i11);
            if (!eVar.f34599d) {
                eVar.f34598c.q(j11, z11, true);
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.h
    public long e(fi.s[] sVarArr, boolean[] zArr, nh.d0[] d0VarArr, boolean[] zArr2, long j11) {
        for (int i11 = 0; i11 < sVarArr.length; i11++) {
            if (d0VarArr[i11] != null && (sVarArr[i11] == null || !zArr[i11])) {
                d0VarArr[i11] = null;
            }
        }
        this.f34574g.clear();
        for (int i12 = 0; i12 < sVarArr.length; i12++) {
            fi.s sVar = sVarArr[i12];
            if (sVar != null) {
                nh.i0 trackGroup = sVar.getTrackGroup();
                int iIndexOf = ((ImmutableList) com.google.android.exoplayer2.util.a.e(this.f34578k)).indexOf(trackGroup);
                this.f34574g.add(((e) com.google.android.exoplayer2.util.a.e(this.f34573f.get(iIndexOf))).f34596a);
                if (this.f34578k.contains(trackGroup) && d0VarArr[i12] == null) {
                    d0VarArr[i12] = new f(iIndexOf);
                    zArr2[i12] = true;
                }
            }
        }
        for (int i13 = 0; i13 < this.f34573f.size(); i13++) {
            e eVar = this.f34573f.get(i13);
            if (!this.f34574g.contains(eVar.f34596a)) {
                eVar.c();
            }
        }
        this.f34588u = true;
        K();
        return j11;
    }

    @Override // com.google.android.exoplayer2.source.h
    public void f(com.google.android.exoplayer2.source.h.a aVar, long j11) {
        this.f34577j = aVar;
        try {
            this.f34572d.w0();
        } catch (IOException e11) {
            this.f34579l = e11;
            o0.n(this.f34572d);
        }
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public long getBufferedPositionUs() {
        if (this.f34584q || this.f34573f.isEmpty()) {
            return Long.MIN_VALUE;
        }
        long j11 = this.f34581n;
        if (j11 != C.TIME_UNSET) {
            return j11;
        }
        boolean z11 = true;
        long jMin = Long.MAX_VALUE;
        for (int i11 = 0; i11 < this.f34573f.size(); i11++) {
            e eVar = this.f34573f.get(i11);
            if (!eVar.f34599d) {
                jMin = Math.min(jMin, eVar.d());
                z11 = false;
            }
        }
        if (z11 || jMin == Long.MIN_VALUE) {
            return 0L;
        }
        return jMin;
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public long getNextLoadPositionUs() {
        return getBufferedPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.h
    public nh.k0 getTrackGroups() {
        com.google.android.exoplayer2.util.a.g(this.f34587t);
        return new nh.k0((nh.i0[]) ((ImmutableList) com.google.android.exoplayer2.util.a.e(this.f34578k)).toArray(new nh.i0[0]));
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public boolean isLoading() {
        return !this.f34584q;
    }

    @Override // com.google.android.exoplayer2.source.h
    public void maybeThrowPrepareError() throws IOException {
        IOException iOException = this.f34579l;
        if (iOException != null) {
            throw iOException;
        }
    }

    @Override // com.google.android.exoplayer2.source.h
    public long readDiscontinuity() {
        if (!this.f34585r) {
            return C.TIME_UNSET;
        }
        this.f34585r = false;
        return 0L;
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public void reevaluateBuffer(long j11) {
    }

    @Override // com.google.android.exoplayer2.source.h
    public long seekToUs(long j11) {
        if (getBufferedPositionUs() == 0 && !this.f34590w) {
            this.f34583p = j11;
            return j11;
        }
        discardBuffer(j11, false);
        this.f34581n = j11;
        if (I()) {
            int iL0 = this.f34572d.l0();
            if (iL0 == 1) {
                return j11;
            }
            if (iL0 != 2) {
                throw new IllegalStateException();
            }
            this.f34582o = j11;
            this.f34572d.t0(j11);
            return j11;
        }
        if (O(j11)) {
            return j11;
        }
        this.f34582o = j11;
        this.f34572d.t0(j11);
        for (int i11 = 0; i11 < this.f34573f.size(); i11++) {
            this.f34573f.get(i11).h(j11);
        }
        return j11;
    }
}
