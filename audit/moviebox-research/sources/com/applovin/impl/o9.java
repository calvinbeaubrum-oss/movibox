package com.applovin.impl;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
abstract class o9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final com.applovin.impl.sdk.j f21471a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Activity f21472b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final com.applovin.impl.sdk.ad.b f21473c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final ViewGroup f21474d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final FrameLayout.LayoutParams f21475e;

    public o9(com.applovin.impl.sdk.ad.b bVar, Activity activity, com.applovin.impl.sdk.j jVar) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
        this.f21475e = layoutParams;
        this.f21473c = bVar;
        this.f21471a = jVar;
        this.f21472b = activity;
        FrameLayout frameLayout = new FrameLayout(activity);
        this.f21474d = frameLayout;
        frameLayout.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        frameLayout.setLayoutParams(layoutParams);
    }

    public void a(View view) {
        this.f21474d.removeView(view);
    }

    public void a(com.applovin.impl.adview.g gVar) {
        if (gVar == null || gVar.getParent() != null) {
            return;
        }
        a(this.f21473c.l(), (this.f21473c.y0() ? 3 : 5) | 48, gVar);
    }

    public void a(com.applovin.impl.sdk.ad.b.d dVar, int i11, com.applovin.impl.adview.g gVar) {
        gVar.a(dVar.f22430a, dVar.f22434e, dVar.f22433d, i11);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(gVar.getLayoutParams());
        int i12 = dVar.f22432c;
        layoutParams.setMargins(i12, dVar.f22431b, i12, 0);
        layoutParams.gravity = i11;
        this.f21474d.addView(gVar, layoutParams);
    }
}
