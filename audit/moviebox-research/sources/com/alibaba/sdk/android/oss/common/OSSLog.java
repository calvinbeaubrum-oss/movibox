package com.alibaba.sdk.android.oss.common;

import android.util.Log;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class OSSLog {
    private static final String TAG = "OSS-Android-SDK";
    private static boolean enableLog = false;

    public static void disableLog() {
        enableLog = false;
    }

    public static void enableLog() {
        enableLog = true;
    }

    public static boolean isEnableLog() {
        return enableLog;
    }

    private static void log2Local(String str, boolean z11) {
        if (z11) {
            OSSLogToFileUtils.getInstance().write(str);
        }
    }

    public static void logDebug(String str) {
        logDebug(TAG, str);
    }

    public static void logDebug(String str, String str2) {
        logDebug(str, str2, true);
    }

    public static void logDebug(String str, String str2, boolean z11) {
        if (enableLog) {
            "[Debug]: ".concat(str2);
            log2Local(str2, z11);
        }
    }

    public static void logDebug(String str, boolean z11) {
        logDebug(TAG, str, z11);
    }

    public static void logError(String str) {
        logError(TAG, str);
    }

    public static void logError(String str, String str2) {
        logDebug(str, str2, true);
    }

    public static void logError(String str, String str2, boolean z11) {
        if (enableLog) {
            "[Error]: ".concat(str2);
            log2Local(str2, z11);
        }
    }

    public static void logError(String str, boolean z11) {
        logError(TAG, str, z11);
    }

    public static void logInfo(String str) {
        logInfo(str, true);
    }

    public static void logInfo(String str, boolean z11) {
        if (enableLog) {
            "[INFO]: ".concat(str);
            log2Local(str, z11);
        }
    }

    public static void logThrowable2Local(Throwable th2) {
        if (enableLog) {
            OSSLogToFileUtils.getInstance().write(th2);
        }
    }

    public static void logVerbose(String str) {
        logVerbose(str, true);
    }

    public static void logVerbose(String str, boolean z11) {
        if (enableLog) {
            Log.v(TAG, "[Verbose]: ".concat(str));
            log2Local(str, z11);
        }
    }

    public static void logWarn(String str) {
        logWarn(str, true);
    }

    public static void logWarn(String str, boolean z11) {
        if (enableLog) {
            Log.w(TAG, "[Warn]: ".concat(str));
            log2Local(str, z11);
        }
    }
}
