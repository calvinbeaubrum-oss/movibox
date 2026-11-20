package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.n0;
import com.google.android.material.R$attr;
import com.google.android.material.R$styleable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f37027a = {R$attr.colorPrimary};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f37028b = {R$attr.colorPrimaryVariant};

    public static void a(@NonNull Context context) {
        e(context, f37027a, "Theme.AppCompat");
    }

    public static void b(@NonNull Context context, AttributeSet attributeSet, int i11, int i12) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ThemeEnforcement, i11, i12);
        boolean z11 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.ThemeEnforcement_enforceMaterialTheme, false);
        typedArrayObtainStyledAttributes.recycle();
        if (z11) {
            TypedValue typedValue = new TypedValue();
            if (!context.getTheme().resolveAttribute(R$attr.isMaterialTheme, typedValue, true) || (typedValue.type == 18 && typedValue.data == 0)) {
                c(context);
            }
        }
        a(context);
    }

    public static void c(@NonNull Context context) {
        e(context, f37028b, "Theme.MaterialComponents");
    }

    public static void d(@NonNull Context context, AttributeSet attributeSet, @NonNull int[] iArr, int i11, int i12, @Nullable int... iArr2) {
        boolean zF;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ThemeEnforcement, i11, i12);
        if (!typedArrayObtainStyledAttributes.getBoolean(R$styleable.ThemeEnforcement_enforceTextAppearance, false)) {
            typedArrayObtainStyledAttributes.recycle();
            return;
        }
        if (iArr2 == null || iArr2.length == 0) {
            zF = typedArrayObtainStyledAttributes.getResourceId(R$styleable.ThemeEnforcement_android_textAppearance, -1) != -1;
        } else {
            zF = f(context, attributeSet, iArr, i11, i12, iArr2);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!zF) {
            throw new IllegalArgumentException("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
        }
    }

    public static void e(@NonNull Context context, @NonNull int[] iArr, String str) {
        if (h(context, iArr)) {
            return;
        }
        throw new IllegalArgumentException("The style on this component requires your app theme to be " + str + " (or a descendant).");
    }

    public static boolean f(@NonNull Context context, AttributeSet attributeSet, @NonNull int[] iArr, int i11, int i12, @NonNull int... iArr2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i11, i12);
        for (int i13 : iArr2) {
            if (typedArrayObtainStyledAttributes.getResourceId(i13, -1) == -1) {
                typedArrayObtainStyledAttributes.recycle();
                return false;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        return true;
    }

    public static boolean g(@NonNull Context context) {
        return vi.b.b(context, R$attr.isMaterial3Theme, false);
    }

    public static boolean h(@NonNull Context context, @NonNull int[] iArr) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(iArr);
        for (int i11 = 0; i11 < iArr.length; i11++) {
            if (!typedArrayObtainStyledAttributes.hasValue(i11)) {
                typedArrayObtainStyledAttributes.recycle();
                return false;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        return true;
    }

    @NonNull
    public static TypedArray i(@NonNull Context context, AttributeSet attributeSet, @NonNull int[] iArr, int i11, int i12, int... iArr2) {
        b(context, attributeSet, i11, i12);
        d(context, attributeSet, iArr, i11, i12, iArr2);
        return context.obtainStyledAttributes(attributeSet, iArr, i11, i12);
    }

    public static n0 j(@NonNull Context context, AttributeSet attributeSet, @NonNull int[] iArr, int i11, int i12, int... iArr2) {
        b(context, attributeSet, i11, i12);
        d(context, attributeSet, iArr, i11, i12, iArr2);
        return n0.v(context, attributeSet, iArr, i11, i12);
    }
}
