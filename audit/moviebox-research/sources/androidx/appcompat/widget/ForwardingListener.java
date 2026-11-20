package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class ForwardingListener implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f1425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1426b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1427c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f1428d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Runnable f1429f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Runnable f1430g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f1431h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f1432i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int[] f1433j = new int[2];

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class DisallowIntercept implements Runnable {
        public DisallowIntercept() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewParent parent = ForwardingListener.this.f1428d.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class TriggerLongPress implements Runnable {
        public TriggerLongPress() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ForwardingListener.this.e();
        }
    }

    public ForwardingListener(View view) {
        this.f1428d = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f1425a = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f1426b = tapTimeout;
        this.f1427c = (tapTimeout + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    public static boolean h(View view, float f11, float f12, float f13) {
        float f14 = -f13;
        return f11 >= f14 && f12 >= f14 && f11 < ((float) (view.getRight() - view.getLeft())) + f13 && f12 < ((float) (view.getBottom() - view.getTop())) + f13;
    }

    public final void a() {
        Runnable runnable = this.f1430g;
        if (runnable != null) {
            this.f1428d.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.f1429f;
        if (runnable2 != null) {
            this.f1428d.removeCallbacks(runnable2);
        }
    }

    public abstract androidx.appcompat.view.menu.o b();

    public abstract boolean c();

    public boolean d() {
        androidx.appcompat.view.menu.o oVarB = b();
        if (oVarB == null || !oVarB.a()) {
            return true;
        }
        oVarB.dismiss();
        return true;
    }

    public void e() {
        a();
        View view = this.f1428d;
        if (view.isEnabled() && !view.isLongClickable() && c()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long jUptimeMillis = SystemClock.uptimeMillis();
            MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(motionEventObtain);
            motionEventObtain.recycle();
            this.f1431h = true;
        }
    }

    public final boolean f(MotionEvent motionEvent) {
        DropDownListView dropDownListView;
        View view = this.f1428d;
        androidx.appcompat.view.menu.o oVarB = b();
        if (oVarB == null || !oVarB.a() || (dropDownListView = (DropDownListView) oVarB.o()) == null || !dropDownListView.isShown()) {
            return false;
        }
        MotionEvent motionEventObtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        i(view, motionEventObtainNoHistory);
        j(dropDownListView, motionEventObtainNoHistory);
        boolean zOnForwardedEvent = dropDownListView.onForwardedEvent(motionEventObtainNoHistory, this.f1432i);
        motionEventObtainNoHistory.recycle();
        int actionMasked = motionEvent.getActionMasked();
        return zOnForwardedEvent && (actionMasked != 1 && actionMasked != 3);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x003d  */
    public final boolean g(MotionEvent motionEvent) {
        View view = this.f1428d;
        if (!view.isEnabled()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f1432i = motionEvent.getPointerId(0);
            if (this.f1429f == null) {
                this.f1429f = new DisallowIntercept();
            }
            view.postDelayed(this.f1429f, this.f1426b);
            if (this.f1430g == null) {
                this.f1430g = new TriggerLongPress();
            }
            view.postDelayed(this.f1430g, this.f1427c);
        } else if (actionMasked == 1) {
            a();
        } else if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.f1432i);
            if (iFindPointerIndex >= 0 && !h(view, motionEvent.getX(iFindPointerIndex), motionEvent.getY(iFindPointerIndex), this.f1425a)) {
                a();
                view.getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            }
        } else if (actionMasked == 3) {
            a();
        }
        return false;
    }

    public final boolean i(View view, MotionEvent motionEvent) {
        int[] iArr = this.f1433j;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation(iArr[0], iArr[1]);
        return true;
    }

    public final boolean j(View view, MotionEvent motionEvent) {
        int[] iArr = this.f1433j;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation(-iArr[0], -iArr[1]);
        return true;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z11;
        boolean z12 = this.f1431h;
        if (z12) {
            z11 = f(motionEvent) || !d();
        } else {
            z11 = g(motionEvent) && c();
            if (z11) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                this.f1428d.onTouchEvent(motionEventObtain);
                motionEventObtain.recycle();
            }
        }
        this.f1431h = z11;
        return z11 || z12;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.f1431h = false;
        this.f1432i = -1;
        Runnable runnable = this.f1429f;
        if (runnable != null) {
            this.f1428d.removeCallbacks(runnable);
        }
    }
}
