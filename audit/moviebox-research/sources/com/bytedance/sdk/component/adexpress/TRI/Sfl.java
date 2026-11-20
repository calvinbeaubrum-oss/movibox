package com.bytedance.sdk.component.adexpress.TRI;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Sfl extends LinearLayout {
    private TextView ExN;
    private int Ol;
    private LinearLayout Qj;
    private TextView TRI;
    private JSONObject Tf;
    private int UFX;
    private int WH;
    private com.bytedance.sdk.component.utils.YIK We;
    private TextView pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private sc f26682qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private TextView f26683sc;
    private ImageView zY;

    /* JADX INFO: renamed from: com.bytedance.sdk.component.adexpress.TRI.Sfl$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Sfl.this.zY != null) {
                final RotateAnimation rotateAnimation = new RotateAnimation(-14.0f, 14.0f, 1, 0.9f, 1, 0.9f);
                rotateAnimation.setInterpolator(new pFF(null));
                rotateAnimation.setDuration(1000L);
                rotateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.bytedance.sdk.component.adexpress.TRI.Sfl.1.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        Sfl.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.TRI.Sfl.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Sfl.this.zY.startAnimation(rotateAnimation);
                            }
                        }, 250L);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }
                });
                Sfl.this.zY.startAnimation(rotateAnimation);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class pFF implements Interpolator {
        private pFF() {
        }

        public /* synthetic */ pFF(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f11) {
            if (f11 <= 0.25f) {
                return (f11 * (-2.0f)) + 0.5f;
            }
            if (f11 <= 0.5f) {
                return (f11 * 4.0f) - 1.0f;
            }
            return f11 <= 0.75f ? (f11 * (-4.0f)) + 3.0f : (f11 * 2.0f) - 1.5f;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface sc {
    }

    public Sfl(@NonNull Context context, View view, int i11, int i12, int i13, JSONObject jSONObject) {
        super(context);
        this.Ol = i11;
        this.WH = i12;
        this.UFX = i13;
        this.Tf = jSONObject;
        sc(context, view);
    }

    public LinearLayout getShakeLayout() {
        return this.Qj;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isShown()) {
            if (this.We == null) {
                this.We = new com.bytedance.sdk.component.utils.YIK(getContext().getApplicationContext(), 1);
            }
            new Object() { // from class: com.bytedance.sdk.component.adexpress.TRI.Sfl.2
            };
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z11) {
    }

    public void sc() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(300L);
        objectAnimatorOfFloat.start();
        postDelayed(new AnonymousClass1(), 500L);
    }

    public void sc(Context context, View view) {
        addView(view);
        this.Qj = (LinearLayout) findViewById(2097610727);
        this.zY = (ImageView) findViewById(2097610725);
        this.f26683sc = (TextView) findViewById(2097610724);
        this.pFF = (TextView) findViewById(2097610726);
        this.ExN = (TextView) findViewById(2097610723);
        this.TRI = (TextView) findViewById(2097610728);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(Color.parseColor("#57000000"));
        this.Qj.setBackground(gradientDrawable);
    }

    public void setOnShakeViewListener(sc scVar) {
        this.f26682qr = scVar;
    }

    public void setShakeText(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.ExN.setText(str);
        } else {
            this.ExN.setVisibility(8);
            this.TRI.setVisibility(8);
        }
    }
}
