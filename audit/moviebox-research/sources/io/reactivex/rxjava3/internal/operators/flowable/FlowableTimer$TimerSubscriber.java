package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
final class FlowableTimer$TimerSubscriber extends AtomicReference<h10.b> implements u30.d, Runnable {
    private static final long serialVersionUID = -2809475196591179431L;
    final u30.c<? super Long> downstream;
    volatile boolean requested;

    public FlowableTimer$TimerSubscriber(u30.c<? super Long> cVar) {
        this.downstream = cVar;
    }

    @Override // u30.d
    public void cancel() {
        DisposableHelper.dispose(this);
    }

    @Override // u30.d
    public void request(long j11) {
        if (SubscriptionHelper.validate(j11)) {
            this.requested = true;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (get() != DisposableHelper.DISPOSED) {
            if (!this.requested) {
                lazySet(EmptyDisposable.INSTANCE);
                this.downstream.onError(new MissingBackpressureException("Can't deliver value due to lack of requests"));
            } else {
                this.downstream.onNext(0L);
                lazySet(EmptyDisposable.INSTANCE);
                this.downstream.onComplete();
            }
        }
    }

    public void setResource(h10.b bVar) {
        DisposableHelper.trySet(this, bVar);
    }
}
