package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
final class FlowableObserveOn$ObserveOnConditionalSubscriber<T> extends FlowableObserveOn$BaseObserveOnSubscriber<T> {
    private static final long serialVersionUID = 644624475404284533L;
    long consumed;
    final m10.a<? super T> downstream;

    public FlowableObserveOn$ObserveOnConditionalSubscriber(m10.a<? super T> aVar, Scheduler.Worker worker, boolean z11, int i11) {
        super(worker, z11, i11);
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
                    throw null;
                }
                if (iRequestFusion == 2) {
                    this.sourceMode = 2;
                    this.queue = dVar2;
                    throw null;
                }
            }
            this.queue = new SpscArrayQueue(this.prefetch);
            throw null;
        }
    }

    @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableObserveOn$BaseObserveOnSubscriber, io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription, m10.g
    public T poll() throws Throwable {
        T tPoll = this.queue.poll();
        if (tPoll != null && this.sourceMode != 1) {
            long j11 = this.consumed + 1;
            if (j11 == this.limit) {
                this.consumed = 0L;
                this.upstream.request(j11);
            } else {
                this.consumed = j11;
            }
        }
        return tPoll;
    }

    @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableObserveOn$BaseObserveOnSubscriber
    public void runAsync() {
        m10.g<T> gVar = this.queue;
        long j11 = this.produced;
        long j12 = this.consumed;
        int iAddAndGet = 1;
        do {
            long j13 = this.requested.get();
            if (j11 != j13) {
                boolean z11 = this.done;
                try {
                    boolean z12 = gVar.poll() == null;
                    if (checkTerminated(z11, z12, null)) {
                        return;
                    }
                    if (!z12) {
                        throw null;
                    }
                } catch (Throwable th2) {
                    i10.a.b(th2);
                    this.cancelled = true;
                    this.upstream.cancel();
                    gVar.clear();
                    throw null;
                }
            }
            if (j11 == j13 && checkTerminated(this.done, gVar.isEmpty(), null)) {
                return;
            }
            this.produced = j11;
            this.consumed = j12;
            iAddAndGet = addAndGet(-iAddAndGet);
        } while (iAddAndGet != 0);
    }

    @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableObserveOn$BaseObserveOnSubscriber
    public void runBackfused() {
        if (!this.cancelled) {
            throw null;
        }
    }

    @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableObserveOn$BaseObserveOnSubscriber
    public void runSync() {
        m10.g<T> gVar = this.queue;
        long j11 = this.produced;
        int iAddAndGet = 1;
        while (j11 == this.requested.get()) {
            if (this.cancelled) {
                return;
            }
            if (gVar.isEmpty()) {
                this.cancelled = true;
                throw null;
            }
            this.produced = j11;
            iAddAndGet = addAndGet(-iAddAndGet);
            if (iAddAndGet == 0) {
                return;
            }
        }
        try {
            T tPoll = gVar.poll();
            if (this.cancelled) {
                return;
            }
            if (tPoll != null) {
                throw null;
            }
            this.cancelled = true;
            throw null;
        } catch (Throwable th2) {
            i10.a.b(th2);
            this.cancelled = true;
            this.upstream.cancel();
            throw null;
        }
    }
}
