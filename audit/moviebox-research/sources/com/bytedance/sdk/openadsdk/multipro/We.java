package com.bytedance.sdk.openadsdk.multipro;

import com.bytedance.sdk.openadsdk.core.Xc;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class We {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static String f28615sc = "com.bytedance.openadsdk";
    public static String pFF = "content://" + f28615sc + ".TTMultiProvider";

    static {
        sc();
    }

    public static void sc() {
        if (Xc.sc() != null) {
            f28615sc = Xc.sc().getPackageName();
            pFF = "content://" + f28615sc + ".TTMultiProvider";
        }
    }
}
