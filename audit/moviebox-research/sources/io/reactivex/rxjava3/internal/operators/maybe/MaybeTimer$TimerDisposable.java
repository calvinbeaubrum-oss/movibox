package io.reactivex.rxjava3.internal.operators.maybe;

import h10.b;
import io.reactivex.rxjava3.core.h;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
final class MaybeTimer$TimerDisposable extends AtomicReference<b> implements b, Runnable {
    private static final long serialVersionUID = 2875964065294031672L;
    final h<? super Long> downstream;

    public MaybeTimer$TimerDisposable(h<? super Long> hVar) {
        this.downstream = hVar;
    }

    @Override // h10.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // h10.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // java.lang.Runnable
    public void run() {
        this.downstream.onSuccess(0L);
    }

    public void setFuture(b bVar) {
        DisposableHelper.replace(this, bVar);
    }
}
