package com.facebook.ads.redexgen.uinode;

import android.view.animation.Animation;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Sk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1640Sk extends AnimationAnimationListenerC1461Ln {
    public final /* synthetic */ C1639Sj A00;

    public C1640Sk(C1639Sj c1639Sj) {
        this.A00 = c1639Sj;
    }

    @Override // com.facebook.ads.redexgen.uinode.AnimationAnimationListenerC1461Ln, android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        AbstractC1462Lo.A0H(this.A00.A01);
        this.A00.A00.ABu();
    }
}
