package com.applovin.impl;

import android.text.TextUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class h0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Map f19311e = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Object f19312f = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f19313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f19314b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AppLovinAdSize f19315c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AppLovinAdType f19316d;

    private h0(AppLovinAdSize appLovinAdSize, AppLovinAdType appLovinAdType, String str, boolean z11, boolean z12) {
        String lowerCase;
        if (TextUtils.isEmpty(str) && (appLovinAdType == null || appLovinAdSize == null)) {
            throw new IllegalArgumentException("No zone identifier or type or size specified");
        }
        this.f19315c = appLovinAdSize;
        this.f19316d = appLovinAdType;
        if (StringUtils.isValidString(str)) {
            lowerCase = str.trim().toLowerCase(Locale.ENGLISH);
        } else {
            lowerCase = (appLovinAdSize.getLabel() + "_" + appLovinAdType.getLabel()).toLowerCase(Locale.ENGLISH);
        }
        if (z11) {
            lowerCase = lowerCase + "_bidding";
        }
        if (z12) {
            lowerCase = lowerCase + "_direct_sold";
        }
        this.f19314b = lowerCase;
    }

    public static h0 a(AppLovinAdSize appLovinAdSize, AppLovinAdType appLovinAdType) {
        return a(appLovinAdSize, appLovinAdType, null);
    }

    public static h0 a(AppLovinAdSize appLovinAdSize, AppLovinAdType appLovinAdType, String str) {
        return a(appLovinAdSize, appLovinAdType, str, false, false);
    }

    public static h0 a(AppLovinAdSize appLovinAdSize, AppLovinAdType appLovinAdType, String str, boolean z11, boolean z12) {
        h0 h0Var = new h0(appLovinAdSize, appLovinAdType, str, z11, z12);
        synchronized (f19312f) {
            try {
                String str2 = h0Var.f19314b;
                Map map = f19311e;
                if (map.containsKey(str2)) {
                    h0Var = (h0) map.get(str2);
                } else {
                    map.put(str2, h0Var);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return h0Var;
    }

    public static h0 a(String str) {
        return a(null, null, str);
    }

    public static Collection a() {
        LinkedHashSet linkedHashSet = new LinkedHashSet(7);
        Collections.addAll(linkedHashSet, c(), k(), j(), m(), b(), h(), l());
        return Collections.unmodifiableSet(linkedHashSet);
    }

    public static void a(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.has("ad_size") && jSONObject.has("ad_type")) {
            synchronized (f19312f) {
                try {
                    h0 h0Var = (h0) f19311e.get(JsonUtils.getString(jSONObject, "zone_id", ""));
                    if (h0Var != null) {
                        h0Var.f19315c = AppLovinAdSize.fromString(JsonUtils.getString(jSONObject, "ad_size", ""));
                        h0Var.f19316d = AppLovinAdType.fromString(JsonUtils.getString(jSONObject, "ad_type", ""));
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public static h0 b() {
        return a(AppLovinAdSize.INTERSTITIAL, AppLovinAdType.APP_OPEN);
    }

    public static h0 b(String str) {
        return a(AppLovinAdSize.INTERSTITIAL, AppLovinAdType.INCENTIVIZED, str);
    }

    public static h0 c() {
        return a(AppLovinAdSize.BANNER, AppLovinAdType.REGULAR);
    }

    public static h0 h() {
        return a(AppLovinAdSize.INTERSTITIAL, AppLovinAdType.INCENTIVIZED);
    }

    public static h0 j() {
        return a(AppLovinAdSize.LEADER, AppLovinAdType.REGULAR);
    }

    public static h0 k() {
        return a(AppLovinAdSize.MREC, AppLovinAdType.REGULAR);
    }

    public static h0 l() {
        return a(AppLovinAdSize.NATIVE, AppLovinAdType.NATIVE);
    }

    public static h0 m() {
        return a(AppLovinAdSize.INTERSTITIAL, AppLovinAdType.REGULAR);
    }

    public MaxAdFormat d() {
        AppLovinAdSize appLovinAdSizeF = f();
        if (appLovinAdSizeF == AppLovinAdSize.BANNER) {
            return MaxAdFormat.BANNER;
        }
        if (appLovinAdSizeF == AppLovinAdSize.LEADER) {
            return MaxAdFormat.LEADER;
        }
        if (appLovinAdSizeF == AppLovinAdSize.MREC) {
            return MaxAdFormat.MREC;
        }
        if (appLovinAdSizeF != AppLovinAdSize.INTERSTITIAL) {
            if (appLovinAdSizeF == AppLovinAdSize.NATIVE) {
                return MaxAdFormat.NATIVE;
            }
            return null;
        }
        if (g() == AppLovinAdType.REGULAR) {
            return MaxAdFormat.INTERSTITIAL;
        }
        if (g() == AppLovinAdType.APP_OPEN) {
            return MaxAdFormat.APP_OPEN;
        }
        if (g() == AppLovinAdType.INCENTIVIZED) {
            return MaxAdFormat.REWARDED;
        }
        if (g() == AppLovinAdType.AUTO_INCENTIVIZED) {
            return MaxAdFormat.REWARDED_INTERSTITIAL;
        }
        return null;
    }

    public String e() {
        return this.f19314b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h0.class != obj.getClass()) {
            return false;
        }
        return this.f19314b.equalsIgnoreCase(((h0) obj).f19314b);
    }

    public AppLovinAdSize f() {
        if (this.f19315c == null && JsonUtils.valueExists(this.f19313a, "ad_size")) {
            this.f19315c = AppLovinAdSize.fromString(JsonUtils.getString(this.f19313a, "ad_size", null));
        }
        return this.f19315c;
    }

    public AppLovinAdType g() {
        if (this.f19316d == null && JsonUtils.valueExists(this.f19313a, "ad_type")) {
            this.f19316d = AppLovinAdType.fromString(JsonUtils.getString(this.f19313a, "ad_type", null));
        }
        return this.f19316d;
    }

    public int hashCode() {
        return this.f19314b.hashCode();
    }

    public boolean i() {
        return a().contains(this);
    }

    public String toString() {
        return "AdZone{id=" + this.f19314b + ", zoneObject=" + this.f19313a + '}';
    }
}
