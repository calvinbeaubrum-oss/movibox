package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class g0<V> extends a0<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f40007a = Logger.getLogger(g0.class.getName());

    /* JADX INFO: compiled from: source.java */
    public static final class a<V> extends AbstractFuture.g<V> {
        public a(Throwable th2) {
            setException(th2);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b<V> extends g0<V> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b<Object> f40008c = new b<>(null);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final V f40009b;

        public b(V v11) {
            this.f40009b = v11;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.g0, java.util.concurrent.Future
        public V get() {
            return this.f40009b;
        }

        public String toString() {
            return super.toString() + "[status=SUCCESS, result=[" + this.f40009b + "]]";
        }
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.i0
    public void addListener(Runnable runnable, Executor executor) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.o(runnable, "Runnable was null.");
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.o(executor, "Executor was null.");
        try {
            executor.execute(runnable);
        } catch (RuntimeException e11) {
            f40007a.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e11);
        }
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z11) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public abstract V get() throws ExecutionException;

    @Override // java.util.concurrent.Future
    public V get(long j11, TimeUnit timeUnit) throws ExecutionException {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(timeUnit);
        return get();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return true;
    }
}
