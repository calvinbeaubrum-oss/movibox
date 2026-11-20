package io.reactivex.rxjava3.internal.operators.completable;

import h10.b;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
final class CompletableDelay$Delay extends AtomicReference<b> implements io.reactivex.rxjava3.core.b, Runnable, b {
    private static final long serialVersionUID = 465972761105851022L;
    final long delay;
    final boolean delayError;
    final io.reactivex.rxjava3.core.b downstream;
    Throwable error;
    final Scheduler scheduler;
    final TimeUnit unit;

    public CompletableDelay$Delay(io.reactivex.rxjava3.core.b bVar, long j11, TimeUnit timeUnit, Scheduler scheduler, boolean z11) {
        this.downstream = bVar;
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

    @Override // io.reactivex.rxjava3.core.b
    public void onComplete() {
        DisposableHelper.replace(this, this.scheduler.e(this, this.delay, this.unit));
    }

    @Override // io.reactivex.rxjava3.core.b
    public void onError(Throwable th2) {
        this.error = th2;
        DisposableHelper.replace(this, this.scheduler.e(this, this.delayError ? this.delay : 0L, this.unit));
    }

    @Override // io.reactivex.rxjava3.core.b
    public void onSubscribe(b bVar) {
        if (DisposableHelper.setOnce(this, bVar)) {
            this.downstream.onSubscribe(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Throwable th2 = this.error;
        this.error = null;
        if (th2 != null) {
            this.downstream.onError(th2);
        } else {
            this.downstream.onComplete();
        }
    }
}
