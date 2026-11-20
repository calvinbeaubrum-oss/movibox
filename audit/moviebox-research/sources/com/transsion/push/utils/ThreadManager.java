package com.transsion.push.utils;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class ThreadManager {

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static HandlerThread f57042a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static Handler f57043b;

        static {
            HandlerThread handlerThread = new HandlerThread("event-thread");
            f57042a = handlerThread;
            handlerThread.start();
            f57043b = new Handler(f57042a.getLooper());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static ExecutorService f57044a = new ThreadPoolExecutor(2, 20, 1, TimeUnit.SECONDS, new SynchronousQueue(), new g(), new ThreadPoolExecutor.DiscardPolicy());
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static ScheduledExecutorService f57045a = Executors.newSingleThreadScheduledExecutor();
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    public static class e implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Queue<Runnable> f57046a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Runnable f57047b;

        /* JADX INFO: compiled from: source.java */
        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Runnable f57048a;

            public a(Runnable runnable) {
                this.f57048a = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    this.f57048a.run();
                } finally {
                    e.this.a();
                }
            }
        }

        public e() {
            this.f57046a = new LinkedList();
        }

        public synchronized void a() {
            Runnable runnablePoll = this.f57046a.poll();
            this.f57047b = runnablePoll;
            if (runnablePoll != null) {
                ThreadManager.c().execute(this.f57047b);
            }
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(Runnable runnable) {
            this.f57046a.offer(new a(runnable));
            if (this.f57047b == null) {
                a();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static ExecutorService f57050a = Executors.newSingleThreadExecutor();
    }

    /* JADX INFO: compiled from: source.java */
    public static class g implements ThreadFactory {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final AtomicInteger f57051d = new AtomicInteger(1);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ThreadGroup f57052a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicInteger f57053b = new AtomicInteger(1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f57054c;

        public g() {
            SecurityManager securityManager = System.getSecurityManager();
            this.f57052a = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.f57054c = "tpush-pool-" + f57051d.getAndIncrement();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.f57052a, runnable, this.f57054c + this.f57053b.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    public static class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static HandlerThread f57055a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static Handler f57056b;

        static {
            HandlerThread handlerThread = new HandlerThread("globle_timer");
            f57055a = handlerThread;
            handlerThread.start();
            f57056b = new Handler(f57055a.getLooper());
        }
    }

    public static Handler b() {
        return b.f57043b;
    }

    public static ExecutorService c() {
        return c.f57044a;
    }

    public static ScheduledExecutorService d() {
        return d.f57045a;
    }

    public static ExecutorService e() {
        return f.f57050a;
    }

    public static final void execute(Runnable runnable) {
        c().execute(runnable);
    }

    public static void executeInBackground(Runnable runnable) {
        execute(runnable);
    }

    public static void executeInDbWriteThread(Runnable runnable) {
        executeInSingle(runnable);
    }

    public static void executeInSingle(Runnable runnable) {
        e().execute(runnable);
    }

    public static Handler f() {
        return h.f57056b;
    }

    public static Executor newSerialExecutor() {
        return new e();
    }

    public static void postAtTime(Runnable runnable, long j11) {
        f().postAtTime(runnable, j11);
    }

    public static void postDelayed(Runnable runnable, long j11) {
        f().postDelayed(runnable, j11);
    }

    public static void postDelayedAndRemoveBefore(Runnable runnable, long j11) {
        f().removeCallbacks(runnable);
        f().postDelayed(runnable, j11);
    }

    public static void runInEventThread(Runnable runnable) {
        b().post(runnable);
    }

    public static final ScheduledFuture<?> schedule(Runnable runnable, long j11) {
        return d().schedule(runnable, j11, TimeUnit.MILLISECONDS);
    }

    public static final <T> ScheduledFuture<T> schedule(Callable<T> callable, long j11) {
        return d().schedule(callable, j11, TimeUnit.MILLISECONDS);
    }

    public static final ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j11, long j12) {
        return d().scheduleAtFixedRate(runnable, j11, j12, TimeUnit.MILLISECONDS);
    }

    public static ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j11, long j12) {
        return d().scheduleWithFixedDelay(runnable, j11, j12, TimeUnit.MILLISECONDS);
    }

    public static final Future<?> submit(Runnable runnable) {
        return c().submit(runnable);
    }

    public static final <T> Future<T> submit(Runnable runnable, T t11) {
        return c().submit(runnable, t11);
    }

    public static final <T> Future<T> submit(Callable<T> callable) {
        return c().submit(callable);
    }

    public static Future<?> submitInSingle(Runnable runnable) {
        return e().submit(runnable);
    }

    public static <T> Future<T> submitInSingle(Runnable runnable, T t11) {
        return e().submit(runnable, t11);
    }

    public static <T> Future<T> submitInSingle(Callable<T> callable) {
        return e().submit(callable);
    }
}
