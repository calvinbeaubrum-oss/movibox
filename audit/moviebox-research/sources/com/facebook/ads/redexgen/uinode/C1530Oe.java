package com.facebook.ads.redexgen.uinode;

import android.animation.ValueAnimator;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Oe, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1530Oe implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ TT A00;

    public C1530Oe(TT tt2) {
        this.A00 = tt2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        Integer num = (Integer) valueAnimator.getAnimatedValue();
        this.A00.A0A.getLayoutParams().height = num.intValue();
        this.A00.A0A.requestLayout();
    }
}
