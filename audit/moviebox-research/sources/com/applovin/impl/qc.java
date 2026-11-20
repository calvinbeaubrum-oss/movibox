package com.applovin.impl;

import android.os.Bundle;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.sdk.utils.StringUtils;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class qc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final StringBuilder f21928a = new StringBuilder();

    public qc a() {
        this.f21928a.append("\n========================================");
        return this;
    }

    public qc a(Bundle bundle) {
        if (bundle == null) {
            return this;
        }
        for (String str : bundle.keySet()) {
            a(str, bundle.get(str));
        }
        return this;
    }

    public qc a(AppLovinAdView appLovinAdView) {
        return a("Size", appLovinAdView.getSize().getWidth() + "x" + appLovinAdView.getSize().getHeight()).a("Alpha", Float.valueOf(appLovinAdView.getAlpha())).a("Visibility", zq.a(appLovinAdView.getVisibility()));
    }

    public qc a(ge geVar) {
        return a("Network", geVar.c()).a("Adapter Version", geVar.A()).a("Format", geVar.getFormat().getLabel()).a("Ad Unit ID", geVar.getAdUnitId()).a("Placement", geVar.getPlacement()).a("Network Placement", geVar.V()).a("Serve ID", geVar.T()).a("Creative ID", StringUtils.isValidString(geVar.getCreativeId()) ? geVar.getCreativeId() : "None").a("Ad Review Creative ID", StringUtils.isValidString(geVar.getAdReviewCreativeId()) ? geVar.getAdReviewCreativeId() : "None").a("Ad Domain", StringUtils.isValidString(geVar.w()) ? geVar.w() : "None").a("DSP Name", StringUtils.isValidString(geVar.getDspName()) ? geVar.getDspName() : "None").a("DSP ID", StringUtils.isValidString(geVar.getDspId()) ? geVar.getDspId() : "None").a("Server Parameters", geVar.l());
    }

    public qc a(com.applovin.impl.sdk.ad.b bVar) {
        boolean z11 = bVar instanceof aq;
        a("Format", bVar.getAdZone().d() != null ? bVar.getAdZone().d().getLabel() : null).a("Ad ID", Long.valueOf(bVar.getAdIdNumber())).a("Zone ID", bVar.getAdZone().e()).a("Ad Class", z11 ? "VastAd" : "AdServerAd");
        String dspName = bVar.getDspName();
        if (StringUtils.isValidString(dspName)) {
            a("DSP Name", dspName);
        }
        if (z11) {
            a("VAST DSP", ((aq) bVar).p1());
        }
        return this;
    }

    public qc a(com.applovin.impl.sdk.j jVar) {
        return a("Muted", Boolean.valueOf(jVar.g0().isMuted()));
    }

    public qc a(String str) {
        StringBuilder sb2 = this.f21928a;
        sb2.append("\n");
        sb2.append(str);
        return this;
    }

    public qc a(String str, Object obj) {
        return a(str, obj, "");
    }

    public qc a(String str, Object obj, String str2) {
        StringBuilder sb2 = this.f21928a;
        sb2.append("\n");
        sb2.append(str);
        sb2.append(": ");
        sb2.append(obj);
        sb2.append(str2);
        return this;
    }

    public qc b(com.applovin.impl.sdk.ad.b bVar) {
        a("Target", bVar.d0()).a("close_style", bVar.n()).a("close_delay_graphic", Long.valueOf(bVar.p()), "s");
        if (bVar instanceof com.applovin.impl.sdk.ad.a) {
            com.applovin.impl.sdk.ad.a aVar = (com.applovin.impl.sdk.ad.a) bVar;
            a("HTML", aVar.h1().substring(0, Math.min(aVar.h1().length(), 64)));
        }
        if (bVar.hasVideoUrl()) {
            a("close_delay", Long.valueOf(bVar.k0()), "s").a("skip_style", bVar.b0()).a("Streaming", Boolean.valueOf(bVar.H0())).a("Video Location", bVar.P()).a("video_button_properties", bVar.i0());
        }
        return this;
    }

    public qc b(String str) {
        this.f21928a.append(str);
        return this;
    }

    public String toString() {
        return this.f21928a.toString();
    }
}
