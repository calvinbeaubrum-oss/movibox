package com.transsion.photoview;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f54133a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f54134b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ScaleGestureDetector f54135c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public VelocityTracker f54136d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f54137e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f54138f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f54139g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f54140h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f54141i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c f54142j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f54143k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f54144l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f54145m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f54146n;

    /* JADX INFO: compiled from: source.java */
    public class a implements ScaleGestureDetector.OnScaleGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f54147a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f54148b = 0.0f;

        public a() {
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            if (Float.isNaN(scaleFactor) || Float.isInfinite(scaleFactor)) {
                return false;
            }
            if (scaleFactor < 0.0f) {
                return true;
            }
            b.this.f54142j.c(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY(), scaleGestureDetector.getFocusX() - this.f54147a, scaleGestureDetector.getFocusY() - this.f54148b);
            this.f54147a = scaleGestureDetector.getFocusX();
            this.f54148b = scaleGestureDetector.getFocusY();
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.f54147a = scaleGestureDetector.getFocusX();
            this.f54148b = scaleGestureDetector.getFocusY();
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        }
    }

    public b(Context context, c cVar) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f54141i = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f54140h = viewConfiguration.getScaledTouchSlop();
        this.f54142j = cVar;
        this.f54135c = new ScaleGestureDetector(context, new a());
    }

    public final float b(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(this.f54134b);
        } catch (Exception unused) {
            return motionEvent.getX();
        }
    }

    public final float c(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(this.f54134b);
        } catch (Exception unused) {
            return motionEvent.getY();
        }
    }

    public float d() {
        return this.f54146n;
    }

    public float e() {
        return this.f54145m;
    }

    public boolean f() {
        return this.f54137e;
    }

    public boolean g() {
        return this.f54135c.isInProgress();
    }

    public boolean h(MotionEvent motionEvent) {
        try {
            this.f54135c.onTouchEvent(motionEvent);
            return i(motionEvent);
        } catch (IllegalArgumentException unused) {
            return true;
        }
    }

    public final boolean i(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.f54133a = motionEvent.getPointerId(0);
            VelocityTracker velocityTrackerObtain = VelocityTracker.obtain();
            this.f54136d = velocityTrackerObtain;
            if (velocityTrackerObtain != null) {
                velocityTrackerObtain.addMovement(motionEvent);
            }
            this.f54138f = b(motionEvent);
            this.f54139g = c(motionEvent);
            this.f54137e = false;
            this.f54143k = motionEvent.getRawY();
            this.f54144l = motionEvent.getRawX();
        } else if (action == 1) {
            this.f54133a = -1;
            if (this.f54137e && this.f54136d != null) {
                this.f54138f = b(motionEvent);
                this.f54139g = c(motionEvent);
                this.f54136d.addMovement(motionEvent);
                this.f54136d.computeCurrentVelocity(1000);
                float xVelocity = this.f54136d.getXVelocity();
                float yVelocity = this.f54136d.getYVelocity();
                if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.f54141i) {
                    this.f54142j.e(this.f54138f, this.f54139g, -xVelocity, -yVelocity);
                }
            }
            VelocityTracker velocityTracker = this.f54136d;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f54136d = null;
            }
        } else if (action == 2) {
            this.f54145m = motionEvent.getRawY() - this.f54143k;
            this.f54146n = motionEvent.getRawX() - this.f54144l;
            float fB = b(motionEvent);
            float fC = c(motionEvent);
            float f11 = fB - this.f54138f;
            float f12 = fC - this.f54139g;
            if (!this.f54137e) {
                this.f54137e = Math.sqrt((double) ((f11 * f11) + (f12 * f12))) >= ((double) this.f54140h);
            }
            if (this.f54137e) {
                this.f54142j.b(f11, f12);
                this.f54138f = fB;
                this.f54139g = fC;
                VelocityTracker velocityTracker2 = this.f54136d;
                if (velocityTracker2 != null) {
                    velocityTracker2.addMovement(motionEvent);
                }
            }
        } else if (action == 3) {
            this.f54133a = -1;
            VelocityTracker velocityTracker3 = this.f54136d;
            if (velocityTracker3 != null) {
                velocityTracker3.recycle();
                this.f54136d = null;
            }
        } else if (action == 6) {
            int iB = o.b(motionEvent.getAction());
            if (motionEvent.getPointerId(iB) == this.f54133a) {
                int i11 = iB == 0 ? 1 : 0;
                this.f54133a = motionEvent.getPointerId(i11);
                this.f54138f = motionEvent.getX(i11);
                this.f54139g = motionEvent.getY(i11);
            }
        }
        int i12 = this.f54133a;
        this.f54134b = motionEvent.findPointerIndex(i12 != -1 ? i12 : 0);
        return true;
    }
}
