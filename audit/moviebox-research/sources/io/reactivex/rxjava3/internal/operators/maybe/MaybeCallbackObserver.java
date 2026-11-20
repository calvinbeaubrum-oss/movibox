package io.reactivex.rxjava3.internal.operators.maybe;

import h10.b;
import io.reactivex.rxjava3.core.h;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.functions.Functions;
import java.util.concurrent.atomic.AtomicReference;
import k10.a;
import k10.f;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class MaybeCallbackObserver<T> extends AtomicReference<b> implements h<T>, b {
    private static final long serialVersionUID = -6076952298809384986L;
    final a onComplete;
    final f<? super Throwable> onError;
    final f<? super T> onSuccess;

    public MaybeCallbackObserver(f<? super T> fVar, f<? super Throwable> fVar2, a aVar) {
        this.onSuccess = fVar;
        this.onError = fVar2;
        this.onComplete = aVar;
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
        return DisposableHelper.isDisposed(get());
    }

    @Override // io.reactivex.rxjava3.core.h
    public void onComplete() {
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onComplete.run();
        } catch (Throwable th2) {
            i10.a.b(th2);
            p10.a.q(th2);
        }
    }

    @Override // io.reactivex.rxjava3.core.h
    public void onError(Throwable th2) {
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onError.accept(th2);
        } catch (Throwable th3) {
            i10.a.b(th3);
            p10.a.q(new CompositeException(th2, th3));
        }
    }

    @Override // io.reactivex.rxjava3.core.h
    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }

    @Override // io.reactivex.rxjava3.core.h
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
