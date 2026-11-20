package io.reactivex.rxjava3.internal.subscriptions;

import h10.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import u30.d;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class AsyncSubscription extends AtomicLong implements d, b {
    private static final long serialVersionUID = 7028635084060361255L;
    final AtomicReference<d> actual;
    final AtomicReference<b> resource;

    public AsyncSubscription() {
        this.resource = new AtomicReference<>();
        this.actual = new AtomicReference<>();
    }

    public AsyncSubscription(b bVar) {
        this();
        this.resource.lazySet(bVar);
    }

    @Override // u30.d
    public void cancel() {
        dispose();
    }

    @Override // h10.b
    public void dispose() {
        SubscriptionHelper.cancel(this.actual);
        DisposableHelper.dispose(this.resource);
    }

    @Override // h10.b
    public boolean isDisposed() {
        return this.actual.get() == SubscriptionHelper.CANCELLED;
    }

    public boolean replaceResource(b bVar) {
        return DisposableHelper.replace(this.resource, bVar);
    }

    @Override // u30.d
    public void request(long j11) {
        SubscriptionHelper.deferredRequest(this.actual, this, j11);
    }

    public boolean setResource(b bVar) {
        return DisposableHelper.set(this.resource, bVar);
    }

    public void setSubscription(d dVar) {
        SubscriptionHelper.deferredSetOnce(this.actual, this, dVar);
    }
}
