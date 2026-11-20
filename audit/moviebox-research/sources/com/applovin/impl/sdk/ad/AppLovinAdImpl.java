package com.applovin.impl.sdk.ad;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.applovin.impl.h0;
import com.applovin.impl.j8;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sj;
import com.applovin.impl.tl;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AppLovinAdImpl extends AppLovinAdBase implements AppLovinAd, j8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Bundle f22407a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private h0 f22408b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f22409c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private c f22410d;

    public AppLovinAdImpl(JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.sdk.j jVar) {
        super(jSONObject, jSONObject2, jVar);
        this.f22407a = new Bundle();
    }

    private long a() {
        return getLongFromAdObject("ad_expiration_ms", ((Long) this.sdk.a(sj.f23030p1)).longValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String a(String str, String str2, tl tlVar) {
        return JsonUtils.getString(tlVar.a("ad_values", new JSONObject()), str, str2);
    }

    public boolean canExpire() {
        return getSize() == AppLovinAdSize.INTERSTITIAL && a() > 0;
    }

    public boolean equals(Object obj) {
        AppLovinAd appLovinAdB;
        if ((obj instanceof c) && (appLovinAdB = ((c) obj).b()) != null) {
            obj = appLovinAdB;
        }
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && getAdIdNumber() == ((AppLovinAdImpl) obj).getAdIdNumber();
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase, com.applovin.sdk.AppLovinAd
    public long getAdIdNumber() {
        return getLongFromAdObject("ad_id", -1L);
    }

    @Override // com.applovin.sdk.AppLovinAd
    public String getAdValue(String str) {
        return getAdValue(str, null);
    }

    @Override // com.applovin.sdk.AppLovinAd
    public String getAdValue(final String str, final String str2) {
        tl tlVar = this.synchronizedAdObject;
        return tlVar != null ? (String) tlVar.a(new j1.a() { // from class: com.applovin.impl.sdk.ad.d
            @Override // j1.a
            public final Object apply(Object obj) {
                return AppLovinAdImpl.a(str, str2, (tl) obj);
            }
        }) : JsonUtils.getString(getJsonObjectFromAdObject("ad_values", new JSONObject()), str, str2);
    }

    public h0 getAdZone() {
        h0 h0Var = this.f22408b;
        if (h0Var != null) {
            if (h0Var.f() != null && this.f22408b.g() != null) {
                return this.f22408b;
            }
            if (getSize() == null && getType() == null) {
                return this.f22408b;
            }
        }
        h0 h0VarA = h0.a(getSize(), getType(), getStringFromFullResponse("zone_id", null), getBooleanFromFullResponse("is_bidding", false), getBooleanFromFullResponse("is_direct_sold", false));
        this.f22408b = h0VarA;
        return h0VarA;
    }

    public c getDummyAd() {
        return this.f22410d;
    }

    public Bundle getMAXAdValues() {
        return this.f22407a;
    }

    public abstract JSONObject getOriginalFullResponse();

    public String getRawFullResponse() {
        String string;
        tl tlVar = this.synchronizedFullResponse;
        if (tlVar != null) {
            return tlVar.toString();
        }
        synchronized (this.fullResponseLock) {
            string = this.fullResponse.toString();
        }
        return string;
    }

    @Override // com.applovin.sdk.AppLovinAd
    public AppLovinAdSize getSize() {
        return AppLovinAdSize.fromString(getStringFromFullResponse("ad_size", null));
    }

    @Override // com.applovin.impl.j8
    public long getTimeToLiveMillis() {
        if (!canExpire()) {
            return Long.MAX_VALUE;
        }
        return a() - (System.currentTimeMillis() - getCreatedAtMillis());
    }

    @Override // com.applovin.sdk.AppLovinAd
    public AppLovinAdType getType() {
        return AppLovinAdType.fromString(getStringFromFullResponse("ad_type", null));
    }

    @Override // com.applovin.sdk.AppLovinAd
    public String getZoneId() {
        if (getAdZone().i()) {
            return null;
        }
        return getStringFromFullResponse("zone_id", null);
    }

    public boolean hasShown() {
        return getBooleanFromAdObject("shown", Boolean.FALSE);
    }

    public boolean hasVideoUrl() {
        this.sdk.J();
        if (!com.applovin.impl.sdk.n.a()) {
            return false;
        }
        this.sdk.J().b("AppLovinAd", "Attempting to invoke hasVideoUrl() from base ad class");
        return false;
    }

    public int hashCode() {
        return (int) getAdIdNumber();
    }

    public boolean isExpired() {
        return this.f22409c;
    }

    @Override // com.applovin.sdk.AppLovinAd
    public boolean isVideoAd() {
        return this.adObject.has("is_video_ad") ? getBooleanFromAdObject("is_video_ad", Boolean.FALSE) : hasVideoUrl();
    }

    public void setDummyAd(c cVar) {
        this.f22410d = cVar;
    }

    @Override // com.applovin.impl.j8
    public void setExpired() {
        this.f22409c = true;
    }

    public void setHasShown(boolean z11) {
        try {
            tl tlVar = this.synchronizedAdObject;
            if (tlVar != null) {
                tlVar.a("shown", (Object) Boolean.valueOf(z11));
                return;
            }
            synchronized (this.adObjectLock) {
                this.adObject.put("shown", z11);
            }
        } catch (Throwable unused) {
        }
    }

    public void setMaxAdValue(String str, Object obj) {
        BundleUtils.put(str, obj, this.f22407a);
    }

    public boolean shouldCancelHtmlCachingIfShown() {
        return getBooleanFromAdObject("chcis", Boolean.FALSE);
    }

    @NonNull
    public String toString() {
        return "AppLovinAd{adIdNumber=" + getAdIdNumber() + ", zoneId=\"" + getZoneId() + "\"}";
    }
}
