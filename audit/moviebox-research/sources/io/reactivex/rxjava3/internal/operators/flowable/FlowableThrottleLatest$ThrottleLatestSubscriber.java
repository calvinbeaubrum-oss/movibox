package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
final class FlowableThrottleLatest$ThrottleLatestSubscriber<T> extends AtomicInteger implements io.reactivex.rxjava3.core.f<T>, u30.d, Runnable {
    private static final long serialVersionUID = -8296689127439125014L;
    volatile boolean cancelled;
    volatile boolean done;
    final u30.c<? super T> downstream;
    final boolean emitLast;
    long emitted;
    Throwable error;
    final AtomicReference<T> latest = new AtomicReference<>();
    final AtomicLong requested = new AtomicLong();
    final long timeout;
    volatile boolean timerFired;
    boolean timerRunning;
    final TimeUnit unit;
    u30.d upstream;
    final Scheduler.Worker worker;

    public FlowableThrottleLatest$ThrottleLatestSubscriber(u30.c<? super T> cVar, long j11, TimeUnit timeUnit, Scheduler.Worker worker, boolean z11) {
        this.downstream = cVar;
        this.timeout = j11;
        this.unit = timeUnit;
        this.worker = worker;
        this.emitLast = z11;
    }

    @Override // u30.d
    public void cancel() {
        this.cancelled = true;
        this.upstream.cancel();
        this.worker.dispose();
        if (getAndIncrement() == 0) {
            this.latest.lazySet(null);
        }
    }

    public void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        AtomicReference<T> atomicReference = this.latest;
        AtomicLong atomicLong = this.requested;
        u30.c<? super T> cVar = this.downstream;
        int iAddAndGet = 1;
        while (!this.cancelled) {
            boolean z11 = this.done;
            if (z11 && this.error != null) {
                atomicReference.lazySet(null);
                cVar.onError(this.error);
                this.worker.dispose();
                return;
            }
            boolean z12 = atomicReference.get() == null;
            if (z11) {
                if (z12 || !this.emitLast) {
                    atomicReference.lazySet(null);
                    cVar.onComplete();
                } else {
                    T andSet = atomicReference.getAndSet(null);
                    long j11 = this.emitted;
                    if (j11 != atomicLong.get()) {
                        this.emitted = j11 + 1;
                        cVar.onNext(andSet);
                        cVar.onComplete();
                    } else {
                        cVar.onError(new MissingBackpressureException("Could not emit final value due to lack of requests"));
                    }
                }
                this.worker.dispose();
                return;
            }
            if (z12) {
                if (this.timerFired) {
                    this.timerRunning = false;
                    this.timerFired = false;
                }
            } else if (!this.timerRunning || this.timerFired) {
                T andSet2 = atomicReference.getAndSet(null);
                long j12 = this.emitted;
                if (j12 == atomicLong.get()) {
                    this.upstream.cancel();
                    cVar.onError(new MissingBackpressureException("Could not emit value due to lack of requests"));
                    this.worker.dispose();
                    return;
                } else {
                    cVar.onNext(andSet2);
                    this.emitted = j12 + 1;
                    this.timerFired = false;
                    this.timerRunning = true;
                    this.worker.schedule(this, this.timeout, this.unit);
                }
            }
            iAddAndGet = addAndGet(-iAddAndGet);
            if (iAddAndGet == 0) {
                return;
            }
        }
        atomicReference.lazySet(null);
    }

    @Override // u30.c
    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // u30.c
    public void onError(Throwable th2) {
        this.error = th2;
        this.done = true;
        drain();
    }

    @Override // u30.c
    public void onNext(T t11) {
        this.latest.set(t11);
        drain();
    }

    @Override // u30.c
    public void onSubscribe(u30.d dVar) {
        if (SubscriptionHelper.validate(this.upstream, dVar)) {
            this.upstream = dVar;
            this.downstream.onSubscribe(this);
            dVar.request(Long.MAX_VALUE);
        }
    }

    @Override // u30.d
    public void request(long j11) {
        if (SubscriptionHelper.validate(j11)) {
            io.reactivex.rxjava3.internal.util.a.a(this.requested, j11);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        this.timerFired = true;
        drain();
    }
}
