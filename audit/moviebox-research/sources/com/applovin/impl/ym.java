package com.applovin.impl;

import com.applovin.impl.sdk.AppLovinError;
import com.applovin.impl.sdk.nativeAd.AppLovinNativeAdLoadListener;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxAdFormat;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class ym extends yl {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final JSONObject f24695h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AppLovinNativeAdLoadListener f24696i;

    public ym(JSONObject jSONObject, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener, com.applovin.impl.sdk.j jVar) {
        super("TaskProcessNativeAdResponse", jVar);
        this.f24695h = jSONObject;
        this.f24696i = appLovinNativeAdLoadListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        JSONArray jSONArray = JsonUtils.getJSONArray(this.f24695h, com.mbridge.msdk.foundation.entity.b.JSON_KEY_ADS, new JSONArray());
        if (jSONArray.length() > 0) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f24691c.a(this.f24690b, "Processing ad...");
            }
            this.f24689a.j0().a(new com.applovin.impl.sdk.nativeAd.b(JsonUtils.getJSONObject(jSONArray, 0, new JSONObject()), this.f24695h, this.f24696i, this.f24689a));
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f24691c.k(this.f24690b, "No ads were returned from the server");
        }
        yp.a("native_native", MaxAdFormat.NATIVE, this.f24695h, this.f24689a);
        this.f24696i.onNativeAdLoadFailed(AppLovinError.NO_FILL);
    }
}
