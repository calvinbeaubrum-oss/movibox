package com.hisavana.pangle.executer;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.api.init.PAGSdk;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdInteractionListener;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdLoadListener;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeRequest;
import com.cloud.sdk.commonutil.util.f;
import com.hisavana.common.base.BaseAd;
import com.hisavana.common.base.BaseNative;
import com.hisavana.common.bean.AdNativeInfo;
import com.hisavana.common.bean.Network;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.bean.TAdNativeInfo;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.common.utils.AdUtil;
import com.hisavana.pangle.check.ExistsCheck;
import com.hisavana.pangle.util.PlatformUtil;
import com.transsion.push.PushConstants;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class PangleNative extends BaseNative {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public PAGNativeAdLoadListener f42037j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public PAGNativeAdInteractionListener f42038k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public PAGNativeAd f42039l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public AdNativeInfo f42040m;

    public PangleNative(Context context, Network network, int i11) {
        super(context, network, i11);
        this.f42037j = new PAGNativeAdLoadListener() { // from class: com.hisavana.pangle.executer.PangleNative.1
            @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
            public void onAdLoaded(PAGNativeAd pAGNativeAd) {
                AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, "onAdLoad");
                PangleNative.this.f42039l = pAGNativeAd;
                if (PangleNative.this.f42039l == null || PangleNative.this.f42039l.getNativeAdData() == null) {
                    return;
                }
                TAdNativeInfo tAdNativeInfo = PlatformUtil.getTAdNativeInfo(pAGNativeAd, ((BaseNative) PangleNative.this).mAdt, PangleNative.this.getTtl(), PangleNative.this);
                int iFilter = PangleNative.this.filter(tAdNativeInfo);
                if (iFilter == 0) {
                    ((BaseNative) PangleNative.this).mNatives.add(tAdNativeInfo);
                } else {
                    AdUtil.release(tAdNativeInfo);
                }
                if (!((BaseNative) PangleNative.this).mNatives.isEmpty()) {
                    PangleNative pangleNative = PangleNative.this;
                    pangleNative.adLoaded(((BaseNative) pangleNative).mNatives);
                    return;
                }
                PangleNative.this.adFailedToLoad(new TAdErrorCode(iFilter, "ad filter"));
                AdLogUtil.Log().w(ExistsCheck.PANGLE_TAG, "ad not pass sensitive check or no icon or image filter:" + iFilter);
            }

            @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.TRI
            public void onError(int i12, String str) {
                PangleNative.this.adFailedToLoad(new TAdErrorCode(i12, "Pangle Ads failed to load ad with error message: " + str));
                AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, "Pangle Ads failed to load ad with error code：" + i12 + "，message: " + str);
            }
        };
        this.f42038k = new PAGNativeAdInteractionListener() { // from class: com.hisavana.pangle.executer.PangleNative.2
            @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
            public void onAdClicked() {
                AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, "Pangle Ads onAdClick");
                PangleNative pangleNative = PangleNative.this;
                pangleNative.adClicked(pangleNative.f42040m);
            }

            @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
            public void onAdDismissed() {
                AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, "Pangle Ads onAdDismissed");
                PangleNative.this.adClosed();
            }

            @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
            public void onAdShowed() {
                AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, "Pangle Ads onAdShowed");
                PangleNative pangleNative = PangleNative.this;
                pangleNative.adImpression(pangleNative.f42040m);
            }
        };
    }

    @Override // com.hisavana.common.base.BaseNative, com.hisavana.common.base.BaseAd, com.hisavana.common.interfacz.ICacheAd
    public void destroyAd() {
        super.destroyAd();
        this.f42039l = null;
        this.f42037j = null;
        this.f42038k = null;
        this.f42040m = null;
        AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, PushConstants.PROVIDER_FIELD_DESTROY + getLogString());
    }

    @Override // com.hisavana.common.base.BaseNative
    public void initNative() {
        Network network = this.mNetwork;
        if (network == null) {
            adFailedToLoad(new TAdErrorCode(TAdErrorCode.CODE_AD_REQUEST_FAILED, "Pangle Ads failed to load ad error with mNetwork == null"));
        } else {
            ExistsCheck.initAdSource(network.getApplicationId(), new PAGSdk.PAGInitCallback() { // from class: com.hisavana.pangle.executer.PangleNative.3
                @Override // com.bytedance.sdk.openadsdk.api.init.PAGSdk.PAGInitCallback
                public void fail(int i11, String str) {
                    PangleNative.this.adFailedToLoad(new TAdErrorCode(i11, "Pangle Ads failed to load ad error with : PAGSdk.isInitSuccess() " + PAGSdk.isInitSuccess()));
                    AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, "init onError code：" + i11 + "，message：" + str);
                }

                @Override // com.bytedance.sdk.openadsdk.api.init.PAGSdk.PAGInitCallback
                public void success() {
                    ExistsCheck.setInitState(true);
                    if (((BaseAd) PangleNative.this).mNetwork != null && !TextUtils.isEmpty(((BaseAd) PangleNative.this).mNetwork.getCodeSeatId()) && PangleNative.this.f42037j != null) {
                        PAGNativeAd.loadAd(((BaseAd) PangleNative.this).mNetwork.getCodeSeatId(), new PAGNativeRequest(), PangleNative.this.f42037j);
                        return;
                    }
                    PangleNative.this.adFailedToLoad(new TAdErrorCode(TAdErrorCode.CODE_AD_REQUEST_FAILED, "Pangle Ads failed to load ad error with : PAGSdk.isInitSuccess() " + PAGSdk.isInitSuccess()));
                }
            });
        }
    }

    @Override // com.hisavana.common.base.BaseNative
    public void onNativeAdStartLoad() {
    }

    @Override // com.hisavana.common.interfacz.IadNative
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, AdNativeInfo adNativeInfo) {
        PAGNativeAd pAGNativeAd;
        this.f42040m = adNativeInfo;
        logTrigerShow(adNativeInfo);
        ArrayList arrayList = new ArrayList();
        arrayList.add(viewGroup);
        arrayList.addAll(list);
        ArrayList arrayList2 = new ArrayList();
        for (View view : list) {
            if (view instanceof Button) {
                arrayList2.add(view);
            }
        }
        ImageView imageView = new ImageView(f.a());
        PAGNativeAdInteractionListener pAGNativeAdInteractionListener = this.f42038k;
        if (pAGNativeAdInteractionListener == null || (pAGNativeAd = this.f42039l) == null) {
            return;
        }
        pAGNativeAd.registerViewForInteraction(viewGroup, arrayList, arrayList2, imageView, pAGNativeAdInteractionListener);
    }

    @Override // com.hisavana.common.interfacz.IadNative
    public void unregisterView(@NonNull AdNativeInfo adNativeInfo) {
    }
}
