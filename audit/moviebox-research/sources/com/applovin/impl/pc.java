package com.applovin.impl;

import android.text.TextUtils;
import android.util.Log;
import java.net.UnknownHostException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class pc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f21708a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f21709b = true;

    private static String a(String str, Throwable th2) {
        String strA = a(th2);
        if (TextUtils.isEmpty(strA)) {
            return str;
        }
        return str + "\n  " + strA.replace("\n", "\n  ") + '\n';
    }

    public static String a(Throwable th2) {
        if (th2 == null) {
            return null;
        }
        if (b(th2)) {
            return "UnknownHostException (no network)";
        }
        return !f21709b ? th2.getMessage() : Log.getStackTraceString(th2).trim().replace("\t", "    ");
    }

    public static void a(String str, String str2) {
    }

    public static void a(String str, String str2, Throwable th2) {
        b(str, a(str2, th2));
    }

    public static void b(String str, String str2) {
        if (f21708a <= 3) {
            Log.e(str, str2);
        }
    }

    public static void b(String str, String str2, Throwable th2) {
        c(str, a(str2, th2));
    }

    private static boolean b(Throwable th2) {
        while (th2 != null) {
            if (th2 instanceof UnknownHostException) {
                return true;
            }
            th2 = th2.getCause();
        }
        return false;
    }

    public static void c(String str, String str2) {
    }

    public static void c(String str, String str2, Throwable th2) {
        d(str, a(str2, th2));
    }

    public static void d(String str, String str2) {
        if (f21708a <= 2) {
            Log.w(str, str2);
        }
    }
}
