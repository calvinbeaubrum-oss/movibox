package com.alibaba.android.arouter.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.alibaba.android.arouter.facade.template.ILogger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f15382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f15383b;

    public static PackageInfo a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384);
        } catch (Exception unused) {
            com.alibaba.android.arouter.launcher.a.f15376c.error(ILogger.defaultTag, "Get package info error.");
            return null;
        }
    }

    public static boolean b(Context context) {
        PackageInfo packageInfoA = a(context);
        if (packageInfoA != null) {
            String str = packageInfoA.versionName;
            int i11 = packageInfoA.versionCode;
            SharedPreferences sharedPreferences = context.getSharedPreferences("SP_AROUTER_CACHE", 0);
            if (str.equals(sharedPreferences.getString("LAST_VERSION_NAME", null)) && i11 == sharedPreferences.getInt("LAST_VERSION_CODE", -1)) {
                return false;
            }
            f15382a = str;
            f15383b = i11;
        }
        return true;
    }

    public static void c(Context context) {
        if (TextUtils.isEmpty(f15382a) || f15383b == 0) {
            return;
        }
        context.getSharedPreferences("SP_AROUTER_CACHE", 0).edit().putString("LAST_VERSION_NAME", f15382a).putInt("LAST_VERSION_CODE", f15383b).apply();
    }
}
