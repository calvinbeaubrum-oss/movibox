package com.bytedance.adsdk.ugeno.TRI;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class pFF extends sc<com.bytedance.adsdk.ugeno.pFF.zY> {
    private com.bytedance.adsdk.ugeno.zY zY;

    public pFF(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.bytedance.adsdk.ugeno.zY zYVar = this.zY;
        if (zYVar != null) {
            zYVar.qr();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.bytedance.adsdk.ugeno.zY zYVar = this.zY;
        if (zYVar != null) {
            zYVar.Qj();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        com.bytedance.adsdk.ugeno.zY zYVar = this.zY;
        if (zYVar != null) {
            zYVar.TRI();
        }
        super.onLayout(z11, i11, i12, i13, i14);
        com.bytedance.adsdk.ugeno.zY zYVar2 = this.zY;
        if (zYVar2 != null) {
            zYVar2.sc(i11, i12, i13, i14);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i11, int i12) {
        com.bytedance.adsdk.ugeno.zY zYVar = this.zY;
        if (zYVar != null) {
            int[] iArrSc = zYVar.sc(i11, i12);
            super.onMeasure(iArrSc[0], iArrSc[1]);
        } else {
            super.onMeasure(i11, i12);
        }
        com.bytedance.adsdk.ugeno.zY zYVar2 = this.zY;
        if (zYVar2 != null) {
            zYVar2.ExN();
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        com.bytedance.adsdk.ugeno.zY zYVar = this.zY;
        if (zYVar != null) {
            zYVar.pFF(i11, i12, i13, i14);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z11) {
        super.onWindowFocusChanged(z11);
    }

    @Override // com.bytedance.adsdk.ugeno.TRI.sc
    public View qr(int i11) {
        return ((com.bytedance.adsdk.ugeno.pFF.zY) this.f26363sc.get(i11)).Ol();
    }

    public void sc(com.bytedance.adsdk.ugeno.zY zYVar) {
        this.zY = zYVar;
    }
}
