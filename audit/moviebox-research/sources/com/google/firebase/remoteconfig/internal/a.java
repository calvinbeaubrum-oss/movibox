package com.google.firebase.remoteconfig.internal;

import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Date f41069f = new Date(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f41070a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public JSONObject f41071b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Date f41072c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public JSONArray f41073d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public JSONObject f41074e;

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public JSONObject f41075a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Date f41076b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public JSONArray f41077c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public JSONObject f41078d;

        public b() {
            this.f41075a = new JSONObject();
            this.f41076b = a.f41069f;
            this.f41077c = new JSONArray();
            this.f41078d = new JSONObject();
        }

        public a a() throws JSONException {
            return new a(this.f41075a, this.f41076b, this.f41077c, this.f41078d);
        }

        public b b(JSONObject jSONObject) {
            try {
                this.f41075a = new JSONObject(jSONObject.toString());
            } catch (JSONException unused) {
            }
            return this;
        }

        public b c(JSONArray jSONArray) {
            try {
                this.f41077c = new JSONArray(jSONArray.toString());
            } catch (JSONException unused) {
            }
            return this;
        }

        public b d(Date date) {
            this.f41076b = date;
            return this;
        }

        public b e(JSONObject jSONObject) {
            try {
                this.f41078d = new JSONObject(jSONObject.toString());
            } catch (JSONException unused) {
            }
            return this;
        }
    }

    public a(JSONObject jSONObject, Date date, JSONArray jSONArray, JSONObject jSONObject2) throws JSONException {
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("configs_key", jSONObject);
        jSONObject3.put("fetch_time_key", date.getTime());
        jSONObject3.put("abt_experiments_key", jSONArray);
        jSONObject3.put("personalization_metadata_key", jSONObject2);
        this.f41071b = jSONObject;
        this.f41072c = date;
        this.f41073d = jSONArray;
        this.f41074e = jSONObject2;
        this.f41070a = jSONObject3;
    }

    public static a b(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("personalization_metadata_key");
        if (jSONObjectOptJSONObject == null) {
            jSONObjectOptJSONObject = new JSONObject();
        }
        return new a(jSONObject.getJSONObject("configs_key"), new Date(jSONObject.getLong("fetch_time_key")), jSONObject.getJSONArray("abt_experiments_key"), jSONObjectOptJSONObject);
    }

    public static b g() {
        return new b();
    }

    public JSONArray c() {
        return this.f41073d;
    }

    public JSONObject d() {
        return this.f41071b;
    }

    public Date e() {
        return this.f41072c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            return this.f41070a.toString().equals(((a) obj).toString());
        }
        return false;
    }

    public JSONObject f() {
        return this.f41074e;
    }

    public int hashCode() {
        return this.f41070a.hashCode();
    }

    public String toString() {
        return this.f41070a.toString();
    }
}
