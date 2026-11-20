package com.bytedance.sdk.openadsdk.core;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class We {
    public static void sc(com.bytedance.sdk.openadsdk.core.model.Sfl sfl, String str, int i11, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("type", i11);
        } catch (JSONException unused) {
        }
        com.bytedance.sdk.openadsdk.We.zY.pFF(sfl, str, "convert_track", jSONObject);
    }
}
