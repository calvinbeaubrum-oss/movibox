package com.bytedance.sdk.openadsdk.core.model;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class zY {

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private int f28452qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private String f28453sc = "";
    private String pFF = "";
    private String zY = "";
    private String We = "";
    private double ExN = -1.0d;
    private int TRI = -1;

    public int ExN() {
        return this.TRI;
    }

    public JSONObject Qj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_name", pFF());
            jSONObject.put(CampaignEx.JSON_KEY_APP_SIZE, TRI());
            jSONObject.put("comment_num", ExN());
            jSONObject.put("download_url", sc());
            jSONObject.put("package_name", zY());
            jSONObject.put("score", We());
            jSONObject.put("app_category", qr());
        } catch (Exception e11) {
            com.bytedance.sdk.component.utils.Tf.pFF(e11.toString());
        }
        return jSONObject;
    }

    public int TRI() {
        return this.f28452qr;
    }

    public double We() {
        return this.ExN;
    }

    public void We(String str) {
        this.We = str;
    }

    public String pFF() {
        return this.pFF;
    }

    public void pFF(int i11) {
        this.f28452qr = i11;
    }

    public void pFF(String str) {
        this.pFF = str;
    }

    public String qr() {
        return this.We;
    }

    public String sc() {
        return this.f28453sc;
    }

    public void sc(double d11) {
        if (d11 < 1.0d || d11 > 5.0d) {
            this.ExN = -1.0d;
        } else {
            this.ExN = d11;
        }
    }

    public void sc(int i11) {
        if (i11 <= 0) {
            this.TRI = -1;
        } else {
            this.TRI = i11;
        }
    }

    public void sc(String str) {
        this.f28453sc = str;
    }

    public String zY() {
        return this.zY;
    }

    public void zY(String str) {
        this.zY = str;
    }
}
