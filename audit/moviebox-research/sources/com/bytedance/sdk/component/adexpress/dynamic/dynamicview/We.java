package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class We extends TRI {
    private Runnable Dl;
    private int YIK;
    ObjectAnimator pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    ObjectAnimator f26817sc;

    public We(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj2) {
        super(context, dynamicRootView, qj2);
        this.YIK = 0;
        this.Dl = new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.We.1
            @Override // java.lang.Runnable
            public void run() {
                We.this.sc();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc() {
        final View childAt = getChildAt(this.YIK);
        final View childAt2 = getChildAt((this.YIK + 1) % getChildCount());
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(childAt, "translationY", 0.0f, (-(this.Qj + getChildAt(this.YIK).getHeight())) / 2);
        this.f26817sc = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        this.f26817sc.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.We.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                childAt.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(childAt2, "translationY", (this.Qj + childAt2.getHeight()) / 2, 0.0f);
        this.pFF = objectAnimatorOfFloat2;
        objectAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
        this.pFF.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.We.3
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
                childAt2.setVisibility(0);
            }
        });
        this.f26817sc.setDuration(500L);
        this.pFF.setDuration(500L);
        this.f26817sc.start();
        this.pFF.start();
        int i11 = this.YIK + 1;
        this.YIK = i11;
        this.YIK = i11 % getChildCount();
        postDelayed(this.Dl, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
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
        postDelayed(this.Dl, 2500L);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ExN, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.cJ
    public void pFF() {
        removeCallbacks(this.Dl);
        ObjectAnimator objectAnimator = this.f26817sc;
        if (objectAnimator != null) {
            objectAnimator.removeAllUpdateListeners();
            this.f26817sc.cancel();
        }
        ObjectAnimator objectAnimator2 = this.pFF;
        if (objectAnimator2 != null) {
            objectAnimator2.removeAllUpdateListeners();
            this.pFF.cancel();
        }
        super.pFF();
    }
}
