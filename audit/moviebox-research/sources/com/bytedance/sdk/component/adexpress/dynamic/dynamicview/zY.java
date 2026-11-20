package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class zY extends TRI {
    private boolean Dl;
    private int YIK;
    ObjectAnimator pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    ObjectAnimator f26830sc;
    private Runnable uEA;

    public zY(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj2) {
        super(context, dynamicRootView, qj2);
        this.YIK = 0;
        this.Dl = false;
        this.uEA = new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.zY.1
            @Override // java.lang.Runnable
            public void run() {
                zY.this.sc();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc() {
        final View childAt;
        final View childAt2 = getChildAt(this.YIK);
        if (childAt2 == null) {
            return;
        }
        int i11 = this.YIK;
        if (i11 == 0) {
            this.Dl = false;
        }
        if (i11 + 1 >= getChildCount() || ((ViewGroup) getChildAt(this.YIK + 1)).getChildCount() <= 0) {
            this.Dl = true;
            childAt = getChildAt(this.YIK - 1);
            this.f26830sc = ObjectAnimator.ofFloat(childAt2, "translationX", 0.0f, (this.f26791qr + getChildAt(this.YIK).getWidth()) / 2);
        } else {
            childAt = getChildAt(this.YIK + 1);
            this.f26830sc = ObjectAnimator.ofFloat(childAt2, "translationX", 0.0f, (-(this.f26791qr + getChildAt(this.YIK).getWidth())) / 2);
        }
        if (childAt == null) {
            return;
        }
        this.f26830sc.setInterpolator(new LinearInterpolator());
        this.f26830sc.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.zY.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                childAt2.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        if (this.Dl) {
            this.pFF = ObjectAnimator.ofFloat(childAt, "translationX", (-(this.f26791qr + childAt.getWidth())) / 2, 0.0f);
        } else {
            this.pFF = ObjectAnimator.ofFloat(childAt, "translationX", (this.f26791qr + childAt.getWidth()) / 2, 0.0f);
        }
        this.pFF.setInterpolator(new LinearInterpolator());
        this.pFF.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.zY.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                childAt.setVisibility(0);
            }
        });
        this.f26830sc.setDuration(500L);
        this.pFF.setDuration(500L);
        this.f26830sc.start();
        this.pFF.start();
        if (this.Dl) {
            this.YIK--;
        } else {
            this.YIK++;
        }
        postDelayed(this.uEA, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.TRI, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ExN, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            View childAt = getChildAt(i11);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            layoutParams.topMargin = (this.Qj - layoutParams.height) / 2;
            childAt.setLayoutParams(layoutParams);
            if (i11 != 0) {
                childAt.setVisibility(8);
            }
        }
        postDelayed(this.uEA, 2500L);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ExN, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.cJ
    public void pFF() {
        removeCallbacks(this.uEA);
        ObjectAnimator objectAnimator = this.f26830sc;
        if (objectAnimator != null) {
            objectAnimator.removeAllUpdateListeners();
            this.f26830sc.cancel();
        }
        ObjectAnimator objectAnimator2 = this.pFF;
        if (objectAnimator2 != null) {
            objectAnimator2.removeAllUpdateListeners();
            this.pFF.cancel();
        }
        super.pFF();
    }
}
