package com.applovin.impl.sdk.network;

import com.applovin.impl.sdk.j;
import com.applovin.impl.sj;
import com.applovin.impl.vi;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f22720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f22721b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map f22722c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map f22723d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final JSONObject f22724e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f22725f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Object f22726g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f22727h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f22728i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f22729j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f22730k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final boolean f22731l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final boolean f22732m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final boolean f22733n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final boolean f22734o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final vi.a f22735p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final boolean f22736q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final boolean f22737r;

    /* JADX INFO: renamed from: com.applovin.impl.sdk.network.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0202a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f22738a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f22739b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f22740c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Map f22742e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        JSONObject f22743f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Object f22744g;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f22746i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f22747j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        boolean f22748k;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        boolean f22750m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        boolean f22751n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        boolean f22752o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        boolean f22753p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        vi.a f22754q;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f22745h = 1;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        boolean f22749l = true;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Map f22741d = new HashMap();

        public C0202a(j jVar) {
            this.f22746i = ((Integer) jVar.a(sj.f22937d3)).intValue();
            this.f22747j = ((Integer) jVar.a(sj.f22929c3)).intValue();
            this.f22750m = ((Boolean) jVar.a(sj.A3)).booleanValue();
            this.f22751n = ((Boolean) jVar.a(sj.f22970h5)).booleanValue();
            this.f22754q = vi.a.a(((Integer) jVar.a(sj.f22978i5)).intValue());
            this.f22753p = ((Boolean) jVar.a(sj.F5)).booleanValue();
        }

        public C0202a a(int i11) {
            this.f22745h = i11;
            return this;
        }

        public C0202a a(vi.a aVar) {
            this.f22754q = aVar;
            return this;
        }

        public C0202a a(Object obj) {
            this.f22744g = obj;
            return this;
        }

        public C0202a a(String str) {
            this.f22740c = str;
            return this;
        }

        public C0202a a(Map map) {
            this.f22742e = map;
            return this;
        }

        public C0202a a(JSONObject jSONObject) {
            this.f22743f = jSONObject;
            return this;
        }

        public C0202a a(boolean z11) {
            this.f22751n = z11;
            return this;
        }

        public a a() {
            return new a(this);
        }

        public C0202a b(int i11) {
            this.f22747j = i11;
            return this;
        }

        public C0202a b(String str) {
            this.f22739b = str;
            return this;
        }

        public C0202a b(Map map) {
            this.f22741d = map;
            return this;
        }

        public C0202a b(boolean z11) {
            this.f22753p = z11;
            return this;
        }

        public C0202a c(int i11) {
            this.f22746i = i11;
            return this;
        }

        public C0202a c(String str) {
            this.f22738a = str;
            return this;
        }

        public C0202a c(boolean z11) {
            this.f22748k = z11;
            return this;
        }

        public C0202a d(boolean z11) {
            this.f22749l = z11;
            return this;
        }

        public C0202a e(boolean z11) {
            this.f22750m = z11;
            return this;
        }

        public C0202a f(boolean z11) {
            this.f22752o = z11;
            return this;
        }
    }

    public a(C0202a c0202a) {
        this.f22720a = c0202a.f22739b;
        this.f22721b = c0202a.f22738a;
        this.f22722c = c0202a.f22741d;
        this.f22723d = c0202a.f22742e;
        this.f22724e = c0202a.f22743f;
        this.f22725f = c0202a.f22740c;
        this.f22726g = c0202a.f22744g;
        int i11 = c0202a.f22745h;
        this.f22727h = i11;
        this.f22728i = i11;
        this.f22729j = c0202a.f22746i;
        this.f22730k = c0202a.f22747j;
        this.f22731l = c0202a.f22748k;
        this.f22732m = c0202a.f22749l;
        this.f22733n = c0202a.f22750m;
        this.f22734o = c0202a.f22751n;
        this.f22735p = c0202a.f22754q;
        this.f22736q = c0202a.f22752o;
        this.f22737r = c0202a.f22753p;
    }

    public static C0202a a(j jVar) {
        return new C0202a(jVar);
    }

    public String a() {
        return this.f22725f;
    }

    public void a(int i11) {
        this.f22728i = i11;
    }

    public void a(String str) {
        this.f22720a = str;
    }

    public JSONObject b() {
        return this.f22724e;
    }

    public void b(String str) {
        this.f22721b = str;
    }

    public int c() {
        return this.f22727h - this.f22728i;
    }

    public Object d() {
        return this.f22726g;
    }

    public vi.a e() {
        return this.f22735p;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        String str = this.f22720a;
        if (str == null ? aVar.f22720a != null : !str.equals(aVar.f22720a)) {
            return false;
        }
        Map map = this.f22722c;
        if (map == null ? aVar.f22722c != null : !map.equals(aVar.f22722c)) {
            return false;
        }
        Map map2 = this.f22723d;
        if (map2 == null ? aVar.f22723d != null : !map2.equals(aVar.f22723d)) {
            return false;
        }
        String str2 = this.f22725f;
        if (str2 == null ? aVar.f22725f != null : !str2.equals(aVar.f22725f)) {
            return false;
        }
        String str3 = this.f22721b;
        if (str3 == null ? aVar.f22721b != null : !str3.equals(aVar.f22721b)) {
            return false;
        }
        JSONObject jSONObject = this.f22724e;
        if (jSONObject == null ? aVar.f22724e != null : !jSONObject.equals(aVar.f22724e)) {
            return false;
        }
        Object obj2 = this.f22726g;
        if (obj2 == null ? aVar.f22726g == null : obj2.equals(aVar.f22726g)) {
            return this.f22727h == aVar.f22727h && this.f22728i == aVar.f22728i && this.f22729j == aVar.f22729j && this.f22730k == aVar.f22730k && this.f22731l == aVar.f22731l && this.f22732m == aVar.f22732m && this.f22733n == aVar.f22733n && this.f22734o == aVar.f22734o && this.f22735p == aVar.f22735p && this.f22736q == aVar.f22736q && this.f22737r == aVar.f22737r;
        }
        return false;
    }

    public String f() {
        return this.f22720a;
    }

    public Map g() {
        return this.f22723d;
    }

    public String h() {
        return this.f22721b;
    }

    public int hashCode() {
        int iHashCode = super.hashCode() * 31;
        String str = this.f22720a;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f22725f;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f22721b;
        int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Object obj = this.f22726g;
        int iHashCode5 = ((((((((((((((((((((((iHashCode4 + (obj != null ? obj.hashCode() : 0)) * 31) + this.f22727h) * 31) + this.f22728i) * 31) + this.f22729j) * 31) + this.f22730k) * 31) + (this.f22731l ? 1 : 0)) * 31) + (this.f22732m ? 1 : 0)) * 31) + (this.f22733n ? 1 : 0)) * 31) + (this.f22734o ? 1 : 0)) * 31) + this.f22735p.b()) * 31) + (this.f22736q ? 1 : 0)) * 31) + (this.f22737r ? 1 : 0);
        Map map = this.f22722c;
        if (map != null) {
            iHashCode5 = (iHashCode5 * 31) + map.hashCode();
        }
        Map map2 = this.f22723d;
        if (map2 != null) {
            iHashCode5 = (iHashCode5 * 31) + map2.hashCode();
        }
        JSONObject jSONObject = this.f22724e;
        if (jSONObject == null) {
            return iHashCode5;
        }
        char[] charArray = jSONObject.toString().toCharArray();
        Arrays.sort(charArray);
        return (iHashCode5 * 31) + new String(charArray).hashCode();
    }

    public Map i() {
        return this.f22722c;
    }

    public int j() {
        return this.f22728i;
    }

    public int k() {
        return this.f22730k;
    }

    public int l() {
        return this.f22729j;
    }

    public boolean m() {
        return this.f22734o;
    }

    public boolean n() {
        return this.f22731l;
    }

    public boolean o() {
        return this.f22737r;
    }

    public boolean p() {
        return this.f22732m;
    }

    public boolean q() {
        return this.f22733n;
    }

    public boolean r() {
        return this.f22736q;
    }

    public String toString() {
        return "HttpRequest {endpoint=" + this.f22720a + ", backupEndpoint=" + this.f22725f + ", httpMethod=" + this.f22721b + ", httpHeaders=" + this.f22723d + ", body=" + this.f22724e + ", emptyResponse=" + this.f22726g + ", initialRetryAttempts=" + this.f22727h + ", retryAttemptsLeft=" + this.f22728i + ", timeoutMillis=" + this.f22729j + ", retryDelayMillis=" + this.f22730k + ", exponentialRetries=" + this.f22731l + ", retryOnAllErrors=" + this.f22732m + ", retryOnNoConnection=" + this.f22733n + ", encodingEnabled=" + this.f22734o + ", encodingType=" + this.f22735p + ", trackConnectionSpeed=" + this.f22736q + ", gzipBodyEncoding=" + this.f22737r + '}';
    }
}
