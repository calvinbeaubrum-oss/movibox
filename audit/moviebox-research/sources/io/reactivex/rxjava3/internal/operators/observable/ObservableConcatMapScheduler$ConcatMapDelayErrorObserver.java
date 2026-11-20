package io.reactivex.rxjava3.internal.operators.observable;

import OooO.OooO0OO;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
final class ObservableConcatMapScheduler$ConcatMapDelayErrorObserver<T, R> extends AtomicInteger implements io.reactivex.rxjava3.core.o<T>, h10.b, Runnable {
    private static final long serialVersionUID = -6951100001833242599L;
    volatile boolean active;
    final int bufferSize;
    volatile boolean cancelled;
    volatile boolean done;
    final io.reactivex.rxjava3.core.o<? super R> downstream;
    final AtomicThrowable errors = new AtomicThrowable();
    final k10.h<? super T, ? extends io.reactivex.rxjava3.core.m<? extends R>> mapper;
    final DelayErrorInnerObserver<R> observer;
    m10.g<T> queue;
    int sourceMode;
    final boolean tillTheEnd;
    h10.b upstream;
    final Scheduler.Worker worker;

    /* JADX INFO: compiled from: source.java */
    public static final class DelayErrorInnerObserver<R> extends AtomicReference<h10.b> implements io.reactivex.rxjava3.core.o<R> {
        private static final long serialVersionUID = 2620149119579502636L;
        final io.reactivex.rxjava3.core.o<? super R> downstream;
        final ObservableConcatMapScheduler$ConcatMapDelayErrorObserver<?, R> parent;

        public DelayErrorInnerObserver(io.reactivex.rxjava3.core.o<? super R> oVar, ObservableConcatMapScheduler$ConcatMapDelayErrorObserver<?, R> observableConcatMapScheduler$ConcatMapDelayErrorObserver) {
            this.downstream = oVar;
            this.parent = observableConcatMapScheduler$ConcatMapDelayErrorObserver;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onComplete() {
            ObservableConcatMapScheduler$ConcatMapDelayErrorObserver<?, R> observableConcatMapScheduler$ConcatMapDelayErrorObserver = this.parent;
            observableConcatMapScheduler$ConcatMapDelayErrorObserver.active = false;
            observableConcatMapScheduler$ConcatMapDelayErrorObserver.drain();
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onError(Throwable th2) {
            ObservableConcatMapScheduler$ConcatMapDelayErrorObserver<?, R> observableConcatMapScheduler$ConcatMapDelayErrorObserver = this.parent;
            if (observableConcatMapScheduler$ConcatMapDelayErrorObserver.errors.tryAddThrowableOrReport(th2)) {
                if (!observableConcatMapScheduler$ConcatMapDelayErrorObserver.tillTheEnd) {
                    observableConcatMapScheduler$ConcatMapDelayErrorObserver.upstream.dispose();
                }
                observableConcatMapScheduler$ConcatMapDelayErrorObserver.active = false;
                observableConcatMapScheduler$ConcatMapDelayErrorObserver.drain();
            }
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onNext(R r11) {
            this.downstream.onNext(r11);
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onSubscribe(h10.b bVar) {
            DisposableHelper.replace(this, bVar);
        }
    }

    public ObservableConcatMapScheduler$ConcatMapDelayErrorObserver(io.reactivex.rxjava3.core.o<? super R> oVar, k10.h<? super T, ? extends io.reactivex.rxjava3.core.m<? extends R>> hVar, int i11, boolean z11, Scheduler.Worker worker) {
        this.downstream = oVar;
        this.mapper = hVar;
        this.bufferSize = i11;
        this.tillTheEnd = z11;
        this.observer = new DelayErrorInnerObserver<>(oVar, this);
        this.worker = worker;
    }

    @Override // h10.b
    public void dispose() {
        this.cancelled = true;
        this.upstream.dispose();
        this.observer.dispose();
        this.worker.dispose();
        this.errors.tryTerminateAndReport();
    }

    public void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        this.worker.schedule(this);
    }

    @Override // h10.b
    public boolean isDisposed() {
        return this.cancelled;
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onError(Throwable th2) {
        if (this.errors.tryAddThrowableOrReport(th2)) {
            this.done = true;
            drain();
        }
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onNext(T t11) {
        if (this.sourceMode == 0) {
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
                    this.sourceMode = iRequestFusion;
                    this.queue = bVar2;
                    this.done = true;
                    this.downstream.onSubscribe(this);
                    drain();
                    return;
                }
                if (iRequestFusion == 2) {
                    this.sourceMode = iRequestFusion;
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
        io.reactivex.rxjava3.core.o<? super R> oVar = this.downstream;
        m10.g<T> gVar = this.queue;
        AtomicThrowable atomicThrowable = this.errors;
        while (true) {
            if (!this.active) {
                if (this.cancelled) {
                    gVar.clear();
                    return;
                }
                if (!this.tillTheEnd && atomicThrowable.get() != null) {
                    gVar.clear();
                    this.cancelled = true;
                    atomicThrowable.tryTerminateConsumer(oVar);
                    this.worker.dispose();
                    return;
                }
                boolean z11 = this.done;
                try {
                    T tPoll = gVar.poll();
                    boolean z12 = tPoll == null;
                    if (z11 && z12) {
                        this.cancelled = true;
                        atomicThrowable.tryTerminateConsumer(oVar);
                        this.worker.dispose();
                        return;
                    }
                    if (!z12) {
                        try {
                            io.reactivex.rxjava3.core.m<? extends R> mVarApply = this.mapper.apply(tPoll);
                            Objects.requireNonNull(mVarApply, "The mapper returned a null ObservableSource");
                            io.reactivex.rxjava3.core.m<? extends R> mVar = mVarApply;
                            if (mVar instanceof k10.k) {
                                try {
                                    OooO0OO.C0001OooO0OO c0001OooO0OO = (Object) ((k10.k) mVar).get();
                                    if (c0001OooO0OO != null && !this.cancelled) {
                                        oVar.onNext(c0001OooO0OO);
                                    }
                                } catch (Throwable th2) {
                                    i10.a.b(th2);
                                    atomicThrowable.tryAddThrowableOrReport(th2);
                                }
                            } else {
                                this.active = true;
                                mVar.subscribe(this.observer);
                            }
                        } catch (Throwable th3) {
                            i10.a.b(th3);
                            this.cancelled = true;
                            this.upstream.dispose();
                            gVar.clear();
                            atomicThrowable.tryAddThrowableOrReport(th3);
                            atomicThrowable.tryTerminateConsumer(oVar);
                            this.worker.dispose();
                            return;
                        }
                    }
                } catch (Throwable th4) {
                    i10.a.b(th4);
                    this.cancelled = true;
                    this.upstream.dispose();
                    atomicThrowable.tryAddThrowableOrReport(th4);
                    atomicThrowable.tryTerminateConsumer(oVar);
                    this.worker.dispose();
                    return;
                }
            }
            if (decrementAndGet() == 0) {
                return;
            }
        }
    }
}
