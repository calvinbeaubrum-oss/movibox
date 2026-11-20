package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class c extends h<e> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f37258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f37259c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f37260d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f37261e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f37262f;

    public c(@NonNull e eVar) {
        super(eVar);
    }

    @Override // com.google.android.material.progressindicator.h
    public void a(@NonNull Canvas canvas, @NonNull Rect rect, float f11, boolean z11, boolean z12) {
        float fWidth = rect.width() / f();
        float fHeight = rect.height() / e();
        S s11 = this.f37304a;
        float f12 = (((e) s11).f37278h / 2.0f) + ((e) s11).f37279i;
        canvas.translate((f12 * fWidth) + rect.left, (f12 * fHeight) + rect.top);
        canvas.rotate(-90.0f);
        canvas.scale(fWidth, fHeight);
        if (((e) this.f37304a).f37280j != 0) {
            canvas.scale(1.0f, -1.0f);
        }
        float f13 = -f12;
        canvas.clipRect(f13, f13, f12, f12);
        S s12 = this.f37304a;
        this.f37261e = ((e) s12).f37251a / 2 <= ((e) s12).f37252b;
        this.f37258b = ((e) s12).f37251a * f11;
        this.f37259c = Math.min(((e) s12).f37251a / 2, ((e) s12).f37252b) * f11;
        S s13 = this.f37304a;
        float f14 = (((e) s13).f37278h - ((e) s13).f37251a) / 2.0f;
        this.f37260d = f14;
        if (z11 || z12) {
            if ((z11 && ((e) s13).f37255e == 2) || (z12 && ((e) s13).f37256f == 1)) {
                this.f37260d = f14 + (((1.0f - f11) * ((e) s13).f37251a) / 2.0f);
            } else if ((z11 && ((e) s13).f37255e == 1) || (z12 && ((e) s13).f37256f == 2)) {
                this.f37260d = f14 - (((1.0f - f11) * ((e) s13).f37251a) / 2.0f);
            }
        }
        if (z12 && ((e) s13).f37256f == 3) {
            this.f37262f = f11;
        } else {
            this.f37262f = 1.0f;
        }
    }

    @Override // com.google.android.material.progressindicator.h
    public void b(@NonNull Canvas canvas, @NonNull Paint paint, int i11, int i12) {
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
        return k();
    }

    @Override // com.google.android.material.progressindicator.h
    public int f() {
        return k();
    }

    public final void h(@NonNull Canvas canvas, @NonNull Paint paint, float f11, float f12, int i11, int i12, int i13) {
        float f13 = f12 >= f11 ? f12 - f11 : (f12 + 1.0f) - f11;
        float f14 = f11 % 1.0f;
        if (this.f37262f < 1.0f) {
            float f15 = f14 + f13;
            if (f15 > 1.0f) {
                h(canvas, paint, f14, 1.0f, i11, i12, 0);
                h(canvas, paint, 1.0f, f15, i11, 0, i13);
                return;
            }
        }
        float degrees = (float) Math.toDegrees(this.f37259c / this.f37260d);
        if (f14 == 0.0f && f13 >= 0.99f) {
            f13 += ((f13 - 0.99f) * ((degrees * 2.0f) / 360.0f)) / 0.01f;
        }
        float fD = si.a.d(1.0f - this.f37262f, 1.0f, f14);
        float fD2 = si.a.d(0.0f, this.f37262f, f13);
        float degrees2 = (float) Math.toDegrees(i12 / this.f37260d);
        float degrees3 = ((fD2 * 360.0f) - degrees2) - ((float) Math.toDegrees(i13 / this.f37260d));
        float f16 = (fD * 360.0f) + degrees2;
        if (degrees3 <= 0.0f) {
            return;
        }
        paint.setAntiAlias(true);
        paint.setColor(i11);
        paint.setStrokeWidth(this.f37258b);
        float f17 = degrees * 2.0f;
        if (degrees3 < f17) {
            float f18 = degrees3 / f17;
            paint.setStyle(Paint.Style.FILL);
            j(canvas, paint, f16 + (degrees * f18), this.f37259c * 2.0f, this.f37258b, f18);
            return;
        }
        float f19 = this.f37260d;
        RectF rectF = new RectF(-f19, -f19, f19, f19);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(this.f37261e ? Paint.Cap.ROUND : Paint.Cap.BUTT);
        float f21 = f16 + degrees;
        canvas.drawArc(rectF, f21, degrees3 - f17, false, paint);
        if (this.f37261e || this.f37259c <= 0.0f) {
            return;
        }
        paint.setStyle(Paint.Style.FILL);
        i(canvas, paint, f21, this.f37259c * 2.0f, this.f37258b);
        i(canvas, paint, (f16 + degrees3) - degrees, this.f37259c * 2.0f, this.f37258b);
    }

    public final void i(@NonNull Canvas canvas, @NonNull Paint paint, float f11, float f12, float f13) {
        j(canvas, paint, f11, f12, f13, 1.0f);
    }

    public final void j(@NonNull Canvas canvas, @NonNull Paint paint, float f11, float f12, float f13, float f14) {
        float fMin = (int) Math.min(f13, this.f37258b);
        float f15 = f12 / 2.0f;
        float fMin2 = Math.min(f15, (this.f37259c * fMin) / this.f37258b);
        RectF rectF = new RectF((-fMin) / 2.0f, (-f12) / 2.0f, fMin / 2.0f, f15);
        canvas.save();
        double d11 = f11;
        canvas.translate((float) (((double) this.f37260d) * Math.cos(Math.toRadians(d11))), (float) (((double) this.f37260d) * Math.sin(Math.toRadians(d11))));
        canvas.rotate(f11);
        canvas.scale(f14, f14);
        canvas.drawRoundRect(rectF, fMin2, fMin2, paint);
        canvas.restore();
    }

    public final int k() {
        S s11 = this.f37304a;
        return ((e) s11).f37278h + (((e) s11).f37279i * 2);
    }
}
