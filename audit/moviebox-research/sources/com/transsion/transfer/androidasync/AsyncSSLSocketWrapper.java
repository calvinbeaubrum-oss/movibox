package com.transsion.transfer.androidasync;

import java.nio.ByteBuffer;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.AbstractVerifier;
import org.apache.http.conn.ssl.StrictHostnameVerifier;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class AsyncSSLSocketWrapper implements l, r, com.transsion.transfer.androidasync.b {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static SSLContext f58418v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static SSLContext f58419w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static TrustManager[] f58420x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static HostnameVerifier f58421y;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l f58422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p f58423b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f58424c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SSLEngine f58425d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f58426e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f58427f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f58428g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f58429h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public HostnameVerifier f58430i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public g f58431j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public X509Certificate[] f58432k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public fy.j f58433l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public fy.d f58434m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public TrustManager[] f58435n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f58436o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f58437p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Exception f58438q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ByteBufferList f58439r = new ByteBufferList();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final fy.d f58440s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ByteBufferList f58441t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public fy.a f58442u;

    /* JADX INFO: compiled from: source.java */
    public class a implements X509TrustManager {
        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            for (X509Certificate x509Certificate : x509CertificateArr) {
                if (x509Certificate != null && x509Certificate.getCriticalExtensionOIDs() != null) {
                    x509Certificate.getCriticalExtensionOIDs().remove("2.5.29.15");
                }
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements X509TrustManager {
        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements fy.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f58443a;

        public c(g gVar) {
            this.f58443a = gVar;
        }

        @Override // fy.a
        public void i(Exception exc) {
            if (exc != null) {
                this.f58443a.a(exc, null);
            } else {
                this.f58443a.a(new SSLException("socket closed during handshake"), null);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements fy.j {
        public d() {
        }

        @Override // fy.j
        public void a() {
            fy.j jVar = AsyncSSLSocketWrapper.this.f58433l;
            if (jVar != null) {
                jVar.a();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e implements fy.a {
        public e() {
        }

        @Override // fy.a
        public void i(Exception exc) {
            fy.a aVar;
            AsyncSSLSocketWrapper asyncSSLSocketWrapper = AsyncSSLSocketWrapper.this;
            if (asyncSSLSocketWrapper.f58437p) {
                return;
            }
            asyncSSLSocketWrapper.f58437p = true;
            asyncSSLSocketWrapper.f58438q = exc;
            if (asyncSSLSocketWrapper.f58439r.r() || (aVar = AsyncSSLSocketWrapper.this.f58442u) == null) {
                return;
            }
            aVar.i(exc);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class f implements fy.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.transsion.transfer.androidasync.util.a f58446a = new com.transsion.transfer.androidasync.util.a().d(8192);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ByteBufferList f58447b = new ByteBufferList();

        public f() {
        }

        @Override // fy.d
        public void D(r rVar, ByteBufferList byteBufferList) {
            AsyncSSLSocketWrapper asyncSSLSocketWrapper = AsyncSSLSocketWrapper.this;
            if (asyncSSLSocketWrapper.f58424c) {
                return;
            }
            try {
                try {
                    asyncSSLSocketWrapper.f58424c = true;
                    byteBufferList.f(this.f58447b);
                    if (this.f58447b.r()) {
                        this.f58447b.a(this.f58447b.j());
                    }
                    ByteBuffer byteBufferD = ByteBufferList.f58481j;
                    while (true) {
                        if (byteBufferD.remaining() == 0 && this.f58447b.E() > 0) {
                            byteBufferD = this.f58447b.D();
                        }
                        int iRemaining = byteBufferD.remaining();
                        int iC = AsyncSSLSocketWrapper.this.f58439r.C();
                        ByteBuffer byteBufferA = this.f58446a.a();
                        SSLEngineResult sSLEngineResultUnwrap = AsyncSSLSocketWrapper.this.f58425d.unwrap(byteBufferD, byteBufferA);
                        AsyncSSLSocketWrapper asyncSSLSocketWrapper2 = AsyncSSLSocketWrapper.this;
                        asyncSSLSocketWrapper2.l(asyncSSLSocketWrapper2.f58439r, byteBufferA);
                        this.f58446a.e(AsyncSSLSocketWrapper.this.f58439r.C() - iC);
                        if (sSLEngineResultUnwrap.getStatus() != SSLEngineResult.Status.BUFFER_OVERFLOW) {
                            if (sSLEngineResultUnwrap.getStatus() != SSLEngineResult.Status.BUFFER_UNDERFLOW) {
                                AsyncSSLSocketWrapper.this.t(sSLEngineResultUnwrap.getHandshakeStatus());
                                if (byteBufferD.remaining() != iRemaining && iC == AsyncSSLSocketWrapper.this.f58439r.C()) {
                                    this.f58447b.c(byteBufferD);
                                    break;
                                }
                            } else {
                                this.f58447b.c(byteBufferD);
                                if (this.f58447b.E() <= 1) {
                                    break;
                                }
                                this.f58447b.c(this.f58447b.j());
                                byteBufferD = ByteBufferList.f58481j;
                            }
                        } else {
                            com.transsion.transfer.androidasync.util.a aVar = this.f58446a;
                            aVar.d(aVar.c() * 2);
                        }
                        iRemaining = -1;
                        AsyncSSLSocketWrapper.this.t(sSLEngineResultUnwrap.getHandshakeStatus());
                        if (byteBufferD.remaining() != iRemaining) {
                        }
                    }
                    AsyncSSLSocketWrapper.this.D();
                } catch (SSLException e11) {
                    AsyncSSLSocketWrapper.this.F(e11);
                }
            } finally {
                AsyncSSLSocketWrapper.this.f58424c = false;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface g {
        void a(Exception exc, com.transsion.transfer.androidasync.b bVar);
    }

    static {
        try {
            f58418v = SSLContext.getInstance("Default");
        } catch (Exception e11) {
            try {
                f58418v = SSLContext.getInstance("TLS");
                f58418v.init(null, new TrustManager[]{new a()}, null);
            } catch (Exception e12) {
                e11.printStackTrace();
                e12.printStackTrace();
            }
        }
        try {
            f58419w = SSLContext.getInstance("TLS");
            TrustManager[] trustManagerArr = {new b()};
            f58420x = trustManagerArr;
            f58419w.init(null, trustManagerArr, null);
            f58421y = new HostnameVerifier() { // from class: com.transsion.transfer.androidasync.c
                @Override // javax.net.ssl.HostnameVerifier
                public final boolean verify(String str, SSLSession sSLSession) {
                    return AsyncSSLSocketWrapper.B(str, sSLSession);
                }
            };
        } catch (Exception e13) {
            e13.printStackTrace();
        }
    }

    public AsyncSSLSocketWrapper(l lVar, String str, int i11, SSLEngine sSLEngine, TrustManager[] trustManagerArr, HostnameVerifier hostnameVerifier, boolean z11) {
        f fVar = new f();
        this.f58440s = fVar;
        this.f58441t = new ByteBufferList();
        this.f58422a = lVar;
        this.f58430i = hostnameVerifier;
        this.f58436o = z11;
        this.f58435n = trustManagerArr;
        this.f58425d = sSLEngine;
        this.f58428g = str;
        this.f58427f = i11;
        sSLEngine.setUseClientMode(z11);
        p pVar = new p(lVar);
        this.f58423b = pVar;
        pVar.p(new d());
        this.f58422a.A(new e());
        this.f58422a.o(fVar);
    }

    public static /* synthetic */ boolean B(String str, SSLSession sSLSession) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(Exception exc) {
        g gVar = this.f58431j;
        if (gVar == null) {
            fy.a aVarR = r();
            if (aVarR != null) {
                aVarR.i(exc);
                return;
            }
            return;
        }
        this.f58431j = null;
        this.f58422a.o(new fy.d.a());
        this.f58422a.f();
        this.f58422a.y(null);
        this.f58422a.close();
        gVar.a(exc, null);
    }

    public static SSLContext q() {
        return f58418v;
    }

    public static void v(l lVar, String str, int i11, SSLEngine sSLEngine, TrustManager[] trustManagerArr, HostnameVerifier hostnameVerifier, boolean z11, g gVar) {
        AsyncSSLSocketWrapper asyncSSLSocketWrapper = new AsyncSSLSocketWrapper(lVar, str, i11, sSLEngine, trustManagerArr, hostnameVerifier, z11);
        asyncSSLSocketWrapper.f58431j = gVar;
        lVar.y(new c(gVar));
        try {
            asyncSSLSocketWrapper.f58425d.beginHandshake();
            asyncSSLSocketWrapper.t(asyncSSLSocketWrapper.f58425d.getHandshakeStatus());
        } catch (SSLException e11) {
            asyncSSLSocketWrapper.F(e11);
        }
    }

    @Override // com.transsion.transfer.androidasync.r
    public void A(fy.a aVar) {
        this.f58442u = aVar;
    }

    public void D() {
        fy.a aVar;
        c0.a(this, this.f58439r);
        if (!this.f58437p || this.f58439r.r() || (aVar = this.f58442u) == null) {
            return;
        }
        aVar.i(this.f58438q);
    }

    @Override // com.transsion.transfer.androidasync.r
    public fy.d G() {
        return this.f58434m;
    }

    @Override // com.transsion.transfer.androidasync.l, com.transsion.transfer.androidasync.r, com.transsion.transfer.androidasync.u
    public AsyncServer a() {
        return this.f58422a.a();
    }

    @Override // com.transsion.transfer.androidasync.r
    public void close() {
        this.f58422a.close();
    }

    @Override // com.transsion.transfer.androidasync.r
    public boolean e() {
        return this.f58422a.e();
    }

    @Override // com.transsion.transfer.androidasync.u
    public void f() {
        this.f58422a.f();
    }

    @Override // com.transsion.transfer.androidasync.u
    public boolean isOpen() {
        return this.f58422a.isOpen();
    }

    @Override // com.transsion.transfer.androidasync.u
    public fy.j k() {
        return this.f58433l;
    }

    public void l(ByteBufferList byteBufferList, ByteBuffer byteBuffer) {
        byteBuffer.flip();
        if (byteBuffer.hasRemaining()) {
            byteBufferList.a(byteBuffer);
        } else {
            ByteBufferList.A(byteBuffer);
        }
    }

    @Override // com.transsion.transfer.androidasync.u
    public void m(ByteBufferList byteBufferList) {
        if (!this.f58429h && this.f58423b.j() <= 0) {
            this.f58429h = true;
            ByteBuffer byteBufferT = ByteBufferList.t(n(byteBufferList.C()));
            SSLEngineResult sSLEngineResultWrap = null;
            do {
                if (!this.f58426e || byteBufferList.C() != 0) {
                    int iC = byteBufferList.C();
                    try {
                        ByteBuffer[] byteBufferArrK = byteBufferList.k();
                        sSLEngineResultWrap = this.f58425d.wrap(byteBufferArrK, byteBufferT);
                        byteBufferList.b(byteBufferArrK);
                        byteBufferT.flip();
                        this.f58441t.a(byteBufferT);
                        if (this.f58441t.C() > 0) {
                            this.f58423b.m(this.f58441t);
                        }
                        int iCapacity = byteBufferT.capacity();
                        try {
                            if (sSLEngineResultWrap.getStatus() == SSLEngineResult.Status.BUFFER_OVERFLOW) {
                                byteBufferT = ByteBufferList.t(iCapacity * 2);
                                iC = -1;
                            } else {
                                byteBufferT = ByteBufferList.t(n(byteBufferList.C()));
                                t(sSLEngineResultWrap.getHandshakeStatus());
                            }
                        } catch (SSLException e11) {
                            e = e11;
                            byteBufferT = null;
                            F(e);
                        }
                    } catch (SSLException e12) {
                        e = e12;
                    }
                    if (iC == byteBufferList.C() && (sSLEngineResultWrap == null || sSLEngineResultWrap.getHandshakeStatus() != SSLEngineResult.HandshakeStatus.NEED_WRAP)) {
                        break;
                    }
                } else {
                    break;
                }
            } while (this.f58423b.j() == 0);
            this.f58429h = false;
            ByteBufferList.A(byteBufferT);
        }
    }

    public int n(int i11) {
        int i12 = (i11 * 3) / 2;
        if (i12 == 0) {
            return 8192;
        }
        return i12;
    }

    @Override // com.transsion.transfer.androidasync.r
    public void o(fy.d dVar) {
        this.f58434m = dVar;
    }

    @Override // com.transsion.transfer.androidasync.u
    public void p(fy.j jVar) {
        this.f58433l = jVar;
    }

    @Override // com.transsion.transfer.androidasync.r
    public void pause() {
        this.f58422a.pause();
    }

    public fy.a r() {
        return this.f58442u;
    }

    @Override // com.transsion.transfer.androidasync.r
    public void resume() {
        this.f58422a.resume();
        D();
    }

    @Override // com.transsion.transfer.androidasync.r
    public String s() {
        return null;
    }

    public final void t(SSLEngineResult.HandshakeStatus handshakeStatus) {
        if (handshakeStatus == SSLEngineResult.HandshakeStatus.NEED_TASK) {
            this.f58425d.getDelegatedTask().run();
        }
        if (handshakeStatus == SSLEngineResult.HandshakeStatus.NEED_WRAP) {
            m(this.f58441t);
        }
        if (handshakeStatus == SSLEngineResult.HandshakeStatus.NEED_UNWRAP) {
            this.f58440s.D(this, new ByteBufferList());
        }
        try {
            if (this.f58426e) {
                return;
            }
            if (this.f58425d.getHandshakeStatus() != SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING && this.f58425d.getHandshakeStatus() != SSLEngineResult.HandshakeStatus.FINISHED) {
                return;
            }
            if (this.f58436o) {
                boolean z11 = false;
                try {
                    this.f58432k = (X509Certificate[]) this.f58425d.getSession().getPeerCertificates();
                    String str = this.f58428g;
                    if (str != null) {
                        HostnameVerifier hostnameVerifier = this.f58430i;
                        if (hostnameVerifier == null) {
                            new StrictHostnameVerifier().verify(this.f58428g, AbstractVerifier.getCNs(this.f58432k[0]), AbstractVerifier.getDNSSubjectAlts(this.f58432k[0]));
                        } else if (!hostnameVerifier.verify(str, this.f58425d.getSession())) {
                            throw new SSLException("hostname <" + this.f58428g + "> has been denied");
                        }
                    }
                    e = null;
                    z11 = true;
                } catch (SSLException e11) {
                    e = e11;
                }
                this.f58426e = true;
                if (!z11) {
                    AsyncSSLException asyncSSLException = new AsyncSSLException(e);
                    F(asyncSSLException);
                    if (!asyncSSLException.getIgnore()) {
                        throw asyncSSLException;
                    }
                }
            } else {
                this.f58426e = true;
            }
            this.f58431j.a(null, this);
            this.f58431j = null;
            this.f58422a.y(null);
            a().D(new Runnable() { // from class: com.transsion.transfer.androidasync.AsyncSSLSocketWrapper.7
                @Override // java.lang.Runnable
                public void run() {
                    fy.j jVar = AsyncSSLSocketWrapper.this.f58433l;
                    if (jVar != null) {
                        jVar.a();
                    }
                }
            });
            D();
        } catch (Exception e12) {
            F(e12);
        }
    }

    @Override // com.transsion.transfer.androidasync.u
    public void y(fy.a aVar) {
        this.f58422a.y(aVar);
    }
}
