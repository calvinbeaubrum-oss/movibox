package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public final class ObservableSubscribeOn<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Scheduler f67406b;

    /* JADX INFO: compiled from: source.java */
    public static final class SubscribeOnObserver<T> extends AtomicReference<h10.b> implements io.reactivex.rxjava3.core.o<T>, h10.b {
        private static final long serialVersionUID = 8094547886072529208L;
        final io.reactivex.rxjava3.core.o<? super T> downstream;
        final AtomicReference<h10.b> upstream = new AtomicReference<>();

        public SubscribeOnObserver(io.reactivex.rxjava3.core.o<? super T> oVar) {
            this.downstream = oVar;
        }

        @Override // h10.b
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            DisposableHelper.dispose(this);
        }

        @Override // h10.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onError(Throwable th2) {
            this.downstream.onError(th2);
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onNext(T t11) {
            this.downstream.onNext(t11);
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onSubscribe(h10.b bVar) {
            DisposableHelper.setOnce(this.upstream, bVar);
        }

        public void setDisposable(h10.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class SubscribeTask implements Runnable {
        private final SubscribeOnObserver<T> parent;

        public SubscribeTask(SubscribeOnObserver<T> subscribeOnObserver) {
            this.parent = subscribeOnObserver;
        }

        @Override // java.lang.Runnable
        public void run() {
            ObservableSubscribeOn.this.f67422a.subscribe(this.parent);
        }
    }

    public ObservableSubscribeOn(io.reactivex.rxjava3.core.m<T> mVar, Scheduler scheduler) {
        super(mVar);
        this.f67406b = scheduler;
    }

    @Override // io.reactivex.rxjava3.core.j
    public void z(io.reactivex.rxjava3.core.o<? super T> oVar) {
        SubscribeOnObserver subscribeOnObserver = new SubscribeOnObserver(oVar);
        oVar.onSubscribe(subscribeOnObserver);
        subscribeOnObserver.setDisposable(this.f67406b.d(new SubscribeTask(subscribeOnObserver)));
    }
}
