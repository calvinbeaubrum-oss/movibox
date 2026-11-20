package com.applovin.impl;

import android.R;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.applovin.impl.sdk.utils.ImageViewUtils;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.iab.omid.library.applovin.adsession.FriendlyObstructionPurpose;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class x9 extends p9 implements g0 {
    private final y9 L;
    private final com.applovin.impl.adview.g M;
    private final ImageView N;
    private final o O;
    private final boolean P;
    private double Q;
    private double R;
    private final AtomicBoolean S;
    private final AtomicBoolean T;
    private boolean U;
    private long V;
    private long W;

    /* JADX INFO: compiled from: source.java */
    public class b implements View.OnClickListener {
        private b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == x9.this.M) {
                x9.this.O();
                return;
            }
            if (view == x9.this.N) {
                x9.this.P();
                return;
            }
            com.applovin.impl.sdk.n nVar = x9.this.f21677c;
            if (com.applovin.impl.sdk.n.a()) {
                x9.this.f21677c.b("AppLovinFullscreenActivity", "Unhandled click on widget: " + view);
            }
        }
    }

    public x9(com.applovin.impl.sdk.ad.b bVar, Activity activity, Map map, com.applovin.impl.sdk.j jVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        super(bVar, activity, map, jVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
        this.L = new y9(this.f21675a, this.f21678d, this.f21676b);
        boolean zH0 = this.f21675a.H0();
        this.P = zH0;
        this.S = new AtomicBoolean();
        this.T = new AtomicBoolean();
        this.U = yp.e(this.f21676b);
        this.V = -2L;
        this.W = 0L;
        if (yp.a(sj.f23014n1, jVar)) {
            a(false);
        }
        b bVar2 = new b();
        if (bVar.k0() >= 0) {
            com.applovin.impl.adview.g gVar = new com.applovin.impl.adview.g(bVar.b0(), activity);
            this.M = gVar;
            gVar.setVisibility(8);
            gVar.setOnClickListener(bVar2);
        } else {
            this.M = null;
        }
        if (a(this.U, jVar)) {
            ImageView imageView = new ImageView(activity);
            this.N = imageView;
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setClickable(true);
            imageView.setOnClickListener(bVar2);
            e(this.U);
        } else {
            this.N = null;
        }
        if (!zH0) {
            this.O = null;
            return;
        }
        o oVar = new o(activity, ((Integer) jVar.a(sj.G2)).intValue(), R.attr.progressBarStyleLarge);
        this.O = oVar;
        oVar.setColor(Color.parseColor("#75FFFFFF"));
        oVar.setBackgroundColor(Color.parseColor("#00000000"));
        oVar.setVisibility(8);
    }

    private void E() {
        this.f21698y++;
        if (this.f21675a.B()) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f21677c.a("AppLovinFullscreenActivity", "Dismissing ad on video skip...");
            }
            f();
        } else {
            if (com.applovin.impl.sdk.n.a()) {
                this.f21677c.a("AppLovinFullscreenActivity", "Skipping video...");
            }
            N();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G() {
        this.V = -1L;
        this.W = SystemClock.elapsedRealtime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H() {
        ArrayList arrayList = new ArrayList();
        com.applovin.impl.adview.g gVar = this.f21684k;
        if (gVar != null) {
            arrayList.add(new og(gVar, FriendlyObstructionPurpose.CLOSE_AD, "close button"));
        }
        com.applovin.impl.adview.k kVar = this.f21683j;
        if (kVar != null && kVar.a()) {
            com.applovin.impl.adview.k kVar2 = this.f21683j;
            arrayList.add(new og(kVar2, FriendlyObstructionPurpose.NOT_VISIBLE, kVar2.getIdentifier()));
        }
        this.f21675a.getAdEventTracker().b(this.f21682i, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I() {
        this.f21690q = SystemClock.elapsedRealtime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        if (this.T.compareAndSet(false, true)) {
            a(this.M, this.f21675a.k0(), new Runnable() { // from class: com.applovin.impl.e90
                @Override // java.lang.Runnable
                public final void run() {
                    this.f18674a.G();
                }
            });
        }
    }

    private void M() {
        this.L.a(this.f21685l);
        this.f21690q = SystemClock.elapsedRealtime();
        this.Q = 100.0d;
    }

    private static boolean a(boolean z11, com.applovin.impl.sdk.j jVar) {
        if (!((Boolean) jVar.a(sj.f23079v2)).booleanValue()) {
            return false;
        }
        if (!((Boolean) jVar.a(sj.f23087w2)).booleanValue() || z11) {
            return true;
        }
        return ((Boolean) jVar.a(sj.f23103y2)).booleanValue();
    }

    private void e(boolean z11) {
        if (z3.f()) {
            AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) this.f21678d.getDrawable(z11 ? com.applovin.sdk.R.drawable.applovin_ic_unmute_to_mute : com.applovin.sdk.R.drawable.applovin_ic_mute_to_unmute);
            if (animatedVectorDrawable != null) {
                this.N.setScaleType(ImageView.ScaleType.FIT_XY);
                this.N.setImageDrawable(animatedVectorDrawable);
                animatedVectorDrawable.start();
                return;
            }
        }
        ImageViewUtils.setImageUri(this.N, z11 ? this.f21675a.L() : this.f21675a.e0(), this.f21676b);
    }

    @Override // com.applovin.impl.p9
    public void A() {
        a((ViewGroup) null);
    }

    public boolean F() {
        return (this.I && this.f21675a.Y0()) || this.Q >= ((double) this.f21675a.m0());
    }

    public void J() {
        long jV;
        long millis;
        if (this.f21675a.U() >= 0 || this.f21675a.V() >= 0) {
            if (this.f21675a.U() >= 0) {
                jV = this.f21675a.U();
            } else {
                com.applovin.impl.sdk.ad.a aVar = (com.applovin.impl.sdk.ad.a) this.f21675a;
                double d11 = this.R;
                long millis2 = d11 > 0.0d ? TimeUnit.SECONDS.toMillis((long) d11) : 0L;
                if (aVar.V0()) {
                    int iJ1 = (int) ((com.applovin.impl.sdk.ad.a) this.f21675a).j1();
                    if (iJ1 > 0) {
                        millis = TimeUnit.SECONDS.toMillis(iJ1);
                    } else {
                        int iP = (int) aVar.p();
                        if (iP > 0) {
                            millis = TimeUnit.SECONDS.toMillis(iP);
                        }
                    }
                    millis2 += millis;
                }
                jV = (long) (millis2 * (((double) this.f21675a.V()) / 100.0d));
            }
            b(jV);
        }
    }

    public boolean L() {
        return l() && !F();
    }

    public void N() {
        if (this.S.compareAndSet(false, true)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f21677c.a("AppLovinFullscreenActivity", "Showing postitial...");
            }
            c("javascript:al_showPostitial();");
            com.applovin.impl.adview.g gVar = this.M;
            if (gVar != null) {
                gVar.setVisibility(8);
            }
            ImageView imageView = this.N;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            o oVar = this.O;
            if (oVar != null) {
                oVar.b();
            }
            if (this.f21684k != null) {
                if (this.f21675a.p() >= 0) {
                    a(this.f21684k, this.f21675a.p(), new Runnable() { // from class: com.applovin.impl.d90
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f18397a.I();
                        }
                    });
                } else {
                    this.f21684k.setVisibility(0);
                }
            }
            this.f21682i.getController().E();
            t();
        }
    }

    public void O() {
        this.V = SystemClock.elapsedRealtime() - this.W;
        if (com.applovin.impl.sdk.n.a()) {
            this.f21677c.a("AppLovinFullscreenActivity", "Attempting to skip video with skip time: " + this.V + "ms");
        }
        if (!L()) {
            E();
            return;
        }
        r();
        if (com.applovin.impl.sdk.n.a()) {
            this.f21677c.a("AppLovinFullscreenActivity", "Prompting incentivized ad close warning");
        }
        this.F.e();
    }

    public void P() {
        this.U = !this.U;
        c("javascript:al_setVideoMuted(" + this.U + ");");
        e(this.U);
        a(this.U, 0L);
    }

    @Override // com.applovin.impl.g0
    public void a() {
        o oVar = this.O;
        if (oVar != null) {
            oVar.a();
        }
    }

    @Override // com.applovin.impl.g0
    public void a(double d11) {
        this.Q = d11;
    }

    @Override // com.applovin.impl.p9
    public void a(long j11) {
    }

    @Override // com.applovin.impl.p9
    public void a(ViewGroup viewGroup) {
        this.L.a(this.N, this.M, this.f21684k, this.O, this.f21683j, this.f21682i, viewGroup);
        this.f21682i.getController().a((g0) this);
        if (!yp.a(sj.f23014n1, this.f21676b)) {
            b(false);
        }
        o oVar = this.O;
        if (oVar != null) {
            oVar.a();
        }
        com.applovin.impl.adview.k kVar = this.f21683j;
        if (kVar != null) {
            kVar.b();
        }
        this.f21682i.renderAd(this.f21675a);
        if (this.M != null) {
            this.f21676b.j0().a(new jn(this.f21676b, "scheduleSkipButton", new Runnable() { // from class: com.applovin.impl.b90
                @Override // java.lang.Runnable
                public final void run() {
                    this.f17887a.K();
                }
            }), tm.b.TIMEOUT, this.f21675a.l0(), true);
        }
        this.f21676b.j0().a(new jn(this.f21676b, "updateMainViewOM", new Runnable() { // from class: com.applovin.impl.c90
            @Override // java.lang.Runnable
            public final void run() {
                this.f18144a.H();
            }
        }), tm.b.OTHER, 500L);
        super.d(this.U);
    }

    @Override // com.applovin.impl.kb.a
    public void b() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f21677c.a("AppLovinFullscreenActivity", "Skipping video from prompt");
        }
        E();
    }

    @Override // com.applovin.impl.g0
    public void b(double d11) {
        c("javascript:al_setVideoMuted(" + this.U + ");");
        o oVar = this.O;
        if (oVar != null) {
            oVar.b();
        }
        if (this.M != null) {
            K();
        }
        this.f21682i.getController().D();
        this.R = d11;
        J();
        if (this.f21675a.b1()) {
            this.F.b(this.f21675a, (Runnable) null);
        }
    }

    @Override // com.applovin.impl.kb.a
    public void c() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f21677c.a("AppLovinFullscreenActivity", "Continue video from prompt - will resume in onWindowFocusChanged(true) when alert dismisses");
        }
    }

    @Override // com.applovin.impl.g0
    public void d() {
        o oVar = this.O;
        if (oVar != null) {
            oVar.b();
        }
    }

    @Override // com.applovin.impl.g0
    public void e() {
        N();
    }

    @Override // com.applovin.impl.p9
    public void f() {
        q();
        super.f();
    }

    @Override // com.applovin.impl.p9
    public void i() {
        super.i();
        M();
    }

    @Override // com.applovin.impl.p9
    public void j() {
        super.j();
        M();
    }

    @Override // com.applovin.impl.p9
    public void q() {
        super.a((int) this.Q, this.P, F(), this.V);
    }

    @Override // com.applovin.impl.p9
    public void z() {
    }
}
