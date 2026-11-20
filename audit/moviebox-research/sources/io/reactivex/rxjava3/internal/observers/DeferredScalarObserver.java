package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.core.o;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public abstract class DeferredScalarObserver<T, R> extends DeferredScalarDisposable<R> implements o<T> {
    private static final long serialVersionUID = -266195175408988651L;
    protected h10.b upstream;

    public DeferredScalarObserver(o<? super R> oVar) {
        super(oVar);
    }

    @Override // io.reactivex.rxjava3.internal.observers.DeferredScalarDisposable, io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable, h10.b
    public void dispose() {
        super.dispose();
        this.upstream.dispose();
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onComplete() {
        T t11 = this.value;
        if (t11 == null) {
            complete();
        } else {
            this.value = null;
            complete(t11);
        }
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onError(Throwable th2) {
        this.value = null;
        error(th2);
    }

    @Override // io.reactivex.rxjava3.core.o
    public abstract /* synthetic */ void onNext(Object obj);

    @Override // io.reactivex.rxjava3.core.o
    public void onSubscribe(h10.b bVar) {
        if (DisposableHelper.validate(this.upstream, bVar)) {
            this.upstream = bVar;
            this.downstream.onSubscribe(this);
        }
    }
}
