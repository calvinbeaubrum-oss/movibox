package com.bytedance.sdk.openadsdk.ExN;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.Qj.Qj;
import com.bytedance.sdk.component.utils.JPJ;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdLoadListener;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerRequest;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerSize;
import com.bytedance.sdk.openadsdk.api.factory.IADLoader;
import com.bytedance.sdk.openadsdk.api.factory.IADTypeLoaderFactory;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdLoadListener;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialRequest;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdLoadListener;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeRequest;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAdLoadListener;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenRequest;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdLoadListener;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedRequest;
import com.bytedance.sdk.openadsdk.core.Qj.qr;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.sc.ExN.pFF;
import com.bytedance.sdk.openadsdk.sc.pFF.ExN;
import com.bytedance.sdk.openadsdk.utils.cJ;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc implements IADTypeLoaderFactory {
    @Override // com.bytedance.sdk.openadsdk.api.factory.IADTypeLoaderFactory
    public IADLoader<PAGBannerRequest, PAGBannerAdLoadListener> createBannerAdLoader() {
        return new IADLoader<PAGBannerRequest, PAGBannerAdLoadListener>() { // from class: com.bytedance.sdk.openadsdk.ExN.sc.2
            @Override // com.bytedance.sdk.openadsdk.api.factory.IADLoader
            /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
            public void loadAd(String str, PAGBannerRequest pAGBannerRequest, PAGBannerAdLoadListener pAGBannerAdLoadListener) {
                if (com.bytedance.sdk.openadsdk.sc.sc.sc(str, pAGBannerRequest, pAGBannerAdLoadListener)) {
                    return;
                }
                AdSlot.Builder codeId = new AdSlot.Builder().setCodeId(str);
                com.bytedance.sdk.openadsdk.sc.sc.sc(codeId, pAGBannerRequest);
                if (!TextUtils.isEmpty(pAGBannerRequest.getAdString())) {
                    codeId.withBid(pAGBannerRequest.getAdString());
                }
                PAGBannerSize adSize = pAGBannerRequest.getAdSize();
                if (adSize != null) {
                    codeId.setExpressViewAcceptedSize(adSize.getWidth(), adSize.getHeight());
                }
                final AdSlot adSlotBuild = codeId.setRequestExtraMap(pAGBannerRequest.getExtraInfo()).build();
                final com.bytedance.sdk.openadsdk.sc.sc.sc scVar = new com.bytedance.sdk.openadsdk.sc.sc.sc(pAGBannerAdLoadListener);
                com.bytedance.sdk.openadsdk.sc.sc.sc(new Qj("loadBannerExpressAd") { // from class: com.bytedance.sdk.openadsdk.ExN.sc.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!Xc.We().dE() && cJ.Sfl()) {
                            scVar.onError(-18, "Blind mode does not allow requesting ads");
                            return;
                        }
                        if (com.bytedance.sdk.openadsdk.sc.sc.sc(scVar)) {
                            return;
                        }
                        AdSlot adSlot = adSlotBuild;
                        if (adSlot == null) {
                            scVar.onError(-4, "adslot is null");
                            return;
                        }
                        adSlot.setNativeAdType(1);
                        adSlotBuild.setDurationSlotType(1);
                        qr.sc(Xc.sc()).sc(adSlotBuild, 1, scVar, 5000);
                    }
                }, scVar, adSlotBuild);
            }
        };
    }

    @Override // com.bytedance.sdk.openadsdk.api.factory.IADTypeLoaderFactory
    public IADLoader<PAGInterstitialRequest, PAGInterstitialAdLoadListener> createInterstitialAdLoader() {
        return new IADLoader<PAGInterstitialRequest, PAGInterstitialAdLoadListener>() { // from class: com.bytedance.sdk.openadsdk.ExN.sc.5
            @Override // com.bytedance.sdk.openadsdk.api.factory.IADLoader
            /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
            public void loadAd(String str, PAGInterstitialRequest pAGInterstitialRequest, PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener) {
                if (com.bytedance.sdk.openadsdk.sc.sc.sc(str, pAGInterstitialRequest, pAGInterstitialAdLoadListener)) {
                    return;
                }
                AdSlot.Builder codeId = new AdSlot.Builder().setRequestExtraMap(pAGInterstitialRequest.getExtraInfo()).setCodeId(str);
                com.bytedance.sdk.openadsdk.sc.sc.sc(codeId, pAGInterstitialRequest);
                if (!TextUtils.isEmpty(pAGInterstitialRequest.getAdString())) {
                    codeId.withBid(pAGInterstitialRequest.getAdString());
                }
                final AdSlot adSlotBuild = codeId.build();
                final com.bytedance.sdk.openadsdk.sc.zY.sc scVar = new com.bytedance.sdk.openadsdk.sc.zY.sc(pAGInterstitialAdLoadListener);
                com.bytedance.sdk.openadsdk.sc.sc.sc(new Qj("loadInterstitialAd") { // from class: com.bytedance.sdk.openadsdk.ExN.sc.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!Xc.We().dE() && cJ.Sfl()) {
                            scVar.onError(-18, "Blind mode does not allow requesting ads");
                            return;
                        }
                        if (com.bytedance.sdk.openadsdk.sc.sc.sc(scVar)) {
                            return;
                        }
                        if (adSlotBuild == null) {
                            scVar.onError(-4, "adslot is null");
                            return;
                        }
                        try {
                            Method methodSc = JPJ.sc("com.bytedance.sdk.openadsdk.TTC3Proxy", "loadFull", Context.class, AdSlot.class, PAGInterstitialAdLoadListener.class);
                            if (methodSc != null) {
                                methodSc.invoke(null, Xc.sc(), adSlotBuild, scVar);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }, scVar, adSlotBuild);
            }
        };
    }

    @Override // com.bytedance.sdk.openadsdk.api.factory.IADTypeLoaderFactory
    public IADLoader<PAGNativeRequest, PAGNativeAdLoadListener> createNativeAdLoader() {
        return new IADLoader<PAGNativeRequest, PAGNativeAdLoadListener>() { // from class: com.bytedance.sdk.openadsdk.ExN.sc.3
            @Override // com.bytedance.sdk.openadsdk.api.factory.IADLoader
            /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
            public void loadAd(String str, PAGNativeRequest pAGNativeRequest, PAGNativeAdLoadListener pAGNativeAdLoadListener) {
                if (com.bytedance.sdk.openadsdk.sc.sc.sc(str, pAGNativeRequest, pAGNativeAdLoadListener)) {
                    return;
                }
                final ExN exN = new ExN(pAGNativeAdLoadListener);
                AdSlot.Builder builderWithBid = new AdSlot.Builder().setCodeId(str).withBid(pAGNativeRequest != null ? pAGNativeRequest.getAdString() : null);
                com.bytedance.sdk.openadsdk.sc.sc.sc(builderWithBid, pAGNativeRequest);
                final AdSlot adSlotBuild = builderWithBid.setRequestExtraMap(pAGNativeRequest.getExtraInfo()).build();
                com.bytedance.sdk.openadsdk.sc.sc.sc(new Qj("loadFeedAd") { // from class: com.bytedance.sdk.openadsdk.ExN.sc.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!Xc.We().dE() && cJ.Sfl()) {
                            exN.onError(-18, "Blind mode does not allow requesting ads");
                            return;
                        }
                        if (com.bytedance.sdk.openadsdk.sc.sc.sc(exN)) {
                            return;
                        }
                        if (adSlotBuild == null) {
                            exN.onError(-4, "adslot is null");
                            return;
                        }
                        try {
                            Method methodSc = JPJ.sc("com.bytedance.sdk.openadsdk.TTC5Proxy", "loadFeed", Context.class, AdSlot.class, PAGNativeAdLoadListener.class);
                            if (methodSc != null) {
                                methodSc.invoke(null, Xc.sc(), adSlotBuild, exN);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }, exN, adSlotBuild);
            }
        };
    }

    @Override // com.bytedance.sdk.openadsdk.api.factory.IADTypeLoaderFactory
    public IADLoader<PAGAppOpenRequest, PAGAppOpenAdLoadListener> createOpenAdLoader() {
        return new IADLoader<PAGAppOpenRequest, PAGAppOpenAdLoadListener>() { // from class: com.bytedance.sdk.openadsdk.ExN.sc.1
            private int pFF;

            @Override // com.bytedance.sdk.openadsdk.api.factory.IADLoader
            /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
            public void loadAd(String str, PAGAppOpenRequest pAGAppOpenRequest, PAGAppOpenAdLoadListener pAGAppOpenAdLoadListener) {
                if (com.bytedance.sdk.openadsdk.sc.sc.sc(str, pAGAppOpenRequest, pAGAppOpenAdLoadListener)) {
                    return;
                }
                AdSlot.Builder builder = new AdSlot.Builder();
                com.bytedance.sdk.openadsdk.sc.sc.sc(builder, pAGAppOpenRequest);
                if (!TextUtils.isEmpty(pAGAppOpenRequest.getAdString())) {
                    builder.withBid(pAGAppOpenRequest.getAdString());
                }
                final AdSlot adSlotBuild = builder.setCodeId(str).setRequestExtraMap(pAGAppOpenRequest.getExtraInfo()).build();
                this.pFF = pAGAppOpenRequest.getTimeout();
                final com.bytedance.sdk.openadsdk.sc.We.sc scVar = new com.bytedance.sdk.openadsdk.sc.We.sc(pAGAppOpenAdLoadListener);
                com.bytedance.sdk.openadsdk.sc.sc.sc(new Qj("loadSplashAd") { // from class: com.bytedance.sdk.openadsdk.ExN.sc.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (!Xc.We().dE() && cJ.Sfl()) {
                                scVar.onError(-18, "Blind mode does not allow requesting ads");
                                return;
                            }
                            if (com.bytedance.sdk.openadsdk.sc.sc.sc(scVar)) {
                                return;
                            }
                            if (adSlotBuild == null) {
                                scVar.onError(-4, "adslot is null");
                                return;
                            }
                            Method methodSc = JPJ.sc("com.bytedance.sdk.openadsdk.TTC2Proxy", "load", Context.class, AdSlot.class, PAGAppOpenAdLoadListener.class, Integer.TYPE);
                            if (methodSc != null) {
                                methodSc.invoke(null, Xc.sc(), adSlotBuild, scVar, Integer.valueOf(AnonymousClass1.this.pFF));
                            }
                        } catch (Throwable th2) {
                            Tf.sc("ADNFactory", "open component maybe not exist, please check", th2);
                        }
                    }
                }, scVar, adSlotBuild);
            }
        };
    }

    @Override // com.bytedance.sdk.openadsdk.api.factory.IADTypeLoaderFactory
    public IADLoader<PAGRewardedRequest, PAGRewardedAdLoadListener> createRewardAdLoader() {
        return new IADLoader<PAGRewardedRequest, PAGRewardedAdLoadListener>() { // from class: com.bytedance.sdk.openadsdk.ExN.sc.4
            @Override // com.bytedance.sdk.openadsdk.api.factory.IADLoader
            /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
            public void loadAd(String str, PAGRewardedRequest pAGRewardedRequest, PAGRewardedAdLoadListener pAGRewardedAdLoadListener) {
                if (com.bytedance.sdk.openadsdk.sc.sc.sc(str, pAGRewardedRequest, pAGRewardedAdLoadListener)) {
                    return;
                }
                AdSlot.Builder codeId = new AdSlot.Builder().setCodeId(str);
                if (!TextUtils.isEmpty(pAGRewardedRequest.getAdString())) {
                    codeId.withBid(pAGRewardedRequest.getAdString());
                }
                com.bytedance.sdk.openadsdk.sc.sc.sc(codeId, pAGRewardedRequest);
                final AdSlot adSlotBuild = codeId.setRequestExtraMap(pAGRewardedRequest.getExtraInfo()).build();
                final pFF pff = new pFF(pAGRewardedAdLoadListener);
                com.bytedance.sdk.openadsdk.sc.sc.sc(new Qj("loadRewardVideoAd") { // from class: com.bytedance.sdk.openadsdk.ExN.sc.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!Xc.We().dE() && cJ.Sfl()) {
                            pff.onError(-18, "Blind mode does not allow requesting ads");
                            return;
                        }
                        if (com.bytedance.sdk.openadsdk.sc.sc.sc(pff)) {
                            return;
                        }
                        if (adSlotBuild == null) {
                            pff.onError(-4, "adslot is null");
                            return;
                        }
                        try {
                            Method methodSc = JPJ.sc("com.bytedance.sdk.openadsdk.TTC3Proxy", "loadReward", Context.class, AdSlot.class, PAGRewardedAdLoadListener.class);
                            if (methodSc != null) {
                                methodSc.invoke(null, Xc.sc(), adSlotBuild, pff);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }, pff, adSlotBuild);
            }
        };
    }
}
