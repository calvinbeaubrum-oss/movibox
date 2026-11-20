package com.google.common.util.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class k<V> extends p<V> {

    /* JADX INFO: compiled from: source.java */
    public static abstract class a<V> extends k<V> implements AbstractFuture.g<V> {
        @Override // com.google.common.util.concurrent.AbstractFuture, com.google.common.util.concurrent.s
        public final void addListener(Runnable runnable, Executor executor) {
            super.addListener(runnable, executor);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean cancel(boolean z11) {
            return super.cancel(z11);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final V get() throws ExecutionException, InterruptedException {
            return (V) super.get();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final V get(long j11, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
            return (V) super.get(j11, timeUnit);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean isCancelled() {
            return super.isCancelled();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean isDone() {
            return super.isDone();
        }
    }

    @Deprecated
    public static <V> k<V> from(k<V> kVar) {
        return (k) com.google.common.base.m.p(kVar);
    }

    public static <V> k<V> from(s<V> sVar) {
        return sVar instanceof k ? (k) sVar : new l(sVar);
    }

    public final void addCallback(o<? super V> oVar, Executor executor) {
        Futures.a(this, oVar, executor);
    }

    public final <X extends Throwable> k<V> catching(Class<X> cls, com.google.common.base.f<? super X, ? extends V> fVar, Executor executor) {
        return (k) Futures.b(this, cls, fVar, executor);
    }

    public final <X extends Throwable> k<V> catchingAsync(Class<X> cls, f<? super X, ? extends V> fVar, Executor executor) {
        return (k) Futures.c(this, cls, fVar, executor);
    }

    public final <T> k<T> transform(com.google.common.base.f<? super V, T> fVar, Executor executor) {
        return (k) Futures.i(this, fVar, executor);
    }

    public final <T> k<T> transformAsync(f<? super V, T> fVar, Executor executor) {
        return (k) Futures.j(this, fVar, executor);
    }

    public final k<V> withTimeout(long j11, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        return (k) Futures.k(this, j11, timeUnit, scheduledExecutorService);
    }
}
