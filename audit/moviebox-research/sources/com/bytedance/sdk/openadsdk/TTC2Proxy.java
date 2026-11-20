package com.bytedance.sdk.openadsdk;

import android.content.Context;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAdLoadListener;
import com.bytedance.sdk.openadsdk.component.qr;
import com.bytedance.sdk.openadsdk.component.qr.sc;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class TTC2Proxy {
    private TTC2Proxy() {
    }

    public static void a(Context context) {
        sc.sc(context);
    }

    public static void load(Context context, AdSlot adSlot, PAGAppOpenAdLoadListener pAGAppOpenAdLoadListener, int i11) {
        adSlot.setDurationSlotType(3);
        qr.sc(context).sc(adSlot, pAGAppOpenAdLoadListener, i11);
    }
}
