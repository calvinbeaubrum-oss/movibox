package com.applovin.impl.mediation.ads;

import android.view.ViewGroup;
import com.applovin.impl.ar;
import com.applovin.impl.br;
import com.applovin.impl.je;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class b implements br.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f20809a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final je f20810b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final br f20811c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ar f20812d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final a.InterfaceC0188a f20813e;

    public b(je jeVar, ViewGroup viewGroup, a.InterfaceC0188a interfaceC0188a, com.applovin.impl.sdk.j jVar) {
        this.f20809a = jVar;
        this.f20810b = jeVar;
        this.f20813e = interfaceC0188a;
        this.f20812d = new ar(viewGroup, jVar);
        br brVar = new br(viewGroup, jVar, this);
        this.f20811c = brVar;
        brVar.a(jeVar);
        jVar.J();
        if (com.applovin.impl.sdk.n.a()) {
            jVar.J().a("MaxNativeAdView", "Created new MaxNativeAdView (" + this + ")");
        }
    }

    private void a(long j11) {
        if (this.f20810b.v0().compareAndSet(false, true)) {
            this.f20809a.J();
            if (com.applovin.impl.sdk.n.a()) {
                this.f20809a.J().a("MaxNativeAdView", "Scheduling viewability impression for ad...");
            }
            this.f20809a.Q().processViewabilityAdImpressionPostback(this.f20810b, j11, this.f20813e);
        }
    }

    public void a() {
        this.f20811c.b();
    }

    public je b() {
        return this.f20810b;
    }

    public void c() {
        this.f20809a.J();
        if (com.applovin.impl.sdk.n.a()) {
            this.f20809a.J().a("MaxNativeAdView", "Handling view attached to window");
        }
        if (this.f20810b.t0().compareAndSet(false, true)) {
            this.f20809a.J();
            if (com.applovin.impl.sdk.n.a()) {
                this.f20809a.J().a("MaxNativeAdView", "Scheduling impression for ad manually...");
            }
            if (this.f20810b.getNativeAd().isExpired()) {
                com.applovin.impl.sdk.n.h("MaxNativeAdView", "Attempting to display an expired native ad. Check if an ad is expired before displaying using `MaxAd.getNativeAd().isExpired()`");
            } else {
                this.f20809a.f().a(this.f20810b);
            }
            this.f20809a.Q().processRawAdImpression(this.f20810b, this.f20813e);
        }
    }

    @Override // com.applovin.impl.br.a
    public void onLogVisibilityImpression() {
        a(this.f20812d.a(this.f20810b));
    }
}
