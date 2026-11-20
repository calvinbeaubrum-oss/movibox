package com.cloud.tmc.kernel.coreimpl;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.executor.IExecutorService;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.performanceanalyse.BuildConfigProxy;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class DefaultExecutorService implements IExecutorService {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f31161j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f31162k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f31163l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final ThreadFactory f31164m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final ThreadFactory f31165n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ScheduledThreadPoolExecutor f31166a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Executor f31170e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Executor f31171f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ExecutorService f31167b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BlockingQueue<Runnable> f31168c = new PriorityBlockingQueue(256);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final BlockingQueue<Runnable> f31169d = new PriorityBlockingQueue(128);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Handler f31172g = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Executor f31173h = new a();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Executor f31174i = new b();

    /* JADX INFO: compiled from: source.java */
    public static class RunnablePriority implements Runnable, Comparable<RunnablePriority> {
        private Runnable runnable;
        private ExecutorType type;

        public RunnablePriority(Runnable runnable, ExecutorType executorType) {
            this.type = executorType;
            this.runnable = runnable;
        }

        @Override // java.lang.Comparable
        public int compareTo(RunnablePriority runnablePriority) {
            ExecutorType executorType = this.type;
            if (executorType == null) {
                return -1;
            }
            ExecutorType executorType2 = runnablePriority.type;
            if (executorType2 == null) {
                return 1;
            }
            if (executorType.equals(executorType2)) {
                return 0;
            }
            return this.type.ordinal() - runnablePriority.type.ordinal();
        }

        public ExecutorType getType() {
            return this.type;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.runnable.run();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a implements Executor {
        public a() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            runnable.run();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements Executor {
        public b() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            DefaultExecutorService.this.f31172g.post(runnable);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicInteger f31177a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "Tmc #" + this.f31177a.getAndIncrement());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicInteger f31178a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "Tmc ##" + this.f31178a.getAndIncrement());
        }
    }

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        f31161j = iAvailableProcessors;
        f31162k = Math.max(2, Math.min(iAvailableProcessors - 1, 4));
        f31163l = (iAvailableProcessors * 2) + 1;
        f31164m = new c();
        f31165n = new d();
    }

    public static /* synthetic */ void d(String str, ThreadPoolExecutor threadPoolExecutor) {
        TmcLogger.c("DefaultExecutorService", "=========================Type: " + str);
        TmcLogger.c("DefaultExecutorService", "Pool Size: {}, " + threadPoolExecutor.getPoolSize());
        TmcLogger.c("DefaultExecutorService", "Active Threads: {}, " + threadPoolExecutor.getActiveCount());
        TmcLogger.c("DefaultExecutorService", "Number of Tasks Completed: {}, " + threadPoolExecutor.getCompletedTaskCount());
        TmcLogger.c("DefaultExecutorService", "Number of Tasks in Queue: {}, " + threadPoolExecutor.getQueue().size());
        TmcLogger.c("DefaultExecutorService", "=========================");
    }

    public final /* synthetic */ void c(ExecutorType executorType, Executor executor, Runnable runnable) {
        RunnablePriority runnablePriority = new RunnablePriority(runnable, executorType);
        TmcLogger.f("TmcExecutorService", "插入 task: type" + executorType);
        executor.execute(runnablePriority);
        if (((BuildConfigProxy) tc.a.a(BuildConfigProxy.class)).isDebug().booleanValue()) {
            e((executorType == ExecutorType.NORMAL || executorType == ExecutorType.IDLE) ? "slave_pool" : "major_pool", executor);
        }
    }

    public final void e(final String str, Executor executor) {
        if (executor instanceof ThreadPoolExecutor) {
            final ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executor;
            if (this.f31167b == null) {
                this.f31167b = Executors.newFixedThreadPool(1);
            }
            this.f31167b.execute(new Runnable() { // from class: com.cloud.tmc.kernel.coreimpl.b
                @Override // java.lang.Runnable
                public final void run() {
                    DefaultExecutorService.d(str, threadPoolExecutor);
                }
            });
        }
    }

    @Override // com.cloud.tmc.kernel.executor.IExecutorService
    public synchronized Executor getExecutor(final ExecutorType executorType) {
        final Executor executor;
        if (executorType == ExecutorType.UI) {
            return this.f31174i;
        }
        if (executorType == ExecutorType.SYNC) {
            return this.f31173h;
        }
        if (executorType == ExecutorType.NORMAL || executorType == ExecutorType.IDLE) {
            if (this.f31171f == null) {
                int i11 = f31163l / 2;
                this.f31171f = new ThreadPoolExecutor(2, i11 < 2 ? 2 : i11, 30L, TimeUnit.SECONDS, this.f31169d, f31165n);
            }
            executor = this.f31171f;
        } else {
            if (this.f31170e == null) {
                int i12 = f31162k;
                int i13 = f31163l;
                this.f31170e = new ThreadPoolExecutor(i12, i13 < i12 ? i12 : i13, 30L, TimeUnit.SECONDS, this.f31168c, f31164m);
            }
            executor = this.f31170e;
        }
        return new Executor() { // from class: com.cloud.tmc.kernel.coreimpl.a
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                this.f31179a.c(executorType, executor, runnable);
            }
        };
    }

    @Override // com.cloud.tmc.kernel.executor.IExecutorService
    public synchronized ScheduledThreadPoolExecutor getScheduledExecutor() {
        try {
            if (this.f31166a == null) {
                this.f31166a = new ScheduledThreadPoolExecutor(4);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.f31166a;
    }
}
