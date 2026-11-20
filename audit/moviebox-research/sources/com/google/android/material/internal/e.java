package com.google.android.material.internal;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class e {
    public static void a(@NonNull Window window, boolean z11, @Nullable Integer num, @Nullable Integer num2) {
        boolean z12 = num == null || num.intValue() == 0;
        boolean z13 = num2 == null || num2.intValue() == 0;
        if (z12 || z13) {
            int iB = com.google.android.material.color.b.b(window.getContext(), R.attr.colorBackground, ViewCompat.MEASURED_STATE_MASK);
            if (z12) {
                num = Integer.valueOf(iB);
            }
            if (z13) {
                num2 = Integer.valueOf(iB);
            }
        }
        WindowCompat.setDecorFitsSystemWindows(window, !z11);
        int iC = c(window.getContext(), z11);
        int iB2 = b(window.getContext(), z11);
        window.setStatusBarColor(iC);
        window.setNavigationBarColor(iB2);
        f(window, d(iC, com.google.android.material.color.b.i(num.intValue())));
        e(window, d(iB2, com.google.android.material.color.b.i(num2.intValue())));
    }

    @TargetApi(21)
    public static int b(Context context, boolean z11) {
        if (z11 && Build.VERSION.SDK_INT < 27) {
            return c3.b.k(com.google.android.material.color.b.b(context, R.attr.navigationBarColor, ViewCompat.MEASURED_STATE_MASK), 128);
        }
        if (z11) {
            return 0;
        }
        return com.google.android.material.color.b.b(context, R.attr.navigationBarColor, ViewCompat.MEASURED_STATE_MASK);
    }

    @TargetApi(21)
    public static int c(Context context, boolean z11) {
        if (z11 && Build.VERSION.SDK_INT < 23) {
            return c3.b.k(com.google.android.material.color.b.b(context, R.attr.statusBarColor, ViewCompat.MEASURED_STATE_MASK), 128);
        }
        if (z11) {
            return 0;
        }
        return com.google.android.material.color.b.b(context, R.attr.statusBarColor, ViewCompat.MEASURED_STATE_MASK);
    }

    public static boolean d(int i11, boolean z11) {
        return com.google.android.material.color.b.i(i11) || (i11 == 0 && z11);
    }

    public static void e(@NonNull Window window, boolean z11) {
        WindowCompat.getInsetsController(window, window.getDecorView()).setAppearanceLightNavigationBars(z11);
    }

    public static void f(@NonNull Window window, boolean z11) {
        WindowCompat.getInsetsController(window, window.getDecorView()).setAppearanceLightStatusBars(z11);
    }
}
