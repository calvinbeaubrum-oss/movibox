package com.transsion.core.pool;

import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class a implements b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile a f51837b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ThreadPoolExecutor f51838a;

    public static a b() {
        if (f51837b == null) {
            synchronized (a.class) {
                try {
                    if (f51837b == null) {
                        f51837b = new a();
                        f51837b.f51838a = TranssionPoolExecutor.c();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f51837b;
    }

    @Override // com.transsion.core.pool.b
    public void a(Runnable runnable) {
        ThreadPoolExecutor threadPoolExecutor = this.f51838a;
        if (threadPoolExecutor != null) {
            if (threadPoolExecutor.isShutdown()) {
                this.f51838a.prestartAllCoreThreads();
            }
            this.f51838a.execute(runnable);
        }
    }
}
