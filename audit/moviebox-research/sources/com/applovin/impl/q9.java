package com.applovin.impl;

import android.app.Activity;
import android.os.SystemClock;
import android.view.ViewGroup;
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
public class q9 extends p9 {
    private final r9 L;
    private x1 M;
    private long N;
    private final AtomicBoolean O;

    public q9(com.applovin.impl.sdk.ad.b bVar, Activity activity, Map map, com.applovin.impl.sdk.j jVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        super(bVar, activity, map, jVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
        this.L = new r9(this.f21675a, this.f21678d, this.f21676b);
        this.O = new AtomicBoolean();
        if (yp.a(sj.f23014n1, jVar)) {
            a(false);
        }
    }

    private long E() {
        com.applovin.impl.sdk.ad.b bVar = this.f21675a;
        if (!(bVar instanceof com.applovin.impl.sdk.ad.a)) {
            return 0L;
        }
        float fJ1 = ((com.applovin.impl.sdk.ad.a) bVar).j1();
        if (fJ1 <= 0.0f) {
            fJ1 = this.f21675a.p();
        }
        return (long) (yp.c(fJ1) * (((double) this.f21675a.E()) / 100.0d));
    }

    private int F() {
        x1 x1Var;
        int iMin = 100;
        if (l()) {
            if (!G() && (x1Var = this.M) != null) {
                iMin = (int) Math.min(100.0d, ((this.N - x1Var.b()) / this.N) * 100.0d);
            }
            if (com.applovin.impl.sdk.n.a()) {
                this.f21677c.a("AppLovinFullscreenActivity", "Ad engaged at " + iMin + "%");
            }
        }
        return iMin;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f21677c.a("AppLovinFullscreenActivity", "Marking ad as fully watched");
        }
        this.O.set(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I() {
        this.f21690q = SystemClock.elapsedRealtime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J() {
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

    private void L() {
        this.L.a(this.f21685l);
        this.f21690q = SystemClock.elapsedRealtime();
        this.O.set(true);
    }

    @Override // com.applovin.impl.p9
    public void A() {
        a((ViewGroup) null);
    }

    public boolean G() {
        if (!(this.I && this.f21675a.Y0()) && l()) {
            return this.O.get();
        }
        return true;
    }

    public void K() {
        long jV;
        long millis = 0;
        if (this.f21675a.U() >= 0 || this.f21675a.V() >= 0) {
            if (this.f21675a.U() >= 0) {
                jV = this.f21675a.U();
            } else {
                if (this.f21675a.V0()) {
                    int iJ1 = (int) ((com.applovin.impl.sdk.ad.a) this.f21675a).j1();
                    if (iJ1 > 0) {
                        millis = TimeUnit.SECONDS.toMillis(iJ1);
                    } else {
                        int iP = (int) this.f21675a.p();
                        if (iP > 0) {
                            millis = TimeUnit.SECONDS.toMillis(iP);
                        }
                    }
                }
                jV = (long) (millis * (((double) this.f21675a.V()) / 100.0d));
            }
            b(jV);
        }
    }

    @Override // com.applovin.impl.p9
    public void a(long j11) {
    }

    @Override // com.applovin.impl.p9
    public void a(ViewGroup viewGroup) {
        this.L.a(this.f21684k, this.f21683j, this.f21682i, viewGroup);
        if (!yp.a(sj.f23014n1, this.f21676b)) {
            b(false);
        }
        com.applovin.impl.adview.k kVar = this.f21683j;
        if (kVar != null) {
            kVar.b();
        }
        this.f21682i.renderAd(this.f21675a);
        a("javascript:al_onPoststitialShow();", this.f21675a.D());
        if (l()) {
            long jE = E();
            this.N = jE;
            if (jE > 0) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f21677c.a("AppLovinFullscreenActivity", "Scheduling timer for ad fully watched in " + this.N + "ms...");
                }
                this.M = x1.a(this.N, this.f21676b, new Runnable() { // from class: com.applovin.impl.w10
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f24011a.H();
                    }
                });
            }
        }
        if (this.f21684k != null) {
            if (this.f21675a.p() >= 0) {
                a(this.f21684k, this.f21675a.p(), new Runnable() { // from class: com.applovin.impl.x10
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f24203a.I();
                    }
                });
            } else {
                this.f21684k.setVisibility(0);
            }
        }
        K();
        this.f21676b.j0().a(new jn(this.f21676b, "updateMainViewOM", new Runnable() { // from class: com.applovin.impl.y10
            @Override // java.lang.Runnable
            public final void run() {
                this.f24456a.J();
            }
        }), tm.b.OTHER, TimeUnit.SECONDS.toMillis(1L));
        t();
        super.d(yp.e(this.f21676b));
    }

    @Override // com.applovin.impl.kb.a
    public void b() {
    }

    @Override // com.applovin.impl.kb.a
    public void c() {
    }

    @Override // com.applovin.impl.p9
    public void f() {
        q();
        x1 x1Var = this.M;
        if (x1Var != null) {
            x1Var.a();
            this.M = null;
        }
        super.f();
    }

    @Override // com.applovin.impl.p9
    public void i() {
        super.i();
        L();
    }

    @Override // com.applovin.impl.p9
    public void j() {
        super.j();
        L();
    }

    @Override // com.applovin.impl.p9
    public void q() {
        super.a(F(), false, G(), -2L);
    }

    @Override // com.applovin.impl.p9
    public void z() {
    }
}
