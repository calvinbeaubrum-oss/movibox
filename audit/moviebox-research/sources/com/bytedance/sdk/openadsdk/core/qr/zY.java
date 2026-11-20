package com.bytedance.sdk.openadsdk.core.qr;

import com.bytedance.sdk.component.qr.pFF.We;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.utils.cJ;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class zY {
    private static JSONObject pFF(String str, long j11) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "over_freq");
            jSONObject.put("rit", str);
            jSONObject.put("ad_sdk_version", BuildConfig.VERSION_NAME);
            jSONObject.put(CampaignEx.JSON_KEY_TIMESTAMP, j11);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public static void sc(String str, long j11) {
        JSONObject jSONObjectPFF = pFF(str, j11);
        We wePFF = com.bytedance.sdk.openadsdk.Xc.zY.sc().pFF().pFF();
        wePFF.pFF(cJ.We("/api/ad/union/sdk/stats/"));
        wePFF.We(jSONObjectPFF.toString());
        wePFF.sc(6);
        wePFF.sc("uploadFrequentEvent");
        wePFF.sc(new com.bytedance.sdk.component.qr.sc.sc() { // from class: com.bytedance.sdk.openadsdk.core.qr.zY.1
            @Override // com.bytedance.sdk.component.qr.sc.sc
            public void sc(com.bytedance.sdk.component.qr.pFF.zY zYVar, com.bytedance.sdk.component.qr.pFF pff) {
            }

            @Override // com.bytedance.sdk.component.qr.sc.sc
            public void sc(com.bytedance.sdk.component.qr.pFF.zY zYVar, IOException iOException) {
                iOException.getMessage();
            }
        });
    }
}
