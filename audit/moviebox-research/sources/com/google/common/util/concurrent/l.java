package com.google.common.util.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class l<V> extends k<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s<V> f38947a;

    public l(s<V> sVar) {
        this.f38947a = (s) com.google.common.base.m.p(sVar);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture, com.google.common.util.concurrent.s
    public void addListener(Runnable runnable, Executor executor) {
        this.f38947a.addListener(runnable, executor);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
    public boolean cancel(boolean z11) {
        return this.f38947a.cancel(z11);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
    public V get() throws ExecutionException, InterruptedException {
        return this.f38947a.get();
    }

    @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
    public V get(long j11, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return this.f38947a.get(j11, timeUnit);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
    public boolean isCancelled() {
        return this.f38947a.isCancelled();
    }

    @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
    public boolean isDone() {
        return this.f38947a.isDone();
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public String toString() {
        return this.f38947a.toString();
    }
}
