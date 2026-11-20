package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.exceptions.OnErrorNotImplementedException;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class EmptyCompletableObserver extends AtomicReference<h10.b> implements io.reactivex.rxjava3.core.b, h10.b {
    private static final long serialVersionUID = -7545121636549663526L;

    @Override // h10.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean hasCustomOnError() {
        return false;
    }

    @Override // h10.b
    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    @Override // io.reactivex.rxjava3.core.b
    public void onComplete() {
        lazySet(DisposableHelper.DISPOSED);
    }

    @Override // io.reactivex.rxjava3.core.b
    public void onError(Throwable th2) {
        lazySet(DisposableHelper.DISPOSED);
        p10.a.q(new OnErrorNotImplementedException(th2));
    }

    @Override // io.reactivex.rxjava3.core.b
    public void onSubscribe(h10.b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }
}
