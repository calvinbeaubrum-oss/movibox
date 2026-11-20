package com.applovin.impl.adview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class n extends e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Paint f17621c = new Paint(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Paint f17622d = new Paint(1);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Paint f17623f = new Paint(1);

    public n(Context context) {
        super(context);
        f17621c.setColor(-1);
        f17622d.setColor(ViewCompat.MEASURED_STATE_MASK);
        Paint paint = f17623f;
        paint.setColor(-1);
        paint.setStyle(Paint.Style.STROKE);
    }

    public float getCenter() {
        return getSize() / 2.0f;
    }

    public float getCrossOffset() {
        return this.f17586a * 10.0f;
    }

    public float getInnerCircleOffset() {
        return this.f17586a * 2.0f;
    }

    public float getInnerCircleRadius() {
        return getCenter() - getInnerCircleOffset();
    }

    public float getStrokeWidth() {
        return this.f17586a * 3.0f;
    }

    @Override // com.applovin.impl.adview.e
    public e.a getStyle() {
        return e.a.WHITE_ON_BLACK;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float center = getCenter();
        canvas.drawCircle(center, center, center, f17621c);
        canvas.drawCircle(center, center, getInnerCircleRadius(), f17622d);
        float crossOffset = getCrossOffset();
        float size = getSize() - crossOffset;
        Paint paint = f17623f;
        paint.setStrokeWidth(getStrokeWidth());
        canvas.drawLine(crossOffset, crossOffset, size, size, paint);
        canvas.drawLine(crossOffset, size, size, crossOffset, paint);
    }
}
