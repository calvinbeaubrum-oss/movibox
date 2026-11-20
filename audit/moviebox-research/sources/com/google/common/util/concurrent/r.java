package com.google.common.util.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class r<V> implements s<V> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final s<?> f38949b = new r(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f38950c = Logger.getLogger(r.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final V f38951a;

    /* JADX INFO: compiled from: source.java */
    public static final class a<V> extends AbstractFuture.h<V> {
        public a(Throwable th2) {
            setException(th2);
        }
    }

    public r(V v11) {
        this.f38951a = v11;
    }

    @Override // com.google.common.util.concurrent.s
    public void addListener(Runnable runnable, Executor executor) {
        com.google.common.base.m.q(runnable, "Runnable was null.");
        com.google.common.base.m.q(executor, "Executor was null.");
        try {
            executor.execute(runnable);
        } catch (RuntimeException e11) {
            f38950c.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e11);
        }
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z11) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public V get() {
        return this.f38951a;
    }

    @Override // java.util.concurrent.Future
    public V get(long j11, TimeUnit timeUnit) throws ExecutionException {
        com.google.common.base.m.p(timeUnit);
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

    public String toString() {
        return super.toString() + "[status=SUCCESS, result=[" + this.f38951a + "]]";
    }
}
