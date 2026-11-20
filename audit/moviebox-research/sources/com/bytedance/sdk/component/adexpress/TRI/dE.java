package com.bytedance.sdk.component.adexpress.TRI;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.google.android.material.card.MaterialCardView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class dE extends FrameLayout {
    private boolean ExN;
    private TextView TRI;
    private AnimatorSet We;
    private ImageView pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private Context f26711sc;
    private JPJ zY;

    public dE(@NonNull Context context) {
        super(context);
        this.ExN = true;
        this.f26711sc = context;
        this.We = new AnimatorSet();
        zY();
        We();
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.TRI.dE.1
            @Override // java.lang.Runnable
            public void run() {
                int iSc = (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(dE.this.f26711sc, 50.0f);
                int iSc2 = (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(dE.this.f26711sc, 50.0f);
                if (dE.this.zY.getMeasuredHeight() > 0) {
                    iSc = dE.this.zY.getMeasuredHeight();
                }
                if (dE.this.zY.getMeasuredWidth() > 0) {
                    iSc2 = dE.this.zY.getMeasuredWidth();
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) dE.this.pFF.getLayoutParams();
                layoutParams.topMargin = ((int) ((iSc / 2.0f) - com.bytedance.sdk.component.adexpress.We.Qj.sc(dE.this.getContext(), 5.0f))) + ((int) com.bytedance.sdk.component.adexpress.We.Qj.sc(dE.this.f26711sc, 40.0f));
                layoutParams.leftMargin = ((int) ((iSc2 / 2.0f) - com.bytedance.sdk.component.adexpress.We.Qj.sc(dE.this.getContext(), 5.0f))) + ((int) com.bytedance.sdk.component.adexpress.We.Qj.sc(dE.this.f26711sc, 20.0f));
                layoutParams.bottomMargin = (int) (((-iSc) / 2.0f) + com.bytedance.sdk.component.adexpress.We.Qj.sc(dE.this.getContext(), 5.0f));
                layoutParams.rightMargin = (int) (((-iSc2) / 2.0f) + com.bytedance.sdk.component.adexpress.We.Qj.sc(dE.this.getContext(), 5.0f));
                layoutParams.setMarginStart(layoutParams.leftMargin);
                layoutParams.setMarginEnd(layoutParams.rightMargin);
                dE.this.pFF.setLayoutParams(layoutParams);
            }
        });
    }

    private void We() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.pFF, "scaleX", 1.0f, 1.0f, 1.0f, 0.9f);
        objectAnimatorOfFloat.setDuration(600L);
        objectAnimatorOfFloat.setRepeatMode(2);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.TRI.dE.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                if (dE.this.ExN) {
                    dE.this.zY.sc();
                }
                dE dEVar = dE.this;
                dEVar.ExN = !dEVar.ExN;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(dE.this.pFF, "alpha", 0.0f, 1.0f);
                objectAnimatorOfFloat2.setDuration(200L);
                objectAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
                objectAnimatorOfFloat2.start();
                dE.this.pFF.setVisibility(0);
            }
        });
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.pFF, "scaleY", 1.0f, 1.0f, 1.0f, 0.9f);
        objectAnimatorOfFloat2.setDuration(600L);
        objectAnimatorOfFloat2.setRepeatMode(2);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        this.We.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
    }

    private void zY() {
        this.zY = new JPJ(this.f26711sc);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.We.Qj.sc(this.f26711sc, 50.0f), (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(this.f26711sc, 50.0f));
        layoutParams.gravity = MaterialCardView.CHECKED_ICON_GRAVITY_TOP_START;
        layoutParams.topMargin = (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(this.f26711sc, 40.0f);
        int iSc = (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(this.f26711sc, 20.0f);
        layoutParams.leftMargin = iSc;
        layoutParams.setMarginStart(iSc);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        addView(this.zY, layoutParams);
        this.pFF = new ImageView(this.f26711sc);
        ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.We.Qj.sc(this.f26711sc, 78.0f), (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(this.f26711sc, 78.0f));
        this.pFF.setImageResource(com.bytedance.sdk.component.utils.Sfl.We(this.f26711sc, "tt_splash_hand"));
        addView(this.pFF, layoutParams2);
        TextView textView = new TextView(this.f26711sc);
        this.TRI = textView;
        textView.setTextColor(-1);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 81;
        layoutParams3.bottomMargin = (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(this.f26711sc, 10.0f);
        addView(this.TRI, layoutParams3);
        this.TRI.setVisibility(8);
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

    public void setGuideText(String str) {
        this.TRI.setVisibility(0);
        this.TRI.setText(str);
    }

    public void setGuideTextColor(int i11) {
        this.TRI.setTextColor(i11);
    }
}
