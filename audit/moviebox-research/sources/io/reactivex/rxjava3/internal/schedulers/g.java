package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class g extends Scheduler {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final RxThreadFactory f67524e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ScheduledExecutorService f67525f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ThreadFactory f67526c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicReference<ScheduledExecutorService> f67527d;

    /* JADX INFO: compiled from: source.java */
    public static final class a extends Scheduler.Worker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ScheduledExecutorService f67528a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final h10.a f67529b = new h10.a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile boolean f67530c;

        public a(ScheduledExecutorService scheduledExecutorService) {
            this.f67528a = scheduledExecutorService;
        }

        @Override // h10.b
        public void dispose() {
            if (this.f67530c) {
                return;
            }
            this.f67530c = true;
            this.f67529b.dispose();
        }

        @Override // h10.b
        public boolean isDisposed() {
            return this.f67530c;
        }

        @Override // io.reactivex.rxjava3.core.Scheduler.Worker
        public h10.b schedule(Runnable runnable, long j11, TimeUnit timeUnit) {
            if (this.f67530c) {
                return EmptyDisposable.INSTANCE;
            }
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(p10.a.s(runnable), this.f67529b);
            this.f67529b.c(scheduledRunnable);
            try {
                scheduledRunnable.setFuture(j11 <= 0 ? this.f67528a.submit((Callable) scheduledRunnable) : this.f67528a.schedule((Callable) scheduledRunnable, j11, timeUnit));
                return scheduledRunnable;
            } catch (RejectedExecutionException e11) {
                dispose();
                p10.a.q(e11);
                return EmptyDisposable.INSTANCE;
            }
        }
    }

    static {
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(0);
        f67525f = scheduledExecutorServiceNewScheduledThreadPool;
        scheduledExecutorServiceNewScheduledThreadPool.shutdown();
        f67524e = new RxThreadFactory("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx3.single-priority", 5).intValue())), true);
    }

    public g() {
        this(f67524e);
    }

    public g(ThreadFactory threadFactory) {
        AtomicReference<ScheduledExecutorService> atomicReference = new AtomicReference<>();
        this.f67527d = atomicReference;
        this.f67526c = threadFactory;
        atomicReference.lazySet(g(threadFactory));
    }

    public static ScheduledExecutorService g(ThreadFactory threadFactory) {
        return SchedulerPoolFactory.a(threadFactory);
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public Scheduler.Worker c() {
        return new a(this.f67527d.get());
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public h10.b e(Runnable runnable, long j11, TimeUnit timeUnit) {
        ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(p10.a.s(runnable), true);
        try {
            scheduledDirectTask.setFuture(j11 <= 0 ? this.f67527d.get().submit(scheduledDirectTask) : this.f67527d.get().schedule(scheduledDirectTask, j11, timeUnit));
            return scheduledDirectTask;
        } catch (RejectedExecutionException e11) {
            p10.a.q(e11);
            return EmptyDisposable.INSTANCE;
        }
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public h10.b f(Runnable runnable, long j11, long j12, TimeUnit timeUnit) {
        Runnable runnableS = p10.a.s(runnable);
        if (j12 > 0) {
            ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(runnableS, true);
            try {
                scheduledDirectPeriodicTask.setFuture(this.f67527d.get().scheduleAtFixedRate(scheduledDirectPeriodicTask, j11, j12, timeUnit));
                return scheduledDirectPeriodicTask;
            } catch (RejectedExecutionException e11) {
                p10.a.q(e11);
                return EmptyDisposable.INSTANCE;
            }
        }
        ScheduledExecutorService scheduledExecutorService = this.f67527d.get();
        c cVar = new c(runnableS, scheduledExecutorService);
        try {
            cVar.b(j11 <= 0 ? scheduledExecutorService.submit(cVar) : scheduledExecutorService.schedule(cVar, j11, timeUnit));
            return cVar;
        } catch (RejectedExecutionException e12) {
            p10.a.q(e12);
            return EmptyDisposable.INSTANCE;
        }
    }
}
