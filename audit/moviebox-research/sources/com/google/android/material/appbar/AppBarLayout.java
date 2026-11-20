package com.google.android.material.appbar;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$integer;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.b0;
import com.google.logging.type.LogSeverity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class AppBarLayout extends LinearLayout implements CoordinatorLayout.b {
    public static final int A = R$style.Widget_Design_AppBarLayout;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f36087a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f36088b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f36089c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f36090d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f36091f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f36092g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public WindowInsetsCompat f36093h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<b> f36094i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f36095j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f36096k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f36097l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f36098m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f36099n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    public WeakReference<View> f36100o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f36101p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    public ValueAnimator f36102q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Nullable
    public ValueAnimator.AnimatorUpdateListener f36103r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final List<f> f36104s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final long f36105t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final TimeInterpolator f36106u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int[] f36107v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @Nullable
    public Drawable f36108w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @Nullable
    public Integer f36109x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final float f36110y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Behavior f36111z;

    /* JADX INFO: compiled from: source.java */
    public static class BaseBehavior<T extends AppBarLayout> extends HeaderBehavior<T> {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f36112l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f36113m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public ValueAnimator f36114n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public SavedState f36115o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        @Nullable
        public WeakReference<View> f36116p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public c f36117q;

        /* JADX INFO: compiled from: source.java */
        public static class SavedState extends AbsSavedState {
            public static final Parcelable.Creator<SavedState> CREATOR = new a();
            boolean firstVisibleChildAtMinimumHeight;
            int firstVisibleChildIndex;
            float firstVisibleChildPercentageShown;
            boolean fullyExpanded;
            boolean fullyScrolled;

            /* JADX INFO: compiled from: source.java */
            public class a implements Parcelable.ClassLoaderCreator<SavedState> {
                @Override // android.os.Parcelable.Creator
                @Nullable
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public SavedState createFromParcel(@NonNull Parcel parcel) {
                    return new SavedState(parcel, null);
                }

                @Override // android.os.Parcelable.ClassLoaderCreator
                @NonNull
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                    return new SavedState(parcel, classLoader);
                }

                @Override // android.os.Parcelable.Creator
                @NonNull
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public SavedState[] newArray(int i11) {
                    return new SavedState[i11];
                }
            }

            public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.fullyScrolled = parcel.readByte() != 0;
                this.fullyExpanded = parcel.readByte() != 0;
                this.firstVisibleChildIndex = parcel.readInt();
                this.firstVisibleChildPercentageShown = parcel.readFloat();
                this.firstVisibleChildAtMinimumHeight = parcel.readByte() != 0;
            }

            public SavedState(Parcelable parcelable) {
                super(parcelable);
            }

            @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
            public void writeToParcel(@NonNull Parcel parcel, int i11) {
                super.writeToParcel(parcel, i11);
                parcel.writeByte(this.fullyScrolled ? (byte) 1 : (byte) 0);
                parcel.writeByte(this.fullyExpanded ? (byte) 1 : (byte) 0);
                parcel.writeInt(this.firstVisibleChildIndex);
                parcel.writeFloat(this.firstVisibleChildPercentageShown);
                parcel.writeByte(this.firstVisibleChildAtMinimumHeight ? (byte) 1 : (byte) 0);
            }
        }

        /* JADX INFO: compiled from: source.java */
        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CoordinatorLayout f36118a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ AppBarLayout f36119b;

            public a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
                this.f36118a = coordinatorLayout;
                this.f36119b = appBarLayout;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                BaseBehavior.this.P(this.f36118a, this.f36119b, ((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }

        /* JADX INFO: compiled from: source.java */
        public class b extends AccessibilityDelegateCompat {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AppBarLayout f36121a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ CoordinatorLayout f36122b;

            public b(AppBarLayout appBarLayout, CoordinatorLayout coordinatorLayout) {
                this.f36121a = appBarLayout;
                this.f36122b = coordinatorLayout;
            }

            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                View viewF0;
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.setClassName(ScrollView.class.getName());
                if (this.f36121a.getTotalScrollRange() == 0 || (viewF0 = BaseBehavior.this.f0(this.f36122b)) == null || !BaseBehavior.this.b0(this.f36121a)) {
                    return;
                }
                if (BaseBehavior.this.M() != (-this.f36121a.getTotalScrollRange())) {
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                    accessibilityNodeInfoCompat.setScrollable(true);
                }
                if (BaseBehavior.this.M() != 0) {
                    if (!viewF0.canScrollVertically(-1)) {
                        accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                        accessibilityNodeInfoCompat.setScrollable(true);
                    } else if ((-this.f36121a.getDownNestedPreScrollRange()) != 0) {
                        accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                        accessibilityNodeInfoCompat.setScrollable(true);
                    }
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public boolean performAccessibilityAction(View view, int i11, Bundle bundle) {
                if (i11 == 4096) {
                    this.f36121a.setExpanded(false);
                    return true;
                }
                if (i11 != 8192) {
                    return super.performAccessibilityAction(view, i11, bundle);
                }
                if (BaseBehavior.this.M() != 0) {
                    View viewF0 = BaseBehavior.this.f0(this.f36122b);
                    if (!viewF0.canScrollVertically(-1)) {
                        this.f36121a.setExpanded(true);
                        return true;
                    }
                    int i12 = -this.f36121a.getDownNestedPreScrollRange();
                    if (i12 != 0) {
                        BaseBehavior.this.q(this.f36122b, this.f36121a, viewF0, 0, i12, new int[]{0, 0}, 1);
                        return true;
                    }
                }
                return false;
            }
        }

        /* JADX INFO: compiled from: source.java */
        public static abstract class c<T extends AppBarLayout> {
            public abstract boolean a(@NonNull T t11);
        }

        public BaseBehavior() {
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public static boolean a0(int i11, int i12) {
            return (i11 & i12) == i12;
        }

        @Nullable
        public static View d0(@NonNull AppBarLayout appBarLayout, int i11) {
            int iAbs = Math.abs(i11);
            int childCount = appBarLayout.getChildCount();
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = appBarLayout.getChildAt(i12);
                if (iAbs >= childAt.getTop() && iAbs <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        public int M() {
            return E() + this.f36112l;
        }

        public final void U(CoordinatorLayout coordinatorLayout, @NonNull T t11) {
            if (ViewCompat.hasAccessibilityDelegate(coordinatorLayout)) {
                return;
            }
            ViewCompat.setAccessibilityDelegate(coordinatorLayout, new b(t11, coordinatorLayout));
        }

        public final void V(CoordinatorLayout coordinatorLayout, @NonNull T t11, int i11, float f11) {
            int iAbs = Math.abs(M() - i11);
            float fAbs = Math.abs(f11);
            W(coordinatorLayout, t11, i11, fAbs > 0.0f ? Math.round((iAbs / fAbs) * 1000.0f) * 3 : (int) (((iAbs / t11.getHeight()) + 1.0f) * 150.0f));
        }

        public final void W(CoordinatorLayout coordinatorLayout, T t11, int i11, int i12) {
            int iM = M();
            if (iM == i11) {
                ValueAnimator valueAnimator = this.f36114n;
                if (valueAnimator == null || !valueAnimator.isRunning()) {
                    return;
                }
                this.f36114n.cancel();
                return;
            }
            ValueAnimator valueAnimator2 = this.f36114n;
            if (valueAnimator2 == null) {
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this.f36114n = valueAnimator3;
                valueAnimator3.setInterpolator(ii.b.f67205e);
                this.f36114n.addUpdateListener(new a(coordinatorLayout, t11));
            } else {
                valueAnimator2.cancel();
            }
            this.f36114n.setDuration(Math.min(i12, LogSeverity.CRITICAL_VALUE));
            this.f36114n.setIntValues(iM, i11);
            this.f36114n.start();
        }

        public final int X(int i11, int i12, int i13) {
            return i11 < (i12 + i13) / 2 ? i12 : i13;
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        /* JADX INFO: renamed from: Y, reason: merged with bridge method [inline-methods] */
        public boolean H(T t11) {
            c cVar = this.f36117q;
            if (cVar != null) {
                return cVar.a(t11);
            }
            WeakReference<View> weakReference = this.f36116p;
            if (weakReference == null) {
                return true;
            }
            View view = weakReference.get();
            return (view == null || !view.isShown() || view.canScrollVertically(-1)) ? false : true;
        }

        public final boolean Z(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t11, @NonNull View view) {
            return t11.j() && coordinatorLayout.getHeight() - view.getHeight() <= t11.getHeight();
        }

        public final boolean b0(AppBarLayout appBarLayout) {
            int childCount = appBarLayout.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                if (((e) appBarLayout.getChildAt(i11).getLayoutParams()).f36127a != 0) {
                    return true;
                }
            }
            return false;
        }

        @Nullable
        public final View c0(@NonNull CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = coordinatorLayout.getChildAt(i11);
                if ((childAt instanceof NestedScrollingChild) || (childAt instanceof AbsListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        public final int e0(@NonNull T t11, int i11) {
            int childCount = t11.getChildCount();
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = t11.getChildAt(i12);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                e eVar = (e) childAt.getLayoutParams();
                if (a0(eVar.c(), 32)) {
                    top -= ((LinearLayout.LayoutParams) eVar).topMargin;
                    bottom += ((LinearLayout.LayoutParams) eVar).bottomMargin;
                }
                int i13 = -i11;
                if (top <= i13 && bottom >= i13) {
                    return i12;
                }
            }
            return -1;
        }

        @Nullable
        public final View f0(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = coordinatorLayout.getChildAt(i11);
                if (((CoordinatorLayout.f) childAt.getLayoutParams()).f() instanceof ScrollingViewBehavior) {
                    return childAt;
                }
            }
            return null;
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        /* JADX INFO: renamed from: g0, reason: merged with bridge method [inline-methods] */
        public int K(@NonNull T t11) {
            return (-t11.getDownNestedScrollRange()) + t11.getTopInset();
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        /* JADX INFO: renamed from: h0, reason: merged with bridge method [inline-methods] */
        public int L(@NonNull T t11) {
            return t11.getTotalScrollRange();
        }

        public final int i0(@NonNull T t11, int i11) {
            int iAbs = Math.abs(i11);
            int childCount = t11.getChildCount();
            int topInset = 0;
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = t11.getChildAt(i12);
                e eVar = (e) childAt.getLayoutParams();
                Interpolator interpolatorD = eVar.d();
                if (iAbs >= childAt.getTop() && iAbs <= childAt.getBottom()) {
                    if (interpolatorD == null) {
                        break;
                    }
                    int iC = eVar.c();
                    if ((iC & 1) != 0) {
                        topInset = childAt.getHeight() + ((LinearLayout.LayoutParams) eVar).topMargin + ((LinearLayout.LayoutParams) eVar).bottomMargin;
                        if ((iC & 2) != 0) {
                            topInset -= ViewCompat.getMinimumHeight(childAt);
                        }
                    }
                    if (ViewCompat.getFitsSystemWindows(childAt)) {
                        topInset -= t11.getTopInset();
                    }
                    if (topInset <= 0) {
                        break;
                    }
                    float f11 = topInset;
                    return Integer.signum(i11) * (childAt.getTop() + Math.round(f11 * interpolatorD.getInterpolation((iAbs - childAt.getTop()) / f11)));
                }
            }
            return i11;
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        /* JADX INFO: renamed from: j0, reason: merged with bridge method [inline-methods] */
        public void N(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t11) {
            x0(coordinatorLayout, t11);
            if (t11.isLiftOnScroll()) {
                t11.v(t11.y(c0(coordinatorLayout)));
            }
        }

        @Override // com.google.android.material.appbar.j, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: k0, reason: merged with bridge method [inline-methods] */
        public boolean l(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t11, int i11) {
            boolean zL = super.l(coordinatorLayout, t11, i11);
            int pendingAction = t11.getPendingAction();
            SavedState savedState = this.f36115o;
            if (savedState == null || (pendingAction & 8) != 0) {
                if (pendingAction != 0) {
                    boolean z11 = (pendingAction & 4) != 0;
                    if ((pendingAction & 2) != 0) {
                        int i12 = -t11.getUpNestedPreScrollRange();
                        if (z11) {
                            V(coordinatorLayout, t11, i12, 0.0f);
                        } else {
                            P(coordinatorLayout, t11, i12);
                        }
                    } else if ((pendingAction & 1) != 0) {
                        if (z11) {
                            V(coordinatorLayout, t11, 0, 0.0f);
                        } else {
                            P(coordinatorLayout, t11, 0);
                        }
                    }
                }
            } else if (savedState.fullyScrolled) {
                P(coordinatorLayout, t11, -t11.getTotalScrollRange());
            } else if (savedState.fullyExpanded) {
                P(coordinatorLayout, t11, 0);
            } else {
                View childAt = t11.getChildAt(savedState.firstVisibleChildIndex);
                P(coordinatorLayout, t11, (-childAt.getBottom()) + (this.f36115o.firstVisibleChildAtMinimumHeight ? ViewCompat.getMinimumHeight(childAt) + t11.getTopInset() : Math.round(childAt.getHeight() * this.f36115o.firstVisibleChildPercentageShown)));
            }
            t11.s();
            this.f36115o = null;
            G(g3.a.b(E(), -t11.getTotalScrollRange(), 0));
            y0(coordinatorLayout, t11, E(), 0, true);
            t11.q(E());
            U(coordinatorLayout, t11);
            return zL;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: l0, reason: merged with bridge method [inline-methods] */
        public boolean m(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t11, int i11, int i12, int i13, int i14) {
            if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) t11.getLayoutParams())).height != -2) {
                return super.m(coordinatorLayout, t11, i11, i12, i13, i14);
            }
            coordinatorLayout.onMeasureChild(t11, i11, i12, View.MeasureSpec.makeMeasureSpec(0, 0), i14);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: m0, reason: merged with bridge method [inline-methods] */
        public void q(CoordinatorLayout coordinatorLayout, @NonNull T t11, View view, int i11, int i12, int[] iArr, int i13) {
            int i14;
            int downNestedPreScrollRange;
            if (i12 != 0) {
                if (i12 < 0) {
                    int i15 = -t11.getTotalScrollRange();
                    i14 = i15;
                    downNestedPreScrollRange = t11.getDownNestedPreScrollRange() + i15;
                } else {
                    i14 = -t11.getUpNestedPreScrollRange();
                    downNestedPreScrollRange = 0;
                }
                if (i14 != downNestedPreScrollRange) {
                    iArr[1] = O(coordinatorLayout, t11, i12, i14, downNestedPreScrollRange);
                }
            }
            if (t11.isLiftOnScroll()) {
                t11.v(t11.y(view));
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: n0, reason: merged with bridge method [inline-methods] */
        public void t(CoordinatorLayout coordinatorLayout, @NonNull T t11, View view, int i11, int i12, int i13, int i14, int i15, int[] iArr) {
            if (i14 < 0) {
                iArr[1] = O(coordinatorLayout, t11, i14, -t11.getDownNestedScrollRange(), 0);
            }
            if (i14 == 0) {
                U(coordinatorLayout, t11);
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: o0, reason: merged with bridge method [inline-methods] */
        public void x(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t11, Parcelable parcelable) {
            if (parcelable instanceof SavedState) {
                s0((SavedState) parcelable, true);
                super.x(coordinatorLayout, t11, this.f36115o.getSuperState());
            } else {
                super.x(coordinatorLayout, t11, parcelable);
                this.f36115o = null;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: p0, reason: merged with bridge method [inline-methods] */
        public Parcelable y(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t11) {
            Parcelable parcelableY = super.y(coordinatorLayout, t11);
            SavedState savedStateT0 = t0(parcelableY, t11);
            return savedStateT0 == null ? parcelableY : savedStateT0;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: q0, reason: merged with bridge method [inline-methods] */
        public boolean A(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t11, @NonNull View view, View view2, int i11, int i12) {
            ValueAnimator valueAnimator;
            boolean z11 = (i11 & 2) != 0 && (t11.isLiftOnScroll() || Z(coordinatorLayout, t11, view));
            if (z11 && (valueAnimator = this.f36114n) != null) {
                valueAnimator.cancel();
            }
            this.f36116p = null;
            this.f36113m = i12;
            return z11;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: r0, reason: merged with bridge method [inline-methods] */
        public void C(CoordinatorLayout coordinatorLayout, @NonNull T t11, View view, int i11) {
            if (this.f36113m == 0 || i11 == 1) {
                x0(coordinatorLayout, t11);
                if (t11.isLiftOnScroll()) {
                    t11.v(t11.y(view));
                }
            }
            this.f36116p = new WeakReference<>(view);
        }

        public void s0(@Nullable SavedState savedState, boolean z11) {
            if (this.f36115o == null || z11) {
                this.f36115o = savedState;
            }
        }

        @Nullable
        public SavedState t0(@Nullable Parcelable parcelable, @NonNull T t11) {
            int iE = E();
            int childCount = t11.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = t11.getChildAt(i11);
                int bottom = childAt.getBottom() + iE;
                if (childAt.getTop() + iE <= 0 && bottom >= 0) {
                    if (parcelable == null) {
                        parcelable = AbsSavedState.EMPTY_STATE;
                    }
                    SavedState savedState = new SavedState(parcelable);
                    boolean z11 = iE == 0;
                    savedState.fullyExpanded = z11;
                    savedState.fullyScrolled = !z11 && (-iE) >= t11.getTotalScrollRange();
                    savedState.firstVisibleChildIndex = i11;
                    savedState.firstVisibleChildAtMinimumHeight = bottom == ViewCompat.getMinimumHeight(childAt) + t11.getTopInset();
                    savedState.firstVisibleChildPercentageShown = bottom / childAt.getHeight();
                    return savedState;
                }
            }
            return null;
        }

        public void u0(@Nullable c cVar) {
            this.f36117q = cVar;
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        /* JADX INFO: renamed from: v0, reason: merged with bridge method [inline-methods] */
        public int Q(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t11, int i11, int i12, int i13) {
            int iM = M();
            int i14 = 0;
            if (i12 == 0 || iM < i12 || iM > i13) {
                this.f36112l = 0;
            } else {
                int iB = g3.a.b(i11, i12, i13);
                if (iM != iB) {
                    int iI0 = t11.h() ? i0(t11, iB) : iB;
                    boolean zG = G(iI0);
                    int i15 = iM - iB;
                    this.f36112l = iB - iI0;
                    if (zG) {
                        while (i14 < t11.getChildCount()) {
                            e eVar = (e) t11.getChildAt(i14).getLayoutParams();
                            c cVarB = eVar.b();
                            if (cVarB != null && (eVar.c() & 1) != 0) {
                                cVarB.a(t11, t11.getChildAt(i14), E());
                            }
                            i14++;
                        }
                    }
                    if (!zG && t11.h()) {
                        coordinatorLayout.dispatchDependentViewsChanged(t11);
                    }
                    t11.q(E());
                    y0(coordinatorLayout, t11, iB, iB < iM ? -1 : 1, false);
                    i14 = i15;
                }
            }
            U(coordinatorLayout, t11);
            return i14;
        }

        public final boolean w0(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t11) {
            List<View> dependents = coordinatorLayout.getDependents(t11);
            int size = dependents.size();
            for (int i11 = 0; i11 < size; i11++) {
                CoordinatorLayout.c cVarF = ((CoordinatorLayout.f) dependents.get(i11).getLayoutParams()).f();
                if (cVarF instanceof ScrollingViewBehavior) {
                    return ((ScrollingViewBehavior) cVarF).K() != 0;
                }
            }
            return false;
        }

        public final void x0(CoordinatorLayout coordinatorLayout, @NonNull T t11) {
            int topInset = t11.getTopInset() + t11.getPaddingTop();
            int iM = M() - topInset;
            int iE0 = e0(t11, iM);
            if (iE0 >= 0) {
                View childAt = t11.getChildAt(iE0);
                e eVar = (e) childAt.getLayoutParams();
                int iC = eVar.c();
                if ((iC & 17) == 17) {
                    int topInset2 = -childAt.getTop();
                    int minimumHeight = -childAt.getBottom();
                    if (iE0 == 0 && ViewCompat.getFitsSystemWindows(t11) && ViewCompat.getFitsSystemWindows(childAt)) {
                        topInset2 -= t11.getTopInset();
                    }
                    if (a0(iC, 2)) {
                        minimumHeight += ViewCompat.getMinimumHeight(childAt);
                    } else if (a0(iC, 5)) {
                        int minimumHeight2 = ViewCompat.getMinimumHeight(childAt) + minimumHeight;
                        if (iM < minimumHeight2) {
                            topInset2 = minimumHeight2;
                        } else {
                            minimumHeight = minimumHeight2;
                        }
                    }
                    if (a0(iC, 32)) {
                        topInset2 += ((LinearLayout.LayoutParams) eVar).topMargin;
                        minimumHeight -= ((LinearLayout.LayoutParams) eVar).bottomMargin;
                    }
                    V(coordinatorLayout, t11, g3.a.b(X(iM, minimumHeight, topInset2) + topInset, -t11.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        public final void y0(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t11, int i11, int i12, boolean z11) {
            View viewD0 = d0(t11, i11);
            boolean zY = false;
            if (viewD0 != null) {
                int iC = ((e) viewD0.getLayoutParams()).c();
                if ((iC & 1) != 0) {
                    int minimumHeight = ViewCompat.getMinimumHeight(viewD0);
                    if (i12 <= 0 || (iC & 12) == 0 ? !((iC & 2) == 0 || (-i11) < (viewD0.getBottom() - minimumHeight) - t11.getTopInset()) : (-i11) >= (viewD0.getBottom() - minimumHeight) - t11.getTopInset()) {
                        zY = true;
                    }
                }
            }
            if (t11.isLiftOnScroll()) {
                zY = t11.y(c0(coordinatorLayout));
            }
            boolean zV = t11.v(zY);
            if (z11 || (zV && w0(coordinatorLayout, t11))) {
                if (t11.getBackground() != null) {
                    t11.getBackground().jumpToCurrentState();
                }
                if (Build.VERSION.SDK_INT >= 23 && t11.getForeground() != null) {
                    t11.getForeground().jumpToCurrentState();
                }
                if (t11.getStateListAnimator() != null) {
                    t11.getStateListAnimator().jumpToCurrentState();
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class Behavior extends BaseBehavior<AppBarLayout> {

        /* JADX INFO: compiled from: source.java */
        public static abstract class a extends BaseBehavior.c<AppBarLayout> {
        }

        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // com.google.android.material.appbar.HeaderBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean D(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull MotionEvent motionEvent) {
            return super.D(coordinatorLayout, view, motionEvent);
        }

        @Override // com.google.android.material.appbar.j
        public /* bridge */ /* synthetic */ int E() {
            return super.E();
        }

        @Override // com.google.android.material.appbar.j
        public /* bridge */ /* synthetic */ boolean G(int i11) {
            return super.G(i11);
        }

        @Override // com.google.android.material.appbar.HeaderBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean k(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull MotionEvent motionEvent) {
            return super.k(coordinatorLayout, view, motionEvent);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: k0 */
        public /* bridge */ /* synthetic */ boolean l(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, int i11) {
            return super.l(coordinatorLayout, appBarLayout, i11);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: l0 */
        public /* bridge */ /* synthetic */ boolean m(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, int i11, int i12, int i13, int i14) {
            return super.m(coordinatorLayout, appBarLayout, i11, i12, i13, i14);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: m0 */
        public /* bridge */ /* synthetic */ void q(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, View view, int i11, int i12, int[] iArr, int i13) {
            super.q(coordinatorLayout, appBarLayout, view, i11, i12, iArr, i13);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: n0 */
        public /* bridge */ /* synthetic */ void t(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, View view, int i11, int i12, int i13, int i14, int i15, int[] iArr) {
            super.t(coordinatorLayout, appBarLayout, view, i11, i12, i13, i14, i15, iArr);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: o0 */
        public /* bridge */ /* synthetic */ void x(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, Parcelable parcelable) {
            super.x(coordinatorLayout, appBarLayout, parcelable);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: p0 */
        public /* bridge */ /* synthetic */ Parcelable y(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout) {
            return super.y(coordinatorLayout, appBarLayout);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: q0 */
        public /* bridge */ /* synthetic */ boolean A(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, View view2, int i11, int i12) {
            return super.A(coordinatorLayout, appBarLayout, view, view2, i11, i12);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: r0 */
        public /* bridge */ /* synthetic */ void C(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, View view, int i11) {
            super.C(coordinatorLayout, appBarLayout, view, i11);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void u0(@Nullable BaseBehavior.c cVar) {
            super.u0(cVar);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class ScrollingViewBehavior extends i {
        public ScrollingViewBehavior() {
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ScrollingViewBehavior_Layout);
            O(typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
            typedArrayObtainStyledAttributes.recycle();
        }

        public static int R(@NonNull AppBarLayout appBarLayout) {
            CoordinatorLayout.c cVarF = ((CoordinatorLayout.f) appBarLayout.getLayoutParams()).f();
            if (cVarF instanceof BaseBehavior) {
                return ((BaseBehavior) cVarF).M();
            }
            return 0;
        }

        @Override // com.google.android.material.appbar.i
        public float J(View view) {
            int i11;
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                int iR = R(appBarLayout);
                if ((downNestedPreScrollRange == 0 || totalScrollRange + iR > downNestedPreScrollRange) && (i11 = totalScrollRange - downNestedPreScrollRange) != 0) {
                    return (iR / i11) + 1.0f;
                }
            }
            return 0.0f;
        }

        @Override // com.google.android.material.appbar.i
        public int L(View view) {
            return view instanceof AppBarLayout ? ((AppBarLayout) view).getTotalScrollRange() : super.L(view);
        }

        @Override // com.google.android.material.appbar.i
        @Nullable
        /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
        public AppBarLayout H(@NonNull List<View> list) {
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                View view = list.get(i11);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        public final void S(@NonNull View view, @NonNull View view2) {
            CoordinatorLayout.c cVarF = ((CoordinatorLayout.f) view2.getLayoutParams()).f();
            if (cVarF instanceof BaseBehavior) {
                ViewCompat.offsetTopAndBottom(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) cVarF).f36112l) + M()) - I(view2));
            }
        }

        public final void T(View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (appBarLayout.isLiftOnScroll()) {
                    appBarLayout.v(appBarLayout.y(view));
                }
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean e(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean h(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2) {
            S(view, view2);
            T(view, view2);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void i(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2) {
            if (view2 instanceof AppBarLayout) {
                ViewCompat.setAccessibilityDelegate(coordinatorLayout, null);
            }
        }

        @Override // com.google.android.material.appbar.j, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean l(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i11) {
            return super.l(coordinatorLayout, view, i11);
        }

        @Override // com.google.android.material.appbar.i, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean m(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i11, int i12, int i13, int i14) {
            return super.m(coordinatorLayout, view, i11, i12, i13, i14);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean w(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull Rect rect, boolean z11) {
            AppBarLayout appBarLayoutH = H(coordinatorLayout.getDependencies(view));
            if (appBarLayoutH != null) {
                Rect rect2 = new Rect(rect);
                rect2.offset(view.getLeft(), view.getTop());
                Rect rect3 = this.f36179d;
                rect3.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect3.contains(rect2)) {
                    appBarLayoutH.setExpanded(false, !z11);
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a implements OnApplyWindowInsetsListener {
        public a() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            return AppBarLayout.this.r(windowInsetsCompat);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b<T extends AppBarLayout> {
        void a(T t11, int i11);
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class c {
        public abstract void a(@NonNull AppBarLayout appBarLayout, @NonNull View view, float f11);
    }

    /* JADX INFO: compiled from: source.java */
    public static class d extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Rect f36125a = new Rect();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Rect f36126b = new Rect();

        public static void b(Rect rect, AppBarLayout appBarLayout, View view) {
            view.getDrawingRect(rect);
            appBarLayout.offsetDescendantRectToMyCoords(view, rect);
            rect.offset(0, -appBarLayout.getTopInset());
        }

        @Override // com.google.android.material.appbar.AppBarLayout.c
        public void a(@NonNull AppBarLayout appBarLayout, @NonNull View view, float f11) {
            b(this.f36125a, appBarLayout, view);
            float fAbs = this.f36125a.top - Math.abs(f11);
            if (fAbs > 0.0f) {
                ViewCompat.setClipBounds(view, null);
                view.setTranslationY(0.0f);
                view.setVisibility(0);
                return;
            }
            float fA = 1.0f - g3.a.a(Math.abs(fAbs / this.f36125a.height()), 0.0f, 1.0f);
            float fHeight = (-fAbs) - ((this.f36125a.height() * 0.3f) * (1.0f - (fA * fA)));
            view.setTranslationY(fHeight);
            view.getDrawingRect(this.f36126b);
            this.f36126b.offset(0, (int) (-fHeight));
            if (fHeight >= this.f36126b.height()) {
                view.setVisibility(4);
            } else {
                view.setVisibility(0);
            }
            ViewCompat.setClipBounds(view, this.f36126b);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class e extends LinearLayout.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f36127a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public c f36128b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Interpolator f36129c;

        public e(int i11, int i12) {
            super(i11, i12);
            this.f36127a = 1;
        }

        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f36127a = 1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.AppBarLayout_Layout);
            this.f36127a = typedArrayObtainStyledAttributes.getInt(R$styleable.AppBarLayout_Layout_layout_scrollFlags, 0);
            f(typedArrayObtainStyledAttributes.getInt(R$styleable.AppBarLayout_Layout_layout_scrollEffect, 0));
            if (typedArrayObtainStyledAttributes.hasValue(R$styleable.AppBarLayout_Layout_layout_scrollInterpolator)) {
                this.f36129c = AnimationUtils.loadInterpolator(context, typedArrayObtainStyledAttributes.getResourceId(R$styleable.AppBarLayout_Layout_layout_scrollInterpolator, 0));
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f36127a = 1;
        }

        public e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f36127a = 1;
        }

        @RequiresApi(19)
        public e(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.f36127a = 1;
        }

        @Nullable
        public final c a(int i11) {
            if (i11 != 1) {
                return null;
            }
            return new d();
        }

        @Nullable
        public c b() {
            return this.f36128b;
        }

        public int c() {
            return this.f36127a;
        }

        public Interpolator d() {
            return this.f36129c;
        }

        public boolean e() {
            int i11 = this.f36127a;
            return (i11 & 1) == 1 && (i11 & 10) != 0;
        }

        public void f(int i11) {
            this.f36128b = a(i11);
        }

        public void g(int i11) {
            this.f36127a = i11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface f {
        void a(float f11, int i11);
    }

    /* JADX INFO: compiled from: source.java */
    public interface g extends b<AppBarLayout> {
    }

    public AppBarLayout(@NonNull Context context) {
        this(context, null);
    }

    public AppBarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.appBarLayoutStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AppBarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        int i12 = A;
        super(zi.a.c(context, attributeSet, i11, i12), attributeSet, i11);
        this.f36088b = -1;
        this.f36089c = -1;
        this.f36090d = -1;
        this.f36092g = 0;
        this.f36104s = new ArrayList();
        Context context2 = getContext();
        setOrientation(1);
        int i13 = Build.VERSION.SDK_INT;
        if (getOutlineProvider() == ViewOutlineProvider.BACKGROUND) {
            l.a(this);
        }
        l.c(this, attributeSet, i11, i12);
        TypedArray typedArrayI = b0.i(context2, attributeSet, R$styleable.AppBarLayout, i11, i12, new int[0]);
        ViewCompat.setBackground(this, typedArrayI.getDrawable(R$styleable.AppBarLayout_android_background));
        ColorStateList colorStateListA = vi.d.a(context2, typedArrayI, R$styleable.AppBarLayout_liftOnScrollColor);
        this.f36101p = colorStateListA != null;
        ColorStateList colorStateListG = oi.f.g(getBackground());
        if (colorStateListG != null) {
            yi.i iVar = new yi.i();
            iVar.d0(colorStateListG);
            if (colorStateListA != null) {
                k(iVar, colorStateListG, colorStateListA);
            } else {
                l(context2, iVar);
            }
        }
        this.f36105t = ti.j.f(context2, R$attr.motionDurationMedium2, getResources().getInteger(R$integer.app_bar_elevation_anim_duration));
        this.f36106u = ti.j.g(context2, R$attr.motionEasingStandardInterpolator, ii.b.f67201a);
        if (typedArrayI.hasValue(R$styleable.AppBarLayout_expanded)) {
            t(typedArrayI.getBoolean(R$styleable.AppBarLayout_expanded, false), false, false);
        }
        if (typedArrayI.hasValue(R$styleable.AppBarLayout_elevation)) {
            l.b(this, typedArrayI.getDimensionPixelSize(R$styleable.AppBarLayout_elevation, 0));
        }
        if (i13 >= 26) {
            if (typedArrayI.hasValue(R$styleable.AppBarLayout_android_keyboardNavigationCluster)) {
                setKeyboardNavigationCluster(typedArrayI.getBoolean(R$styleable.AppBarLayout_android_keyboardNavigationCluster, false));
            }
            if (typedArrayI.hasValue(R$styleable.AppBarLayout_android_touchscreenBlocksFocus)) {
                setTouchscreenBlocksFocus(typedArrayI.getBoolean(R$styleable.AppBarLayout_android_touchscreenBlocksFocus, false));
            }
        }
        this.f36110y = getResources().getDimension(R$dimen.design_appbar_elevation);
        this.f36098m = typedArrayI.getBoolean(R$styleable.AppBarLayout_liftOnScroll, false);
        this.f36099n = typedArrayI.getResourceId(R$styleable.AppBarLayout_liftOnScrollTargetViewId, -1);
        setStatusBarForeground(typedArrayI.getDrawable(R$styleable.AppBarLayout_statusBarForeground));
        typedArrayI.recycle();
        ViewCompat.setOnApplyWindowInsetsListener(this, new a());
    }

    public final void A(float f11, float f12) {
        ValueAnimator valueAnimator = this.f36102q;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f11, f12);
        this.f36102q = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(this.f36105t);
        this.f36102q.setInterpolator(this.f36106u);
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = this.f36103r;
        if (animatorUpdateListener != null) {
            this.f36102q.addUpdateListener(animatorUpdateListener);
        }
        this.f36102q.start();
    }

    public final void B() {
        setWillNotDraw(!x());
    }

    public void addLiftOnScrollListener(@NonNull f fVar) {
        this.f36104s.add(fVar);
    }

    public void addOnOffsetChangedListener(@Nullable b bVar) {
        if (this.f36094i == null) {
            this.f36094i = new ArrayList();
        }
        if (bVar == null || this.f36094i.contains(bVar)) {
            return;
        }
        this.f36094i.add(bVar);
    }

    public void addOnOffsetChangedListener(g gVar) {
        addOnOffsetChangedListener((b) gVar);
    }

    public final void c() {
        WeakReference<View> weakReference = this.f36100o;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f36100o = null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e;
    }

    public void clearLiftOnScrollListener() {
        this.f36104s.clear();
    }

    @Nullable
    public final Integer d() {
        Drawable drawable = this.f36108w;
        if (drawable instanceof yi.i) {
            return Integer.valueOf(((yi.i) drawable).C());
        }
        ColorStateList colorStateListG = oi.f.g(drawable);
        if (colorStateListG != null) {
            return Integer.valueOf(colorStateListG.getDefaultColor());
        }
        return null;
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        if (x()) {
            int iSave = canvas.save();
            canvas.translate(0.0f, -this.f36087a);
            this.f36108w.draw(canvas);
            canvas.restoreToCount(iSave);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f36108w;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidateDrawable(drawable);
        }
    }

    @Nullable
    public final View e(@Nullable View view) {
        int i11;
        if (this.f36100o == null && (i11 = this.f36099n) != -1) {
            View viewFindViewById = view != null ? view.findViewById(i11) : null;
            if (viewFindViewById == null && (getParent() instanceof ViewGroup)) {
                viewFindViewById = ((ViewGroup) getParent()).findViewById(this.f36099n);
            }
            if (viewFindViewById != null) {
                this.f36100o = new WeakReference<>(viewFindViewById);
            }
        }
        WeakReference<View> weakReference = this.f36100o;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public e generateDefaultLayoutParams() {
        return new e(-1, -2);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public e generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            return new e((LinearLayout.LayoutParams) layoutParams);
        }
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new e((ViewGroup.MarginLayoutParams) layoutParams) : new e(layoutParams);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    @NonNull
    public CoordinatorLayout.c<AppBarLayout> getBehavior() {
        Behavior behavior = new Behavior();
        this.f36111z = behavior;
        return behavior;
    }

    public int getDownNestedPreScrollRange() {
        int iMin;
        int minimumHeight;
        int i11 = this.f36089c;
        if (i11 != -1) {
            return i11;
        }
        int i12 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int i13 = eVar.f36127a;
                if ((i13 & 5) != 5) {
                    if (i12 > 0) {
                        break;
                    }
                } else {
                    int i14 = ((LinearLayout.LayoutParams) eVar).topMargin + ((LinearLayout.LayoutParams) eVar).bottomMargin;
                    if ((i13 & 8) != 0) {
                        minimumHeight = ViewCompat.getMinimumHeight(childAt);
                    } else {
                        if ((i13 & 2) != 0) {
                            minimumHeight = measuredHeight - ViewCompat.getMinimumHeight(childAt);
                        } else {
                            iMin = i14 + measuredHeight;
                        }
                        if (childCount == 0 && ViewCompat.getFitsSystemWindows(childAt)) {
                            iMin = Math.min(iMin, measuredHeight - getTopInset());
                        }
                        i12 += iMin;
                    }
                    iMin = i14 + minimumHeight;
                    if (childCount == 0) {
                        iMin = Math.min(iMin, measuredHeight - getTopInset());
                    }
                    i12 += iMin;
                }
            }
        }
        int iMax = Math.max(0, i12);
        this.f36089c = iMax;
        return iMax;
    }

    public int getDownNestedScrollRange() {
        int i11 = this.f36090d;
        if (i11 != -1) {
            return i11;
        }
        int childCount = getChildCount();
        int minimumHeight = 0;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight() + ((LinearLayout.LayoutParams) eVar).topMargin + ((LinearLayout.LayoutParams) eVar).bottomMargin;
                int i13 = eVar.f36127a;
                if ((i13 & 1) == 0) {
                    break;
                }
                minimumHeight += measuredHeight;
                if ((i13 & 2) != 0) {
                    minimumHeight -= ViewCompat.getMinimumHeight(childAt);
                    break;
                }
            }
        }
        int iMax = Math.max(0, minimumHeight);
        this.f36090d = iMax;
        return iMax;
    }

    public int getLiftOnScrollTargetViewId() {
        return this.f36099n;
    }

    @Nullable
    public yi.i getMaterialShapeBackground() {
        Drawable background = getBackground();
        if (background instanceof yi.i) {
            return (yi.i) background;
        }
        return null;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int minimumHeight = ViewCompat.getMinimumHeight(this);
        if (minimumHeight == 0) {
            int childCount = getChildCount();
            minimumHeight = childCount >= 1 ? ViewCompat.getMinimumHeight(getChildAt(childCount - 1)) : 0;
            if (minimumHeight == 0) {
                return getHeight() / 3;
            }
        }
        return (minimumHeight * 2) + topInset;
    }

    public int getPendingAction() {
        return this.f36092g;
    }

    @Nullable
    public Drawable getStatusBarForeground() {
        return this.f36108w;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    public final int getTopInset() {
        WindowInsetsCompat windowInsetsCompat = this.f36093h;
        if (windowInsetsCompat != null) {
            return windowInsetsCompat.getSystemWindowInsetTop();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i11 = this.f36088b;
        if (i11 != -1) {
            return i11;
        }
        int childCount = getChildCount();
        int minimumHeight = 0;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int i13 = eVar.f36127a;
                if ((i13 & 1) == 0) {
                    break;
                }
                minimumHeight += measuredHeight + ((LinearLayout.LayoutParams) eVar).topMargin + ((LinearLayout.LayoutParams) eVar).bottomMargin;
                if (i12 == 0 && ViewCompat.getFitsSystemWindows(childAt)) {
                    minimumHeight -= getTopInset();
                }
                if ((i13 & 2) != 0) {
                    minimumHeight -= ViewCompat.getMinimumHeight(childAt);
                    break;
                }
            }
        }
        int iMax = Math.max(0, minimumHeight);
        this.f36088b = iMax;
        return iMax;
    }

    public int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    public boolean h() {
        return this.f36091f;
    }

    public final boolean i() {
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            if (((e) getChildAt(i11).getLayoutParams()).e()) {
                return true;
            }
        }
        return false;
    }

    public boolean isLiftOnScroll() {
        return this.f36098m;
    }

    public boolean isLifted() {
        return this.f36097l;
    }

    public boolean j() {
        return getTotalScrollRange() != 0;
    }

    public final void k(final yi.i iVar, @NonNull final ColorStateList colorStateList, @NonNull final ColorStateList colorStateList2) {
        final Integer numF = com.google.android.material.color.b.f(getContext(), R$attr.colorSurface);
        this.f36103r = new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.appbar.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f36172a.o(colorStateList, colorStateList2, iVar, numF, valueAnimator);
            }
        };
        ViewCompat.setBackground(this, iVar);
    }

    public final void l(Context context, final yi.i iVar) {
        iVar.S(context);
        this.f36103r = new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.appbar.c
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f36177a.p(iVar, valueAnimator);
            }
        };
        ViewCompat.setBackground(this, iVar);
    }

    public final void m() {
        Behavior behavior = this.f36111z;
        BaseBehavior.SavedState savedStateT0 = (behavior == null || this.f36088b == -1 || this.f36092g != 0) ? null : behavior.t0(AbsSavedState.EMPTY_STATE, this);
        this.f36088b = -1;
        this.f36089c = -1;
        this.f36090d = -1;
        if (savedStateT0 != null) {
            this.f36111z.s0(savedStateT0, false);
        }
    }

    public final boolean n() {
        return getBackground() instanceof yi.i;
    }

    public final /* synthetic */ void o(ColorStateList colorStateList, ColorStateList colorStateList2, yi.i iVar, Integer num, ValueAnimator valueAnimator) {
        Integer num2;
        int iK = com.google.android.material.color.b.k(colorStateList.getDefaultColor(), colorStateList2.getDefaultColor(), ((Float) valueAnimator.getAnimatedValue()).floatValue());
        iVar.d0(ColorStateList.valueOf(iK));
        if (this.f36108w != null && (num2 = this.f36109x) != null && num2.equals(num)) {
            d3.a.n(this.f36108w, iK);
        }
        if (this.f36104s.isEmpty()) {
            return;
        }
        for (f fVar : this.f36104s) {
            if (iVar.z() != null) {
                fVar.a(0.0f, iK);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        yi.j.e(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i11) {
        if (this.f36107v == null) {
            this.f36107v = new int[4];
        }
        int[] iArr = this.f36107v;
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i11 + iArr.length);
        boolean z11 = this.f36096k;
        int i12 = R$attr.state_liftable;
        if (!z11) {
            i12 = -i12;
        }
        iArr[0] = i12;
        iArr[1] = (z11 && this.f36097l) ? R$attr.state_lifted : -R$attr.state_lifted;
        int i13 = R$attr.state_collapsible;
        if (!z11) {
            i13 = -i13;
        }
        iArr[2] = i13;
        iArr[3] = (z11 && this.f36097l) ? R$attr.state_collapsed : -R$attr.state_collapsed;
        return View.mergeDrawableStates(iArrOnCreateDrawableState, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        boolean z12 = true;
        if (ViewCompat.getFitsSystemWindows(this) && z()) {
            int topInset = getTopInset();
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                ViewCompat.offsetTopAndBottom(getChildAt(childCount), topInset);
            }
        }
        m();
        this.f36091f = false;
        int childCount2 = getChildCount();
        for (int i15 = 0; i15 < childCount2; i15++) {
            if (((e) getChildAt(i15).getLayoutParams()).d() != null) {
                this.f36091f = true;
                break;
            }
        }
        Drawable drawable = this.f36108w;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getTopInset());
        }
        if (this.f36095j) {
            return;
        }
        if (!this.f36098m && !i()) {
            z12 = false;
        }
        u(z12);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        int mode = View.MeasureSpec.getMode(i12);
        if (mode != 1073741824 && ViewCompat.getFitsSystemWindows(this) && z()) {
            int measuredHeight = getMeasuredHeight();
            if (mode == Integer.MIN_VALUE) {
                measuredHeight = g3.a.b(getMeasuredHeight() + getTopInset(), 0, View.MeasureSpec.getSize(i12));
            } else if (mode == 0) {
                measuredHeight += getTopInset();
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
        m();
    }

    public final /* synthetic */ void p(yi.i iVar, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        iVar.c0(fFloatValue);
        Drawable drawable = this.f36108w;
        if (drawable instanceof yi.i) {
            ((yi.i) drawable).c0(fFloatValue);
        }
        Iterator<f> it = this.f36104s.iterator();
        while (it.hasNext()) {
            it.next().a(fFloatValue, iVar.C());
        }
    }

    public void q(int i11) {
        this.f36087a = i11;
        if (!willNotDraw()) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
        List<b> list = this.f36094i;
        if (list != null) {
            int size = list.size();
            for (int i12 = 0; i12 < size; i12++) {
                b bVar = this.f36094i.get(i12);
                if (bVar != null) {
                    bVar.a(this, i11);
                }
            }
        }
    }

    public WindowInsetsCompat r(WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat windowInsetsCompat2 = ViewCompat.getFitsSystemWindows(this) ? windowInsetsCompat : null;
        if (!androidx.core.util.d.a(this.f36093h, windowInsetsCompat2)) {
            this.f36093h = windowInsetsCompat2;
            B();
            requestLayout();
        }
        return windowInsetsCompat;
    }

    public boolean removeLiftOnScrollListener(@NonNull f fVar) {
        return this.f36104s.remove(fVar);
    }

    public void removeOnOffsetChangedListener(@Nullable b bVar) {
        List<b> list = this.f36094i;
        if (list == null || bVar == null) {
            return;
        }
        list.remove(bVar);
    }

    public void removeOnOffsetChangedListener(g gVar) {
        removeOnOffsetChangedListener((b) gVar);
    }

    public void s() {
        this.f36092g = 0;
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f11) {
        super.setElevation(f11);
        yi.j.d(this, f11);
    }

    public void setExpanded(boolean z11) {
        setExpanded(z11, ViewCompat.isLaidOut(this));
    }

    public void setExpanded(boolean z11, boolean z12) {
        t(z11, z12, true);
    }

    public void setLiftOnScroll(boolean z11) {
        this.f36098m = z11;
    }

    public void setLiftOnScrollTargetView(@Nullable View view) {
        this.f36099n = -1;
        if (view == null) {
            c();
        } else {
            this.f36100o = new WeakReference<>(view);
        }
    }

    public void setLiftOnScrollTargetViewId(int i11) {
        this.f36099n = i11;
        c();
    }

    public boolean setLiftable(boolean z11) {
        this.f36095j = true;
        return u(z11);
    }

    public void setLiftableOverrideEnabled(boolean z11) {
        this.f36095j = z11;
    }

    public boolean setLifted(boolean z11) {
        return w(z11, true);
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i11) {
        if (i11 != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i11);
    }

    public void setStatusBarForeground(@Nullable Drawable drawable) {
        Drawable drawable2 = this.f36108w;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            this.f36108w = drawable != null ? drawable.mutate() : null;
            this.f36109x = d();
            Drawable drawable3 = this.f36108w;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.f36108w.setState(getDrawableState());
                }
                d3.a.m(this.f36108w, ViewCompat.getLayoutDirection(this));
                this.f36108w.setVisible(getVisibility() == 0, false);
                this.f36108w.setCallback(this);
            }
            B();
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setStatusBarForegroundColor(int i11) {
        setStatusBarForeground(new ColorDrawable(i11));
    }

    public void setStatusBarForegroundResource(int i11) {
        setStatusBarForeground(d1.a.b(getContext(), i11));
    }

    @Deprecated
    public void setTargetElevation(float f11) {
        l.b(this, f11);
    }

    @Override // android.view.View
    public void setVisibility(int i11) {
        super.setVisibility(i11);
        boolean z11 = i11 == 0;
        Drawable drawable = this.f36108w;
        if (drawable != null) {
            drawable.setVisible(z11, false);
        }
    }

    public final void t(boolean z11, boolean z12, boolean z13) {
        this.f36092g = (z11 ? 1 : 2) | (z12 ? 4 : 0) | (z13 ? 8 : 0);
        requestLayout();
    }

    public final boolean u(boolean z11) {
        if (this.f36096k == z11) {
            return false;
        }
        this.f36096k = z11;
        refreshDrawableState();
        return true;
    }

    public boolean v(boolean z11) {
        return w(z11, !this.f36095j);
    }

    @Override // android.view.View
    public boolean verifyDrawable(@NonNull Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f36108w;
    }

    public boolean w(boolean z11, boolean z12) {
        if (!z12 || this.f36097l == z11) {
            return false;
        }
        this.f36097l = z11;
        refreshDrawableState();
        if (!n()) {
            return true;
        }
        if (this.f36101p) {
            A(z11 ? 0.0f : 1.0f, z11 ? 1.0f : 0.0f);
            return true;
        }
        if (!this.f36098m) {
            return true;
        }
        A(z11 ? 0.0f : this.f36110y, z11 ? this.f36110y : 0.0f);
        return true;
    }

    public final boolean x() {
        return this.f36108w != null && getTopInset() > 0;
    }

    public boolean y(@Nullable View view) {
        View viewE = e(view);
        if (viewE != null) {
            view = viewE;
        }
        return view != null && (view.canScrollVertically(-1) || view.getScrollY() > 0);
    }

    public final boolean z() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        return (childAt.getVisibility() == 8 || ViewCompat.getFitsSystemWindows(childAt)) ? false : true;
    }
}
