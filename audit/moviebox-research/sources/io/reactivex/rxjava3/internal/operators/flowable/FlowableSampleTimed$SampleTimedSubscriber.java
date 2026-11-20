package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
abstract class FlowableSampleTimed$SampleTimedSubscriber<T> extends AtomicReference<T> implements io.reactivex.rxjava3.core.f<T>, u30.d, Runnable {
    private static final long serialVersionUID = -3517602651313910099L;
    final u30.c<? super T> downstream;
    final long period;
    final Scheduler scheduler;
    final TimeUnit unit;
    u30.d upstream;
    final AtomicLong requested = new AtomicLong();
    final SequentialDisposable timer = new SequentialDisposable();

    public FlowableSampleTimed$SampleTimedSubscriber(u30.c<? super T> cVar, long j11, TimeUnit timeUnit, Scheduler scheduler) {
        this.downstream = cVar;
        this.period = j11;
        this.unit = timeUnit;
        this.scheduler = scheduler;
    }

    @Override // u30.d
    public void cancel() {
        cancelTimer();
        this.upstream.cancel();
    }

    public void cancelTimer() {
        DisposableHelper.dispose(this.timer);
    }

    public abstract void complete();

    public void emit() {
        T andSet = getAndSet(null);
        if (andSet != null) {
            if (this.requested.get() != 0) {
                this.downstream.onNext(andSet);
                io.reactivex.rxjava3.internal.util.a.d(this.requested, 1L);
            } else {
                cancel();
                this.downstream.onError(new MissingBackpressureException("Couldn't emit value due to lack of requests!"));
            }
        }
    }

    @Override // u30.c
    public void onComplete() {
        cancelTimer();
        complete();
    }

    @Override // u30.c
    public void onError(Throwable th2) {
        cancelTimer();
        this.downstream.onError(th2);
    }

    @Override // u30.c
    public void onNext(T t11) {
        lazySet(t11);
    }

    @Override // u30.c
    public void onSubscribe(u30.d dVar) {
        if (SubscriptionHelper.validate(this.upstream, dVar)) {
            this.upstream = dVar;
            this.downstream.onSubscribe(this);
            SequentialDisposable sequentialDisposable = this.timer;
            Scheduler scheduler = this.scheduler;
            long j11 = this.period;
            sequentialDisposable.replace(scheduler.f(this, j11, j11, this.unit));
            dVar.request(Long.MAX_VALUE);
        }
    }

    @Override // u30.d
    public void request(long j11) {
        if (SubscriptionHelper.validate(j11)) {
            io.reactivex.rxjava3.internal.util.a.a(this.requested, j11);
        }
    }
}
