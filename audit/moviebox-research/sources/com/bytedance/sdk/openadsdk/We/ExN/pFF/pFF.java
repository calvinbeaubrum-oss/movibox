package com.bytedance.sdk.openadsdk.We.ExN.pFF;

import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class pFF implements zY {
    private int We;
    private long pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private long f27317sc;
    private int zY;

    public void pFF(int i11) {
        this.We = i11;
    }

    public void pFF(long j11) {
        this.pFF = j11;
    }

    public void sc(int i11) {
        this.zY = i11;
    }

    public void sc(long j11) {
        this.f27317sc = j11;
    }

    @Override // com.bytedance.sdk.openadsdk.We.ExN.pFF.zY
    public void sc(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("buffers_time", this.f27317sc);
            jSONObject.put("total_duration", this.pFF);
            jSONObject.put("vbtt_skip_type", this.zY);
            jSONObject.put("skip_reason", this.We);
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.Tf.sc("EndcardSkipModel", th2.getMessage());
        }
    }
}
