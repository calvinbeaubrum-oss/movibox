package com.applovin.impl;

import android.webkit.WebView;
import com.iab.omid.library.applovin.adsession.AdSessionConfiguration;
import com.iab.omid.library.applovin.adsession.AdSessionContext;
import com.iab.omid.library.applovin.adsession.CreativeType;
import com.iab.omid.library.applovin.adsession.ImpressionType;
import com.iab.omid.library.applovin.adsession.Owner;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class ng extends mg {
    public ng(com.applovin.impl.sdk.ad.a aVar) {
        super(aVar);
    }

    @Override // com.applovin.impl.mg
    public AdSessionConfiguration a() {
        try {
            return AdSessionConfiguration.createAdSessionConfiguration(CreativeType.HTML_DISPLAY, ImpressionType.LOADED, Owner.NATIVE, Owner.NONE, false);
        } catch (Throwable th2) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f21158c.a(this.f21159d, "Failed to create ad session configuration", th2);
            }
            return null;
        }
    }

    @Override // com.applovin.impl.mg
    public AdSessionContext a(WebView webView) {
        try {
            return this.f21156a.getOpenMeasurementVerificationScriptResources().size() > 0 ? AdSessionContext.createNativeAdSessionContext(this.f21157b.W().b(), this.f21157b.W().a(), this.f21156a.getOpenMeasurementVerificationScriptResources(), this.f21156a.getOpenMeasurementContentUrl(), this.f21156a.getOpenMeasurementCustomReferenceData()) : AdSessionContext.createHtmlAdSessionContext(this.f21157b.W().b(), webView, this.f21156a.getOpenMeasurementContentUrl(), this.f21156a.getOpenMeasurementCustomReferenceData());
        } catch (Throwable th2) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f21158c.a(this.f21159d, "Failed to create ad session context", th2);
            }
            return null;
        }
    }
}
