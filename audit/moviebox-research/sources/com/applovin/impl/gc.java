package com.applovin.impl;

import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinAdViewDisplayErrorCode;
import com.applovin.adview.AppLovinAdViewEventListener;
import com.applovin.impl.sdk.AppLovinError;
import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import com.applovin.impl.sdk.nativeAd.AppLovinNativeAd;
import com.applovin.impl.sdk.nativeAd.AppLovinNativeAdEventListener;
import com.applovin.impl.sdk.nativeAd.AppLovinNativeAdLoadListener;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdExpirationListener;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdRequestListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdReviewListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.MaxRewardedAdListener;
import com.applovin.mediation.nativeAds.MaxNativeAdListener;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinBidTokenCollectionListener;
import com.applovin.sdk.AppLovinPostbackListener;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class gc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f19206a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f19207b = true;

    private static AppLovinAd a(AppLovinAd appLovinAd) {
        AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) appLovinAd;
        return appLovinAdImpl.getDummyAd() != null ? appLovinAdImpl.getDummyAd() : appLovinAd;
    }

    public static void a(final AppLovinAdViewEventListener appLovinAdViewEventListener, final AppLovinAd appLovinAd, final AppLovinAdView appLovinAdView) {
        if (appLovinAd == null || appLovinAdViewEventListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.ow
            @Override // java.lang.Runnable
            public final void run() {
                gc.d(appLovinAdViewEventListener, appLovinAd, appLovinAdView);
            }
        });
    }

    public static void a(final AppLovinAdViewEventListener appLovinAdViewEventListener, final AppLovinAd appLovinAd, final AppLovinAdView appLovinAdView, final AppLovinAdViewDisplayErrorCode appLovinAdViewDisplayErrorCode) {
        if (appLovinAd == null || appLovinAdViewEventListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sw
            @Override // java.lang.Runnable
            public final void run() {
                gc.b(appLovinAdViewEventListener, appLovinAd, appLovinAdView, appLovinAdViewDisplayErrorCode);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(AppLovinNativeAdEventListener appLovinNativeAdEventListener, AppLovinNativeAd appLovinNativeAd) {
        try {
            appLovinNativeAdEventListener.onNativeAdClicked(appLovinNativeAd);
        } catch (Throwable th2) {
            com.applovin.impl.sdk.n.c("ListenerCallbackInvoker", "Unable to notify native ad event listener about ad click", th2);
            c("nativeAdClicked", th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(AppLovinNativeAdLoadListener appLovinNativeAdLoadListener, AppLovinError appLovinError) {
        try {
            appLovinNativeAdLoadListener.onNativeAdLoadFailed(appLovinError);
        } catch (Throwable th2) {
            com.applovin.impl.sdk.n.c("ListenerCallbackInvoker", "Unable to notify native ad event listener about ad failing to load", th2);
            c("nativeAdLoadFailed", th2);
        }
    }

    public static void a(final MaxAdExpirationListener maxAdExpirationListener, final MaxAd maxAd, final MaxAd maxAd2, final boolean z11) {
        if (maxAd == null || maxAd2 == null || maxAdExpirationListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(z11, new Runnable() { // from class: com.applovin.impl.mw
            @Override // java.lang.Runnable
            public final void run() {
                gc.a(z11, maxAdExpirationListener, maxAd, maxAd2);
            }
        });
    }

    public static void a(MaxAdListener maxAdListener, MaxAd maxAd) {
        a(maxAdListener, maxAd, false);
    }

    public static void a(MaxAdListener maxAdListener, MaxAd maxAd, MaxError maxError) {
        a(maxAdListener, maxAd, maxError, false);
    }

    public static void a(final MaxAdListener maxAdListener, final MaxAd maxAd, final MaxError maxError, final boolean z11) {
        if (maxAd == null || maxAdListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(z11, new Runnable() { // from class: com.applovin.impl.hx
            @Override // java.lang.Runnable
            public final void run() {
                gc.a(z11, maxAdListener, maxAd, maxError);
            }
        });
    }

    public static void a(MaxAdListener maxAdListener, MaxAd maxAd, MaxReward maxReward) {
        a(maxAdListener, maxAd, maxReward, false);
    }

    public static void a(final MaxAdListener maxAdListener, final MaxAd maxAd, final MaxReward maxReward, final boolean z11) {
        if (maxAd == null || !(maxAdListener instanceof MaxRewardedAdListener)) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(z11, new Runnable() { // from class: com.applovin.impl.kw
            @Override // java.lang.Runnable
            public final void run() {
                gc.a(z11, maxAdListener, maxAd, maxReward);
            }
        });
    }

    public static void a(final MaxAdListener maxAdListener, final MaxAd maxAd, final boolean z11) {
        if (maxAd == null || maxAdListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(z11, new Runnable() { // from class: com.applovin.impl.dx
            @Override // java.lang.Runnable
            public final void run() {
                gc.a(z11, maxAdListener, maxAd);
            }
        });
    }

    public static void a(MaxAdListener maxAdListener, String str, MaxError maxError) {
        a(maxAdListener, str, maxError, false);
    }

    public static void a(final MaxAdListener maxAdListener, final String str, final MaxError maxError, final boolean z11) {
        if (str == null || maxAdListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(z11, new Runnable() { // from class: com.applovin.impl.lx
            @Override // java.lang.Runnable
            public final void run() {
                gc.a(z11, maxAdListener, str, maxError);
            }
        });
    }

    public static void a(MaxAdRequestListener maxAdRequestListener, String str) {
        a(maxAdRequestListener, str, false);
    }

    public static void a(final MaxAdRequestListener maxAdRequestListener, final String str, final boolean z11) {
        if (str == null || maxAdRequestListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(z11, new Runnable() { // from class: com.applovin.impl.zw
            @Override // java.lang.Runnable
            public final void run() {
                gc.a(z11, maxAdRequestListener, str);
            }
        });
    }

    public static void a(MaxAdRevenueListener maxAdRevenueListener, MaxAd maxAd) {
        a(maxAdRevenueListener, maxAd, false);
    }

    public static void a(final MaxAdRevenueListener maxAdRevenueListener, final MaxAd maxAd, final boolean z11) {
        if (maxAd == null || maxAdRevenueListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(z11, new Runnable() { // from class: com.applovin.impl.ew
            @Override // java.lang.Runnable
            public final void run() {
                gc.a(z11, maxAdRevenueListener, maxAd);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(MaxAdReviewListener maxAdReviewListener, String str, MaxAd maxAd) {
        try {
            maxAdReviewListener.onCreativeIdGenerated(str, maxAd);
        } catch (Throwable th2) {
            com.applovin.impl.sdk.n.c("ListenerCallbackInvoker", "Unable to notify Ad Review creative id generated", th2);
            c("adReviewCreativeIdGenerated", th2);
        }
    }

    public static void a(final MaxAdReviewListener maxAdReviewListener, final String str, final MaxAd maxAd, boolean z11) {
        if (maxAdReviewListener != null) {
            AppLovinSdkUtils.runOnUiThread(z11, new Runnable() { // from class: com.applovin.impl.cw
                @Override // java.lang.Runnable
                public final void run() {
                    gc.a(maxAdReviewListener, str, maxAd);
                }
            });
        }
    }

    public static void a(final MaxNativeAdListener maxNativeAdListener, final MaxAd maxAd, final boolean z11) {
        if (maxAd == null || maxNativeAdListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(z11, new Runnable() { // from class: com.applovin.impl.fw
            @Override // java.lang.Runnable
            public final void run() {
                gc.a(z11, maxNativeAdListener, maxAd);
            }
        });
    }

    public static void a(final MaxNativeAdListener maxNativeAdListener, final MaxNativeAdView maxNativeAdView, final MaxAd maxAd, final boolean z11) {
        if (maxAd == null || maxNativeAdListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(z11, new Runnable() { // from class: com.applovin.impl.kx
            @Override // java.lang.Runnable
            public final void run() {
                gc.a(z11, maxNativeAdListener, maxNativeAdView, maxAd);
            }
        });
    }

    public static void a(final MaxNativeAdListener maxNativeAdListener, final String str, final MaxError maxError, final boolean z11) {
        if (str == null || maxNativeAdListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(z11, new Runnable() { // from class: com.applovin.impl.pw
            @Override // java.lang.Runnable
            public final void run() {
                gc.a(z11, maxNativeAdListener, str, maxError);
            }
        });
    }

    public static void a(final AppLovinAdClickListener appLovinAdClickListener, final AppLovinAd appLovinAd) {
        if (appLovinAd == null || appLovinAdClickListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.mx
            @Override // java.lang.Runnable
            public final void run() {
                gc.b(appLovinAdClickListener, appLovinAd);
            }
        });
    }

    public static void a(final AppLovinAdDisplayListener appLovinAdDisplayListener, final AppLovinAd appLovinAd) {
        if (appLovinAd == null || appLovinAdDisplayListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.gw
            @Override // java.lang.Runnable
            public final void run() {
                gc.c(appLovinAdDisplayListener, appLovinAd);
            }
        });
    }

    public static void a(final AppLovinAdDisplayListener appLovinAdDisplayListener, final String str) {
        if (appLovinAdDisplayListener instanceof qb) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.cx
                @Override // java.lang.Runnable
                public final void run() {
                    gc.b(appLovinAdDisplayListener, str);
                }
            });
        }
    }

    public static void a(final AppLovinAdRewardListener appLovinAdRewardListener, final AppLovinAd appLovinAd, final int i11) {
        if (appLovinAd == null || appLovinAdRewardListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.nw
            @Override // java.lang.Runnable
            public final void run() {
                gc.b(appLovinAdRewardListener, appLovinAd, i11);
            }
        });
    }

    public static void a(final AppLovinAdRewardListener appLovinAdRewardListener, final AppLovinAd appLovinAd, final Map map) {
        if (appLovinAd == null || appLovinAdRewardListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.nx
            @Override // java.lang.Runnable
            public final void run() {
                gc.d(appLovinAdRewardListener, appLovinAd, map);
            }
        });
    }

    public static void a(final AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, final AppLovinAd appLovinAd) {
        if (appLovinAd == null || appLovinAdVideoPlaybackListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.gx
            @Override // java.lang.Runnable
            public final void run() {
                gc.b(appLovinAdVideoPlaybackListener, appLovinAd);
            }
        });
    }

    public static void a(final AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, final AppLovinAd appLovinAd, final double d11, final boolean z11) {
        if (appLovinAd == null || appLovinAdVideoPlaybackListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.bw
            @Override // java.lang.Runnable
            public final void run() {
                gc.b(appLovinAdVideoPlaybackListener, appLovinAd, d11, z11);
            }
        });
    }

    public static void a(final AppLovinBidTokenCollectionListener appLovinBidTokenCollectionListener, final String str) {
        if (appLovinBidTokenCollectionListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.iw
                @Override // java.lang.Runnable
                public final void run() {
                    gc.c(appLovinBidTokenCollectionListener, str);
                }
            });
        }
    }

    public static void a(final AppLovinPostbackListener appLovinPostbackListener, final String str) {
        if (appLovinPostbackListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.lw
                @Override // java.lang.Runnable
                public final void run() {
                    gc.b(appLovinPostbackListener, str);
                }
            });
        }
    }

    public static void a(final AppLovinPostbackListener appLovinPostbackListener, final String str, final int i11) {
        if (appLovinPostbackListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.dw
                @Override // java.lang.Runnable
                public final void run() {
                    gc.b(appLovinPostbackListener, str, i11);
                }
            });
        }
    }

    private static void a(String str, Throwable th2) {
        com.applovin.impl.sdk.n.b("ListenerCallbackInvoker", "Error in internal callback '" + str + "'", th2);
    }

    private static void a(String str, Throwable th2, boolean z11) {
        if (z11) {
            b(str, th2);
        } else {
            a(str, th2);
        }
    }

    public static void a(boolean z11) {
        f19207b = z11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(boolean z11, MaxAdExpirationListener maxAdExpirationListener, MaxAd maxAd, MaxAd maxAd2) {
        if (!c(z11)) {
            maxAdExpirationListener.onExpiredAdReloaded(maxAd, maxAd2);
            return;
        }
        try {
            maxAdExpirationListener.onExpiredAdReloaded(maxAd, maxAd2);
        } catch (Throwable th2) {
            a("onExpiredAdReloaded", th2, z11);
            c("maxExpiredAdReloaded", th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(boolean z11, MaxAdListener maxAdListener, MaxAd maxAd) {
        if (!c(z11)) {
            maxAdListener.onAdClicked(maxAd);
            return;
        }
        try {
            maxAdListener.onAdClicked(maxAd);
        } catch (Throwable th2) {
            a("onAdClicked", th2, z11);
            c("maxAdClicked", th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(boolean z11, MaxAdListener maxAdListener, MaxAd maxAd, MaxError maxError) {
        if (!c(z11)) {
            maxAdListener.onAdDisplayFailed(maxAd, maxError);
            return;
        }
        try {
            maxAdListener.onAdDisplayFailed(maxAd, maxError);
        } catch (Throwable th2) {
            a("onAdDisplayFailed", th2, z11);
            c("maxAdDisplayFailed", th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(boolean z11, MaxAdListener maxAdListener, MaxAd maxAd, MaxReward maxReward) {
        if (!c(z11)) {
            ((MaxRewardedAdListener) maxAdListener).onUserRewarded(maxAd, maxReward);
            return;
        }
        try {
            ((MaxRewardedAdListener) maxAdListener).onUserRewarded(maxAd, maxReward);
        } catch (Throwable th2) {
            a("onUserRewarded", th2, z11);
            c("maxRewardedUser", th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(boolean z11, MaxAdListener maxAdListener, String str, MaxError maxError) {
        if (!c(z11)) {
            maxAdListener.onAdLoadFailed(str, maxError);
            return;
        }
        try {
            maxAdListener.onAdLoadFailed(str, maxError);
        } catch (Throwable th2) {
            a("onAdLoadFailed", th2, z11);
            c("maxAdLoadFailed", th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(boolean z11, MaxAdRequestListener maxAdRequestListener, String str) {
        if (!c(z11)) {
            maxAdRequestListener.onAdRequestStarted(str);
            return;
        }
        try {
            maxAdRequestListener.onAdRequestStarted(str);
        } catch (Throwable th2) {
            a("onAdRequestStarted", th2, z11);
            c("maxAdRequestStarted", th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(boolean z11, MaxAdRevenueListener maxAdRevenueListener, MaxAd maxAd) {
        if (!c(z11)) {
            maxAdRevenueListener.onAdRevenuePaid(maxAd);
            return;
        }
        try {
            maxAdRevenueListener.onAdRevenuePaid(maxAd);
        } catch (Throwable th2) {
            a("onAdRevenuePaid", th2, z11);
            c("maxAdPaidRevenue", th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(boolean z11, MaxNativeAdListener maxNativeAdListener, MaxAd maxAd) {
        if (!c(z11)) {
            maxNativeAdListener.onNativeAdClicked(maxAd);
            return;
        }
        try {
            maxNativeAdListener.onNativeAdClicked(maxAd);
        } catch (Throwable th2) {
            a("onNativeAdClicked", th2, z11);
            c("maxNativeAdClicked", th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(boolean z11, MaxNativeAdListener maxNativeAdListener, MaxNativeAdView maxNativeAdView, MaxAd maxAd) {
        if (!c(z11)) {
            maxNativeAdListener.onNativeAdLoaded(maxNativeAdView, maxAd);
            return;
        }
        try {
            maxNativeAdListener.onNativeAdLoaded(maxNativeAdView, maxAd);
        } catch (Throwable th2) {
            a("onNativeAdLoaded", th2, z11);
            c("maxNativeAdLoaded", th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(boolean z11, MaxNativeAdListener maxNativeAdListener, String str, MaxError maxError) {
        if (!c(z11)) {
            maxNativeAdListener.onNativeAdLoadFailed(str, maxError);
            return;
        }
        try {
            maxNativeAdListener.onNativeAdLoadFailed(str, maxError);
        } catch (Throwable th2) {
            a("onNativeAdLoadFailed", th2, z11);
            c("maxNativeAdLoadFailed", th2);
        }
    }

    public static void b(final AppLovinAdViewEventListener appLovinAdViewEventListener, final AppLovinAd appLovinAd, final AppLovinAdView appLovinAdView) {
        if (appLovinAd == null || appLovinAdViewEventListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.xw
            @Override // java.lang.Runnable
            public final void run() {
                gc.e(appLovinAdViewEventListener, appLovinAd, appLovinAdView);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(AppLovinAdViewEventListener appLovinAdViewEventListener, AppLovinAd appLovinAd, AppLovinAdView appLovinAdView, AppLovinAdViewDisplayErrorCode appLovinAdViewDisplayErrorCode) {
        try {
            appLovinAdViewEventListener.adFailedToDisplay(a(appLovinAd), appLovinAdView, appLovinAdViewDisplayErrorCode);
        } catch (Throwable th2) {
            com.applovin.impl.sdk.n.c("ListenerCallbackInvoker", "Unable to notify ad event listener about display failed event", th2);
        }
    }

    public static void b(final AppLovinNativeAdEventListener appLovinNativeAdEventListener, final AppLovinNativeAd appLovinNativeAd) {
        if (appLovinNativeAdEventListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.ex
                @Override // java.lang.Runnable
                public final void run() {
                    gc.a(appLovinNativeAdEventListener, appLovinNativeAd);
                }
            });
        }
    }

    public static void b(final AppLovinNativeAdLoadListener appLovinNativeAdLoadListener, final AppLovinError appLovinError) {
        if (appLovinNativeAdLoadListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.bx
                @Override // java.lang.Runnable
                public final void run() {
                    gc.a(appLovinNativeAdLoadListener, appLovinError);
                }
            });
        }
    }

    public static void b(MaxAdListener maxAdListener, MaxAd maxAd) {
        b(maxAdListener, maxAd, false);
    }

    public static void b(final MaxAdListener maxAdListener, final MaxAd maxAd, final boolean z11) {
        if (maxAd == null || !(maxAdListener instanceof MaxAdViewAdListener)) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(z11, new Runnable() { // from class: com.applovin.impl.rw
            @Override // java.lang.Runnable
            public final void run() {
                gc.b(z11, maxAdListener, maxAd);
            }
        });
    }

    public static void b(MaxAdReviewListener maxAdReviewListener, String str, MaxAd maxAd) {
        a(maxAdReviewListener, str, maxAd, false);
    }

    public static void b(final MaxNativeAdListener maxNativeAdListener, final MaxAd maxAd, final boolean z11) {
        if (maxAd == null || maxNativeAdListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(z11, new Runnable() { // from class: com.applovin.impl.fx
            @Override // java.lang.Runnable
            public final void run() {
                gc.b(z11, maxNativeAdListener, maxAd);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(AppLovinAdClickListener appLovinAdClickListener, AppLovinAd appLovinAd) {
        try {
            appLovinAdClickListener.adClicked(a(appLovinAd));
        } catch (Throwable th2) {
            com.applovin.impl.sdk.n.c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being clicked", th2);
            c("adClicked", th2);
        }
    }

    public static void b(final AppLovinAdDisplayListener appLovinAdDisplayListener, final AppLovinAd appLovinAd) {
        if (appLovinAd == null || appLovinAdDisplayListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.jx
            @Override // java.lang.Runnable
            public final void run() {
                gc.d(appLovinAdDisplayListener, appLovinAd);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(AppLovinAdDisplayListener appLovinAdDisplayListener, String str) {
        ((qb) appLovinAdDisplayListener).onAdDisplayFailed(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAd appLovinAd, int i11) {
        try {
            appLovinAdRewardListener.validationRequestFailed(a(appLovinAd), i11);
        } catch (Throwable th2) {
            com.applovin.impl.sdk.n.c("ListenerCallbackInvoker", "Unable to notify ad reward listener about reward validation request failing", th2);
        }
    }

    public static void b(final AppLovinAdRewardListener appLovinAdRewardListener, final AppLovinAd appLovinAd, final Map map) {
        if (appLovinAd == null || appLovinAdRewardListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.hw
            @Override // java.lang.Runnable
            public final void run() {
                gc.e(appLovinAdRewardListener, appLovinAd, map);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAd appLovinAd) {
        try {
            appLovinAdVideoPlaybackListener.videoPlaybackBegan(a(appLovinAd));
        } catch (Throwable th2) {
            com.applovin.impl.sdk.n.c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad playback began", th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAd appLovinAd, double d11, boolean z11) {
        try {
            appLovinAdVideoPlaybackListener.videoPlaybackEnded(a(appLovinAd), d11, z11);
        } catch (Throwable th2) {
            com.applovin.impl.sdk.n.c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad playback ended", th2);
        }
    }

    public static void b(final AppLovinBidTokenCollectionListener appLovinBidTokenCollectionListener, final String str) {
        if (appLovinBidTokenCollectionListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.jw
                @Override // java.lang.Runnable
                public final void run() {
                    gc.d(appLovinBidTokenCollectionListener, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(AppLovinPostbackListener appLovinPostbackListener, String str) {
        try {
            appLovinPostbackListener.onPostbackSuccess(str);
        } catch (Throwable th2) {
            com.applovin.impl.sdk.n.c("ListenerCallbackInvoker", "Unable to notify AppLovinPostbackListener about postback URL (" + str + ") executed", th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(AppLovinPostbackListener appLovinPostbackListener, String str, int i11) {
        try {
            appLovinPostbackListener.onPostbackFailure(str, i11);
        } catch (Throwable th2) {
            com.applovin.impl.sdk.n.c("ListenerCallbackInvoker", "Unable to notify AppLovinPostbackListener about postback URL (" + str + ") failing to execute with error code (" + i11 + "):", th2);
        }
    }

    private static void b(String str, Throwable th2) {
        com.applovin.impl.sdk.n.c("ListenerCallbackInvoker", "Error in publisher callback '" + str + "'", th2);
    }

    public static void b(boolean z11) {
        f19206a = z11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(boolean z11, MaxAdListener maxAdListener, MaxAd maxAd) {
        if (!c(z11)) {
            ((MaxAdViewAdListener) maxAdListener).onAdCollapsed(maxAd);
            return;
        }
        try {
            ((MaxAdViewAdListener) maxAdListener).onAdCollapsed(maxAd);
        } catch (Throwable th2) {
            a("onAdCollapsed", th2, z11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(boolean z11, MaxNativeAdListener maxNativeAdListener, MaxAd maxAd) {
        if (!c(z11)) {
            maxNativeAdListener.onNativeAdExpired(maxAd);
            return;
        }
        try {
            maxNativeAdListener.onNativeAdExpired(maxAd);
        } catch (Throwable th2) {
            a("onNativeAdExpired", th2, z11);
            c("maxNativeAdExpired", th2);
        }
    }

    public static void c(final AppLovinAdViewEventListener appLovinAdViewEventListener, final AppLovinAd appLovinAd, final AppLovinAdView appLovinAdView) {
        if (appLovinAd == null || appLovinAdViewEventListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.yw
            @Override // java.lang.Runnable
            public final void run() {
                gc.f(appLovinAdViewEventListener, appLovinAd, appLovinAdView);
            }
        });
    }

    public static void c(MaxAdListener maxAdListener, MaxAd maxAd) {
        c(maxAdListener, maxAd, false);
    }

    public static void c(final MaxAdListener maxAdListener, final MaxAd maxAd, final boolean z11) {
        if (maxAd == null || maxAdListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(z11, new Runnable() { // from class: com.applovin.impl.vw
            @Override // java.lang.Runnable
            public final void run() {
                gc.c(z11, maxAdListener, maxAd);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAd appLovinAd) {
        try {
            appLovinAdDisplayListener.adDisplayed(a(appLovinAd));
        } catch (Throwable th2) {
            com.applovin.impl.sdk.n.c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being displayed", th2);
            c("adDisplayed", th2);
        }
    }

    public static void c(final AppLovinAdRewardListener appLovinAdRewardListener, final AppLovinAd appLovinAd, final Map map) {
        if (appLovinAd == null || appLovinAdRewardListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.uw
            @Override // java.lang.Runnable
            public final void run() {
                gc.f(appLovinAdRewardListener, appLovinAd, map);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(AppLovinBidTokenCollectionListener appLovinBidTokenCollectionListener, String str) {
        try {
            appLovinBidTokenCollectionListener.onBidTokenCollected(str);
        } catch (Throwable th2) {
            com.applovin.impl.sdk.n.c("ListenerCallbackInvoker", "Unable to notify bid token listener about successful bid token collection", th2);
            c("onBidTokenCollected", th2);
        }
    }

    private static void c(String str, Throwable th2) {
        com.applovin.impl.sdk.j jVar = com.applovin.impl.sdk.j.f22563v0;
        if (jVar != null) {
            jVar.E().a("ListenerCallbackInvoker", str, th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(boolean z11, MaxAdListener maxAdListener, MaxAd maxAd) {
        if (!c(z11)) {
            maxAdListener.onAdDisplayed(maxAd);
            return;
        }
        try {
            maxAdListener.onAdDisplayed(maxAd);
        } catch (Throwable th2) {
            a("onAdDisplayed", th2, z11);
            c("maxAdDisplayed", th2);
        }
    }

    private static boolean c(boolean z11) {
        return z11 ? f19206a : f19207b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(AppLovinAdViewEventListener appLovinAdViewEventListener, AppLovinAd appLovinAd, AppLovinAdView appLovinAdView) {
        try {
            appLovinAdViewEventListener.adClosedFullscreen(a(appLovinAd), appLovinAdView);
        } catch (Throwable th2) {
            com.applovin.impl.sdk.n.c("ListenerCallbackInvoker", "Unable to notify ad event listener about fullscreen closed event", th2);
        }
    }

    public static void d(MaxAdListener maxAdListener, MaxAd maxAd) {
        d(maxAdListener, maxAd, false);
    }

    public static void d(final MaxAdListener maxAdListener, final MaxAd maxAd, final boolean z11) {
        if (maxAd == null || !(maxAdListener instanceof MaxAdViewAdListener)) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(z11, new Runnable() { // from class: com.applovin.impl.qw
            @Override // java.lang.Runnable
            public final void run() {
                gc.d(z11, maxAdListener, maxAd);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAd appLovinAd) {
        try {
            appLovinAdDisplayListener.adHidden(a(appLovinAd));
        } catch (Throwable th2) {
            com.applovin.impl.sdk.n.c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being hidden", th2);
            c("adHidden", th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAd appLovinAd, Map map) {
        try {
            appLovinAdRewardListener.userRewardRejected(a(appLovinAd), map);
        } catch (Throwable th2) {
            com.applovin.impl.sdk.n.c("ListenerCallbackInvoker", "Unable to notify ad reward listener about reward validation request being rejected", th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(AppLovinBidTokenCollectionListener appLovinBidTokenCollectionListener, String str) {
        try {
            appLovinBidTokenCollectionListener.onBidTokenCollectionFailed(str);
        } catch (Throwable th2) {
            com.applovin.impl.sdk.n.c("ListenerCallbackInvoker", "Unable to notify bid token listener about bid token collection failure", th2);
            c("onBidTokenCollectionFailed", th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(boolean z11, MaxAdListener maxAdListener, MaxAd maxAd) {
        if (!c(z11)) {
            ((MaxAdViewAdListener) maxAdListener).onAdExpanded(maxAd);
            return;
        }
        try {
            ((MaxAdViewAdListener) maxAdListener).onAdExpanded(maxAd);
        } catch (Throwable th2) {
            a("onAdExpanded", th2, z11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(AppLovinAdViewEventListener appLovinAdViewEventListener, AppLovinAd appLovinAd, AppLovinAdView appLovinAdView) {
        try {
            appLovinAdViewEventListener.adLeftApplication(a(appLovinAd), appLovinAdView);
        } catch (Throwable th2) {
            com.applovin.impl.sdk.n.c("ListenerCallbackInvoker", "Unable to notify ad event listener about application leave event", th2);
        }
    }

    public static void e(MaxAdListener maxAdListener, MaxAd maxAd) {
        e(maxAdListener, maxAd, false);
    }

    public static void e(final MaxAdListener maxAdListener, final MaxAd maxAd, final boolean z11) {
        if (maxAd == null || maxAdListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(z11, new Runnable() { // from class: com.applovin.impl.ax
            @Override // java.lang.Runnable
            public final void run() {
                gc.e(z11, maxAdListener, maxAd);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAd appLovinAd, Map map) {
        try {
            appLovinAdRewardListener.userOverQuota(a(appLovinAd), map);
        } catch (Throwable th2) {
            com.applovin.impl.sdk.n.c("ListenerCallbackInvoker", "Unable to notify ad reward listener about exceeding quota", th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(boolean z11, MaxAdListener maxAdListener, MaxAd maxAd) {
        if (!c(z11)) {
            maxAdListener.onAdHidden(maxAd);
            return;
        }
        try {
            maxAdListener.onAdHidden(maxAd);
        } catch (Throwable th2) {
            a("onAdHidden", th2, z11);
            c("maxAdHidden", th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(AppLovinAdViewEventListener appLovinAdViewEventListener, AppLovinAd appLovinAd, AppLovinAdView appLovinAdView) {
        try {
            appLovinAdViewEventListener.adOpenedFullscreen(a(appLovinAd), appLovinAdView);
        } catch (Throwable th2) {
            com.applovin.impl.sdk.n.c("ListenerCallbackInvoker", "Unable to notify ad event listener about fullscreen opened event", th2);
        }
    }

    public static void f(MaxAdListener maxAdListener, MaxAd maxAd) {
        f(maxAdListener, maxAd, false);
    }

    public static void f(final MaxAdListener maxAdListener, final MaxAd maxAd, final boolean z11) {
        if (maxAd == null || maxAdListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(z11, new Runnable() { // from class: com.applovin.impl.ix
            @Override // java.lang.Runnable
            public final void run() {
                gc.f(z11, maxAdListener, maxAd);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAd appLovinAd, Map map) {
        try {
            appLovinAdRewardListener.userRewardVerified(a(appLovinAd), map);
        } catch (Throwable th2) {
            com.applovin.impl.sdk.n.c("ListenerCallbackInvoker", "Unable to notify ad reward listener about successful reward validation request", th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(boolean z11, MaxAdListener maxAdListener, MaxAd maxAd) {
        if (!c(z11)) {
            maxAdListener.onAdLoaded(maxAd);
            return;
        }
        try {
            maxAdListener.onAdLoaded(maxAd);
        } catch (Throwable th2) {
            a("onAdLoaded", th2, z11);
            c("maxAdLoaded", th2);
        }
    }

    public static void g(MaxAdListener maxAdListener, MaxAd maxAd) {
        g(maxAdListener, maxAd, false);
    }

    public static void g(final MaxAdListener maxAdListener, final MaxAd maxAd, final boolean z11) {
        if (maxAd == null || !(maxAdListener instanceof MaxRewardedAdListener)) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(z11, new Runnable() { // from class: com.applovin.impl.tw
            @Override // java.lang.Runnable
            public final void run() {
                gc.g(z11, maxAdListener, maxAd);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g(boolean z11, MaxAdListener maxAdListener, MaxAd maxAd) {
        if (!c(z11)) {
            ((MaxRewardedAdListener) maxAdListener).onRewardedVideoCompleted(maxAd);
            return;
        }
        try {
            ((MaxRewardedAdListener) maxAdListener).onRewardedVideoCompleted(maxAd);
        } catch (Throwable th2) {
            a("onRewardedVideoCompleted", th2, z11);
        }
    }

    public static void h(MaxAdListener maxAdListener, MaxAd maxAd) {
        h(maxAdListener, maxAd, false);
    }

    public static void h(final MaxAdListener maxAdListener, final MaxAd maxAd, final boolean z11) {
        if (maxAd == null || !(maxAdListener instanceof MaxRewardedAdListener)) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(z11, new Runnable() { // from class: com.applovin.impl.ww
            @Override // java.lang.Runnable
            public final void run() {
                gc.h(z11, maxAdListener, maxAd);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h(boolean z11, MaxAdListener maxAdListener, MaxAd maxAd) {
        if (!c(z11)) {
            ((MaxRewardedAdListener) maxAdListener).onRewardedVideoStarted(maxAd);
            return;
        }
        try {
            ((MaxRewardedAdListener) maxAdListener).onRewardedVideoStarted(maxAd);
        } catch (Throwable th2) {
            a("onRewardedVideoStarted", th2, z11);
        }
    }
}
