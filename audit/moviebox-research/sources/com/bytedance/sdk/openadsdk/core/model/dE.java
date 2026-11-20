package com.bytedance.sdk.openadsdk.core.model;

import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class dE {
    public static int pFF = 2;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static int f28442sc = 1;
    private int zY = 5;
    private int We = 30;
    private int ExN = 70;
    private int TRI = 1;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private int f28443qr = f28442sc;

    public int ExN() {
        return this.f28443qr;
    }

    public void ExN(int i11) {
        this.f28443qr = i11;
    }

    public int We() {
        return this.TRI;
    }

    public void We(int i11) {
        this.TRI = i11;
    }

    public int pFF() {
        return this.We;
    }

    public void pFF(int i11) {
        this.We = i11;
    }

    public int sc() {
        return this.zY;
    }

    public JSONObject sc(JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("ceiling_time", this.zY);
            jSONObject.put("ceiling_ratio", this.We);
            jSONObject.put("expand_ratio", this.ExN);
            jSONObject.put("back_type", this.TRI);
            jSONObject.put("boc_return_type", this.f28443qr);
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.Tf.sc("InteractionParams", th2.getMessage());
        }
        return jSONObject;
    }

    public void sc(int i11) {
        this.zY = i11;
    }

    public int zY() {
        return this.ExN;
    }

    public void zY(int i11) {
        this.ExN = i11;
    }
}
