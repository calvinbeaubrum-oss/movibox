package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
final class ObservableUnsubscribeOn$UnsubscribeObserver<T> extends AtomicBoolean implements io.reactivex.rxjava3.core.o<T>, h10.b {
    private static final long serialVersionUID = 1015244841293359600L;
    final io.reactivex.rxjava3.core.o<? super T> downstream;
    final Scheduler scheduler;
    h10.b upstream;

    /* JADX INFO: compiled from: source.java */
    public final class DisposeTask implements Runnable {
        public DisposeTask() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ObservableUnsubscribeOn$UnsubscribeObserver.this.upstream.dispose();
        }
    }

    public ObservableUnsubscribeOn$UnsubscribeObserver(io.reactivex.rxjava3.core.o<? super T> oVar, Scheduler scheduler) {
        this.downstream = oVar;
        this.scheduler = scheduler;
    }

    @Override // h10.b
    public void dispose() {
        if (compareAndSet(false, true)) {
            this.scheduler.d(new DisposeTask());
        }
    }

    @Override // h10.b
    public boolean isDisposed() {
        return get();
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onComplete() {
        if (get()) {
            return;
        }
        this.downstream.onComplete();
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onError(Throwable th2) {
        if (get()) {
            p10.a.q(th2);
        } else {
            this.downstream.onError(th2);
        }
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onNext(T t11) {
        if (get()) {
            return;
        }
        this.downstream.onNext(t11);
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onSubscribe(h10.b bVar) {
        if (DisposableHelper.validate(this.upstream, bVar)) {
            this.upstream = bVar;
            this.downstream.onSubscribe(this);
        }
    }
}
