package com.applovin.impl;

import android.app.Activity;
import android.view.ViewGroup;
import com.applovin.adview.AppLovinAdView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class r9 extends o9 {
    public r9(com.applovin.impl.sdk.ad.b bVar, Activity activity, com.applovin.impl.sdk.j jVar) {
        super(bVar, activity, jVar);
    }

    @Override // com.applovin.impl.o9
    public /* bridge */ /* synthetic */ void a(com.applovin.impl.adview.g gVar) {
        super.a(gVar);
    }

    public void a(com.applovin.impl.adview.g gVar, com.applovin.impl.adview.k kVar, AppLovinAdView appLovinAdView, ViewGroup viewGroup) {
        this.f21474d.addView(appLovinAdView);
        if (gVar != null) {
            a(this.f21473c.l(), (this.f21473c.y0() ? 3 : 5) | 48, gVar);
        }
        if (kVar != null) {
            this.f21474d.addView(kVar, this.f21475e);
        }
        if (viewGroup != null) {
            viewGroup.addView(this.f21474d);
        } else {
            this.f21472b.setContentView(this.f21474d);
        }
    }
}
