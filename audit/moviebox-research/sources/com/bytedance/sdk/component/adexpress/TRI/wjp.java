package com.bytedance.sdk.component.adexpress.TRI;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.view.animation.LinearInterpolator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class wjp extends View {
    private Paint ExN;
    private Animator.AnimatorListener Ol;
    private float Qj;
    private long TRI;
    private int WH;
    private ValueAnimator We;
    private float pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private float f26726qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private float f26727sc;
    private ValueAnimator zY;

    public wjp(Context context, int i11) {
        super(context);
        this.TRI = 300L;
        this.f26726qr = 0.0f;
        this.WH = i11;
        sc();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(this.f26727sc, this.pFF, this.f26726qr, this.ExN);
    }

    @Override // android.view.View
    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        this.f26727sc = i11 / 2.0f;
        this.pFF = i12 / 2.0f;
        this.Qj = (float) (Math.hypot(i11, i12) / 2.0d);
    }

    public void pFF() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, this.Qj);
        this.zY = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(this.TRI);
        this.zY.setInterpolator(new LinearInterpolator());
        this.zY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.TRI.wjp.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                wjp.this.f26726qr = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                wjp.this.invalidate();
            }
        });
        this.zY.start();
    }

    public void sc() {
        Paint paint = new Paint(1);
        this.ExN = paint;
        paint.setStyle(Paint.Style.FILL);
        this.ExN.setColor(this.WH);
    }

    public void setAnimationListener(Animator.AnimatorListener animatorListener) {
        this.Ol = animatorListener;
    }

    public void zY() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.Qj, 0.0f);
        this.We = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(this.TRI);
        this.We.setInterpolator(new LinearInterpolator());
        this.We.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.TRI.wjp.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                wjp.this.f26726qr = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                wjp.this.invalidate();
            }
        });
        Animator.AnimatorListener animatorListener = this.Ol;
        if (animatorListener != null) {
            this.We.addListener(animatorListener);
        }
        this.We.start();
    }
}
