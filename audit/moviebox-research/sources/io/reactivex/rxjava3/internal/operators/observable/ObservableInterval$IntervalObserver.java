package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
final class ObservableInterval$IntervalObserver extends AtomicReference<h10.b> implements h10.b, Runnable {
    private static final long serialVersionUID = 346773832286157679L;
    long count;
    final io.reactivex.rxjava3.core.o<? super Long> downstream;

    public ObservableInterval$IntervalObserver(io.reactivex.rxjava3.core.o<? super Long> oVar) {
        this.downstream = oVar;
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
        if (get() != DisposableHelper.DISPOSED) {
            io.reactivex.rxjava3.core.o<? super Long> oVar = this.downstream;
            long j11 = this.count;
            this.count = 1 + j11;
            oVar.onNext(Long.valueOf(j11));
        }
    }

    public void setResource(h10.b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }
}
