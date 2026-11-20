package com.facebook.ads.redexgen.uinode;

import android.view.animation.Animation;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class MH implements Animation.AnimationListener {
    public final /* synthetic */ ViewOnClickListenerC1223Bi A00;

    public MH(ViewOnClickListenerC1223Bi viewOnClickListenerC1223Bi) {
        this.A00 = viewOnClickListenerC1223Bi;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        ((UT) this.A00).A07.finish(16);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
    }
}
