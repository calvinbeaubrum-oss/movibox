package com.applovin.impl;

import android.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.mediation.adapter.listeners.MaxAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxAppOpenAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class bd extends Activity implements ad.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.applovin.impl.sdk.j f17913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected ad f17914b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected cd f17915c = new cd(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private MaxAdapterListener f17916d;

    private void a(String str) {
        MaxAdapterError maxAdapterError = new MaxAdapterError(MaxAdapterError.ERROR_CODE_AD_DISPLAY_FAILED, "Null hybrid ad view (" + str + ")");
        MaxAdapterListener maxAdapterListener = this.f17916d;
        if (maxAdapterListener instanceof MaxInterstitialAdapterListener) {
            ((MaxInterstitialAdapterListener) maxAdapterListener).onInterstitialAdDisplayFailed(maxAdapterError);
        } else {
            if (!(maxAdapterListener instanceof MaxAppOpenAdapterListener)) {
                throw new IllegalStateException("Failed to fire display failed callback (" + this.f17916d + "): neither interstitial nor app open ad");
            }
            ((MaxAppOpenAdapterListener) maxAdapterListener).onAppOpenAdDisplayFailed(maxAdapterError);
        }
        finish();
    }

    public void a(View view, String str) {
        if (view == null) {
            a(str);
            return;
        }
        ((ViewGroup) findViewById(R.id.content)).addView(view);
        this.f17914b.bringToFront();
        MaxAdapterListener maxAdapterListener = this.f17916d;
        if (maxAdapterListener instanceof MaxInterstitialAdapterListener) {
            ((MaxInterstitialAdapterListener) maxAdapterListener).onInterstitialAdDisplayed();
            return;
        }
        if (maxAdapterListener instanceof MaxAppOpenAdapterListener) {
            ((MaxAppOpenAdapterListener) maxAdapterListener).onAppOpenAdDisplayed();
            return;
        }
        throw new IllegalStateException("Failed to fire display callback (" + this.f17916d + "): neither interstitial nor app open ad");
    }

    @Override // com.applovin.impl.ad.a
    public void a(ad adVar) {
        if (isFinishing()) {
            return;
        }
        finish();
    }

    public void a(cd cdVar, com.applovin.impl.sdk.j jVar, MaxAdapterListener maxAdapterListener) {
        this.f17913a = jVar;
        this.f17915c = cdVar;
        this.f17916d = maxAdapterListener;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        getWindow().addFlags(16777216);
        getWindow().addFlags(128);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.content);
        viewGroup.setBackgroundColor(this.f17915c.a());
        com.applovin.impl.sdk.j jVar = this.f17913a;
        r.a(jVar != null ? ((Boolean) jVar.a(sj.J2)).booleanValue() : true, this);
        ad adVar = new ad(this.f17915c, this);
        this.f17914b = adVar;
        adVar.setListener(this);
        this.f17914b.setVisibility(4);
        viewGroup.addView(this.f17914b);
        zq.a(this.f17914b, this.f17915c.b());
    }

    @Override // android.app.Activity
    public void onDestroy() {
        MaxAdapterListener maxAdapterListener = this.f17916d;
        if (maxAdapterListener != null) {
            if (maxAdapterListener instanceof MaxInterstitialAdapterListener) {
                ((MaxInterstitialAdapterListener) maxAdapterListener).onInterstitialAdHidden();
            } else {
                if (!(maxAdapterListener instanceof MaxAppOpenAdapterListener)) {
                    throw new IllegalStateException("Failed to fire hidden callback (" + this.f17916d + "): neither interstitial nor app open ad");
                }
                ((MaxAppOpenAdapterListener) maxAdapterListener).onAppOpenAdHidden();
            }
        }
        super.onDestroy();
    }
}
