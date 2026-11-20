package com.cloud.sdk.commonutil.util;

import android.util.Log;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f30301a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f30302b = false;

    public static boolean a() {
        if (f30302b) {
            return f30301a;
        }
        boolean z11 = true;
        f30302b = true;
        try {
            String packageName = f.a().getPackageName();
            if (packageName == null) {
                return f30301a;
            }
            c.Log().d("LauncherUtil", "isLauncherHost: packageName = " + packageName);
            if (!packageName.equals("com.transsion.launcher") && !packageName.equals("com.transsion.XOSlauncher")) {
                z11 = false;
            }
            f30301a = z11;
            return z11;
        } catch (Exception e11) {
            Log.e("LauncherUtil", "isLauncherHost: " + Log.getStackTraceString(e11));
            return f30301a;
        }
    }
}
