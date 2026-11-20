package com.transsion.transfer.androidasync.http;

import android.net.Uri;
import com.google.android.gms.common.api.Api;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import com.transsion.transfer.androidasync.ByteBufferList;
import com.transsion.transfer.androidasync.util.ArrayDeque;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Hashtable;
import java.util.Locale;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class t extends c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f58815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f58816b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f58817c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AsyncHttpClient f58818d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f58819e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f58820f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f58821g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Hashtable<String, d> f58822h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f58823i;

    /* JADX INFO: compiled from: source.java */
    public class a implements fy.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayDeque f58824a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f58825b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f58826c;

        public a(ArrayDeque arrayDeque, e eVar, String str) {
            this.f58824a = arrayDeque;
            this.f58825b = eVar;
            this.f58826c = str;
        }

        @Override // fy.a
        public void i(Exception exc) {
            synchronized (t.this) {
                this.f58824a.remove(this.f58825b);
                t.this.w(this.f58826c);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements fy.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.transsion.transfer.androidasync.l f58828a;

        public b(com.transsion.transfer.androidasync.l lVar) {
            this.f58828a = lVar;
        }

        @Override // fy.a
        public void i(Exception exc) {
            this.f58828a.y(null);
            this.f58828a.close();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends fy.d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.transsion.transfer.androidasync.l f58830a;

        public c(com.transsion.transfer.androidasync.l lVar) {
            this.f58830a = lVar;
        }

        @Override // fy.d.a, fy.d
        public void D(com.transsion.transfer.androidasync.r rVar, ByteBufferList byteBufferList) {
            super.D(rVar, byteBufferList);
            byteBufferList.B();
            this.f58830a.y(null);
            this.f58830a.close();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f58832a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ArrayDeque<g.a> f58833b = new ArrayDeque<>();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ArrayDeque<e> f58834c = new ArrayDeque<>();
    }

    /* JADX INFO: compiled from: source.java */
    public class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public com.transsion.transfer.androidasync.l f58835a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f58836b = System.currentTimeMillis();

        public e(com.transsion.transfer.androidasync.l lVar) {
            this.f58835a = lVar;
        }
    }

    public t(AsyncHttpClient asyncHttpClient) {
        this(asyncHttpClient, HttpHost.DEFAULT_SCHEME_NAME, 80);
    }

    public t(AsyncHttpClient asyncHttpClient, String str, int i11) {
        this.f58817c = 300000;
        this.f58822h = new Hashtable<>();
        this.f58823i = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.f58818d = asyncHttpClient;
        this.f58815a = str;
        this.f58816b = i11;
    }

    @Override // com.transsion.transfer.androidasync.http.c0, com.transsion.transfer.androidasync.http.g
    public void b(g.C0599g c0599g) {
        if (c0599g.f58668a.a("socket-owner") != this) {
            return;
        }
        try {
            q(c0599g.f58664f);
            if (c0599g.f58670k != null || !c0599g.f58664f.isOpen()) {
                c0599g.f58669b.u("closing out socket (exception)");
                c0599g.f58664f.y(null);
                c0599g.f58664f.close();
            } else if (r(c0599g)) {
                c0599g.f58669b.r("Recycling keep-alive socket");
                y(c0599g.f58664f, c0599g.f58669b);
            } else {
                c0599g.f58669b.u("closing out socket (not keep alive)");
                c0599g.f58664f.y(null);
                c0599g.f58664f.close();
            }
        } finally {
            x(c0599g.f58669b);
        }
    }

    @Override // com.transsion.transfer.androidasync.http.c0, com.transsion.transfer.androidasync.http.g
    public com.transsion.transfer.androidasync.future.a e(final g.a aVar) {
        String host;
        int iM;
        String str;
        final Uri uriP = aVar.f58669b.p();
        final int iP = p(aVar.f58669b.p());
        if (iP == -1) {
            return null;
        }
        aVar.f58668a.b("socket-owner", this);
        d dVarO = o(n(uriP, iP, aVar.f58669b.l(), aVar.f58669b.m()));
        synchronized (this) {
            try {
                int i11 = dVarO.f58832a;
                if (i11 >= this.f58823i) {
                    com.transsion.transfer.androidasync.future.n nVar = new com.transsion.transfer.androidasync.future.n();
                    dVarO.f58833b.add(aVar);
                    return nVar;
                }
                boolean z11 = true;
                dVarO.f58832a = i11 + 1;
                while (!dVarO.f58834c.isEmpty()) {
                    e eVarPop = dVarO.f58834c.pop();
                    com.transsion.transfer.androidasync.l lVar = eVarPop.f58835a;
                    if (eVarPop.f58836b + ((long) this.f58817c) < System.currentTimeMillis()) {
                        lVar.y(null);
                        lVar.close();
                    } else if (lVar.isOpen()) {
                        aVar.f58669b.r("Reusing keep-alive socket");
                        aVar.f58660c.a(null, lVar);
                        com.transsion.transfer.androidasync.future.n nVar2 = new com.transsion.transfer.androidasync.future.n();
                        nVar2.setComplete();
                        return nVar2;
                    }
                }
                if (this.f58819e && this.f58820f == null && aVar.f58669b.l() == null) {
                    aVar.f58669b.u("Resolving domain and connecting to all available addresses");
                    com.transsion.transfer.androidasync.future.w wVar = new com.transsion.transfer.androidasync.future.w();
                    wVar.E(this.f58818d.x().p(uriP.getHost()).a(new com.transsion.transfer.androidasync.future.z() { // from class: com.transsion.transfer.androidasync.http.o
                        @Override // com.transsion.transfer.androidasync.future.z
                        public final com.transsion.transfer.androidasync.future.f then(Object obj) {
                            return this.f58726a.t(iP, aVar, (InetAddress[]) obj);
                        }
                    }).i(new com.transsion.transfer.androidasync.future.d() { // from class: com.transsion.transfer.androidasync.http.p
                        @Override // com.transsion.transfer.androidasync.future.d
                        public final void a(Exception exc) throws Exception {
                            this.f58729a.u(aVar, uriP, iP, exc);
                        }
                    })).j(new com.transsion.transfer.androidasync.future.g() { // from class: com.transsion.transfer.androidasync.http.q
                        @Override // com.transsion.transfer.androidasync.future.g
                        public final void a(Exception exc, Object obj) {
                            this.f58733a.v(aVar, uriP, iP, exc, (com.transsion.transfer.androidasync.l) obj);
                        }
                    });
                    return wVar;
                }
                aVar.f58669b.r("Connecting socket");
                if (aVar.f58669b.l() == null && (str = this.f58820f) != null) {
                    aVar.f58669b.d(str, this.f58821g);
                }
                if (aVar.f58669b.l() != null) {
                    host = aVar.f58669b.l();
                    iM = aVar.f58669b.m();
                } else {
                    host = uriP.getHost();
                    iM = iP;
                    z11 = false;
                }
                if (z11) {
                    aVar.f58669b.u("Using proxy: " + host + ":" + iM);
                }
                return this.f58818d.x().m(host, iM, z(aVar, uriP, iP, z11, aVar.f58660c));
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public String n(Uri uri, int i11, String str, int i12) {
        String str2;
        if (str != null) {
            str2 = str + ":" + i12;
        } else {
            str2 = "";
        }
        if (str != null) {
            str2 = str + ":" + i12;
        }
        return uri.getScheme() + "//" + uri.getHost() + ":" + i11 + "?proxy=" + str2;
    }

    public final d o(String str) {
        d dVar = this.f58822h.get(str);
        if (dVar != null) {
            return dVar;
        }
        d dVar2 = new d();
        this.f58822h.put(str, dVar2);
        return dVar2;
    }

    public int p(Uri uri) {
        if (uri.getScheme() == null || !uri.getScheme().equals(this.f58815a)) {
            return -1;
        }
        return uri.getPort() == -1 ? this.f58816b : uri.getPort();
    }

    public final void q(com.transsion.transfer.androidasync.l lVar) {
        lVar.A(new b(lVar));
        lVar.p(null);
        lVar.o(new c(lVar));
    }

    public boolean r(g.C0599g c0599g) {
        return HttpUtil.e(c0599g.f58665g.protocol(), c0599g.f58665g.g()) && HttpUtil.d(Protocol.HTTP_1_1, c0599g.f58669b.h());
    }

    public final /* synthetic */ com.transsion.transfer.androidasync.future.f s(int i11, g.a aVar, InetAddress inetAddress) throws Exception {
        final com.transsion.transfer.androidasync.future.w wVar = new com.transsion.transfer.androidasync.future.w();
        String str = String.format(Locale.ENGLISH, "%s:%s", inetAddress, Integer.valueOf(i11));
        aVar.f58669b.u("attempting connection to " + str);
        this.f58818d.x().n(new InetSocketAddress(inetAddress, i11), new fy.b() { // from class: com.transsion.transfer.androidasync.http.s
            @Override // fy.b
            public final void a(Exception exc, com.transsion.transfer.androidasync.l lVar) {
                wVar.H(exc, lVar);
            }
        });
        return wVar;
    }

    public final /* synthetic */ com.transsion.transfer.androidasync.future.f t(final int i11, final g.a aVar, InetAddress[] inetAddressArr) throws Exception {
        return com.transsion.transfer.androidasync.future.l.d(inetAddressArr, new com.transsion.transfer.androidasync.future.z() { // from class: com.transsion.transfer.androidasync.http.r
            @Override // com.transsion.transfer.androidasync.future.z
            public final com.transsion.transfer.androidasync.future.f then(Object obj) {
                return this.f58737a.s(i11, aVar, (InetAddress) obj);
            }
        });
    }

    public final /* synthetic */ void u(g.a aVar, Uri uri, int i11, Exception exc) throws Exception {
        z(aVar, uri, i11, false, aVar.f58660c).a(exc, null);
    }

    public final /* synthetic */ void v(g.a aVar, Uri uri, int i11, Exception exc, com.transsion.transfer.androidasync.l lVar) {
        if (lVar == null) {
            return;
        }
        if (exc == null) {
            z(aVar, uri, i11, false, aVar.f58660c).a(null, lVar);
            return;
        }
        aVar.f58669b.r("Recycling extra socket leftover from cancelled operation");
        q(lVar);
        y(lVar, aVar.f58669b);
    }

    public final void w(String str) {
        d dVar = this.f58822h.get(str);
        if (dVar == null) {
            return;
        }
        while (!dVar.f58834c.isEmpty()) {
            e eVarPeekLast = dVar.f58834c.peekLast();
            com.transsion.transfer.androidasync.l lVar = eVarPeekLast.f58835a;
            if (eVarPeekLast.f58836b + ((long) this.f58817c) > System.currentTimeMillis()) {
                break;
            }
            dVar.f58834c.pop();
            lVar.y(null);
            lVar.close();
        }
        if (dVar.f58832a == 0 && dVar.f58833b.isEmpty() && dVar.f58834c.isEmpty()) {
            this.f58822h.remove(str);
        }
    }

    public final void x(j jVar) {
        Uri uriP = jVar.p();
        String strN = n(uriP, p(uriP), jVar.l(), jVar.m());
        synchronized (this) {
            try {
                d dVar = this.f58822h.get(strN);
                if (dVar == null) {
                    return;
                }
                dVar.f58832a--;
                while (dVar.f58832a < this.f58823i && dVar.f58833b.size() > 0) {
                    g.a aVarRemove = dVar.f58833b.remove();
                    com.transsion.transfer.androidasync.future.n nVar = (com.transsion.transfer.androidasync.future.n) aVarRemove.f58661d;
                    if (!nVar.isCancelled()) {
                        nVar.setParent(e(aVarRemove));
                    }
                }
                w(strN);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void y(com.transsion.transfer.androidasync.l lVar, j jVar) {
        ArrayDeque<e> arrayDeque;
        if (lVar == null) {
            return;
        }
        Uri uriP = jVar.p();
        String strN = n(uriP, p(uriP), jVar.l(), jVar.m());
        e eVar = new e(lVar);
        synchronized (this) {
            arrayDeque = o(strN).f58834c;
            arrayDeque.push(eVar);
        }
        lVar.y(new a(arrayDeque, eVar, strN));
    }

    public fy.b z(g.a aVar, Uri uri, int i11, boolean z11, fy.b bVar) {
        return bVar;
    }
}
