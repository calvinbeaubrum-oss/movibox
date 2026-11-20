package com.bytedance.sdk.openadsdk.Ql;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class UFX extends View {
    private float pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final Paint f27112sc;
    private float zY;

    public UFX(Context context) {
        super(context);
        setBackgroundColor(Color.parseColor("#8A8A8A"));
        Paint paint = new Paint();
        this.f27112sc = paint;
        paint.setColor(-1);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeCap(Paint.Cap.ROUND);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f11 = this.zY;
        if (f11 > 0.0f) {
            float f12 = this.pFF;
            canvas.drawLine(0.0f, f12, f11, f12, this.f27112sc);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        float f11 = i12;
        this.pFF = (1.0f * f11) / 2.0f;
        this.f27112sc.setStrokeWidth(f11);
    }

    public void setProgress(float f11) {
        this.zY = getWidth() * f11;
        invalidate();
    }
}
