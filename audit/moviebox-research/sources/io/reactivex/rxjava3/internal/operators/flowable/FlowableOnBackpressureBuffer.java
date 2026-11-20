package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class FlowableOnBackpressureBuffer<T> extends a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f67359c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f67360d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f67361f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final k10.a f67362g;

    /* JADX INFO: compiled from: source.java */
    public static final class BackpressureBufferSubscriber<T> extends BasicIntQueueSubscription<T> implements io.reactivex.rxjava3.core.f<T> {
        private static final long serialVersionUID = -2514538129242366402L;
        volatile boolean cancelled;
        final boolean delayError;
        volatile boolean done;
        final u30.c<? super T> downstream;
        Throwable error;
        final k10.a onOverflow;
        boolean outputFused;
        final m10.f<T> queue;
        final AtomicLong requested = new AtomicLong();
        u30.d upstream;

        public BackpressureBufferSubscriber(u30.c<? super T> cVar, int i11, boolean z11, boolean z12, k10.a aVar) {
            this.downstream = cVar;
            this.onOverflow = aVar;
            this.delayError = z12;
            this.queue = z11 ? new io.reactivex.rxjava3.internal.queue.a<>(i11) : new SpscArrayQueue<>(i11);
        }

        @Override // io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription, u30.d
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.upstream.cancel();
            if (this.outputFused || getAndIncrement() != 0) {
                return;
            }
            this.queue.clear();
        }

        public boolean checkTerminated(boolean z11, boolean z12, u30.c<? super T> cVar) {
            if (this.cancelled) {
                this.queue.clear();
                return true;
            }
            if (!z11) {
                return false;
            }
            if (this.delayError) {
                if (!z12) {
                    return false;
                }
                Throwable th2 = this.error;
                if (th2 != null) {
                    cVar.onError(th2);
                } else {
                    cVar.onComplete();
                }
                return true;
            }
            Throwable th3 = this.error;
            if (th3 != null) {
                this.queue.clear();
                cVar.onError(th3);
                return true;
            }
            if (!z12) {
                return false;
            }
            cVar.onComplete();
            return true;
        }

        @Override // io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription, m10.g
        public void clear() {
            this.queue.clear();
        }

        public void drain() {
            if (getAndIncrement() == 0) {
                m10.f<T> fVar = this.queue;
                u30.c<? super T> cVar = this.downstream;
                int iAddAndGet = 1;
                while (!checkTerminated(this.done, fVar.isEmpty(), cVar)) {
                    long j11 = this.requested.get();
                    long j12 = 0;
                    while (j12 != j11) {
                        boolean z11 = this.done;
                        T tPoll = fVar.poll();
                        boolean z12 = tPoll == null;
                        if (checkTerminated(z11, z12, cVar)) {
                            return;
                        }
                        if (z12) {
                            break;
                        }
                        cVar.onNext(tPoll);
                        j12++;
                    }
                    if (j12 == j11 && checkTerminated(this.done, fVar.isEmpty(), cVar)) {
                        return;
                    }
                    if (j12 != 0 && j11 != Long.MAX_VALUE) {
                        this.requested.addAndGet(-j12);
                    }
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription, m10.g
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // u30.c
        public void onComplete() {
            this.done = true;
            if (this.outputFused) {
                this.downstream.onComplete();
            } else {
                drain();
            }
        }

        @Override // u30.c
        public void onError(Throwable th2) {
            this.error = th2;
            this.done = true;
            if (this.outputFused) {
                this.downstream.onError(th2);
            } else {
                drain();
            }
        }

        @Override // u30.c
        public void onNext(T t11) {
            if (this.queue.offer(t11)) {
                if (this.outputFused) {
                    this.downstream.onNext(null);
                    return;
                } else {
                    drain();
                    return;
                }
            }
            this.upstream.cancel();
            MissingBackpressureException missingBackpressureException = new MissingBackpressureException("Buffer is full");
            try {
                this.onOverflow.run();
            } catch (Throwable th2) {
                i10.a.b(th2);
                missingBackpressureException.initCause(th2);
            }
            onError(missingBackpressureException);
        }

        @Override // u30.c
        public void onSubscribe(u30.d dVar) {
            if (SubscriptionHelper.validate(this.upstream, dVar)) {
                this.upstream = dVar;
                this.downstream.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }

        @Override // io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription, m10.g
        public T poll() {
            return this.queue.poll();
        }

        @Override // io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription, u30.d
        public void request(long j11) {
            if (this.outputFused || !SubscriptionHelper.validate(j11)) {
                return;
            }
            io.reactivex.rxjava3.internal.util.a.a(this.requested, j11);
            drain();
        }

        @Override // io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription, m10.c
        public int requestFusion(int i11) {
            if ((i11 & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }
    }

    public FlowableOnBackpressureBuffer(io.reactivex.rxjava3.core.e<T> eVar, int i11, boolean z11, boolean z12, k10.a aVar) {
        super(eVar);
        this.f67359c = i11;
        this.f67360d = z11;
        this.f67361f = z12;
        this.f67362g = aVar;
    }

    @Override // io.reactivex.rxjava3.core.e
    public void g(u30.c<? super T> cVar) {
        this.f67370b.f(new BackpressureBufferSubscriber(cVar, this.f67359c, this.f67360d, this.f67361f, this.f67362g));
    }
}
