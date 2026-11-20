package com.applovin.impl;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.app.NotificationCompat;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.applovin.sdk.AppLovinMediationProvider;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class h3 extends View {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final int f19336x = Color.rgb(66, 145, 241);

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final int f19337y = Color.rgb(66, 145, 241);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final int f19338z = Color.rgb(66, 145, 241);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Paint f19339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Paint f19340b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected Paint f19341c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected Paint f19342d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private RectF f19343f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f19344g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f19345h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f19346i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f19347j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f19348k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f19349l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f19350m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f19351n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f19352o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f19353p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float f19354q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f19355r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private float f19356s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final float f19357t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final float f19358u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final float f19359v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final int f19360w;

    /* JADX INFO: compiled from: source.java */
    public static class a {
        /* JADX INFO: Access modifiers changed from: private */
        public static float c(Resources resources, float f11) {
            return (f11 * resources.getDisplayMetrics().density) + 0.5f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static float d(Resources resources, float f11) {
            return f11 * resources.getDisplayMetrics().scaledDensity;
        }
    }

    public h3(Context context) {
        this(context, null);
    }

    public h3(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public h3(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f19343f = new RectF();
        this.f19347j = 0;
        this.f19352o = "";
        this.f19353p = "";
        this.f19355r = "";
        this.f19358u = a.d(getResources(), 14.0f);
        this.f19360w = (int) a.c(getResources(), 100.0f);
        this.f19357t = a.c(getResources(), 4.0f);
        this.f19359v = a.d(getResources(), 18.0f);
        a();
        b();
    }

    private int a(int i11) {
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        if (mode == 1073741824) {
            return size;
        }
        int i12 = this.f19360w;
        return mode == Integer.MIN_VALUE ? Math.min(i12, size) : i12;
    }

    private float getProgressAngle() {
        return (getProgress() / this.f19348k) * 360.0f;
    }

    public void a() {
        this.f19349l = f19336x;
        this.f19345h = f19337y;
        this.f19344g = this.f19358u;
        setMax(100);
        setProgress(0);
        this.f19350m = this.f19357t;
        this.f19351n = 0;
        this.f19354q = this.f19359v;
        this.f19346i = f19338z;
    }

    public void b() {
        TextPaint textPaint = new TextPaint();
        this.f19341c = textPaint;
        textPaint.setColor(this.f19345h);
        this.f19341c.setTextSize(this.f19344g);
        this.f19341c.setAntiAlias(true);
        TextPaint textPaint2 = new TextPaint();
        this.f19342d = textPaint2;
        textPaint2.setColor(this.f19346i);
        this.f19342d.setTextSize(this.f19354q);
        this.f19342d.setAntiAlias(true);
        Paint paint = new Paint();
        this.f19339a = paint;
        paint.setColor(this.f19349l);
        this.f19339a.setStyle(Paint.Style.STROKE);
        this.f19339a.setAntiAlias(true);
        this.f19339a.setStrokeWidth(this.f19350m);
        Paint paint2 = new Paint();
        this.f19340b = paint2;
        paint2.setColor(this.f19351n);
        this.f19340b.setAntiAlias(true);
    }

    public int getFinishedStrokeColor() {
        return this.f19349l;
    }

    public float getFinishedStrokeWidth() {
        return this.f19350m;
    }

    public int getInnerBackgroundColor() {
        return this.f19351n;
    }

    public String getInnerBottomText() {
        return this.f19355r;
    }

    public int getInnerBottomTextColor() {
        return this.f19346i;
    }

    public float getInnerBottomTextSize() {
        return this.f19354q;
    }

    public int getMax() {
        return this.f19348k;
    }

    public String getPrefixText() {
        return this.f19352o;
    }

    public int getProgress() {
        return this.f19347j;
    }

    public String getSuffixText() {
        return this.f19353p;
    }

    public int getTextColor() {
        return this.f19345h;
    }

    public float getTextSize() {
        return this.f19344g;
    }

    @Override // android.view.View
    public void invalidate() {
        b();
        super.invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f11 = this.f19350m;
        this.f19343f.set(f11, f11, getWidth() - f11, getHeight() - f11);
        float width = getWidth();
        float f12 = this.f19350m;
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, ((width - f12) + f12) / 2.0f, this.f19340b);
        canvas.drawArc(this.f19343f, 270.0f, -getProgressAngle(), false, this.f19339a);
        String str = this.f19352o + this.f19347j + this.f19353p;
        if (!TextUtils.isEmpty(str)) {
            canvas.drawText(str, (getWidth() - this.f19341c.measureText(str)) / 2.0f, (getWidth() - (this.f19341c.descent() + this.f19341c.ascent())) / 2.0f, this.f19341c);
        }
        if (TextUtils.isEmpty(getInnerBottomText())) {
            return;
        }
        this.f19342d.setTextSize(this.f19354q);
        canvas.drawText(getInnerBottomText(), (getWidth() - this.f19342d.measureText(getInnerBottomText())) / 2.0f, (getHeight() - this.f19356s) - ((this.f19341c.descent() + this.f19341c.ascent()) / 2.0f), this.f19342d);
    }

    @Override // android.view.View
    public void onMeasure(int i11, int i12) {
        setMeasuredDimension(a(i11), a(i12));
        this.f19356s = getHeight() - ((getHeight() * 3) / 4);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        this.f19345h = bundle.getInt("text_color");
        this.f19344g = bundle.getFloat("text_size");
        this.f19354q = bundle.getFloat("inner_bottom_text_size");
        this.f19355r = bundle.getString("inner_bottom_text");
        this.f19346i = bundle.getInt("inner_bottom_text_color");
        this.f19349l = bundle.getInt("finished_stroke_color");
        this.f19350m = bundle.getFloat("finished_stroke_width");
        this.f19351n = bundle.getInt("inner_background_color");
        b();
        setMax(bundle.getInt(AppLovinMediationProvider.MAX));
        setProgress(bundle.getInt(NotificationCompat.CATEGORY_PROGRESS));
        this.f19352o = bundle.getString(RequestParameters.PREFIX);
        this.f19353p = bundle.getString("suffix");
        super.onRestoreInstanceState(bundle.getParcelable("saved_instance"));
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("saved_instance", super.onSaveInstanceState());
        bundle.putInt("text_color", getTextColor());
        bundle.putFloat("text_size", getTextSize());
        bundle.putFloat("inner_bottom_text_size", getInnerBottomTextSize());
        bundle.putFloat("inner_bottom_text_color", getInnerBottomTextColor());
        bundle.putString("inner_bottom_text", getInnerBottomText());
        bundle.putInt("inner_bottom_text_color", getInnerBottomTextColor());
        bundle.putInt("finished_stroke_color", getFinishedStrokeColor());
        bundle.putInt(AppLovinMediationProvider.MAX, getMax());
        bundle.putInt(NotificationCompat.CATEGORY_PROGRESS, getProgress());
        bundle.putString("suffix", getSuffixText());
        bundle.putString(RequestParameters.PREFIX, getPrefixText());
        bundle.putFloat("finished_stroke_width", getFinishedStrokeWidth());
        bundle.putInt("inner_background_color", getInnerBackgroundColor());
        return bundle;
    }

    public void setFinishedStrokeColor(int i11) {
        this.f19349l = i11;
        invalidate();
    }

    public void setFinishedStrokeWidth(float f11) {
        this.f19350m = f11;
        invalidate();
    }

    public void setInnerBackgroundColor(int i11) {
        this.f19351n = i11;
        invalidate();
    }

    public void setInnerBottomText(String str) {
        this.f19355r = str;
        invalidate();
    }

    public void setInnerBottomTextColor(int i11) {
        this.f19346i = i11;
        invalidate();
    }

    public void setInnerBottomTextSize(float f11) {
        this.f19354q = f11;
        invalidate();
    }

    public void setMax(int i11) {
        if (i11 > 0) {
            this.f19348k = i11;
            invalidate();
        }
    }

    public void setPrefixText(String str) {
        this.f19352o = str;
        invalidate();
    }

    public void setProgress(int i11) {
        this.f19347j = i11;
        if (i11 > getMax()) {
            this.f19347j %= getMax();
        }
        invalidate();
    }

    public void setSuffixText(String str) {
        this.f19353p = str;
        invalidate();
    }

    public void setTextColor(int i11) {
        this.f19345h = i11;
        invalidate();
    }

    public void setTextSize(float f11) {
        this.f19344g = f11;
        invalidate();
    }
}
