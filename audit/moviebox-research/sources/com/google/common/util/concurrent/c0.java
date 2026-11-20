package com.google.common.util.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class c0 {
    public static <V> V a(Future<V> future) throws ExecutionException {
        V v11;
        boolean z11 = false;
        while (true) {
            try {
                v11 = future.get();
                break;
            } catch (InterruptedException unused) {
                z11 = true;
            } catch (Throwable th2) {
                if (z11) {
                    Thread.currentThread().interrupt();
                }
                throw th2;
            }
        }
        if (z11) {
            Thread.currentThread().interrupt();
        }
        return v11;
    }

    public static <V> V b(Future<V> future, long j11, TimeUnit timeUnit) throws ExecutionException, TimeoutException {
        V v11;
        boolean z11 = false;
        try {
            long nanos = timeUnit.toNanos(j11);
            long jNanoTime = System.nanoTime() + nanos;
            while (true) {
                try {
                    v11 = future.get(nanos, TimeUnit.NANOSECONDS);
                    break;
                } catch (InterruptedException unused) {
                    z11 = true;
                    nanos = jNanoTime - System.nanoTime();
                }
            }
            if (z11) {
                Thread.currentThread().interrupt();
            }
            return v11;
        } catch (Throwable th2) {
            if (z11) {
                Thread.currentThread().interrupt();
            }
            throw th2;
        }
    }
}
