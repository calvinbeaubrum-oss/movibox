package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import p10.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
final class CompletableDisposeOn$DisposeOnObserver implements b, h10.b, Runnable {
    volatile boolean disposed;
    final b downstream;
    final Scheduler scheduler;
    h10.b upstream;

    public CompletableDisposeOn$DisposeOnObserver(b bVar, Scheduler scheduler) {
        this.downstream = bVar;
        this.scheduler = scheduler;
    }

    @Override // h10.b
    public void dispose() {
        this.disposed = true;
        this.scheduler.d(this);
    }

    @Override // h10.b
    public boolean isDisposed() {
        return this.disposed;
    }

    @Override // io.reactivex.rxjava3.core.b
    public void onComplete() {
        if (this.disposed) {
            return;
        }
        this.downstream.onComplete();
    }

    @Override // io.reactivex.rxjava3.core.b
    public void onError(Throwable th2) {
        if (this.disposed) {
            a.q(th2);
        } else {
            this.downstream.onError(th2);
        }
    }

    @Override // io.reactivex.rxjava3.core.b
    public void onSubscribe(h10.b bVar) {
        if (DisposableHelper.validate(this.upstream, bVar)) {
            this.upstream = bVar;
            this.downstream.onSubscribe(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        this.upstream.dispose();
        this.upstream = DisposableHelper.DISPOSED;
    }
}
