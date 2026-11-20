package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$animator;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.b0;
import com.google.android.material.internal.f0;
import com.google.logging.type.LogSeverity;
import ii.l;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ti.j;
import yi.n;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class BottomAppBar extends Toolbar implements CoordinatorLayout.b {
    public static final int FAB_ALIGNMENT_MODE_CENTER = 0;
    public static final int FAB_ALIGNMENT_MODE_END = 1;
    public static final int FAB_ANCHOR_MODE_CRADLE = 1;
    public static final int FAB_ANCHOR_MODE_EMBED = 0;
    public static final int FAB_ANIMATION_MODE_SCALE = 0;
    public static final int FAB_ANIMATION_MODE_SLIDE = 1;
    public static final int MENU_ALIGNMENT_MODE_AUTO = 0;
    public static final int MENU_ALIGNMENT_MODE_START = 1;

    @Nullable
    public Integer V;
    public final yi.i W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    @Nullable
    public Animator f36253a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    @Nullable
    public Animator f36254b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public int f36255c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public int f36256d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public int f36257e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public final int f36258f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public int f36259g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public int f36260h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public final boolean f36261i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public boolean f36262j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final boolean f36263k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public final boolean f36264l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public final boolean f36265m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public int f36266n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public ArrayList<i> f36267o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public int f36268p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public boolean f36269q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public boolean f36270r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public Behavior f36271s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public int f36272t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public int f36273u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public int f36274v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    @NonNull
    public AnimatorListenerAdapter f36275w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    @NonNull
    public l<FloatingActionButton> f36276x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public static final int f36251y0 = R$style.Widget_MaterialComponents_BottomAppBar;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public static final int f36252z0 = R$attr.motionDurationLong2;
    public static final int A0 = R$attr.motionEasingEmphasizedInterpolator;

    /* JADX INFO: compiled from: source.java */
    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        @NonNull
        public final Rect f36277n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public WeakReference<BottomAppBar> f36278o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f36279p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final View.OnLayoutChangeListener f36280q;

        /* JADX INFO: compiled from: source.java */
        public class a implements View.OnLayoutChangeListener {
            public a() {
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
                BottomAppBar bottomAppBar = (BottomAppBar) Behavior.this.f36278o.get();
                if (bottomAppBar == null || !((view instanceof FloatingActionButton) || (view instanceof ExtendedFloatingActionButton))) {
                    view.removeOnLayoutChangeListener(this);
                    return;
                }
                int height = view.getHeight();
                if (view instanceof FloatingActionButton) {
                    FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                    floatingActionButton.getMeasuredContentRect(Behavior.this.f36277n);
                    int iHeight = Behavior.this.f36277n.height();
                    bottomAppBar.F0(iHeight);
                    bottomAppBar.setFabCornerSize(floatingActionButton.getShapeAppearanceModel().r().a(new RectF(Behavior.this.f36277n)));
                    height = iHeight;
                }
                CoordinatorLayout.f fVar = (CoordinatorLayout.f) view.getLayoutParams();
                if (Behavior.this.f36279p == 0) {
                    if (bottomAppBar.f36257e0 == 1) {
                        ((ViewGroup.MarginLayoutParams) fVar).bottomMargin = bottomAppBar.getBottomInset() + (bottomAppBar.getResources().getDimensionPixelOffset(R$dimen.mtrl_bottomappbar_fab_bottom_margin) - ((view.getMeasuredHeight() - height) / 2));
                    }
                    ((ViewGroup.MarginLayoutParams) fVar).leftMargin = bottomAppBar.getLeftInset();
                    ((ViewGroup.MarginLayoutParams) fVar).rightMargin = bottomAppBar.getRightInset();
                    if (f0.p(view)) {
                        ((ViewGroup.MarginLayoutParams) fVar).leftMargin += bottomAppBar.f36258f0;
                    } else {
                        ((ViewGroup.MarginLayoutParams) fVar).rightMargin += bottomAppBar.f36258f0;
                    }
                }
                bottomAppBar.E0();
            }
        }

        public Behavior() {
            this.f36280q = new a();
            this.f36277n = new Rect();
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f36280q = new a();
            this.f36277n = new Rect();
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
        public boolean l(@NonNull CoordinatorLayout coordinatorLayout, @NonNull BottomAppBar bottomAppBar, int i11) {
            this.f36278o = new WeakReference<>(bottomAppBar);
            View viewV0 = bottomAppBar.v0();
            if (viewV0 != null && !ViewCompat.isLaidOut(viewV0)) {
                BottomAppBar.I0(bottomAppBar, viewV0);
                this.f36279p = ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) viewV0.getLayoutParams())).bottomMargin;
                if (viewV0 instanceof FloatingActionButton) {
                    FloatingActionButton floatingActionButton = (FloatingActionButton) viewV0;
                    if (bottomAppBar.f36257e0 == 0 && bottomAppBar.f36261i0) {
                        ViewCompat.setElevation(floatingActionButton, 0.0f);
                        floatingActionButton.setCompatElevation(0.0f);
                    }
                    if (floatingActionButton.getShowMotionSpec() == null) {
                        floatingActionButton.setShowMotionSpecResource(R$animator.mtrl_fab_show_motion_spec);
                    }
                    if (floatingActionButton.getHideMotionSpec() == null) {
                        floatingActionButton.setHideMotionSpecResource(R$animator.mtrl_fab_hide_motion_spec);
                    }
                    bottomAppBar.n0(floatingActionButton);
                }
                viewV0.addOnLayoutChangeListener(this.f36280q);
                bottomAppBar.E0();
            }
            coordinatorLayout.onLayoutChild(bottomAppBar, i11);
            return super.l(coordinatorLayout, bottomAppBar, i11);
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
        public boolean A(@NonNull CoordinatorLayout coordinatorLayout, @NonNull BottomAppBar bottomAppBar, @NonNull View view, @NonNull View view2, int i11, int i12) {
            return bottomAppBar.getHideOnScroll() && super.A(coordinatorLayout, bottomAppBar, view, view2, i11, i12);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f36282a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f36283b;

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
            this.f36282a = parcel.readInt();
            this.f36283b = parcel.readInt() != 0;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeInt(this.f36282a);
            parcel.writeInt(this.f36283b ? 1 : 0);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (BottomAppBar.this.f36269q0) {
                return;
            }
            BottomAppBar bottomAppBar = BottomAppBar.this;
            bottomAppBar.A0(bottomAppBar.f36255c0, BottomAppBar.this.f36270r0);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements l<FloatingActionButton> {
        public b() {
        }

        @Override // ii.l
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(@NonNull FloatingActionButton floatingActionButton) {
            BottomAppBar.this.W.e0((floatingActionButton.getVisibility() == 0 && BottomAppBar.this.f36257e0 == 1) ? floatingActionButton.getScaleY() : 0.0f);
        }

        @Override // ii.l
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(@NonNull FloatingActionButton floatingActionButton) {
            if (BottomAppBar.this.f36257e0 != 1) {
                return;
            }
            float translationX = floatingActionButton.getTranslationX();
            if (BottomAppBar.this.getTopEdgeTreatment().j() != translationX) {
                BottomAppBar.this.getTopEdgeTreatment().p(translationX);
                BottomAppBar.this.W.invalidateSelf();
            }
            float fMax = Math.max(0.0f, -floatingActionButton.getTranslationY());
            if (BottomAppBar.this.getTopEdgeTreatment().c() != fMax) {
                BottomAppBar.this.getTopEdgeTreatment().k(fMax);
                BottomAppBar.this.W.invalidateSelf();
            }
            BottomAppBar.this.W.e0(floatingActionButton.getVisibility() == 0 ? floatingActionButton.getScaleY() : 0.0f);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements f0.d {
        public c() {
        }

        @Override // com.google.android.material.internal.f0.d
        @NonNull
        public WindowInsetsCompat a(View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull f0.e eVar) {
            boolean z11;
            if (BottomAppBar.this.f36263k0) {
                BottomAppBar.this.f36272t0 = windowInsetsCompat.getSystemWindowInsetBottom();
            }
            boolean z12 = false;
            if (BottomAppBar.this.f36264l0) {
                z11 = BottomAppBar.this.f36274v0 != windowInsetsCompat.getSystemWindowInsetLeft();
                BottomAppBar.this.f36274v0 = windowInsetsCompat.getSystemWindowInsetLeft();
            } else {
                z11 = false;
            }
            if (BottomAppBar.this.f36265m0) {
                boolean z13 = BottomAppBar.this.f36273u0 != windowInsetsCompat.getSystemWindowInsetRight();
                BottomAppBar.this.f36273u0 = windowInsetsCompat.getSystemWindowInsetRight();
                z12 = z13;
            }
            if (z11 || z12) {
                BottomAppBar.this.o0();
                BottomAppBar.this.E0();
                BottomAppBar.this.D0();
            }
            return windowInsetsCompat;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d extends AnimatorListenerAdapter {
        public d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomAppBar.this.s0();
            BottomAppBar.this.f36253a0 = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.t0();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e extends FloatingActionButton.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f36288a;

        /* JADX INFO: compiled from: source.java */
        public class a extends FloatingActionButton.b {
            public a() {
            }

            @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.b
            public void b(FloatingActionButton floatingActionButton) {
                BottomAppBar.this.s0();
            }
        }

        public e(int i11) {
            this.f36288a = i11;
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.b
        public void a(@NonNull FloatingActionButton floatingActionButton) {
            floatingActionButton.setTranslationX(BottomAppBar.this.x0(this.f36288a));
            floatingActionButton.show(new a());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class f extends AnimatorListenerAdapter {
        public f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomAppBar.this.s0();
            BottomAppBar.this.f36269q0 = false;
            BottomAppBar.this.f36254b0 = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.t0();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class g extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f36292a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ActionMenuView f36293b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f36294c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f36295d;

        public g(ActionMenuView actionMenuView, int i11, boolean z11) {
            this.f36293b = actionMenuView;
            this.f36294c = i11;
            this.f36295d = z11;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f36292a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f36292a) {
                return;
            }
            boolean z11 = BottomAppBar.this.f36268p0 != 0;
            BottomAppBar bottomAppBar = BottomAppBar.this;
            bottomAppBar.replaceMenu(bottomAppBar.f36268p0);
            BottomAppBar.this.H0(this.f36293b, this.f36294c, this.f36295d, z11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class h extends AnimatorListenerAdapter {
        public h() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.f36275w0.onAnimationStart(animator);
            FloatingActionButton floatingActionButtonU0 = BottomAppBar.this.u0();
            if (floatingActionButtonU0 != null) {
                floatingActionButtonU0.setTranslationX(BottomAppBar.this.getFabTranslationX());
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface i {
        void a(BottomAppBar bottomAppBar);

        void b(BottomAppBar bottomAppBar);
    }

    public BottomAppBar(@NonNull Context context) {
        this(context, null);
    }

    public BottomAppBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.bottomAppBarStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public BottomAppBar(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        int i12 = f36251y0;
        super(zi.a.c(context, attributeSet, i11, i12), attributeSet, i11);
        yi.i iVar = new yi.i();
        this.W = iVar;
        this.f36266n0 = 0;
        this.f36268p0 = 0;
        this.f36269q0 = false;
        this.f36270r0 = true;
        this.f36275w0 = new a();
        this.f36276x0 = new b();
        Context context2 = getContext();
        TypedArray typedArrayI = b0.i(context2, attributeSet, R$styleable.BottomAppBar, i11, i12, new int[0]);
        ColorStateList colorStateListA = vi.d.a(context2, typedArrayI, R$styleable.BottomAppBar_backgroundTint);
        if (typedArrayI.hasValue(R$styleable.BottomAppBar_navigationIconTint)) {
            setNavigationIconTint(typedArrayI.getColor(R$styleable.BottomAppBar_navigationIconTint, -1));
        }
        int dimensionPixelSize = typedArrayI.getDimensionPixelSize(R$styleable.BottomAppBar_elevation, 0);
        float dimensionPixelOffset = typedArrayI.getDimensionPixelOffset(R$styleable.BottomAppBar_fabCradleMargin, 0);
        float dimensionPixelOffset2 = typedArrayI.getDimensionPixelOffset(R$styleable.BottomAppBar_fabCradleRoundedCornerRadius, 0);
        float dimensionPixelOffset3 = typedArrayI.getDimensionPixelOffset(R$styleable.BottomAppBar_fabCradleVerticalOffset, 0);
        this.f36255c0 = typedArrayI.getInt(R$styleable.BottomAppBar_fabAlignmentMode, 0);
        this.f36256d0 = typedArrayI.getInt(R$styleable.BottomAppBar_fabAnimationMode, 0);
        this.f36257e0 = typedArrayI.getInt(R$styleable.BottomAppBar_fabAnchorMode, 1);
        this.f36261i0 = typedArrayI.getBoolean(R$styleable.BottomAppBar_removeEmbeddedFabElevation, true);
        this.f36260h0 = typedArrayI.getInt(R$styleable.BottomAppBar_menuAlignmentMode, 0);
        this.f36262j0 = typedArrayI.getBoolean(R$styleable.BottomAppBar_hideOnScroll, false);
        this.f36263k0 = typedArrayI.getBoolean(R$styleable.BottomAppBar_paddingBottomSystemWindowInsets, false);
        this.f36264l0 = typedArrayI.getBoolean(R$styleable.BottomAppBar_paddingLeftSystemWindowInsets, false);
        this.f36265m0 = typedArrayI.getBoolean(R$styleable.BottomAppBar_paddingRightSystemWindowInsets, false);
        this.f36259g0 = typedArrayI.getDimensionPixelOffset(R$styleable.BottomAppBar_fabAlignmentModeEndMargin, -1);
        boolean z11 = typedArrayI.getBoolean(R$styleable.BottomAppBar_addElevationShadow, true);
        typedArrayI.recycle();
        this.f36258f0 = getResources().getDimensionPixelOffset(R$dimen.mtrl_bottomappbar_fabOffsetEndMode);
        iVar.setShapeAppearanceModel(n.a().D(new com.google.android.material.bottomappbar.d(dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3)).m());
        if (z11) {
            iVar.k0(2);
        } else {
            iVar.k0(1);
            if (Build.VERSION.SDK_INT >= 28) {
                setOutlineAmbientShadowColor(0);
                setOutlineSpotShadowColor(0);
            }
        }
        iVar.g0(Paint.Style.FILL);
        iVar.S(context2);
        setElevation(dimensionPixelSize);
        d3.a.o(iVar, colorStateListA);
        ViewCompat.setBackground(this, iVar);
        f0.e(this, attributeSet, i11, i12, new c());
    }

    @Nullable
    private Drawable C0(@Nullable Drawable drawable) {
        if (drawable == null || this.V == null) {
            return drawable;
        }
        Drawable drawableR = d3.a.r(drawable.mutate());
        d3.a.n(drawableR, this.V.intValue());
        return drawableR;
    }

    public static void I0(BottomAppBar bottomAppBar, View view) {
        CoordinatorLayout.f fVar = (CoordinatorLayout.f) view.getLayoutParams();
        fVar.f7523d = 17;
        int i11 = bottomAppBar.f36257e0;
        if (i11 == 1) {
            fVar.f7523d = 17 | 48;
        }
        if (i11 == 0) {
            fVar.f7523d |= 80;
        }
    }

    @Nullable
    private ActionMenuView getActionMenuView() {
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            View childAt = getChildAt(i11);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getBottomInset() {
        return this.f36272t0;
    }

    private int getFabAlignmentAnimationDuration() {
        return j.f(getContext(), f36252z0, LogSeverity.NOTICE_VALUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getFabTranslationX() {
        return x0(this.f36255c0);
    }

    private float getFabTranslationY() {
        if (this.f36257e0 == 1) {
            return -getTopEdgeTreatment().c();
        }
        View viewV0 = v0();
        return viewV0 != null ? (-((getMeasuredHeight() + getBottomInset()) - viewV0.getMeasuredHeight())) / 2 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getLeftInset() {
        return this.f36274v0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRightInset() {
        return this.f36273u0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public com.google.android.material.bottomappbar.d getTopEdgeTreatment() {
        return (com.google.android.material.bottomappbar.d) this.W.G().p();
    }

    public final void A0(int i11, boolean z11) {
        if (!ViewCompat.isLaidOut(this)) {
            this.f36269q0 = false;
            replaceMenu(this.f36268p0);
            return;
        }
        Animator animator = this.f36254b0;
        if (animator != null) {
            animator.cancel();
        }
        ArrayList arrayList = new ArrayList();
        if (!y0()) {
            i11 = 0;
            z11 = false;
        }
        r0(i11, z11, arrayList);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        this.f36254b0 = animatorSet;
        animatorSet.addListener(new f());
        this.f36254b0.start();
    }

    public final void B0(int i11) {
        if (this.f36255c0 == i11 || !ViewCompat.isLaidOut(this)) {
            return;
        }
        Animator animator = this.f36253a0;
        if (animator != null) {
            animator.cancel();
        }
        ArrayList arrayList = new ArrayList();
        if (this.f36256d0 == 1) {
            q0(i11, arrayList);
        } else {
            p0(i11, arrayList);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.setInterpolator(j.g(getContext(), A0, ii.b.f67201a));
        this.f36253a0 = animatorSet;
        animatorSet.addListener(new d());
        this.f36253a0.start();
    }

    public final void D0() {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView == null || this.f36254b0 != null) {
            return;
        }
        actionMenuView.setAlpha(1.0f);
        if (y0()) {
            G0(actionMenuView, this.f36255c0, this.f36270r0);
        } else {
            G0(actionMenuView, 0, false);
        }
    }

    public final void E0() {
        getTopEdgeTreatment().p(getFabTranslationX());
        this.W.e0((this.f36270r0 && y0() && this.f36257e0 == 1) ? 1.0f : 0.0f);
        View viewV0 = v0();
        if (viewV0 != null) {
            viewV0.setTranslationY(getFabTranslationY());
            viewV0.setTranslationX(getFabTranslationX());
        }
    }

    public boolean F0(int i11) {
        float f11 = i11;
        if (f11 == getTopEdgeTreatment().h()) {
            return false;
        }
        getTopEdgeTreatment().o(f11);
        this.W.invalidateSelf();
        return true;
    }

    public final void G0(@NonNull ActionMenuView actionMenuView, int i11, boolean z11) {
        H0(actionMenuView, i11, z11, false);
    }

    public final void H0(@NonNull final ActionMenuView actionMenuView, final int i11, final boolean z11, boolean z12) {
        Runnable runnable = new Runnable() { // from class: com.google.android.material.bottomappbar.BottomAppBar.8
            @Override // java.lang.Runnable
            public void run() {
                ActionMenuView actionMenuView2 = actionMenuView;
                actionMenuView2.setTranslationX(BottomAppBar.this.w0(actionMenuView2, i11, z11));
            }
        };
        if (z12) {
            actionMenuView.post(runnable);
        } else {
            runnable.run();
        }
    }

    public void addOnScrollStateChangedListener(@NonNull HideBottomViewOnScrollBehavior.b bVar) {
        getBehavior().F(bVar);
    }

    public void clearOnScrollStateChangedListeners() {
        getBehavior().H();
    }

    @Nullable
    public ColorStateList getBackgroundTint() {
        return this.W.K();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    @NonNull
    public Behavior getBehavior() {
        if (this.f36271s0 == null) {
            this.f36271s0 = new Behavior();
        }
        return this.f36271s0;
    }

    public float getCradleVerticalOffset() {
        return getTopEdgeTreatment().c();
    }

    public int getFabAlignmentMode() {
        return this.f36255c0;
    }

    public int getFabAlignmentModeEndMargin() {
        return this.f36259g0;
    }

    public int getFabAnchorMode() {
        return this.f36257e0;
    }

    public int getFabAnimationMode() {
        return this.f36256d0;
    }

    public float getFabCradleMargin() {
        return getTopEdgeTreatment().f();
    }

    public float getFabCradleRoundedCornerRadius() {
        return getTopEdgeTreatment().g();
    }

    public boolean getHideOnScroll() {
        return this.f36262j0;
    }

    public int getMenuAlignmentMode() {
        return this.f36260h0;
    }

    public boolean isScrolledDown() {
        return getBehavior().I();
    }

    public boolean isScrolledUp() {
        return getBehavior().J();
    }

    public final void n0(@NonNull FloatingActionButton floatingActionButton) {
        floatingActionButton.addOnHideAnimationListener(this.f36275w0);
        floatingActionButton.addOnShowAnimationListener(new h());
        floatingActionButton.addTransformationCallback(this.f36276x0);
    }

    public final void o0() {
        Animator animator = this.f36254b0;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.f36253a0;
        if (animator2 != null) {
            animator2.cancel();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        yi.j.f(this, this.W);
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).setClipChildren(false);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        if (z11) {
            o0();
            E0();
            final View viewV0 = v0();
            if (viewV0 != null && ViewCompat.isLaidOut(viewV0)) {
                viewV0.post(new Runnable() { // from class: com.google.android.material.bottomappbar.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        viewV0.requestLayout();
                    }
                });
            }
        }
        D0();
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f36255c0 = savedState.f36282a;
        this.f36270r0 = savedState.f36283b;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f36282a = this.f36255c0;
        savedState.f36283b = this.f36270r0;
        return savedState;
    }

    public void p0(int i11, List<Animator> list) {
        FloatingActionButton floatingActionButtonU0 = u0();
        if (floatingActionButtonU0 == null || floatingActionButtonU0.isOrWillBeHidden()) {
            return;
        }
        t0();
        floatingActionButtonU0.hide(new e(i11));
    }

    public void performHide() {
        performHide(true);
    }

    public void performHide(boolean z11) {
        getBehavior().N(this, z11);
    }

    public void performShow() {
        performShow(true);
    }

    public void performShow(boolean z11) {
        getBehavior().P(this, z11);
    }

    public final void q0(int i11, @NonNull List<Animator> list) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(u0(), "translationX", x0(i11));
        objectAnimatorOfFloat.setDuration(getFabAlignmentAnimationDuration());
        list.add(objectAnimatorOfFloat);
    }

    public final void r0(int i11, boolean z11, @NonNull List<Animator> list) {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView == null) {
            return;
        }
        float fabAlignmentAnimationDuration = getFabAlignmentAnimationDuration();
        Animator animatorOfFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", 1.0f);
        animatorOfFloat.setDuration((long) (0.8f * fabAlignmentAnimationDuration));
        if (Math.abs(actionMenuView.getTranslationX() - w0(actionMenuView, i11, z11)) <= 1.0f) {
            if (actionMenuView.getAlpha() < 1.0f) {
                list.add(animatorOfFloat);
            }
        } else {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", 0.0f);
            objectAnimatorOfFloat.setDuration((long) (fabAlignmentAnimationDuration * 0.2f));
            objectAnimatorOfFloat.addListener(new g(actionMenuView, i11, z11));
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playSequentially(objectAnimatorOfFloat, animatorOfFloat);
            list.add(animatorSet);
        }
    }

    public void removeOnScrollStateChangedListener(@NonNull HideBottomViewOnScrollBehavior.b bVar) {
        getBehavior().K(bVar);
    }

    public void replaceMenu(int i11) {
        if (i11 != 0) {
            this.f36268p0 = 0;
            getMenu().clear();
            inflateMenu(i11);
        }
    }

    public final void s0() {
        ArrayList<i> arrayList;
        int i11 = this.f36266n0 - 1;
        this.f36266n0 = i11;
        if (i11 != 0 || (arrayList = this.f36267o0) == null) {
            return;
        }
        Iterator<i> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
    }

    public void setBackgroundTint(@Nullable ColorStateList colorStateList) {
        d3.a.o(this.W, colorStateList);
    }

    public void setCradleVerticalOffset(float f11) {
        if (f11 != getCradleVerticalOffset()) {
            getTopEdgeTreatment().k(f11);
            this.W.invalidateSelf();
            E0();
        }
    }

    @Override // android.view.View
    public void setElevation(float f11) {
        this.W.c0(f11);
        getBehavior().L(this, this.W.F() - this.W.E());
    }

    public void setFabAlignmentMode(int i11) {
        setFabAlignmentModeAndReplaceMenu(i11, 0);
    }

    public void setFabAlignmentModeAndReplaceMenu(int i11, int i12) {
        this.f36268p0 = i12;
        this.f36269q0 = true;
        A0(i11, this.f36270r0);
        B0(i11);
        this.f36255c0 = i11;
    }

    public void setFabAlignmentModeEndMargin(int i11) {
        if (this.f36259g0 != i11) {
            this.f36259g0 = i11;
            E0();
        }
    }

    public void setFabAnchorMode(int i11) {
        this.f36257e0 = i11;
        E0();
        View viewV0 = v0();
        if (viewV0 != null) {
            I0(this, viewV0);
            viewV0.requestLayout();
            this.W.invalidateSelf();
        }
    }

    public void setFabAnimationMode(int i11) {
        this.f36256d0 = i11;
    }

    public void setFabCornerSize(float f11) {
        if (f11 != getTopEdgeTreatment().d()) {
            getTopEdgeTreatment().l(f11);
            this.W.invalidateSelf();
        }
    }

    public void setFabCradleMargin(float f11) {
        if (f11 != getFabCradleMargin()) {
            getTopEdgeTreatment().m(f11);
            this.W.invalidateSelf();
        }
    }

    public void setFabCradleRoundedCornerRadius(float f11) {
        if (f11 != getFabCradleRoundedCornerRadius()) {
            getTopEdgeTreatment().n(f11);
            this.W.invalidateSelf();
        }
    }

    public void setHideOnScroll(boolean z11) {
        this.f36262j0 = z11;
    }

    public void setMenuAlignmentMode(int i11) {
        if (this.f36260h0 != i11) {
            this.f36260h0 = i11;
            ActionMenuView actionMenuView = getActionMenuView();
            if (actionMenuView != null) {
                G0(actionMenuView, this.f36255c0, y0());
            }
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(@Nullable Drawable drawable) {
        super.setNavigationIcon(C0(drawable));
    }

    public void setNavigationIconTint(int i11) {
        this.V = Integer.valueOf(i11);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }

    public final void t0() {
        ArrayList<i> arrayList;
        int i11 = this.f36266n0;
        this.f36266n0 = i11 + 1;
        if (i11 != 0 || (arrayList = this.f36267o0) == null) {
            return;
        }
        Iterator<i> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().b(this);
        }
    }

    @Nullable
    public final FloatingActionButton u0() {
        View viewV0 = v0();
        if (viewV0 instanceof FloatingActionButton) {
            return (FloatingActionButton) viewV0;
        }
        return null;
    }

    @Nullable
    public final View v0() {
        if (!(getParent() instanceof CoordinatorLayout)) {
            return null;
        }
        for (View view : ((CoordinatorLayout) getParent()).getDependents(this)) {
            if ((view instanceof FloatingActionButton) || (view instanceof ExtendedFloatingActionButton)) {
                return view;
            }
        }
        return null;
    }

    public int w0(@NonNull ActionMenuView actionMenuView, int i11, boolean z11) {
        int dimensionPixelOffset = 0;
        if (this.f36260h0 != 1 && (i11 != 1 || !z11)) {
            return 0;
        }
        boolean zP = f0.p(this);
        int measuredWidth = zP ? getMeasuredWidth() : 0;
        for (int i12 = 0; i12 < getChildCount(); i12++) {
            View childAt = getChildAt(i12);
            if ((childAt.getLayoutParams() instanceof Toolbar.f) && (((Toolbar.f) childAt.getLayoutParams()).f826a & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK) == 8388611) {
                measuredWidth = zP ? Math.min(measuredWidth, childAt.getLeft()) : Math.max(measuredWidth, childAt.getRight());
            }
        }
        int right = zP ? actionMenuView.getRight() : actionMenuView.getLeft();
        int i13 = zP ? this.f36273u0 : -this.f36274v0;
        if (getNavigationIcon() == null) {
            dimensionPixelOffset = getResources().getDimensionPixelOffset(R$dimen.m3_bottomappbar_horizontal_padding);
            if (!zP) {
                dimensionPixelOffset = -dimensionPixelOffset;
            }
        }
        return measuredWidth - ((right + i13) + dimensionPixelOffset);
    }

    public final float x0(int i11) {
        boolean zP = f0.p(this);
        if (i11 != 1) {
            return 0.0f;
        }
        View viewV0 = v0();
        return ((getMeasuredWidth() / 2) - ((zP ? this.f36274v0 : this.f36273u0) + ((this.f36259g0 == -1 || viewV0 == null) ? this.f36258f0 : (viewV0.getMeasuredWidth() / 2) + this.f36259g0))) * (zP ? -1 : 1);
    }

    public final boolean y0() {
        FloatingActionButton floatingActionButtonU0 = u0();
        return floatingActionButtonU0 != null && floatingActionButtonU0.isOrWillBeShown();
    }
}
