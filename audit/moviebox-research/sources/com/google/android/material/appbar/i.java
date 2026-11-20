package com.google.android.material.appbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.card.MaterialCardView;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class i extends j<View> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f36179d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Rect f36180f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f36181g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f36182h;

    public i() {
        this.f36179d = new Rect();
        this.f36180f = new Rect();
        this.f36181g = 0;
    }

    public i(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f36179d = new Rect();
        this.f36180f = new Rect();
        this.f36181g = 0;
    }

    public static int N(int i11) {
        return i11 == 0 ? MaterialCardView.CHECKED_ICON_GRAVITY_TOP_START : i11;
    }

    @Override // com.google.android.material.appbar.j
    public void F(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i11) {
        View viewH = H(coordinatorLayout.getDependencies(view));
        if (viewH == null) {
            super.F(coordinatorLayout, view, i11);
            this.f36181g = 0;
            return;
        }
        CoordinatorLayout.f fVar = (CoordinatorLayout.f) view.getLayoutParams();
        Rect rect = this.f36179d;
        rect.set(coordinatorLayout.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, viewH.getBottom() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin, ((coordinatorLayout.getHeight() + viewH.getBottom()) - coordinatorLayout.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin);
        WindowInsetsCompat lastWindowInsets = coordinatorLayout.getLastWindowInsets();
        if (lastWindowInsets != null && ViewCompat.getFitsSystemWindows(coordinatorLayout) && !ViewCompat.getFitsSystemWindows(view)) {
            rect.left += lastWindowInsets.getSystemWindowInsetLeft();
            rect.right -= lastWindowInsets.getSystemWindowInsetRight();
        }
        Rect rect2 = this.f36180f;
        GravityCompat.apply(N(fVar.f7522c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i11);
        int I = I(viewH);
        view.layout(rect2.left, rect2.top - I, rect2.right, rect2.bottom - I);
        this.f36181g = rect2.top - viewH.getBottom();
    }

    @Nullable
    public abstract View H(List<View> list);

    public final int I(View view) {
        if (this.f36182h == 0) {
            return 0;
        }
        float fJ = J(view);
        int i11 = this.f36182h;
        return g3.a.b((int) (fJ * i11), 0, i11);
    }

    public float J(View view) {
        return 1.0f;
    }

    public final int K() {
        return this.f36182h;
    }

    public int L(@NonNull View view) {
        return view.getMeasuredHeight();
    }

    public final int M() {
        return this.f36181g;
    }

    public final void O(int i11) {
        this.f36182h = i11;
    }

    public boolean P() {
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean m(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i11, int i12, int i13, int i14) {
        View viewH;
        WindowInsetsCompat lastWindowInsets;
        int i15 = view.getLayoutParams().height;
        if ((i15 != -1 && i15 != -2) || (viewH = H(coordinatorLayout.getDependencies(view))) == null) {
            return false;
        }
        int size = View.MeasureSpec.getSize(i13);
        if (size <= 0) {
            size = coordinatorLayout.getHeight();
        } else if (ViewCompat.getFitsSystemWindows(viewH) && (lastWindowInsets = coordinatorLayout.getLastWindowInsets()) != null) {
            size += lastWindowInsets.getSystemWindowInsetTop() + lastWindowInsets.getSystemWindowInsetBottom();
        }
        int iL = size + L(viewH);
        int measuredHeight = viewH.getMeasuredHeight();
        if (P()) {
            view.setTranslationY(-measuredHeight);
        } else {
            view.setTranslationY(0.0f);
            iL -= measuredHeight;
        }
        coordinatorLayout.onMeasureChild(view, i11, i12, View.MeasureSpec.makeMeasureSpec(iL, i15 == -1 ? 1073741824 : Integer.MIN_VALUE), i14);
        return true;
    }
}
