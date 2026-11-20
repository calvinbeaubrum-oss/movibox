package io.reactivex.rxjava3.internal.operators.maybe;

import h10.b;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.h;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
final class MaybeUnsubscribeOn$UnsubscribeOnMaybeObserver<T> extends AtomicReference<b> implements h<T>, b, Runnable {
    private static final long serialVersionUID = 3256698449646456986L;
    final h<? super T> downstream;

    /* JADX INFO: renamed from: ds, reason: collision with root package name */
    b f67380ds;
    final Scheduler scheduler;

    public MaybeUnsubscribeOn$UnsubscribeOnMaybeObserver(h<? super T> hVar, Scheduler scheduler) {
        this.downstream = hVar;
        this.scheduler = scheduler;
    }

    @Override // h10.b
    public void dispose() {
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        b andSet = getAndSet(disposableHelper);
        if (andSet != disposableHelper) {
            this.f67380ds = andSet;
            this.scheduler.d(this);
        }
    }

    @Override // h10.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // io.reactivex.rxjava3.core.h
    public void onComplete() {
        this.downstream.onComplete();
    }

    @Override // io.reactivex.rxjava3.core.h
    public void onError(Throwable th2) {
        this.downstream.onError(th2);
    }

    @Override // io.reactivex.rxjava3.core.h
    public void onSubscribe(b bVar) {
        if (DisposableHelper.setOnce(this, bVar)) {
            this.downstream.onSubscribe(this);
        }
    }

    @Override // io.reactivex.rxjava3.core.h
    public void onSuccess(T t11) {
        this.downstream.onSuccess(t11);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f67380ds.dispose();
    }
}
