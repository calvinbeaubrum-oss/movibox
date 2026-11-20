package com.mbridge.msdk.videocommon.b;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f48451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f48452b;

    public c(String str, int i11) {
        this.f48451a = str;
        this.f48452b = i11;
    }

    public static c a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            String strOptString = jSONObject.optString("name");
            int iOptInt = jSONObject.optInt("amount");
            jSONObject.optString("id");
            return new c(strOptString, iOptInt);
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public static Map<String, c> a(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        try {
            HashMap map = new HashMap();
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i11);
                map.put(jSONObjectOptJSONObject.optString("id"), new c(jSONObjectOptJSONObject.optString("name"), jSONObjectOptJSONObject.optInt("amount")));
            }
            return map;
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public static c b(String str) {
        c cVarC = null;
        try {
            com.mbridge.msdk.videocommon.d.a aVarB = com.mbridge.msdk.videocommon.d.b.a().b();
            if (TextUtils.isEmpty(str)) {
                cVarC = c();
            } else if (aVarB != null && aVarB.j() != null) {
                cVarC = aVarB.j().get(str);
            }
            return cVarC == null ? c() : cVarC;
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }

    private static c c() {
        return new c("Virtual Item", 1);
    }

    public final String a() {
        return this.f48451a;
    }

    public final void a(int i11) {
        this.f48452b = i11;
    }

    public final void a(String str) {
        this.f48451a = str;
    }

    public final int b() {
        return this.f48452b;
    }

    public final String toString() {
        return "Reward{name='" + this.f48451a + "', amount=" + this.f48452b + '}';
    }
}
