package com.mbridge.msdk.e;

import android.util.Log;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f43882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Executor f43883b;

    /* JADX INFO: compiled from: source.java */
    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Runnable f43886a;

        public a(Runnable runnable) {
            this.f43886a = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (y.a(this.f43886a)) {
                return;
            }
            try {
                this.f43886a.run();
            } catch (Exception e11) {
                if (com.mbridge.msdk.e.a.f43738a) {
                    Log.e("TrackManager", "execute error", e11);
                }
            }
        }
    }

    public j() {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.f43882a = new ThreadPoolExecutor(1, 1, 0L, timeUnit, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.mbridge.msdk.e.j.1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, "MBridgeTrackThread");
            }
        }, new ThreadPoolExecutor.DiscardPolicy());
        this.f43883b = new ThreadPoolExecutor(1, 1, 0L, timeUnit, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.mbridge.msdk.e.j.2
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, "MBridgeTrackDatabaseThread");
            }
        }, new ThreadPoolExecutor.DiscardPolicy());
    }

    public final void a(Runnable runnable) {
        this.f43882a.execute(new a(runnable));
    }

    public final void b(Runnable runnable) {
        this.f43883b.execute(new a(runnable));
    }
}
