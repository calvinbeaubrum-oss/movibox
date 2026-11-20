package com.applovin.mediation.nativeAds.adPlacer;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.applovin.impl.ed;
import com.applovin.impl.je;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.n;
import com.applovin.impl.zc;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.applovin.mediation.nativeAds.MaxNativeAdViewBinder;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class MaxAdPlacer implements ed.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AppLovinSdkUtils.Size f25012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private MaxNativeAdViewBinder f25013b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zc f25014c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ed f25015d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Listener f25016e;
    protected final n logger;
    protected final j sdk;

    /* JADX INFO: compiled from: source.java */
    public interface Listener {
        void onAdClicked(MaxAd maxAd);

        void onAdLoaded(int i11);

        void onAdRemoved(int i11);

        void onAdRevenuePaid(MaxAd maxAd);
    }

    public MaxAdPlacer(MaxAdPlacerSettings maxAdPlacerSettings, Context context) {
        this(maxAdPlacerSettings, AppLovinSdk.getInstance(context), context);
    }

    public MaxAdPlacer(MaxAdPlacerSettings maxAdPlacerSettings, AppLovinSdk appLovinSdk, Context context) {
        this.f25012a = AppLovinSdkUtils.Size.ZERO;
        j jVarA = appLovinSdk.a();
        this.sdk = jVarA;
        n nVarJ = jVarA.J();
        this.logger = nVarJ;
        this.f25014c = new zc(maxAdPlacerSettings);
        this.f25015d = new ed(maxAdPlacerSettings, context, this);
        if (n.a()) {
            nVarJ.a("MaxAdPlacer", "Initializing ad placer with settings: " + maxAdPlacerSettings);
        }
    }

    private void a() {
        int iC;
        while (this.f25015d.d() && (iC = this.f25014c.c()) != -1) {
            if (n.a()) {
                this.logger.a("MaxAdPlacer", "Placing ad at position: " + iC);
            }
            this.f25014c.a(this.f25015d.b(), iC);
            Listener listener = this.f25016e;
            if (listener != null) {
                listener.onAdLoaded(iC);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int i11) {
        if (n.a()) {
            this.logger.a("MaxAdPlacer", "Removing item at position: " + i11);
        }
        this.f25014c.i(i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int i11, Collection collection) {
        if (n.a()) {
            this.logger.a("MaxAdPlacer", "Clearing trailing ads after position " + i11);
        }
        this.f25014c.a(collection);
    }

    private void a(Collection collection, Runnable runnable) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            this.f25015d.a(this.f25014c.a(((Integer) it.next()).intValue()));
        }
        runnable.run();
        if (collection.isEmpty()) {
            return;
        }
        if (n.a()) {
            this.logger.a("MaxAdPlacer", "Removed " + collection.size() + " ads from stream: " + collection);
        }
        if (this.f25016e != null) {
            Iterator it2 = collection.iterator();
            while (it2.hasNext()) {
                this.f25016e.onAdRemoved(((Integer) it2.next()).intValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b() {
        if (n.a()) {
            this.logger.a("MaxAdPlacer", "Clearing all cached ads");
        }
        this.f25014c.a();
        this.f25015d.a();
    }

    public void clearAds() {
        a(this.f25014c.b(), new Runnable() { // from class: com.applovin.mediation.nativeAds.adPlacer.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f25040a.b();
            }
        });
    }

    public Collection<Integer> clearTrailingAds(final int i11) {
        final Collection<Integer> collectionE = this.f25014c.e(i11);
        if (!collectionE.isEmpty()) {
            a(collectionE, new Runnable() { // from class: com.applovin.mediation.nativeAds.adPlacer.a
                @Override // java.lang.Runnable
                public final void run() {
                    this.f25035a.a(i11, collectionE);
                }
            });
        }
        return collectionE;
    }

    public void destroy() {
        if (n.a()) {
            this.logger.a("MaxAdPlacer", "Destroying ad placer");
        }
        clearAds();
        this.f25015d.c();
    }

    public long getAdItemId(int i11) {
        if (isFilledPosition(i11)) {
            return -System.identityHashCode(this.f25014c.a(i11));
        }
        return 0L;
    }

    public AppLovinSdkUtils.Size getAdSize(int i11, int i12) {
        if (isFilledPosition(i11)) {
            AppLovinSdkUtils.Size size = this.f25012a;
            boolean z11 = size != AppLovinSdkUtils.Size.ZERO;
            int iMin = Math.min(z11 ? size.getWidth() : 360, i12);
            je jeVar = (je) this.f25014c.a(i11);
            if ("small_template_1".equalsIgnoreCase(jeVar.u0())) {
                return new AppLovinSdkUtils.Size(iMin, z11 ? this.f25012a.getHeight() : 120);
            }
            if (MaxNativeAdView.MEDIUM_TEMPLATE_1.equalsIgnoreCase(jeVar.u0())) {
                return new AppLovinSdkUtils.Size(iMin, (int) (((double) iMin) / (z11 ? ((double) this.f25012a.getWidth()) / ((double) this.f25012a.getHeight()) : 1.2d)));
            }
            if (z11) {
                return this.f25012a;
            }
            if (jeVar.r0() != null) {
                View mainView = jeVar.r0().getMainView();
                return new AppLovinSdkUtils.Size(mainView.getMeasuredWidth(), mainView.getMeasuredHeight());
            }
        }
        return AppLovinSdkUtils.Size.ZERO;
    }

    public int getAdjustedCount(int i11) {
        return this.f25014c.b(i11);
    }

    public int getAdjustedPosition(int i11) {
        return this.f25014c.c(i11);
    }

    public int getOriginalPosition(int i11) {
        return this.f25014c.d(i11);
    }

    public void insertItem(int i11) {
        if (n.a()) {
            this.logger.a("MaxAdPlacer", "Inserting item at position: " + i11);
        }
        this.f25014c.f(i11);
    }

    public boolean isAdPosition(int i11) {
        return this.f25014c.g(i11);
    }

    public boolean isFilledPosition(int i11) {
        return this.f25014c.h(i11);
    }

    public void loadAds() {
        if (n.a()) {
            this.logger.a("MaxAdPlacer", "Loading ads");
        }
        this.f25015d.e();
    }

    public void moveItem(int i11, int i12) {
        this.f25014c.b(i11, i12);
    }

    @Override // com.applovin.impl.ed.a
    public void onAdRevenuePaid(MaxAd maxAd) {
        Listener listener = this.f25016e;
        if (listener != null) {
            listener.onAdRevenuePaid(maxAd);
        }
    }

    @Override // com.applovin.impl.ed.a
    public void onNativeAdClicked(MaxAd maxAd) {
        Listener listener = this.f25016e;
        if (listener != null) {
            listener.onAdClicked(maxAd);
        }
    }

    @Override // com.applovin.impl.ed.a
    public void onNativeAdLoadFailed(String str, MaxError maxError) {
        if (n.a()) {
            this.logger.b("MaxAdPlacer", "Native ad failed to load: " + maxError);
        }
    }

    @Override // com.applovin.impl.ed.a
    public void onNativeAdLoaded() {
        if (n.a()) {
            this.logger.a("MaxAdPlacer", "Native ad enqueued");
        }
        a();
    }

    public void removeItem(final int i11) {
        a(isFilledPosition(i11) ? Collections.singletonList(Integer.valueOf(i11)) : Collections.emptyList(), new Runnable() { // from class: com.applovin.mediation.nativeAds.adPlacer.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f25038a.a(i11);
            }
        });
    }

    public void renderAd(int i11, ViewGroup viewGroup) {
        MaxAd maxAdA = this.f25014c.a(i11);
        if (maxAdA == null) {
            if (n.a()) {
                this.logger.a("MaxAdPlacer", "An ad is not available for position: " + i11);
                return;
            }
            return;
        }
        MaxNativeAdView maxNativeAdViewR0 = ((je) maxAdA).r0();
        if (maxNativeAdViewR0 == null) {
            if (this.f25013b == null) {
                if (n.a()) {
                    this.logger.b("MaxAdPlacer", "Unable to render ad at position: " + i11 + ". If you're using a custom ad template, check that nativeAdViewBinder is set.");
                    return;
                }
                return;
            }
            maxNativeAdViewR0 = new MaxNativeAdView(this.f25013b, viewGroup.getContext());
            if (this.f25015d.a(maxNativeAdViewR0, maxAdA)) {
                if (n.a()) {
                    this.logger.a("MaxAdPlacer", "Rendered ad at position: " + i11);
                }
            } else if (n.a()) {
                this.logger.b("MaxAdPlacer", "Unable to render ad at position: " + i11);
            }
        } else if (n.a()) {
            this.logger.a("MaxAdPlacer", "Using pre-rendered ad at position: " + i11);
        }
        for (int childCount = viewGroup.getChildCount(); childCount >= 0; childCount--) {
            if (viewGroup.getChildAt(childCount) instanceof MaxNativeAdView) {
                viewGroup.removeViewAt(childCount);
            }
        }
        if (maxNativeAdViewR0.getParent() != null) {
            ((ViewGroup) maxNativeAdViewR0.getParent()).removeView(maxNativeAdViewR0);
        }
        viewGroup.addView(maxNativeAdViewR0, -1, -1);
    }

    public void setAdSize(int i11, int i12) {
        this.f25012a = new AppLovinSdkUtils.Size(i11, i12);
    }

    public void setListener(Listener listener) {
        this.f25016e = listener;
    }

    public void setNativeAdViewBinder(MaxNativeAdViewBinder maxNativeAdViewBinder) {
        this.f25013b = maxNativeAdViewBinder;
    }

    public void updateFillablePositions(int i11, int i12) {
        this.f25014c.c(i11, i12);
        if (i11 == -1 || i12 == -1) {
            return;
        }
        a();
    }
}
