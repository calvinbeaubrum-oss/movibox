package com.apm.insight.runtime;

import com.apm.insight.MonitorCrash;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static MonitorCrash f17086a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f17087b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f17088c;

    public static MonitorCrash a() {
        if (f17086a == null) {
            MonitorCrash monitorCrashInitSDK = MonitorCrash.initSDK(com.apm.insight.e.g(), "239017", 1030851L, "1.3.8.nourl-rc.1", "com.apm.insight");
            f17086a = monitorCrashInitSDK;
            monitorCrashInitSDK.config().setChannel("release");
        }
        return f17086a;
    }

    public static void a(Throwable th2, String str) {
        if (com.apm.insight.e.g() == null) {
            return;
        }
        if (f17087b == -1) {
            f17087b = 5;
        }
        int i11 = f17088c;
        if (i11 < f17087b) {
            f17088c = i11 + 1;
            a().reportCustomErr(str, "INNER", th2);
        }
    }
}
