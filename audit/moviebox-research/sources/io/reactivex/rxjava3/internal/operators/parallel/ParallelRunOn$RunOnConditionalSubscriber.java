package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import m10.a;
import u30.d;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
final class ParallelRunOn$RunOnConditionalSubscriber<T> extends ParallelRunOn$BaseRunOnSubscriber<T> {
    private static final long serialVersionUID = 1075119423897941642L;
    final a<? super T> downstream;

    public ParallelRunOn$RunOnConditionalSubscriber(a<? super T> aVar, int i11, SpscArrayQueue<T> spscArrayQueue, Scheduler.Worker worker) {
        super(i11, spscArrayQueue, worker);
    }

    @Override // io.reactivex.rxjava3.internal.operators.parallel.ParallelRunOn$BaseRunOnSubscriber, u30.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.upstream, dVar)) {
            this.upstream = dVar;
            throw null;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        int i11 = this.consumed;
        SpscArrayQueue<T> spscArrayQueue = this.queue;
        int iAddAndGet = 1;
        do {
            long j11 = this.requested.get();
            if (0 != j11) {
                if (this.cancelled) {
                    spscArrayQueue.clear();
                    return;
                }
                boolean z11 = this.done;
                if (z11 && this.error != null) {
                    spscArrayQueue.clear();
                    throw null;
                }
                boolean z12 = spscArrayQueue.poll() == null;
                if (z11 && z12) {
                    throw null;
                }
                if (!z12) {
                    throw null;
                }
            }
            if (0 == j11) {
                if (this.cancelled) {
                    spscArrayQueue.clear();
                    return;
                } else if (this.done) {
                    if (this.error != null) {
                        spscArrayQueue.clear();
                        throw null;
                    }
                    if (spscArrayQueue.isEmpty()) {
                        throw null;
                    }
                }
            }
            if (0 != 0) {
                io.reactivex.rxjava3.internal.util.a.d(this.requested, 0L);
            }
            this.consumed = i11;
            iAddAndGet = addAndGet(-iAddAndGet);
        } while (iAddAndGet != 0);
    }
}
