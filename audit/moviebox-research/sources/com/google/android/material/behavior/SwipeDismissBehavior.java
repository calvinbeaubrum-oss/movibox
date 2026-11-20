package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.widget.ViewDragHelper;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.c<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewDragHelper f36236a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f36237b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f36238c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f36239d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f36241g;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f36240f = 0.0f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f36242h = 2;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f36243i = 0.5f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f36244j = 0.0f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f36245k = 0.5f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ViewDragHelper.b f36246l = new a();

    /* JADX INFO: compiled from: source.java */
    public class SettleRunnable implements Runnable {
        private final boolean dismiss;
        private final View view;

        public SettleRunnable(View view, boolean z11) {
            this.view = view;
            this.dismiss = z11;
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar;
            ViewDragHelper viewDragHelper = SwipeDismissBehavior.this.f36236a;
            if (viewDragHelper != null && viewDragHelper.n(true)) {
                ViewCompat.postOnAnimation(this.view, this);
            } else {
                if (!this.dismiss || (cVar = SwipeDismissBehavior.this.f36237b) == null) {
                    return;
                }
                cVar.a(this.view);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a extends ViewDragHelper.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f36247a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f36248b = -1;

        public a() {
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public int a(@NonNull View view, int i11, int i12) {
            int width;
            int width2;
            int width3;
            boolean z11 = ViewCompat.getLayoutDirection(view) == 1;
            int i13 = SwipeDismissBehavior.this.f36242h;
            if (i13 == 0) {
                if (z11) {
                    width = this.f36247a - view.getWidth();
                    width2 = this.f36247a;
                } else {
                    width = this.f36247a;
                    width3 = view.getWidth();
                    width2 = width3 + width;
                }
            } else if (i13 != 1) {
                width = this.f36247a - view.getWidth();
                width2 = view.getWidth() + this.f36247a;
            } else if (z11) {
                width = this.f36247a;
                width3 = view.getWidth();
                width2 = width3 + width;
            } else {
                width = this.f36247a - view.getWidth();
                width2 = this.f36247a;
            }
            return SwipeDismissBehavior.H(width, i11, width2);
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public int b(@NonNull View view, int i11, int i12) {
            return view.getTop();
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public int d(@NonNull View view) {
            return view.getWidth();
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public void i(@NonNull View view, int i11) {
            this.f36248b = i11;
            this.f36247a = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                SwipeDismissBehavior.this.f36239d = true;
                parent.requestDisallowInterceptTouchEvent(true);
                SwipeDismissBehavior.this.f36239d = false;
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public void j(int i11) {
            c cVar = SwipeDismissBehavior.this.f36237b;
            if (cVar != null) {
                cVar.b(i11);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public void k(@NonNull View view, int i11, int i12, int i13, int i14) {
            float width = view.getWidth() * SwipeDismissBehavior.this.f36244j;
            float width2 = view.getWidth() * SwipeDismissBehavior.this.f36245k;
            float fAbs = Math.abs(i11 - this.f36247a);
            if (fAbs <= width) {
                view.setAlpha(1.0f);
            } else if (fAbs >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.G(0.0f, 1.0f - SwipeDismissBehavior.J(width, width2, fAbs), 1.0f));
            }
        }

        /* JADX WARN: Code duplicated, block: B:10:0x001d  */
        @Override // androidx.customview.widget.ViewDragHelper.b
        public void l(@NonNull View view, float f11, float f12) {
            int i11;
            boolean z11;
            c cVar;
            this.f36248b = -1;
            int width = view.getWidth();
            if (n(view, f11)) {
                if (f11 >= 0.0f) {
                    int left = view.getLeft();
                    int i12 = this.f36247a;
                    if (left < i12) {
                        i11 = this.f36247a - width;
                    } else {
                        i11 = i12 + width;
                    }
                } else {
                    i11 = this.f36247a - width;
                }
                z11 = true;
            } else {
                i11 = this.f36247a;
                z11 = false;
            }
            if (SwipeDismissBehavior.this.f36236a.Q(i11, view.getTop())) {
                ViewCompat.postOnAnimation(view, new SettleRunnable(view, z11));
            } else {
                if (!z11 || (cVar = SwipeDismissBehavior.this.f36237b) == null) {
                    return;
                }
                cVar.a(view);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public boolean m(View view, int i11) {
            int i12 = this.f36248b;
            return (i12 == -1 || i12 == i11) && SwipeDismissBehavior.this.F(view);
        }

        public final boolean n(@NonNull View view, float f11) {
            if (f11 == 0.0f) {
                return Math.abs(view.getLeft() - this.f36247a) >= Math.round(((float) view.getWidth()) * SwipeDismissBehavior.this.f36243i);
            }
            boolean z11 = ViewCompat.getLayoutDirection(view) == 1;
            int i11 = SwipeDismissBehavior.this.f36242h;
            if (i11 == 2) {
                return true;
            }
            if (i11 == 0) {
                if (z11) {
                    if (f11 >= 0.0f) {
                        return false;
                    }
                } else if (f11 <= 0.0f) {
                    return false;
                }
                return true;
            }
            if (i11 != 1) {
                return false;
            }
            if (z11) {
                if (f11 <= 0.0f) {
                    return false;
                }
            } else if (f11 >= 0.0f) {
                return false;
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements AccessibilityViewCommand {
        public b() {
        }

        @Override // androidx.core.view.accessibility.AccessibilityViewCommand
        public boolean perform(@NonNull View view, @Nullable AccessibilityViewCommand.CommandArguments commandArguments) {
            if (!SwipeDismissBehavior.this.F(view)) {
                return false;
            }
            boolean z11 = ViewCompat.getLayoutDirection(view) == 1;
            int i11 = SwipeDismissBehavior.this.f36242h;
            ViewCompat.offsetLeftAndRight(view, (!(i11 == 0 && z11) && (i11 != 1 || z11)) ? view.getWidth() : -view.getWidth());
            view.setAlpha(0.0f);
            c cVar = SwipeDismissBehavior.this.f36237b;
            if (cVar != null) {
                cVar.a(view);
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface c {
        void a(View view);

        void b(int i11);
    }

    public static float G(float f11, float f12, float f13) {
        return Math.min(Math.max(f11, f12), f13);
    }

    public static int H(int i11, int i12, int i13) {
        return Math.min(Math.max(i11, i12), i13);
    }

    public static float J(float f11, float f12, float f13) {
        return (f13 - f11) / (f12 - f11);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean D(CoordinatorLayout coordinatorLayout, V v11, MotionEvent motionEvent) {
        if (this.f36236a == null) {
            return false;
        }
        if (this.f36239d && motionEvent.getActionMasked() == 3) {
            return true;
        }
        this.f36236a.H(motionEvent);
        return true;
    }

    public boolean F(@NonNull View view) {
        return true;
    }

    public final void I(ViewGroup viewGroup) {
        if (this.f36236a == null) {
            this.f36236a = this.f36241g ? ViewDragHelper.o(viewGroup, this.f36240f, this.f36246l) : ViewDragHelper.p(viewGroup, this.f36246l);
        }
    }

    public void K(float f11) {
        this.f36245k = G(0.0f, f11, 1.0f);
    }

    public void L(@Nullable c cVar) {
        this.f36237b = cVar;
    }

    public void M(float f11) {
        this.f36244j = G(0.0f, f11, 1.0f);
    }

    public void N(int i11) {
        this.f36242h = i11;
    }

    public final void O(View view) {
        ViewCompat.removeAccessibilityAction(view, 1048576);
        if (F(view)) {
            ViewCompat.replaceAccessibilityAction(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, null, new b());
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean k(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v11, @NonNull MotionEvent motionEvent) {
        boolean zIsPointInChildBounds = this.f36238c;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            zIsPointInChildBounds = coordinatorLayout.isPointInChildBounds(v11, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.f36238c = zIsPointInChildBounds;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f36238c = false;
        }
        if (!zIsPointInChildBounds) {
            return false;
        }
        I(coordinatorLayout);
        return !this.f36239d && this.f36236a.R(motionEvent);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v11, int i11) {
        boolean zL = super.l(coordinatorLayout, v11, i11);
        if (ViewCompat.getImportantForAccessibility(v11) == 0) {
            ViewCompat.setImportantForAccessibility(v11, 1);
            O(v11);
        }
        return zL;
    }
}
