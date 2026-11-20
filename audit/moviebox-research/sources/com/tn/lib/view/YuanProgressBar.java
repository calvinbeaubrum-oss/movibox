package com.tn.lib.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Looper;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatButton;
import com.tn.lib.widget.R$styleable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class YuanProgressBar extends AppCompatButton {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f49665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f49666b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RectF f49667c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RectF f49668d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f49669f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f49670g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Paint f49671h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f49672i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f49673j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f49674k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f49675l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f49676m;

    public YuanProgressBar(Context context) {
        super(context);
        this.f49669f = 100;
        this.f49670g = 0;
        this.f49673j = Color.parseColor("#99ffffff");
        this.f49674k = Color.parseColor("#ffffff");
        this.f49675l = 0;
        this.f49676m = 0;
        init(context, null);
    }

    public YuanProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f49669f = 100;
        this.f49670g = 0;
        this.f49673j = Color.parseColor("#99ffffff");
        this.f49674k = Color.parseColor("#ffffff");
        this.f49675l = 0;
        this.f49676m = 0;
        init(context, attributeSet);
    }

    public YuanProgressBar(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f49669f = 100;
        this.f49670g = 0;
        this.f49673j = Color.parseColor("#99ffffff");
        this.f49674k = Color.parseColor("#ffffff");
        this.f49675l = 0;
        this.f49676m = 0;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        setWillNotDraw(false);
        Paint paint = new Paint();
        this.f49665a = paint;
        paint.setAntiAlias(true);
        this.f49665a.setColor(Color.parseColor("#2f9ceb"));
        this.f49667c = new RectF();
        this.f49668d = new RectF();
        this.f49665a.setStyle(Paint.Style.STROKE);
        this.f49665a.setStrokeWidth(tp.f.f77260a.a(getContext(), 2.0f));
        this.f49665a.setStrokeCap(Paint.Cap.ROUND);
        setBackground(null);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Base_YuanProgressBar);
            this.f49670g = typedArrayObtainStyledAttributes.getColor(R$styleable.Base_YuanProgressBar_base_insideColor, 0);
            this.f49673j = typedArrayObtainStyledAttributes.getColor(R$styleable.Base_YuanProgressBar_base_circleColor, this.f49673j);
            this.f49674k = typedArrayObtainStyledAttributes.getColor(R$styleable.Base_YuanProgressBar_base_yuan_progressColor, this.f49674k);
            this.f49675l = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.Base_YuanProgressBar_base_yuanCircleStrokeWidth, this.f49675l);
            this.f49676m = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.Base_YuanProgressBar_base_yuanProgressStrokeWidth, this.f49676m);
            Paint paint2 = new Paint();
            this.f49671h = paint2;
            paint2.setAntiAlias(true);
            typedArrayObtainStyledAttributes.recycle();
        }
        setTextSize(2, 12.0f);
    }

    public final void a(Canvas canvas) {
        Paint paint;
        canvas.save();
        if (this.f49672i == 0) {
            this.f49672i = tp.f.f77260a.a(getContext(), 1.0f);
        }
        int i11 = this.f49670g;
        if (i11 != 0 && (paint = this.f49671h) != null) {
            paint.setColor(i11);
            canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, (getWidth() / 2.0f) - this.f49672i, this.f49671h);
        }
        this.f49665a.setColor(this.f49673j);
        if (this.f49675l <= 0) {
            this.f49675l = this.f49672i;
        }
        this.f49665a.setStrokeWidth(this.f49675l);
        canvas.drawArc(this.f49667c, -90.0f, 360.0f, false, this.f49665a);
        this.f49665a.setColor(this.f49674k);
        if (this.f49676m <= 0) {
            this.f49676m = this.f49672i * 3;
        }
        this.f49665a.setStrokeWidth(this.f49676m);
        canvas.drawArc(this.f49667c, -90.0f, (this.f49666b * 360.0f) / this.f49669f, false, this.f49665a);
        canvas.restore();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        a(canvas);
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        RectF rectF = this.f49667c;
        tp.f fVar = tp.f.f77260a;
        rectF.left = fVar.a(getContext(), 2.0f);
        this.f49667c.top = fVar.a(getContext(), 2.0f);
        this.f49667c.right = i11 - fVar.a(getContext(), 2.0f);
        this.f49667c.bottom = i12 - fVar.a(getContext(), 2.0f);
        this.f49668d.left = fVar.a(getContext(), 4.0f);
        this.f49668d.top = fVar.a(getContext(), 4.0f);
        this.f49668d.right = i11 - fVar.a(getContext(), 4.0f);
        this.f49668d.bottom = i12 - fVar.a(getContext(), 4.0f);
    }

    public void setColorNetDetect() {
        this.f49673j = Color.parseColor("#33000000");
        this.f49674k = Color.parseColor("#3ECAF2");
    }

    public void setProgress(float f11) {
        this.f49666b = f11;
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            invalidate();
        } else {
            postInvalidate();
        }
    }
}
