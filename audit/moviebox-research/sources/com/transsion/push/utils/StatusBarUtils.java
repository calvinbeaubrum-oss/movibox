package com.transsion.push.utils;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class StatusBarUtils {
    public static void setNavigationBarColor(Activity activity, int i11) {
        activity.getWindow().setNavigationBarColor(Build.VERSION.SDK_INT >= 23 ? activity.getResources().getColor(i11, activity.getTheme()) : activity.getResources().getColor(i11));
        activity.setImmersive(true);
    }

    public static void setNavigationBarLightMode(Activity activity, boolean z11) {
        try {
            int i11 = View.class.getField("SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR").getInt(View.class);
            if (i11 > 0) {
                View decorView = activity.getWindow().getDecorView();
                decorView.setSystemUiVisibility(!z11 ? decorView.getSystemUiVisibility() | i11 : decorView.getSystemUiVisibility() & (~i11));
            }
        } catch (Exception unused) {
            PushLogUtils.LOG.i("not surport NavigationbarDarkMode");
        }
    }

    public static void setStatusBarColor(Activity activity, int i11) {
        activity.getWindow().setStatusBarColor(Build.VERSION.SDK_INT >= 23 ? activity.getResources().getColor(i11, activity.getTheme()) : activity.getResources().getColor(i11));
        activity.setImmersive(true);
    }

    public static void setStatusBarLightMode(Window window, boolean z11) {
        View decorView;
        int i11;
        if (Build.VERSION.SDK_INT >= 23 && (decorView = window.getDecorView()) != null) {
            int systemUiVisibility = decorView.getSystemUiVisibility();
            if (z11) {
                window.addFlags(Integer.MIN_VALUE);
                i11 = systemUiVisibility | 8192;
            } else {
                i11 = systemUiVisibility & (-8193);
            }
            decorView.setSystemUiVisibility(i11);
        }
    }
}
