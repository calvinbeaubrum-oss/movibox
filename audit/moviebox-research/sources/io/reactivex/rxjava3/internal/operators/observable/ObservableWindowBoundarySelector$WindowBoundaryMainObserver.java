package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.subjects.UnicastSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
final class ObservableWindowBoundarySelector$WindowBoundaryMainObserver<T, B, V> extends AtomicInteger implements io.reactivex.rxjava3.core.o<T>, h10.b, Runnable {
    private static final long serialVersionUID = 8646217640096099753L;
    final int bufferSize;
    final k10.h<? super B, ? extends io.reactivex.rxjava3.core.m<V>> closingIndicator;
    final io.reactivex.rxjava3.core.o<? super io.reactivex.rxjava3.core.j<T>> downstream;
    long emitted;
    final io.reactivex.rxjava3.core.m<B> open;
    volatile boolean openDone;
    h10.b upstream;
    volatile boolean upstreamCanceled;
    volatile boolean upstreamDone;
    final m10.f<Object> queue = new MpscLinkedQueue();
    final h10.a resources = new h10.a();
    final List<UnicastSubject<T>> windows = new ArrayList();
    final AtomicLong windowCount = new AtomicLong(1);
    final AtomicBoolean downstreamDisposed = new AtomicBoolean();
    final AtomicThrowable error = new AtomicThrowable();
    final WindowStartObserver<B> startObserver = new WindowStartObserver<>(this);
    final AtomicLong requested = new AtomicLong();

    /* JADX INFO: compiled from: source.java */
    public static final class WindowStartObserver<B> extends AtomicReference<h10.b> implements io.reactivex.rxjava3.core.o<B> {
        private static final long serialVersionUID = -3326496781427702834L;
        final ObservableWindowBoundarySelector$WindowBoundaryMainObserver<?, B, ?> parent;

        public WindowStartObserver(ObservableWindowBoundarySelector$WindowBoundaryMainObserver<?, B, ?> observableWindowBoundarySelector$WindowBoundaryMainObserver) {
            this.parent = observableWindowBoundarySelector$WindowBoundaryMainObserver;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onComplete() {
            this.parent.openComplete();
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onError(Throwable th2) {
            this.parent.openError(th2);
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onNext(B b11) {
            this.parent.open(b11);
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onSubscribe(h10.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class a<T, V> extends io.reactivex.rxjava3.core.j<T> implements io.reactivex.rxjava3.core.o<V>, h10.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ObservableWindowBoundarySelector$WindowBoundaryMainObserver<T, ?, V> f67407a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final UnicastSubject<T> f67408b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AtomicReference<h10.b> f67409c = new AtomicReference<>();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AtomicBoolean f67410d = new AtomicBoolean();

        public a(ObservableWindowBoundarySelector$WindowBoundaryMainObserver<T, ?, V> observableWindowBoundarySelector$WindowBoundaryMainObserver, UnicastSubject<T> unicastSubject) {
            this.f67407a = observableWindowBoundarySelector$WindowBoundaryMainObserver;
            this.f67408b = unicastSubject;
        }

        public boolean F() {
            return !this.f67410d.get() && this.f67410d.compareAndSet(false, true);
        }

        @Override // h10.b
        public void dispose() {
            DisposableHelper.dispose(this.f67409c);
        }

        @Override // h10.b
        public boolean isDisposed() {
            return this.f67409c.get() == DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onComplete() {
            this.f67407a.close(this);
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onError(Throwable th2) {
            if (isDisposed()) {
                p10.a.q(th2);
            } else {
                this.f67407a.closeError(th2);
            }
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onNext(V v11) {
            if (DisposableHelper.dispose(this.f67409c)) {
                this.f67407a.close(this);
            }
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onSubscribe(h10.b bVar) {
            DisposableHelper.setOnce(this.f67409c, bVar);
        }

        @Override // io.reactivex.rxjava3.core.j
        public void z(io.reactivex.rxjava3.core.o<? super T> oVar) {
            this.f67408b.subscribe(oVar);
            this.f67410d.set(true);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b<B> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final B f67411a;

        public b(B b11) {
            this.f67411a = b11;
        }
    }

    public ObservableWindowBoundarySelector$WindowBoundaryMainObserver(io.reactivex.rxjava3.core.o<? super io.reactivex.rxjava3.core.j<T>> oVar, io.reactivex.rxjava3.core.m<B> mVar, k10.h<? super B, ? extends io.reactivex.rxjava3.core.m<V>> hVar, int i11) {
        this.downstream = oVar;
        this.open = mVar;
        this.closingIndicator = hVar;
        this.bufferSize = i11;
    }

    public void close(a<T, V> aVar) {
        this.queue.offer(aVar);
        drain();
    }

    public void closeError(Throwable th2) {
        this.upstream.dispose();
        this.startObserver.dispose();
        this.resources.dispose();
        if (this.error.tryAddThrowableOrReport(th2)) {
            this.upstreamDone = true;
            drain();
        }
    }

    @Override // h10.b
    public void dispose() {
        if (this.downstreamDisposed.compareAndSet(false, true)) {
            if (this.windowCount.decrementAndGet() != 0) {
                this.startObserver.dispose();
                return;
            }
            this.upstream.dispose();
            this.startObserver.dispose();
            this.resources.dispose();
            this.error.tryTerminateAndReport();
            this.upstreamCanceled = true;
            drain();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        io.reactivex.rxjava3.core.o<? super io.reactivex.rxjava3.core.j<T>> oVar = this.downstream;
        m10.f<Object> fVar = this.queue;
        List<UnicastSubject<T>> list = this.windows;
        int iAddAndGet = 1;
        while (true) {
            if (this.upstreamCanceled) {
                fVar.clear();
                list.clear();
            } else {
                boolean z11 = this.upstreamDone;
                Object objPoll = fVar.poll();
                boolean z12 = objPoll == null;
                if (z11 && (z12 || this.error.get() != null)) {
                    terminateDownstream(oVar);
                    this.upstreamCanceled = true;
                } else if (z12) {
                    if (this.openDone && list.size() == 0) {
                        this.upstream.dispose();
                        this.startObserver.dispose();
                        this.resources.dispose();
                        terminateDownstream(oVar);
                        this.upstreamCanceled = true;
                    }
                } else if (objPoll instanceof b) {
                    if (!this.downstreamDisposed.get()) {
                        try {
                            io.reactivex.rxjava3.core.m<V> mVarApply = this.closingIndicator.apply(((b) objPoll).f67411a);
                            Objects.requireNonNull(mVarApply, "The closingIndicator returned a null ObservableSource");
                            io.reactivex.rxjava3.core.m<V> mVar = mVarApply;
                            this.windowCount.getAndIncrement();
                            UnicastSubject<T> unicastSubjectF = UnicastSubject.F(this.bufferSize, this);
                            a aVar = new a(this, unicastSubjectF);
                            oVar.onNext(aVar);
                            if (aVar.F()) {
                                unicastSubjectF.onComplete();
                            } else {
                                list.add(unicastSubjectF);
                                this.resources.c(aVar);
                                mVar.subscribe(aVar);
                            }
                        } catch (Throwable th2) {
                            i10.a.b(th2);
                            this.upstream.dispose();
                            this.startObserver.dispose();
                            this.resources.dispose();
                            i10.a.b(th2);
                            this.error.tryAddThrowableOrReport(th2);
                            this.upstreamDone = true;
                        }
                    }
                } else if (objPoll instanceof a) {
                    UnicastSubject<T> unicastSubject = ((a) objPoll).f67408b;
                    list.remove(unicastSubject);
                    this.resources.b((h10.b) objPoll);
                    unicastSubject.onComplete();
                } else {
                    Iterator<UnicastSubject<T>> it = list.iterator();
                    while (it.hasNext()) {
                        it.next().onNext(objPoll);
                    }
                }
            }
            iAddAndGet = addAndGet(-iAddAndGet);
            if (iAddAndGet == 0) {
                return;
            }
        }
    }

    @Override // h10.b
    public boolean isDisposed() {
        return this.downstreamDisposed.get();
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onComplete() {
        this.startObserver.dispose();
        this.resources.dispose();
        this.upstreamDone = true;
        drain();
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onError(Throwable th2) {
        this.startObserver.dispose();
        this.resources.dispose();
        if (this.error.tryAddThrowableOrReport(th2)) {
            this.upstreamDone = true;
            drain();
        }
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onNext(T t11) {
        this.queue.offer(t11);
        drain();
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onSubscribe(h10.b bVar) {
        if (DisposableHelper.validate(this.upstream, bVar)) {
            this.upstream = bVar;
            this.downstream.onSubscribe(this);
            this.open.subscribe(this.startObserver);
        }
    }

    public void open(B b11) {
        this.queue.offer(new b(b11));
        drain();
    }

    public void openComplete() {
        this.openDone = true;
        drain();
    }

    public void openError(Throwable th2) {
        this.upstream.dispose();
        this.resources.dispose();
        if (this.error.tryAddThrowableOrReport(th2)) {
            this.upstreamDone = true;
            drain();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.windowCount.decrementAndGet() == 0) {
            this.upstream.dispose();
            this.startObserver.dispose();
            this.resources.dispose();
            this.error.tryTerminateAndReport();
            this.upstreamCanceled = true;
            drain();
        }
    }

    public void terminateDownstream(io.reactivex.rxjava3.core.o<?> oVar) {
        Throwable thTerminate = this.error.terminate();
        if (thTerminate == null) {
            Iterator<UnicastSubject<T>> it = this.windows.iterator();
            while (it.hasNext()) {
                it.next().onComplete();
            }
            oVar.onComplete();
            return;
        }
        if (thTerminate != ExceptionHelper.f67551a) {
            Iterator<UnicastSubject<T>> it2 = this.windows.iterator();
            while (it2.hasNext()) {
                it2.next().onError(thTerminate);
            }
            oVar.onError(thTerminate);
        }
    }
}
