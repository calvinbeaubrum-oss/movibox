package com.bytedance.sdk.openadsdk.core.zY;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener;
import com.bytedance.sdk.openadsdk.core.Ol;
import com.bytedance.sdk.openadsdk.core.Qj.Sfl;
import com.bytedance.sdk.openadsdk.utils.kX;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class zY extends com.bytedance.sdk.openadsdk.core.ExN.zY {
    protected PAGBannerAdWrapperListener ExN;
    protected String TRI;
    protected AdSlot We;
    protected Sfl pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    protected final Context f28598sc;
    protected com.bytedance.sdk.openadsdk.core.model.Sfl zY;

    public zY(@NonNull Context context, com.bytedance.sdk.openadsdk.core.model.Sfl sfl, AdSlot adSlot) {
        super(context);
        this.TRI = "banner_ad";
        this.f28598sc = context;
        this.zY = sfl;
        this.We = adSlot;
        sc();
        AdSlot adSlot2 = this.We;
        if (adSlot2 != null) {
            sc(adSlot2.getExpressViewAcceptedWidth(), this.We.getExpressViewAcceptedHeight());
        }
    }

    public Sfl getCurView() {
        return this.pFF;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.pFF == null) {
            sc();
        }
        com.bytedance.sdk.openadsdk.utils.zY.sc(this, this.zY);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void pFF() {
        Sfl sfl = this.pFF;
        if (sfl != null) {
            sfl.Ol();
        }
    }

    public void sc() {
        Sfl sfl = new Sfl(this.f28598sc, this.zY, this.We, this.TRI);
        this.pFF = sfl;
        addView(sfl, new ViewGroup.LayoutParams(-1, -1));
        PAGBannerAdWrapperListener pAGBannerAdWrapperListener = this.ExN;
        if (pAGBannerAdWrapperListener != null) {
            setExpressInteractionListener(pAGBannerAdWrapperListener);
        }
    }

    public void sc(float f11, float f12) {
        int iZY = kX.zY(this.f28598sc, f11);
        int iZY2 = kX.zY(this.f28598sc, f12);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(iZY, iZY2);
        }
        layoutParams.width = iZY;
        layoutParams.height = iZY2;
        setLayoutParams(layoutParams);
    }

    public void setExpressInteractionListener(PAGBannerAdWrapperListener pAGBannerAdWrapperListener) {
        this.ExN = pAGBannerAdWrapperListener;
        Sfl sfl = this.pFF;
        if (sfl != null) {
            sfl.setJsbLandingPageOpenListener(new com.bytedance.sdk.openadsdk.core.widget.TRI() { // from class: com.bytedance.sdk.openadsdk.core.zY.zY.1
                @Override // com.bytedance.sdk.openadsdk.core.widget.TRI
                public void sc() {
                    zY.this.ExN.onAdClicked();
                }
            });
            this.pFF.setExpressInteractionListener(new PAGExpressAdWrapperListener() { // from class: com.bytedance.sdk.openadsdk.core.zY.zY.2
                @Override // com.bytedance.sdk.openadsdk.api.PAGAdWrapperListener
                public void onAdClicked() {
                    PAGBannerAdWrapperListener pAGBannerAdWrapperListener2;
                    com.bytedance.sdk.openadsdk.core.model.Sfl sfl2 = zY.this.zY;
                    if (sfl2 == null || !sfl2.Pu() || (pAGBannerAdWrapperListener2 = zY.this.ExN) == null) {
                        return;
                    }
                    pAGBannerAdWrapperListener2.onAdClicked();
                }

                @Override // com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener
                public void onAdDismissed() {
                }

                @Override // com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener
                public void onAdShow(View view, int i11) {
                }

                @Override // com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener
                public void onRenderFail(View view, String str, int i11) {
                    zY zYVar = zY.this;
                    PAGBannerAdWrapperListener pAGBannerAdWrapperListener2 = zYVar.ExN;
                    if (pAGBannerAdWrapperListener2 != null) {
                        pAGBannerAdWrapperListener2.onRenderFail(zYVar, str, i11);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener
                public void onRenderSuccess(View view, float f11, float f12) {
                    Sfl sfl2 = zY.this.pFF;
                    if (sfl2 != null) {
                        sfl2.setSoundMute(true);
                    }
                    Sfl sfl3 = zY.this.pFF;
                    if (sfl3 != null && !com.bytedance.sdk.openadsdk.core.UFX.zY.sc(sfl3.getDynamicShowType())) {
                        zY.this.sc(f11, f12);
                    }
                    zY zYVar = zY.this;
                    PAGBannerAdWrapperListener pAGBannerAdWrapperListener2 = zYVar.ExN;
                    if (pAGBannerAdWrapperListener2 != null) {
                        pAGBannerAdWrapperListener2.onRenderSuccess(zYVar, f11, f12);
                    }
                }
            });
        }
    }

    public void zY() {
        if (this.pFF != null) {
            Ol.pFF().TRI(this.pFF.getClosedListenerKey());
            removeView(this.pFF);
            this.pFF.UFX();
            this.pFF = null;
        }
        Ol.pFF().Dl();
    }
}
