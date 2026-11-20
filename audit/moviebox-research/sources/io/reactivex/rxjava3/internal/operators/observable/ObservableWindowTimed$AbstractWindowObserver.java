package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
abstract class ObservableWindowTimed$AbstractWindowObserver<T> extends AtomicInteger implements io.reactivex.rxjava3.core.o<T>, h10.b {
    private static final long serialVersionUID = 5724293814035355511L;
    final int bufferSize;
    volatile boolean done;
    final io.reactivex.rxjava3.core.o<? super io.reactivex.rxjava3.core.j<T>> downstream;
    long emitted;
    Throwable error;
    final long timespan;
    final TimeUnit unit;
    h10.b upstream;
    volatile boolean upstreamCancelled;
    final m10.f<Object> queue = new MpscLinkedQueue();
    final AtomicBoolean downstreamCancelled = new AtomicBoolean();
    final AtomicInteger windowCount = new AtomicInteger(1);

    public ObservableWindowTimed$AbstractWindowObserver(io.reactivex.rxjava3.core.o<? super io.reactivex.rxjava3.core.j<T>> oVar, long j11, TimeUnit timeUnit, int i11) {
        this.downstream = oVar;
        this.timespan = j11;
        this.unit = timeUnit;
        this.bufferSize = i11;
    }

    public abstract void cleanupResources();

    public abstract void createFirstWindow();

    @Override // h10.b
    public final void dispose() {
        if (this.downstreamCancelled.compareAndSet(false, true)) {
            windowDone();
        }
    }

    public abstract void drain();

    @Override // h10.b
    public final boolean isDisposed() {
        return this.downstreamCancelled.get();
    }

    @Override // io.reactivex.rxjava3.core.o
    public final void onComplete() {
        this.done = true;
        drain();
    }

    @Override // io.reactivex.rxjava3.core.o
    public final void onError(Throwable th2) {
        this.error = th2;
        this.done = true;
        drain();
    }

    @Override // io.reactivex.rxjava3.core.o
    public final void onNext(T t11) {
        this.queue.offer(t11);
        drain();
    }

    @Override // io.reactivex.rxjava3.core.o
    public final void onSubscribe(h10.b bVar) {
        if (DisposableHelper.validate(this.upstream, bVar)) {
            this.upstream = bVar;
            this.downstream.onSubscribe(this);
            createFirstWindow();
        }
    }

    public final void windowDone() {
        if (this.windowCount.decrementAndGet() == 0) {
            cleanupResources();
            this.upstream.dispose();
            this.upstreamCancelled = true;
            drain();
        }
    }
}
