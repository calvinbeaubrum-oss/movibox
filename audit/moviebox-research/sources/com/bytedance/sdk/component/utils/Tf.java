package com.bytedance.sdk.component.utils;

import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Tf {
    private static String We = "";
    private static int pFF = 4;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static boolean f27031sc = false;
    private static com.bytedance.sdk.component.sc zY;

    public static boolean We() {
        return f27031sc;
    }

    public static String pFF(String str, String str2) {
        if (TextUtils.isEmpty(We)) {
            return str;
        }
        return sc(str2 + "]-[" + str);
    }

    public static void pFF() {
        f27031sc = true;
        sc(3);
    }

    public static void pFF(String str) {
        if (f27031sc) {
            sc("Logger", str);
        }
    }

    private static String sc(Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        for (Object obj : objArr) {
            if (obj != null) {
                sb2.append(obj.toString());
            } else {
                sb2.append(" null ");
            }
            sb2.append(" ");
        }
        return sb2.toString();
    }

    public static void sc(int i11) {
        pFF = i11;
    }

    public static void sc(String str) {
        We = str;
    }

    public static void sc(String str, String str2) {
        if (zY != null) {
            zY(str);
        }
        if (f27031sc && str2 != null && pFF <= 6) {
            Log.e(zY(str), str2);
        }
    }

    public static void sc(String str, String str2, String str3, Throwable th2) {
        if (f27031sc) {
            sc(pFF(str, str2), str3, th2);
        }
    }

    public static void sc(String str, String str2, Throwable th2) {
        if (zY != null) {
            zY(str);
        }
        if (f27031sc) {
            if (!(str2 == null && th2 == null) && pFF <= 6) {
                Log.e(zY(str), str2, th2);
            }
        }
    }

    public static void sc(String str, Object... objArr) {
        if (zY != null) {
            zY(str);
            sc(objArr);
        }
        if (f27031sc && objArr != null && pFF <= 6) {
            Log.e(zY(str), sc(objArr));
        }
    }

    public static boolean sc() {
        return pFF <= 3;
    }

    public static String zY(String str) {
        if (TextUtils.isEmpty(We)) {
            return str;
        }
        return sc("[" + We + "]-[" + str + "]");
    }

    public static void zY() {
        f27031sc = false;
        sc(7);
    }
}
