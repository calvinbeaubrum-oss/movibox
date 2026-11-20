package com.google.android.flexbox;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class d extends RecyclerView.l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f36070c = {R.attr.listDivider};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Drawable f36071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f36072b;

    public d(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(f36070c);
        this.f36071a = typedArrayObtainStyledAttributes.getDrawable(0);
        typedArrayObtainStyledAttributes.recycle();
        setOrientation(3);
    }

    public final void d(Canvas canvas, RecyclerView recyclerView) {
        int top;
        int intrinsicHeight;
        int left;
        int right;
        int i11;
        int iMin;
        int left2;
        if (g()) {
            FlexboxLayoutManager flexboxLayoutManager = (FlexboxLayoutManager) recyclerView.getLayoutManager();
            int flexDirection = flexboxLayoutManager.getFlexDirection();
            int left3 = recyclerView.getLeft() - recyclerView.getPaddingLeft();
            int right2 = recyclerView.getRight() + recyclerView.getPaddingRight();
            int childCount = recyclerView.getChildCount();
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = recyclerView.getChildAt(i12);
                RecyclerView.n nVar = (RecyclerView.n) childAt.getLayoutParams();
                if (flexDirection == 3) {
                    intrinsicHeight = childAt.getBottom() + ((ViewGroup.MarginLayoutParams) nVar).bottomMargin;
                    top = this.f36071a.getIntrinsicHeight() + intrinsicHeight;
                } else {
                    top = childAt.getTop() - ((ViewGroup.MarginLayoutParams) nVar).topMargin;
                    intrinsicHeight = top - this.f36071a.getIntrinsicHeight();
                }
                if (flexboxLayoutManager.isMainAxisDirectionHorizontal()) {
                    if (flexboxLayoutManager.E()) {
                        iMin = Math.min(childAt.getRight() + ((ViewGroup.MarginLayoutParams) nVar).rightMargin + this.f36071a.getIntrinsicWidth(), right2);
                        left2 = childAt.getLeft() - ((ViewGroup.MarginLayoutParams) nVar).leftMargin;
                    } else {
                        left = Math.max((childAt.getLeft() - ((ViewGroup.MarginLayoutParams) nVar).leftMargin) - this.f36071a.getIntrinsicWidth(), left3);
                        right = childAt.getRight();
                        i11 = ((ViewGroup.MarginLayoutParams) nVar).rightMargin;
                    }
                    this.f36071a.setBounds(left2, intrinsicHeight, iMin, top);
                    this.f36071a.draw(canvas);
                } else {
                    left = childAt.getLeft() - ((ViewGroup.MarginLayoutParams) nVar).leftMargin;
                    right = childAt.getRight();
                    i11 = ((ViewGroup.MarginLayoutParams) nVar).rightMargin;
                }
                int i13 = left;
                iMin = right + i11;
                left2 = i13;
                this.f36071a.setBounds(left2, intrinsicHeight, iMin, top);
                this.f36071a.draw(canvas);
            }
        }
    }

    public final void e(Canvas canvas, RecyclerView recyclerView) {
        int left;
        int intrinsicWidth;
        int iMax;
        int bottom;
        int i11;
        int i12;
        if (h()) {
            FlexboxLayoutManager flexboxLayoutManager = (FlexboxLayoutManager) recyclerView.getLayoutManager();
            int top = recyclerView.getTop() - recyclerView.getPaddingTop();
            int bottom2 = recyclerView.getBottom() + recyclerView.getPaddingBottom();
            int childCount = recyclerView.getChildCount();
            int flexDirection = flexboxLayoutManager.getFlexDirection();
            for (int i13 = 0; i13 < childCount; i13++) {
                View childAt = recyclerView.getChildAt(i13);
                RecyclerView.n nVar = (RecyclerView.n) childAt.getLayoutParams();
                if (flexboxLayoutManager.E()) {
                    intrinsicWidth = childAt.getRight() + ((ViewGroup.MarginLayoutParams) nVar).rightMargin;
                    left = this.f36071a.getIntrinsicWidth() + intrinsicWidth;
                } else {
                    left = childAt.getLeft() - ((ViewGroup.MarginLayoutParams) nVar).leftMargin;
                    intrinsicWidth = left - this.f36071a.getIntrinsicWidth();
                }
                if (flexboxLayoutManager.isMainAxisDirectionHorizontal()) {
                    iMax = childAt.getTop() - ((ViewGroup.MarginLayoutParams) nVar).topMargin;
                    bottom = childAt.getBottom();
                    i11 = ((ViewGroup.MarginLayoutParams) nVar).bottomMargin;
                } else {
                    if (flexDirection == 3) {
                        int iMin = Math.min(childAt.getBottom() + ((ViewGroup.MarginLayoutParams) nVar).bottomMargin + this.f36071a.getIntrinsicHeight(), bottom2);
                        iMax = childAt.getTop() - ((ViewGroup.MarginLayoutParams) nVar).topMargin;
                        i12 = iMin;
                    } else {
                        iMax = Math.max((childAt.getTop() - ((ViewGroup.MarginLayoutParams) nVar).topMargin) - this.f36071a.getIntrinsicHeight(), top);
                        bottom = childAt.getBottom();
                        i11 = ((ViewGroup.MarginLayoutParams) nVar).bottomMargin;
                    }
                    this.f36071a.setBounds(intrinsicWidth, iMax, left, i12);
                    this.f36071a.draw(canvas);
                }
                i12 = bottom + i11;
                this.f36071a.setBounds(intrinsicWidth, iMax, left, i12);
                this.f36071a.draw(canvas);
            }
        }
    }

    public final boolean f(int i11, List<b> list, FlexboxLayoutManager flexboxLayoutManager) {
        int iB = flexboxLayoutManager.B(i11);
        if ((iB == -1 || iB >= flexboxLayoutManager.getFlexLinesInternal().size() || flexboxLayoutManager.getFlexLinesInternal().get(iB).f36057o != i11) && i11 != 0) {
            return list.size() != 0 && list.get(list.size() - 1).f36058p == i11 - 1;
        }
        return true;
    }

    public final boolean g() {
        return (this.f36072b & 1) > 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void getItemOffsets(@NonNull Rect rect, @NonNull View view, RecyclerView recyclerView, @NonNull RecyclerView.x xVar) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition == 0) {
            return;
        }
        if (!g() && !h()) {
            rect.set(0, 0, 0, 0);
            return;
        }
        FlexboxLayoutManager flexboxLayoutManager = (FlexboxLayoutManager) recyclerView.getLayoutManager();
        List<b> listA = flexboxLayoutManager.A();
        j(rect, childAdapterPosition, flexboxLayoutManager, listA, flexboxLayoutManager.getFlexDirection());
        i(rect, childAdapterPosition, flexboxLayoutManager, listA);
    }

    public final boolean h() {
        return (this.f36072b & 2) > 0;
    }

    public final void i(Rect rect, int i11, FlexboxLayoutManager flexboxLayoutManager, List<b> list) {
        if (list.size() == 0 || flexboxLayoutManager.B(i11) == 0) {
            return;
        }
        if (flexboxLayoutManager.isMainAxisDirectionHorizontal()) {
            if (g()) {
                rect.top = this.f36071a.getIntrinsicHeight();
                rect.bottom = 0;
                return;
            } else {
                rect.top = 0;
                rect.bottom = 0;
                return;
            }
        }
        if (h()) {
            if (flexboxLayoutManager.E()) {
                rect.right = this.f36071a.getIntrinsicWidth();
                rect.left = 0;
            } else {
                rect.left = this.f36071a.getIntrinsicWidth();
                rect.right = 0;
            }
        }
    }

    public final void j(Rect rect, int i11, FlexboxLayoutManager flexboxLayoutManager, List<b> list, int i12) {
        if (f(i11, list, flexboxLayoutManager)) {
            return;
        }
        if (flexboxLayoutManager.isMainAxisDirectionHorizontal()) {
            if (!h()) {
                rect.left = 0;
                rect.right = 0;
                return;
            } else if (flexboxLayoutManager.E()) {
                rect.right = this.f36071a.getIntrinsicWidth();
                rect.left = 0;
                return;
            } else {
                rect.left = this.f36071a.getIntrinsicWidth();
                rect.right = 0;
                return;
            }
        }
        if (!g()) {
            rect.top = 0;
            rect.bottom = 0;
        } else if (i12 == 3) {
            rect.bottom = this.f36071a.getIntrinsicHeight();
            rect.top = 0;
        } else {
            rect.top = this.f36071a.getIntrinsicHeight();
            rect.bottom = 0;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.x xVar) {
        d(canvas, recyclerView);
        e(canvas, recyclerView);
    }

    public void setDrawable(Drawable drawable) {
        if (drawable == null) {
            throw new IllegalArgumentException("Drawable cannot be null.");
        }
        this.f36071a = drawable;
    }

    public void setOrientation(int i11) {
        this.f36072b = i11;
    }
}
