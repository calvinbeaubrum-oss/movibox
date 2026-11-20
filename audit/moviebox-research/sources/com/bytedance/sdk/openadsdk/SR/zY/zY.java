package com.bytedance.sdk.openadsdk.SR.zY;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class zY {

    /* JADX INFO: compiled from: source.java */
    public static class sc {
        public final JSONObject pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        public final String f27145sc;

        public sc(String str, JSONObject jSONObject) {
            this.f27145sc = str;
            this.pFF = jSONObject;
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("device_info");
            if (jSONObjectOptJSONObject != null) {
                try {
                    jSONObjectOptJSONObject.put("gaid", com.bytedance.sdk.openadsdk.wjp.sc.pFF.sc.sc().pFF());
                    jSONObject.put("device_info", jSONObjectOptJSONObject);
                } catch (JSONException unused) {
                }
            }
        }
    }

    public static pFF sc() {
        return We.sc();
    }
}
