package com.google.common.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
class TrustedListenableFutureTask<V> extends k.a<V> implements RunnableFuture<V> {
    private volatile InterruptibleTask<?> task;

    /* JADX INFO: compiled from: source.java */
    public final class TrustedFutureInterruptibleAsyncTask extends InterruptibleTask<s<V>> {
        private final e<V> callable;

        public TrustedFutureInterruptibleAsyncTask(e<V> eVar) {
            this.callable = (e) com.google.common.base.m.p(eVar);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public void afterRanInterruptiblyFailure(Throwable th2) {
            TrustedListenableFutureTask.this.setException(th2);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public void afterRanInterruptiblySuccess(s<V> sVar) {
            TrustedListenableFutureTask.this.setFuture(sVar);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public final boolean isDone() {
            return TrustedListenableFutureTask.this.isDone();
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public s<V> runInterruptibly() throws Exception {
            return (s) com.google.common.base.m.r(this.callable.call(), "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", this.callable);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public String toPendingString() {
            return this.callable.toString();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class TrustedFutureInterruptibleTask extends InterruptibleTask<V> {
        private final Callable<V> callable;

        public TrustedFutureInterruptibleTask(Callable<V> callable) {
            this.callable = (Callable) com.google.common.base.m.p(callable);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public void afterRanInterruptiblyFailure(Throwable th2) {
            TrustedListenableFutureTask.this.setException(th2);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public void afterRanInterruptiblySuccess(V v11) {
            TrustedListenableFutureTask.this.set(v11);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public final boolean isDone() {
            return TrustedListenableFutureTask.this.isDone();
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public V runInterruptibly() throws Exception {
            return this.callable.call();
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public String toPendingString() {
            return this.callable.toString();
        }
    }

    public TrustedListenableFutureTask(e<V> eVar) {
        this.task = new TrustedFutureInterruptibleAsyncTask(eVar);
    }

    public TrustedListenableFutureTask(Callable<V> callable) {
        this.task = new TrustedFutureInterruptibleTask(callable);
    }

    public static <V> TrustedListenableFutureTask<V> create(e<V> eVar) {
        return new TrustedListenableFutureTask<>(eVar);
    }

    public static <V> TrustedListenableFutureTask<V> create(Runnable runnable, V v11) {
        return new TrustedListenableFutureTask<>(Executors.callable(runnable, v11));
    }

    public static <V> TrustedListenableFutureTask<V> create(Callable<V> callable) {
        return new TrustedListenableFutureTask<>(callable);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public void afterDone() {
        InterruptibleTask<?> interruptibleTask;
        super.afterDone();
        if (wasInterrupted() && (interruptibleTask = this.task) != null) {
            interruptibleTask.interruptTask();
        }
        this.task = null;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
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
