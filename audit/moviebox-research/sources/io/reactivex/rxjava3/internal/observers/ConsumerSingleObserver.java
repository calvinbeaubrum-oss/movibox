package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.core.q;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.functions.Functions;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class ConsumerSingleObserver<T> extends AtomicReference<h10.b> implements q<T>, h10.b {
    private static final long serialVersionUID = -7012088219455310787L;
    final k10.f<? super Throwable> onError;
    final k10.f<? super T> onSuccess;

    public ConsumerSingleObserver(k10.f<? super T> fVar, k10.f<? super Throwable> fVar2) {
        this.onSuccess = fVar;
        this.onError = fVar2;
    }

    @Override // h10.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean hasCustomOnError() {
        return this.onError != Functions.f67331f;
    }

    @Override // h10.b
    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    @Override // io.reactivex.rxjava3.core.q
    public void onError(Throwable th2) {
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onError.accept(th2);
        } catch (Throwable th3) {
            i10.a.b(th3);
            p10.a.q(new CompositeException(th2, th3));
        }
    }

    @Override // io.reactivex.rxjava3.core.q
    public void onSubscribe(h10.b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }

    @Override // io.reactivex.rxjava3.core.q
    public void onSuccess(T t11) {
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onSuccess.accept(t11);
        } catch (Throwable th2) {
            i10.a.b(th2);
            p10.a.q(th2);
        }
    }
}
