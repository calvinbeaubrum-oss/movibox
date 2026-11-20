package jo;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import com.squareup.okhttp.Address;
import com.squareup.okhttp.CertificatePinner;
import com.squareup.okhttp.Connection;
import com.squareup.okhttp.ConnectionSpec;
import com.squareup.okhttp.Handshake;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.Route;
import com.squareup.okhttp.internal.e;
import com.squareup.okhttp.internal.framed.FramedConnection;
import com.squareup.okhttp.internal.g;
import com.squareup.okhttp.internal.h;
import com.squareup.okhttp.internal.http.OkHeaders;
import com.squareup.okhttp.internal.http.RouteException;
import com.squareup.okhttp.internal.http.d;
import com.squareup.okhttp.internal.http.n;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import ko.b;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class a implements Connection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Route f68113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Socket f68114b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Socket f68115c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Handshake f68116d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Protocol f68117e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile FramedConnection f68118f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f68119g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public BufferedSource f68120h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public BufferedSink f68121i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f68123k;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<Reference<n>> f68122j = new ArrayList();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f68124l = Long.MAX_VALUE;

    public a(Route route) {
        this.f68113a = route;
    }

    public int a() {
        FramedConnection framedConnection = this.f68118f;
        if (framedConnection != null) {
            return framedConnection.d0();
        }
        return 1;
    }

    public void b() {
        g.d(this.f68114b);
    }

    public void c(int i11, int i12, int i13, List<ConnectionSpec> list, boolean z11) throws RouteException {
        if (this.f68117e != null) {
            throw new IllegalStateException("already connected");
        }
        com.squareup.okhttp.internal.a aVar = new com.squareup.okhttp.internal.a(list);
        Proxy proxy = this.f68113a.getProxy();
        Address address = this.f68113a.getAddress();
        if (this.f68113a.getAddress().getSslSocketFactory() == null && !list.contains(ConnectionSpec.CLEARTEXT)) {
            throw new RouteException(new UnknownServiceException("CLEARTEXT communication not supported: " + list));
        }
        RouteException routeException = null;
        while (this.f68117e == null) {
            try {
                this.f68114b = (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.HTTP) ? address.getSocketFactory().createSocket() : new Socket(proxy);
                d(i11, i12, i13, aVar);
            } catch (IOException e11) {
                g.d(this.f68115c);
                g.d(this.f68114b);
                this.f68115c = null;
                this.f68114b = null;
                this.f68120h = null;
                this.f68121i = null;
                this.f68116d = null;
                this.f68117e = null;
                if (routeException == null) {
                    routeException = new RouteException(e11);
                } else {
                    routeException.addConnectException(e11);
                }
                if (!z11) {
                    throw routeException;
                }
                if (!aVar.b(e11)) {
                    throw routeException;
                }
            }
        }
    }

    public final void d(int i11, int i12, int i13, com.squareup.okhttp.internal.a aVar) throws Throwable {
        this.f68114b.setSoTimeout(i12);
        try {
            e.f().d(this.f68114b, this.f68113a.getSocketAddress(), i11);
            this.f68120h = Okio.buffer(Okio.source(this.f68114b));
            this.f68121i = Okio.buffer(Okio.sink(this.f68114b));
            if (this.f68113a.getAddress().getSslSocketFactory() != null) {
                e(i12, i13, aVar);
            } else {
                this.f68117e = Protocol.HTTP_1_1;
                this.f68115c = this.f68114b;
            }
            Protocol protocol = this.f68117e;
            if (protocol == Protocol.SPDY_3 || protocol == Protocol.HTTP_2) {
                this.f68115c.setSoTimeout(0);
                FramedConnection framedConnectionI = new FramedConnection.a(true).k(this.f68115c, this.f68113a.getAddress().url().host(), this.f68120h, this.f68121i).j(this.f68117e).i();
                framedConnectionI.s0();
                this.f68118f = framedConnectionI;
            }
        } catch (ConnectException unused) {
            throw new ConnectException("Failed to connect to " + this.f68113a.getSocketAddress());
        }
    }

    public final void e(int i11, int i12, com.squareup.okhttp.internal.a aVar) throws Throwable {
        if (this.f68113a.requiresTunnel()) {
            f(i11, i12);
        }
        Address address = this.f68113a.getAddress();
        SSLSocket sSLSocket = null;
        try {
            try {
                SSLSocket sSLSocket2 = (SSLSocket) address.getSslSocketFactory().createSocket(this.f68114b, address.getUriHost(), address.getUriPort(), true);
                try {
                    ConnectionSpec connectionSpecA = aVar.a(sSLSocket2);
                    if (connectionSpecA.supportsTlsExtensions()) {
                        e.f().c(sSLSocket2, address.getUriHost(), address.getProtocols());
                    }
                    sSLSocket2.startHandshake();
                    Handshake handshake = Handshake.get(sSLSocket2.getSession());
                    if (address.getHostnameVerifier().verify(address.getUriHost(), sSLSocket2.getSession())) {
                        address.getCertificatePinner().check(address.getUriHost(), handshake.peerCertificates());
                        String strH = connectionSpecA.supportsTlsExtensions() ? e.f().h(sSLSocket2) : null;
                        this.f68115c = sSLSocket2;
                        this.f68120h = Okio.buffer(Okio.source(sSLSocket2));
                        this.f68121i = Okio.buffer(Okio.sink(this.f68115c));
                        this.f68116d = handshake;
                        this.f68117e = strH != null ? Protocol.get(strH) : Protocol.HTTP_1_1;
                        e.f().a(sSLSocket2);
                        return;
                    }
                    X509Certificate x509Certificate = (X509Certificate) handshake.peerCertificates().get(0);
                    throw new SSLPeerUnverifiedException("Hostname " + address.getUriHost() + " not verified:\n    certificate: " + CertificatePinner.pin(x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + b.a(x509Certificate));
                } catch (AssertionError e11) {
                    e = e11;
                    if (!g.o(e)) {
                        throw e;
                    }
                    throw new IOException(e);
                } catch (Throwable th2) {
                    th = th2;
                    sSLSocket = sSLSocket2;
                    if (sSLSocket != null) {
                        e.f().a(sSLSocket);
                    }
                    g.d(sSLSocket);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (AssertionError e12) {
            e = e12;
        }
    }

    public final void f(int i11, int i12) throws IOException {
        Request requestG = g();
        HttpUrl httpUrl = requestG.httpUrl();
        String str = "CONNECT " + httpUrl.host() + ":" + httpUrl.port() + " HTTP/1.1";
        do {
            d dVar = new d(null, this.f68120h, this.f68121i);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.f68120h.timeout().timeout(i11, timeUnit);
            this.f68121i.timeout().timeout(i12, timeUnit);
            dVar.p(requestG.headers(), str);
            dVar.finishRequest();
            Response responseBuild = dVar.o().request(requestG).build();
            long jE = OkHeaders.e(responseBuild);
            if (jE == -1) {
                jE = 0;
            }
            Source sourceL = dVar.l(jE);
            g.r(sourceL, Api.BaseClientBuilder.API_PRIORITY_OTHER, timeUnit);
            sourceL.close();
            int iCode = responseBuild.code();
            if (iCode == 200) {
                if (!this.f68120h.buffer().exhausted() || !this.f68121i.buffer().exhausted()) {
                    throw new IOException("TLS tunnel buffered too many bytes!");
                }
                return;
            } else {
                if (iCode != 407) {
                    throw new IOException("Unexpected response code for CONNECT: " + responseBuild.code());
                }
                requestG = OkHeaders.j(this.f68113a.getAddress().getAuthenticator(), responseBuild, this.f68113a.getProxy());
            }
        } while (requestG != null);
        throw new IOException("Failed to authenticate with proxy");
    }

    public final Request g() throws IOException {
        return new Request.Builder().url(this.f68113a.getAddress().url()).header(HttpHeaders.HOST, g.i(this.f68113a.getAddress().url())).header("Proxy-Connection", "Keep-Alive").header("User-Agent", h.a()).build();
    }

    @Override // com.squareup.okhttp.Connection
    public Handshake getHandshake() {
        return this.f68116d;
    }

    @Override // com.squareup.okhttp.Connection
    public Protocol getProtocol() {
        Protocol protocol = this.f68117e;
        return protocol != null ? protocol : Protocol.HTTP_1_1;
    }

    @Override // com.squareup.okhttp.Connection
    public Route getRoute() {
        return this.f68113a;
    }

    @Override // com.squareup.okhttp.Connection
    public Socket getSocket() {
        return this.f68115c;
    }

    public boolean h(boolean z11) {
        if (this.f68115c.isClosed() || this.f68115c.isInputShutdown() || this.f68115c.isOutputShutdown()) {
            return false;
        }
        if (this.f68118f == null && z11) {
            try {
                int soTimeout = this.f68115c.getSoTimeout();
                try {
                    this.f68115c.setSoTimeout(1);
                    if (this.f68120h.exhausted()) {
                        this.f68115c.setSoTimeout(soTimeout);
                        return false;
                    }
                    this.f68115c.setSoTimeout(soTimeout);
                    return true;
                } catch (Throwable th2) {
                    this.f68115c.setSoTimeout(soTimeout);
                    throw th2;
                }
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            }
        }
        return true;
    }

    public boolean i() {
        return this.f68118f != null;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Connection{");
        sb2.append(this.f68113a.getAddress().url().host());
        sb2.append(":");
        sb2.append(this.f68113a.getAddress().url().port());
        sb2.append(", proxy=");
        sb2.append(this.f68113a.getProxy());
        sb2.append(" hostAddress=");
        sb2.append(this.f68113a.getSocketAddress());
        sb2.append(" cipherSuite=");
        Handshake handshake = this.f68116d;
        sb2.append(handshake != null ? handshake.cipherSuite() : DevicePublicKeyStringDef.NONE);
        sb2.append(" protocol=");
        sb2.append(this.f68117e);
        sb2.append('}');
        return sb2.toString();
    }
}
