package io.reactivex.rxjava3.internal.subscribers;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class SubscriberResourceWrapper<T> extends AtomicReference<h10.b> implements io.reactivex.rxjava3.core.f<T>, h10.b, u30.d {
    private static final long serialVersionUID = -8612022020200669122L;
    final u30.c<? super T> downstream;
    final AtomicReference<u30.d> upstream = new AtomicReference<>();

    public SubscriberResourceWrapper(u30.c<? super T> cVar) {
        this.downstream = cVar;
    }

    @Override // u30.d
    public void cancel() {
        dispose();
    }

    @Override // h10.b
    public void dispose() {
        SubscriptionHelper.cancel(this.upstream);
        DisposableHelper.dispose(this);
    }

    @Override // h10.b
    public boolean isDisposed() {
        return this.upstream.get() == SubscriptionHelper.CANCELLED;
    }

    @Override // u30.c
    public void onComplete() {
        DisposableHelper.dispose(this);
        this.downstream.onComplete();
    }

    @Override // u30.c
    public void onError(Throwable th2) {
        DisposableHelper.dispose(this);
        this.downstream.onError(th2);
    }

    @Override // u30.c
    public void onNext(T t11) {
        this.downstream.onNext(t11);
    }

    @Override // u30.c
    public void onSubscribe(u30.d dVar) {
        if (SubscriptionHelper.setOnce(this.upstream, dVar)) {
            this.downstream.onSubscribe(this);
        }
    }

    @Override // u30.d
    public void request(long j11) {
        if (SubscriptionHelper.validate(j11)) {
            this.upstream.get().request(j11);
        }
    }

    public void setResource(h10.b bVar) {
        DisposableHelper.set(this, bVar);
    }
}
