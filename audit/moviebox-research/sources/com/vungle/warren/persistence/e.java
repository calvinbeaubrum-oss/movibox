package com.vungle.warren.persistence;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class e<T> implements Future<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f62323b = "e";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Future<T> f62324a;

    public e(Future<T> future) {
        this.f62324a = future;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z11) {
        return this.f62324a.cancel(z11);
    }

    @Override // java.util.concurrent.Future
    @Nullable
    public T get() {
        try {
            return this.f62324a.get();
        } catch (InterruptedException unused) {
            Log.w(f62323b, "future.get() Interrupted on Thread " + Thread.currentThread().getName());
            Thread.currentThread().interrupt();
            return null;
        } catch (ExecutionException e11) {
            Log.e(f62323b, "error on execution", e11);
            return null;
        }
    }

    @Override // java.util.concurrent.Future
    @Nullable
    public T get(long j11, @NonNull TimeUnit timeUnit) {
        try {
            return this.f62324a.get(j11, timeUnit);
        } catch (InterruptedException unused) {
            Log.w(f62323b, "future.get() Interrupted on Thread " + Thread.currentThread().getName());
            Thread.currentThread().interrupt();
            return null;
        } catch (ExecutionException e11) {
            Log.e(f62323b, "error on execution", e11);
            return null;
        } catch (TimeoutException unused2) {
            Log.w(f62323b, "future.get() Timeout on Thread " + Thread.currentThread().getName());
            return null;
        }
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.f62324a.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.f62324a.isDone();
    }
}
