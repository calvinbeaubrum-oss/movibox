package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public final class IoScheduler extends Scheduler {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final RxThreadFactory f67476e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final RxThreadFactory f67477f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f67480i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static boolean f67481j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final CachedWorkerPool f67482k;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ThreadFactory f67483c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicReference<CachedWorkerPool> f67484d;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final TimeUnit f67479h = TimeUnit.SECONDS;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final long f67478g = Long.getLong("rx3.io-keep-alive-time", 60).longValue();

    /* JADX INFO: compiled from: source.java */
    public static final class CachedWorkerPool implements Runnable {
        final h10.a allWorkers;
        private final ScheduledExecutorService evictorService;
        private final Future<?> evictorTask;
        private final ConcurrentLinkedQueue<a> expiringWorkerQueue;
        private final long keepAliveTime;
        private final ThreadFactory threadFactory;

        public CachedWorkerPool(long j11, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool;
            ScheduledFuture<?> scheduledFutureScheduleWithFixedDelay;
            long nanos = timeUnit != null ? timeUnit.toNanos(j11) : 0L;
            this.keepAliveTime = nanos;
            this.expiringWorkerQueue = new ConcurrentLinkedQueue<>();
            this.allWorkers = new h10.a();
            this.threadFactory = threadFactory;
            if (timeUnit != null) {
                scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, IoScheduler.f67477f);
                scheduledFutureScheduleWithFixedDelay = scheduledExecutorServiceNewScheduledThreadPool.scheduleWithFixedDelay(this, nanos, nanos, TimeUnit.NANOSECONDS);
            } else {
                scheduledExecutorServiceNewScheduledThreadPool = null;
                scheduledFutureScheduleWithFixedDelay = null;
            }
            this.evictorService = scheduledExecutorServiceNewScheduledThreadPool;
            this.evictorTask = scheduledFutureScheduleWithFixedDelay;
        }

        public static void evictExpiredWorkers(ConcurrentLinkedQueue<a> concurrentLinkedQueue, h10.a aVar) {
            if (concurrentLinkedQueue.isEmpty()) {
                return;
            }
            long jNow = now();
            for (a aVar2 : concurrentLinkedQueue) {
                if (aVar2.e() > jNow) {
                    return;
                }
                if (concurrentLinkedQueue.remove(aVar2)) {
                    aVar.a(aVar2);
                }
            }
        }

        public static long now() {
            return System.nanoTime();
        }

        public a get() {
            if (this.allWorkers.isDisposed()) {
                return IoScheduler.f67480i;
            }
            while (!this.expiringWorkerQueue.isEmpty()) {
                a aVarPoll = this.expiringWorkerQueue.poll();
                if (aVarPoll != null) {
                    return aVarPoll;
                }
            }
            a aVar = new a(this.threadFactory);
            this.allWorkers.c(aVar);
            return aVar;
        }

        public void release(a aVar) {
            aVar.f(now() + this.keepAliveTime);
            this.expiringWorkerQueue.offer(aVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            evictExpiredWorkers(this.expiringWorkerQueue, this.allWorkers);
        }

        public void shutdown() {
            this.allWorkers.dispose();
            Future<?> future = this.evictorTask;
            if (future != null) {
                future.cancel(true);
            }
            ScheduledExecutorService scheduledExecutorService = this.evictorService;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class EventLoopWorker extends Scheduler.Worker implements Runnable {
        private final CachedWorkerPool pool;
        private final a threadWorker;
        final AtomicBoolean once = new AtomicBoolean();
        private final h10.a tasks = new h10.a();

        public EventLoopWorker(CachedWorkerPool cachedWorkerPool) {
            this.pool = cachedWorkerPool;
            this.threadWorker = cachedWorkerPool.get();
        }

        @Override // h10.b
        public void dispose() {
            if (this.once.compareAndSet(false, true)) {
                this.tasks.dispose();
                if (IoScheduler.f67481j) {
                    this.threadWorker.a(this, 0L, TimeUnit.NANOSECONDS, null);
                } else {
                    this.pool.release(this.threadWorker);
                }
            }
        }

        @Override // h10.b
        public boolean isDisposed() {
            return this.once.get();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.pool.release(this.threadWorker);
        }

        @Override // io.reactivex.rxjava3.core.Scheduler.Worker
        public h10.b schedule(Runnable runnable, long j11, TimeUnit timeUnit) {
            return this.tasks.isDisposed() ? EmptyDisposable.INSTANCE : this.threadWorker.a(runnable, j11, timeUnit, this.tasks);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    public static final class a extends e {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f67485c;

        public a(ThreadFactory threadFactory) {
            super(threadFactory);
            this.f67485c = 0L;
        }

        public long e() {
            return this.f67485c;
        }

        public void f(long j11) {
            this.f67485c = j11;
        }
    }

    static {
        a aVar = new a(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
        f67480i = aVar;
        aVar.dispose();
        int iMax = Math.max(1, Math.min(10, Integer.getInteger("rx3.io-priority", 5).intValue()));
        RxThreadFactory rxThreadFactory = new RxThreadFactory("RxCachedThreadScheduler", iMax);
        f67476e = rxThreadFactory;
        f67477f = new RxThreadFactory("RxCachedWorkerPoolEvictor", iMax);
        f67481j = Boolean.getBoolean("rx3.io-scheduled-release");
        CachedWorkerPool cachedWorkerPool = new CachedWorkerPool(0L, null, rxThreadFactory);
        f67482k = cachedWorkerPool;
        cachedWorkerPool.shutdown();
    }

    public IoScheduler() {
        this(f67476e);
    }

    public IoScheduler(ThreadFactory threadFactory) {
        this.f67483c = threadFactory;
        this.f67484d = new AtomicReference<>(f67482k);
        g();
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public Scheduler.Worker c() {
        return new EventLoopWorker(this.f67484d.get());
    }

    public void g() {
        CachedWorkerPool cachedWorkerPool = new CachedWorkerPool(f67478g, f67479h, this.f67483c);
        if (l10.a.a(this.f67484d, f67482k, cachedWorkerPool)) {
            return;
        }
        cachedWorkerPool.shutdown();
    }
}
