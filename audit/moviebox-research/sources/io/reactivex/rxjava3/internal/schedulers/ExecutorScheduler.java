package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public final class ExecutorScheduler extends Scheduler {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Scheduler f67471f = q10.a.c();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f67472c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f67473d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Executor f67474e;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    public final class DelayedDispose implements Runnable {

        /* JADX INFO: renamed from: dr, reason: collision with root package name */
        private final DelayedRunnable f67475dr;

        public DelayedDispose(DelayedRunnable delayedRunnable) {
            this.f67475dr = delayedRunnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            DelayedRunnable delayedRunnable = this.f67475dr;
            delayedRunnable.direct.replace(ExecutorScheduler.this.d(delayedRunnable));
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    public static final class DelayedRunnable extends AtomicReference<Runnable> implements Runnable, h10.b {
        private static final long serialVersionUID = -4101336210206799084L;
        final SequentialDisposable direct;
        final SequentialDisposable timed;

        public DelayedRunnable(Runnable runnable) {
            super(runnable);
            this.timed = new SequentialDisposable();
            this.direct = new SequentialDisposable();
        }

        @Override // h10.b
        public void dispose() {
            if (getAndSet(null) != null) {
                this.timed.dispose();
                this.direct.dispose();
            }
        }

        public Runnable getWrappedRunnable() {
            Runnable runnable = get();
            return runnable != null ? runnable : Functions.f67327b;
        }

        @Override // h10.b
        public boolean isDisposed() {
            return get() == null;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = get();
            if (runnable != null) {
                try {
                    try {
                        runnable.run();
                        lazySet(null);
                        this.timed.lazySet(DisposableHelper.DISPOSED);
                        SequentialDisposable sequentialDisposable = this.direct;
                    } finally {
                        lazySet(null);
                        this.timed.lazySet(DisposableHelper.DISPOSED);
                        this.direct.lazySet(DisposableHelper.DISPOSED);
                    }
                } catch (Throwable th2) {
                    p10.a.q(th2);
                    throw th2;
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    public static final class ExecutorWorker extends Scheduler.Worker implements Runnable {
        volatile boolean disposed;
        final Executor executor;
        final boolean fair;
        final boolean interruptibleWorker;
        final AtomicInteger wip = new AtomicInteger();
        final h10.a tasks = new h10.a();
        final MpscLinkedQueue<Runnable> queue = new MpscLinkedQueue<>();

        /* JADX INFO: compiled from: source.java */
        /* JADX INFO: loaded from: classes.dex */
        public static final class BooleanRunnable extends AtomicBoolean implements Runnable, h10.b {
            private static final long serialVersionUID = -2421395018820541164L;
            final Runnable actual;

            public BooleanRunnable(Runnable runnable) {
                this.actual = runnable;
            }

            @Override // h10.b
            public void dispose() {
                lazySet(true);
            }

            @Override // h10.b
            public boolean isDisposed() {
                return get();
            }

            @Override // java.lang.Runnable
            public void run() {
                if (get()) {
                    return;
                }
                try {
                    this.actual.run();
                    lazySet(true);
                } catch (Throwable th2) {
                    try {
                        p10.a.q(th2);
                        throw th2;
                    } catch (Throwable th3) {
                        lazySet(true);
                        throw th3;
                    }
                }
            }
        }

        /* JADX INFO: compiled from: source.java */
        public static final class InterruptibleRunnable extends AtomicInteger implements Runnable, h10.b {
            static final int FINISHED = 2;
            static final int INTERRUPTED = 4;
            static final int INTERRUPTING = 3;
            static final int READY = 0;
            static final int RUNNING = 1;
            private static final long serialVersionUID = -3603436687413320876L;
            final Runnable run;
            final h10.c tasks;
            volatile Thread thread;

            public InterruptibleRunnable(Runnable runnable, h10.c cVar) {
                this.run = runnable;
                this.tasks = cVar;
            }

            public void cleanup() {
                h10.c cVar = this.tasks;
                if (cVar != null) {
                    cVar.b(this);
                }
            }

            @Override // h10.b
            public void dispose() {
                while (true) {
                    int i11 = get();
                    if (i11 >= 2) {
                        return;
                    }
                    if (i11 == 0) {
                        if (compareAndSet(0, 4)) {
                            cleanup();
                            return;
                        }
                    } else if (compareAndSet(1, 3)) {
                        Thread thread = this.thread;
                        if (thread != null) {
                            thread.interrupt();
                            this.thread = null;
                        }
                        set(4);
                        cleanup();
                        return;
                    }
                }
            }

            @Override // h10.b
            public boolean isDisposed() {
                return get() >= 2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (get() == 0) {
                    this.thread = Thread.currentThread();
                    if (!compareAndSet(0, 1)) {
                        this.thread = null;
                        return;
                    }
                    try {
                        this.run.run();
                        this.thread = null;
                        if (compareAndSet(1, 2)) {
                            cleanup();
                            return;
                        }
                        while (get() == 3) {
                            Thread.yield();
                        }
                        Thread.interrupted();
                    } catch (Throwable th2) {
                        try {
                            p10.a.q(th2);
                            throw th2;
                        } catch (Throwable th3) {
                            this.thread = null;
                            if (compareAndSet(1, 2)) {
                                cleanup();
                            } else {
                                while (get() == 3) {
                                    Thread.yield();
                                }
                                Thread.interrupted();
                            }
                            throw th3;
                        }
                    }
                }
            }
        }

        /* JADX INFO: compiled from: source.java */
        public final class SequentialDispose implements Runnable {
            private final Runnable decoratedRun;
            private final SequentialDisposable mar;

            public SequentialDispose(SequentialDisposable sequentialDisposable, Runnable runnable) {
                this.mar = sequentialDisposable;
                this.decoratedRun = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.mar.replace(ExecutorWorker.this.schedule(this.decoratedRun));
            }
        }

        public ExecutorWorker(Executor executor, boolean z11, boolean z12) {
            this.executor = executor;
            this.interruptibleWorker = z11;
            this.fair = z12;
        }

        @Override // h10.b
        public void dispose() {
            if (this.disposed) {
                return;
            }
            this.disposed = true;
            this.tasks.dispose();
            if (this.wip.getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // h10.b
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.fair) {
                runFair();
            } else {
                runEager();
            }
        }

        public void runEager() {
            MpscLinkedQueue<Runnable> mpscLinkedQueue = this.queue;
            int iAddAndGet = 1;
            while (!this.disposed) {
                while (true) {
                    Runnable runnablePoll = mpscLinkedQueue.poll();
                    if (runnablePoll == null) {
                        break;
                    }
                    runnablePoll.run();
                    if (this.disposed) {
                        mpscLinkedQueue.clear();
                        return;
                    }
                }
                if (this.disposed) {
                    mpscLinkedQueue.clear();
                    return;
                } else {
                    iAddAndGet = this.wip.addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
            mpscLinkedQueue.clear();
        }

        public void runFair() {
            MpscLinkedQueue<Runnable> mpscLinkedQueue = this.queue;
            if (this.disposed) {
                mpscLinkedQueue.clear();
                return;
            }
            mpscLinkedQueue.poll().run();
            if (this.disposed) {
                mpscLinkedQueue.clear();
            } else if (this.wip.decrementAndGet() != 0) {
                this.executor.execute(this);
            }
        }

        @Override // io.reactivex.rxjava3.core.Scheduler.Worker
        public h10.b schedule(Runnable runnable) {
            h10.b booleanRunnable;
            if (this.disposed) {
                return EmptyDisposable.INSTANCE;
            }
            Runnable runnableS = p10.a.s(runnable);
            if (this.interruptibleWorker) {
                booleanRunnable = new InterruptibleRunnable(runnableS, this.tasks);
                this.tasks.c(booleanRunnable);
            } else {
                booleanRunnable = new BooleanRunnable(runnableS);
            }
            this.queue.offer(booleanRunnable);
            if (this.wip.getAndIncrement() == 0) {
                try {
                    this.executor.execute(this);
                } catch (RejectedExecutionException e11) {
                    this.disposed = true;
                    this.queue.clear();
                    p10.a.q(e11);
                    return EmptyDisposable.INSTANCE;
                }
            }
            return booleanRunnable;
        }

        @Override // io.reactivex.rxjava3.core.Scheduler.Worker
        public h10.b schedule(Runnable runnable, long j11, TimeUnit timeUnit) {
            if (j11 <= 0) {
                return schedule(runnable);
            }
            if (this.disposed) {
                return EmptyDisposable.INSTANCE;
            }
            SequentialDisposable sequentialDisposable = new SequentialDisposable();
            SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(new SequentialDispose(sequentialDisposable2, p10.a.s(runnable)), this.tasks);
            this.tasks.c(scheduledRunnable);
            Executor executor = this.executor;
            if (executor instanceof ScheduledExecutorService) {
                try {
                    scheduledRunnable.setFuture(((ScheduledExecutorService) executor).schedule((Callable) scheduledRunnable, j11, timeUnit));
                } catch (RejectedExecutionException e11) {
                    this.disposed = true;
                    p10.a.q(e11);
                    return EmptyDisposable.INSTANCE;
                }
            } else {
                scheduledRunnable.setFuture(new b(ExecutorScheduler.f67471f.e(scheduledRunnable, j11, timeUnit)));
            }
            sequentialDisposable.replace(scheduledRunnable);
            return sequentialDisposable2;
        }
    }

    public ExecutorScheduler(Executor executor, boolean z11, boolean z12) {
        this.f67474e = executor;
        this.f67472c = z11;
        this.f67473d = z12;
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public Scheduler.Worker c() {
        return new ExecutorWorker(this.f67474e, this.f67472c, this.f67473d);
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public h10.b d(Runnable runnable) {
        Runnable runnableS = p10.a.s(runnable);
        try {
            if (this.f67474e instanceof ExecutorService) {
                ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(runnableS, this.f67472c);
                scheduledDirectTask.setFuture(((ExecutorService) this.f67474e).submit(scheduledDirectTask));
                return scheduledDirectTask;
            }
            if (this.f67472c) {
                ExecutorWorker.InterruptibleRunnable interruptibleRunnable = new ExecutorWorker.InterruptibleRunnable(runnableS, null);
                this.f67474e.execute(interruptibleRunnable);
                return interruptibleRunnable;
            }
            ExecutorWorker.BooleanRunnable booleanRunnable = new ExecutorWorker.BooleanRunnable(runnableS);
            this.f67474e.execute(booleanRunnable);
            return booleanRunnable;
        } catch (RejectedExecutionException e11) {
            p10.a.q(e11);
            return EmptyDisposable.INSTANCE;
        }
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public h10.b e(Runnable runnable, long j11, TimeUnit timeUnit) {
        Runnable runnableS = p10.a.s(runnable);
        if (!(this.f67474e instanceof ScheduledExecutorService)) {
            DelayedRunnable delayedRunnable = new DelayedRunnable(runnableS);
            delayedRunnable.timed.replace(f67471f.e(new DelayedDispose(delayedRunnable), j11, timeUnit));
            return delayedRunnable;
        }
        try {
            ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(runnableS, this.f67472c);
            scheduledDirectTask.setFuture(((ScheduledExecutorService) this.f67474e).schedule(scheduledDirectTask, j11, timeUnit));
            return scheduledDirectTask;
        } catch (RejectedExecutionException e11) {
            p10.a.q(e11);
            return EmptyDisposable.INSTANCE;
        }
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public h10.b f(Runnable runnable, long j11, long j12, TimeUnit timeUnit) {
        if (!(this.f67474e instanceof ScheduledExecutorService)) {
            return super.f(runnable, j11, j12, timeUnit);
        }
        try {
            ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(p10.a.s(runnable), this.f67472c);
            scheduledDirectPeriodicTask.setFuture(((ScheduledExecutorService) this.f67474e).scheduleAtFixedRate(scheduledDirectPeriodicTask, j11, j12, timeUnit));
            return scheduledDirectPeriodicTask;
        } catch (RejectedExecutionException e11) {
            p10.a.q(e11);
            return EmptyDisposable.INSTANCE;
        }
    }
}
