package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
final class FlowableIntervalRange$IntervalRangeSubscriber extends AtomicLong implements u30.d, Runnable {
    private static final long serialVersionUID = -2809475196591179431L;
    long count;
    final u30.c<? super Long> downstream;
    final long end;
    final AtomicReference<h10.b> resource = new AtomicReference<>();

    public FlowableIntervalRange$IntervalRangeSubscriber(u30.c<? super Long> cVar, long j11, long j12) {
        this.downstream = cVar;
        this.count = j11;
        this.end = j12;
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
        h10.b bVar = this.resource.get();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (bVar != disposableHelper) {
            long j11 = get();
            if (j11 == 0) {
                this.downstream.onError(new MissingBackpressureException("Can't deliver value " + this.count + " due to lack of requests"));
                DisposableHelper.dispose(this.resource);
                return;
            }
            long j12 = this.count;
            this.downstream.onNext(Long.valueOf(j12));
            if (j12 == this.end) {
                if (this.resource.get() != disposableHelper) {
                    this.downstream.onComplete();
                }
                DisposableHelper.dispose(this.resource);
            } else {
                this.count = j12 + 1;
                if (j11 != Long.MAX_VALUE) {
                    decrementAndGet();
                }
            }
        }
    }

    public void setResource(h10.b bVar) {
        DisposableHelper.setOnce(this.resource, bVar);
    }
}
