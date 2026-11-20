package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
abstract class AbstractBackpressureThrottlingSubscriber<T, R> extends AtomicInteger implements io.reactivex.rxjava3.core.f<T>, u30.d {
    private static final long serialVersionUID = -5050301752721603566L;
    volatile boolean cancelled;
    volatile boolean done;
    final u30.c<? super R> downstream;
    Throwable error;
    u30.d upstream;
    final AtomicLong requested = new AtomicLong();
    final AtomicReference<R> current = new AtomicReference<>();

    public AbstractBackpressureThrottlingSubscriber(u30.c<? super R> cVar) {
        this.downstream = cVar;
    }

    @Override // u30.d
    public void cancel() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        this.upstream.cancel();
        if (getAndIncrement() == 0) {
            this.current.lazySet(null);
        }
    }

    public boolean checkTerminated(boolean z11, boolean z12, u30.c<?> cVar, AtomicReference<R> atomicReference) {
        if (this.cancelled) {
            atomicReference.lazySet(null);
            return true;
        }
        if (!z11) {
            return false;
        }
        Throwable th2 = this.error;
        if (th2 != null) {
            atomicReference.lazySet(null);
            cVar.onError(th2);
            return true;
        }
        if (!z12) {
            return false;
        }
        cVar.onComplete();
        return true;
    }

    public void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        u30.c<? super R> cVar = this.downstream;
        AtomicLong atomicLong = this.requested;
        AtomicReference<R> atomicReference = this.current;
        int iAddAndGet = 1;
        do {
            long j11 = 0;
            while (true) {
                if (j11 == atomicLong.get()) {
                    break;
                }
                boolean z11 = this.done;
                R andSet = atomicReference.getAndSet(null);
                boolean z12 = andSet == null;
                if (checkTerminated(z11, z12, cVar, atomicReference)) {
                    return;
                }
                if (z12) {
                    break;
                }
                cVar.onNext(andSet);
                j11++;
            }
            if (j11 == atomicLong.get()) {
                if (checkTerminated(this.done, atomicReference.get() == null, cVar, atomicReference)) {
                    return;
                }
            }
            if (j11 != 0) {
                io.reactivex.rxjava3.internal.util.a.d(atomicLong, j11);
            }
            iAddAndGet = addAndGet(-iAddAndGet);
        } while (iAddAndGet != 0);
    }

    @Override // u30.c
    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // u30.c
    public void onError(Throwable th2) {
        this.error = th2;
        this.done = true;
        drain();
    }

    @Override // u30.c
    public abstract void onNext(T t11);

    @Override // u30.c
    public void onSubscribe(u30.d dVar) {
        if (SubscriptionHelper.validate(this.upstream, dVar)) {
            this.upstream = dVar;
            this.downstream.onSubscribe(this);
            dVar.request(Long.MAX_VALUE);
        }
    }

    @Override // u30.d
    public void request(long j11) {
        if (SubscriptionHelper.validate(j11)) {
            io.reactivex.rxjava3.internal.util.a.a(this.requested, j11);
            drain();
        }
    }
}
