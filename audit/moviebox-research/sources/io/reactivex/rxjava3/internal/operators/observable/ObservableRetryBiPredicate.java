package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public final class ObservableRetryBiPredicate<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k10.d<? super Integer, ? super Throwable> f67403b;

    /* JADX INFO: compiled from: source.java */
    public static final class RetryBiObserver<T> extends AtomicInteger implements io.reactivex.rxjava3.core.o<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final io.reactivex.rxjava3.core.o<? super T> downstream;
        final k10.d<? super Integer, ? super Throwable> predicate;
        int retries;
        final io.reactivex.rxjava3.core.m<? extends T> source;
        final SequentialDisposable upstream;

        public RetryBiObserver(io.reactivex.rxjava3.core.o<? super T> oVar, k10.d<? super Integer, ? super Throwable> dVar, SequentialDisposable sequentialDisposable, io.reactivex.rxjava3.core.m<? extends T> mVar) {
            this.downstream = oVar;
            this.upstream = sequentialDisposable;
            this.source = mVar;
            this.predicate = dVar;
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onError(Throwable th2) {
            try {
                k10.d<? super Integer, ? super Throwable> dVar = this.predicate;
                int i11 = this.retries + 1;
                this.retries = i11;
                if (dVar.test(Integer.valueOf(i11), th2)) {
                    subscribeNext();
                } else {
                    this.downstream.onError(th2);
                }
            } catch (Throwable th3) {
                i10.a.b(th3);
                this.downstream.onError(new CompositeException(th2, th3));
            }
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onNext(T t11) {
            this.downstream.onNext(t11);
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onSubscribe(h10.b bVar) {
            this.upstream.replace(bVar);
        }

        public void subscribeNext() {
            if (getAndIncrement() == 0) {
                int iAddAndGet = 1;
                while (!this.upstream.isDisposed()) {
                    this.source.subscribe(this);
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
        }
    }

    public ObservableRetryBiPredicate(io.reactivex.rxjava3.core.j<T> jVar, k10.d<? super Integer, ? super Throwable> dVar) {
        super(jVar);
        this.f67403b = dVar;
    }

    @Override // io.reactivex.rxjava3.core.j
    public void z(io.reactivex.rxjava3.core.o<? super T> oVar) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        oVar.onSubscribe(sequentialDisposable);
        new RetryBiObserver(oVar, this.f67403b, sequentialDisposable, this.f67422a).subscribeNext();
    }
}
