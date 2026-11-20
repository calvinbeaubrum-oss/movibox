package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.f;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import p10.a;
import u30.d;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
abstract class ParallelRunOn$BaseRunOnSubscriber<T> extends AtomicInteger implements f<T>, d, Runnable {
    private static final long serialVersionUID = 9222303586456402150L;
    volatile boolean cancelled;
    int consumed;
    volatile boolean done;
    Throwable error;
    final int limit;
    final int prefetch;
    final SpscArrayQueue<T> queue;
    final AtomicLong requested = new AtomicLong();
    d upstream;
    final Scheduler.Worker worker;

    public ParallelRunOn$BaseRunOnSubscriber(int i11, SpscArrayQueue<T> spscArrayQueue, Scheduler.Worker worker) {
        this.prefetch = i11;
        this.queue = spscArrayQueue;
        this.limit = i11 - (i11 >> 2);
        this.worker = worker;
    }

    @Override // u30.d
    public final void cancel() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        this.upstream.cancel();
        this.worker.dispose();
        if (getAndIncrement() == 0) {
            this.queue.clear();
        }
    }

    @Override // u30.c
    public final void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        schedule();
    }

    @Override // u30.c
    public final void onError(Throwable th2) {
        if (this.done) {
            a.q(th2);
            return;
        }
        this.error = th2;
        this.done = true;
        schedule();
    }

    @Override // u30.c
    public final void onNext(T t11) {
        if (this.done) {
            return;
        }
        if (this.queue.offer(t11)) {
            schedule();
        } else {
            this.upstream.cancel();
            onError(new MissingBackpressureException("Queue is full?!"));
        }
    }

    @Override // u30.c
    public abstract /* synthetic */ void onSubscribe(d dVar);

    @Override // u30.d
    public final void request(long j11) {
        if (SubscriptionHelper.validate(j11)) {
            io.reactivex.rxjava3.internal.util.a.a(this.requested, j11);
            schedule();
        }
    }

    public final void schedule() {
        if (getAndIncrement() == 0) {
            this.worker.schedule(this);
        }
    }
}
