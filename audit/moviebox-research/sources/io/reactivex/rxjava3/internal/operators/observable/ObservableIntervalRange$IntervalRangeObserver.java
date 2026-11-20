package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
final class ObservableIntervalRange$IntervalRangeObserver extends AtomicReference<h10.b> implements h10.b, Runnable {
    private static final long serialVersionUID = 1891866368734007884L;
    long count;
    final io.reactivex.rxjava3.core.o<? super Long> downstream;
    final long end;

    public ObservableIntervalRange$IntervalRangeObserver(io.reactivex.rxjava3.core.o<? super Long> oVar, long j11, long j12) {
        this.downstream = oVar;
        this.count = j11;
        this.end = j12;
    }

    @Override // h10.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // h10.b
    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (isDisposed()) {
            return;
        }
        long j11 = this.count;
        this.downstream.onNext(Long.valueOf(j11));
        if (j11 != this.end) {
            this.count = j11 + 1;
            return;
        }
        if (!isDisposed()) {
            this.downstream.onComplete();
        }
        DisposableHelper.dispose(this);
    }

    public void setResource(h10.b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }
}
