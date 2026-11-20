package com.bytedance.sdk.openadsdk.utils;

import android.content.SharedPreferences;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class FI {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static boolean f28730sc = sc();

    public static void sc(int i11) {
        try {
            SharedPreferences.Editor editorEdit = com.bytedance.sdk.openadsdk.core.Xc.sc().getSharedPreferences("pag_sp_prop_switch", 0).edit();
            editorEdit.putInt("perf_con_use_prop", i11);
            editorEdit.apply();
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.Tf.pFF(th2.getMessage());
        }
    }

    private static boolean sc() {
        SharedPreferences sharedPreferences;
        try {
            return com.bytedance.sdk.openadsdk.core.Xc.sc() == null || (sharedPreferences = com.bytedance.sdk.openadsdk.core.Xc.sc().getSharedPreferences("pag_sp_prop_switch", 0)) == null || sharedPreferences.getInt("perf_con_use_prop", 1) == 1;
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.Tf.pFF(th2.getMessage());
        }
        return true;
    }
}
