package com.google.android.material.materialswitch;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.n0;
import c3.b;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.b0;
import com.google.android.material.internal.f0;
import oi.f;
import zi.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class MaterialSwitch extends SwitchCompat {

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public static final int f37122l0 = R$style.Widget_Material3_CompoundButton_MaterialSwitch;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public static final int[] f37123m0 = {R$attr.state_with_icon};

    @Nullable
    public Drawable V;

    @Nullable
    public Drawable W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public int f37124a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    @Nullable
    public Drawable f37125b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    @Nullable
    public Drawable f37126c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    @Nullable
    public ColorStateList f37127d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    @Nullable
    public ColorStateList f37128e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    @NonNull
    public PorterDuff.Mode f37129f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    @Nullable
    public ColorStateList f37130g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    @Nullable
    public ColorStateList f37131h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    @NonNull
    public PorterDuff.Mode f37132i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public int[] f37133j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public int[] f37134k0;

    public MaterialSwitch(@NonNull Context context) {
        this(context, null);
    }

    public MaterialSwitch(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.materialSwitchStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialSwitch(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        int i12 = f37122l0;
        super(a.c(context, attributeSet, i11, i12), attributeSet, i11);
        this.f37124a0 = -1;
        Context context2 = getContext();
        this.V = super.getThumbDrawable();
        this.f37127d0 = super.getThumbTintList();
        super.setThumbTintList(null);
        this.f37125b0 = super.getTrackDrawable();
        this.f37130g0 = super.getTrackTintList();
        super.setTrackTintList(null);
        n0 n0VarJ = b0.j(context2, attributeSet, R$styleable.MaterialSwitch, i11, i12, new int[0]);
        this.W = n0VarJ.g(R$styleable.MaterialSwitch_thumbIcon);
        this.f37124a0 = n0VarJ.f(R$styleable.MaterialSwitch_thumbIconSize, -1);
        this.f37128e0 = n0VarJ.c(R$styleable.MaterialSwitch_thumbIconTint);
        int iK = n0VarJ.k(R$styleable.MaterialSwitch_thumbIconTintMode, -1);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        this.f37129f0 = f0.r(iK, mode);
        this.f37126c0 = n0VarJ.g(R$styleable.MaterialSwitch_trackDecoration);
        this.f37131h0 = n0VarJ.c(R$styleable.MaterialSwitch_trackDecorationTint);
        this.f37132i0 = f0.r(n0VarJ.k(R$styleable.MaterialSwitch_trackDecorationTintMode, -1), mode);
        n0VarJ.x();
        setEnforceSwitchWidth(false);
        p();
        q();
    }

    public static void r(@Nullable Drawable drawable, @Nullable ColorStateList colorStateList, @NonNull int[] iArr, @NonNull int[] iArr2, float f11) {
        if (drawable == null || colorStateList == null) {
            return;
        }
        d3.a.n(drawable, b.c(colorStateList.getColorForState(iArr, 0), colorStateList.getColorForState(iArr2, 0), f11));
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    @Nullable
    public Drawable getThumbDrawable() {
        return this.V;
    }

    @Nullable
    public Drawable getThumbIconDrawable() {
        return this.W;
    }

    public int getThumbIconSize() {
        return this.f37124a0;
    }

    @Nullable
    public ColorStateList getThumbIconTintList() {
        return this.f37128e0;
    }

    @NonNull
    public PorterDuff.Mode getThumbIconTintMode() {
        return this.f37129f0;
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    @Nullable
    public ColorStateList getThumbTintList() {
        return this.f37127d0;
    }

    @Nullable
    public Drawable getTrackDecorationDrawable() {
        return this.f37126c0;
    }

    @Nullable
    public ColorStateList getTrackDecorationTintList() {
        return this.f37131h0;
    }

    @NonNull
    public PorterDuff.Mode getTrackDecorationTintMode() {
        return this.f37132i0;
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    @Nullable
    public Drawable getTrackDrawable() {
        return this.f37125b0;
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    @Nullable
    public ColorStateList getTrackTintList() {
        return this.f37130g0;
    }

    @Override // android.view.View
    public void invalidate() {
        s();
        super.invalidate();
    }

    @Override // androidx.appcompat.widget.SwitchCompat, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i11) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i11 + 1);
        if (this.W != null) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f37123m0);
        }
        this.f37133j0 = f.j(iArrOnCreateDrawableState);
        this.f37134k0 = f.f(iArrOnCreateDrawableState);
        return iArrOnCreateDrawableState;
    }

    public final void p() {
        this.V = f.c(this.V, this.f37127d0, getThumbTintMode());
        this.W = f.c(this.W, this.f37128e0, this.f37129f0);
        s();
        Drawable drawable = this.V;
        Drawable drawable2 = this.W;
        int i11 = this.f37124a0;
        super.setThumbDrawable(f.b(drawable, drawable2, i11, i11));
        refreshDrawableState();
    }

    public final void q() {
        this.f37125b0 = f.c(this.f37125b0, this.f37130g0, getTrackTintMode());
        this.f37126c0 = f.c(this.f37126c0, this.f37131h0, this.f37132i0);
        s();
        Drawable layerDrawable = this.f37125b0;
        if (layerDrawable != null && this.f37126c0 != null) {
            layerDrawable = new LayerDrawable(new Drawable[]{this.f37125b0, this.f37126c0});
        } else if (layerDrawable == null) {
            layerDrawable = this.f37126c0;
        }
        if (layerDrawable != null) {
            setSwitchMinWidth(layerDrawable.getIntrinsicWidth());
        }
        super.setTrackDrawable(layerDrawable);
    }

    public final void s() {
        if (this.f37127d0 == null && this.f37128e0 == null && this.f37130g0 == null && this.f37131h0 == null) {
            return;
        }
        float thumbPosition = getThumbPosition();
        ColorStateList colorStateList = this.f37127d0;
        if (colorStateList != null) {
            r(this.V, colorStateList, this.f37133j0, this.f37134k0, thumbPosition);
        }
        ColorStateList colorStateList2 = this.f37128e0;
        if (colorStateList2 != null) {
            r(this.W, colorStateList2, this.f37133j0, this.f37134k0, thumbPosition);
        }
        ColorStateList colorStateList3 = this.f37130g0;
        if (colorStateList3 != null) {
            r(this.f37125b0, colorStateList3, this.f37133j0, this.f37134k0, thumbPosition);
        }
        ColorStateList colorStateList4 = this.f37131h0;
        if (colorStateList4 != null) {
            r(this.f37126c0, colorStateList4, this.f37133j0, this.f37134k0, thumbPosition);
        }
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setThumbDrawable(@Nullable Drawable drawable) {
        this.V = drawable;
        p();
    }

    public void setThumbIconDrawable(@Nullable Drawable drawable) {
        this.W = drawable;
        p();
    }

    public void setThumbIconResource(int i11) {
        setThumbIconDrawable(d1.a.b(getContext(), i11));
    }

    public void setThumbIconSize(int i11) {
        if (this.f37124a0 != i11) {
            this.f37124a0 = i11;
            p();
        }
    }

    public void setThumbIconTintList(@Nullable ColorStateList colorStateList) {
        this.f37128e0 = colorStateList;
        p();
    }

    public void setThumbIconTintMode(@NonNull PorterDuff.Mode mode) {
        this.f37129f0 = mode;
        p();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setThumbTintList(@Nullable ColorStateList colorStateList) {
        this.f37127d0 = colorStateList;
        p();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setThumbTintMode(@Nullable PorterDuff.Mode mode) {
        super.setThumbTintMode(mode);
        p();
    }

    public void setTrackDecorationDrawable(@Nullable Drawable drawable) {
        this.f37126c0 = drawable;
        q();
    }

    public void setTrackDecorationResource(int i11) {
        setTrackDecorationDrawable(d1.a.b(getContext(), i11));
    }

    public void setTrackDecorationTintList(@Nullable ColorStateList colorStateList) {
        this.f37131h0 = colorStateList;
        q();
    }

    public void setTrackDecorationTintMode(@NonNull PorterDuff.Mode mode) {
        this.f37132i0 = mode;
        q();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setTrackDrawable(@Nullable Drawable drawable) {
        this.f37125b0 = drawable;
        q();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setTrackTintList(@Nullable ColorStateList colorStateList) {
        this.f37130g0 = colorStateList;
        q();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setTrackTintMode(@Nullable PorterDuff.Mode mode) {
        super.setTrackTintMode(mode);
        q();
    }
}
