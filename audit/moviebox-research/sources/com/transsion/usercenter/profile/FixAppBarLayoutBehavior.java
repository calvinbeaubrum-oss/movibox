package com.transsion.usercenter.profile;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.appbar.AppBarLayout;
import com.transsion.usercenter.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class FixAppBarLayoutBehavior extends AppBarLayout.Behavior {
    public ViewPager2 A;
    public View B;
    public d C;
    public int D;
    public int E;
    public boolean F;
    public VelocityTracker G;
    public int H;
    public RecyclerView I;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f59494r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f59495s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f59496t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f59497u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f59498v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f59499w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f59500x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int[] f59501y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public View f59502z;

    /* JADX INFO: compiled from: source.java */
    public class a extends AppBarLayout.Behavior.a {
        public a() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior.c
        public boolean a(@NonNull AppBarLayout appBarLayout) {
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends ViewPager2.OnPageChangeCallback {
        public b() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i11) {
            super.onPageSelected(i11);
            View childAt = FixAppBarLayoutBehavior.this.A.getChildAt(i11);
            if (childAt != null) {
                FixAppBarLayoutBehavior.this.F0(childAt);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements Animator.AnimatorListener {
        public c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            FixAppBarLayoutBehavior.this.f59495s = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface d {
        void a(float f11, boolean z11);
    }

    public FixAppBarLayoutBehavior() {
        this.f59495s = false;
        this.f59501y = null;
        this.D = -1;
        this.E = -1;
        this.F = false;
        R0();
    }

    public FixAppBarLayoutBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f59495s = false;
        this.f59501y = null;
        this.D = -1;
        this.E = -1;
        this.F = false;
        R0();
    }

    public final void D0() {
        ViewPager2 viewPager2 = this.A;
        if (viewPager2 != null) {
            viewPager2.registerOnPageChangeCallback(new b());
        }
    }

    public final boolean E0() {
        RecyclerView.m layoutManager;
        RecyclerView recyclerView = this.I;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null) {
            return true;
        }
        View viewFindViewByPosition = layoutManager.findViewByPosition(0);
        return viewFindViewByPosition != null && viewFindViewByPosition.getTop() >= 0;
    }

    public final void F0(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
                View childAt = viewGroup.getChildAt(i11);
                if (childAt instanceof RecyclerView) {
                    this.I = (RecyclerView) childAt;
                }
            }
        }
    }

    public boolean G0(int i11) {
        View view = this.B;
        return view == null || i11 < view.getTop();
    }

    public final boolean H0() {
        return this.f59502z != null;
    }

    public final /* synthetic */ void I0(AppBarLayout appBarLayout, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f59502z.setScaleX(fFloatValue);
        this.f59502z.setScaleY(fFloatValue);
        O0(appBarLayout, (int) ((1.0f - valueAnimator.getAnimatedFraction()) * this.f59498v));
        if (this.C != null) {
            this.C.a(Math.min((fFloatValue - 1.0f) / 0.3f, 1.0f), true);
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x006e  */
    /* JADX WARN: Code duplicated, block: B:29:0x0076  */
    @Override // com.google.android.material.appbar.AppBarLayout.Behavior, com.google.android.material.appbar.HeaderBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /* JADX INFO: renamed from: J0, reason: merged with bridge method [inline-methods] */
    public boolean k(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        int iFindPointerIndex;
        uo.b.f78622a.c("FixAppBarLayoutBehavior", "---onInterceptTouchEvent isOnInterceptTouchEvent: " + super.k(coordinatorLayout, appBarLayout, motionEvent), false);
        if (!H0()) {
            return super.k(coordinatorLayout, appBarLayout, motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.E < 0) {
            this.E = ViewConfiguration.get(appBarLayout.getContext()).getScaledTouchSlop();
        }
        if (actionMasked == 0) {
            this.F = false;
            if (coordinatorLayout.isPointInChildBounds(appBarLayout, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                this.D = motionEvent.getPointerId(0);
                this.H = (int) (motionEvent.getY() + 0.5f);
                if (this.G == null) {
                    this.G = VelocityTracker.obtain();
                }
            }
        } else if (actionMasked == 1) {
            this.F = false;
            this.D = -1;
            velocityTracker = this.G;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.G = null;
            }
        } else if (actionMasked == 2) {
            int i11 = this.D;
            if (i11 != -1 && (iFindPointerIndex = motionEvent.findPointerIndex(i11)) >= 0) {
                int y11 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
                if (Math.abs(this.H - y11) > this.E) {
                    this.F = true;
                    this.H = y11;
                    return true;
                }
            }
        } else if (actionMasked == 3) {
            this.F = false;
            this.D = -1;
            velocityTracker = this.G;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.G = null;
            }
        }
        VelocityTracker velocityTracker2 = this.G;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(motionEvent);
        }
        return super.k(coordinatorLayout, appBarLayout, motionEvent);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /* JADX INFO: renamed from: K0, reason: merged with bridge method [inline-methods] */
    public boolean o(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, float f11, float f12) {
        if (f12 > 100.0f) {
            this.f59494r = false;
        }
        return super.o(coordinatorLayout, appBarLayout, view, f11, f12);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /* JADX INFO: renamed from: L0, reason: merged with bridge method [inline-methods] */
    public void s(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i11, int i12, int i13, int i14, int i15) {
        super.s(coordinatorLayout, appBarLayout, view, i11, i12, i13, i14, i15);
        T0(i14, appBarLayout, view, i15);
    }

    public final boolean M0(AppBarLayout appBarLayout, MotionEvent motionEvent) {
        float yVelocity;
        int actionMasked = motionEvent.getActionMasked();
        if (this.E < 0) {
            this.E = ViewConfiguration.get(appBarLayout.getContext()).getScaledTouchSlop();
        }
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                VelocityTracker velocityTracker = this.G;
                if (velocityTracker != null) {
                    velocityTracker.addMovement(motionEvent);
                    this.G.computeCurrentVelocity(1000);
                    yVelocity = this.G.getYVelocity(this.D);
                } else {
                    yVelocity = 0.0f;
                }
                this.f59494r = yVelocity <= 100.0f;
                P0(appBarLayout);
            } else if (actionMasked == 2) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.D);
                if (iFindPointerIndex < 0) {
                    uo.b.f78622a.h("FixAppBarLayoutBehavior", "Error processing scroll; pointer index for id " + this.D + " not found. Did any MotionEvents get skipped?", false);
                } else {
                    int y11 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
                    int i11 = this.H - y11;
                    if (!this.F) {
                        int iAbs = Math.abs(i11);
                        int i12 = this.E;
                        if (iAbs > i12) {
                            this.F = true;
                            i11 = i11 > 0 ? i11 - i12 : i11 + i12;
                        }
                    }
                    if (this.F) {
                        this.H = y11;
                        if (G0(y11)) {
                            return Q0(appBarLayout, appBarLayout, i11);
                        }
                        if (E0()) {
                            return Q0(appBarLayout, appBarLayout, i11);
                        }
                    }
                }
            } else if (actionMasked == 3) {
            }
            this.F = false;
            this.D = -1;
            VelocityTracker velocityTracker2 = this.G;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.G = null;
            }
        } else {
            this.D = motionEvent.getPointerId(0);
            this.H = (int) (motionEvent.getY() + 0.5f);
            if (this.G == null) {
                this.G = VelocityTracker.obtain();
            }
        }
        VelocityTracker velocityTracker3 = this.G;
        if (velocityTracker3 != null) {
            velocityTracker3.addMovement(motionEvent);
        }
        return false;
    }

    @Override // com.google.android.material.appbar.AppBarLayout.Behavior, com.google.android.material.appbar.HeaderBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /* JADX INFO: renamed from: N0, reason: merged with bridge method [inline-methods] */
    public boolean D(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, MotionEvent motionEvent) {
        uo.b.f78622a.c("FixAppBarLayoutBehavior", appBarLayout.getScrollY() + "   onTouchEvent " + motionEvent.toString(), false);
        if (H0() && M0(appBarLayout, motionEvent)) {
            return true;
        }
        return super.D(coordinatorLayout, appBarLayout, motionEvent);
    }

    public final void O0(ViewGroup viewGroup, int i11) {
        int childCount = viewGroup.getChildCount();
        int[] iArr = this.f59501y;
        if (iArr == null || iArr.length != childCount) {
            this.f59501y = new int[childCount];
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = viewGroup.getChildAt(i12);
                if (childAt != null) {
                    this.f59501y[i12] = childAt.getTop();
                } else {
                    this.f59501y[i12] = -1;
                }
            }
        }
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt2 = viewGroup.getChildAt(i13);
            if (childAt2.getId() != R$id.toolbar) {
                if (childAt2.getId() == R$id.collapsing) {
                    O0((ViewGroup) childAt2, i11);
                } else if (this.f59501y[i13] >= 0) {
                    childAt2.getMeasuredHeight();
                    childAt2.setTranslationY(i11);
                }
            }
        }
        ViewPager2 viewPager2 = this.A;
        if (viewPager2 != null) {
            viewPager2.setTranslationY(i11);
        }
    }

    public final void P0(final AppBarLayout appBarLayout) {
        if (!H0() || this.f59495s || this.f59497u <= 0.0f) {
            return;
        }
        this.f59495s = true;
        this.f59497u = 0.0f;
        if (this.f59494r) {
            ValueAnimator duration = ValueAnimator.ofFloat(this.f59496t, 1.0f).setDuration(300L);
            duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.transsion.usercenter.profile.a
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f59566a.I0(appBarLayout, valueAnimator);
                }
            });
            duration.addListener(new c());
            duration.start();
            return;
        }
        this.f59502z.setScaleX(1.0f);
        this.f59502z.setScaleY(1.0f);
        O0(appBarLayout, 0);
        this.f59495s = false;
        d dVar = this.C;
        if (dVar != null) {
            dVar.a(0.0f, true);
        }
    }

    public final boolean Q0(AppBarLayout appBarLayout, View view, int i11) {
        if (this.f59495s || !H0() || ((i11 >= 0 || appBarLayout.getBottom() < this.f59499w) && (i11 <= 0 || appBarLayout.getBottom() <= this.f59499w))) {
            return false;
        }
        float f11 = this.f59497u + (-i11);
        this.f59497u = f11;
        float fMin = Math.min(f11, 500.0f);
        this.f59497u = fMin;
        float fMax = Math.max(1.0f, (fMin / 500.0f) + 1.0f);
        this.f59496t = fMax;
        this.f59498v = (int) ((this.f59500x / 2) * (fMax - 1.0f));
        this.f59502z.setScaleX(fMax);
        this.f59502z.setScaleY(this.f59496t);
        O0(appBarLayout, this.f59498v);
        view.setScrollY(0);
        if (this.C == null) {
            return true;
        }
        this.C.a(Math.min((this.f59496t - 1.0f) / 0.3f, 1.0f), false);
        return true;
    }

    public final void R0() {
        u0(new a());
    }

    public void S0(d dVar) {
        this.C = dVar;
    }

    public final void T0(int i11, AppBarLayout appBarLayout, View view, int i12) {
        if (i12 == 1) {
            int iE = E();
            if ((i11 >= 0 || iE != 0) && (i11 <= 0 || iE != (-appBarLayout.getTotalScrollRange()))) {
                return;
            }
            ViewCompat.stopNestedScroll(view, 1);
        }
    }

    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, com.google.android.material.appbar.j, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /* JADX INFO: renamed from: k0 */
    public boolean l(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i11) {
        boolean zL = super.l(coordinatorLayout, appBarLayout, i11);
        if (this.f59502z == null) {
            View viewFindViewWithTag = coordinatorLayout.findViewWithTag("largeScale");
            this.f59502z = viewFindViewWithTag;
            if (viewFindViewWithTag != null) {
                appBarLayout.setClipChildren(false);
                this.f59500x = this.f59502z.getHeight();
            }
        }
        if (this.A == null) {
            this.A = (ViewPager2) coordinatorLayout.findViewWithTag("viewPager");
            D0();
        }
        if (this.B == null) {
            this.B = coordinatorLayout.findViewWithTag("emptyView");
        }
        this.f59499w = appBarLayout.getHeight();
        this.f59501y = null;
        return zL;
    }

    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /* JADX INFO: renamed from: m0 */
    public void q(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i11, int i12, int[] iArr, int i13) {
        if (E0() && Q0(appBarLayout, view, i12)) {
            return;
        }
        super.q(coordinatorLayout, appBarLayout, view, i11, i12, iArr, i13);
        T0(i12, appBarLayout, view, i13);
    }

    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /* JADX INFO: renamed from: q0 */
    public boolean A(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i11, int i12) {
        this.f59494r = true;
        return super.A(coordinatorLayout, appBarLayout, view, view2, i11, i12);
    }

    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /* JADX INFO: renamed from: r0 */
    public void C(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i11) {
        if (H0()) {
            P0(appBarLayout);
        }
        super.C(coordinatorLayout, appBarLayout, view, i11);
    }
}
