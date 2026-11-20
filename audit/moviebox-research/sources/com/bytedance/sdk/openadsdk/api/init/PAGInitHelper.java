package com.bytedance.sdk.openadsdk.api.init;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.Xc.pFF;
import com.bytedance.sdk.openadsdk.common.ExN;
import com.bytedance.sdk.openadsdk.core.Ol;
import com.bytedance.sdk.openadsdk.core.Ol.zY;
import com.bytedance.sdk.openadsdk.core.SR;
import com.bytedance.sdk.openadsdk.core.Tf;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.core.act.sc;
import com.bytedance.sdk.openadsdk.multipro.We.We;
import com.bytedance.sdk.openadsdk.utils.HJN;
import com.bytedance.sdk.openadsdk.utils.JPJ;
import com.bytedance.sdk.openadsdk.utils.kX;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class PAGInitHelper {
    public static final List<PAGSdk.PAGInitCallback> CALLBACK_LIST = new ArrayList();
    public static float animationScale = 1.0f;

    public static void initAPM() {
        if (ExN.sc()) {
            return;
        }
        try {
            String strWe = Ol.pFF().We();
            if (TextUtils.isEmpty(strWe)) {
                return;
            }
            ApmHelper.initApm(Xc.sc(), new PAGConfig.Builder().appId(strWe).build());
        } catch (Exception unused) {
        }
    }

    public static void initAnimationScale(Context context) {
        try {
            float f11 = Settings.System.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f);
            animationScale = f11;
            if (f11 <= 0.0f) {
                animationScale = 1.0f;
            }
        } catch (Throwable unused) {
            animationScale = 1.0f;
        }
    }

    public static void initMemoryData() {
        Xc.We();
        We.sc("ttopenadsdk", "a", 0);
        We.sc("sp_global_file", "a", 0);
        We.sc("sp_global_privacy", "a", 0);
        We.sc("sp_global_app_id", "a", 0);
        We.sc("sp_global_icon_id", "a", 0);
        We.sc(pFF.f27476sc, "a", 0);
        We.sc("tpl_fetch_model", "a", 0);
        We.sc("tt_sp", "a", 0);
        We.sc("tt_sdk_event_net_ad", "a", 0);
        We.sc("tt_sdk_event_net_state", "a", 0);
        We.sc("tt_sdk_event_net_trail", "a", 0);
        We.sc("tt_sdk_event_db_ad", "a", 0);
        We.sc("tt_sdk_event_db_state", "a", 0);
        We.sc("tt_sdk_event_db_trail", "a", 0);
        We.sc("pag_sp_bad_par", "did");
        We.sc("pag_sp_bad_par", "gaid");
    }

    public static void maybeAsyncInitTask(final Context context) {
        sc.sc(context);
        HJN.sc();
        kX.sc(context);
        sc(context);
        Xc.ExN();
        String strSc = Tf.sc(context);
        zY.pFF(strSc);
        com.bytedance.sdk.openadsdk.We.sc.We.sc(strSc, true);
        com.bytedance.sdk.component.adexpress.sc.pFF.pFF.sc();
        com.bytedance.sdk.openadsdk.core.Ql.zY.sc.sc().pFF();
        initAnimationScale(context);
        SR.pFF().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGInitHelper.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.SR.zY.sc();
                com.bytedance.sdk.openadsdk.SR.zY.sc("android_act", false, new com.bytedance.sdk.openadsdk.SR.pFF() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGInitHelper.1.1
                    @Override // com.bytedance.sdk.openadsdk.SR.pFF
                    public com.bytedance.sdk.openadsdk.SR.sc.zY getLogStats() throws Exception {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("act", sc.pFF(context));
                            jSONObject.put("api_available", sc.pFF());
                            jSONObject.put("act_signals_callback_available", sc.zY());
                            jSONObject.put("act_event", sc.sc());
                        } catch (Throwable th2) {
                            com.bytedance.sdk.component.utils.Tf.sc("AsyncInitTask", "run: ", th2);
                        }
                        return com.bytedance.sdk.openadsdk.SR.sc.We.pFF().sc("android_act").pFF(jSONObject.toString());
                    }
                });
            }
        }, 10000L);
    }

    private static void sc(Context context) {
        com.bytedance.sdk.openadsdk.core.zY.sc(context).sc("uuid", JPJ.sc());
    }
}
