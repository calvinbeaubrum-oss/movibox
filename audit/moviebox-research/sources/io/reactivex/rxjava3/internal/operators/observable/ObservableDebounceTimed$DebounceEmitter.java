package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
final class ObservableDebounceTimed$DebounceEmitter<T> extends AtomicReference<h10.b> implements Runnable, h10.b {
    private static final long serialVersionUID = 6812032969491025141L;
    final long idx;
    final AtomicBoolean once = new AtomicBoolean();
    final b<T> parent;
    final T value;

    public ObservableDebounceTimed$DebounceEmitter(T t11, long j11, b<T> bVar) {
        this.value = t11;
        this.idx = j11;
    }

    @Override // h10.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // h10.b
    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.once.compareAndSet(false, true)) {
            throw null;
        }
    }

    public void setResource(h10.b bVar) {
        DisposableHelper.replace(this, bVar);
    }
}
