package com.applovin.impl.adview;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.applovin.impl.sj;
import com.applovin.impl.t6;
import com.applovin.sdk.AppLovinSdkUtils;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
class f extends Dialog implements t6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Activity f17596a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f17597b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.applovin.impl.sdk.n f17598c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final b f17599d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.applovin.impl.sdk.ad.a f17600f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private RelativeLayout f17601g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private e f17602h;

    /* JADX INFO: compiled from: source.java */
    public class a implements Animation.AnimationListener {
        public a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            f.this.f17602h.setClickable(true);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public f(com.applovin.impl.sdk.ad.a aVar, b bVar, Activity activity, com.applovin.impl.sdk.j jVar) {
        super(activity, R.style.Theme.Translucent.NoTitleBar);
        if (aVar == null) {
            throw new IllegalArgumentException("No ad specified");
        }
        if (bVar == null) {
            throw new IllegalArgumentException("No main view specified");
        }
        if (jVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        if (activity == null) {
            throw new IllegalArgumentException("No activity specified");
        }
        this.f17597b = jVar;
        this.f17598c = jVar.J();
        this.f17596a = activity;
        this.f17599d = bVar;
        this.f17600f = aVar;
        requestWindowFeature(1);
        setCancelable(false);
    }

    private int a(int i11) {
        return AppLovinSdkUtils.dpToPx(this.f17596a, i11);
    }

    private void a() {
        this.f17599d.a("javascript:al_onCloseTapped();");
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        a();
    }

    private void a(e.a aVar) {
        if (this.f17602h != null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f17598c.k("ExpandedAdDialog", "Attempting to create duplicate close button");
                return;
            }
            return;
        }
        e eVarA = e.a(aVar, this.f17596a);
        this.f17602h = eVarA;
        eVarA.setVisibility(8);
        this.f17602h.setOnClickListener(new View.OnClickListener() { // from class: com.applovin.impl.adview.j0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f17613a.a(view);
            }
        });
        this.f17602h.setClickable(false);
        int iA = a(((Integer) this.f17597b.a(sj.T1)).intValue());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iA, iA);
        layoutParams.addRule(10);
        com.applovin.impl.sdk.j jVar = this.f17597b;
        sj sjVar = sj.W1;
        layoutParams.addRule(((Boolean) jVar.a(sjVar)).booleanValue() ? 9 : 11);
        this.f17602h.a(iA);
        int iA2 = a(((Integer) this.f17597b.a(sj.V1)).intValue());
        int iA3 = a(((Integer) this.f17597b.a(sj.U1)).intValue());
        layoutParams.setMargins(iA3, iA2, iA3, 0);
        this.f17601g.addView(this.f17602h, layoutParams);
        this.f17602h.bringToFront();
        int iA4 = a(((Integer) this.f17597b.a(sj.X1)).intValue());
        View view = new View(this.f17596a);
        view.setBackgroundColor(0);
        int i11 = iA + iA4;
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i11, i11);
        layoutParams2.addRule(10);
        layoutParams2.addRule(((Boolean) this.f17597b.a(sjVar)).booleanValue() ? 9 : 11);
        layoutParams2.setMargins(iA3 - a(5), iA2 - a(5), iA3 - a(5), 0);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.applovin.impl.adview.k0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f17616a.b(view2);
            }
        });
        this.f17601g.addView(view, layoutParams2);
        view.bringToFront();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        if (this.f17602h.isClickable()) {
            this.f17602h.performClick();
        }
    }

    private void d() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        this.f17599d.setLayoutParams(layoutParams);
        RelativeLayout relativeLayout = new RelativeLayout(this.f17596a);
        this.f17601g = relativeLayout;
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f17601g.setBackgroundColor(-1157627904);
        this.f17601g.addView(this.f17599d);
        if (!this.f17600f.n1()) {
            a(this.f17600f.g1());
            g();
        }
        setContentView(this.f17601g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        this.f17601g.removeView(this.f17599d);
        super.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f() {
        try {
            if (this.f17602h == null) {
                a();
            }
            this.f17602h.setVisibility(0);
            this.f17602h.bringToFront();
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(300L);
            alphaAnimation.setAnimationListener(new a());
            this.f17602h.startAnimation(alphaAnimation);
        } catch (Throwable th2) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f17598c.a("ExpandedAdDialog", "Unable to fade in close button", th2);
            }
            a();
        }
    }

    private void g() {
        this.f17596a.runOnUiThread(new Runnable() { // from class: com.applovin.impl.adview.l0
            @Override // java.lang.Runnable
            public final void run() {
                this.f17618a.f();
            }
        });
    }

    public com.applovin.impl.sdk.ad.a b() {
        return this.f17600f;
    }

    public b c() {
        return this.f17599d;
    }

    @Override // android.app.Dialog, android.content.DialogInterface, com.applovin.impl.t6
    public void dismiss() {
        this.f17596a.runOnUiThread(new Runnable() { // from class: com.applovin.impl.adview.m0
            @Override // java.lang.Runnable
            public final void run() {
                this.f17620a.e();
            }
        });
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        this.f17599d.a("javascript:al_onBackPressed();");
        dismiss();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        d();
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        try {
            Window window = getWindow();
            if (window != null) {
                window.setFlags(this.f17596a.getWindow().getAttributes().flags, this.f17596a.getWindow().getAttributes().flags);
                window.addFlags(16777216);
            } else if (com.applovin.impl.sdk.n.a()) {
                this.f17598c.b("ExpandedAdDialog", "Unable to turn on hardware acceleration - window is null");
            }
        } catch (Throwable th2) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f17598c.a("ExpandedAdDialog", "Setting window flags failed.", th2);
            }
        }
    }
}
