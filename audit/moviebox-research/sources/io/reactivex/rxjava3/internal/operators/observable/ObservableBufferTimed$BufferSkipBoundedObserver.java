package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
final class ObservableBufferTimed$BufferSkipBoundedObserver<T, U extends Collection<? super T>> extends io.reactivex.rxjava3.internal.observers.c<T, U, U> implements Runnable, h10.b {
    final k10.k<U> bufferSupplier;
    final List<U> buffers;
    final long timeskip;
    final long timespan;
    final TimeUnit unit;
    h10.b upstream;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    final Scheduler.Worker f67391w;

    /* JADX INFO: compiled from: source.java */
    public final class RemoveFromBuffer implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final U f67392b;

        public RemoveFromBuffer(U u11) {
            this.f67392b = u11;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (ObservableBufferTimed$BufferSkipBoundedObserver.this) {
                ObservableBufferTimed$BufferSkipBoundedObserver.this.buffers.remove(this.f67392b);
            }
            ObservableBufferTimed$BufferSkipBoundedObserver observableBufferTimed$BufferSkipBoundedObserver = ObservableBufferTimed$BufferSkipBoundedObserver.this;
            observableBufferTimed$BufferSkipBoundedObserver.fastPathOrderedEmit(this.f67392b, false, observableBufferTimed$BufferSkipBoundedObserver.f67391w);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class RemoveFromBufferEmit implements Runnable {
        private final U buffer;

        public RemoveFromBufferEmit(U u11) {
            this.buffer = u11;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (ObservableBufferTimed$BufferSkipBoundedObserver.this) {
                ObservableBufferTimed$BufferSkipBoundedObserver.this.buffers.remove(this.buffer);
            }
            ObservableBufferTimed$BufferSkipBoundedObserver observableBufferTimed$BufferSkipBoundedObserver = ObservableBufferTimed$BufferSkipBoundedObserver.this;
            observableBufferTimed$BufferSkipBoundedObserver.fastPathOrderedEmit(this.buffer, false, observableBufferTimed$BufferSkipBoundedObserver.f67391w);
        }
    }

    public ObservableBufferTimed$BufferSkipBoundedObserver(io.reactivex.rxjava3.core.o<? super U> oVar, k10.k<U> kVar, long j11, long j12, TimeUnit timeUnit, Scheduler.Worker worker) {
        super(oVar, new MpscLinkedQueue());
        this.bufferSupplier = kVar;
        this.timespan = j11;
        this.timeskip = j12;
        this.unit = timeUnit;
        this.f67391w = worker;
        this.buffers = new LinkedList();
    }

    @Override // io.reactivex.rxjava3.internal.observers.c, io.reactivex.rxjava3.internal.util.e
    public /* bridge */ /* synthetic */ void accept(io.reactivex.rxjava3.core.o oVar, Object obj) {
        accept((io.reactivex.rxjava3.core.o<? super Collection>) oVar, (Collection) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void accept(io.reactivex.rxjava3.core.o<? super U> oVar, U u11) {
        oVar.onNext(u11);
    }

    public void clear() {
        synchronized (this) {
            this.buffers.clear();
        }
    }

    @Override // h10.b
    public void dispose() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        clear();
        this.upstream.dispose();
        this.f67391w.dispose();
    }

    @Override // h10.b
    public boolean isDisposed() {
        return this.cancelled;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // io.reactivex.rxjava3.core.o
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
            io.reactivex.rxjava3.internal.util.i.d(this.queue, this.downstream, false, this.f67391w, this);
        }
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onError(Throwable th2) {
        this.done = true;
        clear();
        this.downstream.onError(th2);
        this.f67391w.dispose();
    }

    @Override // io.reactivex.rxjava3.core.o
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

    @Override // io.reactivex.rxjava3.core.o
    public void onSubscribe(h10.b bVar) {
        if (DisposableHelper.validate(this.upstream, bVar)) {
            this.upstream = bVar;
            try {
                U u11 = this.bufferSupplier.get();
                Objects.requireNonNull(u11, "The buffer supplied is null");
                U u12 = u11;
                this.buffers.add(u12);
                this.downstream.onSubscribe(this);
                Scheduler.Worker worker = this.f67391w;
                long j11 = this.timeskip;
                worker.schedulePeriodically(this, j11, j11, this.unit);
                this.f67391w.schedule(new RemoveFromBufferEmit(u12), this.timespan, this.unit);
            } catch (Throwable th2) {
                i10.a.b(th2);
                bVar.dispose();
                EmptyDisposable.error(th2, this.downstream);
                this.f67391w.dispose();
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.cancelled) {
            return;
        }
        try {
            U u11 = this.bufferSupplier.get();
            Objects.requireNonNull(u11, "The bufferSupplier returned a null buffer");
            U u12 = u11;
            synchronized (this) {
                try {
                    if (this.cancelled) {
                        return;
                    }
                    this.buffers.add(u12);
                    this.f67391w.schedule(new RemoveFromBuffer(u12), this.timespan, this.unit);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            i10.a.b(th3);
            this.downstream.onError(th3);
            dispose();
        }
    }
}
