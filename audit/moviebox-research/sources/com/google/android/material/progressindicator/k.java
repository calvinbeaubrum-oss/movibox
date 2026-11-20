package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class k extends h<n> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f37314b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f37315c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f37316d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f37317e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f37318f;

    public k(@NonNull n nVar) {
        super(nVar);
        this.f37314b = 300.0f;
    }

    @Override // com.google.android.material.progressindicator.h
    public void a(@NonNull Canvas canvas, @NonNull Rect rect, float f11, boolean z11, boolean z12) {
        this.f37314b = rect.width();
        float f12 = ((n) this.f37304a).f37251a;
        canvas.translate(rect.left + (rect.width() / 2.0f), rect.top + (rect.height() / 2.0f) + Math.max(0.0f, (rect.height() - f12) / 2.0f));
        if (((n) this.f37304a).f37342j) {
            canvas.scale(-1.0f, 1.0f);
        }
        float f13 = this.f37314b / 2.0f;
        float f14 = f12 / 2.0f;
        canvas.clipRect(-f13, -f14, f13, f14);
        S s11 = this.f37304a;
        this.f37317e = ((n) s11).f37251a / 2 == ((n) s11).f37252b;
        this.f37315c = ((n) s11).f37251a * f11;
        this.f37316d = Math.min(((n) s11).f37251a / 2, ((n) s11).f37252b) * f11;
        if (z11 || z12) {
            if ((z11 && ((n) this.f37304a).f37255e == 2) || (z12 && ((n) this.f37304a).f37256f == 1)) {
                canvas.scale(1.0f, -1.0f);
            }
            if (z11 || (z12 && ((n) this.f37304a).f37256f != 3)) {
                canvas.translate(0.0f, (((n) this.f37304a).f37251a * (1.0f - f11)) / 2.0f);
            }
        }
        if (z12 && ((n) this.f37304a).f37256f == 3) {
            this.f37318f = f11;
        } else {
            this.f37318f = 1.0f;
        }
    }

    @Override // com.google.android.material.progressindicator.h
    public void b(@NonNull Canvas canvas, @NonNull Paint paint, int i11, int i12) {
        int iA = com.google.android.material.color.b.a(i11, i12);
        if (((n) this.f37304a).f37343k <= 0 || iA == 0) {
            return;
        }
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(iA);
        PointF pointF = new PointF((this.f37314b / 2.0f) - (this.f37315c / 2.0f), 0.0f);
        S s11 = this.f37304a;
        i(canvas, paint, pointF, ((n) s11).f37343k, ((n) s11).f37343k);
    }

    @Override // com.google.android.material.progressindicator.h
    public void c(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull h.a aVar, int i11) {
        int iA = com.google.android.material.color.b.a(aVar.f37307c, i11);
        float f11 = aVar.f37305a;
        float f12 = aVar.f37306b;
        int i12 = aVar.f37308d;
        h(canvas, paint, f11, f12, iA, i12, i12);
    }

    @Override // com.google.android.material.progressindicator.h
    public void d(@NonNull Canvas canvas, @NonNull Paint paint, float f11, float f12, int i11, int i12, int i13) {
        h(canvas, paint, f11, f12, com.google.android.material.color.b.a(i11, i12), i13, i13);
    }

    @Override // com.google.android.material.progressindicator.h
    public int e() {
        return ((n) this.f37304a).f37251a;
    }

    @Override // com.google.android.material.progressindicator.h
    public int f() {
        return -1;
    }

    public final void h(@NonNull Canvas canvas, @NonNull Paint paint, float f11, float f12, int i11, int i12, int i13) {
        float fA = g3.a.a(f11, 0.0f, 1.0f);
        float fA2 = g3.a.a(f12, 0.0f, 1.0f);
        float fD = si.a.d(1.0f - this.f37318f, 1.0f, fA);
        float fD2 = si.a.d(1.0f - this.f37318f, 1.0f, fA2);
        int iA = (int) ((i12 * g3.a.a(fD, 0.0f, 0.01f)) / 0.01f);
        int iA2 = (int) ((i13 * (1.0f - g3.a.a(fD2, 0.99f, 1.0f))) / 0.01f);
        float f13 = this.f37314b;
        int i14 = (int) ((fD * f13) + iA);
        int i15 = (int) ((fD2 * f13) - iA2);
        float f14 = (-f13) / 2.0f;
        if (i14 <= i15) {
            float f15 = this.f37316d;
            float f16 = i14 + f15;
            float f17 = i15 - f15;
            float f18 = f15 * 2.0f;
            paint.setColor(i11);
            paint.setAntiAlias(true);
            paint.setStrokeWidth(this.f37315c);
            if (f16 >= f17) {
                j(canvas, paint, new PointF(f16 + f14, 0.0f), new PointF(f17 + f14, 0.0f), f18, this.f37315c);
                return;
            }
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeCap(this.f37317e ? Paint.Cap.ROUND : Paint.Cap.BUTT);
            float f19 = f16 + f14;
            float f21 = f17 + f14;
            canvas.drawLine(f19, 0.0f, f21, 0.0f, paint);
            if (this.f37317e || this.f37316d <= 0.0f) {
                return;
            }
            paint.setStyle(Paint.Style.FILL);
            if (f16 > 0.0f) {
                i(canvas, paint, new PointF(f19, 0.0f), f18, this.f37315c);
            }
            if (f17 < this.f37314b) {
                i(canvas, paint, new PointF(f21, 0.0f), f18, this.f37315c);
            }
        }
    }

    public final void i(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull PointF pointF, float f11, float f12) {
        j(canvas, paint, pointF, null, f11, f12);
    }

    public final void j(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull PointF pointF, @Nullable PointF pointF2, float f11, float f12) {
        float fMin = Math.min(f12, this.f37315c);
        float f13 = f11 / 2.0f;
        float fMin2 = Math.min(f13, (this.f37316d * fMin) / this.f37315c);
        RectF rectF = new RectF((-f11) / 2.0f, (-fMin) / 2.0f, f13, fMin / 2.0f);
        paint.setStyle(Paint.Style.FILL);
        canvas.save();
        if (pointF2 != null) {
            canvas.translate(pointF2.x, pointF2.y);
            Path path = new Path();
            path.addRoundRect(rectF, fMin2, fMin2, Path.Direction.CCW);
            canvas.clipPath(path);
            canvas.translate(-pointF2.x, -pointF2.y);
        }
        canvas.translate(pointF.x, pointF.y);
        canvas.drawRoundRect(rectF, fMin2, fMin2, paint);
        canvas.restore();
    }
}
