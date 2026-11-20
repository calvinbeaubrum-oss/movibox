package com.mbridge.msdk.foundation.tools;

import android.text.TextUtils;
import android.util.Log;
import com.mbridge.msdk.MBridgeConstans;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class ad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f44958a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f44959b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f44960c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f44961d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f44962e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f44963f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f44964g = true;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f44965h = true;

    static {
        if (MBridgeConstans.DEBUG) {
            return;
        }
        f44964g = false;
        f44958a = false;
        f44960c = false;
        f44965h = false;
        f44959b = false;
        f44963f = false;
        f44962e = false;
        f44961d = false;
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        return "MBRIDGE_" + str;
    }

    public static void a(String str, String str2) {
        if (!f44958a || TextUtils.isEmpty(str2)) {
            return;
        }
        a(str);
    }

    public static void a(String str, String str2, Throwable th2) {
        if (!f44959b || str2 == null || th2 == null) {
            return;
        }
        Log.e(a(str), str2, th2);
    }

    public static void a(String str, Throwable th2) {
        if (!f44965h || th2 == null) {
            return;
        }
        Log.w(a(str), th2);
    }

    public static void b(String str, String str2) {
        if (!f44959b || str2 == null) {
            return;
        }
        Log.e(a(str), str2);
    }

    public static void b(String str, String str2, Throwable th2) {
        if (!f44965h || TextUtils.isEmpty(str2)) {
            return;
        }
        Log.w(a(str), str2, th2);
    }

    public static void c(String str, String str2) {
        if (!f44960c || TextUtils.isEmpty(str2)) {
            return;
        }
        a(str);
    }

    public static void d(String str, String str2) {
        if (!f44965h || TextUtils.isEmpty(str2)) {
            return;
        }
        Log.w(a(str), str2);
    }
}
