package io.reactivex.rxjava3.internal.operators.completable;

import h10.b;
import io.reactivex.rxjava3.core.c;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
final class CompletableSubscribeOn$SubscribeOnObserver extends AtomicReference<b> implements io.reactivex.rxjava3.core.b, b, Runnable {
    private static final long serialVersionUID = 7000911171163930287L;
    final io.reactivex.rxjava3.core.b downstream;
    final c source;
    final SequentialDisposable task = new SequentialDisposable();

    public CompletableSubscribeOn$SubscribeOnObserver(io.reactivex.rxjava3.core.b bVar, c cVar) {
        this.downstream = bVar;
        this.source = cVar;
    }

    @Override // h10.b
    public void dispose() {
        DisposableHelper.dispose(this);
        this.task.dispose();
    }

    @Override // h10.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // io.reactivex.rxjava3.core.b
    public void onComplete() {
        this.downstream.onComplete();
    }

    @Override // io.reactivex.rxjava3.core.b
    public void onError(Throwable th2) {
        this.downstream.onError(th2);
    }

    @Override // io.reactivex.rxjava3.core.b
    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.source.a(this);
    }
}
