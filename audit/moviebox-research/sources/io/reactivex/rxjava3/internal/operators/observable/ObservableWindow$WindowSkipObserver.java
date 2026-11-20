package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.subjects.UnicastSubject;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
final class ObservableWindow$WindowSkipObserver<T> extends AtomicInteger implements io.reactivex.rxjava3.core.o<T>, h10.b, Runnable {
    private static final long serialVersionUID = 3366976432059579510L;
    final int capacityHint;
    final long count;
    final io.reactivex.rxjava3.core.o<? super io.reactivex.rxjava3.core.j<T>> downstream;
    long firstEmission;
    long index;
    final long skip;
    h10.b upstream;
    final ArrayDeque<UnicastSubject<T>> windows = new ArrayDeque<>();
    final AtomicBoolean cancelled = new AtomicBoolean();

    public ObservableWindow$WindowSkipObserver(io.reactivex.rxjava3.core.o<? super io.reactivex.rxjava3.core.j<T>> oVar, long j11, long j12, int i11) {
        this.downstream = oVar;
        this.count = j11;
        this.skip = j12;
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
        ArrayDeque<UnicastSubject<T>> arrayDeque = this.windows;
        while (!arrayDeque.isEmpty()) {
            arrayDeque.poll().onComplete();
        }
        this.downstream.onComplete();
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onError(Throwable th2) {
        ArrayDeque<UnicastSubject<T>> arrayDeque = this.windows;
        while (!arrayDeque.isEmpty()) {
            arrayDeque.poll().onError(th2);
        }
        this.downstream.onError(th2);
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onNext(T t11) {
        p pVar;
        ArrayDeque<UnicastSubject<T>> arrayDeque = this.windows;
        long j11 = this.index;
        long j12 = this.skip;
        if (j11 % j12 != 0 || this.cancelled.get()) {
            pVar = null;
        } else {
            getAndIncrement();
            UnicastSubject<T> unicastSubjectF = UnicastSubject.F(this.capacityHint, this);
            pVar = new p(unicastSubjectF);
            arrayDeque.offer(unicastSubjectF);
            this.downstream.onNext(pVar);
        }
        long j13 = this.firstEmission + 1;
        Iterator<UnicastSubject<T>> it = arrayDeque.iterator();
        while (it.hasNext()) {
            it.next().onNext(t11);
        }
        if (j13 >= this.count) {
            arrayDeque.poll().onComplete();
            if (arrayDeque.isEmpty() && this.cancelled.get()) {
                return;
            } else {
                this.firstEmission = j13 - j12;
            }
        } else {
            this.firstEmission = j13;
        }
        this.index = j11 + 1;
        if (pVar == null || !pVar.F()) {
            return;
        }
        pVar.f67455a.onComplete();
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
