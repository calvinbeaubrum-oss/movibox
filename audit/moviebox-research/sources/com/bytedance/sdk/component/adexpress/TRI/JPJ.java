package com.bytedance.sdk.component.adexpress.TRI;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.PathInterpolator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class JPJ extends View {
    private static int zY = 50;
    private ObjectAnimator We;
    private int pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private Paint f26671sc;

    public JPJ(Context context) {
        this(context, null);
    }

    public JPJ(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public JPJ(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.pFF = 10;
        zY();
    }

    private void zY() {
        Paint paint = new Paint();
        this.f26671sc = paint;
        paint.setAntiAlias(true);
        this.f26671sc.setColor(Color.parseColor("#FFFFFFFF"));
        this.f26671sc.setStyle(Paint.Style.STROKE);
        this.f26671sc.setStrokeWidth(18.0f);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f);
        this.We = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(200L);
    }

    @Override // android.view.View
    public void invalidate() {
        if (hasWindowFocus()) {
            super.invalidate();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        this.f26671sc.setShader(new LinearGradient(getMeasuredWidth() / 2, 0.0f, getMeasuredWidth() / 2, getMeasuredHeight(), -1, 16777215, Shader.TileMode.CLAMP));
        canvas.drawCircle(getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f, this.pFF, this.f26671sc);
    }

    public void pFF() {
        clearAnimation();
    }

    public void sc() {
        int iMin = ((int) Math.min(getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f)) - 18;
        zY = iMin;
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(10, iMin);
        valueAnimatorOfInt.setInterpolator(new PathInterpolator(0.0f, 0.2f, 0.3f, 1.0f));
        valueAnimatorOfInt.setDuration(800L);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.TRI.JPJ.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                JPJ.this.pFF = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                JPJ.this.invalidate();
            }
        });
        valueAnimatorOfInt.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.TRI.JPJ.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                JPJ.this.We.start();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                JPJ.this.setVisibility(0);
                JPJ.this.setAlpha(1.0f);
            }
        });
        valueAnimatorOfInt.start();
    }
}
