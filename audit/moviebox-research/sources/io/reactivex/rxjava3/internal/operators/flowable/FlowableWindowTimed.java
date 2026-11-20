package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.processors.UnicastProcessor;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class FlowableWindowTimed<T> extends a<T, io.reactivex.rxjava3.core.e<T>> {

    /* JADX INFO: compiled from: source.java */
    public static abstract class AbstractWindowSubscriber<T> extends AtomicInteger implements io.reactivex.rxjava3.core.f<T>, u30.d {
        private static final long serialVersionUID = 5724293814035355511L;
        final int bufferSize;
        volatile boolean done;
        final u30.c<? super io.reactivex.rxjava3.core.e<T>> downstream;
        long emitted;
        Throwable error;
        final long timespan;
        final TimeUnit unit;
        u30.d upstream;
        volatile boolean upstreamCancelled;
        final m10.f<Object> queue = new MpscLinkedQueue();
        final AtomicLong requested = new AtomicLong();
        final AtomicBoolean downstreamCancelled = new AtomicBoolean();
        final AtomicInteger windowCount = new AtomicInteger(1);

        public AbstractWindowSubscriber(u30.c<? super io.reactivex.rxjava3.core.e<T>> cVar, long j11, TimeUnit timeUnit, int i11) {
            this.downstream = cVar;
            this.timespan = j11;
            this.unit = timeUnit;
            this.bufferSize = i11;
        }

        @Override // u30.d
        public final void cancel() {
            if (this.downstreamCancelled.compareAndSet(false, true)) {
                windowDone();
            }
        }

        public abstract void cleanupResources();

        public abstract void createFirstWindow();

        public abstract void drain();

        @Override // u30.c
        public final void onComplete() {
            this.done = true;
            drain();
        }

        @Override // u30.c
        public final void onError(Throwable th2) {
            this.error = th2;
            this.done = true;
            drain();
        }

        @Override // u30.c
        public final void onNext(T t11) {
            this.queue.offer(t11);
            drain();
        }

        @Override // u30.c
        public final void onSubscribe(u30.d dVar) {
            if (SubscriptionHelper.validate(this.upstream, dVar)) {
                this.upstream = dVar;
                this.downstream.onSubscribe(this);
                createFirstWindow();
            }
        }

        @Override // u30.d
        public final void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                io.reactivex.rxjava3.internal.util.a.a(this.requested, j11);
            }
        }

        public final void windowDone() {
            if (this.windowCount.decrementAndGet() == 0) {
                cleanupResources();
                this.upstream.cancel();
                this.upstreamCancelled = true;
                drain();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class WindowExactBoundedSubscriber<T> extends AbstractWindowSubscriber<T> implements Runnable {
        private static final long serialVersionUID = -6130475889925953722L;
        long count;
        final long maxSize;
        final boolean restartTimerOnMaxSize;
        final Scheduler scheduler;
        final SequentialDisposable timer;
        UnicastProcessor<T> window;
        final Scheduler.Worker worker;

        /* JADX INFO: compiled from: source.java */
        public static final class WindowBoundaryRunnable implements Runnable {
            final long index;
            final WindowExactBoundedSubscriber<?> parent;

            public WindowBoundaryRunnable(WindowExactBoundedSubscriber<?> windowExactBoundedSubscriber, long j11) {
                this.parent = windowExactBoundedSubscriber;
                this.index = j11;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.parent.boundary(this);
            }
        }

        public WindowExactBoundedSubscriber(u30.c<? super io.reactivex.rxjava3.core.e<T>> cVar, long j11, TimeUnit timeUnit, Scheduler scheduler, int i11, long j12, boolean z11) {
            super(cVar, j11, timeUnit, i11);
            this.scheduler = scheduler;
            this.maxSize = j12;
            this.restartTimerOnMaxSize = z11;
            if (z11) {
                this.worker = scheduler.c();
            } else {
                this.worker = null;
            }
            this.timer = new SequentialDisposable();
        }

        public void boundary(WindowBoundaryRunnable windowBoundaryRunnable) {
            this.queue.offer(windowBoundaryRunnable);
            drain();
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableWindowTimed.AbstractWindowSubscriber
        public void cleanupResources() {
            this.timer.dispose();
            Scheduler.Worker worker = this.worker;
            if (worker != null) {
                worker.dispose();
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableWindowTimed.AbstractWindowSubscriber
        public void createFirstWindow() {
            if (this.downstreamCancelled.get()) {
                return;
            }
            if (this.requested.get() == 0) {
                this.upstream.cancel();
                this.downstream.onError(new MissingBackpressureException(FlowableWindowTimed.h(this.emitted)));
                cleanupResources();
                this.upstreamCancelled = true;
                return;
            }
            this.emitted = 1L;
            this.windowCount.getAndIncrement();
            this.window = UnicastProcessor.i(this.bufferSize, this);
            g gVar = new g(this.window);
            this.downstream.onNext(gVar);
            WindowBoundaryRunnable windowBoundaryRunnable = new WindowBoundaryRunnable(this, 1L);
            if (this.restartTimerOnMaxSize) {
                SequentialDisposable sequentialDisposable = this.timer;
                Scheduler.Worker worker = this.worker;
                long j11 = this.timespan;
                sequentialDisposable.replace(worker.schedulePeriodically(windowBoundaryRunnable, j11, j11, this.unit));
            } else {
                SequentialDisposable sequentialDisposable2 = this.timer;
                Scheduler scheduler = this.scheduler;
                long j12 = this.timespan;
                sequentialDisposable2.replace(scheduler.f(windowBoundaryRunnable, j12, j12, this.unit));
            }
            if (gVar.h()) {
                this.window.onComplete();
            }
            this.upstream.request(Long.MAX_VALUE);
        }

        public UnicastProcessor<T> createNewWindow(UnicastProcessor<T> unicastProcessor) {
            if (unicastProcessor != null) {
                unicastProcessor.onComplete();
                unicastProcessor = null;
            }
            if (this.downstreamCancelled.get()) {
                cleanupResources();
            } else {
                long j11 = this.emitted;
                if (this.requested.get() == j11) {
                    this.upstream.cancel();
                    cleanupResources();
                    this.upstreamCancelled = true;
                    this.downstream.onError(new MissingBackpressureException(FlowableWindowTimed.h(j11)));
                } else {
                    long j12 = j11 + 1;
                    this.emitted = j12;
                    this.windowCount.getAndIncrement();
                    unicastProcessor = UnicastProcessor.i(this.bufferSize, this);
                    this.window = unicastProcessor;
                    g gVar = new g(unicastProcessor);
                    this.downstream.onNext(gVar);
                    if (this.restartTimerOnMaxSize) {
                        SequentialDisposable sequentialDisposable = this.timer;
                        Scheduler.Worker worker = this.worker;
                        WindowBoundaryRunnable windowBoundaryRunnable = new WindowBoundaryRunnable(this, j12);
                        long j13 = this.timespan;
                        sequentialDisposable.update(worker.schedulePeriodically(windowBoundaryRunnable, j13, j13, this.unit));
                    }
                    if (gVar.h()) {
                        unicastProcessor.onComplete();
                    }
                }
            }
            return unicastProcessor;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableWindowTimed.AbstractWindowSubscriber
        public void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            m10.f<Object> fVar = this.queue;
            u30.c<? super io.reactivex.rxjava3.core.e<T>> cVar = this.downstream;
            UnicastProcessor<T> unicastProcessorCreateNewWindow = this.window;
            int iAddAndGet = 1;
            while (true) {
                if (this.upstreamCancelled) {
                    fVar.clear();
                    unicastProcessorCreateNewWindow = 0;
                    this.window = null;
                } else {
                    boolean z11 = this.done;
                    Object objPoll = fVar.poll();
                    boolean z12 = objPoll == null;
                    if (z11 && z12) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            if (unicastProcessorCreateNewWindow != 0) {
                                unicastProcessorCreateNewWindow.onError(th2);
                            }
                            cVar.onError(th2);
                        } else {
                            if (unicastProcessorCreateNewWindow != 0) {
                                unicastProcessorCreateNewWindow.onComplete();
                            }
                            cVar.onComplete();
                        }
                        cleanupResources();
                        this.upstreamCancelled = true;
                    } else if (!z12) {
                        if (objPoll instanceof WindowBoundaryRunnable) {
                            if (((WindowBoundaryRunnable) objPoll).index == this.emitted || !this.restartTimerOnMaxSize) {
                                this.count = 0L;
                                unicastProcessorCreateNewWindow = createNewWindow(unicastProcessorCreateNewWindow);
                            }
                        } else if (unicastProcessorCreateNewWindow != 0) {
                            unicastProcessorCreateNewWindow.onNext(objPoll);
                            long j11 = this.count + 1;
                            if (j11 == this.maxSize) {
                                this.count = 0L;
                                unicastProcessorCreateNewWindow = createNewWindow(unicastProcessorCreateNewWindow);
                            } else {
                                this.count = j11;
                            }
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

    /* JADX INFO: compiled from: source.java */
    public static final class WindowExactUnboundedSubscriber<T> extends AbstractWindowSubscriber<T> implements Runnable {
        static final Object NEXT_WINDOW = new Object();
        private static final long serialVersionUID = 1155822639622580836L;
        final Scheduler scheduler;
        final SequentialDisposable timer;
        UnicastProcessor<T> window;
        final Runnable windowRunnable;

        /* JADX INFO: compiled from: source.java */
        public final class WindowRunnable implements Runnable {
            public WindowRunnable() {
            }

            @Override // java.lang.Runnable
            public void run() {
                WindowExactUnboundedSubscriber.this.windowDone();
            }
        }

        public WindowExactUnboundedSubscriber(u30.c<? super io.reactivex.rxjava3.core.e<T>> cVar, long j11, TimeUnit timeUnit, Scheduler scheduler, int i11) {
            super(cVar, j11, timeUnit, i11);
            this.scheduler = scheduler;
            this.timer = new SequentialDisposable();
            this.windowRunnable = new WindowRunnable();
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableWindowTimed.AbstractWindowSubscriber
        public void cleanupResources() {
            this.timer.dispose();
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableWindowTimed.AbstractWindowSubscriber
        public void createFirstWindow() {
            if (this.downstreamCancelled.get()) {
                return;
            }
            if (this.requested.get() == 0) {
                this.upstream.cancel();
                this.downstream.onError(new MissingBackpressureException(FlowableWindowTimed.h(this.emitted)));
                cleanupResources();
                this.upstreamCancelled = true;
                return;
            }
            this.windowCount.getAndIncrement();
            this.window = UnicastProcessor.i(this.bufferSize, this.windowRunnable);
            this.emitted = 1L;
            g gVar = new g(this.window);
            this.downstream.onNext(gVar);
            SequentialDisposable sequentialDisposable = this.timer;
            Scheduler scheduler = this.scheduler;
            long j11 = this.timespan;
            sequentialDisposable.replace(scheduler.f(this, j11, j11, this.unit));
            if (gVar.h()) {
                this.window.onComplete();
            }
            this.upstream.request(Long.MAX_VALUE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v12, types: [io.reactivex.rxjava3.processors.UnicastProcessor] */
        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableWindowTimed.AbstractWindowSubscriber
        public void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            m10.f<Object> fVar = this.queue;
            u30.c<? super io.reactivex.rxjava3.core.e<T>> cVar = this.downstream;
            UnicastProcessor unicastProcessor = (UnicastProcessor<T>) this.window;
            int iAddAndGet = 1;
            while (true) {
                if (this.upstreamCancelled) {
                    fVar.clear();
                    this.window = null;
                    unicastProcessor = (UnicastProcessor<T>) null;
                } else {
                    boolean z11 = this.done;
                    Object objPoll = fVar.poll();
                    boolean z12 = objPoll == null;
                    if (z11 && z12) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            if (unicastProcessor != null) {
                                unicastProcessor.onError(th2);
                            }
                            cVar.onError(th2);
                        } else {
                            if (unicastProcessor != null) {
                                unicastProcessor.onComplete();
                            }
                            cVar.onComplete();
                        }
                        cleanupResources();
                        this.upstreamCancelled = true;
                    } else if (!z12) {
                        if (objPoll == NEXT_WINDOW) {
                            if (unicastProcessor != null) {
                                unicastProcessor.onComplete();
                                this.window = null;
                                unicastProcessor = (UnicastProcessor<T>) null;
                            }
                            if (this.downstreamCancelled.get()) {
                                this.timer.dispose();
                            } else {
                                long j11 = this.requested.get();
                                long j12 = this.emitted;
                                if (j11 == j12) {
                                    this.upstream.cancel();
                                    cleanupResources();
                                    this.upstreamCancelled = true;
                                    cVar.onError(new MissingBackpressureException(FlowableWindowTimed.h(this.emitted)));
                                } else {
                                    this.emitted = j12 + 1;
                                    this.windowCount.getAndIncrement();
                                    unicastProcessor = (UnicastProcessor<T>) UnicastProcessor.i(this.bufferSize, this.windowRunnable);
                                    this.window = unicastProcessor;
                                    g gVar = new g(unicastProcessor);
                                    cVar.onNext(gVar);
                                    if (gVar.h()) {
                                        unicastProcessor.onComplete();
                                    }
                                }
                            }
                        } else if (unicastProcessor != null) {
                            unicastProcessor.onNext(objPoll);
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

    /* JADX INFO: compiled from: source.java */
    public static final class WindowSkipSubscriber<T> extends AbstractWindowSubscriber<T> implements Runnable {
        private static final long serialVersionUID = -7852870764194095894L;
        final long timeskip;
        final List<UnicastProcessor<T>> windows;
        final Scheduler.Worker worker;
        static final Object WINDOW_OPEN = new Object();
        static final Object WINDOW_CLOSE = new Object();

        /* JADX INFO: compiled from: source.java */
        public static final class WindowBoundaryRunnable implements Runnable {
            final boolean isOpen;
            final WindowSkipSubscriber<?> parent;

            public WindowBoundaryRunnable(WindowSkipSubscriber<?> windowSkipSubscriber, boolean z11) {
                this.parent = windowSkipSubscriber;
                this.isOpen = z11;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.parent.boundary(this.isOpen);
            }
        }

        public WindowSkipSubscriber(u30.c<? super io.reactivex.rxjava3.core.e<T>> cVar, long j11, long j12, TimeUnit timeUnit, Scheduler.Worker worker, int i11) {
            super(cVar, j11, timeUnit, i11);
            this.timeskip = j12;
            this.worker = worker;
            this.windows = new LinkedList();
        }

        public void boundary(boolean z11) {
            this.queue.offer(z11 ? WINDOW_OPEN : WINDOW_CLOSE);
            drain();
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableWindowTimed.AbstractWindowSubscriber
        public void cleanupResources() {
            this.worker.dispose();
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableWindowTimed.AbstractWindowSubscriber
        public void createFirstWindow() {
            if (this.downstreamCancelled.get()) {
                return;
            }
            if (this.requested.get() == 0) {
                this.upstream.cancel();
                this.downstream.onError(new MissingBackpressureException(FlowableWindowTimed.h(this.emitted)));
                cleanupResources();
                this.upstreamCancelled = true;
                return;
            }
            this.emitted = 1L;
            this.windowCount.getAndIncrement();
            UnicastProcessor<T> unicastProcessorI = UnicastProcessor.i(this.bufferSize, this);
            this.windows.add(unicastProcessorI);
            g gVar = new g(unicastProcessorI);
            this.downstream.onNext(gVar);
            this.worker.schedule(new WindowBoundaryRunnable(this, false), this.timespan, this.unit);
            Scheduler.Worker worker = this.worker;
            WindowBoundaryRunnable windowBoundaryRunnable = new WindowBoundaryRunnable(this, true);
            long j11 = this.timeskip;
            worker.schedulePeriodically(windowBoundaryRunnable, j11, j11, this.unit);
            if (gVar.h()) {
                unicastProcessorI.onComplete();
                this.windows.remove(unicastProcessorI);
            }
            this.upstream.request(Long.MAX_VALUE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableWindowTimed.AbstractWindowSubscriber
        public void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            m10.f<Object> fVar = this.queue;
            u30.c<? super io.reactivex.rxjava3.core.e<T>> cVar = this.downstream;
            List<UnicastProcessor<T>> list = this.windows;
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
                            Iterator<UnicastProcessor<T>> it = list.iterator();
                            while (it.hasNext()) {
                                it.next().onError(th2);
                            }
                            cVar.onError(th2);
                        } else {
                            Iterator<UnicastProcessor<T>> it2 = list.iterator();
                            while (it2.hasNext()) {
                                it2.next().onComplete();
                            }
                            cVar.onComplete();
                        }
                        cleanupResources();
                        this.upstreamCancelled = true;
                    } else if (!z12) {
                        if (objPoll == WINDOW_OPEN) {
                            if (!this.downstreamCancelled.get()) {
                                long j11 = this.emitted;
                                if (this.requested.get() != j11) {
                                    this.emitted = j11 + 1;
                                    this.windowCount.getAndIncrement();
                                    UnicastProcessor<T> unicastProcessorI = UnicastProcessor.i(this.bufferSize, this);
                                    list.add(unicastProcessorI);
                                    g gVar = new g(unicastProcessorI);
                                    cVar.onNext(gVar);
                                    this.worker.schedule(new WindowBoundaryRunnable(this, false), this.timespan, this.unit);
                                    if (gVar.h()) {
                                        unicastProcessorI.onComplete();
                                    }
                                } else {
                                    this.upstream.cancel();
                                    MissingBackpressureException missingBackpressureException = new MissingBackpressureException(FlowableWindowTimed.h(j11));
                                    Iterator<UnicastProcessor<T>> it3 = list.iterator();
                                    while (it3.hasNext()) {
                                        it3.next().onError(missingBackpressureException);
                                    }
                                    cVar.onError(missingBackpressureException);
                                    cleanupResources();
                                    this.upstreamCancelled = true;
                                }
                            }
                        } else if (objPoll != WINDOW_CLOSE) {
                            Iterator<UnicastProcessor<T>> it4 = list.iterator();
                            while (it4.hasNext()) {
                                it4.next().onNext(objPoll);
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

    public static String h(long j11) {
        return "Unable to emit the next window (#" + j11 + ") due to lack of requests. Please make sure the downstream is ready to consume windows.";
    }
}
