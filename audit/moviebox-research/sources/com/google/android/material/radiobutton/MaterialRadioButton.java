package com.google.android.material.radiobutton;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.core.widget.b;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.b0;
import vi.d;
import zi.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class MaterialRadioButton extends AppCompatRadioButton {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f37344c = R$style.Widget_MaterialComponents_CompoundButton_RadioButton;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[][] f37345d = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public ColorStateList f37346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f37347b;

    public MaterialRadioButton(@NonNull Context context) {
        this(context, null);
    }

    public MaterialRadioButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.radioButtonStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialRadioButton(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        int i12 = f37344c;
        super(a.c(context, attributeSet, i11, i12), attributeSet, i11);
        Context context2 = getContext();
        TypedArray typedArrayI = b0.i(context2, attributeSet, R$styleable.MaterialRadioButton, i11, i12, new int[0]);
        if (typedArrayI.hasValue(R$styleable.MaterialRadioButton_buttonTint)) {
            b.d(this, d.a(context2, typedArrayI, R$styleable.MaterialRadioButton_buttonTint));
        }
        this.f37347b = typedArrayI.getBoolean(R$styleable.MaterialRadioButton_useMaterialThemeColors, false);
        typedArrayI.recycle();
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f37346a == null) {
            int iD = com.google.android.material.color.b.d(this, R$attr.colorControlActivated);
            int iD2 = com.google.android.material.color.b.d(this, R$attr.colorOnSurface);
            int iD3 = com.google.android.material.color.b.d(this, R$attr.colorSurface);
            int[][] iArr = f37345d;
            int[] iArr2 = new int[iArr.length];
            iArr2[0] = com.google.android.material.color.b.k(iD3, iD, 1.0f);
            iArr2[1] = com.google.android.material.color.b.k(iD3, iD2, 0.54f);
            iArr2[2] = com.google.android.material.color.b.k(iD3, iD2, 0.38f);
            iArr2[3] = com.google.android.material.color.b.k(iD3, iD2, 0.38f);
            this.f37346a = new ColorStateList(iArr, iArr2);
        }
        return this.f37346a;
    }

    public boolean isUseMaterialThemeColors() {
        return this.f37347b;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f37347b && b.b(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z11) {
        this.f37347b = z11;
        if (z11) {
            b.d(this, getMaterialThemeColorsTintList());
        } else {
            b.d(this, null);
        }
    }
}
