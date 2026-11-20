package com.applovin.impl;

import com.applovin.impl.sdk.AppLovinError;
import com.applovin.impl.sdk.nativeAd.AppLovinNativeAdLoadListener;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class pm extends hm {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final AppLovinNativeAdLoadListener f21780j;

    public pm(h0 h0Var, String str, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener, com.applovin.impl.sdk.j jVar) {
        super(h0Var, str, jVar);
        this.f21780j = appLovinNativeAdLoadListener;
    }

    @Override // com.applovin.impl.hm
    public yl a(JSONObject jSONObject) {
        return new ym(jSONObject, this.f21780j, this.f24689a);
    }

    @Override // com.applovin.impl.hm
    public void a(int i11, String str) {
        super.a(i11, str);
        this.f21780j.onNativeAdLoadFailed(new AppLovinError(i11, str));
    }

    @Override // com.applovin.impl.hm
    public String e() {
        return e4.d(this.f24689a);
    }

    @Override // com.applovin.impl.hm
    public String f() {
        return e4.e(this.f24689a);
    }
}
