package com.bytedance.sdk.openadsdk.We.ExN.pFF;

import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class Tf implements zY {
    private long We;
    private long pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private String f27313sc;
    private long zY;

    public void pFF(long j11) {
        this.zY = j11;
    }

    public void sc(long j11) {
        this.pFF = j11;
    }

    public void sc(String str) {
        this.f27313sc = str;
    }

    @Override // com.bytedance.sdk.openadsdk.We.ExN.pFF.zY
    public void sc(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("preload_url", this.f27313sc);
            jSONObject.put("preload_size", this.pFF);
            jSONObject.put("load_time", this.zY);
            jSONObject.put("local_cache", this.We);
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.Tf.sc("LoadVideoSuccessModel", th2.getMessage());
        }
    }

    public void zY(long j11) {
        this.We = j11;
    }
}
