package com.bytedance.sdk.openadsdk.We.ExN.pFF;

import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class qr implements zY {
    private long pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private long f27318sc;

    public void pFF(long j11) {
        this.pFF = j11;
    }

    public void sc(long j11) {
        this.f27318sc = j11;
    }

    @Override // com.bytedance.sdk.openadsdk.We.ExN.pFF.zY
    public void sc(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("buffers_time", this.f27318sc);
            jSONObject.put("total_duration", this.pFF);
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.Tf.sc("FeedPauseModel", th2.getMessage());
        }
    }
}
