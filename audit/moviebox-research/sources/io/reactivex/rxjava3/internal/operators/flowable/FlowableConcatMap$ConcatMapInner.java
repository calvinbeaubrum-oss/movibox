package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.internal.subscriptions.SubscriptionArbiter;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
final class FlowableConcatMap$ConcatMapInner<R> extends SubscriptionArbiter implements io.reactivex.rxjava3.core.f<R> {
    private static final long serialVersionUID = 897683679971470653L;
    final b<R> parent;
    long produced;

    public FlowableConcatMap$ConcatMapInner(b<R> bVar) {
        super(false);
        this.parent = bVar;
    }

    @Override // u30.c
    public void onComplete() {
        long j11 = this.produced;
        if (j11 != 0) {
            this.produced = 0L;
            produced(j11);
        }
        this.parent.innerComplete();
    }

    @Override // u30.c
    public void onError(Throwable th2) {
        long j11 = this.produced;
        if (j11 != 0) {
            this.produced = 0L;
            produced(j11);
        }
        this.parent.innerError(th2);
    }

    @Override // u30.c
    public void onNext(R r11) {
        this.produced++;
        this.parent.innerNext(r11);
    }

    @Override // u30.c
    public void onSubscribe(u30.d dVar) {
        setSubscription(dVar);
    }
}
