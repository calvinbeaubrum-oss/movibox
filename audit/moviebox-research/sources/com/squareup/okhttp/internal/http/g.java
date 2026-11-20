package com.squareup.okhttp.internal.http;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.squareup.okhttp.Address;
import com.squareup.okhttp.CertificatePinner;
import com.squareup.okhttp.Connection;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import com.squareup.okhttp.Route;
import com.squareup.okhttp.internal.InternalCache;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.GzipSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class g {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final ResponseBody f49284r = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OkHttpClient f49285a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n f49286b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Response f49287c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public HttpStream f49288d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f49289e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f49290f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f49291g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Request f49292h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Request f49293i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Response f49294j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Response f49295k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Sink f49296l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public BufferedSink f49297m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f49298n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f49299o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public CacheRequest f49300p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public com.squareup.okhttp.internal.http.b f49301q;

    /* JADX INFO: compiled from: source.java */
    public static class a extends ResponseBody {
        @Override // com.squareup.okhttp.ResponseBody
        public long contentLength() {
            return 0L;
        }

        @Override // com.squareup.okhttp.ResponseBody
        public MediaType contentType() {
            return null;
        }

        @Override // com.squareup.okhttp.ResponseBody
        public BufferedSource source() {
            return new Buffer();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements Source {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f49302a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BufferedSource f49303b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CacheRequest f49304c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ BufferedSink f49305d;

        public b(BufferedSource bufferedSource, CacheRequest cacheRequest, BufferedSink bufferedSink) {
            this.f49303b = bufferedSource;
            this.f49304c = cacheRequest;
            this.f49305d = bufferedSink;
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!this.f49302a && !com.squareup.okhttp.internal.g.g(this, 100, TimeUnit.MILLISECONDS)) {
                this.f49302a = true;
                this.f49304c.abort();
            }
            this.f49303b.close();
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j11) throws IOException {
            try {
                long j12 = this.f49303b.read(buffer, j11);
                if (j12 != -1) {
                    buffer.copyTo(this.f49305d.buffer(), buffer.size() - j12, j12);
                    this.f49305d.emitCompleteSegments();
                    return j12;
                }
                if (!this.f49302a) {
                    this.f49302a = true;
                    this.f49305d.close();
                }
                return -1L;
            } catch (IOException e11) {
                if (!this.f49302a) {
                    this.f49302a = true;
                    this.f49304c.abort();
                }
                throw e11;
            }
        }

        @Override // okio.Source
        public Timeout timeout() {
            return this.f49303b.timeout();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements Interceptor.Chain {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f49307a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Request f49308b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f49309c;

        public c(int i11, Request request) {
            this.f49307a = i11;
            this.f49308b = request;
        }

        @Override // com.squareup.okhttp.Interceptor.Chain
        public Connection connection() {
            return g.this.f49286b.c();
        }

        @Override // com.squareup.okhttp.Interceptor.Chain
        public Response proceed(Request request) throws IOException {
            this.f49309c++;
            if (this.f49307a > 0) {
                Interceptor interceptor = g.this.f49285a.networkInterceptors().get(this.f49307a - 1);
                Address address = connection().getRoute().getAddress();
                if (!request.httpUrl().host().equals(address.getUriHost()) || request.httpUrl().port() != address.getUriPort()) {
                    throw new IllegalStateException("network interceptor " + interceptor + " must retain the same host and port");
                }
                if (this.f49309c > 1) {
                    throw new IllegalStateException("network interceptor " + interceptor + " must call proceed() exactly once");
                }
            }
            if (this.f49307a < g.this.f49285a.networkInterceptors().size()) {
                c cVar = g.this.new c(this.f49307a + 1, request);
                Interceptor interceptor2 = g.this.f49285a.networkInterceptors().get(this.f49307a);
                Response responseIntercept = interceptor2.intercept(cVar);
                if (cVar.f49309c != 1) {
                    throw new IllegalStateException("network interceptor " + interceptor2 + " must call proceed() exactly once");
                }
                if (responseIntercept != null) {
                    return responseIntercept;
                }
                throw new NullPointerException("network interceptor " + interceptor2 + " returned null");
            }
            g.this.f49288d.writeRequestHeaders(request);
            g.this.f49293i = request;
            if (g.this.q(request) && request.body() != null) {
                BufferedSink bufferedSinkBuffer = Okio.buffer(g.this.f49288d.createRequestBody(request, request.body().contentLength()));
                request.body().writeTo(bufferedSinkBuffer);
                bufferedSinkBuffer.close();
            }
            Response responseR = g.this.r();
            int iCode = responseR.code();
            if ((iCode != 204 && iCode != 205) || responseR.body().contentLength() <= 0) {
                return responseR;
            }
            throw new ProtocolException("HTTP " + iCode + " had non-zero Content-Length: " + responseR.body().contentLength());
        }

        @Override // com.squareup.okhttp.Interceptor.Chain
        public Request request() {
            return this.f49308b;
        }
    }

    public g(OkHttpClient okHttpClient, Request request, boolean z11, boolean z12, boolean z13, n nVar, k kVar, Response response) {
        this.f49285a = okHttpClient;
        this.f49292h = request;
        this.f49291g = z11;
        this.f49298n = z12;
        this.f49299o = z13;
        this.f49286b = nVar == null ? new n(okHttpClient.getConnectionPool(), i(okHttpClient, request)) : nVar;
        this.f49296l = kVar;
        this.f49287c = response;
    }

    public static boolean B(Response response, Response response2) {
        Date date;
        if (response2.code() == 304) {
            return true;
        }
        Date date2 = response.headers().getDate(HttpHeaders.LAST_MODIFIED);
        return (date2 == null || (date = response2.headers().getDate(HttpHeaders.LAST_MODIFIED)) == null || date.getTime() >= date2.getTime()) ? false : true;
    }

    public static Headers g(Headers headers, Headers headers2) throws IOException {
        Headers.Builder builder = new Headers.Builder();
        int size = headers.size();
        for (int i11 = 0; i11 < size; i11++) {
            String strName = headers.name(i11);
            String strValue = headers.value(i11);
            if ((!"Warning".equalsIgnoreCase(strName) || !strValue.startsWith("1")) && (!OkHeaders.h(strName) || headers2.get(strName) == null)) {
                builder.add(strName, strValue);
            }
        }
        int size2 = headers2.size();
        for (int i12 = 0; i12 < size2; i12++) {
            String strName2 = headers2.name(i12);
            if (!HttpHeaders.CONTENT_LENGTH.equalsIgnoreCase(strName2) && OkHeaders.h(strName2)) {
                builder.add(strName2, headers2.value(i12));
            }
        }
        return builder.build();
    }

    public static Address i(OkHttpClient okHttpClient, Request request) {
        SSLSocketFactory sslSocketFactory;
        HostnameVerifier hostnameVerifier;
        CertificatePinner certificatePinner;
        if (request.isHttps()) {
            sslSocketFactory = okHttpClient.getSslSocketFactory();
            hostnameVerifier = okHttpClient.getHostnameVerifier();
            certificatePinner = okHttpClient.getCertificatePinner();
        } else {
            sslSocketFactory = null;
            hostnameVerifier = null;
            certificatePinner = null;
        }
        return new Address(request.httpUrl().host(), request.httpUrl().port(), okHttpClient.getDns(), okHttpClient.getSocketFactory(), sslSocketFactory, hostnameVerifier, certificatePinner, okHttpClient.getAuthenticator(), okHttpClient.getProxy(), okHttpClient.getProtocols(), okHttpClient.getConnectionSpecs(), okHttpClient.getProxySelector());
    }

    public static boolean n(Response response) {
        if (response.request().method().equals("HEAD")) {
            return false;
        }
        int iCode = response.code();
        return (((iCode >= 100 && iCode < 200) || iCode == 204 || iCode == 304) && OkHeaders.e(response) == -1 && !"chunked".equalsIgnoreCase(response.header("Transfer-Encoding"))) ? false : true;
    }

    public static Response z(Response response) {
        return (response == null || response.body() == null) ? response : response.newBuilder().body(null).build();
    }

    public final Response A(Response response) throws IOException {
        if (!this.f49290f || !"gzip".equalsIgnoreCase(this.f49295k.header(HttpHeaders.CONTENT_ENCODING)) || response.body() == null) {
            return response;
        }
        GzipSource gzipSource = new GzipSource(response.body().source());
        Headers headersBuild = response.headers().newBuilder().removeAll(HttpHeaders.CONTENT_ENCODING).removeAll(HttpHeaders.CONTENT_LENGTH).build();
        return response.newBuilder().headers(headersBuild).body(new i(headersBuild, Okio.buffer(gzipSource))).build();
    }

    public void C() {
        if (this.f49289e != -1) {
            throw new IllegalStateException();
        }
        this.f49289e = System.currentTimeMillis();
    }

    public final Response d(CacheRequest cacheRequest, Response response) throws IOException {
        Sink sinkBody;
        return (cacheRequest == null || (sinkBody = cacheRequest.body()) == null) ? response : response.newBuilder().body(new i(response.headers(), Okio.buffer(new b(response.body().source(), cacheRequest, Okio.buffer(sinkBody))))).build();
    }

    public void e() {
        this.f49286b.b();
    }

    public n f() {
        BufferedSink bufferedSink = this.f49297m;
        if (bufferedSink != null) {
            com.squareup.okhttp.internal.g.c(bufferedSink);
        } else {
            Sink sink = this.f49296l;
            if (sink != null) {
                com.squareup.okhttp.internal.g.c(sink);
            }
        }
        Response response = this.f49295k;
        if (response != null) {
            com.squareup.okhttp.internal.g.c(response.body());
        } else {
            this.f49286b.d();
        }
        return this.f49286b;
    }

    public final HttpStream h() throws RouteException, RequestException, IOException {
        return this.f49286b.k(this.f49285a.getConnectTimeout(), this.f49285a.getReadTimeout(), this.f49285a.getWriteTimeout(), this.f49285a.getRetryOnConnectionFailure(), !this.f49293i.method().equals("GET"));
    }

    public Request j() throws IOException {
        String strHeader;
        HttpUrl httpUrlResolve;
        if (this.f49295k == null) {
            throw new IllegalStateException();
        }
        jo.a aVarC = this.f49286b.c();
        Route route = aVarC != null ? aVarC.getRoute() : null;
        Proxy proxy = route != null ? route.getProxy() : this.f49285a.getProxy();
        int iCode = this.f49295k.code();
        String strMethod = this.f49292h.method();
        if (iCode != 307 && iCode != 308) {
            if (iCode != 401) {
                if (iCode != 407) {
                    switch (iCode) {
                        case NOTICE_VALUE:
                        case 301:
                        case 302:
                        case 303:
                            break;
                        default:
                            return null;
                    }
                } else if (proxy.type() != Proxy.Type.HTTP) {
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                }
            }
            return OkHeaders.j(this.f49285a.getAuthenticator(), this.f49295k, proxy);
        }
        if (!strMethod.equals("GET") && !strMethod.equals("HEAD")) {
            return null;
        }
        if (!this.f49285a.getFollowRedirects() || (strHeader = this.f49295k.header(HttpHeaders.LOCATION)) == null || (httpUrlResolve = this.f49292h.httpUrl().resolve(strHeader)) == null) {
            return null;
        }
        if (!httpUrlResolve.scheme().equals(this.f49292h.httpUrl().scheme()) && !this.f49285a.getFollowSslRedirects()) {
            return null;
        }
        Request.Builder builderNewBuilder = this.f49292h.newBuilder();
        if (h.b(strMethod)) {
            if (h.c(strMethod)) {
                builderNewBuilder.method("GET", null);
            } else {
                builderNewBuilder.method(strMethod, null);
            }
            builderNewBuilder.removeHeader("Transfer-Encoding");
            builderNewBuilder.removeHeader(HttpHeaders.CONTENT_LENGTH);
            builderNewBuilder.removeHeader(HttpHeaders.CONTENT_TYPE);
        }
        if (!x(httpUrlResolve)) {
            builderNewBuilder.removeHeader(HttpHeaders.AUTHORIZATION);
        }
        return builderNewBuilder.url(httpUrlResolve).build();
    }

    public Connection k() {
        return this.f49286b.c();
    }

    public Request l() {
        return this.f49292h;
    }

    public Response m() {
        Response response = this.f49295k;
        if (response != null) {
            return response;
        }
        throw new IllegalStateException();
    }

    public final void o() throws IOException {
        InternalCache internalCache = com.squareup.okhttp.internal.c.instance.internalCache(this.f49285a);
        if (internalCache == null) {
            return;
        }
        if (com.squareup.okhttp.internal.http.b.a(this.f49295k, this.f49293i)) {
            this.f49300p = internalCache.put(z(this.f49295k));
        } else if (h.a(this.f49293i.method())) {
            try {
                internalCache.remove(this.f49293i);
            } catch (IOException unused) {
            }
        }
    }

    public final Request p(Request request) throws IOException {
        Request.Builder builderNewBuilder = request.newBuilder();
        if (request.header(HttpHeaders.HOST) == null) {
            builderNewBuilder.header(HttpHeaders.HOST, com.squareup.okhttp.internal.g.i(request.httpUrl()));
        }
        if (request.header("Connection") == null) {
            builderNewBuilder.header("Connection", "Keep-Alive");
        }
        if (request.header("Accept-Encoding") == null) {
            this.f49290f = true;
            builderNewBuilder.header("Accept-Encoding", "gzip");
        }
        CookieHandler cookieHandler = this.f49285a.getCookieHandler();
        if (cookieHandler != null) {
            OkHeaders.a(builderNewBuilder, cookieHandler.get(request.uri(), OkHeaders.l(builderNewBuilder.build().headers(), null)));
        }
        if (request.header("User-Agent") == null) {
            builderNewBuilder.header("User-Agent", com.squareup.okhttp.internal.h.a());
        }
        return builderNewBuilder.build();
    }

    public boolean q(Request request) {
        return h.b(request.method());
    }

    public final Response r() throws IOException {
        this.f49288d.finishRequest();
        Response responseBuild = this.f49288d.readResponseHeaders().request(this.f49293i).handshake(this.f49286b.c().getHandshake()).header(OkHeaders.f49221c, Long.toString(this.f49289e)).header(OkHeaders.f49222d, Long.toString(System.currentTimeMillis())).build();
        if (!this.f49299o) {
            responseBuild = responseBuild.newBuilder().body(this.f49288d.openResponseBody(responseBuild)).build();
        }
        if (CampaignEx.JSON_NATIVE_VIDEO_CLOSE.equalsIgnoreCase(responseBuild.request().header("Connection")) || CampaignEx.JSON_NATIVE_VIDEO_CLOSE.equalsIgnoreCase(responseBuild.header("Connection"))) {
            this.f49286b.l();
        }
        return responseBuild;
    }

    public void s() throws IOException {
        Response responseR;
        if (this.f49295k != null) {
            return;
        }
        Request request = this.f49293i;
        if (request == null && this.f49294j == null) {
            throw new IllegalStateException("call sendRequest() first!");
        }
        if (request == null) {
            return;
        }
        if (this.f49299o) {
            this.f49288d.writeRequestHeaders(request);
            responseR = r();
        } else if (this.f49298n) {
            BufferedSink bufferedSink = this.f49297m;
            if (bufferedSink != null && bufferedSink.buffer().size() > 0) {
                this.f49297m.emit();
            }
            if (this.f49289e == -1) {
                if (OkHeaders.d(this.f49293i) == -1) {
                    Sink sink = this.f49296l;
                    if (sink instanceof k) {
                        this.f49293i = this.f49293i.newBuilder().header(HttpHeaders.CONTENT_LENGTH, Long.toString(((k) sink).a())).build();
                    }
                }
                this.f49288d.writeRequestHeaders(this.f49293i);
            }
            Sink sink2 = this.f49296l;
            if (sink2 != null) {
                BufferedSink bufferedSink2 = this.f49297m;
                if (bufferedSink2 != null) {
                    bufferedSink2.close();
                } else {
                    sink2.close();
                }
                Sink sink3 = this.f49296l;
                if (sink3 instanceof k) {
                    this.f49288d.writeRequestBody((k) sink3);
                }
            }
            responseR = r();
        } else {
            responseR = new c(0, request).proceed(this.f49293i);
        }
        t(responseR.headers());
        Response response = this.f49294j;
        if (response != null) {
            if (B(response, responseR)) {
                this.f49295k = this.f49294j.newBuilder().request(this.f49292h).priorResponse(z(this.f49287c)).headers(g(this.f49294j.headers(), responseR.headers())).cacheResponse(z(this.f49294j)).networkResponse(z(responseR)).build();
                responseR.body().close();
                w();
                InternalCache internalCache = com.squareup.okhttp.internal.c.instance.internalCache(this.f49285a);
                internalCache.trackConditionalCacheHit();
                internalCache.update(this.f49294j, z(this.f49295k));
                this.f49295k = A(this.f49295k);
                return;
            }
            com.squareup.okhttp.internal.g.c(this.f49294j.body());
        }
        Response responseBuild = responseR.newBuilder().request(this.f49292h).priorResponse(z(this.f49287c)).cacheResponse(z(this.f49294j)).networkResponse(z(responseR)).build();
        this.f49295k = responseBuild;
        if (n(responseBuild)) {
            o();
            this.f49295k = A(d(this.f49300p, this.f49295k));
        }
    }

    public void t(Headers headers) throws IOException {
        CookieHandler cookieHandler = this.f49285a.getCookieHandler();
        if (cookieHandler != null) {
            cookieHandler.put(this.f49292h.uri(), OkHeaders.l(headers, null));
        }
    }

    public g u(RouteException routeException) {
        if (!this.f49286b.m(routeException) || !this.f49285a.getRetryOnConnectionFailure()) {
            return null;
        }
        return new g(this.f49285a, this.f49292h, this.f49291g, this.f49298n, this.f49299o, f(), (k) this.f49296l, this.f49287c);
    }

    public g v(IOException iOException, Sink sink) {
        if (!this.f49286b.n(iOException, sink) || !this.f49285a.getRetryOnConnectionFailure()) {
            return null;
        }
        return new g(this.f49285a, this.f49292h, this.f49291g, this.f49298n, this.f49299o, f(), (k) sink, this.f49287c);
    }

    public void w() throws IOException {
        this.f49286b.o();
    }

    public boolean x(HttpUrl httpUrl) {
        HttpUrl httpUrl2 = this.f49292h.httpUrl();
        return httpUrl2.host().equals(httpUrl.host()) && httpUrl2.port() == httpUrl.port() && httpUrl2.scheme().equals(httpUrl.scheme());
    }

    public void y() throws RouteException, IOException, RequestException {
        if (this.f49301q != null) {
            return;
        }
        if (this.f49288d != null) {
            throw new IllegalStateException();
        }
        Request requestP = p(this.f49292h);
        InternalCache internalCache = com.squareup.okhttp.internal.c.instance.internalCache(this.f49285a);
        Response response = internalCache != null ? internalCache.get(requestP) : null;
        com.squareup.okhttp.internal.http.b bVarC = new com.squareup.okhttp.internal.http.b.C0536b(System.currentTimeMillis(), requestP, response).c();
        this.f49301q = bVarC;
        this.f49293i = bVarC.f49226a;
        this.f49294j = bVarC.f49227b;
        if (internalCache != null) {
            internalCache.trackResponse(bVarC);
        }
        if (response != null && this.f49294j == null) {
            com.squareup.okhttp.internal.g.c(response.body());
        }
        if (this.f49293i == null) {
            Response response2 = this.f49294j;
            if (response2 != null) {
                this.f49295k = response2.newBuilder().request(this.f49292h).priorResponse(z(this.f49287c)).cacheResponse(z(this.f49294j)).build();
            } else {
                this.f49295k = new Response.Builder().request(this.f49292h).priorResponse(z(this.f49287c)).protocol(Protocol.HTTP_1_1).code(504).message("Unsatisfiable Request (only-if-cached)").body(f49284r).build();
            }
            this.f49295k = A(this.f49295k);
            return;
        }
        HttpStream httpStreamH = h();
        this.f49288d = httpStreamH;
        httpStreamH.setHttpEngine(this);
        if (this.f49298n && q(this.f49293i) && this.f49296l == null) {
            long jD = OkHeaders.d(requestP);
            if (!this.f49291g) {
                this.f49288d.writeRequestHeaders(this.f49293i);
                this.f49296l = this.f49288d.createRequestBody(this.f49293i, jD);
            } else {
                if (jD > 2147483647L) {
                    throw new IllegalStateException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for requests larger than 2 GiB.");
                }
                if (jD == -1) {
                    this.f49296l = new k();
                } else {
                    this.f49288d.writeRequestHeaders(this.f49293i);
                    this.f49296l = new k((int) jD);
                }
            }
        }
    }
}
