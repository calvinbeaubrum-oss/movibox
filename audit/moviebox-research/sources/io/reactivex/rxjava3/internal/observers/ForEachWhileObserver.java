package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.core.o;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import k10.j;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class ForEachWhileObserver<T> extends AtomicReference<h10.b> implements o<T>, h10.b {
    private static final long serialVersionUID = -4403180040475402120L;
    boolean done;
    final k10.a onComplete;
    final k10.f<? super Throwable> onError;
    final j<? super T> onNext;

    public ForEachWhileObserver(j<? super T> jVar, k10.f<? super Throwable> fVar, k10.a aVar) {
        this.onNext = jVar;
        this.onError = fVar;
        this.onComplete = aVar;
    }

    @Override // h10.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // h10.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        try {
            this.onComplete.run();
        } catch (Throwable th2) {
            i10.a.b(th2);
            p10.a.q(th2);
        }
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onError(Throwable th2) {
        if (this.done) {
            p10.a.q(th2);
            return;
        }
        this.done = true;
        try {
            this.onError.accept(th2);
        } catch (Throwable th3) {
            i10.a.b(th3);
            p10.a.q(new CompositeException(th2, th3));
        }
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onNext(T t11) {
        if (this.done) {
            return;
        }
        try {
            if (this.onNext.test(t11)) {
                return;
            }
            dispose();
            onComplete();
        } catch (Throwable th2) {
            i10.a.b(th2);
            dispose();
            onError(th2);
        }
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onSubscribe(h10.b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }
}
