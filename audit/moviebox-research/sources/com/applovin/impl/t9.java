package com.applovin.impl;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.iab.omid.library.applovin.adsession.FriendlyObstructionPurpose;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class t9 extends v9 {

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private final aq f23214n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private final Set f23215o0;

    /* JADX INFO: compiled from: source.java */
    public class a implements v4.b {
        public a() {
        }

        @Override // com.applovin.impl.v4.b
        public void a() {
            long seconds = TimeUnit.MILLISECONDS.toSeconds(t9.this.f23790e0 - ((long) (t9.this.N.getDuration() - t9.this.N.getCurrentPosition())));
            int iE = t9.this.E();
            HashSet hashSet = new HashSet();
            for (kq kqVar : new HashSet(t9.this.f23215o0)) {
                if (kqVar.a(seconds, iE)) {
                    hashSet.add(kqVar);
                    t9.this.f23215o0.remove(kqVar);
                }
            }
            t9.this.a(hashSet);
            if (iE >= 25 && iE < 50) {
                t9.this.f23214n0.getAdEventTracker().x();
                return;
            }
            if (iE >= 50 && iE < 75) {
                t9.this.f23214n0.getAdEventTracker().y();
            } else if (iE >= 75) {
                t9.this.f23214n0.getAdEventTracker().C();
            }
        }

        @Override // com.applovin.impl.v4.b
        public boolean b() {
            return !t9.this.f23793h0;
        }
    }

    public t9(com.applovin.impl.sdk.ad.b bVar, final Activity activity, Map map, final com.applovin.impl.sdk.j jVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        super(bVar, activity, map, jVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
        HashSet hashSet = new HashSet();
        this.f23215o0 = hashSet;
        aq aqVar = (aq) bVar;
        this.f23214n0 = aqVar;
        if (aqVar.t1()) {
            ImageView imageViewA = gq.a(aqVar.n1().d(), activity, jVar);
            this.V = imageViewA;
            imageViewA.setOnClickListener(new View.OnClickListener() { // from class: com.applovin.impl.w50
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f24058a.a(activity, jVar, view);
                }
            });
        }
        aq.d dVar = aq.d.VIDEO;
        hashSet.addAll(aqVar.a(dVar, lq.f20505a));
        a(aq.d.IMPRESSION);
        a(dVar, "creativeView");
        aqVar.getAdEventTracker().g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Activity activity, com.applovin.impl.sdk.j jVar, View view) {
        Uri uriB = this.f23214n0.n1().b();
        if (uriB != null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f21677c.a("AppLovinFullscreenActivity", "Industry Icon clicked, opening URL: " + uriB);
            }
            a(aq.d.INDUSTRY_ICON_CLICK);
            tp.a(uriB, activity, jVar);
        }
    }

    private void a(aq.d dVar) {
        a(dVar, fq.UNSPECIFIED);
    }

    private void a(aq.d dVar, fq fqVar) {
        a(dVar, "", fqVar);
    }

    private void a(aq.d dVar, String str) {
        a(dVar, str, fq.UNSPECIFIED);
    }

    private void a(aq.d dVar, String str, fq fqVar) {
        a(this.f23214n0.a(dVar, str), fqVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Set set) {
        a(set, fq.UNSPECIFIED);
    }

    private void a(Set set, fq fqVar) {
        if (set == null || set.isEmpty()) {
            return;
        }
        long seconds = TimeUnit.MILLISECONDS.toSeconds(this.N.getCurrentPosition());
        oq oqVarS1 = this.f23214n0.s1();
        Uri uriC = oqVarS1 != null ? oqVarS1.c() : null;
        if (com.applovin.impl.sdk.n.a()) {
            this.f21677c.a("AppLovinFullscreenActivity", "Firing " + set.size() + " tracker(s): " + set);
        }
        mq.a(set, seconds, uriC, fqVar, this.f21676b);
    }

    private boolean a0() {
        return this.V != null && this.f23214n0.t1();
    }

    private void b0() {
        if (!I() || this.f23215o0.isEmpty()) {
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f21677c.k("AppLovinFullscreenActivity", "Firing " + this.f23215o0.size() + " un-fired video progress trackers when video was completed.");
        }
        a(this.f23215o0);
    }

    @Override // com.applovin.impl.v9, com.applovin.impl.p9
    public void A() {
        a((ViewGroup) null);
    }

    @Override // com.applovin.impl.v9
    public void F() {
        a(aq.d.VIDEO, "skip");
        this.f23214n0.getAdEventTracker().B();
        super.F();
    }

    @Override // com.applovin.impl.v9
    public void G() {
        super.G();
        aq aqVar = this.f23214n0;
        if (aqVar != null) {
            aqVar.getAdEventTracker().i();
        }
    }

    @Override // com.applovin.impl.v9
    public void R() {
        long jV;
        int iP;
        long millis = 0;
        if (this.f23214n0.U() >= 0 || this.f23214n0.V() >= 0) {
            if (this.f23214n0.U() >= 0) {
                jV = this.f23214n0.U();
            } else {
                aq aqVar = this.f23214n0;
                nq nqVarR1 = aqVar.r1();
                if (nqVarR1 == null || nqVarR1.c() <= 0) {
                    long j11 = this.f23790e0;
                    if (j11 > 0) {
                        millis = j11;
                    }
                } else {
                    millis = TimeUnit.SECONDS.toMillis(nqVarR1.c());
                }
                if (aqVar.V0() && (iP = (int) aqVar.p()) > 0) {
                    millis += TimeUnit.SECONDS.toMillis(iP);
                }
                jV = (long) (millis * (((double) this.f23214n0.V()) / 100.0d));
            }
            b(jV);
        }
    }

    @Override // com.applovin.impl.v9
    public void W() {
        super.W();
        aq aqVar = this.f23214n0;
        if (aqVar != null) {
            aqVar.getAdEventTracker().j();
        }
    }

    @Override // com.applovin.impl.v9
    public void X() {
        b0();
        if (!mq.a(this.f23214n0)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f21677c.a("AppLovinFullscreenActivity", "VAST ad does not have valid companion ad - dismissing...");
            }
            f();
        } else {
            if (this.f23793h0) {
                return;
            }
            a(aq.d.COMPANION, "creativeView");
            this.f23214n0.getAdEventTracker().w();
            super.X();
        }
    }

    @Override // com.applovin.impl.v9
    public void Z() {
        super.Z();
        a(aq.d.VIDEO, this.f23789d0 ? CampaignEx.JSON_NATIVE_VIDEO_MUTE : CampaignEx.JSON_NATIVE_VIDEO_UNMUTE);
        this.f23214n0.getAdEventTracker().b(this.f23789d0);
    }

    @Override // com.applovin.impl.v9
    public void a(MotionEvent motionEvent, Bundle bundle) {
        a(aq.d.VIDEO_CLICK);
        this.f23214n0.getAdEventTracker().v();
        super.a(motionEvent, bundle);
    }

    @Override // com.applovin.impl.v9, com.applovin.impl.p9
    public void a(ViewGroup viewGroup) {
        super.a(viewGroup);
        if (a0()) {
            a(aq.d.INDUSTRY_ICON_IMPRESSION);
            this.V.setVisibility(0);
        }
        this.f23786a0.a("PROGRESS_TRACKING", TimeUnit.SECONDS.toMillis(1L), new a());
        ArrayList arrayList = new ArrayList();
        o oVar = this.O;
        if (oVar != null) {
            arrayList.add(new og(oVar, FriendlyObstructionPurpose.OTHER, "video stream buffering indicator"));
        }
        com.applovin.impl.adview.g gVar = this.P;
        if (gVar != null) {
            arrayList.add(new og(gVar, FriendlyObstructionPurpose.CLOSE_AD, "skip button"));
        }
        h3 h3Var = this.Q;
        if (h3Var != null) {
            arrayList.add(new og(h3Var, FriendlyObstructionPurpose.OTHER, "countdown clock"));
        }
        ProgressBar progressBar = this.T;
        if (progressBar != null) {
            arrayList.add(new og(progressBar, FriendlyObstructionPurpose.OTHER, "progress bar"));
        }
        ProgressBar progressBar2 = this.U;
        if (progressBar2 != null) {
            arrayList.add(new og(progressBar2, FriendlyObstructionPurpose.OTHER, "postitial progress bar"));
        }
        ImageView imageView = this.R;
        if (imageView != null) {
            arrayList.add(new og(imageView, FriendlyObstructionPurpose.VIDEO_CONTROLS, "mute button"));
        }
        com.applovin.impl.adview.l lVar = this.S;
        if (lVar != null) {
            arrayList.add(new og(lVar, FriendlyObstructionPurpose.VIDEO_CONTROLS, "generic webview overlay containing HTML controls"));
        }
        com.applovin.impl.adview.k kVar = this.f21683j;
        if (kVar != null && kVar.a()) {
            com.applovin.impl.adview.k kVar2 = this.f21683j;
            arrayList.add(new og(kVar2, FriendlyObstructionPurpose.NOT_VISIBLE, kVar2.getIdentifier()));
        }
        this.f23214n0.getAdEventTracker().b(this.N, arrayList);
    }

    @Override // com.applovin.impl.v9
    public void c(long j11) {
        super.c(j11);
        this.f23214n0.getAdEventTracker().b(TimeUnit.MILLISECONDS.toSeconds(j11), yp.e(this.f21676b));
    }

    @Override // com.applovin.impl.v9
    public void d(String str) {
        a(aq.d.ERROR, fq.MEDIA_FILE_ERROR);
        this.f23214n0.getAdEventTracker().b(str);
        super.d(str);
    }

    @Override // com.applovin.impl.v9, com.applovin.impl.p9
    public void f() {
        if (this.f23214n0 != null) {
            a(aq.d.VIDEO, CampaignEx.JSON_NATIVE_VIDEO_CLOSE);
            a(aq.d.COMPANION, CampaignEx.JSON_NATIVE_VIDEO_CLOSE);
        }
        super.f();
    }

    @Override // com.applovin.impl.p9
    public void w() {
        super.w();
        a(this.f23793h0 ? aq.d.COMPANION : aq.d.VIDEO, "pause");
        this.f23214n0.getAdEventTracker().z();
    }

    @Override // com.applovin.impl.p9
    public void x() {
        super.x();
        a(this.f23793h0 ? aq.d.COMPANION : aq.d.VIDEO, CampaignEx.JSON_NATIVE_VIDEO_RESUME);
        this.f23214n0.getAdEventTracker().A();
    }

    @Override // com.applovin.impl.v9, com.applovin.impl.p9
    public void z() {
        this.f23786a0.c();
        super.z();
    }
}
