package com.bytedance.sdk.openadsdk.core.zY;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener;
import com.bytedance.sdk.openadsdk.core.Qj.wjp;
import com.bytedance.sdk.openadsdk.core.model.Sfl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class pFF extends zY {
    public pFF(@NonNull Context context, Sfl sfl, AdSlot adSlot) {
        super(context, sfl, adSlot);
    }

    public com.bytedance.sdk.openadsdk.multipro.pFF.sc getVideoModel() {
        com.bytedance.sdk.openadsdk.core.Qj.Sfl sfl = this.pFF;
        if (sfl != null) {
            return ((wjp) sfl).getVideoModel();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.zY.zY
    public void sc() {
        wjp wjpVar = new wjp(this.f28598sc, this.zY, this.We, this.TRI);
        this.pFF = wjpVar;
        addView(wjpVar, new ViewGroup.LayoutParams(-1, -1));
        PAGBannerAdWrapperListener pAGBannerAdWrapperListener = this.ExN;
        if (pAGBannerAdWrapperListener != null) {
            setExpressInteractionListener(pAGBannerAdWrapperListener);
        }
    }
}
