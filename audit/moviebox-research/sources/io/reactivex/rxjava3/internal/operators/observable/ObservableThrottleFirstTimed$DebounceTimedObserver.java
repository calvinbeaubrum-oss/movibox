package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
final class ObservableThrottleFirstTimed$DebounceTimedObserver<T> extends AtomicReference<h10.b> implements io.reactivex.rxjava3.core.o<T>, h10.b, Runnable {
    private static final long serialVersionUID = 786994795061867455L;
    final io.reactivex.rxjava3.core.o<? super T> downstream;
    volatile boolean gate;
    final long timeout;
    final TimeUnit unit;
    h10.b upstream;
    final Scheduler.Worker worker;

    public ObservableThrottleFirstTimed$DebounceTimedObserver(io.reactivex.rxjava3.core.o<? super T> oVar, long j11, TimeUnit timeUnit, Scheduler.Worker worker) {
        this.downstream = oVar;
        this.timeout = j11;
        this.unit = timeUnit;
        this.worker = worker;
    }

    @Override // h10.b
    public void dispose() {
        this.upstream.dispose();
        this.worker.dispose();
    }

    @Override // h10.b
    public boolean isDisposed() {
        return this.worker.isDisposed();
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onComplete() {
        this.downstream.onComplete();
        this.worker.dispose();
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onError(Throwable th2) {
        this.downstream.onError(th2);
        this.worker.dispose();
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onNext(T t11) {
        if (this.gate) {
            return;
        }
        this.gate = true;
        this.downstream.onNext(t11);
        h10.b bVar = get();
        if (bVar != null) {
            bVar.dispose();
        }
        DisposableHelper.replace(this, this.worker.schedule(this, this.timeout, this.unit));
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
        this.gate = false;
    }
}
