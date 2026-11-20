package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class e extends Scheduler.Worker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScheduledExecutorService f67522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f67523b;

    public e(ThreadFactory threadFactory) {
        this.f67522a = SchedulerPoolFactory.a(threadFactory);
    }

    public ScheduledRunnable a(Runnable runnable, long j11, TimeUnit timeUnit, h10.c cVar) {
        ScheduledRunnable scheduledRunnable = new ScheduledRunnable(p10.a.s(runnable), cVar);
        if (cVar != null && !cVar.c(scheduledRunnable)) {
            return scheduledRunnable;
        }
        try {
            scheduledRunnable.setFuture(j11 <= 0 ? this.f67522a.submit((Callable) scheduledRunnable) : this.f67522a.schedule((Callable) scheduledRunnable, j11, timeUnit));
        } catch (RejectedExecutionException e11) {
            if (cVar != null) {
                cVar.a(scheduledRunnable);
            }
            p10.a.q(e11);
        }
        return scheduledRunnable;
    }

    public h10.b b(Runnable runnable, long j11, TimeUnit timeUnit) {
        ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(p10.a.s(runnable), true);
        try {
            scheduledDirectTask.setFuture(j11 <= 0 ? this.f67522a.submit(scheduledDirectTask) : this.f67522a.schedule(scheduledDirectTask, j11, timeUnit));
            return scheduledDirectTask;
        } catch (RejectedExecutionException e11) {
            p10.a.q(e11);
            return EmptyDisposable.INSTANCE;
        }
    }

    public h10.b c(Runnable runnable, long j11, long j12, TimeUnit timeUnit) {
        Runnable runnableS = p10.a.s(runnable);
        if (j12 <= 0) {
            c cVar = new c(runnableS, this.f67522a);
            try {
                cVar.b(j11 <= 0 ? this.f67522a.submit(cVar) : this.f67522a.schedule(cVar, j11, timeUnit));
                return cVar;
            } catch (RejectedExecutionException e11) {
                p10.a.q(e11);
                return EmptyDisposable.INSTANCE;
            }
        }
        ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(runnableS, true);
        try {
            scheduledDirectPeriodicTask.setFuture(this.f67522a.scheduleAtFixedRate(scheduledDirectPeriodicTask, j11, j12, timeUnit));
            return scheduledDirectPeriodicTask;
        } catch (RejectedExecutionException e12) {
            p10.a.q(e12);
            return EmptyDisposable.INSTANCE;
        }
    }

    public void d() {
        if (this.f67523b) {
            return;
        }
        this.f67523b = true;
        this.f67522a.shutdown();
    }

    @Override // h10.b
    public void dispose() {
        if (this.f67523b) {
            return;
        }
        this.f67523b = true;
        this.f67522a.shutdownNow();
    }

    @Override // h10.b
    public boolean isDisposed() {
        return this.f67523b;
    }

    @Override // io.reactivex.rxjava3.core.Scheduler.Worker
    public h10.b schedule(Runnable runnable) {
        return schedule(runnable, 0L, null);
    }

    @Override // io.reactivex.rxjava3.core.Scheduler.Worker
    public h10.b schedule(Runnable runnable, long j11, TimeUnit timeUnit) {
        return this.f67523b ? EmptyDisposable.INSTANCE : a(runnable, j11, timeUnit, null);
    }
}
