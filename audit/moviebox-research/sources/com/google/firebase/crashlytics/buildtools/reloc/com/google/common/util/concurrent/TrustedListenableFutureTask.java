package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
class TrustedListenableFutureTask<V> extends AbstractFuture.g<V> implements RunnableFuture<V> {
    private volatile InterruptibleTask<?> task;

    /* JADX INFO: compiled from: source.java */
    public final class TrustedFutureInterruptibleAsyncTask extends InterruptibleTask<i0<V>> {
        private final f<V> callable;

        public TrustedFutureInterruptibleAsyncTask(f<V> fVar) {
            this.callable = (f) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(fVar);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.InterruptibleTask
        public void afterRanInterruptibly(i0<V> i0Var, Throwable th2) {
            if (th2 == null) {
                TrustedListenableFutureTask.this.setFuture(i0Var);
            } else {
                TrustedListenableFutureTask.this.setException(th2);
            }
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.InterruptibleTask
        public final boolean isDone() {
            return TrustedListenableFutureTask.this.isDone();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.InterruptibleTask
        public i0<V> runInterruptibly() throws Exception {
            return (i0) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.o(this.callable.call(), "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)?");
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.InterruptibleTask
        public String toPendingString() {
            return this.callable.toString();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class TrustedFutureInterruptibleTask extends InterruptibleTask<V> {
        private final Callable<V> callable;

        public TrustedFutureInterruptibleTask(Callable<V> callable) {
            this.callable = (Callable) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(callable);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.InterruptibleTask
        public void afterRanInterruptibly(V v11, Throwable th2) {
            if (th2 == null) {
                TrustedListenableFutureTask.this.set(v11);
            } else {
                TrustedListenableFutureTask.this.setException(th2);
            }
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.InterruptibleTask
        public final boolean isDone() {
            return TrustedListenableFutureTask.this.isDone();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.InterruptibleTask
        public V runInterruptibly() throws Exception {
            return this.callable.call();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.InterruptibleTask
        public String toPendingString() {
            return this.callable.toString();
        }
    }

    public TrustedListenableFutureTask(f<V> fVar) {
        this.task = new TrustedFutureInterruptibleAsyncTask(fVar);
    }

    public TrustedListenableFutureTask(Callable<V> callable) {
        this.task = new TrustedFutureInterruptibleTask(callable);
    }

    public static <V> TrustedListenableFutureTask<V> create(f<V> fVar) {
        return new TrustedListenableFutureTask<>(fVar);
    }

    public static <V> TrustedListenableFutureTask<V> create(Runnable runnable, V v11) {
        return new TrustedListenableFutureTask<>(Executors.callable(runnable, v11));
    }

    public static <V> TrustedListenableFutureTask<V> create(Callable<V> callable) {
        return new TrustedListenableFutureTask<>(callable);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.AbstractFuture
    public void afterDone() {
        InterruptibleTask<?> interruptibleTask;
        super.afterDone();
        if (wasInterrupted() && (interruptibleTask = this.task) != null) {
            interruptibleTask.interruptTask();
        }
        this.task = null;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.AbstractFuture
    public String pendingToString() {
        InterruptibleTask<?> interruptibleTask = this.task;
        if (interruptibleTask == null) {
            return super.pendingToString();
        }
        return "task=[" + interruptibleTask + "]";
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public void run() {
        InterruptibleTask<?> interruptibleTask = this.task;
        if (interruptibleTask != null) {
            interruptibleTask.run();
        }
        this.task = null;
    }
}
