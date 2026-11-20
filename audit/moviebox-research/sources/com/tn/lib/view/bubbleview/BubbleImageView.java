package com.tn.lib.view.bubbleview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ImageView;
import com.tn.lib.widget.R$styleable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class BubbleImageView extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BubbleDrawable f49801a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Drawable f49802b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f49803c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f49804d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f49805f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f49806g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Bitmap f49807h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public BubbleDrawable.ArrowLocation f49808i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f49809j;

    public BubbleImageView(Context context) {
        super(context);
        c(null);
    }

    public BubbleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(attributeSet);
    }

    public BubbleImageView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        c(attributeSet);
    }

    public static int dp2px(Context context, int i11) {
        return (int) TypedValue.applyDimension(1, i11, context.getResources().getDisplayMetrics());
    }

    public static Bitmap getBitmapFromDrawable(Context context, Drawable drawable, int i11, int i12, int i13) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            Bitmap bitmapCreateBitmap = (i11 <= 0 || i12 <= 0) ? Bitmap.createBitmap(dp2px(context, i13), dp2px(context, i13), Bitmap.Config.ARGB_8888) : Bitmap.createBitmap(i11, i12, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmapCreateBitmap;
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    public final Bitmap a(Drawable drawable) {
        return getBitmapFromDrawable(getContext(), drawable, getWidth(), getWidth(), 25);
    }

    public final Drawable b(int i11) {
        if (i11 != 0) {
            return getContext().getResources().getDrawable(i11);
        }
        throw new IllegalArgumentException("getDrawable res can not be zero");
    }

    public final void c(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.BubbleView);
            this.f49803c = typedArrayObtainStyledAttributes.getDimension(R$styleable.BubbleView_arrowWidth, BubbleDrawable.b.f49708u);
            this.f49805f = typedArrayObtainStyledAttributes.getDimension(R$styleable.BubbleView_arrowHeight, BubbleDrawable.b.f49709v);
            this.f49804d = typedArrayObtainStyledAttributes.getDimension(R$styleable.BubbleView_angle, BubbleDrawable.b.f49710w);
            this.f49806g = typedArrayObtainStyledAttributes.getDimension(R$styleable.BubbleView_arrowPosition, BubbleDrawable.b.f49711x);
            this.f49808i = BubbleDrawable.ArrowLocation.mapIntToValue(typedArrayObtainStyledAttributes.getInt(R$styleable.BubbleView_arrowLocation, 0));
            this.f49809j = typedArrayObtainStyledAttributes.getBoolean(R$styleable.BubbleView_arrowCenter, false);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public final void d() {
        Drawable drawable;
        Drawable drawable2;
        int width = getWidth();
        int height = getHeight();
        if (width > 0 && height <= 0 && (drawable2 = this.f49802b) != null && drawable2.getIntrinsicWidth() >= 0) {
            height = (width / this.f49802b.getIntrinsicWidth()) * this.f49802b.getIntrinsicHeight();
        }
        if (height > 0 && width <= 0 && (drawable = this.f49802b) != null && drawable.getIntrinsicHeight() >= 0) {
            width = (height / this.f49802b.getIntrinsicHeight()) * this.f49802b.getIntrinsicWidth();
        }
        e(width, height);
    }

    public final void e(int i11, int i12) {
        f(getPaddingLeft(), i11 - getPaddingRight(), getPaddingTop(), i12 - getPaddingBottom());
    }

    public final void f(int i11, int i12, int i13, int i14) {
        if (i12 <= i11 || i14 <= i13) {
            return;
        }
        RectF rectF = new RectF(i11, i13, i12, i14);
        Drawable drawable = this.f49802b;
        if (drawable != null) {
            this.f49807h = a(drawable);
        }
        this.f49801a = new BubbleDrawable.b().B(rectF).t(this.f49808i).q(this.f49804d).s(this.f49805f).v(this.f49803c).z(BubbleDrawable.BubbleType.BITMAP).u(this.f49806g).w(this.f49807h).r(this.f49809j).A();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int saveCount = canvas.getSaveCount();
        canvas.translate(getPaddingLeft(), getPaddingTop());
        BubbleDrawable bubbleDrawable = this.f49801a;
        if (bubbleDrawable != null) {
            bubbleDrawable.draw(canvas);
        }
        canvas.restoreToCount(saveCount);
    }

    @Override // android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        d();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth <= 0 && measuredHeight > 0) {
            setMeasuredDimension(measuredHeight, measuredHeight);
        }
        if (measuredHeight > 0 || measuredWidth <= 0) {
            return;
        }
        setMeasuredDimension(measuredWidth, measuredWidth);
    }

    @Override // android.view.View
    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        if (i11 <= 0 || i12 <= 0) {
            return;
        }
        e(i11, i12);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        this.f49807h = bitmap;
        this.f49802b = new BitmapDrawable(getResources(), bitmap);
        d();
        super.setImageDrawable(this.f49801a);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        this.f49802b = drawable;
        d();
        super.setImageDrawable(this.f49801a);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i11) {
        setImageDrawable(b(i11));
    }
}
