package com.blankj.utilcode.util;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c {
    @NonNull
    public static String a() {
        return b(Utils.a().getPackageName());
    }

    @NonNull
    public static String b(String str) {
        if (j0.C(str)) {
            return "";
        }
        try {
            PackageManager packageManager = Utils.a().getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            return packageInfo == null ? "" : packageInfo.applicationInfo.loadLabel(packageManager).toString();
        } catch (PackageManager.NameNotFoundException e11) {
            e11.printStackTrace();
            return "";
        }
    }

    @NonNull
    public static String c() {
        return Utils.a().getPackageName();
    }

    public static int d() {
        return e(Utils.a().getPackageName());
    }

    public static int e(String str) {
        if (j0.C(str)) {
            return -1;
        }
        try {
            PackageInfo packageInfo = Utils.a().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                return -1;
            }
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e11) {
            e11.printStackTrace();
            return -1;
        }
    }

    @NonNull
    public static String f() {
        return g(Utils.a().getPackageName());
    }

    @NonNull
    public static String g(String str) {
        if (j0.C(str)) {
            return "";
        }
        try {
            PackageInfo packageInfo = Utils.a().getPackageManager().getPackageInfo(str, 0);
            return packageInfo == null ? "" : packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e11) {
            e11.printStackTrace();
            return "";
        }
    }

    public static boolean h() {
        return i(Utils.a().getPackageName());
    }

    public static boolean i(String str) {
        if (j0.C(str)) {
            return false;
        }
        try {
            return (Utils.a().getPackageManager().getApplicationInfo(str, 0).flags & 2) != 0;
        } catch (PackageManager.NameNotFoundException e11) {
            e11.printStackTrace();
            return false;
        }
    }

    public static boolean j() {
        return j0.w();
    }

    public static boolean k(String str) {
        if (j0.C(str)) {
            return false;
        }
        try {
            return Utils.a().getPackageManager().getApplicationInfo(str, 0).enabled;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }
}
