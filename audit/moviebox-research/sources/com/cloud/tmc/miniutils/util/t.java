package com.cloud.tmc.miniutils.util;

import android.app.ActivityManager;
import android.app.Application;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class t {
    public static String a() throws Throwable {
        String strC = c();
        if (!TextUtils.isEmpty(strC)) {
            return strC;
        }
        String strB = b();
        return !TextUtils.isEmpty(strB) ? strB : d();
    }

    public static String b() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        String str;
        try {
            ActivityManager activityManager = (ActivityManager) e0.a().getSystemService("activity");
            if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null && runningAppProcesses.size() != 0) {
                int iMyPid = Process.myPid();
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.pid == iMyPid && (str = runningAppProcessInfo.processName) != null) {
                        return str;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return "";
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0058 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static String c() throws Throwable {
        BufferedReader bufferedReader;
        Throwable th2;
        Exception e11;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File("/proc/" + Process.myPid() + "/cmdline")));
            try {
                try {
                    String strTrim = bufferedReader.readLine().trim();
                    try {
                        bufferedReader.close();
                    } catch (IOException e12) {
                        e12.printStackTrace();
                    }
                    return strTrim;
                } catch (Exception e13) {
                    e11 = e13;
                    e11.printStackTrace();
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e14) {
                            e14.printStackTrace();
                        }
                    }
                    return "";
                }
            } catch (Throwable th3) {
                th2 = th3;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e15) {
                        e15.printStackTrace();
                    }
                }
                throw th2;
            }
        } catch (Exception e16) {
            bufferedReader = null;
            e11 = e16;
        } catch (Throwable th4) {
            bufferedReader = null;
            th2 = th4;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw th2;
        }
    }

    public static String d() {
        try {
            Application applicationA = e0.a();
            Field field = applicationA.getClass().getField("mLoadedApk");
            field.setAccessible(true);
            Object obj = field.get(applicationA);
            Field declaredField = obj.getClass().getDeclaredField("mActivityThread");
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(obj);
            return (String) obj2.getClass().getDeclaredMethod("getProcessName", new Class[0]).invoke(obj2, new Object[0]);
        } catch (Exception e11) {
            e11.printStackTrace();
            return "";
        }
    }

    public static boolean e() {
        try {
            String strA = a();
            return (strA == null || TextUtils.isEmpty(strA) || !strA.contains(":mini")) ? false : true;
        } catch (Throwable th2) {
            Log.e("isMiniProcess", "isMiniProcess: ", th2);
            return false;
        }
    }
}
