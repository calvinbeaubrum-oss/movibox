package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.subjects.UnicastSubject;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
final class ObservableWindowTimed$WindowExactUnboundedObserver<T> extends ObservableWindowTimed$AbstractWindowObserver<T> implements Runnable {
    static final Object NEXT_WINDOW = new Object();
    private static final long serialVersionUID = 1155822639622580836L;
    final Scheduler scheduler;
    final SequentialDisposable timer;
    UnicastSubject<T> window;
    final Runnable windowRunnable;

    /* JADX INFO: compiled from: source.java */
    public final class WindowRunnable implements Runnable {
        public WindowRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ObservableWindowTimed$WindowExactUnboundedObserver.this.windowDone();
        }
    }

    public ObservableWindowTimed$WindowExactUnboundedObserver(io.reactivex.rxjava3.core.o<? super io.reactivex.rxjava3.core.j<T>> oVar, long j11, TimeUnit timeUnit, Scheduler scheduler, int i11) {
        super(oVar, j11, timeUnit, i11);
        this.scheduler = scheduler;
        this.timer = new SequentialDisposable();
        this.windowRunnable = new WindowRunnable();
    }

    @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableWindowTimed$AbstractWindowObserver
    public void cleanupResources() {
        this.timer.dispose();
    }

    @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableWindowTimed$AbstractWindowObserver
    public void createFirstWindow() {
        if (this.downstreamCancelled.get()) {
            return;
        }
        this.windowCount.getAndIncrement();
        UnicastSubject<T> unicastSubjectF = UnicastSubject.F(this.bufferSize, this.windowRunnable);
        this.window = unicastSubjectF;
        this.emitted = 1L;
        p pVar = new p(unicastSubjectF);
        this.downstream.onNext(pVar);
        SequentialDisposable sequentialDisposable = this.timer;
        Scheduler scheduler = this.scheduler;
        long j11 = this.timespan;
        sequentialDisposable.replace(scheduler.f(this, j11, j11, this.unit));
        if (pVar.F()) {
            this.window.onComplete();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v12, types: [io.reactivex.rxjava3.subjects.UnicastSubject] */
    @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableWindowTimed$AbstractWindowObserver
    public void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        m10.f<Object> fVar = this.queue;
        io.reactivex.rxjava3.core.o<? super io.reactivex.rxjava3.core.j<T>> oVar = this.downstream;
        UnicastSubject unicastSubject = (UnicastSubject<T>) this.window;
        int iAddAndGet = 1;
        while (true) {
            if (this.upstreamCancelled) {
                fVar.clear();
                this.window = null;
                unicastSubject = (UnicastSubject<T>) null;
            } else {
                boolean z11 = this.done;
                Object objPoll = fVar.poll();
                boolean z12 = objPoll == null;
                if (z11 && z12) {
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        if (unicastSubject != null) {
                            unicastSubject.onError(th2);
                        }
                        oVar.onError(th2);
                    } else {
                        if (unicastSubject != null) {
                            unicastSubject.onComplete();
                        }
                        oVar.onComplete();
                    }
                    cleanupResources();
                    this.upstreamCancelled = true;
                } else if (!z12) {
                    if (objPoll == NEXT_WINDOW) {
                        if (unicastSubject != null) {
                            unicastSubject.onComplete();
                            this.window = null;
                            unicastSubject = (UnicastSubject<T>) null;
                        }
                        if (this.downstreamCancelled.get()) {
                            this.timer.dispose();
                        } else {
                            this.emitted++;
                            this.windowCount.getAndIncrement();
                            unicastSubject = (UnicastSubject<T>) UnicastSubject.F(this.bufferSize, this.windowRunnable);
                            this.window = unicastSubject;
                            p pVar = new p(unicastSubject);
                            oVar.onNext(pVar);
                            if (pVar.F()) {
                                unicastSubject.onComplete();
                            }
                        }
                    } else if (unicastSubject != null) {
                        unicastSubject.onNext(objPoll);
                    }
                }
            }
            iAddAndGet = addAndGet(-iAddAndGet);
            if (iAddAndGet == 0) {
                return;
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        this.queue.offer(NEXT_WINDOW);
        drain();
    }
}
