package com.bytedance.sdk.openadsdk.core.UFX.TRI;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc {
    private String ExN;
    private String We;
    private String pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private String f28253sc;
    private String zY;

    public sc ExN(String str) {
        this.ExN = str;
        return this;
    }

    public String ExN() {
        return this.ExN;
    }

    public sc We(String str) {
        this.We = str;
        return this;
    }

    public String We() {
        return this.We;
    }

    public sc pFF(String str) {
        this.pFF = str;
        return this;
    }

    public String pFF() {
        return this.pFF;
    }

    public sc sc(String str) {
        this.f28253sc = str;
        return this;
    }

    public String sc() {
        return this.f28253sc;
    }

    public JSONObject sc(sc scVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.f28253sc);
            jSONObject.put("md5", this.pFF);
            jSONObject.put("url", this.zY);
            if (scVar != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("id", scVar.sc());
                jSONObject2.put("md5", scVar.pFF());
                jSONObject2.put("url", scVar.zY());
                jSONObject.put("overlay", jSONObject2);
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public sc zY(String str) {
        this.zY = str;
        return this;
    }

    public String zY() {
        return this.zY;
    }
}
