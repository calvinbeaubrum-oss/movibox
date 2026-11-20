package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class b0<V> extends a0<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i0<V> f39977a;

    public b0(i0<V> i0Var) {
        this.f39977a = (i0) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(i0Var);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.i0
    public void addListener(Runnable runnable, Executor executor) {
        this.f39977a.addListener(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z11) {
        return this.f39977a.cancel(z11);
    }

    @Override // java.util.concurrent.Future
    public V get() throws ExecutionException, InterruptedException {
        return this.f39977a.get();
    }

    @Override // java.util.concurrent.Future
    public V get(long j11, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return this.f39977a.get(j11, timeUnit);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.f39977a.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.f39977a.isDone();
    }
}
