package androidx.media3.datasource;

import android.net.Uri;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.Nullable;
import c4.g;
import c4.j;
import c4.o;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.google.common.base.n;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;
import com.google.common.collect.u;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class c extends c4.a implements HttpDataSource {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f9598e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f9599f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f9600g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public final String f9601h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public final HttpDataSource.b f9602i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final HttpDataSource.b f9603j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f9604k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    public n<String> f9605l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    public g f9606m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    public HttpURLConnection f9607n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    public InputStream f9608o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f9609p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f9610q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f9611r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f9612s;

    /* JADX INFO: compiled from: source.java */
    public static final class b implements HttpDataSource.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public o f9614b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public n<String> f9615c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public String f9616d;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f9619g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f9620h;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final HttpDataSource.b f9613a = new HttpDataSource.b();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f9617e = 8000;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f9618f = 8000;

        @Override // androidx.media3.datasource.a.InterfaceC0090a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public c createDataSource() {
            c cVar = new c(this.f9616d, this.f9617e, this.f9618f, this.f9619g, this.f9613a, this.f9615c, this.f9620h);
            o oVar = this.f9614b;
            if (oVar != null) {
                cVar.c(oVar);
            }
            return cVar;
        }

        public b b(Map<String, String> map) {
            this.f9613a.a(map);
            return this;
        }

        public b c(@Nullable String str) {
            this.f9616d = str;
            return this;
        }
    }

    /* JADX INFO: renamed from: androidx.media3.datasource.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0091c extends u<String, List<String>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<String, List<String>> f9621a;

        public C0091c(Map<String, List<String>> map) {
            this.f9621a = map;
        }

        public static /* synthetic */ boolean x(Map.Entry entry) {
            return entry.getKey() != null;
        }

        public static /* synthetic */ boolean y(String str) {
            return str != null;
        }

        @Override // com.google.common.collect.u, java.util.Map
        public boolean containsKey(@Nullable Object obj) {
            return obj != null && super.containsKey(obj);
        }

        @Override // com.google.common.collect.u, java.util.Map
        public boolean containsValue(@Nullable Object obj) {
            return super.standardContainsValue(obj);
        }

        @Override // com.google.common.collect.u, com.google.common.collect.x
        /* JADX INFO: renamed from: delegate */
        public Map<String, List<String>> u() {
            return this.f9621a;
        }

        @Override // com.google.common.collect.u, java.util.Map
        public Set<Map.Entry<String, List<String>>> entrySet() {
            return Sets.b(super.entrySet(), new n() { // from class: c4.h
                @Override // com.google.common.base.n
                public final boolean apply(Object obj) {
                    return androidx.media3.datasource.c.C0091c.x((Map.Entry) obj);
                }
            });
        }

        @Override // com.google.common.collect.u, java.util.Map
        public boolean equals(@Nullable Object obj) {
            return obj != null && super.standardEquals(obj);
        }

        @Override // com.google.common.collect.u, java.util.Map
        public int hashCode() {
            return super.standardHashCode();
        }

        @Override // com.google.common.collect.u, java.util.Map
        public boolean isEmpty() {
            if (super.isEmpty()) {
                return true;
            }
            return super.size() == 1 && super.containsKey(null);
        }

        @Override // com.google.common.collect.u, java.util.Map
        public Set<String> keySet() {
            return Sets.b(super.keySet(), new n() { // from class: c4.i
                @Override // com.google.common.base.n
                public final boolean apply(Object obj) {
                    return androidx.media3.datasource.c.C0091c.y((String) obj);
                }
            });
        }

        @Override // com.google.common.collect.u, java.util.Map
        public int size() {
            return super.size() - (super.containsKey(null) ? 1 : 0);
        }

        @Override // com.google.common.collect.u, java.util.Map
        @Nullable
        /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
        public List<String> get(@Nullable Object obj) {
            if (obj == null) {
                return null;
            }
            return (List) super.get(obj);
        }
    }

    public c(@Nullable String str, int i11, int i12, boolean z11, @Nullable HttpDataSource.b bVar, @Nullable n<String> nVar, boolean z12) {
        super(true);
        this.f9601h = str;
        this.f9599f = i11;
        this.f9600g = i12;
        this.f9598e = z11;
        this.f9602i = bVar;
        this.f9605l = nVar;
        this.f9603j = new HttpDataSource.b();
        this.f9604k = z12;
    }

    public static boolean j(HttpURLConnection httpURLConnection) {
        return "gzip".equalsIgnoreCase(httpURLConnection.getHeaderField(HttpHeaders.CONTENT_ENCODING));
    }

    public static void m(@Nullable HttpURLConnection httpURLConnection, long j11) {
        int i11;
        if (httpURLConnection == null || (i11 = u0.f81838a) < 19 || i11 > 20) {
            return;
        }
        try {
            InputStream inputStream = httpURLConnection.getInputStream();
            if (j11 == -1) {
                if (inputStream.read() == -1) {
                    return;
                }
            } else if (j11 <= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) {
                return;
            }
            String name = inputStream.getClass().getName();
            if ("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream".equals(name) || "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream".equals(name)) {
                Method declaredMethod = ((Class) z3.a.e(inputStream.getClass().getSuperclass())).getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(inputStream, new Object[0]);
            }
        } catch (Exception unused) {
        }
    }

    @Override // androidx.media3.datasource.a
    public long a(g gVar) throws HttpDataSource.HttpDataSourceException {
        byte[] bArrU1;
        this.f9606m = gVar;
        long j11 = 0;
        this.f9612s = 0L;
        this.f9611r = 0L;
        f(gVar);
        try {
            HttpURLConnection httpURLConnectionK = k(gVar);
            this.f9607n = httpURLConnectionK;
            this.f9610q = httpURLConnectionK.getResponseCode();
            String responseMessage = httpURLConnectionK.getResponseMessage();
            int i11 = this.f9610q;
            if (i11 < 200 || i11 > 299) {
                Map<String, List<String>> headerFields = httpURLConnectionK.getHeaderFields();
                if (this.f9610q == 416) {
                    if (gVar.f14604g == j.c(httpURLConnectionK.getHeaderField("Content-Range"))) {
                        this.f9609p = true;
                        g(gVar);
                        long j12 = gVar.f14605h;
                        if (j12 != -1) {
                            return j12;
                        }
                        return 0L;
                    }
                }
                InputStream errorStream = httpURLConnectionK.getErrorStream();
                try {
                    bArrU1 = errorStream != null ? u0.u1(errorStream) : u0.f81843f;
                } catch (IOException unused) {
                    bArrU1 = u0.f81843f;
                }
                byte[] bArr = bArrU1;
                h();
                throw new HttpDataSource.InvalidResponseCodeException(this.f9610q, responseMessage, this.f9610q == 416 ? new DataSourceException(2008) : null, headerFields, gVar, bArr);
            }
            String contentType = httpURLConnectionK.getContentType();
            n<String> nVar = this.f9605l;
            if (nVar != null && !nVar.apply(contentType)) {
                h();
                throw new HttpDataSource.InvalidContentTypeException(contentType, gVar);
            }
            if (this.f9610q == 200) {
                long j13 = gVar.f14604g;
                if (j13 != 0) {
                    j11 = j13;
                }
            }
            boolean zJ = j(httpURLConnectionK);
            if (zJ) {
                this.f9611r = gVar.f14605h;
            } else {
                long j14 = gVar.f14605h;
                if (j14 != -1) {
                    this.f9611r = j14;
                } else {
                    long jB = j.b(httpURLConnectionK.getHeaderField(HttpHeaders.CONTENT_LENGTH), httpURLConnectionK.getHeaderField("Content-Range"));
                    this.f9611r = jB != -1 ? jB - j11 : -1L;
                }
            }
            try {
                this.f9608o = httpURLConnectionK.getInputStream();
                if (zJ) {
                    this.f9608o = new GZIPInputStream(this.f9608o);
                }
                this.f9609p = true;
                g(gVar);
                try {
                    p(j11, gVar);
                    return this.f9611r;
                } catch (IOException e11) {
                    h();
                    if (e11 instanceof HttpDataSource.HttpDataSourceException) {
                        throw ((HttpDataSource.HttpDataSourceException) e11);
                    }
                    throw new HttpDataSource.HttpDataSourceException(e11, gVar, 2000, 1);
                }
            } catch (IOException e12) {
                h();
                throw new HttpDataSource.HttpDataSourceException(e12, gVar, 2000, 1);
            }
        } catch (IOException e13) {
            h();
            throw HttpDataSource.HttpDataSourceException.createForIOException(e13, gVar, 1);
        }
    }

    @Override // androidx.media3.datasource.a
    public void close() throws HttpDataSource.HttpDataSourceException {
        try {
            InputStream inputStream = this.f9608o;
            if (inputStream != null) {
                long j11 = this.f9611r;
                long j12 = -1;
                if (j11 != -1) {
                    j12 = j11 - this.f9612s;
                }
                m(this.f9607n, j12);
                try {
                    inputStream.close();
                } catch (IOException e11) {
                    throw new HttpDataSource.HttpDataSourceException(e11, (g) u0.i(this.f9606m), 2000, 3);
                }
            }
            this.f9608o = null;
            h();
            if (this.f9609p) {
                this.f9609p = false;
                e();
            }
        } catch (Throwable th2) {
            this.f9608o = null;
            h();
            if (this.f9609p) {
                this.f9609p = false;
                e();
            }
            throw th2;
        }
    }

    @Override // c4.a, androidx.media3.datasource.a
    public Map<String, List<String>> getResponseHeaders() {
        HttpURLConnection httpURLConnection = this.f9607n;
        return httpURLConnection == null ? ImmutableMap.of() : new C0091c(httpURLConnection.getHeaderFields());
    }

    @Override // androidx.media3.datasource.a
    @Nullable
    public Uri getUri() {
        HttpURLConnection httpURLConnection = this.f9607n;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    public final void h() {
        HttpURLConnection httpURLConnection = this.f9607n;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e11) {
                z3.o.d("DefaultHttpDataSource", "Unexpected error while disconnecting", e11);
            }
            this.f9607n = null;
        }
    }

    public final URL i(URL url, @Nullable String str, g gVar) throws HttpDataSource.HttpDataSourceException {
        if (str == null) {
            throw new HttpDataSource.HttpDataSourceException("Null location redirect", gVar, 2001, 1);
        }
        try {
            URL url2 = new URL(url, str);
            String protocol = url2.getProtocol();
            if (!"https".equals(protocol) && !HttpHost.DEFAULT_SCHEME_NAME.equals(protocol)) {
                throw new HttpDataSource.HttpDataSourceException("Unsupported protocol redirect: " + protocol, gVar, 2001, 1);
            }
            if (this.f9598e || protocol.equals(url.getProtocol())) {
                return url2;
            }
            throw new HttpDataSource.HttpDataSourceException("Disallowed cross-protocol redirect (" + url.getProtocol() + " to " + protocol + ")", gVar, 2001, 1);
        } catch (MalformedURLException e11) {
            throw new HttpDataSource.HttpDataSourceException(e11, gVar, 2001, 1);
        }
    }

    public final HttpURLConnection k(g gVar) throws IOException {
        URL url = new URL(gVar.f14598a.toString());
        int i11 = gVar.f14600c;
        byte[] bArr = gVar.f14601d;
        long j11 = gVar.f14604g;
        long j12 = gVar.f14605h;
        boolean zD = gVar.d(1);
        if (!this.f9598e && !this.f9604k) {
            return l(url, i11, bArr, j11, j12, zD, true, gVar.f14602e);
        }
        int i12 = 0;
        URL urlI = url;
        int i13 = i11;
        byte[] bArr2 = bArr;
        while (true) {
            int i14 = i12 + 1;
            if (i12 > 20) {
                throw new HttpDataSource.HttpDataSourceException(new NoRouteToHostException("Too many redirects: " + i14), gVar, 2001, 1);
            }
            long j13 = j11;
            long j14 = j11;
            int i15 = i13;
            URL url2 = urlI;
            long j15 = j12;
            HttpURLConnection httpURLConnectionL = l(urlI, i13, bArr2, j13, j12, zD, false, gVar.f14602e);
            int responseCode = httpURLConnectionL.getResponseCode();
            String headerField = httpURLConnectionL.getHeaderField(HttpHeaders.LOCATION);
            if ((i15 == 1 || i15 == 3) && (responseCode == 300 || responseCode == 301 || responseCode == 302 || responseCode == 303 || responseCode == 307 || responseCode == 308)) {
                httpURLConnectionL.disconnect();
                urlI = i(url2, headerField, gVar);
                i13 = i15;
            } else {
                if (i15 != 2 || (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303)) {
                    return httpURLConnectionL;
                }
                httpURLConnectionL.disconnect();
                if (this.f9604k && responseCode == 302) {
                    i13 = i15;
                } else {
                    bArr2 = null;
                    i13 = 1;
                }
                urlI = i(url2, headerField, gVar);
            }
            i12 = i14;
            j11 = j14;
            j12 = j15;
        }
    }

    public final HttpURLConnection l(URL url, int i11, @Nullable byte[] bArr, long j11, long j12, boolean z11, boolean z12, Map<String, String> map) throws IOException {
        HttpURLConnection httpURLConnectionN = n(url);
        httpURLConnectionN.setConnectTimeout(this.f9599f);
        httpURLConnectionN.setReadTimeout(this.f9600g);
        HashMap map2 = new HashMap();
        HttpDataSource.b bVar = this.f9602i;
        if (bVar != null) {
            map2.putAll(bVar.b());
        }
        map2.putAll(this.f9603j.b());
        map2.putAll(map);
        for (Map.Entry entry : map2.entrySet()) {
            httpURLConnectionN.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        String strA = j.a(j11, j12);
        if (strA != null) {
            httpURLConnectionN.setRequestProperty("Range", strA);
        }
        String str = this.f9601h;
        if (str != null) {
            httpURLConnectionN.setRequestProperty("User-Agent", str);
        }
        httpURLConnectionN.setRequestProperty("Accept-Encoding", z11 ? "gzip" : "identity");
        httpURLConnectionN.setInstanceFollowRedirects(z12);
        httpURLConnectionN.setDoOutput(bArr != null);
        httpURLConnectionN.setRequestMethod(g.c(i11));
        if (bArr != null) {
            httpURLConnectionN.setFixedLengthStreamingMode(bArr.length);
            httpURLConnectionN.connect();
            OutputStream outputStream = httpURLConnectionN.getOutputStream();
            outputStream.write(bArr);
            outputStream.close();
        } else {
            httpURLConnectionN.connect();
        }
        return httpURLConnectionN;
    }

    public HttpURLConnection n(URL url) throws IOException {
        return (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection()));
    }

    public final int o(byte[] bArr, int i11, int i12) throws IOException {
        if (i12 == 0) {
            return 0;
        }
        long j11 = this.f9611r;
        if (j11 != -1) {
            long j12 = j11 - this.f9612s;
            if (j12 == 0) {
                return -1;
            }
            i12 = (int) Math.min(i12, j12);
        }
        int i13 = ((InputStream) u0.i(this.f9608o)).read(bArr, i11, i12);
        if (i13 == -1) {
            return -1;
        }
        this.f9612s += (long) i13;
        d(i13);
        return i13;
    }

    public final void p(long j11, g gVar) throws IOException {
        if (j11 == 0) {
            return;
        }
        byte[] bArr = new byte[4096];
        while (j11 > 0) {
            int i11 = ((InputStream) u0.i(this.f9608o)).read(bArr, 0, (int) Math.min(j11, 4096));
            if (Thread.currentThread().isInterrupted()) {
                throw new HttpDataSource.HttpDataSourceException(new InterruptedIOException(), gVar, 2000, 1);
            }
            if (i11 == -1) {
                throw new HttpDataSource.HttpDataSourceException(gVar, 2008, 1);
            }
            j11 -= (long) i11;
            d(i11);
        }
    }

    @Override // androidx.media3.common.l
    public int read(byte[] bArr, int i11, int i12) throws HttpDataSource.HttpDataSourceException {
        try {
            return o(bArr, i11, i12);
        } catch (IOException e11) {
            throw HttpDataSource.HttpDataSourceException.createForIOException(e11, (g) u0.i(this.f9606m), 2);
        }
    }
}
