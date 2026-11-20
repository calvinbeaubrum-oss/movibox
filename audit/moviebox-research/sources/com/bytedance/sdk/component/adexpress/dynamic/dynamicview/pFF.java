package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.GradientDrawable;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class pFF extends GradientDrawable {
    private final Paint pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    protected Path f26827sc;

    public pFF() {
        this.f26827sc = new Path();
        Paint paint = new Paint(1);
        this.pFF = paint;
        paint.setColor(-1);
    }

    public pFF(GradientDrawable.Orientation orientation, int[] iArr) {
        super(orientation, iArr);
        this.f26827sc = new Path();
        Paint paint = new Paint(1);
        this.pFF = paint;
        paint.setColor(-1);
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Path path = this.f26827sc;
        if (path == null || path.isEmpty()) {
            sc(canvas);
            return;
        }
        int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), this.pFF, 31);
        sc(canvas);
        this.pFF.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        canvas.drawPath(this.f26827sc, this.pFF);
        this.pFF.setXfermode(null);
        canvas.restoreToCount(iSaveLayer);
    }

    public void sc(int i11, int i12, int i13, int i14) {
        this.f26827sc.addRect(i11, i12, i13, i14, Path.Direction.CW);
        invalidateSelf();
    }

    public void sc(Canvas canvas) {
        super.draw(canvas);
    }
}
