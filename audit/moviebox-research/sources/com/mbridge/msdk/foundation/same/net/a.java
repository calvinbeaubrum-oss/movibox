package com.mbridge.msdk.foundation.same.net;

import android.net.TrafficStats;
import android.os.SystemClock;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f44526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f44527b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static long f44528c;

    /* JADX INFO: renamed from: com.mbridge.msdk.foundation.same.net.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0490a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static a f44529a = new a();
    }

    private a() {
    }

    public static a a() {
        return C0490a.f44529a;
    }

    public final synchronized void b() {
        try {
            if (f44528c != 0 && f44527b != 0) {
                long jElapsedRealtime = SystemClock.elapsedRealtime() - f44528c;
                if (jElapsedRealtime != 0) {
                    try {
                        if (TrafficStats.getTotalRxBytes() != -1) {
                            long totalRxBytes = ((TrafficStats.getTotalRxBytes() - f44527b) * 1000) / jElapsedRealtime;
                            if (totalRxBytes == 0) {
                                f44526a = 1L;
                            } else {
                                f44526a = totalRxBytes;
                            }
                        } else {
                            f44526a = 0L;
                        }
                    } catch (Exception e11) {
                        e11.printStackTrace();
                    }
                }
                c();
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized void c() {
        f44527b = 0L;
        f44528c = 0L;
    }

    public final long d() {
        return f44526a;
    }

    public final synchronized void e() {
        if (f44528c == 0) {
            f44528c = SystemClock.elapsedRealtime();
            f44527b = TrafficStats.getTotalRxBytes();
        }
    }
}
