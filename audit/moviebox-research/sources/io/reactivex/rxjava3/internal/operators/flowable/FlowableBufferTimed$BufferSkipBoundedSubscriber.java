package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import k10.k;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
final class FlowableBufferTimed$BufferSkipBoundedSubscriber<T, U extends Collection<? super T>> extends io.reactivex.rxjava3.internal.subscribers.b<T, U, U> implements u30.d, Runnable {
    final k<U> bufferSupplier;
    final List<U> buffers;
    final long timeskip;
    final long timespan;
    final TimeUnit unit;
    u30.d upstream;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    final Scheduler.Worker f67356w;

    /* JADX INFO: compiled from: source.java */
    public final class RemoveFromBuffer implements Runnable {
        private final U buffer;

        public RemoveFromBuffer(U u11) {
            this.buffer = u11;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (FlowableBufferTimed$BufferSkipBoundedSubscriber.this) {
                FlowableBufferTimed$BufferSkipBoundedSubscriber.this.buffers.remove(this.buffer);
            }
            FlowableBufferTimed$BufferSkipBoundedSubscriber flowableBufferTimed$BufferSkipBoundedSubscriber = FlowableBufferTimed$BufferSkipBoundedSubscriber.this;
            flowableBufferTimed$BufferSkipBoundedSubscriber.fastPathOrderedEmitMax(this.buffer, false, flowableBufferTimed$BufferSkipBoundedSubscriber.f67356w);
        }
    }

    public FlowableBufferTimed$BufferSkipBoundedSubscriber(u30.c<? super U> cVar, k<U> kVar, long j11, long j12, TimeUnit timeUnit, Scheduler.Worker worker) {
        super(cVar, new MpscLinkedQueue());
        this.bufferSupplier = kVar;
        this.timespan = j11;
        this.timeskip = j12;
        this.unit = timeUnit;
        this.f67356w = worker;
        this.buffers = new LinkedList();
    }

    @Override // io.reactivex.rxjava3.internal.subscribers.b, io.reactivex.rxjava3.internal.util.h
    public /* bridge */ /* synthetic */ boolean accept(u30.c cVar, Object obj) {
        return accept((u30.c<? super Collection>) cVar, (Collection) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean accept(u30.c<? super U> cVar, U u11) {
        cVar.onNext(u11);
        return true;
    }

    @Override // u30.d
    public void cancel() {
        this.cancelled = true;
        this.upstream.cancel();
        this.f67356w.dispose();
        clear();
    }

    public void clear() {
        synchronized (this) {
            this.buffers.clear();
        }
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // u30.c
    public void onComplete() {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.buffers);
            this.buffers.clear();
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.queue.offer((U) ((Collection) it.next()));
        }
        this.done = true;
        if (enter()) {
            i.e(this.queue, this.downstream, false, this.f67356w, this);
        }
    }

    @Override // u30.c
    public void onError(Throwable th2) {
        this.done = true;
        this.f67356w.dispose();
        clear();
        this.downstream.onError(th2);
    }

    @Override // u30.c
    public void onNext(T t11) {
        synchronized (this) {
            try {
                Iterator<U> it = this.buffers.iterator();
                while (it.hasNext()) {
                    it.next().add(t11);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // u30.c
    public void onSubscribe(u30.d dVar) {
        if (SubscriptionHelper.validate(this.upstream, dVar)) {
            this.upstream = dVar;
            try {
                U u11 = this.bufferSupplier.get();
                Objects.requireNonNull(u11, "The supplied buffer is null");
                U u12 = u11;
                this.buffers.add(u12);
                this.downstream.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
                Scheduler.Worker worker = this.f67356w;
                long j11 = this.timeskip;
                worker.schedulePeriodically(this, j11, j11, this.unit);
                this.f67356w.schedule(new RemoveFromBuffer(u12), this.timespan, this.unit);
            } catch (Throwable th2) {
                i10.a.b(th2);
                this.f67356w.dispose();
                dVar.cancel();
                EmptySubscription.error(th2, this.downstream);
            }
        }
    }

    @Override // u30.d
    public void request(long j11) {
        requested(j11);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.cancelled) {
            return;
        }
        try {
            U u11 = this.bufferSupplier.get();
            Objects.requireNonNull(u11, "The supplied buffer is null");
            U u12 = u11;
            synchronized (this) {
                try {
                    if (this.cancelled) {
                        return;
                    }
                    this.buffers.add(u12);
                    this.f67356w.schedule(new RemoveFromBuffer(u12), this.timespan, this.unit);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            i10.a.b(th3);
            cancel();
            this.downstream.onError(th3);
        }
    }
}
