package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.i;
import java.util.Collection;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import k10.k;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
final class FlowableBufferTimed$BufferExactBoundedSubscriber<T, U extends Collection<? super T>> extends io.reactivex.rxjava3.internal.subscribers.b<T, U, U> implements u30.d, Runnable, h10.b {
    U buffer;
    final k<U> bufferSupplier;
    long consumerIndex;
    final int maxSize;
    long producerIndex;
    final boolean restartTimerOnMaxSize;
    h10.b timer;
    final long timespan;
    final TimeUnit unit;
    u30.d upstream;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    final Scheduler.Worker f67355w;

    public FlowableBufferTimed$BufferExactBoundedSubscriber(u30.c<? super U> cVar, k<U> kVar, long j11, TimeUnit timeUnit, int i11, boolean z11, Scheduler.Worker worker) {
        super(cVar, new MpscLinkedQueue());
        this.bufferSupplier = kVar;
        this.timespan = j11;
        this.unit = timeUnit;
        this.maxSize = i11;
        this.restartTimerOnMaxSize = z11;
        this.f67355w = worker;
    }

    @Override // io.reactivex.rxjava3.internal.subscribers.b, io.reactivex.rxjava3.internal.util.h
    public /* bridge */ /* synthetic */ boolean accept(u30.c cVar, Object obj) {
        return accept((u30.c<? super Collection>) cVar, (Collection) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean accept(u30.c<? super U> cVar, U u11) {
        cVar.onNext(u11);
        return true;
    }

    @Override // u30.d
    public void cancel() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        dispose();
    }

    @Override // h10.b
    public void dispose() {
        synchronized (this) {
            this.buffer = null;
        }
        this.upstream.cancel();
        this.f67355w.dispose();
    }

    @Override // h10.b
    public boolean isDisposed() {
        return this.f67355w.isDisposed();
    }

    @Override // u30.c
    public void onComplete() {
        U u11;
        synchronized (this) {
            u11 = this.buffer;
            this.buffer = null;
        }
        if (u11 != null) {
            this.queue.offer(u11);
            this.done = true;
            if (enter()) {
                i.e(this.queue, this.downstream, false, this, this);
            }
            this.f67355w.dispose();
        }
    }

    @Override // u30.c
    public void onError(Throwable th2) {
        synchronized (this) {
            this.buffer = null;
        }
        this.downstream.onError(th2);
        this.f67355w.dispose();
    }

    @Override // u30.c
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
                fastPathOrderedEmitMax(u11, false, this);
                try {
                    U u12 = this.bufferSupplier.get();
                    Objects.requireNonNull(u12, "The supplied buffer is null");
                    U u13 = u12;
                    synchronized (this) {
                        this.buffer = u13;
                        this.consumerIndex++;
                    }
                    if (this.restartTimerOnMaxSize) {
                        Scheduler.Worker worker = this.f67355w;
                        long j11 = this.timespan;
                        this.timer = worker.schedulePeriodically(this, j11, j11, this.unit);
                    }
                } catch (Throwable th2) {
                    i10.a.b(th2);
                    cancel();
                    this.downstream.onError(th2);
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    @Override // u30.c
    public void onSubscribe(u30.d dVar) {
        if (SubscriptionHelper.validate(this.upstream, dVar)) {
            this.upstream = dVar;
            try {
                U u11 = this.bufferSupplier.get();
                Objects.requireNonNull(u11, "The supplied buffer is null");
                this.buffer = u11;
                this.downstream.onSubscribe(this);
                Scheduler.Worker worker = this.f67355w;
                long j11 = this.timespan;
                this.timer = worker.schedulePeriodically(this, j11, j11, this.unit);
                dVar.request(Long.MAX_VALUE);
            } catch (Throwable th2) {
                i10.a.b(th2);
                this.f67355w.dispose();
                dVar.cancel();
                EmptySubscription.error(th2, this.downstream);
            }
        }
    }

    @Override // u30.d
    public void request(long j11) {
        requested(j11);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            U u11 = this.bufferSupplier.get();
            Objects.requireNonNull(u11, "The supplied buffer is null");
            U u12 = u11;
            synchronized (this) {
                U u13 = this.buffer;
                if (u13 != null && this.producerIndex == this.consumerIndex) {
                    this.buffer = u12;
                    fastPathOrderedEmitMax(u13, false, this);
                }
            }
        } catch (Throwable th2) {
            i10.a.b(th2);
            cancel();
            this.downstream.onError(th2);
        }
    }
}
