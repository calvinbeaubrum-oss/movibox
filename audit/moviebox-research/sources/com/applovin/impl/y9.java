package com.applovin.impl;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.applovin.adview.AppLovinAdView;
import com.applovin.sdk.AppLovinSdkUtils;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class y9 extends o9 {
    public y9(com.applovin.impl.sdk.ad.b bVar, Activity activity, com.applovin.impl.sdk.j jVar) {
        super(bVar, activity, jVar);
    }

    public void a(ImageView imageView, com.applovin.impl.adview.g gVar, com.applovin.impl.adview.g gVar2, o oVar, com.applovin.impl.adview.k kVar, AppLovinAdView appLovinAdView, ViewGroup viewGroup) {
        this.f21474d.addView(appLovinAdView);
        if (gVar != null) {
            a(this.f21473c.l(), (this.f21473c.F0() ? 3 : 5) | 48, gVar);
        }
        if (gVar2 != null) {
            a(this.f21473c.l(), (this.f21473c.y0() ? 3 : 5) | 48, gVar2);
        }
        if (imageView != null) {
            int iDpToPx = AppLovinSdkUtils.dpToPx(this.f21472b, ((Integer) this.f21471a.a(sj.A2)).intValue());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iDpToPx, iDpToPx, ((Integer) this.f21471a.a(sj.C2)).intValue());
            int iDpToPx2 = AppLovinSdkUtils.dpToPx(this.f21472b, ((Integer) this.f21471a.a(sj.B2)).intValue());
            layoutParams.setMargins(iDpToPx2, iDpToPx2, iDpToPx2, iDpToPx2);
            this.f21474d.addView(imageView, layoutParams);
        }
        if (oVar != null) {
            this.f21474d.addView(oVar, this.f21475e);
        }
        if (kVar != null) {
            this.f21474d.addView(kVar, new ViewGroup.LayoutParams(-1, -1));
        }
        if (viewGroup != null) {
            viewGroup.addView(this.f21474d);
        } else {
            this.f21472b.setContentView(this.f21474d);
        }
    }

    @Override // com.applovin.impl.o9
    public /* bridge */ /* synthetic */ void a(com.applovin.impl.adview.g gVar) {
        super.a(gVar);
    }
}
