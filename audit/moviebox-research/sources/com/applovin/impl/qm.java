package com.applovin.impl;

import com.applovin.sdk.AppLovinAdLoadListener;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class qm extends om {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final w f21955k;

    public qm(w wVar, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.j jVar) {
        super(h0.a("adtoken_zone"), appLovinAdLoadListener, "TaskFetchTokenAd", jVar);
        this.f21955k = wVar;
    }

    @Override // com.applovin.impl.hm
    public Map h() {
        HashMap map = new HashMap(2);
        map.put("adtoken", this.f21955k.b());
        map.put("adtoken_prefix", this.f21955k.d());
        return map;
    }
}
