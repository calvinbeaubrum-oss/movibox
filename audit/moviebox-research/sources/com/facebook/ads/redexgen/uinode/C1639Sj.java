package com.facebook.ads.redexgen.uinode;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Sj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1639Sj extends KT {
    public final /* synthetic */ InterfaceC1557Pf A00;
    public final /* synthetic */ C1558Pg A01;

    public C1639Sj(C1558Pg c1558Pg, InterfaceC1557Pf interfaceC1557Pf) {
        this.A01 = c1558Pg;
        this.A00 = interfaceC1557Pf;
    }

    @Override // com.facebook.ads.redexgen.uinode.KT
    public final void A06() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setInterpolator(new AccelerateInterpolator());
        alphaAnimation.setAnimationListener(new C1640Sk(this));
        this.A01.startAnimation(alphaAnimation);
    }
}
