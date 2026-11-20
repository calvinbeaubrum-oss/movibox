package com.bytedance.sdk.openadsdk.component.reward.sc;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.model.JPJ;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class dE {
    private final sc ExN;
    private com.bytedance.sdk.openadsdk.core.widget.Qj TRI;
    private final int We;
    private final com.bytedance.sdk.openadsdk.core.model.Sfl pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private AnimatorSet f27901qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    com.bytedance.sdk.openadsdk.core.widget.Ol f27902sc;
    private final Context zY;

    public dE(sc scVar) {
        this.zY = scVar.f27911pc;
        this.pFF = scVar.pFF;
        this.We = scVar.OKY;
        this.ExN = scVar;
    }

    public View We() {
        return this.TRI;
    }

    public void pFF() {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(1, 80);
        valueAnimatorOfInt.setDuration(AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.sc.dE.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                com.bytedance.sdk.openadsdk.core.widget.Ol ol2 = dE.this.f27902sc;
                if (ol2 != null) {
                    ol2.setProgress(iIntValue);
                }
            }
        });
        ValueAnimator valueAnimatorOfInt2 = ValueAnimator.ofInt(81, 99);
        valueAnimatorOfInt2.setDuration(3000L);
        valueAnimatorOfInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.sc.dE.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                com.bytedance.sdk.openadsdk.core.widget.Ol ol2 = dE.this.f27902sc;
                if (ol2 != null) {
                    ol2.setProgress(iIntValue);
                }
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        this.f27901qr = animatorSet;
        animatorSet.play(valueAnimatorOfInt).before(valueAnimatorOfInt2);
        this.f27901qr.start();
    }

    public void sc() {
        try {
            if (JPJ.zY(this.pFF)) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.widget.Qj qj2 = new com.bytedance.sdk.openadsdk.core.widget.Qj(this.zY);
            this.TRI = qj2;
            this.f27902sc = qj2.getLoadingProgressBar();
            com.bytedance.sdk.openadsdk.core.ExN.Qj downloadButton = this.TRI.getDownloadButton();
            if (downloadButton != null) {
                downloadButton.setOnClickListener(this.ExN.McK.ExN());
            }
            this.TRI.sc(this.pFF, this.We);
        } catch (Throwable unused) {
        }
    }

    public void zY() {
        AnimatorSet animatorSet = this.f27901qr;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }
}
