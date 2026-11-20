package io.reactivex.rxjava3.internal.observers;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class BasicIntQueueDisposable<T> extends AtomicInteger implements m10.b<T> {
    private static final long serialVersionUID = -1001730202384742097L;

    @Override // m10.g
    public abstract /* synthetic */ void clear();

    @Override // h10.b
    public abstract /* synthetic */ void dispose();

    @Override // h10.b
    public abstract /* synthetic */ boolean isDisposed();

    @Override // m10.g
    public abstract /* synthetic */ boolean isEmpty();

    @Override // m10.g
    public final boolean offer(T t11) {
        throw new UnsupportedOperationException("Should not be called");
    }

    public final boolean offer(T t11, T t12) {
        throw new UnsupportedOperationException("Should not be called");
    }

    @Override // m10.g
    public abstract /* synthetic */ Object poll() throws Throwable;

    @Override // m10.c
    public abstract /* synthetic */ int requestFusion(int i11);
}
