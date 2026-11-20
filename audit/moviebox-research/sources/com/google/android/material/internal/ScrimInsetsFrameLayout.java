package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class ScrimInsetsFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public Drawable f36944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Rect f36945b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Rect f36946c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f36947d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f36948f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f36949g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f36950h;

    /* JADX INFO: compiled from: source.java */
    public class a implements OnApplyWindowInsetsListener {
        public a() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, @NonNull WindowInsetsCompat windowInsetsCompat) {
            ScrimInsetsFrameLayout scrimInsetsFrameLayout = ScrimInsetsFrameLayout.this;
            if (scrimInsetsFrameLayout.f36945b == null) {
                scrimInsetsFrameLayout.f36945b = new Rect();
            }
            ScrimInsetsFrameLayout.this.f36945b.set(windowInsetsCompat.getSystemWindowInsetLeft(), windowInsetsCompat.getSystemWindowInsetTop(), windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
            ScrimInsetsFrameLayout.this.a(windowInsetsCompat);
            ScrimInsetsFrameLayout.this.setWillNotDraw(!windowInsetsCompat.hasSystemWindowInsets() || ScrimInsetsFrameLayout.this.f36944a == null);
            ViewCompat.postInvalidateOnAnimation(ScrimInsetsFrameLayout.this);
            return windowInsetsCompat.consumeSystemWindowInsets();
        }
    }

    public ScrimInsetsFrameLayout(@NonNull Context context) {
        this(context, null);
    }

    public ScrimInsetsFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScrimInsetsFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f36946c = new Rect();
        this.f36947d = true;
        this.f36948f = true;
        this.f36949g = true;
        this.f36950h = true;
        TypedArray typedArrayI = b0.i(context, attributeSet, R$styleable.ScrimInsetsFrameLayout, i11, R$style.Widget_Design_ScrimInsetsFrameLayout, new int[0]);
        this.f36944a = typedArrayI.getDrawable(R$styleable.ScrimInsetsFrameLayout_insetForeground);
        typedArrayI.recycle();
        setWillNotDraw(true);
        ViewCompat.setOnApplyWindowInsetsListener(this, new a());
    }

    public void a(WindowInsetsCompat windowInsetsCompat) {
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.f36945b == null || this.f36944a == null) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(getScrollX(), getScrollY());
        if (this.f36947d) {
            this.f36946c.set(0, 0, width, this.f36945b.top);
            this.f36944a.setBounds(this.f36946c);
            this.f36944a.draw(canvas);
        }
        if (this.f36948f) {
            this.f36946c.set(0, height - this.f36945b.bottom, width, height);
            this.f36944a.setBounds(this.f36946c);
            this.f36944a.draw(canvas);
        }
        if (this.f36949g) {
            Rect rect = this.f36946c;
            Rect rect2 = this.f36945b;
            rect.set(0, rect2.top, rect2.left, height - rect2.bottom);
            this.f36944a.setBounds(this.f36946c);
            this.f36944a.draw(canvas);
        }
        if (this.f36950h) {
            Rect rect3 = this.f36946c;
            Rect rect4 = this.f36945b;
            rect3.set(width - rect4.right, rect4.top, width, height - rect4.bottom);
            this.f36944a.setBounds(this.f36946c);
            this.f36944a.draw(canvas);
        }
        canvas.restoreToCount(iSave);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable drawable = this.f36944a;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable drawable = this.f36944a;
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public void setDrawBottomInsetForeground(boolean z11) {
        this.f36948f = z11;
    }

    public void setDrawLeftInsetForeground(boolean z11) {
        this.f36949g = z11;
    }

    public void setDrawRightInsetForeground(boolean z11) {
        this.f36950h = z11;
    }

    public void setDrawTopInsetForeground(boolean z11) {
        this.f36947d = z11;
    }

    public void setScrimInsetForeground(@Nullable Drawable drawable) {
        this.f36944a = drawable;
    }
}
