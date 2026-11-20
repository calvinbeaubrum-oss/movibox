package com.bytedance.adsdk.ugeno.Ol.pFF;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.bytedance.adsdk.ugeno.core.WH;
import com.bytedance.adsdk.ugeno.zY;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class sc extends FrameLayout {
    private Map<Integer, WH> pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private zY f26344sc;

    public sc(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        zY zYVar = this.f26344sc;
        if (zYVar != null) {
            zYVar.qr();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        zY zYVar = this.f26344sc;
        if (zYVar != null) {
            zYVar.Qj();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        Map<Integer, WH> map = this.pFF;
        if (map == null || !map.containsKey(4)) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        zY zYVar = this.f26344sc;
        if (zYVar != null) {
            zYVar.TRI();
        }
        super.onLayout(z11, i11, i12, i13, i14);
        zY zYVar2 = this.f26344sc;
        if (zYVar2 != null) {
            zYVar2.sc(i11, i12, i13, i14);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i11, int i12) {
        zY zYVar = this.f26344sc;
        if (zYVar != null) {
            int[] iArrSc = zYVar.sc(i11, i12);
            super.onMeasure(iArrSc[0], iArrSc[1]);
        } else {
            super.onMeasure(i11, i12);
        }
        zY zYVar2 = this.f26344sc;
        if (zYVar2 != null) {
            zYVar2.ExN();
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        zY zYVar = this.f26344sc;
        if (zYVar != null) {
            zYVar.pFF(i11, i12, i13, i14);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z11) {
        super.onWindowFocusChanged(z11);
    }

    public void sc(zY zYVar) {
        this.f26344sc = zYVar;
    }

    public void setEventMap(Map<Integer, WH> map) {
        this.pFF = map;
    }
}
