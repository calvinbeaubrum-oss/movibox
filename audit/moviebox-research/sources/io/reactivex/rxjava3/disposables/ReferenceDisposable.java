package io.reactivex.rxjava3.disposables;

import h10.b;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
abstract class ReferenceDisposable<T> extends AtomicReference<T> implements b {
    private static final long serialVersionUID = 6537757548749041217L;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReferenceDisposable(T t11) {
        super(t11);
        Objects.requireNonNull(t11, "value is null");
    }

    @Override // h10.b
    public final void dispose() {
        T andSet;
        if (get() == null || (andSet = getAndSet(null)) == null) {
            return;
        }
        onDisposed(andSet);
    }

    @Override // h10.b
    public final boolean isDisposed() {
        return get() == null;
    }

    public abstract void onDisposed(T t11);
}
