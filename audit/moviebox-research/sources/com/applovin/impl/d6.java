package com.applovin.impl;

import android.net.Uri;
import android.support.v4.media.session.PlaybackStateCompat;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.applovin.exoplayer2.common.base.Predicate;
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
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class d6 extends a2 implements qa {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f18372e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f18373f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f18374g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f18375h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final qa.f f18376i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final qa.f f18377j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f18378k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Predicate f18379l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private l5 f18380m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private HttpURLConnection f18381n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private InputStream f18382o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f18383p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f18384q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private long f18385r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private long f18386s;

    /* JADX INFO: compiled from: source.java */
    public static final class b implements qa.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private xo f18388b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Predicate f18389c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f18390d;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f18393g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f18394h;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final qa.f f18387a = new qa.f();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f18391e = 8000;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f18392f = 8000;

        public b a(String str) {
            this.f18390d = str;
            return this;
        }

        @Override // com.applovin.impl.qa.b, com.applovin.impl.i5.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public d6 a() {
            d6 d6Var = new d6(this.f18390d, this.f18391e, this.f18392f, this.f18393g, this.f18387a, this.f18389c, this.f18394h);
            xo xoVar = this.f18388b;
            if (xoVar != null) {
                d6Var.a(xoVar);
            }
            return d6Var;
        }
    }

    private d6(String str, int i11, int i12, boolean z11, qa.f fVar, Predicate predicate, boolean z12) {
        super(true);
        this.f18375h = str;
        this.f18373f = i11;
        this.f18374g = i12;
        this.f18372e = z11;
        this.f18376i = fVar;
        this.f18379l = predicate;
        this.f18377j = new qa.f();
        this.f18378k = z12;
    }

    private HttpURLConnection a(URL url, int i11, byte[] bArr, long j11, long j12, boolean z11, boolean z12, Map map) throws IOException {
        HttpURLConnection httpURLConnectionA = a(url);
        httpURLConnectionA.setConnectTimeout(this.f18373f);
        httpURLConnectionA.setReadTimeout(this.f18374g);
        HashMap map2 = new HashMap();
        qa.f fVar = this.f18376i;
        if (fVar != null) {
            map2.putAll(fVar.a());
        }
        map2.putAll(this.f18377j.a());
        map2.putAll(map);
        for (Map.Entry entry : map2.entrySet()) {
            httpURLConnectionA.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        String strA = sa.a(j11, j12);
        if (strA != null) {
            httpURLConnectionA.setRequestProperty("Range", strA);
        }
        String str = this.f18375h;
        if (str != null) {
            httpURLConnectionA.setRequestProperty("User-Agent", str);
        }
        httpURLConnectionA.setRequestProperty("Accept-Encoding", z11 ? "gzip" : "identity");
        httpURLConnectionA.setInstanceFollowRedirects(z12);
        httpURLConnectionA.setDoOutput(bArr != null);
        httpURLConnectionA.setRequestMethod(l5.a(i11));
        if (bArr != null) {
            httpURLConnectionA.setFixedLengthStreamingMode(bArr.length);
            httpURLConnectionA.connect();
            OutputStream outputStream = httpURLConnectionA.getOutputStream();
            outputStream.write(bArr);
            outputStream.close();
        } else {
            httpURLConnectionA.connect();
        }
        return httpURLConnectionA;
    }

    private URL a(URL url, String str, l5 l5Var) throws qa.c {
        if (str == null) {
            throw new qa.c("Null location redirect", l5Var, 2001, 1);
        }
        try {
            URL url2 = new URL(url, str);
            String protocol = url2.getProtocol();
            if (!"https".equals(protocol) && !HttpHost.DEFAULT_SCHEME_NAME.equals(protocol)) {
                throw new qa.c("Unsupported protocol redirect: " + protocol, l5Var, 2001, 1);
            }
            if (this.f18372e || protocol.equals(url.getProtocol())) {
                return url2;
            }
            throw new qa.c("Disallowed cross-protocol redirect (" + url.getProtocol() + " to " + protocol + ")", l5Var, 2001, 1);
        } catch (MalformedURLException e11) {
            throw new qa.c(e11, l5Var, 2001, 1);
        }
    }

    private void a(long j11, l5 l5Var) throws IOException {
        if (j11 == 0) {
            return;
        }
        byte[] bArr = new byte[4096];
        while (j11 > 0) {
            int i11 = ((InputStream) xp.a((Object) this.f18382o)).read(bArr, 0, (int) Math.min(j11, 4096));
            if (Thread.currentThread().isInterrupted()) {
                throw new qa.c(new InterruptedIOException(), l5Var, 2000, 1);
            }
            if (i11 == -1) {
                throw new qa.c(l5Var, 2008, 1);
            }
            j11 -= (long) i11;
            d(i11);
        }
    }

    private static void a(HttpURLConnection httpURLConnection, long j11) {
        int i11;
        if (httpURLConnection == null || (i11 = xp.f24372a) < 19 || i11 > 20) {
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
                Method declaredMethod = ((Class) b1.a(inputStream.getClass().getSuperclass())).getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(inputStream, new Object[0]);
            }
        } catch (Exception unused) {
        }
    }

    private static boolean a(HttpURLConnection httpURLConnection) {
        return "gzip".equalsIgnoreCase(httpURLConnection.getHeaderField(HttpHeaders.CONTENT_ENCODING));
    }

    private HttpURLConnection d(l5 l5Var) throws IOException {
        URL url = new URL(l5Var.f20336a.toString());
        int i11 = l5Var.f20338c;
        byte[] bArr = l5Var.f20339d;
        long j11 = l5Var.f20342g;
        long j12 = l5Var.f20343h;
        boolean zB = l5Var.b(1);
        if (!this.f18372e && !this.f18378k) {
            return a(url, i11, bArr, j11, j12, zB, true, l5Var.f20340e);
        }
        int i12 = 0;
        URL urlA = url;
        int i13 = i11;
        byte[] bArr2 = bArr;
        while (true) {
            int i14 = i12 + 1;
            if (i12 > 20) {
                throw new qa.c(new NoRouteToHostException("Too many redirects: " + i14), l5Var, 2001, 1);
            }
            long j13 = j11;
            long j14 = j11;
            int i15 = i13;
            URL url2 = urlA;
            long j15 = j12;
            HttpURLConnection httpURLConnectionA = a(urlA, i13, bArr2, j13, j12, zB, false, l5Var.f20340e);
            int responseCode = httpURLConnectionA.getResponseCode();
            String headerField = httpURLConnectionA.getHeaderField(HttpHeaders.LOCATION);
            if ((i15 == 1 || i15 == 3) && (responseCode == 300 || responseCode == 301 || responseCode == 302 || responseCode == 303 || responseCode == 307 || responseCode == 308)) {
                httpURLConnectionA.disconnect();
                urlA = a(url2, headerField, l5Var);
                i13 = i15;
            } else {
                if (i15 != 2 || (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303)) {
                    return httpURLConnectionA;
                }
                httpURLConnectionA.disconnect();
                if (this.f18378k && responseCode == 302) {
                    i13 = i15;
                } else {
                    bArr2 = null;
                    i13 = 1;
                }
                urlA = a(url2, headerField, l5Var);
            }
            i12 = i14;
            j11 = j14;
            j12 = j15;
        }
    }

    private int e(byte[] bArr, int i11, int i12) throws IOException {
        if (i12 == 0) {
            return 0;
        }
        long j11 = this.f18385r;
        if (j11 != -1) {
            long j12 = j11 - this.f18386s;
            if (j12 == 0) {
                return -1;
            }
            i12 = (int) Math.min(i12, j12);
        }
        int i13 = ((InputStream) xp.a((Object) this.f18382o)).read(bArr, i11, i12);
        if (i13 == -1) {
            return -1;
        }
        this.f18386s += (long) i13;
        d(i13);
        return i13;
    }

    private void h() {
        HttpURLConnection httpURLConnection = this.f18381n;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e11) {
                pc.a("DefaultHttpDataSource", "Unexpected error while disconnecting", e11);
            }
            this.f18381n = null;
        }
    }

    @Override // com.applovin.impl.g5
    public int a(byte[] bArr, int i11, int i12) throws qa.c {
        try {
            return e(bArr, i11, i12);
        } catch (IOException e11) {
            throw qa.c.a(e11, (l5) xp.a(this.f18380m), 2);
        }
    }

    @Override // com.applovin.impl.i5
    public long a(l5 l5Var) throws qa.c {
        byte[] bArrA;
        this.f18380m = l5Var;
        long j11 = 0;
        this.f18386s = 0L;
        this.f18385r = 0L;
        b(l5Var);
        try {
            HttpURLConnection httpURLConnectionD = d(l5Var);
            this.f18381n = httpURLConnectionD;
            this.f18384q = httpURLConnectionD.getResponseCode();
            String responseMessage = httpURLConnectionD.getResponseMessage();
            int i11 = this.f18384q;
            if (i11 < 200 || i11 > 299) {
                Map<String, List<String>> headerFields = httpURLConnectionD.getHeaderFields();
                if (this.f18384q == 416) {
                    if (l5Var.f20342g == sa.a(httpURLConnectionD.getHeaderField("Content-Range"))) {
                        this.f18383p = true;
                        c(l5Var);
                        long j12 = l5Var.f20343h;
                        if (j12 != -1) {
                            return j12;
                        }
                        return 0L;
                    }
                }
                InputStream errorStream = httpURLConnectionD.getErrorStream();
                try {
                    bArrA = errorStream != null ? xp.a(errorStream) : xp.f24377f;
                } catch (IOException unused) {
                    bArrA = xp.f24377f;
                }
                byte[] bArr = bArrA;
                h();
                throw new qa.e(this.f18384q, responseMessage, this.f18384q == 416 ? new j5(2008) : null, headerFields, l5Var, bArr);
            }
            String contentType = httpURLConnectionD.getContentType();
            Predicate predicate = this.f18379l;
            if (predicate != null && !predicate.apply(contentType)) {
                h();
                throw new qa.d(contentType, l5Var);
            }
            if (this.f18384q == 200) {
                long j13 = l5Var.f20342g;
                if (j13 != 0) {
                    j11 = j13;
                }
            }
            boolean zA = a(httpURLConnectionD);
            if (zA) {
                this.f18385r = l5Var.f20343h;
            } else {
                long j14 = l5Var.f20343h;
                if (j14 != -1) {
                    this.f18385r = j14;
                } else {
                    long jA = sa.a(httpURLConnectionD.getHeaderField(HttpHeaders.CONTENT_LENGTH), httpURLConnectionD.getHeaderField("Content-Range"));
                    this.f18385r = jA != -1 ? jA - j11 : -1L;
                }
            }
            try {
                this.f18382o = httpURLConnectionD.getInputStream();
                if (zA) {
                    this.f18382o = new GZIPInputStream(this.f18382o);
                }
                this.f18383p = true;
                c(l5Var);
                try {
                    a(j11, l5Var);
                    return this.f18385r;
                } catch (IOException e11) {
                    h();
                    if (e11 instanceof qa.c) {
                        throw ((qa.c) e11);
                    }
                    throw new qa.c(e11, l5Var, 2000, 1);
                }
            } catch (IOException e12) {
                h();
                throw new qa.c(e12, l5Var, 2000, 1);
            }
        } catch (IOException e13) {
            h();
            throw qa.c.a(e13, l5Var, 1);
        }
    }

    public HttpURLConnection a(URL url) {
        return (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection()));
    }

    @Override // com.applovin.impl.i5
    public Uri c() {
        HttpURLConnection httpURLConnection = this.f18381n;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    @Override // com.applovin.impl.i5
    public void close() {
        try {
            InputStream inputStream = this.f18382o;
            if (inputStream != null) {
                long j11 = this.f18385r;
                long j12 = -1;
                if (j11 != -1) {
                    j12 = j11 - this.f18386s;
                }
                a(this.f18381n, j12);
                try {
                    inputStream.close();
                } catch (IOException e11) {
                    throw new qa.c(e11, (l5) xp.a(this.f18380m), 2000, 3);
                }
            }
            this.f18382o = null;
            h();
            if (this.f18383p) {
                this.f18383p = false;
                g();
            }
        } catch (Throwable th2) {
            this.f18382o = null;
            h();
            if (this.f18383p) {
                this.f18383p = false;
                g();
            }
            throw th2;
        }
    }

    @Override // com.applovin.impl.a2, com.applovin.impl.i5
    public Map e() {
        HttpURLConnection httpURLConnection = this.f18381n;
        return httpURLConnection == null ? Collections.emptyMap() : httpURLConnection.getHeaderFields();
    }
}
