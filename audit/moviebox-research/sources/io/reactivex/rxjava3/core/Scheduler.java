package io.reactivex.rxjava3.core;

import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class Scheduler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f67318a = Boolean.getBoolean("rx3.scheduler.use-nanotime");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f67319b = a(Long.getLong("rx3.scheduler.drift-tolerance", 15).longValue(), System.getProperty("rx3.scheduler.drift-tolerance-unit", "minutes"));

    /* JADX INFO: compiled from: source.java */
    public static final class DisposeTask implements h10.b, Runnable {
        final Runnable decoratedRun;
        Thread runner;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        final Worker f67320w;

        public DisposeTask(Runnable runnable, Worker worker) {
            this.decoratedRun = runnable;
            this.f67320w = worker;
        }

        @Override // h10.b
        public void dispose() {
            if (this.runner == Thread.currentThread()) {
                Worker worker = this.f67320w;
                if (worker instanceof io.reactivex.rxjava3.internal.schedulers.e) {
                    ((io.reactivex.rxjava3.internal.schedulers.e) worker).d();
                    return;
                }
            }
            this.f67320w.dispose();
        }

        public Runnable getWrappedRunnable() {
            return this.decoratedRun;
        }

        @Override // h10.b
        public boolean isDisposed() {
            return this.f67320w.isDisposed();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.runner = Thread.currentThread();
            try {
                this.decoratedRun.run();
                dispose();
                this.runner = null;
            } catch (Throwable th2) {
                try {
                    p10.a.q(th2);
                    throw th2;
                } catch (Throwable th3) {
                    dispose();
                    this.runner = null;
                    throw th3;
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    public static final class PeriodicDirectTask implements h10.b, Runnable {
        volatile boolean disposed;
        final Runnable run;
        final Worker worker;

        public PeriodicDirectTask(Runnable runnable, Worker worker) {
            this.run = runnable;
            this.worker = worker;
        }

        @Override // h10.b
        public void dispose() {
            this.disposed = true;
            this.worker.dispose();
        }

        public Runnable getWrappedRunnable() {
            return this.run;
        }

        @Override // h10.b
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.disposed) {
                return;
            }
            try {
                this.run.run();
            } catch (Throwable th2) {
                dispose();
                p10.a.q(th2);
                throw th2;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class Worker implements h10.b {

        /* JADX INFO: compiled from: source.java */
        /* JADX INFO: loaded from: classes8.dex */
        public final class PeriodicTask implements Runnable {
            long count;
            final Runnable decoratedRun;
            long lastNowNanoseconds;
            final long periodInNanoseconds;

            /* JADX INFO: renamed from: sd, reason: collision with root package name */
            final SequentialDisposable f67321sd;
            long startInNanoseconds;

            public PeriodicTask(long j11, Runnable runnable, long j12, SequentialDisposable sequentialDisposable, long j13) {
                this.decoratedRun = runnable;
                this.f67321sd = sequentialDisposable;
                this.periodInNanoseconds = j13;
                this.lastNowNanoseconds = j12;
                this.startInNanoseconds = j11;
            }

            public Runnable getWrappedRunnable() {
                return this.decoratedRun;
            }

            /* JADX WARN: Code duplicated, block: B:10:0x0035  */
            @Override // java.lang.Runnable
            public void run() {
                long j11;
                this.decoratedRun.run();
                if (this.f67321sd.isDisposed()) {
                    return;
                }
                Worker worker = Worker.this;
                TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                long jNow = worker.now(timeUnit);
                long j12 = Scheduler.f67319b;
                long j13 = jNow + j12;
                long j14 = this.lastNowNanoseconds;
                if (j13 >= j14) {
                    long j15 = this.periodInNanoseconds;
                    if (jNow >= j14 + j15 + j12) {
                        long j16 = this.periodInNanoseconds;
                        long j17 = jNow + j16;
                        long j18 = this.count + 1;
                        this.count = j18;
                        this.startInNanoseconds = j17 - (j16 * j18);
                        j11 = j17;
                    } else {
                        long j19 = this.startInNanoseconds;
                        long j21 = this.count + 1;
                        this.count = j21;
                        j11 = j19 + (j21 * j15);
                    }
                } else {
                    long j110 = this.periodInNanoseconds;
                    long j111 = jNow + j110;
                    long j112 = this.count + 1;
                    this.count = j112;
                    this.startInNanoseconds = j111 - (j110 * j112);
                    j11 = j111;
                }
                this.lastNowNanoseconds = jNow;
                this.f67321sd.replace(Worker.this.schedule(this, j11 - jNow, timeUnit));
            }
        }

        public long now(TimeUnit timeUnit) {
            return Scheduler.b(timeUnit);
        }

        public h10.b schedule(Runnable runnable) {
            return schedule(runnable, 0L, TimeUnit.NANOSECONDS);
        }

        public abstract h10.b schedule(Runnable runnable, long j11, TimeUnit timeUnit);

        public h10.b schedulePeriodically(Runnable runnable, long j11, long j12, TimeUnit timeUnit) {
            SequentialDisposable sequentialDisposable = new SequentialDisposable();
            SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            Runnable runnableS = p10.a.s(runnable);
            long nanos = timeUnit.toNanos(j12);
            long jNow = now(TimeUnit.NANOSECONDS);
            h10.b bVarSchedule = schedule(new PeriodicTask(jNow + timeUnit.toNanos(j11), runnableS, jNow, sequentialDisposable2, nanos), j11, timeUnit);
            if (bVarSchedule == EmptyDisposable.INSTANCE) {
                return bVarSchedule;
            }
            sequentialDisposable.replace(bVarSchedule);
            return sequentialDisposable2;
        }
    }

    public static long a(long j11, String str) {
        if ("seconds".equalsIgnoreCase(str)) {
            return TimeUnit.SECONDS.toNanos(j11);
        }
        return "milliseconds".equalsIgnoreCase(str) ? TimeUnit.MILLISECONDS.toNanos(j11) : TimeUnit.MINUTES.toNanos(j11);
    }

    public static long b(TimeUnit timeUnit) {
        return !f67318a ? timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS) : timeUnit.convert(System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    public abstract Worker c();

    public h10.b d(Runnable runnable) {
        return e(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    public h10.b e(Runnable runnable, long j11, TimeUnit timeUnit) {
        Worker workerC = c();
        DisposeTask disposeTask = new DisposeTask(p10.a.s(runnable), workerC);
        workerC.schedule(disposeTask, j11, timeUnit);
        return disposeTask;
    }

    public h10.b f(Runnable runnable, long j11, long j12, TimeUnit timeUnit) {
        Worker workerC = c();
        PeriodicDirectTask periodicDirectTask = new PeriodicDirectTask(p10.a.s(runnable), workerC);
        h10.b bVarSchedulePeriodically = workerC.schedulePeriodically(periodicDirectTask, j11, j12, timeUnit);
        return bVarSchedulePeriodically == EmptyDisposable.INSTANCE ? bVarSchedulePeriodically : periodicDirectTask;
    }
}
