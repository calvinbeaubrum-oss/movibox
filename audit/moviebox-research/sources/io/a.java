package io;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import android.util.Log;
import androidx.annotation.Nullable;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.android.gms.common.api.Api;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class a {
    public static String a(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        int i11;
        String str = "";
        String processName = Build.VERSION.SDK_INT >= 28 ? Application.getProcessName() : "";
        if (com.google.common.base.p.b(processName)) {
            try {
                processName = (String) Class.forName("android.app.ActivityThread").getDeclaredMethod("currentProcessName", null).invoke(null, null);
            } catch (Throwable th2) {
                Log.w("AndroidContexts", "Failed to query process name", th2);
            }
        }
        str = processName;
        ActivityManager activityManager = (ActivityManager) e(context, ActivityManager.class, "activity");
        int iMyPid = Process.myPid();
        if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
            if (com.google.common.base.p.b(str)) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.pid == iMyPid) {
                        str = runningAppProcessInfo.processName;
                        break;
                    }
                }
            }
            if (!com.google.common.base.p.b(str)) {
                int iMin = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo2 : runningAppProcesses) {
                    if (str.equals(runningAppProcessInfo2.processName) && (i11 = runningAppProcessInfo2.pid) != iMyPid) {
                        iMin = Math.min(iMin, i11);
                    }
                }
                if (iMin != Integer.MAX_VALUE) {
                    str = str + InstructionFileId.DOT + (iMyPid - iMin);
                }
            }
        }
        return com.google.common.base.p.b(str) ? Integer.toString(iMyPid) : str;
    }

    public static boolean b(Context context, String... strArr) {
        for (String str : strArr) {
            if (c(context, str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean c(Context context, String str) {
        try {
            return context.checkCallingOrSelfPermission(str) == 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean d(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        try {
            return packageManager.hasSystemFeature(str);
        } catch (Throwable unused) {
            return false;
        }
    }

    @Nullable
    public static <T> T e(Context context, Class<T> cls, String str) {
        try {
            T t11 = (T) context.getSystemService(str);
            if (t11 == null || !cls.isInstance(t11)) {
                return null;
            }
            return t11;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static <T, R> R f(Context context, Class<T> cls, String str, com.google.common.base.f<T, R> fVar) {
        Object objE = e(context, cls, str);
        if (objE == null) {
            return null;
        }
        try {
            return (R) fVar.apply(objE);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static <T, R> R g(Context context, Class<T> cls, String str, com.google.common.base.f<T, R> fVar, R r11) {
        return (R) ho.q.a(f(context, cls, str, fVar), r11);
    }
}
