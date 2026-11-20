package io.reactivex.rxjava3.internal.operators.completable;

import h10.b;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
final class CompletableObserveOn$ObserveOnCompletableObserver extends AtomicReference<b> implements io.reactivex.rxjava3.core.b, b, Runnable {
    private static final long serialVersionUID = 8571289934935992137L;
    final io.reactivex.rxjava3.core.b downstream;
    Throwable error;
    final Scheduler scheduler;

    public CompletableObserveOn$ObserveOnCompletableObserver(io.reactivex.rxjava3.core.b bVar, Scheduler scheduler) {
        this.downstream = bVar;
        this.scheduler = scheduler;
    }

    @Override // h10.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // h10.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // io.reactivex.rxjava3.core.b
    public void onComplete() {
        DisposableHelper.replace(this, this.scheduler.d(this));
    }

    @Override // io.reactivex.rxjava3.core.b
    public void onError(Throwable th2) {
        this.error = th2;
        DisposableHelper.replace(this, this.scheduler.d(this));
    }

    @Override // io.reactivex.rxjava3.core.b
    public void onSubscribe(b bVar) {
        if (DisposableHelper.setOnce(this, bVar)) {
            this.downstream.onSubscribe(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Throwable th2 = this.error;
        if (th2 == null) {
            this.downstream.onComplete();
        } else {
            this.error = null;
            this.downstream.onError(th2);
        }
    }
}
