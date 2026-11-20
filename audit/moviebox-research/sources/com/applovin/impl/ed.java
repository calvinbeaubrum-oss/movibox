package com.applovin.impl;

import android.content.Context;
import com.applovin.impl.mediation.ads.MaxNativeAdLoaderImpl;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.nativeAds.MaxNativeAdListener;
import com.applovin.mediation.nativeAds.MaxNativeAdLoader;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.applovin.mediation.nativeAds.adPlacer.MaxAdPlacerSettings;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class ed extends MaxNativeAdListener implements MaxAdRevenueListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f18687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MaxNativeAdLoader f18688b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Queue f18689c = new LinkedList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f18690d = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Object f18691f = new Object();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private a f18692g;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void onAdRevenuePaid(MaxAd maxAd);

        void onNativeAdClicked(MaxAd maxAd);

        void onNativeAdLoadFailed(String str, MaxError maxError);

        void onNativeAdLoaded();
    }

    public ed(MaxAdPlacerSettings maxAdPlacerSettings, Context context, a aVar) {
        this.f18687a = maxAdPlacerSettings.getMaxPreloadedAdCount();
        this.f18692g = aVar;
        MaxNativeAdLoader maxNativeAdLoader = new MaxNativeAdLoader(maxAdPlacerSettings.getAdUnitId(), context);
        this.f18688b = maxNativeAdLoader;
        maxNativeAdLoader.setNativeAdListener(this);
        maxNativeAdLoader.setRevenueListener(this);
        maxNativeAdLoader.setPlacement(maxAdPlacerSettings.getPlacement());
        maxNativeAdLoader.setLocalExtraParameter(MaxNativeAdLoaderImpl.KEY_EXTRA_PARAMETER_AD_REQUEST_TYPE, com.applovin.impl.mediation.d.b.NATIVE_AD_PLACER);
    }

    public void a() {
        synchronized (this.f18691f) {
            try {
                Iterator it = this.f18689c.iterator();
                while (it.hasNext()) {
                    a((MaxAd) it.next());
                }
                this.f18689c.clear();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void a(MaxAd maxAd) {
        this.f18688b.destroy(maxAd);
    }

    public boolean a(MaxNativeAdView maxNativeAdView, MaxAd maxAd) {
        return this.f18688b.render(maxNativeAdView, maxAd);
    }

    public MaxAd b() {
        MaxAd maxAd;
        synchronized (this.f18691f) {
            maxAd = null;
            while (!this.f18689c.isEmpty() && (maxAd == null || maxAd.getNativeAd().isExpired())) {
                try {
                    maxAd = (MaxAd) this.f18689c.remove();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            e();
        }
        return maxAd;
    }

    public void c() {
        this.f18692g = null;
        a();
        this.f18688b.destroy();
    }

    public boolean d() {
        boolean z11;
        synchronized (this.f18691f) {
            z11 = !this.f18689c.isEmpty();
        }
        return z11;
    }

    public void e() {
        synchronized (this.f18691f) {
            try {
                if (!this.f18690d && this.f18689c.size() < this.f18687a) {
                    this.f18690d = true;
                    this.f18688b.loadAd();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.applovin.mediation.MaxAdRevenueListener
    public void onAdRevenuePaid(MaxAd maxAd) {
        a aVar = this.f18692g;
        if (aVar != null) {
            aVar.onAdRevenuePaid(maxAd);
        }
    }

    @Override // com.applovin.mediation.nativeAds.MaxNativeAdListener
    public void onNativeAdClicked(MaxAd maxAd) {
        a aVar = this.f18692g;
        if (aVar != null) {
            aVar.onNativeAdClicked(maxAd);
        }
    }

    @Override // com.applovin.mediation.nativeAds.MaxNativeAdListener
    public void onNativeAdLoadFailed(String str, MaxError maxError) {
        a aVar = this.f18692g;
        if (aVar != null) {
            aVar.onNativeAdLoadFailed(str, maxError);
        }
    }

    @Override // com.applovin.mediation.nativeAds.MaxNativeAdListener
    public void onNativeAdLoaded(MaxNativeAdView maxNativeAdView, MaxAd maxAd) {
        synchronized (this.f18691f) {
            this.f18689c.add(maxAd);
            this.f18690d = false;
            e();
        }
        a aVar = this.f18692g;
        if (aVar != null) {
            aVar.onNativeAdLoaded();
        }
    }
}
