package com.bytedance.sdk.component.adexpress.TRI;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Dl extends FrameLayout {
    private TextView ExN;
    private AnimatorSet Ol;
    private AnimatorSet Qj;
    private AnimatorSet TRI;
    private ImageView We;
    private ImageView pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private AnimatorSet f26662qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private Context f26663sc;
    private ImageView zY;

    public Dl(@NonNull Context context) {
        super(context);
        this.TRI = new AnimatorSet();
        this.f26662qr = new AnimatorSet();
        this.Qj = new AnimatorSet();
        this.Ol = new AnimatorSet();
        this.f26663sc = context;
        zY();
    }

    private void We() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.pFF, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.zY, "scaleX", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.zY, "scaleY", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.We, "alpha", 0.0f, 1.0f);
        this.Qj.setDuration(300L);
        this.Qj.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3, objectAnimatorOfFloat4);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.pFF, "translationX", 0.0f, com.bytedance.sdk.component.adexpress.We.Qj.sc(getContext(), 90.0f));
        objectAnimatorOfFloat5.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(getContext(), 90.0f));
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.TRI.Dl.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Integer num = (Integer) valueAnimator.getAnimatedValue();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) Dl.this.We.getLayoutParams();
                layoutParams.width = num.intValue();
                Dl.this.We.setLayoutParams(layoutParams);
            }
        });
        valueAnimatorOfInt.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(this.zY, "translationX", 0.0f, com.bytedance.sdk.component.adexpress.We.Qj.sc(getContext(), 90.0f));
        objectAnimatorOfFloat6.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        this.Ol.setDuration(1500L);
        this.Ol.playTogether(objectAnimatorOfFloat5, valueAnimatorOfInt, objectAnimatorOfFloat6);
        ObjectAnimator objectAnimatorOfFloat7 = ObjectAnimator.ofFloat(this.pFF, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat8 = ObjectAnimator.ofFloat(this.We, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat9 = ObjectAnimator.ofFloat(this.zY, "alpha", 1.0f, 0.0f);
        this.f26662qr.setDuration(50L);
        this.f26662qr.playTogether(objectAnimatorOfFloat7, objectAnimatorOfFloat8, objectAnimatorOfFloat9);
        this.TRI.playSequentially(this.Qj, this.Ol, this.f26662qr);
    }

    private void zY() {
        ImageView imageView = new ImageView(this.f26663sc);
        this.We = imageView;
        imageView.setBackgroundResource(com.bytedance.sdk.component.utils.Sfl.We(this.f26663sc, "tt_splash_slide_right_bg"));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(0, -2);
        layoutParams.gravity = 48;
        layoutParams.leftMargin = (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(this.f26663sc, 30.0f);
        addView(this.We, layoutParams);
        setClipChildren(false);
        setClipToPadding(false);
        ImageView imageView2 = new ImageView(this.f26663sc);
        this.zY = imageView2;
        imageView2.setImageResource(com.bytedance.sdk.component.utils.Sfl.We(this.f26663sc, "tt_splash_slide_right_circle"));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.We.Qj.sc(this.f26663sc, 50.0f), (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(this.f26663sc, 50.0f));
        layoutParams2.gravity = 48;
        layoutParams2.leftMargin = (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(this.f26663sc, 30.0f);
        addView(this.zY, layoutParams2);
        ImageView imageView3 = new ImageView(this.f26663sc);
        this.pFF = imageView3;
        imageView3.setImageResource(com.bytedance.sdk.component.utils.Sfl.We(this.f26663sc, "tt_splash_hand2"));
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.We.Qj.sc(this.f26663sc, 80.0f), (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(this.f26663sc, 80.0f));
        layoutParams3.gravity = 48;
        layoutParams3.leftMargin = (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(this.f26663sc, 30.0f);
        addView(this.pFF, layoutParams3);
        TextView textView = new TextView(this.f26663sc);
        this.ExN = textView;
        textView.setTextColor(-1);
        this.ExN.setSingleLine();
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 80;
        addView(this.ExN, layoutParams4);
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.TRI.Dl.1
            @Override // java.lang.Runnable
            public void run() {
                FrameLayout.LayoutParams layoutParams5 = (FrameLayout.LayoutParams) Dl.this.pFF.getLayoutParams();
                layoutParams5.topMargin = (int) ((Dl.this.zY.getMeasuredHeight() / 2.0f) - com.bytedance.sdk.component.adexpress.We.Qj.sc(Dl.this.getContext(), 7.0f));
                int iSc = (-Dl.this.zY.getMeasuredWidth()) + ((int) com.bytedance.sdk.component.adexpress.We.Qj.sc(Dl.this.f26663sc, 30.0f));
                layoutParams5.leftMargin = iSc;
                layoutParams5.setMarginStart(iSc);
                layoutParams5.setMarginEnd(layoutParams5.rightMargin);
                Dl.this.pFF.setLayoutParams(layoutParams5);
                FrameLayout.LayoutParams layoutParams6 = (FrameLayout.LayoutParams) Dl.this.We.getLayoutParams();
                layoutParams6.topMargin = (int) ((Dl.this.zY.getMeasuredHeight() / 2.0f) - com.bytedance.sdk.component.adexpress.We.Qj.sc(Dl.this.getContext(), 5.0f));
                layoutParams6.leftMargin = (int) ((Dl.this.zY.getMeasuredWidth() / 2.0f) + ((int) com.bytedance.sdk.component.adexpress.We.Qj.sc(Dl.this.f26663sc, 30.0f)));
                layoutParams5.setMarginStart(layoutParams5.leftMargin);
                layoutParams5.setMarginEnd(layoutParams5.rightMargin);
                Dl.this.We.setLayoutParams(layoutParams6);
            }
        });
    }

    @Override // android.view.View
    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
    }

    public void pFF() {
        try {
            AnimatorSet animatorSet = this.TRI;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            AnimatorSet animatorSet2 = this.Qj;
            if (animatorSet2 != null) {
                animatorSet2.cancel();
            }
            AnimatorSet animatorSet3 = this.Ol;
            if (animatorSet3 != null) {
                animatorSet3.cancel();
            }
            AnimatorSet animatorSet4 = this.f26662qr;
            if (animatorSet4 != null) {
                animatorSet4.cancel();
            }
        } catch (Throwable unused) {
        }
    }

    public void sc() {
        We();
        this.TRI.start();
        this.TRI.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.component.adexpress.TRI.Dl.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                Dl.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.TRI.Dl.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Dl.this.TRI.start();
                    }
                }, 200L);
            }
        });
    }

    public void setGuideText(String str) {
        this.ExN.setText(str);
    }
}
