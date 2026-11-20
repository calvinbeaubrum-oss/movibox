package io;

import android.content.ContentResolver;
import android.provider.Settings;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Method f67265a;

    static {
        Method method;
        try {
            method = (Method) a0.q("Landroid/os/SystemProperties.get(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;");
        } catch (Throwable unused) {
            method = null;
        }
        f67265a = method;
    }

    public static boolean a(ContentResolver contentResolver, String str) {
        return b(contentResolver, str, false);
    }

    public static boolean b(ContentResolver contentResolver, String str, boolean z11) {
        return c(contentResolver, str, z11 ? 1 : 0) != 0;
    }

    public static int c(ContentResolver contentResolver, String str, int i11) {
        try {
            return Settings.Global.getInt(contentResolver, str, i11);
        } catch (Throwable unused) {
            return i11;
        }
    }

    public static String d(ContentResolver contentResolver, String str) {
        return e(contentResolver, str, "");
    }

    public static String e(ContentResolver contentResolver, String str, String str2) {
        try {
            return (String) ho.q.a(Settings.Global.getString(contentResolver, str), str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    public static boolean f(ContentResolver contentResolver, String str) {
        return g(contentResolver, str, false);
    }

    public static boolean g(ContentResolver contentResolver, String str, boolean z11) {
        return h(contentResolver, str, z11 ? 1 : 0) != 0;
    }

    public static int h(ContentResolver contentResolver, String str, int i11) {
        try {
            return Settings.Secure.getInt(contentResolver, str, i11);
        } catch (Throwable unused) {
            return i11;
        }
    }

    public static String i(ContentResolver contentResolver, String str) {
        return j(contentResolver, str, "");
    }

    public static String j(ContentResolver contentResolver, String str, String str2) {
        try {
            return (String) ho.q.a(Settings.Secure.getString(contentResolver, str), str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    public static String k(String str) {
        return l(str, "");
    }

    public static String l(String str, String str2) {
        Method method = f67265a;
        if (method == null) {
            return str2;
        }
        try {
            return (String) ho.q.a((String) method.invoke(null, str, str2), str2);
        } catch (Throwable unused) {
            return str2;
        }
    }
}
