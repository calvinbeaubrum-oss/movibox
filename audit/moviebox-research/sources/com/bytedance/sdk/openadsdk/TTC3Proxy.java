package com.bytedance.sdk.openadsdk;

import android.content.Context;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdLoadListener;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdLoadListener;
import com.bytedance.sdk.openadsdk.component.reward.ExN;
import com.bytedance.sdk.openadsdk.component.reward.Tf;
import com.bytedance.sdk.openadsdk.component.reward.WH;
import com.bytedance.sdk.openadsdk.component.reward.qr;
import com.bytedance.sdk.openadsdk.component.zY.pFF;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class TTC3Proxy {
    public static void a(Context context) {
        try {
            Tf.sc(context).sc();
        } catch (Throwable unused) {
        }
        try {
            ExN.sc(context).sc();
        } catch (Throwable unused2) {
        }
    }

    public static void loadFull(Context context, AdSlot adSlot, PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener) {
        adSlot.setDurationSlotType(8);
        ExN.sc(context).sc(adSlot, new pFF(pAGInterstitialAdLoadListener));
    }

    public static void loadReward(Context context, AdSlot adSlot, PAGRewardedAdLoadListener pAGRewardedAdLoadListener) {
        adSlot.setDurationSlotType(7);
        Tf.sc(context).sc(adSlot, new qr(pAGRewardedAdLoadListener));
    }

    public static void verityPlayable(String str, int i11, String str2, String str3, String str4) {
        WH.sc(str, i11, str2, str3, str4);
    }
}
