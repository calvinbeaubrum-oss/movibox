package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import u30.c;
import u30.d;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
final class ParallelRunOn$RunOnSubscriber<T> extends ParallelRunOn$BaseRunOnSubscriber<T> {
    private static final long serialVersionUID = 1075119423897941642L;
    final c<? super T> downstream;

    public ParallelRunOn$RunOnSubscriber(c<? super T> cVar, int i11, SpscArrayQueue<T> spscArrayQueue, Scheduler.Worker worker) {
        super(i11, spscArrayQueue, worker);
        this.downstream = cVar;
    }

    @Override // io.reactivex.rxjava3.internal.operators.parallel.ParallelRunOn$BaseRunOnSubscriber, u30.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.upstream, dVar)) {
            this.upstream = dVar;
            this.downstream.onSubscribe(this);
            dVar.request(this.prefetch);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Throwable th2;
        int i11 = this.consumed;
        SpscArrayQueue<T> spscArrayQueue = this.queue;
        c<? super T> cVar = this.downstream;
        int i12 = this.limit;
        int iAddAndGet = 1;
        while (true) {
            long j11 = this.requested.get();
            long j12 = 0;
            while (j12 != j11) {
                if (this.cancelled) {
                    spscArrayQueue.clear();
                    return;
                }
                boolean z11 = this.done;
                if (z11 && (th2 = this.error) != null) {
                    spscArrayQueue.clear();
                    cVar.onError(th2);
                    this.worker.dispose();
                    return;
                }
                T tPoll = spscArrayQueue.poll();
                boolean z12 = tPoll == null;
                if (z11 && z12) {
                    cVar.onComplete();
                    this.worker.dispose();
                    return;
                } else {
                    if (z12) {
                        break;
                    }
                    cVar.onNext(tPoll);
                    j12++;
                    i11++;
                    if (i11 == i12) {
                        this.upstream.request(i11);
                        i11 = 0;
                    }
                }
            }
            if (j12 == j11) {
                if (this.cancelled) {
                    spscArrayQueue.clear();
                    return;
                }
                if (this.done) {
                    Throwable th3 = this.error;
                    if (th3 != null) {
                        spscArrayQueue.clear();
                        cVar.onError(th3);
                        this.worker.dispose();
                        return;
                    } else if (spscArrayQueue.isEmpty()) {
                        cVar.onComplete();
                        this.worker.dispose();
                        return;
                    }
                }
            }
            if (j12 != 0 && j11 != Long.MAX_VALUE) {
                this.requested.addAndGet(-j12);
            }
            int i13 = get();
            if (i13 == iAddAndGet) {
                this.consumed = i11;
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            } else {
                iAddAndGet = i13;
            }
        }
    }
}
