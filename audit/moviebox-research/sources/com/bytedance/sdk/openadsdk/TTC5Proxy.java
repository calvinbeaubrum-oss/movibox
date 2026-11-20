package com.bytedance.sdk.openadsdk;

import android.content.Context;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdLoadListener;
import com.bytedance.sdk.openadsdk.component.pFF.sc;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class TTC5Proxy {
    public static void loadFeed(Context context, AdSlot adSlot, PAGNativeAdLoadListener pAGNativeAdLoadListener) {
        adSlot.setDurationSlotType(5);
        sc.sc().sc(context, adSlot, pAGNativeAdLoadListener);
    }
}
