package com.transsion.transfer.androidasync.http;

import android.net.Uri;
import android.util.Log;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.transsion.transfer.androidasync.AsyncSSLException;
import java.util.Locale;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f58683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f58684b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Uri f58685c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Headers f58686d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f58687e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public gy.a f58688f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f58689g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f58690h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f58691i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f58692j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f58693k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f58694l;

    /* JADX INFO: compiled from: source.java */
    public class a implements a0 {
        public a() {
        }

        public String toString() {
            j jVar = j.this;
            if (jVar.f58690h != null) {
                return String.format(Locale.ENGLISH, "%s %s %s", jVar.f58684b, j.this.p(), j.this.f58683a);
            }
            String strK = jVar.k();
            if (strK == null || strK.length() == 0) {
                strK = "/";
            }
            String encodedQuery = j.this.p().getEncodedQuery();
            if (encodedQuery != null && encodedQuery.length() != 0) {
                strK = strK + "?" + encodedQuery;
            }
            return String.format(Locale.ENGLISH, "%s %s %s", j.this.f58684b, strK, j.this.f58683a);
        }
    }

    public j(Uri uri, String str) {
        this(uri, str, null);
    }

    public j(Uri uri, String str, Headers headers) {
        this.f58683a = "HTTP/1.1";
        this.f58686d = new Headers();
        this.f58687e = true;
        this.f58689g = 5000;
        this.f58691i = -1;
        this.f58684b = str;
        this.f58685c = uri;
        if (headers == null) {
            this.f58686d = new Headers();
        } else {
            this.f58686d = headers;
        }
        if (headers == null) {
            x(this.f58686d, uri);
        }
    }

    public static String f() {
        String property = System.getProperty("http.agent");
        if (property != null) {
            return property;
        }
        return "Java" + System.getProperty("java.version");
    }

    public static void x(Headers headers, Uri uri) {
        if (uri != null) {
            String host = uri.getHost();
            if (uri.getPort() != -1) {
                host = host + ":" + uri.getPort();
            }
            if (host != null) {
                headers.f(HttpHeaders.HOST, host);
            }
        }
        headers.f("User-Agent", f());
        headers.f("Accept-Encoding", "gzip, deflate");
        headers.f("Connection", "keep-alive");
        headers.f("Accept", "*/*");
    }

    public j c(String str, String str2) {
        h().a(str, str2);
        return this;
    }

    public void d(String str, int i11) {
        this.f58690h = str;
        this.f58691i = i11;
    }

    public gy.a e() {
        return this.f58688f;
    }

    public boolean g() {
        return this.f58687e;
    }

    public Headers h() {
        return this.f58686d;
    }

    public final String i(String str) {
        return String.format(Locale.ENGLISH, "(%d ms) %s: %s", Long.valueOf(this.f58694l != 0 ? System.currentTimeMillis() - this.f58694l : 0L), p(), str);
    }

    public String j() {
        return this.f58684b;
    }

    public String k() {
        return p().getEncodedPath();
    }

    public String l() {
        return this.f58690h;
    }

    public int m() {
        return this.f58691i;
    }

    public a0 n() {
        return new a();
    }

    public int o() {
        return this.f58689g;
    }

    public Uri p() {
        return this.f58685c;
    }

    public boolean q() {
        return true;
    }

    public void r(String str) {
        if (this.f58692j != null && this.f58693k <= 3) {
            i(str);
        }
    }

    public void s(String str, Exception exc) {
        String str2 = this.f58692j;
        if (str2 != null && this.f58693k <= 6) {
            Log.e(str2, i(str));
            Log.e(this.f58692j, exc.getMessage(), exc);
        }
    }

    public void t(String str) {
        if (this.f58692j != null && this.f58693k <= 4) {
            i(str);
        }
    }

    public String toString() {
        Headers headers = this.f58686d;
        return headers == null ? super.toString() : headers.g(this.f58685c.toString());
    }

    public void u(String str) {
        String str2 = this.f58692j;
        if (str2 != null && this.f58693k <= 2) {
            Log.v(str2, i(str));
        }
    }

    public void v(AsyncSSLException asyncSSLException) {
    }

    public void w(gy.a aVar) {
        this.f58688f = aVar;
    }

    public j y(int i11) {
        this.f58689g = i11;
        return this;
    }
}
