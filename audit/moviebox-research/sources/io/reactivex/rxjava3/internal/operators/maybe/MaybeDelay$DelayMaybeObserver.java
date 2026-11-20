package io.reactivex.rxjava3.internal.operators.maybe;

import h10.b;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.h;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
final class MaybeDelay$DelayMaybeObserver<T> extends AtomicReference<b> implements h<T>, b, Runnable {
    private static final long serialVersionUID = 5566860102500855068L;
    final long delay;
    final boolean delayError;
    final h<? super T> downstream;
    Throwable error;
    final Scheduler scheduler;
    final TimeUnit unit;
    T value;

    public MaybeDelay$DelayMaybeObserver(h<? super T> hVar, long j11, TimeUnit timeUnit, Scheduler scheduler, boolean z11) {
        this.downstream = hVar;
        this.delay = j11;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.delayError = z11;
    }

    @Override // h10.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // h10.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // io.reactivex.rxjava3.core.h
    public void onComplete() {
        schedule(this.delay);
    }

    @Override // io.reactivex.rxjava3.core.h
    public void onError(Throwable th2) {
        this.error = th2;
        schedule(this.delayError ? this.delay : 0L);
    }

    @Override // io.reactivex.rxjava3.core.h
    public void onSubscribe(b bVar) {
        if (DisposableHelper.setOnce(this, bVar)) {
            this.downstream.onSubscribe(this);
        }
    }

    @Override // io.reactivex.rxjava3.core.h
    public void onSuccess(T t11) {
        this.value = t11;
        schedule(this.delay);
    }

    @Override // java.lang.Runnable
    public void run() {
        Throwable th2 = this.error;
        if (th2 != null) {
            this.downstream.onError(th2);
            return;
        }
        T t11 = this.value;
        if (t11 != null) {
            this.downstream.onSuccess(t11);
        } else {
            this.downstream.onComplete();
        }
    }

    public void schedule(long j11) {
        DisposableHelper.replace(this, this.scheduler.e(this, j11, this.unit));
    }
}
