package com.mbridge.msdk.foundation.same.f;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ThreadPoolExecutor f44515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ThreadPoolExecutor f44516b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static ThreadPoolExecutor f44517c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static ThreadPoolExecutor f44518d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Handler f44519e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static ThreadPoolExecutor f44520f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static ThreadPoolExecutor f44521g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static ThreadPoolExecutor f44522h;

    /* JADX INFO: compiled from: source.java */
    public static class a extends Handler {
        public a() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
        }
    }

    public static ThreadPoolExecutor a() {
        if (f44516b == null) {
            f44516b = new ThreadPoolExecutor(2, 5, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(10), new ThreadFactory() { // from class: com.mbridge.msdk.foundation.same.f.b.1
                @Override // java.util.concurrent.ThreadFactory
                public final Thread newThread(Runnable runnable) {
                    Thread threadNewThread = Executors.defaultThreadFactory().newThread(runnable);
                    threadNewThread.setName("BitmapThreadPool");
                    return threadNewThread;
                }
            }, new ThreadPoolExecutor.DiscardPolicy());
        }
        return f44516b;
    }

    public static ThreadPoolExecutor b() {
        if (f44515a == null) {
            f44515a = new ThreadPoolExecutor(5, 15, 15L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(100), new ThreadFactory() { // from class: com.mbridge.msdk.foundation.same.f.b.2
                @Override // java.util.concurrent.ThreadFactory
                public final Thread newThread(Runnable runnable) {
                    Thread threadNewThread = Executors.defaultThreadFactory().newThread(runnable);
                    threadNewThread.setName("CommonThreadPool");
                    return threadNewThread;
                }
            }, new ThreadPoolExecutor.DiscardPolicy());
        }
        return f44515a;
    }

    public static ThreadPoolExecutor c() {
        if (f44517c == null) {
            ThreadFactory threadFactory = new ThreadFactory() { // from class: com.mbridge.msdk.foundation.same.f.b.3
                @Override // java.util.concurrent.ThreadFactory
                public final Thread newThread(Runnable runnable) {
                    Thread threadNewThread = Executors.defaultThreadFactory().newThread(runnable);
                    threadNewThread.setName("mb-image-download-tread");
                    return threadNewThread;
                }
            };
            int iAvailableProcessors = (Runtime.getRuntime().availableProcessors() * 2) + 1;
            f44517c = new ThreadPoolExecutor(iAvailableProcessors, iAvailableProcessors, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(30), threadFactory, new ThreadPoolExecutor.DiscardPolicy());
        }
        return f44517c;
    }

    public static ThreadPoolExecutor d() {
        if (f44518d == null) {
            ThreadFactory threadFactory = new ThreadFactory() { // from class: com.mbridge.msdk.foundation.same.f.b.4
                @Override // java.util.concurrent.ThreadFactory
                public final Thread newThread(Runnable runnable) {
                    Thread threadNewThread = Executors.defaultThreadFactory().newThread(runnable);
                    threadNewThread.setName("mb-image-download-tread");
                    return threadNewThread;
                }
            };
            int iAvailableProcessors = (Runtime.getRuntime().availableProcessors() * 2) + 1;
            f44518d = new ThreadPoolExecutor(iAvailableProcessors, iAvailableProcessors, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(30), threadFactory, new ThreadPoolExecutor.DiscardPolicy());
        }
        return f44518d;
    }

    public static Handler e() {
        if (f44519e == null) {
            f44519e = new a();
        }
        return f44519e;
    }

    public static ThreadPoolExecutor f() {
        if (f44520f == null) {
            f44520f = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(1), new ThreadFactory() { // from class: com.mbridge.msdk.foundation.same.f.b.5
                @Override // java.util.concurrent.ThreadFactory
                public final Thread newThread(Runnable runnable) {
                    Thread threadNewThread = Executors.defaultThreadFactory().newThread(runnable);
                    threadNewThread.setName("NwtThreadPool");
                    return threadNewThread;
                }
            }, new ThreadPoolExecutor.DiscardPolicy());
        }
        return f44520f;
    }

    public static ThreadPoolExecutor g() {
        if (f44521g == null) {
            f44521g = new ThreadPoolExecutor(5, 15, 5L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(100), new ThreadFactory() { // from class: com.mbridge.msdk.foundation.same.f.b.6
                @Override // java.util.concurrent.ThreadFactory
                public final Thread newThread(Runnable runnable) {
                    Thread threadNewThread = Executors.defaultThreadFactory().newThread(runnable);
                    threadNewThread.setName("ReportThreadPool");
                    return threadNewThread;
                }
            }, new ThreadPoolExecutor.DiscardPolicy());
        }
        return f44521g;
    }

    public static ThreadPoolExecutor h() {
        if (f44522h == null) {
            ThreadFactory threadFactory = new ThreadFactory() { // from class: com.mbridge.msdk.foundation.same.f.b.7
                @Override // java.util.concurrent.ThreadFactory
                public final Thread newThread(Runnable runnable) {
                    Thread thread = new Thread(runnable);
                    thread.setName("rv-load-tread");
                    return thread;
                }
            };
            int iAvailableProcessors = (Runtime.getRuntime().availableProcessors() * 2) + 1;
            f44522h = new ThreadPoolExecutor(iAvailableProcessors, iAvailableProcessors * 2, 5L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(30), threadFactory, new ThreadPoolExecutor.DiscardPolicy());
        }
        return f44522h;
    }
}
