package com.applovin.impl;

import android.content.Context;
import android.graphics.PointF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class jo extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener, xg.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f20000c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f20001d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final GestureDetector f20002e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PointF f19998a = new PointF();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PointF f19999b = new PointF();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile float f20003f = 3.1415927f;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(PointF pointF);

        boolean onSingleTapUp(MotionEvent motionEvent);
    }

    public jo(Context context, a aVar, float f11) {
        this.f20000c = aVar;
        this.f20001d = f11;
        this.f20002e = new GestureDetector(context, this);
    }

    @Override // com.applovin.impl.xg.a
    public void a(float[] fArr, float f11) {
        this.f20003f = -f11;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        this.f19998a.set(motionEvent.getX(), motionEvent.getY());
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f11, float f12) {
        float x11 = (motionEvent2.getX() - this.f19998a.x) / this.f20001d;
        float y11 = motionEvent2.getY();
        PointF pointF = this.f19998a;
        float f13 = (y11 - pointF.y) / this.f20001d;
        pointF.set(motionEvent2.getX(), motionEvent2.getY());
        double d11 = this.f20003f;
        float fCos = (float) Math.cos(d11);
        float fSin = (float) Math.sin(d11);
        PointF pointF2 = this.f19999b;
        pointF2.x -= (fCos * x11) - (fSin * f13);
        float f14 = pointF2.y + (fSin * x11) + (fCos * f13);
        pointF2.y = f14;
        pointF2.y = Math.max(-45.0f, Math.min(45.0f, f14));
        this.f20000c.a(this.f19999b);
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return this.f20000c.onSingleTapUp(motionEvent);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f20002e.onTouchEvent(motionEvent);
    }
}
