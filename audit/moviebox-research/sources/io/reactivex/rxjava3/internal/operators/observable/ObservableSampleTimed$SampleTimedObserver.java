package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
abstract class ObservableSampleTimed$SampleTimedObserver<T> extends AtomicReference<T> implements io.reactivex.rxjava3.core.o<T>, h10.b, Runnable {
    private static final long serialVersionUID = -3517602651313910099L;
    final io.reactivex.rxjava3.core.o<? super T> downstream;
    final long period;
    final Scheduler scheduler;
    final AtomicReference<h10.b> timer = new AtomicReference<>();
    final TimeUnit unit;
    h10.b upstream;

    public ObservableSampleTimed$SampleTimedObserver(io.reactivex.rxjava3.core.o<? super T> oVar, long j11, TimeUnit timeUnit, Scheduler scheduler) {
        this.downstream = oVar;
        this.period = j11;
        this.unit = timeUnit;
        this.scheduler = scheduler;
    }

    public void cancelTimer() {
        DisposableHelper.dispose(this.timer);
    }

    public abstract void complete();

    @Override // h10.b
    public void dispose() {
        cancelTimer();
        this.upstream.dispose();
    }

    public void emit() {
        T andSet = getAndSet(null);
        if (andSet != null) {
            this.downstream.onNext(andSet);
        }
    }

    @Override // h10.b
    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onComplete() {
        cancelTimer();
        complete();
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onError(Throwable th2) {
        cancelTimer();
        this.downstream.onError(th2);
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onNext(T t11) {
        lazySet(t11);
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onSubscribe(h10.b bVar) {
        if (DisposableHelper.validate(this.upstream, bVar)) {
            this.upstream = bVar;
            this.downstream.onSubscribe(this);
            Scheduler scheduler = this.scheduler;
            long j11 = this.period;
            DisposableHelper.replace(this.timer, scheduler.f(this, j11, j11, this.unit));
        }
    }
}
