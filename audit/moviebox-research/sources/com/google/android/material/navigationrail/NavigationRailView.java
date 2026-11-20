package com.google.android.material.navigationrail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.n0;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import c3.c;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.b0;
import com.google.android.material.internal.f0;
import com.google.android.material.navigation.NavigationBarView;
import ii.b;
import vi.d;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class NavigationRailView extends NavigationBarView {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f37228f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public View f37229g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public Boolean f37230h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public Boolean f37231i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public Boolean f37232j;

    /* JADX INFO: compiled from: source.java */
    public class a implements f0.d {
        public a() {
        }

        @Override // com.google.android.material.internal.f0.d
        @NonNull
        public WindowInsetsCompat a(View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull f0.e eVar) {
            c insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
            NavigationRailView navigationRailView = NavigationRailView.this;
            if (navigationRailView.l(navigationRailView.f37230h)) {
                eVar.f37043b += insets.f14555b;
            }
            NavigationRailView navigationRailView2 = NavigationRailView.this;
            if (navigationRailView2.l(navigationRailView2.f37231i)) {
                eVar.f37045d += insets.f14557d;
            }
            NavigationRailView navigationRailView3 = NavigationRailView.this;
            if (navigationRailView3.l(navigationRailView3.f37232j)) {
                eVar.f37042a += f0.p(view) ? insets.f14556c : insets.f14554a;
            }
            eVar.a(view);
            return windowInsetsCompat;
        }
    }

    public NavigationRailView(@NonNull Context context) {
        this(context, null);
    }

    public NavigationRailView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.navigationRailStyle);
    }

    public NavigationRailView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, R$style.Widget_MaterialComponents_NavigationRailView);
    }

    public NavigationRailView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        this.f37230h = null;
        this.f37231i = null;
        this.f37232j = null;
        this.f37228f = getResources().getDimensionPixelSize(R$dimen.mtrl_navigation_rail_margin);
        Context context2 = getContext();
        n0 n0VarJ = b0.j(context2, attributeSet, R$styleable.NavigationRailView, i11, i12, new int[0]);
        int iN = n0VarJ.n(R$styleable.NavigationRailView_headerLayout, 0);
        if (iN != 0) {
            addHeaderView(iN);
        }
        setMenuGravity(n0VarJ.k(R$styleable.NavigationRailView_menuGravity, 49));
        if (n0VarJ.s(R$styleable.NavigationRailView_itemMinHeight)) {
            setItemMinimumHeight(n0VarJ.f(R$styleable.NavigationRailView_itemMinHeight, -1));
        }
        if (n0VarJ.s(R$styleable.NavigationRailView_paddingTopSystemWindowInsets)) {
            this.f37230h = Boolean.valueOf(n0VarJ.a(R$styleable.NavigationRailView_paddingTopSystemWindowInsets, false));
        }
        if (n0VarJ.s(R$styleable.NavigationRailView_paddingBottomSystemWindowInsets)) {
            this.f37231i = Boolean.valueOf(n0VarJ.a(R$styleable.NavigationRailView_paddingBottomSystemWindowInsets, false));
        }
        if (n0VarJ.s(R$styleable.NavigationRailView_paddingStartSystemWindowInsets)) {
            this.f37232j = Boolean.valueOf(n0VarJ.a(R$styleable.NavigationRailView_paddingStartSystemWindowInsets, false));
        }
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R$dimen.m3_navigation_rail_item_padding_top_with_large_font);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R$dimen.m3_navigation_rail_item_padding_bottom_with_large_font);
        float fB = b.b(0.0f, 1.0f, 0.3f, 1.0f, d.f(context2) - 1.0f);
        float fC = b.c(getItemPaddingTop(), dimensionPixelOffset, fB);
        float fC2 = b.c(getItemPaddingBottom(), dimensionPixelOffset2, fB);
        setItemPaddingTop(Math.round(fC));
        setItemPaddingBottom(Math.round(fC2));
        n0VarJ.x();
        h();
    }

    private NavigationRailMenuView getNavigationRailMenuView() {
        return (NavigationRailMenuView) getMenuView();
    }

    private void h() {
        f0.f(this, new a());
    }

    public void addHeaderView(int i11) {
        addHeaderView(LayoutInflater.from(getContext()).inflate(i11, (ViewGroup) this, false));
    }

    public void addHeaderView(@NonNull View view) {
        removeHeaderView();
        this.f37229g = view;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        layoutParams.topMargin = this.f37228f;
        addView(view, 0, layoutParams);
    }

    @Nullable
    public View getHeaderView() {
        return this.f37229g;
    }

    public int getItemMinimumHeight() {
        return ((NavigationRailMenuView) getMenuView()).getItemMinimumHeight();
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public int getMaxItemCount() {
        return 7;
    }

    public int getMenuGravity() {
        return getNavigationRailMenuView().getMenuGravity();
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    @NonNull
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public NavigationRailMenuView c(@NonNull Context context) {
        return new NavigationRailMenuView(context);
    }

    public final boolean j() {
        View view = this.f37229g;
        return (view == null || view.getVisibility() == 8) ? false : true;
    }

    public final int k(int i11) {
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        if (View.MeasureSpec.getMode(i11) == 1073741824 || suggestedMinimumWidth <= 0) {
            return i11;
        }
        return View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i11), suggestedMinimumWidth + getPaddingLeft() + getPaddingRight()), 1073741824);
    }

    public final boolean l(Boolean bool) {
        return bool != null ? bool.booleanValue() : ViewCompat.getFitsSystemWindows(this);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        NavigationRailMenuView navigationRailMenuView = getNavigationRailMenuView();
        int i15 = 0;
        if (j()) {
            int bottom = this.f37229g.getBottom() + this.f37228f;
            int top = navigationRailMenuView.getTop();
            if (top < bottom) {
                i15 = bottom - top;
            }
        } else if (navigationRailMenuView.m()) {
            i15 = this.f37228f;
        }
        if (i15 > 0) {
            navigationRailMenuView.layout(navigationRailMenuView.getLeft(), navigationRailMenuView.getTop() + i15, navigationRailMenuView.getRight(), navigationRailMenuView.getBottom() + i15);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i11, int i12) {
        int iK = k(i11);
        super.onMeasure(iK, i12);
        if (j()) {
            measureChild(getNavigationRailMenuView(), iK, View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - this.f37229g.getMeasuredHeight()) - this.f37228f, Integer.MIN_VALUE));
        }
    }

    public void removeHeaderView() {
        View view = this.f37229g;
        if (view != null) {
            removeView(view);
            this.f37229g = null;
        }
    }

    public void setItemMinimumHeight(int i11) {
        ((NavigationRailMenuView) getMenuView()).setItemMinimumHeight(i11);
    }

    public void setMenuGravity(int i11) {
        getNavigationRailMenuView().setMenuGravity(i11);
    }
}
