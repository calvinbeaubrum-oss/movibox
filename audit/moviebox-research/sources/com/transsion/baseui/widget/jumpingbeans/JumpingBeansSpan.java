package com.transsion.baseui.widget.jumpingbeans;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.text.TextPaint;
import android.text.style.SuperscriptSpan;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
final class JumpingBeansSpan extends SuperscriptSpan implements ValueAnimator.AnimatorUpdateListener {
    private final float animatedRange;
    private final int delay;
    private ValueAnimator jumpAnimator;
    private final int loopDuration;
    private int shift;
    private final WeakReference<TextView> textView;

    /* JADX INFO: compiled from: source.java */
    public static class a implements TimeInterpolator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f51529a;

        public a(float f11) {
            this.f51529a = Math.abs(f11);
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f11) {
            float f12 = this.f51529a;
            if (f11 > f12) {
                return 0.0f;
            }
            return (float) Math.sin(((double) (f11 / f12)) * 3.141592653589793d);
        }
    }

    public JumpingBeansSpan(@NonNull TextView textView, int i11, int i12, int i13, float f11) {
        this.textView = new WeakReference<>(textView);
        this.delay = i13 * i12;
        this.loopDuration = i11;
        this.animatedRange = f11;
    }

    public static boolean e(View view) {
        return view.isAttachedToWindow();
    }

    public final void c() {
        f();
        Log.w("JumpingBeans", "!!! Remember to call JumpingBeans.stopJumping() when appropriate !!!");
    }

    public final void d(float f11) {
        if (this.jumpAnimator != null) {
            return;
        }
        this.shift = 0;
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, ((int) f11) / 2);
        this.jumpAnimator = valueAnimatorOfInt;
        valueAnimatorOfInt.setDuration(this.loopDuration).setStartDelay(this.delay);
        this.jumpAnimator.setInterpolator(new a(this.animatedRange));
        this.jumpAnimator.setRepeatCount(-1);
        this.jumpAnimator.setRepeatMode(1);
        this.jumpAnimator.addUpdateListener(this);
        this.jumpAnimator.start();
    }

    public void f() {
        ValueAnimator valueAnimator = this.jumpAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.jumpAnimator.removeAllListeners();
        }
        if (this.textView.get() != null) {
            this.textView.clear();
        }
    }

    public final void g(ValueAnimator valueAnimator, TextView textView) {
        if (e(textView)) {
            this.shift = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            textView.invalidate();
        }
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        TextView textView = this.textView.get();
        if (textView != null) {
            g(valueAnimator, textView);
        } else {
            c();
        }
    }

    @Override // android.text.style.SuperscriptSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        d(textPaint.ascent());
        textPaint.baselineShift = this.shift;
    }

    @Override // android.text.style.SuperscriptSpan, android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        d(textPaint.ascent());
        textPaint.baselineShift = this.shift;
    }
}
