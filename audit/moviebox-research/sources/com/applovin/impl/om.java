package com.applovin.impl;

import com.applovin.impl.sdk.AppLovinError;
import com.applovin.sdk.AppLovinAdLoadListener;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class om extends hm {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final AppLovinAdLoadListener f21582j;

    public om(h0 h0Var, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.j jVar) {
        this(h0Var, appLovinAdLoadListener, "TaskFetchNextAd", jVar);
    }

    public om(h0 h0Var, AppLovinAdLoadListener appLovinAdLoadListener, String str, com.applovin.impl.sdk.j jVar) {
        super(h0Var, str, jVar);
        this.f21582j = appLovinAdLoadListener;
    }

    @Override // com.applovin.impl.hm
    public yl a(JSONObject jSONObject) {
        return new um(jSONObject, this.f19510h, this.f21582j, this.f24689a);
    }

    @Override // com.applovin.impl.hm
    public void a(int i11, String str) {
        super.a(i11, str);
        AppLovinAdLoadListener appLovinAdLoadListener = this.f21582j;
        if (!(appLovinAdLoadListener instanceof rb)) {
            appLovinAdLoadListener.failedToReceiveAd(i11);
        } else {
            ((rb) this.f21582j).failedToReceiveAdV2(new AppLovinError(i11, str));
        }
    }

    @Override // com.applovin.impl.hm
    public String e() {
        return e4.a(this.f24689a);
    }

    @Override // com.applovin.impl.hm
    public String f() {
        return e4.b(this.f24689a);
    }
}
