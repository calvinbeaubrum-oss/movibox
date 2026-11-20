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
public class SR extends FrameLayout {
    private boolean ExN;
    private TextView TRI;
    private AnimatorSet We;
    private ImageView pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private Context f26679sc;
    private We zY;

    public SR(@NonNull Context context) {
        super(context);
        this.ExN = true;
        this.f26679sc = context;
        this.We = new AnimatorSet();
        zY();
        We();
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.TRI.SR.1
            @Override // java.lang.Runnable
            public void run() {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) SR.this.pFF.getLayoutParams();
                layoutParams.topMargin = ((int) ((SR.this.zY.getMeasuredHeight() / 2.0f) - com.bytedance.sdk.component.adexpress.We.Qj.sc(SR.this.getContext(), 5.0f))) + ((int) com.bytedance.sdk.component.adexpress.We.Qj.sc(SR.this.f26679sc, 20.0f));
                layoutParams.leftMargin = ((int) ((SR.this.zY.getMeasuredWidth() / 2.0f) - com.bytedance.sdk.component.adexpress.We.Qj.sc(SR.this.getContext(), 5.0f))) + ((int) com.bytedance.sdk.component.adexpress.We.Qj.sc(SR.this.f26679sc, 20.0f));
                layoutParams.bottomMargin = (int) (((-SR.this.zY.getMeasuredHeight()) / 2.0f) + com.bytedance.sdk.component.adexpress.We.Qj.sc(SR.this.getContext(), 5.0f));
                layoutParams.rightMargin = (int) (((-SR.this.zY.getMeasuredWidth()) / 2.0f) + com.bytedance.sdk.component.adexpress.We.Qj.sc(SR.this.getContext(), 5.0f));
                layoutParams.setMarginStart(layoutParams.leftMargin);
                layoutParams.setMarginEnd(layoutParams.rightMargin);
                SR.this.pFF.setLayoutParams(layoutParams);
            }
        });
    }

    private void We() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.pFF, "scaleX", 1.0f, 0.8f);
        objectAnimatorOfFloat.setDuration(1000L);
        objectAnimatorOfFloat.setRepeatMode(2);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.TRI.SR.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                if (SR.this.ExN) {
                    SR.this.zY.sc();
                    SR.this.zY.setAlpha(1.0f);
                } else {
                    SR.this.zY.pFF();
                    SR.this.zY.setAlpha(0.0f);
                }
                SR sr2 = SR.this;
                sr2.ExN = !sr2.ExN;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(SR.this.pFF, "alpha", 0.0f, 1.0f);
                objectAnimatorOfFloat2.setDuration(200L);
                objectAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
                objectAnimatorOfFloat2.start();
                SR.this.pFF.setVisibility(0);
            }
        });
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.pFF, "scaleY", 1.0f, 0.8f);
        objectAnimatorOfFloat2.setDuration(1000L);
        objectAnimatorOfFloat2.setRepeatMode(2);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        this.We.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
    }

    private void zY() {
        this.zY = new We(this.f26679sc);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.We.Qj.sc(this.f26679sc, 80.0f), (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(this.f26679sc, 80.0f));
        layoutParams.gravity = MaterialCardView.CHECKED_ICON_GRAVITY_TOP_START;
        layoutParams.topMargin = (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(this.f26679sc, 20.0f);
        int iSc = (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(this.f26679sc, 20.0f);
        layoutParams.leftMargin = iSc;
        layoutParams.setMarginStart(iSc);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        addView(this.zY, layoutParams);
        this.zY.sc();
        this.pFF = new ImageView(this.f26679sc);
        ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.We.Qj.sc(this.f26679sc, 80.0f), (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(this.f26679sc, 80.0f));
        this.pFF.setImageResource(com.bytedance.sdk.component.utils.Sfl.We(this.f26679sc, "tt_splash_hand"));
        addView(this.pFF, layoutParams2);
        TextView textView = new TextView(this.f26679sc);
        this.TRI = textView;
        textView.setTextColor(-1);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 81;
        layoutParams3.bottomMargin = (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(this.f26679sc, 10.0f);
        addView(this.TRI, layoutParams3);
    }

    public void pFF() {
        AnimatorSet animatorSet = this.We;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        We we2 = this.zY;
        if (we2 != null) {
            we2.pFF();
        }
    }

    public void sc() {
        this.We.start();
    }

    public void setGuideText(String str) {
        this.TRI.setText(str);
    }

    public void setGuideTextColor(int i11) {
        this.TRI.setTextColor(i11);
    }
}
