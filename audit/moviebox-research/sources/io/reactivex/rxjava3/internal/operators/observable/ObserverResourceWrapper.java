package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class ObserverResourceWrapper<T> extends AtomicReference<h10.b> implements io.reactivex.rxjava3.core.o<T>, h10.b {
    private static final long serialVersionUID = -8612022020200669122L;
    final io.reactivex.rxjava3.core.o<? super T> downstream;
    final AtomicReference<h10.b> upstream = new AtomicReference<>();

    public ObserverResourceWrapper(io.reactivex.rxjava3.core.o<? super T> oVar) {
        this.downstream = oVar;
    }

    @Override // h10.b
    public void dispose() {
        DisposableHelper.dispose(this.upstream);
        DisposableHelper.dispose(this);
    }

    @Override // h10.b
    public boolean isDisposed() {
        return this.upstream.get() == DisposableHelper.DISPOSED;
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onComplete() {
        dispose();
        this.downstream.onComplete();
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onError(Throwable th2) {
        dispose();
        this.downstream.onError(th2);
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onNext(T t11) {
        this.downstream.onNext(t11);
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onSubscribe(h10.b bVar) {
        if (DisposableHelper.setOnce(this.upstream, bVar)) {
            this.downstream.onSubscribe(this);
        }
    }

    public void setResource(h10.b bVar) {
        DisposableHelper.set(this, bVar);
    }
}
