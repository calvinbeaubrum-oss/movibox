package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.n0;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$color;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.b0;
import com.google.android.material.internal.f0;
import com.google.android.material.navigation.NavigationBarMenuView;
import com.google.android.material.navigation.NavigationBarView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class BottomNavigationView extends NavigationBarView {

    /* JADX INFO: compiled from: source.java */
    public class a implements f0.d {
        public a() {
        }

        @Override // com.google.android.material.internal.f0.d
        @NonNull
        public WindowInsetsCompat a(View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull f0.e eVar) {
            eVar.f37045d += windowInsetsCompat.getSystemWindowInsetBottom();
            boolean z11 = ViewCompat.getLayoutDirection(view) == 1;
            int systemWindowInsetLeft = windowInsetsCompat.getSystemWindowInsetLeft();
            int systemWindowInsetRight = windowInsetsCompat.getSystemWindowInsetRight();
            eVar.f37042a += z11 ? systemWindowInsetRight : systemWindowInsetLeft;
            int i11 = eVar.f37044c;
            if (!z11) {
                systemWindowInsetLeft = systemWindowInsetRight;
            }
            eVar.f37044c = i11 + systemWindowInsetLeft;
            eVar.a(view);
            return windowInsetsCompat;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Deprecated
    public interface b extends NavigationBarView.b {
    }

    /* JADX INFO: compiled from: source.java */
    @Deprecated
    public interface c extends NavigationBarView.c {
    }

    public BottomNavigationView(@NonNull Context context) {
        this(context, null);
    }

    public BottomNavigationView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.bottomNavigationStyle);
    }

    public BottomNavigationView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, R$style.Widget_Design_BottomNavigationView);
    }

    public BottomNavigationView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        Context context2 = getContext();
        n0 n0VarJ = b0.j(context2, attributeSet, R$styleable.BottomNavigationView, i11, i12, new int[0]);
        setItemHorizontalTranslationEnabled(n0VarJ.a(R$styleable.BottomNavigationView_itemHorizontalTranslationEnabled, true));
        if (n0VarJ.s(R$styleable.BottomNavigationView_android_minHeight)) {
            setMinimumHeight(n0VarJ.f(R$styleable.BottomNavigationView_android_minHeight, 0));
        }
        if (n0VarJ.a(R$styleable.BottomNavigationView_compatShadowEnabled, true) && g()) {
            d(context2);
        }
        n0VarJ.x();
        e();
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    @NonNull
    public NavigationBarMenuView c(@NonNull Context context) {
        return new BottomNavigationMenuView(context);
    }

    public final void d(@NonNull Context context) {
        View view = new View(context);
        view.setBackgroundColor(z2.a.getColor(context, R$color.design_bottom_navigation_shadow_color));
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R$dimen.design_bottom_navigation_shadow_height)));
        addView(view);
    }

    public final void e() {
        f0.f(this, new a());
    }

    public final int f(int i11) {
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        if (View.MeasureSpec.getMode(i11) == 1073741824 || suggestedMinimumHeight <= 0) {
            return i11;
        }
        return View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i11), suggestedMinimumHeight + getPaddingTop() + getPaddingBottom()), 1073741824);
    }

    public final boolean g() {
        return false;
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public int getMaxItemCount() {
        return 5;
    }

    public boolean isItemHorizontalTranslationEnabled() {
        return ((BottomNavigationMenuView) getMenuView()).isItemHorizontalTranslationEnabled();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, f(i12));
    }

    public void setItemHorizontalTranslationEnabled(boolean z11) {
        BottomNavigationMenuView bottomNavigationMenuView = (BottomNavigationMenuView) getMenuView();
        if (bottomNavigationMenuView.isItemHorizontalTranslationEnabled() != z11) {
            bottomNavigationMenuView.setItemHorizontalTranslationEnabled(z11);
            getPresenter().h(false);
        }
    }

    @Deprecated
    public void setOnNavigationItemReselectedListener(@Nullable b bVar) {
        setOnItemReselectedListener(bVar);
    }

    @Deprecated
    public void setOnNavigationItemSelectedListener(@Nullable c cVar) {
        setOnItemSelectedListener(cVar);
    }
}
