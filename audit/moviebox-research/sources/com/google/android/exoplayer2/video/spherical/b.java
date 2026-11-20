package com.google.android.exoplayer2.video.spherical;

import android.content.Context;
import android.graphics.PointF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener, com.google.android.exoplayer2.video.spherical.a.InterfaceC0376a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f35845c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f35846d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final GestureDetector f35847f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PointF f35843a = new PointF();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PointF f35844b = new PointF();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile float f35848g = 3.1415927f;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void b(PointF pointF);

        boolean onSingleTapUp(MotionEvent motionEvent);
    }

    public b(Context context, a aVar, float f11) {
        this.f35845c = aVar;
        this.f35846d = f11;
        this.f35847f = new GestureDetector(context, this);
    }

    @Override // com.google.android.exoplayer2.video.spherical.a.InterfaceC0376a
    public void a(float[] fArr, float f11) {
        this.f35848g = -f11;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        this.f35843a.set(motionEvent.getX(), motionEvent.getY());
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f11, float f12) {
        float x11 = (motionEvent2.getX() - this.f35843a.x) / this.f35846d;
        float y11 = motionEvent2.getY();
        PointF pointF = this.f35843a;
        float f13 = (y11 - pointF.y) / this.f35846d;
        pointF.set(motionEvent2.getX(), motionEvent2.getY());
        double d11 = this.f35848g;
        float fCos = (float) Math.cos(d11);
        float fSin = (float) Math.sin(d11);
        PointF pointF2 = this.f35844b;
        pointF2.x -= (fCos * x11) - (fSin * f13);
        float f14 = pointF2.y + (fSin * x11) + (fCos * f13);
        pointF2.y = f14;
        pointF2.y = Math.max(-45.0f, Math.min(45.0f, f14));
        this.f35845c.b(this.f35844b);
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return this.f35845c.onSingleTapUp(motionEvent);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f35847f.onTouchEvent(motionEvent);
    }
}
