package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$attr;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.s0;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R$dimen;
import com.google.android.material.R$drawable;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class NavigationMenuItemView extends ForegroundLinearLayout implements androidx.appcompat.view.menu.m.a {
    public static final int[] H = {R.attr.state_checked};
    public final CheckedTextView A;
    public FrameLayout B;
    public androidx.appcompat.view.menu.h C;
    public ColorStateList D;
    public boolean E;
    public Drawable F;
    public final AccessibilityDelegateCompat G;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f36939w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f36940x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f36941y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f36942z;

    /* JADX INFO: compiled from: source.java */
    public class a extends AccessibilityDelegateCompat {
        public a() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setCheckable(NavigationMenuItemView.this.f36941y);
        }
    }

    public NavigationMenuItemView(@NonNull Context context) {
        this(context, null);
    }

    public NavigationMenuItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f36942z = true;
        a aVar = new a();
        this.G = aVar;
        setOrientation(0);
        LayoutInflater.from(context).inflate(R$layout.design_navigation_menu_item, (ViewGroup) this, true);
        setIconSize(context.getResources().getDimensionPixelSize(R$dimen.design_navigation_icon_size));
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(R$id.design_menu_item_text);
        this.A = checkedTextView;
        checkedTextView.setDuplicateParentStateEnabled(true);
        ViewCompat.setAccessibilityDelegate(checkedTextView, aVar);
    }

    private void setActionView(@Nullable View view) {
        if (view != null) {
            if (this.B == null) {
                this.B = (FrameLayout) ((ViewStub) findViewById(R$id.design_menu_item_action_area_stub)).inflate();
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.B.removeAllViews();
            this.B.addView(view);
        }
    }

    @Override // androidx.appcompat.view.menu.m.a
    public androidx.appcompat.view.menu.h getItemData() {
        return this.C;
    }

    @Override // androidx.appcompat.view.menu.m.a
    public void initialize(@NonNull androidx.appcompat.view.menu.h hVar, int i11) {
        this.C = hVar;
        if (hVar.getItemId() > 0) {
            setId(hVar.getItemId());
        }
        setVisibility(hVar.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            ViewCompat.setBackground(this, v());
        }
        setCheckable(hVar.isCheckable());
        setChecked(hVar.isChecked());
        setEnabled(hVar.isEnabled());
        setTitle(hVar.getTitle());
        setIcon(hVar.getIcon());
        setActionView(hVar.getActionView());
        setContentDescription(hVar.getContentDescription());
        s0.a(this, hVar.getTooltipText());
        u();
    }

    public void initialize(@NonNull androidx.appcompat.view.menu.h hVar, boolean z11) {
        this.f36942z = z11;
        initialize(hVar, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i11) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i11 + 1);
        androidx.appcompat.view.menu.h hVar = this.C;
        if (hVar != null && hVar.isCheckable() && this.C.isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, H);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // androidx.appcompat.view.menu.m.a
    public boolean prefersCondensedTitle() {
        return false;
    }

    public void recycle() {
        FrameLayout frameLayout = this.B;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        this.A.setCompoundDrawables(null, null, null, null);
    }

    public void setCheckable(boolean z11) {
        refreshDrawableState();
        if (this.f36941y != z11) {
            this.f36941y = z11;
            this.G.sendAccessibilityEvent(this.A, 2048);
        }
    }

    public void setChecked(boolean z11) {
        refreshDrawableState();
        this.A.setChecked(z11);
        CheckedTextView checkedTextView = this.A;
        checkedTextView.setTypeface(checkedTextView.getTypeface(), (z11 && this.f36942z) ? 1 : 0);
    }

    public void setHorizontalPadding(int i11) {
        setPadding(i11, getPaddingTop(), i11, getPaddingBottom());
    }

    public void setIcon(@Nullable Drawable drawable) {
        if (drawable != null) {
            if (this.E) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = d3.a.r(drawable).mutate();
                d3.a.o(drawable, this.D);
            }
            int i11 = this.f36939w;
            drawable.setBounds(0, 0, i11, i11);
        } else if (this.f36940x) {
            if (this.F == null) {
                Drawable drawableE = b3.h.e(getResources(), R$drawable.navigation_empty_icon, getContext().getTheme());
                this.F = drawableE;
                if (drawableE != null) {
                    int i12 = this.f36939w;
                    drawableE.setBounds(0, 0, i12, i12);
                }
            }
            drawable = this.F;
        }
        androidx.core.widget.m.j(this.A, drawable, null, null, null);
    }

    public void setIconPadding(int i11) {
        this.A.setCompoundDrawablePadding(i11);
    }

    public void setIconSize(int i11) {
        this.f36939w = i11;
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.D = colorStateList;
        this.E = colorStateList != null;
        androidx.appcompat.view.menu.h hVar = this.C;
        if (hVar != null) {
            setIcon(hVar.getIcon());
        }
    }

    public void setMaxLines(int i11) {
        this.A.setMaxLines(i11);
    }

    public void setNeedsEmptyIcon(boolean z11) {
        this.f36940x = z11;
    }

    public void setShortcut(boolean z11, char c11) {
    }

    public void setTextAppearance(int i11) {
        androidx.core.widget.m.p(this.A, i11);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.A.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.A.setText(charSequence);
    }

    public boolean showsIcon() {
        return true;
    }

    public final void u() {
        if (w()) {
            this.A.setVisibility(8);
            FrameLayout frameLayout = this.B;
            if (frameLayout != null) {
                LinearLayoutCompat.a aVar = (LinearLayoutCompat.a) frameLayout.getLayoutParams();
                ((LinearLayout.LayoutParams) aVar).width = -1;
                this.B.setLayoutParams(aVar);
                return;
            }
            return;
        }
        this.A.setVisibility(0);
        FrameLayout frameLayout2 = this.B;
        if (frameLayout2 != null) {
            LinearLayoutCompat.a aVar2 = (LinearLayoutCompat.a) frameLayout2.getLayoutParams();
            ((LinearLayout.LayoutParams) aVar2).width = -2;
            this.B.setLayoutParams(aVar2);
        }
    }

    @Nullable
    public final StateListDrawable v() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(R$attr.colorControlHighlight, typedValue, true)) {
            return null;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(H, new ColorDrawable(typedValue.data));
        stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
        return stateListDrawable;
    }

    public final boolean w() {
        return this.C.getTitle() == null && this.C.getIcon() == null && this.C.getActionView() != null;
    }
}
