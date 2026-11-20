package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import android.os.Handler;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.o0;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMap;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.net.SocketFactory;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class RtspClient implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f34384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f34385b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f34386c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SocketFactory f34387d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f34388f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Uri f34392j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    public y.a f34394l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    public String f34395m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    public KeepAliveMonitor f34396n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    public l f34397o;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f34399q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f34400r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f34401s;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayDeque<p.d> f34389g = new ArrayDeque<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final SparseArray<b0> f34390h = new SparseArray<>();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c f34391i = new c();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public u f34393k = new u(new b());

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f34402t = C.TIME_UNSET;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f34398p = -1;

    /* JADX INFO: compiled from: source.java */
    public final class KeepAliveMonitor implements Runnable, Closeable {
        private final long intervalMs;
        private boolean isStarted;
        private final Handler keepAliveHandler = o0.w();

        public KeepAliveMonitor(long j11) {
            this.intervalMs = j11;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.isStarted = false;
            this.keepAliveHandler.removeCallbacks(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            RtspClient.this.f34391i.e(RtspClient.this.f34392j, RtspClient.this.f34395m);
            this.keepAliveHandler.postDelayed(this, this.intervalMs);
        }

        public void start() {
            if (this.isStarted) {
                return;
            }
            this.isStarted = true;
            this.keepAliveHandler.postDelayed(this, this.intervalMs);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class b implements u.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f34403a = o0.w();

        public b() {
        }

        @Override // com.google.android.exoplayer2.source.rtsp.u.d
        public /* synthetic */ void a(Exception exc) {
            v.a(this, exc);
        }

        @Override // com.google.android.exoplayer2.source.rtsp.u.d
        public /* synthetic */ void b(List list, Exception exc) {
            v.b(this, list, exc);
        }

        @Override // com.google.android.exoplayer2.source.rtsp.u.d
        public void c(final List<String> list) {
            this.f34403a.post(new Runnable() { // from class: com.google.android.exoplayer2.source.rtsp.m
                @Override // java.lang.Runnable
                public final void run() {
                    this.f34562a.h(list);
                }
            });
        }

        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public final void h(List<String> list) {
            RtspClient.this.p0(list);
            if (y.e(list)) {
                g(list);
            } else {
                f(list);
            }
        }

        public final void f(List<String> list) {
            RtspClient.this.f34391i.d(Integer.parseInt((String) com.google.android.exoplayer2.util.a.e(y.k(list).f34452c.d("CSeq"))));
        }

        public final void g(List<String> list) {
            ImmutableList<f0> immutableListOf;
            c0 c0VarL = y.l(list);
            int i11 = Integer.parseInt((String) com.google.android.exoplayer2.util.a.e(c0VarL.f34455b.d("CSeq")));
            b0 b0Var = (b0) RtspClient.this.f34390h.get(i11);
            if (b0Var == null) {
                return;
            }
            RtspClient.this.f34390h.remove(i11);
            int i12 = b0Var.f34451b;
            try {
                int i13 = c0VarL.f34454a;
                if (i13 == 200) {
                    switch (i12) {
                        case 1:
                        case 3:
                        case 7:
                        case 8:
                        case 9:
                        case 11:
                        case 12:
                            return;
                        case 2:
                            i(new n(i13, h0.b(c0VarL.f34456c)));
                            return;
                        case 4:
                            j(new z(i13, y.j(c0VarL.f34455b.d("Public"))));
                            return;
                        case 5:
                            k();
                            return;
                        case 6:
                            String strD = c0VarL.f34455b.d("Range");
                            d0 d0VarD = strD == null ? d0.f34460c : d0.d(strD);
                            try {
                                String strD2 = c0VarL.f34455b.d("RTP-Info");
                                immutableListOf = strD2 == null ? ImmutableList.of() : f0.a(strD2, RtspClient.this.f34392j);
                            } catch (ParserException unused) {
                                immutableListOf = ImmutableList.of();
                            }
                            l(new a0(c0VarL.f34454a, d0VarD, immutableListOf));
                            return;
                        case 10:
                            String strD3 = c0VarL.f34455b.d("Session");
                            String strD4 = c0VarL.f34455b.d("Transport");
                            if (strD3 == null || strD4 == null) {
                                throw ParserException.createForMalformedManifest("Missing mandatory session or transport header", null);
                            }
                            m(new e0(c0VarL.f34454a, y.m(strD3), strD4));
                            return;
                        default:
                            throw new IllegalStateException();
                    }
                    RtspClient.this.j0(new RtspMediaSource.RtspPlaybackException(e));
                }
                if (i13 != 401) {
                    if (i13 == 301 || i13 == 302) {
                        if (RtspClient.this.f34398p != -1) {
                            RtspClient.this.f34398p = 0;
                        }
                        String strD5 = c0VarL.f34455b.d(HttpHeaders.LOCATION);
                        if (strD5 == null) {
                            RtspClient.this.f34384a.a("Redirection without new location.", null);
                            return;
                        }
                        Uri uri = Uri.parse(strD5);
                        RtspClient.this.f34392j = y.p(uri);
                        RtspClient.this.f34394l = y.n(uri);
                        RtspClient.this.f34391i.c(RtspClient.this.f34392j, RtspClient.this.f34395m);
                        return;
                    }
                } else if (RtspClient.this.f34394l != null && !RtspClient.this.f34400r) {
                    ImmutableList<String> immutableListE = c0VarL.f34455b.e("WWW-Authenticate");
                    if (immutableListE.isEmpty()) {
                        throw ParserException.createForMalformedManifest("Missing WWW-Authenticate header in a 401 response.", null);
                    }
                    for (int i14 = 0; i14 < immutableListE.size(); i14++) {
                        RtspClient.this.f34397o = y.o(immutableListE.get(i14));
                        if (RtspClient.this.f34397o.f34557a == 2) {
                            break;
                        }
                    }
                    RtspClient.this.f34391i.b();
                    RtspClient.this.f34400r = true;
                    return;
                }
                RtspClient.this.j0(new RtspMediaSource.RtspPlaybackException(y.t(i12) + " " + c0VarL.f34454a));
            } catch (ParserException e11) {
                RtspClient.this.j0(new RtspMediaSource.RtspPlaybackException(e11));
            }
        }

        public final void i(n nVar) {
            d0 d0VarD = d0.f34460c;
            String str = nVar.f34565b.f34513a.get("range");
            if (str != null) {
                try {
                    d0VarD = d0.d(str);
                } catch (ParserException e11) {
                    RtspClient.this.f34384a.a("SDP format error.", e11);
                    return;
                }
            }
            ImmutableList<t> immutableListH0 = RtspClient.h0(nVar.f34565b, RtspClient.this.f34392j);
            if (immutableListH0.isEmpty()) {
                RtspClient.this.f34384a.a("No playable track.", null);
            } else {
                RtspClient.this.f34384a.f(d0VarD, immutableListH0);
                RtspClient.this.f34399q = true;
            }
        }

        public final void j(z zVar) {
            if (RtspClient.this.f34396n != null) {
                return;
            }
            if (RtspClient.u0(zVar.f34645b)) {
                RtspClient.this.f34391i.c(RtspClient.this.f34392j, RtspClient.this.f34395m);
            } else {
                RtspClient.this.f34384a.a("DESCRIBE not supported.", null);
            }
        }

        public final void k() {
            com.google.android.exoplayer2.util.a.g(RtspClient.this.f34398p == 2);
            RtspClient.this.f34398p = 1;
            RtspClient.this.f34401s = false;
            if (RtspClient.this.f34402t != C.TIME_UNSET) {
                RtspClient rtspClient = RtspClient.this;
                rtspClient.x0(o0.f1(rtspClient.f34402t));
            }
        }

        public final void l(a0 a0Var) {
            com.google.android.exoplayer2.util.a.g(RtspClient.this.f34398p == 1);
            RtspClient.this.f34398p = 2;
            if (RtspClient.this.f34396n == null) {
                RtspClient rtspClient = RtspClient.this;
                rtspClient.f34396n = rtspClient.new KeepAliveMonitor(30000L);
                RtspClient.this.f34396n.start();
            }
            RtspClient.this.f34402t = C.TIME_UNSET;
            RtspClient.this.f34385b.e(o0.C0(a0Var.f34448b.f34462a), a0Var.f34449c);
        }

        public final void m(e0 e0Var) {
            com.google.android.exoplayer2.util.a.g(RtspClient.this.f34398p != -1);
            RtspClient.this.f34398p = 1;
            RtspClient.this.f34395m = e0Var.f34475b.f34642a;
            RtspClient.this.i0();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f34405a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public b0 f34406b;

        public c() {
        }

        public final b0 a(int i11, @Nullable String str, Map<String, String> map, Uri uri) {
            String str2 = RtspClient.this.f34386c;
            int i12 = this.f34405a;
            this.f34405a = i12 + 1;
            o.b bVar = new o.b(str2, str, i12);
            if (RtspClient.this.f34397o != null) {
                com.google.android.exoplayer2.util.a.i(RtspClient.this.f34394l);
                try {
                    bVar.b(HttpHeaders.AUTHORIZATION, RtspClient.this.f34397o.a(RtspClient.this.f34394l, uri, i11));
                } catch (ParserException e11) {
                    RtspClient.this.j0(new RtspMediaSource.RtspPlaybackException(e11));
                }
            }
            bVar.d(map);
            return new b0(uri, i11, bVar.e(), "");
        }

        public void b() {
            com.google.android.exoplayer2.util.a.i(this.f34406b);
            ImmutableListMultimap<String, String> immutableListMultimapB = this.f34406b.f34452c.b();
            HashMap map = new HashMap();
            for (String str : immutableListMultimapB.keySet()) {
                if (!str.equals("CSeq") && !str.equals("User-Agent") && !str.equals("Session") && !str.equals(HttpHeaders.AUTHORIZATION)) {
                    map.put(str, (String) com.google.common.collect.e0.g(immutableListMultimapB.get(str)));
                }
            }
            h(a(this.f34406b.f34451b, RtspClient.this.f34395m, map, this.f34406b.f34450a));
        }

        public void c(Uri uri, @Nullable String str) {
            h(a(2, str, ImmutableMap.of(), uri));
        }

        public void d(int i11) {
            i(new c0(405, new o.b(RtspClient.this.f34386c, RtspClient.this.f34395m, i11).e()));
            this.f34405a = Math.max(this.f34405a, i11 + 1);
        }

        public void e(Uri uri, @Nullable String str) {
            h(a(4, str, ImmutableMap.of(), uri));
        }

        public void f(Uri uri, String str) {
            com.google.android.exoplayer2.util.a.g(RtspClient.this.f34398p == 2);
            h(a(5, str, ImmutableMap.of(), uri));
            RtspClient.this.f34401s = true;
        }

        public void g(Uri uri, long j11, String str) {
            boolean z11 = true;
            if (RtspClient.this.f34398p != 1 && RtspClient.this.f34398p != 2) {
                z11 = false;
            }
            com.google.android.exoplayer2.util.a.g(z11);
            h(a(6, str, ImmutableMap.of("Range", d0.b(j11)), uri));
        }

        public final void h(b0 b0Var) {
            int i11 = Integer.parseInt((String) com.google.android.exoplayer2.util.a.e(b0Var.f34452c.d("CSeq")));
            com.google.android.exoplayer2.util.a.g(RtspClient.this.f34390h.get(i11) == null);
            RtspClient.this.f34390h.append(i11, b0Var);
            ImmutableList<String> immutableListQ = y.q(b0Var);
            RtspClient.this.p0(immutableListQ);
            RtspClient.this.f34393k.g(immutableListQ);
            this.f34406b = b0Var;
        }

        public final void i(c0 c0Var) {
            ImmutableList<String> immutableListR = y.r(c0Var);
            RtspClient.this.p0(immutableListR);
            RtspClient.this.f34393k.g(immutableListR);
        }

        public void j(Uri uri, String str, @Nullable String str2) {
            RtspClient.this.f34398p = 0;
            h(a(10, str2, ImmutableMap.of("Transport", str), uri));
        }

        public void k(Uri uri, String str) {
            if (RtspClient.this.f34398p == -1 || RtspClient.this.f34398p == 0) {
                return;
            }
            RtspClient.this.f34398p = 0;
            h(a(12, str, ImmutableMap.of(), uri));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface d {
        void c(RtspMediaSource.RtspPlaybackException rtspPlaybackException);

        void d();

        void e(long j11, ImmutableList<f0> immutableList);
    }

    /* JADX INFO: compiled from: source.java */
    public interface e {
        void a(String str, @Nullable Throwable th2);

        void f(d0 d0Var, ImmutableList<t> immutableList);
    }

    public RtspClient(e eVar, d dVar, String str, Uri uri, SocketFactory socketFactory, boolean z11) {
        this.f34384a = eVar;
        this.f34385b = dVar;
        this.f34386c = str;
        this.f34387d = socketFactory;
        this.f34388f = z11;
        this.f34392j = y.p(uri);
        this.f34394l = y.n(uri);
    }

    public static ImmutableList<t> h0(g0 g0Var, Uri uri) {
        ImmutableList.a aVar = new ImmutableList.a();
        for (int i11 = 0; i11 < g0Var.f34514b.size(); i11++) {
            com.google.android.exoplayer2.source.rtsp.a aVar2 = g0Var.f34514b.get(i11);
            if (j.c(aVar2)) {
                aVar.a(new t(aVar2, uri));
            }
        }
        return aVar.m();
    }

    public static boolean u0(List<Integer> list) {
        return list.isEmpty() || list.contains(2);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        KeepAliveMonitor keepAliveMonitor = this.f34396n;
        if (keepAliveMonitor != null) {
            keepAliveMonitor.close();
            this.f34396n = null;
            this.f34391i.k(this.f34392j, (String) com.google.android.exoplayer2.util.a.e(this.f34395m));
        }
        this.f34393k.close();
    }

    public final void i0() {
        p.d dVarPollFirst = this.f34389g.pollFirst();
        if (dVarPollFirst == null) {
            this.f34385b.d();
        } else {
            this.f34391i.j(dVarPollFirst.c(), dVarPollFirst.d(), this.f34395m);
        }
    }

    public final void j0(Throwable th2) {
        RtspMediaSource.RtspPlaybackException rtspPlaybackException = th2 instanceof RtspMediaSource.RtspPlaybackException ? (RtspMediaSource.RtspPlaybackException) th2 : new RtspMediaSource.RtspPlaybackException(th2);
        if (this.f34399q) {
            this.f34385b.c(rtspPlaybackException);
        } else {
            this.f34384a.a(com.google.common.base.p.e(th2.getMessage()), th2);
        }
    }

    public final Socket k0(Uri uri) throws IOException {
        com.google.android.exoplayer2.util.a.a(uri.getHost() != null);
        return this.f34387d.createSocket((String) com.google.android.exoplayer2.util.a.e(uri.getHost()), uri.getPort() > 0 ? uri.getPort() : 554);
    }

    public int l0() {
        return this.f34398p;
    }

    public final void p0(List<String> list) {
        if (this.f34388f) {
            com.google.android.exoplayer2.util.s.b("RtspClient", com.google.common.base.g.h("\n").d(list));
        }
    }

    public void q0(int i11, u.b bVar) {
        this.f34393k.e(i11, bVar);
    }

    public void s0() {
        try {
            close();
            u uVar = new u(new b());
            this.f34393k = uVar;
            uVar.d(k0(this.f34392j));
            this.f34395m = null;
            this.f34400r = false;
            this.f34397o = null;
        } catch (IOException e11) {
            this.f34385b.c(new RtspMediaSource.RtspPlaybackException(e11));
        }
    }

    public void t0(long j11) {
        if (this.f34398p == 2 && !this.f34401s) {
            this.f34391i.f(this.f34392j, (String) com.google.android.exoplayer2.util.a.e(this.f34395m));
        }
        this.f34402t = j11;
    }

    public void v0(List<p.d> list) {
        this.f34389g.addAll(list);
        i0();
    }

    public void w0() throws IOException {
        try {
            this.f34393k.d(k0(this.f34392j));
            this.f34391i.e(this.f34392j, this.f34395m);
        } catch (IOException e11) {
            o0.n(this.f34393k);
            throw e11;
        }
    }

    public void x0(long j11) {
        this.f34391i.g(this.f34392j, j11, (String) com.google.android.exoplayer2.util.a.e(this.f34395m));
    }
}
