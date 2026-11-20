package com.bytedance.sdk.component.adexpress.We;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.utils.Sfl;
import java.lang.reflect.Method;
import java.util.Locale;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Qj {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static boolean f26731sc;

    private static float We(Context context) {
        try {
            if (f26731sc) {
                Class<?> clsLoadClass = context.getClassLoader().loadClass("android.util.DisplayMetrics");
                Method declaredMethod = clsLoadClass.getDeclaredMethod("getDeviceDensity", new Class[0]);
                declaredMethod.setAccessible(true);
                return ((Integer) declaredMethod.invoke(clsLoadClass, new Object[0])).intValue() / 160.0f;
            }
        } catch (Exception unused) {
        }
        return context.getResources().getDisplayMetrics().density;
    }

    public static int pFF(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.sc.sc.sc.sc().zY().pFF();
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int pFF(Context context, float f11) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.sc.sc.sc.sc().zY().pFF();
        }
        float fWe = We(context);
        if (fWe <= 0.0f) {
            fWe = 1.0f;
        }
        return (int) ((f11 / fWe) + 0.5f);
    }

    public static float sc(Context context, float f11) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.sc.sc.sc.sc().zY().pFF();
        }
        return (f11 * We(context)) + 0.5f;
    }

    public static int sc(float f11, float f12, float f13, float f14) {
        return (((int) ((f11 * 255.0f) + 0.5f)) << 24) | (((int) ((f12 * 255.0f) + 0.5f)) << 16) | (((int) ((f13 * 255.0f) + 0.5f)) << 8) | ((int) ((f14 * 255.0f) + 0.5f));
    }

    public static int sc(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.sc.sc.sc.sc().zY().pFF();
        }
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    private static String sc(String str) {
        str.hashCode();
        switch (str) {
            case "ar":
                return "aa";
            case "ja":
                return "japan";
            case "ko":
                return "korea";
            case "ms":
                return "my";
            case "zh":
                return "cn";
            default:
                return str;
        }
    }

    public static float zY(Context context, float f11) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.sc.sc.sc.sc().zY().pFF();
        }
        return f11 * We(context);
    }

    public static String zY(@NonNull Context context) {
        String language;
        try {
            Locale locale = Build.VERSION.SDK_INT >= 24 ? Sfl.pFF(context).getConfiguration().getLocales().get(0) : Locale.getDefault();
            language = locale.getLanguage();
            try {
                if (locale.getCountry().equals("TW")) {
                    language = "zhHant";
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            language = "";
        }
        return sc(language);
    }
}
