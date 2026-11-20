package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$styleable;
import androidx.core.view.GravityCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.card.MaterialCardView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class LinearLayoutCompat extends ViewGroup {
    public static final int HORIZONTAL = 0;
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_END = 4;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_NONE = 0;
    public static final int VERTICAL = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f1434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1436c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1437d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1438f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f1439g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f1440h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f1441i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int[] f1442j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int[] f1443k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Drawable f1444l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f1445m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f1446n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f1447o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f1448p;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static class a extends LinearLayout.LayoutParams {
        public a(int i11, int i12) {
            super(i11, i12);
        }

        public a(int i11, int i12, float f11) {
            super(i11, i12, f11);
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    public LinearLayoutCompat(@NonNull Context context) {
        this(context, null);
    }

    public LinearLayoutCompat(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LinearLayoutCompat(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f1434a = true;
        this.f1435b = -1;
        this.f1436c = 0;
        this.f1438f = MaterialCardView.CHECKED_ICON_GRAVITY_TOP_START;
        n0 n0VarV = n0.v(context, attributeSet, R$styleable.LinearLayoutCompat, i11, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, R$styleable.LinearLayoutCompat, attributeSet, n0VarV.r(), i11, 0);
        int iK = n0VarV.k(R$styleable.LinearLayoutCompat_android_orientation, -1);
        if (iK >= 0) {
            setOrientation(iK);
        }
        int iK2 = n0VarV.k(R$styleable.LinearLayoutCompat_android_gravity, -1);
        if (iK2 >= 0) {
            setGravity(iK2);
        }
        boolean zA = n0VarV.a(R$styleable.LinearLayoutCompat_android_baselineAligned, true);
        if (!zA) {
            setBaselineAligned(zA);
        }
        this.f1440h = n0VarV.i(R$styleable.LinearLayoutCompat_android_weightSum, -1.0f);
        this.f1435b = n0VarV.k(R$styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.f1441i = n0VarV.a(R$styleable.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(n0VarV.g(R$styleable.LinearLayoutCompat_divider));
        this.f1447o = n0VarV.k(R$styleable.LinearLayoutCompat_showDividers, 0);
        this.f1448p = n0VarV.f(R$styleable.LinearLayoutCompat_dividerPadding, 0);
        n0VarV.x();
    }

    private void f(int i11, int i12) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i13 = 0; i13 < i11; i13++) {
            View viewL = l(i13);
            if (viewL.getVisibility() != 8) {
                a aVar = (a) viewL.getLayoutParams();
                if (((LinearLayout.LayoutParams) aVar).width == -1) {
                    int i14 = ((LinearLayout.LayoutParams) aVar).height;
                    ((LinearLayout.LayoutParams) aVar).height = viewL.getMeasuredHeight();
                    measureChildWithMargins(viewL, iMakeMeasureSpec, 0, i12, 0);
                    ((LinearLayout.LayoutParams) aVar).height = i14;
                }
            }
        }
    }

    private void t(View view, int i11, int i12, int i13, int i14) {
        view.layout(i11, i12, i13 + i11, i14 + i12);
    }

    public void a(Canvas canvas) {
        int right;
        int left;
        int i11;
        int virtualChildCount = getVirtualChildCount();
        boolean zB = y0.b(this);
        for (int i12 = 0; i12 < virtualChildCount; i12++) {
            View viewL = l(i12);
            if (viewL != null && viewL.getVisibility() != 8 && m(i12)) {
                a aVar = (a) viewL.getLayoutParams();
                d(canvas, zB ? viewL.getRight() + ((LinearLayout.LayoutParams) aVar).rightMargin : (viewL.getLeft() - ((LinearLayout.LayoutParams) aVar).leftMargin) - this.f1445m);
            }
        }
        if (m(virtualChildCount)) {
            View viewL2 = l(virtualChildCount - 1);
            if (viewL2 != null) {
                a aVar2 = (a) viewL2.getLayoutParams();
                if (zB) {
                    left = viewL2.getLeft() - ((LinearLayout.LayoutParams) aVar2).leftMargin;
                    i11 = this.f1445m;
                    right = left - i11;
                } else {
                    right = viewL2.getRight() + ((LinearLayout.LayoutParams) aVar2).rightMargin;
                }
            } else if (zB) {
                right = getPaddingLeft();
            } else {
                left = getWidth() - getPaddingRight();
                i11 = this.f1445m;
                right = left - i11;
            }
            d(canvas, right);
        }
    }

    public void b(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        for (int i11 = 0; i11 < virtualChildCount; i11++) {
            View viewL = l(i11);
            if (viewL != null && viewL.getVisibility() != 8 && m(i11)) {
                c(canvas, (viewL.getTop() - ((LinearLayout.LayoutParams) ((a) viewL.getLayoutParams())).topMargin) - this.f1446n);
            }
        }
        if (m(virtualChildCount)) {
            View viewL2 = l(virtualChildCount - 1);
            c(canvas, viewL2 == null ? (getHeight() - getPaddingBottom()) - this.f1446n : viewL2.getBottom() + ((LinearLayout.LayoutParams) ((a) viewL2.getLayoutParams())).bottomMargin);
        }
    }

    public void c(Canvas canvas, int i11) {
        this.f1444l.setBounds(getPaddingLeft() + this.f1448p, i11, (getWidth() - getPaddingRight()) - this.f1448p, this.f1446n + i11);
        this.f1444l.draw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    public void d(Canvas canvas, int i11) {
        this.f1444l.setBounds(i11, getPaddingTop() + this.f1448p, this.f1445m + i11, (getHeight() - getPaddingBottom()) - this.f1448p);
        this.f1444l.draw(canvas);
    }

    public final void e(int i11, int i12) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i13 = 0; i13 < i11; i13++) {
            View viewL = l(i13);
            if (viewL.getVisibility() != 8) {
                a aVar = (a) viewL.getLayoutParams();
                if (((LinearLayout.LayoutParams) aVar).height == -1) {
                    int i14 = ((LinearLayout.LayoutParams) aVar).width;
                    ((LinearLayout.LayoutParams) aVar).width = viewL.getMeasuredWidth();
                    measureChildWithMargins(viewL, i12, 0, iMakeMeasureSpec, 0);
                    ((LinearLayout.LayoutParams) aVar).width = i14;
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public a generateDefaultLayoutParams() {
        int i11 = this.f1437d;
        if (i11 == 0) {
            return new a(-2, -2);
        }
        if (i11 == 1) {
            return new a(-1, -2);
        }
        return null;
    }

    @Override // android.view.ViewGroup
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    @Override // android.view.View
    public int getBaseline() {
        int i11;
        if (this.f1435b < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i12 = this.f1435b;
        if (childCount <= i12) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(i12);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (this.f1435b == 0) {
                return -1;
            }
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
        int bottom = this.f1436c;
        if (this.f1437d == 1 && (i11 = this.f1438f & 112) != 48) {
            if (i11 == 16) {
                bottom += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f1439g) / 2;
            } else if (i11 == 80) {
                bottom = ((getBottom() - getTop()) - getPaddingBottom()) - this.f1439g;
            }
        }
        return bottom + ((LinearLayout.LayoutParams) ((a) childAt.getLayoutParams())).topMargin + baseline;
    }

    public int getBaselineAlignedChildIndex() {
        return this.f1435b;
    }

    public Drawable getDividerDrawable() {
        return this.f1444l;
    }

    public int getDividerPadding() {
        return this.f1448p;
    }

    public int getDividerWidth() {
        return this.f1445m;
    }

    public int getGravity() {
        return this.f1438f;
    }

    public int getOrientation() {
        return this.f1437d;
    }

    public int getShowDividers() {
        return this.f1447o;
    }

    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f1440h;
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public a generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof a) {
            return new a((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new a((ViewGroup.MarginLayoutParams) layoutParams) : new a(layoutParams);
    }

    public int i(View view, int i11) {
        return 0;
    }

    public boolean isBaselineAligned() {
        return this.f1434a;
    }

    public boolean isMeasureWithLargestChildEnabled() {
        return this.f1441i;
    }

    public int j(View view) {
        return 0;
    }

    public int k(View view) {
        return 0;
    }

    public View l(int i11) {
        return getChildAt(i11);
    }

    public boolean m(int i11) {
        if (i11 == 0) {
            return (this.f1447o & 1) != 0;
        }
        if (i11 == getChildCount()) {
            return (this.f1447o & 4) != 0;
        }
        if ((this.f1447o & 2) == 0) {
            return false;
        }
        for (int i12 = i11 - 1; i12 >= 0; i12--) {
            if (getChildAt(i12).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:33:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:35:0x00be  */
    /* JADX WARN: Code duplicated, block: B:37:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:39:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:41:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:42:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:44:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:45:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:48:0x0100  */
    public void n(int i11, int i12, int i13, int i14) {
        int paddingLeft;
        int i15;
        int i16;
        int i17;
        int baseline;
        int i18;
        int i19;
        int measuredHeight;
        boolean zB = y0.b(this);
        int paddingTop = getPaddingTop();
        int i21 = i14 - i12;
        int paddingBottom = i21 - getPaddingBottom();
        int paddingBottom2 = (i21 - paddingTop) - getPaddingBottom();
        int virtualChildCount = getVirtualChildCount();
        int i22 = this.f1438f;
        int i23 = i22 & 112;
        boolean z11 = this.f1434a;
        int[] iArr = this.f1442j;
        int[] iArr2 = this.f1443k;
        int absoluteGravity = GravityCompat.getAbsoluteGravity(8388615 & i22, getLayoutDirection());
        if (absoluteGravity != 1) {
            paddingLeft = absoluteGravity != 5 ? getPaddingLeft() : ((getPaddingLeft() + i13) - i11) - this.f1439g;
        } else {
            paddingLeft = getPaddingLeft() + (((i13 - i11) - this.f1439g) / 2);
        }
        if (zB) {
            i15 = virtualChildCount - 1;
            i16 = -1;
        } else {
            i15 = 0;
            i16 = 1;
        }
        int i24 = 0;
        while (i24 < virtualChildCount) {
            int i25 = i15 + (i16 * i24);
            View viewL = l(i25);
            if (viewL == null) {
                paddingLeft += r(i25);
            } else {
                if (viewL.getVisibility() != 8) {
                    int measuredWidth = viewL.getMeasuredWidth();
                    int measuredHeight2 = viewL.getMeasuredHeight();
                    a aVar = (a) viewL.getLayoutParams();
                    int i26 = i24;
                    if (z11) {
                        i17 = virtualChildCount;
                        baseline = ((LinearLayout.LayoutParams) aVar).height != -1 ? viewL.getBaseline() : -1;
                        i18 = ((LinearLayout.LayoutParams) aVar).gravity;
                        if (i18 < 0) {
                            i18 = i23;
                        }
                        i19 = i18 & 112;
                        if (i19 != 16) {
                            measuredHeight = ((((paddingBottom2 - measuredHeight2) / 2) + paddingTop) + ((LinearLayout.LayoutParams) aVar).topMargin) - ((LinearLayout.LayoutParams) aVar).bottomMargin;
                        } else if (i19 != 48) {
                            measuredHeight = ((LinearLayout.LayoutParams) aVar).topMargin + paddingTop;
                            if (baseline != -1) {
                                measuredHeight += iArr[1] - baseline;
                            }
                        } else if (i19 != 80) {
                            measuredHeight = paddingTop;
                        } else {
                            measuredHeight = (paddingBottom - measuredHeight2) - ((LinearLayout.LayoutParams) aVar).bottomMargin;
                            if (baseline != -1) {
                                measuredHeight -= iArr2[2] - (viewL.getMeasuredHeight() - baseline);
                            }
                        }
                        if (m(i25)) {
                            paddingLeft += this.f1445m;
                        }
                        int i27 = ((LinearLayout.LayoutParams) aVar).leftMargin + paddingLeft;
                        t(viewL, i27 + j(viewL), measuredHeight, measuredWidth, measuredHeight2);
                        int iK = i27 + measuredWidth + ((LinearLayout.LayoutParams) aVar).rightMargin + k(viewL);
                        i24 = i26 + i(viewL, i25);
                        paddingLeft = iK;
                    } else {
                        i17 = virtualChildCount;
                    }
                    i18 = ((LinearLayout.LayoutParams) aVar).gravity;
                    if (i18 < 0) {
                        i18 = i23;
                    }
                    i19 = i18 & 112;
                    if (i19 != 16) {
                        measuredHeight = ((((paddingBottom2 - measuredHeight2) / 2) + paddingTop) + ((LinearLayout.LayoutParams) aVar).topMargin) - ((LinearLayout.LayoutParams) aVar).bottomMargin;
                    } else if (i19 != 48) {
                        measuredHeight = ((LinearLayout.LayoutParams) aVar).topMargin + paddingTop;
                        if (baseline != -1) {
                            measuredHeight += iArr[1] - baseline;
                        }
                    } else if (i19 != 80) {
                        measuredHeight = paddingTop;
                    } else {
                        measuredHeight = (paddingBottom - measuredHeight2) - ((LinearLayout.LayoutParams) aVar).bottomMargin;
                        if (baseline != -1) {
                            measuredHeight -= iArr2[2] - (viewL.getMeasuredHeight() - baseline);
                        }
                    }
                    if (m(i25)) {
                        paddingLeft += this.f1445m;
                    }
                    int i28 = ((LinearLayout.LayoutParams) aVar).leftMargin + paddingLeft;
                    t(viewL, i28 + j(viewL), measuredHeight, measuredWidth, measuredHeight2);
                    int iK2 = i28 + measuredWidth + ((LinearLayout.LayoutParams) aVar).rightMargin + k(viewL);
                    i24 = i26 + i(viewL, i25);
                    paddingLeft = iK2;
                }
                i24++;
                virtualChildCount = i17;
                i23 = i23;
                paddingTop = paddingTop;
            }
            i17 = virtualChildCount;
            i24++;
            virtualChildCount = i17;
            i23 = i23;
            paddingTop = paddingTop;
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00a1  */
    public void o(int i11, int i12, int i13, int i14) {
        int paddingTop;
        int i15;
        int i16;
        int i17;
        int paddingLeft = getPaddingLeft();
        int i18 = i13 - i11;
        int paddingRight = i18 - getPaddingRight();
        int paddingRight2 = (i18 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        int i19 = this.f1438f;
        int i21 = i19 & 112;
        int i22 = i19 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i21 != 16) {
            paddingTop = i21 != 80 ? getPaddingTop() : ((getPaddingTop() + i14) - i12) - this.f1439g;
        } else {
            paddingTop = getPaddingTop() + (((i14 - i12) - this.f1439g) / 2);
        }
        int i23 = 0;
        while (i23 < virtualChildCount) {
            View viewL = l(i23);
            if (viewL == null) {
                paddingTop += r(i23);
            } else if (viewL.getVisibility() != 8) {
                int measuredWidth = viewL.getMeasuredWidth();
                int measuredHeight = viewL.getMeasuredHeight();
                a aVar = (a) viewL.getLayoutParams();
                int i24 = ((LinearLayout.LayoutParams) aVar).gravity;
                if (i24 < 0) {
                    i24 = i22;
                }
                int absoluteGravity = GravityCompat.getAbsoluteGravity(i24, getLayoutDirection()) & 7;
                if (absoluteGravity != 1) {
                    if (absoluteGravity != 5) {
                        i17 = ((LinearLayout.LayoutParams) aVar).leftMargin + paddingLeft;
                    } else {
                        i15 = paddingRight - measuredWidth;
                        i16 = ((LinearLayout.LayoutParams) aVar).rightMargin;
                    }
                    int i25 = i17;
                    if (m(i23)) {
                        paddingTop += this.f1446n;
                    }
                    int i26 = paddingTop + ((LinearLayout.LayoutParams) aVar).topMargin;
                    t(viewL, i25, i26 + j(viewL), measuredWidth, measuredHeight);
                    int iK = i26 + measuredHeight + ((LinearLayout.LayoutParams) aVar).bottomMargin + k(viewL);
                    i23 += i(viewL, i23);
                    paddingTop = iK;
                } else {
                    i15 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft + ((LinearLayout.LayoutParams) aVar).leftMargin;
                    i16 = ((LinearLayout.LayoutParams) aVar).rightMargin;
                }
                i17 = i15 - i16;
                int i27 = i17;
                if (m(i23)) {
                    paddingTop += this.f1446n;
                }
                int i28 = paddingTop + ((LinearLayout.LayoutParams) aVar).topMargin;
                t(viewL, i27, i28 + j(viewL), measuredWidth, measuredHeight);
                int iK2 = i28 + measuredHeight + ((LinearLayout.LayoutParams) aVar).bottomMargin + k(viewL);
                i23 += i(viewL, i23);
                paddingTop = iK2;
            }
            i23++;
        }
    }

    @Override // android.view.View
    public void onDraw(@NonNull Canvas canvas) {
        if (this.f1444l == null) {
            return;
        }
        if (this.f1437d == 1) {
            b(canvas);
        } else {
            a(canvas);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        if (this.f1437d == 1) {
            o(i11, i12, i13, i14);
        } else {
            n(i11, i12, i13, i14);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i11, int i12) {
        if (this.f1437d == 1) {
            s(i11, i12);
        } else {
            q(i11, i12);
        }
    }

    public void p(View view, int i11, int i12, int i13, int i14, int i15) {
        measureChildWithMargins(view, i12, i13, i14, i15);
    }

    /* JADX WARN: Code duplicated, block: B:200:0x0455  */
    /* JADX WARN: Code duplicated, block: B:60:0x0171  */
    /* JADX WARN: Code duplicated, block: B:67:0x0193  */
    /* JADX WARN: Code duplicated, block: B:74:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:77:0x01c7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:79:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:82:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:85:0x01dc  */
    public void q(int i11, int i12) {
        int[] iArr;
        int iCombineMeasuredStates;
        int i13;
        int iMax;
        int i14;
        int i15;
        int baseline;
        int i16;
        int i17;
        int i18;
        int i19;
        boolean z11;
        boolean z12;
        View view;
        int i21;
        boolean z13;
        int i22;
        int measuredHeight;
        int i23;
        int baseline2;
        int i24;
        this.f1439g = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i11);
        int mode2 = View.MeasureSpec.getMode(i12);
        if (this.f1442j == null || this.f1443k == null) {
            this.f1442j = new int[4];
            this.f1443k = new int[4];
        }
        int[] iArr2 = this.f1442j;
        int[] iArr3 = this.f1443k;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        iArr3[3] = -1;
        iArr3[2] = -1;
        iArr3[1] = -1;
        iArr3[0] = -1;
        boolean z14 = this.f1434a;
        boolean z15 = this.f1441i;
        int i25 = 1073741824;
        boolean z16 = mode == 1073741824;
        float f11 = 0.0f;
        int i26 = 0;
        int iMax2 = 0;
        int iMax3 = 0;
        int iMax4 = 0;
        int iMax5 = 0;
        boolean z17 = false;
        int iCombineMeasuredStates2 = 0;
        boolean z18 = true;
        boolean z19 = false;
        while (true) {
            iArr = iArr3;
            if (i26 >= virtualChildCount) {
                break;
            }
            View viewL = l(i26);
            if (viewL == null) {
                this.f1439g += r(i26);
            } else {
                if (viewL.getVisibility() == 8) {
                    i26 += i(viewL, i26);
                } else {
                    if (m(i26)) {
                        this.f1439g += this.f1445m;
                    }
                    a aVar = (a) viewL.getLayoutParams();
                    float f12 = ((LinearLayout.LayoutParams) aVar).weight;
                    float f13 = f11 + f12;
                    if (mode == i25 && ((LinearLayout.LayoutParams) aVar).width == 0 && f12 > 0.0f) {
                        if (z16) {
                            this.f1439g += ((LinearLayout.LayoutParams) aVar).leftMargin + ((LinearLayout.LayoutParams) aVar).rightMargin;
                        } else {
                            int i27 = this.f1439g;
                            this.f1439g = Math.max(i27, ((LinearLayout.LayoutParams) aVar).leftMargin + i27 + ((LinearLayout.LayoutParams) aVar).rightMargin);
                        }
                        if (z14) {
                            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                            viewL.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                            i19 = i26;
                            z11 = z15;
                            z12 = z14;
                            view = viewL;
                        } else {
                            i19 = i26;
                            z11 = z15;
                            z12 = z14;
                            view = viewL;
                            i21 = 1073741824;
                            z17 = true;
                        }
                        if (mode2 == i21 && ((LinearLayout.LayoutParams) aVar).height == -1) {
                            z13 = true;
                            z19 = true;
                        } else {
                            z13 = false;
                        }
                        i22 = ((LinearLayout.LayoutParams) aVar).topMargin + ((LinearLayout.LayoutParams) aVar).bottomMargin;
                        measuredHeight = view.getMeasuredHeight() + i22;
                        iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, view.getMeasuredState());
                        if (z12 && (baseline2 = view.getBaseline()) != -1) {
                            i24 = ((LinearLayout.LayoutParams) aVar).gravity;
                            if (i24 < 0) {
                                i24 = this.f1438f;
                            }
                            int i28 = (((i24 & 112) >> 4) & (-2)) >> 1;
                            iArr2[i28] = Math.max(iArr2[i28], baseline2);
                            iArr[i28] = Math.max(iArr[i28], measuredHeight - baseline2);
                        }
                        iMax3 = Math.max(iMax3, measuredHeight);
                        if (z18 || ((LinearLayout.LayoutParams) aVar).height != -1) {
                            z18 = false;
                        } else {
                            z18 = true;
                        }
                        if (((LinearLayout.LayoutParams) aVar).weight > 0.0f) {
                            if (!z13) {
                                i22 = measuredHeight;
                            }
                            iMax5 = Math.max(iMax5, i22);
                        } else {
                            int i29 = iMax5;
                            if (!z13) {
                                i22 = measuredHeight;
                            }
                            iMax4 = Math.max(iMax4, i22);
                            iMax5 = i29;
                        }
                        int i31 = i19;
                        i23 = i(view, i31) + i31;
                        f11 = f13;
                    } else {
                        if (((LinearLayout.LayoutParams) aVar).width != 0 || f12 <= 0.0f) {
                            i18 = Integer.MIN_VALUE;
                        } else {
                            ((LinearLayout.LayoutParams) aVar).width = -2;
                            i18 = 0;
                        }
                        i19 = i26;
                        int i32 = i18;
                        z11 = z15;
                        z12 = z14;
                        p(viewL, i19, i11, f13 == 0.0f ? this.f1439g : 0, i12, 0);
                        if (i32 != Integer.MIN_VALUE) {
                            ((LinearLayout.LayoutParams) aVar).width = i32;
                        }
                        int measuredWidth = viewL.getMeasuredWidth();
                        if (z16) {
                            view = viewL;
                            this.f1439g += ((LinearLayout.LayoutParams) aVar).leftMargin + measuredWidth + ((LinearLayout.LayoutParams) aVar).rightMargin + k(view);
                        } else {
                            view = viewL;
                            int i33 = this.f1439g;
                            this.f1439g = Math.max(i33, i33 + measuredWidth + ((LinearLayout.LayoutParams) aVar).leftMargin + ((LinearLayout.LayoutParams) aVar).rightMargin + k(view));
                        }
                        if (z11) {
                            iMax2 = Math.max(measuredWidth, iMax2);
                        }
                    }
                    i21 = 1073741824;
                    if (mode2 == i21) {
                        z13 = false;
                    } else {
                        z13 = false;
                    }
                    i22 = ((LinearLayout.LayoutParams) aVar).topMargin + ((LinearLayout.LayoutParams) aVar).bottomMargin;
                    measuredHeight = view.getMeasuredHeight() + i22;
                    iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, view.getMeasuredState());
                    if (z12) {
                        i24 = ((LinearLayout.LayoutParams) aVar).gravity;
                        if (i24 < 0) {
                            i24 = this.f1438f;
                        }
                        int i210 = (((i24 & 112) >> 4) & (-2)) >> 1;
                        iArr2[i210] = Math.max(iArr2[i210], baseline2);
                        iArr[i210] = Math.max(iArr[i210], measuredHeight - baseline2);
                    }
                    iMax3 = Math.max(iMax3, measuredHeight);
                    if (z18) {
                        z18 = false;
                    } else {
                        z18 = false;
                    }
                    if (((LinearLayout.LayoutParams) aVar).weight > 0.0f) {
                        if (!z13) {
                            i22 = measuredHeight;
                        }
                        iMax5 = Math.max(iMax5, i22);
                    } else {
                        int i211 = iMax5;
                        if (!z13) {
                            i22 = measuredHeight;
                        }
                        iMax4 = Math.max(iMax4, i22);
                        iMax5 = i211;
                    }
                    int i34 = i19;
                    i23 = i(view, i34) + i34;
                    f11 = f13;
                }
                i26 = i23 + 1;
                iArr3 = iArr;
                z15 = z11;
                z14 = z12;
                i25 = 1073741824;
            }
            i23 = i26;
            z11 = z15;
            z12 = z14;
            i26 = i23 + 1;
            iArr3 = iArr;
            z15 = z11;
            z14 = z12;
            i25 = 1073741824;
        }
        boolean z21 = z15;
        boolean z22 = z14;
        int i35 = iMax3;
        int i36 = iMax4;
        int i37 = iMax5;
        int i38 = iCombineMeasuredStates2;
        if (this.f1439g > 0 && m(virtualChildCount)) {
            this.f1439g += this.f1445m;
        }
        int i39 = iArr2[1];
        int iMax6 = (i39 == -1 && iArr2[0] == -1 && iArr2[2] == -1 && iArr2[3] == -1) ? i35 : Math.max(i35, Math.max(iArr2[3], Math.max(iArr2[0], Math.max(i39, iArr2[2]))) + Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
        if (z21 && (mode == Integer.MIN_VALUE || mode == 0)) {
            this.f1439g = 0;
            int i40 = 0;
            while (i40 < virtualChildCount) {
                View viewL2 = l(i40);
                if (viewL2 == null) {
                    this.f1439g += r(i40);
                } else if (viewL2.getVisibility() == 8) {
                    i40 += i(viewL2, i40);
                } else {
                    a aVar2 = (a) viewL2.getLayoutParams();
                    if (z16) {
                        this.f1439g += ((LinearLayout.LayoutParams) aVar2).leftMargin + iMax2 + ((LinearLayout.LayoutParams) aVar2).rightMargin + k(viewL2);
                    } else {
                        int i41 = this.f1439g;
                        this.f1439g = Math.max(i41, i41 + iMax2 + ((LinearLayout.LayoutParams) aVar2).leftMargin + ((LinearLayout.LayoutParams) aVar2).rightMargin + k(viewL2));
                    }
                    i40++;
                    iMax6 = iMax6;
                }
                i40++;
                iMax6 = iMax6;
            }
        }
        int iMax7 = iMax6;
        int paddingLeft = this.f1439g + getPaddingLeft() + getPaddingRight();
        this.f1439g = paddingLeft;
        int iResolveSizeAndState = View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i11, 0);
        int i42 = (16777215 & iResolveSizeAndState) - this.f1439g;
        if (z17 || (i42 != 0 && f11 > 0.0f)) {
            float f14 = this.f1440h;
            if (f14 > 0.0f) {
                f11 = f14;
            }
            iArr2[3] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
            iArr[3] = -1;
            iArr[2] = -1;
            iArr[1] = -1;
            iArr[0] = -1;
            this.f1439g = 0;
            int i43 = i36;
            iCombineMeasuredStates = i38;
            int iMax8 = -1;
            int i44 = 0;
            while (i44 < virtualChildCount) {
                View viewL3 = l(i44);
                if (viewL3 == null || viewL3.getVisibility() == 8) {
                    i14 = i42;
                    virtualChildCount = virtualChildCount;
                } else {
                    a aVar3 = (a) viewL3.getLayoutParams();
                    float f15 = ((LinearLayout.LayoutParams) aVar3).weight;
                    if (f15 > 0.0f) {
                        int i45 = (int) ((i42 * f15) / f11);
                        float f16 = f11 - f15;
                        int i46 = i42 - i45;
                        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i12, getPaddingTop() + getPaddingBottom() + ((LinearLayout.LayoutParams) aVar3).topMargin + ((LinearLayout.LayoutParams) aVar3).bottomMargin, ((LinearLayout.LayoutParams) aVar3).height);
                        if (((LinearLayout.LayoutParams) aVar3).width == 0) {
                            i17 = 1073741824;
                            if (mode == 1073741824) {
                                if (i45 <= 0) {
                                    i45 = 0;
                                }
                                viewL3.measure(View.MeasureSpec.makeMeasureSpec(i45, 1073741824), childMeasureSpec);
                            }
                            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, viewL3.getMeasuredState() & ViewCompat.MEASURED_STATE_MASK);
                            f11 = f16;
                            i14 = i46;
                        } else {
                            i17 = 1073741824;
                        }
                        int measuredWidth2 = viewL3.getMeasuredWidth() + i45;
                        if (measuredWidth2 < 0) {
                            measuredWidth2 = 0;
                        }
                        viewL3.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth2, i17), childMeasureSpec);
                        iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, viewL3.getMeasuredState() & ViewCompat.MEASURED_STATE_MASK);
                        f11 = f16;
                        i14 = i46;
                    } else {
                        i14 = i42;
                    }
                    if (z16) {
                        this.f1439g += viewL3.getMeasuredWidth() + ((LinearLayout.LayoutParams) aVar3).leftMargin + ((LinearLayout.LayoutParams) aVar3).rightMargin + k(viewL3);
                    } else {
                        int i47 = this.f1439g;
                        this.f1439g = Math.max(i47, viewL3.getMeasuredWidth() + i47 + ((LinearLayout.LayoutParams) aVar3).leftMargin + ((LinearLayout.LayoutParams) aVar3).rightMargin + k(viewL3));
                    }
                    boolean z23 = mode2 != 1073741824 && ((LinearLayout.LayoutParams) aVar3).height == -1;
                    int i48 = ((LinearLayout.LayoutParams) aVar3).topMargin + ((LinearLayout.LayoutParams) aVar3).bottomMargin;
                    int measuredHeight2 = viewL3.getMeasuredHeight() + i48;
                    iMax8 = Math.max(iMax8, measuredHeight2);
                    if (!z23) {
                        i48 = measuredHeight2;
                    }
                    int iMax9 = Math.max(i43, i48);
                    if (z18) {
                        i15 = -1;
                        boolean z24 = ((LinearLayout.LayoutParams) aVar3).height == -1;
                        if (z22 && (baseline = viewL3.getBaseline()) != i15) {
                            i16 = ((LinearLayout.LayoutParams) aVar3).gravity;
                            if (i16 < 0) {
                                i16 = this.f1438f;
                            }
                            int i49 = (((i16 & 112) >> 4) & (-2)) >> 1;
                            iArr2[i49] = Math.max(iArr2[i49], baseline);
                            iArr[i49] = Math.max(iArr[i49], measuredHeight2 - baseline);
                        }
                        z18 = z24;
                        i43 = iMax9;
                        f11 = f11;
                    } else {
                        i15 = -1;
                    }
                    if (z22) {
                        i16 = ((LinearLayout.LayoutParams) aVar3).gravity;
                        if (i16 < 0) {
                            i16 = this.f1438f;
                        }
                        int i410 = (((i16 & 112) >> 4) & (-2)) >> 1;
                        iArr2[i410] = Math.max(iArr2[i410], baseline);
                        iArr[i410] = Math.max(iArr[i410], measuredHeight2 - baseline);
                    }
                    z18 = z24;
                    i43 = iMax9;
                    f11 = f11;
                }
                i44++;
                i42 = i14;
                virtualChildCount = virtualChildCount;
            }
            i13 = virtualChildCount;
            this.f1439g += getPaddingLeft() + getPaddingRight();
            int i50 = iArr2[1];
            iMax7 = (i50 == -1 && iArr2[0] == -1 && iArr2[2] == -1 && iArr2[3] == -1) ? iMax8 : Math.max(iMax8, Math.max(iArr2[3], Math.max(iArr2[0], Math.max(i50, iArr2[2]))) + Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
            iMax = i43;
        } else {
            iMax = Math.max(i36, i37);
            if (z21 && mode != 1073741824) {
                for (int i51 = 0; i51 < virtualChildCount; i51++) {
                    View viewL4 = l(i51);
                    if (viewL4 != null && viewL4.getVisibility() != 8 && ((LinearLayout.LayoutParams) ((a) viewL4.getLayoutParams())).weight > 0.0f) {
                        viewL4.measure(View.MeasureSpec.makeMeasureSpec(iMax2, 1073741824), View.MeasureSpec.makeMeasureSpec(viewL4.getMeasuredHeight(), 1073741824));
                    }
                }
            }
            i13 = virtualChildCount;
            iCombineMeasuredStates = i38;
        }
        if (z18 || mode2 == 1073741824) {
            iMax = iMax7;
        }
        setMeasuredDimension(iResolveSizeAndState | ((-16777216) & iCombineMeasuredStates), View.resolveSizeAndState(Math.max(iMax + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i12, iCombineMeasuredStates << 16));
        if (z19) {
            e(i13, i11);
        }
    }

    public int r(int i11) {
        return 0;
    }

    /* JADX WARN: Code duplicated, block: B:153:0x032e  */
    public void s(int i11, int i12) {
        int i13;
        int iCombineMeasuredStates;
        int iMax;
        int i14;
        int i15;
        int i16;
        boolean z11;
        int i17;
        int i18;
        int i19;
        int i21;
        int i22;
        int i23;
        int i24;
        int iMax2;
        int i25;
        View view;
        int iMax3;
        boolean z12;
        this.f1439g = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i11);
        int mode2 = View.MeasureSpec.getMode(i12);
        int i26 = this.f1435b;
        boolean z13 = this.f1441i;
        float f11 = 0.0f;
        int i27 = 0;
        int i28 = 0;
        int i29 = 0;
        int iMax4 = 0;
        int i31 = 0;
        int i32 = 0;
        boolean z14 = false;
        boolean z15 = true;
        boolean z16 = false;
        while (true) {
            int i33 = 8;
            int i34 = iMax4;
            if (i32 >= virtualChildCount) {
                int i35 = i27;
                int i36 = i29;
                int i37 = i31;
                int i38 = mode2;
                int iMax5 = i28;
                int i39 = virtualChildCount;
                if (this.f1439g > 0) {
                    i13 = i39;
                    if (m(i13)) {
                        this.f1439g += this.f1446n;
                    }
                } else {
                    i13 = i39;
                }
                if (z13 && (i38 == Integer.MIN_VALUE || i38 == 0)) {
                    this.f1439g = 0;
                    int i40 = 0;
                    while (i40 < i13) {
                        View viewL = l(i40);
                        if (viewL == null) {
                            this.f1439g += r(i40);
                        } else if (viewL.getVisibility() == i33) {
                            i40 += i(viewL, i40);
                        } else {
                            a aVar = (a) viewL.getLayoutParams();
                            int i41 = this.f1439g;
                            this.f1439g = Math.max(i41, i41 + i36 + ((LinearLayout.LayoutParams) aVar).topMargin + ((LinearLayout.LayoutParams) aVar).bottomMargin + k(viewL));
                        }
                        i40++;
                        i33 = 8;
                    }
                }
                int paddingTop = this.f1439g + getPaddingTop() + getPaddingBottom();
                this.f1439g = paddingTop;
                int iResolveSizeAndState = View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i12, 0);
                int i42 = (16777215 & iResolveSizeAndState) - this.f1439g;
                if (z14 || (i42 != 0 && f11 > 0.0f)) {
                    float f12 = this.f1440h;
                    if (f12 > 0.0f) {
                        f11 = f12;
                    }
                    this.f1439g = 0;
                    int i43 = i42;
                    int i44 = i37;
                    iCombineMeasuredStates = i35;
                    int i45 = 0;
                    while (i45 < i13) {
                        View viewL2 = l(i45);
                        if (viewL2.getVisibility() == 8) {
                            i14 = i43;
                        } else {
                            a aVar2 = (a) viewL2.getLayoutParams();
                            float f13 = ((LinearLayout.LayoutParams) aVar2).weight;
                            if (f13 > 0.0f) {
                                int i46 = (int) ((i43 * f13) / f11);
                                float f14 = f11 - f13;
                                i14 = i43 - i46;
                                int childMeasureSpec = ViewGroup.getChildMeasureSpec(i11, getPaddingLeft() + getPaddingRight() + ((LinearLayout.LayoutParams) aVar2).leftMargin + ((LinearLayout.LayoutParams) aVar2).rightMargin, ((LinearLayout.LayoutParams) aVar2).width);
                                if (((LinearLayout.LayoutParams) aVar2).height == 0) {
                                    i17 = 1073741824;
                                    if (i38 == 1073741824) {
                                        if (i46 <= 0) {
                                            i46 = 0;
                                        }
                                        viewL2.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(i46, 1073741824));
                                    }
                                    iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, viewL2.getMeasuredState() & InputDeviceCompat.SOURCE_ANY);
                                    f11 = f14;
                                } else {
                                    i17 = 1073741824;
                                }
                                int measuredHeight = viewL2.getMeasuredHeight() + i46;
                                if (measuredHeight < 0) {
                                    measuredHeight = 0;
                                }
                                viewL2.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(measuredHeight, i17));
                                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, viewL2.getMeasuredState() & InputDeviceCompat.SOURCE_ANY);
                                f11 = f14;
                            } else {
                                i14 = i43;
                            }
                            int i47 = ((LinearLayout.LayoutParams) aVar2).leftMargin + ((LinearLayout.LayoutParams) aVar2).rightMargin;
                            int measuredWidth = viewL2.getMeasuredWidth() + i47;
                            iMax5 = Math.max(iMax5, measuredWidth);
                            float f15 = f11;
                            if (mode != 1073741824) {
                                i15 = iCombineMeasuredStates;
                                i16 = -1;
                                if (((LinearLayout.LayoutParams) aVar2).width != -1) {
                                }
                                int iMax6 = Math.max(i44, i47);
                                if (z15 || ((LinearLayout.LayoutParams) aVar2).width != i16) {
                                    z11 = false;
                                } else {
                                    z11 = true;
                                }
                                int i48 = this.f1439g;
                                this.f1439g = Math.max(i48, viewL2.getMeasuredHeight() + i48 + ((LinearLayout.LayoutParams) aVar2).topMargin + ((LinearLayout.LayoutParams) aVar2).bottomMargin + k(viewL2));
                                z15 = z11;
                                iCombineMeasuredStates = i15;
                                i44 = iMax6;
                                f11 = f15;
                            } else {
                                i15 = iCombineMeasuredStates;
                                i16 = -1;
                            }
                            i47 = measuredWidth;
                            int iMax7 = Math.max(i44, i47);
                            if (z15) {
                                z11 = false;
                            } else {
                                z11 = false;
                            }
                            int i49 = this.f1439g;
                            this.f1439g = Math.max(i49, viewL2.getMeasuredHeight() + i49 + ((LinearLayout.LayoutParams) aVar2).topMargin + ((LinearLayout.LayoutParams) aVar2).bottomMargin + k(viewL2));
                            z15 = z11;
                            iCombineMeasuredStates = i15;
                            i44 = iMax7;
                            f11 = f15;
                        }
                        i45++;
                        i43 = i14;
                    }
                    this.f1439g += getPaddingTop() + getPaddingBottom();
                    iMax = i44;
                } else {
                    iMax = Math.max(i37, i34);
                    if (z13 && i38 != 1073741824) {
                        for (int i50 = 0; i50 < i13; i50++) {
                            View viewL3 = l(i50);
                            if (viewL3 != null && viewL3.getVisibility() != 8 && ((LinearLayout.LayoutParams) ((a) viewL3.getLayoutParams())).weight > 0.0f) {
                                viewL3.measure(View.MeasureSpec.makeMeasureSpec(viewL3.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(i36, 1073741824));
                            }
                        }
                    }
                    iCombineMeasuredStates = i35;
                }
                if (z15 || mode == 1073741824) {
                    iMax = iMax5;
                }
                setMeasuredDimension(View.resolveSizeAndState(Math.max(iMax + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i11, iCombineMeasuredStates), iResolveSizeAndState);
                if (z16) {
                    f(i13, i12);
                    return;
                }
                return;
            }
            View viewL4 = l(i32);
            if (viewL4 == null) {
                this.f1439g += r(i32);
                i22 = mode2;
                iMax4 = i34;
                i24 = virtualChildCount;
            } else {
                int i51 = i27;
                if (viewL4.getVisibility() == 8) {
                    i32 += i(viewL4, i32);
                    iMax4 = i34;
                    i27 = i51;
                    i24 = virtualChildCount;
                    i22 = mode2;
                } else {
                    if (m(i32)) {
                        this.f1439g += this.f1446n;
                    }
                    a aVar3 = (a) viewL4.getLayoutParams();
                    float f16 = ((LinearLayout.LayoutParams) aVar3).weight;
                    float f17 = f11 + f16;
                    if (mode2 == 1073741824 && ((LinearLayout.LayoutParams) aVar3).height == 0 && f16 > 0.0f) {
                        int i52 = this.f1439g;
                        this.f1439g = Math.max(i52, ((LinearLayout.LayoutParams) aVar3).topMargin + i52 + ((LinearLayout.LayoutParams) aVar3).bottomMargin);
                        iMax3 = i29;
                        view = viewL4;
                        iMax2 = i31;
                        i19 = i51;
                        i21 = i28;
                        z14 = true;
                        i22 = mode2;
                        i23 = i34;
                        i24 = virtualChildCount;
                        i25 = i32;
                    } else {
                        int i53 = i28;
                        if (((LinearLayout.LayoutParams) aVar3).height != 0 || f16 <= 0.0f) {
                            i18 = Integer.MIN_VALUE;
                        } else {
                            ((LinearLayout.LayoutParams) aVar3).height = -2;
                            i18 = 0;
                        }
                        i19 = i51;
                        int i54 = i18;
                        i21 = i53;
                        int i55 = i29;
                        i22 = mode2;
                        i23 = i34;
                        i24 = virtualChildCount;
                        iMax2 = i31;
                        i25 = i32;
                        p(viewL4, i32, i11, 0, i12, f17 == 0.0f ? this.f1439g : 0);
                        if (i54 != Integer.MIN_VALUE) {
                            ((LinearLayout.LayoutParams) aVar3).height = i54;
                        }
                        int measuredHeight2 = viewL4.getMeasuredHeight();
                        int i56 = this.f1439g;
                        view = viewL4;
                        this.f1439g = Math.max(i56, i56 + measuredHeight2 + ((LinearLayout.LayoutParams) aVar3).topMargin + ((LinearLayout.LayoutParams) aVar3).bottomMargin + k(view));
                        iMax3 = z13 ? Math.max(measuredHeight2, i55) : i55;
                    }
                    if (i26 >= 0 && i26 == i25 + 1) {
                        this.f1436c = this.f1439g;
                    }
                    if (i25 < i26 && ((LinearLayout.LayoutParams) aVar3).weight > 0.0f) {
                        throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                    }
                    if (mode == 1073741824 || ((LinearLayout.LayoutParams) aVar3).width != -1) {
                        z12 = false;
                    } else {
                        z12 = true;
                        z16 = true;
                    }
                    int i57 = ((LinearLayout.LayoutParams) aVar3).leftMargin + ((LinearLayout.LayoutParams) aVar3).rightMargin;
                    int measuredWidth2 = view.getMeasuredWidth() + i57;
                    int iMax8 = Math.max(i21, measuredWidth2);
                    int iCombineMeasuredStates2 = View.combineMeasuredStates(i19, view.getMeasuredState());
                    z15 = z15 && ((LinearLayout.LayoutParams) aVar3).width == -1;
                    if (((LinearLayout.LayoutParams) aVar3).weight > 0.0f) {
                        if (!z12) {
                            i57 = measuredWidth2;
                        }
                        iMax4 = Math.max(i23, i57);
                    } else {
                        if (!z12) {
                            i57 = measuredWidth2;
                        }
                        iMax2 = Math.max(iMax2, i57);
                        iMax4 = i23;
                    }
                    int i58 = i(view, i25) + i25;
                    i29 = iMax3;
                    i28 = iMax8;
                    f11 = f17;
                    i31 = iMax2;
                    i32 = i58;
                    i27 = iCombineMeasuredStates2;
                }
            }
            i32++;
            virtualChildCount = i24;
            mode2 = i22;
        }
    }

    public void setBaselineAligned(boolean z11) {
        this.f1434a = z11;
    }

    public void setBaselineAlignedChildIndex(int i11) {
        if (i11 >= 0 && i11 < getChildCount()) {
            this.f1435b = i11;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.f1444l) {
            return;
        }
        this.f1444l = drawable;
        if (drawable != null) {
            this.f1445m = drawable.getIntrinsicWidth();
            this.f1446n = drawable.getIntrinsicHeight();
        } else {
            this.f1445m = 0;
            this.f1446n = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i11) {
        this.f1448p = i11;
    }

    public void setGravity(int i11) {
        if (this.f1438f != i11) {
            if ((8388615 & i11) == 0) {
                i11 |= GravityCompat.START;
            }
            if ((i11 & 112) == 0) {
                i11 |= 48;
            }
            this.f1438f = i11;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i11) {
        int i12 = i11 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        int i13 = this.f1438f;
        if ((8388615 & i13) != i12) {
            this.f1438f = i12 | ((-8388616) & i13);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z11) {
        this.f1441i = z11;
    }

    public void setOrientation(int i11) {
        if (this.f1437d != i11) {
            this.f1437d = i11;
            requestLayout();
        }
    }

    public void setShowDividers(int i11) {
        if (i11 != this.f1447o) {
            requestLayout();
        }
        this.f1447o = i11;
    }

    public void setVerticalGravity(int i11) {
        int i12 = i11 & 112;
        int i13 = this.f1438f;
        if ((i13 & 112) != i12) {
            this.f1438f = i12 | (i13 & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f11) {
        this.f1440h = Math.max(0.0f, f11);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
