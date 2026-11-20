package com.google.android.material.navigationrail;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarMenuView;
import ui.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class NavigationRailMenuView extends NavigationBarMenuView {
    public int I;
    public final FrameLayout.LayoutParams J;

    public NavigationRailMenuView(@NonNull Context context) {
        super(context);
        this.I = -1;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        this.J = layoutParams;
        layoutParams.gravity = 49;
        setLayoutParams(layoutParams);
        setItemActiveIndicatorResizeable(true);
    }

    @Override // com.google.android.material.navigation.NavigationBarMenuView
    @NonNull
    public NavigationBarItemView d(@NonNull Context context) {
        return new a(context);
    }

    public int getItemMinimumHeight() {
        return this.I;
    }

    public int getMenuGravity() {
        return this.J.gravity;
    }

    public boolean m() {
        return (this.J.gravity & 112) == 48;
    }

    public final int n(int i11, int i12, int i13) {
        int iMax = i12 / Math.max(1, i13);
        int size = this.I;
        if (size == -1) {
            size = View.MeasureSpec.getSize(i11);
        }
        return View.MeasureSpec.makeMeasureSpec(Math.min(size, iMax), 0);
    }

    public final int o(View view, int i11, int i12) {
        if (view.getVisibility() == 8) {
            return 0;
        }
        view.measure(i11, i12);
        return view.getMeasuredHeight();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        int childCount = getChildCount();
        int i15 = i13 - i11;
        int i16 = 0;
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt = getChildAt(i17);
            if (childAt.getVisibility() != 8) {
                int measuredHeight = childAt.getMeasuredHeight() + i16;
                childAt.layout(0, i16, i15, measuredHeight);
                i16 = measuredHeight;
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i11, int i12) {
        int size = View.MeasureSpec.getSize(i12);
        int size2 = getMenu().G().size();
        setMeasuredDimension(View.MeasureSpec.getSize(i11), View.resolveSizeAndState((size2 <= 1 || !f(getLabelVisibilityMode(), size2)) ? p(i11, size, size2, null) : q(i11, size, size2), i12, 0));
    }

    public final int p(int i11, int i12, int i13, View view) {
        int iN = view == null ? n(i11, i12, i13) : View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 0);
        int childCount = getChildCount();
        int iO = 0;
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            if (childAt != view) {
                iO += o(childAt, i11, iN);
            }
        }
        return iO;
    }

    public final int q(int i11, int i12, int i13) {
        int iO;
        View childAt = getChildAt(getSelectedItemPosition());
        if (childAt != null) {
            iO = o(childAt, i11, n(i11, i12, i13));
            i12 -= iO;
            i13--;
        } else {
            iO = 0;
        }
        return iO + p(i11, i12, i13, childAt);
    }

    public void setItemMinimumHeight(int i11) {
        if (this.I != i11) {
            this.I = i11;
            requestLayout();
        }
    }

    public void setMenuGravity(int i11) {
        FrameLayout.LayoutParams layoutParams = this.J;
        if (layoutParams.gravity != i11) {
            layoutParams.gravity = i11;
            setLayoutParams(layoutParams);
        }
    }
}
