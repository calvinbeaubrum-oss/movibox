package com.google.android.material.navigation;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.n0;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$dimen;
import com.google.android.material.R$styleable;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.b0;
import g1.g;
import yi.i;
import yi.j;
import yi.n;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class NavigationBarView extends FrameLayout {
    public static final int LABEL_VISIBILITY_AUTO = -1;
    public static final int LABEL_VISIBILITY_LABELED = 1;
    public static final int LABEL_VISIBILITY_SELECTED = 0;
    public static final int LABEL_VISIBILITY_UNLABELED = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final d f37195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final NavigationBarMenuView f37196b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final NavigationBarPresenter f37197c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public MenuInflater f37198d;

    /* JADX INFO: compiled from: source.java */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public Bundle f37199a;

        /* JADX INFO: compiled from: source.java */
        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            @Nullable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            @NonNull
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i11) {
                return new SavedState[i11];
            }
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            a(parcel, classLoader == null ? getClass().getClassLoader() : classLoader);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public final void a(@NonNull Parcel parcel, ClassLoader classLoader) {
            this.f37199a = parcel.readBundle(classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeBundle(this.f37199a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a implements androidx.appcompat.view.menu.f.a {
        public a() {
        }

        @Override // androidx.appcompat.view.menu.f.a
        public boolean a(androidx.appcompat.view.menu.f fVar, @NonNull MenuItem menuItem) {
            NavigationBarView.a(NavigationBarView.this);
            NavigationBarView.b(NavigationBarView.this);
            return false;
        }

        @Override // androidx.appcompat.view.menu.f.a
        public void b(androidx.appcompat.view.menu.f fVar) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
    }

    /* JADX INFO: compiled from: source.java */
    public interface c {
    }

    public NavigationBarView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11, int i12) {
        super(zi.a.c(context, attributeSet, i11, i12), attributeSet, i11);
        NavigationBarPresenter navigationBarPresenter = new NavigationBarPresenter();
        this.f37197c = navigationBarPresenter;
        Context context2 = getContext();
        n0 n0VarJ = b0.j(context2, attributeSet, R$styleable.NavigationBarView, i11, i12, R$styleable.NavigationBarView_itemTextAppearanceInactive, R$styleable.NavigationBarView_itemTextAppearanceActive);
        d dVar = new d(context2, getClass(), getMaxItemCount());
        this.f37195a = dVar;
        NavigationBarMenuView navigationBarMenuViewC = c(context2);
        this.f37196b = navigationBarMenuViewC;
        navigationBarPresenter.l(navigationBarMenuViewC);
        navigationBarPresenter.a(1);
        navigationBarMenuViewC.setPresenter(navigationBarPresenter);
        dVar.b(navigationBarPresenter);
        navigationBarPresenter.k(getContext(), dVar);
        if (n0VarJ.s(R$styleable.NavigationBarView_itemIconTint)) {
            navigationBarMenuViewC.setIconTintList(n0VarJ.c(R$styleable.NavigationBarView_itemIconTint));
        } else {
            navigationBarMenuViewC.setIconTintList(navigationBarMenuViewC.createDefaultColorStateList(R.attr.textColorSecondary));
        }
        setItemIconSize(n0VarJ.f(R$styleable.NavigationBarView_itemIconSize, getResources().getDimensionPixelSize(R$dimen.mtrl_navigation_bar_item_default_icon_size)));
        if (n0VarJ.s(R$styleable.NavigationBarView_itemTextAppearanceInactive)) {
            setItemTextAppearanceInactive(n0VarJ.n(R$styleable.NavigationBarView_itemTextAppearanceInactive, 0));
        }
        if (n0VarJ.s(R$styleable.NavigationBarView_itemTextAppearanceActive)) {
            setItemTextAppearanceActive(n0VarJ.n(R$styleable.NavigationBarView_itemTextAppearanceActive, 0));
        }
        setItemTextAppearanceActiveBoldEnabled(n0VarJ.a(R$styleable.NavigationBarView_itemTextAppearanceActiveBoldEnabled, true));
        if (n0VarJ.s(R$styleable.NavigationBarView_itemTextColor)) {
            setItemTextColor(n0VarJ.c(R$styleable.NavigationBarView_itemTextColor));
        }
        Drawable background = getBackground();
        ColorStateList colorStateListG = oi.f.g(background);
        if (background == null || colorStateListG != null) {
            i iVar = new i(n.e(context2, attributeSet, i11, i12).m());
            if (colorStateListG != null) {
                iVar.d0(colorStateListG);
            }
            iVar.S(context2);
            ViewCompat.setBackground(this, iVar);
        }
        if (n0VarJ.s(R$styleable.NavigationBarView_itemPaddingTop)) {
            setItemPaddingTop(n0VarJ.f(R$styleable.NavigationBarView_itemPaddingTop, 0));
        }
        if (n0VarJ.s(R$styleable.NavigationBarView_itemPaddingBottom)) {
            setItemPaddingBottom(n0VarJ.f(R$styleable.NavigationBarView_itemPaddingBottom, 0));
        }
        if (n0VarJ.s(R$styleable.NavigationBarView_activeIndicatorLabelPadding)) {
            setActiveIndicatorLabelPadding(n0VarJ.f(R$styleable.NavigationBarView_activeIndicatorLabelPadding, 0));
        }
        if (n0VarJ.s(R$styleable.NavigationBarView_elevation)) {
            setElevation(n0VarJ.f(R$styleable.NavigationBarView_elevation, 0));
        }
        d3.a.o(getBackground().mutate(), vi.d.b(context2, n0VarJ, R$styleable.NavigationBarView_backgroundTint));
        setLabelVisibilityMode(n0VarJ.l(R$styleable.NavigationBarView_labelVisibilityMode, -1));
        int iN = n0VarJ.n(R$styleable.NavigationBarView_itemBackground, 0);
        if (iN != 0) {
            navigationBarMenuViewC.setItemBackgroundRes(iN);
        } else {
            setItemRippleColor(vi.d.b(context2, n0VarJ, R$styleable.NavigationBarView_itemRippleColor));
        }
        int iN2 = n0VarJ.n(R$styleable.NavigationBarView_itemActiveIndicatorStyle, 0);
        if (iN2 != 0) {
            setItemActiveIndicatorEnabled(true);
            TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(iN2, R$styleable.NavigationBarActiveIndicator);
            setItemActiveIndicatorWidth(typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.NavigationBarActiveIndicator_android_width, 0));
            setItemActiveIndicatorHeight(typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.NavigationBarActiveIndicator_android_height, 0));
            setItemActiveIndicatorMarginHorizontal(typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.NavigationBarActiveIndicator_marginHorizontal, 0));
            setItemActiveIndicatorColor(vi.d.a(context2, typedArrayObtainStyledAttributes, R$styleable.NavigationBarActiveIndicator_android_color));
            setItemActiveIndicatorShapeAppearance(n.b(context2, typedArrayObtainStyledAttributes.getResourceId(R$styleable.NavigationBarActiveIndicator_shapeAppearance, 0), 0).m());
            typedArrayObtainStyledAttributes.recycle();
        }
        if (n0VarJ.s(R$styleable.NavigationBarView_menu)) {
            inflateMenu(n0VarJ.n(R$styleable.NavigationBarView_menu, 0));
        }
        n0VarJ.x();
        addView(navigationBarMenuViewC);
        dVar.W(new a());
    }

    public static /* synthetic */ b a(NavigationBarView navigationBarView) {
        navigationBarView.getClass();
        return null;
    }

    public static /* synthetic */ c b(NavigationBarView navigationBarView) {
        navigationBarView.getClass();
        return null;
    }

    private MenuInflater getMenuInflater() {
        if (this.f37198d == null) {
            this.f37198d = new g(getContext());
        }
        return this.f37198d;
    }

    @NonNull
    public abstract NavigationBarMenuView c(@NonNull Context context);

    public int getActiveIndicatorLabelPadding() {
        return this.f37196b.getActiveIndicatorLabelPadding();
    }

    @Nullable
    public BadgeDrawable getBadge(int i11) {
        return this.f37196b.getBadge(i11);
    }

    @Nullable
    public ColorStateList getItemActiveIndicatorColor() {
        return this.f37196b.getItemActiveIndicatorColor();
    }

    public int getItemActiveIndicatorHeight() {
        return this.f37196b.getItemActiveIndicatorHeight();
    }

    public int getItemActiveIndicatorMarginHorizontal() {
        return this.f37196b.getItemActiveIndicatorMarginHorizontal();
    }

    @Nullable
    public n getItemActiveIndicatorShapeAppearance() {
        return this.f37196b.getItemActiveIndicatorShapeAppearance();
    }

    public int getItemActiveIndicatorWidth() {
        return this.f37196b.getItemActiveIndicatorWidth();
    }

    @Nullable
    public Drawable getItemBackground() {
        return this.f37196b.getItemBackground();
    }

    @Deprecated
    public int getItemBackgroundResource() {
        return this.f37196b.getItemBackgroundRes();
    }

    public int getItemIconSize() {
        return this.f37196b.getItemIconSize();
    }

    @Nullable
    public ColorStateList getItemIconTintList() {
        return this.f37196b.getIconTintList();
    }

    public int getItemPaddingBottom() {
        return this.f37196b.getItemPaddingBottom();
    }

    public int getItemPaddingTop() {
        return this.f37196b.getItemPaddingTop();
    }

    @Nullable
    public ColorStateList getItemRippleColor() {
        return this.f37196b.getItemRippleColor();
    }

    public int getItemTextAppearanceActive() {
        return this.f37196b.getItemTextAppearanceActive();
    }

    public int getItemTextAppearanceInactive() {
        return this.f37196b.getItemTextAppearanceInactive();
    }

    @Nullable
    public ColorStateList getItemTextColor() {
        return this.f37196b.getItemTextColor();
    }

    public int getLabelVisibilityMode() {
        return this.f37196b.getLabelVisibilityMode();
    }

    public abstract int getMaxItemCount();

    @NonNull
    public Menu getMenu() {
        return this.f37195a;
    }

    @NonNull
    public m getMenuView() {
        return this.f37196b;
    }

    @NonNull
    public BadgeDrawable getOrCreateBadge(int i11) {
        return this.f37196b.e(i11);
    }

    @NonNull
    public NavigationBarPresenter getPresenter() {
        return this.f37197c;
    }

    public int getSelectedItemId() {
        return this.f37196b.getSelectedItemId();
    }

    public void inflateMenu(int i11) {
        this.f37197c.m(true);
        getMenuInflater().inflate(i11, this.f37195a);
        this.f37197c.m(false);
        this.f37197c.h(true);
    }

    public boolean isItemActiveIndicatorEnabled() {
        return this.f37196b.getItemActiveIndicatorEnabled();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        j.e(this);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f37195a.T(savedState.f37199a);
    }

    @Override // android.view.View
    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        savedState.f37199a = bundle;
        this.f37195a.V(bundle);
        return savedState;
    }

    public void removeBadge(int i11) {
        this.f37196b.h(i11);
    }

    public void setActiveIndicatorLabelPadding(int i11) {
        this.f37196b.setActiveIndicatorLabelPadding(i11);
    }

    @Override // android.view.View
    public void setElevation(float f11) {
        super.setElevation(f11);
        j.d(this, f11);
    }

    public void setItemActiveIndicatorColor(@Nullable ColorStateList colorStateList) {
        this.f37196b.setItemActiveIndicatorColor(colorStateList);
    }

    public void setItemActiveIndicatorEnabled(boolean z11) {
        this.f37196b.setItemActiveIndicatorEnabled(z11);
    }

    public void setItemActiveIndicatorHeight(int i11) {
        this.f37196b.setItemActiveIndicatorHeight(i11);
    }

    public void setItemActiveIndicatorMarginHorizontal(int i11) {
        this.f37196b.setItemActiveIndicatorMarginHorizontal(i11);
    }

    public void setItemActiveIndicatorShapeAppearance(@Nullable n nVar) {
        this.f37196b.setItemActiveIndicatorShapeAppearance(nVar);
    }

    public void setItemActiveIndicatorWidth(int i11) {
        this.f37196b.setItemActiveIndicatorWidth(i11);
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        this.f37196b.setItemBackground(drawable);
    }

    public void setItemBackgroundResource(int i11) {
        this.f37196b.setItemBackgroundRes(i11);
    }

    public void setItemIconSize(int i11) {
        this.f37196b.setItemIconSize(i11);
    }

    public void setItemIconSizeRes(int i11) {
        setItemIconSize(getResources().getDimensionPixelSize(i11));
    }

    public void setItemIconTintList(@Nullable ColorStateList colorStateList) {
        this.f37196b.setIconTintList(colorStateList);
    }

    public void setItemOnTouchListener(int i11, @Nullable View.OnTouchListener onTouchListener) {
        this.f37196b.setItemOnTouchListener(i11, onTouchListener);
    }

    public void setItemPaddingBottom(int i11) {
        this.f37196b.setItemPaddingBottom(i11);
    }

    public void setItemPaddingTop(int i11) {
        this.f37196b.setItemPaddingTop(i11);
    }

    public void setItemRippleColor(@Nullable ColorStateList colorStateList) {
        this.f37196b.setItemRippleColor(colorStateList);
    }

    public void setItemTextAppearanceActive(int i11) {
        this.f37196b.setItemTextAppearanceActive(i11);
    }

    public void setItemTextAppearanceActiveBoldEnabled(boolean z11) {
        this.f37196b.setItemTextAppearanceActiveBoldEnabled(z11);
    }

    public void setItemTextAppearanceInactive(int i11) {
        this.f37196b.setItemTextAppearanceInactive(i11);
    }

    public void setItemTextColor(@Nullable ColorStateList colorStateList) {
        this.f37196b.setItemTextColor(colorStateList);
    }

    public void setLabelVisibilityMode(int i11) {
        if (this.f37196b.getLabelVisibilityMode() != i11) {
            this.f37196b.setLabelVisibilityMode(i11);
            this.f37197c.h(false);
        }
    }

    public void setOnItemReselectedListener(@Nullable b bVar) {
    }

    public void setOnItemSelectedListener(@Nullable c cVar) {
    }

    public void setSelectedItemId(int i11) {
        MenuItem menuItemFindItem = this.f37195a.findItem(i11);
        if (menuItemFindItem == null || this.f37195a.P(menuItemFindItem, this.f37197c, 0)) {
            return;
        }
        menuItemFindItem.setChecked(true);
    }
}
