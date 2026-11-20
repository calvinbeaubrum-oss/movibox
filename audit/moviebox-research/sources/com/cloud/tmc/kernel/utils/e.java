package com.cloud.tmc.kernel.utils;

import android.os.Handler;
import android.os.Looper;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.executor.IExecutorService;
import com.cloud.tmc.kernel.log.TmcLogger;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Handler f31284a = new Handler(Looper.getMainLooper());

    public static void a(ExecutorType executorType, Runnable runnable) {
        Executor executor = ((IExecutorService) tc.a.a(IExecutorService.class)).getExecutor(executorType);
        if (executor != null) {
            executor.execute(runnable);
            return;
        }
        TmcLogger.f("ExecutorUtils", "execute: executor is null! threadType = " + executorType);
    }

    public static ScheduledThreadPoolExecutor b() {
        return ((IExecutorService) tc.a.a(IExecutorService.class)).getScheduledExecutor();
    }

    public static boolean c() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static void d(Runnable runnable) {
        f31284a.post(runnable);
    }

    public static void e(Runnable runnable) {
        f31284a.removeCallbacks(runnable);
    }

    public static void f(Runnable runnable) {
        if (c()) {
            runnable.run();
        } else {
            f31284a.post(runnable);
        }
    }

    public static void g(Runnable runnable, long j11) {
        f31284a.postDelayed(runnable, j11);
    }
}
