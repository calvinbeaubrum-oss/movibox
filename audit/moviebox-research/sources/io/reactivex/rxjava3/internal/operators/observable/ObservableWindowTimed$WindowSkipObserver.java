package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.subjects.UnicastSubject;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
final class ObservableWindowTimed$WindowSkipObserver<T> extends ObservableWindowTimed$AbstractWindowObserver<T> implements Runnable {
    private static final long serialVersionUID = -7852870764194095894L;
    final long timeskip;
    final List<UnicastSubject<T>> windows;
    final Scheduler.Worker worker;
    static final Object WINDOW_OPEN = new Object();
    static final Object WINDOW_CLOSE = new Object();

    /* JADX INFO: compiled from: source.java */
    public static final class WindowBoundaryRunnable implements Runnable {
        final boolean isOpen;
        final ObservableWindowTimed$WindowSkipObserver<?> parent;

        public WindowBoundaryRunnable(ObservableWindowTimed$WindowSkipObserver<?> observableWindowTimed$WindowSkipObserver, boolean z11) {
            this.parent = observableWindowTimed$WindowSkipObserver;
            this.isOpen = z11;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.parent.boundary(this.isOpen);
        }
    }

    public ObservableWindowTimed$WindowSkipObserver(io.reactivex.rxjava3.core.o<? super io.reactivex.rxjava3.core.j<T>> oVar, long j11, long j12, TimeUnit timeUnit, Scheduler.Worker worker, int i11) {
        super(oVar, j11, timeUnit, i11);
        this.timeskip = j12;
        this.worker = worker;
        this.windows = new LinkedList();
    }

    public void boundary(boolean z11) {
        this.queue.offer(z11 ? WINDOW_OPEN : WINDOW_CLOSE);
        drain();
    }

    @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableWindowTimed$AbstractWindowObserver
    public void cleanupResources() {
        this.worker.dispose();
    }

    @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableWindowTimed$AbstractWindowObserver
    public void createFirstWindow() {
        if (this.downstreamCancelled.get()) {
            return;
        }
        this.emitted = 1L;
        this.windowCount.getAndIncrement();
        UnicastSubject<T> unicastSubjectF = UnicastSubject.F(this.bufferSize, this);
        this.windows.add(unicastSubjectF);
        p pVar = new p(unicastSubjectF);
        this.downstream.onNext(pVar);
        this.worker.schedule(new WindowBoundaryRunnable(this, false), this.timespan, this.unit);
        Scheduler.Worker worker = this.worker;
        WindowBoundaryRunnable windowBoundaryRunnable = new WindowBoundaryRunnable(this, true);
        long j11 = this.timeskip;
        worker.schedulePeriodically(windowBoundaryRunnable, j11, j11, this.unit);
        if (pVar.F()) {
            unicastSubjectF.onComplete();
            this.windows.remove(unicastSubjectF);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableWindowTimed$AbstractWindowObserver
    public void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        m10.f<Object> fVar = this.queue;
        io.reactivex.rxjava3.core.o<? super io.reactivex.rxjava3.core.j<T>> oVar = this.downstream;
        List<UnicastSubject<T>> list = this.windows;
        int iAddAndGet = 1;
        while (true) {
            if (this.upstreamCancelled) {
                fVar.clear();
                list.clear();
            } else {
                boolean z11 = this.done;
                Object objPoll = fVar.poll();
                boolean z12 = objPoll == null;
                if (z11 && z12) {
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        Iterator<UnicastSubject<T>> it = list.iterator();
                        while (it.hasNext()) {
                            it.next().onError(th2);
                        }
                        oVar.onError(th2);
                    } else {
                        Iterator<UnicastSubject<T>> it2 = list.iterator();
                        while (it2.hasNext()) {
                            it2.next().onComplete();
                        }
                        oVar.onComplete();
                    }
                    cleanupResources();
                    this.upstreamCancelled = true;
                } else if (!z12) {
                    if (objPoll == WINDOW_OPEN) {
                        if (!this.downstreamCancelled.get()) {
                            this.emitted++;
                            this.windowCount.getAndIncrement();
                            UnicastSubject<T> unicastSubjectF = UnicastSubject.F(this.bufferSize, this);
                            list.add(unicastSubjectF);
                            p pVar = new p(unicastSubjectF);
                            oVar.onNext(pVar);
                            this.worker.schedule(new WindowBoundaryRunnable(this, false), this.timespan, this.unit);
                            if (pVar.F()) {
                                unicastSubjectF.onComplete();
                            }
                        }
                    } else if (objPoll != WINDOW_CLOSE) {
                        Iterator<UnicastSubject<T>> it3 = list.iterator();
                        while (it3.hasNext()) {
                            it3.next().onNext(objPoll);
                        }
                    } else if (!list.isEmpty()) {
                        list.remove(0).onComplete();
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
        windowDone();
    }
}
