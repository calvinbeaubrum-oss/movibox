package com.bytedance.adsdk.ugeno.Ol.TRI;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.TextView;
import com.bytedance.adsdk.ugeno.core.IAnimation;
import com.bytedance.adsdk.ugeno.sc.ExN;
import com.bytedance.adsdk.ugeno.sc.TRI;
import com.bytedance.adsdk.ugeno.zY;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class sc extends TextView implements IAnimation, ExN {
    private float pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private zY f26330sc;
    private TRI zY;

    public sc(Context context) {
        super(context);
        this.zY = new TRI(this);
    }

    public float getBorderRadius() {
        return this.zY.sc();
    }

    @Override // com.bytedance.adsdk.ugeno.core.IAnimation, com.bytedance.adsdk.ugeno.sc.ExN
    public float getRipple() {
        return this.pFF;
    }

    @Override // com.bytedance.adsdk.ugeno.sc.ExN
    public float getRubIn() {
        return this.zY.getRubIn();
    }

    @Override // com.bytedance.adsdk.ugeno.sc.ExN
    public float getShine() {
        return this.zY.getShine();
    }

    @Override // com.bytedance.adsdk.ugeno.sc.ExN
    public float getStretch() {
        return this.zY.getStretch();
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        zY zYVar = this.f26330sc;
        if (zYVar != null) {
            zYVar.qr();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        zY zYVar = this.f26330sc;
        if (zYVar != null) {
            zYVar.Qj();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        zY zYVar = this.f26330sc;
        if (zYVar != null) {
            zYVar.sc(canvas, this);
            this.f26330sc.sc(canvas);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        zY zYVar = this.f26330sc;
        if (zYVar != null) {
            zYVar.sc(i11, i12, i13, i14);
        }
        super.onLayout(z11, i11, i12, i13, i14);
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i11, int i12) {
        zY zYVar = this.f26330sc;
        if (zYVar == null) {
            super.onMeasure(i11, i12);
        } else {
            int[] iArrSc = zYVar.sc(i11, i12);
            super.onMeasure(iArrSc[0], iArrSc[1]);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        zY zYVar = this.f26330sc;
        if (zYVar != null) {
            zYVar.pFF(i11, i12, i13, i13);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onWindowFocusChanged(boolean z11) {
        super.onWindowFocusChanged(z11);
    }

    public void sc(zY zYVar) {
        this.f26330sc = zYVar;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i11) {
        this.zY.sc(i11);
    }

    public void setBorderRadius(float f11) {
        TRI tri = this.zY;
        if (tri != null) {
            tri.sc(f11);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.core.IAnimation
    public void setRipple(float f11) {
        this.pFF = f11;
        TRI tri = this.zY;
        if (tri != null) {
            tri.pFF(f11);
        }
        postInvalidate();
    }

    public void setRubIn(float f11) {
        TRI tri = this.zY;
        if (tri != null) {
            tri.ExN(f11);
        }
    }

    public void setShine(float f11) {
        TRI tri = this.zY;
        if (tri != null) {
            tri.zY(f11);
        }
    }

    public void setStretch(float f11) {
        TRI tri = this.zY;
        if (tri != null) {
            tri.We(f11);
        }
    }
}
