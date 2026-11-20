package com.transsion.ad.hi;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.transsion.ad.R$styleable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class MaskLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Drawable f50403a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Paint f50404b;

    public MaskLayout(@NonNull Context context) {
        this(context, null);
    }

    public MaskLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.MaskLayout);
        this.f50403a = typedArrayObtainStyledAttributes.getDrawable(R$styleable.MaskLayout_xhg_mask_drawable);
        typedArrayObtainStyledAttributes.recycle();
        Paint paint = new Paint(1);
        this.f50404b = paint;
        paint.setFilterBitmap(true);
        this.f50404b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        setWillNotDraw(false);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.f50403a == null) {
            super.draw(canvas);
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 26) {
            canvas.saveLayer(0.0f, 0.0f, measuredWidth, measuredHeight, null);
        } else {
            canvas.saveLayer(0.0f, 0.0f, measuredWidth, measuredHeight, null, 31);
        }
        this.f50403a.setBounds(getPaddingLeft(), getPaddingTop(), measuredWidth - getPaddingRight(), measuredHeight - getPaddingBottom());
        this.f50403a.draw(canvas);
        if (i11 >= 26) {
            canvas.saveLayer(0.0f, 0.0f, measuredWidth, measuredHeight, this.f50404b);
        } else {
            canvas.saveLayer(0.0f, 0.0f, measuredWidth, measuredHeight, this.f50404b, 31);
        }
        super.draw(canvas);
        canvas.restore();
        canvas.restore();
    }
}
