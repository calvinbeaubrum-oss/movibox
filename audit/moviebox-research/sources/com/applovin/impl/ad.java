package com.applovin.impl;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.applovin.sdk.AppLovinSdkUtils;
import com.google.android.material.card.MaterialCardView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class ad extends FrameLayout implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f17503a;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(ad adVar);
    }

    public ad(cd cdVar, Context context) {
        super(context);
        setOnClickListener(this);
        com.applovin.impl.adview.i iVar = new com.applovin.impl.adview.i(context);
        int iDpToPx = AppLovinSdkUtils.dpToPx(context, cdVar.e());
        iVar.setLayoutParams(new FrameLayout.LayoutParams(iDpToPx, iDpToPx, 17));
        iVar.a(iDpToPx);
        addView(iVar);
        int iDpToPx2 = AppLovinSdkUtils.dpToPx(context, cdVar.e() + (cdVar.c() * 2));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iDpToPx2, iDpToPx2, MaterialCardView.CHECKED_ICON_GRAVITY_TOP_END);
        int iDpToPx3 = AppLovinSdkUtils.dpToPx(context, cdVar.f());
        int iDpToPx4 = AppLovinSdkUtils.dpToPx(context, cdVar.d());
        layoutParams.setMargins(iDpToPx4, iDpToPx3, iDpToPx4, 0);
        setLayoutParams(layoutParams);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f17503a.a(this);
    }

    public void setListener(a aVar) {
        this.f17503a = aVar;
    }
}
