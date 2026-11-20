package com.cloud.tmc.kernel.log;

import android.util.Log;
import com.cloud.tmc.kernel.proxy.performanceanalyse.LogEProxy;
import tc.a;
import zb.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class TmcLogger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f31197a = Log.isLoggable("miniapp", 3);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Proxy f31198b = new DefaultLoggerImpl();

    /* JADX INFO: compiled from: source.java */
    public static class DefaultLoggerImpl implements Proxy {
        @Override // com.cloud.tmc.kernel.log.TmcLogger.Proxy
        public void d(String str, String str2) {
            boolean unused = TmcLogger.f31197a;
        }

        @Override // com.cloud.tmc.kernel.log.TmcLogger.Proxy
        public void debug(String str, String str2) {
            boolean unused = TmcLogger.f31197a;
        }

        @Override // com.cloud.tmc.kernel.log.TmcLogger.Proxy
        public void e(String str, String str2, Throwable th2) {
            Log.e(str, str2, th2);
            ((LogEProxy) a.a(LogEProxy.class)).e(str, str2);
        }

        @Override // com.cloud.tmc.kernel.log.TmcLogger.Proxy
        public void i(String str, String str2) {
            boolean unused = TmcLogger.f31197a;
        }

        @Override // com.cloud.tmc.kernel.log.TmcLogger.Proxy
        public void v(String str, String str2) {
            if (TmcLogger.f31197a) {
                Log.v(str, str2);
            }
        }

        @Override // com.cloud.tmc.kernel.log.TmcLogger.Proxy
        public void w(String str, String str2, Throwable th2) {
            if (TmcLogger.f31197a) {
                Log.w(str, str2, th2);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @c("com.cloud.tmc.kernel.log.TmcLogger$DefaultLoggerImpl")
    public interface Proxy {
        void d(String str, String str2);

        void debug(String str, String str2);

        void e(String str, String str2, Throwable th2);

        void i(String str, String str2);

        void v(String str, String str2);

        void w(String str, String str2, Throwable th2);
    }

    public static void b(String str) {
        c("TmcLogger", str);
    }

    public static void c(String str, String str2) {
        if (l(str2)) {
            return;
        }
        j().d(str, str2);
    }

    public static void d(String str, String str2) {
        if (l(str2)) {
            return;
        }
        j().debug(str, str2);
    }

    public static void e(String str) {
        g("TmcLogger", str, null);
    }

    public static void f(String str, String str2) {
        g(str, str2, null);
    }

    public static void g(String str, String str2, Throwable th2) {
        j().e(str, str2, th2);
    }

    public static void h(String str, Throwable th2) {
        g("TmcLogger", str, th2);
    }

    public static void i(boolean z11) {
        if (z11) {
            f31197a = true;
        }
    }

    public static Proxy j() {
        Proxy proxy = (Proxy) a.a(Proxy.class);
        return proxy != null ? proxy : f31198b;
    }

    public static void k(String str, String str2) {
        if (l(str2)) {
            return;
        }
        j().i(str, str2);
    }

    public static boolean l(String str) {
        return str == null || "".equals(str);
    }

    public static void m(String str, String str2) {
        Log.e("TmcPerformance", "[Thread:" + Thread.currentThread().getName() + "] [Stage:" + str + "] [Info:" + str2 + "] [TimeStamp:" + System.currentTimeMillis() + "]");
    }

    public static void n(String str) {
        o("TmcLogger", str);
    }

    public static void o(String str, String str2) {
        if (l(str2)) {
            return;
        }
        j().w(str, str2, null);
    }

    public static void p(String str, String str2, Throwable th2) {
        j().w(str, str2, th2);
    }
}
