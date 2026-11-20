package androidx.appcompat.widget;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class v0 implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static v0 f1773l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static v0 f1774m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f1775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CharSequence f1776b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1777c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Runnable f1778d = new Runnable() { // from class: androidx.appcompat.widget.t0
        @Override // java.lang.Runnable
        public final void run() {
            this.f1771a.e();
        }
    };

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Runnable f1779f = new Runnable() { // from class: androidx.appcompat.widget.u0
        @Override // java.lang.Runnable
        public final void run() {
            this.f1772a.d();
        }
    };

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f1780g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f1781h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public w0 f1782i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f1783j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f1784k;

    public v0(View view, CharSequence charSequence) {
        this.f1775a = view;
        this.f1776b = charSequence;
        this.f1777c = ViewConfigurationCompat.getScaledHoverSlop(ViewConfiguration.get(view.getContext()));
        c();
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    public static void g(v0 v0Var) {
        v0 v0Var2 = f1773l;
        if (v0Var2 != null) {
            v0Var2.b();
        }
        f1773l = v0Var;
        if (v0Var != null) {
            v0Var.f();
        }
    }

    public static void h(View view, CharSequence charSequence) {
        v0 v0Var = f1773l;
        if (v0Var != null && v0Var.f1775a == view) {
            g(null);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            new v0(view, charSequence);
            return;
        }
        v0 v0Var2 = f1774m;
        if (v0Var2 != null && v0Var2.f1775a == view) {
            v0Var2.d();
        }
        view.setOnLongClickListener(null);
        view.setLongClickable(false);
        view.setOnHoverListener(null);
    }

    public final void b() {
        this.f1775a.removeCallbacks(this.f1778d);
    }

    public final void c() {
        this.f1784k = true;
    }

    public void d() {
        if (f1774m == this) {
            f1774m = null;
            w0 w0Var = this.f1782i;
            if (w0Var != null) {
                w0Var.c();
                this.f1782i = null;
                c();
                this.f1775a.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (f1773l == this) {
            g(null);
        }
        this.f1775a.removeCallbacks(this.f1779f);
    }

    public final /* synthetic */ void e() {
        i(false);
    }

    public final void f() {
        this.f1775a.postDelayed(this.f1778d, ViewConfiguration.getLongPressTimeout());
    }

    public void i(boolean z11) {
        long longPressTimeout;
        long j11;
        long j12;
        if (this.f1775a.isAttachedToWindow()) {
            g(null);
            v0 v0Var = f1774m;
            if (v0Var != null) {
                v0Var.d();
            }
            f1774m = this;
            this.f1783j = z11;
            w0 w0Var = new w0(this.f1775a.getContext());
            this.f1782i = w0Var;
            w0Var.e(this.f1775a, this.f1780g, this.f1781h, this.f1783j, this.f1776b);
            this.f1775a.addOnAttachStateChangeListener(this);
            if (this.f1783j) {
                j12 = 2500;
            } else {
                if ((ViewCompat.getWindowSystemUiVisibility(this.f1775a) & 1) == 1) {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j11 = 3000;
                } else {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j11 = 15000;
                }
                j12 = j11 - longPressTimeout;
            }
            this.f1775a.removeCallbacks(this.f1779f);
            this.f1775a.postDelayed(this.f1779f, j12);
        }
    }

    public final boolean j(MotionEvent motionEvent) {
        int x11 = (int) motionEvent.getX();
        int y11 = (int) motionEvent.getY();
        if (!this.f1784k && Math.abs(x11 - this.f1780g) <= this.f1777c && Math.abs(y11 - this.f1781h) <= this.f1777c) {
            return false;
        }
        this.f1780g = x11;
        this.f1781h = y11;
        this.f1784k = false;
        return true;
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.f1782i != null && this.f1783j) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f1775a.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                c();
                d();
            }
        } else if (this.f1775a.isEnabled() && this.f1782i == null && j(motionEvent)) {
            g(this);
        }
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.f1780g = view.getWidth() / 2;
        this.f1781h = view.getHeight() / 2;
        i(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        d();
    }
}
