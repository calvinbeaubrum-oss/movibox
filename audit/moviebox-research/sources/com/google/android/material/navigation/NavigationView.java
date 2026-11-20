package com.google.android.material.navigation;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.widget.n0;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.ScrimInsetsFrameLayout;
import com.google.android.material.internal.b0;
import com.google.android.material.internal.g0;
import com.google.android.material.internal.r;
import com.google.android.material.internal.s;
import g1.g;
import java.util.Objects;
import ti.i;
import yi.j;
import yi.n;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class NavigationView extends ScrimInsetsFrameLayout implements ti.b {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int[] f37201x = {R.attr.state_checked};

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int[] f37202y = {-16842910};

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f37203z = R$style.Widget_Design_NavigationView;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final r f37204i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final s f37205j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f37206k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int[] f37207l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public MenuInflater f37208m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f37209n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f37210o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f37211p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f37212q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f37213r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f37214s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final yi.r f37215t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final i f37216u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ti.c f37217v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final DrawerLayout.e f37218w;

    /* JADX INFO: compiled from: source.java */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        @Nullable
        public Bundle menuState;

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

        public SavedState(@NonNull Parcel parcel, @Nullable ClassLoader classLoader) {
            super(parcel, classLoader);
            this.menuState = parcel.readBundle(classLoader);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeBundle(this.menuState);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a extends DrawerLayout.g {
        public a() {
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.e
        public void a(@NonNull View view) {
            NavigationView navigationView = NavigationView.this;
            if (view == navigationView) {
                final ti.c cVar = navigationView.f37217v;
                Objects.requireNonNull(cVar);
                view.post(new Runnable() { // from class: com.google.android.material.navigation.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        cVar.e();
                    }
                });
            }
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.e
        public void b(@NonNull View view) {
            NavigationView navigationView = NavigationView.this;
            if (view == navigationView) {
                navigationView.f37217v.f();
                NavigationView.this.l();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements androidx.appcompat.view.menu.f.a {
        public b() {
        }

        @Override // androidx.appcompat.view.menu.f.a
        public boolean a(androidx.appcompat.view.menu.f fVar, MenuItem menuItem) {
            NavigationView.this.getClass();
            return false;
        }

        @Override // androidx.appcompat.view.menu.f.a
        public void b(androidx.appcompat.view.menu.f fVar) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements ViewTreeObserver.OnGlobalLayoutListener {
        public c() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            NavigationView navigationView = NavigationView.this;
            navigationView.getLocationOnScreen(navigationView.f37207l);
            boolean z11 = true;
            boolean z12 = NavigationView.this.f37207l[1] == 0;
            NavigationView.this.f37205j.F(z12);
            NavigationView navigationView2 = NavigationView.this;
            navigationView2.setDrawTopInsetForeground(z12 && navigationView2.isTopInsetScrimEnabled());
            NavigationView.this.setDrawLeftInsetForeground(NavigationView.this.f37207l[0] == 0 || NavigationView.this.f37207l[0] + NavigationView.this.getWidth() == 0);
            Activity activityA = com.google.android.material.internal.c.a(NavigationView.this.getContext());
            if (activityA != null) {
                Rect rectA = g0.a(activityA);
                boolean z13 = rectA.height() - NavigationView.this.getHeight() == NavigationView.this.f37207l[1];
                boolean z14 = Color.alpha(activityA.getWindow().getNavigationBarColor()) != 0;
                NavigationView navigationView3 = NavigationView.this;
                navigationView3.setDrawBottomInsetForeground(z13 && z14 && navigationView3.isBottomInsetScrimEnabled());
                if (rectA.width() != NavigationView.this.f37207l[0] && rectA.width() - NavigationView.this.getWidth() != NavigationView.this.f37207l[0]) {
                    z11 = false;
                }
                NavigationView.this.setDrawRightInsetForeground(z11);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface d {
    }

    public NavigationView(@NonNull Context context) {
        this(context, null);
    }

    public NavigationView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.navigationViewStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public NavigationView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        int i12;
        int i13;
        int i14 = f37203z;
        super(zi.a.c(context, attributeSet, i11, i14), attributeSet, i11);
        s sVar = new s();
        this.f37205j = sVar;
        this.f37207l = new int[2];
        this.f37210o = true;
        this.f37211p = true;
        this.f37212q = 0;
        this.f37215t = yi.r.a(this);
        this.f37216u = new i(this);
        this.f37217v = new ti.c(this);
        this.f37218w = new a();
        Context context2 = getContext();
        r rVar = new r(context2);
        this.f37204i = rVar;
        n0 n0VarJ = b0.j(context2, attributeSet, R$styleable.NavigationView, i11, i14, new int[0]);
        if (n0VarJ.s(R$styleable.NavigationView_android_background)) {
            ViewCompat.setBackground(this, n0VarJ.g(R$styleable.NavigationView_android_background));
        }
        int iF = n0VarJ.f(R$styleable.NavigationView_drawerLayoutCornerSize, 0);
        this.f37212q = iF;
        this.f37213r = iF == 0;
        this.f37214s = getResources().getDimensionPixelSize(R$dimen.m3_navigation_drawer_layout_corner_size);
        Drawable background = getBackground();
        ColorStateList colorStateListG = oi.f.g(background);
        if (background == null || colorStateListG != null) {
            yi.i iVar = new yi.i(n.e(context2, attributeSet, i11, i14).m());
            if (colorStateListG != null) {
                iVar.d0(colorStateListG);
            }
            iVar.S(context2);
            ViewCompat.setBackground(this, iVar);
        }
        if (n0VarJ.s(R$styleable.NavigationView_elevation)) {
            setElevation(n0VarJ.f(R$styleable.NavigationView_elevation, 0));
        }
        setFitsSystemWindows(n0VarJ.a(R$styleable.NavigationView_android_fitsSystemWindows, false));
        this.f37206k = n0VarJ.f(R$styleable.NavigationView_android_maxWidth, 0);
        ColorStateList colorStateListC = n0VarJ.s(R$styleable.NavigationView_subheaderColor) ? n0VarJ.c(R$styleable.NavigationView_subheaderColor) : null;
        int iN = n0VarJ.s(R$styleable.NavigationView_subheaderTextAppearance) ? n0VarJ.n(R$styleable.NavigationView_subheaderTextAppearance, 0) : 0;
        if (iN == 0 && colorStateListC == null) {
            colorStateListC = g(R.attr.textColorSecondary);
        }
        ColorStateList colorStateListC2 = n0VarJ.s(R$styleable.NavigationView_itemIconTint) ? n0VarJ.c(R$styleable.NavigationView_itemIconTint) : g(R.attr.textColorSecondary);
        int iN2 = n0VarJ.s(R$styleable.NavigationView_itemTextAppearance) ? n0VarJ.n(R$styleable.NavigationView_itemTextAppearance, 0) : 0;
        boolean zA = n0VarJ.a(R$styleable.NavigationView_itemTextAppearanceActiveBoldEnabled, true);
        if (n0VarJ.s(R$styleable.NavigationView_itemIconSize)) {
            setItemIconSize(n0VarJ.f(R$styleable.NavigationView_itemIconSize, 0));
        }
        ColorStateList colorStateListC3 = n0VarJ.s(R$styleable.NavigationView_itemTextColor) ? n0VarJ.c(R$styleable.NavigationView_itemTextColor) : null;
        if (iN2 == 0 && colorStateListC3 == null) {
            colorStateListC3 = g(R.attr.textColorPrimary);
        }
        Drawable drawableG = n0VarJ.g(R$styleable.NavigationView_itemBackground);
        if (drawableG == null && j(n0VarJ)) {
            drawableG = h(n0VarJ);
            ColorStateList colorStateListB = vi.d.b(context2, n0VarJ, R$styleable.NavigationView_itemRippleColor);
            if (colorStateListB != null) {
                sVar.L(new RippleDrawable(wi.b.e(colorStateListB), null, i(n0VarJ, null)));
            }
        }
        if (n0VarJ.s(R$styleable.NavigationView_itemHorizontalPadding)) {
            i12 = 0;
            setItemHorizontalPadding(n0VarJ.f(R$styleable.NavigationView_itemHorizontalPadding, 0));
        } else {
            i12 = 0;
        }
        if (n0VarJ.s(R$styleable.NavigationView_itemVerticalPadding)) {
            setItemVerticalPadding(n0VarJ.f(R$styleable.NavigationView_itemVerticalPadding, i12));
        }
        setDividerInsetStart(n0VarJ.f(R$styleable.NavigationView_dividerInsetStart, i12));
        setDividerInsetEnd(n0VarJ.f(R$styleable.NavigationView_dividerInsetEnd, i12));
        setSubheaderInsetStart(n0VarJ.f(R$styleable.NavigationView_subheaderInsetStart, i12));
        setSubheaderInsetEnd(n0VarJ.f(R$styleable.NavigationView_subheaderInsetEnd, i12));
        setTopInsetScrimEnabled(n0VarJ.a(R$styleable.NavigationView_topInsetScrimEnabled, this.f37210o));
        setBottomInsetScrimEnabled(n0VarJ.a(R$styleable.NavigationView_bottomInsetScrimEnabled, this.f37211p));
        int iF2 = n0VarJ.f(R$styleable.NavigationView_itemIconPadding, i12);
        setItemMaxLines(n0VarJ.k(R$styleable.NavigationView_itemMaxLines, 1));
        rVar.W(new b());
        sVar.J(1);
        sVar.k(context2, rVar);
        if (iN != 0) {
            sVar.Z(iN);
        }
        sVar.W(colorStateListC);
        sVar.P(colorStateListC2);
        sVar.V(getOverScrollMode());
        if (iN2 != 0) {
            sVar.R(iN2);
        }
        sVar.S(zA);
        sVar.T(colorStateListC3);
        sVar.K(drawableG);
        sVar.N(iF2);
        rVar.b(sVar);
        addView((View) sVar.z(this));
        if (n0VarJ.s(R$styleable.NavigationView_menu)) {
            i13 = 0;
            inflateMenu(n0VarJ.n(R$styleable.NavigationView_menu, 0));
        } else {
            i13 = 0;
        }
        if (n0VarJ.s(R$styleable.NavigationView_headerLayout)) {
            inflateHeaderView(n0VarJ.n(R$styleable.NavigationView_headerLayout, i13));
        }
        n0VarJ.x();
        o();
    }

    @Nullable
    private ColorStateList g(int i11) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i11, typedValue, true)) {
            return null;
        }
        ColorStateList colorStateListA = d1.a.a(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(androidx.appcompat.R$attr.colorPrimary, typedValue, true)) {
            return null;
        }
        int i12 = typedValue.data;
        int defaultColor = colorStateListA.getDefaultColor();
        int[] iArr = f37202y;
        return new ColorStateList(new int[][]{iArr, f37201x, FrameLayout.EMPTY_STATE_SET}, new int[]{colorStateListA.getColorForState(iArr, defaultColor), i12, defaultColor});
    }

    private MenuInflater getMenuInflater() {
        if (this.f37208m == null) {
            this.f37208m = new g(getContext());
        }
        return this.f37208m;
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout
    public void a(@NonNull WindowInsetsCompat windowInsetsCompat) {
        this.f37205j.m(windowInsetsCompat);
    }

    public void addHeaderView(@NonNull View view) {
        this.f37205j.l(view);
    }

    @Override // ti.b
    public void cancelBackProgress() {
        n();
        this.f37216u.f();
        l();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(@NonNull Canvas canvas) {
        this.f37215t.e(canvas, new ji.a.InterfaceC0730a() { // from class: com.google.android.material.navigation.e
            @Override // ji.a.InterfaceC0730a
            public final void a(Canvas canvas2) {
                this.f37226a.k(canvas2);
            }
        });
    }

    public i getBackHelper() {
        return this.f37216u;
    }

    @Nullable
    public MenuItem getCheckedItem() {
        return this.f37205j.n();
    }

    public int getDividerInsetEnd() {
        return this.f37205j.o();
    }

    public int getDividerInsetStart() {
        return this.f37205j.p();
    }

    public int getHeaderCount() {
        return this.f37205j.q();
    }

    public View getHeaderView(int i11) {
        return this.f37205j.r(i11);
    }

    @Nullable
    public Drawable getItemBackground() {
        return this.f37205j.s();
    }

    public int getItemHorizontalPadding() {
        return this.f37205j.t();
    }

    public int getItemIconPadding() {
        return this.f37205j.u();
    }

    @Nullable
    public ColorStateList getItemIconTintList() {
        return this.f37205j.x();
    }

    public int getItemMaxLines() {
        return this.f37205j.v();
    }

    @Nullable
    public ColorStateList getItemTextColor() {
        return this.f37205j.w();
    }

    public int getItemVerticalPadding() {
        return this.f37205j.y();
    }

    @NonNull
    public Menu getMenu() {
        return this.f37204i;
    }

    public int getSubheaderInsetEnd() {
        return this.f37205j.A();
    }

    public int getSubheaderInsetStart() {
        return this.f37205j.B();
    }

    @NonNull
    public final Drawable h(@NonNull n0 n0Var) {
        return i(n0Var, vi.d.b(getContext(), n0Var, R$styleable.NavigationView_itemShapeFillColor));
    }

    @Override // ti.b
    public void handleBackInvoked() {
        Pair<DrawerLayout, DrawerLayout.f> pairN = n();
        DrawerLayout drawerLayout = (DrawerLayout) pairN.first;
        androidx.activity.b bVarC = this.f37216u.c();
        if (bVarC == null || Build.VERSION.SDK_INT < 34) {
            drawerLayout.closeDrawer(this);
            return;
        }
        this.f37216u.h(bVarC, ((DrawerLayout.f) pairN.second).f8220a, com.google.android.material.navigation.b.b(drawerLayout, this), com.google.android.material.navigation.b.c(drawerLayout));
    }

    @NonNull
    public final Drawable i(@NonNull n0 n0Var, @Nullable ColorStateList colorStateList) {
        yi.i iVar = new yi.i(n.b(getContext(), n0Var.n(R$styleable.NavigationView_itemShapeAppearance, 0), n0Var.n(R$styleable.NavigationView_itemShapeAppearanceOverlay, 0)).m());
        iVar.d0(colorStateList);
        return new InsetDrawable((Drawable) iVar, n0Var.f(R$styleable.NavigationView_itemShapeInsetStart, 0), n0Var.f(R$styleable.NavigationView_itemShapeInsetTop, 0), n0Var.f(R$styleable.NavigationView_itemShapeInsetEnd, 0), n0Var.f(R$styleable.NavigationView_itemShapeInsetBottom, 0));
    }

    public View inflateHeaderView(int i11) {
        return this.f37205j.D(i11);
    }

    public void inflateMenu(int i11) {
        this.f37205j.a0(true);
        getMenuInflater().inflate(i11, this.f37204i);
        this.f37205j.a0(false);
        this.f37205j.h(false);
    }

    public boolean isBottomInsetScrimEnabled() {
        return this.f37211p;
    }

    public boolean isTopInsetScrimEnabled() {
        return this.f37210o;
    }

    public final boolean j(@NonNull n0 n0Var) {
        return n0Var.s(R$styleable.NavigationView_itemShapeAppearance) || n0Var.s(R$styleable.NavigationView_itemShapeAppearanceOverlay);
    }

    public final /* synthetic */ void k(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    public final void l() {
        if (!this.f37213r || this.f37212q == 0) {
            return;
        }
        this.f37212q = 0;
        m(getWidth(), getHeight());
    }

    public final void m(int i11, int i12) {
        if ((getParent() instanceof DrawerLayout) && (getLayoutParams() instanceof DrawerLayout.f)) {
            if ((this.f37212q > 0 || this.f37213r) && (getBackground() instanceof yi.i)) {
                boolean z11 = GravityCompat.getAbsoluteGravity(((DrawerLayout.f) getLayoutParams()).f8220a, ViewCompat.getLayoutDirection(this)) == 3;
                yi.i iVar = (yi.i) getBackground();
                n.b bVarO = iVar.G().v().o(this.f37212q);
                if (z11) {
                    bVarO.H(0.0f);
                    bVarO.w(0.0f);
                } else {
                    bVarO.M(0.0f);
                    bVarO.B(0.0f);
                }
                n nVarM = bVarO.m();
                iVar.setShapeAppearanceModel(nVarM);
                this.f37215t.g(this, nVarM);
                this.f37215t.f(this, new RectF(0.0f, 0.0f, i11, i12));
                this.f37215t.i(this, true);
            }
        }
    }

    public final Pair<DrawerLayout, DrawerLayout.f> n() {
        ViewParent parent = getParent();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if ((parent instanceof DrawerLayout) && (layoutParams instanceof DrawerLayout.f)) {
            return new Pair<>((DrawerLayout) parent, (DrawerLayout.f) layoutParams);
        }
        throw new IllegalStateException("NavigationView back progress requires the direct parent view to be a DrawerLayout.");
    }

    public final void o() {
        this.f37209n = new c();
        getViewTreeObserver().addOnGlobalLayoutListener(this.f37209n);
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        j.e(this);
        ViewParent parent = getParent();
        if ((parent instanceof DrawerLayout) && this.f37217v.b()) {
            DrawerLayout drawerLayout = (DrawerLayout) parent;
            drawerLayout.removeDrawerListener(this.f37218w);
            drawerLayout.addDrawerListener(this.f37218w);
            if (drawerLayout.isDrawerOpen(this)) {
                this.f37217v.e();
            }
        }
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.f37209n);
        ViewParent parent = getParent();
        if (parent instanceof DrawerLayout) {
            ((DrawerLayout) parent).removeDrawerListener(this.f37218w);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i11, int i12) {
        int mode = View.MeasureSpec.getMode(i11);
        if (mode == Integer.MIN_VALUE) {
            i11 = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i11), this.f37206k), 1073741824);
        } else if (mode == 0) {
            i11 = View.MeasureSpec.makeMeasureSpec(this.f37206k, 1073741824);
        }
        super.onMeasure(i11, i12);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f37204i.T(savedState.menuState);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        savedState.menuState = bundle;
        this.f37204i.V(bundle);
        return savedState;
    }

    @Override // android.view.View
    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        m(i11, i12);
    }

    public void removeHeaderView(@NonNull View view) {
        this.f37205j.E(view);
    }

    public void setBottomInsetScrimEnabled(boolean z11) {
        this.f37211p = z11;
    }

    public void setCheckedItem(int i11) {
        MenuItem menuItemFindItem = this.f37204i.findItem(i11);
        if (menuItemFindItem != null) {
            this.f37205j.G((h) menuItemFindItem);
        }
    }

    public void setCheckedItem(@NonNull MenuItem menuItem) {
        MenuItem menuItemFindItem = this.f37204i.findItem(menuItem.getItemId());
        if (menuItemFindItem == null) {
            throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
        }
        this.f37205j.G((h) menuItemFindItem);
    }

    public void setDividerInsetEnd(int i11) {
        this.f37205j.H(i11);
    }

    public void setDividerInsetStart(int i11) {
        this.f37205j.I(i11);
    }

    @Override // android.view.View
    public void setElevation(float f11) {
        super.setElevation(f11);
        j.d(this, f11);
    }

    public void setForceCompatClippingEnabled(boolean z11) {
        this.f37215t.h(this, z11);
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        this.f37205j.K(drawable);
    }

    public void setItemBackgroundResource(int i11) {
        setItemBackground(z2.a.getDrawable(getContext(), i11));
    }

    public void setItemHorizontalPadding(int i11) {
        this.f37205j.M(i11);
    }

    public void setItemHorizontalPaddingResource(int i11) {
        this.f37205j.M(getResources().getDimensionPixelSize(i11));
    }

    public void setItemIconPadding(int i11) {
        this.f37205j.N(i11);
    }

    public void setItemIconPaddingResource(int i11) {
        this.f37205j.N(getResources().getDimensionPixelSize(i11));
    }

    public void setItemIconSize(int i11) {
        this.f37205j.O(i11);
    }

    public void setItemIconTintList(@Nullable ColorStateList colorStateList) {
        this.f37205j.P(colorStateList);
    }

    public void setItemMaxLines(int i11) {
        this.f37205j.Q(i11);
    }

    public void setItemTextAppearance(int i11) {
        this.f37205j.R(i11);
    }

    public void setItemTextAppearanceActiveBoldEnabled(boolean z11) {
        this.f37205j.S(z11);
    }

    public void setItemTextColor(@Nullable ColorStateList colorStateList) {
        this.f37205j.T(colorStateList);
    }

    public void setItemVerticalPadding(int i11) {
        this.f37205j.U(i11);
    }

    public void setItemVerticalPaddingResource(int i11) {
        this.f37205j.U(getResources().getDimensionPixelSize(i11));
    }

    public void setNavigationItemSelectedListener(@Nullable d dVar) {
    }

    @Override // android.view.View
    public void setOverScrollMode(int i11) {
        super.setOverScrollMode(i11);
        s sVar = this.f37205j;
        if (sVar != null) {
            sVar.V(i11);
        }
    }

    public void setSubheaderInsetEnd(int i11) {
        this.f37205j.X(i11);
    }

    public void setSubheaderInsetStart(int i11) {
        this.f37205j.Y(i11);
    }

    public void setTopInsetScrimEnabled(boolean z11) {
        this.f37210o = z11;
    }

    @Override // ti.b
    public void startBackProgress(@NonNull androidx.activity.b bVar) {
        n();
        this.f37216u.j(bVar);
    }

    @Override // ti.b
    public void updateBackProgress(@NonNull androidx.activity.b bVar) {
        this.f37216u.l(bVar, ((DrawerLayout.f) n().second).f8220a);
        if (this.f37213r) {
            this.f37212q = ii.b.c(0, this.f37214s, this.f37216u.a(bVar.a()));
            m(getWidth(), getHeight());
        }
    }
}
