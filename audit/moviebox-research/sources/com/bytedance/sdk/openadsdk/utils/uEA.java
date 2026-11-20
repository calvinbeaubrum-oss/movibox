package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class uEA {
    public static String sc(Context context) {
        int iSc = com.bytedance.sdk.component.utils.uEA.sc(context, 0L);
        if (iSc == 2) {
            return "2g";
        }
        if (iSc == 3) {
            return "3g";
        }
        if (iSc == 4) {
            return "wifi";
        }
        if (iSc != 5) {
            return iSc != 6 ? "mobile" : "5g";
        }
        return "4g";
    }
}
