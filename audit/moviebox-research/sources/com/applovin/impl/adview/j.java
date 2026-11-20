package com.applovin.impl.adview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class j extends e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Paint f17609f = new Paint(1);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Paint f17610g = new Paint(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float[] f17611c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Path f17612d;

    public j(Context context) {
        super(context);
        this.f17611c = new float[]{30.0f, 30.0f, 50.0f, 50.0f, 30.0f, 70.0f, 55.0f, 30.0f, 75.0f, 50.0f, 55.0f, 70.0f};
        f17609f.setARGB(80, 0, 0, 0);
        Paint paint = f17610g;
        paint.setColor(-1);
        paint.setStyle(Paint.Style.STROKE);
    }

    private void a() {
        int i11 = 0;
        while (true) {
            float[] fArr = this.f17611c;
            if (i11 >= fArr.length) {
                Path path = new Path();
                this.f17612d = path;
                float[] fArr2 = this.f17611c;
                path.moveTo(fArr2[0], fArr2[1]);
                Path path2 = this.f17612d;
                float[] fArr3 = this.f17611c;
                path2.lineTo(fArr3[2], fArr3[3]);
                Path path3 = this.f17612d;
                float[] fArr4 = this.f17611c;
                path3.lineTo(fArr4[4], fArr4[5]);
                Path path4 = this.f17612d;
                float[] fArr5 = this.f17611c;
                path4.moveTo(fArr5[6], fArr5[7]);
                Path path5 = this.f17612d;
                float[] fArr6 = this.f17611c;
                path5.lineTo(fArr6[8], fArr6[9]);
                Path path6 = this.f17612d;
                float[] fArr7 = this.f17611c;
                path6.lineTo(fArr7[10], fArr7[11]);
                return;
            }
            fArr[i11] = fArr[i11] * 0.3f * this.f17586a;
            i11++;
        }
    }

    @Override // com.applovin.impl.adview.e
    public void a(int i11) {
        setViewScale(i11 / 30.0f);
        a();
    }

    public float getCenter() {
        return getSize() / 2.0f;
    }

    public float getStrokeWidth() {
        return this.f17586a * 2.0f;
    }

    @Override // com.applovin.impl.adview.e
    public e.a getStyle() {
        return e.a.TRANSPARENT_SKIP;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float center = getCenter();
        canvas.drawCircle(center, center, center, f17609f);
        Paint paint = f17610g;
        paint.setStrokeWidth(getStrokeWidth());
        canvas.drawPath(this.f17612d, paint);
    }
}
