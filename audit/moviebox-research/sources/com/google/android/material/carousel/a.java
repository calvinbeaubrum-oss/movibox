package com.google.android.material.carousel;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.material.R$dimen;
import li.f;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class a {
    public static float a(float f11, float f12, int i11) {
        return f11 + (Math.max(0, i11 - 1) * f12);
    }

    public static float b(float f11, float f12, int i11) {
        return i11 > 0 ? f11 + (f12 / 2.0f) : f11;
    }

    public static b c(@NonNull Context context, float f11, float f12, @NonNull li.a aVar) {
        float f13;
        float fMin = Math.min(f(context) + f11, aVar.f70287f);
        float f14 = fMin / 2.0f;
        float f15 = 0.0f - f14;
        float fB = b(0.0f, aVar.f70283b, aVar.f70284c);
        float fJ = j(0.0f, a(fB, aVar.f70283b, (int) Math.floor(aVar.f70284c / 2.0f)), aVar.f70283b, aVar.f70284c);
        float fB2 = b(fJ, aVar.f70286e, aVar.f70285d);
        float fJ2 = j(fJ, a(fB2, aVar.f70286e, (int) Math.floor(aVar.f70285d / 2.0f)), aVar.f70286e, aVar.f70285d);
        float fB3 = b(fJ2, aVar.f70287f, aVar.f70288g);
        float fJ3 = j(fJ2, a(fB3, aVar.f70287f, aVar.f70288g), aVar.f70287f, aVar.f70288g);
        float fB4 = b(fJ3, aVar.f70286e, aVar.f70285d);
        float fB5 = b(j(fJ3, a(fB4, aVar.f70286e, (int) Math.ceil(aVar.f70285d / 2.0f)), aVar.f70286e, aVar.f70285d), aVar.f70283b, aVar.f70284c);
        float f16 = f14 + f12;
        float fB6 = f.b(fMin, aVar.f70287f, f11);
        float fB7 = f.b(aVar.f70283b, aVar.f70287f, f11);
        float fB8 = f.b(aVar.f70286e, aVar.f70287f, f11);
        b.C0379b c0379bA = new b.C0379b(aVar.f70287f, f12).a(f15, fB6, fMin);
        int i11 = aVar.f70284c;
        if (i11 > 0) {
            c0379bA.g(fB, fB7, aVar.f70283b, (int) Math.floor(i11 / 2.0f));
        }
        int i12 = aVar.f70285d;
        if (i12 > 0) {
            c0379bA.g(fB2, fB8, aVar.f70286e, (int) Math.floor(i12 / 2.0f));
        }
        c0379bA.h(fB3, 0.0f, aVar.f70287f, aVar.f70288g, true);
        int i13 = aVar.f70285d;
        if (i13 > 0) {
            f13 = 2.0f;
            c0379bA.g(fB4, fB8, aVar.f70286e, (int) Math.ceil(i13 / 2.0f));
        } else {
            f13 = 2.0f;
        }
        int i14 = aVar.f70284c;
        if (i14 > 0) {
            c0379bA.g(fB5, fB7, aVar.f70283b, (int) Math.ceil(i14 / f13));
        }
        c0379bA.a(f16, fB6, fMin);
        return c0379bA.i();
    }

    public static b d(@NonNull Context context, float f11, float f12, @NonNull li.a aVar, int i11) {
        return i11 == 1 ? c(context, f11, f12, aVar) : e(context, f11, f12, aVar);
    }

    public static b e(@NonNull Context context, float f11, float f12, @NonNull li.a aVar) {
        float fMin = Math.min(f(context) + f11, aVar.f70287f);
        float f13 = fMin / 2.0f;
        float f14 = 0.0f - f13;
        float fB = b(0.0f, aVar.f70287f, aVar.f70288g);
        float fJ = j(0.0f, a(fB, aVar.f70287f, aVar.f70288g), aVar.f70287f, aVar.f70288g);
        float fB2 = b(fJ, aVar.f70286e, aVar.f70285d);
        float fB3 = b(j(fJ, fB2, aVar.f70286e, aVar.f70285d), aVar.f70283b, aVar.f70284c);
        float f15 = f13 + f12;
        float fB4 = f.b(fMin, aVar.f70287f, f11);
        float fB5 = f.b(aVar.f70283b, aVar.f70287f, f11);
        float fB6 = f.b(aVar.f70286e, aVar.f70287f, f11);
        b.C0379b c0379bH = new b.C0379b(aVar.f70287f, f12).a(f14, fB4, fMin).h(fB, 0.0f, aVar.f70287f, aVar.f70288g, true);
        if (aVar.f70285d > 0) {
            c0379bH.b(fB2, fB6, aVar.f70286e);
        }
        int i11 = aVar.f70284c;
        if (i11 > 0) {
            c0379bH.g(fB3, fB5, aVar.f70283b, i11);
        }
        c0379bH.a(f15, fB4, fMin);
        return c0379bH.i();
    }

    public static float f(@NonNull Context context) {
        return context.getResources().getDimension(R$dimen.m3_carousel_gone_size);
    }

    public static float g(@NonNull Context context) {
        return context.getResources().getDimension(R$dimen.m3_carousel_small_item_size_max);
    }

    public static float h(@NonNull Context context) {
        return context.getResources().getDimension(R$dimen.m3_carousel_small_item_size_min);
    }

    public static int i(int[] iArr) {
        int i11 = Integer.MIN_VALUE;
        for (int i12 : iArr) {
            if (i12 > i11) {
                i11 = i12;
            }
        }
        return i11;
    }

    public static float j(float f11, float f12, float f13, int i11) {
        return i11 > 0 ? f12 + (f13 / 2.0f) : f11;
    }
}
