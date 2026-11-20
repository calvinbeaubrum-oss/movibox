package com.tn.lib.view.indicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import com.tn.lib.widget.R$styleable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class DrawableIndicator extends BaseIndicator {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Bitmap f49898d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Bitmap f49899f;

    public DrawableIndicator(Context context) {
        this(context, null);
    }

    public DrawableIndicator(Context context, int i11, int i12) {
        super(context);
        this.f49898d = BitmapFactory.decodeResource(getResources(), i11);
        this.f49899f = BitmapFactory.decodeResource(getResources(), i12);
    }

    public DrawableIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DrawableIndicator(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.DrawableIndicator);
        if (typedArrayObtainStyledAttributes != null) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) typedArrayObtainStyledAttributes.getDrawable(R$styleable.DrawableIndicator_normal_drawable);
            BitmapDrawable bitmapDrawable2 = (BitmapDrawable) typedArrayObtainStyledAttributes.getDrawable(R$styleable.DrawableIndicator_selected_drawable);
            this.f49898d = bitmapDrawable.getBitmap();
            this.f49899f = bitmapDrawable2.getBitmap();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int iD = this.f49892a.d();
        if (iD <= 1 || this.f49898d == null || this.f49899f == null) {
            return;
        }
        int i11 = 0;
        float width = 0.0f;
        while (i11 < iD) {
            canvas.drawBitmap(this.f49892a.a() == i11 ? this.f49899f : this.f49898d, width, 0.0f, this.f49893b);
            width += this.f49898d.getWidth() + this.f49892a.e();
            i11++;
        }
    }

    @Override // android.view.View
    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        int iD = this.f49892a.d();
        if (iD <= 1) {
            return;
        }
        int i13 = iD - 1;
        setMeasuredDimension((this.f49899f.getWidth() * i13) + this.f49899f.getWidth() + (this.f49892a.e() * i13), Math.max(this.f49898d.getHeight(), this.f49899f.getHeight()));
    }
}
