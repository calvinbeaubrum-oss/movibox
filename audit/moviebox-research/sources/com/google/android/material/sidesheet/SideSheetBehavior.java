package com.google.android.material.sidesheet;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import yi.n;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class SideSheetBehavior<V extends View> extends CoordinatorLayout.c<V> implements ti.b {
    public static final int A = R$string.side_sheet_accessibility_pane_title;
    public static final int B = R$style.Widget_Material3_SideSheet;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f37465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f37466b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public yi.i f37467c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public ColorStateList f37468d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public n f37469f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final SideSheetBehavior<V>.c f37470g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f37471h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f37472i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f37473j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f37474k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    public ViewDragHelper f37475l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f37476m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f37477n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f37478o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f37479p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f37480q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f37481r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    public WeakReference<V> f37482s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @Nullable
    public WeakReference<View> f37483t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f37484u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @Nullable
    public VelocityTracker f37485v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @Nullable
    public ti.i f37486w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f37487x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @NonNull
    public final Set<j> f37488y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final ViewDragHelper.b f37489z;

    /* JADX INFO: compiled from: source.java */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        final int state;

        /* JADX INFO: compiled from: source.java */
        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            @Nullable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
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

        public SavedState(@NonNull Parcel parcel) {
            this(parcel, (ClassLoader) null);
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.state = parcel.readInt();
        }

        public SavedState(Parcelable parcelable, @NonNull SideSheetBehavior<?> sideSheetBehavior) {
            super(parcelable);
            this.state = sideSheetBehavior.f37473j;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeInt(this.state);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a extends ViewDragHelper.b {
        public a() {
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public int a(@NonNull View view, int i11, int i12) {
            return g3.a.b(i11, SideSheetBehavior.this.f37465a.g(), SideSheetBehavior.this.f37465a.f());
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public int b(@NonNull View view, int i11, int i12) {
            return view.getTop();
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public int d(@NonNull View view) {
            return SideSheetBehavior.this.f37478o + SideSheetBehavior.this.g0();
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public void j(int i11) {
            if (i11 == 1 && SideSheetBehavior.this.f37472i) {
                SideSheetBehavior.this.F0(1);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public void k(@NonNull View view, int i11, int i12, int i13, int i14) {
            ViewGroup.MarginLayoutParams marginLayoutParams;
            View viewB0 = SideSheetBehavior.this.b0();
            if (viewB0 != null && (marginLayoutParams = (ViewGroup.MarginLayoutParams) viewB0.getLayoutParams()) != null) {
                SideSheetBehavior.this.f37465a.p(marginLayoutParams, view.getLeft(), view.getRight());
                viewB0.setLayoutParams(marginLayoutParams);
            }
            SideSheetBehavior.this.W(view, i11);
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public void l(@NonNull View view, float f11, float f12) {
            int iS = SideSheetBehavior.this.S(view, f11, f12);
            SideSheetBehavior sideSheetBehavior = SideSheetBehavior.this;
            sideSheetBehavior.K0(view, iS, sideSheetBehavior.J0());
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public boolean m(@NonNull View view, int i11) {
            return (SideSheetBehavior.this.f37473j == 1 || SideSheetBehavior.this.f37482s == null || SideSheetBehavior.this.f37482s.get() != view) ? false : true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SideSheetBehavior.this.F0(5);
            if (SideSheetBehavior.this.f37482s == null || SideSheetBehavior.this.f37482s.get() == null) {
                return;
            }
            ((View) SideSheetBehavior.this.f37482s.get()).requestLayout();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f37492a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f37493b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Runnable f37494c = new Runnable() { // from class: com.google.android.material.sidesheet.i
            @Override // java.lang.Runnable
            public final void run() {
                this.f37506a.c();
            }
        };

        public c() {
        }

        public void b(int i11) {
            if (SideSheetBehavior.this.f37482s == null || SideSheetBehavior.this.f37482s.get() == null) {
                return;
            }
            this.f37492a = i11;
            if (this.f37493b) {
                return;
            }
            ViewCompat.postOnAnimation((View) SideSheetBehavior.this.f37482s.get(), this.f37494c);
            this.f37493b = true;
        }

        public final /* synthetic */ void c() {
            this.f37493b = false;
            if (SideSheetBehavior.this.f37475l != null && SideSheetBehavior.this.f37475l.n(true)) {
                b(this.f37492a);
            } else if (SideSheetBehavior.this.f37473j == 2) {
                SideSheetBehavior.this.F0(this.f37492a);
            }
        }
    }

    public SideSheetBehavior() {
        this.f37470g = new c();
        this.f37472i = true;
        this.f37473j = 5;
        this.f37474k = 5;
        this.f37477n = 0.1f;
        this.f37484u = -1;
        this.f37488y = new LinkedHashSet();
        this.f37489z = new a();
    }

    public SideSheetBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f37470g = new c();
        this.f37472i = true;
        this.f37473j = 5;
        this.f37474k = 5;
        this.f37477n = 0.1f;
        this.f37484u = -1;
        this.f37488y = new LinkedHashSet();
        this.f37489z = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SideSheetBehavior_Layout);
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.SideSheetBehavior_Layout_backgroundTint)) {
            this.f37468d = vi.d.a(context, typedArrayObtainStyledAttributes, R$styleable.SideSheetBehavior_Layout_backgroundTint);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.SideSheetBehavior_Layout_shapeAppearance)) {
            this.f37469f = n.e(context, attributeSet, 0, B).m();
        }
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.SideSheetBehavior_Layout_coplanarSiblingViewId)) {
            A0(typedArrayObtainStyledAttributes.getResourceId(R$styleable.SideSheetBehavior_Layout_coplanarSiblingViewId, -1));
        }
        V(context);
        this.f37471h = typedArrayObtainStyledAttributes.getDimension(R$styleable.SideSheetBehavior_Layout_android_elevation, -1.0f);
        B0(typedArrayObtainStyledAttributes.getBoolean(R$styleable.SideSheetBehavior_Layout_behavior_draggable, true));
        typedArrayObtainStyledAttributes.recycle();
        this.f37466b = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    private boolean G0() {
        return this.f37475l != null && (this.f37472i || this.f37473j == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K0(View view, int i11, boolean z11) {
        if (!s0(view, i11, z11)) {
            F0(i11);
        } else {
            F0(2);
            this.f37470g.b(i11);
        }
    }

    private void L0() {
        V v11;
        WeakReference<V> weakReference = this.f37482s;
        if (weakReference == null || (v11 = weakReference.get()) == null) {
            return;
        }
        ViewCompat.removeAccessibilityAction(v11, 262144);
        ViewCompat.removeAccessibilityAction(v11, 1048576);
        if (this.f37473j != 5) {
            x0(v11, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, 5);
        }
        if (this.f37473j != 3) {
            x0(v11, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, 3);
        }
    }

    private AccessibilityViewCommand U(final int i11) {
        return new AccessibilityViewCommand() { // from class: com.google.android.material.sidesheet.f
            @Override // androidx.core.view.accessibility.AccessibilityViewCommand
            public final boolean perform(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
                return this.f37498a.t0(i11, view, commandArguments);
            }
        };
    }

    private void V(@NonNull Context context) {
        if (this.f37469f == null) {
            return;
        }
        yi.i iVar = new yi.i(this.f37469f);
        this.f37467c = iVar;
        iVar.S(context);
        ColorStateList colorStateList = this.f37468d;
        if (colorStateList != null) {
            this.f37467c.d0(colorStateList);
            return;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.colorBackground, typedValue, true);
        this.f37467c.setTint(typedValue.data);
    }

    private int Y(int i11, int i12, int i13, int i14) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i11, i12, i14);
        if (i13 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(size, i13), 1073741824);
        }
        if (size != 0) {
            i13 = Math.min(size, i13);
        }
        return View.MeasureSpec.makeMeasureSpec(i13, Integer.MIN_VALUE);
    }

    private void x0(V v11, AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, int i11) {
        ViewCompat.replaceAccessibilityAction(v11, accessibilityActionCompat, null, U(i11));
    }

    private void z0(@NonNull V v11, Runnable runnable) {
        if (r0(v11)) {
            v11.post(runnable);
        } else {
            runnable.run();
        }
    }

    public void A0(int i11) {
        this.f37484u = i11;
        T();
        WeakReference<V> weakReference = this.f37482s;
        if (weakReference != null) {
            V v11 = weakReference.get();
            if (i11 == -1 || !ViewCompat.isLaidOut(v11)) {
                return;
            }
            v11.requestLayout();
        }
    }

    public void B0(boolean z11) {
        this.f37472i = z11;
    }

    public final void C0(int i11) {
        d dVar = this.f37465a;
        if (dVar == null || dVar.j() != i11) {
            if (i11 == 0) {
                this.f37465a = new com.google.android.material.sidesheet.b(this);
                if (this.f37469f == null || o0()) {
                    return;
                }
                n.b bVarV = this.f37469f.v();
                bVarV.M(0.0f).B(0.0f);
                N0(bVarV.m());
                return;
            }
            if (i11 == 1) {
                this.f37465a = new com.google.android.material.sidesheet.a(this);
                if (this.f37469f == null || n0()) {
                    return;
                }
                n.b bVarV2 = this.f37469f.v();
                bVarV2.H(0.0f).w(0.0f);
                N0(bVarV2.m());
                return;
            }
            throw new IllegalArgumentException("Invalid sheet edge position value: " + i11 + ". Must be 0 or 1" + InstructionFileId.DOT);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean D(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v11, @NonNull MotionEvent motionEvent) {
        if (!v11.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.f37473j == 1 && actionMasked == 0) {
            return true;
        }
        if (G0()) {
            this.f37475l.H(motionEvent);
        }
        if (actionMasked == 0) {
            y0();
        }
        if (this.f37485v == null) {
            this.f37485v = VelocityTracker.obtain();
        }
        this.f37485v.addMovement(motionEvent);
        if (G0() && actionMasked == 2 && !this.f37476m && p0(motionEvent)) {
            this.f37475l.c(v11, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.f37476m;
    }

    public final void D0(@NonNull V v11, int i11) {
        C0(GravityCompat.getAbsoluteGravity(((CoordinatorLayout.f) v11.getLayoutParams()).f7522c, i11) == 3 ? 1 : 0);
    }

    public void E0(final int i11) {
        if (i11 == 1 || i11 == 2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("STATE_");
            sb2.append(i11 == 1 ? "DRAGGING" : "SETTLING");
            sb2.append(" should not be set externally.");
            throw new IllegalArgumentException(sb2.toString());
        }
        WeakReference<V> weakReference = this.f37482s;
        if (weakReference == null || weakReference.get() == null) {
            F0(i11);
        } else {
            z0(this.f37482s.get(), new Runnable() { // from class: com.google.android.material.sidesheet.h
                @Override // java.lang.Runnable
                public final void run() {
                    this.f37504a.v0(i11);
                }
            });
        }
    }

    public void F0(int i11) {
        V v11;
        if (this.f37473j == i11) {
            return;
        }
        this.f37473j = i11;
        if (i11 == 3 || i11 == 5) {
            this.f37474k = i11;
        }
        WeakReference<V> weakReference = this.f37482s;
        if (weakReference == null || (v11 = weakReference.get()) == null) {
            return;
        }
        O0(v11);
        Iterator<j> it = this.f37488y.iterator();
        while (it.hasNext()) {
            it.next().a(v11, i11);
        }
        L0();
    }

    public boolean H0(@NonNull View view, float f11) {
        return this.f37465a.n(view, f11);
    }

    public final boolean I0(@NonNull V v11) {
        return (v11.isShown() || ViewCompat.getAccessibilityPaneTitle(v11) != null) && this.f37472i;
    }

    public boolean J0() {
        return true;
    }

    public final void M0() {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        WeakReference<V> weakReference = this.f37482s;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        V v11 = this.f37482s.get();
        View viewB0 = b0();
        if (viewB0 == null || (marginLayoutParams = (ViewGroup.MarginLayoutParams) viewB0.getLayoutParams()) == null) {
            return;
        }
        this.f37465a.o(marginLayoutParams, (int) ((this.f37478o * v11.getScaleX()) + this.f37481r));
        viewB0.requestLayout();
    }

    public final void N0(@NonNull n nVar) {
        yi.i iVar = this.f37467c;
        if (iVar != null) {
            iVar.setShapeAppearanceModel(nVar);
        }
    }

    public final void O0(@NonNull View view) {
        int i11 = this.f37473j == 5 ? 4 : 0;
        if (view.getVisibility() != i11) {
            view.setVisibility(i11);
        }
    }

    public final int Q(int i11, V v11) {
        int i12 = this.f37473j;
        if (i12 == 1 || i12 == 2) {
            return i11 - this.f37465a.h(v11);
        }
        if (i12 == 3) {
            return 0;
        }
        if (i12 == 5) {
            return this.f37465a.e();
        }
        throw new IllegalStateException("Unexpected value: " + this.f37473j);
    }

    public final float R(float f11, float f12) {
        return Math.abs(f11 - f12);
    }

    public final int S(@NonNull View view, float f11, float f12) {
        if (q0(f11)) {
            return 3;
        }
        if (H0(view, f11)) {
            if (!this.f37465a.m(f11, f12) && !this.f37465a.l(view)) {
                return 3;
            }
        } else if (f11 == 0.0f || !e.a(f11, f12)) {
            int left = view.getLeft();
            if (Math.abs(left - c0()) < Math.abs(left - this.f37465a.e())) {
                return 3;
            }
        }
        return 5;
    }

    public final void T() {
        WeakReference<View> weakReference = this.f37483t;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f37483t = null;
    }

    public final void W(@NonNull View view, int i11) {
        if (this.f37488y.isEmpty()) {
            return;
        }
        float fB = this.f37465a.b(i11);
        Iterator<j> it = this.f37488y.iterator();
        while (it.hasNext()) {
            it.next().b(view, fB);
        }
    }

    public final void X(View view) {
        if (ViewCompat.getAccessibilityPaneTitle(view) == null) {
            ViewCompat.setAccessibilityPaneTitle(view, view.getResources().getString(A));
        }
    }

    public int Z() {
        return this.f37478o;
    }

    @Nullable
    public final ValueAnimator.AnimatorUpdateListener a0() {
        final ViewGroup.MarginLayoutParams marginLayoutParams;
        final View viewB0 = b0();
        if (viewB0 == null || (marginLayoutParams = (ViewGroup.MarginLayoutParams) viewB0.getLayoutParams()) == null) {
            return null;
        }
        final int iC = this.f37465a.c(marginLayoutParams);
        return new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.sidesheet.g
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f37500a.u0(marginLayoutParams, iC, viewB0, valueAnimator);
            }
        };
    }

    @Nullable
    public View b0() {
        WeakReference<View> weakReference = this.f37483t;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public int c0() {
        return this.f37465a.d();
    }

    @Override // ti.b
    public void cancelBackProgress() {
        ti.i iVar = this.f37486w;
        if (iVar == null) {
            return;
        }
        iVar.f();
    }

    public final int d0() {
        d dVar = this.f37465a;
        return (dVar == null || dVar.j() == 0) ? 5 : 3;
    }

    public float e0() {
        return this.f37477n;
    }

    public float f0() {
        return 0.5f;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void g(@NonNull CoordinatorLayout.f fVar) {
        super.g(fVar);
        this.f37482s = null;
        this.f37475l = null;
        this.f37486w = null;
    }

    public int g0() {
        return this.f37481r;
    }

    public int h0(int i11) {
        if (i11 == 3) {
            return c0();
        }
        if (i11 == 5) {
            return this.f37465a.e();
        }
        throw new IllegalArgumentException("Invalid state to get outer edge offset: " + i11);
    }

    @Override // ti.b
    public void handleBackInvoked() {
        ti.i iVar = this.f37486w;
        if (iVar == null) {
            return;
        }
        androidx.activity.b bVarC = iVar.c();
        if (bVarC == null || Build.VERSION.SDK_INT < 34) {
            E0(5);
        } else {
            this.f37486w.h(bVarC, d0(), new b(), a0());
        }
    }

    public int i0() {
        return this.f37480q;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void j() {
        super.j();
        this.f37482s = null;
        this.f37475l = null;
        this.f37486w = null;
    }

    public int j0() {
        return this.f37479p;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean k(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v11, @NonNull MotionEvent motionEvent) {
        ViewDragHelper viewDragHelper;
        if (!I0(v11)) {
            this.f37476m = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            y0();
        }
        if (this.f37485v == null) {
            this.f37485v = VelocityTracker.obtain();
        }
        this.f37485v.addMovement(motionEvent);
        if (actionMasked == 0) {
            this.f37487x = (int) motionEvent.getX();
        } else if ((actionMasked == 1 || actionMasked == 3) && this.f37476m) {
            this.f37476m = false;
            return false;
        }
        return (this.f37476m || (viewDragHelper = this.f37475l) == null || !viewDragHelper.R(motionEvent)) ? false : true;
    }

    public int k0() {
        return 500;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v11, int i11) {
        if (ViewCompat.getFitsSystemWindows(coordinatorLayout) && !ViewCompat.getFitsSystemWindows(v11)) {
            v11.setFitsSystemWindows(true);
        }
        if (this.f37482s == null) {
            this.f37482s = new WeakReference<>(v11);
            this.f37486w = new ti.i(v11);
            yi.i iVar = this.f37467c;
            if (iVar != null) {
                ViewCompat.setBackground(v11, iVar);
                yi.i iVar2 = this.f37467c;
                float elevation = this.f37471h;
                if (elevation == -1.0f) {
                    elevation = ViewCompat.getElevation(v11);
                }
                iVar2.c0(elevation);
            } else {
                ColorStateList colorStateList = this.f37468d;
                if (colorStateList != null) {
                    ViewCompat.setBackgroundTintList(v11, colorStateList);
                }
            }
            O0(v11);
            L0();
            if (ViewCompat.getImportantForAccessibility(v11) == 0) {
                ViewCompat.setImportantForAccessibility(v11, 1);
            }
            X(v11);
        }
        D0(v11, i11);
        if (this.f37475l == null) {
            this.f37475l = ViewDragHelper.p(coordinatorLayout, this.f37489z);
        }
        int iH = this.f37465a.h(v11);
        coordinatorLayout.onLayoutChild(v11, i11);
        this.f37479p = coordinatorLayout.getWidth();
        this.f37480q = this.f37465a.i(coordinatorLayout);
        this.f37478o = v11.getWidth();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) v11.getLayoutParams();
        this.f37481r = marginLayoutParams != null ? this.f37465a.a(marginLayoutParams) : 0;
        ViewCompat.offsetLeftAndRight(v11, Q(iH, v11));
        w0(coordinatorLayout);
        for (j jVar : this.f37488y) {
            if (jVar instanceof j) {
                jVar.c(v11);
            }
        }
        return true;
    }

    @Nullable
    public ViewDragHelper l0() {
        return this.f37475l;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean m(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v11, int i11, int i12, int i13, int i14) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) v11.getLayoutParams();
        v11.measure(Y(i11, coordinatorLayout.getPaddingLeft() + coordinatorLayout.getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i12, -1, marginLayoutParams.width), Y(i13, coordinatorLayout.getPaddingTop() + coordinatorLayout.getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i14, -1, marginLayoutParams.height));
        return true;
    }

    @Nullable
    public final CoordinatorLayout.f m0() {
        V v11;
        WeakReference<V> weakReference = this.f37482s;
        if (weakReference == null || (v11 = weakReference.get()) == null || !(v11.getLayoutParams() instanceof CoordinatorLayout.f)) {
            return null;
        }
        return (CoordinatorLayout.f) v11.getLayoutParams();
    }

    public final boolean n0() {
        CoordinatorLayout.f fVarM0 = m0();
        return fVarM0 != null && ((ViewGroup.MarginLayoutParams) fVarM0).leftMargin > 0;
    }

    public final boolean o0() {
        CoordinatorLayout.f fVarM0 = m0();
        return fVarM0 != null && ((ViewGroup.MarginLayoutParams) fVarM0).rightMargin > 0;
    }

    public final boolean p0(@NonNull MotionEvent motionEvent) {
        return G0() && R((float) this.f37487x, motionEvent.getX()) > ((float) this.f37475l.A());
    }

    public final boolean q0(float f11) {
        return this.f37465a.k(f11);
    }

    public final boolean r0(@NonNull V v11) {
        ViewParent parent = v11.getParent();
        return parent != null && parent.isLayoutRequested() && ViewCompat.isAttachedToWindow(v11);
    }

    public final boolean s0(View view, int i11, boolean z11) {
        int iH0 = h0(i11);
        ViewDragHelper viewDragHelperL0 = l0();
        return viewDragHelperL0 != null && (!z11 ? !viewDragHelperL0.S(view, iH0, view.getTop()) : !viewDragHelperL0.Q(iH0, view.getTop()));
    }

    @Override // ti.b
    public void startBackProgress(@NonNull androidx.activity.b bVar) {
        ti.i iVar = this.f37486w;
        if (iVar == null) {
            return;
        }
        iVar.j(bVar);
    }

    public final /* synthetic */ boolean t0(int i11, View view, AccessibilityViewCommand.CommandArguments commandArguments) {
        E0(i11);
        return true;
    }

    public final /* synthetic */ void u0(ViewGroup.MarginLayoutParams marginLayoutParams, int i11, View view, ValueAnimator valueAnimator) {
        this.f37465a.o(marginLayoutParams, ii.b.c(i11, 0, valueAnimator.getAnimatedFraction()));
        view.requestLayout();
    }

    @Override // ti.b
    public void updateBackProgress(@NonNull androidx.activity.b bVar) {
        ti.i iVar = this.f37486w;
        if (iVar == null) {
            return;
        }
        iVar.l(bVar, d0());
        M0();
    }

    public final /* synthetic */ void v0(int i11) {
        V v11 = this.f37482s.get();
        if (v11 != null) {
            K0(v11, i11, false);
        }
    }

    public final void w0(@NonNull CoordinatorLayout coordinatorLayout) {
        int i11;
        View viewFindViewById;
        if (this.f37483t != null || (i11 = this.f37484u) == -1 || (viewFindViewById = coordinatorLayout.findViewById(i11)) == null) {
            return;
        }
        this.f37483t = new WeakReference<>(viewFindViewById);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void x(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v11, @NonNull Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        if (savedState.getSuperState() != null) {
            super.x(coordinatorLayout, v11, savedState.getSuperState());
        }
        int i11 = savedState.state;
        if (i11 == 1 || i11 == 2) {
            i11 = 5;
        }
        this.f37473j = i11;
        this.f37474k = i11;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    @NonNull
    public Parcelable y(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v11) {
        return new SavedState(super.y(coordinatorLayout, v11), (SideSheetBehavior<?>) this);
    }

    public final void y0() {
        VelocityTracker velocityTracker = this.f37485v;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f37485v = null;
        }
    }
}
