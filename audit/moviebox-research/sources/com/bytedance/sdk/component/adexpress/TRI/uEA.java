package com.bytedance.sdk.component.adexpress.TRI;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class uEA extends RelativeLayout {
    private TextView ExN;
    private AnimatorSet Ol;
    private AnimatorSet Qj;
    private AnimatorSet TRI;
    private int UFX;
    private String WH;
    private TextView We;
    private ImageView pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private AnimatorSet f26721qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private ImageView f26722sc;
    private ImageView zY;

    public uEA(Context context) {
        super(context);
        this.TRI = new AnimatorSet();
        this.f26721qr = new AnimatorSet();
        this.Qj = new AnimatorSet();
        this.Ol = new AnimatorSet();
        this.UFX = 100;
        sc(context);
    }

    public uEA(Context context, String str) {
        super(context);
        this.TRI = new AnimatorSet();
        this.f26721qr = new AnimatorSet();
        this.Qj = new AnimatorSet();
        this.Ol = new AnimatorSet();
        this.UFX = 100;
        setClipChildren(false);
        this.WH = str;
        sc(context);
    }

    public AnimatorSet getSlideUpAnimatorSet() {
        return this.TRI;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        pFF();
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
            AnimatorSet animatorSet3 = this.f26721qr;
            if (animatorSet3 != null) {
                animatorSet3.cancel();
            }
            AnimatorSet animatorSet4 = this.Ol;
            if (animatorSet4 != null) {
                animatorSet4.cancel();
            }
        } catch (Exception e11) {
            com.bytedance.sdk.component.utils.Tf.pFF(e11.getMessage());
        }
    }

    public void sc() {
        zY();
        this.TRI.start();
        this.TRI.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.component.adexpress.TRI.uEA.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                uEA.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.TRI.uEA.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        uEA.this.TRI.start();
                    }
                }, 200L);
            }
        });
    }

    public void sc(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.We.sc();
        }
        if ("5".equals(this.WH)) {
            addView(com.bytedance.sdk.component.adexpress.zY.sc.TRI(context));
            this.UFX = (int) (((double) this.UFX) * 1.25d);
        } else {
            addView(com.bytedance.sdk.component.adexpress.zY.sc.ExN(context));
        }
        this.f26722sc = (ImageView) findViewById(2097610734);
        this.pFF = (ImageView) findViewById(2097610735);
        this.We = (TextView) findViewById(2097610730);
        this.zY = (ImageView) findViewById(2097610733);
        this.ExN = (TextView) findViewById(2097610731);
    }

    public void setGuideText(String str) {
        TextView textView = this.We;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setSlideText(String str) {
        if (this.ExN != null) {
            if (TextUtils.isEmpty(str)) {
                this.ExN.setText("");
            } else {
                this.ExN.setText(str);
            }
        }
    }

    public void zY() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f26722sc, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f26722sc, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.f26722sc, "translationY", 0.0f, com.bytedance.sdk.component.adexpress.We.Qj.sc(getContext(), -this.UFX));
        objectAnimatorOfFloat3.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(getContext(), this.UFX));
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.TRI.uEA.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (uEA.this.zY != null) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) uEA.this.zY.getLayoutParams();
                    layoutParams.height = num.intValue();
                    uEA.this.zY.setLayoutParams(layoutParams);
                }
            }
        });
        valueAnimatorOfInt.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.zY, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.zY, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(this.pFF, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat7 = ObjectAnimator.ofFloat(this.pFF, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat8 = ObjectAnimator.ofFloat(this.pFF, "scaleX", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat9 = ObjectAnimator.ofFloat(this.pFF, "scaleY", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat10 = ObjectAnimator.ofFloat(this.pFF, "translationY", 0.0f, com.bytedance.sdk.component.adexpress.We.Qj.sc(getContext(), -this.UFX));
        objectAnimatorOfFloat10.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        this.f26721qr.setDuration(50L);
        this.Ol.setDuration(1500L);
        this.Qj.setDuration(50L);
        this.f26721qr.playTogether(objectAnimatorOfFloat2, objectAnimatorOfFloat7, objectAnimatorOfFloat5);
        this.Qj.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat6, objectAnimatorOfFloat8, objectAnimatorOfFloat9, objectAnimatorOfFloat4);
        this.Ol.playTogether(objectAnimatorOfFloat3, valueAnimatorOfInt, objectAnimatorOfFloat10);
        this.TRI.playSequentially(this.Qj, this.Ol, this.f26721qr);
    }
}
