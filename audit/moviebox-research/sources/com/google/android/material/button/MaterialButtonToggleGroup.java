package com.google.android.material.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ToggleButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.b0;
import com.google.android.material.internal.f0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import yi.n;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class MaterialButtonToggleGroup extends LinearLayout {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f36411l = R$style.Widget_MaterialComponents_MaterialButtonToggleGroup;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<b> f36412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f36413b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedHashSet<c> f36414c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Comparator<MaterialButton> f36415d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Integer[] f36416f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f36417g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f36418h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f36419i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f36420j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Set<Integer> f36421k;

    /* JADX INFO: compiled from: source.java */
    public class a extends AccessibilityDelegateCompat {
        public a() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, MaterialButtonToggleGroup.this.g(view), 1, false, ((MaterialButton) view).isChecked()));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final yi.d f36423e = new yi.a(0.0f);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public yi.d f36424a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public yi.d f36425b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public yi.d f36426c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public yi.d f36427d;

        public b(yi.d dVar, yi.d dVar2, yi.d dVar3, yi.d dVar4) {
            this.f36424a = dVar;
            this.f36425b = dVar3;
            this.f36426c = dVar4;
            this.f36427d = dVar2;
        }

        public static b a(b bVar) {
            yi.d dVar = f36423e;
            return new b(dVar, bVar.f36427d, dVar, bVar.f36426c);
        }

        public static b b(b bVar, View view) {
            return f0.p(view) ? c(bVar) : d(bVar);
        }

        public static b c(b bVar) {
            yi.d dVar = bVar.f36424a;
            yi.d dVar2 = bVar.f36427d;
            yi.d dVar3 = f36423e;
            return new b(dVar, dVar2, dVar3, dVar3);
        }

        public static b d(b bVar) {
            yi.d dVar = f36423e;
            return new b(dVar, dVar, bVar.f36425b, bVar.f36426c);
        }

        public static b e(b bVar, View view) {
            return f0.p(view) ? d(bVar) : c(bVar);
        }

        public static b f(b bVar) {
            yi.d dVar = bVar.f36424a;
            yi.d dVar2 = f36423e;
            return new b(dVar, dVar2, bVar.f36425b, dVar2);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface c {
        void a(MaterialButtonToggleGroup materialButtonToggleGroup, int i11, boolean z11);
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements MaterialButton.b {
        public d() {
        }

        @Override // com.google.android.material.button.MaterialButton.b
        public void a(@NonNull MaterialButton materialButton, boolean z11) {
            MaterialButtonToggleGroup.this.invalidate();
        }
    }

    public MaterialButtonToggleGroup(@NonNull Context context) {
        this(context, null);
    }

    public MaterialButtonToggleGroup(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.materialButtonToggleGroupStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialButtonToggleGroup(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        int i12 = f36411l;
        super(zi.a.c(context, attributeSet, i11, i12), attributeSet, i11);
        this.f36412a = new ArrayList();
        this.f36413b = new d();
        this.f36414c = new LinkedHashSet<>();
        this.f36415d = new Comparator<MaterialButton>() { // from class: com.google.android.material.button.MaterialButtonToggleGroup.1
            @Override // java.util.Comparator
            public int compare(MaterialButton materialButton, MaterialButton materialButton2) {
                int iCompareTo = Boolean.valueOf(materialButton.isChecked()).compareTo(Boolean.valueOf(materialButton2.isChecked()));
                if (iCompareTo != 0) {
                    return iCompareTo;
                }
                int iCompareTo2 = Boolean.valueOf(materialButton.isPressed()).compareTo(Boolean.valueOf(materialButton2.isPressed()));
                return iCompareTo2 != 0 ? iCompareTo2 : Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(materialButton)).compareTo(Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(materialButton2)));
            }
        };
        this.f36417g = false;
        this.f36421k = new HashSet();
        TypedArray typedArrayI = b0.i(getContext(), attributeSet, R$styleable.MaterialButtonToggleGroup, i11, i12, new int[0]);
        setSingleSelection(typedArrayI.getBoolean(R$styleable.MaterialButtonToggleGroup_singleSelection, false));
        this.f36420j = typedArrayI.getResourceId(R$styleable.MaterialButtonToggleGroup_checkedButton, -1);
        this.f36419i = typedArrayI.getBoolean(R$styleable.MaterialButtonToggleGroup_selectionRequired, false);
        setChildrenDrawingOrderEnabled(true);
        setEnabled(typedArrayI.getBoolean(R$styleable.MaterialButtonToggleGroup_android_enabled, true));
        typedArrayI.recycle();
        ViewCompat.setImportantForAccessibility(this, 1);
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            if (i(i11)) {
                return i11;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (i(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    private int getVisibleButtonCount() {
        int i11 = 0;
        for (int i12 = 0; i12 < getChildCount(); i12++) {
            if ((getChildAt(i12) instanceof MaterialButton) && i(i12)) {
                i11++;
            }
        }
        return i11;
    }

    public static void m(n.b bVar, @Nullable b bVar2) {
        if (bVar2 == null) {
            bVar.o(0.0f);
        } else {
            bVar.I(bVar2.f36424a).x(bVar2.f36427d).N(bVar2.f36425b).C(bVar2.f36426c);
        }
    }

    private void setGeneratedIdIfNeeded(@NonNull MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            materialButton.setId(ViewCompat.generateViewId());
        }
    }

    private void setupButtonChild(@NonNull MaterialButton materialButton) {
        materialButton.setMaxLines(1);
        materialButton.setEllipsize(TextUtils.TruncateAt.END);
        materialButton.setCheckable(true);
        materialButton.setOnPressedChangeListenerInternal(this.f36413b);
        materialButton.setShouldDrawSurfaceColorStroke(true);
    }

    public void addOnButtonCheckedListener(@NonNull c cVar) {
        this.f36414c.add(cVar);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i11, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            Log.e("MButtonToggleGroup", "Child views must be of type MaterialButton.");
            return;
        }
        super.addView(view, i11, layoutParams);
        MaterialButton materialButton = (MaterialButton) view;
        setGeneratedIdIfNeeded(materialButton);
        setupButtonChild(materialButton);
        d(materialButton.getId(), materialButton.isChecked());
        n shapeAppearanceModel = materialButton.getShapeAppearanceModel();
        this.f36412a.add(new b(shapeAppearanceModel.r(), shapeAppearanceModel.j(), shapeAppearanceModel.t(), shapeAppearanceModel.l()));
        materialButton.setEnabled(isEnabled());
        ViewCompat.setAccessibilityDelegate(materialButton, new a());
    }

    public final void b() {
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex == -1) {
            return;
        }
        for (int i11 = firstVisibleChildIndex + 1; i11 < getChildCount(); i11++) {
            MaterialButton materialButtonF = f(i11);
            int iMin = Math.min(materialButtonF.getStrokeWidth(), f(i11 - 1).getStrokeWidth());
            LinearLayout.LayoutParams layoutParamsC = c(materialButtonF);
            if (getOrientation() == 0) {
                MarginLayoutParamsCompat.setMarginEnd(layoutParamsC, 0);
                MarginLayoutParamsCompat.setMarginStart(layoutParamsC, -iMin);
                layoutParamsC.topMargin = 0;
            } else {
                layoutParamsC.bottomMargin = 0;
                layoutParamsC.topMargin = -iMin;
                MarginLayoutParamsCompat.setMarginStart(layoutParamsC, 0);
            }
            materialButtonF.setLayoutParams(layoutParamsC);
        }
        k(firstVisibleChildIndex);
    }

    @NonNull
    public final LinearLayout.LayoutParams c(@NonNull View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        return layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
    }

    public void check(int i11) {
        d(i11, true);
    }

    public void clearChecked() {
        n(new HashSet());
    }

    public void clearOnButtonCheckedListeners() {
        this.f36414c.clear();
    }

    public final void d(int i11, boolean z11) {
        if (i11 == -1) {
            Log.e("MButtonToggleGroup", "Button ID is not valid: " + i11);
            return;
        }
        HashSet hashSet = new HashSet(this.f36421k);
        if (z11 && !hashSet.contains(Integer.valueOf(i11))) {
            if (this.f36418h && !hashSet.isEmpty()) {
                hashSet.clear();
            }
            hashSet.add(Integer.valueOf(i11));
        } else {
            if (z11 || !hashSet.contains(Integer.valueOf(i11))) {
                return;
            }
            if (!this.f36419i || hashSet.size() > 1) {
                hashSet.remove(Integer.valueOf(i11));
            }
        }
        n(hashSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(@NonNull Canvas canvas) {
        o();
        super.dispatchDraw(canvas);
    }

    public final void e(int i11, boolean z11) {
        Iterator<c> it = this.f36414c.iterator();
        while (it.hasNext()) {
            it.next().a(this, i11, z11);
        }
    }

    public final MaterialButton f(int i11) {
        return (MaterialButton) getChildAt(i11);
    }

    public final int g(@Nullable View view) {
        if (!(view instanceof MaterialButton)) {
            return -1;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < getChildCount(); i12++) {
            if (getChildAt(i12) == view) {
                return i11;
            }
            if ((getChildAt(i12) instanceof MaterialButton) && i(i12)) {
                i11++;
            }
        }
        return -1;
    }

    public int getCheckedButtonId() {
        if (!this.f36418h || this.f36421k.isEmpty()) {
            return -1;
        }
        return this.f36421k.iterator().next().intValue();
    }

    @NonNull
    public List<Integer> getCheckedButtonIds() {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            int id2 = f(i11).getId();
            if (this.f36421k.contains(Integer.valueOf(id2))) {
                arrayList.add(Integer.valueOf(id2));
            }
        }
        return arrayList;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i11, int i12) {
        Integer[] numArr = this.f36416f;
        if (numArr != null && i12 < numArr.length) {
            return numArr[i12].intValue();
        }
        Log.w("MButtonToggleGroup", "Child order wasn't updated");
        return i12;
    }

    @Nullable
    public final b h(int i11, int i12, int i13) {
        b bVar = this.f36412a.get(i11);
        if (i12 == i13) {
            return bVar;
        }
        boolean z11 = getOrientation() == 0;
        if (i11 == i12) {
            return z11 ? b.e(bVar, this) : b.f(bVar);
        }
        if (i11 == i13) {
            return z11 ? b.b(bVar, this) : b.a(bVar);
        }
        return null;
    }

    public final boolean i(int i11) {
        return getChildAt(i11).getVisibility() != 8;
    }

    public boolean isSelectionRequired() {
        return this.f36419i;
    }

    public boolean isSingleSelection() {
        return this.f36418h;
    }

    public void j(@NonNull MaterialButton materialButton, boolean z11) {
        if (this.f36417g) {
            return;
        }
        d(materialButton.getId(), z11);
    }

    public final void k(int i11) {
        if (getChildCount() == 0 || i11 == -1) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) f(i11).getLayoutParams();
        if (getOrientation() == 1) {
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
        } else {
            MarginLayoutParamsCompat.setMarginEnd(layoutParams, 0);
            MarginLayoutParamsCompat.setMarginStart(layoutParams, 0);
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
        }
    }

    public final void l(int i11, boolean z11) {
        View viewFindViewById = findViewById(i11);
        if (viewFindViewById instanceof MaterialButton) {
            this.f36417g = true;
            ((MaterialButton) viewFindViewById).setChecked(z11);
            this.f36417g = false;
        }
    }

    public final void n(Set<Integer> set) {
        Set<Integer> set2 = this.f36421k;
        this.f36421k = new HashSet(set);
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            int id2 = f(i11).getId();
            l(id2, set.contains(Integer.valueOf(id2)));
            if (set2.contains(Integer.valueOf(id2)) != set.contains(Integer.valueOf(id2))) {
                e(id2, set.contains(Integer.valueOf(id2)));
            }
        }
        invalidate();
    }

    public final void o() {
        TreeMap treeMap = new TreeMap(this.f36415d);
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            treeMap.put(f(i11), Integer.valueOf(i11));
        }
        this.f36416f = (Integer[]) treeMap.values().toArray(new Integer[0]);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        int i11 = this.f36420j;
        if (i11 != -1) {
            n(Collections.singleton(Integer.valueOf(i11)));
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, getVisibleButtonCount(), false, isSingleSelection() ? 1 : 2));
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i11, int i12) {
        p();
        b();
        super.onMeasure(i11, i12);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            ((MaterialButton) view).setOnPressedChangeListenerInternal(null);
        }
        int iIndexOfChild = indexOfChild(view);
        if (iIndexOfChild >= 0) {
            this.f36412a.remove(iIndexOfChild);
        }
        p();
        b();
    }

    public void p() {
        int childCount = getChildCount();
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        for (int i11 = 0; i11 < childCount; i11++) {
            MaterialButton materialButtonF = f(i11);
            if (materialButtonF.getVisibility() != 8) {
                n.b bVarV = materialButtonF.getShapeAppearanceModel().v();
                m(bVarV, h(i11, firstVisibleChildIndex, lastVisibleChildIndex));
                materialButtonF.setShapeAppearanceModel(bVarV.m());
            }
        }
    }

    public final void q() {
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            f(i11).setA11yClassName((this.f36418h ? RadioButton.class : ToggleButton.class).getName());
        }
    }

    public void removeOnButtonCheckedListener(@NonNull c cVar) {
        this.f36414c.remove(cVar);
    }

    @Override // android.view.View
    public void setEnabled(boolean z11) {
        super.setEnabled(z11);
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            f(i11).setEnabled(z11);
        }
    }

    public void setSelectionRequired(boolean z11) {
        this.f36419i = z11;
    }

    public void setSingleSelection(int i11) {
        setSingleSelection(getResources().getBoolean(i11));
    }

    public void setSingleSelection(boolean z11) {
        if (this.f36418h != z11) {
            this.f36418h = z11;
            clearChecked();
        }
        q();
    }

    public void uncheck(int i11) {
        d(i11, false);
    }
}
