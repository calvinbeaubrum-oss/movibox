package com.facebook.ads.redexgen.uinode;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Qo, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1592Qo extends AnimatorListenerAdapter {
    public final /* synthetic */ KF A00;

    public C1592Qo(KF kf2) {
        this.A00 = kf2;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        if (this.A00.A04) {
            AbstractC1462Lo.A0L(this.A00.A03);
        }
        this.A00.A03.setAlpha(1.0f);
        this.A00.A01 = EnumC1586Qi.A03;
        if (this.A00.A00 != null) {
            this.A00.A00.setListener(null);
            this.A00.A00 = null;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        if (this.A00.A04) {
            AbstractC1462Lo.A0H(this.A00.A03);
        }
        this.A00.A01 = EnumC1586Qi.A05;
        if (this.A00.A00 != null) {
            this.A00.A00.setListener(null);
            this.A00.A00 = null;
        }
    }
}
