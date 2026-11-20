package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class CombinedFuture<V> extends AggregateFuture<Object, V> {

    /* JADX INFO: compiled from: source.java */
    public final class AsyncCallableInterruptibleTask extends CombinedFuture<V>.CombinedFutureInterruptibleTask<i0<V>> {
        private final f<V> callable;
        final /* synthetic */ CombinedFuture this$0;

        public AsyncCallableInterruptibleTask(CombinedFuture combinedFuture, f<V> fVar, Executor executor) {
            super(combinedFuture, executor);
            this.callable = (f) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(fVar);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.InterruptibleTask
        public i0<V> runInterruptibly() throws Exception {
            this.thrownByExecute = false;
            return (i0) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.o(this.callable.call(), "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)?");
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.CombinedFuture.CombinedFutureInterruptibleTask
        public void setValue(i0<V> i0Var) {
            throw null;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.InterruptibleTask
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
            this.callable = (Callable) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(callable);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.InterruptibleTask
        public V runInterruptibly() throws Exception {
            this.thrownByExecute = false;
            return this.callable.call();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.CombinedFuture.CombinedFutureInterruptibleTask
        public void setValue(V v11) {
            throw null;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.InterruptibleTask
        public String toPendingString() {
            return this.callable.toString();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public abstract class CombinedFutureInterruptibleTask<T> extends InterruptibleTask<T> {
        private final Executor listenerExecutor;
        final /* synthetic */ CombinedFuture this$0;
        boolean thrownByExecute = true;

        public CombinedFutureInterruptibleTask(CombinedFuture combinedFuture, Executor executor) {
            this.listenerExecutor = (Executor) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(executor);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.InterruptibleTask
        public final void afterRanInterruptibly(T t11, Throwable th2) {
            if (th2 == null) {
                setValue(t11);
            } else {
                if (th2 instanceof ExecutionException) {
                    th2.getCause();
                    throw null;
                }
                if (!(th2 instanceof CancellationException)) {
                    throw null;
                }
                throw null;
            }
        }

        public final void execute() {
            try {
                this.listenerExecutor.execute(this);
            } catch (RejectedExecutionException unused) {
                if (this.thrownByExecute) {
                    throw null;
                }
            }
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.InterruptibleTask
        public final boolean isDone() {
            throw null;
        }

        public abstract void setValue(T t11);
    }

    /* JADX INFO: compiled from: source.java */
    public final class CombinedFutureRunningState extends AggregateFuture<Object, V>.RunningState {
        private CombinedFutureInterruptibleTask task;
        final /* synthetic */ CombinedFuture this$0;

        public CombinedFutureRunningState(CombinedFuture combinedFuture, ImmutableCollection<? extends i0<?>> immutableCollection, boolean z11, CombinedFutureInterruptibleTask combinedFutureInterruptibleTask) {
            super(immutableCollection, z11, false);
            this.task = combinedFutureInterruptibleTask;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.AggregateFuture.RunningState
        public void collectOneValue(boolean z11, int i11, Object obj) {
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.AggregateFuture.RunningState
        public void handleAllCompleted() {
            CombinedFutureInterruptibleTask combinedFutureInterruptibleTask = this.task;
            combinedFutureInterruptibleTask.getClass();
            combinedFutureInterruptibleTask.execute();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.AggregateFuture.RunningState
        public void interruptTask() {
            CombinedFutureInterruptibleTask combinedFutureInterruptibleTask = this.task;
            if (combinedFutureInterruptibleTask != null) {
                combinedFutureInterruptibleTask.interruptTask();
            }
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.AggregateFuture.RunningState
        public void releaseResourcesAfterFailure() {
            super.releaseResourcesAfterFailure();
            this.task = null;
        }
    }
}
