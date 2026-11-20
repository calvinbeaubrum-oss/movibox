package com.cloud.tmc.kernel.extension;

import android.text.TextUtils;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.google.gson.JsonObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class a {
    public static void a(BridgeExtension bridgeExtension, bc.a aVar, String str, Boolean bool) {
        if (aVar != null) {
            try {
                JsonObject jsonObject = new JsonObject();
                if (TextUtils.isEmpty(str)) {
                    str = "";
                }
                jsonObject.addProperty("failMsg", str);
                TmcLogger.f("BridgeAPI", bridgeExtension.getClass().getSimpleName() + ", call api fail:" + str);
                aVar.e(jsonObject);
                if (bool.booleanValue()) {
                    aVar.close();
                }
            } catch (Throwable th2) {
                TmcLogger.c("BridgeAPI", "callbackFail error:" + th2.getMessage());
            }
        }
    }
}
