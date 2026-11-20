package io.reactivex.rxjava3.internal.operators.observable;

import androidx.compose.animation.core.j0;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class ObservableFlatMap<T, U> extends a<T, U> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k10.h<? super T, ? extends io.reactivex.rxjava3.core.m<? extends U>> f67395b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f67396c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f67397d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f67398f;

    /* JADX INFO: compiled from: source.java */
    public static final class InnerObserver<T, U> extends AtomicReference<h10.b> implements io.reactivex.rxjava3.core.o<U> {
        private static final long serialVersionUID = -4606175640614850599L;
        volatile boolean done;
        int fusionMode;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        final long f67399id;
        final MergeObserver<T, U> parent;
        volatile m10.g<U> queue;

        public InnerObserver(MergeObserver<T, U> mergeObserver, long j11) {
            this.f67399id = j11;
            this.parent = mergeObserver;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onComplete() {
            this.done = true;
            this.parent.drain();
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onError(Throwable th2) {
            if (this.parent.errors.tryAddThrowableOrReport(th2)) {
                MergeObserver<T, U> mergeObserver = this.parent;
                if (!mergeObserver.delayErrors) {
                    mergeObserver.disposeAll();
                }
                this.done = true;
                this.parent.drain();
            }
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onNext(U u11) {
            if (this.fusionMode == 0) {
                this.parent.tryEmit(u11, this);
            } else {
                this.parent.drain();
            }
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onSubscribe(h10.b bVar) {
            if (DisposableHelper.setOnce(this, bVar) && (bVar instanceof m10.b)) {
                m10.b bVar2 = (m10.b) bVar;
                int iRequestFusion = bVar2.requestFusion(7);
                if (iRequestFusion == 1) {
                    this.fusionMode = iRequestFusion;
                    this.queue = bVar2;
                    this.done = true;
                    this.parent.drain();
                    return;
                }
                if (iRequestFusion == 2) {
                    this.fusionMode = iRequestFusion;
                    this.queue = bVar2;
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class MergeObserver<T, U> extends AtomicInteger implements h10.b, io.reactivex.rxjava3.core.o<T> {
        private static final long serialVersionUID = -2117620485640801370L;
        final int bufferSize;
        final boolean delayErrors;
        volatile boolean disposed;
        volatile boolean done;
        final io.reactivex.rxjava3.core.o<? super U> downstream;
        final AtomicThrowable errors = new AtomicThrowable();
        int lastIndex;
        final k10.h<? super T, ? extends io.reactivex.rxjava3.core.m<? extends U>> mapper;
        final int maxConcurrency;
        final AtomicReference<InnerObserver<?, ?>[]> observers;
        volatile m10.f<U> queue;
        Queue<io.reactivex.rxjava3.core.m<? extends U>> sources;
        long uniqueId;
        h10.b upstream;
        int wip;
        static final InnerObserver<?, ?>[] EMPTY = new InnerObserver[0];
        static final InnerObserver<?, ?>[] CANCELLED = new InnerObserver[0];

        public MergeObserver(io.reactivex.rxjava3.core.o<? super U> oVar, k10.h<? super T, ? extends io.reactivex.rxjava3.core.m<? extends U>> hVar, boolean z11, int i11, int i12) {
            this.downstream = oVar;
            this.mapper = hVar;
            this.delayErrors = z11;
            this.maxConcurrency = i11;
            this.bufferSize = i12;
            if (i11 != Integer.MAX_VALUE) {
                this.sources = new ArrayDeque(i11);
            }
            this.observers = new AtomicReference<>(EMPTY);
        }

        public boolean addInner(InnerObserver<T, U> innerObserver) {
            InnerObserver<?, ?>[] innerObserverArr;
            InnerObserver[] innerObserverArr2;
            do {
                innerObserverArr = this.observers.get();
                if (innerObserverArr == CANCELLED) {
                    innerObserver.dispose();
                    return false;
                }
                int length = innerObserverArr.length;
                innerObserverArr2 = new InnerObserver[length + 1];
                System.arraycopy(innerObserverArr, 0, innerObserverArr2, 0, length);
                innerObserverArr2[length] = innerObserver;
            } while (!j0.a(this.observers, innerObserverArr, innerObserverArr2));
            return true;
        }

        public boolean checkTerminate() {
            if (this.disposed) {
                return true;
            }
            Throwable th2 = this.errors.get();
            if (this.delayErrors || th2 == null) {
                return false;
            }
            disposeAll();
            this.errors.tryTerminateConsumer(this.downstream);
            return true;
        }

        @Override // h10.b
        public void dispose() {
            this.disposed = true;
            if (disposeAll()) {
                this.errors.tryTerminateAndReport();
            }
        }

        public boolean disposeAll() {
            this.upstream.dispose();
            AtomicReference<InnerObserver<?, ?>[]> atomicReference = this.observers;
            InnerObserver<?, ?>[] innerObserverArr = CANCELLED;
            InnerObserver<?, ?>[] andSet = atomicReference.getAndSet(innerObserverArr);
            if (andSet == innerObserverArr) {
                return false;
            }
            for (InnerObserver<?, ?> innerObserver : andSet) {
                innerObserver.dispose();
            }
            return true;
        }

        public void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        /* JADX WARN: Code duplicated, block: B:104:0x00c5 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:67:0x00c4 A[PHI: r4
  0x00c4: PHI (r4v6 int) = (r4v4 int), (r4v7 int) binds: [B:57:0x00aa, B:66:0x00c2] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Multi-variable type inference failed */
        public void drainLoop() {
            int size;
            boolean z11;
            io.reactivex.rxjava3.core.o<? super U> oVar = this.downstream;
            int iAddAndGet = 1;
            while (!checkTerminate()) {
                m10.f<U> fVar = this.queue;
                int i11 = 0;
                if (fVar != null) {
                    while (!checkTerminate()) {
                        U uPoll = fVar.poll();
                        if (uPoll != null) {
                            oVar.onNext(uPoll);
                            i11++;
                        }
                    }
                    return;
                }
                if (i11 == 0) {
                    boolean z12 = this.done;
                    m10.f<U> fVar2 = this.queue;
                    InnerObserver<?, ?>[] innerObserverArr = this.observers.get();
                    int length = innerObserverArr.length;
                    if (this.maxConcurrency != Integer.MAX_VALUE) {
                        synchronized (this) {
                            size = this.sources.size();
                        }
                    } else {
                        size = 0;
                    }
                    if (z12 && ((fVar2 == null || fVar2.isEmpty()) && length == 0 && size == 0)) {
                        this.errors.tryTerminateConsumer(this.downstream);
                        return;
                    }
                    if (length != 0) {
                        int iMin = Math.min(length - 1, this.lastIndex);
                        for (int i12 = 0; i12 < length; i12++) {
                            if (checkTerminate()) {
                                return;
                            }
                            InnerObserver<T, U> innerObserver = innerObserverArr[iMin];
                            m10.g<U> gVar = innerObserver.queue;
                            if (gVar != null) {
                                do {
                                    try {
                                        U uPoll2 = gVar.poll();
                                        if (uPoll2 == null) {
                                            z11 = innerObserver.done;
                                            m10.g<U> gVar2 = innerObserver.queue;
                                            if (z11 && (gVar2 == null || gVar2.isEmpty())) {
                                                removeInner(innerObserver);
                                                i11++;
                                            }
                                            iMin++;
                                            if (iMin == length) {
                                                iMin = 0;
                                            }
                                        } else {
                                            oVar.onNext(uPoll2);
                                        }
                                    } catch (Throwable th2) {
                                        i10.a.b(th2);
                                        innerObserver.dispose();
                                        this.errors.tryAddThrowableOrReport(th2);
                                        if (checkTerminate()) {
                                            return;
                                        }
                                        removeInner(innerObserver);
                                        i11++;
                                        iMin++;
                                        if (iMin == length) {
                                        }
                                    }
                                } while (!checkTerminate());
                                return;
                            }
                            z11 = innerObserver.done;
                            m10.g<U> gVar3 = innerObserver.queue;
                            if (z11) {
                                removeInner(innerObserver);
                                i11++;
                            }
                            iMin++;
                            if (iMin == length) {
                                iMin = 0;
                            }
                        }
                        this.lastIndex = iMin;
                    }
                    if (i11 == 0) {
                        iAddAndGet = addAndGet(-iAddAndGet);
                        if (iAddAndGet == 0) {
                            return;
                        }
                    } else if (this.maxConcurrency != Integer.MAX_VALUE) {
                        subscribeMore(i11);
                    }
                } else if (this.maxConcurrency != Integer.MAX_VALUE) {
                    subscribeMore(i11);
                }
            }
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
            } else if (this.errors.tryAddThrowableOrReport(th2)) {
                this.done = true;
                drain();
            }
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onNext(T t11) {
            if (this.done) {
                return;
            }
            try {
                io.reactivex.rxjava3.core.m<? extends U> mVarApply = this.mapper.apply(t11);
                Objects.requireNonNull(mVarApply, "The mapper returned a null ObservableSource");
                io.reactivex.rxjava3.core.m<? extends U> mVar = mVarApply;
                if (this.maxConcurrency != Integer.MAX_VALUE) {
                    synchronized (this) {
                        try {
                            int i11 = this.wip;
                            if (i11 == this.maxConcurrency) {
                                this.sources.offer(mVar);
                                return;
                            }
                            this.wip = i11 + 1;
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                }
                subscribeInner(mVar);
            } catch (Throwable th3) {
                i10.a.b(th3);
                this.upstream.dispose();
                onError(th3);
            }
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onSubscribe(h10.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void removeInner(InnerObserver<T, U> innerObserver) {
            InnerObserver<?, ?>[] innerObserverArr;
            InnerObserver<?, ?>[] innerObserverArr2;
            do {
                innerObserverArr = this.observers.get();
                int length = innerObserverArr.length;
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        i11 = -1;
                        break;
                    } else if (innerObserverArr[i11] == innerObserver) {
                        break;
                    } else {
                        i11++;
                    }
                }
                if (i11 < 0) {
                    return;
                }
                if (length == 1) {
                    innerObserverArr2 = EMPTY;
                } else {
                    InnerObserver<?, ?>[] innerObserverArr3 = new InnerObserver[length - 1];
                    System.arraycopy(innerObserverArr, 0, innerObserverArr3, 0, i11);
                    System.arraycopy(innerObserverArr, i11 + 1, innerObserverArr3, i11, (length - i11) - 1);
                    innerObserverArr2 = innerObserverArr3;
                }
            } while (!j0.a(this.observers, innerObserverArr, innerObserverArr2));
        }

        public void subscribeInner(io.reactivex.rxjava3.core.m<? extends U> mVar) {
            boolean z11;
            while (mVar instanceof k10.k) {
                if (!tryEmitScalar((k10.k) mVar) || this.maxConcurrency == Integer.MAX_VALUE) {
                    return;
                }
                synchronized (this) {
                    try {
                        mVar = this.sources.poll();
                        if (mVar == null) {
                            z11 = true;
                            this.wip--;
                        } else {
                            z11 = false;
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                if (z11) {
                    drain();
                    return;
                }
            }
            long j11 = this.uniqueId;
            this.uniqueId = 1 + j11;
            InnerObserver<T, U> innerObserver = new InnerObserver<>(this, j11);
            if (addInner(innerObserver)) {
                mVar.subscribe(innerObserver);
            }
        }

        public void subscribeMore(int i11) {
            while (true) {
                int i12 = i11 - 1;
                if (i11 == 0) {
                    return;
                }
                synchronized (this) {
                    try {
                        io.reactivex.rxjava3.core.m<? extends U> mVarPoll = this.sources.poll();
                        if (mVarPoll == null) {
                            this.wip--;
                        } else {
                            subscribeInner(mVarPoll);
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                i11 = i12;
            }
        }

        public void tryEmit(U u11, InnerObserver<T, U> innerObserver) {
            if (get() == 0 && compareAndSet(0, 1)) {
                this.downstream.onNext(u11);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                m10.g aVar = innerObserver.queue;
                if (aVar == null) {
                    aVar = new io.reactivex.rxjava3.internal.queue.a(this.bufferSize);
                    innerObserver.queue = aVar;
                }
                aVar.offer(u11);
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            drainLoop();
        }

        public boolean tryEmitScalar(k10.k<? extends U> kVar) {
            try {
                U u11 = kVar.get();
                if (u11 == null) {
                    return true;
                }
                if (get() == 0 && compareAndSet(0, 1)) {
                    this.downstream.onNext(u11);
                    if (decrementAndGet() == 0) {
                        return true;
                    }
                } else {
                    m10.f<U> aVar = this.queue;
                    if (aVar == null) {
                        aVar = this.maxConcurrency == Integer.MAX_VALUE ? new io.reactivex.rxjava3.internal.queue.a<>(this.bufferSize) : new SpscArrayQueue<>(this.maxConcurrency);
                        this.queue = aVar;
                    }
                    aVar.offer(u11);
                    if (getAndIncrement() != 0) {
                        return false;
                    }
                }
                drainLoop();
                return true;
            } catch (Throwable th2) {
                i10.a.b(th2);
                this.errors.tryAddThrowableOrReport(th2);
                drain();
                return true;
            }
        }
    }

    public ObservableFlatMap(io.reactivex.rxjava3.core.m<T> mVar, k10.h<? super T, ? extends io.reactivex.rxjava3.core.m<? extends U>> hVar, boolean z11, int i11, int i12) {
        super(mVar);
        this.f67395b = hVar;
        this.f67396c = z11;
        this.f67397d = i11;
        this.f67398f = i12;
    }

    @Override // io.reactivex.rxjava3.core.j
    public void z(io.reactivex.rxjava3.core.o<? super U> oVar) {
        if (ObservableScalarXMap.b(this.f67422a, oVar, this.f67395b)) {
            return;
        }
        this.f67422a.subscribe(new MergeObserver(oVar, this.f67395b, this.f67396c, this.f67397d, this.f67398f));
    }
}
