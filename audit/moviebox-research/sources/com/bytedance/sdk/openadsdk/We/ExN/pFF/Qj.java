package com.bytedance.sdk.openadsdk.We.ExN.pFF;

import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class Qj implements zY {
    private long pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private long f27309sc;
    private int zY;

    public void pFF(long j11) {
        this.pFF = j11;
    }

    public void sc(int i11) {
        this.zY = i11;
    }

    public void sc(long j11) {
        this.f27309sc = j11;
    }

    @Override // com.bytedance.sdk.openadsdk.We.ExN.pFF.zY
    public void sc(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("video_start_duration", this.f27309sc);
            jSONObject.put("video_cache_size", this.pFF);
            jSONObject.put("is_auto_play", this.zY);
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.Tf.sc("FeedPlayModel", th2.getMessage());
        }
    }
}
