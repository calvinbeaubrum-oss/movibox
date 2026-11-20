package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import java.util.Collection;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
final class ObservableBufferTimed$BufferExactUnboundedObserver<T, U extends Collection<? super T>> extends io.reactivex.rxjava3.internal.observers.c<T, U, U> implements Runnable, h10.b {
    U buffer;
    final k10.k<U> bufferSupplier;
    final Scheduler scheduler;
    final AtomicReference<h10.b> timer;
    final long timespan;
    final TimeUnit unit;
    h10.b upstream;

    public ObservableBufferTimed$BufferExactUnboundedObserver(io.reactivex.rxjava3.core.o<? super U> oVar, k10.k<U> kVar, long j11, TimeUnit timeUnit, Scheduler scheduler) {
        super(oVar, new MpscLinkedQueue());
        this.timer = new AtomicReference<>();
        this.bufferSupplier = kVar;
        this.timespan = j11;
        this.unit = timeUnit;
        this.scheduler = scheduler;
    }

    @Override // io.reactivex.rxjava3.internal.observers.c, io.reactivex.rxjava3.internal.util.e
    public /* bridge */ /* synthetic */ void accept(io.reactivex.rxjava3.core.o oVar, Object obj) {
        accept((io.reactivex.rxjava3.core.o<? super Collection>) oVar, (Collection) obj);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public void accept(io.reactivex.rxjava3.core.o<? super U> oVar, U u11) {
        this.downstream.onNext((Object) u11);
    }

    @Override // h10.b
    public void dispose() {
        DisposableHelper.dispose(this.timer);
        this.upstream.dispose();
    }

    @Override // h10.b
    public boolean isDisposed() {
        return this.timer.get() == DisposableHelper.DISPOSED;
    }

    @Override // io.reactivex.rxjava3.core.o
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
                io.reactivex.rxjava3.internal.util.i.d(this.queue, this.downstream, false, null, this);
            }
        }
        DisposableHelper.dispose(this.timer);
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onError(Throwable th2) {
        synchronized (this) {
            this.buffer = null;
        }
        this.downstream.onError(th2);
        DisposableHelper.dispose(this.timer);
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
            } catch (Throwable th2) {
                throw th2;
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
                if (DisposableHelper.isDisposed(this.timer.get())) {
                    return;
                }
                Scheduler scheduler = this.scheduler;
                long j11 = this.timespan;
                DisposableHelper.set(this.timer, scheduler.f(this, j11, j11, this.unit));
            } catch (Throwable th2) {
                i10.a.b(th2);
                dispose();
                EmptyDisposable.error(th2, this.downstream);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        U u11;
        try {
            U u12 = this.bufferSupplier.get();
            Objects.requireNonNull(u12, "The bufferSupplier returned a null buffer");
            U u13 = u12;
            synchronized (this) {
                try {
                    u11 = this.buffer;
                    if (u11 != null) {
                        this.buffer = u13;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (u11 == null) {
                DisposableHelper.dispose(this.timer);
            } else {
                fastPathEmit(u11, false, this);
            }
        } catch (Throwable th3) {
            i10.a.b(th3);
            this.downstream.onError(th3);
            dispose();
        }
    }
}
