package com.applovin.impl;

import com.applovin.impl.sdk.nativeAd.AppLovinNativeAdLoadListener;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class nm extends pm {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final w f21373k;

    public nm(w wVar, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener, com.applovin.impl.sdk.j jVar) {
        super(h0.a("adtoken_zone"), "TaskFetchNativeTokenAd", appLovinNativeAdLoadListener, jVar);
        this.f21373k = wVar;
    }

    @Override // com.applovin.impl.hm
    public Map h() {
        HashMap map = new HashMap(2);
        map.put("adtoken", this.f21373k.b());
        map.put("adtoken_prefix", this.f21373k.d());
        return map;
    }
}
