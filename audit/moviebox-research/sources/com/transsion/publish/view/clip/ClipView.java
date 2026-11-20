package com.transsion.publish.view.clip;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.transsion.publish.R$color;
import z2.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class ClipView extends View {
    public static final int BORDERDISTANCE = 0;
    public static final int CIRCLE_ZOOM = 3;
    public static final int CIRCULAR = 0;
    public static final int RECTANGULAR = 1;
    public static int TYPE_START = 0;
    public static int mHorizontalPadding = 16;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f56732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f56733b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f56734c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f56735d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f56736f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f56737g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f56738h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f56739i;
    public int innerCircle;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f56740j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f56741k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f56742l;

    public ClipView(Context context) {
        this(context, null);
        this.f56733b = context;
    }

    public ClipView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        this.f56733b = context;
    }

    public ClipView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.innerCircle = getWidth() / 3;
        this.f56740j = true;
        this.f56741k = true;
        this.f56742l = true;
        this.f56732a = new Paint();
        this.f56733b = context;
    }

    public static int dip2px(Context context, float f11) {
        return (int) ((f11 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public int cropHeight() {
        return this.f56735d;
    }

    public int cropWidth() {
        return this.f56734c;
    }

    public int getInnerCircle() {
        return this.innerCircle;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i11;
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        int i12 = this.f56734c;
        if (i12 <= 0 || (i11 = this.f56735d) <= 0 || width <= 0 || height <= 0) {
            if (TYPE_START == 0) {
                this.innerCircle = width / 3;
                this.f56732a.setColor(0);
                this.f56732a.setDither(true);
                this.f56732a.setAntiAlias(true);
                this.f56732a.setStyle(Paint.Style.STROKE);
                int i13 = width / 2;
                float f11 = i13;
                int i14 = height / 2;
                float f12 = i14;
                canvas.drawCircle(f11, f12, i13 - mHorizontalPadding, this.f56732a);
                this.f56732a.setColor(a.getColor(getContext(), R$color.cl31_50_p));
                this.f56732a.setStrokeWidth(height);
                canvas.drawCircle(f11, f12, (i13 - mHorizontalPadding) + i14, this.f56732a);
                return;
            }
            this.f56732a.setColor(a.getColor(getContext(), R$color.cl31_50_p));
            float f13 = width;
            float f14 = (height - width) / 2;
            canvas.drawRect(0.0f, 0.0f, f13, f14, this.f56732a);
            float f15 = (height + width) / 2;
            canvas.drawRect(0.0f, f15, f13, height, this.f56732a);
            canvas.drawRect(0.0f, f14, 0.0f, f15, this.f56732a);
            canvas.drawRect(width, f14, f13, f15, this.f56732a);
            this.f56732a.setColor(-1);
            this.f56732a.setStrokeWidth(2.0f);
            float f16 = width;
            canvas.drawLine(0.0f, f14, f16, f14, this.f56732a);
            canvas.drawLine(0.0f, f15, f16, f15, this.f56732a);
            canvas.drawLine(0.0f, f14, 0.0f, f15, this.f56732a);
            canvas.drawLine(f16, f14, f16, f15, this.f56732a);
            return;
        }
        if (this.f56740j) {
            int[] iArrA = this.f56742l ? iw.a.a(this.f56733b, i12, i11, width, height) : iw.a.b(this.f56733b, i12, i11, width, height, 1.0f);
            this.f56734c = iArrA[0];
            this.f56735d = iArrA[1];
        }
        int i15 = (width - this.f56734c) / 2;
        int i16 = (height - this.f56735d) / 2;
        this.f56732a.setColor(a.getColor(getContext(), R$color.cl31_50_p));
        float f17 = width;
        float f18 = i16;
        canvas.drawRect(0.0f, 0.0f, f17, f18, this.f56732a);
        canvas.drawRect(0.0f, this.f56735d + i16, f17, height, this.f56732a);
        canvas.drawRect(0.0f, f18, i15, this.f56735d + i16, this.f56732a);
        canvas.drawRect(this.f56734c + i15, f18, f17, this.f56735d + i16, this.f56732a);
        this.f56732a.setColor(a.getColor(getContext(), com.tn.lib.widget.R$color.white));
        this.f56732a.setStrokeWidth(1);
        this.f56736f = i15;
        this.f56737g = i16;
        int i17 = this.f56734c + i15;
        this.f56738h = i17;
        if (this.f56742l) {
            this.f56739i = this.f56735d + i16;
        } else {
            this.f56739i = this.f56735d - (i16 != 0 ? i16 : 1);
        }
        if (this.f56741k) {
            canvas.drawLine(i15, i16, i17, i16, this.f56732a);
            float f19 = this.f56736f;
            int i18 = this.f56739i;
            canvas.drawLine(f19, i18, this.f56738h, i18, this.f56732a);
            int i19 = this.f56736f;
            canvas.drawLine(i19, this.f56737g, i19, this.f56739i, this.f56732a);
            int i21 = this.f56738h;
            canvas.drawLine(i21, this.f56737g, i21, this.f56739i, this.f56732a);
        }
    }

    public Rect rect() {
        return new Rect(this.f56736f, this.f56737g, this.f56738h, this.f56739i);
    }

    public void setFullScreen(boolean z11) {
        this.f56742l = z11;
    }

    public void setNeedDivider(boolean z11) {
        this.f56741k = z11;
    }

    public void setSizeNeedChange(boolean z11) {
        this.f56740j = z11;
        invalidate();
    }

    public void setStart(int i11) {
        TYPE_START = i11;
    }

    public void setStartWH(int i11, int i12) {
        this.f56734c = i11;
        this.f56735d = i12;
    }
}
