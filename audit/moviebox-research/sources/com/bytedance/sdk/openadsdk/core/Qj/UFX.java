package com.bytedance.sdk.openadsdk.core.Qj;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class UFX {
    private static int sc(String str) {
        str.hashCode();
        switch (str) {
            case "banner_ad":
                return 1;
            case "rewarded_video":
                return 7;
            case "open_ad":
                return 3;
            case "fullscreen_interstitial_ad":
                return 8;
            case "interaction":
                return 2;
            default:
                return 5;
        }
    }

    public static void sc(String str, int i11, String str2, String str3, String str4, com.bytedance.sdk.openadsdk.core.model.Sfl sfl) {
        if (TextUtils.isEmpty(str2)) {
            str2 = com.bytedance.sdk.openadsdk.core.Qj.sc(i11);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("render_source", str);
            com.bytedance.sdk.openadsdk.core.model.Sfl.sc scVarJoC = sfl.JoC();
            if (scVarJoC != null) {
                jSONObject.put("tpl_id", scVarJoC.TRI());
                if ("Web".equals(str)) {
                    if (scVarJoC.SR()) {
                        jSONObject.put("engine_version", "v3");
                    } else {
                        jSONObject.put("engine_version", "v1");
                    }
                }
            } else if (sfl.qKn() != null) {
                jSONObject.put("tpl_id", sfl.qKn().sc());
                if ("Web".equals(str)) {
                    jSONObject.put("engine_version", "v3");
                }
            }
        } catch (Exception unused) {
        }
        com.bytedance.sdk.openadsdk.SR.zY.sc().sc(com.bytedance.sdk.openadsdk.SR.sc.We.pFF().sc(sc(str3)).zY(str4).ExN(sfl != null ? sfl.ofL() : "").pFF(i11).pFF(jSONObject.toString()).TRI(str2));
    }
}
