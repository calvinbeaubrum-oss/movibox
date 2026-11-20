package io.reactivex.rxjava3.internal.subscribers;

import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public abstract class DeferredScalarSubscriber<T, R> extends DeferredScalarSubscription<R> implements io.reactivex.rxjava3.core.f<T> {
    private static final long serialVersionUID = 2984505488220891551L;
    protected boolean hasValue;
    protected u30.d upstream;

    public DeferredScalarSubscriber(u30.c<? super R> cVar) {
        super(cVar);
    }

    @Override // io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription, io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription, u30.d
    public void cancel() {
        super.cancel();
        this.upstream.cancel();
    }

    @Override // u30.c
    public void onComplete() {
        if (this.hasValue) {
            complete(this.value);
        } else {
            this.downstream.onComplete();
        }
    }

    @Override // u30.c
    public void onError(Throwable th2) {
        this.value = null;
        this.downstream.onError(th2);
    }

    @Override // u30.c
    public abstract /* synthetic */ void onNext(Object obj);

    @Override // u30.c
    public void onSubscribe(u30.d dVar) {
        if (SubscriptionHelper.validate(this.upstream, dVar)) {
            this.upstream = dVar;
            this.downstream.onSubscribe(this);
            dVar.request(Long.MAX_VALUE);
        }
    }
}
