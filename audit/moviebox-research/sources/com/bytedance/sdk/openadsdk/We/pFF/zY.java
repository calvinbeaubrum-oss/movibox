package com.bytedance.sdk.openadsdk.We.pFF;

import com.hisavana.common.tracking.TrackingKey;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class zY implements pFF {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    pFF f27375sc;

    @Override // com.bytedance.sdk.openadsdk.We.pFF.pFF
    public void sc(JSONObject jSONObject, long j11) throws JSONException {
        pFF pff = this.f27375sc;
        if (pff != null) {
            pff.sc(jSONObject, j11);
        }
        if (j11 <= 0) {
            j11 = System.currentTimeMillis();
        }
        jSONObject.put(TrackingKey.EVENT_TS, j11);
    }
}
