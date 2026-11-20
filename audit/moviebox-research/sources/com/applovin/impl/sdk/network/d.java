package com.applovin.impl.sdk.network;

import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.vi;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f22770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f22771b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f22772c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f22773d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Map f22774e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map f22775f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Map f22776g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private vi.a f22777h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f22778i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f22779j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f22780k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f22781l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f22782m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f22783n;

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f22784a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f22785b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f22786c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f22787d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Map f22788e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Map f22789f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private Map f22790g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private vi.a f22791h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f22792i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private boolean f22793j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private boolean f22794k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private boolean f22795l;

        public b a(vi.a aVar) {
            this.f22791h = aVar;
            return this;
        }

        public b a(String str) {
            this.f22787d = str;
            return this;
        }

        public b a(Map map) {
            this.f22789f = map;
            return this;
        }

        public b a(boolean z11) {
            this.f22792i = z11;
            return this;
        }

        public d a() {
            return new d(this);
        }

        public b b(String str) {
            this.f22784a = str;
            return this;
        }

        public b b(Map map) {
            this.f22788e = map;
            return this;
        }

        public b b(boolean z11) {
            this.f22795l = z11;
            return this;
        }

        public b c(String str) {
            this.f22785b = str;
            return this;
        }

        public b c(Map map) {
            this.f22790g = map;
            return this;
        }

        public b c(boolean z11) {
            this.f22793j = z11;
            return this;
        }

        public b d(String str) {
            this.f22786c = str;
            return this;
        }

        public b d(boolean z11) {
            this.f22794k = z11;
            return this;
        }
    }

    private d(b bVar) {
        this.f22770a = UUID.randomUUID().toString();
        this.f22771b = bVar.f22785b;
        this.f22772c = bVar.f22786c;
        this.f22773d = bVar.f22787d;
        this.f22774e = bVar.f22788e;
        this.f22775f = bVar.f22789f;
        this.f22776g = bVar.f22790g;
        this.f22777h = bVar.f22791h;
        this.f22778i = bVar.f22792i;
        this.f22779j = bVar.f22793j;
        this.f22780k = bVar.f22794k;
        this.f22781l = bVar.f22795l;
        this.f22782m = bVar.f22784a;
        this.f22783n = 0;
    }

    public d(JSONObject jSONObject, j jVar) throws JSONException {
        String string = JsonUtils.getString(jSONObject, "uniqueId", UUID.randomUUID().toString());
        String string2 = JsonUtils.getString(jSONObject, "communicatorRequestId", "");
        String string3 = JsonUtils.getString(jSONObject, "httpMethod", "");
        String string4 = jSONObject.getString("targetUrl");
        String string5 = JsonUtils.getString(jSONObject, "backupUrl", "");
        int i11 = jSONObject.getInt("attemptNumber");
        Map mapSynchronizedMap = JsonUtils.valueExists(jSONObject, "parameters") ? Collections.synchronizedMap(JsonUtils.toStringMap(jSONObject.getJSONObject("parameters"))) : new HashMap();
        Map mapSynchronizedMap2 = JsonUtils.valueExists(jSONObject, "httpHeaders") ? Collections.synchronizedMap(JsonUtils.toStringMap(jSONObject.getJSONObject("httpHeaders"))) : new HashMap();
        Map mapSynchronizedMap3 = JsonUtils.valueExists(jSONObject, "requestBody") ? Collections.synchronizedMap(JsonUtils.toStringObjectMap(jSONObject.getJSONObject("requestBody"))) : new HashMap();
        this.f22770a = string;
        this.f22771b = string3;
        this.f22782m = string2;
        this.f22772c = string4;
        this.f22773d = string5;
        this.f22774e = mapSynchronizedMap;
        this.f22775f = mapSynchronizedMap2;
        this.f22776g = mapSynchronizedMap3;
        this.f22777h = vi.a.a(jSONObject.optInt("encodingType", vi.a.DEFAULT.b()));
        this.f22778i = jSONObject.optBoolean("isEncodingEnabled", false);
        this.f22779j = jSONObject.optBoolean("gzipBodyEncoding", false);
        this.f22780k = jSONObject.optBoolean("isAllowedPreInitEvent", false);
        this.f22781l = jSONObject.optBoolean("shouldFireInWebView", false);
        this.f22783n = i11;
    }

    public static b b() {
        return new b();
    }

    public void a() {
        Map map = CollectionUtils.map(this.f22774e);
        map.put("postback_ts", String.valueOf(System.currentTimeMillis()));
        this.f22774e = map;
    }

    public int c() {
        return this.f22783n;
    }

    public String d() {
        return this.f22773d;
    }

    public String e() {
        return this.f22782m;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f22770a.equals(((d) obj).f22770a);
    }

    public vi.a f() {
        return this.f22777h;
    }

    public Map g() {
        return this.f22775f;
    }

    public String h() {
        return this.f22771b;
    }

    public int hashCode() {
        return this.f22770a.hashCode();
    }

    public Map i() {
        return this.f22774e;
    }

    public Map j() {
        return this.f22776g;
    }

    public String k() {
        return this.f22772c;
    }

    public void l() {
        this.f22783n++;
    }

    public boolean m() {
        return this.f22780k;
    }

    public boolean n() {
        return this.f22778i;
    }

    public boolean o() {
        return this.f22779j;
    }

    public boolean p() {
        return this.f22781l;
    }

    public JSONObject q() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("uniqueId", this.f22770a);
        jSONObject.put("communicatorRequestId", this.f22782m);
        jSONObject.put("httpMethod", this.f22771b);
        jSONObject.put("targetUrl", this.f22772c);
        jSONObject.put("backupUrl", this.f22773d);
        jSONObject.put("encodingType", this.f22777h);
        jSONObject.put("isEncodingEnabled", this.f22778i);
        jSONObject.put("gzipBodyEncoding", this.f22779j);
        jSONObject.put("isAllowedPreInitEvent", this.f22780k);
        jSONObject.put("attemptNumber", this.f22783n);
        if (this.f22774e != null) {
            jSONObject.put("parameters", new JSONObject(this.f22774e));
        }
        if (this.f22775f != null) {
            jSONObject.put("httpHeaders", new JSONObject(this.f22775f));
        }
        if (this.f22776g != null) {
            jSONObject.put("requestBody", new JSONObject(this.f22776g));
        }
        return jSONObject;
    }

    public String toString() {
        return "PostbackRequest{uniqueId='" + this.f22770a + "', communicatorRequestId='" + this.f22782m + "', httpMethod='" + this.f22771b + "', targetUrl='" + this.f22772c + "', backupUrl='" + this.f22773d + "', attemptNumber=" + this.f22783n + ", isEncodingEnabled=" + this.f22778i + ", isGzipBodyEncoding=" + this.f22779j + ", isAllowedPreInitEvent=" + this.f22780k + ", shouldFireInWebView=" + this.f22781l + '}';
    }
}
