package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
final class ObservableTimer$TimerObserver extends AtomicReference<h10.b> implements h10.b, Runnable {
    private static final long serialVersionUID = -2809475196591179431L;
    final io.reactivex.rxjava3.core.o<? super Long> downstream;

    public ObservableTimer$TimerObserver(io.reactivex.rxjava3.core.o<? super Long> oVar) {
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
        if (isDisposed()) {
            return;
        }
        this.downstream.onNext(0L);
        lazySet(EmptyDisposable.INSTANCE);
        this.downstream.onComplete();
    }

    public void setResource(h10.b bVar) {
        DisposableHelper.trySet(this, bVar);
    }
}
