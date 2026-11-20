package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.subjects.UnicastSubject;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
final class ObservableWindow$WindowExactObserver<T> extends AtomicInteger implements io.reactivex.rxjava3.core.o<T>, h10.b, Runnable {
    private static final long serialVersionUID = -7481782523886138128L;
    final AtomicBoolean cancelled = new AtomicBoolean();
    final int capacityHint;
    final long count;
    final io.reactivex.rxjava3.core.o<? super io.reactivex.rxjava3.core.j<T>> downstream;
    long size;
    h10.b upstream;
    UnicastSubject<T> window;

    public ObservableWindow$WindowExactObserver(io.reactivex.rxjava3.core.o<? super io.reactivex.rxjava3.core.j<T>> oVar, long j11, int i11) {
        this.downstream = oVar;
        this.count = j11;
        this.capacityHint = i11;
        lazySet(1);
    }

    @Override // h10.b
    public void dispose() {
        if (this.cancelled.compareAndSet(false, true)) {
            run();
        }
    }

    @Override // h10.b
    public boolean isDisposed() {
        return this.cancelled.get();
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onComplete() {
        UnicastSubject<T> unicastSubject = this.window;
        if (unicastSubject != null) {
            this.window = null;
            unicastSubject.onComplete();
        }
        this.downstream.onComplete();
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onError(Throwable th2) {
        UnicastSubject<T> unicastSubject = this.window;
        if (unicastSubject != null) {
            this.window = null;
            unicastSubject.onError(th2);
        }
        this.downstream.onError(th2);
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onNext(T t11) {
        p pVar;
        UnicastSubject<T> unicastSubjectF = this.window;
        if (unicastSubjectF != null || this.cancelled.get()) {
            pVar = null;
        } else {
            getAndIncrement();
            unicastSubjectF = UnicastSubject.F(this.capacityHint, this);
            this.window = unicastSubjectF;
            pVar = new p(unicastSubjectF);
            this.downstream.onNext(pVar);
        }
        if (unicastSubjectF != null) {
            unicastSubjectF.onNext(t11);
            long j11 = this.size + 1;
            this.size = j11;
            if (j11 >= this.count) {
                this.size = 0L;
                this.window = null;
                unicastSubjectF.onComplete();
            }
            if (pVar == null || !pVar.F()) {
                return;
            }
            this.window = null;
            unicastSubjectF.onComplete();
        }
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onSubscribe(h10.b bVar) {
        if (DisposableHelper.validate(this.upstream, bVar)) {
            this.upstream = bVar;
            this.downstream.onSubscribe(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (decrementAndGet() == 0) {
            this.upstream.dispose();
        }
    }
}
