package com.google.common.util.concurrent;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public final class MoreExecutors {

    /* JADX INFO: renamed from: com.google.common.util.concurrent.MoreExecutors$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes4.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ s val$future;
        final /* synthetic */ BlockingQueue val$queue;

        public AnonymousClass1(BlockingQueue blockingQueue, s sVar) {
            this.val$queue = blockingQueue;
            this.val$future = sVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.val$queue.add(this.val$future);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes4.dex */
    public static final class ScheduledListeningDecorator extends c implements v {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ScheduledExecutorService f38896b;

        /* JADX INFO: compiled from: source.java */
        public static final class NeverSuccessfulListenableFutureTask extends AbstractFuture.h<Void> implements Runnable {
            private final Runnable delegate;

            public NeverSuccessfulListenableFutureTask(Runnable runnable) {
                this.delegate = (Runnable) com.google.common.base.m.p(runnable);
            }

            @Override // com.google.common.util.concurrent.AbstractFuture
            public String pendingToString() {
                return "task=[" + this.delegate + "]";
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    this.delegate.run();
                } catch (Error | RuntimeException e11) {
                    setException(e11);
                    throw e11;
                }
            }
        }

        /* JADX INFO: compiled from: source.java */
        public static final class a<V> extends n.a<V> implements t<V> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final ScheduledFuture<?> f38897b;

            public a(s<V> sVar, ScheduledFuture<?> scheduledFuture) {
                super(sVar);
                this.f38897b = scheduledFuture;
            }

            @Override // com.google.common.util.concurrent.m, java.util.concurrent.Future
            public boolean cancel(boolean z11) {
                boolean zCancel = super.cancel(z11);
                if (zCancel) {
                    this.f38897b.cancel(z11);
                }
                return zCancel;
            }

            @Override // java.util.concurrent.Delayed
            public long getDelay(TimeUnit timeUnit) {
                return this.f38897b.getDelay(timeUnit);
            }

            @Override // java.lang.Comparable
            /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
            public int compareTo(Delayed delayed) {
                return this.f38897b.compareTo(delayed);
            }
        }

        public ScheduledListeningDecorator(ScheduledExecutorService scheduledExecutorService) {
            super(scheduledExecutorService);
            this.f38896b = (ScheduledExecutorService) com.google.common.base.m.p(scheduledExecutorService);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public <V> t<V> schedule(Callable<V> callable, long j11, TimeUnit timeUnit) {
            TrustedListenableFutureTask trustedListenableFutureTaskCreate = TrustedListenableFutureTask.create(callable);
            return new a(trustedListenableFutureTaskCreate, this.f38896b.schedule(trustedListenableFutureTaskCreate, j11, timeUnit));
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public t<?> scheduleAtFixedRate(Runnable runnable, long j11, long j12, TimeUnit timeUnit) {
            NeverSuccessfulListenableFutureTask neverSuccessfulListenableFutureTask = new NeverSuccessfulListenableFutureTask(runnable);
            return new a(neverSuccessfulListenableFutureTask, this.f38896b.scheduleAtFixedRate(neverSuccessfulListenableFutureTask, j11, j12, timeUnit));
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public t<?> schedule(Runnable runnable, long j11, TimeUnit timeUnit) {
            TrustedListenableFutureTask trustedListenableFutureTaskCreate = TrustedListenableFutureTask.create(runnable, null);
            return new a(trustedListenableFutureTaskCreate, this.f38896b.schedule(trustedListenableFutureTaskCreate, j11, timeUnit));
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public t<?> scheduleWithFixedDelay(Runnable runnable, long j11, long j12, TimeUnit timeUnit) {
            NeverSuccessfulListenableFutureTask neverSuccessfulListenableFutureTask = new NeverSuccessfulListenableFutureTask(runnable);
            return new a(neverSuccessfulListenableFutureTask, this.f38896b.scheduleWithFixedDelay(neverSuccessfulListenableFutureTask, j11, j12, timeUnit));
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes4.dex */
    public class a implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Executor f38898a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AbstractFuture f38899b;

        public a(Executor executor, AbstractFuture abstractFuture) {
            this.f38898a = executor;
            this.f38899b = abstractFuture;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            try {
                this.f38898a.execute(runnable);
            } catch (RejectedExecutionException e11) {
                this.f38899b.setException(e11);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes4.dex */
    public static class b {
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes4.dex */
    public static class c extends com.google.common.util.concurrent.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ExecutorService f38900a;

        public c(ExecutorService executorService) {
            this.f38900a = (ExecutorService) com.google.common.base.m.p(executorService);
        }

        @Override // java.util.concurrent.ExecutorService
        public final boolean awaitTermination(long j11, TimeUnit timeUnit) throws InterruptedException {
            return this.f38900a.awaitTermination(j11, timeUnit);
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            this.f38900a.execute(runnable);
        }

        @Override // java.util.concurrent.ExecutorService
        public final boolean isShutdown() {
            return this.f38900a.isShutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public final boolean isTerminated() {
            return this.f38900a.isTerminated();
        }

        @Override // java.util.concurrent.ExecutorService
        public final void shutdown() {
            this.f38900a.shutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public final List<Runnable> shutdownNow() {
            return this.f38900a.shutdownNow();
        }

        public final String toString() {
            return super.toString() + "[" + this.f38900a + "]";
        }
    }

    public static Executor a() {
        return DirectExecutor.INSTANCE;
    }

    public static u b(ExecutorService executorService) {
        if (executorService instanceof u) {
            return (u) executorService;
        }
        return executorService instanceof ScheduledExecutorService ? new ScheduledListeningDecorator((ScheduledExecutorService) executorService) : new c(executorService);
    }

    public static Executor c(Executor executor, AbstractFuture<?> abstractFuture) {
        com.google.common.base.m.p(executor);
        com.google.common.base.m.p(abstractFuture);
        return executor == a() ? executor : new a(executor, abstractFuture);
    }
}
