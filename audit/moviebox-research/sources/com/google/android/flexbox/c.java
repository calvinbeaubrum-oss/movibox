package com.google.android.flexbox;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.MarginLayoutParamsCompat;
import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.android.flexbox.a f36061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean[] f36062b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public int[] f36063c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public long[] f36064d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public long[] f36065e;

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<com.google.android.flexbox.b> f36066a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f36067b;

        public void a() {
            this.f36066a = null;
            this.f36067b = 0;
        }
    }

    /* JADX INFO: renamed from: com.google.android.flexbox.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0377c implements Comparable<C0377c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f36068a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f36069b;

        public C0377c() {
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(@NonNull C0377c c0377c) {
            int i11 = this.f36069b;
            int i12 = c0377c.f36069b;
            return i11 != i12 ? i11 - i12 : this.f36068a - c0377c.f36068a;
        }

        @NonNull
        public String toString() {
            return "Order{order=" + this.f36069b + ", index=" + this.f36068a + '}';
        }
    }

    public c(com.google.android.flexbox.a aVar) {
        this.f36061a = aVar;
    }

    public final int A(int i11, FlexItem flexItem, int i12) {
        com.google.android.flexbox.a aVar = this.f36061a;
        int childWidthMeasureSpec = aVar.getChildWidthMeasureSpec(i11, aVar.getPaddingLeft() + this.f36061a.getPaddingRight() + flexItem.getMarginLeft() + flexItem.getMarginRight() + i12, flexItem.getWidth());
        int size = View.MeasureSpec.getSize(childWidthMeasureSpec);
        if (size > flexItem.getMaxWidth()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.getMaxWidth(), View.MeasureSpec.getMode(childWidthMeasureSpec));
        }
        return size < flexItem.getMinWidth() ? View.MeasureSpec.makeMeasureSpec(flexItem.getMinWidth(), View.MeasureSpec.getMode(childWidthMeasureSpec)) : childWidthMeasureSpec;
    }

    public final int B(FlexItem flexItem, boolean z11) {
        return z11 ? flexItem.getMarginBottom() : flexItem.getMarginRight();
    }

    public final int C(FlexItem flexItem, boolean z11) {
        return z11 ? flexItem.getMarginRight() : flexItem.getMarginBottom();
    }

    public final int D(FlexItem flexItem, boolean z11) {
        return z11 ? flexItem.getMarginTop() : flexItem.getMarginLeft();
    }

    public final int E(FlexItem flexItem, boolean z11) {
        return z11 ? flexItem.getMarginLeft() : flexItem.getMarginTop();
    }

    public final int F(FlexItem flexItem, boolean z11) {
        return z11 ? flexItem.getHeight() : flexItem.getWidth();
    }

    public final int G(FlexItem flexItem, boolean z11) {
        return z11 ? flexItem.getWidth() : flexItem.getHeight();
    }

    public final int H(boolean z11) {
        return z11 ? this.f36061a.getPaddingBottom() : this.f36061a.getPaddingEnd();
    }

    public final int I(boolean z11) {
        return z11 ? this.f36061a.getPaddingEnd() : this.f36061a.getPaddingBottom();
    }

    public final int J(boolean z11) {
        return z11 ? this.f36061a.getPaddingTop() : this.f36061a.getPaddingStart();
    }

    public final int K(boolean z11) {
        return z11 ? this.f36061a.getPaddingStart() : this.f36061a.getPaddingTop();
    }

    public final int L(View view, boolean z11) {
        return z11 ? view.getMeasuredHeight() : view.getMeasuredWidth();
    }

    public final int M(View view, boolean z11) {
        return z11 ? view.getMeasuredWidth() : view.getMeasuredHeight();
    }

    public final boolean N(int i11, int i12, com.google.android.flexbox.b bVar) {
        return i11 == i12 - 1 && bVar.c() != 0;
    }

    public boolean O(SparseIntArray sparseIntArray) {
        int flexItemCount = this.f36061a.getFlexItemCount();
        if (sparseIntArray.size() != flexItemCount) {
            return true;
        }
        for (int i11 = 0; i11 < flexItemCount; i11++) {
            View flexItemAt = this.f36061a.getFlexItemAt(i11);
            if (flexItemAt != null && ((FlexItem) flexItemAt.getLayoutParams()).getOrder() != sparseIntArray.get(i11)) {
                return true;
            }
        }
        return false;
    }

    public final boolean P(View view, int i11, int i12, int i13, int i14, FlexItem flexItem, int i15, int i16, int i17) {
        if (this.f36061a.getFlexWrap() == 0) {
            return false;
        }
        if (flexItem.isWrapBefore()) {
            return true;
        }
        if (i11 == 0) {
            return false;
        }
        int maxLine = this.f36061a.getMaxLine();
        if (maxLine != -1 && maxLine <= i17 + 1) {
            return false;
        }
        int decorationLengthMainAxis = this.f36061a.getDecorationLengthMainAxis(view, i15, i16);
        if (decorationLengthMainAxis > 0) {
            i14 += decorationLengthMainAxis;
        }
        return i12 < i13 + i14;
    }

    public void Q(View view, com.google.android.flexbox.b bVar, int i11, int i12, int i13, int i14) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.f36061a.getAlignItems();
        if (flexItem.getAlignSelf() != -1) {
            alignItems = flexItem.getAlignSelf();
        }
        int i15 = bVar.f36049g;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (this.f36061a.getFlexWrap() == 2) {
                    view.layout(i11, (i12 - i15) + view.getMeasuredHeight() + flexItem.getMarginTop(), i13, (i14 - i15) + view.getMeasuredHeight() + flexItem.getMarginTop());
                    return;
                } else {
                    int i16 = i12 + i15;
                    view.layout(i11, (i16 - view.getMeasuredHeight()) - flexItem.getMarginBottom(), i13, i16 - flexItem.getMarginBottom());
                    return;
                }
            }
            if (alignItems == 2) {
                int measuredHeight = (((i15 - view.getMeasuredHeight()) + flexItem.getMarginTop()) - flexItem.getMarginBottom()) / 2;
                if (this.f36061a.getFlexWrap() != 2) {
                    int i17 = i12 + measuredHeight;
                    view.layout(i11, i17, i13, view.getMeasuredHeight() + i17);
                    return;
                } else {
                    int i18 = i12 - measuredHeight;
                    view.layout(i11, i18, i13, view.getMeasuredHeight() + i18);
                    return;
                }
            }
            if (alignItems == 3) {
                if (this.f36061a.getFlexWrap() != 2) {
                    int iMax = Math.max(bVar.f36054l - view.getBaseline(), flexItem.getMarginTop());
                    view.layout(i11, i12 + iMax, i13, i14 + iMax);
                    return;
                } else {
                    int iMax2 = Math.max((bVar.f36054l - view.getMeasuredHeight()) + view.getBaseline(), flexItem.getMarginBottom());
                    view.layout(i11, i12 - iMax2, i13, i14 - iMax2);
                    return;
                }
            }
            if (alignItems != 4) {
                return;
            }
        }
        if (this.f36061a.getFlexWrap() != 2) {
            view.layout(i11, i12 + flexItem.getMarginTop(), i13, i14 + flexItem.getMarginTop());
        } else {
            view.layout(i11, i12 - flexItem.getMarginBottom(), i13, i14 - flexItem.getMarginBottom());
        }
    }

    public void R(View view, com.google.android.flexbox.b bVar, boolean z11, int i11, int i12, int i13, int i14) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.f36061a.getAlignItems();
        if (flexItem.getAlignSelf() != -1) {
            alignItems = flexItem.getAlignSelf();
        }
        int i15 = bVar.f36049g;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (z11) {
                    view.layout((i11 - i15) + view.getMeasuredWidth() + flexItem.getMarginLeft(), i12, (i13 - i15) + view.getMeasuredWidth() + flexItem.getMarginLeft(), i14);
                    return;
                } else {
                    view.layout(((i11 + i15) - view.getMeasuredWidth()) - flexItem.getMarginRight(), i12, ((i13 + i15) - view.getMeasuredWidth()) - flexItem.getMarginRight(), i14);
                    return;
                }
            }
            if (alignItems == 2) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                int measuredWidth = (((i15 - view.getMeasuredWidth()) + MarginLayoutParamsCompat.getMarginStart(marginLayoutParams)) - MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams)) / 2;
                if (z11) {
                    view.layout(i11 - measuredWidth, i12, i13 - measuredWidth, i14);
                    return;
                } else {
                    view.layout(i11 + measuredWidth, i12, i13 + measuredWidth, i14);
                    return;
                }
            }
            if (alignItems != 3 && alignItems != 4) {
                return;
            }
        }
        if (z11) {
            view.layout(i11 - flexItem.getMarginRight(), i12, i13 - flexItem.getMarginRight(), i14);
        } else {
            view.layout(i11 + flexItem.getMarginLeft(), i12, i13 + flexItem.getMarginLeft(), i14);
        }
    }

    public long S(int i11, int i12) {
        return (((long) i11) & 4294967295L) | (((long) i12) << 32);
    }

    public final void T(int i11, int i12, com.google.android.flexbox.b bVar, int i13, int i14, boolean z11) {
        int i15;
        int i16;
        int iMax;
        int i17 = bVar.f36047e;
        float f11 = bVar.f36053k;
        float f12 = 0.0f;
        if (f11 <= 0.0f || i13 > i17) {
            return;
        }
        float f13 = (i17 - i13) / f11;
        bVar.f36047e = i14 + bVar.f36048f;
        if (!z11) {
            bVar.f36049g = Integer.MIN_VALUE;
        }
        int i18 = 0;
        boolean z12 = false;
        int i19 = 0;
        float f14 = 0.0f;
        while (i18 < bVar.f36050h) {
            int i21 = bVar.f36057o + i18;
            View reorderedFlexItemAt = this.f36061a.getReorderedFlexItemAt(i21);
            if (reorderedFlexItemAt == null || reorderedFlexItemAt.getVisibility() == 8) {
                i15 = i17;
                i16 = i18;
            } else {
                FlexItem flexItem = (FlexItem) reorderedFlexItemAt.getLayoutParams();
                int flexDirection = this.f36061a.getFlexDirection();
                if (flexDirection == 0 || flexDirection == 1) {
                    i15 = i17;
                    int i22 = i18;
                    int measuredWidth = reorderedFlexItemAt.getMeasuredWidth();
                    long[] jArr = this.f36065e;
                    if (jArr != null) {
                        measuredWidth = y(jArr[i21]);
                    }
                    int measuredHeight = reorderedFlexItemAt.getMeasuredHeight();
                    long[] jArr2 = this.f36065e;
                    if (jArr2 != null) {
                        measuredHeight = x(jArr2[i21]);
                    }
                    if (this.f36062b[i21] || flexItem.getFlexShrink() <= 0.0f) {
                        i16 = i22;
                    } else {
                        float flexShrink = measuredWidth - (flexItem.getFlexShrink() * f13);
                        if (i16 == bVar.f36050h - 1) {
                            i16 = i22;
                            flexShrink += f14;
                            f14 = 0.0f;
                        }
                        i16 = i22;
                        int iRound = Math.round(flexShrink);
                        if (iRound < flexItem.getMinWidth()) {
                            iRound = flexItem.getMinWidth();
                            this.f36062b[i21] = true;
                            bVar.f36053k -= flexItem.getFlexShrink();
                            z12 = true;
                        } else {
                            f14 += flexShrink - iRound;
                            double d11 = f14;
                            if (d11 > 1.0d) {
                                iRound++;
                                f14 -= 1.0f;
                            } else if (d11 < -1.0d) {
                                iRound--;
                                f14 += 1.0f;
                            }
                        }
                        int iZ = z(i12, flexItem, bVar.f36055m);
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iRound, 1073741824);
                        reorderedFlexItemAt.measure(iMakeMeasureSpec, iZ);
                        int measuredWidth2 = reorderedFlexItemAt.getMeasuredWidth();
                        int measuredHeight2 = reorderedFlexItemAt.getMeasuredHeight();
                        Z(i21, iMakeMeasureSpec, iZ, reorderedFlexItemAt);
                        this.f36061a.updateViewCache(i21, reorderedFlexItemAt);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int iMax2 = Math.max(i19, measuredHeight + flexItem.getMarginTop() + flexItem.getMarginBottom() + this.f36061a.getDecorationLengthCrossAxis(reorderedFlexItemAt));
                    bVar.f36047e += measuredWidth + flexItem.getMarginLeft() + flexItem.getMarginRight();
                    iMax = iMax2;
                } else {
                    int measuredHeight3 = reorderedFlexItemAt.getMeasuredHeight();
                    long[] jArr3 = this.f36065e;
                    if (jArr3 != null) {
                        measuredHeight3 = x(jArr3[i21]);
                    }
                    int measuredWidth3 = reorderedFlexItemAt.getMeasuredWidth();
                    long[] jArr4 = this.f36065e;
                    if (jArr4 != null) {
                        measuredWidth3 = y(jArr4[i21]);
                    }
                    if (this.f36062b[i21] || flexItem.getFlexShrink() <= f12) {
                        i15 = i17;
                        i16 = i18;
                    } else {
                        float flexShrink2 = measuredHeight3 - (flexItem.getFlexShrink() * f13);
                        if (i18 == bVar.f36050h - 1) {
                            flexShrink2 += f14;
                            f14 = 0.0f;
                        }
                        int iRound2 = Math.round(flexShrink2);
                        if (iRound2 < flexItem.getMinHeight()) {
                            iRound2 = flexItem.getMinHeight();
                            this.f36062b[i21] = true;
                            bVar.f36053k -= flexItem.getFlexShrink();
                            i15 = i17;
                            i16 = i18;
                            z12 = true;
                        } else {
                            f14 += flexShrink2 - iRound2;
                            i15 = i17;
                            i16 = i18;
                            double d12 = f14;
                            if (d12 > 1.0d) {
                                iRound2++;
                                f14 -= 1.0f;
                            } else if (d12 < -1.0d) {
                                iRound2--;
                                f14 += 1.0f;
                            }
                        }
                        int iA = A(i11, flexItem, bVar.f36055m);
                        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iRound2, 1073741824);
                        reorderedFlexItemAt.measure(iA, iMakeMeasureSpec2);
                        measuredWidth3 = reorderedFlexItemAt.getMeasuredWidth();
                        int measuredHeight4 = reorderedFlexItemAt.getMeasuredHeight();
                        Z(i21, iA, iMakeMeasureSpec2, reorderedFlexItemAt);
                        this.f36061a.updateViewCache(i21, reorderedFlexItemAt);
                        measuredHeight3 = measuredHeight4;
                    }
                    iMax = Math.max(i19, measuredWidth3 + flexItem.getMarginLeft() + flexItem.getMarginRight() + this.f36061a.getDecorationLengthCrossAxis(reorderedFlexItemAt));
                    bVar.f36047e += measuredHeight3 + flexItem.getMarginTop() + flexItem.getMarginBottom();
                }
                bVar.f36049g = Math.max(bVar.f36049g, iMax);
                i19 = iMax;
            }
            i18 = i16 + 1;
            i17 = i15;
            f12 = 0.0f;
        }
        int i23 = i17;
        if (!z12 || i23 == bVar.f36047e) {
            return;
        }
        T(i11, i12, bVar, i13, i14, true);
    }

    public final int[] U(int i11, List<C0377c> list, SparseIntArray sparseIntArray) {
        Collections.sort(list);
        sparseIntArray.clear();
        int[] iArr = new int[i11];
        int i12 = 0;
        for (C0377c c0377c : list) {
            int i13 = c0377c.f36068a;
            iArr[i12] = i13;
            sparseIntArray.append(i13, c0377c.f36069b);
            i12++;
        }
        return iArr;
    }

    public final void V(View view, int i11, int i12) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int iMin = Math.min(Math.max(((i11 - flexItem.getMarginLeft()) - flexItem.getMarginRight()) - this.f36061a.getDecorationLengthCrossAxis(view), flexItem.getMinWidth()), flexItem.getMaxWidth());
        long[] jArr = this.f36065e;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(jArr != null ? x(jArr[i12]) : view.getMeasuredHeight(), 1073741824);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
        view.measure(iMakeMeasureSpec2, iMakeMeasureSpec);
        Z(i12, iMakeMeasureSpec2, iMakeMeasureSpec, view);
        this.f36061a.updateViewCache(i12, view);
    }

    public final void W(View view, int i11, int i12) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int iMin = Math.min(Math.max(((i11 - flexItem.getMarginTop()) - flexItem.getMarginBottom()) - this.f36061a.getDecorationLengthCrossAxis(view), flexItem.getMinHeight()), flexItem.getMaxHeight());
        long[] jArr = this.f36065e;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(jArr != null ? y(jArr[i12]) : view.getMeasuredWidth(), 1073741824);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
        view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        Z(i12, iMakeMeasureSpec, iMakeMeasureSpec2, view);
        this.f36061a.updateViewCache(i12, view);
    }

    public void X() {
        Y(0);
    }

    public void Y(int i11) {
        View reorderedFlexItemAt;
        if (i11 >= this.f36061a.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.f36061a.getFlexDirection();
        if (this.f36061a.getAlignItems() != 4) {
            for (com.google.android.flexbox.b bVar : this.f36061a.getFlexLinesInternal()) {
                for (Integer num : bVar.f36056n) {
                    View reorderedFlexItemAt2 = this.f36061a.getReorderedFlexItemAt(num.intValue());
                    if (flexDirection == 0 || flexDirection == 1) {
                        W(reorderedFlexItemAt2, bVar.f36049g, num.intValue());
                    } else {
                        if (flexDirection != 2 && flexDirection != 3) {
                            throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
                        }
                        V(reorderedFlexItemAt2, bVar.f36049g, num.intValue());
                    }
                }
            }
            return;
        }
        int[] iArr = this.f36063c;
        List<com.google.android.flexbox.b> flexLinesInternal = this.f36061a.getFlexLinesInternal();
        int size = flexLinesInternal.size();
        for (int i12 = iArr != null ? iArr[i11] : 0; i12 < size; i12++) {
            com.google.android.flexbox.b bVar2 = flexLinesInternal.get(i12);
            int i13 = bVar2.f36050h;
            for (int i14 = 0; i14 < i13; i14++) {
                int i15 = bVar2.f36057o + i14;
                if (i14 < this.f36061a.getFlexItemCount() && (reorderedFlexItemAt = this.f36061a.getReorderedFlexItemAt(i15)) != null && reorderedFlexItemAt.getVisibility() != 8) {
                    FlexItem flexItem = (FlexItem) reorderedFlexItemAt.getLayoutParams();
                    if (flexItem.getAlignSelf() == -1 || flexItem.getAlignSelf() == 4) {
                        if (flexDirection == 0 || flexDirection == 1) {
                            W(reorderedFlexItemAt, bVar2.f36049g, i15);
                        } else {
                            if (flexDirection != 2 && flexDirection != 3) {
                                throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
                            }
                            V(reorderedFlexItemAt, bVar2.f36049g, i15);
                        }
                    }
                }
            }
        }
    }

    public final void Z(int i11, int i12, int i13, View view) {
        long[] jArr = this.f36064d;
        if (jArr != null) {
            jArr[i11] = S(i12, i13);
        }
        long[] jArr2 = this.f36065e;
        if (jArr2 != null) {
            jArr2[i11] = S(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    public final void a(List<com.google.android.flexbox.b> list, com.google.android.flexbox.b bVar, int i11, int i12) {
        bVar.f36055m = i12;
        this.f36061a.onNewFlexLineAdded(bVar);
        bVar.f36058p = i11;
        list.add(bVar);
    }

    public void b(b bVar, int i11, int i12, int i13, int i14, int i15, @Nullable List<com.google.android.flexbox.b> list) {
        int i16;
        int i17;
        List<com.google.android.flexbox.b> list2;
        int i18;
        View view;
        int i19;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27 = i12;
        int i28 = i15;
        boolean zIsMainAxisDirectionHorizontal = this.f36061a.isMainAxisDirectionHorizontal();
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        List<com.google.android.flexbox.b> arrayList = list == null ? new ArrayList() : list;
        bVar.f36066a = arrayList;
        boolean z11 = i28 == -1;
        int iK = K(zIsMainAxisDirectionHorizontal);
        int I = I(zIsMainAxisDirectionHorizontal);
        int iJ = J(zIsMainAxisDirectionHorizontal);
        int iH = H(zIsMainAxisDirectionHorizontal);
        com.google.android.flexbox.b bVar2 = new com.google.android.flexbox.b();
        int i29 = i14;
        bVar2.f36057o = i29;
        int i31 = I + iK;
        bVar2.f36047e = i31;
        int flexItemCount = this.f36061a.getFlexItemCount();
        boolean z12 = z11;
        int i32 = 0;
        int iCombineMeasuredStates = 0;
        int i33 = 0;
        int i34 = Integer.MIN_VALUE;
        while (i29 < flexItemCount) {
            View reorderedFlexItemAt = this.f36061a.getReorderedFlexItemAt(i29);
            if (reorderedFlexItemAt != null) {
                if (reorderedFlexItemAt.getVisibility() == 8) {
                    bVar2.f36051i++;
                    bVar2.f36050h++;
                    if (N(i29, flexItemCount, bVar2)) {
                        a(arrayList, bVar2, i29, i32);
                    }
                } else {
                    if (reorderedFlexItemAt instanceof CompoundButton) {
                        v((CompoundButton) reorderedFlexItemAt);
                    }
                    FlexItem flexItem = (FlexItem) reorderedFlexItemAt.getLayoutParams();
                    int i35 = flexItemCount;
                    if (flexItem.getAlignSelf() == 4) {
                        bVar2.f36056n.add(Integer.valueOf(i29));
                    }
                    int iG = G(flexItem, zIsMainAxisDirectionHorizontal);
                    if (flexItem.getFlexBasisPercent() != -1.0f && mode == 1073741824) {
                        iG = Math.round(size * flexItem.getFlexBasisPercent());
                    }
                    if (zIsMainAxisDirectionHorizontal) {
                        int childWidthMeasureSpec = this.f36061a.getChildWidthMeasureSpec(i11, i31 + E(flexItem, true) + C(flexItem, true), iG);
                        int childHeightMeasureSpec = this.f36061a.getChildHeightMeasureSpec(i27, iJ + iH + D(flexItem, true) + B(flexItem, true) + i32, F(flexItem, true));
                        reorderedFlexItemAt.measure(childWidthMeasureSpec, childHeightMeasureSpec);
                        Z(i29, childWidthMeasureSpec, childHeightMeasureSpec, reorderedFlexItemAt);
                        i17 = childWidthMeasureSpec;
                    } else {
                        int childWidthMeasureSpec2 = this.f36061a.getChildWidthMeasureSpec(i27, iJ + iH + D(flexItem, false) + B(flexItem, false) + i32, F(flexItem, false));
                        int childHeightMeasureSpec2 = this.f36061a.getChildHeightMeasureSpec(i11, E(flexItem, false) + i31 + C(flexItem, false), iG);
                        reorderedFlexItemAt.measure(childWidthMeasureSpec2, childHeightMeasureSpec2);
                        Z(i29, childWidthMeasureSpec2, childHeightMeasureSpec2, reorderedFlexItemAt);
                        i17 = childHeightMeasureSpec2;
                    }
                    this.f36061a.updateViewCache(i29, reorderedFlexItemAt);
                    i(reorderedFlexItemAt, i29);
                    iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, reorderedFlexItemAt.getMeasuredState());
                    int i36 = i32;
                    int i37 = i31;
                    com.google.android.flexbox.b bVar3 = bVar2;
                    int i38 = i29;
                    list2 = arrayList;
                    int i39 = i17;
                    if (P(reorderedFlexItemAt, mode, size, bVar2.f36047e, C(flexItem, zIsMainAxisDirectionHorizontal) + M(reorderedFlexItemAt, zIsMainAxisDirectionHorizontal) + E(flexItem, zIsMainAxisDirectionHorizontal), flexItem, i38, i33, arrayList.size())) {
                        i29 = i38;
                        if (bVar3.c() > 0) {
                            a(list2, bVar3, i29 > 0 ? i29 - 1 : 0, i36);
                            i32 = bVar3.f36049g + i36;
                        } else {
                            i32 = i36;
                        }
                        if (!zIsMainAxisDirectionHorizontal) {
                            i18 = i12;
                            view = reorderedFlexItemAt;
                            i22 = -1;
                            if (flexItem.getWidth() == -1) {
                                com.google.android.flexbox.a aVar = this.f36061a;
                                view.measure(aVar.getChildWidthMeasureSpec(i18, aVar.getPaddingLeft() + this.f36061a.getPaddingRight() + flexItem.getMarginLeft() + flexItem.getMarginRight() + i32, flexItem.getWidth()), i39);
                                i(view, i29);
                            }
                        } else if (flexItem.getHeight() == -1) {
                            com.google.android.flexbox.a aVar2 = this.f36061a;
                            i18 = i12;
                            i22 = -1;
                            view = reorderedFlexItemAt;
                            view.measure(i39, aVar2.getChildHeightMeasureSpec(i18, aVar2.getPaddingTop() + this.f36061a.getPaddingBottom() + flexItem.getMarginTop() + flexItem.getMarginBottom() + i32, flexItem.getHeight()));
                            i(view, i29);
                        } else {
                            i18 = i12;
                            view = reorderedFlexItemAt;
                            i22 = -1;
                        }
                        bVar2 = new com.google.android.flexbox.b();
                        i21 = 1;
                        bVar2.f36050h = 1;
                        i19 = i37;
                        bVar2.f36047e = i19;
                        bVar2.f36057o = i29;
                        i23 = 0;
                        i24 = Integer.MIN_VALUE;
                    } else {
                        i18 = i12;
                        i29 = i38;
                        view = reorderedFlexItemAt;
                        bVar2 = bVar3;
                        i19 = i37;
                        i21 = 1;
                        i22 = -1;
                        bVar2.f36050h++;
                        i23 = i33 + 1;
                        i32 = i36;
                        i24 = i34;
                    }
                    bVar2.f36059q |= flexItem.getFlexGrow() != 0.0f;
                    bVar2.f36060r |= flexItem.getFlexShrink() != 0.0f;
                    int[] iArr = this.f36063c;
                    if (iArr != null) {
                        iArr[i29] = list2.size();
                    }
                    bVar2.f36047e += M(view, zIsMainAxisDirectionHorizontal) + E(flexItem, zIsMainAxisDirectionHorizontal) + C(flexItem, zIsMainAxisDirectionHorizontal);
                    bVar2.f36052j += flexItem.getFlexGrow();
                    bVar2.f36053k += flexItem.getFlexShrink();
                    this.f36061a.onNewFlexItemAdded(view, i29, i23, bVar2);
                    int iMax = Math.max(i24, L(view, zIsMainAxisDirectionHorizontal) + D(flexItem, zIsMainAxisDirectionHorizontal) + B(flexItem, zIsMainAxisDirectionHorizontal) + this.f36061a.getDecorationLengthCrossAxis(view));
                    bVar2.f36049g = Math.max(bVar2.f36049g, iMax);
                    if (zIsMainAxisDirectionHorizontal) {
                        if (this.f36061a.getFlexWrap() != 2) {
                            bVar2.f36054l = Math.max(bVar2.f36054l, view.getBaseline() + flexItem.getMarginTop());
                        } else {
                            bVar2.f36054l = Math.max(bVar2.f36054l, (view.getMeasuredHeight() - view.getBaseline()) + flexItem.getMarginBottom());
                        }
                    }
                    i25 = i35;
                    if (N(i29, i25, bVar2)) {
                        a(list2, bVar2, i29, i32);
                        i32 += bVar2.f36049g;
                    }
                    i26 = i15;
                    if (i26 != i22 && list2.size() > 0 && list2.get(list2.size() - i21).f36058p >= i26 && i29 >= i26 && !z12) {
                        i32 = -bVar2.a();
                        z12 = true;
                    }
                    if (i32 > i13 && z12) {
                        i16 = iCombineMeasuredStates;
                        bVar.f36067b = i16;
                    } else {
                        i33 = i23;
                        i34 = iMax;
                    }
                }
                i29++;
                flexItemCount = i25;
                i27 = i18;
                i31 = i19;
                arrayList = list2;
                size = size;
                mode = mode;
                i28 = i26;
            } else if (N(i29, flexItemCount, bVar2)) {
                a(arrayList, bVar2, i29, i32);
            }
            size = size;
            mode = mode;
            i18 = i27;
            i26 = i28;
            i19 = i31;
            list2 = arrayList;
            i25 = flexItemCount;
            i29++;
            flexItemCount = i25;
            i27 = i18;
            i31 = i19;
            arrayList = list2;
            size = size;
            mode = mode;
            i28 = i26;
        }
        i16 = iCombineMeasuredStates;
        bVar.f36067b = i16;
    }

    public void c(b bVar, int i11, int i12) {
        b(bVar, i11, i12, Api.BaseClientBuilder.API_PRIORITY_OTHER, 0, -1, null);
    }

    public void d(b bVar, int i11, int i12, int i13, int i14, @Nullable List<com.google.android.flexbox.b> list) {
        b(bVar, i11, i12, i13, i14, -1, list);
    }

    public void e(b bVar, int i11, int i12, int i13, int i14, List<com.google.android.flexbox.b> list) {
        b(bVar, i11, i12, i13, 0, i14, list);
    }

    public void f(b bVar, int i11, int i12) {
        b(bVar, i12, i11, Api.BaseClientBuilder.API_PRIORITY_OTHER, 0, -1, null);
    }

    public void g(b bVar, int i11, int i12, int i13, int i14, @Nullable List<com.google.android.flexbox.b> list) {
        b(bVar, i12, i11, i13, i14, -1, list);
    }

    public void h(b bVar, int i11, int i12, int i13, int i14, List<com.google.android.flexbox.b> list) {
        b(bVar, i12, i11, i13, 0, i14, list);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x002d  */
    /* JADX WARN: Code duplicated, block: B:13:0x0032  */
    /* JADX WARN: Code duplicated, block: B:15:0x0038  */
    /* JADX WARN: Code duplicated, block: B:16:0x003d  */
    /* JADX WARN: Code duplicated, block: B:18:0x0040  */
    /* JADX WARN: Code duplicated, block: B:20:? A[RETURN, SYNTHETIC] */
    public final void i(View view, int i11) {
        boolean z11;
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        boolean z12 = true;
        if (measuredWidth >= flexItem.getMinWidth()) {
            if (measuredWidth > flexItem.getMaxWidth()) {
                measuredWidth = flexItem.getMaxWidth();
            } else {
                z11 = false;
            }
            if (measuredHeight < flexItem.getMinHeight()) {
                measuredHeight = flexItem.getMinHeight();
            } else if (measuredHeight > flexItem.getMaxHeight()) {
                measuredHeight = flexItem.getMaxHeight();
            } else {
                z12 = z11;
            }
            if (z12) {
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
                int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
                view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                Z(i11, iMakeMeasureSpec, iMakeMeasureSpec2, view);
                this.f36061a.updateViewCache(i11, view);
            }
        }
        measuredWidth = flexItem.getMinWidth();
        z11 = true;
        if (measuredHeight < flexItem.getMinHeight()) {
            measuredHeight = flexItem.getMinHeight();
        } else if (measuredHeight > flexItem.getMaxHeight()) {
            measuredHeight = flexItem.getMaxHeight();
        } else {
            z12 = z11;
        }
        if (z12) {
            int iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
            int iMakeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
            view.measure(iMakeMeasureSpec3, iMakeMeasureSpec4);
            Z(i11, iMakeMeasureSpec3, iMakeMeasureSpec4, view);
            this.f36061a.updateViewCache(i11, view);
        }
    }

    public void j(List<com.google.android.flexbox.b> list, int i11) {
        int i12 = this.f36063c[i11];
        if (i12 == -1) {
            i12 = 0;
        }
        if (list.size() > i12) {
            list.subList(i12, list.size()).clear();
        }
        int[] iArr = this.f36063c;
        int length = iArr.length - 1;
        if (i11 > length) {
            Arrays.fill(iArr, -1);
        } else {
            Arrays.fill(iArr, i11, length, -1);
        }
        long[] jArr = this.f36064d;
        int length2 = jArr.length - 1;
        if (i11 > length2) {
            Arrays.fill(jArr, 0L);
        } else {
            Arrays.fill(jArr, i11, length2, 0L);
        }
    }

    public final List<com.google.android.flexbox.b> k(List<com.google.android.flexbox.b> list, int i11, int i12) {
        int i13 = (i11 - i12) / 2;
        ArrayList arrayList = new ArrayList();
        com.google.android.flexbox.b bVar = new com.google.android.flexbox.b();
        bVar.f36049g = i13;
        int size = list.size();
        for (int i14 = 0; i14 < size; i14++) {
            if (i14 == 0) {
                arrayList.add(bVar);
            }
            arrayList.add(list.get(i14));
            if (i14 == list.size() - 1) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    @NonNull
    public final List<C0377c> l(int i11) {
        ArrayList arrayList = new ArrayList(i11);
        for (int i12 = 0; i12 < i11; i12++) {
            FlexItem flexItem = (FlexItem) this.f36061a.getFlexItemAt(i12).getLayoutParams();
            C0377c c0377c = new C0377c();
            c0377c.f36069b = flexItem.getOrder();
            c0377c.f36068a = i12;
            arrayList.add(c0377c);
        }
        return arrayList;
    }

    public int[] m(SparseIntArray sparseIntArray) {
        int flexItemCount = this.f36061a.getFlexItemCount();
        return U(flexItemCount, l(flexItemCount), sparseIntArray);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int[] n(View view, int i11, ViewGroup.LayoutParams layoutParams, SparseIntArray sparseIntArray) {
        int flexItemCount = this.f36061a.getFlexItemCount();
        List<C0377c> listL = l(flexItemCount);
        C0377c c0377c = new C0377c();
        if (view == null || !(layoutParams instanceof FlexItem)) {
            c0377c.f36069b = 1;
        } else {
            c0377c.f36069b = ((FlexItem) layoutParams).getOrder();
        }
        if (i11 == -1 || i11 == flexItemCount || i11 >= this.f36061a.getFlexItemCount()) {
            c0377c.f36068a = flexItemCount;
        } else {
            c0377c.f36068a = i11;
            while (i11 < flexItemCount) {
                listL.get(i11).f36068a++;
                i11++;
            }
        }
        listL.add(c0377c);
        return U(flexItemCount + 1, listL, sparseIntArray);
    }

    public void o(int i11, int i12, int i13) {
        int mode;
        int size;
        int flexDirection = this.f36061a.getFlexDirection();
        if (flexDirection == 0 || flexDirection == 1) {
            int mode2 = View.MeasureSpec.getMode(i12);
            int size2 = View.MeasureSpec.getSize(i12);
            mode = mode2;
            size = size2;
        } else {
            if (flexDirection != 2 && flexDirection != 3) {
                throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
            }
            mode = View.MeasureSpec.getMode(i11);
            size = View.MeasureSpec.getSize(i11);
        }
        List<com.google.android.flexbox.b> flexLinesInternal = this.f36061a.getFlexLinesInternal();
        if (mode == 1073741824) {
            int sumOfCrossSize = this.f36061a.getSumOfCrossSize() + i13;
            int i14 = 0;
            if (flexLinesInternal.size() == 1) {
                flexLinesInternal.get(0).f36049g = size - i13;
                return;
            }
            if (flexLinesInternal.size() >= 2) {
                int alignContent = this.f36061a.getAlignContent();
                if (alignContent == 1) {
                    int i15 = size - sumOfCrossSize;
                    com.google.android.flexbox.b bVar = new com.google.android.flexbox.b();
                    bVar.f36049g = i15;
                    flexLinesInternal.add(0, bVar);
                    return;
                }
                if (alignContent == 2) {
                    this.f36061a.setFlexLines(k(flexLinesInternal, size, sumOfCrossSize));
                    return;
                }
                if (alignContent == 3) {
                    if (sumOfCrossSize >= size) {
                        return;
                    }
                    float size3 = (size - sumOfCrossSize) / (flexLinesInternal.size() - 1);
                    ArrayList arrayList = new ArrayList();
                    int size4 = flexLinesInternal.size();
                    float f11 = 0.0f;
                    while (i14 < size4) {
                        arrayList.add(flexLinesInternal.get(i14));
                        if (i14 != flexLinesInternal.size() - 1) {
                            com.google.android.flexbox.b bVar2 = new com.google.android.flexbox.b();
                            if (i14 == flexLinesInternal.size() - 2) {
                                bVar2.f36049g = Math.round(f11 + size3);
                                f11 = 0.0f;
                            } else {
                                bVar2.f36049g = Math.round(size3);
                            }
                            int i16 = bVar2.f36049g;
                            f11 += size3 - i16;
                            if (f11 > 1.0f) {
                                bVar2.f36049g = i16 + 1;
                                f11 -= 1.0f;
                            } else if (f11 < -1.0f) {
                                bVar2.f36049g = i16 - 1;
                                f11 += 1.0f;
                            }
                            arrayList.add(bVar2);
                        }
                        i14++;
                    }
                    this.f36061a.setFlexLines(arrayList);
                    return;
                }
                if (alignContent == 4) {
                    if (sumOfCrossSize >= size) {
                        this.f36061a.setFlexLines(k(flexLinesInternal, size, sumOfCrossSize));
                        return;
                    }
                    int size5 = (size - sumOfCrossSize) / (flexLinesInternal.size() * 2);
                    ArrayList arrayList2 = new ArrayList();
                    com.google.android.flexbox.b bVar3 = new com.google.android.flexbox.b();
                    bVar3.f36049g = size5;
                    for (com.google.android.flexbox.b bVar4 : flexLinesInternal) {
                        arrayList2.add(bVar3);
                        arrayList2.add(bVar4);
                        arrayList2.add(bVar3);
                    }
                    this.f36061a.setFlexLines(arrayList2);
                    return;
                }
                if (alignContent == 5 && sumOfCrossSize < size) {
                    float size6 = (size - sumOfCrossSize) / flexLinesInternal.size();
                    int size7 = flexLinesInternal.size();
                    float f12 = 0.0f;
                    while (i14 < size7) {
                        com.google.android.flexbox.b bVar5 = flexLinesInternal.get(i14);
                        float f13 = bVar5.f36049g + size6;
                        if (i14 == flexLinesInternal.size() - 1) {
                            f13 += f12;
                            f12 = 0.0f;
                        }
                        int iRound = Math.round(f13);
                        f12 += f13 - iRound;
                        if (f12 > 1.0f) {
                            iRound++;
                            f12 -= 1.0f;
                        } else if (f12 < -1.0f) {
                            iRound--;
                            f12 += 1.0f;
                        }
                        bVar5.f36049g = iRound;
                        i14++;
                    }
                }
            }
        }
    }

    public void p(int i11, int i12) {
        q(i11, i12, 0);
    }

    public void q(int i11, int i12, int i13) {
        int size;
        int paddingLeft;
        int paddingRight;
        r(this.f36061a.getFlexItemCount());
        if (i13 >= this.f36061a.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.f36061a.getFlexDirection();
        int flexDirection2 = this.f36061a.getFlexDirection();
        if (flexDirection2 == 0 || flexDirection2 == 1) {
            int mode = View.MeasureSpec.getMode(i11);
            size = View.MeasureSpec.getSize(i11);
            int largestMainSize = this.f36061a.getLargestMainSize();
            if (mode != 1073741824) {
                size = Math.min(largestMainSize, size);
            }
            paddingLeft = this.f36061a.getPaddingLeft();
            paddingRight = this.f36061a.getPaddingRight();
        } else {
            if (flexDirection2 != 2 && flexDirection2 != 3) {
                throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
            }
            int mode2 = View.MeasureSpec.getMode(i12);
            size = View.MeasureSpec.getSize(i12);
            if (mode2 != 1073741824) {
                size = this.f36061a.getLargestMainSize();
            }
            paddingLeft = this.f36061a.getPaddingTop();
            paddingRight = this.f36061a.getPaddingBottom();
        }
        int i14 = paddingLeft + paddingRight;
        int[] iArr = this.f36063c;
        List<com.google.android.flexbox.b> flexLinesInternal = this.f36061a.getFlexLinesInternal();
        int size2 = flexLinesInternal.size();
        for (int i15 = iArr != null ? iArr[i13] : 0; i15 < size2; i15++) {
            com.google.android.flexbox.b bVar = flexLinesInternal.get(i15);
            int i16 = bVar.f36047e;
            if (i16 < size && bVar.f36059q) {
                w(i11, i12, bVar, size, i14, false);
            } else if (i16 > size && bVar.f36060r) {
                T(i11, i12, bVar, size, i14, false);
            }
        }
    }

    public final void r(int i11) {
        boolean[] zArr = this.f36062b;
        if (zArr == null) {
            this.f36062b = new boolean[Math.max(i11, 10)];
        } else if (zArr.length < i11) {
            this.f36062b = new boolean[Math.max(zArr.length * 2, i11)];
        } else {
            Arrays.fill(zArr, false);
        }
    }

    public void s(int i11) {
        int[] iArr = this.f36063c;
        if (iArr == null) {
            this.f36063c = new int[Math.max(i11, 10)];
        } else if (iArr.length < i11) {
            this.f36063c = Arrays.copyOf(this.f36063c, Math.max(iArr.length * 2, i11));
        }
    }

    public void t(int i11) {
        long[] jArr = this.f36064d;
        if (jArr == null) {
            this.f36064d = new long[Math.max(i11, 10)];
        } else if (jArr.length < i11) {
            this.f36064d = Arrays.copyOf(this.f36064d, Math.max(jArr.length * 2, i11));
        }
    }

    public void u(int i11) {
        long[] jArr = this.f36065e;
        if (jArr == null) {
            this.f36065e = new long[Math.max(i11, 10)];
        } else if (jArr.length < i11) {
            this.f36065e = Arrays.copyOf(this.f36065e, Math.max(jArr.length * 2, i11));
        }
    }

    public final void v(CompoundButton compoundButton) {
        FlexItem flexItem = (FlexItem) compoundButton.getLayoutParams();
        int minWidth = flexItem.getMinWidth();
        int minHeight = flexItem.getMinHeight();
        Drawable drawableA = androidx.core.widget.b.a(compoundButton);
        int minimumWidth = drawableA == null ? 0 : drawableA.getMinimumWidth();
        int minimumHeight = drawableA != null ? drawableA.getMinimumHeight() : 0;
        if (minWidth == -1) {
            minWidth = minimumWidth;
        }
        flexItem.setMinWidth(minWidth);
        if (minHeight == -1) {
            minHeight = minimumHeight;
        }
        flexItem.setMinHeight(minHeight);
    }

    public final void w(int i11, int i12, com.google.android.flexbox.b bVar, int i13, int i14, boolean z11) {
        int i15;
        int i16;
        int iMax;
        double d11;
        int i17;
        double d12;
        float f11 = bVar.f36052j;
        float f12 = 0.0f;
        if (f11 <= 0.0f || i13 < (i15 = bVar.f36047e)) {
            return;
        }
        float f13 = (i13 - i15) / f11;
        bVar.f36047e = i14 + bVar.f36048f;
        if (!z11) {
            bVar.f36049g = Integer.MIN_VALUE;
        }
        int i18 = 0;
        boolean z12 = false;
        int i19 = 0;
        float f14 = 0.0f;
        while (i18 < bVar.f36050h) {
            int i21 = bVar.f36057o + i18;
            View reorderedFlexItemAt = this.f36061a.getReorderedFlexItemAt(i21);
            if (reorderedFlexItemAt == null || reorderedFlexItemAt.getVisibility() == 8) {
                i16 = i15;
            } else {
                FlexItem flexItem = (FlexItem) reorderedFlexItemAt.getLayoutParams();
                int flexDirection = this.f36061a.getFlexDirection();
                if (flexDirection == 0 || flexDirection == 1) {
                    int i22 = i15;
                    int measuredWidth = reorderedFlexItemAt.getMeasuredWidth();
                    long[] jArr = this.f36065e;
                    if (jArr != null) {
                        measuredWidth = y(jArr[i21]);
                    }
                    int measuredHeight = reorderedFlexItemAt.getMeasuredHeight();
                    long[] jArr2 = this.f36065e;
                    i16 = i22;
                    if (jArr2 != null) {
                        measuredHeight = x(jArr2[i21]);
                    }
                    if (!this.f36062b[i21] && flexItem.getFlexGrow() > 0.0f) {
                        float flexGrow = measuredWidth + (flexItem.getFlexGrow() * f13);
                        if (i18 == bVar.f36050h - 1) {
                            flexGrow += f14;
                            f14 = 0.0f;
                        }
                        int iRound = Math.round(flexGrow);
                        if (iRound > flexItem.getMaxWidth()) {
                            iRound = flexItem.getMaxWidth();
                            this.f36062b[i21] = true;
                            bVar.f36052j -= flexItem.getFlexGrow();
                            z12 = true;
                        } else {
                            f14 += flexGrow - iRound;
                            double d13 = f14;
                            if (d13 > 1.0d) {
                                iRound++;
                                d11 = d13 - 1.0d;
                            } else if (d13 < -1.0d) {
                                iRound--;
                                d11 = d13 + 1.0d;
                            }
                            f14 = (float) d11;
                        }
                        int iZ = z(i12, flexItem, bVar.f36055m);
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iRound, 1073741824);
                        reorderedFlexItemAt.measure(iMakeMeasureSpec, iZ);
                        int measuredWidth2 = reorderedFlexItemAt.getMeasuredWidth();
                        int measuredHeight2 = reorderedFlexItemAt.getMeasuredHeight();
                        Z(i21, iMakeMeasureSpec, iZ, reorderedFlexItemAt);
                        this.f36061a.updateViewCache(i21, reorderedFlexItemAt);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int iMax2 = Math.max(i19, measuredHeight + flexItem.getMarginTop() + flexItem.getMarginBottom() + this.f36061a.getDecorationLengthCrossAxis(reorderedFlexItemAt));
                    bVar.f36047e += measuredWidth + flexItem.getMarginLeft() + flexItem.getMarginRight();
                    iMax = iMax2;
                } else {
                    int measuredHeight3 = reorderedFlexItemAt.getMeasuredHeight();
                    long[] jArr3 = this.f36065e;
                    if (jArr3 != null) {
                        measuredHeight3 = x(jArr3[i21]);
                    }
                    int measuredWidth3 = reorderedFlexItemAt.getMeasuredWidth();
                    long[] jArr4 = this.f36065e;
                    if (jArr4 != null) {
                        measuredWidth3 = y(jArr4[i21]);
                    }
                    if (this.f36062b[i21] || flexItem.getFlexGrow() <= f12) {
                        i17 = i15;
                    } else {
                        float flexGrow2 = measuredHeight3 + (flexItem.getFlexGrow() * f13);
                        if (i18 == bVar.f36050h - 1) {
                            flexGrow2 += f14;
                            f14 = 0.0f;
                        }
                        int iRound2 = Math.round(flexGrow2);
                        if (iRound2 > flexItem.getMaxHeight()) {
                            iRound2 = flexItem.getMaxHeight();
                            this.f36062b[i21] = true;
                            bVar.f36052j -= flexItem.getFlexGrow();
                            i17 = i15;
                            z12 = true;
                        } else {
                            f14 += flexGrow2 - iRound2;
                            i17 = i15;
                            double d14 = f14;
                            if (d14 > 1.0d) {
                                iRound2++;
                                d12 = d14 - 1.0d;
                            } else if (d14 < -1.0d) {
                                iRound2--;
                                d12 = d14 + 1.0d;
                            }
                            f14 = (float) d12;
                        }
                        int iA = A(i11, flexItem, bVar.f36055m);
                        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iRound2, 1073741824);
                        reorderedFlexItemAt.measure(iA, iMakeMeasureSpec2);
                        measuredWidth3 = reorderedFlexItemAt.getMeasuredWidth();
                        int measuredHeight4 = reorderedFlexItemAt.getMeasuredHeight();
                        Z(i21, iA, iMakeMeasureSpec2, reorderedFlexItemAt);
                        this.f36061a.updateViewCache(i21, reorderedFlexItemAt);
                        measuredHeight3 = measuredHeight4;
                    }
                    iMax = Math.max(i19, measuredWidth3 + flexItem.getMarginLeft() + flexItem.getMarginRight() + this.f36061a.getDecorationLengthCrossAxis(reorderedFlexItemAt));
                    bVar.f36047e += measuredHeight3 + flexItem.getMarginTop() + flexItem.getMarginBottom();
                    i16 = i17;
                }
                bVar.f36049g = Math.max(bVar.f36049g, iMax);
                i19 = iMax;
            }
            i18++;
            i15 = i16;
            f12 = 0.0f;
        }
        int i23 = i15;
        if (!z12 || i23 == bVar.f36047e) {
            return;
        }
        w(i11, i12, bVar, i13, i14, true);
    }

    public int x(long j11) {
        return (int) (j11 >> 32);
    }

    public int y(long j11) {
        return (int) j11;
    }

    public final int z(int i11, FlexItem flexItem, int i12) {
        com.google.android.flexbox.a aVar = this.f36061a;
        int childHeightMeasureSpec = aVar.getChildHeightMeasureSpec(i11, aVar.getPaddingTop() + this.f36061a.getPaddingBottom() + flexItem.getMarginTop() + flexItem.getMarginBottom() + i12, flexItem.getHeight());
        int size = View.MeasureSpec.getSize(childHeightMeasureSpec);
        if (size > flexItem.getMaxHeight()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.getMaxHeight(), View.MeasureSpec.getMode(childHeightMeasureSpec));
        }
        return size < flexItem.getMinHeight() ? View.MeasureSpec.makeMeasureSpec(flexItem.getMinHeight(), View.MeasureSpec.getMode(childHeightMeasureSpec)) : childHeightMeasureSpec;
    }
}
