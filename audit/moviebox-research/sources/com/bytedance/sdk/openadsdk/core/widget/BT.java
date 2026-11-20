package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class BT extends com.bytedance.sdk.openadsdk.core.ExN.Qj {
    private RectF pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private Paint f28526sc;
    private int zY;

    public BT(Context context) {
        this(context, null);
    }

    public BT(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BT(Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.zY = 0;
        sc();
    }

    private void sc() {
        setTextColor(-1);
        Paint paint = new Paint();
        this.f28526sc = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f28526sc.setColor(Color.parseColor("#99333333"));
        this.f28526sc.setAntiAlias(true);
        this.f28526sc.setStrokeWidth(0.0f);
        this.pFF = new RectF();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        RectF rectF = this.pFF;
        float f11 = rectF.bottom;
        canvas.drawRoundRect(rectF, f11 / 2.0f, f11 / 2.0f, this.f28526sc);
        canvas.translate((this.pFF.right / 2.0f) - (getPaint().measureText(getText().toString()) / 2.0f), 0.0f);
        super.onDraw(canvas);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ExN.Qj, android.widget.TextView, android.view.View
    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth <= 0 || measuredHeight <= 0) {
            this.pFF.set(0.0f, 0.0f, 0.0f, 0.0f);
            return;
        }
        int iMeasureText = (int) getPaint().measureText("00");
        this.zY = iMeasureText;
        if (measuredWidth < iMeasureText) {
            measuredWidth = iMeasureText;
        }
        int i13 = measuredWidth + ((measuredHeight / 2) * 2);
        setMeasuredDimension(i13, measuredHeight);
        this.pFF.set(0.0f, 0.0f, i13, measuredHeight);
    }
}
