package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class a0<V> extends e0<V> {
    public static <V> a0<V> from(i0<V> i0Var) {
        return i0Var instanceof a0 ? (a0) i0Var : new b0(i0Var);
    }

    public final void addCallback(d0<? super V> d0Var, Executor executor) {
        Futures.a(this, d0Var, executor);
    }

    public final <X extends Throwable> a0<V> catching(Class<X> cls, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.d<? super X, ? extends V> dVar, Executor executor) {
        return (a0) Futures.b(this, cls, dVar, executor);
    }

    public final <X extends Throwable> a0<V> catchingAsync(Class<X> cls, g<? super X, ? extends V> gVar, Executor executor) {
        return (a0) Futures.c(this, cls, gVar, executor);
    }

    public final <T> a0<T> transform(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.d<? super V, T> dVar, Executor executor) {
        return (a0) Futures.g(this, dVar, executor);
    }

    public final <T> a0<T> transformAsync(g<? super V, T> gVar, Executor executor) {
        return (a0) Futures.h(this, gVar, executor);
    }

    public final a0<V> withTimeout(long j11, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        return (a0) Futures.i(this, j11, timeUnit, scheduledExecutorService);
    }
}
