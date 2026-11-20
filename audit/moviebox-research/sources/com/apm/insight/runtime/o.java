package com.apm.insight.runtime;

import android.system.Os;
import android.system.OsConstants;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f17104a = -1;

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static long f17105a = -1;

        public static long a() {
            if (o.f17104a == -1) {
                long jSysconf = f17105a;
                if (jSysconf <= 0) {
                    jSysconf = Os.sysconf(OsConstants._SC_CLK_TCK);
                    if (jSysconf <= 0) {
                        jSysconf = 100;
                    }
                    f17105a = jSysconf;
                }
                long unused = o.f17104a = 1000 / jSysconf;
            }
            return o.f17104a;
        }

        private static long a(String str) {
            try {
                int i11 = Class.forName("libcore.io.OsConstants").getField(str).getInt(null);
                Class<?> cls = Class.forName("libcore.io.Libcore");
                Class<?> cls2 = Class.forName("libcore.io.Os");
                return ((Long) cls2.getMethod("sysconf", Integer.TYPE).invoke(cls.getField("os").get(null), Integer.valueOf(i11))).longValue();
            } catch (Throwable th2) {
                th2.printStackTrace();
                return 100L;
            }
        }
    }
}
