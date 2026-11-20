package com.google.common.util.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class m<V> extends com.google.common.collect.x implements Future<V> {
    public boolean cancel(boolean z11) {
        return u().cancel(z11);
    }

    @Override // java.util.concurrent.Future
    public V get() throws ExecutionException, InterruptedException {
        return u().get();
    }

    @Override // java.util.concurrent.Future
    public V get(long j11, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return u().get(j11, timeUnit);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return u().isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return u().isDone();
    }

    public abstract Future<? extends V> u();
}
