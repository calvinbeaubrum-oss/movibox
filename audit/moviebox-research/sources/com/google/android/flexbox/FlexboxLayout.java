package com.google.android.flexbox;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class FlexboxLayout extends ViewGroup implements a {
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_END = 4;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_NONE = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f35983a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f35984b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f35985c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f35986d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f35987f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f35988g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public Drawable f35989h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public Drawable f35990i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f35991j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f35992k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f35993l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f35994m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int[] f35995n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public SparseIntArray f35996o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public c f35997p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public List<b> f35998q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public c.b f35999r;

    /* JADX INFO: compiled from: source.java */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams implements FlexItem {
        public static final Parcelable.Creator<LayoutParams> CREATOR = new a();
        private int mAlignSelf;
        private float mFlexBasisPercent;
        private float mFlexGrow;
        private float mFlexShrink;
        private int mMaxHeight;
        private int mMaxWidth;
        private int mMinHeight;
        private int mMinWidth;
        private int mOrder;
        private boolean mWrapBefore;

        /* JADX INFO: compiled from: source.java */
        public class a implements Parcelable.Creator<LayoutParams> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public LayoutParams createFromParcel(Parcel parcel) {
                return new LayoutParams(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public LayoutParams[] newArray(int i11) {
                return new LayoutParams[i11];
            }
        }

        public LayoutParams(int i11, int i12) {
            super(new ViewGroup.LayoutParams(i11, i12));
            this.mOrder = 1;
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMinWidth = -1;
            this.mMinHeight = -1;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mOrder = 1;
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMinWidth = -1;
            this.mMinHeight = -1;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FlexboxLayout_Layout);
            this.mOrder = typedArrayObtainStyledAttributes.getInt(R$styleable.FlexboxLayout_Layout_layout_order, 1);
            this.mFlexGrow = typedArrayObtainStyledAttributes.getFloat(R$styleable.FlexboxLayout_Layout_layout_flexGrow, 0.0f);
            this.mFlexShrink = typedArrayObtainStyledAttributes.getFloat(R$styleable.FlexboxLayout_Layout_layout_flexShrink, 1.0f);
            this.mAlignSelf = typedArrayObtainStyledAttributes.getInt(R$styleable.FlexboxLayout_Layout_layout_alignSelf, -1);
            this.mFlexBasisPercent = typedArrayObtainStyledAttributes.getFraction(R$styleable.FlexboxLayout_Layout_layout_flexBasisPercent, 1, 1, -1.0f);
            this.mMinWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.FlexboxLayout_Layout_layout_minWidth, -1);
            this.mMinHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.FlexboxLayout_Layout_layout_minHeight, -1);
            this.mMaxWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.FlexboxLayout_Layout_layout_maxWidth, 16777215);
            this.mMaxHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.FlexboxLayout_Layout_layout_maxHeight, 16777215);
            this.mWrapBefore = typedArrayObtainStyledAttributes.getBoolean(R$styleable.FlexboxLayout_Layout_layout_wrapBefore, false);
            typedArrayObtainStyledAttributes.recycle();
        }

        public LayoutParams(Parcel parcel) {
            super(0, 0);
            this.mOrder = 1;
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMinWidth = -1;
            this.mMinHeight = -1;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
            this.mOrder = parcel.readInt();
            this.mFlexGrow = parcel.readFloat();
            this.mFlexShrink = parcel.readFloat();
            this.mAlignSelf = parcel.readInt();
            this.mFlexBasisPercent = parcel.readFloat();
            this.mMinWidth = parcel.readInt();
            this.mMinHeight = parcel.readInt();
            this.mMaxWidth = parcel.readInt();
            this.mMaxHeight = parcel.readInt();
            this.mWrapBefore = parcel.readByte() != 0;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).leftMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).rightMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).topMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).height = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).width = parcel.readInt();
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.mOrder = 1;
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMinWidth = -1;
            this.mMinHeight = -1;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.mOrder = 1;
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMinWidth = -1;
            this.mMinHeight = -1;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.mOrder = 1;
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMinWidth = -1;
            this.mMinHeight = -1;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
            this.mOrder = layoutParams.mOrder;
            this.mFlexGrow = layoutParams.mFlexGrow;
            this.mFlexShrink = layoutParams.mFlexShrink;
            this.mAlignSelf = layoutParams.mAlignSelf;
            this.mFlexBasisPercent = layoutParams.mFlexBasisPercent;
            this.mMinWidth = layoutParams.mMinWidth;
            this.mMinHeight = layoutParams.mMinHeight;
            this.mMaxWidth = layoutParams.mMaxWidth;
            this.mMaxHeight = layoutParams.mMaxHeight;
            this.mWrapBefore = layoutParams.mWrapBefore;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getAlignSelf() {
            return this.mAlignSelf;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float getFlexBasisPercent() {
            return this.mFlexBasisPercent;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float getFlexGrow() {
            return this.mFlexGrow;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float getFlexShrink() {
            return this.mFlexShrink;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getHeight() {
            return ((ViewGroup.MarginLayoutParams) this).height;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginBottom() {
            return ((ViewGroup.MarginLayoutParams) this).bottomMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginLeft() {
            return ((ViewGroup.MarginLayoutParams) this).leftMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginRight() {
            return ((ViewGroup.MarginLayoutParams) this).rightMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginTop() {
            return ((ViewGroup.MarginLayoutParams) this).topMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMaxHeight() {
            return this.mMaxHeight;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMaxWidth() {
            return this.mMaxWidth;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMinHeight() {
            return this.mMinHeight;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMinWidth() {
            return this.mMinWidth;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getOrder() {
            return this.mOrder;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getWidth() {
            return ((ViewGroup.MarginLayoutParams) this).width;
        }

        @Override // com.google.android.flexbox.FlexItem
        public boolean isWrapBefore() {
            return this.mWrapBefore;
        }

        public void setAlignSelf(int i11) {
            this.mAlignSelf = i11;
        }

        public void setFlexBasisPercent(float f11) {
            this.mFlexBasisPercent = f11;
        }

        public void setFlexGrow(float f11) {
            this.mFlexGrow = f11;
        }

        public void setFlexShrink(float f11) {
            this.mFlexShrink = f11;
        }

        public void setHeight(int i11) {
            ((ViewGroup.MarginLayoutParams) this).height = i11;
        }

        public void setMaxHeight(int i11) {
            this.mMaxHeight = i11;
        }

        public void setMaxWidth(int i11) {
            this.mMaxWidth = i11;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMinHeight(int i11) {
            this.mMinHeight = i11;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMinWidth(int i11) {
            this.mMinWidth = i11;
        }

        public void setOrder(int i11) {
            this.mOrder = i11;
        }

        public void setWidth(int i11) {
            ((ViewGroup.MarginLayoutParams) this).width = i11;
        }

        public void setWrapBefore(boolean z11) {
            this.mWrapBefore = z11;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeInt(this.mOrder);
            parcel.writeFloat(this.mFlexGrow);
            parcel.writeFloat(this.mFlexShrink);
            parcel.writeInt(this.mAlignSelf);
            parcel.writeFloat(this.mFlexBasisPercent);
            parcel.writeInt(this.mMinWidth);
            parcel.writeInt(this.mMinHeight);
            parcel.writeInt(this.mMaxWidth);
            parcel.writeInt(this.mMaxHeight);
            parcel.writeByte(this.mWrapBefore ? (byte) 1 : (byte) 0);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).bottomMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).leftMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).rightMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).topMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).height);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).width);
        }
    }

    public FlexboxLayout(Context context) {
        this(context, null);
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f35988g = -1;
        this.f35997p = new c(this);
        this.f35998q = new ArrayList();
        this.f35999r = new c.b();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FlexboxLayout, i11, 0);
        this.f35983a = typedArrayObtainStyledAttributes.getInt(R$styleable.FlexboxLayout_flexDirection, 0);
        this.f35984b = typedArrayObtainStyledAttributes.getInt(R$styleable.FlexboxLayout_flexWrap, 0);
        this.f35985c = typedArrayObtainStyledAttributes.getInt(R$styleable.FlexboxLayout_justifyContent, 0);
        this.f35986d = typedArrayObtainStyledAttributes.getInt(R$styleable.FlexboxLayout_alignItems, 0);
        this.f35987f = typedArrayObtainStyledAttributes.getInt(R$styleable.FlexboxLayout_alignContent, 0);
        this.f35988g = typedArrayObtainStyledAttributes.getInt(R$styleable.FlexboxLayout_maxLine, -1);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(R$styleable.FlexboxLayout_dividerDrawable);
        if (drawable != null) {
            setDividerDrawableHorizontal(drawable);
            setDividerDrawableVertical(drawable);
        }
        Drawable drawable2 = typedArrayObtainStyledAttributes.getDrawable(R$styleable.FlexboxLayout_dividerDrawableHorizontal);
        if (drawable2 != null) {
            setDividerDrawableHorizontal(drawable2);
        }
        Drawable drawable3 = typedArrayObtainStyledAttributes.getDrawable(R$styleable.FlexboxLayout_dividerDrawableVertical);
        if (drawable3 != null) {
            setDividerDrawableVertical(drawable3);
        }
        int i12 = typedArrayObtainStyledAttributes.getInt(R$styleable.FlexboxLayout_showDivider, 0);
        if (i12 != 0) {
            this.f35992k = i12;
            this.f35991j = i12;
        }
        int i13 = typedArrayObtainStyledAttributes.getInt(R$styleable.FlexboxLayout_showDividerVertical, 0);
        if (i13 != 0) {
            this.f35992k = i13;
        }
        int i14 = typedArrayObtainStyledAttributes.getInt(R$styleable.FlexboxLayout_showDividerHorizontal, 0);
        if (i14 != 0) {
            this.f35991j = i14;
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public final boolean a(int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            if (this.f35998q.get(i12).c() > 0) {
                return false;
            }
        }
        return true;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i11, ViewGroup.LayoutParams layoutParams) {
        if (this.f35996o == null) {
            this.f35996o = new SparseIntArray(getChildCount());
        }
        this.f35995n = this.f35997p.n(view, i11, layoutParams, this.f35996o);
        super.addView(view, i11, layoutParams);
    }

    public final boolean b(int i11, int i12) {
        for (int i13 = 1; i13 <= i12; i13++) {
            View reorderedChildAt = getReorderedChildAt(i11 - i13);
            if (reorderedChildAt != null && reorderedChildAt.getVisibility() != 8) {
                return false;
            }
        }
        return true;
    }

    public final void c(Canvas canvas, boolean z11, boolean z12) {
        int paddingLeft = getPaddingLeft();
        int iMax = Math.max(0, (getWidth() - getPaddingRight()) - paddingLeft);
        int size = this.f35998q.size();
        for (int i11 = 0; i11 < size; i11++) {
            b bVar = this.f35998q.get(i11);
            for (int i12 = 0; i12 < bVar.f36050h; i12++) {
                int i13 = bVar.f36057o + i12;
                View reorderedChildAt = getReorderedChildAt(i13);
                if (reorderedChildAt != null && reorderedChildAt.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) reorderedChildAt.getLayoutParams();
                    if (g(i13, i12)) {
                        f(canvas, z11 ? reorderedChildAt.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin : (reorderedChildAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - this.f35994m, bVar.f36044b, bVar.f36049g);
                    }
                    if (i12 == bVar.f36050h - 1 && (this.f35992k & 4) > 0) {
                        f(canvas, z11 ? (reorderedChildAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - this.f35994m : reorderedChildAt.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, bVar.f36044b, bVar.f36049g);
                    }
                }
            }
            if (h(i11)) {
                e(canvas, paddingLeft, z12 ? bVar.f36046d : bVar.f36044b - this.f35993l, iMax);
            }
            if (i(i11) && (this.f35991j & 4) > 0) {
                e(canvas, paddingLeft, z12 ? bVar.f36044b - this.f35993l : bVar.f36046d, iMax);
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public final void d(Canvas canvas, boolean z11, boolean z12) {
        int paddingTop = getPaddingTop();
        int iMax = Math.max(0, (getHeight() - getPaddingBottom()) - paddingTop);
        int size = this.f35998q.size();
        for (int i11 = 0; i11 < size; i11++) {
            b bVar = this.f35998q.get(i11);
            for (int i12 = 0; i12 < bVar.f36050h; i12++) {
                int i13 = bVar.f36057o + i12;
                View reorderedChildAt = getReorderedChildAt(i13);
                if (reorderedChildAt != null && reorderedChildAt.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) reorderedChildAt.getLayoutParams();
                    if (g(i13, i12)) {
                        e(canvas, bVar.f36043a, z12 ? reorderedChildAt.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : (reorderedChildAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - this.f35993l, bVar.f36049g);
                    }
                    if (i12 == bVar.f36050h - 1 && (this.f35991j & 4) > 0) {
                        e(canvas, bVar.f36043a, z12 ? (reorderedChildAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - this.f35993l : reorderedChildAt.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, bVar.f36049g);
                    }
                }
            }
            if (h(i11)) {
                f(canvas, z11 ? bVar.f36045c : bVar.f36043a - this.f35994m, paddingTop, iMax);
            }
            if (i(i11) && (this.f35992k & 4) > 0) {
                f(canvas, z11 ? bVar.f36043a - this.f35994m : bVar.f36045c, paddingTop, iMax);
            }
        }
    }

    public final void e(Canvas canvas, int i11, int i12, int i13) {
        Drawable drawable = this.f35989h;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i11, i12, i13 + i11, this.f35993l + i12);
        this.f35989h.draw(canvas);
    }

    public final void f(Canvas canvas, int i11, int i12, int i13) {
        Drawable drawable = this.f35990i;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i11, i12, this.f35994m + i11, i13 + i12);
        this.f35990i.draw(canvas);
    }

    public final boolean g(int i11, int i12) {
        if (b(i11, i12)) {
            if (isMainAxisDirectionHorizontal()) {
                return (this.f35992k & 1) != 0;
            }
            return (this.f35991j & 1) != 0;
        }
        if (isMainAxisDirectionHorizontal()) {
            return (this.f35992k & 2) != 0;
        }
        return (this.f35991j & 2) != 0;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // com.google.android.flexbox.a
    public int getAlignContent() {
        return this.f35987f;
    }

    @Override // com.google.android.flexbox.a
    public int getAlignItems() {
        return this.f35986d;
    }

    @Override // com.google.android.flexbox.a
    public int getChildHeightMeasureSpec(int i11, int i12, int i13) {
        return ViewGroup.getChildMeasureSpec(i11, i12, i13);
    }

    @Override // com.google.android.flexbox.a
    public int getChildWidthMeasureSpec(int i11, int i12, int i13) {
        return ViewGroup.getChildMeasureSpec(i11, i12, i13);
    }

    @Override // com.google.android.flexbox.a
    public int getDecorationLengthCrossAxis(View view) {
        return 0;
    }

    @Override // com.google.android.flexbox.a
    public int getDecorationLengthMainAxis(View view, int i11, int i12) {
        int i13;
        int i14;
        if (isMainAxisDirectionHorizontal()) {
            i13 = g(i11, i12) ? this.f35994m : 0;
            if ((this.f35992k & 4) <= 0) {
                return i13;
            }
            i14 = this.f35994m;
        } else {
            i13 = g(i11, i12) ? this.f35993l : 0;
            if ((this.f35991j & 4) <= 0) {
                return i13;
            }
            i14 = this.f35993l;
        }
        return i13 + i14;
    }

    @Nullable
    public Drawable getDividerDrawableHorizontal() {
        return this.f35989h;
    }

    @Nullable
    public Drawable getDividerDrawableVertical() {
        return this.f35990i;
    }

    @Override // com.google.android.flexbox.a
    public int getFlexDirection() {
        return this.f35983a;
    }

    @Override // com.google.android.flexbox.a
    public View getFlexItemAt(int i11) {
        return getChildAt(i11);
    }

    @Override // com.google.android.flexbox.a
    public int getFlexItemCount() {
        return getChildCount();
    }

    public List<b> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.f35998q.size());
        for (b bVar : this.f35998q) {
            if (bVar.c() != 0) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    @Override // com.google.android.flexbox.a
    public List<b> getFlexLinesInternal() {
        return this.f35998q;
    }

    @Override // com.google.android.flexbox.a
    public int getFlexWrap() {
        return this.f35984b;
    }

    public int getJustifyContent() {
        return this.f35985c;
    }

    @Override // com.google.android.flexbox.a
    public int getLargestMainSize() {
        Iterator<b> it = this.f35998q.iterator();
        int iMax = Integer.MIN_VALUE;
        while (it.hasNext()) {
            iMax = Math.max(iMax, it.next().f36047e);
        }
        return iMax;
    }

    @Override // com.google.android.flexbox.a
    public int getMaxLine() {
        return this.f35988g;
    }

    public View getReorderedChildAt(int i11) {
        if (i11 < 0) {
            return null;
        }
        int[] iArr = this.f35995n;
        if (i11 >= iArr.length) {
            return null;
        }
        return getChildAt(iArr[i11]);
    }

    @Override // com.google.android.flexbox.a
    public View getReorderedFlexItemAt(int i11) {
        return getReorderedChildAt(i11);
    }

    public int getShowDividerHorizontal() {
        return this.f35991j;
    }

    public int getShowDividerVertical() {
        return this.f35992k;
    }

    @Override // com.google.android.flexbox.a
    public int getSumOfCrossSize() {
        int size = this.f35998q.size();
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            b bVar = this.f35998q.get(i12);
            if (h(i12)) {
                i11 += isMainAxisDirectionHorizontal() ? this.f35993l : this.f35994m;
            }
            if (i(i12)) {
                i11 += isMainAxisDirectionHorizontal() ? this.f35993l : this.f35994m;
            }
            i11 += bVar.f36049g;
        }
        return i11;
    }

    public final boolean h(int i11) {
        if (i11 < 0 || i11 >= this.f35998q.size()) {
            return false;
        }
        if (a(i11)) {
            if (isMainAxisDirectionHorizontal()) {
                return (this.f35991j & 1) != 0;
            }
            return (this.f35992k & 1) != 0;
        }
        if (isMainAxisDirectionHorizontal()) {
            return (this.f35991j & 2) != 0;
        }
        return (this.f35992k & 2) != 0;
    }

    public final boolean i(int i11) {
        if (i11 < 0 || i11 >= this.f35998q.size()) {
            return false;
        }
        for (int i12 = i11 + 1; i12 < this.f35998q.size(); i12++) {
            if (this.f35998q.get(i12).c() > 0) {
                return false;
            }
        }
        if (isMainAxisDirectionHorizontal()) {
            return (this.f35991j & 4) != 0;
        }
        return (this.f35992k & 4) != 0;
    }

    @Override // com.google.android.flexbox.a
    public boolean isMainAxisDirectionHorizontal() {
        int i11 = this.f35983a;
        return i11 == 0 || i11 == 1;
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:45:0x00e7  */
    public final void j(boolean z11, int i11, int i12, int i13, int i14) {
        float measuredWidth;
        float f11;
        float f12;
        int i15;
        View reorderedChildAt;
        int i16;
        int i17;
        float f13;
        int i18;
        LayoutParams layoutParams;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int i19 = i13 - i11;
        int paddingBottom = (i14 - i12) - getPaddingBottom();
        int paddingTop = getPaddingTop();
        int size = this.f35998q.size();
        int i21 = 0;
        while (i21 < size) {
            b bVar = this.f35998q.get(i21);
            if (h(i21)) {
                int i22 = this.f35993l;
                paddingBottom -= i22;
                paddingTop += i22;
            }
            int i23 = this.f35985c;
            int i24 = 1;
            if (i23 == 0) {
                measuredWidth = paddingLeft;
                f11 = i19 - paddingRight;
            } else if (i23 != 1) {
                if (i23 == 2) {
                    int i25 = bVar.f36047e;
                    measuredWidth = paddingLeft + ((i19 - i25) / 2.0f);
                    f11 = (i19 - paddingRight) - ((i19 - i25) / 2.0f);
                } else if (i23 == 3) {
                    measuredWidth = paddingLeft;
                    int iC = bVar.c();
                    f12 = (i19 - bVar.f36047e) / (iC != 1 ? iC - 1 : 1.0f);
                    f11 = i19 - paddingRight;
                } else if (i23 == 4) {
                    int iC2 = bVar.c();
                    f12 = iC2 != 0 ? (i19 - bVar.f36047e) / iC2 : 0.0f;
                    float f14 = f12 / 2.0f;
                    measuredWidth = paddingLeft + f14;
                    f11 = (i19 - paddingRight) - f14;
                } else {
                    if (i23 != 5) {
                        throw new IllegalStateException("Invalid justifyContent is set: " + this.f35985c);
                    }
                    int iC3 = bVar.c();
                    f12 = iC3 != 0 ? (i19 - bVar.f36047e) / (iC3 + 1) : 0.0f;
                    measuredWidth = paddingLeft + f12;
                    f11 = (i19 - paddingRight) - f12;
                }
                float fMax = Math.max(f12, 0.0f);
                i15 = 0;
                while (i15 < bVar.f36050h) {
                    int i26 = bVar.f36057o + i15;
                    reorderedChildAt = getReorderedChildAt(i26);
                    if (reorderedChildAt != null || reorderedChildAt.getVisibility() == 8) {
                        i16 = paddingLeft;
                        i17 = i15;
                    } else {
                        LayoutParams layoutParams2 = (LayoutParams) reorderedChildAt.getLayoutParams();
                        float f15 = measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin;
                        float f16 = f11 - ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin;
                        if (g(i26, i15)) {
                            int i27 = this.f35994m;
                            float f17 = i27;
                            f15 += f17;
                            i18 = i27;
                            f13 = f16 - f17;
                        } else {
                            f13 = f16;
                            i18 = 0;
                        }
                        int i28 = (i15 != bVar.f36050h - i24 || (this.f35992k & 4) <= 0) ? 0 : this.f35994m;
                        if (this.f35984b != 2) {
                            i16 = paddingLeft;
                            i17 = i15;
                            layoutParams = layoutParams2;
                            if (z11) {
                                this.f35997p.Q(reorderedChildAt, bVar, Math.round(f13) - reorderedChildAt.getMeasuredWidth(), paddingTop, Math.round(f13), paddingTop + reorderedChildAt.getMeasuredHeight());
                            } else {
                                this.f35997p.Q(reorderedChildAt, bVar, Math.round(f15), paddingTop, Math.round(f15) + reorderedChildAt.getMeasuredWidth(), paddingTop + reorderedChildAt.getMeasuredHeight());
                            }
                        } else if (z11) {
                            i17 = i15;
                            i16 = paddingLeft;
                            layoutParams = layoutParams2;
                            this.f35997p.Q(reorderedChildAt, bVar, Math.round(f13) - reorderedChildAt.getMeasuredWidth(), paddingBottom - reorderedChildAt.getMeasuredHeight(), Math.round(f13), paddingBottom);
                        } else {
                            i16 = paddingLeft;
                            i17 = i15;
                            layoutParams = layoutParams2;
                            this.f35997p.Q(reorderedChildAt, bVar, Math.round(f15), paddingBottom - reorderedChildAt.getMeasuredHeight(), Math.round(f15) + reorderedChildAt.getMeasuredWidth(), paddingBottom);
                        }
                        measuredWidth = f15 + reorderedChildAt.getMeasuredWidth() + fMax + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                        float measuredWidth2 = f13 - ((reorderedChildAt.getMeasuredWidth() + fMax) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin);
                        if (z11) {
                            bVar.d(reorderedChildAt, i28, 0, i18, 0);
                        } else {
                            bVar.d(reorderedChildAt, i18, 0, i28, 0);
                        }
                        f11 = measuredWidth2;
                    }
                    i15 = i17 + 1;
                    paddingLeft = i16;
                    i24 = 1;
                }
                int i29 = paddingLeft;
                int i31 = bVar.f36049g;
                paddingTop += i31;
                paddingBottom -= i31;
                i21++;
                paddingLeft = i29;
            } else {
                int i32 = bVar.f36047e;
                f11 = i32 - paddingLeft;
                measuredWidth = (i19 - i32) + paddingRight;
            }
            f12 = 0.0f;
            float fMax2 = Math.max(f12, 0.0f);
            i15 = 0;
            while (i15 < bVar.f36050h) {
                int i210 = bVar.f36057o + i15;
                reorderedChildAt = getReorderedChildAt(i210);
                if (reorderedChildAt != null) {
                    i16 = paddingLeft;
                    i17 = i15;
                } else {
                    i16 = paddingLeft;
                    i17 = i15;
                }
                i15 = i17 + 1;
                paddingLeft = i16;
                i24 = 1;
            }
            int i211 = paddingLeft;
            int i33 = bVar.f36049g;
            paddingTop += i33;
            paddingBottom -= i33;
            i21++;
            paddingLeft = i211;
        }
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:46:0x00e4  */
    public final void k(boolean z11, boolean z12, int i11, int i12, int i13, int i14) {
        float f11;
        int i15;
        float f12;
        float f13;
        int i16;
        View reorderedChildAt;
        int i17;
        float f14;
        float f15;
        int i18;
        LayoutParams layoutParams;
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingRight = getPaddingRight();
        int paddingLeft = getPaddingLeft();
        int i19 = i14 - i12;
        int i21 = (i13 - i11) - paddingRight;
        int size = this.f35998q.size();
        for (int i22 = 0; i22 < size; i22++) {
            b bVar = this.f35998q.get(i22);
            if (h(i22)) {
                int i23 = this.f35994m;
                paddingLeft += i23;
                i21 -= i23;
            }
            int i24 = this.f35985c;
            if (i24 != 0) {
                if (i24 == 1) {
                    int i25 = bVar.f36047e;
                    f11 = (i19 - i25) + paddingBottom;
                    i15 = i25 - paddingTop;
                } else if (i24 == 2) {
                    int i26 = bVar.f36047e;
                    f12 = (i19 - paddingBottom) - ((i19 - i26) / 2.0f);
                    f11 = paddingTop + ((i19 - i26) / 2.0f);
                    f13 = 0.0f;
                } else if (i24 == 3) {
                    f11 = paddingTop;
                    int iC = bVar.c();
                    f13 = (i19 - bVar.f36047e) / (iC != 1 ? iC - 1 : 1.0f);
                    f12 = i19 - paddingBottom;
                } else if (i24 == 4) {
                    int iC2 = bVar.c();
                    f13 = iC2 != 0 ? (i19 - bVar.f36047e) / iC2 : 0.0f;
                    float f16 = f13 / 2.0f;
                    f11 = paddingTop + f16;
                    f12 = (i19 - paddingBottom) - f16;
                } else {
                    if (i24 != 5) {
                        throw new IllegalStateException("Invalid justifyContent is set: " + this.f35985c);
                    }
                    int iC3 = bVar.c();
                    f13 = iC3 != 0 ? (i19 - bVar.f36047e) / (iC3 + 1) : 0.0f;
                    f11 = paddingTop + f13;
                    f12 = (i19 - paddingBottom) - f13;
                }
                float fMax = Math.max(f13, 0.0f);
                i16 = 0;
                while (i16 < bVar.f36050h) {
                    int i27 = bVar.f36057o + i16;
                    reorderedChildAt = getReorderedChildAt(i27);
                    if (reorderedChildAt != null || reorderedChildAt.getVisibility() == 8) {
                        i17 = i16;
                    } else {
                        LayoutParams layoutParams2 = (LayoutParams) reorderedChildAt.getLayoutParams();
                        float f17 = f11 + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin;
                        float f18 = f12 - ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin;
                        if (g(i27, i16)) {
                            int i28 = this.f35993l;
                            float f19 = i28;
                            f14 = f17 + f19;
                            i18 = i28;
                            f15 = f18 - f19;
                        } else {
                            f14 = f17;
                            f15 = f18;
                            i18 = 0;
                        }
                        int i29 = (i16 != bVar.f36050h - 1 || (this.f35991j & 4) <= 0) ? 0 : this.f35993l;
                        if (!z11) {
                            i17 = i16;
                            layoutParams = layoutParams2;
                            if (z12) {
                                this.f35997p.R(reorderedChildAt, bVar, false, paddingLeft, Math.round(f15) - reorderedChildAt.getMeasuredHeight(), paddingLeft + reorderedChildAt.getMeasuredWidth(), Math.round(f15));
                            } else {
                                this.f35997p.R(reorderedChildAt, bVar, false, paddingLeft, Math.round(f14), paddingLeft + reorderedChildAt.getMeasuredWidth(), Math.round(f14) + reorderedChildAt.getMeasuredHeight());
                            }
                        } else if (z12) {
                            i17 = i16;
                            layoutParams = layoutParams2;
                            this.f35997p.R(reorderedChildAt, bVar, true, i21 - reorderedChildAt.getMeasuredWidth(), Math.round(f15) - reorderedChildAt.getMeasuredHeight(), i21, Math.round(f15));
                        } else {
                            i17 = i16;
                            layoutParams = layoutParams2;
                            this.f35997p.R(reorderedChildAt, bVar, true, i21 - reorderedChildAt.getMeasuredWidth(), Math.round(f14), i21, Math.round(f14) + reorderedChildAt.getMeasuredHeight());
                        }
                        LayoutParams layoutParams3 = layoutParams;
                        float measuredHeight = f14 + reorderedChildAt.getMeasuredHeight() + fMax + ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin;
                        float measuredHeight2 = f15 - ((reorderedChildAt.getMeasuredHeight() + fMax) + ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin);
                        if (z12) {
                            bVar.d(reorderedChildAt, 0, i29, 0, i18);
                        } else {
                            bVar.d(reorderedChildAt, 0, i18, 0, i29);
                        }
                        f11 = measuredHeight;
                        f12 = measuredHeight2;
                    }
                    i16 = i17 + 1;
                }
                int i31 = bVar.f36049g;
                paddingLeft += i31;
                i21 -= i31;
            } else {
                f11 = paddingTop;
                i15 = i19 - paddingBottom;
            }
            f12 = i15;
            f13 = 0.0f;
            float fMax2 = Math.max(f13, 0.0f);
            i16 = 0;
            while (i16 < bVar.f36050h) {
                int i210 = bVar.f36057o + i16;
                reorderedChildAt = getReorderedChildAt(i210);
                if (reorderedChildAt != null) {
                    i17 = i16;
                } else {
                    i17 = i16;
                }
                i16 = i17 + 1;
            }
            int i32 = bVar.f36049g;
            paddingLeft += i32;
            i21 -= i32;
        }
    }

    public final void l(int i11, int i12) {
        this.f35998q.clear();
        this.f35999r.a();
        this.f35997p.c(this.f35999r, i11, i12);
        this.f35998q = this.f35999r.f36066a;
        this.f35997p.p(i11, i12);
        if (this.f35986d == 3) {
            for (b bVar : this.f35998q) {
                int iMax = Integer.MIN_VALUE;
                for (int i13 = 0; i13 < bVar.f36050h; i13++) {
                    View reorderedChildAt = getReorderedChildAt(bVar.f36057o + i13);
                    if (reorderedChildAt != null && reorderedChildAt.getVisibility() != 8) {
                        LayoutParams layoutParams = (LayoutParams) reorderedChildAt.getLayoutParams();
                        iMax = this.f35984b != 2 ? Math.max(iMax, reorderedChildAt.getMeasuredHeight() + Math.max(bVar.f36054l - reorderedChildAt.getBaseline(), ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) : Math.max(iMax, reorderedChildAt.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + Math.max((bVar.f36054l - reorderedChildAt.getMeasuredHeight()) + reorderedChildAt.getBaseline(), ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin));
                    }
                }
                bVar.f36049g = iMax;
            }
        }
        this.f35997p.o(i11, i12, getPaddingTop() + getPaddingBottom());
        this.f35997p.X();
        n(this.f35983a, i11, i12, this.f35999r.f36067b);
    }

    public final void m(int i11, int i12) {
        this.f35998q.clear();
        this.f35999r.a();
        this.f35997p.f(this.f35999r, i11, i12);
        this.f35998q = this.f35999r.f36066a;
        this.f35997p.p(i11, i12);
        this.f35997p.o(i11, i12, getPaddingLeft() + getPaddingRight());
        this.f35997p.X();
        n(this.f35983a, i11, i12, this.f35999r.f36067b);
    }

    public final void n(int i11, int i12, int i13, int i14) {
        int sumOfCrossSize;
        int largestMainSize;
        int iResolveSizeAndState;
        int iResolveSizeAndState2;
        int mode = View.MeasureSpec.getMode(i12);
        int size = View.MeasureSpec.getSize(i12);
        int mode2 = View.MeasureSpec.getMode(i13);
        int size2 = View.MeasureSpec.getSize(i13);
        if (i11 == 0 || i11 == 1) {
            sumOfCrossSize = getSumOfCrossSize() + getPaddingTop() + getPaddingBottom();
            largestMainSize = getLargestMainSize();
        } else {
            if (i11 != 2 && i11 != 3) {
                throw new IllegalArgumentException("Invalid flex direction: " + i11);
            }
            sumOfCrossSize = getLargestMainSize();
            largestMainSize = getSumOfCrossSize() + getPaddingLeft() + getPaddingRight();
        }
        if (mode == Integer.MIN_VALUE) {
            if (size < largestMainSize) {
                i14 = View.combineMeasuredStates(i14, 16777216);
            } else {
                size = largestMainSize;
            }
            iResolveSizeAndState = View.resolveSizeAndState(size, i12, i14);
        } else if (mode == 0) {
            iResolveSizeAndState = View.resolveSizeAndState(largestMainSize, i12, i14);
        } else {
            if (mode != 1073741824) {
                throw new IllegalStateException("Unknown width mode is set: " + mode);
            }
            if (size < largestMainSize) {
                i14 = View.combineMeasuredStates(i14, 16777216);
            }
            iResolveSizeAndState = View.resolveSizeAndState(size, i12, i14);
        }
        if (mode2 == Integer.MIN_VALUE) {
            if (size2 < sumOfCrossSize) {
                i14 = View.combineMeasuredStates(i14, 256);
            } else {
                size2 = sumOfCrossSize;
            }
            iResolveSizeAndState2 = View.resolveSizeAndState(size2, i13, i14);
        } else if (mode2 == 0) {
            iResolveSizeAndState2 = View.resolveSizeAndState(sumOfCrossSize, i13, i14);
        } else {
            if (mode2 != 1073741824) {
                throw new IllegalStateException("Unknown height mode is set: " + mode2);
            }
            if (size2 < sumOfCrossSize) {
                i14 = View.combineMeasuredStates(i14, 256);
            }
            iResolveSizeAndState2 = View.resolveSizeAndState(size2, i13, i14);
        }
        setMeasuredDimension(iResolveSizeAndState, iResolveSizeAndState2);
    }

    public final void o() {
        if (this.f35989h == null && this.f35990i == null) {
            setWillNotDraw(true);
        } else {
            setWillNotDraw(false);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f35990i == null && this.f35989h == null) {
            return;
        }
        if (this.f35991j == 0 && this.f35992k == 0) {
            return;
        }
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int i11 = this.f35983a;
        if (i11 == 0) {
            c(canvas, layoutDirection == 1, this.f35984b == 2);
            return;
        }
        if (i11 == 1) {
            c(canvas, layoutDirection != 1, this.f35984b == 2);
            return;
        }
        if (i11 == 2) {
            boolean z11 = layoutDirection == 1;
            if (this.f35984b == 2) {
                z11 = !z11;
            }
            d(canvas, z11, false);
            return;
        }
        if (i11 != 3) {
            return;
        }
        boolean z12 = layoutDirection == 1;
        if (this.f35984b == 2) {
            z12 = !z12;
        }
        d(canvas, z12, true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        boolean z12;
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int i15 = this.f35983a;
        if (i15 == 0) {
            j(layoutDirection == 1, i11, i12, i13, i14);
            return;
        }
        if (i15 == 1) {
            j(layoutDirection != 1, i11, i12, i13, i14);
            return;
        }
        if (i15 == 2) {
            z12 = layoutDirection == 1;
            k(this.f35984b == 2 ? !z12 : z12, false, i11, i12, i13, i14);
        } else if (i15 == 3) {
            z12 = layoutDirection == 1;
            k(this.f35984b == 2 ? !z12 : z12, true, i11, i12, i13, i14);
        } else {
            throw new IllegalStateException("Invalid flex direction is set: " + this.f35983a);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i11, int i12) {
        if (this.f35996o == null) {
            this.f35996o = new SparseIntArray(getChildCount());
        }
        if (this.f35997p.O(this.f35996o)) {
            this.f35995n = this.f35997p.m(this.f35996o);
        }
        int i13 = this.f35983a;
        if (i13 == 0 || i13 == 1) {
            l(i11, i12);
            return;
        }
        if (i13 == 2 || i13 == 3) {
            m(i11, i12);
            return;
        }
        throw new IllegalStateException("Invalid value for the flex direction is set: " + this.f35983a);
    }

    @Override // com.google.android.flexbox.a
    public void onNewFlexItemAdded(View view, int i11, int i12, b bVar) {
        if (g(i11, i12)) {
            if (isMainAxisDirectionHorizontal()) {
                int i13 = bVar.f36047e;
                int i14 = this.f35994m;
                bVar.f36047e = i13 + i14;
                bVar.f36048f += i14;
                return;
            }
            int i15 = bVar.f36047e;
            int i16 = this.f35993l;
            bVar.f36047e = i15 + i16;
            bVar.f36048f += i16;
        }
    }

    @Override // com.google.android.flexbox.a
    public void onNewFlexLineAdded(b bVar) {
        if (isMainAxisDirectionHorizontal()) {
            if ((this.f35992k & 4) > 0) {
                int i11 = bVar.f36047e;
                int i12 = this.f35994m;
                bVar.f36047e = i11 + i12;
                bVar.f36048f += i12;
                return;
            }
            return;
        }
        if ((this.f35991j & 4) > 0) {
            int i13 = bVar.f36047e;
            int i14 = this.f35993l;
            bVar.f36047e = i13 + i14;
            bVar.f36048f += i14;
        }
    }

    public void setAlignContent(int i11) {
        if (this.f35987f != i11) {
            this.f35987f = i11;
            requestLayout();
        }
    }

    public void setAlignItems(int i11) {
        if (this.f35986d != i11) {
            this.f35986d = i11;
            requestLayout();
        }
    }

    public void setDividerDrawable(Drawable drawable) {
        setDividerDrawableHorizontal(drawable);
        setDividerDrawableVertical(drawable);
    }

    public void setDividerDrawableHorizontal(@Nullable Drawable drawable) {
        if (drawable == this.f35989h) {
            return;
        }
        this.f35989h = drawable;
        if (drawable != null) {
            this.f35993l = drawable.getIntrinsicHeight();
        } else {
            this.f35993l = 0;
        }
        o();
        requestLayout();
    }

    public void setDividerDrawableVertical(@Nullable Drawable drawable) {
        if (drawable == this.f35990i) {
            return;
        }
        this.f35990i = drawable;
        if (drawable != null) {
            this.f35994m = drawable.getIntrinsicWidth();
        } else {
            this.f35994m = 0;
        }
        o();
        requestLayout();
    }

    public void setFlexDirection(int i11) {
        if (this.f35983a != i11) {
            this.f35983a = i11;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public void setFlexLines(List<b> list) {
        this.f35998q = list;
    }

    public void setFlexWrap(int i11) {
        if (this.f35984b != i11) {
            this.f35984b = i11;
            requestLayout();
        }
    }

    public void setJustifyContent(int i11) {
        if (this.f35985c != i11) {
            this.f35985c = i11;
            requestLayout();
        }
    }

    public void setMaxLine(int i11) {
        if (this.f35988g != i11) {
            this.f35988g = i11;
            requestLayout();
        }
    }

    public void setShowDivider(int i11) {
        setShowDividerVertical(i11);
        setShowDividerHorizontal(i11);
    }

    public void setShowDividerHorizontal(int i11) {
        if (i11 != this.f35991j) {
            this.f35991j = i11;
            requestLayout();
        }
    }

    public void setShowDividerVertical(int i11) {
        if (i11 != this.f35992k) {
            this.f35992k = i11;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public void updateViewCache(int i11, View view) {
    }
}
