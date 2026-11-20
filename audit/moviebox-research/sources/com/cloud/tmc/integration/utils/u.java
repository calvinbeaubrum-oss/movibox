package com.cloud.tmc.integration.utils;

import android.os.SystemClock;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f31132a;

    public static boolean a() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j11 = jElapsedRealtime - f31132a;
        if (j11 > 400) {
            f31132a = jElapsedRealtime;
            return false;
        }
        if (j11 >= 0) {
            return true;
        }
        f31132a = 0L;
        return false;
    }
}
