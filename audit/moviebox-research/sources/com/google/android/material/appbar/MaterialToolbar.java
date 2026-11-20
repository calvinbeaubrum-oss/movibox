package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.ToolbarUtils;
import com.google.android.material.internal.b0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class MaterialToolbar extends Toolbar {

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final int f36167d0 = R$style.Widget_MaterialComponents_Toolbar;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final ImageView.ScaleType[] f36168e0 = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};

    @Nullable
    public Integer V;
    public boolean W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public boolean f36169a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    @Nullable
    public ImageView.ScaleType f36170b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    @Nullable
    public Boolean f36171c0;

    public MaterialToolbar(@NonNull Context context) {
        this(context, null);
    }

    public MaterialToolbar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.toolbarStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialToolbar(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        int i12 = f36167d0;
        super(zi.a.c(context, attributeSet, i11, i12), attributeSet, i11);
        Context context2 = getContext();
        TypedArray typedArrayI = b0.i(context2, attributeSet, R$styleable.MaterialToolbar, i11, i12, new int[0]);
        if (typedArrayI.hasValue(R$styleable.MaterialToolbar_navigationIconTint)) {
            setNavigationIconTint(typedArrayI.getColor(R$styleable.MaterialToolbar_navigationIconTint, -1));
        }
        this.W = typedArrayI.getBoolean(R$styleable.MaterialToolbar_titleCentered, false);
        this.f36169a0 = typedArrayI.getBoolean(R$styleable.MaterialToolbar_subtitleCentered, false);
        int i13 = typedArrayI.getInt(R$styleable.MaterialToolbar_logoScaleType, -1);
        if (i13 >= 0) {
            ImageView.ScaleType[] scaleTypeArr = f36168e0;
            if (i13 < scaleTypeArr.length) {
                this.f36170b0 = scaleTypeArr[i13];
            }
        }
        if (typedArrayI.hasValue(R$styleable.MaterialToolbar_logoAdjustViewBounds)) {
            this.f36171c0 = Boolean.valueOf(typedArrayI.getBoolean(R$styleable.MaterialToolbar_logoAdjustViewBounds, false));
        }
        typedArrayI.recycle();
        D(context2);
    }

    public final Pair<Integer, Integer> C(@Nullable TextView textView, @Nullable TextView textView2) {
        int measuredWidth = getMeasuredWidth();
        int i11 = measuredWidth / 2;
        int paddingLeft = getPaddingLeft();
        int paddingRight = measuredWidth - getPaddingRight();
        for (int i12 = 0; i12 < getChildCount(); i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8 && childAt != textView && childAt != textView2) {
                if (childAt.getRight() < i11 && childAt.getRight() > paddingLeft) {
                    paddingLeft = childAt.getRight();
                }
                if (childAt.getLeft() > i11 && childAt.getLeft() < paddingRight) {
                    paddingRight = childAt.getLeft();
                }
            }
        }
        return new Pair<>(Integer.valueOf(paddingLeft), Integer.valueOf(paddingRight));
    }

    public final void D(Context context) {
        Drawable background = getBackground();
        ColorStateList colorStateListValueOf = background == null ? ColorStateList.valueOf(0) : oi.f.g(background);
        if (colorStateListValueOf != null) {
            yi.i iVar = new yi.i();
            iVar.d0(colorStateListValueOf);
            iVar.S(context);
            iVar.c0(ViewCompat.getElevation(this));
            ViewCompat.setBackground(this, iVar);
        }
    }

    public final void E(View view, Pair<Integer, Integer> pair) {
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = view.getMeasuredWidth();
        int i11 = (measuredWidth / 2) - (measuredWidth2 / 2);
        int i12 = measuredWidth2 + i11;
        int iMax = Math.max(Math.max(((Integer) pair.first).intValue() - i11, 0), Math.max(i12 - ((Integer) pair.second).intValue(), 0));
        if (iMax > 0) {
            i11 += iMax;
            i12 -= iMax;
            view.measure(View.MeasureSpec.makeMeasureSpec(i12 - i11, 1073741824), view.getMeasuredHeightAndState());
        }
        view.layout(i11, view.getTop(), i12, view.getBottom());
    }

    public final void F() {
        if (this.W || this.f36169a0) {
            TextView textViewI = ToolbarUtils.i(this);
            TextView textViewG = ToolbarUtils.g(this);
            if (textViewI == null && textViewG == null) {
                return;
            }
            Pair<Integer, Integer> pairC = C(textViewI, textViewG);
            if (this.W && textViewI != null) {
                E(textViewI, pairC);
            }
            if (!this.f36169a0 || textViewG == null) {
                return;
            }
            E(textViewG, pairC);
        }
    }

    @Nullable
    public final Drawable G(@Nullable Drawable drawable) {
        if (drawable == null || this.V == null) {
            return drawable;
        }
        Drawable drawableR = d3.a.r(drawable.mutate());
        d3.a.n(drawableR, this.V.intValue());
        return drawableR;
    }

    public final void H() {
        ImageView imageViewD = ToolbarUtils.d(this);
        if (imageViewD != null) {
            Boolean bool = this.f36171c0;
            if (bool != null) {
                imageViewD.setAdjustViewBounds(bool.booleanValue());
            }
            ImageView.ScaleType scaleType = this.f36170b0;
            if (scaleType != null) {
                imageViewD.setScaleType(scaleType);
            }
        }
    }

    public void clearNavigationIconTint() {
        this.V = null;
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            d3.a.o(d3.a.r(navigationIcon.mutate()), null);
            setNavigationIcon(navigationIcon);
        }
    }

    @Nullable
    public ImageView.ScaleType getLogoScaleType() {
        return this.f36170b0;
    }

    @Nullable
    public Integer getNavigationIconTint() {
        return this.V;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void inflateMenu(int i11) {
        Menu menu = getMenu();
        boolean z11 = menu instanceof androidx.appcompat.view.menu.f;
        if (z11) {
            ((androidx.appcompat.view.menu.f) menu).i0();
        }
        super.inflateMenu(i11);
        if (z11) {
            ((androidx.appcompat.view.menu.f) menu).h0();
        }
    }

    public boolean isLogoAdjustViewBounds() {
        Boolean bool = this.f36171c0;
        return bool != null && bool.booleanValue();
    }

    public boolean isSubtitleCentered() {
        return this.f36169a0;
    }

    public boolean isTitleCentered() {
        return this.W;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        yi.j.e(this);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        F();
        H();
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f11) {
        super.setElevation(f11);
        yi.j.d(this, f11);
    }

    public void setLogoAdjustViewBounds(boolean z11) {
        Boolean bool = this.f36171c0;
        if (bool == null || bool.booleanValue() != z11) {
            this.f36171c0 = Boolean.valueOf(z11);
            requestLayout();
        }
    }

    public void setLogoScaleType(@NonNull ImageView.ScaleType scaleType) {
        if (this.f36170b0 != scaleType) {
            this.f36170b0 = scaleType;
            requestLayout();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(@Nullable Drawable drawable) {
        super.setNavigationIcon(G(drawable));
    }

    public void setNavigationIconTint(int i11) {
        this.V = Integer.valueOf(i11);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    public void setSubtitleCentered(boolean z11) {
        if (this.f36169a0 != z11) {
            this.f36169a0 = z11;
            requestLayout();
        }
    }

    public void setTitleCentered(boolean z11) {
        if (this.W != z11) {
            this.W = z11;
            requestLayout();
        }
    }
}
