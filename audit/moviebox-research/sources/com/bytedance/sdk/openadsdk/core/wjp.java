package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebView;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class wjp {
    public static void sc(Context context, boolean z11, JSONObject jSONObject, com.bytedance.sdk.openadsdk.core.model.Sfl sfl, String str, int i11, WebView webView, com.bytedance.sdk.openadsdk.core.widget.TRI tri) {
        int iOptInt = jSONObject.optInt("landingStyle");
        String strOptString = jSONObject.optString("url");
        String strOptString2 = jSONObject.optString("fallback_url");
        try {
            jSONObject.put("is_activity", z11);
        } catch (JSONException unused) {
        }
        boolean z12 = true;
        com.bytedance.sdk.openadsdk.We.zY.sc(sfl, str, 1, jSONObject);
        if (TextUtils.isEmpty(strOptString)) {
            return;
        }
        if (iOptInt == 0) {
            if (webView != null) {
                webView.loadUrl(strOptString);
                com.bytedance.sdk.openadsdk.We.zY.sc(sfl, str, 2, (JSONObject) null);
            } else {
                com.bytedance.sdk.openadsdk.We.zY.sc(sfl, str, -1, (JSONObject) null);
            }
        } else if (iOptInt == 1 || iOptInt == 8) {
            com.bytedance.sdk.openadsdk.SR.sc.pFF pff = new com.bytedance.sdk.openadsdk.SR.sc.pFF();
            pff.sc(com.bytedance.sdk.openadsdk.We.pFF.sc.pFF);
            pff.sc(sfl);
            pff.pFF(str);
            pff.sc(-1);
            pff.sc(false);
            pff.pFF(sfl.QLv());
            com.bytedance.sdk.openadsdk.We.zY.sc(pff);
            com.bytedance.sdk.openadsdk.utils.YIK.sc(context, strOptString, sfl, com.bytedance.sdk.openadsdk.We.pFF.sc.pFF);
        } else if (iOptInt == 2) {
            if (!com.bytedance.sdk.openadsdk.utils.YIK.pFF(context, strOptString, sfl, str)) {
                com.bytedance.sdk.openadsdk.SR.sc.pFF pff2 = new com.bytedance.sdk.openadsdk.SR.sc.pFF();
                pff2.sc(com.bytedance.sdk.openadsdk.We.pFF.sc.pFF);
                pff2.sc(sfl);
                pff2.pFF(str);
                pff2.sc(-1);
                pff2.sc(false);
                pff2.pFF(sfl.QLv());
                com.bytedance.sdk.openadsdk.We.zY.sc(pff2);
                HashMap map = new HashMap();
                map.put("deeplink_url", strOptString);
                map.put("fallback_url", strOptString2);
                map.put("jsb_deeplink", 1);
                com.bytedance.sdk.openadsdk.We.zY.sc(sfl, str, "open_fallback_url", map);
                com.bytedance.sdk.openadsdk.utils.YIK.sc(context, strOptString2, sfl, com.bytedance.sdk.openadsdk.We.pFF.sc.pFF);
            }
        } else if (iOptInt != 3) {
            z12 = false;
        } else if (cD.pFF(context, strOptString, sfl, i11, str, false)) {
            com.bytedance.sdk.openadsdk.We.zY.sc(sfl, str, 3, (JSONObject) null);
        } else {
            com.bytedance.sdk.openadsdk.We.zY.sc(sfl, str, -2, (JSONObject) null);
        }
        if (tri == null || !z12) {
            return;
        }
        tri.sc();
    }
}
