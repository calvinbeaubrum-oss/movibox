package androidx.core.text;

import android.icu.util.ULocale;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Method f7874a;

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(21)
    public static class a {
        public static String a(Locale locale) {
            return locale.getScript();
        }
    }

    /* JADX INFO: renamed from: androidx.core.text.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @RequiresApi(24)
    public static class C0074b {
        public static ULocale a(Object obj) {
            return ULocale.addLikelySubtags((ULocale) obj);
        }

        public static ULocale b(Locale locale) {
            return ULocale.forLocale(locale);
        }

        public static String c(Object obj) {
            return ((ULocale) obj).getScript();
        }
    }

    static {
        if (Build.VERSION.SDK_INT < 24) {
            try {
                f7874a = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", Locale.class);
            } catch (Exception e11) {
                throw new IllegalStateException(e11);
            }
        }
    }

    @Nullable
    public static String a(@NonNull Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return C0074b.c(C0074b.a(C0074b.b(locale)));
        }
        try {
            return a.a((Locale) f7874a.invoke(null, locale));
        } catch (IllegalAccessException e11) {
            Log.w("ICUCompat", e11);
            return a.a(locale);
        } catch (InvocationTargetException e12) {
            Log.w("ICUCompat", e12);
            return a.a(locale);
        }
    }
}
