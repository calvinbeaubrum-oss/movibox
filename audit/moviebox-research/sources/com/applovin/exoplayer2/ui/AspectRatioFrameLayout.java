package com.applovin.exoplayer2.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.applovin.sdk.R;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AspectRatioFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f17243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f17244b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f17245c;

    /* JADX INFO: compiled from: source.java */
    public interface b {
    }

    /* JADX INFO: compiled from: source.java */
    public final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float f17246a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f17247b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f17248c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f17249d;

        private c() {
        }

        public void a(float f11, float f12, boolean z11) {
            this.f17246a = f11;
            this.f17247b = f12;
            this.f17248c = z11;
            if (this.f17249d) {
                return;
            }
            this.f17249d = true;
            AspectRatioFrameLayout.this.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f17249d = false;
            AspectRatioFrameLayout.a(AspectRatioFrameLayout.this);
        }
    }

    public AspectRatioFrameLayout(Context context) {
        this(context, null);
    }

    public AspectRatioFrameLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17245c = 0;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.AppLovinAspectRatioFrameLayout, 0, 0);
            try {
                this.f17245c = typedArrayObtainStyledAttributes.getInt(R.styleable.AppLovinAspectRatioFrameLayout_al_resize_mode, 0);
                typedArrayObtainStyledAttributes.recycle();
            } catch (Throwable th2) {
                typedArrayObtainStyledAttributes.recycle();
                throw th2;
            }
        }
        this.f17243a = new c();
    }

    public static /* synthetic */ b a(AspectRatioFrameLayout aspectRatioFrameLayout) {
        aspectRatioFrameLayout.getClass();
        return null;
    }

    public int getResizeMode() {
        return this.f17245c;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i11, int i12) {
        float f11;
        float f12;
        super.onMeasure(i11, i12);
        if (this.f17244b <= 0.0f) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f13 = measuredWidth;
        float f14 = measuredHeight;
        float f15 = f13 / f14;
        float f16 = (this.f17244b / f15) - 1.0f;
        if (Math.abs(f16) <= 0.01f) {
            this.f17243a.a(this.f17244b, f15, false);
            return;
        }
        int i13 = this.f17245c;
        if (i13 != 0) {
            if (i13 != 1) {
                if (i13 == 2) {
                    f11 = this.f17244b;
                } else if (i13 == 4) {
                    if (f16 > 0.0f) {
                        f11 = this.f17244b;
                    } else {
                        f12 = this.f17244b;
                    }
                }
                measuredWidth = (int) (f14 * f11);
            } else {
                f12 = this.f17244b;
            }
            measuredHeight = (int) (f13 / f12);
        } else if (f16 > 0.0f) {
            f12 = this.f17244b;
            measuredHeight = (int) (f13 / f12);
        } else {
            f11 = this.f17244b;
            measuredWidth = (int) (f14 * f11);
        }
        this.f17243a.a(this.f17244b, f15, true);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
    }

    public void setAspectRatio(float f11) {
        if (this.f17244b != f11) {
            this.f17244b = f11;
            requestLayout();
        }
    }

    public void setAspectRatioListener(@Nullable b bVar) {
    }

    public void setResizeMode(int i11) {
        if (this.f17245c != i11) {
            this.f17245c = i11;
            requestLayout();
        }
    }
}
