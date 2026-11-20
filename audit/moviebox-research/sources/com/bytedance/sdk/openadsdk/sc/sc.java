package com.bytedance.sdk.openadsdk.sc;

import android.text.TextUtils;
import com.bytedance.sdk.component.Qj.Qj;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.api.PAGErrorCode;
import com.bytedance.sdk.openadsdk.api.PAGLoadListener;
import com.bytedance.sdk.openadsdk.api.PAGRequest;
import com.bytedance.sdk.openadsdk.core.SR;
import com.bytedance.sdk.openadsdk.dE.We;
import com.bytedance.sdk.openadsdk.dE.zY;
import com.bytedance.sdk.openadsdk.utils.Cb;
import com.bytedance.sdk.openadsdk.utils.cJ;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc {
    public static void sc(final Qj qj2, final PAGLoadListener pAGLoadListener, final AdSlot adSlot) {
        Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.openadsdk.sc.sc.1
            @Override // java.lang.Runnable
            public void run() {
                if (SR.ExN()) {
                    zY.sc(new We() { // from class: com.bytedance.sdk.openadsdk.sc.sc.1.1
                        @Override // com.bytedance.sdk.openadsdk.dE.We
                        public com.bytedance.sdk.openadsdk.dE.pFF.sc generatorModel() {
                            com.bytedance.sdk.openadsdk.dE.pFF.sc scVar = new com.bytedance.sdk.openadsdk.dE.pFF.sc();
                            scVar.pFF("load_ad");
                            scVar.zY(adSlot.getCodeId());
                            scVar.We(cJ.zY(adSlot.getDurationSlotType()));
                            scVar.sc(BuildConfig.VERSION_NAME);
                            scVar.qr(cJ.sc(adSlot).toString());
                            return scVar;
                        }
                    });
                    Cb.We(qj2);
                    return;
                }
                Tf.sc("AdLoadBaseManager", "please exec TTAdSdk.init before load ad");
                PAGLoadListener pAGLoadListener2 = pAGLoadListener;
                if (pAGLoadListener2 != null) {
                    pAGLoadListener2.onError(10000, "Please exec TTAdSdk.init before load ad");
                }
            }
        };
        if (SR.ExN()) {
            runnable.run();
        } else {
            SR.pFF().post(runnable);
        }
    }

    public static void sc(AdSlot.Builder builder, PAGRequest pAGRequest) {
        Map<String, Object> extraInfo;
        if (!SR.ExN() || pAGRequest == null || builder == null || (extraInfo = pAGRequest.getExtraInfo()) == null) {
            return;
        }
        if (extraInfo.containsKey("ad_id") && extraInfo.get("ad_id") != null) {
            builder.setAdId(extraInfo.get("ad_id").toString());
        }
        if (extraInfo.containsKey(CampaignEx.JSON_KEY_CREATIVE_ID) && extraInfo.get(CampaignEx.JSON_KEY_CREATIVE_ID) != null) {
            builder.setCreativeId(extraInfo.get(CampaignEx.JSON_KEY_CREATIVE_ID).toString());
        }
        if (extraInfo.containsKey("ext") && extraInfo.get("ext") != null) {
            builder.setExt(extraInfo.get("ext").toString());
        }
        if (!extraInfo.containsKey("media_extra") || extraInfo.get("media_extra") == null) {
            return;
        }
        builder.setMediaExtra(extraInfo.get("media_extra").toString());
    }

    public static boolean sc(PAGLoadListener pAGLoadListener) {
        if (com.bytedance.sdk.openadsdk.core.settings.Tf.sc()) {
            return false;
        }
        if (pAGLoadListener == null) {
            return true;
        }
        pAGLoadListener.onError(1000, "Ad request is temporarily paused, Please contact your Pangle AM");
        return true;
    }

    public static boolean sc(String str, PAGRequest pAGRequest, PAGLoadListener pAGLoadListener) {
        if (TextUtils.isEmpty(str) && pAGLoadListener != null) {
            pAGLoadListener.onError(1, PAGErrorCode.PAGAdErrorCodeSlotIdNULLMsg);
            return true;
        }
        if (pAGRequest != null || pAGLoadListener == null) {
            return false;
        }
        pAGLoadListener.onError(2, PAGErrorCode.PAGAdErrorCodeRequestNULLMsg);
        return true;
    }
}
