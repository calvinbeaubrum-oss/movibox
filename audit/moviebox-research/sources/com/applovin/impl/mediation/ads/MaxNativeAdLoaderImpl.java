package com.applovin.impl.mediation.ads;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.applovin.impl.gc;
import com.applovin.impl.ge;
import com.applovin.impl.j8;
import com.applovin.impl.je;
import com.applovin.impl.jn;
import com.applovin.impl.mediation.MaxErrorImpl;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.tm;
import com.applovin.impl.v;
import com.applovin.impl.ve;
import com.applovin.impl.yl;
import com.applovin.impl.yp;
import com.applovin.impl.z3;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.nativeAds.MaxNativeAd;
import com.applovin.mediation.nativeAds.MaxNativeAdListener;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class MaxNativeAdLoaderImpl extends com.applovin.impl.mediation.ads.a implements com.applovin.impl.sdk.a.InterfaceC0199a, v.b {
    public static final String KEY_EXTRA_PARAMETER_AD_REQUEST_TYPE = "ad_request_type";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f20792a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f20793b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f20794c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.applovin.impl.mediation.d.b f20795d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f20796e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private MaxNativeAdListener f20797f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Map f20798g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Set f20799h;

    /* JADX INFO: compiled from: source.java */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MaxNativeAd f20800a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ List f20801b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ViewGroup f20802c;

        public a(MaxNativeAd maxNativeAd, List list, ViewGroup viewGroup) {
            this.f20800a = maxNativeAd;
            this.f20801b = list;
            this.f20802c = viewGroup;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f20800a.prepareForInteraction(this.f20801b, this.f20802c)) {
                return;
            }
            com.applovin.impl.sdk.n.h(MaxNativeAdLoaderImpl.this.tag, "Failed to prepare native ad for interaction...");
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MaxNativeAdView f20804a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ je f20805b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ MaxNativeAd f20806c;

        public b(MaxNativeAdView maxNativeAdView, je jeVar, MaxNativeAd maxNativeAd) {
            this.f20804a = maxNativeAdView;
            this.f20805b = jeVar;
            this.f20806c = maxNativeAd;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.applovin.impl.sdk.n nVar = MaxNativeAdLoaderImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxNativeAdLoaderImpl maxNativeAdLoaderImpl = MaxNativeAdLoaderImpl.this;
                maxNativeAdLoaderImpl.logger.a(maxNativeAdLoaderImpl.tag, "Rendering native ad view: " + this.f20804a);
            }
            this.f20804a.render(this.f20805b, MaxNativeAdLoaderImpl.this.f20792a, MaxNativeAdLoaderImpl.this.sdk);
            this.f20806c.setNativeAdView(this.f20804a);
            if (this.f20806c.prepareForInteraction(this.f20804a.getClickableViews(), this.f20804a)) {
                return;
            }
            this.f20806c.prepareViewForInteraction(this.f20804a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements com.applovin.impl.mediation.ads.a.InterfaceC0188a {
        private c() {
        }

        public /* synthetic */ c(MaxNativeAdLoaderImpl maxNativeAdLoaderImpl, a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(MaxAd maxAd) {
            com.applovin.impl.sdk.n nVar = MaxNativeAdLoaderImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxNativeAdLoaderImpl maxNativeAdLoaderImpl = MaxNativeAdLoaderImpl.this;
                maxNativeAdLoaderImpl.logger.a(maxNativeAdLoaderImpl.tag, "Native ad loaded");
            }
            je jeVar = (je) maxAd;
            jeVar.g(MaxNativeAdLoaderImpl.this.f20793b);
            jeVar.f(MaxNativeAdLoaderImpl.this.f20794c);
            MaxNativeAdLoaderImpl.this.sdk.w().d(jeVar);
            synchronized (MaxNativeAdLoaderImpl.this.f20796e) {
                MaxNativeAdLoaderImpl.this.f20799h.add(jeVar);
            }
            MaxNativeAdView maxNativeAdViewA = MaxNativeAdLoaderImpl.this.a(jeVar.N());
            if (maxNativeAdViewA == null) {
                com.applovin.impl.sdk.n nVar2 = MaxNativeAdLoaderImpl.this.logger;
                if (com.applovin.impl.sdk.n.a()) {
                    MaxNativeAdLoaderImpl maxNativeAdLoaderImpl2 = MaxNativeAdLoaderImpl.this;
                    maxNativeAdLoaderImpl2.logger.a(maxNativeAdLoaderImpl2.tag, "No custom view provided, checking template");
                }
                String strU0 = jeVar.u0();
                if (StringUtils.isValidString(strU0)) {
                    com.applovin.impl.sdk.n nVar3 = MaxNativeAdLoaderImpl.this.logger;
                    if (com.applovin.impl.sdk.n.a()) {
                        MaxNativeAdLoaderImpl maxNativeAdLoaderImpl3 = MaxNativeAdLoaderImpl.this;
                        maxNativeAdLoaderImpl3.logger.a(maxNativeAdLoaderImpl3.tag, "Using template: " + strU0 + "...");
                    }
                    maxNativeAdViewA = new MaxNativeAdView(strU0, com.applovin.impl.sdk.j.l());
                }
            }
            if (maxNativeAdViewA == null) {
                com.applovin.impl.sdk.n nVar4 = MaxNativeAdLoaderImpl.this.logger;
                if (com.applovin.impl.sdk.n.a()) {
                    MaxNativeAdLoaderImpl maxNativeAdLoaderImpl4 = MaxNativeAdLoaderImpl.this;
                    maxNativeAdLoaderImpl4.logger.a(maxNativeAdLoaderImpl4.tag, "No native ad view to render. Returning the native ad to be rendered later.");
                }
                com.applovin.impl.sdk.n nVar5 = MaxNativeAdLoaderImpl.this.logger;
                if (com.applovin.impl.sdk.n.a()) {
                    MaxNativeAdLoaderImpl maxNativeAdLoaderImpl5 = MaxNativeAdLoaderImpl.this;
                    maxNativeAdLoaderImpl5.logger.a(maxNativeAdLoaderImpl5.tag, "MaxNativeAdListener.onNativeAdLoaded(nativeAdView=null, nativeAd=" + maxAd + "), listener=" + MaxNativeAdLoaderImpl.this.f20797f);
                }
                gc.a(MaxNativeAdLoaderImpl.this.f20797f, (MaxNativeAdView) null, maxAd, true);
                MaxNativeAdLoaderImpl.this.a(jeVar);
                return;
            }
            a(maxNativeAdViewA);
            MaxNativeAdLoaderImpl.this.a(maxNativeAdViewA, jeVar, jeVar.getNativeAd());
            com.applovin.impl.sdk.n nVar6 = MaxNativeAdLoaderImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxNativeAdLoaderImpl maxNativeAdLoaderImpl6 = MaxNativeAdLoaderImpl.this;
                maxNativeAdLoaderImpl6.logger.a(maxNativeAdLoaderImpl6.tag, "MaxNativeAdListener.onNativeAdLoaded(nativeAdView=" + maxNativeAdViewA + ", nativeAd=" + maxAd + "), listener=" + MaxNativeAdLoaderImpl.this.f20797f);
            }
            gc.a(MaxNativeAdLoaderImpl.this.f20797f, maxNativeAdViewA, maxAd, true);
            MaxNativeAdLoaderImpl.this.a(jeVar);
            MaxNativeAdLoaderImpl.this.a(maxNativeAdViewA);
        }

        private void a(MaxNativeAdView maxNativeAdView) {
            je jeVarB;
            com.applovin.impl.mediation.ads.b adViewTracker = maxNativeAdView.getAdViewTracker();
            if (adViewTracker == null || (jeVarB = adViewTracker.b()) == null) {
                return;
            }
            com.applovin.impl.sdk.n nVar = MaxNativeAdLoaderImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxNativeAdLoaderImpl maxNativeAdLoaderImpl = MaxNativeAdLoaderImpl.this;
                maxNativeAdLoaderImpl.logger.a(maxNativeAdLoaderImpl.tag, "Destroying previous ad");
            }
            MaxNativeAdLoaderImpl.this.destroy(jeVarB);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdClicked(MaxAd maxAd) {
            com.applovin.impl.sdk.n nVar = MaxNativeAdLoaderImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxNativeAdLoaderImpl maxNativeAdLoaderImpl = MaxNativeAdLoaderImpl.this;
                maxNativeAdLoaderImpl.logger.a(maxNativeAdLoaderImpl.tag, "MaxNativeAdListener.onNativeAdClicked(nativeAd=" + maxAd + "), listener=" + MaxNativeAdLoaderImpl.this.f20797f);
            }
            gc.a(MaxNativeAdLoaderImpl.this.f20797f, maxAd, true);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdDisplayed(MaxAd maxAd) {
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdHidden(MaxAd maxAd) {
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoadFailed(String str, MaxError maxError) {
            MaxNativeAdLoaderImpl.this.a(((MaxErrorImpl) maxError).getLoadTag());
            com.applovin.impl.sdk.n nVar = MaxNativeAdLoaderImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxNativeAdLoaderImpl maxNativeAdLoaderImpl = MaxNativeAdLoaderImpl.this;
                maxNativeAdLoaderImpl.logger.a(maxNativeAdLoaderImpl.tag, "MaxNativeAdListener.onNativeAdLoadFailed(adUnitId=" + str + ", error=" + maxError + "), listener=" + MaxNativeAdLoaderImpl.this.f20797f);
            }
            gc.a(MaxNativeAdLoaderImpl.this.f20797f, str, maxError, true);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoaded(final MaxAd maxAd) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.mediation.ads.t
                @Override // java.lang.Runnable
                public final void run() {
                    this.f20854a.a(maxAd);
                }
            });
        }

        @Override // com.applovin.mediation.MaxAdRequestListener
        public void onAdRequestStarted(String str) {
        }

        @Override // com.applovin.mediation.MaxAdRevenueListener
        public void onAdRevenuePaid(MaxAd maxAd) {
            com.applovin.impl.sdk.n nVar = MaxNativeAdLoaderImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxNativeAdLoaderImpl maxNativeAdLoaderImpl = MaxNativeAdLoaderImpl.this;
                maxNativeAdLoaderImpl.logger.a(maxNativeAdLoaderImpl.tag, "MaxAdRevenueListener.onAdRevenuePaid(ad=" + maxAd + "), listener=" + MaxNativeAdLoaderImpl.this.revenueListener);
            }
            gc.a(MaxNativeAdLoaderImpl.this.revenueListener, maxAd, true);
        }
    }

    public MaxNativeAdLoaderImpl(String str, com.applovin.impl.sdk.j jVar) {
        super(str, MaxAdFormat.NATIVE, "MaxNativeAdLoader", jVar);
        this.f20792a = new c(this, null);
        this.f20795d = com.applovin.impl.mediation.d.b.PUBLISHER_INITIATED;
        this.f20796e = new Object();
        this.f20798g = new HashMap();
        this.f20799h = new HashSet();
        jVar.h().a(this);
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "Created new MaxNativeAdLoader (" + this + ")");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MaxNativeAdView a(String str) {
        MaxNativeAdView maxNativeAdView;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.f20796e) {
            maxNativeAdView = (MaxNativeAdView) this.f20798g.remove(str);
        }
        return maxNativeAdView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(je jeVar) {
        if (jeVar.t0().get()) {
            return;
        }
        this.sdk.f().a(jeVar, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MaxNativeAdView maxNativeAdView) {
        com.applovin.impl.mediation.ads.b adViewTracker = maxNativeAdView.getAdViewTracker();
        if (adViewTracker != null) {
            if (z3.e()) {
                if (maxNativeAdView.isAttachedToWindow()) {
                    adViewTracker.c();
                }
            } else if (maxNativeAdView.getParent() != null) {
                adViewTracker.c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MaxNativeAdView maxNativeAdView, je jeVar, MaxNativeAd maxNativeAd) {
        jeVar.a(maxNativeAdView);
        a((ge) jeVar);
        b bVar = new b(maxNativeAdView, jeVar, maxNativeAd);
        if (maxNativeAd.shouldPrepareViewForInteractionOnMainThread()) {
            AppLovinSdkUtils.runOnUiThread(bVar);
        } else {
            this.sdk.j0().a((yl) new jn(this.sdk, "renderMaxNativeAd", bVar), tm.b.MEDIATION);
        }
    }

    private void a(String str, MaxNativeAdView maxNativeAdView) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.f20796e) {
            this.f20798g.put(str, maxNativeAdView);
        }
    }

    @Override // com.applovin.impl.mediation.ads.a
    public void destroy() {
        this.f20797f = null;
        this.sdk.h().b(this);
        synchronized (this.f20796e) {
            this.f20798g.clear();
            this.f20799h.clear();
        }
        super.destroy();
    }

    public void destroy(MaxAd maxAd) {
        com.applovin.impl.mediation.ads.b adViewTracker;
        if (!(maxAd instanceof je)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Destroy failed on non-native ad(" + maxAd + ")");
                return;
            }
            return;
        }
        je jeVar = (je) maxAd;
        if (jeVar.x0()) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Native ad (" + jeVar + ") has already been destroyed");
                return;
            }
            return;
        }
        synchronized (this.f20796e) {
            this.f20799h.remove(jeVar);
        }
        MaxNativeAdView maxNativeAdViewR0 = jeVar.r0();
        if (maxNativeAdViewR0 != null && (adViewTracker = maxNativeAdViewR0.getAdViewTracker()) != null && maxAd.equals(adViewTracker.b())) {
            maxNativeAdViewR0.recycle();
        }
        MaxNativeAd nativeAd = jeVar.getNativeAd();
        if (nativeAd != null && nativeAd.getAdViewTracker() != null) {
            nativeAd.getAdViewTracker().a();
        }
        this.sdk.f().a(jeVar);
        this.sdk.Q().destroyAd(jeVar);
        this.sdk.K().c(this.adUnitId, jeVar.N());
    }

    public String getPlacement() {
        return this.f20793b;
    }

    public void handleNativeAdViewRendered(MaxAd maxAd) {
        MaxNativeAd nativeAd = ((je) maxAd).getNativeAd();
        if (nativeAd == null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.b(this.tag, "Failed to handle native ad rendered. Could not retrieve MaxNativeAd. The ad may have already been destroyed.");
                return;
            }
            return;
        }
        com.applovin.impl.mediation.ads.b adViewTracker = nativeAd.getAdViewTracker();
        if (adViewTracker != null) {
            adViewTracker.c();
        } else if (com.applovin.impl.sdk.n.a()) {
            this.logger.b(this.tag, "Failed to handle native ad rendered. Could not retrieve tracker. Ad might not have been registered via MaxNativeAdLoader.a(...).");
        }
    }

    public void loadAd(@Nullable MaxNativeAdView maxNativeAdView) {
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "Loading native ad for '" + this.adUnitId + "' into '" + maxNativeAdView + "' and notifying " + this.f20792a + "...");
        }
        this.extraParameters.put("integration_type", maxNativeAdView != null ? "custom_ad_view" : "no_ad_view");
        String lowerCase = UUID.randomUUID().toString().toLowerCase(Locale.US);
        a(lowerCase, maxNativeAdView);
        this.sdk.Q().loadAd(this.adUnitId, lowerCase, MaxAdFormat.NATIVE, this.f20795d, this.localExtraParameters, this.extraParameters, com.applovin.impl.sdk.j.l(), this.f20792a);
    }

    @Override // com.applovin.impl.sdk.a.InterfaceC0199a
    public void onAdExpired(j8 j8Var) {
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "Ad expired for ad unit id " + getAdUnitId());
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "MaxNativeAdListener.onNativeAdExpired(nativeAd=" + j8Var + "), listener=" + this.f20797f);
        }
        gc.b(this.f20797f, (MaxAd) j8Var, true);
    }

    @Override // com.applovin.impl.v.b
    public void onCreativeIdGenerated(String str, String str2) {
        je jeVar;
        Iterator it = this.f20799h.iterator();
        do {
            if (!it.hasNext()) {
                jeVar = null;
                break;
            }
            jeVar = (je) it.next();
        } while (!jeVar.T().equalsIgnoreCase(str));
        if (jeVar != null) {
            jeVar.h(str2);
            gc.b(this.adReviewListener, str2, jeVar);
            synchronized (this.f20796e) {
                this.f20799h.remove(jeVar);
            }
        }
    }

    public void registerClickableViews(List<View> list, ViewGroup viewGroup, MaxAd maxAd) {
        je jeVar = (je) maxAd;
        MaxNativeAd nativeAd = jeVar.getNativeAd();
        if (nativeAd == null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.b(this.tag, "Failed to register native ad. Could not retrieve MaxNativeAd. The ad may have already been destroyed.");
                return;
            }
            return;
        }
        jeVar.a(viewGroup);
        this.sdk.w().d(jeVar);
        a((ge) jeVar);
        nativeAd.setClickableViews(list);
        nativeAd.setAdViewTracker(new com.applovin.impl.mediation.ads.b(jeVar, viewGroup, this.f20792a, this.sdk));
        a aVar = new a(nativeAd, list, viewGroup);
        if (nativeAd.shouldPrepareViewForInteractionOnMainThread()) {
            AppLovinSdkUtils.runOnUiThread(aVar);
        } else {
            this.sdk.j0().a((yl) new jn(this.sdk, "renderMaxNativeAd", aVar), tm.b.MEDIATION);
        }
    }

    public boolean render(MaxNativeAdView maxNativeAdView, MaxAd maxAd) {
        if (!(maxAd instanceof je)) {
            com.applovin.impl.sdk.n.h(this.tag, "Failed to render native ad. `ad` needs to be of type `MediatedNativeAd` to render.");
            return false;
        }
        if (maxNativeAdView == null) {
            com.applovin.impl.sdk.n.h(this.tag, "Failed to render native ad. `adView` to render cannot be null.");
            return false;
        }
        je jeVar = (je) maxAd;
        MaxNativeAd nativeAd = jeVar.getNativeAd();
        if (nativeAd == null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.b(this.tag, "Failed to render native ad. Could not retrieve MaxNativeAd. The ad may have already been destroyed.");
            }
            return false;
        }
        if (nativeAd.isExpired() && !((Boolean) this.sdk.a(ve.f23889l7)).booleanValue()) {
            com.applovin.impl.sdk.n.h(this.tag, "Cancelled rendering for expired native ad. Check if an ad is expired before displaying using `MaxAd.getNativeAd().isExpired()`");
            return false;
        }
        a(maxNativeAdView, jeVar, nativeAd);
        a(maxNativeAdView);
        return true;
    }

    public void setCustomData(String str) {
        yp.b(str, this.tag);
        this.f20794c = str;
    }

    @Override // com.applovin.impl.mediation.ads.a
    public void setLocalExtraParameter(String str, Object obj) {
        super.setLocalExtraParameter(str, obj);
        if (KEY_EXTRA_PARAMETER_AD_REQUEST_TYPE.equalsIgnoreCase(str) && (obj instanceof com.applovin.impl.mediation.d.b)) {
            this.f20795d = (com.applovin.impl.mediation.d.b) obj;
        }
    }

    public void setNativeAdListener(MaxNativeAdListener maxNativeAdListener) {
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "Setting native ad listener: " + maxNativeAdListener);
        }
        this.f20797f = maxNativeAdListener;
    }

    public void setPlacement(String str) {
        this.f20793b = str;
    }

    @NonNull
    public String toString() {
        return "MaxNativeAdLoader{adUnitId='" + this.adUnitId + "', nativeAdListener=" + this.f20797f + ", revenueListener=" + this.revenueListener + '}';
    }
}
