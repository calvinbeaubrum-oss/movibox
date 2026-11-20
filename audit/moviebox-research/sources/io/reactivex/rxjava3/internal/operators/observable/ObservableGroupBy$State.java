package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
final class ObservableGroupBy$State<T, K> extends AtomicInteger implements h10.b, io.reactivex.rxjava3.core.m<T> {
    static final int ABANDONED = 2;
    static final int ABANDONED_HAS_SUBSCRIBER = 3;
    static final int FRESH = 0;
    static final int HAS_SUBSCRIBER = 1;
    private static final long serialVersionUID = -3852313036005250360L;
    final boolean delayError;
    volatile boolean done;
    Throwable error;
    final K key;
    final ObservableGroupBy$GroupByObserver<?, K, T> parent;
    final io.reactivex.rxjava3.internal.queue.a<T> queue;
    final AtomicBoolean cancelled = new AtomicBoolean();
    final AtomicReference<io.reactivex.rxjava3.core.o<? super T>> actual = new AtomicReference<>();
    final AtomicInteger once = new AtomicInteger();

    public ObservableGroupBy$State(int i11, ObservableGroupBy$GroupByObserver<?, K, T> observableGroupBy$GroupByObserver, K k11, boolean z11) {
        this.queue = new io.reactivex.rxjava3.internal.queue.a<>(i11);
        this.parent = observableGroupBy$GroupByObserver;
        this.key = k11;
        this.delayError = z11;
    }

    public void cancelParent() {
        if ((this.once.get() & 2) == 0) {
            this.parent.cancel(this.key);
        }
    }

    public boolean checkTerminated(boolean z11, boolean z12, io.reactivex.rxjava3.core.o<? super T> oVar, boolean z13) {
        if (this.cancelled.get()) {
            this.queue.clear();
            this.actual.lazySet(null);
            cancelParent();
            return true;
        }
        if (!z11) {
            return false;
        }
        if (z13) {
            if (!z12) {
                return false;
            }
            Throwable th2 = this.error;
            this.actual.lazySet(null);
            if (th2 != null) {
                oVar.onError(th2);
            } else {
                oVar.onComplete();
            }
            return true;
        }
        Throwable th3 = this.error;
        if (th3 != null) {
            this.queue.clear();
            this.actual.lazySet(null);
            oVar.onError(th3);
            return true;
        }
        if (!z12) {
            return false;
        }
        this.actual.lazySet(null);
        oVar.onComplete();
        return true;
    }

    @Override // h10.b
    public void dispose() {
        if (this.cancelled.compareAndSet(false, true) && getAndIncrement() == 0) {
            this.actual.lazySet(null);
            cancelParent();
        }
    }

    public void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        io.reactivex.rxjava3.internal.queue.a<T> aVar = this.queue;
        boolean z11 = this.delayError;
        io.reactivex.rxjava3.core.o<? super T> oVar = this.actual.get();
        int iAddAndGet = 1;
        while (true) {
            if (oVar != null) {
                while (true) {
                    boolean z12 = this.done;
                    T tPoll = aVar.poll();
                    boolean z13 = tPoll == null;
                    if (checkTerminated(z12, z13, oVar, z11)) {
                        return;
                    }
                    if (z13) {
                        break;
                    } else {
                        oVar.onNext(tPoll);
                    }
                }
            }
            iAddAndGet = addAndGet(-iAddAndGet);
            if (iAddAndGet == 0) {
                return;
            }
            if (oVar == null) {
                oVar = this.actual.get();
            }
        }
    }

    @Override // h10.b
    public boolean isDisposed() {
        return this.cancelled.get();
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

    @Override // io.reactivex.rxjava3.core.m
    public void subscribe(io.reactivex.rxjava3.core.o<? super T> oVar) {
        int i11;
        do {
            i11 = this.once.get();
            if ((i11 & 1) != 0) {
                EmptyDisposable.error(new IllegalStateException("Only one Observer allowed!"), oVar);
                return;
            }
        } while (!this.once.compareAndSet(i11, i11 | 1));
        oVar.onSubscribe(this);
        this.actual.lazySet(oVar);
        if (this.cancelled.get()) {
            this.actual.lazySet(null);
        } else {
            drain();
        }
    }

    public boolean tryAbandon() {
        return this.once.get() == 0 && this.once.compareAndSet(0, 2);
    }
}
