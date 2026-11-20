package com.bytedance.sdk.openadsdk.core.Ql.zY;

import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.openadsdk.core.model.JPJ;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.hisavana.common.tracking.TrackingKey;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class pFF {
    public static void sc(Sfl sfl) {
        if (JPJ.pFF(sfl)) {
            com.bytedance.sdk.openadsdk.We.zY.pFF(sfl, "playable_preload", "preload_start", (JSONObject) null);
        }
    }

    public static void sc(Sfl sfl, int i11, String str) {
        if (sfl != null) {
            if (JPJ.zY(sfl) || JPJ.pFF(sfl)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(TrackingKey.ERROR_CODE, i11);
                    jSONObject.put("error_reason", str);
                } catch (JSONException e11) {
                    Tf.sc("PlayableEvent", "onFail json error", e11);
                }
                com.bytedance.sdk.openadsdk.We.zY.pFF(sfl, "playable_preload", "preload_fail", jSONObject);
            }
        }
    }

    public static void sc(Sfl sfl, long j11, long j12) {
        if (sfl != null) {
            if (JPJ.zY(sfl) || JPJ.pFF(sfl)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("loadzip_success_time", j11);
                    jSONObject.put("unzip_success_time", j12);
                } catch (JSONException e11) {
                    Tf.sc("PlayableEvent", "onSuccess json error", e11);
                }
                com.bytedance.sdk.openadsdk.We.zY.pFF(sfl, "playable_preload", "preload_success", jSONObject);
            }
        }
    }
}
