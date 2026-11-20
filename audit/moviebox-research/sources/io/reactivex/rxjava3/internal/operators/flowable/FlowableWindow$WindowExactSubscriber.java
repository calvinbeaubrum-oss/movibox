package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.processors.UnicastProcessor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
final class FlowableWindow$WindowExactSubscriber<T> extends AtomicInteger implements io.reactivex.rxjava3.core.f<T>, u30.d, Runnable {
    private static final long serialVersionUID = -2365647875069161133L;
    final int bufferSize;
    final u30.c<? super io.reactivex.rxjava3.core.e<T>> downstream;
    long index;
    final AtomicBoolean once;
    final long size;
    u30.d upstream;
    UnicastProcessor<T> window;

    public FlowableWindow$WindowExactSubscriber(u30.c<? super io.reactivex.rxjava3.core.e<T>> cVar, long j11, int i11) {
        super(1);
        this.downstream = cVar;
        this.size = j11;
        this.once = new AtomicBoolean();
        this.bufferSize = i11;
    }

    @Override // u30.d
    public void cancel() {
        if (this.once.compareAndSet(false, true)) {
            run();
        }
    }

    @Override // u30.c
    public void onComplete() {
        UnicastProcessor<T> unicastProcessor = this.window;
        if (unicastProcessor != null) {
            this.window = null;
            unicastProcessor.onComplete();
        }
        this.downstream.onComplete();
    }

    @Override // u30.c
    public void onError(Throwable th2) {
        UnicastProcessor<T> unicastProcessor = this.window;
        if (unicastProcessor != null) {
            this.window = null;
            unicastProcessor.onError(th2);
        }
        this.downstream.onError(th2);
    }

    @Override // u30.c
    public void onNext(T t11) {
        g gVar;
        long j11 = this.index;
        UnicastProcessor<T> unicastProcessorI = this.window;
        if (j11 == 0) {
            getAndIncrement();
            unicastProcessorI = UnicastProcessor.i(this.bufferSize, this);
            this.window = unicastProcessorI;
            gVar = new g(unicastProcessorI);
            this.downstream.onNext(gVar);
        } else {
            gVar = null;
        }
        long j12 = j11 + 1;
        unicastProcessorI.onNext(t11);
        if (j12 == this.size) {
            this.index = 0L;
            this.window = null;
            unicastProcessorI.onComplete();
        } else {
            this.index = j12;
        }
        if (gVar == null || !gVar.h()) {
            return;
        }
        gVar.f67377b.onComplete();
    }

    @Override // u30.c
    public void onSubscribe(u30.d dVar) {
        if (SubscriptionHelper.validate(this.upstream, dVar)) {
            this.upstream = dVar;
            this.downstream.onSubscribe(this);
        }
    }

    @Override // u30.d
    public void request(long j11) {
        if (SubscriptionHelper.validate(j11)) {
            this.upstream.request(io.reactivex.rxjava3.internal.util.a.c(this.size, j11));
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (decrementAndGet() == 0) {
            this.upstream.cancel();
        }
    }
}
