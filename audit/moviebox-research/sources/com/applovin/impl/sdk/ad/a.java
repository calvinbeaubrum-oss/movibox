package com.applovin.impl.sdk.ad;

import android.net.Uri;
import com.applovin.impl.ng;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.tl;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends b {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final String f22411l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final String f22412m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final String f22413n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final ng f22414o;

    public a(JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.sdk.j jVar) {
        super(jSONObject, jSONObject2, jVar);
        this.f22411l = h1();
        this.f22412m = m1();
        this.f22413n = l1();
        this.f22414o = new ng(this);
    }

    private String l1() {
        return getStringFromAdObject("stream_url", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(tl tlVar) {
        tlVar.b("html", this.f22411l);
        tlVar.b("stream_url", this.f22413n);
    }

    @Override // com.applovin.impl.sdk.ad.b
    public boolean H0() {
        return containsKeyForAdObject("stream_url");
    }

    @Override // com.applovin.impl.sdk.ad.b
    public void K0() {
        tl tlVar = this.synchronizedAdObject;
        if (tlVar != null) {
            tlVar.a(new androidx.core.util.a() { // from class: com.applovin.impl.sdk.ad.e
                @Override // androidx.core.util.a
                public final void accept(Object obj) {
                    this.f22451a.w((tl) obj);
                }
            });
            return;
        }
        synchronized (this.adObjectLock) {
            JsonUtils.putString(this.adObject, "html", this.f22411l);
            JsonUtils.putString(this.adObject, "stream_url", this.f22413n);
        }
    }

    @Override // com.applovin.impl.sdk.ad.b
    public String P() {
        return this.f22412m;
    }

    public void b(String str) {
        tl tlVar = this.synchronizedAdObject;
        if (tlVar != null) {
            tlVar.b("html", str);
            return;
        }
        synchronized (this.adObjectLock) {
            JsonUtils.putString(this.adObject, "html", str);
        }
    }

    public void d(Uri uri) {
        tl tlVar = this.synchronizedAdObject;
        if (tlVar != null) {
            tlVar.b("video", uri.toString());
            return;
        }
        synchronized (this.adObjectLock) {
            JsonUtils.putString(this.adObject, "video", uri.toString());
        }
    }

    public com.applovin.impl.adview.e.a g1() {
        return a(getIntFromAdObject("expandable_style", com.applovin.impl.adview.e.a.INVISIBLE.b()));
    }

    @Override // com.applovin.impl.sdk.ad.b, com.applovin.impl.sdk.AppLovinAdBase, com.applovin.impl.lg
    public ng getAdEventTracker() {
        return this.f22414o;
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public JSONObject getOriginalFullResponse() {
        JSONObject jSONObjectDeepCopy;
        JSONObject jSONObjectA;
        tl tlVar = this.synchronizedFullResponse;
        if (tlVar != null) {
            jSONObjectA = tlVar.a();
        } else {
            synchronized (this.fullResponseLock) {
                jSONObjectDeepCopy = JsonUtils.deepCopy(this.fullResponse);
            }
            jSONObjectA = jSONObjectDeepCopy;
        }
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObjectA, com.mbridge.msdk.foundation.entity.b.JSON_KEY_ADS, new JSONArray());
        if (jSONArray.length() > 0) {
            JSONObject jSONObject = JsonUtils.getJSONObject(jSONArray, 0, new JSONObject());
            JsonUtils.putString(jSONObject, "html", this.f22411l);
            JsonUtils.putString(jSONObject, "video", this.f22412m);
            JsonUtils.putString(jSONObject, "stream_url", this.f22413n);
        }
        return jSONObjectA;
    }

    public String h1() {
        return getStringFromAdObject("html", "");
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public boolean hasVideoUrl() {
        return s0() != null;
    }

    public String i1() {
        return getStringFromAdObject(com.mbridge.msdk.foundation.entity.b.JSON_KEY_HTML_URL, "");
    }

    @Override // com.applovin.impl.sdk.ad.b, com.applovin.impl.sdk.AppLovinAdBase, com.applovin.impl.lg
    public boolean isOpenMeasurementEnabled() {
        if (this.sdk.W().e()) {
            return true;
        }
        return getBooleanFromAdObject("omsdk_enabled", Boolean.FALSE);
    }

    @Override // com.applovin.impl.sdk.ad.b
    public Uri j() {
        String stringFromAdObject = getStringFromAdObject(CampaignEx.JSON_KEY_CLICK_URL, "");
        if (StringUtils.isValidString(stringFromAdObject)) {
            return Uri.parse(stringFromAdObject);
        }
        return null;
    }

    @Override // com.applovin.impl.sdk.ad.b
    public Uri j0() {
        String stringFromAdObject = getStringFromAdObject("video_click_url", "");
        return StringUtils.isValidString(stringFromAdObject) ? Uri.parse(stringFromAdObject) : j();
    }

    public float j1() {
        return getFloatFromAdObject("mraid_close_delay_graphic", 0.0f);
    }

    public String k1() {
        return this.f22413n;
    }

    public String m1() {
        return getStringFromAdObject("video", "");
    }

    public boolean n1() {
        if (this.adObject.has("close_button_expandable_hidden")) {
            return getBooleanFromAdObject("close_button_expandable_hidden", Boolean.FALSE);
        }
        return true;
    }

    public void o1() {
        tl tlVar = this.synchronizedAdObject;
        if (tlVar != null) {
            tlVar.c("stream_url");
            return;
        }
        synchronized (this.adObjectLock) {
            this.adObject.remove("stream_url");
        }
    }

    public boolean p1() {
        return getBooleanFromAdObject("should_cache_html_url_contents", Boolean.FALSE);
    }

    public boolean q1() {
        return getBooleanFromAdObject("should_respect_whitelist_when_retrieving_html_from_url", Boolean.FALSE);
    }

    @Override // com.applovin.impl.sdk.ad.b
    public Uri s0() {
        String strL1 = l1();
        if (StringUtils.isValidString(strL1)) {
            return Uri.parse(strL1);
        }
        String strM1 = m1();
        if (StringUtils.isValidString(strM1)) {
            return Uri.parse(strM1);
        }
        return null;
    }
}
