package com.mbridge.msdk.foundation.same.report;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.z;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class r {
    public static JSONObject a(Context context, com.mbridge.msdk.c.g gVar) throws Exception {
        JSONObject jSONObject = new JSONObject();
        if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            String strL = z.l();
            if (!TextUtils.isEmpty(strL)) {
                jSONObject.put("manufacturer", strL);
            }
            int iK = z.k();
            if (iK != -1) {
                jSONObject.put("sdkint", iK);
            }
            String strM = z.m(context);
            if (!TextUtils.isEmpty(strM)) {
                jSONObject.put("is24H", strM);
            }
            String strP = z.p();
            if (!TextUtils.isEmpty(strP)) {
                jSONObject.put("totalram", strP);
            }
            String strN = z.n(context);
            if (!TextUtils.isEmpty(strN)) {
                jSONObject.put("totalmemory", strN);
            }
            jSONObject.put("adid_limit", com.mbridge.msdk.foundation.tools.e.a() + "");
            jSONObject.put("adid_limit_dev", com.mbridge.msdk.foundation.controller.authoritycontroller.b.b() ? "1" : "0");
        }
        if (gVar.au() == 1 && !TextUtils.isEmpty(com.mbridge.msdk.foundation.tools.e.d()) && com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
            jSONObject.put("az_aid_info", com.mbridge.msdk.foundation.tools.e.d());
        }
        return jSONObject;
    }
}
