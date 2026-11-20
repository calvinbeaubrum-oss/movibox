package io.reactivex.rxjava3.internal.operators.single;

import h10.b;
import io.reactivex.rxjava3.core.q;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
final class SingleTimer$TimerDisposable extends AtomicReference<b> implements b, Runnable {
    private static final long serialVersionUID = 8465401857522493082L;
    final q<? super Long> downstream;

    public SingleTimer$TimerDisposable(q<? super Long> qVar) {
        this.downstream = qVar;
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
