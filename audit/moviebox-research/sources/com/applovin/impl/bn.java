package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.sdk.AppLovinAdLoadListener;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class bn extends yl {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final JSONObject f18008h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final JSONObject f18009i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final AppLovinAdLoadListener f18010j;

    public bn(JSONObject jSONObject, JSONObject jSONObject2, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.j jVar) {
        super("TaskRenderAppLovinAd", jVar);
        this.f18008h = jSONObject;
        this.f18009i = jSONObject2;
        this.f18010j = appLovinAdLoadListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f24691c.a(this.f24690b, "Rendering ad...");
        }
        com.applovin.impl.sdk.ad.a aVar = new com.applovin.impl.sdk.ad.a(this.f18008h, this.f18009i, this.f24689a);
        boolean zBooleanValue = JsonUtils.getBoolean(this.f18008h, "gs_load_immediately", Boolean.FALSE).booleanValue();
        boolean zBooleanValue2 = JsonUtils.getBoolean(this.f18008h, "vs_load_immediately", Boolean.TRUE).booleanValue();
        cm cmVar = new cm(aVar, this.f24689a, this.f18010j);
        cmVar.c(zBooleanValue2);
        cmVar.b(zBooleanValue);
        this.f24689a.j0().a((yl) cmVar, tm.b.CACHING);
    }
}
