package com.bytedance.sdk.openadsdk.core.model;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class uEA {
    private int We;
    private String pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private String f28450sc;
    private int zY;

    public static uEA sc(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        uEA uea = new uEA();
        try {
            uea.sc(jSONObject.optString("market_dpl", ""));
            uea.pFF(jSONObject.optString("market_dpl_auto", ""));
            uea.sc(jSONObject.optInt("exec_type", 0));
            uea.pFF(jSONObject.optInt("oem_vendor_type", 0));
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.Tf.sc("OemModel", th2.getMessage());
        }
        return uea;
    }

    public String pFF() {
        return this.zY == 2 ? this.pFF : this.f28450sc;
    }

    public void pFF(int i11) {
        this.We = i11;
    }

    public void pFF(String str) {
        this.pFF = str;
    }

    public void sc(int i11) {
        this.zY = i11;
    }

    public void sc(String str) {
        this.f28450sc = str;
    }

    public boolean sc() {
        return this.We == 1;
    }

    public JSONObject zY() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.f28450sc)) {
                jSONObject.put("market_dpl", this.f28450sc);
            }
            if (!TextUtils.isEmpty(this.pFF)) {
                jSONObject.put("market_dpl_auto", this.pFF);
            }
            jSONObject.put("exec_type", this.zY);
            jSONObject.put("oem_vendor_type", this.We);
            return jSONObject;
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.Tf.sc("OemModel", th2.getMessage());
            return null;
        }
    }
}
