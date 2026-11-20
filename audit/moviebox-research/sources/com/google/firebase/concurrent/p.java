package com.google.firebase.concurrent;

import android.annotation.SuppressLint;
import androidx.concurrent.futures.AbstractResolvableFuture;
import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
@SuppressLint({"RestrictedApi"})
public class p<V> extends AbstractResolvableFuture<V> implements ScheduledFuture<V> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ScheduledFuture<?> f39023i;

    /* JADX INFO: compiled from: source.java */
    public class a implements b<V> {
        public a() {
        }

        @Override // com.google.firebase.concurrent.p.b
        public void a(Throwable th2) {
            p.this.w(th2);
        }

        @Override // com.google.firebase.concurrent.p.b
        public void set(V v11) {
            p.this.v(v11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b<T> {
        void a(Throwable th2);

        void set(T t11);
    }

    /* JADX INFO: compiled from: source.java */
    public interface c<T> {
        ScheduledFuture<?> a(b<T> bVar);
    }

    public p(c<V> cVar) {
        this.f39023i = cVar.a(new a());
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public int compareTo(Delayed delayed) {
        return this.f39023i.compareTo(delayed);
    }

    @Override // androidx.concurrent.futures.AbstractResolvableFuture
    public void c() {
        this.f39023i.cancel(y());
    }

    @Override // java.util.concurrent.Delayed
    public long getDelay(TimeUnit timeUnit) {
        return this.f39023i.getDelay(timeUnit);
    }
}
