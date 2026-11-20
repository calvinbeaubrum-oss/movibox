package com.bytedance.sdk.openadsdk.core.model;

import androidx.annotation.Nullable;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class UFX {
    private String pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private String f28408sc;
    private int zY;

    @Nullable
    public JSONObject We() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("u", this.f28408sc);
            jSONObject.put("ft", this.zY);
            jSONObject.put("fu", this.pFF);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public String pFF() {
        return this.pFF;
    }

    public void pFF(String str) {
        this.pFF = str;
    }

    public String sc() {
        return this.f28408sc;
    }

    public void sc(int i11) {
        this.zY = i11;
    }

    public void sc(String str) {
        this.f28408sc = str;
    }

    public int zY() {
        return this.zY;
    }
}
