package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public final class TrampolineScheduler extends Scheduler {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final TrampolineScheduler f67490c = new TrampolineScheduler();

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    public static final class SleepingRunnable implements Runnable {
        private final long execTime;
        private final Runnable run;
        private final TrampolineWorker worker;

        public SleepingRunnable(Runnable runnable, TrampolineWorker trampolineWorker, long j11) {
            this.run = runnable;
            this.worker = trampolineWorker;
            this.execTime = j11;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.worker.f67494d) {
                return;
            }
            long jNow = this.worker.now(TimeUnit.MILLISECONDS);
            long j11 = this.execTime;
            if (j11 > jNow) {
                try {
                    Thread.sleep(j11 - jNow);
                } catch (InterruptedException e11) {
                    Thread.currentThread().interrupt();
                    p10.a.q(e11);
                    return;
                }
            }
            if (this.worker.f67494d) {
                return;
            }
            this.run.run();
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    public static final class TrampolineWorker extends Scheduler.Worker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final PriorityBlockingQueue<a> f67491a = new PriorityBlockingQueue<>();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicInteger f67492b = new AtomicInteger();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AtomicInteger f67493c = new AtomicInteger();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public volatile boolean f67494d;

        /* JADX INFO: compiled from: source.java */
        public final class AppendToQueueTask implements Runnable {
            final a timedRunnable;

            public AppendToQueueTask(a aVar) {
                this.timedRunnable = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.timedRunnable.f67498d = true;
                TrampolineWorker.this.f67491a.remove(this.timedRunnable);
            }
        }

        public h10.b a(Runnable runnable, long j11) {
            if (this.f67494d) {
                return EmptyDisposable.INSTANCE;
            }
            a aVar = new a(runnable, Long.valueOf(j11), this.f67493c.incrementAndGet());
            this.f67491a.add(aVar);
            if (this.f67492b.getAndIncrement() != 0) {
                return io.reactivex.rxjava3.disposables.a.b(new AppendToQueueTask(aVar));
            }
            int iAddAndGet = 1;
            while (!this.f67494d) {
                a aVarPoll = this.f67491a.poll();
                if (aVarPoll == null) {
                    iAddAndGet = this.f67492b.addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return EmptyDisposable.INSTANCE;
                    }
                } else if (!aVarPoll.f67498d) {
                    aVarPoll.f67495a.run();
                }
            }
            this.f67491a.clear();
            return EmptyDisposable.INSTANCE;
        }

        @Override // h10.b
        public void dispose() {
            this.f67494d = true;
        }

        @Override // h10.b
        public boolean isDisposed() {
            return this.f67494d;
        }

        @Override // io.reactivex.rxjava3.core.Scheduler.Worker
        public h10.b schedule(Runnable runnable) {
            return a(runnable, now(TimeUnit.MILLISECONDS));
        }

        @Override // io.reactivex.rxjava3.core.Scheduler.Worker
        public h10.b schedule(Runnable runnable, long j11, TimeUnit timeUnit) {
            long jNow = now(TimeUnit.MILLISECONDS) + timeUnit.toMillis(j11);
            return a(new SleepingRunnable(runnable, this, jNow), jNow);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    public static final class a implements Comparable<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f67495a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f67496b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f67497c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public volatile boolean f67498d;

        public a(Runnable runnable, Long l11, int i11) {
            this.f67495a = runnable;
            this.f67496b = l11.longValue();
            this.f67497c = i11;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            int iCompare = Long.compare(this.f67496b, aVar.f67496b);
            return iCompare == 0 ? Integer.compare(this.f67497c, aVar.f67497c) : iCompare;
        }
    }

    public static TrampolineScheduler g() {
        return f67490c;
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public Scheduler.Worker c() {
        return new TrampolineWorker();
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public h10.b d(Runnable runnable) {
        p10.a.s(runnable).run();
        return EmptyDisposable.INSTANCE;
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public h10.b e(Runnable runnable, long j11, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j11);
            p10.a.s(runnable).run();
        } catch (InterruptedException e11) {
            Thread.currentThread().interrupt();
            p10.a.q(e11);
        }
        return EmptyDisposable.INSTANCE;
    }
}
