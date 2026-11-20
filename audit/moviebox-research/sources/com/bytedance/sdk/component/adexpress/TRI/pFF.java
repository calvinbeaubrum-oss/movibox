package com.bytedance.sdk.component.adexpress.TRI;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class pFF extends FrameLayout {
    private View ExN;
    private int Ol;
    private int Qj;
    private View TRI;
    private Context WH;
    private View We;
    private ObjectAnimator pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private ImageView f26714qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private AnimatorSet f26715sc;
    private boolean zY;

    public pFF(Context context, int i11, int i12) {
        super(context);
        this.zY = false;
        this.f26715sc = new AnimatorSet();
        this.Qj = i11;
        this.Ol = i12;
        this.WH = context;
        zY();
        We();
    }

    private void We() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.We, "scaleX", 1.0f, 2.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.We, "scaleY", 1.0f, 2.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.ExN, "scaleX", 1.0f, 2.5f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.ExN, "scaleY", 1.0f, 2.5f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.TRI, "scaleX", 1.0f, 1.5f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(this.TRI, "scaleY", 1.0f, 1.5f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat7 = ObjectAnimator.ofFloat(this.f26714qr, "rotation", 0.0f, -20.0f, 0.0f);
        this.pFF = objectAnimatorOfFloat7;
        objectAnimatorOfFloat7.setDuration(1000L);
        this.f26715sc.setDuration(1500L);
        this.f26715sc.setInterpolator(new AccelerateDecelerateInterpolator());
        this.f26715sc.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2).with(objectAnimatorOfFloat3).with(objectAnimatorOfFloat4).with(objectAnimatorOfFloat5).with(objectAnimatorOfFloat6);
        this.f26715sc.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.TRI.pFF.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                pFF.this.zY = true;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (pFF.this.zY) {
                    return;
                }
                pFF.this.pFF.start();
                pFF.this.f26715sc.start();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
    }

    private GradientDrawable sc(String str, String str2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(Color.parseColor(str));
        gradientDrawable.setStroke(1, Color.parseColor(str2));
        return gradientDrawable;
    }

    private void zY() {
        View view = new View(this.WH);
        this.We = view;
        view.setBackground(sc("#1A7BBEFF", "#337BBEFF"));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (((double) this.Qj) * 0.45d), (int) (((double) this.Ol) * 0.45d));
        layoutParams.gravity = 17;
        this.We.setLayoutParams(layoutParams);
        addView(this.We);
        View view2 = new View(this.WH);
        this.ExN = view2;
        view2.setBackground(sc("#337BBEFF", "#807BBEFF"));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) (((double) this.Qj) * 0.25d), (int) (((double) this.Ol) * 0.25d));
        layoutParams2.gravity = 17;
        this.ExN.setLayoutParams(layoutParams2);
        addView(this.ExN);
        View view3 = new View(this.WH);
        this.TRI = view3;
        view3.setBackground(sc("#807BBEFF", "#FF7BBEFF"));
        int i11 = this.Qj;
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams((int) (((double) i11) * 0.25d), (int) (((double) i11) * 0.25d));
        layoutParams3.gravity = 17;
        this.TRI.setLayoutParams(layoutParams3);
        addView(this.TRI);
        ImageView imageView = new ImageView(this.WH);
        this.f26714qr = imageView;
        imageView.setImageResource(com.bytedance.sdk.component.utils.Sfl.We(getContext(), "tt_blue_hand"));
        this.f26714qr.setScaleType(ImageView.ScaleType.FIT_CENTER);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams((int) (((double) this.Qj) * 0.62d), (int) (((double) this.Ol) * 0.53d));
        layoutParams4.gravity = 17;
        layoutParams4.topMargin = (layoutParams4.width / 2) - 5;
        layoutParams4.leftMargin = (layoutParams4.height / 2) - 5;
        this.f26714qr.setLayoutParams(layoutParams4);
        addView(this.f26714qr);
    }

    public void pFF() {
        this.zY = true;
        ObjectAnimator objectAnimator = this.pFF;
        if (objectAnimator == null || this.f26715sc == null) {
            return;
        }
        objectAnimator.cancel();
        this.f26715sc.cancel();
    }

    public void sc() {
        this.zY = false;
        ObjectAnimator objectAnimator = this.pFF;
        if (objectAnimator == null || this.f26715sc == null) {
            return;
        }
        objectAnimator.start();
        this.f26715sc.start();
    }
}
