package com.facebook.biddingkit.logging;

import android.os.AsyncTask;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f32465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f32466b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Map<String, String>> f32467c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f32468d;

    /* JADX INFO: compiled from: source.java */
    public class a extends AsyncTask<e, Void, Void> {
        public a() {
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(e... eVarArr) {
            f.g(eVarArr[0]);
            return null;
        }
    }

    public void a(String str) {
        this.f32466b = str;
    }

    public void b(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        Map<String, String> map = this.f32467c.get(str);
        if (map == null) {
            map = new HashMap<>();
            this.f32467c.put(str, map);
        }
        map.put("cpm_cents", str2);
    }

    public void c(String str) {
        this.f32465a = str;
    }

    public void d(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        Map<String, String> map = this.f32467c.get(str);
        if (map == null) {
            map = new HashMap<>();
            this.f32467c.put(str, map);
        }
        map.put("error", str2);
    }

    public void e(String str) {
        this.f32468d = str;
    }

    public void f(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        Map<String, String> map = this.f32467c.get(str);
        if (map == null) {
            map = new HashMap<>();
            this.f32467c.put(str, map);
        }
        map.put("latency_ms", str2);
    }

    public void g(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        Map<String, String> map = this.f32467c.get(str);
        if (map == null) {
            map = new HashMap<>();
            this.f32467c.put(str, map);
        }
        map.put("result", str2);
    }

    public JSONObject h() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        Iterator<Map.Entry<String, Map<String, String>>> it = this.f32467c.entrySet().iterator();
        while (it.hasNext()) {
            String key = it.next().getKey();
            jSONObject.put(key, j(key));
        }
        return jSONObject;
    }

    public String i() {
        return TextUtils.isEmpty(this.f32466b) ? "" : this.f32466b;
    }

    public JSONObject j(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (!this.f32467c.containsKey(str)) {
            return jSONObject;
        }
        for (Map.Entry<String, String> entry : this.f32467c.get(str).entrySet()) {
            if ("cpm_cents".equals(entry.getKey())) {
                jSONObject.put(entry.getKey(), Double.parseDouble(entry.getValue()));
            } else if ("latency_ms".equals(entry.getKey())) {
                jSONObject.put(entry.getKey(), Long.parseLong(entry.getValue()));
            } else {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        }
        return jSONObject;
    }

    public String k() {
        return this.f32465a;
    }

    public String l() {
        return TextUtils.isEmpty(this.f32468d) ? "" : this.f32468d;
    }

    public JSONObject m() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.f32466b)) {
                jSONObject.put("auction_id", this.f32466b);
            }
            if (!TextUtils.isEmpty(this.f32468d)) {
                jSONObject.put("exception", this.f32468d);
            }
            Iterator<Map.Entry<String, Map<String, String>>> it = this.f32467c.entrySet().iterator();
            while (it.hasNext()) {
                String key = it.next().getKey();
                jSONObject.put(key, j(key));
            }
        } catch (JSONException e11) {
            b.d("EventLog", "Failed to create json data", e11);
        }
        return jSONObject;
    }

    public void n() {
        new a().execute(this);
    }
}
