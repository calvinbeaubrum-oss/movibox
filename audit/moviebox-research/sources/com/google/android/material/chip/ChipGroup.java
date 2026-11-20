package com.google.android.material.chip;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.FlowLayout;
import com.google.android.material.internal.b0;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class ChipGroup extends FlowLayout {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f36569l = R$style.Widget_MaterialComponents_ChipGroup;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f36570f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f36571g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public e f36572h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.google.android.material.internal.a<Chip> f36573i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f36574j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final f f36575k;

    /* JADX INFO: compiled from: source.java */
    public class a implements com.google.android.material.internal.a.b {
        public a() {
        }

        @Override // com.google.android.material.internal.a.b
        public void a(Set<Integer> set) {
            if (ChipGroup.this.f36572h != null) {
                e eVar = ChipGroup.this.f36572h;
                ChipGroup chipGroup = ChipGroup.this;
                eVar.a(chipGroup, chipGroup.f36573i.j(ChipGroup.this));
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements e {
        public b(d dVar) {
        }

        @Override // com.google.android.material.chip.ChipGroup.e
        public void a(@NonNull ChipGroup chipGroup, @NonNull List<Integer> list) {
            if (ChipGroup.this.f36573i.m()) {
                ChipGroup.this.getCheckedChipId();
                throw null;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c extends ViewGroup.MarginLayoutParams {
        public c(int i11, int i12) {
            super(i11, i12);
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Deprecated
    public interface d {
    }

    /* JADX INFO: compiled from: source.java */
    public interface e {
        void a(@NonNull ChipGroup chipGroup, @NonNull List<Integer> list);
    }

    /* JADX INFO: compiled from: source.java */
    public class f implements ViewGroup.OnHierarchyChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ViewGroup.OnHierarchyChangeListener f36578a;

        public f() {
        }

        public /* synthetic */ f(ChipGroup chipGroup, a aVar) {
            this();
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            if (view == ChipGroup.this && (view2 instanceof Chip)) {
                if (view2.getId() == -1) {
                    view2.setId(ViewCompat.generateViewId());
                }
                ChipGroup.this.f36573i.e((Chip) view2);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f36578a;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            ChipGroup chipGroup = ChipGroup.this;
            if (view == chipGroup && (view2 instanceof Chip)) {
                chipGroup.f36573i.o((Chip) view2);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f36578a;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    public ChipGroup(Context context) {
        this(context, null);
    }

    public ChipGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.chipGroupStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ChipGroup(Context context, AttributeSet attributeSet, int i11) {
        int i12 = f36569l;
        super(zi.a.c(context, attributeSet, i11, i12), attributeSet, i11);
        com.google.android.material.internal.a<Chip> aVar = new com.google.android.material.internal.a<>();
        this.f36573i = aVar;
        f fVar = new f(this, null);
        this.f36575k = fVar;
        TypedArray typedArrayI = b0.i(getContext(), attributeSet, R$styleable.ChipGroup, i11, i12, new int[0]);
        int dimensionPixelOffset = typedArrayI.getDimensionPixelOffset(R$styleable.ChipGroup_chipSpacing, 0);
        setChipSpacingHorizontal(typedArrayI.getDimensionPixelOffset(R$styleable.ChipGroup_chipSpacingHorizontal, dimensionPixelOffset));
        setChipSpacingVertical(typedArrayI.getDimensionPixelOffset(R$styleable.ChipGroup_chipSpacingVertical, dimensionPixelOffset));
        setSingleLine(typedArrayI.getBoolean(R$styleable.ChipGroup_singleLine, false));
        setSingleSelection(typedArrayI.getBoolean(R$styleable.ChipGroup_singleSelection, false));
        setSelectionRequired(typedArrayI.getBoolean(R$styleable.ChipGroup_selectionRequired, false));
        this.f36574j = typedArrayI.getResourceId(R$styleable.ChipGroup_checkedChip, -1);
        typedArrayI.recycle();
        aVar.p(new a());
        super.setOnHierarchyChangeListener(fVar);
        ViewCompat.setImportantForAccessibility(this, 1);
    }

    private int getVisibleChipCount() {
        int i11 = 0;
        for (int i12 = 0; i12 < getChildCount(); i12++) {
            if ((getChildAt(i12) instanceof Chip) && f(i12)) {
                i11++;
            }
        }
        return i11;
    }

    public void check(int i11) {
        this.f36573i.f(i11);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof c);
    }

    public void clearCheck() {
        this.f36573i.h();
    }

    public int e(@Nullable View view) {
        if (!(view instanceof Chip)) {
            return -1;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < getChildCount(); i12++) {
            View childAt = getChildAt(i12);
            if ((childAt instanceof Chip) && f(i12)) {
                if (((Chip) childAt) == view) {
                    return i11;
                }
                i11++;
            }
        }
        return -1;
    }

    public final boolean f(int i11) {
        return getChildAt(i11).getVisibility() == 0;
    }

    @Override // android.view.ViewGroup
    @NonNull
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new c(-2, -2);
    }

    @Override // android.view.ViewGroup
    @NonNull
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    @NonNull
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new c(layoutParams);
    }

    public int getCheckedChipId() {
        return this.f36573i.k();
    }

    @NonNull
    public List<Integer> getCheckedChipIds() {
        return this.f36573i.j(this);
    }

    public int getChipSpacingHorizontal() {
        return this.f36570f;
    }

    public int getChipSpacingVertical() {
        return this.f36571g;
    }

    public boolean isSelectionRequired() {
        return this.f36573i.l();
    }

    @Override // com.google.android.material.internal.FlowLayout
    public boolean isSingleLine() {
        return super.isSingleLine();
    }

    public boolean isSingleSelection() {
        return this.f36573i.m();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        int i11 = this.f36574j;
        if (i11 != -1) {
            this.f36573i.f(i11);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(getRowCount(), isSingleLine() ? getVisibleChipCount() : -1, false, isSingleSelection() ? 1 : 2));
    }

    public void setChipSpacing(int i11) {
        setChipSpacingHorizontal(i11);
        setChipSpacingVertical(i11);
    }

    public void setChipSpacingHorizontal(int i11) {
        if (this.f36570f != i11) {
            this.f36570f = i11;
            setItemSpacing(i11);
            requestLayout();
        }
    }

    public void setChipSpacingHorizontalResource(int i11) {
        setChipSpacingHorizontal(getResources().getDimensionPixelOffset(i11));
    }

    public void setChipSpacingResource(int i11) {
        setChipSpacing(getResources().getDimensionPixelOffset(i11));
    }

    public void setChipSpacingVertical(int i11) {
        if (this.f36571g != i11) {
            this.f36571g = i11;
            setLineSpacing(i11);
            requestLayout();
        }
    }

    public void setChipSpacingVerticalResource(int i11) {
        setChipSpacingVertical(getResources().getDimensionPixelOffset(i11));
    }

    @Deprecated
    public void setDividerDrawableHorizontal(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setDividerDrawableVertical(@Nullable Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setFlexWrap(int i11) {
        throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
    }

    @Deprecated
    public void setOnCheckedChangeListener(@Nullable d dVar) {
        if (dVar == null) {
            setOnCheckedStateChangeListener(null);
        } else {
            setOnCheckedStateChangeListener(new b(dVar));
        }
    }

    public void setOnCheckedStateChangeListener(@Nullable e eVar) {
        this.f36572h = eVar;
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f36575k.f36578a = onHierarchyChangeListener;
    }

    public void setSelectionRequired(boolean z11) {
        this.f36573i.q(z11);
    }

    @Deprecated
    public void setShowDividerHorizontal(int i11) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setShowDividerVertical(int i11) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    public void setSingleLine(int i11) {
        setSingleLine(getResources().getBoolean(i11));
    }

    @Override // com.google.android.material.internal.FlowLayout
    public void setSingleLine(boolean z11) {
        super.setSingleLine(z11);
    }

    public void setSingleSelection(int i11) {
        setSingleSelection(getResources().getBoolean(i11));
    }

    public void setSingleSelection(boolean z11) {
        this.f36573i.r(z11);
    }
}
