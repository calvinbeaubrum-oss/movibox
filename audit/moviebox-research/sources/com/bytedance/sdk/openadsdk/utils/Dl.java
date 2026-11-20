package com.bytedance.sdk.openadsdk.utils;

import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class Dl {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static boolean f28727sc = false;

    public static void pFF() {
        f28727sc = false;
    }

    public static void pFF(String str, String str2) {
        if (f28727sc && str2 != null) {
            Log.e(sc(str), str2);
        }
    }

    public static void pFF(String str, String str2, Object... objArr) {
        pFF(zY(str, str2), objArr);
    }

    public static void pFF(String str, Object... objArr) {
        if (f28727sc && objArr != null) {
            Log.e(sc(str), sc(objArr));
        }
    }

    private static String sc(String str) {
        if (TextUtils.isEmpty("PangleSDK-6505")) {
            return str;
        }
        return sc("[PangleSDK-6505]-[" + str + "]");
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

    public static void sc() {
        f28727sc = true;
    }

    public static void sc(String str, String str2) {
        if (f28727sc && str2 != null) {
            sc(str);
        }
    }

    public static void sc(String str, String str2, Object... objArr) {
        sc(zY(str, str2), objArr);
    }

    public static void sc(String str, Object... objArr) {
        if (f28727sc && objArr != null) {
            sc(str);
            sc(objArr);
        }
    }

    private static String zY(String str, String str2) {
        if (TextUtils.isEmpty("PangleSDK-6505")) {
            return str;
        }
        return sc(str2 + "]-[" + str);
    }
}
