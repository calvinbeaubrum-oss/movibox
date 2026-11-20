package q0;

import OoooO0.o00Oo0.OooOO0;
import android.content.Context;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.core.view.MotionEventCompat;
import p013OoooO0.o00Oo0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f74105a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f74106b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ScaleGestureDetector f74107c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public VelocityTracker f74108d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f74109e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f74110f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f74111g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f74112h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f74113i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b f74114j;

    /* JADX INFO: renamed from: q0.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class ScaleGestureDetectorOnScaleGestureListenerC0812a implements ScaleGestureDetector.OnScaleGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f74115a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f74116b = 0.0f;

        public ScaleGestureDetectorOnScaleGestureListenerC0812a() {
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
            ((o00Oo0.a) a.this.f74114j).a(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY(), scaleGestureDetector.getFocusX() - this.f74115a, scaleGestureDetector.getFocusY() - this.f74116b);
            this.f74115a = scaleGestureDetector.getFocusX();
            this.f74116b = scaleGestureDetector.getFocusY();
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.f74115a = scaleGestureDetector.getFocusX();
            this.f74116b = scaleGestureDetector.getFocusY();
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        }
    }

    public a(Context context, b bVar) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f74113i = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f74112h = viewConfiguration.getScaledTouchSlop();
        this.f74114j = bVar;
        this.f74107c = new ScaleGestureDetector(context, new ScaleGestureDetectorOnScaleGestureListenerC0812a());
    }

    public final float a(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(this.f74106b);
        } catch (Exception unused) {
            return motionEvent.getX();
        }
    }

    public final float b(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(this.f74106b);
        } catch (Exception unused) {
            return motionEvent.getY();
        }
    }

    /* JADX WARN: Code duplicated, block: B:74:0x0114 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:75:0x0116  */
    public final boolean c(MotionEvent motionEvent) {
        int iRound;
        int i11;
        int iRound2;
        int i12;
        int i13;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.f74105a = motionEvent.getPointerId(0);
            VelocityTracker velocityTrackerObtain = VelocityTracker.obtain();
            this.f74108d = velocityTrackerObtain;
            if (velocityTrackerObtain != null) {
                velocityTrackerObtain.addMovement(motionEvent);
            }
            this.f74110f = a(motionEvent);
            this.f74111g = b(motionEvent);
            this.f74109e = false;
        } else if (action == 1) {
            this.f74105a = -1;
            if (this.f74109e && this.f74108d != null) {
                this.f74110f = a(motionEvent);
                this.f74111g = b(motionEvent);
                this.f74108d.addMovement(motionEvent);
                this.f74108d.computeCurrentVelocity(1000);
                float xVelocity = this.f74108d.getXVelocity();
                float yVelocity = this.f74108d.getYVelocity();
                if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.f74113i) {
                    o00Oo0.a aVar = (o00Oo0.a) this.f74114j;
                    o00Oo0 o00oo0 = o00Oo0.this;
                    o00oo0.f254u = o00oo0.new OooOO0(o00oo0.f243j.getContext());
                    o00Oo0 o00oo1 = o00Oo0.this;
                    o00Oo0.OooOO0 oooOO0 = o00oo1.f254u;
                    int iF = o00oo1.f(o00oo1.f243j);
                    o00Oo0 o00oo2 = o00Oo0.this;
                    int iA = o00oo2.a(o00oo2.f243j);
                    int i14 = (int) (-xVelocity);
                    int i15 = (int) (-yVelocity);
                    RectF rectFH = o00Oo0.this.h();
                    if (rectFH != null) {
                        int iRound3 = Math.round(-rectFH.left);
                        float f11 = iF;
                        if (f11 < rectFH.width()) {
                            iRound = Math.round(rectFH.width() - f11);
                            i11 = 0;
                        } else {
                            iRound = iRound3;
                            i11 = iRound;
                        }
                        int iRound4 = Math.round(-rectFH.top);
                        float f12 = iA;
                        if (f12 < rectFH.height()) {
                            iRound2 = Math.round(rectFH.height() - f12);
                            i12 = 0;
                        } else {
                            iRound2 = iRound4;
                            i12 = iRound2;
                        }
                        oooOO0.OooO0O0 = iRound3;
                        oooOO0.OooO0OO = iRound4;
                        if (iRound3 != iRound || iRound4 != iRound2) {
                            oooOO0.OooO00o.fling(iRound3, iRound4, i14, i15, i11, iRound, i12, iRound2, 0, 0);
                        }
                    }
                    o00Oo0 o00oo3 = o00Oo0.this;
                    o00oo3.f243j.post(o00oo3.f254u);
                }
            }
            VelocityTracker velocityTracker = this.f74108d;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f74108d = null;
            }
        } else if (action == 2) {
            float fA = a(motionEvent);
            float fB = b(motionEvent);
            float f13 = fA - this.f74110f;
            float f14 = fB - this.f74111g;
            if (!this.f74109e) {
                this.f74109e = Math.sqrt((double) ((f14 * f14) + (f13 * f13))) >= ((double) this.f74112h);
            }
            if (this.f74109e) {
                o00Oo0.a aVar2 = (o00Oo0.a) this.f74114j;
                if (!o00Oo0.this.f245l.f74107c.isInProgress()) {
                    o00Oo0.this.getClass();
                    o00Oo0.this.f248o.postTranslate(f13, f14);
                    o00Oo0.this.c();
                    ViewParent parent = o00Oo0.this.f243j.getParent();
                    o00Oo0 o00oo4 = o00Oo0.this;
                    if (o00oo4.f240g && !o00oo4.f245l.f74107c.isInProgress()) {
                        o00Oo0 o00oo5 = o00Oo0.this;
                        if (!o00oo5.f241h && !o00oo5.f242i) {
                            float fAbs = Math.abs(f13);
                            float fAbs2 = Math.abs(f14);
                            o00Oo0 o00oo6 = o00Oo0.this;
                            int i16 = o00oo6.f255v;
                            if (((i16 == 2 && fAbs > fAbs2) || ((i16 == 0 && f13 >= 1.0f && fAbs > fAbs2) || ((i16 == 1 && f13 <= -1.0f && fAbs > fAbs2) || (((i13 = o00oo6.f256w) == 0 && f14 >= 1.0f && fAbs2 > fAbs) || ((i13 == 1 && f14 <= -1.0f && fAbs2 > fAbs) || (i13 == 2 && fAbs2 > fAbs)))))) && parent != null) {
                                parent.requestDisallowInterceptTouchEvent(false);
                            }
                        } else if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    } else if (parent != null) {
                        parent.requestDisallowInterceptTouchEvent(true);
                    }
                }
                this.f74110f = fA;
                this.f74111g = fB;
                VelocityTracker velocityTracker2 = this.f74108d;
                if (velocityTracker2 != null) {
                    velocityTracker2.addMovement(motionEvent);
                }
            }
        } else if (action == 3) {
            this.f74105a = -1;
            VelocityTracker velocityTracker3 = this.f74108d;
            if (velocityTracker3 != null) {
                velocityTracker3.recycle();
                this.f74108d = null;
            }
        } else if (action == 6) {
            int action2 = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
            if (motionEvent.getPointerId(action2) == this.f74105a) {
                int i17 = action2 == 0 ? 1 : 0;
                this.f74105a = motionEvent.getPointerId(i17);
                this.f74110f = motionEvent.getX(i17);
                this.f74111g = motionEvent.getY(i17);
            }
        }
        int i18 = this.f74105a;
        this.f74106b = motionEvent.findPointerIndex(i18 != -1 ? i18 : 0);
        return true;
    }
}
