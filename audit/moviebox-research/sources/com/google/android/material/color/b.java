package com.google.android.material.color;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class b {
    public static int a(int i11, int i12) {
        return c3.b.k(i11, (Color.alpha(i11) * i12) / 255);
    }

    public static int b(@NonNull Context context, int i11, int i12) {
        Integer numF = f(context, i11);
        return numF != null ? numF.intValue() : i12;
    }

    public static int c(Context context, int i11, String str) {
        return m(context, vi.b.e(context, i11, str));
    }

    public static int d(@NonNull View view, int i11) {
        return m(view.getContext(), vi.b.f(view, i11));
    }

    public static int e(@NonNull View view, int i11, int i12) {
        return b(view.getContext(), i11, i12);
    }

    @Nullable
    public static Integer f(@NonNull Context context, int i11) {
        TypedValue typedValueA = vi.b.a(context, i11);
        if (typedValueA != null) {
            return Integer.valueOf(m(context, typedValueA));
        }
        return null;
    }

    @NonNull
    public static ColorStateList g(@NonNull Context context, int i11, @NonNull ColorStateList colorStateList) {
        TypedValue typedValueA = vi.b.a(context, i11);
        ColorStateList colorStateListN = typedValueA != null ? n(context, typedValueA) : null;
        return colorStateListN == null ? colorStateList : colorStateListN;
    }

    @Nullable
    public static ColorStateList h(@NonNull Context context, int i11) {
        TypedValue typedValueA = vi.b.a(context, i11);
        if (typedValueA == null) {
            return null;
        }
        int i12 = typedValueA.resourceId;
        if (i12 != 0) {
            return z2.a.getColorStateList(context, i12);
        }
        int i13 = typedValueA.data;
        if (i13 != 0) {
            return ColorStateList.valueOf(i13);
        }
        return null;
    }

    public static boolean i(int i11) {
        return i11 != 0 && c3.b.d(i11) > 0.5d;
    }

    public static int j(int i11, int i12) {
        return c3.b.g(i12, i11);
    }

    public static int k(int i11, int i12, float f11) {
        return j(i11, c3.b.k(i12, Math.round(Color.alpha(i12) * f11)));
    }

    public static int l(@NonNull View view, int i11, int i12, float f11) {
        return k(d(view, i11), d(view, i12), f11);
    }

    public static int m(@NonNull Context context, @NonNull TypedValue typedValue) {
        int i11 = typedValue.resourceId;
        return i11 != 0 ? z2.a.getColor(context, i11) : typedValue.data;
    }

    public static ColorStateList n(@NonNull Context context, @NonNull TypedValue typedValue) {
        int i11 = typedValue.resourceId;
        return i11 != 0 ? z2.a.getColorStateList(context, i11) : ColorStateList.valueOf(typedValue.data);
    }
}
