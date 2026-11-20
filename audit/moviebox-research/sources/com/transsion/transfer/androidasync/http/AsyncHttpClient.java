package com.transsion.transfer.androidasync.http;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.cloud.hisavana.sdk.internal.agentpage.AgentPageJsBridge;
import com.transsion.transfer.androidasync.AsyncSSLException;
import com.transsion.transfer.androidasync.AsyncServer;
import com.transsion.transfer.androidasync.ByteBufferList;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class AsyncHttpClient {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static AsyncHttpClient f58552f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<com.transsion.transfer.androidasync.http.g> f58553a = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public n f58554b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public t f58555c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public v f58556d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AsyncServer f58557e;

    /* JADX INFO: compiled from: source.java */
    public class a implements fy.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f58558a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.transsion.transfer.androidasync.http.j f58559b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ h f58560c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ hy.a f58561d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ com.transsion.transfer.androidasync.http.g.C0599g f58562e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f58563f;

        public a(com.transsion.transfer.androidasync.http.j jVar, h hVar, hy.a aVar, com.transsion.transfer.androidasync.http.g.C0599g c0599g, int i11) {
            this.f58559b = jVar;
            this.f58560c = hVar;
            this.f58561d = aVar;
            this.f58562e = c0599g;
            this.f58563f = i11;
        }

        @Override // fy.b
        public void a(Exception exc, com.transsion.transfer.androidasync.l lVar) {
            if (this.f58558a && lVar != null) {
                lVar.o(new fy.d.a());
                lVar.A(new fy.a.C0680a());
                lVar.close();
                throw new AssertionError("double connect callback");
            }
            this.f58558a = true;
            this.f58559b.u("socket connected");
            if (this.f58560c.isCancelled()) {
                if (lVar != null) {
                    lVar.close();
                    return;
                }
                return;
            }
            h hVar = this.f58560c;
            if (hVar.f58592i != null) {
                hVar.f58591h.cancel();
            }
            if (exc != null) {
                AsyncHttpClient.this.H(this.f58560c, exc, null, this.f58559b, this.f58561d);
                return;
            }
            com.transsion.transfer.androidasync.http.g.C0599g c0599g = this.f58562e;
            c0599g.f58664f = lVar;
            h hVar2 = this.f58560c;
            hVar2.f58590g = lVar;
            AsyncHttpClient.this.u(this.f58559b, this.f58563f, hVar2, this.f58561d, c0599g);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends l {

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final /* synthetic */ h f58565q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final /* synthetic */ com.transsion.transfer.androidasync.http.j f58566r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final /* synthetic */ hy.a f58567s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public final /* synthetic */ com.transsion.transfer.androidasync.http.g.C0599g f58568t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public final /* synthetic */ int f58569u;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(com.transsion.transfer.androidasync.http.j jVar, h hVar, com.transsion.transfer.androidasync.http.j jVar2, hy.a aVar, com.transsion.transfer.androidasync.http.g.C0599g c0599g, int i11) {
            super(jVar);
            this.f58565q = hVar;
            this.f58566r = jVar2;
            this.f58567s = aVar;
            this.f58568t = c0599g;
            this.f58569u = i11;
        }

        @Override // com.transsion.transfer.androidasync.http.l, com.transsion.transfer.androidasync.s
        public void L(Exception exc) {
            if (exc != null) {
                this.f58566r.s("exception during response", exc);
            }
            if (this.f58565q.isCancelled()) {
                return;
            }
            if (exc instanceof AsyncSSLException) {
                this.f58566r.s("SSL Exception", exc);
                AsyncSSLException asyncSSLException = (AsyncSSLException) exc;
                this.f58566r.v(asyncSSLException);
                if (asyncSSLException.getIgnore()) {
                    return;
                }
            }
            com.transsion.transfer.androidasync.l lVarSocket = socket();
            if (lVarSocket == null) {
                return;
            }
            super.L(exc);
            if ((!lVarSocket.isOpen() || exc != null) && g() == null && exc != null) {
                AsyncHttpClient.this.H(this.f58565q, exc, null, this.f58566r, this.f58567s);
            }
            this.f58568t.f58670k = exc;
            Iterator<com.transsion.transfer.androidasync.http.g> it = AsyncHttpClient.this.f58553a.iterator();
            while (it.hasNext()) {
                it.next().b(this.f58568t);
            }
        }

        @Override // com.transsion.transfer.androidasync.v
        public void M(com.transsion.transfer.androidasync.r rVar) {
            this.f58568t.f58663j = rVar;
            Iterator<com.transsion.transfer.androidasync.http.g> it = AsyncHttpClient.this.f58553a.iterator();
            while (it.hasNext()) {
                it.next().d(this.f58568t);
            }
            super.M(this.f58568t.f58663j);
            Iterator<com.transsion.transfer.androidasync.http.g> it2 = AsyncHttpClient.this.f58553a.iterator();
            while (it2.hasNext()) {
                final com.transsion.transfer.androidasync.http.j jVarH = it2.next().h(this.f58568t);
                if (jVarH != null) {
                    com.transsion.transfer.androidasync.http.j jVar = this.f58566r;
                    jVarH.f58694l = jVar.f58694l;
                    jVarH.f58693k = jVar.f58693k;
                    jVarH.f58692j = jVar.f58692j;
                    jVarH.f58690h = jVar.f58690h;
                    jVarH.f58691i = jVar.f58691i;
                    AsyncHttpClient.I(jVarH);
                    this.f58566r.t("Response intercepted by middleware");
                    jVarH.t("Request initiated by middleware intercept by middleware");
                    AsyncServer asyncServer = AsyncHttpClient.this.f58557e;
                    final int i11 = this.f58569u;
                    final h hVar = this.f58565q;
                    final hy.a aVar = this.f58567s;
                    asyncServer.D(new Runnable() { // from class: com.transsion.transfer.androidasync.http.d
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f58641a.V(jVarH, i11, hVar, aVar);
                        }
                    });
                    o(new fy.d.a());
                    return;
                }
            }
            Headers headers = this.f58699j;
            int iB = b();
            if ((iB != 301 && iB != 302 && iB != 307) || !this.f58566r.g()) {
                this.f58566r.u("Final (post cache response) headers:\n" + toString());
                AsyncHttpClient.this.H(this.f58565q, null, this, this.f58566r, this.f58567s);
                return;
            }
            String strC = headers.c(HttpHeaders.LOCATION);
            try {
                Uri uri = Uri.parse(strC);
                if (uri.getScheme() == null) {
                    uri = Uri.parse(new URL(new URL(this.f58566r.p().toString()), strC).toString());
                }
                final com.transsion.transfer.androidasync.http.j jVar2 = new com.transsion.transfer.androidasync.http.j(uri, this.f58566r.j().equals("HEAD") ? "HEAD" : "GET");
                com.transsion.transfer.androidasync.http.j jVar3 = this.f58566r;
                jVar2.f58694l = jVar3.f58694l;
                jVar2.f58693k = jVar3.f58693k;
                jVar2.f58692j = jVar3.f58692j;
                jVar2.f58690h = jVar3.f58690h;
                jVar2.f58691i = jVar3.f58691i;
                AsyncHttpClient.I(jVar2);
                AsyncHttpClient.o(this.f58566r, jVar2, "User-Agent");
                AsyncHttpClient.o(this.f58566r, jVar2, "Range");
                this.f58566r.t("Redirecting");
                jVar2.t("Redirected");
                AsyncServer asyncServer2 = AsyncHttpClient.this.f58557e;
                final int i12 = this.f58569u;
                final h hVar2 = this.f58565q;
                final hy.a aVar2 = this.f58567s;
                asyncServer2.D(new Runnable() { // from class: com.transsion.transfer.androidasync.http.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f58646a.W(jVar2, i12, hVar2, aVar2);
                    }
                });
                o(new fy.d.a());
            } catch (Exception e11) {
                AsyncHttpClient.this.H(this.f58565q, e11, this, this.f58566r, this.f58567s);
            }
        }

        @Override // com.transsion.transfer.androidasync.http.l
        public void O() {
            super.O();
            if (this.f58565q.isCancelled()) {
                return;
            }
            h hVar = this.f58565q;
            if (hVar.f58592i != null) {
                hVar.f58591h.cancel();
            }
            this.f58566r.u("Received headers:\n" + toString());
            Iterator<com.transsion.transfer.androidasync.http.g> it = AsyncHttpClient.this.f58553a.iterator();
            while (it.hasNext()) {
                it.next().g(this.f58568t);
            }
        }

        @Override // com.transsion.transfer.androidasync.http.l
        public void Q(Exception exc) {
            if (exc != null) {
                AsyncHttpClient.this.H(this.f58565q, exc, null, this.f58566r, this.f58567s);
                return;
            }
            this.f58566r.u("request completed");
            if (this.f58565q.isCancelled()) {
                return;
            }
            h hVar = this.f58565q;
            if (hVar.f58592i != null && this.f58699j == null) {
                hVar.f58591h.cancel();
                h hVar2 = this.f58565q;
                hVar2.f58591h = AsyncHttpClient.this.f58557e.E(hVar2.f58592i, AsyncHttpClient.y(this.f58566r));
            }
            Iterator<com.transsion.transfer.androidasync.http.g> it = AsyncHttpClient.this.f58553a.iterator();
            while (it.hasNext()) {
                it.next().c(this.f58568t);
            }
        }

        public final /* synthetic */ void V(com.transsion.transfer.androidasync.http.j jVar, int i11, h hVar, hy.a aVar) {
            AsyncHttpClient.this.r(jVar, i11, hVar, aVar);
        }

        public final /* synthetic */ void W(com.transsion.transfer.androidasync.http.j jVar, int i11, h hVar, hy.a aVar) {
            AsyncHttpClient.this.r(jVar, i11 + 1, hVar, aVar);
        }

        @Override // com.transsion.transfer.androidasync.http.k
        public com.transsion.transfer.androidasync.l w() {
            this.f58566r.r("Detaching socket");
            com.transsion.transfer.androidasync.l lVarSocket = socket();
            if (lVarSocket == null) {
                return null;
            }
            lVarSocket.p(null);
            lVarSocket.y(null);
            lVarSocket.A(null);
            lVarSocket.o(null);
            R(null);
            return lVarSocket;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements fy.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f58571a;

        public c(l lVar) {
            this.f58571a = lVar;
        }

        @Override // fy.a
        public void i(Exception exc) {
            if (exc != null) {
                this.f58571a.L(exc);
            } else {
                this.f58571a.P();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements fy.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f58573a;

        public d(l lVar) {
            this.f58573a = lVar;
        }

        @Override // fy.a
        public void i(Exception exc) {
            if (exc != null) {
                this.f58573a.L(exc);
            } else {
                this.f58573a.O();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e extends com.transsion.transfer.androidasync.future.w<File> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ h f58575g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ OutputStream f58576h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ File f58577i;

        public e(h hVar, OutputStream outputStream, File file) {
            this.f58575g = hVar;
            this.f58576h = outputStream;
            this.f58577i = file;
        }

        @Override // com.transsion.transfer.androidasync.future.n
        public void cancelCleanup() {
            try {
                this.f58575g.get().o(new fy.d.a());
                this.f58575g.get().close();
            } catch (Exception unused) {
            }
            try {
                this.f58576h.close();
            } catch (Exception unused2) {
            }
            this.f58577i.delete();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class f implements hy.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f58579a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ OutputStream f58580b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ File f58581c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ g f58582d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ com.transsion.transfer.androidasync.future.w f58583e;

        /* JADX INFO: compiled from: source.java */
        public class a extends com.transsion.transfer.androidasync.stream.a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ com.transsion.transfer.androidasync.http.k f58585b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ long f58586c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(OutputStream outputStream, com.transsion.transfer.androidasync.http.k kVar, long j11) {
                super(outputStream);
                this.f58585b = kVar;
                this.f58586c = j11;
            }

            @Override // com.transsion.transfer.androidasync.stream.a, fy.d
            public void D(com.transsion.transfer.androidasync.r rVar, ByteBufferList byteBufferList) {
                f.this.f58579a += (long) byteBufferList.C();
                super.D(rVar, byteBufferList);
                f fVar = f.this;
                AsyncHttpClient.this.C(fVar.f58582d, this.f58585b, fVar.f58579a, this.f58586c);
            }
        }

        /* JADX INFO: compiled from: source.java */
        public class b implements fy.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.transsion.transfer.androidasync.http.k f58588a;

            public b(com.transsion.transfer.androidasync.http.k kVar) {
                this.f58588a = kVar;
            }

            @Override // fy.a
            public void i(Exception e11) {
                try {
                    f.this.f58580b.close();
                } catch (IOException e12) {
                    e11 = e12;
                }
                Exception exc = e11;
                if (exc == null) {
                    f fVar = f.this;
                    AsyncHttpClient.this.E(fVar.f58582d, fVar.f58583e, this.f58588a, null, fVar.f58581c);
                } else {
                    f.this.f58581c.delete();
                    f fVar2 = f.this;
                    AsyncHttpClient.this.E(fVar2.f58582d, fVar2.f58583e, this.f58588a, exc, null);
                }
            }
        }

        public f(OutputStream outputStream, File file, g gVar, com.transsion.transfer.androidasync.future.w wVar) {
            this.f58580b = outputStream;
            this.f58581c = file;
            this.f58582d = gVar;
            this.f58583e = wVar;
        }

        @Override // hy.a
        public void a(Exception exc, com.transsion.transfer.androidasync.http.k kVar) {
            if (exc != null) {
                try {
                    this.f58580b.close();
                } catch (IOException unused) {
                }
                this.f58581c.delete();
                AsyncHttpClient.this.E(this.f58582d, this.f58583e, kVar, exc, null);
            } else {
                AsyncHttpClient.this.B(this.f58582d, kVar);
                kVar.o(new a(this.f58580b, kVar, HttpUtil.a(kVar.g())));
                kVar.A(new b(kVar));
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class g extends i<File> {
    }

    /* JADX INFO: compiled from: source.java */
    public class h extends com.transsion.transfer.androidasync.future.w<com.transsion.transfer.androidasync.http.k> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public com.transsion.transfer.androidasync.l f58590g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public com.transsion.transfer.androidasync.future.a f58591h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Runnable f58592i;

        public h() {
        }

        @Override // com.transsion.transfer.androidasync.future.w, com.transsion.transfer.androidasync.future.n, com.transsion.transfer.androidasync.future.a
        public boolean cancel() {
            if (!super.cancel()) {
                return false;
            }
            com.transsion.transfer.androidasync.l lVar = this.f58590g;
            if (lVar != null) {
                lVar.o(new fy.d.a());
                this.f58590g.close();
            }
            com.transsion.transfer.androidasync.future.a aVar = this.f58591h;
            if (aVar == null) {
                return true;
            }
            aVar.cancel();
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class i<T> implements hy.b<T> {
        @Override // hy.b
        public void a(com.transsion.transfer.androidasync.http.k kVar, long j11, long j12) {
        }

        @Override // hy.b
        public void b(com.transsion.transfer.androidasync.http.k kVar) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class j extends i<String> {
    }

    /* JADX INFO: compiled from: source.java */
    public interface k {
        void a(Exception exc, d0 d0Var);
    }

    public AsyncHttpClient(AsyncServer asyncServer) {
        this.f58557e = asyncServer;
        t tVar = new t(this);
        this.f58555c = tVar;
        z(tVar);
        n nVar = new n(this);
        this.f58554b = nVar;
        z(nVar);
        v vVar = new v();
        this.f58556d = vVar;
        z(vVar);
        this.f58554b.A(new b0());
    }

    public static /* synthetic */ void G(com.transsion.transfer.androidasync.future.w wVar, k kVar, com.transsion.transfer.androidasync.http.j jVar, Exception exc, com.transsion.transfer.androidasync.http.k kVar2) {
        if (exc != null) {
            if (!wVar.G(exc) || kVar == null) {
                return;
            }
            kVar.a(exc, null);
            return;
        }
        d0 d0VarF = h0.F(jVar.h(), kVar2);
        if (d0VarF == null) {
            exc = new WebSocketHandshakeException("Unable to complete websocket handshake");
            kVar2.close();
            if (!wVar.G(exc)) {
                return;
            }
        } else if (!wVar.J(d0VarF)) {
            return;
        }
        if (kVar != null) {
            kVar.a(exc, d0VarF);
        }
    }

    @SuppressLint({"NewApi"})
    public static void I(com.transsion.transfer.androidasync.http.j jVar) {
        if (jVar.f58690h != null) {
            return;
        }
        try {
            List<Proxy> listSelect = ProxySelector.getDefault().select(URI.create(jVar.p().toString()));
            if (listSelect.isEmpty()) {
                return;
            }
            Proxy proxy = listSelect.get(0);
            if (proxy.type() == Proxy.Type.HTTP && (proxy.address() instanceof InetSocketAddress)) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) proxy.address();
                jVar.d(inetSocketAddress.getHostString(), inetSocketAddress.getPort());
            }
        } catch (Exception unused) {
        }
    }

    public static void o(com.transsion.transfer.androidasync.http.j jVar, com.transsion.transfer.androidasync.http.j jVar2, String str) {
        String strC = jVar.h().c(str);
        if (TextUtils.isEmpty(strC)) {
            return;
        }
        jVar2.h().f(str, strC);
    }

    public static AsyncHttpClient w() {
        if (f58552f == null) {
            f58552f = new AsyncHttpClient(AsyncServer.r());
        }
        return f58552f;
    }

    public static long y(com.transsion.transfer.androidasync.http.j jVar) {
        return jVar.o();
    }

    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public final <T> void E(final hy.b<T> bVar, final com.transsion.transfer.androidasync.future.w<T> wVar, final com.transsion.transfer.androidasync.http.k kVar, final Exception exc, final T t11) {
        this.f58557e.D(new Runnable() { // from class: com.transsion.transfer.androidasync.http.AsyncHttpClient.7
            @Override // java.lang.Runnable
            public void run() {
                AsyncHttpClient.this.D(bVar, wVar, kVar, exc, t11);
            }
        });
    }

    public final void B(hy.b bVar, com.transsion.transfer.androidasync.http.k kVar) {
        if (bVar != null) {
            bVar.b(kVar);
        }
    }

    public final void C(hy.b bVar, com.transsion.transfer.androidasync.http.k kVar, long j11, long j12) {
        if (bVar != null) {
            bVar.a(kVar, j11, j12);
        }
    }

    public final <T> void D(hy.b<T> bVar, com.transsion.transfer.androidasync.future.w<T> wVar, com.transsion.transfer.androidasync.http.k kVar, Exception exc, T t11) {
        if ((exc != null ? wVar.G(exc) : wVar.J(t11)) && bVar != null) {
            bVar.c(exc, kVar, t11);
        }
    }

    public final /* synthetic */ void F(final hy.b bVar, final com.transsion.transfer.androidasync.future.w wVar, jy.a aVar, Exception exc, final com.transsion.transfer.androidasync.http.k kVar) {
        if (exc != null) {
            E(bVar, wVar, kVar, exc, null);
            return;
        }
        B(bVar, kVar);
        com.transsion.transfer.androidasync.future.f fVarA = aVar.a(kVar);
        fVarA.j(new com.transsion.transfer.androidasync.future.g() { // from class: com.transsion.transfer.androidasync.http.b
            @Override // com.transsion.transfer.androidasync.future.g
            public final void a(Exception exc2, Object obj) {
                this.f58628a.E(bVar, wVar, kVar, exc2, obj);
            }
        });
        wVar.setParent(fVarA);
    }

    public final void H(h hVar, Exception exc, l lVar, com.transsion.transfer.androidasync.http.j jVar, hy.a aVar) {
        boolean zJ;
        hVar.f58591h.cancel();
        if (exc != null) {
            jVar.s("Connection error", exc);
            zJ = hVar.G(exc);
        } else {
            jVar.r("Connection successful");
            zJ = hVar.J(lVar);
        }
        if (zJ) {
            aVar.a(exc, lVar);
        } else if (lVar != null) {
            lVar.o(new fy.d.a());
            lVar.close();
        }
    }

    public com.transsion.transfer.androidasync.future.f<d0> J(com.transsion.transfer.androidasync.http.j jVar, String str, k kVar) {
        return K(jVar, str != null ? new String[]{str} : null, kVar);
    }

    public com.transsion.transfer.androidasync.future.f<d0> K(final com.transsion.transfer.androidasync.http.j jVar, String[] strArr, final k kVar) {
        h0.D(jVar, strArr);
        final com.transsion.transfer.androidasync.future.w wVar = new com.transsion.transfer.androidasync.future.w();
        wVar.setParent(p(jVar, new hy.a() { // from class: com.transsion.transfer.androidasync.http.c
            @Override // hy.a
            public final void a(Exception exc, k kVar2) {
                AsyncHttpClient.G(wVar, kVar, jVar, exc, kVar2);
            }
        }));
        return wVar;
    }

    public com.transsion.transfer.androidasync.future.f<d0> L(String str, String str2, k kVar) {
        return J(new com.transsion.transfer.androidasync.http.h(str.replace("ws://", "http://").replace("wss://", AgentPageJsBridge.HTTPS)), str2, kVar);
    }

    public com.transsion.transfer.androidasync.future.f<com.transsion.transfer.androidasync.http.k> p(com.transsion.transfer.androidasync.http.j jVar, hy.a aVar) {
        h hVar = new h();
        r(jVar, 0, hVar, aVar);
        return hVar;
    }

    public <T> com.transsion.transfer.androidasync.future.w<T> q(com.transsion.transfer.androidasync.http.j jVar, final jy.a<T> aVar, final hy.b<T> bVar) {
        h hVar = new h();
        final com.transsion.transfer.androidasync.future.w<T> wVar = new com.transsion.transfer.androidasync.future.w<>();
        r(jVar, 0, hVar, new hy.a() { // from class: com.transsion.transfer.androidasync.http.a
            @Override // hy.a
            public final void a(Exception exc, k kVar) {
                this.f58624a.F(bVar, wVar, aVar, exc, kVar);
            }
        });
        wVar.setParent(hVar);
        return wVar;
    }

    public final void r(final com.transsion.transfer.androidasync.http.j jVar, final int i11, final h hVar, final hy.a aVar) {
        if (this.f58557e.t()) {
            s(jVar, i11, hVar, aVar);
        } else {
            this.f58557e.D(new Runnable() { // from class: com.transsion.transfer.androidasync.http.AsyncHttpClient.1
                @Override // java.lang.Runnable
                public void run() {
                    AsyncHttpClient.this.s(jVar, i11, hVar, aVar);
                }
            });
        }
    }

    public final void s(final com.transsion.transfer.androidasync.http.j jVar, int i11, final h hVar, final hy.a aVar) {
        if (i11 > 15) {
            H(hVar, new RedirectLimitExceededException("too many redirects"), null, jVar, aVar);
            return;
        }
        jVar.p();
        final com.transsion.transfer.androidasync.http.g.C0599g c0599g = new com.transsion.transfer.androidasync.http.g.C0599g();
        jVar.f58694l = System.currentTimeMillis();
        c0599g.f58669b = jVar;
        jVar.r("Executing request.");
        Iterator<com.transsion.transfer.androidasync.http.g> it = this.f58553a.iterator();
        while (it.hasNext()) {
            it.next().a(c0599g);
        }
        if (jVar.o() > 0) {
            Runnable runnable = new Runnable() { // from class: com.transsion.transfer.androidasync.http.AsyncHttpClient.2
                @Override // java.lang.Runnable
                public void run() {
                    com.transsion.transfer.androidasync.future.a aVar2 = c0599g.f58661d;
                    if (aVar2 != null) {
                        aVar2.cancel();
                        com.transsion.transfer.androidasync.l lVar = c0599g.f58664f;
                        if (lVar != null) {
                            lVar.close();
                        }
                    }
                    AsyncHttpClient.this.H(hVar, new TimeoutException(), null, jVar, aVar);
                }
            };
            hVar.f58592i = runnable;
            hVar.f58591h = this.f58557e.E(runnable, y(jVar));
        }
        c0599g.f58660c = new a(jVar, hVar, aVar, c0599g, i11);
        I(jVar);
        if (jVar.e() != null && jVar.h().c(HttpHeaders.CONTENT_TYPE) == null) {
            jVar.h().f(HttpHeaders.CONTENT_TYPE, jVar.e().c());
        }
        Iterator<com.transsion.transfer.androidasync.http.g> it2 = this.f58553a.iterator();
        while (it2.hasNext()) {
            com.transsion.transfer.androidasync.future.a aVarE = it2.next().e(c0599g);
            if (aVarE != null) {
                c0599g.f58661d = aVarE;
                hVar.setParent(aVarE);
                return;
            }
        }
        H(hVar, new IllegalArgumentException("invalid uri=" + jVar.p() + " middlewares=" + this.f58553a), null, jVar, aVar);
    }

    public com.transsion.transfer.androidasync.future.f<File> t(com.transsion.transfer.androidasync.http.j jVar, String str, g gVar) {
        File file = new File(str);
        file.getParentFile().mkdirs();
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file), 8192);
            h hVar = new h();
            e eVar = new e(hVar, bufferedOutputStream, file);
            eVar.setParent(hVar);
            r(jVar, 0, hVar, new f(bufferedOutputStream, file, gVar, eVar));
            return eVar;
        } catch (FileNotFoundException e11) {
            com.transsion.transfer.androidasync.future.w wVar = new com.transsion.transfer.androidasync.future.w();
            wVar.G(e11);
            return wVar;
        }
    }

    public final void u(com.transsion.transfer.androidasync.http.j jVar, int i11, h hVar, hy.a aVar, com.transsion.transfer.androidasync.http.g.C0599g c0599g) {
        b bVar = new b(jVar, hVar, jVar, aVar, c0599g, i11);
        c0599g.f58666h = new c(bVar);
        c0599g.f58667i = new d(bVar);
        c0599g.f58665g = bVar;
        bVar.R(c0599g.f58664f);
        Iterator<com.transsion.transfer.androidasync.http.g> it = this.f58553a.iterator();
        while (it.hasNext() && !it.next().f(c0599g)) {
        }
    }

    public com.transsion.transfer.androidasync.future.f<String> v(com.transsion.transfer.androidasync.http.j jVar, j jVar2) {
        return q(jVar, new jy.f(), jVar2);
    }

    public AsyncServer x() {
        return this.f58557e;
    }

    public void z(com.transsion.transfer.androidasync.http.g gVar) {
        this.f58553a.add(0, gVar);
    }
}
