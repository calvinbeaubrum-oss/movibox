package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
final class FlowableInterval$IntervalSubscriber extends AtomicLong implements u30.d, Runnable {
    private static final long serialVersionUID = -2809475196591179431L;
    long count;
    final u30.c<? super Long> downstream;
    final AtomicReference<h10.b> resource = new AtomicReference<>();

    public FlowableInterval$IntervalSubscriber(u30.c<? super Long> cVar) {
        this.downstream = cVar;
    }

    @Override // u30.d
    public void cancel() {
        DisposableHelper.dispose(this.resource);
    }

    @Override // u30.d
    public void request(long j11) {
        if (SubscriptionHelper.validate(j11)) {
            io.reactivex.rxjava3.internal.util.a.a(this, j11);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.resource.get() != DisposableHelper.DISPOSED) {
            if (get() != 0) {
                u30.c<? super Long> cVar = this.downstream;
                long j11 = this.count;
                this.count = j11 + 1;
                cVar.onNext(Long.valueOf(j11));
                io.reactivex.rxjava3.internal.util.a.d(this, 1L);
                return;
            }
            this.downstream.onError(new MissingBackpressureException("Can't deliver value " + this.count + " due to lack of requests"));
            DisposableHelper.dispose(this.resource);
        }
    }

    public void setResource(h10.b bVar) {
        DisposableHelper.setOnce(this.resource, bVar);
    }
}
