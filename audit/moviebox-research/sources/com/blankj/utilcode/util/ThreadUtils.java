package com.blankj.utilcode.util;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public final class ThreadUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f25254a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<Integer, Map<Integer, ExecutorService>> f25255b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<Task, ExecutorService> f25256c = new ConcurrentHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f25257d = Runtime.getRuntime().availableProcessors();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Timer f25258e = new Timer();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Executor f25259f;

    /* JADX INFO: renamed from: com.blankj.utilcode.util.ThreadUtils$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes3.dex */
    class AnonymousClass1 extends TimerTask {
        final /* synthetic */ ExecutorService val$pool;
        final /* synthetic */ Task val$task;

        public AnonymousClass1(ExecutorService executorService, Task task) {
            this.val$pool = executorService;
            this.val$task = task;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            this.val$pool.execute(this.val$task);
        }
    }

    /* JADX INFO: renamed from: com.blankj.utilcode.util.ThreadUtils$2, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes3.dex */
    class AnonymousClass2 extends TimerTask {
        final /* synthetic */ ExecutorService val$pool;
        final /* synthetic */ Task val$task;

        public AnonymousClass2(ExecutorService executorService, Task task) {
            this.val$pool = executorService;
            this.val$task = task;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            this.val$pool.execute(this.val$task);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class LinkedBlockingQueue4Util extends LinkedBlockingQueue<Runnable> {
        private int mCapacity;
        private volatile b mPool;

        public LinkedBlockingQueue4Util() {
            this.mCapacity = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        }

        public LinkedBlockingQueue4Util(int i11) {
            this.mCapacity = i11;
        }

        public LinkedBlockingQueue4Util(boolean z11) {
            this.mCapacity = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            if (z11) {
                this.mCapacity = 0;
            }
        }

        @Override // java.util.concurrent.LinkedBlockingQueue, java.util.Queue, java.util.concurrent.BlockingQueue
        public boolean offer(@NonNull Runnable runnable) {
            if (this.mCapacity > size() || this.mPool == null || this.mPool.getPoolSize() >= this.mPool.getMaximumPoolSize()) {
                return super.offer(runnable);
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes3.dex */
    public static abstract class SimpleTask<T> extends Task<T> {
        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        public void onCancel() {
            Log.e("ThreadUtils", "onCancel: " + Thread.currentThread());
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        public void onFail(Throwable th2) {
            Log.e("ThreadUtils", "onFail: ", th2);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes3.dex */
    public static abstract class Task<T> implements Runnable {
        private static final int CANCELLED = 4;
        private static final int COMPLETING = 3;
        private static final int EXCEPTIONAL = 2;
        private static final int INTERRUPTED = 5;
        private static final int NEW = 0;
        private static final int RUNNING = 1;
        private static final int TIMEOUT = 6;
        private Executor deliver;
        private volatile boolean isSchedule;
        private a mTimeoutListener;
        private long mTimeoutMillis;
        private Timer mTimer;
        private volatile Thread runner;
        private final AtomicInteger state = new AtomicInteger(0);

        /* JADX INFO: renamed from: com.blankj.utilcode.util.ThreadUtils$Task$1, reason: invalid class name */
        /* JADX INFO: compiled from: source.java */
        public class AnonymousClass1 extends TimerTask {
            public AnonymousClass1() {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (Task.this.isDone()) {
                    return;
                }
                Task.access$400(Task.this);
            }
        }

        /* JADX INFO: compiled from: source.java */
        public interface a {
        }

        public static /* synthetic */ a access$400(Task task) {
            task.getClass();
            return null;
        }

        private Executor getDeliver() {
            Executor executor = this.deliver;
            return executor == null ? ThreadUtils.e() : executor;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSchedule(boolean z11) {
            this.isSchedule = z11;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void timeout() {
            synchronized (this.state) {
                try {
                    if (this.state.get() > 1) {
                        return;
                    }
                    this.state.set(6);
                    if (this.runner != null) {
                        this.runner.interrupt();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        public void cancel() {
            cancel(true);
        }

        public void cancel(boolean z11) {
            synchronized (this.state) {
                try {
                    if (this.state.get() > 1) {
                        return;
                    }
                    this.state.set(4);
                    if (z11 && this.runner != null) {
                        this.runner.interrupt();
                    }
                    getDeliver().execute(new Runnable() { // from class: com.blankj.utilcode.util.ThreadUtils.Task.5
                        @Override // java.lang.Runnable
                        public void run() {
                            Task.this.onCancel();
                            Task.this.onDone();
                        }
                    });
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        public abstract T doInBackground() throws Throwable;

        public boolean isCanceled() {
            return this.state.get() >= 4;
        }

        public boolean isDone() {
            return this.state.get() > 1;
        }

        public abstract void onCancel();

        @CallSuper
        public void onDone() {
            ThreadUtils.f25256c.remove(this);
            Timer timer = this.mTimer;
            if (timer != null) {
                timer.cancel();
                this.mTimer = null;
            }
        }

        public abstract void onFail(Throwable th2);

        public abstract void onSuccess(T t11);

        @Override // java.lang.Runnable
        public void run() {
            if (this.isSchedule) {
                if (this.runner == null) {
                    if (!this.state.compareAndSet(0, 1)) {
                        return;
                    } else {
                        this.runner = Thread.currentThread();
                    }
                } else if (this.state.get() != 1) {
                    return;
                }
            } else if (!this.state.compareAndSet(0, 1)) {
                return;
            } else {
                this.runner = Thread.currentThread();
            }
            try {
                final T tDoInBackground = doInBackground();
                if (this.isSchedule) {
                    if (this.state.get() != 1) {
                        return;
                    }
                    getDeliver().execute(new Runnable() { // from class: com.blankj.utilcode.util.ThreadUtils.Task.2
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.lang.Runnable
                        public void run() {
                            Task.this.onSuccess(tDoInBackground);
                        }
                    });
                } else if (this.state.compareAndSet(1, 3)) {
                    getDeliver().execute(new Runnable() { // from class: com.blankj.utilcode.util.ThreadUtils.Task.3
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.lang.Runnable
                        public void run() {
                            Task.this.onSuccess(tDoInBackground);
                            Task.this.onDone();
                        }
                    });
                }
            } catch (InterruptedException unused) {
                this.state.compareAndSet(4, 5);
            } catch (Throwable th2) {
                if (this.state.compareAndSet(1, 2)) {
                    getDeliver().execute(new Runnable() { // from class: com.blankj.utilcode.util.ThreadUtils.Task.4
                        @Override // java.lang.Runnable
                        public void run() {
                            Task.this.onFail(th2);
                            Task.this.onDone();
                        }
                    });
                }
            }
        }

        public Task<T> setDeliver(Executor executor) {
            this.deliver = executor;
            return this;
        }

        public Task<T> setTimeout(long j11, a aVar) {
            this.mTimeoutMillis = j11;
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class UtilsThreadFactory extends AtomicLong implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AtomicInteger f25260a = new AtomicInteger(1);
        private static final long serialVersionUID = -9209200509960368598L;
        private final boolean isDaemon;
        private final String namePrefix;
        private final int priority;

        /* JADX INFO: compiled from: source.java */
        /* JADX INFO: loaded from: classes3.dex */
        public class a implements Thread.UncaughtExceptionHandler {
            public a() {
            }

            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th2) {
                System.out.println(th2);
            }
        }

        public UtilsThreadFactory(String str, int i11) {
            this(str, i11, false);
        }

        public UtilsThreadFactory(String str, int i11, boolean z11) {
            this.namePrefix = str + "-pool-" + f25260a.getAndIncrement() + "-thread-";
            this.priority = i11;
            this.isDaemon = z11;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            Thread thread = new Thread(runnable, this.namePrefix + getAndIncrement()) { // from class: com.blankj.utilcode.util.ThreadUtils.UtilsThreadFactory.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        super.run();
                    } catch (Throwable th2) {
                        Log.e("ThreadUtils", "Request threw uncaught throwable", th2);
                    }
                }
            };
            thread.setDaemon(this.isDaemon);
            thread.setUncaughtExceptionHandler(new a());
            thread.setPriority(this.priority);
            return thread;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes3.dex */
    public class a implements Executor {
        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            ThreadUtils.j(runnable);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes3.dex */
    public static final class b extends ThreadPoolExecutor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicInteger f25262a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public LinkedBlockingQueue4Util f25263b;

        public b(int i11, int i12, long j11, TimeUnit timeUnit, LinkedBlockingQueue4Util linkedBlockingQueue4Util, ThreadFactory threadFactory) {
            super(i11, i12, j11, timeUnit, linkedBlockingQueue4Util, threadFactory);
            this.f25262a = new AtomicInteger();
            linkedBlockingQueue4Util.mPool = this;
            this.f25263b = linkedBlockingQueue4Util;
        }

        public static ExecutorService b(int i11, int i12) {
            if (i11 == -8) {
                return new b(ThreadUtils.f25257d + 1, (ThreadUtils.f25257d * 2) + 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue4Util(true), new UtilsThreadFactory("cpu", i12));
            }
            if (i11 == -4) {
                return new b((ThreadUtils.f25257d * 2) + 1, (ThreadUtils.f25257d * 2) + 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue4Util(), new UtilsThreadFactory("io", i12));
            }
            if (i11 == -2) {
                return new b(0, 128, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue4Util(true), new UtilsThreadFactory("cached", i12));
            }
            if (i11 == -1) {
                return new b(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue4Util(), new UtilsThreadFactory("single", i12));
            }
            return new b(i11, i11, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue4Util(), new UtilsThreadFactory("fixed(" + i11 + ")", i12));
        }

        @Override // java.util.concurrent.ThreadPoolExecutor
        public void afterExecute(Runnable runnable, Throwable th2) {
            this.f25262a.decrementAndGet();
            super.afterExecute(runnable, th2);
        }

        @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            if (isShutdown()) {
                return;
            }
            this.f25262a.incrementAndGet();
            try {
                super.execute(runnable);
            } catch (RejectedExecutionException unused) {
                Log.e("ThreadUtils", "This will not happen!");
                this.f25263b.offer(runnable);
            } catch (Throwable unused2) {
                this.f25262a.decrementAndGet();
            }
        }
    }

    public static ExecutorService d() {
        return g(-2);
    }

    public static Executor e() {
        if (f25259f == null) {
            f25259f = new a();
        }
        return f25259f;
    }

    public static Handler f() {
        return f25254a;
    }

    public static ExecutorService g(int i11) {
        return h(i11, 5);
    }

    public static ExecutorService h(int i11, int i12) {
        ExecutorService executorServiceB;
        Map<Integer, Map<Integer, ExecutorService>> map = f25255b;
        synchronized (map) {
            try {
                Map<Integer, ExecutorService> map2 = map.get(Integer.valueOf(i11));
                if (map2 == null) {
                    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                    executorServiceB = b.b(i11, i12);
                    concurrentHashMap.put(Integer.valueOf(i12), executorServiceB);
                    map.put(Integer.valueOf(i11), concurrentHashMap);
                } else {
                    executorServiceB = map2.get(Integer.valueOf(i12));
                    if (executorServiceB == null) {
                        executorServiceB = b.b(i11, i12);
                        map2.put(Integer.valueOf(i12), executorServiceB);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return executorServiceB;
    }

    public static boolean i() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static void j(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            f25254a.post(runnable);
        }
    }

    public static void k(Runnable runnable, long j11) {
        f25254a.postDelayed(runnable, j11);
    }
}
