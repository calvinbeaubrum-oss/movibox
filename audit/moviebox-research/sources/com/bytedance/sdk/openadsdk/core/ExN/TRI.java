package com.bytedance.sdk.openadsdk.core.ExN;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RotateDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class TRI extends FrameLayout {
    private Drawable ExN;
    private boolean Qj;
    private boolean TRI;
    private Drawable We;
    private int pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private ValueAnimator f28004qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private int f28005sc;
    private Drawable zY;

    public TRI(Context context) {
        super(context);
        this.f28005sc = 100;
    }

    public TRI(Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f28005sc = 100;
    }

    private void sc() {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, 10000);
        this.f28004qr = valueAnimatorOfInt;
        valueAnimatorOfInt.setDuration(AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
        this.f28004qr.setRepeatCount(-1);
        this.f28004qr.setInterpolator(new LinearInterpolator());
        this.f28004qr.setRepeatMode(1);
        this.f28004qr.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.ExN.TRI.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                TRI.this.setProgress(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        this.f28004qr.start();
        setMax(10000);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.TRI = true;
        if (this.ExN != null) {
            sc();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.TRI = false;
        ValueAnimator valueAnimator = this.f28004qr;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f28004qr.removeAllUpdateListeners();
            this.f28004qr = null;
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i11) {
        super.onVisibilityChanged(view, i11);
        if (i11 != 0) {
            ValueAnimator valueAnimator = this.f28004qr;
            if (valueAnimator == null || this.Qj) {
                return;
            }
            this.Qj = true;
            valueAnimator.pause();
            return;
        }
        if (this.Qj) {
            this.Qj = false;
            ValueAnimator valueAnimator2 = this.f28004qr;
            if (valueAnimator2 != null) {
                valueAnimator2.resume();
            } else {
                sc();
            }
        }
    }

    public void setIndeterminateDrawable(Drawable drawable) {
        this.ExN = drawable;
        setProgressDrawable(drawable);
        if (this.TRI && this.f28004qr == null) {
            sc();
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(Ol.sc(this, layoutParams));
    }

    public void setMax(int i11) {
        this.f28005sc = i11;
    }

    @Override // android.view.View
    public void setPadding(int i11, int i12, int i13, int i14) {
        super.setPaddingRelative(i11, i12, i13, i14);
    }

    public void setProgress(int i11) {
        this.pFF = i11;
        Drawable drawable = this.zY;
        if (drawable != null) {
            drawable.setLevel((int) ((i11 * 10000.0f) / this.f28005sc));
        }
    }

    public void setProgressDrawable(Drawable drawable) {
        this.We = drawable;
        setBackground(drawable);
        Drawable drawable2 = this.We;
        if (drawable2 instanceof LayerDrawable) {
            int numberOfLayers = ((LayerDrawable) drawable2).getNumberOfLayers();
            for (int i11 = 0; i11 < numberOfLayers; i11++) {
                Drawable drawable3 = ((LayerDrawable) this.We).getDrawable(i11);
                if ((drawable3 instanceof ScaleDrawable) || (drawable3 instanceof ClipDrawable)) {
                    this.zY = drawable3;
                }
            }
        }
        Drawable drawable4 = this.We;
        if (drawable4 instanceof RotateDrawable) {
            this.zY = drawable4;
        }
    }
}
