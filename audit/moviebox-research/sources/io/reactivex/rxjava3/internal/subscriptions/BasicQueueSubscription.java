package io.reactivex.rxjava3.internal.subscriptions;

import java.util.concurrent.atomic.AtomicLong;
import m10.d;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public abstract class BasicQueueSubscription<T> extends AtomicLong implements d<T> {
    private static final long serialVersionUID = -6671519529404341862L;

    @Override // u30.d
    public abstract /* synthetic */ void cancel();

    @Override // m10.g
    public abstract /* synthetic */ void clear();

    @Override // m10.g
    public abstract /* synthetic */ boolean isEmpty();

    @Override // m10.g
    public final boolean offer(T t11) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public final boolean offer(T t11, T t12) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // m10.g
    public abstract /* synthetic */ Object poll() throws Throwable;

    @Override // u30.d
    public abstract /* synthetic */ void request(long j11);

    @Override // m10.c
    public abstract /* synthetic */ int requestFusion(int i11);
}
