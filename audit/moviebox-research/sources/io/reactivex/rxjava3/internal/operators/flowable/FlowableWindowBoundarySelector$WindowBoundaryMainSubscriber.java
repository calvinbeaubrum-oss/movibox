package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.processors.UnicastProcessor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import k10.h;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
final class FlowableWindowBoundarySelector$WindowBoundaryMainSubscriber<T, B, V> extends AtomicInteger implements io.reactivex.rxjava3.core.f<T>, u30.d, Runnable {
    private static final long serialVersionUID = 8646217640096099753L;
    final int bufferSize;
    final h<? super B, ? extends u30.b<V>> closingIndicator;
    final u30.c<? super io.reactivex.rxjava3.core.e<T>> downstream;
    long emitted;
    final u30.b<B> open;
    volatile boolean openDone;
    u30.d upstream;
    volatile boolean upstreamCanceled;
    volatile boolean upstreamDone;
    final m10.f<Object> queue = new MpscLinkedQueue();
    final h10.a resources = new h10.a();
    final List<UnicastProcessor<T>> windows = new ArrayList();
    final AtomicLong windowCount = new AtomicLong(1);
    final AtomicBoolean downstreamCancelled = new AtomicBoolean();
    final AtomicThrowable error = new AtomicThrowable();
    final WindowStartSubscriber<B> startSubscriber = new WindowStartSubscriber<>(this);
    final AtomicLong requested = new AtomicLong();

    /* JADX INFO: compiled from: source.java */
    public static final class WindowStartSubscriber<B> extends AtomicReference<u30.d> implements io.reactivex.rxjava3.core.f<B> {
        private static final long serialVersionUID = -3326496781427702834L;
        final FlowableWindowBoundarySelector$WindowBoundaryMainSubscriber<?, B, ?> parent;

        public WindowStartSubscriber(FlowableWindowBoundarySelector$WindowBoundaryMainSubscriber<?, B, ?> flowableWindowBoundarySelector$WindowBoundaryMainSubscriber) {
            this.parent = flowableWindowBoundarySelector$WindowBoundaryMainSubscriber;
        }

        public void cancel() {
            SubscriptionHelper.cancel(this);
        }

        @Override // u30.c
        public void onComplete() {
            this.parent.openComplete();
        }

        @Override // u30.c
        public void onError(Throwable th2) {
            this.parent.openError(th2);
        }

        @Override // u30.c
        public void onNext(B b11) {
            this.parent.open(b11);
        }

        @Override // u30.c
        public void onSubscribe(u30.d dVar) {
            if (SubscriptionHelper.setOnce(this, dVar)) {
                dVar.request(Long.MAX_VALUE);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class a<T, V> extends io.reactivex.rxjava3.core.e<T> implements io.reactivex.rxjava3.core.f<V>, h10.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final FlowableWindowBoundarySelector$WindowBoundaryMainSubscriber<T, ?, V> f67365b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final UnicastProcessor<T> f67366c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AtomicReference<u30.d> f67367d = new AtomicReference<>();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final AtomicBoolean f67368f = new AtomicBoolean();

        public a(FlowableWindowBoundarySelector$WindowBoundaryMainSubscriber<T, ?, V> flowableWindowBoundarySelector$WindowBoundaryMainSubscriber, UnicastProcessor<T> unicastProcessor) {
            this.f67365b = flowableWindowBoundarySelector$WindowBoundaryMainSubscriber;
            this.f67366c = unicastProcessor;
        }

        @Override // h10.b
        public void dispose() {
            SubscriptionHelper.cancel(this.f67367d);
        }

        @Override // io.reactivex.rxjava3.core.e
        public void g(u30.c<? super T> cVar) {
            this.f67366c.subscribe(cVar);
            this.f67368f.set(true);
        }

        public boolean h() {
            return !this.f67368f.get() && this.f67368f.compareAndSet(false, true);
        }

        @Override // h10.b
        public boolean isDisposed() {
            return this.f67367d.get() == SubscriptionHelper.CANCELLED;
        }

        @Override // u30.c
        public void onComplete() {
            this.f67365b.close(this);
        }

        @Override // u30.c
        public void onError(Throwable th2) {
            if (isDisposed()) {
                p10.a.q(th2);
            } else {
                this.f67365b.closeError(th2);
            }
        }

        @Override // u30.c
        public void onNext(V v11) {
            if (SubscriptionHelper.cancel(this.f67367d)) {
                this.f67365b.close(this);
            }
        }

        @Override // u30.c
        public void onSubscribe(u30.d dVar) {
            if (SubscriptionHelper.setOnce(this.f67367d, dVar)) {
                dVar.request(Long.MAX_VALUE);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b<B> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final B f67369a;

        public b(B b11) {
            this.f67369a = b11;
        }
    }

    public FlowableWindowBoundarySelector$WindowBoundaryMainSubscriber(u30.c<? super io.reactivex.rxjava3.core.e<T>> cVar, u30.b<B> bVar, h<? super B, ? extends u30.b<V>> hVar, int i11) {
        this.downstream = cVar;
        this.open = bVar;
        this.closingIndicator = hVar;
        this.bufferSize = i11;
    }

    @Override // u30.d
    public void cancel() {
        if (this.downstreamCancelled.compareAndSet(false, true)) {
            if (this.windowCount.decrementAndGet() != 0) {
                this.startSubscriber.cancel();
                return;
            }
            this.upstream.cancel();
            this.startSubscriber.cancel();
            this.resources.dispose();
            this.error.tryTerminateAndReport();
            this.upstreamCanceled = true;
            drain();
        }
    }

    public void close(a<T, V> aVar) {
        this.queue.offer(aVar);
        drain();
    }

    public void closeError(Throwable th2) {
        this.upstream.cancel();
        this.startSubscriber.cancel();
        this.resources.dispose();
        if (this.error.tryAddThrowableOrReport(th2)) {
            this.upstreamDone = true;
            drain();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        u30.c<? super io.reactivex.rxjava3.core.e<T>> cVar = this.downstream;
        m10.f<Object> fVar = this.queue;
        List<UnicastProcessor<T>> list = this.windows;
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
                    terminateDownstream(cVar);
                    this.upstreamCanceled = true;
                } else if (z12) {
                    if (this.openDone && list.size() == 0) {
                        this.upstream.cancel();
                        this.startSubscriber.cancel();
                        this.resources.dispose();
                        terminateDownstream(cVar);
                        this.upstreamCanceled = true;
                    }
                } else if (objPoll instanceof b) {
                    if (!this.downstreamCancelled.get()) {
                        long j11 = this.emitted;
                        if (this.requested.get() != j11) {
                            this.emitted = j11 + 1;
                            try {
                                u30.b<V> bVarApply = this.closingIndicator.apply(((b) objPoll).f67369a);
                                Objects.requireNonNull(bVarApply, "The closingIndicator returned a null Publisher");
                                u30.b<V> bVar = bVarApply;
                                this.windowCount.getAndIncrement();
                                UnicastProcessor<T> unicastProcessorI = UnicastProcessor.i(this.bufferSize, this);
                                a aVar = new a(this, unicastProcessorI);
                                cVar.onNext(aVar);
                                if (aVar.h()) {
                                    unicastProcessorI.onComplete();
                                } else {
                                    list.add(unicastProcessorI);
                                    this.resources.c(aVar);
                                    bVar.subscribe(aVar);
                                }
                            } catch (Throwable th2) {
                                i10.a.b(th2);
                                this.upstream.cancel();
                                this.startSubscriber.cancel();
                                this.resources.dispose();
                                i10.a.b(th2);
                                this.error.tryAddThrowableOrReport(th2);
                                this.upstreamDone = true;
                            }
                        } else {
                            this.upstream.cancel();
                            this.startSubscriber.cancel();
                            this.resources.dispose();
                            this.error.tryAddThrowableOrReport(new MissingBackpressureException(FlowableWindowTimed.h(j11)));
                            this.upstreamDone = true;
                        }
                    }
                } else if (objPoll instanceof a) {
                    UnicastProcessor<T> unicastProcessor = ((a) objPoll).f67366c;
                    list.remove(unicastProcessor);
                    this.resources.b((h10.b) objPoll);
                    unicastProcessor.onComplete();
                } else {
                    Iterator<UnicastProcessor<T>> it = list.iterator();
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

    @Override // u30.c
    public void onComplete() {
        this.startSubscriber.cancel();
        this.resources.dispose();
        this.upstreamDone = true;
        drain();
    }

    @Override // u30.c
    public void onError(Throwable th2) {
        this.startSubscriber.cancel();
        this.resources.dispose();
        if (this.error.tryAddThrowableOrReport(th2)) {
            this.upstreamDone = true;
            drain();
        }
    }

    @Override // u30.c
    public void onNext(T t11) {
        this.queue.offer(t11);
        drain();
    }

    @Override // u30.c
    public void onSubscribe(u30.d dVar) {
        if (SubscriptionHelper.validate(this.upstream, dVar)) {
            this.upstream = dVar;
            this.downstream.onSubscribe(this);
            this.open.subscribe(this.startSubscriber);
            dVar.request(Long.MAX_VALUE);
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
        this.upstream.cancel();
        this.resources.dispose();
        if (this.error.tryAddThrowableOrReport(th2)) {
            this.upstreamDone = true;
            drain();
        }
    }

    @Override // u30.d
    public void request(long j11) {
        if (SubscriptionHelper.validate(j11)) {
            io.reactivex.rxjava3.internal.util.a.a(this.requested, j11);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.windowCount.decrementAndGet() == 0) {
            this.upstream.cancel();
            this.startSubscriber.cancel();
            this.resources.dispose();
            this.error.tryTerminateAndReport();
            this.upstreamCanceled = true;
            drain();
        }
    }

    public void terminateDownstream(u30.c<?> cVar) {
        Throwable thTerminate = this.error.terminate();
        if (thTerminate == null) {
            Iterator<UnicastProcessor<T>> it = this.windows.iterator();
            while (it.hasNext()) {
                it.next().onComplete();
            }
            cVar.onComplete();
            return;
        }
        if (thTerminate != ExceptionHelper.f67551a) {
            Iterator<UnicastProcessor<T>> it2 = this.windows.iterator();
            while (it2.hasNext()) {
                it2.next().onError(thTerminate);
            }
            cVar.onError(thTerminate);
        }
    }
}
