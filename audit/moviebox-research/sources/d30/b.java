package d30;

import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.hisavana.common.constant.ComConstants;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.jsoup.Connection;
import org.jsoup.HttpStatusException;
import org.jsoup.UnsupportedMimeTypeException;
import org.jsoup.nodes.Document;
import org.jsoup.parser.e;
import org.jsoup.parser.g;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class b implements Connection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Connection.c f62894a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Connection.d f62895b = new d();

    /* JADX INFO: renamed from: d30.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static abstract class AbstractC0645b<T extends Connection.a> implements Connection.a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public URL f62896a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Connection.Method f62897b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Map<String, List<String>> f62898c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Map<String, String> f62899d;

        public AbstractC0645b() {
            this.f62898c = new LinkedHashMap();
            this.f62899d = new LinkedHashMap();
        }

        /* JADX WARN: Code duplicated, block: B:17:0x0029  */
        public static boolean F(byte[] bArr) {
            int i11;
            int i12;
            if (bArr.length >= 3 && (bArr[0] & 255) == 239) {
                i11 = (((bArr[1] & 255) == 187) && ((bArr[2] & 255) == 191)) ? 3 : 0;
            }
            int length = bArr.length;
            while (i11 < length) {
                byte b11 = bArr[i11];
                if ((b11 & 128) != 0) {
                    if ((b11 & 224) == 192) {
                        i12 = i11 + 1;
                    } else if ((b11 & 240) == 224) {
                        i12 = i11 + 2;
                    } else {
                        if ((b11 & 248) != 240) {
                            return false;
                        }
                        i12 = i11 + 3;
                    }
                    while (i11 < i12) {
                        i11++;
                        if ((bArr[i11] & 192) != 128) {
                            return false;
                        }
                    }
                }
                i11++;
            }
            return true;
        }

        public static String z(String str) {
            try {
                byte[] bytes = str.getBytes("ISO-8859-1");
                return !F(bytes) ? str : new String(bytes, "UTF-8");
            } catch (UnsupportedEncodingException unused) {
                return str;
            }
        }

        public final List<String> A(String str) {
            d30.d.j(str);
            for (Map.Entry<String, List<String>> entry : this.f62898c.entrySet()) {
                if (str.equalsIgnoreCase(entry.getKey())) {
                    return entry.getValue();
                }
            }
            return Collections.emptyList();
        }

        public boolean B(String str) {
            d30.d.i(str, "Cookie name must not be empty");
            return this.f62899d.containsKey(str);
        }

        public boolean C(String str, String str2) {
            d30.d.h(str);
            d30.d.h(str2);
            Iterator<String> it = E(str).iterator();
            while (it.hasNext()) {
                if (str2.equalsIgnoreCase(it.next())) {
                    return true;
                }
            }
            return false;
        }

        public String D(String str) {
            d30.d.k(str, "Header name must not be null");
            List<String> listA = A(str);
            if (listA.size() > 0) {
                return d30.c.i(listA, ", ");
            }
            return null;
        }

        public List<String> E(String str) {
            d30.d.h(str);
            return A(str);
        }

        public final Map.Entry<String, List<String>> G(String str) {
            String strA = e30.b.a(str);
            for (Map.Entry<String, List<String>> entry : this.f62898c.entrySet()) {
                if (e30.b.a(entry.getKey()).equals(strA)) {
                    return entry;
                }
            }
            return null;
        }

        @Override // org.jsoup.Connection.a
        public URL f() {
            return this.f62896a;
        }

        @Override // org.jsoup.Connection.a
        public T h(String str, String str2) {
            d30.d.i(str, "Cookie name must not be empty");
            d30.d.k(str2, "Cookie value must not be null");
            this.f62899d.put(str, str2);
            return this;
        }

        @Override // org.jsoup.Connection.a
        public Map<String, String> k() {
            return this.f62899d;
        }

        @Override // org.jsoup.Connection.a
        public Connection.Method method() {
            return this.f62897b;
        }

        @Override // org.jsoup.Connection.a
        public T n(String str) {
            d30.d.i(str, "Header name must not be empty");
            Map.Entry<String, List<String>> entryG = G(str);
            if (entryG != null) {
                this.f62898c.remove(entryG.getKey());
            }
            return this;
        }

        @Override // org.jsoup.Connection.a
        public T p(URL url) {
            d30.d.k(url, "URL must not be null");
            this.f62896a = url;
            return this;
        }

        @Override // org.jsoup.Connection.a
        public T q(String str, String str2) {
            d30.d.i(str, "Header name must not be empty");
            n(str);
            y(str, str2);
            return this;
        }

        @Override // org.jsoup.Connection.a
        public T r(Connection.Method method) {
            d30.d.k(method, "Method must not be null");
            this.f62897b = method;
            return this;
        }

        @Override // org.jsoup.Connection.a
        public boolean s(String str) {
            d30.d.i(str, "Header name must not be empty");
            return A(str).size() != 0;
        }

        @Override // org.jsoup.Connection.a
        public Map<String, List<String>> u() {
            return this.f62898c;
        }

        public T y(String str, String str2) {
            d30.d.h(str);
            if (str2 == null) {
                str2 = "";
            }
            List<String> listE = E(str);
            if (listE.isEmpty()) {
                listE = new ArrayList<>();
                this.f62898c.put(str, listE);
            }
            listE.add(z(str2));
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c extends AbstractC0645b<Connection.c> implements Connection.c {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Proxy f62900e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f62901f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f62902g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f62903h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Collection<Connection.b> f62904i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f62905j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f62906k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f62907l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public e f62908m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f62909n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f62910o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public String f62911p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public SSLSocketFactory f62912q;

        public c() {
            super();
            this.f62905j = null;
            this.f62906k = false;
            this.f62907l = false;
            this.f62909n = false;
            this.f62910o = true;
            this.f62911p = "UTF-8";
            this.f62901f = ComConstants.AD_TIMEOUT_MILLIS;
            this.f62902g = 1048576;
            this.f62903h = true;
            this.f62904i = new ArrayList();
            this.f62897b = Connection.Method.GET;
            y("Accept-Encoding", "gzip");
            y("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.143 Safari/537.36");
            this.f62908m = e.a();
        }

        @Override // d30.b.AbstractC0645b
        public /* bridge */ /* synthetic */ List E(String str) {
            return super.E(str);
        }

        @Override // org.jsoup.Connection.c
        /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
        public c o(e eVar) {
            this.f62908m = eVar;
            this.f62909n = true;
            return this;
        }

        @Override // org.jsoup.Connection.c
        public Connection.c a(boolean z11) {
            this.f62907l = z11;
            return this;
        }

        @Override // org.jsoup.Connection.c
        public boolean b() {
            return this.f62906k;
        }

        @Override // org.jsoup.Connection.c
        public String c() {
            return this.f62911p;
        }

        @Override // org.jsoup.Connection.c
        public Connection.c d(String str) {
            this.f62905j = str;
            return this;
        }

        @Override // org.jsoup.Connection.c
        public boolean e() {
            return this.f62910o;
        }

        @Override // d30.b.AbstractC0645b, org.jsoup.Connection.a
        public /* bridge */ /* synthetic */ URL f() {
            return super.f();
        }

        @Override // org.jsoup.Connection.c
        public SSLSocketFactory g() {
            return this.f62912q;
        }

        @Override // org.jsoup.Connection.c
        public Proxy i() {
            return this.f62900e;
        }

        @Override // org.jsoup.Connection.c
        public Collection<Connection.b> j() {
            return this.f62904i;
        }

        @Override // d30.b.AbstractC0645b, org.jsoup.Connection.a
        public /* bridge */ /* synthetic */ Map k() {
            return super.k();
        }

        @Override // org.jsoup.Connection.c
        public boolean l() {
            return this.f62903h;
        }

        @Override // d30.b.AbstractC0645b, org.jsoup.Connection.a
        public /* bridge */ /* synthetic */ Connection.Method method() {
            return super.method();
        }

        @Override // d30.b.AbstractC0645b, org.jsoup.Connection.a
        public /* bridge */ /* synthetic */ boolean s(String str) {
            return super.s(str);
        }

        @Override // org.jsoup.Connection.c
        public boolean t() {
            return this.f62907l;
        }

        @Override // org.jsoup.Connection.c
        public int timeout() {
            return this.f62901f;
        }

        @Override // d30.b.AbstractC0645b, org.jsoup.Connection.a
        public /* bridge */ /* synthetic */ Map u() {
            return super.u();
        }

        @Override // org.jsoup.Connection.c
        public String v() {
            return this.f62905j;
        }

        @Override // org.jsoup.Connection.c
        public int w() {
            return this.f62902g;
        }

        @Override // org.jsoup.Connection.c
        public e x() {
            return this.f62908m;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class d extends AbstractC0645b<Connection.d> implements Connection.d {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static SSLSocketFactory f62913o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final Pattern f62914p = Pattern.compile("(application|text)/\\w*\\+?xml.*");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f62915e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f62916f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public ByteBuffer f62917g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public InputStream f62918h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f62919i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f62920j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f62921k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f62922l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f62923m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public Connection.c f62924n;

        /* JADX INFO: compiled from: source.java */
        public class a implements HostnameVerifier {
            @Override // javax.net.ssl.HostnameVerifier
            public boolean verify(String str, SSLSession sSLSession) {
                return true;
            }
        }

        /* JADX INFO: renamed from: d30.b$d$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public class C0646b implements X509TrustManager {
            @Override // javax.net.ssl.X509TrustManager
            public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
            }

            @Override // javax.net.ssl.X509TrustManager
            public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            }

            @Override // javax.net.ssl.X509TrustManager
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        }

        public d() {
            super();
            this.f62921k = false;
            this.f62922l = false;
            this.f62923m = 0;
        }

        public d(d dVar) throws IOException {
            super();
            this.f62921k = false;
            this.f62922l = false;
            this.f62923m = 0;
            if (dVar != null) {
                int i11 = dVar.f62923m + 1;
                this.f62923m = i11;
                if (i11 >= 20) {
                    throw new IOException(String.format("Too many redirects occurred trying to load URL %s", dVar.f()));
                }
            }
        }

        public static HttpURLConnection I(Connection.c cVar) throws IOException {
            HttpURLConnection httpURLConnection = (HttpURLConnection) (cVar.i() == null ? (URLConnection) FirebasePerfUrlConnection.instrument(cVar.f().openConnection()) : (URLConnection) FirebasePerfUrlConnection.instrument(cVar.f().openConnection(cVar.i())));
            httpURLConnection.setRequestMethod(cVar.method().name());
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setConnectTimeout(cVar.timeout());
            httpURLConnection.setReadTimeout(cVar.timeout() / 2);
            if (httpURLConnection instanceof HttpsURLConnection) {
                SSLSocketFactory sSLSocketFactoryG = cVar.g();
                if (sSLSocketFactoryG != null) {
                    ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(sSLSocketFactoryG);
                } else if (!cVar.e()) {
                    O();
                    HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
                    httpsURLConnection.setSSLSocketFactory(f62913o);
                    httpsURLConnection.setHostnameVerifier(M());
                }
            }
            if (cVar.method().hasBody()) {
                httpURLConnection.setDoOutput(true);
            }
            if (cVar.k().size() > 0) {
                httpURLConnection.addRequestProperty("Cookie", N(cVar));
            }
            for (Map.Entry<String, List<String>> entry : cVar.u().entrySet()) {
                Iterator<String> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    httpURLConnection.addRequestProperty(entry.getKey(), it.next());
                }
            }
            return httpURLConnection;
        }

        public static LinkedHashMap<String, List<String>> J(HttpURLConnection httpURLConnection) {
            LinkedHashMap<String, List<String>> linkedHashMap = new LinkedHashMap<>();
            int i11 = 0;
            while (true) {
                String headerFieldKey = httpURLConnection.getHeaderFieldKey(i11);
                String headerField = httpURLConnection.getHeaderField(i11);
                if (headerFieldKey == null && headerField == null) {
                    return linkedHashMap;
                }
                i11++;
                if (headerFieldKey != null && headerField != null) {
                    if (linkedHashMap.containsKey(headerFieldKey)) {
                        linkedHashMap.get(headerFieldKey).add(headerField);
                    } else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(headerField);
                        linkedHashMap.put(headerFieldKey, arrayList);
                    }
                }
            }
        }

        public static d K(Connection.c cVar) throws IOException {
            return L(cVar, null);
        }

        /* JADX WARN: Code duplicated, block: B:26:0x0082 A[Catch: IOException -> 0x008a, TryCatch #0 {IOException -> 0x008a, blocks: (B:24:0x0079, B:26:0x0082, B:29:0x008d, B:31:0x00a1, B:35:0x00ab, B:36:0x00bf, B:38:0x00c5, B:40:0x00cd, B:42:0x00d6, B:43:0x00da, B:44:0x00f3, B:46:0x00f9, B:47:0x010f, B:55:0x0122, B:57:0x0128, B:59:0x012e, B:61:0x0136, B:64:0x0143, B:65:0x0152, B:67:0x0155, B:69:0x0161, B:71:0x0165, B:73:0x016e, B:74:0x0175, B:76:0x0183, B:78:0x018b, B:80:0x0193, B:82:0x019c, B:84:0x01a6, B:88:0x01c6, B:85:0x01b0, B:87:0x01b8, B:81:0x0198, B:89:0x01df, B:53:0x011c, B:92:0x01e8, B:93:0x01f7), top: B:96:0x0079 }] */
        /* JADX WARN: Code duplicated, block: B:89:0x01df A[Catch: IOException -> 0x008a, TRY_LEAVE, TryCatch #0 {IOException -> 0x008a, blocks: (B:24:0x0079, B:26:0x0082, B:29:0x008d, B:31:0x00a1, B:35:0x00ab, B:36:0x00bf, B:38:0x00c5, B:40:0x00cd, B:42:0x00d6, B:43:0x00da, B:44:0x00f3, B:46:0x00f9, B:47:0x010f, B:55:0x0122, B:57:0x0128, B:59:0x012e, B:61:0x0136, B:64:0x0143, B:65:0x0152, B:67:0x0155, B:69:0x0161, B:71:0x0165, B:73:0x016e, B:74:0x0175, B:76:0x0183, B:78:0x018b, B:80:0x0193, B:82:0x019c, B:84:0x01a6, B:88:0x01c6, B:85:0x01b0, B:87:0x01b8, B:81:0x0198, B:89:0x01df, B:53:0x011c, B:92:0x01e8, B:93:0x01f7), top: B:96:0x0079 }] */
        public static d L(Connection.c cVar, d dVar) throws IOException {
            String strS;
            HttpURLConnection httpURLConnectionI;
            int responseCode;
            d dVar2;
            String strH;
            d30.d.k(cVar, "Request must not be null");
            String protocol = cVar.f().getProtocol();
            if (!protocol.equals(HttpHost.DEFAULT_SCHEME_NAME) && !protocol.equals("https")) {
                throw new MalformedURLException("Only http & https protocols supported");
            }
            boolean zHasBody = cVar.method().hasBody();
            boolean z11 = cVar.v() != null;
            if (!zHasBody) {
                d30.d.c(z11, "Cannot set a request body for HTTP method " + cVar.method());
            }
            try {
                if (cVar.j().size() <= 0 || (zHasBody && !z11)) {
                    strS = zHasBody ? S(cVar) : null;
                    long jNanoTime = System.nanoTime();
                    httpURLConnectionI = I(cVar);
                    httpURLConnectionI.connect();
                    if (httpURLConnectionI.getDoOutput()) {
                        U(cVar, httpURLConnectionI.getOutputStream(), strS);
                    }
                    responseCode = httpURLConnectionI.getResponseCode();
                    dVar2 = new d(dVar);
                    dVar2.T(httpURLConnectionI, dVar);
                    dVar2.f62924n = cVar;
                    if (!dVar2.s(HttpHeaders.LOCATION) && cVar.l()) {
                        if (responseCode != 307) {
                            cVar.r(Connection.Method.GET);
                            cVar.j().clear();
                            cVar.d(null);
                            cVar.n(HttpHeaders.CONTENT_TYPE);
                        }
                        String strD = dVar2.D(HttpHeaders.LOCATION);
                        if (strD != null && strD.startsWith("http:/") && strD.charAt(6) != '/') {
                            strD = strD.substring(6);
                        }
                        cVar.p(b.h(d30.c.n(cVar.f(), strD)));
                        for (Map.Entry<String, String> entry : dVar2.f62899d.entrySet()) {
                            cVar.h(entry.getKey(), entry.getValue());
                        }
                        return L(cVar, dVar2);
                    }
                    if ((responseCode >= 200 || responseCode >= 400) && !cVar.b()) {
                        throw new HttpStatusException("HTTP error fetching URL", responseCode, cVar.f().toString());
                    }
                    strH = dVar2.H();
                    if (strH != null && !cVar.t() && !strH.startsWith("text/") && !f62914p.matcher(strH).matches()) {
                        throw new UnsupportedMimeTypeException("Unhandled content type. Must be text/*, application/xml, or application/xhtml+xml", strH, cVar.f().toString());
                    }
                    if (strH != null && f62914p.matcher(strH).matches() && (cVar instanceof c) && !((c) cVar).f62909n) {
                        cVar.o(e.g());
                    }
                    dVar2.f62919i = d30.a.d(dVar2.f62920j);
                    if (httpURLConnectionI.getContentLength() != 0 || cVar.method() == Connection.Method.HEAD) {
                        dVar2.f62917g = d30.a.c();
                    } else {
                        dVar2.f62918h = null;
                        dVar2.f62918h = httpURLConnectionI.getErrorStream() != null ? httpURLConnectionI.getErrorStream() : httpURLConnectionI.getInputStream();
                        if (dVar2.C(HttpHeaders.CONTENT_ENCODING, "gzip")) {
                            dVar2.f62918h = new GZIPInputStream(dVar2.f62918h);
                        } else if (dVar2.C(HttpHeaders.CONTENT_ENCODING, "deflate")) {
                            dVar2.f62918h = new InflaterInputStream(dVar2.f62918h, new Inflater(true));
                        }
                        dVar2.f62918h = e30.a.d(dVar2.f62918h, 32768, cVar.w()).c(jNanoTime, cVar.timeout());
                    }
                    dVar2.f62921k = true;
                    return dVar2;
                }
                R(cVar);
                httpURLConnectionI.connect();
                if (httpURLConnectionI.getDoOutput()) {
                    U(cVar, httpURLConnectionI.getOutputStream(), strS);
                }
                responseCode = httpURLConnectionI.getResponseCode();
                dVar2 = new d(dVar);
                dVar2.T(httpURLConnectionI, dVar);
                dVar2.f62924n = cVar;
                if (!dVar2.s(HttpHeaders.LOCATION)) {
                }
                if (responseCode >= 200) {
                    throw new HttpStatusException("HTTP error fetching URL", responseCode, cVar.f().toString());
                }
                throw new HttpStatusException("HTTP error fetching URL", responseCode, cVar.f().toString());
                strH = dVar2.H();
                if (strH != null) {
                    throw new UnsupportedMimeTypeException("Unhandled content type. Must be text/*, application/xml, or application/xhtml+xml", strH, cVar.f().toString());
                }
                if (strH != null) {
                    cVar.o(e.g());
                }
                dVar2.f62919i = d30.a.d(dVar2.f62920j);
                if (httpURLConnectionI.getContentLength() != 0) {
                    dVar2.f62917g = d30.a.c();
                } else {
                    dVar2.f62917g = d30.a.c();
                }
                dVar2.f62921k = true;
                return dVar2;
            } catch (IOException e11) {
                httpURLConnectionI.disconnect();
                throw e11;
            }
            long jNanoTime2 = System.nanoTime();
            httpURLConnectionI = I(cVar);
        }

        public static HostnameVerifier M() {
            return new a();
        }

        public static String N(Connection.c cVar) {
            StringBuilder sbO = d30.c.o();
            boolean z11 = true;
            for (Map.Entry<String, String> entry : cVar.k().entrySet()) {
                if (z11) {
                    z11 = false;
                } else {
                    sbO.append("; ");
                }
                sbO.append(entry.getKey());
                sbO.append('=');
                sbO.append(entry.getValue());
            }
            return sbO.toString();
        }

        public static synchronized void O() throws IOException {
            if (f62913o == null) {
                TrustManager[] trustManagerArr = {new C0646b()};
                try {
                    SSLContext sSLContext = SSLContext.getInstance("SSL");
                    sSLContext.init(null, trustManagerArr, new SecureRandom());
                    f62913o = sSLContext.getSocketFactory();
                } catch (KeyManagementException | NoSuchAlgorithmException unused) {
                    throw new IOException("Can't create unsecure trust manager");
                }
            }
        }

        public static void R(Connection.c cVar) throws IOException {
            boolean z11;
            URL urlF = cVar.f();
            StringBuilder sbO = d30.c.o();
            sbO.append(urlF.getProtocol());
            sbO.append("://");
            sbO.append(urlF.getAuthority());
            sbO.append(urlF.getPath());
            sbO.append("?");
            if (urlF.getQuery() != null) {
                sbO.append(urlF.getQuery());
                z11 = false;
            } else {
                z11 = true;
            }
            for (Connection.b bVar : cVar.j()) {
                d30.d.c(bVar.b(), "InputStream data not supported in URL query string.");
                if (z11) {
                    z11 = false;
                } else {
                    sbO.append('&');
                }
                sbO.append(URLEncoder.encode(bVar.a(), "UTF-8"));
                sbO.append('=');
                sbO.append(URLEncoder.encode(bVar.value(), "UTF-8"));
            }
            cVar.p(new URL(sbO.toString()));
            cVar.j().clear();
        }

        public static String S(Connection.c cVar) {
            if (!cVar.s(HttpHeaders.CONTENT_TYPE)) {
                if (b.j(cVar)) {
                    String strE = d30.a.e();
                    cVar.q(HttpHeaders.CONTENT_TYPE, "multipart/form-data; boundary=" + strE);
                    return strE;
                }
                cVar.q(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded; charset=" + cVar.c());
            }
            return null;
        }

        public static void U(Connection.c cVar, OutputStream outputStream, String str) throws IOException {
            Collection<Connection.b> collectionJ = cVar.j();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, cVar.c()));
            if (str != null) {
                for (Connection.b bVar : collectionJ) {
                    bufferedWriter.write("--");
                    bufferedWriter.write(str);
                    bufferedWriter.write("\r\n");
                    bufferedWriter.write("Content-Disposition: form-data; name=\"");
                    bufferedWriter.write(b.f(bVar.a()));
                    bufferedWriter.write("\"");
                    if (bVar.b()) {
                        bufferedWriter.write("; filename=\"");
                        bufferedWriter.write(b.f(bVar.value()));
                        bufferedWriter.write("\"\r\nContent-Type: ");
                        bufferedWriter.write(bVar.z() != null ? bVar.z() : OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
                        bufferedWriter.write("\r\n\r\n");
                        bufferedWriter.flush();
                        d30.a.a(bVar.inputStream(), outputStream);
                        outputStream.flush();
                    } else {
                        bufferedWriter.write("\r\n\r\n");
                        bufferedWriter.write(bVar.value());
                    }
                    bufferedWriter.write("\r\n");
                }
                bufferedWriter.write("--");
                bufferedWriter.write(str);
                bufferedWriter.write("--");
            } else if (cVar.v() != null) {
                bufferedWriter.write(cVar.v());
            } else {
                boolean z11 = true;
                for (Connection.b bVar2 : collectionJ) {
                    if (z11) {
                        z11 = false;
                    } else {
                        bufferedWriter.append('&');
                    }
                    bufferedWriter.write(URLEncoder.encode(bVar2.a(), cVar.c()));
                    bufferedWriter.write(61);
                    bufferedWriter.write(URLEncoder.encode(bVar2.value(), cVar.c()));
                }
            }
            bufferedWriter.close();
        }

        @Override // d30.b.AbstractC0645b
        public /* bridge */ /* synthetic */ boolean B(String str) {
            return super.B(str);
        }

        @Override // d30.b.AbstractC0645b
        public /* bridge */ /* synthetic */ boolean C(String str, String str2) {
            return super.C(str, str2);
        }

        @Override // d30.b.AbstractC0645b
        public /* bridge */ /* synthetic */ String D(String str) {
            return super.D(str);
        }

        @Override // d30.b.AbstractC0645b
        public /* bridge */ /* synthetic */ List E(String str) {
            return super.E(str);
        }

        public String H() {
            return this.f62920j;
        }

        public void P(Map<String, List<String>> map) {
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key != null) {
                    List<String> value = entry.getValue();
                    if (key.equalsIgnoreCase("Set-Cookie")) {
                        for (String str : value) {
                            if (str != null) {
                                g gVar = new g(str);
                                String strTrim = gVar.b("=").trim();
                                String strTrim2 = gVar.g(";").trim();
                                if (strTrim.length() > 0) {
                                    h(strTrim, strTrim2);
                                }
                            }
                        }
                    }
                    Iterator<String> it = value.iterator();
                    while (it.hasNext()) {
                        y(key, it.next());
                    }
                }
            }
        }

        public final void Q() {
            InputStream inputStream = this.f62918h;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                } finally {
                    this.f62918h = null;
                }
            }
        }

        public final void T(HttpURLConnection httpURLConnection, Connection.d dVar) throws IOException {
            this.f62897b = Connection.Method.valueOf(httpURLConnection.getRequestMethod());
            this.f62896a = httpURLConnection.getURL();
            this.f62915e = httpURLConnection.getResponseCode();
            this.f62916f = httpURLConnection.getResponseMessage();
            this.f62920j = httpURLConnection.getContentType();
            P(J(httpURLConnection));
            if (dVar != null) {
                for (Map.Entry<String, String> entry : dVar.k().entrySet()) {
                    if (!B(entry.getKey())) {
                        h(entry.getKey(), entry.getValue());
                    }
                }
            }
        }

        @Override // d30.b.AbstractC0645b, org.jsoup.Connection.a
        public /* bridge */ /* synthetic */ URL f() {
            return super.f();
        }

        @Override // d30.b.AbstractC0645b, org.jsoup.Connection.a
        public /* bridge */ /* synthetic */ Map k() {
            return super.k();
        }

        @Override // org.jsoup.Connection.d
        public Document m() throws IOException {
            d30.d.e(this.f62921k, "Request must be executed (with .execute(), .get(), or .post() before parsing response");
            if (this.f62917g != null) {
                this.f62918h = new ByteArrayInputStream(this.f62917g.array());
                this.f62922l = false;
            }
            d30.d.c(this.f62922l, "Input stream already read and parsed, cannot re-read.");
            Document documentF = d30.a.f(this.f62918h, this.f62919i, this.f62896a.toExternalForm(), this.f62924n.x());
            this.f62919i = documentF.j1().a().name();
            this.f62922l = true;
            Q();
            return documentF;
        }

        @Override // d30.b.AbstractC0645b, org.jsoup.Connection.a
        public /* bridge */ /* synthetic */ boolean s(String str) {
            return super.s(str);
        }
    }

    public static Connection e(String str) {
        b bVar = new b();
        bVar.b(str);
        return bVar;
    }

    public static String f(String str) {
        if (str == null) {
            return null;
        }
        return str.replaceAll("\"", "%22");
    }

    public static String g(String str) {
        try {
            return h(new URL(str)).toExternalForm();
        } catch (Exception unused) {
            return str;
        }
    }

    public static URL h(URL url) {
        try {
            return new URL(new URI(url.toExternalForm().replaceAll(" ", "%20")).toASCIIString());
        } catch (Exception unused) {
            return url;
        }
    }

    public static boolean j(Connection.c cVar) {
        Iterator<Connection.b> it = cVar.j().iterator();
        while (it.hasNext()) {
            if (it.next().b()) {
                return true;
            }
        }
        return false;
    }

    @Override // org.jsoup.Connection
    public Connection a(boolean z11) {
        this.f62894a.a(z11);
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection b(String str) {
        d30.d.i(str, "Must supply a valid URL");
        try {
            this.f62894a.p(new URL(g(str)));
            return this;
        } catch (MalformedURLException e11) {
            throw new IllegalArgumentException("Malformed URL: " + str, e11);
        }
    }

    @Override // org.jsoup.Connection
    public Document get() throws IOException {
        this.f62894a.r(Connection.Method.GET);
        i();
        return this.f62895b.m();
    }

    public Connection.d i() throws IOException {
        d dVarK = d.K(this.f62894a);
        this.f62895b = dVarK;
        return dVarK;
    }
}
