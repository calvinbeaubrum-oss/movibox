package com.google.android.material.switchmaterial;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.color.b;
import com.google.android.material.internal.b0;
import com.google.android.material.internal.f0;
import pi.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class SwitchMaterial extends SwitchCompat {

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final int f37641c0 = R$style.Widget_MaterialComponents_CompoundButton_Switch;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final int[][] f37642d0 = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};

    @NonNull
    public final a V;

    @Nullable
    public ColorStateList W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    @Nullable
    public ColorStateList f37643a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public boolean f37644b0;

    public SwitchMaterial(@NonNull Context context) {
        this(context, null);
    }

    public SwitchMaterial(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.switchStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SwitchMaterial(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        int i12 = f37641c0;
        super(zi.a.c(context, attributeSet, i11, i12), attributeSet, i11);
        Context context2 = getContext();
        this.V = new a(context2);
        TypedArray typedArrayI = b0.i(context2, attributeSet, R$styleable.SwitchMaterial, i11, i12, new int[0]);
        this.f37644b0 = typedArrayI.getBoolean(R$styleable.SwitchMaterial_useMaterialThemeColors, false);
        typedArrayI.recycle();
    }

    private ColorStateList getMaterialThemeColorsThumbTintList() {
        if (this.W == null) {
            int iD = b.d(this, R$attr.colorSurface);
            int iD2 = b.d(this, R$attr.colorControlActivated);
            float dimension = getResources().getDimension(R$dimen.mtrl_switch_thumb_elevation);
            if (this.V.e()) {
                dimension += f0.n(this);
            }
            int iC = this.V.c(iD, dimension);
            int[][] iArr = f37642d0;
            int[] iArr2 = new int[iArr.length];
            iArr2[0] = b.k(iD, iD2, 1.0f);
            iArr2[1] = iC;
            iArr2[2] = b.k(iD, iD2, 0.38f);
            iArr2[3] = iC;
            this.W = new ColorStateList(iArr, iArr2);
        }
        return this.W;
    }

    private ColorStateList getMaterialThemeColorsTrackTintList() {
        if (this.f37643a0 == null) {
            int[][] iArr = f37642d0;
            int[] iArr2 = new int[iArr.length];
            int iD = b.d(this, R$attr.colorSurface);
            int iD2 = b.d(this, R$attr.colorControlActivated);
            int iD3 = b.d(this, R$attr.colorOnSurface);
            iArr2[0] = b.k(iD, iD2, 0.54f);
            iArr2[1] = b.k(iD, iD3, 0.32f);
            iArr2[2] = b.k(iD, iD2, 0.12f);
            iArr2[3] = b.k(iD, iD3, 0.12f);
            this.f37643a0 = new ColorStateList(iArr, iArr2);
        }
        return this.f37643a0;
    }

    public boolean isUseMaterialThemeColors() {
        return this.f37644b0;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f37644b0 && getThumbTintList() == null) {
            setThumbTintList(getMaterialThemeColorsThumbTintList());
        }
        if (this.f37644b0 && getTrackTintList() == null) {
            setTrackTintList(getMaterialThemeColorsTrackTintList());
        }
    }

    public void setUseMaterialThemeColors(boolean z11) {
        this.f37644b0 = z11;
        if (z11) {
            setThumbTintList(getMaterialThemeColorsThumbTintList());
            setTrackTintList(getMaterialThemeColorsTrackTintList());
        } else {
            setThumbTintList(null);
            setTrackTintList(null);
        }
    }
}
