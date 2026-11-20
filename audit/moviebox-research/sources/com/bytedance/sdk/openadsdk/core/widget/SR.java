package com.bytedance.sdk.openadsdk.core.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@SuppressLint({"AppCompatCustomView"})
public class SR extends com.bytedance.sdk.openadsdk.core.ExN.We {
    private RectF pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private Paint f28536sc;

    public SR(Context context) {
        super(context);
        sc();
    }

    private void sc() {
        Paint paint = new Paint();
        this.f28536sc = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f28536sc.setColor(Color.parseColor("#99333333"));
        this.f28536sc.setAntiAlias(true);
        this.f28536sc.setStrokeWidth(0.0f);
        this.pFF = new RectF();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        RectF rectF = this.pFF;
        canvas.drawRoundRect(rectF, rectF.right / 2.0f, rectF.bottom / 2.0f, this.f28536sc);
        super.onDraw(canvas);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ExN.We, android.widget.ImageView, android.view.View
    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        if (this.pFF.right == getMeasuredWidth() && this.pFF.bottom == getMeasuredHeight()) {
            return;
        }
        this.pFF.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
    }
}
