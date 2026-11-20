package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
final class ObservableConcatMapScheduler$ConcatMapObserver<T, U> extends AtomicInteger implements io.reactivex.rxjava3.core.o<T>, h10.b, Runnable {
    private static final long serialVersionUID = 8828587559905699186L;
    volatile boolean active;
    final int bufferSize;
    volatile boolean disposed;
    volatile boolean done;
    final io.reactivex.rxjava3.core.o<? super U> downstream;
    int fusionMode;
    final InnerObserver<U> inner;
    final k10.h<? super T, ? extends io.reactivex.rxjava3.core.m<? extends U>> mapper;
    m10.g<T> queue;
    h10.b upstream;
    final Scheduler.Worker worker;

    /* JADX INFO: compiled from: source.java */
    public static final class InnerObserver<U> extends AtomicReference<h10.b> implements io.reactivex.rxjava3.core.o<U> {
        private static final long serialVersionUID = -7449079488798789337L;
        final io.reactivex.rxjava3.core.o<? super U> downstream;
        final ObservableConcatMapScheduler$ConcatMapObserver<?, ?> parent;

        public InnerObserver(io.reactivex.rxjava3.core.o<? super U> oVar, ObservableConcatMapScheduler$ConcatMapObserver<?, ?> observableConcatMapScheduler$ConcatMapObserver) {
            this.downstream = oVar;
            this.parent = observableConcatMapScheduler$ConcatMapObserver;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onComplete() {
            this.parent.innerComplete();
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onError(Throwable th2) {
            this.parent.dispose();
            this.downstream.onError(th2);
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onNext(U u11) {
            this.downstream.onNext(u11);
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onSubscribe(h10.b bVar) {
            DisposableHelper.replace(this, bVar);
        }
    }

    public ObservableConcatMapScheduler$ConcatMapObserver(io.reactivex.rxjava3.core.o<? super U> oVar, k10.h<? super T, ? extends io.reactivex.rxjava3.core.m<? extends U>> hVar, int i11, Scheduler.Worker worker) {
        this.downstream = oVar;
        this.mapper = hVar;
        this.bufferSize = i11;
        this.inner = new InnerObserver<>(oVar, this);
        this.worker = worker;
    }

    @Override // h10.b
    public void dispose() {
        this.disposed = true;
        this.inner.dispose();
        this.upstream.dispose();
        this.worker.dispose();
        if (getAndIncrement() == 0) {
            this.queue.clear();
        }
    }

    public void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        this.worker.schedule(this);
    }

    public void innerComplete() {
        this.active = false;
        drain();
    }

    @Override // h10.b
    public boolean isDisposed() {
        return this.disposed;
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        drain();
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onError(Throwable th2) {
        if (this.done) {
            p10.a.q(th2);
            return;
        }
        this.done = true;
        dispose();
        this.downstream.onError(th2);
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onNext(T t11) {
        if (this.done) {
            return;
        }
        if (this.fusionMode == 0) {
            this.queue.offer(t11);
        }
        drain();
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onSubscribe(h10.b bVar) {
        if (DisposableHelper.validate(this.upstream, bVar)) {
            this.upstream = bVar;
            if (bVar instanceof m10.b) {
                m10.b bVar2 = (m10.b) bVar;
                int iRequestFusion = bVar2.requestFusion(3);
                if (iRequestFusion == 1) {
                    this.fusionMode = iRequestFusion;
                    this.queue = bVar2;
                    this.done = true;
                    this.downstream.onSubscribe(this);
                    drain();
                    return;
                }
                if (iRequestFusion == 2) {
                    this.fusionMode = iRequestFusion;
                    this.queue = bVar2;
                    this.downstream.onSubscribe(this);
                    return;
                }
            }
            this.queue = new io.reactivex.rxjava3.internal.queue.a(this.bufferSize);
            this.downstream.onSubscribe(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        while (!this.disposed) {
            if (!this.active) {
                boolean z11 = this.done;
                try {
                    T tPoll = this.queue.poll();
                    boolean z12 = tPoll == null;
                    if (z11 && z12) {
                        this.disposed = true;
                        this.downstream.onComplete();
                        this.worker.dispose();
                        return;
                    } else if (!z12) {
                        try {
                            io.reactivex.rxjava3.core.m<? extends U> mVarApply = this.mapper.apply(tPoll);
                            Objects.requireNonNull(mVarApply, "The mapper returned a null ObservableSource");
                            io.reactivex.rxjava3.core.m<? extends U> mVar = mVarApply;
                            this.active = true;
                            mVar.subscribe(this.inner);
                        } catch (Throwable th2) {
                            i10.a.b(th2);
                            dispose();
                            this.queue.clear();
                            this.downstream.onError(th2);
                            this.worker.dispose();
                            return;
                        }
                    }
                } catch (Throwable th3) {
                    i10.a.b(th3);
                    dispose();
                    this.queue.clear();
                    this.downstream.onError(th3);
                    this.worker.dispose();
                    return;
                }
            }
            if (decrementAndGet() == 0) {
                return;
            }
        }
        this.queue.clear();
    }
}
