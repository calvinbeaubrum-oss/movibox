package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
final class FlowableSubscribeOn$SubscribeOnSubscriber<T> extends AtomicReference<Thread> implements io.reactivex.rxjava3.core.f<T>, u30.d, Runnable {
    private static final long serialVersionUID = 8094547886072529208L;
    final u30.c<? super T> downstream;
    final boolean nonScheduledRequests;
    u30.b<T> source;
    final Scheduler.Worker worker;
    final AtomicReference<u30.d> upstream = new AtomicReference<>();
    final AtomicLong requested = new AtomicLong();

    /* JADX INFO: compiled from: source.java */
    public static final class Request implements Runnable {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        final long f67364n;
        final u30.d upstream;

        public Request(u30.d dVar, long j11) {
            this.upstream = dVar;
            this.f67364n = j11;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.upstream.request(this.f67364n);
        }
    }

    public FlowableSubscribeOn$SubscribeOnSubscriber(u30.c<? super T> cVar, Scheduler.Worker worker, u30.b<T> bVar, boolean z11) {
        this.downstream = cVar;
        this.worker = worker;
        this.source = bVar;
        this.nonScheduledRequests = !z11;
    }

    @Override // u30.d
    public void cancel() {
        SubscriptionHelper.cancel(this.upstream);
        this.worker.dispose();
    }

    @Override // u30.c
    public void onComplete() {
        this.downstream.onComplete();
        this.worker.dispose();
    }

    @Override // u30.c
    public void onError(Throwable th2) {
        this.downstream.onError(th2);
        this.worker.dispose();
    }

    @Override // u30.c
    public void onNext(T t11) {
        this.downstream.onNext(t11);
    }

    @Override // u30.c
    public void onSubscribe(u30.d dVar) {
        if (SubscriptionHelper.setOnce(this.upstream, dVar)) {
            long andSet = this.requested.getAndSet(0L);
            if (andSet != 0) {
                requestUpstream(andSet, dVar);
            }
        }
    }

    @Override // u30.d
    public void request(long j11) {
        if (SubscriptionHelper.validate(j11)) {
            u30.d dVar = this.upstream.get();
            if (dVar != null) {
                requestUpstream(j11, dVar);
                return;
            }
            io.reactivex.rxjava3.internal.util.a.a(this.requested, j11);
            u30.d dVar2 = this.upstream.get();
            if (dVar2 != null) {
                long andSet = this.requested.getAndSet(0L);
                if (andSet != 0) {
                    requestUpstream(andSet, dVar2);
                }
            }
        }
    }

    public void requestUpstream(long j11, u30.d dVar) {
        if (this.nonScheduledRequests || Thread.currentThread() == get()) {
            dVar.request(j11);
        } else {
            this.worker.schedule(new Request(dVar, j11));
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        lazySet(Thread.currentThread());
        u30.b<T> bVar = this.source;
        this.source = null;
        bVar.subscribe(this);
    }
}
