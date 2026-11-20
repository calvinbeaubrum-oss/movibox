package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Sfl extends Drawable {
    private RectF We;
    private int pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private Paint f26800sc;
    private int zY;

    public Sfl(int i11, int i12) {
        this.zY = i11;
        this.pFF = i12;
        Paint paint = new Paint();
        this.f26800sc = paint;
        paint.setColor(0);
        this.f26800sc.setAntiAlias(true);
        this.f26800sc.setShadowLayer(i12, 0.0f, 0.0f, ViewCompat.MEASURED_STATE_MASK);
        this.f26800sc.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        RectF rectF = this.We;
        int i11 = this.zY;
        canvas.drawRoundRect(rectF, i11, i11, this.f26800sc);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i11) {
        this.f26800sc.setAlpha(i11);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i11, int i12, int i13, int i14) {
        super.setBounds(i11, i12, i13, i14);
        int i15 = this.pFF;
        this.We = new RectF(i11 + i15, i12 + i15, i13 - i15, i14 - i15);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f26800sc.setColorFilter(colorFilter);
    }
}
