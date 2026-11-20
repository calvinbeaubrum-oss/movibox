package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.exceptions.OnErrorNotImplementedException;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class CallbackCompletableObserver extends AtomicReference<h10.b> implements io.reactivex.rxjava3.core.b, h10.b, k10.f<Throwable> {
    private static final long serialVersionUID = -4361286194466301354L;
    final k10.a onComplete;
    final k10.f<? super Throwable> onError;

    public CallbackCompletableObserver(k10.a aVar) {
        this.onError = this;
        this.onComplete = aVar;
    }

    public CallbackCompletableObserver(k10.f<? super Throwable> fVar, k10.a aVar) {
        this.onError = fVar;
        this.onComplete = aVar;
    }

    @Override // k10.f
    public void accept(Throwable th2) {
        p10.a.q(new OnErrorNotImplementedException(th2));
    }

    @Override // h10.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean hasCustomOnError() {
        return this.onError != this;
    }

    @Override // h10.b
    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    @Override // io.reactivex.rxjava3.core.b
    public void onComplete() {
        try {
            this.onComplete.run();
        } catch (Throwable th2) {
            i10.a.b(th2);
            p10.a.q(th2);
        }
        lazySet(DisposableHelper.DISPOSED);
    }

    @Override // io.reactivex.rxjava3.core.b
    public void onError(Throwable th2) {
        try {
            this.onError.accept(th2);
        } catch (Throwable th3) {
            i10.a.b(th3);
            p10.a.q(th3);
        }
        lazySet(DisposableHelper.DISPOSED);
    }

    @Override // io.reactivex.rxjava3.core.b
    public void onSubscribe(h10.b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }
}
