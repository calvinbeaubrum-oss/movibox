package com.applovin.impl;

import android.content.Context;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.applovin.adview.AppLovinInterstitialAd;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.impl.sdk.AppLovinAdServiceImpl;
import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.SoftReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class jb {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final com.applovin.impl.sdk.j f19918b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final AppLovinAdServiceImpl f19919c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AppLovinAd f19920d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f19921e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private SoftReference f19922f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile String f19924h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f19917a = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Object f19923g = new Object();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile boolean f19925i = false;

    /* JADX INFO: compiled from: source.java */
    public class a implements AppLovinAdRewardListener {
        public a() {
        }

        @Override // com.applovin.sdk.AppLovinAdRewardListener
        public void userOverQuota(AppLovinAd appLovinAd, Map map) {
            jb.this.f19918b.J();
            if (com.applovin.impl.sdk.n.a()) {
                jb.this.f19918b.J().b("IncentivizedAdController", "User over quota: " + map);
            }
        }

        @Override // com.applovin.sdk.AppLovinAdRewardListener
        public void userRewardRejected(AppLovinAd appLovinAd, Map map) {
            jb.this.f19918b.J();
            if (com.applovin.impl.sdk.n.a()) {
                jb.this.f19918b.J().b("IncentivizedAdController", "Reward rejected: " + map);
            }
        }

        @Override // com.applovin.sdk.AppLovinAdRewardListener
        public void userRewardVerified(AppLovinAd appLovinAd, Map map) {
            jb.this.f19918b.J();
            if (com.applovin.impl.sdk.n.a()) {
                jb.this.f19918b.J().a("IncentivizedAdController", "Reward validated: " + map);
            }
        }

        @Override // com.applovin.sdk.AppLovinAdRewardListener
        public void validationRequestFailed(AppLovinAd appLovinAd, int i11) {
            jb.this.f19918b.J();
            if (com.applovin.impl.sdk.n.a()) {
                jb.this.f19918b.J().b("IncentivizedAdController", "Reward validation failed: " + i11);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements AppLovinAdLoadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AppLovinAdLoadListener f19927a;

        public b(AppLovinAdLoadListener appLovinAdLoadListener) {
            this.f19927a = appLovinAdLoadListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(int i11) {
            try {
                this.f19927a.failedToReceiveAd(i11);
            } catch (Throwable th2) {
                com.applovin.impl.sdk.n.c("AppLovinIncentivizedInterstitial", "Unable to notify listener about ad load failure", th2);
                jb.this.f19918b.E().a("IncentivizedAdController", "adLoadFailed", th2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(AppLovinAd appLovinAd) {
            try {
                this.f19927a.adReceived(appLovinAd);
            } catch (Throwable th2) {
                com.applovin.impl.sdk.n.c("AppLovinIncentivizedInterstitial", "Unable to notify ad listener about a newly loaded ad", th2);
                jb.this.f19918b.E().a("IncentivizedAdController", "adLoaded", th2);
            }
        }

        @Override // com.applovin.sdk.AppLovinAdLoadListener
        public void adReceived(final AppLovinAd appLovinAd) {
            jb.this.f19920d = appLovinAd;
            if (this.f19927a != null) {
                AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.zy
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f24930a.a(appLovinAd);
                    }
                });
            }
        }

        @Override // com.applovin.sdk.AppLovinAdLoadListener
        public void failedToReceiveAd(final int i11) {
            if (this.f19927a != null) {
                AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.az
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f17797a.a(i11);
                    }
                });
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements qb, AppLovinAdVideoPlaybackListener, AppLovinAdRewardListener, AppLovinAdClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AppLovinAd f19929a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AppLovinAdDisplayListener f19930b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final AppLovinAdClickListener f19931c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final AppLovinAdVideoPlaybackListener f19932d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final AppLovinAdRewardListener f19933f;

        private c(AppLovinAd appLovinAd, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
            this.f19929a = appLovinAd;
            this.f19930b = appLovinAdDisplayListener;
            this.f19931c = appLovinAdClickListener;
            this.f19932d = appLovinAdVideoPlaybackListener;
            this.f19933f = appLovinAdRewardListener;
        }

        public /* synthetic */ c(jb jbVar, AppLovinAd appLovinAd, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener, a aVar) {
            this(appLovinAd, appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
        }

        private void a(com.applovin.impl.sdk.ad.b bVar) {
            String str;
            int i11;
            jb.this.f19918b.J();
            if (com.applovin.impl.sdk.n.a()) {
                jb.this.f19918b.J().a("IncentivizedAdController", "Finishing direct ad...");
            }
            String strB = jb.this.b();
            if (!StringUtils.isValidString(strB) || !jb.this.f19925i) {
                jb.this.f19918b.J();
                if (com.applovin.impl.sdk.n.a()) {
                    jb.this.f19918b.J().b("IncentivizedAdController", "Invalid reward state - result: " + strB + " and wasFullyEngaged: " + jb.this.f19925i);
                }
                jb.this.f19918b.J();
                if (com.applovin.impl.sdk.n.a()) {
                    jb.this.f19918b.J().a("IncentivizedAdController", "Cancelling any incoming reward requests for this ad");
                }
                bVar.b();
                if (jb.this.f19925i) {
                    jb.this.f19918b.J();
                    if (com.applovin.impl.sdk.n.a()) {
                        jb.this.f19918b.J().b("IncentivizedAdController", "User close the ad after fully watching but reward validation task did not return on time");
                    }
                    str = "network_timeout";
                    i11 = AppLovinErrorCodes.INCENTIVIZED_SERVER_TIMEOUT;
                } else {
                    jb.this.f19918b.J();
                    if (com.applovin.impl.sdk.n.a()) {
                        jb.this.f19918b.J().b("IncentivizedAdController", "User close the ad prematurely");
                    }
                    str = "user_closed_video";
                    i11 = AppLovinErrorCodes.INCENTIVIZED_USER_CLOSED_VIDEO;
                }
                bVar.a(fh.a(str));
                jb.this.f19918b.J();
                if (com.applovin.impl.sdk.n.a()) {
                    jb.this.f19918b.J().a("IncentivizedAdController", "Notifying listener of reward validation failure");
                }
                gc.a(this.f19933f, bVar, i11);
            }
            if (bVar.E0().getAndSet(true)) {
                return;
            }
            jb.this.f19918b.J();
            if (com.applovin.impl.sdk.n.a()) {
                jb.this.f19918b.J().a("IncentivizedAdController", "Scheduling report rewarded ad...");
            }
            jb.this.f19918b.j0().a((yl) new en(bVar, jb.this.f19918b), tm.b.OTHER);
        }

        @Override // com.applovin.sdk.AppLovinAdClickListener
        public void adClicked(AppLovinAd appLovinAd) {
            gc.a(this.f19931c, appLovinAd);
        }

        @Override // com.applovin.sdk.AppLovinAdDisplayListener
        public void adDisplayed(AppLovinAd appLovinAd) {
            gc.a(this.f19930b, appLovinAd);
        }

        @Override // com.applovin.sdk.AppLovinAdDisplayListener
        public void adHidden(AppLovinAd appLovinAd) {
            String str;
            AppLovinAd appLovinAdE = appLovinAd instanceof com.applovin.impl.sdk.ad.c ? ((com.applovin.impl.sdk.ad.c) appLovinAd).e() : appLovinAd;
            if (appLovinAdE instanceof com.applovin.impl.sdk.ad.b) {
                a((com.applovin.impl.sdk.ad.b) appLovinAdE);
            } else {
                if (appLovinAdE == null) {
                    str = "null/expired ad";
                } else {
                    str = "invalid ad of type: " + appLovinAdE;
                }
                jb.this.f19918b.J();
                if (com.applovin.impl.sdk.n.a()) {
                    jb.this.f19918b.J().b("IncentivizedAdController", "Received `adHidden` callback for " + str);
                }
            }
            jb.this.a(appLovinAdE);
            jb.this.f19918b.J();
            if (com.applovin.impl.sdk.n.a()) {
                jb.this.f19918b.J().a("IncentivizedAdController", "Notifying listener of rewarded ad dismissal");
            }
            gc.b(this.f19930b, appLovinAd);
        }

        @Override // com.applovin.impl.qb
        public void onAdDisplayFailed(String str) {
            String str2;
            AppLovinAd appLovinAdE = this.f19929a;
            if (appLovinAdE instanceof com.applovin.impl.sdk.ad.c) {
                appLovinAdE = ((com.applovin.impl.sdk.ad.c) appLovinAdE).e();
            }
            boolean z11 = this.f19930b instanceof qb;
            if (appLovinAdE instanceof com.applovin.impl.sdk.ad.b) {
                a((com.applovin.impl.sdk.ad.b) appLovinAdE);
            } else {
                if (appLovinAdE == null) {
                    str2 = "null/expired ad";
                } else {
                    str2 = "invalid ad of type: " + appLovinAdE;
                }
                jb.this.f19918b.J();
                if (com.applovin.impl.sdk.n.a()) {
                    com.applovin.impl.sdk.n nVarJ = jb.this.f19918b.J();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Received `");
                    sb2.append(z11 ? "adDisplayFailed" : "adHidden");
                    sb2.append("` callback for ");
                    sb2.append(str2);
                    nVarJ.b("IncentivizedAdController", sb2.toString());
                }
            }
            jb.this.a(appLovinAdE);
            if (z11) {
                gc.a(this.f19930b, str);
            } else {
                gc.b(this.f19930b, this.f19929a);
            }
        }

        @Override // com.applovin.sdk.AppLovinAdRewardListener
        public void userOverQuota(AppLovinAd appLovinAd, Map map) {
            jb.this.a("quota_exceeded");
            gc.b(this.f19933f, appLovinAd, map);
        }

        @Override // com.applovin.sdk.AppLovinAdRewardListener
        public void userRewardRejected(AppLovinAd appLovinAd, Map map) {
            jb.this.a("rejected");
            gc.a(this.f19933f, appLovinAd, map);
        }

        @Override // com.applovin.sdk.AppLovinAdRewardListener
        public void userRewardVerified(AppLovinAd appLovinAd, Map map) {
            jb.this.a("accepted");
            gc.c(this.f19933f, appLovinAd, map);
        }

        @Override // com.applovin.sdk.AppLovinAdRewardListener
        public void validationRequestFailed(AppLovinAd appLovinAd, int i11) {
            jb.this.a("network_timeout");
            gc.a(this.f19933f, appLovinAd, i11);
        }

        @Override // com.applovin.sdk.AppLovinAdVideoPlaybackListener
        public void videoPlaybackBegan(AppLovinAd appLovinAd) {
            gc.a(this.f19932d, appLovinAd);
        }

        @Override // com.applovin.sdk.AppLovinAdVideoPlaybackListener
        public void videoPlaybackEnded(AppLovinAd appLovinAd, double d11, boolean z11) {
            gc.a(this.f19932d, appLovinAd, d11, z11);
            jb.this.f19925i = z11;
        }
    }

    public jb(String str, AppLovinSdk appLovinSdk) {
        this.f19918b = appLovinSdk.a();
        this.f19919c = (AppLovinAdServiceImpl) appLovinSdk.getAdService();
        this.f19921e = str;
    }

    private AppLovinAdRewardListener a() {
        return new a();
    }

    private String a(AppLovinAd appLovinAd, AppLovinAd appLovinAd2) {
        if (appLovinAd == null) {
            com.applovin.impl.sdk.n.h("IncentivizedAdController", "Unable to retrieve the loaded ad. This can occur when attempting to show an expired ad.: " + appLovinAd2);
            return "Unable to retrieve the loaded ad. This can occur when attempting to show an expired ad.";
        }
        if (appLovinAd2.getType() == AppLovinAdType.INCENTIVIZED || appLovinAd2.getType() == AppLovinAdType.AUTO_INCENTIVIZED) {
            return null;
        }
        com.applovin.impl.sdk.n.h("IncentivizedAdController", "Attempting to display ad with invalid ad type: " + appLovinAd2.getType());
        return "Attempting to display ad with invalid ad type";
    }

    private void a(AppLovinAdImpl appLovinAdImpl, Context context, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        c cVar = new c(this, appLovinAdImpl, appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener, null);
        AppLovinAd appLovinAdA = yp.a(appLovinAdImpl, this.f19918b);
        String strA = a(appLovinAdA, appLovinAdImpl);
        if (StringUtils.isValidString(strA)) {
            a(appLovinAdImpl, strA, cVar, cVar);
            return;
        }
        AppLovinInterstitialAdDialog appLovinInterstitialAdDialogCreate = AppLovinInterstitialAd.create(this.f19918b.s0(), context);
        for (String str : this.f19917a.keySet()) {
            appLovinInterstitialAdDialogCreate.setExtraInfo(str, this.f19917a.get(str));
        }
        appLovinInterstitialAdDialogCreate.setAdDisplayListener(cVar);
        appLovinInterstitialAdDialogCreate.setAdVideoPlaybackListener(cVar);
        appLovinInterstitialAdDialogCreate.setAdClickListener(cVar);
        appLovinInterstitialAdDialogCreate.showAndRender(appLovinAdA);
        a((com.applovin.impl.sdk.ad.b) appLovinAdA, cVar);
    }

    private void a(AppLovinAdImpl appLovinAdImpl, ViewGroup viewGroup, Lifecycle lifecycle, Context context, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        c cVar = new c(this, appLovinAdImpl, appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener, null);
        AppLovinAd appLovinAdA = yp.a(appLovinAdImpl, this.f19918b);
        String strA = a(appLovinAdA, appLovinAdImpl);
        if (StringUtils.isValidString(strA)) {
            a(appLovinAdImpl, strA, cVar, cVar);
            return;
        }
        AppLovinInterstitialAdDialog appLovinInterstitialAdDialogCreate = AppLovinInterstitialAd.create(this.f19918b.s0(), context);
        for (String str : this.f19917a.keySet()) {
            appLovinInterstitialAdDialogCreate.setExtraInfo(str, this.f19917a.get(str));
        }
        appLovinInterstitialAdDialogCreate.setAdDisplayListener(cVar);
        appLovinInterstitialAdDialogCreate.setAdVideoPlaybackListener(cVar);
        appLovinInterstitialAdDialogCreate.setAdClickListener(cVar);
        appLovinInterstitialAdDialogCreate.showAndRender(appLovinAdA, viewGroup, lifecycle);
        a((com.applovin.impl.sdk.ad.b) appLovinAdA, cVar);
    }

    private void a(com.applovin.impl.sdk.ad.b bVar, AppLovinAdRewardListener appLovinAdRewardListener) {
        this.f19918b.j0().a((yl) new kn(bVar, appLovinAdRewardListener, this.f19918b), tm.b.OTHER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AppLovinAd appLovinAd) {
        AppLovinAd appLovinAd2 = this.f19920d;
        if (appLovinAd2 == null) {
            return;
        }
        if (!(appLovinAd2 instanceof com.applovin.impl.sdk.ad.c)) {
            if (appLovinAd == appLovinAd2) {
                this.f19920d = null;
            }
        } else {
            com.applovin.impl.sdk.ad.c cVar = (com.applovin.impl.sdk.ad.c) appLovinAd2;
            if (cVar.e() == null || appLovinAd == cVar.e()) {
                this.f19920d = null;
            }
        }
    }

    private void a(AppLovinAd appLovinAd, Context context, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        AppLovinAdImpl appLovinAdImpl = appLovinAd != null ? (AppLovinAdImpl) appLovinAd : (AppLovinAdImpl) this.f19920d;
        if (appLovinAdImpl != null) {
            a(appLovinAdImpl, context, appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
        } else {
            com.applovin.impl.sdk.n.h("IncentivizedAdController", "Skipping incentivized video playback: user attempted to play an incentivized video before one was preloaded.");
            e();
        }
    }

    private void a(AppLovinAd appLovinAd, ViewGroup viewGroup, Lifecycle lifecycle, Context context, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        AppLovinAdImpl appLovinAdImpl = appLovinAd != null ? (AppLovinAdImpl) appLovinAd : (AppLovinAdImpl) this.f19920d;
        if (appLovinAdImpl != null) {
            a(appLovinAdImpl, viewGroup, lifecycle, context, appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
        } else {
            com.applovin.impl.sdk.n.h("IncentivizedAdController", "Skipping incentivized video playback: user attempted to play an incentivized video before one was preloaded.");
            e();
        }
    }

    private void a(AppLovinAd appLovinAd, String str, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, qb qbVar) {
        this.f19918b.D().c(ca.f18158o);
        gc.a(appLovinAdVideoPlaybackListener, appLovinAd, 0.0d, false);
        gc.a(qbVar, str);
    }

    private void a(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f19919c.loadNextIncentivizedAd(this.f19921e, appLovinAdLoadListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        synchronized (this.f19923g) {
            this.f19924h = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b() {
        String str;
        synchronized (this.f19923g) {
            str = this.f19924h;
        }
        return str;
    }

    private void e() {
        AppLovinAdLoadListener appLovinAdLoadListener;
        SoftReference softReference = this.f19922f;
        if (softReference == null || (appLovinAdLoadListener = (AppLovinAdLoadListener) softReference.get()) == null) {
            return;
        }
        appLovinAdLoadListener.failedToReceiveAd(AppLovinErrorCodes.INCENTIVIZED_NO_AD_PRELOADED);
    }

    public void a(AppLovinAd appLovinAd, Context context, String str, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        if (appLovinAdRewardListener == null) {
            appLovinAdRewardListener = a();
        }
        a(appLovinAd, context, appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
    }

    public void a(String str, Object obj) {
        this.f19917a.put(str, obj);
    }

    public void b(AppLovinAd appLovinAd, ViewGroup viewGroup, Lifecycle lifecycle, Context context, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        a(appLovinAd, viewGroup, lifecycle, context, appLovinAdRewardListener == null ? a() : appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
    }

    public void b(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f19918b.J();
        if (com.applovin.impl.sdk.n.a()) {
            this.f19918b.J().a("IncentivizedAdController", "User requested preload of incentivized ad...");
        }
        this.f19922f = new SoftReference(appLovinAdLoadListener);
        if (!d()) {
            a(new b(appLovinAdLoadListener));
            return;
        }
        com.applovin.impl.sdk.n.h("IncentivizedAdController", "Attempted to call preloadAndNotify: while an ad was already loaded or currently being played. Do not call preloadAndNotify: again until the last ad has been closed (adHidden).");
        if (appLovinAdLoadListener != null) {
            appLovinAdLoadListener.adReceived(this.f19920d);
        }
    }

    public String c() {
        return this.f19921e;
    }

    public boolean d() {
        return this.f19920d != null;
    }
}
