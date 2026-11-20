package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.gms.common.api.Api;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class HeaderBehavior<V extends View> extends j<V> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public Runnable f36160d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public OverScroller f36161f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f36162g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f36163h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f36164i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f36165j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public VelocityTracker f36166k;

    /* JADX INFO: compiled from: source.java */
    public class FlingRunnable implements Runnable {
        private final V layout;
        private final CoordinatorLayout parent;

        public FlingRunnable(CoordinatorLayout coordinatorLayout, V v11) {
            this.parent = coordinatorLayout;
            this.layout = v11;
        }

        @Override // java.lang.Runnable
        public void run() {
            OverScroller overScroller;
            if (this.layout == null || (overScroller = HeaderBehavior.this.f36161f) == null) {
                return;
            }
            if (!overScroller.computeScrollOffset()) {
                HeaderBehavior.this.N(this.parent, this.layout);
                return;
            }
            HeaderBehavior headerBehavior = HeaderBehavior.this;
            headerBehavior.P(this.parent, this.layout, headerBehavior.f36161f.getCurrY());
            ViewCompat.postOnAnimation(this.layout, this);
        }
    }

    public HeaderBehavior() {
        this.f36163h = -1;
        this.f36165j = -1;
    }

    public HeaderBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f36163h = -1;
        this.f36165j = -1;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x007b  */
    /* JADX WARN: Code duplicated, block: B:30:0x0085  */
    /* JADX WARN: Code duplicated, block: B:33:0x008c A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:37:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean D(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v11, @NonNull MotionEvent motionEvent) {
        boolean z11;
        VelocityTracker velocityTracker;
        VelocityTracker velocityTracker2;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1) {
            VelocityTracker velocityTracker3 = this.f36166k;
            if (velocityTracker3 != null) {
                velocityTracker3.addMovement(motionEvent);
                this.f36166k.computeCurrentVelocity(1000);
                J(coordinatorLayout, v11, -L(v11), 0, this.f36166k.getYVelocity(this.f36163h));
                z11 = true;
            }
            this.f36162g = false;
            this.f36163h = -1;
            velocityTracker = this.f36166k;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f36166k = null;
            }
            velocityTracker2 = this.f36166k;
            if (velocityTracker2 != null) {
                velocityTracker2.addMovement(motionEvent);
            }
            if (this.f36162g) {
                return true;
            }
        }
        if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.f36163h);
            if (iFindPointerIndex == -1) {
                return false;
            }
            int y11 = (int) motionEvent.getY(iFindPointerIndex);
            int i11 = this.f36164i - y11;
            this.f36164i = y11;
            O(coordinatorLayout, v11, i11, K(v11), 0);
        } else if (actionMasked != 3) {
            if (actionMasked == 6) {
                int i12 = motionEvent.getActionIndex() == 0 ? 1 : 0;
                this.f36163h = motionEvent.getPointerId(i12);
                this.f36164i = (int) (motionEvent.getY(i12) + 0.5f);
            }
        }
        z11 = false;
        velocityTracker2 = this.f36166k;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(motionEvent);
        }
        return !this.f36162g || z11;
        z11 = false;
        this.f36162g = false;
        this.f36163h = -1;
        velocityTracker = this.f36166k;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f36166k = null;
        }
        velocityTracker2 = this.f36166k;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(motionEvent);
        }
        if (this.f36162g) {
            return true;
        }
    }

    public boolean H(V v11) {
        return false;
    }

    public final void I() {
        if (this.f36166k == null) {
            this.f36166k = VelocityTracker.obtain();
        }
    }

    public final boolean J(CoordinatorLayout coordinatorLayout, @NonNull V v11, int i11, int i12, float f11) {
        Runnable runnable = this.f36160d;
        if (runnable != null) {
            v11.removeCallbacks(runnable);
            this.f36160d = null;
        }
        if (this.f36161f == null) {
            this.f36161f = new OverScroller(v11.getContext());
        }
        this.f36161f.fling(0, E(), 0, Math.round(f11), 0, 0, i11, i12);
        if (!this.f36161f.computeScrollOffset()) {
            N(coordinatorLayout, v11);
            return false;
        }
        FlingRunnable flingRunnable = new FlingRunnable(coordinatorLayout, v11);
        this.f36160d = flingRunnable;
        ViewCompat.postOnAnimation(v11, flingRunnable);
        return true;
    }

    public int K(@NonNull V v11) {
        return -v11.getHeight();
    }

    public int L(@NonNull V v11) {
        return v11.getHeight();
    }

    public int M() {
        return E();
    }

    public void N(CoordinatorLayout coordinatorLayout, V v11) {
    }

    public final int O(CoordinatorLayout coordinatorLayout, V v11, int i11, int i12, int i13) {
        return Q(coordinatorLayout, v11, M() - i11, i12, i13);
    }

    public int P(CoordinatorLayout coordinatorLayout, V v11, int i11) {
        return Q(coordinatorLayout, v11, i11, Integer.MIN_VALUE, Api.BaseClientBuilder.API_PRIORITY_OTHER);
    }

    public int Q(CoordinatorLayout coordinatorLayout, V v11, int i11, int i12, int i13) {
        int iB;
        int iE = E();
        if (i12 == 0 || iE < i12 || iE > i13 || iE == (iB = g3.a.b(i11, i12, i13))) {
            return 0;
        }
        G(iB);
        return iE - iB;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean k(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v11, @NonNull MotionEvent motionEvent) {
        int iFindPointerIndex;
        if (this.f36165j < 0) {
            this.f36165j = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.f36162g) {
            int i11 = this.f36163h;
            if (i11 == -1 || (iFindPointerIndex = motionEvent.findPointerIndex(i11)) == -1) {
                return false;
            }
            int y11 = (int) motionEvent.getY(iFindPointerIndex);
            if (Math.abs(y11 - this.f36164i) > this.f36165j) {
                this.f36164i = y11;
                return true;
            }
        }
        if (motionEvent.getActionMasked() == 0) {
            this.f36163h = -1;
            int x11 = (int) motionEvent.getX();
            int y12 = (int) motionEvent.getY();
            boolean z11 = H(v11) && coordinatorLayout.isPointInChildBounds(v11, x11, y12);
            this.f36162g = z11;
            if (z11) {
                this.f36164i = y12;
                this.f36163h = motionEvent.getPointerId(0);
                I();
                OverScroller overScroller = this.f36161f;
                if (overScroller != null && !overScroller.isFinished()) {
                    this.f36161f.abortAnimation();
                    return true;
                }
            }
        }
        VelocityTracker velocityTracker = this.f36166k;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        return false;
    }
}
