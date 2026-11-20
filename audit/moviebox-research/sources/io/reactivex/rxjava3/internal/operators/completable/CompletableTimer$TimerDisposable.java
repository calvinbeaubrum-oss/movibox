package io.reactivex.rxjava3.internal.operators.completable;

import h10.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
final class CompletableTimer$TimerDisposable extends AtomicReference<b> implements b, Runnable {
    private static final long serialVersionUID = 3167244060586201109L;
    final io.reactivex.rxjava3.core.b downstream;

    public CompletableTimer$TimerDisposable(io.reactivex.rxjava3.core.b bVar) {
        this.downstream = bVar;
    }

    @Override // h10.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // h10.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // java.lang.Runnable
    public void run() {
        this.downstream.onComplete();
    }

    public void setFuture(b bVar) {
        DisposableHelper.replace(this, bVar);
    }
}
