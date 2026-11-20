package com.facebook.ads.redexgen.uinode;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Of, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1531Of extends AnimatorListenerAdapter {
    public final /* synthetic */ TT A00;
    public final /* synthetic */ boolean A01;

    public C1531Of(TT tt2, boolean z11) {
        this.A00 = tt2;
        this.A01 = z11;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        this.A00.A0M.setTranslationY(0.0f);
        this.A00.A0U();
        if (!this.A01 && this.A00.A0J != null) {
            this.A00.A0J.destroy();
        }
        if (this.A00.A0g != null) {
            this.A00.A0g.setVisibility(this.A01 ? 8 : 0);
        }
    }
}
