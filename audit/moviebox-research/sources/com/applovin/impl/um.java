package com.applovin.impl;

import com.applovin.impl.sdk.AppLovinError;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinErrorCodes;
import com.google.android.gms.ads.AdError;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class um extends yl implements rb {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final JSONObject f23632h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final h0 f23633i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final AppLovinAdLoadListener f23634j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f23635k;

    public um(JSONObject jSONObject, h0 h0Var, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.j jVar) {
        this(jSONObject, h0Var, false, appLovinAdLoadListener, jVar);
    }

    public um(JSONObject jSONObject, h0 h0Var, boolean z11, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.j jVar) {
        super("TaskProcessAdResponse", jVar);
        if (jSONObject == null) {
            throw new IllegalArgumentException("No response specified");
        }
        if (h0Var == null) {
            throw new IllegalArgumentException("No zone specified");
        }
        this.f23632h = jSONObject;
        this.f23633i = h0Var;
        this.f23634j = appLovinAdLoadListener;
        this.f23635k = z11;
    }

    private void a(JSONObject jSONObject) {
        String string = JsonUtils.getString(jSONObject, "type", AdError.UNDEFINED_DOMAIN);
        if ("applovin".equalsIgnoreCase(string)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f24691c.a(this.f24690b, "Starting task for AppLovin ad...");
            }
            this.f24689a.j0().a(new bn(jSONObject, this.f23632h, this, this.f24689a));
            return;
        }
        if ("vast".equalsIgnoreCase(string)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f24691c.a(this.f24690b, "Starting task for VAST ad...");
            }
            this.f24689a.j0().a(zm.a(jSONObject, this.f23632h, this, this.f24689a));
            return;
        }
        if ("js_tag".equalsIgnoreCase(string)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f24691c.a(this.f24690b, "Starting task for JS tag ad...");
            }
            this.f24689a.j0().a(new vm(jSONObject, this.f23632h, this, this.f24689a));
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f24691c.b(this.f24690b, "Unable to process ad of unknown type: " + string);
        }
        failedToReceiveAdV2(new AppLovinError(AppLovinErrorCodes.INVALID_RESPONSE, "Unknown ad type: " + string));
    }

    @Override // com.applovin.sdk.AppLovinAdLoadListener
    public void adReceived(AppLovinAd appLovinAd) {
        AppLovinAdLoadListener appLovinAdLoadListener = this.f23634j;
        if (appLovinAdLoadListener != null) {
            appLovinAdLoadListener.adReceived(appLovinAd);
        }
        if (this.f23635k || !(appLovinAd instanceof com.applovin.impl.sdk.ad.b)) {
            return;
        }
        this.f24689a.E().a(la.f20380i, (com.applovin.impl.sdk.ad.b) appLovinAd);
    }

    @Override // com.applovin.sdk.AppLovinAdLoadListener
    public void failedToReceiveAd(int i11) {
        failedToReceiveAdV2(new AppLovinError(i11, ""));
    }

    @Override // com.applovin.impl.rb
    public void failedToReceiveAdV2(AppLovinError appLovinError) {
        AppLovinAdLoadListener appLovinAdLoadListener = this.f23634j;
        if (appLovinAdLoadListener == null) {
            return;
        }
        if (appLovinAdLoadListener instanceof rb) {
            ((rb) appLovinAdLoadListener).failedToReceiveAdV2(appLovinError);
        } else {
            appLovinAdLoadListener.failedToReceiveAd(appLovinError.getCode());
        }
        if (this.f23635k) {
            return;
        }
        this.f24689a.E().a(la.f20381j, this.f23633i, appLovinError);
    }

    @Override // java.lang.Runnable
    public void run() {
        JSONArray jSONArray = JsonUtils.getJSONArray(this.f23632h, com.mbridge.msdk.foundation.entity.b.JSON_KEY_ADS, new JSONArray());
        if (jSONArray.length() > 0) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f24691c.a(this.f24690b, "Processing ad...");
            }
            a(JsonUtils.getJSONObject(jSONArray, 0, new JSONObject()));
        } else {
            if (com.applovin.impl.sdk.n.a()) {
                this.f24691c.k(this.f24690b, "No ads were returned from the server");
            }
            yp.a(this.f23633i.e(), this.f23633i.d(), this.f23632h, this.f24689a);
            failedToReceiveAdV2(AppLovinError.NO_FILL);
        }
    }
}
