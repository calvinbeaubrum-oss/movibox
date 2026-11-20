package com.amazonaws.http;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class UrlHttpClient implements HttpClient {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Log f15739c = LogFactory.b(UrlHttpClient.class);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ClientConfiguration f15740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SSLContext f15741b = null;

    /* JADX INFO: compiled from: source.java */
    public final class CurlBuilder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final URL f15742a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f15743b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final HashMap<String, String> f15744c = new HashMap<>();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f15745d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f15746e = false;

        public CurlBuilder(URL url) {
            if (url == null) {
                throw new IllegalArgumentException("Must have a valid url");
            }
            this.f15742a = url;
        }

        public String a() {
            if (!b()) {
                throw new IllegalStateException("Invalid state, cannot create curl command");
            }
            StringBuilder sb2 = new StringBuilder("curl");
            if (this.f15743b != null) {
                sb2.append(" -X ");
                sb2.append(this.f15743b);
            }
            for (Map.Entry<String, String> entry : this.f15744c.entrySet()) {
                sb2.append(" -H \"");
                sb2.append(entry.getKey());
                sb2.append(":");
                sb2.append(entry.getValue());
                sb2.append("\"");
            }
            if (this.f15745d != null) {
                sb2.append(" -d '");
                sb2.append(this.f15745d);
                sb2.append("'");
            }
            sb2.append(" ");
            sb2.append(this.f15742a.toString());
            return sb2.toString();
        }

        public boolean b() {
            return !this.f15746e;
        }

        public CurlBuilder c(String str) {
            this.f15745d = str;
            return this;
        }

        public CurlBuilder d(boolean z11) {
            this.f15746e = z11;
            return this;
        }

        public CurlBuilder e(Map<String, String> map) {
            this.f15744c.clear();
            this.f15744c.putAll(map);
            return this;
        }

        public CurlBuilder f(String str) {
            this.f15743b = str;
            return this;
        }
    }

    public UrlHttpClient(ClientConfiguration clientConfiguration) {
        this.f15740a = clientConfiguration;
    }

    @Override // com.amazonaws.http.HttpClient
    public HttpResponse a(HttpRequest httpRequest) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(httpRequest.e().toURL().openConnection()));
        CurlBuilder curlBuilder = this.f15740a.j() ? new CurlBuilder(httpRequest.e().toURL()) : null;
        c(httpRequest, httpURLConnection);
        b(httpRequest, httpURLConnection, curlBuilder);
        h(httpRequest, httpURLConnection, curlBuilder);
        if (curlBuilder != null) {
            if (curlBuilder.b()) {
                f(curlBuilder.a());
            } else {
                f("Failed to create curl, content too long");
            }
        }
        return d(httpRequest, httpURLConnection);
    }

    public HttpURLConnection b(HttpRequest httpRequest, HttpURLConnection httpURLConnection, CurlBuilder curlBuilder) throws ProtocolException {
        if (httpRequest.c() != null && !httpRequest.c().isEmpty()) {
            if (curlBuilder != null) {
                curlBuilder.e(httpRequest.c());
            }
            for (Map.Entry<String, String> entry : httpRequest.c().entrySet()) {
                String key = entry.getKey();
                if (!key.equals(HttpHeaders.CONTENT_LENGTH) && !key.equals(HttpHeaders.HOST)) {
                    key.equals("Expect");
                    httpURLConnection.setRequestProperty(key, entry.getValue());
                }
            }
        }
        String strD = httpRequest.d();
        httpURLConnection.setRequestMethod(strD);
        if (curlBuilder != null) {
            curlBuilder.f(strD);
        }
        return httpURLConnection;
    }

    public void c(HttpRequest httpRequest, HttpURLConnection httpURLConnection) {
        httpURLConnection.setConnectTimeout(this.f15740a.a());
        httpURLConnection.setReadTimeout(this.f15740a.f());
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setUseCaches(false);
        if (httpRequest.f()) {
            httpURLConnection.setChunkedStreamingMode(0);
        }
        if (httpURLConnection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            if (this.f15740a.g() != null) {
                e(httpsURLConnection);
            }
        }
    }

    public HttpResponse d(HttpRequest httpRequest, HttpURLConnection httpURLConnection) throws IOException {
        String responseMessage = httpURLConnection.getResponseMessage();
        int responseCode = httpURLConnection.getResponseCode();
        InputStream errorStream = httpURLConnection.getErrorStream();
        if (errorStream == null && !"HEAD".equals(httpRequest.d())) {
            try {
                errorStream = httpURLConnection.getInputStream();
            } catch (IOException unused) {
            }
        }
        HttpResponse.Builder builderB = HttpResponse.a().d(responseCode).e(responseMessage).b(errorStream);
        for (Map.Entry<String, List<String>> entry : httpURLConnection.getHeaderFields().entrySet()) {
            if (entry.getKey() != null) {
                builderB.c(entry.getKey(), entry.getValue().get(0));
            }
        }
        return builderB.a();
    }

    public final void e(HttpsURLConnection httpsURLConnection) {
        if (this.f15741b == null) {
            TrustManager[] trustManagerArr = {this.f15740a.g()};
            try {
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                this.f15741b = sSLContext;
                sSLContext.init(null, trustManagerArr, null);
            } catch (GeneralSecurityException e11) {
                throw new RuntimeException(e11);
            }
        }
        httpsURLConnection.setSSLSocketFactory(this.f15741b.getSocketFactory());
    }

    public void f(String str) {
        f15739c.a(str);
    }

    public final void g(InputStream inputStream, OutputStream outputStream, CurlBuilder curlBuilder, ByteBuffer byteBuffer) throws IOException {
        byte[] bArr = new byte[8192];
        while (true) {
            int i11 = inputStream.read(bArr);
            if (i11 == -1) {
                return;
            }
            if (byteBuffer != null) {
                try {
                    byteBuffer.put(bArr, 0, i11);
                } catch (BufferOverflowException unused) {
                    curlBuilder.d(true);
                }
            }
            outputStream.write(bArr, 0, i11);
        }
    }

    public void h(HttpRequest httpRequest, HttpURLConnection httpURLConnection, CurlBuilder curlBuilder) throws IOException {
        ByteBuffer byteBufferAllocate;
        if (httpRequest.a() == null || httpRequest.b() < 0) {
            return;
        }
        httpURLConnection.setDoOutput(true);
        if (!httpRequest.f()) {
            httpURLConnection.setFixedLengthStreamingMode((int) httpRequest.b());
        }
        OutputStream outputStream = httpURLConnection.getOutputStream();
        if (curlBuilder == null) {
            byteBufferAllocate = null;
        } else if (httpRequest.b() < 2147483647L) {
            byteBufferAllocate = ByteBuffer.allocate((int) httpRequest.b());
        } else {
            curlBuilder.d(true);
            byteBufferAllocate = null;
        }
        g(httpRequest.a(), outputStream, curlBuilder, byteBufferAllocate);
        if (curlBuilder != null && byteBufferAllocate != null && byteBufferAllocate.position() != 0) {
            curlBuilder.c(new String(byteBufferAllocate.array(), "UTF-8"));
        }
        outputStream.flush();
        outputStream.close();
    }

    @Override // com.amazonaws.http.HttpClient
    public void shutdown() {
    }
}
