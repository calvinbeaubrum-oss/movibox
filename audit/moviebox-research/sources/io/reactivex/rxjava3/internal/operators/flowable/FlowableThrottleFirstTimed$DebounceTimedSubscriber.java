package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
final class FlowableThrottleFirstTimed$DebounceTimedSubscriber<T> extends AtomicLong implements io.reactivex.rxjava3.core.f<T>, u30.d, Runnable {
    private static final long serialVersionUID = -9102637559663639004L;
    boolean done;
    final u30.c<? super T> downstream;
    volatile boolean gate;
    final long timeout;
    final SequentialDisposable timer = new SequentialDisposable();
    final TimeUnit unit;
    u30.d upstream;
    final Scheduler.Worker worker;

    public FlowableThrottleFirstTimed$DebounceTimedSubscriber(u30.c<? super T> cVar, long j11, TimeUnit timeUnit, Scheduler.Worker worker) {
        this.downstream = cVar;
        this.timeout = j11;
        this.unit = timeUnit;
        this.worker = worker;
    }

    @Override // u30.d
    public void cancel() {
        this.upstream.cancel();
        this.worker.dispose();
    }

    @Override // u30.c
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        this.downstream.onComplete();
        this.worker.dispose();
    }

    @Override // u30.c
    public void onError(Throwable th2) {
        if (this.done) {
            p10.a.q(th2);
            return;
        }
        this.done = true;
        this.downstream.onError(th2);
        this.worker.dispose();
    }

    @Override // u30.c
    public void onNext(T t11) {
        if (this.done || this.gate) {
            return;
        }
        this.gate = true;
        if (get() == 0) {
            this.done = true;
            cancel();
            this.downstream.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
        } else {
            this.downstream.onNext(t11);
            io.reactivex.rxjava3.internal.util.a.d(this, 1L);
            h10.b bVar = this.timer.get();
            if (bVar != null) {
                bVar.dispose();
            }
            this.timer.replace(this.worker.schedule(this, this.timeout, this.unit));
        }
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
            io.reactivex.rxjava3.internal.util.a.a(this, j11);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        this.gate = false;
    }
}
