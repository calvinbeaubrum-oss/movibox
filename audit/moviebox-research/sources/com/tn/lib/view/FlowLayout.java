package com.tn.lib.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.api.Api;
import com.tn.lib.widget.R$styleable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class FlowLayout extends ViewGroup {
    public static final int SPACING_ALIGN = -65537;
    public static final int SPACING_AUTO = -65536;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f49517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f49518b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f49519c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f49520d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f49521f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f49522g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f49523h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f49524i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f49525j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f49526k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f49527l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public List<Float> f49528m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List<Integer> f49529n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public List<Integer> f49530o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public List<Integer> f49531p;

    public FlowLayout(Context context) {
        this(context, null);
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f49517a = true;
        this.f49518b = 0;
        this.f49519c = 0;
        this.f49520d = -65538;
        this.f49521f = 0.0f;
        this.f49522g = 0.0f;
        this.f49523h = false;
        this.f49524i = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.f49525j = -1;
        this.f49526k = SPACING_AUTO;
        this.f49528m = new ArrayList();
        this.f49529n = new ArrayList();
        this.f49530o = new ArrayList();
        this.f49531p = new ArrayList();
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.FlowLayout, 0, 0);
        try {
            this.f49517a = typedArrayObtainStyledAttributes.getBoolean(R$styleable.FlowLayout_flFlow, true);
            this.f49518b = b(typedArrayObtainStyledAttributes, R$styleable.FlowLayout_flChildSpacing, (int) a(0.0f));
            this.f49519c = b(typedArrayObtainStyledAttributes, R$styleable.FlowLayout_flMinChildSpacing, (int) a(0.0f));
            this.f49520d = b(typedArrayObtainStyledAttributes, R$styleable.FlowLayout_flChildSpacingForLastRow, -65538);
            this.f49521f = b(typedArrayObtainStyledAttributes, R$styleable.FlowLayout_flRowSpacing, (int) a(0.0f));
            this.f49524i = typedArrayObtainStyledAttributes.getInt(R$styleable.FlowLayout_flMaxRows, Api.BaseClientBuilder.API_PRIORITY_OTHER);
            this.f49523h = typedArrayObtainStyledAttributes.getBoolean(R$styleable.FlowLayout_flRtl, false);
            this.f49525j = typedArrayObtainStyledAttributes.getInt(R$styleable.FlowLayout_android_gravity, -1);
            this.f49526k = typedArrayObtainStyledAttributes.getInt(R$styleable.FlowLayout_flRowVerticalGravity, SPACING_AUTO);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public final float a(float f11) {
        return TypedValue.applyDimension(1, f11, getResources().getDisplayMetrics());
    }

    public final int b(TypedArray typedArray, int i11, int i12) {
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(i11, typedValue);
        return typedValue.type == 5 ? typedArray.getDimensionPixelSize(i11, i12) : typedArray.getInt(i11, i12);
    }

    public final int c(int i11, int i12, int i13, int i14) {
        if (this.f49518b == -65536 || i14 >= this.f49530o.size() || i14 >= this.f49531p.size() || this.f49531p.get(i14).intValue() <= 0) {
            return 0;
        }
        if (i11 == 1) {
            return ((i12 - i13) - this.f49530o.get(i14).intValue()) / 2;
        }
        if (i11 != 5) {
            return 0;
        }
        return (i12 - i13) - this.f49530o.get(i14).intValue();
    }

    public final float d(int i11, int i12, int i13, int i14) {
        if (i11 != -65536) {
            return i11;
        }
        if (i14 > 1) {
            return (i12 - i13) / (i14 - 1);
        }
        return 0.0f;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.MarginLayoutParams(layoutParams);
    }

    public int getChildSpacing() {
        return this.f49518b;
    }

    public int getChildSpacingForLastRow() {
        return this.f49520d;
    }

    public int getCountInRow(int i11) {
        return this.f49531p.get(i11).intValue();
    }

    public int getMaxRows() {
        return this.f49524i;
    }

    public int getMinChildSpacing() {
        return this.f49519c;
    }

    public float getRowSpacing() {
        return this.f49521f;
    }

    public int getRowsCount() {
        return this.f49531p.size();
    }

    public boolean isFlow() {
        return this.f49517a;
    }

    public boolean isRtl() {
        return this.f49523h;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x005d  */
    /* JADX WARN: Code duplicated, block: B:43:0x0144  */
    /* JADX WARN: Code duplicated, block: B:44:0x014a  */
    /* JADX WARN: Code duplicated, block: B:48:0x0174  */
    /* JADX WARN: Code duplicated, block: B:50:0x0180  */
    /* JADX WARN: Code duplicated, block: B:51:0x0182  */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        int i15;
        int i16;
        int i17;
        int iC;
        int i18;
        int size;
        int i19;
        int i21;
        View childAt;
        int iIntValue;
        int i22;
        int width;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        float f11;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int width2 = this.f49523h ? getWidth() - paddingRight : paddingLeft;
        int i29 = this.f49525j;
        int i31 = i29 & 112;
        int i32 = i29 & 7;
        if (i31 != 16) {
            if (i31 == 80) {
                i15 = (((i14 - i12) - paddingTop) - paddingBottom) - this.f49527l;
            }
            i16 = paddingLeft + paddingRight;
            i17 = i13 - i11;
            iC = width2 + c(i32, i17, i16, 0);
            i18 = this.f49526k & 112;
            size = this.f49531p.size();
            i19 = 0;
            i21 = 0;
            while (i19 < Math.min(size, this.f49524i)) {
                iIntValue = this.f49531p.get(i19).intValue();
                int iIntValue2 = this.f49529n.get(i19).intValue();
                float fFloatValue = this.f49528m.get(i19).floatValue();
                i22 = 0;
                while (true) {
                    paddingLeft = paddingLeft;
                    if (i22 >= iIntValue || i21 >= getChildCount()) {
                        break;
                    }
                    int i33 = i21 + 1;
                    View childAt2 = getChildAt(i21);
                    i21 = i33;
                    size = size;
                    if (childAt2.getVisibility() != 8) {
                        int i34 = i22 + 1;
                        ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                            int i35 = marginLayoutParams.leftMargin;
                            int i36 = marginLayoutParams.rightMargin;
                            i25 = marginLayoutParams.topMargin;
                            i24 = marginLayoutParams.bottomMargin;
                            int i37 = iIntValue;
                            i27 = i35;
                            i26 = i36;
                            i23 = i37;
                        } else {
                            i23 = iIntValue;
                            i24 = 0;
                            i25 = 0;
                            i26 = 0;
                            i27 = 0;
                        }
                        int measuredWidth = childAt2.getMeasuredWidth();
                        int measuredHeight = childAt2.getMeasuredHeight();
                        int i38 = paddingTop + i25;
                        int i39 = i32;
                        if (i18 == 80) {
                            i28 = ((paddingTop + iIntValue2) - i24) - measuredHeight;
                        } else {
                            if (i18 == 16) {
                                i38 += (((iIntValue2 - i25) - i24) - measuredHeight) / 2;
                            }
                            i28 = i38;
                        }
                        int i40 = i28 + measuredHeight;
                        if (this.f49523h) {
                            int i41 = iC - i26;
                            childAt2.layout(i41 - measuredWidth, i28, i41, i40);
                            f11 = iC - (((measuredWidth + fFloatValue) + i27) + i26);
                        } else {
                            int i42 = iC + i27;
                            childAt2.layout(i42, i28, i42 + measuredWidth, i40);
                            f11 = iC + measuredWidth + fFloatValue + i27 + i26;
                        }
                        iC = (int) f11;
                        i22 = i34;
                        iIntValue = i23;
                        i16 = i16;
                        i18 = i18;
                        i32 = i39;
                    }
                }
                int i43 = i16;
                int i44 = i32;
                int i45 = i18;
                int i46 = size;
                if (this.f49523h) {
                    width = getWidth() - paddingRight;
                } else {
                    width = paddingLeft;
                }
                i19++;
                int iC2 = width + c(i44, i17, i43, i19);
                paddingTop = (int) (paddingTop + iIntValue2 + this.f49522g);
                size = i46;
                i32 = i44;
                i16 = i43;
                i18 = i45;
                iC = iC2;
                paddingLeft = paddingLeft;
            }
            while (i21 < getChildCount()) {
                childAt = getChildAt(i21);
                if (childAt.getVisibility() == 8) {
                    childAt.layout(0, 0, 0, 0);
                }
                i21++;
            }
        }
        i15 = ((((i14 - i12) - paddingTop) - paddingBottom) - this.f49527l) / 2;
        paddingTop += i15;
        i16 = paddingLeft + paddingRight;
        i17 = i13 - i11;
        iC = width2 + c(i32, i17, i16, 0);
        i18 = this.f49526k & 112;
        size = this.f49531p.size();
        i19 = 0;
        i21 = 0;
        while (i19 < Math.min(size, this.f49524i)) {
            iIntValue = this.f49531p.get(i19).intValue();
            int iIntValue3 = this.f49529n.get(i19).intValue();
            float fFloatValue2 = this.f49528m.get(i19).floatValue();
            i22 = 0;
            while (true) {
                paddingLeft = paddingLeft;
                if (i22 >= iIntValue) {
                    break;
                }
                break;
                break;
            }
            int i47 = i16;
            int i48 = i32;
            int i49 = i18;
            int i410 = size;
            if (this.f49523h) {
                width = getWidth() - paddingRight;
            } else {
                width = paddingLeft;
            }
            i19++;
            int iC3 = width + c(i48, i17, i47, i19);
            paddingTop = (int) (paddingTop + iIntValue3 + this.f49522g);
            size = i410;
            i32 = i48;
            i16 = i47;
            i18 = i49;
            iC = iC3;
            paddingLeft = paddingLeft;
        }
        while (i21 < getChildCount()) {
            childAt = getChildAt(i21);
            if (childAt.getVisibility() == 8) {
                childAt.layout(0, 0, 0, 0);
            }
            i21++;
        }
    }

    @Override // android.view.View
    public void onMeasure(int i11, int i12) {
        int i13;
        int iMin;
        int i14;
        View view;
        int i15;
        int i16;
        int measuredWidth;
        int i17;
        int i18;
        super.onMeasure(i11, i12);
        int size = View.MeasureSpec.getSize(i11);
        int mode = View.MeasureSpec.getMode(i11);
        int size2 = View.MeasureSpec.getSize(i12);
        int mode2 = View.MeasureSpec.getMode(i12);
        this.f49528m.clear();
        this.f49529n.clear();
        this.f49530o.clear();
        this.f49531p.clear();
        int childCount = getChildCount();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        boolean z11 = mode != 0 && this.f49517a;
        int i19 = this.f49518b;
        int i21 = (i19 == -65536 && mode == 0) ? 0 : i19;
        float f11 = i21 == -65536 ? this.f49519c : i21;
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        int iMax = 0;
        int i25 = 0;
        int i26 = 0;
        int iMax2 = 0;
        while (i24 < childCount) {
            float f12 = f11;
            View childAt = getChildAt(i24);
            int i27 = i22;
            if (childAt.getVisibility() == 8) {
                i24 = i24;
                i17 = i21;
                mode = mode;
                mode2 = mode2;
                childCount = childCount;
                f12 = f12;
                measuredWidth = i23;
                size = size;
                i18 = i27;
                size2 = size2;
            } else {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    view = childAt;
                    measureChildWithMargins(childAt, i11, 0, i12, i26);
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i15 = marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                    i16 = marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
                } else {
                    view = childAt;
                    measureChild(view, i11, i12);
                    i15 = 0;
                    i16 = 0;
                }
                measuredWidth = i15 + view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight() + i16;
                if (!z11 || i25 + measuredWidth <= paddingLeft) {
                    i17 = i21;
                    i18 = i27 + 1;
                    i25 = (int) (i25 + measuredWidth + f12);
                    measuredWidth += i23;
                    iMax2 = Math.max(iMax2, measuredHeight);
                } else {
                    i17 = i21;
                    this.f49528m.add(Float.valueOf(d(i17, paddingLeft, i23, i27)));
                    this.f49531p.add(Integer.valueOf(i27));
                    this.f49529n.add(Integer.valueOf(iMax2));
                    int i28 = (int) f12;
                    this.f49530o.add(Integer.valueOf(i25 - i28));
                    if (this.f49528m.size() <= this.f49524i) {
                        i26 += iMax2;
                    }
                    iMax = Math.max(iMax, i25);
                    i25 = measuredWidth + i28;
                    iMax2 = measuredHeight;
                    i18 = 1;
                }
            }
            i23 = measuredWidth;
            i24++;
            i21 = i17;
            i22 = i18;
            f11 = f12;
            size = size;
            size2 = size2;
            mode = mode;
            childCount = childCount;
            mode2 = mode2;
        }
        int i29 = i22;
        int i31 = i21;
        int i32 = size;
        int i33 = mode;
        int i34 = size2;
        int i35 = mode2;
        int i36 = i23;
        float f13 = f11;
        int i37 = iMax2;
        int i38 = this.f49520d;
        if (i38 == -65537) {
            if (this.f49528m.size() >= 1) {
                List<Float> list = this.f49528m;
                list.add(list.get(list.size() - 1));
            } else {
                this.f49528m.add(Float.valueOf(d(i31, paddingLeft, i36, i29)));
            }
        } else if (i38 != -65538) {
            this.f49528m.add(Float.valueOf(d(i38, paddingLeft, i36, i29)));
        } else {
            this.f49528m.add(Float.valueOf(d(i31, paddingLeft, i36, i29)));
        }
        this.f49531p.add(Integer.valueOf(i29));
        this.f49529n.add(Integer.valueOf(i37));
        this.f49530o.add(Integer.valueOf(i25 - ((int) f13)));
        if (this.f49528m.size() <= this.f49524i) {
            i26 += i37;
        }
        int iMax3 = Math.max(iMax, i25);
        if (i31 == -65536) {
            iMin = i32;
            i13 = iMin;
        } else if (i33 == 0) {
            iMin = iMax3 + getPaddingLeft() + getPaddingRight();
            i13 = i32;
        } else {
            i13 = i32;
            iMin = Math.min(iMax3 + getPaddingLeft() + getPaddingRight(), i13);
        }
        int paddingTop = i26 + getPaddingTop() + getPaddingBottom();
        int iMin2 = Math.min(this.f49528m.size(), this.f49524i);
        float f14 = this.f49521f;
        if (f14 == -65536.0f && i35 == 0) {
            f14 = 0.0f;
        }
        if (f14 == -65536.0f) {
            if (iMin2 > 1) {
                this.f49522g = (i34 - paddingTop) / (iMin2 - 1);
            } else {
                this.f49522g = 0.0f;
            }
            paddingTop = i34;
            i14 = paddingTop;
        } else {
            this.f49522g = f14;
            if (iMin2 <= 1) {
                i14 = i34;
            } else if (i35 == 0) {
                paddingTop = (int) (paddingTop + (f14 * (iMin2 - 1)));
                i14 = i34;
            } else {
                int i39 = (int) (paddingTop + (f14 * (iMin2 - 1)));
                i14 = i34;
                paddingTop = Math.min(i39, i14);
            }
        }
        this.f49527l = paddingTop;
        setMeasuredDimension(i33 == 1073741824 ? i13 : iMin, i35 == 1073741824 ? i14 : paddingTop);
    }

    public void setChildSpacing(int i11) {
        this.f49518b = i11;
        requestLayout();
    }

    public void setChildSpacingForLastRow(int i11) {
        this.f49520d = i11;
        requestLayout();
    }

    public void setFlow(boolean z11) {
        this.f49517a = z11;
        requestLayout();
    }

    public void setGravity(int i11) {
        if (this.f49525j != i11) {
            this.f49525j = i11;
            requestLayout();
        }
    }

    public void setMaxRows(int i11) {
        this.f49524i = i11;
        requestLayout();
    }

    public void setMinChildSpacing(int i11) {
        this.f49519c = i11;
        requestLayout();
    }

    public void setRowSpacing(float f11) {
        this.f49521f = f11;
        requestLayout();
    }

    public void setRowVerticalGravity(int i11) {
        if (this.f49526k != i11) {
            this.f49526k = i11;
            requestLayout();
        }
    }

    public void setRtl(boolean z11) {
        this.f49523h = z11;
        requestLayout();
    }
}
