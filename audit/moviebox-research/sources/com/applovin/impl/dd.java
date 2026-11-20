package com.applovin.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.mediation.adapter.listeners.MaxAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxAppOpenAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener;
import com.applovin.mediation.hybridAds.MaxHybridMRecAdActivity;
import com.applovin.mediation.hybridAds.MaxHybridNativeAdActivity;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class dd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f18437a;

    /* JADX INFO: compiled from: source.java */
    public static class a extends p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ie f18438a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.applovin.impl.sdk.j f18439b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final MaxAdapterListener f18440c;

        public a(ie ieVar, com.applovin.impl.sdk.j jVar, MaxAdapterListener maxAdapterListener) {
            this.f18438a = ieVar;
            this.f18439b = jVar;
            this.f18440c = maxAdapterListener;
        }

        @Override // com.applovin.impl.p, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (activity instanceof MaxHybridMRecAdActivity) {
                ((MaxHybridMRecAdActivity) activity).a(this.f18438a.I(), this.f18438a.z(), this.f18439b, this.f18440c);
            }
        }

        @Override // com.applovin.impl.p, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if ((activity instanceof MaxHybridMRecAdActivity) && !activity.isChangingConfigurations() && this.f18438a.x().get()) {
                this.f18439b.e().b(this);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b extends p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ie f18441a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.applovin.impl.sdk.j f18442b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final MaxAdapterListener f18443c;

        public b(ie ieVar, com.applovin.impl.sdk.j jVar, MaxAdapterListener maxAdapterListener) {
            this.f18441a = ieVar;
            this.f18442b = jVar;
            this.f18443c = maxAdapterListener;
        }

        @Override // com.applovin.impl.p, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (activity instanceof MaxHybridNativeAdActivity) {
                ((MaxHybridNativeAdActivity) activity).a(this.f18441a.I(), this.f18441a.getNativeAd(), this.f18442b, this.f18443c);
            }
        }

        @Override // com.applovin.impl.p, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if ((activity instanceof MaxHybridNativeAdActivity) && !activity.isChangingConfigurations() && this.f18441a.x().get()) {
                this.f18442b.e().b(this);
            }
        }
    }

    public dd(com.applovin.impl.sdk.j jVar) {
        this.f18437a = jVar;
    }

    public void a(ie ieVar, Activity activity, MaxAdapterListener maxAdapterListener) {
        yp.b();
        if (activity == null) {
            activity = this.f18437a.e().b();
        }
        if (ieVar.getNativeAd() != null) {
            this.f18437a.J();
            if (com.applovin.impl.sdk.n.a()) {
                this.f18437a.J().a("MaxHybridAdService", "Showing fullscreen native ad...");
            }
            this.f18437a.e().a(new b(ieVar, this.f18437a, maxAdapterListener));
            activity.startActivity(new Intent(activity, (Class<?>) MaxHybridNativeAdActivity.class));
            return;
        }
        if (ieVar.z() != null) {
            this.f18437a.J();
            if (com.applovin.impl.sdk.n.a()) {
                this.f18437a.J().a("MaxHybridAdService", "Showing fullscreen MREC ad...");
            }
            this.f18437a.e().a(new a(ieVar, this.f18437a, maxAdapterListener));
            activity.startActivity(new Intent(activity, (Class<?>) MaxHybridMRecAdActivity.class));
            return;
        }
        if (maxAdapterListener instanceof MaxInterstitialAdapterListener) {
            ((MaxInterstitialAdapterListener) maxAdapterListener).onInterstitialAdDisplayFailed(MaxAdapterError.AD_DISPLAY_FAILED);
        } else {
            if (!(maxAdapterListener instanceof MaxAppOpenAdapterListener)) {
                throw new IllegalStateException("Failed to display hybrid ad: neither native nor adview ad");
            }
            ((MaxAppOpenAdapterListener) maxAdapterListener).onAppOpenAdDisplayFailed(MaxAdapterError.AD_DISPLAY_FAILED);
        }
    }
}
