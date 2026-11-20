package com.cloud.sdk.commonutil.util;

import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class j {
    public static int a(float f11) {
        return (int) ((f11 * b()) + 0.5f);
    }

    public static float b() {
        DisplayMetrics displayMetricsD = d();
        if (displayMetricsD == null) {
            return -1.0f;
        }
        return displayMetricsD.density;
    }

    public static float c() {
        DisplayMetrics displayMetricsD = d();
        if (displayMetricsD == null) {
            return -1.0f;
        }
        return displayMetricsD.scaledDensity;
    }

    public static DisplayMetrics d() {
        if (f.a() == null) {
            return null;
        }
        Display defaultDisplay = ((WindowManager) f.a().getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
            return displayMetrics;
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public static int e() {
        if (f.a() == null || f.a().getResources() == null) {
            return 0;
        }
        return f.a().getResources().getConfiguration().orientation;
    }

    public static int f() {
        if (f.a() == null) {
            return -1;
        }
        return d().heightPixels;
    }

    public static int g() {
        if (f.a() == null) {
            return -1;
        }
        return d().widthPixels;
    }

    public static int h(float f11) {
        return (int) ((f11 / c()) + 0.5f);
    }

    public static int i(float f11) {
        return (int) ((f11 * c()) + 0.5f);
    }
}
