package io.reactivex.rxjava3.internal.subscriptions;

import java.util.concurrent.atomic.AtomicInteger;
import m10.d;
import u30.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class ScalarSubscription<T> extends AtomicInteger implements d<T> {
    static final int CANCELLED = 2;
    static final int NO_REQUEST = 0;
    static final int REQUESTED = 1;
    private static final long serialVersionUID = -3830916580126663321L;
    final c<? super T> subscriber;
    final T value;

    public ScalarSubscription(c<? super T> cVar, T t11) {
        this.subscriber = cVar;
        this.value = t11;
    }

    @Override // u30.d
    public void cancel() {
        lazySet(2);
    }

    @Override // m10.g
    public void clear() {
        lazySet(1);
    }

    public boolean isCancelled() {
        return get() == 2;
    }

    @Override // m10.g
    public boolean isEmpty() {
        return get() != 0;
    }

    @Override // m10.g
    public boolean offer(T t11) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public boolean offer(T t11, T t12) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // m10.g
    public T poll() {
        if (get() != 0) {
            return null;
        }
        lazySet(1);
        return this.value;
    }

    @Override // u30.d
    public void request(long j11) {
        if (SubscriptionHelper.validate(j11) && compareAndSet(0, 1)) {
            c<? super T> cVar = this.subscriber;
            cVar.onNext(this.value);
            if (get() != 2) {
                cVar.onComplete();
            }
        }
    }

    @Override // m10.c
    public int requestFusion(int i11) {
        return i11 & 1;
    }
}
