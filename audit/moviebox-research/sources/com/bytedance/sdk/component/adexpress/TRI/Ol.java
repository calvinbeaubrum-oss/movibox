package com.bytedance.sdk.component.adexpress.TRI;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Ol extends View {
    private Paint ExN;
    private int Qj;
    private int TRI;
    private Paint We;
    private int pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private Paint f26674qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private int f26675sc;
    private final RectF zY;

    public Ol(Context context) {
        super(context);
        this.zY = new RectF();
        sc();
    }

    private void sc() {
        Paint paint = new Paint();
        this.We = paint;
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f26674qr = paint2;
        paint2.setAntiAlias(true);
        Paint paint3 = new Paint();
        this.ExN = paint3;
        paint3.setAntiAlias(true);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = this.zY;
        int i11 = this.TRI;
        canvas.drawRoundRect(rectF, i11, i11, this.ExN);
        RectF rectF2 = this.zY;
        int i12 = this.TRI;
        canvas.drawRoundRect(rectF2, i12, i12, this.We);
        int i13 = this.f26675sc;
        int i14 = this.pFF;
        canvas.drawLine(i13 * 0.3f, i14 * 0.3f, i13 * 0.7f, i14 * 0.7f, this.f26674qr);
        int i15 = this.f26675sc;
        int i16 = this.pFF;
        canvas.drawLine(i15 * 0.7f, i16 * 0.3f, i15 * 0.3f, i16 * 0.7f, this.f26674qr);
    }

    @Override // android.view.View
    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        this.f26675sc = i11;
        this.pFF = i12;
        RectF rectF = this.zY;
        int i15 = this.Qj;
        rectF.set(i15, i15, i11 - i15, i12 - i15);
    }

    public void setBgColor(int i11) {
        this.ExN.setStyle(Paint.Style.FILL);
        this.ExN.setColor(i11);
    }

    public void setDislikeColor(int i11) {
        this.f26674qr.setColor(i11);
    }

    public void setDislikeWidth(int i11) {
        this.f26674qr.setStrokeWidth(i11);
    }

    public void setRadius(int i11) {
        this.TRI = i11;
    }

    public void setStrokeColor(int i11) {
        this.We.setStyle(Paint.Style.STROKE);
        this.We.setColor(i11);
    }

    public void setStrokeWidth(int i11) {
        this.We.setStrokeWidth(i11);
        this.Qj = i11;
    }
}
