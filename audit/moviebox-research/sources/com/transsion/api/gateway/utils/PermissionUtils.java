package com.transsion.api.gateway.utils;

import android.os.Build;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class PermissionUtils {
    public static boolean lacksPermission(String str) {
        try {
            return Build.VERSION.SDK_INT >= 23 && ContextUtils.getContext().checkSelfPermission(str) == -1;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean lacksPermissions(String... strArr) {
        for (String str : strArr) {
            if (lacksPermission(str)) {
                return true;
            }
        }
        return false;
    }
}
