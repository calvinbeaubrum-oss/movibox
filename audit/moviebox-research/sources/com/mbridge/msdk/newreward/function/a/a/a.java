package com.mbridge.msdk.newreward.function.a.a;

import android.util.Log;
import com.mbridge.msdk.newreward.function.a.c;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashMap<String, c> f46147a;

    /* JADX INFO: renamed from: com.mbridge.msdk.newreward.function.a.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0506a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static a f46148a = new a();
    }

    private a() {
        this.f46147a = new HashMap<>();
    }

    public static a a() {
        return C0506a.f46148a;
    }

    public final c a(String str, JSONArray jSONArray) {
        JSONArray jSONArray2;
        Exception e11;
        if (this.f46147a == null) {
            this.f46147a = new HashMap<>();
        }
        if (this.f46147a.containsKey(str)) {
            return this.f46147a.get(str);
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
        if (this.f46147a == null) {
            this.f46147a = new HashMap<>();
        }
        if (this.f46147a.containsKey(str)) {
            return this.f46147a.get(str);
        }
        c cVar = new c(str, jSONArray);
        this.f46147a.put(str, cVar);
        return cVar;
    }
}
