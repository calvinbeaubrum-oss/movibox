package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.f;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import java.util.concurrent.atomic.AtomicInteger;
import m10.g;
import u30.d;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public abstract class ConcatMapXMainSubscriber<T> extends AtomicInteger implements f<T> {
    private static final long serialVersionUID = -3214213361171757852L;
    volatile boolean cancelled;
    volatile boolean done;
    final ErrorMode errorMode;
    final AtomicThrowable errors = new AtomicThrowable();
    final int prefetch;
    g<T> queue;
    boolean syncFused;
    d upstream;

    public ConcatMapXMainSubscriber(int i11, ErrorMode errorMode) {
        this.errorMode = errorMode;
        this.prefetch = i11;
    }

    public void clearValue() {
    }

    public abstract void disposeInner();

    public abstract void drain();

    @Override // u30.c
    public final void onComplete() {
        this.done = true;
        drain();
    }

    @Override // u30.c
    public final void onError(Throwable th2) {
        if (this.errors.tryAddThrowableOrReport(th2)) {
            if (this.errorMode == ErrorMode.IMMEDIATE) {
                disposeInner();
            }
            this.done = true;
            drain();
        }
    }

    @Override // u30.c
    public final void onNext(T t11) {
        if (t11 == null || this.queue.offer(t11)) {
            drain();
        } else {
            this.upstream.cancel();
            onError(new MissingBackpressureException("queue full?!"));
        }
    }

    @Override // u30.c
    public final void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.upstream, dVar)) {
            this.upstream = dVar;
            if (dVar instanceof m10.d) {
                m10.d dVar2 = (m10.d) dVar;
                int iRequestFusion = dVar2.requestFusion(7);
                if (iRequestFusion == 1) {
                    this.queue = dVar2;
                    this.syncFused = true;
                    this.done = true;
                    onSubscribeDownstream();
                    drain();
                    return;
                }
                if (iRequestFusion == 2) {
                    this.queue = dVar2;
                    onSubscribeDownstream();
                    this.upstream.request(this.prefetch);
                    return;
                }
            }
            this.queue = new SpscArrayQueue(this.prefetch);
            onSubscribeDownstream();
            this.upstream.request(this.prefetch);
        }
    }

    public abstract void onSubscribeDownstream();

    public final void stop() {
        this.cancelled = true;
        this.upstream.cancel();
        disposeInner();
        this.errors.tryTerminateAndReport();
        if (getAndIncrement() == 0) {
            this.queue.clear();
            clearValue();
        }
    }
}
