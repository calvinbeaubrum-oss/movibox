package com.bytedance.sdk.openadsdk.We.ExN.pFF;

import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class TRI implements zY {
    private long pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private long f27312sc;
    private int zY = 0;

    public void pFF(long j11) {
        this.pFF = j11;
    }

    public void sc(int i11) {
        this.zY = i11;
    }

    public void sc(long j11) {
        this.f27312sc = j11;
    }

    @Override // com.bytedance.sdk.openadsdk.We.ExN.pFF.zY
    public void sc(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("total_duration", this.f27312sc);
            jSONObject.put("buffers_time", this.pFF);
            jSONObject.put("video_backup", this.zY);
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.Tf.sc("FeedOverModel", th2.getMessage());
        }
    }
}
