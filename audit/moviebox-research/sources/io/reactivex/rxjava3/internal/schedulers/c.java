package io.reactivex.rxjava3.internal.schedulers;

import androidx.compose.animation.core.j0;
import io.reactivex.rxjava3.internal.functions.Functions;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class c implements Callable<Void>, h10.b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final FutureTask<Void> f67514g = new FutureTask<>(Functions.f67327b, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f67515a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ExecutorService f67518d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Thread f67519f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference<Future<?>> f67517c = new AtomicReference<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference<Future<?>> f67516b = new AtomicReference<>();

    public c(Runnable runnable, ExecutorService executorService) {
        this.f67515a = runnable;
        this.f67518d = executorService;
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void call() {
        this.f67519f = Thread.currentThread();
        try {
            this.f67515a.run();
            this.f67519f = null;
            c(this.f67518d.submit(this));
            return null;
        } catch (Throwable th2) {
            this.f67519f = null;
            p10.a.q(th2);
            throw th2;
        }
    }

    public void b(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.f67517c.get();
            if (future2 == f67514g) {
                future.cancel(this.f67519f != Thread.currentThread());
                return;
            }
        } while (!j0.a(this.f67517c, future2, future));
    }

    public void c(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.f67516b.get();
            if (future2 == f67514g) {
                future.cancel(this.f67519f != Thread.currentThread());
                return;
            }
        } while (!j0.a(this.f67516b, future2, future));
    }

    @Override // h10.b
    public void dispose() {
        AtomicReference<Future<?>> atomicReference = this.f67517c;
        FutureTask<Void> futureTask = f67514g;
        Future<?> andSet = atomicReference.getAndSet(futureTask);
        if (andSet != null && andSet != futureTask) {
            andSet.cancel(this.f67519f != Thread.currentThread());
        }
        Future<?> andSet2 = this.f67516b.getAndSet(futureTask);
        if (andSet2 == null || andSet2 == futureTask) {
            return;
        }
        andSet2.cancel(this.f67519f != Thread.currentThread());
    }

    @Override // h10.b
    public boolean isDisposed() {
        return this.f67517c.get() == f67514g;
    }
}
