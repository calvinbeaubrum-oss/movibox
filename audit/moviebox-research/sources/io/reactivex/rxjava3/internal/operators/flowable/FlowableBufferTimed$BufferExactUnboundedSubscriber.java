package io.reactivex.rxjava3.internal.operators.flowable;

import androidx.compose.animation.core.j0;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.i;
import java.util.Collection;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import k10.k;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
final class FlowableBufferTimed$BufferExactUnboundedSubscriber<T, U extends Collection<? super T>> extends io.reactivex.rxjava3.internal.subscribers.b<T, U, U> implements u30.d, Runnable, h10.b {
    U buffer;
    final k<U> bufferSupplier;
    final Scheduler scheduler;
    final AtomicReference<h10.b> timer;
    final long timespan;
    final TimeUnit unit;
    u30.d upstream;

    public FlowableBufferTimed$BufferExactUnboundedSubscriber(u30.c<? super U> cVar, k<U> kVar, long j11, TimeUnit timeUnit, Scheduler scheduler) {
        super(cVar, new MpscLinkedQueue());
        this.timer = new AtomicReference<>();
        this.bufferSupplier = kVar;
        this.timespan = j11;
        this.unit = timeUnit;
        this.scheduler = scheduler;
    }

    @Override // io.reactivex.rxjava3.internal.subscribers.b, io.reactivex.rxjava3.internal.util.h
    public /* bridge */ /* synthetic */ boolean accept(u30.c cVar, Object obj) {
        return accept((u30.c<? super Collection>) cVar, (Collection) obj);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public boolean accept(u30.c<? super U> cVar, U u11) {
        this.downstream.onNext((Object) u11);
        return true;
    }

    @Override // u30.d
    public void cancel() {
        this.cancelled = true;
        this.upstream.cancel();
        DisposableHelper.dispose(this.timer);
    }

    @Override // h10.b
    public void dispose() {
        cancel();
    }

    @Override // h10.b
    public boolean isDisposed() {
        return this.timer.get() == DisposableHelper.DISPOSED;
    }

    @Override // u30.c
    public void onComplete() {
        DisposableHelper.dispose(this.timer);
        synchronized (this) {
            try {
                U u11 = this.buffer;
                if (u11 == null) {
                    return;
                }
                this.buffer = null;
                this.queue.offer(u11);
                this.done = true;
                if (enter()) {
                    i.e(this.queue, this.downstream, false, null, this);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // u30.c
    public void onError(Throwable th2) {
        DisposableHelper.dispose(this.timer);
        synchronized (this) {
            this.buffer = null;
        }
        this.downstream.onError(th2);
    }

    @Override // u30.c
    public void onNext(T t11) {
        synchronized (this) {
            try {
                U u11 = this.buffer;
                if (u11 != null) {
                    u11.add(t11);
                }
            } catch (Throwable th2) {
                throw th2;
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
                if (this.cancelled) {
                    return;
                }
                dVar.request(Long.MAX_VALUE);
                Scheduler scheduler = this.scheduler;
                long j11 = this.timespan;
                h10.b bVarF = scheduler.f(this, j11, j11, this.unit);
                if (j0.a(this.timer, null, bVarF)) {
                    return;
                }
                bVarF.dispose();
            } catch (Throwable th2) {
                i10.a.b(th2);
                cancel();
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
                try {
                    U u13 = this.buffer;
                    if (u13 == null) {
                        return;
                    }
                    this.buffer = u12;
                    fastPathEmitMax(u13, false, this);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            i10.a.b(th3);
            cancel();
            this.downstream.onError(th3);
        }
    }
}
