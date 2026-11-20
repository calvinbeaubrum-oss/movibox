package com.bytedance.sdk.openadsdk.We.ExN.pFF;

import com.hisavana.common.tracking.TrackingKey;
import org.json.JSONObject;
import x8.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class SR implements zY {
    private final String ExN;
    private final int We;
    private long pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private long f27311sc;
    private final int zY;

    public SR(b bVar) {
        this.zY = bVar.b();
        this.We = bVar.a();
        this.ExN = bVar.d();
    }

    public void pFF(long j11) {
        this.pFF = j11;
    }

    public void sc(long j11) {
        this.f27311sc = j11;
    }

    @Override // com.bytedance.sdk.openadsdk.We.ExN.pFF.zY
    public void sc(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("buffers_time", this.f27311sc);
            jSONObject.put("total_duration", this.pFF);
            jSONObject.put(TrackingKey.ERROR_CODE, this.zY);
            jSONObject.put("extra_error_code", this.We);
            jSONObject.put(TrackingKey.ERROR_MESSAGE, this.ExN);
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.Tf.sc("PlayErrorModel", th2.getMessage());
        }
    }
}
