package com.bytedance.sdk.openadsdk.We.ExN.pFF;

import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class We implements zY {
    public int We = 0;
    public long pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public long f27316sc;
    public int zY;

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
        this.f27316sc = j11;
    }

    @Override // com.bytedance.sdk.openadsdk.We.ExN.pFF.zY
    public void sc(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("total_duration", this.f27316sc);
            jSONObject.put("buffers_time", this.pFF);
            jSONObject.put("break_reason", this.zY);
            jSONObject.put("video_backup", this.We);
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.Tf.sc("FeedBreakModel", th2.getMessage());
        }
    }
}
