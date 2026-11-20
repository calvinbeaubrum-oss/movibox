package com.bytedance.sdk.openadsdk.We.ExN.pFF;

import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class UFX implements zY {
    private final long pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final String f27314sc;

    public UFX(String str, long j11) {
        this.f27314sc = str;
        this.pFF = j11;
    }

    @Override // com.bytedance.sdk.openadsdk.We.ExN.pFF.zY
    public void sc(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("preload_url", this.f27314sc);
            jSONObject.put("preload_size", this.pFF);
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.Tf.sc("LoadVideoStartModel", th2.getMessage());
        }
    }
}
