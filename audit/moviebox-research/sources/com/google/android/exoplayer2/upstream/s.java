package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.Nullable;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.google.android.exoplayer2.util.o0;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;
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

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class s extends f {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f35492e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f35493f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f35494g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public final String f35495h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public final w f35496i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final w f35497j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f35498k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    public com.google.common.base.n<String> f35499l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    public n f35500m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    public HttpURLConnection f35501n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    public InputStream f35502o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f35503p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f35504q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f35505r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f35506s;

    /* JADX INFO: compiled from: source.java */
    public static final class b implements k.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public k0 f35508b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public com.google.common.base.n<String> f35509c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public String f35510d;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f35513g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f35514h;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final w f35507a = new w();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f35511e = 8000;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f35512f = 8000;

        @Override // com.google.android.exoplayer2.upstream.k.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public s createDataSource() {
            s sVar = new s(this.f35510d, this.f35511e, this.f35512f, this.f35513g, this.f35507a, this.f35509c, this.f35514h);
            k0 k0Var = this.f35508b;
            if (k0Var != null) {
                sVar.e(k0Var);
            }
            return sVar;
        }

        public b b(@Nullable String str) {
            this.f35510d = str;
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c extends com.google.common.collect.u<String, List<String>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<String, List<String>> f35515a;

        public c(Map<String, List<String>> map) {
            this.f35515a = map;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean x(Map.Entry entry) {
            return entry.getKey() != null;
        }

        /* JADX INFO: Access modifiers changed from: private */
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
            return this.f35515a;
        }

        @Override // com.google.common.collect.u, java.util.Map
        public Set<Map.Entry<String, List<String>>> entrySet() {
            return Sets.b(super.entrySet(), new com.google.common.base.n() { // from class: com.google.android.exoplayer2.upstream.u
                @Override // com.google.common.base.n
                public final boolean apply(Object obj) {
                    return s.c.x((Map.Entry) obj);
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
            return Sets.b(super.keySet(), new com.google.common.base.n() { // from class: com.google.android.exoplayer2.upstream.t
                @Override // com.google.common.base.n
                public final boolean apply(Object obj) {
                    return s.c.y((String) obj);
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

    public s(@Nullable String str, int i11, int i12, boolean z11, @Nullable w wVar, @Nullable com.google.common.base.n<String> nVar, boolean z12) {
        super(true);
        this.f35495h = str;
        this.f35493f = i11;
        this.f35494g = i12;
        this.f35492e = z11;
        this.f35496i = wVar;
        this.f35499l = nVar;
        this.f35497j = new w();
        this.f35498k = z12;
    }

    public static boolean n(HttpURLConnection httpURLConnection) {
        return "gzip".equalsIgnoreCase(httpURLConnection.getHeaderField(HttpHeaders.CONTENT_ENCODING));
    }

    public static void q(@Nullable HttpURLConnection httpURLConnection, long j11) {
        int i11;
        if (httpURLConnection == null || (i11 = o0.f35608a) < 19 || i11 > 20) {
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
                Method declaredMethod = ((Class) com.google.android.exoplayer2.util.a.e(inputStream.getClass().getSuperclass())).getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(inputStream, new Object[0]);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public long a(final n nVar) throws HttpDataSource$HttpDataSourceException {
        byte[] bArrZ0;
        this.f35500m = nVar;
        long j11 = 0;
        this.f35506s = 0L;
        this.f35505r = 0L;
        j(nVar);
        try {
            HttpURLConnection httpURLConnectionO = o(nVar);
            this.f35501n = httpURLConnectionO;
            this.f35504q = httpURLConnectionO.getResponseCode();
            String responseMessage = httpURLConnectionO.getResponseMessage();
            int i11 = this.f35504q;
            if (i11 < 200 || i11 > 299) {
                Map<String, List<String>> headerFields = httpURLConnectionO.getHeaderFields();
                if (this.f35504q == 416) {
                    if (nVar.f35428g == x.c(httpURLConnectionO.getHeaderField("Content-Range"))) {
                        this.f35503p = true;
                        k(nVar);
                        long j12 = nVar.f35429h;
                        if (j12 != -1) {
                            return j12;
                        }
                        return 0L;
                    }
                }
                InputStream errorStream = httpURLConnectionO.getErrorStream();
                try {
                    bArrZ0 = errorStream != null ? o0.Z0(errorStream) : o0.f35613f;
                } catch (IOException unused) {
                    bArrZ0 = o0.f35613f;
                }
                byte[] bArr = bArrZ0;
                l();
                throw new HttpDataSource$InvalidResponseCodeException(this.f35504q, responseMessage, this.f35504q == 416 ? new DataSourceException(2008) : null, headerFields, nVar, bArr);
            }
            final String contentType = httpURLConnectionO.getContentType();
            com.google.common.base.n<String> nVar2 = this.f35499l;
            if (nVar2 != null && !nVar2.apply(contentType)) {
                l();
                throw new HttpDataSource$HttpDataSourceException(contentType, nVar) { // from class: com.google.android.exoplayer2.upstream.HttpDataSource$InvalidContentTypeException
                    public final String contentType;

                    {
                        super("Invalid content type: " + contentType, nVar, 2003, 1);
                        this.contentType = contentType;
                    }
                };
            }
            if (this.f35504q == 200) {
                long j13 = nVar.f35428g;
                if (j13 != 0) {
                    j11 = j13;
                }
            }
            boolean zN = n(httpURLConnectionO);
            if (zN) {
                this.f35505r = nVar.f35429h;
            } else {
                long j14 = nVar.f35429h;
                if (j14 != -1) {
                    this.f35505r = j14;
                } else {
                    long jB = x.b(httpURLConnectionO.getHeaderField(HttpHeaders.CONTENT_LENGTH), httpURLConnectionO.getHeaderField("Content-Range"));
                    this.f35505r = jB != -1 ? jB - j11 : -1L;
                }
            }
            try {
                this.f35502o = httpURLConnectionO.getInputStream();
                if (zN) {
                    this.f35502o = new GZIPInputStream(this.f35502o);
                }
                this.f35503p = true;
                k(nVar);
                try {
                    t(j11, nVar);
                    return this.f35505r;
                } catch (IOException e11) {
                    l();
                    if (e11 instanceof HttpDataSource$HttpDataSourceException) {
                        throw ((HttpDataSource$HttpDataSourceException) e11);
                    }
                    throw new HttpDataSource$HttpDataSourceException(e11, nVar, 2000, 1);
                }
            } catch (IOException e12) {
                l();
                throw new HttpDataSource$HttpDataSourceException(e12, nVar, 2000, 1);
            }
        } catch (IOException e13) {
            l();
            throw HttpDataSource$HttpDataSourceException.createForIOException(e13, nVar, 1);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public void close() throws HttpDataSource$HttpDataSourceException {
        try {
            InputStream inputStream = this.f35502o;
            if (inputStream != null) {
                long j11 = this.f35505r;
                long j12 = -1;
                if (j11 != -1) {
                    j12 = j11 - this.f35506s;
                }
                q(this.f35501n, j12);
                try {
                    inputStream.close();
                } catch (IOException e11) {
                    throw new HttpDataSource$HttpDataSourceException(e11, (n) o0.j(this.f35500m), 2000, 3);
                }
            }
            this.f35502o = null;
            l();
            if (this.f35503p) {
                this.f35503p = false;
                i();
            }
        } catch (Throwable th2) {
            this.f35502o = null;
            l();
            if (this.f35503p) {
                this.f35503p = false;
                i();
            }
            throw th2;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.f, com.google.android.exoplayer2.upstream.k
    public Map<String, List<String>> getResponseHeaders() {
        HttpURLConnection httpURLConnection = this.f35501n;
        return httpURLConnection == null ? ImmutableMap.of() : new c(httpURLConnection.getHeaderFields());
    }

    @Override // com.google.android.exoplayer2.upstream.k
    @Nullable
    public Uri getUri() {
        HttpURLConnection httpURLConnection = this.f35501n;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    public final void l() {
        HttpURLConnection httpURLConnection = this.f35501n;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e11) {
                com.google.android.exoplayer2.util.s.d("DefaultHttpDataSource", "Unexpected error while disconnecting", e11);
            }
            this.f35501n = null;
        }
    }

    public final URL m(URL url, @Nullable String str, n nVar) throws HttpDataSource$HttpDataSourceException {
        if (str == null) {
            throw new HttpDataSource$HttpDataSourceException("Null location redirect", nVar, 2001, 1);
        }
        try {
            URL url2 = new URL(url, str);
            String protocol = url2.getProtocol();
            if (!"https".equals(protocol) && !HttpHost.DEFAULT_SCHEME_NAME.equals(protocol)) {
                throw new HttpDataSource$HttpDataSourceException("Unsupported protocol redirect: " + protocol, nVar, 2001, 1);
            }
            if (this.f35492e || protocol.equals(url.getProtocol())) {
                return url2;
            }
            throw new HttpDataSource$HttpDataSourceException("Disallowed cross-protocol redirect (" + url.getProtocol() + " to " + protocol + ")", nVar, 2001, 1);
        } catch (MalformedURLException e11) {
            throw new HttpDataSource$HttpDataSourceException(e11, nVar, 2001, 1);
        }
    }

    public final HttpURLConnection o(n nVar) throws IOException {
        URL url = new URL(nVar.f35422a.toString());
        int i11 = nVar.f35424c;
        byte[] bArr = nVar.f35425d;
        long j11 = nVar.f35428g;
        long j12 = nVar.f35429h;
        boolean zD = nVar.d(1);
        if (!this.f35492e && !this.f35498k) {
            return p(url, i11, bArr, j11, j12, zD, true, nVar.f35426e);
        }
        int i12 = 0;
        URL urlM = url;
        int i13 = i11;
        byte[] bArr2 = bArr;
        while (true) {
            int i14 = i12 + 1;
            if (i12 > 20) {
                throw new HttpDataSource$HttpDataSourceException(new NoRouteToHostException("Too many redirects: " + i14), nVar, 2001, 1);
            }
            long j13 = j11;
            long j14 = j11;
            int i15 = i13;
            URL url2 = urlM;
            long j15 = j12;
            HttpURLConnection httpURLConnectionP = p(urlM, i13, bArr2, j13, j12, zD, false, nVar.f35426e);
            int responseCode = httpURLConnectionP.getResponseCode();
            String headerField = httpURLConnectionP.getHeaderField(HttpHeaders.LOCATION);
            if ((i15 == 1 || i15 == 3) && (responseCode == 300 || responseCode == 301 || responseCode == 302 || responseCode == 303 || responseCode == 307 || responseCode == 308)) {
                httpURLConnectionP.disconnect();
                urlM = m(url2, headerField, nVar);
                i13 = i15;
            } else {
                if (i15 != 2 || (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303)) {
                    return httpURLConnectionP;
                }
                httpURLConnectionP.disconnect();
                if (this.f35498k && responseCode == 302) {
                    i13 = i15;
                } else {
                    bArr2 = null;
                    i13 = 1;
                }
                urlM = m(url2, headerField, nVar);
            }
            i12 = i14;
            j11 = j14;
            j12 = j15;
        }
    }

    public final HttpURLConnection p(URL url, int i11, @Nullable byte[] bArr, long j11, long j12, boolean z11, boolean z12, Map<String, String> map) throws IOException {
        HttpURLConnection httpURLConnectionR = r(url);
        httpURLConnectionR.setConnectTimeout(this.f35493f);
        httpURLConnectionR.setReadTimeout(this.f35494g);
        HashMap map2 = new HashMap();
        w wVar = this.f35496i;
        if (wVar != null) {
            map2.putAll(wVar.a());
        }
        map2.putAll(this.f35497j.a());
        map2.putAll(map);
        for (Map.Entry entry : map2.entrySet()) {
            httpURLConnectionR.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        String strA = x.a(j11, j12);
        if (strA != null) {
            httpURLConnectionR.setRequestProperty("Range", strA);
        }
        String str = this.f35495h;
        if (str != null) {
            httpURLConnectionR.setRequestProperty("User-Agent", str);
        }
        httpURLConnectionR.setRequestProperty("Accept-Encoding", z11 ? "gzip" : "identity");
        httpURLConnectionR.setInstanceFollowRedirects(z12);
        httpURLConnectionR.setDoOutput(bArr != null);
        httpURLConnectionR.setRequestMethod(n.c(i11));
        if (bArr != null) {
            httpURLConnectionR.setFixedLengthStreamingMode(bArr.length);
            httpURLConnectionR.connect();
            OutputStream outputStream = httpURLConnectionR.getOutputStream();
            outputStream.write(bArr);
            outputStream.close();
        } else {
            httpURLConnectionR.connect();
        }
        return httpURLConnectionR;
    }

    public HttpURLConnection r(URL url) throws IOException {
        return (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection()));
    }

    @Override // com.google.android.exoplayer2.upstream.g
    public int read(byte[] bArr, int i11, int i12) throws HttpDataSource$HttpDataSourceException {
        try {
            return s(bArr, i11, i12);
        } catch (IOException e11) {
            throw HttpDataSource$HttpDataSourceException.createForIOException(e11, (n) o0.j(this.f35500m), 2);
        }
    }

    public final int s(byte[] bArr, int i11, int i12) throws IOException {
        if (i12 == 0) {
            return 0;
        }
        long j11 = this.f35505r;
        if (j11 != -1) {
            long j12 = j11 - this.f35506s;
            if (j12 == 0) {
                return -1;
            }
            i12 = (int) Math.min(i12, j12);
        }
        int i13 = ((InputStream) o0.j(this.f35502o)).read(bArr, i11, i12);
        if (i13 == -1) {
            return -1;
        }
        this.f35506s += (long) i13;
        h(i13);
        return i13;
    }

    public final void t(long j11, n nVar) throws IOException {
        if (j11 == 0) {
            return;
        }
        byte[] bArr = new byte[4096];
        while (j11 > 0) {
            int i11 = ((InputStream) o0.j(this.f35502o)).read(bArr, 0, (int) Math.min(j11, 4096));
            if (Thread.currentThread().isInterrupted()) {
                throw new HttpDataSource$HttpDataSourceException(new InterruptedIOException(), nVar, 2000, 1);
            }
            if (i11 == -1) {
                throw new HttpDataSource$HttpDataSourceException(nVar, 2008, 1);
            }
            j11 -= (long) i11;
            h(i11);
        }
    }
}
