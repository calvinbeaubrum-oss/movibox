package com.applovin.impl;

import android.os.SystemClock;
import android.view.ViewGroup;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.mediation.nativeAds.MaxNativeAd;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class je extends ne implements j8 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final AtomicBoolean f19941v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final AtomicBoolean f19942w;

    public je(int i11, Map map, JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.sdk.j jVar) {
        super(i11, map, jSONObject, jSONObject2, null, jVar);
        this.f19941v = new AtomicBoolean();
        this.f19942w = new AtomicBoolean();
    }

    private je(je jeVar, com.applovin.impl.mediation.g gVar) {
        super(jeVar.K(), jeVar.i(), jeVar.a(), jeVar.g(), gVar, jeVar.f21736a);
        this.f19941v = new AtomicBoolean();
        this.f19942w = new AtomicBoolean();
    }

    private long q0() {
        long jA = a("ad_expiration_ms", -1L);
        return jA < 0 ? b("ad_expiration_ms", ((Long) this.f21736a.a(ve.f23888k7)).longValue()) : jA;
    }

    @Override // com.applovin.impl.ge
    public ge a(com.applovin.impl.mediation.g gVar) {
        return new je(this, gVar);
    }

    public void a(ViewGroup viewGroup) {
        this.f19211o.a(viewGroup);
    }

    public void a(MaxNativeAdView maxNativeAdView) {
        this.f19211o.a(maxNativeAdView);
    }

    @Override // com.applovin.impl.j8
    public long getTimeToLiveMillis() {
        return q0() - (SystemClock.elapsedRealtime() - L());
    }

    public MaxNativeAdView r0() {
        return this.f19211o.f();
    }

    public ViewGroup s0() {
        return this.f19211o.h();
    }

    @Override // com.applovin.impl.j8
    public void setExpired() {
        MaxNativeAd nativeAd = getNativeAd();
        if (nativeAd != null) {
            nativeAd.setExpired();
        }
    }

    public AtomicBoolean t0() {
        return this.f19941v;
    }

    public String u0() {
        return BundleUtils.getString("template", "", l());
    }

    public AtomicBoolean v0() {
        return this.f19942w;
    }

    public boolean w0() {
        return a("inacc", (Boolean) this.f21736a.a(ve.F7)).booleanValue();
    }

    public boolean x0() {
        return this.f19211o == null;
    }
}
