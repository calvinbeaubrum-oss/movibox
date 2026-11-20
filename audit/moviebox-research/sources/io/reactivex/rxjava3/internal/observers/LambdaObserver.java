package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.core.o;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.functions.Functions;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class LambdaObserver<T> extends AtomicReference<h10.b> implements o<T>, h10.b {
    private static final long serialVersionUID = -7251123623727029452L;
    final k10.a onComplete;
    final k10.f<? super Throwable> onError;
    final k10.f<? super T> onNext;
    final k10.f<? super h10.b> onSubscribe;

    public LambdaObserver(k10.f<? super T> fVar, k10.f<? super Throwable> fVar2, k10.a aVar, k10.f<? super h10.b> fVar3) {
        this.onNext = fVar;
        this.onError = fVar2;
        this.onComplete = aVar;
        this.onSubscribe = fVar3;
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

    @Override // io.reactivex.rxjava3.core.o
    public void onComplete() {
        if (isDisposed()) {
            return;
        }
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onComplete.run();
        } catch (Throwable th2) {
            i10.a.b(th2);
            p10.a.q(th2);
        }
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onError(Throwable th2) {
        if (isDisposed()) {
            p10.a.q(th2);
            return;
        }
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onError.accept(th2);
        } catch (Throwable th3) {
            i10.a.b(th3);
            p10.a.q(new CompositeException(th2, th3));
        }
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onNext(T t11) {
        if (isDisposed()) {
            return;
        }
        try {
            this.onNext.accept(t11);
        } catch (Throwable th2) {
            i10.a.b(th2);
            get().dispose();
            onError(th2);
        }
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onSubscribe(h10.b bVar) {
        if (DisposableHelper.setOnce(this, bVar)) {
            try {
                this.onSubscribe.accept(this);
            } catch (Throwable th2) {
                i10.a.b(th2);
                bVar.dispose();
                onError(th2);
            }
        }
    }
}
