package com.bytedance.sdk.component.Qj.pFF;

import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class sc {
    public int We;
    public int pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public int f26561sc;
    public int zY;

    public sc(int i11, int i12, int i13, int i14) {
        this.f26561sc = i11;
        this.pFF = i12;
        this.zY = i13;
        this.We = i14;
    }

    public JSONObject sc() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sdk_thread_num", this.f26561sc);
            jSONObject.put("sdk_max_thread_num", this.pFF);
            jSONObject.put("app_thread_num", this.zY);
            jSONObject.put("app_max_thread_num", this.We);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }
}
