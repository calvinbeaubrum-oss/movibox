package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable;
import io.reactivex.rxjava3.internal.schedulers.TrampolineScheduler;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public final class ObservableObserveOn<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Scheduler f67400b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f67401c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f67402d;

    /* JADX INFO: compiled from: source.java */
    public static final class ObserveOnObserver<T> extends BasicIntQueueDisposable<T> implements io.reactivex.rxjava3.core.o<T>, Runnable {
        private static final long serialVersionUID = 6576896619930983584L;
        final int bufferSize;
        final boolean delayError;
        volatile boolean disposed;
        volatile boolean done;
        final io.reactivex.rxjava3.core.o<? super T> downstream;
        Throwable error;
        boolean outputFused;
        m10.g<T> queue;
        int sourceMode;
        h10.b upstream;
        final Scheduler.Worker worker;

        public ObserveOnObserver(io.reactivex.rxjava3.core.o<? super T> oVar, Scheduler.Worker worker, boolean z11, int i11) {
            this.downstream = oVar;
            this.worker = worker;
            this.delayError = z11;
            this.bufferSize = i11;
        }

        public boolean checkTerminated(boolean z11, boolean z12, io.reactivex.rxjava3.core.o<? super T> oVar) {
            if (this.disposed) {
                this.queue.clear();
                return true;
            }
            if (!z11) {
                return false;
            }
            Throwable th2 = this.error;
            if (this.delayError) {
                if (!z12) {
                    return false;
                }
                this.disposed = true;
                if (th2 != null) {
                    oVar.onError(th2);
                } else {
                    oVar.onComplete();
                }
                this.worker.dispose();
                return true;
            }
            if (th2 != null) {
                this.disposed = true;
                this.queue.clear();
                oVar.onError(th2);
                this.worker.dispose();
                return true;
            }
            if (!z12) {
                return false;
            }
            this.disposed = true;
            oVar.onComplete();
            this.worker.dispose();
            return true;
        }

        @Override // io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable, m10.g
        public void clear() {
            this.queue.clear();
        }

        @Override // io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable, h10.b
        public void dispose() {
            if (this.disposed) {
                return;
            }
            this.disposed = true;
            this.upstream.dispose();
            this.worker.dispose();
            if (this.outputFused || getAndIncrement() != 0) {
                return;
            }
            this.queue.clear();
        }

        public void drainFused() {
            int iAddAndGet = 1;
            while (!this.disposed) {
                boolean z11 = this.done;
                Throwable th2 = this.error;
                if (!this.delayError && z11 && th2 != null) {
                    this.disposed = true;
                    this.downstream.onError(this.error);
                    this.worker.dispose();
                    return;
                }
                this.downstream.onNext(null);
                if (z11) {
                    this.disposed = true;
                    Throwable th3 = this.error;
                    if (th3 != null) {
                        this.downstream.onError(th3);
                    } else {
                        this.downstream.onComplete();
                    }
                    this.worker.dispose();
                    return;
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }

        public void drainNormal() {
            m10.g<T> gVar = this.queue;
            io.reactivex.rxjava3.core.o<? super T> oVar = this.downstream;
            int iAddAndGet = 1;
            while (!checkTerminated(this.done, gVar.isEmpty(), oVar)) {
                while (true) {
                    boolean z11 = this.done;
                    try {
                        T tPoll = gVar.poll();
                        boolean z12 = tPoll == null;
                        if (checkTerminated(z11, z12, oVar)) {
                            return;
                        }
                        if (z12) {
                            break;
                        } else {
                            oVar.onNext(tPoll);
                        }
                    } catch (Throwable th2) {
                        i10.a.b(th2);
                        this.disposed = true;
                        this.upstream.dispose();
                        gVar.clear();
                        oVar.onError(th2);
                        this.worker.dispose();
                        return;
                    }
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }

        @Override // io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable, h10.b
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable, m10.g
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            schedule();
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onError(Throwable th2) {
            if (this.done) {
                p10.a.q(th2);
                return;
            }
            this.error = th2;
            this.done = true;
            schedule();
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onNext(T t11) {
            if (this.done) {
                return;
            }
            if (this.sourceMode != 2) {
                this.queue.offer(t11);
            }
            schedule();
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onSubscribe(h10.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                if (bVar instanceof m10.b) {
                    m10.b bVar2 = (m10.b) bVar;
                    int iRequestFusion = bVar2.requestFusion(7);
                    if (iRequestFusion == 1) {
                        this.sourceMode = iRequestFusion;
                        this.queue = bVar2;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        schedule();
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

        @Override // io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable, m10.g
        public T poll() throws Throwable {
            return this.queue.poll();
        }

        @Override // io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable, m10.c
        public int requestFusion(int i11) {
            if ((i11 & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.outputFused) {
                drainFused();
            } else {
                drainNormal();
            }
        }

        public void schedule() {
            if (getAndIncrement() == 0) {
                this.worker.schedule(this);
            }
        }
    }

    public ObservableObserveOn(io.reactivex.rxjava3.core.m<T> mVar, Scheduler scheduler, boolean z11, int i11) {
        super(mVar);
        this.f67400b = scheduler;
        this.f67401c = z11;
        this.f67402d = i11;
    }

    @Override // io.reactivex.rxjava3.core.j
    public void z(io.reactivex.rxjava3.core.o<? super T> oVar) {
        Scheduler scheduler = this.f67400b;
        if (scheduler instanceof TrampolineScheduler) {
            this.f67422a.subscribe(oVar);
        } else {
            this.f67422a.subscribe(new ObserveOnObserver(oVar, scheduler.c(), this.f67401c, this.f67402d));
        }
    }
}
