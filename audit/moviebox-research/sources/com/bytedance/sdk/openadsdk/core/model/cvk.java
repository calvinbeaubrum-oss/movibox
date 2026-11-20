package com.bytedance.sdk.openadsdk.core.model;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class cvk {
    private JSONObject ExN;
    private String We;
    private String pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private String f28441sc;
    private String zY;

    public static cvk sc(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        cvk cvkVar = new cvk();
        cvkVar.f28441sc = jSONObject.optString("id");
        cvkVar.We = jSONObject.optString("data");
        cvkVar.zY = jSONObject.optString("url");
        cvkVar.pFF = jSONObject.optString("md5");
        cvkVar.ExN = jSONObject.optJSONObject("custom_components");
        return cvkVar;
    }

    public JSONObject ExN() {
        return this.ExN;
    }

    public JSONObject TRI() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.f28441sc);
            jSONObject.put("md5", this.pFF);
            jSONObject.put("url", this.zY);
            jSONObject.put("data", this.We);
            jSONObject.put("custom_components", this.ExN);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public String We() {
        return this.We;
    }

    public String pFF() {
        return this.pFF;
    }

    public String sc() {
        return this.f28441sc;
    }

    public String zY() {
        return this.zY;
    }
}
