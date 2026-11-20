package com.bytedance.sdk.openadsdk.We.ExN.pFF;

import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class Ql implements zY {
    public int pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public long f27310sc;
    public long zY;

    public void pFF(long j11) {
        this.zY = j11;
    }

    public void sc(int i11) {
        this.pFF = i11;
    }

    public void sc(long j11) {
        this.f27310sc = j11;
    }

    @Override // com.bytedance.sdk.openadsdk.We.ExN.pFF.zY
    public void sc(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("buffers_time", this.f27310sc);
            jSONObject.put("buffers_count", this.pFF);
            jSONObject.put("total_duration", this.zY);
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.Tf.sc("PlayBufferModel", th2.getMessage());
        }
    }
}
