package io.reactivex.rxjava3.internal.operators.single;

import h10.b;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.q;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
final class SingleUnsubscribeOn$UnsubscribeOnSingleObserver<T> extends AtomicReference<b> implements q<T>, b, Runnable {
    private static final long serialVersionUID = 3256698449646456986L;
    final q<? super T> downstream;

    /* JADX INFO: renamed from: ds, reason: collision with root package name */
    b f67458ds;
    final Scheduler scheduler;

    public SingleUnsubscribeOn$UnsubscribeOnSingleObserver(q<? super T> qVar, Scheduler scheduler) {
        this.downstream = qVar;
        this.scheduler = scheduler;
    }

    @Override // h10.b
    public void dispose() {
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        b andSet = getAndSet(disposableHelper);
        if (andSet != disposableHelper) {
            this.f67458ds = andSet;
            this.scheduler.d(this);
        }
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
        if (DisposableHelper.setOnce(this, bVar)) {
            this.downstream.onSubscribe(this);
        }
    }

    @Override // io.reactivex.rxjava3.core.q
    public void onSuccess(T t11) {
        this.downstream.onSuccess(t11);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f67458ds.dispose();
    }
}
