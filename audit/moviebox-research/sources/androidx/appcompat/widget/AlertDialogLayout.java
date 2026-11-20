package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.appcompat.R$id;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class AlertDialogLayout extends LinearLayoutCompat {
    public AlertDialogLayout(@Nullable Context context) {
        super(context);
    }

    public AlertDialogLayout(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public static int u(View view) {
        int minimumHeight = ViewCompat.getMinimumHeight(view);
        if (minimumHeight > 0) {
            return minimumHeight;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() == 1) {
                return u(viewGroup.getChildAt(0));
            }
        }
        return 0;
    }

    public final void f(int i11, int i12) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i13 = 0; i13 < i11; i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                LinearLayoutCompat.a aVar = (LinearLayoutCompat.a) childAt.getLayoutParams();
                if (((LinearLayout.LayoutParams) aVar).width == -1) {
                    int i14 = ((LinearLayout.LayoutParams) aVar).height;
                    ((LinearLayout.LayoutParams) aVar).height = childAt.getMeasuredHeight();
                    measureChildWithMargins(childAt, iMakeMeasureSpec, 0, i12, 0);
                    ((LinearLayout.LayoutParams) aVar).height = i14;
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00a9  */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        int i15;
        int i16;
        int i17;
        int paddingLeft = getPaddingLeft();
        int i18 = i13 - i11;
        int paddingRight = i18 - getPaddingRight();
        int paddingRight2 = (i18 - paddingLeft) - getPaddingRight();
        int measuredHeight = getMeasuredHeight();
        int childCount = getChildCount();
        int gravity = getGravity();
        int i19 = gravity & 112;
        int i21 = gravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        int paddingTop = i19 != 16 ? i19 != 80 ? getPaddingTop() : ((getPaddingTop() + i14) - i12) - measuredHeight : getPaddingTop() + (((i14 - i12) - measuredHeight) / 2);
        Drawable dividerDrawable = getDividerDrawable();
        int intrinsicHeight = dividerDrawable == null ? 0 : dividerDrawable.getIntrinsicHeight();
        for (int i22 = 0; i22 < childCount; i22++) {
            View childAt = getChildAt(i22);
            if (childAt != null && childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight2 = childAt.getMeasuredHeight();
                LinearLayoutCompat.a aVar = (LinearLayoutCompat.a) childAt.getLayoutParams();
                int i23 = ((LinearLayout.LayoutParams) aVar).gravity;
                if (i23 < 0) {
                    i23 = i21;
                }
                int absoluteGravity = GravityCompat.getAbsoluteGravity(i23, getLayoutDirection()) & 7;
                if (absoluteGravity != 1) {
                    if (absoluteGravity != 5) {
                        i17 = ((LinearLayout.LayoutParams) aVar).leftMargin + paddingLeft;
                    } else {
                        i15 = paddingRight - measuredWidth;
                        i16 = ((LinearLayout.LayoutParams) aVar).rightMargin;
                    }
                    if (m(i22)) {
                        paddingTop += intrinsicHeight;
                    }
                    int i24 = paddingTop + ((LinearLayout.LayoutParams) aVar).topMargin;
                    t(childAt, i17, i24, measuredWidth, measuredHeight2);
                    paddingTop = i24 + measuredHeight2 + ((LinearLayout.LayoutParams) aVar).bottomMargin;
                } else {
                    i15 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft + ((LinearLayout.LayoutParams) aVar).leftMargin;
                    i16 = ((LinearLayout.LayoutParams) aVar).rightMargin;
                }
                i17 = i15 - i16;
                if (m(i22)) {
                    paddingTop += intrinsicHeight;
                }
                int i25 = paddingTop + ((LinearLayout.LayoutParams) aVar).topMargin;
                t(childAt, i17, i25, measuredWidth, measuredHeight2);
                paddingTop = i25 + measuredHeight2 + ((LinearLayout.LayoutParams) aVar).bottomMargin;
            }
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public void onMeasure(int i11, int i12) {
        if (v(i11, i12)) {
            return;
        }
        super.onMeasure(i11, i12);
    }

    public final void t(View view, int i11, int i12, int i13, int i14) {
        view.layout(i11, i12, i13 + i11, i14 + i12);
    }

    public final boolean v(int i11, int i12) {
        int iCombineMeasuredStates;
        int iU;
        int measuredHeight;
        int measuredHeight2;
        int childCount = getChildCount();
        View view = null;
        View view2 = null;
        View view3 = null;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                int id2 = childAt.getId();
                if (id2 == R$id.topPanel) {
                    view = childAt;
                } else if (id2 == R$id.buttonPanel) {
                    view2 = childAt;
                } else {
                    if ((id2 != R$id.contentPanel && id2 != R$id.customPanel) || view3 != null) {
                        return false;
                    }
                    view3 = childAt;
                }
            }
        }
        int mode = View.MeasureSpec.getMode(i12);
        int size = View.MeasureSpec.getSize(i12);
        int mode2 = View.MeasureSpec.getMode(i11);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (view != null) {
            view.measure(i11, 0);
            paddingTop += view.getMeasuredHeight();
            iCombineMeasuredStates = View.combineMeasuredStates(0, view.getMeasuredState());
        } else {
            iCombineMeasuredStates = 0;
        }
        if (view2 != null) {
            view2.measure(i11, 0);
            iU = u(view2);
            measuredHeight = view2.getMeasuredHeight() - iU;
            paddingTop += iU;
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view2.getMeasuredState());
        } else {
            iU = 0;
            measuredHeight = 0;
        }
        if (view3 != null) {
            view3.measure(i11, mode == 0 ? 0 : View.MeasureSpec.makeMeasureSpec(Math.max(0, size - paddingTop), mode));
            measuredHeight2 = view3.getMeasuredHeight();
            paddingTop += measuredHeight2;
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view3.getMeasuredState());
        } else {
            measuredHeight2 = 0;
        }
        int i14 = size - paddingTop;
        if (view2 != null) {
            int i15 = paddingTop - iU;
            int iMin = Math.min(i14, measuredHeight);
            if (iMin > 0) {
                i14 -= iMin;
                iU += iMin;
            }
            view2.measure(i11, View.MeasureSpec.makeMeasureSpec(iU, 1073741824));
            paddingTop = i15 + view2.getMeasuredHeight();
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view2.getMeasuredState());
        }
        if (view3 != null && i14 > 0) {
            view3.measure(i11, View.MeasureSpec.makeMeasureSpec(measuredHeight2 + i14, mode));
            paddingTop = (paddingTop - measuredHeight2) + view3.getMeasuredHeight();
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view3.getMeasuredState());
        }
        int iMax = 0;
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt2 = getChildAt(i16);
            if (childAt2.getVisibility() != 8) {
                iMax = Math.max(iMax, childAt2.getMeasuredWidth());
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(iMax + getPaddingLeft() + getPaddingRight(), i11, iCombineMeasuredStates), View.resolveSizeAndState(paddingTop, i12, 0));
        if (mode2 == 1073741824) {
            return true;
        }
        f(childCount, i12);
        return true;
    }
}
