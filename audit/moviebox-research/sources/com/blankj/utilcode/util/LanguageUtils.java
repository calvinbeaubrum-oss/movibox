package com.blankj.utilcode.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import java.util.Locale;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class LanguageUtils {
    public static void a(Activity activity) {
        String strC = j0.r().c("KEY_LOCALE");
        if (TextUtils.isEmpty(strC)) {
            return;
        }
        Locale localeB = "VALUE_FOLLOW_SYSTEM".equals(strC) ? b(Resources.getSystem().getConfiguration()) : g(strC);
        if (localeB == null) {
            return;
        }
        i(activity, localeB);
        i(Utils.a(), localeB);
    }

    public static Locale b(Configuration configuration) {
        return Build.VERSION.SDK_INT >= 24 ? configuration.getLocales().get(0) : configuration.locale;
    }

    public static boolean c(String str) {
        int i11 = 0;
        for (char c11 : str.toCharArray()) {
            if (c11 == '$') {
                if (i11 >= 1) {
                    return false;
                }
                i11++;
            }
        }
        return i11 == 1;
    }

    public static boolean d(Locale locale, Locale locale2) {
        return j0.e(locale2.getLanguage(), locale.getLanguage()) && j0.e(locale2.getCountry(), locale.getCountry());
    }

    public static void e(final Locale locale, final int i11, final Utils.b<Boolean> bVar) {
        Resources resources = Utils.a().getResources();
        Configuration configuration = resources.getConfiguration();
        Locale localeB = b(configuration);
        f(configuration, locale);
        Utils.a().getResources().updateConfiguration(configuration, resources.getDisplayMetrics());
        if (bVar == null) {
            return;
        }
        if (d(localeB, locale)) {
            bVar.accept(Boolean.TRUE);
        } else if (i11 < 20) {
            j0.I(new Runnable() { // from class: com.blankj.utilcode.util.LanguageUtils.2
                @Override // java.lang.Runnable
                public void run() {
                    LanguageUtils.e(locale, i11 + 1, bVar);
                }
            }, 16L);
        } else {
            Log.e("LanguageUtils", "appLocal didn't update.");
            bVar.accept(Boolean.FALSE);
        }
    }

    public static void f(Configuration configuration, Locale locale) {
        configuration.setLocale(locale);
    }

    public static Locale g(String str) {
        Locale localeH = h(str);
        if (localeH == null) {
            Log.e("LanguageUtils", "The string of " + str + " is not in the correct format.");
            j0.r().f("KEY_LOCALE");
        }
        return localeH;
    }

    public static Locale h(String str) {
        if (!c(str)) {
            return null;
        }
        try {
            int iIndexOf = str.indexOf("$");
            return new Locale(str.substring(0, iIndexOf), str.substring(iIndexOf + 1));
        } catch (Exception unused) {
            return null;
        }
    }

    public static void i(Context context, Locale locale) {
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        f(configuration, locale);
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
    }
}
