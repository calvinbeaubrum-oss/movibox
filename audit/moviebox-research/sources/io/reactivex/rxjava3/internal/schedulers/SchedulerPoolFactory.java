package io.reactivex.rxjava3.internal.schedulers;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import k10.h;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public final class SchedulerPoolFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f67486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f67487b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicReference<ScheduledExecutorService> f67488c = new AtomicReference<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<ScheduledThreadPoolExecutor, Object> f67489d = new ConcurrentHashMap();

    /* JADX INFO: compiled from: source.java */
    public static final class ScheduledTask implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            for (ScheduledThreadPoolExecutor scheduledThreadPoolExecutor : new ArrayList(SchedulerPoolFactory.f67489d.keySet())) {
                if (scheduledThreadPoolExecutor.isShutdown()) {
                    SchedulerPoolFactory.f67489d.remove(scheduledThreadPoolExecutor);
                } else {
                    scheduledThreadPoolExecutor.purge();
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    public static final class a implements h<String, String> {
        @Override // k10.h
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String apply(String str) {
            return System.getProperty(str);
        }
    }

    static {
        a aVar = new a();
        boolean zB = b(true, "rx3.purge-enabled", true, true, aVar);
        f67486a = zB;
        f67487b = c(zB, "rx3.purge-period-seconds", 1, 1, aVar);
        d();
    }

    public static ScheduledExecutorService a(ThreadFactory threadFactory) {
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        e(f67486a, scheduledExecutorServiceNewScheduledThreadPool);
        return scheduledExecutorServiceNewScheduledThreadPool;
    }

    public static boolean b(boolean z11, String str, boolean z12, boolean z13, h<String, String> hVar) {
        if (!z11) {
            return z13;
        }
        try {
            String strApply = hVar.apply(str);
            return strApply == null ? z12 : "true".equals(strApply);
        } catch (Throwable th2) {
            i10.a.b(th2);
            return z12;
        }
    }

    public static int c(boolean z11, String str, int i11, int i12, h<String, String> hVar) {
        if (!z11) {
            return i12;
        }
        try {
            String strApply = hVar.apply(str);
            return strApply == null ? i11 : Integer.parseInt(strApply);
        } catch (Throwable th2) {
            i10.a.b(th2);
            return i11;
        }
    }

    public static void d() {
        f(f67486a);
    }

    public static void e(boolean z11, ScheduledExecutorService scheduledExecutorService) {
        if (z11 && (scheduledExecutorService instanceof ScheduledThreadPoolExecutor)) {
            f67489d.put((ScheduledThreadPoolExecutor) scheduledExecutorService, scheduledExecutorService);
        }
    }

    public static void f(boolean z11) {
        if (!z11) {
            return;
        }
        while (true) {
            AtomicReference<ScheduledExecutorService> atomicReference = f67488c;
            ScheduledExecutorService scheduledExecutorService = atomicReference.get();
            if (scheduledExecutorService != null) {
                return;
            }
            ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, new RxThreadFactory("RxSchedulerPurge"));
            if (l10.a.a(atomicReference, scheduledExecutorService, scheduledExecutorServiceNewScheduledThreadPool)) {
                ScheduledTask scheduledTask = new ScheduledTask();
                int i11 = f67487b;
                scheduledExecutorServiceNewScheduledThreadPool.scheduleAtFixedRate(scheduledTask, i11, i11, TimeUnit.SECONDS);
                return;
            }
            scheduledExecutorServiceNewScheduledThreadPool.shutdownNow();
        }
    }
}
