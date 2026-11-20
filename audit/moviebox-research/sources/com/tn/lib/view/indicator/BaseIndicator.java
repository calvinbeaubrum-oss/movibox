package com.tn.lib.view.indicator;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.card.MaterialCardView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class BaseIndicator extends View implements wp.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f49892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Paint f49893b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f49894c;

    public BaseIndicator(Context context) {
        this(context, null);
    }

    public BaseIndicator(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BaseIndicator(Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f49892a = new a();
        Paint paint = new Paint();
        this.f49893b = paint;
        paint.setAntiAlias(true);
        this.f49893b.setColor(0);
        this.f49893b.setColor(this.f49892a.g());
    }

    @Override // wp.a
    public a getIndicatorConfig() {
        return this.f49892a;
    }

    @Override // wp.a
    @NonNull
    public View getIndicatorView() {
        if (this.f49892a.l()) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            int iB = this.f49892a.b();
            if (iB == 0) {
                layoutParams.gravity = MaterialCardView.CHECKED_ICON_GRAVITY_BOTTOM_START;
            } else if (iB == 1) {
                layoutParams.gravity = 81;
            } else if (iB == 2) {
                layoutParams.gravity = MaterialCardView.CHECKED_ICON_GRAVITY_BOTTOM_END;
            }
            layoutParams.leftMargin = this.f49892a.f().f49919a;
            layoutParams.rightMargin = this.f49892a.f().f49921c;
            layoutParams.topMargin = this.f49892a.f().f49920b;
            layoutParams.bottomMargin = this.f49892a.f().f49922d;
            setLayoutParams(layoutParams);
        }
        return this;
    }

    @Override // wp.a
    public void onPageChanged(int i11, int i12) {
        this.f49892a.q(i11);
        this.f49892a.n(i12);
        requestLayout();
    }

    @Override // wp.c
    public void onPageScrollStateChanged(int i11) {
    }

    @Override // wp.c
    public void onPageScrolled(int i11, float f11, int i12) {
        this.f49894c = f11;
        invalidate();
    }

    @Override // wp.c
    public void onPageSelected(int i11) {
        this.f49892a.n(i11);
        invalidate();
    }
}
