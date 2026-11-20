package com.bytedance.sdk.openadsdk.core.model;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class Ql {
    private final int We;
    private final int pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final int f28398sc;
    private final int zY;

    public Ql(JSONObject jSONObject) {
        this.f28398sc = jSONObject.optInt("auto_click", 0);
        this.pFF = jSONObject.optInt("close_jump_probability", 0);
        this.zY = jSONObject.optInt("skip_jump_probability", 0);
        this.We = jSONObject.optInt("hidden_bar", 0);
    }

    public static boolean sc(Sfl sfl) {
        if (sfl == null || !sfl.ymG() || sfl.ypJ() == null) {
            return false;
        }
        return sfl.ypJ().We();
    }

    public JSONObject ExN() {
        try {
            JSONObject jSONObject = new JSONObject();
            int i11 = this.f28398sc;
            if (i11 == 1) {
                jSONObject.put("auto_click", i11);
            }
            int i12 = this.pFF;
            if (i12 > 0 && i12 <= 100) {
                jSONObject.put("close_jump_probability", i12);
            }
            int i13 = this.zY;
            if (i13 > 0 && i13 <= 100) {
                jSONObject.put("skip_jump_probability", i13);
            }
            if (this.We == 1) {
                jSONObject.put("hidden_bar", 1);
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public boolean We() {
        return this.We == 1;
    }

    public int pFF() {
        int i11 = this.pFF;
        if (i11 < 0 || i11 > 100) {
            return 0;
        }
        return i11;
    }

    public int sc() {
        return this.f28398sc;
    }

    public int zY() {
        int i11 = this.zY;
        if (i11 < 0 || i11 > 100) {
            return 0;
        }
        return i11;
    }
}
