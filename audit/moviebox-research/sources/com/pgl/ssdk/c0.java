package com.pgl.ssdk;

import android.content.Context;
import android.graphics.Point;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f48724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f48725b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f48726c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f48727d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f48728e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static int f48729f;

    private static void a(Context context) {
        if (context == null) {
            return;
        }
        try {
            new DisplayMetrics();
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            f48727d = (int) displayMetrics.density;
            f48726c = displayMetrics.densityDpi;
        } catch (Throwable unused) {
        }
    }

    private static void b(Context context) {
        try {
            new DisplayMetrics();
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            f48728e = (int) displayMetrics.xdpi;
            f48729f = (int) displayMetrics.ydpi;
        } catch (Throwable unused) {
        }
    }

    private static void c(Context context) {
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            f48724a = point.x;
            f48725b = point.y;
        } catch (Throwable unused) {
        }
    }

    public static String d(Context context) {
        int i11 = -1;
        if (context != null) {
            try {
                i11 = Settings.System.getInt(context.getContentResolver(), "screen_brightness", -1);
            } catch (Throwable unused) {
            }
        }
        return String.valueOf(i11);
    }

    public static String e(Context context) {
        try {
            c(context);
            a(context);
            b(context);
        } catch (Throwable unused) {
        }
        return f48726c + "[<!>]" + f48724a + "," + f48725b + "[<!>]";
    }
}
