package com.bytedance.sdk.component.adexpress.TRI;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class BT extends FrameLayout {
    private boolean ExN;
    private AnimatorSet We;
    private ImageView pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private Context f26659sc;
    private JPJ zY;

    public BT(@NonNull Context context) {
        super(context);
        this.ExN = true;
        this.f26659sc = context;
        this.We = new AnimatorSet();
        zY();
        We();
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.TRI.BT.1
            @Override // java.lang.Runnable
            public void run() {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) BT.this.pFF.getLayoutParams();
                layoutParams.topMargin = (int) ((BT.this.zY.getMeasuredHeight() / 2.0f) - com.bytedance.sdk.component.adexpress.We.Qj.sc(BT.this.getContext(), 5.0f));
                layoutParams.leftMargin = (int) ((BT.this.zY.getMeasuredWidth() / 2.0f) - com.bytedance.sdk.component.adexpress.We.Qj.sc(BT.this.getContext(), 5.0f));
                layoutParams.bottomMargin = (int) (((-BT.this.zY.getMeasuredHeight()) / 2.0f) + com.bytedance.sdk.component.adexpress.We.Qj.sc(BT.this.getContext(), 5.0f));
                layoutParams.rightMargin = (int) (((-BT.this.zY.getMeasuredWidth()) / 2.0f) + com.bytedance.sdk.component.adexpress.We.Qj.sc(BT.this.getContext(), 5.0f));
                layoutParams.setMarginStart(layoutParams.leftMargin);
                layoutParams.setMarginEnd(layoutParams.rightMargin);
                BT.this.pFF.setLayoutParams(layoutParams);
            }
        });
    }

    private void We() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.pFF, "scaleX", 1.0f, 0.9f);
        objectAnimatorOfFloat.setDuration(800L);
        objectAnimatorOfFloat.setRepeatMode(2);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.TRI.BT.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                if (BT.this.ExN) {
                    BT.this.zY.sc();
                }
                BT bt2 = BT.this;
                bt2.ExN = !bt2.ExN;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(BT.this.pFF, "alpha", 0.0f, 1.0f);
                objectAnimatorOfFloat2.setDuration(200L);
                objectAnimatorOfFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
                objectAnimatorOfFloat2.start();
                BT.this.pFF.setVisibility(0);
            }
        });
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.pFF, "scaleY", 1.0f, 0.9f);
        objectAnimatorOfFloat2.setDuration(800L);
        objectAnimatorOfFloat2.setRepeatMode(2);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        objectAnimatorOfFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        this.We.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
    }

    private void zY() {
        this.zY = new JPJ(this.f26659sc);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.We.Qj.sc(this.f26659sc, 40.0f), (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(this.f26659sc, 40.0f));
        layoutParams.gravity = 8388627;
        addView(this.zY, layoutParams);
        this.pFF = new ImageView(this.f26659sc);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.We.Qj.sc(this.f26659sc, 62.0f), (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(this.f26659sc, 62.0f));
        layoutParams2.gravity = 16;
        this.pFF.setImageResource(com.bytedance.sdk.component.utils.Sfl.We(this.f26659sc, "tt_splash_hand"));
        addView(this.pFF, layoutParams2);
    }

    public void pFF() {
        AnimatorSet animatorSet = this.We;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        JPJ jpj = this.zY;
        if (jpj != null) {
            jpj.pFF();
        }
        ImageView imageView = this.pFF;
        if (imageView != null) {
            imageView.clearAnimation();
        }
    }

    public void sc() {
        this.We.start();
    }
}
