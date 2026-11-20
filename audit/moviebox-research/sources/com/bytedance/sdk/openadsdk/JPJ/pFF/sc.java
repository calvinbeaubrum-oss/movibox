package com.bytedance.sdk.openadsdk.JPJ.pFF;

import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc {
    private final int pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final int f27095sc;
    private final float zY;

    public sc(int i11, int i12, float f11) {
        this.f27095sc = i11;
        this.pFF = i12;
        this.zY = f11;
    }

    public static JSONObject sc(sc scVar) throws Throwable {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("width", scVar.f27095sc);
        jSONObject.put("height", scVar.pFF);
        jSONObject.put("alpha", scVar.zY);
        return jSONObject;
    }
}
