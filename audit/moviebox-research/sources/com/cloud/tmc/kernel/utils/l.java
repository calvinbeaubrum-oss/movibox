package com.cloud.tmc.kernel.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniutils.util.e0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Boolean f31288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Boolean f31289b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f31290c;

    @NonNull
    public static Context a() {
        return e0.a();
    }

    public static int b() {
        return Process.myPid();
    }

    @Nullable
    public static String c() {
        try {
            if (!TextUtils.isEmpty(f31290c)) {
                return f31290c;
            }
            try {
                f31290c = (String) m.d(m.e("android.app.ActivityThread", "currentActivityThread"), "getProcessName");
                TmcLogger.c("TmcKernel", "getProcessName from ActivityThread: " + f31290c);
            } catch (Throwable th2) {
                TmcLogger.g("TmcKernel", "getProcessName error!", th2);
            }
            if (f31290c == null) {
                Context contextA = a();
                int iMyPid = Process.myPid();
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) contextA.getSystemService("activity")).getRunningAppProcesses()) {
                    if (runningAppProcessInfo.pid == iMyPid) {
                        f31290c = runningAppProcessInfo.processName;
                    }
                }
            }
        } catch (Exception e11) {
            TmcLogger.g("TmcKernel", "getProcessName error", e11);
        }
        return f31290c;
    }

    public static boolean d() {
        if (f31288a == null) {
            Context contextA = a();
            String strC = c();
            f31288a = Boolean.valueOf(TextUtils.equals(strC, contextA.getPackageName()));
            TmcLogger.c("TmcKernel", "isMainProcess " + f31288a + " processName: " + strC + " stack: " + Log.getStackTraceString(new Throwable("Just Print!")));
        }
        return f31288a.booleanValue();
    }

    public static boolean e() {
        if (f31289b == null) {
            String strC = c();
            f31289b = Boolean.valueOf((strC == null || TextUtils.isEmpty(strC) || !strC.contains(":mini")) ? false : true);
        }
        return f31289b.booleanValue();
    }
}
