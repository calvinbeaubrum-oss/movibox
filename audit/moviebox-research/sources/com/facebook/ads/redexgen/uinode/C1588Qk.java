package com.facebook.ads.redexgen.uinode;

import android.animation.Animator;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Qk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1588Qk implements Animator.AnimatorListener {
    public final /* synthetic */ KI A00;

    public C1588Qk(KI ki2) {
        this.A00 = ki2;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.A00.A07(false);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.A00.A01 = null;
        this.A00.A02 = EnumC1586Qi.A03;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
    }
}
