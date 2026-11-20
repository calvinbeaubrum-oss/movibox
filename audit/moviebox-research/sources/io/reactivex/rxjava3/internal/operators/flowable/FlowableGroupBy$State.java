package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
final class FlowableGroupBy$State<T, K> extends BasicIntQueueSubscription<T> implements u30.b<T> {
    static final int ABANDONED = 2;
    static final int ABANDONED_HAS_SUBSCRIBER = 3;
    static final int FRESH = 0;
    static final int HAS_SUBSCRIBER = 1;
    private static final long serialVersionUID = -3852313036005250360L;
    final boolean delayError;
    volatile boolean done;
    Throwable error;
    final K key;
    boolean outputFused;
    final FlowableGroupBy$GroupBySubscriber<?, K, T> parent;
    int produced;
    final io.reactivex.rxjava3.internal.queue.a<T> queue;
    final AtomicLong requested = new AtomicLong();
    final AtomicBoolean cancelled = new AtomicBoolean();
    final AtomicReference<u30.c<? super T>> actual = new AtomicReference<>();
    final AtomicInteger once = new AtomicInteger();
    final AtomicBoolean evictOnce = new AtomicBoolean();

    public FlowableGroupBy$State(int i11, FlowableGroupBy$GroupBySubscriber<?, K, T> flowableGroupBy$GroupBySubscriber, K k11, boolean z11) {
        this.queue = new io.reactivex.rxjava3.internal.queue.a<>(i11);
        this.parent = flowableGroupBy$GroupBySubscriber;
        this.key = k11;
        this.delayError = z11;
    }

    @Override // io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription, u30.d
    public void cancel() {
        if (this.cancelled.compareAndSet(false, true)) {
            cancelParent();
            drain();
        }
    }

    public void cancelParent() {
        if ((this.once.get() & 2) == 0 && this.evictOnce.compareAndSet(false, true)) {
            this.parent.cancel(this.key);
        }
    }

    public boolean checkTerminated(boolean z11, boolean z12, u30.c<? super T> cVar, boolean z13, long j11, boolean z14) {
        if (this.cancelled.get()) {
            cleanupQueue(j11, z14);
            return true;
        }
        if (!z11) {
            return false;
        }
        if (z13) {
            if (!z12) {
                return false;
            }
            this.cancelled.lazySet(true);
            Throwable th2 = this.error;
            if (th2 != null) {
                cVar.onError(th2);
            } else {
                cVar.onComplete();
                replenishParent(j11, z14);
            }
            return true;
        }
        Throwable th3 = this.error;
        if (th3 != null) {
            this.queue.clear();
            this.cancelled.lazySet(true);
            cVar.onError(th3);
            return true;
        }
        if (!z12) {
            return false;
        }
        this.cancelled.lazySet(true);
        cVar.onComplete();
        replenishParent(j11, z14);
        return true;
    }

    public void cleanupQueue(long j11, boolean z11) {
        while (this.queue.poll() != null) {
            j11++;
        }
        replenishParent(j11, z11);
    }

    @Override // io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription, m10.g
    public void clear() {
        io.reactivex.rxjava3.internal.queue.a<T> aVar = this.queue;
        while (aVar.poll() != null) {
            this.produced++;
        }
        tryReplenish();
    }

    public void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        if (this.outputFused) {
            drainFused();
        } else {
            drainNormal();
        }
    }

    public void drainFused() {
        Throwable th2;
        io.reactivex.rxjava3.internal.queue.a<T> aVar = this.queue;
        u30.c<? super T> cVar = this.actual.get();
        int iAddAndGet = 1;
        while (true) {
            if (cVar != null) {
                if (this.cancelled.get()) {
                    return;
                }
                boolean z11 = this.done;
                if (z11 && !this.delayError && (th2 = this.error) != null) {
                    aVar.clear();
                    cVar.onError(th2);
                    return;
                }
                cVar.onNext(null);
                if (z11) {
                    Throwable th3 = this.error;
                    if (th3 != null) {
                        cVar.onError(th3);
                        return;
                    } else {
                        cVar.onComplete();
                        return;
                    }
                }
            }
            iAddAndGet = addAndGet(-iAddAndGet);
            if (iAddAndGet == 0) {
                return;
            }
            if (cVar == null) {
                cVar = this.actual.get();
            }
        }
    }

    public void drainNormal() {
        long j11;
        long j12;
        long j13;
        io.reactivex.rxjava3.internal.queue.a<T> aVar = this.queue;
        boolean z11 = this.delayError;
        u30.c<? super T> cVar = this.actual.get();
        AtomicBoolean atomicBoolean = this.cancelled;
        u30.c<? super T> cVar2 = cVar;
        int iAddAndGet = 1;
        while (true) {
            long j14 = 0;
            if (atomicBoolean.get()) {
                cleanupQueue(0L, false);
            } else if (cVar2 != null) {
                long j15 = this.requested.get();
                long j16 = 0;
                while (true) {
                    if (j16 != j15) {
                        boolean z12 = this.done;
                        T tPoll = aVar.poll();
                        boolean z13 = tPoll == null;
                        long j17 = j16;
                        j11 = j14;
                        if (checkTerminated(z12, z13, cVar2, z11, j17, !z13)) {
                            continue;
                        } else if (z13) {
                            j12 = j17;
                        } else {
                            cVar2.onNext(tPoll);
                            j16 = j17 + 1;
                            j14 = j11;
                        }
                    } else {
                        j11 = j14;
                        j12 = j16;
                    }
                    if (j16 == j15) {
                        long j18 = j12;
                        if (checkTerminated(this.done, aVar.isEmpty(), cVar2, z11, j12, false)) {
                            continue;
                        } else {
                            j13 = j18;
                        }
                    } else {
                        j13 = j12;
                    }
                    if (j13 != j11) {
                        io.reactivex.rxjava3.internal.util.a.d(this.requested, j13);
                        requestParent(j13);
                    }
                }
            }
            iAddAndGet = addAndGet(-iAddAndGet);
            if (iAddAndGet == 0) {
                return;
            }
            if (cVar2 == null) {
                cVar2 = this.actual.get();
            }
        }
    }

    @Override // io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription, m10.g
    public boolean isEmpty() {
        if (this.queue.isEmpty()) {
            tryReplenish();
            return true;
        }
        tryReplenish();
        return false;
    }

    public void onComplete() {
        this.done = true;
        drain();
    }

    public void onError(Throwable th2) {
        this.error = th2;
        this.done = true;
        drain();
    }

    public void onNext(T t11) {
        this.queue.offer(t11);
        drain();
    }

    @Override // io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription, m10.g
    public T poll() {
        T tPoll = this.queue.poll();
        if (tPoll != null) {
            this.produced++;
            return tPoll;
        }
        tryReplenish();
        return null;
    }

    public void replenishParent(long j11, boolean z11) {
        if (z11) {
            j11++;
        }
        if (j11 != 0) {
            requestParent(j11);
        }
    }

    @Override // io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription, u30.d
    public void request(long j11) {
        if (SubscriptionHelper.validate(j11)) {
            io.reactivex.rxjava3.internal.util.a.a(this.requested, j11);
            drain();
        }
    }

    @Override // io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription, m10.c
    public int requestFusion(int i11) {
        return 0;
    }

    public void requestParent(long j11) {
        if ((this.once.get() & 2) == 0) {
            this.parent.requestGroup(j11);
        }
    }

    @Override // u30.b
    public void subscribe(u30.c<? super T> cVar) {
        int i11;
        do {
            i11 = this.once.get();
            if ((i11 & 1) != 0) {
                EmptySubscription.error(new IllegalStateException("Only one Subscriber allowed!"), cVar);
                return;
            }
        } while (!this.once.compareAndSet(i11, i11 | 1));
        cVar.onSubscribe(this);
        this.actual.lazySet(cVar);
        if (this.cancelled.get()) {
            this.actual.lazySet(null);
        } else {
            drain();
        }
    }

    public boolean tryAbandon() {
        return this.once.get() == 0 && this.once.compareAndSet(0, 2);
    }

    public boolean tryComplete() {
        boolean zCompareAndSet = this.evictOnce.compareAndSet(false, true);
        this.done = true;
        drain();
        return zCompareAndSet;
    }

    public void tryReplenish() {
        int i11 = this.produced;
        if (i11 != 0) {
            this.produced = 0;
            requestParent(i11);
        }
    }
}
