package com.cloud.sdk.commonutil.pool;

import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile b f30250b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static ThreadPoolExecutor f30251c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ThreadPoolExecutor f30252a;

    public static b b() {
        if (f30250b == null) {
            synchronized (b.class) {
                try {
                    if (f30250b == null) {
                        f30250b = new b();
                        b bVar = f30250b;
                        ThreadPoolExecutor threadPoolExecutorB = f30251c;
                        if (threadPoolExecutorB == null) {
                            threadPoolExecutorB = HSPoolExecutor.b();
                        }
                        bVar.f30252a = threadPoolExecutorB;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f30250b;
    }

    public void a(Runnable runnable) {
        ThreadPoolExecutor threadPoolExecutor = this.f30252a;
        if (threadPoolExecutor != null) {
            if (threadPoolExecutor.isShutdown()) {
                this.f30252a.prestartAllCoreThreads();
            }
            this.f30252a.execute(runnable);
        }
    }
}
