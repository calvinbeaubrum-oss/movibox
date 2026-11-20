package com.tn.lib.view.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class CircleIndicator extends BaseIndicator {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f49895d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f49896f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f49897g;

    public CircleIndicator(Context context) {
        this(context, null);
    }

    public CircleIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleIndicator(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f49895d = this.f49892a.h() / 2;
        this.f49896f = this.f49892a.k() / 2;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int iD = this.f49892a.d();
        if (iD <= 1) {
            return;
        }
        float fE = 0.0f;
        int i11 = 0;
        while (i11 < iD) {
            this.f49893b.setColor(this.f49892a.a() == i11 ? this.f49892a.j() : this.f49892a.g());
            int iK = this.f49892a.a() == i11 ? this.f49892a.k() : this.f49892a.h();
            float f11 = this.f49892a.a() == i11 ? this.f49896f : this.f49895d;
            canvas.drawCircle(fE + f11, this.f49897g, f11, this.f49893b);
            fE += iK + this.f49892a.e();
            i11++;
        }
    }

    @Override // android.view.View
    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        int iD = this.f49892a.d();
        if (iD <= 1) {
            return;
        }
        this.f49895d = this.f49892a.h() / 2;
        int iK = this.f49892a.k() / 2;
        this.f49896f = iK;
        this.f49897g = Math.max(iK, this.f49895d);
        int i13 = iD - 1;
        setMeasuredDimension((this.f49892a.e() * i13) + this.f49892a.k() + (this.f49892a.h() * i13), Math.max(this.f49892a.h(), this.f49892a.k()));
    }
}
