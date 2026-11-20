package com.mbridge.msdk.foundation.controller;

import android.util.Log;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashMap<String, com.mbridge.msdk.foundation.b.d> f44074a;

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static b f44075a = new b();
    }

    private b() {
        this.f44074a = new HashMap<>();
    }

    public static b a() {
        return a.f44075a;
    }

    public final com.mbridge.msdk.foundation.b.d a(String str, JSONArray jSONArray) {
        JSONArray jSONArray2;
        Exception e11;
        if (this.f44074a == null) {
            this.f44074a = new HashMap<>();
        }
        if (this.f44074a.containsKey(str)) {
            return this.f44074a.get(str);
        }
        if (jSONArray == null) {
            try {
                jSONArray2 = new JSONArray();
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("c_cb", 0);
                    jSONObject.put("t_disc", 0.95d);
                    jSONObject.put("u_disc", 0.95d);
                    jSONObject.put("max_ecppv_diff", 0);
                    jSONObject.put("max_cache_num", 20);
                    jSONObject.put("max_usage_limit", 10);
                    jSONObject.put("time_interval", 7200);
                    jSONArray2.put(jSONObject);
                } catch (Exception e12) {
                    e11 = e12;
                    Log.e("CandidateController", e11.getMessage());
                }
            } catch (Exception e13) {
                jSONArray2 = jSONArray;
                e11 = e13;
            }
            jSONArray = jSONArray2;
        }
        if (this.f44074a == null) {
            this.f44074a = new HashMap<>();
        }
        if (this.f44074a.containsKey(str)) {
            return this.f44074a.get(str);
        }
        com.mbridge.msdk.foundation.b.d dVar = new com.mbridge.msdk.foundation.b.d(str, jSONArray);
        this.f44074a.put(str, dVar);
        return dVar;
    }
}
