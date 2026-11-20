package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import k10.h;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
abstract class FlowableConcatMapScheduler$BaseConcatMapSubscriber<T, R> extends AtomicInteger implements io.reactivex.rxjava3.core.f<T>, b<R>, u30.d, Runnable {
    private static final long serialVersionUID = -3511336836796789179L;
    volatile boolean active;
    volatile boolean cancelled;
    int consumed;
    volatile boolean done;
    final int limit;
    final h<? super T, ? extends u30.b<? extends R>> mapper;
    final int prefetch;
    m10.g<T> queue;
    int sourceMode;
    u30.d upstream;
    final Scheduler.Worker worker;
    final FlowableConcatMap$ConcatMapInner<R> inner = new FlowableConcatMap$ConcatMapInner<>(this);
    final AtomicThrowable errors = new AtomicThrowable();

    public FlowableConcatMapScheduler$BaseConcatMapSubscriber(h<? super T, ? extends u30.b<? extends R>> hVar, int i11, Scheduler.Worker worker) {
        this.mapper = hVar;
        this.prefetch = i11;
        this.limit = i11 - (i11 >> 2);
        this.worker = worker;
    }

    @Override // u30.d
    public abstract /* synthetic */ void cancel();

    @Override // io.reactivex.rxjava3.internal.operators.flowable.b
    public final void innerComplete() {
        this.active = false;
        schedule();
    }

    @Override // io.reactivex.rxjava3.internal.operators.flowable.b
    public abstract /* synthetic */ void innerError(Throwable th2);

    @Override // io.reactivex.rxjava3.internal.operators.flowable.b
    public abstract /* synthetic */ void innerNext(Object obj);

    @Override // u30.c
    public final void onComplete() {
        this.done = true;
        schedule();
    }

    @Override // u30.c
    public abstract /* synthetic */ void onError(Throwable th2);

    @Override // u30.c
    public final void onNext(T t11) {
        if (this.sourceMode == 2 || this.queue.offer(t11)) {
            schedule();
        } else {
            this.upstream.cancel();
            onError(new IllegalStateException("Queue full?!"));
        }
    }

    @Override // u30.c
    public final void onSubscribe(u30.d dVar) {
        if (SubscriptionHelper.validate(this.upstream, dVar)) {
            this.upstream = dVar;
            if (dVar instanceof m10.d) {
                m10.d dVar2 = (m10.d) dVar;
                int iRequestFusion = dVar2.requestFusion(7);
                if (iRequestFusion == 1) {
                    this.sourceMode = iRequestFusion;
                    this.queue = dVar2;
                    this.done = true;
                    subscribeActual();
                    schedule();
                    return;
                }
                if (iRequestFusion == 2) {
                    this.sourceMode = iRequestFusion;
                    this.queue = dVar2;
                    subscribeActual();
                    dVar.request(this.prefetch);
                    return;
                }
            }
            this.queue = new SpscArrayQueue(this.prefetch);
            subscribeActual();
            dVar.request(this.prefetch);
        }
    }

    @Override // u30.d
    public abstract /* synthetic */ void request(long j11);

    public abstract void schedule();

    public abstract void subscribeActual();
}
