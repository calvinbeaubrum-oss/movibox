package androidx.media3.exoplayer.video.spherical;

import android.content.Context;
import android.graphics.PointF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener, androidx.media3.exoplayer.video.spherical.a.InterfaceC0109a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f11728c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f11729d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final GestureDetector f11730f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PointF f11726a = new PointF();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PointF f11727b = new PointF();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile float f11731g = 3.1415927f;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void b(PointF pointF);

        boolean onSingleTapUp(MotionEvent motionEvent);
    }

    public b(Context context, a aVar, float f11) {
        this.f11728c = aVar;
        this.f11729d = f11;
        this.f11730f = new GestureDetector(context, this);
    }

    @Override // androidx.media3.exoplayer.video.spherical.a.InterfaceC0109a
    public void a(float[] fArr, float f11) {
        this.f11731g = -f11;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        this.f11726a.set(motionEvent.getX(), motionEvent.getY());
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f11, float f12) {
        float x11 = (motionEvent2.getX() - this.f11726a.x) / this.f11729d;
        float y11 = motionEvent2.getY();
        PointF pointF = this.f11726a;
        float f13 = (y11 - pointF.y) / this.f11729d;
        pointF.set(motionEvent2.getX(), motionEvent2.getY());
        double d11 = this.f11731g;
        float fCos = (float) Math.cos(d11);
        float fSin = (float) Math.sin(d11);
        PointF pointF2 = this.f11727b;
        pointF2.x -= (fCos * x11) - (fSin * f13);
        float f14 = pointF2.y + (fSin * x11) + (fCos * f13);
        pointF2.y = f14;
        pointF2.y = Math.max(-45.0f, Math.min(45.0f, f14));
        this.f11728c.b(this.f11727b);
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return this.f11728c.onSingleTapUp(motionEvent);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f11730f.onTouchEvent(motionEvent);
    }
}
