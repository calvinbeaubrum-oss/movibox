package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.f;
import androidx.appcompat.widget.j;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.TintableBackgroundView;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.internal.b0;
import com.google.android.material.internal.f0;
import com.google.android.material.stateful.ExtendableSavedState;
import ii.i;
import ii.l;
import java.util.List;
import yi.n;
import yi.q;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class FloatingActionButton extends VisibilityAwareImageButton implements TintableBackgroundView, qi.a, q, CoordinatorLayout.b {
    public static final int NO_CUSTOM_SIZE = 0;
    public static final int SIZE_AUTO = -1;
    public static final int SIZE_MINI = 1;
    public static final int SIZE_NORMAL = 0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f36820s = R$style.Widget_Design_FloatingActionButton;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public ColorStateList f36821b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public PorterDuff.Mode f36822c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public ColorStateList f36823d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public PorterDuff.Mode f36824f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public ColorStateList f36825g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f36826h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f36827i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f36828j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f36829k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f36830l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f36831m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Rect f36832n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Rect f36833o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @NonNull
    public final j f36834p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @NonNull
    public final qi.b f36835q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public com.google.android.material.floatingactionbutton.a f36836r;

    /* JADX INFO: compiled from: source.java */
    public static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.c<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Rect f36837a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public b f36838b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f36839c;

        public BaseBehavior() {
            this.f36839c = true;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FloatingActionButton_Behavior_Layout);
            this.f36839c = typedArrayObtainStyledAttributes.getBoolean(R$styleable.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
            typedArrayObtainStyledAttributes.recycle();
        }

        private static boolean F(@NonNull View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.f) {
                return ((CoordinatorLayout.f) layoutParams).f() instanceof BottomSheetBehavior;
            }
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
        public boolean b(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, @NonNull Rect rect) {
            Rect rect2 = floatingActionButton.f36832n;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        public final void G(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton) {
            int i11;
            Rect rect = floatingActionButton.f36832n;
            if (rect == null || rect.centerX() <= 0 || rect.centerY() <= 0) {
                return;
            }
            CoordinatorLayout.f fVar = (CoordinatorLayout.f) floatingActionButton.getLayoutParams();
            int i12 = 0;
            if (floatingActionButton.getRight() >= coordinatorLayout.getWidth() - ((ViewGroup.MarginLayoutParams) fVar).rightMargin) {
                i11 = rect.right;
            } else {
                i11 = floatingActionButton.getLeft() <= ((ViewGroup.MarginLayoutParams) fVar).leftMargin ? -rect.left : 0;
            }
            if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin) {
                i12 = rect.bottom;
            } else if (floatingActionButton.getTop() <= ((ViewGroup.MarginLayoutParams) fVar).topMargin) {
                i12 = -rect.top;
            }
            if (i12 != 0) {
                ViewCompat.offsetTopAndBottom(floatingActionButton, i12);
            }
            if (i11 != 0) {
                ViewCompat.offsetLeftAndRight(floatingActionButton, i11);
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
        public boolean h(CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                K(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
                return false;
            }
            if (!F(view)) {
                return false;
            }
            L(view, floatingActionButton);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
        public boolean l(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, int i11) {
            List<View> dependencies = coordinatorLayout.getDependencies(floatingActionButton);
            int size = dependencies.size();
            for (int i12 = 0; i12 < size; i12++) {
                View view = dependencies.get(i12);
                if (!(view instanceof AppBarLayout)) {
                    if (F(view) && L(view, floatingActionButton)) {
                        break;
                    }
                } else {
                    if (K(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.onLayoutChild(floatingActionButton, i11);
            G(coordinatorLayout, floatingActionButton);
            return true;
        }

        public final boolean J(@NonNull View view, @NonNull FloatingActionButton floatingActionButton) {
            return this.f36839c && ((CoordinatorLayout.f) floatingActionButton.getLayoutParams()).e() == view.getId() && floatingActionButton.getUserSetVisibility() == 0;
        }

        public final boolean K(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull FloatingActionButton floatingActionButton) {
            if (!J(appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.f36837a == null) {
                this.f36837a = new Rect();
            }
            Rect rect = this.f36837a;
            com.google.android.material.internal.d.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.f(this.f36838b, false);
                return true;
            }
            floatingActionButton.i(this.f36838b, false);
            return true;
        }

        public final boolean L(@NonNull View view, @NonNull FloatingActionButton floatingActionButton) {
            if (!J(view, floatingActionButton)) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) floatingActionButton.getLayoutParams())).topMargin) {
                floatingActionButton.f(this.f36838b, false);
                return true;
            }
            floatingActionButton.i(this.f36838b, false);
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
    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        /* JADX INFO: renamed from: E */
        public /* bridge */ /* synthetic */ boolean b(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, @NonNull Rect rect) {
            return super.b(coordinatorLayout, floatingActionButton, rect);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        /* JADX INFO: renamed from: H */
        public /* bridge */ /* synthetic */ boolean h(CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, View view) {
            return super.h(coordinatorLayout, floatingActionButton, view);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        /* JADX INFO: renamed from: I */
        public /* bridge */ /* synthetic */ boolean l(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, int i11) {
            return super.l(coordinatorLayout, floatingActionButton, i11);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ void g(@NonNull CoordinatorLayout.f fVar) {
            super.g(fVar);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a implements com.google.android.material.floatingactionbutton.a.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f36840a;

        public a(b bVar) {
            this.f36840a = bVar;
        }

        @Override // com.google.android.material.floatingactionbutton.a.k
        public void a() {
            this.f36840a.b(FloatingActionButton.this);
        }

        @Override // com.google.android.material.floatingactionbutton.a.k
        public void b() {
            this.f36840a.a(FloatingActionButton.this);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class b {
        public void a(FloatingActionButton floatingActionButton) {
        }

        public void b(FloatingActionButton floatingActionButton) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements xi.b {
        public c() {
        }

        @Override // xi.b
        public void a(int i11, int i12, int i13, int i14) {
            FloatingActionButton.this.f36832n.set(i11, i12, i13, i14);
            FloatingActionButton floatingActionButton = FloatingActionButton.this;
            floatingActionButton.setPadding(i11 + floatingActionButton.f36829k, i12 + FloatingActionButton.this.f36829k, i13 + FloatingActionButton.this.f36829k, i14 + FloatingActionButton.this.f36829k);
        }

        @Override // xi.b
        public void b(@Nullable Drawable drawable) {
            if (drawable != null) {
                FloatingActionButton.super.setBackgroundDrawable(drawable);
            }
        }

        @Override // xi.b
        public boolean c() {
            return FloatingActionButton.this.f36831m;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d<T extends FloatingActionButton> implements com.google.android.material.floatingactionbutton.a.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NonNull
        public final l<T> f36843a;

        public d(l<T> lVar) {
            this.f36843a = lVar;
        }

        @Override // com.google.android.material.floatingactionbutton.a.j
        public void a() {
            this.f36843a.b(FloatingActionButton.this);
        }

        @Override // com.google.android.material.floatingactionbutton.a.j
        public void b() {
            this.f36843a.a(FloatingActionButton.this);
        }

        public boolean equals(@Nullable Object obj) {
            return (obj instanceof d) && ((d) obj).f36843a.equals(this.f36843a);
        }

        public int hashCode() {
            return this.f36843a.hashCode();
        }
    }

    public FloatingActionButton(@NonNull Context context) {
        this(context, null);
    }

    public FloatingActionButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.floatingActionButtonStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public FloatingActionButton(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        int i12 = f36820s;
        super(zi.a.c(context, attributeSet, i11, i12), attributeSet, i11);
        this.f36832n = new Rect();
        this.f36833o = new Rect();
        Context context2 = getContext();
        TypedArray typedArrayI = b0.i(context2, attributeSet, R$styleable.FloatingActionButton, i11, i12, new int[0]);
        this.f36821b = vi.d.a(context2, typedArrayI, R$styleable.FloatingActionButton_backgroundTint);
        this.f36822c = f0.r(typedArrayI.getInt(R$styleable.FloatingActionButton_backgroundTintMode, -1), null);
        this.f36825g = vi.d.a(context2, typedArrayI, R$styleable.FloatingActionButton_rippleColor);
        this.f36827i = typedArrayI.getInt(R$styleable.FloatingActionButton_fabSize, -1);
        this.f36828j = typedArrayI.getDimensionPixelSize(R$styleable.FloatingActionButton_fabCustomSize, 0);
        this.f36826h = typedArrayI.getDimensionPixelSize(R$styleable.FloatingActionButton_borderWidth, 0);
        float dimension = typedArrayI.getDimension(R$styleable.FloatingActionButton_elevation, 0.0f);
        float dimension2 = typedArrayI.getDimension(R$styleable.FloatingActionButton_hoveredFocusedTranslationZ, 0.0f);
        float dimension3 = typedArrayI.getDimension(R$styleable.FloatingActionButton_pressedTranslationZ, 0.0f);
        this.f36831m = typedArrayI.getBoolean(R$styleable.FloatingActionButton_useCompatPadding, false);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.mtrl_fab_min_touch_target);
        setMaxImageSize(typedArrayI.getDimensionPixelSize(R$styleable.FloatingActionButton_maxImageSize, 0));
        i iVarC = i.c(context2, typedArrayI, R$styleable.FloatingActionButton_showMotionSpec);
        i iVarC2 = i.c(context2, typedArrayI, R$styleable.FloatingActionButton_hideMotionSpec);
        n nVarM = n.g(context2, attributeSet, i11, i12, n.f81423m).m();
        boolean z11 = typedArrayI.getBoolean(R$styleable.FloatingActionButton_ensureMinTouchTargetSize, false);
        setEnabled(typedArrayI.getBoolean(R$styleable.FloatingActionButton_android_enabled, true));
        typedArrayI.recycle();
        j jVar = new j(this);
        this.f36834p = jVar;
        jVar.g(attributeSet, i11);
        this.f36835q = new qi.b(this);
        getImpl().a0(nVarM);
        getImpl().x(this.f36821b, this.f36822c, this.f36825g, this.f36826h);
        getImpl().W(dimensionPixelSize);
        getImpl().Q(dimension);
        getImpl().T(dimension2);
        getImpl().X(dimension3);
        getImpl().b0(iVarC);
        getImpl().S(iVarC2);
        getImpl().R(z11);
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    private com.google.android.material.floatingactionbutton.a getImpl() {
        if (this.f36836r == null) {
            this.f36836r = c();
        }
        return this.f36836r;
    }

    public void addOnHideAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        getImpl().e(animatorListener);
    }

    public void addOnShowAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        getImpl().f(animatorListener);
    }

    public void addTransformationCallback(@NonNull l<? extends FloatingActionButton> lVar) {
        getImpl().g(new d(lVar));
    }

    @NonNull
    public final com.google.android.material.floatingactionbutton.a c() {
        return new ri.d(this, new c());
    }

    public void clearCustomSize() {
        setCustomSize(0);
    }

    public final int d(int i11) {
        int i12 = this.f36828j;
        if (i12 != 0) {
            return i12;
        }
        Resources resources = getResources();
        if (i11 != -1) {
            return i11 != 1 ? resources.getDimensionPixelSize(R$dimen.design_fab_size_normal) : resources.getDimensionPixelSize(R$dimen.design_fab_size_mini);
        }
        return Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470 ? d(1) : d(0);
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().E(getDrawableState());
    }

    public final void e(@NonNull Rect rect) {
        getMeasuredContentRect(rect);
        int i11 = -this.f36836r.v();
        rect.inset(i11, i11);
    }

    public void f(@Nullable b bVar, boolean z11) {
        getImpl().w(j(bVar), z11);
    }

    public final void g(@NonNull Rect rect) {
        int i11 = rect.left;
        Rect rect2 = this.f36832n;
        rect.left = i11 + rect2.left;
        rect.top += rect2.top;
        rect.right -= rect2.right;
        rect.bottom -= rect2.bottom;
    }

    @Override // android.view.View
    @Nullable
    public ColorStateList getBackgroundTintList() {
        return this.f36821b;
    }

    @Override // android.view.View
    @Nullable
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.f36822c;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    @NonNull
    public CoordinatorLayout.c<FloatingActionButton> getBehavior() {
        return new Behavior();
    }

    public float getCompatElevation() {
        return getImpl().m();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().p();
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().s();
    }

    @Nullable
    public Drawable getContentBackground() {
        return getImpl().l();
    }

    @Deprecated
    public boolean getContentRect(@NonNull Rect rect) {
        if (!ViewCompat.isLaidOut(this)) {
            return false;
        }
        rect.set(0, 0, getWidth(), getHeight());
        g(rect);
        return true;
    }

    public int getCustomSize() {
        return this.f36828j;
    }

    public int getExpandedComponentIdHint() {
        return this.f36835q.b();
    }

    @Nullable
    public i getHideMotionSpec() {
        return getImpl().o();
    }

    public void getMeasuredContentRect(@NonNull Rect rect) {
        rect.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
        g(rect);
    }

    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.f36825g;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    @Nullable
    public ColorStateList getRippleColorStateList() {
        return this.f36825g;
    }

    @NonNull
    public n getShapeAppearanceModel() {
        return (n) androidx.core.util.i.g(getImpl().t());
    }

    @Nullable
    public i getShowMotionSpec() {
        return getImpl().u();
    }

    public int getSize() {
        return this.f36827i;
    }

    public int getSizeDimension() {
        return d(this.f36827i);
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    @Nullable
    public ColorStateList getSupportImageTintList() {
        return this.f36823d;
    }

    @Nullable
    public PorterDuff.Mode getSupportImageTintMode() {
        return this.f36824f;
    }

    public boolean getUseCompatPadding() {
        return this.f36831m;
    }

    public final void h() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        ColorStateList colorStateList = this.f36823d;
        if (colorStateList == null) {
            d3.a.c(drawable);
            return;
        }
        int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
        PorterDuff.Mode mode = this.f36824f;
        if (mode == null) {
            mode = PorterDuff.Mode.SRC_IN;
        }
        drawable.mutate().setColorFilter(f.e(colorForState, mode));
    }

    public void hide() {
        hide(null);
    }

    public void hide(@Nullable b bVar) {
        f(bVar, true);
    }

    public void i(@Nullable b bVar, boolean z11) {
        getImpl().f0(j(bVar), z11);
    }

    @Override // qi.a
    public boolean isExpanded() {
        return this.f36835q.c();
    }

    public boolean isOrWillBeHidden() {
        return getImpl().y();
    }

    public boolean isOrWillBeShown() {
        return getImpl().z();
    }

    @Nullable
    public final com.google.android.material.floatingactionbutton.a.k j(@Nullable b bVar) {
        if (bVar == null) {
            return null;
        }
        return new a(bVar);
    }

    @Override // android.widget.ImageView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().A();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().B();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().D();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i11, int i12) {
        int sizeDimension = getSizeDimension();
        this.f36829k = (sizeDimension - this.f36830l) / 2;
        getImpl().i0();
        int iMin = Math.min(View.resolveSize(sizeDimension, i11), View.resolveSize(sizeDimension, i12));
        Rect rect = this.f36832n;
        setMeasuredDimension(rect.left + iMin + rect.right, iMin + rect.top + rect.bottom);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof ExtendableSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ExtendableSavedState extendableSavedState = (ExtendableSavedState) parcelable;
        super.onRestoreInstanceState(extendableSavedState.getSuperState());
        this.f36835q.d((Bundle) androidx.core.util.i.g(extendableSavedState.extendableStates.get("expandableWidgetHelper")));
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        if (parcelableOnSaveInstanceState == null) {
            parcelableOnSaveInstanceState = new Bundle();
        }
        ExtendableSavedState extendableSavedState = new ExtendableSavedState(parcelableOnSaveInstanceState);
        extendableSavedState.extendableStates.put("expandableWidgetHelper", this.f36835q.e());
        return extendableSavedState;
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            e(this.f36833o);
            if (!this.f36833o.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return false;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void removeOnHideAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        getImpl().K(animatorListener);
    }

    public void removeOnShowAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        getImpl().L(animatorListener);
    }

    public void removeTransformationCallback(@NonNull l<? extends FloatingActionButton> lVar) {
        getImpl().M(new d(lVar));
    }

    @Override // android.view.View
    public void setBackgroundColor(int i11) {
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
    }

    @Override // android.view.View
    public void setBackgroundResource(int i11) {
    }

    @Override // android.view.View
    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        if (this.f36821b != colorStateList) {
            this.f36821b = colorStateList;
            getImpl().O(colorStateList);
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.f36822c != mode) {
            this.f36822c = mode;
            getImpl().P(mode);
        }
    }

    public void setCompatElevation(float f11) {
        getImpl().Q(f11);
    }

    public void setCompatElevationResource(int i11) {
        setCompatElevation(getResources().getDimension(i11));
    }

    public void setCompatHoveredFocusedTranslationZ(float f11) {
        getImpl().T(f11);
    }

    public void setCompatHoveredFocusedTranslationZResource(int i11) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i11));
    }

    public void setCompatPressedTranslationZ(float f11) {
        getImpl().X(f11);
    }

    public void setCompatPressedTranslationZResource(int i11) {
        setCompatPressedTranslationZ(getResources().getDimension(i11));
    }

    public void setCustomSize(int i11) {
        if (i11 < 0) {
            throw new IllegalArgumentException("Custom size must be non-negative");
        }
        if (i11 != this.f36828j) {
            this.f36828j = i11;
            requestLayout();
        }
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f11) {
        super.setElevation(f11);
        getImpl().j0(f11);
    }

    public void setEnsureMinTouchTargetSize(boolean z11) {
        if (z11 != getImpl().n()) {
            getImpl().R(z11);
            requestLayout();
        }
    }

    public boolean setExpanded(boolean z11) {
        return this.f36835q.f(z11);
    }

    public void setExpandedComponentIdHint(int i11) {
        this.f36835q.g(i11);
    }

    public void setHideMotionSpec(@Nullable i iVar) {
        getImpl().S(iVar);
    }

    public void setHideMotionSpecResource(int i11) {
        setHideMotionSpec(i.d(getContext(), i11));
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable drawable) {
        if (getDrawable() != drawable) {
            super.setImageDrawable(drawable);
            getImpl().h0();
            if (this.f36823d != null) {
                h();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i11) {
        this.f36834p.i(i11);
        h();
    }

    public void setMaxImageSize(int i11) {
        this.f36830l = i11;
        getImpl().V(i11);
    }

    public void setRippleColor(int i11) {
        setRippleColor(ColorStateList.valueOf(i11));
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        if (this.f36825g != colorStateList) {
            this.f36825g = colorStateList;
            getImpl().Y(this.f36825g);
        }
    }

    @Override // android.view.View
    public void setScaleX(float f11) {
        super.setScaleX(f11);
        getImpl().I();
    }

    @Override // android.view.View
    public void setScaleY(float f11) {
        super.setScaleY(f11);
        getImpl().I();
    }

    public void setShadowPaddingEnabled(boolean z11) {
        getImpl().Z(z11);
    }

    @Override // yi.q
    public void setShapeAppearanceModel(@NonNull n nVar) {
        getImpl().a0(nVar);
    }

    public void setShowMotionSpec(@Nullable i iVar) {
        getImpl().b0(iVar);
    }

    public void setShowMotionSpecResource(int i11) {
        setShowMotionSpec(i.d(getContext(), i11));
    }

    public void setSize(int i11) {
        this.f36828j = 0;
        if (i11 != this.f36827i) {
            this.f36827i = i11;
            requestLayout();
        }
    }

    @Override // androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    @Override // androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        setBackgroundTintMode(mode);
    }

    public void setSupportImageTintList(@Nullable ColorStateList colorStateList) {
        if (this.f36823d != colorStateList) {
            this.f36823d = colorStateList;
            h();
        }
    }

    public void setSupportImageTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.f36824f != mode) {
            this.f36824f = mode;
            h();
        }
    }

    @Override // android.view.View
    public void setTranslationX(float f11) {
        super.setTranslationX(f11);
        getImpl().J();
    }

    @Override // android.view.View
    public void setTranslationY(float f11) {
        super.setTranslationY(f11);
        getImpl().J();
    }

    @Override // android.view.View
    public void setTranslationZ(float f11) {
        super.setTranslationZ(f11);
        getImpl().J();
    }

    public void setUseCompatPadding(boolean z11) {
        if (this.f36831m != z11) {
            this.f36831m = z11;
            getImpl().C();
        }
    }

    @Override // com.google.android.material.internal.VisibilityAwareImageButton, android.widget.ImageView, android.view.View
    public void setVisibility(int i11) {
        super.setVisibility(i11);
    }

    public boolean shouldEnsureMinTouchTargetSize() {
        return getImpl().n();
    }

    public void show() {
        show(null);
    }

    public void show(@Nullable b bVar) {
        i(bVar, true);
    }
}
