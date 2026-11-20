package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$animator;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.b0;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class ExtendedFloatingActionButton extends MaterialButton implements CoordinatorLayout.b {
    public static final int J = R$style.Widget_MaterialComponents_ExtendedFloatingActionButton_Icon;
    public static final Property<View, Float> K = new f(Float.class, "width");
    public static final Property<View, Float> L = new g(Float.class, "height");
    public static final Property<View, Float> M = new h(Float.class, "paddingStart");
    public static final Property<View, Float> N = new i(Float.class, "paddingEnd");
    public int A;

    @NonNull
    public final CoordinatorLayout.c<ExtendedFloatingActionButton> B;
    public boolean C;
    public boolean D;
    public boolean E;

    @NonNull
    public ColorStateList F;
    public int G;
    public int H;
    public final int I;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f36793s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final ri.a f36794t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @NonNull
    public final com.google.android.material.floatingactionbutton.b f36795u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @NonNull
    public final com.google.android.material.floatingactionbutton.b f36796v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final com.google.android.material.floatingactionbutton.b f36797w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final com.google.android.material.floatingactionbutton.b f36798x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f36799y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f36800z;

    /* JADX INFO: compiled from: source.java */
    public static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends CoordinatorLayout.c<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Rect f36801a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f36802b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f36803c;

        public ExtendedFloatingActionButtonBehavior() {
            this.f36802b = false;
            this.f36803c = true;
        }

        public ExtendedFloatingActionButtonBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ExtendedFloatingActionButton_Behavior_Layout);
            this.f36802b = typedArrayObtainStyledAttributes.getBoolean(R$styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoHide, false);
            this.f36803c = typedArrayObtainStyledAttributes.getBoolean(R$styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoShrink, true);
            typedArrayObtainStyledAttributes.recycle();
        }

        public static boolean G(@NonNull View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.f) {
                return ((CoordinatorLayout.f) layoutParams).f() instanceof BottomSheetBehavior;
            }
            return false;
        }

        public void E(@NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            extendedFloatingActionButton.y(this.f36803c ? 3 : 0, null);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
        public boolean b(@NonNull CoordinatorLayout coordinatorLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton, @NonNull Rect rect) {
            return super.b(coordinatorLayout, extendedFloatingActionButton, rect);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
        public boolean h(CoordinatorLayout coordinatorLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                L(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton);
                return false;
            }
            if (!G(view)) {
                return false;
            }
            M(view, extendedFloatingActionButton);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
        public boolean l(@NonNull CoordinatorLayout coordinatorLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton, int i11) {
            List<View> dependencies = coordinatorLayout.getDependencies(extendedFloatingActionButton);
            int size = dependencies.size();
            for (int i12 = 0; i12 < size; i12++) {
                View view = dependencies.get(i12);
                if (!(view instanceof AppBarLayout)) {
                    if (G(view) && M(view, extendedFloatingActionButton)) {
                        break;
                    }
                } else {
                    if (L(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.onLayoutChild(extendedFloatingActionButton, i11);
            return true;
        }

        public final boolean J(@NonNull View view, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            return (this.f36802b || this.f36803c) && ((CoordinatorLayout.f) extendedFloatingActionButton.getLayoutParams()).e() == view.getId();
        }

        public void K(@NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            extendedFloatingActionButton.y(this.f36803c ? 2 : 1, null);
        }

        public final boolean L(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!J(appBarLayout, extendedFloatingActionButton)) {
                return false;
            }
            if (this.f36801a == null) {
                this.f36801a = new Rect();
            }
            Rect rect = this.f36801a;
            com.google.android.material.internal.d.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                K(extendedFloatingActionButton);
                return true;
            }
            E(extendedFloatingActionButton);
            return true;
        }

        public final boolean M(@NonNull View view, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!J(view, extendedFloatingActionButton)) {
                return false;
            }
            if (view.getTop() < (extendedFloatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) extendedFloatingActionButton.getLayoutParams())).topMargin) {
                K(extendedFloatingActionButton);
                return true;
            }
            E(extendedFloatingActionButton);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void g(@NonNull CoordinatorLayout.f fVar) {
            if (fVar.f7527h == 0) {
                fVar.f7527h = 80;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a implements n {
        public a() {
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int getHeight() {
            return ExtendedFloatingActionButton.this.getCollapsedSize();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public ViewGroup.LayoutParams getLayoutParams() {
            return new ViewGroup.LayoutParams(getWidth(), getHeight());
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int getPaddingEnd() {
            return ExtendedFloatingActionButton.this.getCollapsedPadding();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int getPaddingStart() {
            return ExtendedFloatingActionButton.this.getCollapsedPadding();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int getWidth() {
            return ExtendedFloatingActionButton.this.getCollapsedSize();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements n {
        public b() {
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int getHeight() {
            return ExtendedFloatingActionButton.this.getMeasuredHeight();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public ViewGroup.LayoutParams getLayoutParams() {
            return new ViewGroup.LayoutParams(-2, -2);
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int getPaddingEnd() {
            return ExtendedFloatingActionButton.this.A;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int getPaddingStart() {
            return ExtendedFloatingActionButton.this.f36800z;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int getWidth() {
            return (ExtendedFloatingActionButton.this.getMeasuredWidth() - (ExtendedFloatingActionButton.this.getCollapsedPadding() * 2)) + ExtendedFloatingActionButton.this.f36800z + ExtendedFloatingActionButton.this.A;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n f36806a;

        public c(n nVar) {
            this.f36806a = nVar;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int getHeight() {
            ViewGroup.MarginLayoutParams marginLayoutParams;
            if (ExtendedFloatingActionButton.this.H != -1) {
                return (ExtendedFloatingActionButton.this.H == 0 || ExtendedFloatingActionButton.this.H == -2) ? this.f36806a.getHeight() : ExtendedFloatingActionButton.this.H;
            }
            if (!(ExtendedFloatingActionButton.this.getParent() instanceof View)) {
                return this.f36806a.getHeight();
            }
            View view = (View) ExtendedFloatingActionButton.this.getParent();
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null || layoutParams.height != -2) {
                return (view.getHeight() - ((!(ExtendedFloatingActionButton.this.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) || (marginLayoutParams = (ViewGroup.MarginLayoutParams) ExtendedFloatingActionButton.this.getLayoutParams()) == null) ? 0 : marginLayoutParams.topMargin + marginLayoutParams.bottomMargin)) - (view.getPaddingTop() + view.getPaddingBottom());
            }
            return this.f36806a.getHeight();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public ViewGroup.LayoutParams getLayoutParams() {
            return new ViewGroup.LayoutParams(-1, ExtendedFloatingActionButton.this.H == 0 ? -2 : ExtendedFloatingActionButton.this.H);
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int getPaddingEnd() {
            return ExtendedFloatingActionButton.this.A;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int getPaddingStart() {
            return ExtendedFloatingActionButton.this.f36800z;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int getWidth() {
            ViewGroup.MarginLayoutParams marginLayoutParams;
            if (!(ExtendedFloatingActionButton.this.getParent() instanceof View)) {
                return this.f36806a.getWidth();
            }
            View view = (View) ExtendedFloatingActionButton.this.getParent();
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null || layoutParams.width != -2) {
                return (view.getWidth() - ((!(ExtendedFloatingActionButton.this.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) || (marginLayoutParams = (ViewGroup.MarginLayoutParams) ExtendedFloatingActionButton.this.getLayoutParams()) == null) ? 0 : marginLayoutParams.leftMargin + marginLayoutParams.rightMargin)) - (view.getPaddingLeft() + view.getPaddingRight());
            }
            return this.f36806a.getWidth();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n f36808a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ n f36809b;

        public d(n nVar, n nVar2) {
            this.f36808a = nVar;
            this.f36809b = nVar2;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int getHeight() {
            if (ExtendedFloatingActionButton.this.H == -1) {
                return this.f36808a.getHeight();
            }
            return (ExtendedFloatingActionButton.this.H == 0 || ExtendedFloatingActionButton.this.H == -2) ? this.f36809b.getHeight() : ExtendedFloatingActionButton.this.H;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public ViewGroup.LayoutParams getLayoutParams() {
            return new ViewGroup.LayoutParams(ExtendedFloatingActionButton.this.G == 0 ? -2 : ExtendedFloatingActionButton.this.G, ExtendedFloatingActionButton.this.H != 0 ? ExtendedFloatingActionButton.this.H : -2);
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int getPaddingEnd() {
            return ExtendedFloatingActionButton.this.A;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int getPaddingStart() {
            return ExtendedFloatingActionButton.this.f36800z;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int getWidth() {
            if (ExtendedFloatingActionButton.this.G == -1) {
                return this.f36808a.getWidth();
            }
            return (ExtendedFloatingActionButton.this.G == 0 || ExtendedFloatingActionButton.this.G == -2) ? this.f36809b.getWidth() : ExtendedFloatingActionButton.this.G;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f36811a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.google.android.material.floatingactionbutton.b f36812b;

        public e(com.google.android.material.floatingactionbutton.b bVar, l lVar) {
            this.f36812b = bVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f36811a = true;
            this.f36812b.e();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f36812b.h();
            if (this.f36811a) {
                return;
            }
            this.f36812b.l(null);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f36812b.onAnimationStart(animator);
            this.f36811a = false;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class f extends Property<View, Float> {
        public f(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        @NonNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(@NonNull View view) {
            return Float.valueOf(view.getLayoutParams().width);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(@NonNull View view, @NonNull Float f11) {
            view.getLayoutParams().width = f11.intValue();
            view.requestLayout();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class g extends Property<View, Float> {
        public g(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        @NonNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(@NonNull View view) {
            return Float.valueOf(view.getLayoutParams().height);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(@NonNull View view, @NonNull Float f11) {
            view.getLayoutParams().height = f11.intValue();
            view.requestLayout();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class h extends Property<View, Float> {
        public h(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        @NonNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(@NonNull View view) {
            return Float.valueOf(ViewCompat.getPaddingStart(view));
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(@NonNull View view, @NonNull Float f11) {
            ViewCompat.setPaddingRelative(view, f11.intValue(), view.getPaddingTop(), ViewCompat.getPaddingEnd(view), view.getPaddingBottom());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class i extends Property<View, Float> {
        public i(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        @NonNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(@NonNull View view) {
            return Float.valueOf(ViewCompat.getPaddingEnd(view));
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(@NonNull View view, @NonNull Float f11) {
            ViewCompat.setPaddingRelative(view, ViewCompat.getPaddingStart(view), view.getPaddingTop(), f11.intValue(), view.getPaddingBottom());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class j extends ri.b {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final n f36814g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f36815h;

        public j(ri.a aVar, n nVar, boolean z11) {
            super(ExtendedFloatingActionButton.this, aVar);
            this.f36814g = nVar;
            this.f36815h = z11;
        }

        @Override // com.google.android.material.floatingactionbutton.b
        public void a() {
            ExtendedFloatingActionButton.this.C = this.f36815h;
            ViewGroup.LayoutParams layoutParams = ExtendedFloatingActionButton.this.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            if (!this.f36815h) {
                ExtendedFloatingActionButton.this.G = layoutParams.width;
                ExtendedFloatingActionButton.this.H = layoutParams.height;
            }
            layoutParams.width = this.f36814g.getLayoutParams().width;
            layoutParams.height = this.f36814g.getLayoutParams().height;
            ViewCompat.setPaddingRelative(ExtendedFloatingActionButton.this, this.f36814g.getPaddingStart(), ExtendedFloatingActionButton.this.getPaddingTop(), this.f36814g.getPaddingEnd(), ExtendedFloatingActionButton.this.getPaddingBottom());
            ExtendedFloatingActionButton.this.requestLayout();
        }

        @Override // com.google.android.material.floatingactionbutton.b
        public boolean c() {
            return this.f36815h == ExtendedFloatingActionButton.this.C || ExtendedFloatingActionButton.this.getIcon() == null || TextUtils.isEmpty(ExtendedFloatingActionButton.this.getText());
        }

        @Override // com.google.android.material.floatingactionbutton.b
        public int f() {
            return this.f36815h ? R$animator.mtrl_extended_fab_change_size_expand_motion_spec : R$animator.mtrl_extended_fab_change_size_collapse_motion_spec;
        }

        @Override // ri.b, com.google.android.material.floatingactionbutton.b
        public void h() {
            super.h();
            ExtendedFloatingActionButton.this.D = false;
            ExtendedFloatingActionButton.this.setHorizontallyScrolling(false);
            ViewGroup.LayoutParams layoutParams = ExtendedFloatingActionButton.this.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            layoutParams.width = this.f36814g.getLayoutParams().width;
            layoutParams.height = this.f36814g.getLayoutParams().height;
        }

        @Override // ri.b, com.google.android.material.floatingactionbutton.b
        @NonNull
        public AnimatorSet j() {
            ii.i iVarO = o();
            if (iVarO.j("width")) {
                PropertyValuesHolder[] propertyValuesHolderArrG = iVarO.g("width");
                propertyValuesHolderArrG[0].setFloatValues(ExtendedFloatingActionButton.this.getWidth(), this.f36814g.getWidth());
                iVarO.l("width", propertyValuesHolderArrG);
            }
            if (iVarO.j("height")) {
                PropertyValuesHolder[] propertyValuesHolderArrG2 = iVarO.g("height");
                propertyValuesHolderArrG2[0].setFloatValues(ExtendedFloatingActionButton.this.getHeight(), this.f36814g.getHeight());
                iVarO.l("height", propertyValuesHolderArrG2);
            }
            if (iVarO.j("paddingStart")) {
                PropertyValuesHolder[] propertyValuesHolderArrG3 = iVarO.g("paddingStart");
                propertyValuesHolderArrG3[0].setFloatValues(ViewCompat.getPaddingStart(ExtendedFloatingActionButton.this), this.f36814g.getPaddingStart());
                iVarO.l("paddingStart", propertyValuesHolderArrG3);
            }
            if (iVarO.j("paddingEnd")) {
                PropertyValuesHolder[] propertyValuesHolderArrG4 = iVarO.g("paddingEnd");
                propertyValuesHolderArrG4[0].setFloatValues(ViewCompat.getPaddingEnd(ExtendedFloatingActionButton.this), this.f36814g.getPaddingEnd());
                iVarO.l("paddingEnd", propertyValuesHolderArrG4);
            }
            if (iVarO.j("labelOpacity")) {
                PropertyValuesHolder[] propertyValuesHolderArrG5 = iVarO.g("labelOpacity");
                boolean z11 = this.f36815h;
                propertyValuesHolderArrG5[0].setFloatValues(z11 ? 0.0f : 1.0f, z11 ? 1.0f : 0.0f);
                iVarO.l("labelOpacity", propertyValuesHolderArrG5);
            }
            return super.n(iVarO);
        }

        @Override // com.google.android.material.floatingactionbutton.b
        public void l(@Nullable l lVar) {
        }

        @Override // ri.b, com.google.android.material.floatingactionbutton.b
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            ExtendedFloatingActionButton.this.C = this.f36815h;
            ExtendedFloatingActionButton.this.D = true;
            ExtendedFloatingActionButton.this.setHorizontallyScrolling(true);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class k extends ri.b {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f36817g;

        public k(ri.a aVar) {
            super(ExtendedFloatingActionButton.this, aVar);
        }

        @Override // com.google.android.material.floatingactionbutton.b
        public void a() {
            ExtendedFloatingActionButton.this.setVisibility(8);
        }

        @Override // com.google.android.material.floatingactionbutton.b
        public boolean c() {
            return ExtendedFloatingActionButton.this.w();
        }

        @Override // ri.b, com.google.android.material.floatingactionbutton.b
        public void e() {
            super.e();
            this.f36817g = true;
        }

        @Override // com.google.android.material.floatingactionbutton.b
        public int f() {
            return R$animator.mtrl_extended_fab_hide_motion_spec;
        }

        @Override // ri.b, com.google.android.material.floatingactionbutton.b
        public void h() {
            super.h();
            ExtendedFloatingActionButton.this.f36793s = 0;
            if (this.f36817g) {
                return;
            }
            ExtendedFloatingActionButton.this.setVisibility(8);
        }

        @Override // com.google.android.material.floatingactionbutton.b
        public void l(@Nullable l lVar) {
        }

        @Override // ri.b, com.google.android.material.floatingactionbutton.b
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            this.f36817g = false;
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.f36793s = 1;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class l {
    }

    /* JADX INFO: compiled from: source.java */
    public class m extends ri.b {
        public m(ri.a aVar) {
            super(ExtendedFloatingActionButton.this, aVar);
        }

        @Override // com.google.android.material.floatingactionbutton.b
        public void a() {
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.setAlpha(1.0f);
            ExtendedFloatingActionButton.this.setScaleY(1.0f);
            ExtendedFloatingActionButton.this.setScaleX(1.0f);
        }

        @Override // com.google.android.material.floatingactionbutton.b
        public boolean c() {
            return ExtendedFloatingActionButton.this.x();
        }

        @Override // com.google.android.material.floatingactionbutton.b
        public int f() {
            return R$animator.mtrl_extended_fab_show_motion_spec;
        }

        @Override // ri.b, com.google.android.material.floatingactionbutton.b
        public void h() {
            super.h();
            ExtendedFloatingActionButton.this.f36793s = 0;
        }

        @Override // com.google.android.material.floatingactionbutton.b
        public void l(@Nullable l lVar) {
        }

        @Override // ri.b, com.google.android.material.floatingactionbutton.b
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.f36793s = 2;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface n {
        int getHeight();

        ViewGroup.LayoutParams getLayoutParams();

        int getPaddingEnd();

        int getPaddingStart();

        int getWidth();
    }

    public ExtendedFloatingActionButton(@NonNull Context context) {
        this(context, null);
    }

    public ExtendedFloatingActionButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.extendedFloatingActionButtonStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ExtendedFloatingActionButton(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        int i12 = J;
        super(zi.a.c(context, attributeSet, i11, i12), attributeSet, i11);
        this.f36793s = 0;
        ri.a aVar = new ri.a();
        this.f36794t = aVar;
        m mVar = new m(aVar);
        this.f36797w = mVar;
        k kVar = new k(aVar);
        this.f36798x = kVar;
        this.C = true;
        this.D = false;
        this.E = false;
        Context context2 = getContext();
        this.B = new ExtendedFloatingActionButtonBehavior(context2, attributeSet);
        TypedArray typedArrayI = b0.i(context2, attributeSet, R$styleable.ExtendedFloatingActionButton, i11, i12, new int[0]);
        ii.i iVarC = ii.i.c(context2, typedArrayI, R$styleable.ExtendedFloatingActionButton_showMotionSpec);
        ii.i iVarC2 = ii.i.c(context2, typedArrayI, R$styleable.ExtendedFloatingActionButton_hideMotionSpec);
        ii.i iVarC3 = ii.i.c(context2, typedArrayI, R$styleable.ExtendedFloatingActionButton_extendMotionSpec);
        ii.i iVarC4 = ii.i.c(context2, typedArrayI, R$styleable.ExtendedFloatingActionButton_shrinkMotionSpec);
        this.f36799y = typedArrayI.getDimensionPixelSize(R$styleable.ExtendedFloatingActionButton_collapsedSize, -1);
        int i13 = typedArrayI.getInt(R$styleable.ExtendedFloatingActionButton_extendStrategy, 1);
        this.I = i13;
        this.f36800z = ViewCompat.getPaddingStart(this);
        this.A = ViewCompat.getPaddingEnd(this);
        ri.a aVar2 = new ri.a();
        j jVar = new j(aVar2, v(i13), true);
        this.f36796v = jVar;
        j jVar2 = new j(aVar2, new a(), false);
        this.f36795u = jVar2;
        mVar.i(iVarC);
        kVar.i(iVarC2);
        jVar.i(iVarC3);
        jVar2.i(iVarC4);
        typedArrayI.recycle();
        setShapeAppearanceModel(yi.n.g(context2, attributeSet, i11, i12, yi.n.f81423m).m());
        z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean w() {
        if (getVisibility() == 0) {
            return this.f36793s == 1;
        }
        return this.f36793s != 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean x() {
        if (getVisibility() != 0) {
            return this.f36793s == 2;
        }
        return this.f36793s != 1;
    }

    public final boolean A() {
        return (ViewCompat.isLaidOut(this) || (!x() && this.E)) && !isInEditMode();
    }

    public void B(@NonNull ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
    }

    public void addOnExtendAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        this.f36796v.g(animatorListener);
    }

    public void addOnHideAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        this.f36798x.g(animatorListener);
    }

    public void addOnShowAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        this.f36797w.g(animatorListener);
    }

    public void addOnShrinkAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        this.f36795u.g(animatorListener);
    }

    public void extend() {
        y(3, null);
    }

    public void extend(@NonNull l lVar) {
        y(3, lVar);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    @NonNull
    public CoordinatorLayout.c<ExtendedFloatingActionButton> getBehavior() {
        return this.B;
    }

    public int getCollapsedPadding() {
        return (getCollapsedSize() - getIconSize()) / 2;
    }

    public int getCollapsedSize() {
        int i11 = this.f36799y;
        return i11 < 0 ? (Math.min(ViewCompat.getPaddingStart(this), ViewCompat.getPaddingEnd(this)) * 2) + getIconSize() : i11;
    }

    @Nullable
    public ii.i getExtendMotionSpec() {
        return this.f36796v.b();
    }

    @Nullable
    public ii.i getHideMotionSpec() {
        return this.f36798x.b();
    }

    @Nullable
    public ii.i getShowMotionSpec() {
        return this.f36797w.b();
    }

    @Nullable
    public ii.i getShrinkMotionSpec() {
        return this.f36795u.b();
    }

    public void hide() {
        y(1, null);
    }

    public void hide(@NonNull l lVar) {
        y(1, lVar);
    }

    public final boolean isExtended() {
        return this.C;
    }

    @Override // com.google.android.material.button.MaterialButton, android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.C && TextUtils.isEmpty(getText()) && getIcon() != null) {
            this.C = false;
            this.f36795u.a();
        }
    }

    public void removeOnExtendAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        this.f36796v.d(animatorListener);
    }

    public void removeOnHideAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        this.f36798x.d(animatorListener);
    }

    public void removeOnShowAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        this.f36797w.d(animatorListener);
    }

    public void removeOnShrinkAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        this.f36795u.d(animatorListener);
    }

    public void setAnimateShowBeforeLayout(boolean z11) {
        this.E = z11;
    }

    public void setExtendMotionSpec(@Nullable ii.i iVar) {
        this.f36796v.i(iVar);
    }

    public void setExtendMotionSpecResource(int i11) {
        setExtendMotionSpec(ii.i.d(getContext(), i11));
    }

    public void setExtended(boolean z11) {
        if (this.C == z11) {
            return;
        }
        com.google.android.material.floatingactionbutton.b bVar = z11 ? this.f36796v : this.f36795u;
        if (bVar.c()) {
            return;
        }
        bVar.a();
    }

    public void setHideMotionSpec(@Nullable ii.i iVar) {
        this.f36798x.i(iVar);
    }

    public void setHideMotionSpecResource(int i11) {
        setHideMotionSpec(ii.i.d(getContext(), i11));
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i11, int i12, int i13, int i14) {
        super.setPadding(i11, i12, i13, i14);
        if (!this.C || this.D) {
            return;
        }
        this.f36800z = ViewCompat.getPaddingStart(this);
        this.A = ViewCompat.getPaddingEnd(this);
    }

    @Override // android.widget.TextView, android.view.View
    public void setPaddingRelative(int i11, int i12, int i13, int i14) {
        super.setPaddingRelative(i11, i12, i13, i14);
        if (!this.C || this.D) {
            return;
        }
        this.f36800z = i11;
        this.A = i13;
    }

    public void setShowMotionSpec(@Nullable ii.i iVar) {
        this.f36797w.i(iVar);
    }

    public void setShowMotionSpecResource(int i11) {
        setShowMotionSpec(ii.i.d(getContext(), i11));
    }

    public void setShrinkMotionSpec(@Nullable ii.i iVar) {
        this.f36795u.i(iVar);
    }

    public void setShrinkMotionSpecResource(int i11) {
        setShrinkMotionSpec(ii.i.d(getContext(), i11));
    }

    @Override // android.widget.TextView
    public void setTextColor(int i11) {
        super.setTextColor(i11);
        z();
    }

    @Override // android.widget.TextView
    public void setTextColor(@NonNull ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
        z();
    }

    public void show() {
        y(0, null);
    }

    public void show(@NonNull l lVar) {
        y(0, lVar);
    }

    public void shrink() {
        y(2, null);
    }

    public void shrink(@NonNull l lVar) {
        y(2, lVar);
    }

    public final n v(int i11) {
        b bVar = new b();
        c cVar = new c(bVar);
        d dVar = new d(cVar, bVar);
        if (i11 != 1) {
            return i11 != 2 ? dVar : cVar;
        }
        return bVar;
    }

    public final void y(int i11, @Nullable l lVar) {
        com.google.android.material.floatingactionbutton.b bVar;
        if (i11 == 0) {
            bVar = this.f36797w;
        } else if (i11 == 1) {
            bVar = this.f36798x;
        } else if (i11 == 2) {
            bVar = this.f36795u;
        } else {
            if (i11 != 3) {
                throw new IllegalStateException("Unknown strategy type: " + i11);
            }
            bVar = this.f36796v;
        }
        if (bVar.c()) {
            return;
        }
        if (!A()) {
            bVar.a();
            bVar.l(lVar);
            return;
        }
        if (i11 == 2) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                this.G = layoutParams.width;
                this.H = layoutParams.height;
            } else {
                this.G = getWidth();
                this.H = getHeight();
            }
        }
        measure(0, 0);
        AnimatorSet animatorSetJ = bVar.j();
        animatorSetJ.addListener(new e(bVar, lVar));
        Iterator<Animator.AnimatorListener> it = bVar.k().iterator();
        while (it.hasNext()) {
            animatorSetJ.addListener(it.next());
        }
        animatorSetJ.start();
    }

    public final void z() {
        this.F = getTextColors();
    }
}
