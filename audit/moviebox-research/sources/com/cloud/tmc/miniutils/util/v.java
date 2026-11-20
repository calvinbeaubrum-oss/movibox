package com.cloud.tmc.miniutils.util;

import android.os.Environment;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class v {
    public static long a() {
        return h0.j(e());
    }

    public static long b() {
        return h0.k(e());
    }

    public static long c() {
        return h0.j(Environment.getDataDirectory().getAbsolutePath());
    }

    public static long d() {
        return h0.k(Environment.getDataDirectory().getAbsolutePath());
    }

    public static String e() {
        return f() ? Environment.getExternalStorageDirectory().getAbsolutePath() : "";
    }

    public static boolean f() {
        return "mounted".equals(Environment.getExternalStorageState());
    }
}
