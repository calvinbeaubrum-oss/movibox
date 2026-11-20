package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
final class FlowableObserveOn$ObserveOnSubscriber<T> extends FlowableObserveOn$BaseObserveOnSubscriber<T> {
    private static final long serialVersionUID = -4547113800637756442L;
    final u30.c<? super T> downstream;

    public FlowableObserveOn$ObserveOnSubscriber(u30.c<? super T> cVar, Scheduler.Worker worker, boolean z11, int i11) {
        super(worker, z11, i11);
        this.downstream = cVar;
    }

    @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableObserveOn$BaseObserveOnSubscriber, u30.c
    public void onSubscribe(u30.d dVar) {
        if (SubscriptionHelper.validate(this.upstream, dVar)) {
            this.upstream = dVar;
            if (dVar instanceof m10.d) {
                m10.d dVar2 = (m10.d) dVar;
                int iRequestFusion = dVar2.requestFusion(7);
                if (iRequestFusion == 1) {
                    this.sourceMode = 1;
                    this.queue = dVar2;
                    this.done = true;
                    this.downstream.onSubscribe(this);
                    return;
                }
                if (iRequestFusion == 2) {
                    this.sourceMode = 2;
                    this.queue = dVar2;
                    this.downstream.onSubscribe(this);
                    dVar.request(this.prefetch);
                    return;
                }
            }
            this.queue = new SpscArrayQueue(this.prefetch);
            this.downstream.onSubscribe(this);
            dVar.request(this.prefetch);
        }
    }

    @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableObserveOn$BaseObserveOnSubscriber, io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription, m10.g
    public T poll() throws Throwable {
        T tPoll = this.queue.poll();
        if (tPoll != null && this.sourceMode != 1) {
            long j11 = this.produced + 1;
            if (j11 == this.limit) {
                this.produced = 0L;
                this.upstream.request(j11);
            } else {
                this.produced = j11;
            }
        }
        return tPoll;
    }

    @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableObserveOn$BaseObserveOnSubscriber
    public void runAsync() {
        u30.c<? super T> cVar = this.downstream;
        m10.g<T> gVar = this.queue;
        long j11 = this.produced;
        int iAddAndGet = 1;
        while (true) {
            long jAddAndGet = this.requested.get();
            while (j11 != jAddAndGet) {
                boolean z11 = this.done;
                try {
                    T tPoll = gVar.poll();
                    boolean z12 = tPoll == null;
                    if (checkTerminated(z11, z12, cVar)) {
                        return;
                    }
                    if (z12) {
                        break;
                    }
                    cVar.onNext(tPoll);
                    j11++;
                    if (j11 == this.limit) {
                        if (jAddAndGet != Long.MAX_VALUE) {
                            jAddAndGet = this.requested.addAndGet(-j11);
                        }
                        this.upstream.request(j11);
                        j11 = 0;
                    }
                } catch (Throwable th2) {
                    i10.a.b(th2);
                    this.cancelled = true;
                    this.upstream.cancel();
                    gVar.clear();
                    cVar.onError(th2);
                    this.worker.dispose();
                    return;
                }
            }
            if (j11 == jAddAndGet && checkTerminated(this.done, gVar.isEmpty(), cVar)) {
                return;
            }
            int i11 = get();
            if (iAddAndGet == i11) {
                this.produced = j11;
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            } else {
                iAddAndGet = i11;
            }
        }
    }

    @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableObserveOn$BaseObserveOnSubscriber
    public void runBackfused() {
        int iAddAndGet = 1;
        while (!this.cancelled) {
            boolean z11 = this.done;
            this.downstream.onNext(null);
            if (z11) {
                this.cancelled = true;
                Throwable th2 = this.error;
                if (th2 != null) {
                    this.downstream.onError(th2);
                } else {
                    this.downstream.onComplete();
                }
                this.worker.dispose();
                return;
            }
            iAddAndGet = addAndGet(-iAddAndGet);
            if (iAddAndGet == 0) {
                return;
            }
        }
    }

    @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableObserveOn$BaseObserveOnSubscriber
    public void runSync() {
        u30.c<? super T> cVar = this.downstream;
        m10.g<T> gVar = this.queue;
        long j11 = this.produced;
        int iAddAndGet = 1;
        do {
            long j12 = this.requested.get();
            while (j11 != j12) {
                try {
                    T tPoll = gVar.poll();
                    if (this.cancelled) {
                        return;
                    }
                    if (tPoll == null) {
                        this.cancelled = true;
                        cVar.onComplete();
                        this.worker.dispose();
                        return;
                    }
                    cVar.onNext(tPoll);
                    j11++;
                } catch (Throwable th2) {
                    i10.a.b(th2);
                    this.cancelled = true;
                    this.upstream.cancel();
                    cVar.onError(th2);
                    this.worker.dispose();
                    return;
                }
            }
            if (this.cancelled) {
                return;
            }
            if (gVar.isEmpty()) {
                this.cancelled = true;
                cVar.onComplete();
                this.worker.dispose();
                return;
            }
            this.produced = j11;
            iAddAndGet = addAndGet(-iAddAndGet);
        } while (iAddAndGet != 0);
    }
}
