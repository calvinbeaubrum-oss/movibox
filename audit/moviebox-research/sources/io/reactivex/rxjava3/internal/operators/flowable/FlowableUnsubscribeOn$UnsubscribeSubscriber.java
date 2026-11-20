package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
final class FlowableUnsubscribeOn$UnsubscribeSubscriber<T> extends AtomicBoolean implements io.reactivex.rxjava3.core.f<T>, u30.d {
    private static final long serialVersionUID = 1015244841293359600L;
    final u30.c<? super T> downstream;
    final Scheduler scheduler;
    u30.d upstream;

    /* JADX INFO: compiled from: source.java */
    public final class Cancellation implements Runnable {
        public Cancellation() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FlowableUnsubscribeOn$UnsubscribeSubscriber.this.upstream.cancel();
        }
    }

    public FlowableUnsubscribeOn$UnsubscribeSubscriber(u30.c<? super T> cVar, Scheduler scheduler) {
        this.downstream = cVar;
        this.scheduler = scheduler;
    }

    @Override // u30.d
    public void cancel() {
        if (compareAndSet(false, true)) {
            this.scheduler.d(new Cancellation());
        }
    }

    @Override // u30.c
    public void onComplete() {
        if (get()) {
            return;
        }
        this.downstream.onComplete();
    }

    @Override // u30.c
    public void onError(Throwable th2) {
        if (get()) {
            p10.a.q(th2);
        } else {
            this.downstream.onError(th2);
        }
    }

    @Override // u30.c
    public void onNext(T t11) {
        if (get()) {
            return;
        }
        this.downstream.onNext(t11);
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
        this.upstream.request(j11);
    }
}
