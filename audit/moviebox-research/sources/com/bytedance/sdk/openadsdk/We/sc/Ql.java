package com.bytedance.sdk.openadsdk.We.sc;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.hisavana.common.tracking.TrackingKey;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class Ql implements com.bytedance.sdk.openadsdk.SR.pFF {
    private final boolean pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final com.bytedance.sdk.component.TRI.sc.TRI.We f27385sc;

    public Ql(boolean z11, com.bytedance.sdk.component.TRI.sc.TRI.We we2) {
        this.f27385sc = we2;
        this.pFF = z11;
    }

    @Override // com.bytedance.sdk.openadsdk.SR.pFF
    @Nullable
    public com.bytedance.sdk.openadsdk.SR.sc.zY getLogStats() throws Exception {
        int i11;
        if (this.f27385sc == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("success", this.pFF);
        jSONObject.put("url", this.f27385sc.pFF());
        int iWe = this.f27385sc.We();
        if (iWe <= 0) {
            iWe = 0;
        }
        jSONObject.put("retry_times", iWe);
        jSONObject.put("ad_id", this.f27385sc.TRI());
        jSONObject.put("track_type", this.f27385sc.ExN());
        if (!this.pFF) {
            i11 = 4;
        } else if (this.f27385sc.WH()) {
            i11 = 3;
        } else {
            i11 = this.f27385sc.We() <= 0 ? 1 : 2;
        }
        jSONObject.put("upload_scene", i11);
        String strQr = this.f27385sc.qr();
        if (!TextUtils.isEmpty(strQr)) {
            JSONArray jSONArray = new JSONArray();
            for (String str : strQr.split(",")) {
                jSONArray.put(str);
            }
            jSONObject.put(TrackingKey.ERROR_CODE, jSONArray);
        }
        String strOl = this.f27385sc.Ol();
        if (!TextUtils.isEmpty(strOl)) {
            JSONArray jSONArray2 = new JSONArray();
            for (String str2 : strOl.split(",")) {
                jSONArray2.put(str2);
            }
            jSONObject.put("error_msg", jSONArray2);
        }
        return com.bytedance.sdk.openadsdk.SR.sc.We.pFF().sc("track_link_result").pFF(jSONObject.toString());
    }
}
