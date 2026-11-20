package com.apm.insight.runtime;

import androidx.annotation.Nullable;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static HashMap<String, d> f17066a = new HashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private JSONObject f17067b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private JSONObject f17068c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f17069d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f17070e;

    private d(JSONObject jSONObject, String str) {
        this.f17070e = str;
        a(jSONObject);
        f17066a.put(this.f17070e, this);
        com.apm.insight.a.a((Object) "after update aid ".concat(String.valueOf(str)));
    }

    public static void a(String str, JSONObject jSONObject) {
        d dVar = f17066a.get(str);
        if (dVar != null) {
            dVar.a(jSONObject);
        } else {
            new d(jSONObject, str);
        }
    }

    private void a(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        this.f17067b = jSONObject;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("error_module")) == null) {
            return;
        }
        this.f17069d = jSONObjectOptJSONObject.optInt("switcher") == 1 && jSONObjectOptJSONObject.optInt("err_sampling_rate") == 1;
    }

    public static boolean a(String str) {
        return f17066a.get(str) != null;
    }

    @Nullable
    public static JSONObject b(String str) {
        d dVar = f17066a.get(str);
        if (dVar != null) {
            return dVar.f17067b;
        }
        return null;
    }

    public static d c(String str) {
        return f17066a.get(str);
    }

    public static long d(String str) {
        d dVar = f17066a.get(str);
        if (dVar == null) {
            return 3600000L;
        }
        try {
            return Long.decode(com.apm.insight.a.a(dVar.f17067b, "over_all", "get_settings_interval")).longValue() * 1000;
        } catch (Throwable unused) {
            return 3600000L;
        }
    }

    public static boolean e(String str) {
        JSONObject jSONObject;
        d dVar = f17066a.get(str);
        return (dVar == null || (jSONObject = dVar.f17067b) == null || 1 != com.apm.insight.a.a(jSONObject, 0, "crash_module", "switcher")) ? false : true;
    }

    public static boolean f(String str) {
        JSONObject jSONObject;
        d dVar = f17066a.get(str);
        return (dVar == null || (jSONObject = dVar.f17067b) == null || 1 != com.apm.insight.a.a(jSONObject, 0, "crash_module", "switcher")) ? false : true;
    }

    public static boolean g(String str) {
        JSONObject jSONObject;
        d dVar = f17066a.get(str);
        return (dVar == null || (jSONObject = dVar.f17067b) == null || 1 != com.apm.insight.a.a(jSONObject, 0, "crash_module", "switcher")) ? false : true;
    }

    public final boolean a() {
        if (this.f17067b == null) {
            return false;
        }
        return this.f17069d;
    }
}
