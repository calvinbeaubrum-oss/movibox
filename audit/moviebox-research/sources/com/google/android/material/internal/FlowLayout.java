package com.google.android.material.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import com.google.android.gms.common.api.Api;
import com.google.android.material.R$id;
import com.google.android.material.R$styleable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class FlowLayout extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f36929a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f36930b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f36931c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f36932d;

    public FlowLayout(@NonNull Context context) {
        this(context, null);
    }

    public FlowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f36931c = false;
        b(context, attributeSet);
    }

    @TargetApi(21)
    public FlowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        this.f36931c = false;
        b(context, attributeSet);
    }

    public static int a(int i11, int i12, int i13) {
        if (i12 != Integer.MIN_VALUE) {
            return i12 != 1073741824 ? i13 : i11;
        }
        return Math.min(i13, i11);
    }

    public final void b(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.FlowLayout, 0, 0);
        this.f36929a = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.FlowLayout_lineSpacing, 0);
        this.f36930b = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.FlowLayout_itemSpacing, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    public int getItemSpacing() {
        return this.f36930b;
    }

    public int getLineSpacing() {
        return this.f36929a;
    }

    public int getRowCount() {
        return this.f36932d;
    }

    public int getRowIndex(@NonNull View view) {
        Object tag = view.getTag(R$id.row_index_key);
        if (tag instanceof Integer) {
            return ((Integer) tag).intValue();
        }
        return -1;
    }

    public boolean isSingleLine() {
        return this.f36931c;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        int marginEnd;
        int marginStart;
        if (getChildCount() == 0) {
            this.f36932d = 0;
            return;
        }
        this.f36932d = 1;
        boolean z12 = ViewCompat.getLayoutDirection(this) == 1;
        int paddingRight = z12 ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = z12 ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int i15 = (i13 - i11) - paddingLeft;
        int measuredWidth = paddingRight;
        int i16 = paddingTop;
        for (int i17 = 0; i17 < getChildCount(); i17++) {
            View childAt = getChildAt(i17);
            if (childAt.getVisibility() == 8) {
                childAt.setTag(R$id.row_index_key, -1);
            } else {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    marginStart = MarginLayoutParamsCompat.getMarginStart(marginLayoutParams);
                    marginEnd = MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams);
                } else {
                    marginEnd = 0;
                    marginStart = 0;
                }
                int measuredWidth2 = measuredWidth + marginStart + childAt.getMeasuredWidth();
                if (!this.f36931c && measuredWidth2 > i15) {
                    i16 = this.f36929a + paddingTop;
                    this.f36932d++;
                    measuredWidth = paddingRight;
                }
                childAt.setTag(R$id.row_index_key, Integer.valueOf(this.f36932d - 1));
                int i18 = measuredWidth + marginStart;
                int measuredWidth3 = childAt.getMeasuredWidth() + i18;
                int measuredHeight = childAt.getMeasuredHeight() + i16;
                if (z12) {
                    childAt.layout(i15 - measuredWidth3, i16, (i15 - measuredWidth) - marginStart, measuredHeight);
                } else {
                    childAt.layout(i18, i16, measuredWidth3, measuredHeight);
                }
                measuredWidth += marginStart + marginEnd + childAt.getMeasuredWidth() + this.f36930b;
                paddingTop = measuredHeight;
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i11, int i12) {
        int i13;
        int i14;
        int paddingLeft;
        int size = View.MeasureSpec.getSize(i11);
        int mode = View.MeasureSpec.getMode(i11);
        int size2 = View.MeasureSpec.getSize(i12);
        int mode2 = View.MeasureSpec.getMode(i12);
        int i15 = (mode == Integer.MIN_VALUE || mode == 1073741824) ? size : Api.BaseClientBuilder.API_PRIORITY_OTHER;
        int paddingLeft2 = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = i15 - getPaddingRight();
        int i16 = paddingTop;
        int i17 = 0;
        for (int i18 = 0; i18 < getChildCount(); i18++) {
            View childAt = getChildAt(i18);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i11, i12);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i13 = marginLayoutParams.leftMargin;
                    i14 = marginLayoutParams.rightMargin;
                } else {
                    i13 = 0;
                    i14 = 0;
                }
                int i19 = paddingLeft2;
                if (paddingLeft2 + i13 + childAt.getMeasuredWidth() <= paddingRight || isSingleLine()) {
                    paddingLeft = i19;
                } else {
                    paddingLeft = getPaddingLeft();
                    i16 = this.f36929a + paddingTop;
                }
                int measuredWidth = paddingLeft + i13 + childAt.getMeasuredWidth();
                int measuredHeight = i16 + childAt.getMeasuredHeight();
                if (measuredWidth > i17) {
                    i17 = measuredWidth;
                }
                paddingLeft2 = paddingLeft + i13 + i14 + childAt.getMeasuredWidth() + this.f36930b;
                if (i18 == getChildCount() - 1) {
                    i17 += i14;
                }
                paddingTop = measuredHeight;
            }
        }
        setMeasuredDimension(a(size, mode, i17 + getPaddingRight()), a(size2, mode2, paddingTop + getPaddingBottom()));
    }

    public void setItemSpacing(int i11) {
        this.f36930b = i11;
    }

    public void setLineSpacing(int i11) {
        this.f36929a = i11;
    }

    public void setSingleLine(boolean z11) {
        this.f36931c = z11;
    }
}
