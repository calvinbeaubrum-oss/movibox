package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import java.util.Collection;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
final class ObservableBufferTimed$BufferExactBoundedObserver<T, U extends Collection<? super T>> extends io.reactivex.rxjava3.internal.observers.c<T, U, U> implements Runnable, h10.b {
    U buffer;
    final k10.k<U> bufferSupplier;
    long consumerIndex;
    final int maxSize;
    long producerIndex;
    final boolean restartTimerOnMaxSize;
    h10.b timer;
    final long timespan;
    final TimeUnit unit;
    h10.b upstream;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    final Scheduler.Worker f67390w;

    public ObservableBufferTimed$BufferExactBoundedObserver(io.reactivex.rxjava3.core.o<? super U> oVar, k10.k<U> kVar, long j11, TimeUnit timeUnit, int i11, boolean z11, Scheduler.Worker worker) {
        super(oVar, new MpscLinkedQueue());
        this.bufferSupplier = kVar;
        this.timespan = j11;
        this.unit = timeUnit;
        this.maxSize = i11;
        this.restartTimerOnMaxSize = z11;
        this.f67390w = worker;
    }

    @Override // io.reactivex.rxjava3.internal.observers.c, io.reactivex.rxjava3.internal.util.e
    public /* bridge */ /* synthetic */ void accept(io.reactivex.rxjava3.core.o oVar, Object obj) {
        accept((io.reactivex.rxjava3.core.o<? super Collection>) oVar, (Collection) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void accept(io.reactivex.rxjava3.core.o<? super U> oVar, U u11) {
        oVar.onNext(u11);
    }

    @Override // h10.b
    public void dispose() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        this.upstream.dispose();
        this.f67390w.dispose();
        synchronized (this) {
            this.buffer = null;
        }
    }

    @Override // h10.b
    public boolean isDisposed() {
        return this.cancelled;
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onComplete() {
        U u11;
        this.f67390w.dispose();
        synchronized (this) {
            u11 = this.buffer;
            this.buffer = null;
        }
        if (u11 != null) {
            this.queue.offer(u11);
            this.done = true;
            if (enter()) {
                io.reactivex.rxjava3.internal.util.i.d(this.queue, this.downstream, false, this, this);
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onError(Throwable th2) {
        synchronized (this) {
            this.buffer = null;
        }
        this.downstream.onError(th2);
        this.f67390w.dispose();
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onNext(T t11) {
        synchronized (this) {
            try {
                U u11 = this.buffer;
                if (u11 == null) {
                    return;
                }
                u11.add(t11);
                if (u11.size() < this.maxSize) {
                    return;
                }
                this.buffer = null;
                this.producerIndex++;
                if (this.restartTimerOnMaxSize) {
                    this.timer.dispose();
                }
                fastPathOrderedEmit(u11, false, this);
                try {
                    U u12 = this.bufferSupplier.get();
                    Objects.requireNonNull(u12, "The buffer supplied is null");
                    U u13 = u12;
                    synchronized (this) {
                        this.buffer = u13;
                        this.consumerIndex++;
                    }
                    if (this.restartTimerOnMaxSize) {
                        Scheduler.Worker worker = this.f67390w;
                        long j11 = this.timespan;
                        this.timer = worker.schedulePeriodically(this, j11, j11, this.unit);
                    }
                } catch (Throwable th2) {
                    i10.a.b(th2);
                    this.downstream.onError(th2);
                    dispose();
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onSubscribe(h10.b bVar) {
        if (DisposableHelper.validate(this.upstream, bVar)) {
            this.upstream = bVar;
            try {
                U u11 = this.bufferSupplier.get();
                Objects.requireNonNull(u11, "The buffer supplied is null");
                this.buffer = u11;
                this.downstream.onSubscribe(this);
                Scheduler.Worker worker = this.f67390w;
                long j11 = this.timespan;
                this.timer = worker.schedulePeriodically(this, j11, j11, this.unit);
            } catch (Throwable th2) {
                i10.a.b(th2);
                bVar.dispose();
                EmptyDisposable.error(th2, this.downstream);
                this.f67390w.dispose();
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            U u11 = this.bufferSupplier.get();
            Objects.requireNonNull(u11, "The bufferSupplier returned a null buffer");
            U u12 = u11;
            synchronized (this) {
                U u13 = this.buffer;
                if (u13 != null && this.producerIndex == this.consumerIndex) {
                    this.buffer = u12;
                    fastPathOrderedEmit(u13, false, this);
                }
            }
        } catch (Throwable th2) {
            i10.a.b(th2);
            dispose();
            this.downstream.onError(th2);
        }
    }
}
