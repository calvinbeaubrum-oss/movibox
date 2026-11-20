package com.google.common.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class CombinedFuture<V> extends AggregateFuture<Object, V> {

    /* JADX INFO: compiled from: source.java */
    public final class AsyncCallableInterruptibleTask extends CombinedFuture<V>.CombinedFutureInterruptibleTask<s<V>> {
        private final e<V> callable;
        final /* synthetic */ CombinedFuture this$0;

        public AsyncCallableInterruptibleTask(CombinedFuture combinedFuture, e<V> eVar, Executor executor) {
            super(combinedFuture, executor);
            this.callable = (e) com.google.common.base.m.p(eVar);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public s<V> runInterruptibly() throws Exception {
            return (s) com.google.common.base.m.r(this.callable.call(), "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", this.callable);
        }

        @Override // com.google.common.util.concurrent.CombinedFuture.CombinedFutureInterruptibleTask
        public void setValue(s<V> sVar) {
            throw null;
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public String toPendingString() {
            return this.callable.toString();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class CallableInterruptibleTask extends CombinedFuture<V>.CombinedFutureInterruptibleTask<V> {
        private final Callable<V> callable;
        final /* synthetic */ CombinedFuture this$0;

        public CallableInterruptibleTask(CombinedFuture combinedFuture, Callable<V> callable, Executor executor) {
            super(combinedFuture, executor);
            this.callable = (Callable) com.google.common.base.m.p(callable);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public V runInterruptibly() throws Exception {
            return this.callable.call();
        }

        @Override // com.google.common.util.concurrent.CombinedFuture.CombinedFutureInterruptibleTask
        public void setValue(V v11) {
            throw null;
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public String toPendingString() {
            return this.callable.toString();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public abstract class CombinedFutureInterruptibleTask<T> extends InterruptibleTask<T> {
        private final Executor listenerExecutor;
        final /* synthetic */ CombinedFuture this$0;

        public CombinedFutureInterruptibleTask(CombinedFuture combinedFuture, Executor executor) {
            this.listenerExecutor = (Executor) com.google.common.base.m.p(executor);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public final void afterRanInterruptiblyFailure(Throwable th2) {
            CombinedFuture.c(null, null);
            if (th2 instanceof ExecutionException) {
                ((ExecutionException) th2).getCause();
                throw null;
            }
            if (!(th2 instanceof CancellationException)) {
                throw null;
            }
            throw null;
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public final void afterRanInterruptiblySuccess(T t11) {
            CombinedFuture.c(null, null);
            setValue(t11);
        }

        public final void execute() {
            try {
                this.listenerExecutor.execute(this);
            } catch (RejectedExecutionException unused) {
                throw null;
            }
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public final boolean isDone() {
            throw null;
        }

        public abstract void setValue(T t11);
    }

    public static /* synthetic */ CombinedFutureInterruptibleTask c(CombinedFuture combinedFuture, CombinedFutureInterruptibleTask combinedFutureInterruptibleTask) {
        throw null;
    }
}
