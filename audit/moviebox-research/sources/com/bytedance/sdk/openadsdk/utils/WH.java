package com.bytedance.sdk.openadsdk.utils;

import android.text.TextUtils;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class WH {
    private static String pFF(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return com.bytedance.sdk.openadsdk.multipro.We.We.pFF(null, str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    public static String sc() {
        return pFF("any_door_id", null);
    }

    public static void sc(String str) {
        sc("any_door_id", str);
    }

    private static void sc(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.multipro.We.We.sc((String) null, str, str2);
        } catch (Throwable unused) {
        }
    }
}
