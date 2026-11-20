package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
final class ObservableThrottleLatest$ThrottleLatestObserver<T> extends AtomicInteger implements io.reactivex.rxjava3.core.o<T>, h10.b, Runnable {
    private static final long serialVersionUID = -8296689127439125014L;
    volatile boolean cancelled;
    volatile boolean done;
    final io.reactivex.rxjava3.core.o<? super T> downstream;
    final boolean emitLast;
    Throwable error;
    final AtomicReference<T> latest = new AtomicReference<>();
    final long timeout;
    volatile boolean timerFired;
    boolean timerRunning;
    final TimeUnit unit;
    h10.b upstream;
    final Scheduler.Worker worker;

    public ObservableThrottleLatest$ThrottleLatestObserver(io.reactivex.rxjava3.core.o<? super T> oVar, long j11, TimeUnit timeUnit, Scheduler.Worker worker, boolean z11) {
        this.downstream = oVar;
        this.timeout = j11;
        this.unit = timeUnit;
        this.worker = worker;
        this.emitLast = z11;
    }

    @Override // h10.b
    public void dispose() {
        this.cancelled = true;
        this.upstream.dispose();
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
        io.reactivex.rxjava3.core.o<? super T> oVar = this.downstream;
        int iAddAndGet = 1;
        while (!this.cancelled) {
            boolean z11 = this.done;
            if (z11 && this.error != null) {
                atomicReference.lazySet(null);
                oVar.onError(this.error);
                this.worker.dispose();
                return;
            }
            boolean z12 = atomicReference.get() == null;
            if (z11) {
                T andSet = atomicReference.getAndSet(null);
                if (!z12 && this.emitLast) {
                    oVar.onNext(andSet);
                }
                oVar.onComplete();
                this.worker.dispose();
                return;
            }
            if (z12) {
                if (this.timerFired) {
                    this.timerRunning = false;
                    this.timerFired = false;
                }
            } else if (!this.timerRunning || this.timerFired) {
                oVar.onNext(atomicReference.getAndSet(null));
                this.timerFired = false;
                this.timerRunning = true;
                this.worker.schedule(this, this.timeout, this.unit);
            }
            iAddAndGet = addAndGet(-iAddAndGet);
            if (iAddAndGet == 0) {
                return;
            }
        }
        atomicReference.lazySet(null);
    }

    @Override // h10.b
    public boolean isDisposed() {
        return this.cancelled;
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onError(Throwable th2) {
        this.error = th2;
        this.done = true;
        drain();
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onNext(T t11) {
        this.latest.set(t11);
        drain();
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onSubscribe(h10.b bVar) {
        if (DisposableHelper.validate(this.upstream, bVar)) {
            this.upstream = bVar;
            this.downstream.onSubscribe(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        this.timerFired = true;
        drain();
    }
}
