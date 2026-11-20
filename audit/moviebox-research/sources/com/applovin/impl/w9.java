package com.applovin.impl;

import android.app.Activity;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.applovin.adview.AppLovinAdView;
import com.applovin.sdk.AppLovinSdkUtils;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class w9 extends o9 {
    public w9(com.applovin.impl.sdk.ad.b bVar, Activity activity, com.applovin.impl.sdk.j jVar) {
        super(bVar, activity, jVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean a(View view, MotionEvent motionEvent) {
        return true;
    }

    @Override // com.applovin.impl.o9
    public /* bridge */ /* synthetic */ void a(View view) {
        super.a(view);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x009d  */
    /* JADX WARN: Code duplicated, block: B:20:0x010c  */
    /* JADX WARN: Code duplicated, block: B:23:0x012c  */
    /* JADX WARN: Code duplicated, block: B:25:0x0142  */
    /* JADX WARN: Code duplicated, block: B:27:0x014a  */
    /* JADX WARN: Code duplicated, block: B:28:0x014e  */
    /* JADX WARN: Code duplicated, block: B:31:0x015d  */
    /* JADX WARN: Code duplicated, block: B:33:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:35:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:37:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:40:0x0214  */
    /* JADX WARN: Code duplicated, block: B:42:0x021e  */
    /* JADX WARN: Code duplicated, block: B:45:0x0261  */
    /* JADX WARN: Code duplicated, block: B:48:0x026c  */
    /* JADX WARN: Code duplicated, block: B:49:0x0272  */
    public void a(ImageView imageView, com.applovin.impl.adview.g gVar, final com.applovin.impl.adview.l lVar, o oVar, ProgressBar progressBar, h3 h3Var, View view, AppLovinAdView appLovinAdView, com.applovin.impl.adview.k kVar, ImageView imageView2, ViewGroup viewGroup) {
        FrameLayout.LayoutParams layoutParams;
        aq aqVar;
        int i11;
        int i12;
        qq qqVarI0;
        if (this.f21473c.p0() == com.applovin.impl.sdk.ad.b.e.TOP) {
            layoutParams = new FrameLayout.LayoutParams(-1, -2, 48);
        } else {
            if (this.f21473c.p0() != com.applovin.impl.sdk.ad.b.e.BOTTOM) {
                if (this.f21473c.p0() == com.applovin.impl.sdk.ad.b.e.LEFT) {
                    layoutParams = new FrameLayout.LayoutParams(-2, -1, 3);
                } else {
                    layoutParams = this.f21473c.p0() == com.applovin.impl.sdk.ad.b.e.RIGHT ? new FrameLayout.LayoutParams(-2, -1, 5) : this.f21475e;
                }
                appLovinAdView.setLayoutParams(this.f21475e);
                this.f21474d.addView(appLovinAdView);
                View view2 = new View(this.f21472b);
                view2.setLayoutParams(this.f21475e);
                view2.setBackgroundColor(Color.argb(254, 0, 0, 0));
                view2.setOnTouchListener(new View.OnTouchListener() { // from class: com.applovin.impl.z70
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view3, MotionEvent motionEvent) {
                        return w9.a(view3, motionEvent);
                    }
                });
                this.f21474d.addView(view2);
                view.setLayoutParams(layoutParams);
                this.f21474d.addView(view);
                if (lVar != null) {
                    qqVarI0 = this.f21473c.i0();
                    LinearLayout linearLayout = new LinearLayout(this.f21472b);
                    linearLayout.setOrientation(1);
                    linearLayout.setWeightSum(100.0f);
                    linearLayout.setGravity(qqVarI0.e());
                    ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
                    LinearLayout linearLayout2 = new LinearLayout(this.f21472b);
                    linearLayout2.setOrientation(0);
                    linearLayout2.setWeightSum(100.0f);
                    linearLayout2.setGravity(qqVarI0.e());
                    ViewGroup.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, 0, qqVarI0.f());
                    LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, -1, qqVarI0.i());
                    int iDpToPx = AppLovinSdkUtils.dpToPx(this.f21472b, qqVarI0.g());
                    layoutParams4.setMargins(iDpToPx, iDpToPx, iDpToPx, iDpToPx);
                    linearLayout2.addView(lVar, layoutParams4);
                    linearLayout.addView(linearLayout2, layoutParams3);
                    this.f21474d.addView(linearLayout, layoutParams2);
                    if (qqVarI0.a() > 0.0f) {
                        lVar.setVisibility(4);
                        long jC = yp.c(qqVarI0.a());
                        final long jB = qqVarI0.b();
                        AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.a80
                            @Override // java.lang.Runnable
                            public final void run() {
                                zq.a(lVar, jB, (Runnable) null);
                            }
                        }, jC);
                    }
                    if (qqVarI0.c() > 0.0f) {
                        long jC2 = yp.c(qqVarI0.c());
                        final long jD = qqVarI0.d();
                        AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.b80
                            @Override // java.lang.Runnable
                            public final void run() {
                                zq.b(lVar, jD, null);
                            }
                        }, jC2);
                    }
                }
                if (gVar != null) {
                    if (this.f21473c.F0()) {
                        i11 = 48;
                        i12 = 3;
                    } else {
                        i11 = 48;
                        i12 = 5;
                    }
                    a(this.f21473c.l(), i11 | i12, gVar);
                }
                if (imageView != null) {
                    int iDpToPx2 = AppLovinSdkUtils.dpToPx(this.f21472b, ((Integer) this.f21471a.a(sj.A2)).intValue());
                    FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(iDpToPx2, iDpToPx2, ((Integer) this.f21471a.a(sj.C2)).intValue());
                    int iDpToPx3 = AppLovinSdkUtils.dpToPx(this.f21472b, ((Integer) this.f21471a.a(sj.B2)).intValue());
                    layoutParams5.setMargins(iDpToPx3, iDpToPx3, iDpToPx3, iDpToPx3);
                    this.f21474d.addView(imageView, layoutParams5);
                }
                if (oVar != null) {
                    this.f21474d.addView(oVar, this.f21475e);
                }
                if (h3Var != null) {
                    int iDpToPx4 = AppLovinSdkUtils.dpToPx(this.f21472b, ((Integer) this.f21471a.a(sj.f22991k2)).intValue());
                    FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(iDpToPx4, iDpToPx4, ((Integer) this.f21471a.a(sj.f22983j2)).intValue());
                    int iDpToPx5 = AppLovinSdkUtils.dpToPx(this.f21472b, ((Integer) this.f21471a.a(sj.f22975i2)).intValue());
                    layoutParams6.setMargins(iDpToPx5, iDpToPx5, iDpToPx5, iDpToPx5);
                    this.f21474d.addView(h3Var, layoutParams6);
                }
                if (progressBar != null) {
                    FrameLayout.LayoutParams layoutParams7 = new FrameLayout.LayoutParams(-1, 20, 80);
                    layoutParams7.setMargins(0, 0, 0, ((Integer) this.f21471a.a(sj.F2)).intValue());
                    this.f21474d.addView(progressBar, layoutParams7);
                }
                if (imageView2 != null) {
                    aqVar = (aq) this.f21473c;
                    if (aqVar.t1()) {
                        int iDpToPx6 = AppLovinSdkUtils.dpToPx(this.f21472b, aqVar.n1().f());
                        int iDpToPx7 = AppLovinSdkUtils.dpToPx(this.f21472b, aqVar.n1().c());
                        int iDpToPx8 = AppLovinSdkUtils.dpToPx(this.f21472b, ((Integer) this.f21471a.a(sj.U4)).intValue());
                        FrameLayout.LayoutParams layoutParams8 = new FrameLayout.LayoutParams(iDpToPx6, iDpToPx7, 83);
                        layoutParams8.setMargins(iDpToPx8, iDpToPx8, iDpToPx8, iDpToPx8);
                        this.f21474d.addView(imageView2, layoutParams8);
                    }
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
            layoutParams = new FrameLayout.LayoutParams(-1, -2, 80);
        }
        appLovinAdView.setLayoutParams(this.f21475e);
        this.f21474d.addView(appLovinAdView);
        View view3 = new View(this.f21472b);
        view3.setLayoutParams(this.f21475e);
        view3.setBackgroundColor(Color.argb(254, 0, 0, 0));
        view3.setOnTouchListener(new View.OnTouchListener() { // from class: com.applovin.impl.z70
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view4, MotionEvent motionEvent) {
                return w9.a(view4, motionEvent);
            }
        });
        this.f21474d.addView(view3);
        view.setLayoutParams(layoutParams);
        this.f21474d.addView(view);
        if (lVar != null) {
            qqVarI0 = this.f21473c.i0();
            LinearLayout linearLayout3 = new LinearLayout(this.f21472b);
            linearLayout3.setOrientation(1);
            linearLayout3.setWeightSum(100.0f);
            linearLayout3.setGravity(qqVarI0.e());
            ViewGroup.LayoutParams layoutParams9 = new FrameLayout.LayoutParams(-1, -1);
            LinearLayout linearLayout4 = new LinearLayout(this.f21472b);
            linearLayout4.setOrientation(0);
            linearLayout4.setWeightSum(100.0f);
            linearLayout4.setGravity(qqVarI0.e());
            ViewGroup.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(-2, 0, qqVarI0.f());
            LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(0, -1, qqVarI0.i());
            int iDpToPx9 = AppLovinSdkUtils.dpToPx(this.f21472b, qqVarI0.g());
            layoutParams11.setMargins(iDpToPx9, iDpToPx9, iDpToPx9, iDpToPx9);
            linearLayout4.addView(lVar, layoutParams11);
            linearLayout3.addView(linearLayout4, layoutParams10);
            this.f21474d.addView(linearLayout3, layoutParams9);
            if (qqVarI0.a() > 0.0f) {
                lVar.setVisibility(4);
                long jC3 = yp.c(qqVarI0.a());
                final long jB2 = qqVarI0.b();
                AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.a80
                    @Override // java.lang.Runnable
                    public final void run() {
                        zq.a(lVar, jB2, (Runnable) null);
                    }
                }, jC3);
            }
            if (qqVarI0.c() > 0.0f) {
                long jC4 = yp.c(qqVarI0.c());
                final long jD2 = qqVarI0.d();
                AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.b80
                    @Override // java.lang.Runnable
                    public final void run() {
                        zq.b(lVar, jD2, null);
                    }
                }, jC4);
            }
        }
        if (gVar != null) {
            if (this.f21473c.F0()) {
                i11 = 48;
                i12 = 3;
            } else {
                i11 = 48;
                i12 = 5;
            }
            a(this.f21473c.l(), i11 | i12, gVar);
        }
        if (imageView != null) {
            int iDpToPx10 = AppLovinSdkUtils.dpToPx(this.f21472b, ((Integer) this.f21471a.a(sj.A2)).intValue());
            FrameLayout.LayoutParams layoutParams12 = new FrameLayout.LayoutParams(iDpToPx10, iDpToPx10, ((Integer) this.f21471a.a(sj.C2)).intValue());
            int iDpToPx11 = AppLovinSdkUtils.dpToPx(this.f21472b, ((Integer) this.f21471a.a(sj.B2)).intValue());
            layoutParams12.setMargins(iDpToPx11, iDpToPx11, iDpToPx11, iDpToPx11);
            this.f21474d.addView(imageView, layoutParams12);
        }
        if (oVar != null) {
            this.f21474d.addView(oVar, this.f21475e);
        }
        if (h3Var != null) {
            int iDpToPx12 = AppLovinSdkUtils.dpToPx(this.f21472b, ((Integer) this.f21471a.a(sj.f22991k2)).intValue());
            FrameLayout.LayoutParams layoutParams13 = new FrameLayout.LayoutParams(iDpToPx12, iDpToPx12, ((Integer) this.f21471a.a(sj.f22983j2)).intValue());
            int iDpToPx13 = AppLovinSdkUtils.dpToPx(this.f21472b, ((Integer) this.f21471a.a(sj.f22975i2)).intValue());
            layoutParams13.setMargins(iDpToPx13, iDpToPx13, iDpToPx13, iDpToPx13);
            this.f21474d.addView(h3Var, layoutParams13);
        }
        if (progressBar != null) {
            FrameLayout.LayoutParams layoutParams14 = new FrameLayout.LayoutParams(-1, 20, 80);
            layoutParams14.setMargins(0, 0, 0, ((Integer) this.f21471a.a(sj.F2)).intValue());
            this.f21474d.addView(progressBar, layoutParams14);
        }
        if (imageView2 != null) {
            aqVar = (aq) this.f21473c;
            if (aqVar.t1()) {
                int iDpToPx14 = AppLovinSdkUtils.dpToPx(this.f21472b, aqVar.n1().f());
                int iDpToPx15 = AppLovinSdkUtils.dpToPx(this.f21472b, aqVar.n1().c());
                int iDpToPx16 = AppLovinSdkUtils.dpToPx(this.f21472b, ((Integer) this.f21471a.a(sj.U4)).intValue());
                FrameLayout.LayoutParams layoutParams15 = new FrameLayout.LayoutParams(iDpToPx14, iDpToPx15, 83);
                layoutParams15.setMargins(iDpToPx16, iDpToPx16, iDpToPx16, iDpToPx16);
                this.f21474d.addView(imageView2, layoutParams15);
            }
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

    @Override // com.applovin.impl.o9
    public /* bridge */ /* synthetic */ void a(com.applovin.impl.adview.g gVar) {
        super.a(gVar);
    }

    public void a(com.applovin.impl.adview.g gVar, com.applovin.impl.adview.k kVar, View view, ProgressBar progressBar) {
        if (view != null) {
            view.setVisibility(0);
        }
        e0.a(this.f21474d, view);
        if (gVar != null) {
            a(this.f21473c.l(), (this.f21473c.y0() ? 3 : 5) | 48, gVar);
        }
        if (progressBar != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, 20, ((Boolean) this.f21471a.a(sj.N2)).booleanValue() ? 80 : 48);
            layoutParams.setMargins(0, 0, 0, ((Integer) this.f21471a.a(sj.O2)).intValue());
            this.f21474d.addView(progressBar, layoutParams);
        }
        if (kVar != null) {
            this.f21474d.addView(kVar, this.f21475e);
        }
    }
}
