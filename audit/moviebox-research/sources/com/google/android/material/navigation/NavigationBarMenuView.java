package com.google.android.material.navigation;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.m;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$integer;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.z;
import java.util.HashSet;
import k6.s;
import k6.u;
import ti.j;
import yi.i;
import yi.n;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class NavigationBarMenuView extends ViewGroup implements m {
    public static final int[] G = {R.attr.state_checked};
    public static final int[] H = {-16842910};
    public int A;
    public n B;
    public boolean C;
    public ColorStateList D;
    public NavigationBarPresenter E;
    public androidx.appcompat.view.menu.f F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final u f37163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final View.OnClickListener f37164b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final androidx.core.util.f<NavigationBarItemView> f37165c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final SparseArray<View.OnTouchListener> f37166d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f37167f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public NavigationBarItemView[] f37168g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f37169h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f37170i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public ColorStateList f37171j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f37172k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ColorStateList f37173l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    public final ColorStateList f37174m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f37175n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f37176o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f37177p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Drawable f37178q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Nullable
    public ColorStateList f37179r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f37180s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @NonNull
    public final SparseArray<BadgeDrawable> f37181t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f37182u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f37183v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f37184w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f37185x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f37186y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f37187z;

    /* JADX INFO: compiled from: source.java */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h itemData = ((NavigationBarItemView) view).getItemData();
            if (NavigationBarMenuView.this.F.P(itemData, NavigationBarMenuView.this.E, 0)) {
                return;
            }
            itemData.setChecked(true);
        }
    }

    public NavigationBarMenuView(@NonNull Context context) {
        super(context);
        this.f37165c = new androidx.core.util.h(5);
        this.f37166d = new SparseArray<>(5);
        this.f37169h = 0;
        this.f37170i = 0;
        this.f37181t = new SparseArray<>(5);
        this.f37182u = -1;
        this.f37183v = -1;
        this.f37184w = -1;
        this.C = false;
        this.f37174m = createDefaultColorStateList(R.attr.textColorSecondary);
        if (isInEditMode()) {
            this.f37163a = null;
        } else {
            k6.a aVar = new k6.a();
            this.f37163a = aVar;
            aVar.s0(0);
            aVar.a0(j.f(getContext(), R$attr.motionDurationMedium4, getResources().getInteger(R$integer.material_motion_duration_long_1)));
            aVar.c0(j.g(getContext(), R$attr.motionEasingStandard, ii.b.f67202b));
            aVar.k0(new z());
        }
        this.f37164b = new a();
        ViewCompat.setImportantForAccessibility(this, 1);
    }

    private NavigationBarItemView getNewItem() {
        NavigationBarItemView navigationBarItemViewAcquire = this.f37165c.acquire();
        return navigationBarItemViewAcquire == null ? d(getContext()) : navigationBarItemViewAcquire;
    }

    private void setBadgeIfNeeded(@NonNull NavigationBarItemView navigationBarItemView) {
        BadgeDrawable badgeDrawable;
        int id2 = navigationBarItemView.getId();
        if (g(id2) && (badgeDrawable = this.f37181t.get(id2)) != null) {
            navigationBarItemView.setBadge(badgeDrawable);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void buildMenuView() {
        removeAllViews();
        NavigationBarItemView[] navigationBarItemViewArr = this.f37168g;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                if (navigationBarItemView != null) {
                    this.f37165c.release(navigationBarItemView);
                    navigationBarItemView.f();
                }
            }
        }
        if (this.F.size() == 0) {
            this.f37169h = 0;
            this.f37170i = 0;
            this.f37168g = null;
            return;
        }
        i();
        this.f37168g = new NavigationBarItemView[this.F.size()];
        boolean zF = f(this.f37167f, this.F.G().size());
        for (int i11 = 0; i11 < this.F.size(); i11++) {
            this.E.m(true);
            this.F.getItem(i11).setCheckable(true);
            this.E.m(false);
            NavigationBarItemView newItem = getNewItem();
            this.f37168g[i11] = newItem;
            newItem.setIconTintList(this.f37171j);
            newItem.setIconSize(this.f37172k);
            newItem.setTextColor(this.f37174m);
            newItem.setTextAppearanceInactive(this.f37175n);
            newItem.setTextAppearanceActive(this.f37176o);
            newItem.setTextAppearanceActiveBoldEnabled(this.f37177p);
            newItem.setTextColor(this.f37173l);
            int i12 = this.f37182u;
            if (i12 != -1) {
                newItem.setItemPaddingTop(i12);
            }
            int i13 = this.f37183v;
            if (i13 != -1) {
                newItem.setItemPaddingBottom(i13);
            }
            int i14 = this.f37184w;
            if (i14 != -1) {
                newItem.setActiveIndicatorLabelPadding(i14);
            }
            newItem.setActiveIndicatorWidth(this.f37186y);
            newItem.setActiveIndicatorHeight(this.f37187z);
            newItem.setActiveIndicatorMarginHorizontal(this.A);
            newItem.setActiveIndicatorDrawable(c());
            newItem.setActiveIndicatorResizeable(this.C);
            newItem.setActiveIndicatorEnabled(this.f37185x);
            Drawable drawable = this.f37178q;
            if (drawable != null) {
                newItem.setItemBackground(drawable);
            } else {
                newItem.setItemBackground(this.f37180s);
            }
            newItem.setItemRippleColor(this.f37179r);
            newItem.setShifting(zF);
            newItem.setLabelVisibilityMode(this.f37167f);
            h hVar = (h) this.F.getItem(i11);
            newItem.initialize(hVar, 0);
            newItem.setItemPosition(i11);
            int itemId = hVar.getItemId();
            newItem.setOnTouchListener(this.f37166d.get(itemId));
            newItem.setOnClickListener(this.f37164b);
            int i15 = this.f37169h;
            if (i15 != 0 && itemId == i15) {
                this.f37170i = i11;
            }
            setBadgeIfNeeded(newItem);
            addView(newItem);
        }
        int iMin = Math.min(this.F.size() - 1, this.f37170i);
        this.f37170i = iMin;
        this.F.getItem(iMin).setChecked(true);
    }

    @Nullable
    public final Drawable c() {
        if (this.B == null || this.D == null) {
            return null;
        }
        i iVar = new i(this.B);
        iVar.d0(this.D);
        return iVar;
    }

    @Nullable
    public ColorStateList createDefaultColorStateList(int i11) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i11, typedValue, true)) {
            return null;
        }
        ColorStateList colorStateListA = d1.a.a(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(androidx.appcompat.R$attr.colorPrimary, typedValue, true)) {
            return null;
        }
        int i12 = typedValue.data;
        int defaultColor = colorStateListA.getDefaultColor();
        int[] iArr = H;
        return new ColorStateList(new int[][]{iArr, G, ViewGroup.EMPTY_STATE_SET}, new int[]{colorStateListA.getColorForState(iArr, defaultColor), i12, defaultColor});
    }

    @NonNull
    public abstract NavigationBarItemView d(@NonNull Context context);

    public BadgeDrawable e(int i11) {
        l(i11);
        BadgeDrawable badgeDrawableD = this.f37181t.get(i11);
        if (badgeDrawableD == null) {
            badgeDrawableD = BadgeDrawable.d(getContext());
            this.f37181t.put(i11, badgeDrawableD);
        }
        NavigationBarItemView navigationBarItemViewFindItemView = findItemView(i11);
        if (navigationBarItemViewFindItemView != null) {
            navigationBarItemViewFindItemView.setBadge(badgeDrawableD);
        }
        return badgeDrawableD;
    }

    public boolean f(int i11, int i12) {
        if (i11 == -1) {
            if (i12 <= 3) {
                return false;
            }
        } else if (i11 != 0) {
            return false;
        }
        return true;
    }

    @Nullable
    public NavigationBarItemView findItemView(int i11) {
        l(i11);
        NavigationBarItemView[] navigationBarItemViewArr = this.f37168g;
        if (navigationBarItemViewArr == null) {
            return null;
        }
        for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
            if (navigationBarItemView.getId() == i11) {
                return navigationBarItemView;
            }
        }
        return null;
    }

    public final boolean g(int i11) {
        return i11 != -1;
    }

    public int getActiveIndicatorLabelPadding() {
        return this.f37184w;
    }

    @Nullable
    public BadgeDrawable getBadge(int i11) {
        return this.f37181t.get(i11);
    }

    public SparseArray<BadgeDrawable> getBadgeDrawables() {
        return this.f37181t;
    }

    @Nullable
    public ColorStateList getIconTintList() {
        return this.f37171j;
    }

    @Nullable
    public ColorStateList getItemActiveIndicatorColor() {
        return this.D;
    }

    public boolean getItemActiveIndicatorEnabled() {
        return this.f37185x;
    }

    public int getItemActiveIndicatorHeight() {
        return this.f37187z;
    }

    public int getItemActiveIndicatorMarginHorizontal() {
        return this.A;
    }

    @Nullable
    public n getItemActiveIndicatorShapeAppearance() {
        return this.B;
    }

    public int getItemActiveIndicatorWidth() {
        return this.f37186y;
    }

    @Nullable
    public Drawable getItemBackground() {
        NavigationBarItemView[] navigationBarItemViewArr = this.f37168g;
        return (navigationBarItemViewArr == null || navigationBarItemViewArr.length <= 0) ? this.f37178q : navigationBarItemViewArr[0].getBackground();
    }

    @Deprecated
    public int getItemBackgroundRes() {
        return this.f37180s;
    }

    public int getItemIconSize() {
        return this.f37172k;
    }

    public int getItemPaddingBottom() {
        return this.f37183v;
    }

    public int getItemPaddingTop() {
        return this.f37182u;
    }

    @Nullable
    public ColorStateList getItemRippleColor() {
        return this.f37179r;
    }

    public int getItemTextAppearanceActive() {
        return this.f37176o;
    }

    public int getItemTextAppearanceInactive() {
        return this.f37175n;
    }

    @Nullable
    public ColorStateList getItemTextColor() {
        return this.f37173l;
    }

    public int getLabelVisibilityMode() {
        return this.f37167f;
    }

    @Nullable
    public androidx.appcompat.view.menu.f getMenu() {
        return this.F;
    }

    public int getSelectedItemId() {
        return this.f37169h;
    }

    public int getSelectedItemPosition() {
        return this.f37170i;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public void h(int i11) {
        l(i11);
        NavigationBarItemView navigationBarItemViewFindItemView = findItemView(i11);
        if (navigationBarItemViewFindItemView != null) {
            navigationBarItemViewFindItemView.n();
        }
        this.f37181t.put(i11, null);
    }

    public final void i() {
        HashSet hashSet = new HashSet();
        for (int i11 = 0; i11 < this.F.size(); i11++) {
            hashSet.add(Integer.valueOf(this.F.getItem(i11).getItemId()));
        }
        for (int i12 = 0; i12 < this.f37181t.size(); i12++) {
            int iKeyAt = this.f37181t.keyAt(i12);
            if (!hashSet.contains(Integer.valueOf(iKeyAt))) {
                this.f37181t.delete(iKeyAt);
            }
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public void initialize(@NonNull androidx.appcompat.view.menu.f fVar) {
        this.F = fVar;
    }

    public void j(SparseArray<BadgeDrawable> sparseArray) {
        for (int i11 = 0; i11 < sparseArray.size(); i11++) {
            int iKeyAt = sparseArray.keyAt(i11);
            if (this.f37181t.indexOfKey(iKeyAt) < 0) {
                this.f37181t.append(iKeyAt, sparseArray.get(iKeyAt));
            }
        }
        NavigationBarItemView[] navigationBarItemViewArr = this.f37168g;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                BadgeDrawable badgeDrawable = this.f37181t.get(navigationBarItemView.getId());
                if (badgeDrawable != null) {
                    navigationBarItemView.setBadge(badgeDrawable);
                }
            }
        }
    }

    public void k(int i11) {
        int size = this.F.size();
        for (int i12 = 0; i12 < size; i12++) {
            MenuItem item = this.F.getItem(i12);
            if (i11 == item.getItemId()) {
                this.f37169h = i11;
                this.f37170i = i12;
                item.setChecked(true);
                return;
            }
        }
    }

    public final void l(int i11) {
        if (g(i11)) {
            return;
        }
        throw new IllegalArgumentException(i11 + " is not a valid view id");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, this.F.G().size(), false, 1));
    }

    public void setActiveIndicatorLabelPadding(int i11) {
        this.f37184w = i11;
        NavigationBarItemView[] navigationBarItemViewArr = this.f37168g;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorLabelPadding(i11);
            }
        }
    }

    public void setIconTintList(@Nullable ColorStateList colorStateList) {
        this.f37171j = colorStateList;
        NavigationBarItemView[] navigationBarItemViewArr = this.f37168g;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setIconTintList(colorStateList);
            }
        }
    }

    public void setItemActiveIndicatorColor(@Nullable ColorStateList colorStateList) {
        this.D = colorStateList;
        NavigationBarItemView[] navigationBarItemViewArr = this.f37168g;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorDrawable(c());
            }
        }
    }

    public void setItemActiveIndicatorEnabled(boolean z11) {
        this.f37185x = z11;
        NavigationBarItemView[] navigationBarItemViewArr = this.f37168g;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorEnabled(z11);
            }
        }
    }

    public void setItemActiveIndicatorHeight(int i11) {
        this.f37187z = i11;
        NavigationBarItemView[] navigationBarItemViewArr = this.f37168g;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorHeight(i11);
            }
        }
    }

    public void setItemActiveIndicatorMarginHorizontal(int i11) {
        this.A = i11;
        NavigationBarItemView[] navigationBarItemViewArr = this.f37168g;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorMarginHorizontal(i11);
            }
        }
    }

    public void setItemActiveIndicatorResizeable(boolean z11) {
        this.C = z11;
        NavigationBarItemView[] navigationBarItemViewArr = this.f37168g;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorResizeable(z11);
            }
        }
    }

    public void setItemActiveIndicatorShapeAppearance(@Nullable n nVar) {
        this.B = nVar;
        NavigationBarItemView[] navigationBarItemViewArr = this.f37168g;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorDrawable(c());
            }
        }
    }

    public void setItemActiveIndicatorWidth(int i11) {
        this.f37186y = i11;
        NavigationBarItemView[] navigationBarItemViewArr = this.f37168g;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorWidth(i11);
            }
        }
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        this.f37178q = drawable;
        NavigationBarItemView[] navigationBarItemViewArr = this.f37168g;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setItemBackground(drawable);
            }
        }
    }

    public void setItemBackgroundRes(int i11) {
        this.f37180s = i11;
        NavigationBarItemView[] navigationBarItemViewArr = this.f37168g;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setItemBackground(i11);
            }
        }
    }

    public void setItemIconSize(int i11) {
        this.f37172k = i11;
        NavigationBarItemView[] navigationBarItemViewArr = this.f37168g;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setIconSize(i11);
            }
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void setItemOnTouchListener(int i11, @Nullable View.OnTouchListener onTouchListener) {
        if (onTouchListener == null) {
            this.f37166d.remove(i11);
        } else {
            this.f37166d.put(i11, onTouchListener);
        }
        NavigationBarItemView[] navigationBarItemViewArr = this.f37168g;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                if (navigationBarItemView.getItemData().getItemId() == i11) {
                    navigationBarItemView.setOnTouchListener(onTouchListener);
                }
            }
        }
    }

    public void setItemPaddingBottom(int i11) {
        this.f37183v = i11;
        NavigationBarItemView[] navigationBarItemViewArr = this.f37168g;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setItemPaddingBottom(i11);
            }
        }
    }

    public void setItemPaddingTop(int i11) {
        this.f37182u = i11;
        NavigationBarItemView[] navigationBarItemViewArr = this.f37168g;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setItemPaddingTop(i11);
            }
        }
    }

    public void setItemRippleColor(@Nullable ColorStateList colorStateList) {
        this.f37179r = colorStateList;
        NavigationBarItemView[] navigationBarItemViewArr = this.f37168g;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setItemRippleColor(colorStateList);
            }
        }
    }

    public void setItemTextAppearanceActive(int i11) {
        this.f37176o = i11;
        NavigationBarItemView[] navigationBarItemViewArr = this.f37168g;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setTextAppearanceActive(i11);
                ColorStateList colorStateList = this.f37173l;
                if (colorStateList != null) {
                    navigationBarItemView.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextAppearanceActiveBoldEnabled(boolean z11) {
        this.f37177p = z11;
        NavigationBarItemView[] navigationBarItemViewArr = this.f37168g;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setTextAppearanceActiveBoldEnabled(z11);
            }
        }
    }

    public void setItemTextAppearanceInactive(int i11) {
        this.f37175n = i11;
        NavigationBarItemView[] navigationBarItemViewArr = this.f37168g;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setTextAppearanceInactive(i11);
                ColorStateList colorStateList = this.f37173l;
                if (colorStateList != null) {
                    navigationBarItemView.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextColor(@Nullable ColorStateList colorStateList) {
        this.f37173l = colorStateList;
        NavigationBarItemView[] navigationBarItemViewArr = this.f37168g;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setTextColor(colorStateList);
            }
        }
    }

    public void setLabelVisibilityMode(int i11) {
        this.f37167f = i11;
    }

    public void setPresenter(@NonNull NavigationBarPresenter navigationBarPresenter) {
        this.E = navigationBarPresenter;
    }

    public void updateMenuView() {
        u uVar;
        androidx.appcompat.view.menu.f fVar = this.F;
        if (fVar == null || this.f37168g == null) {
            return;
        }
        int size = fVar.size();
        if (size != this.f37168g.length) {
            buildMenuView();
            return;
        }
        int i11 = this.f37169h;
        for (int i12 = 0; i12 < size; i12++) {
            MenuItem item = this.F.getItem(i12);
            if (item.isChecked()) {
                this.f37169h = item.getItemId();
                this.f37170i = i12;
            }
        }
        if (i11 != this.f37169h && (uVar = this.f37163a) != null) {
            s.a(this, uVar);
        }
        boolean zF = f(this.f37167f, this.F.G().size());
        for (int i13 = 0; i13 < size; i13++) {
            this.E.m(true);
            this.f37168g[i13].setLabelVisibilityMode(this.f37167f);
            this.f37168g[i13].setShifting(zF);
            this.f37168g[i13].initialize((h) this.F.getItem(i13), 0);
            this.E.m(false);
        }
    }
}
