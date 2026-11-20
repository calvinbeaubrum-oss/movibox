package com.applovin.impl;

import com.amazon.device.ads.DTBAdSize;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxAdFormat;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f21626a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DTBAdSize f21627b;

    /* JADX INFO: compiled from: source.java */
    public enum a {
        VIDEO,
        DISPLAY,
        INTERSTITIAL
    }

    public p0(String str, JSONObject jSONObject, MaxAdFormat maxAdFormat) {
        this.f21626a = str;
        this.f21627b = a(JsonUtils.getInt(jSONObject, "type", a(maxAdFormat).ordinal()), maxAdFormat, str);
    }

    private DTBAdSize a(int i11, MaxAdFormat maxAdFormat, String str) {
        try {
            if (a.VIDEO.ordinal() == i11) {
                return new DTBAdSize.DTBVideo(320, 480, str);
            }
            if (a.DISPLAY.ordinal() == i11) {
                return new DTBAdSize(maxAdFormat.getSize().getWidth(), maxAdFormat.getSize().getHeight(), str);
            }
            if (a.INTERSTITIAL.ordinal() == i11) {
                return new DTBAdSize.DTBInterstitialAdSize(str);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private a a(MaxAdFormat maxAdFormat) {
        return maxAdFormat.isAdViewAd() ? a.DISPLAY : a.INTERSTITIAL;
    }

    public DTBAdSize a() {
        return this.f21627b;
    }
}
