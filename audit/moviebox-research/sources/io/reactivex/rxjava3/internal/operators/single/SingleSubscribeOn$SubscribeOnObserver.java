package io.reactivex.rxjava3.internal.operators.single;

import h10.b;
import io.reactivex.rxjava3.core.q;
import io.reactivex.rxjava3.core.r;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
final class SingleSubscribeOn$SubscribeOnObserver<T> extends AtomicReference<b> implements q<T>, b, Runnable {
    private static final long serialVersionUID = 7000911171163930287L;
    final q<? super T> downstream;
    final r<? extends T> source;
    final SequentialDisposable task = new SequentialDisposable();

    public SingleSubscribeOn$SubscribeOnObserver(q<? super T> qVar, r<? extends T> rVar) {
        this.downstream = qVar;
        this.source = rVar;
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

    @Override // io.reactivex.rxjava3.core.q
    public void onError(Throwable th2) {
        this.downstream.onError(th2);
    }

    @Override // io.reactivex.rxjava3.core.q
    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }

    @Override // io.reactivex.rxjava3.core.q
    public void onSuccess(T t11) {
        this.downstream.onSuccess(t11);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.source.a(this);
    }
}
