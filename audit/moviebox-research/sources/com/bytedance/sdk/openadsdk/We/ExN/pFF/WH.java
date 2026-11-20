package com.bytedance.sdk.openadsdk.We.ExN.pFF;

import com.hisavana.common.tracking.TrackingKey;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class WH implements zY {
    private String ExN;
    private String TRI;
    private int We;
    private long pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private String f27315sc;
    private long zY;

    public void pFF(long j11) {
        this.zY = j11;
    }

    public void pFF(String str) {
        this.ExN = str;
    }

    public void sc(int i11) {
        this.We = i11;
    }

    public void sc(long j11) {
        this.pFF = j11;
    }

    public void sc(String str) {
        this.f27315sc = str;
    }

    @Override // com.bytedance.sdk.openadsdk.We.ExN.pFF.zY
    public void sc(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("preload_url", this.f27315sc);
            jSONObject.put("preload_size", this.pFF);
            jSONObject.put("load_time", this.zY);
            jSONObject.put(TrackingKey.ERROR_CODE, this.We);
            jSONObject.put(TrackingKey.ERROR_MESSAGE, this.ExN);
            jSONObject.put("error_message_server", this.TRI);
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.Tf.sc("LoadVideoErrorModel", th2.getMessage());
        }
    }

    public void zY(String str) {
        this.TRI = str;
    }
}
