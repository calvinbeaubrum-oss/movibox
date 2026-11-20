package com.cloud.tmc.miniutils.util;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b {
    @NonNull
    public static String a() {
        return b(e0.a().getPackageName());
    }

    @NonNull
    public static String b(String str) {
        if (h0.u(str)) {
            return "";
        }
        try {
            PackageManager packageManager = e0.a().getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            return packageInfo == null ? "" : packageInfo.applicationInfo.loadLabel(packageManager).toString();
        } catch (PackageManager.NameNotFoundException e11) {
            e11.printStackTrace();
            return "";
        }
    }

    @NonNull
    public static String c() {
        return d(e0.a().getPackageName());
    }

    @NonNull
    public static String d(String str) {
        if (h0.u(str)) {
            return "";
        }
        try {
            PackageInfo packageInfo = e0.a().getPackageManager().getPackageInfo(str, 0);
            return packageInfo == null ? "" : packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e11) {
            e11.printStackTrace();
            return "";
        }
    }
}
