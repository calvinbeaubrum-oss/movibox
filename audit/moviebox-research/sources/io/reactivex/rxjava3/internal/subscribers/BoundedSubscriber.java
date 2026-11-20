package io.reactivex.rxjava3.internal.subscribers;

import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class BoundedSubscriber<T> extends AtomicReference<u30.d> implements io.reactivex.rxjava3.core.f<T>, u30.d, h10.b {
    private static final long serialVersionUID = -7251123623727029452L;
    final int bufferSize;
    int consumed;
    final int limit;
    final k10.a onComplete;
    final k10.f<? super Throwable> onError;
    final k10.f<? super T> onNext;
    final k10.f<? super u30.d> onSubscribe;

    public BoundedSubscriber(k10.f<? super T> fVar, k10.f<? super Throwable> fVar2, k10.a aVar, k10.f<? super u30.d> fVar3, int i11) {
        this.onNext = fVar;
        this.onError = fVar2;
        this.onComplete = aVar;
        this.onSubscribe = fVar3;
        this.bufferSize = i11;
        this.limit = i11 - (i11 >> 2);
    }

    @Override // u30.d
    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    @Override // h10.b
    public void dispose() {
        cancel();
    }

    public boolean hasCustomOnError() {
        return this.onError != Functions.f67331f;
    }

    @Override // h10.b
    public boolean isDisposed() {
        return get() == SubscriptionHelper.CANCELLED;
    }

    @Override // u30.c
    public void onComplete() {
        u30.d dVar = get();
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (dVar != subscriptionHelper) {
            lazySet(subscriptionHelper);
            try {
                this.onComplete.run();
            } catch (Throwable th2) {
                i10.a.b(th2);
                p10.a.q(th2);
            }
        }
    }

    @Override // u30.c
    public void onError(Throwable th2) {
        u30.d dVar = get();
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (dVar == subscriptionHelper) {
            p10.a.q(th2);
            return;
        }
        lazySet(subscriptionHelper);
        try {
            this.onError.accept(th2);
        } catch (Throwable th3) {
            i10.a.b(th3);
            p10.a.q(new CompositeException(th2, th3));
        }
    }

    @Override // u30.c
    public void onNext(T t11) {
        if (isDisposed()) {
            return;
        }
        try {
            this.onNext.accept(t11);
            int i11 = this.consumed + 1;
            if (i11 == this.limit) {
                this.consumed = 0;
                get().request(this.limit);
            } else {
                this.consumed = i11;
            }
        } catch (Throwable th2) {
            i10.a.b(th2);
            get().cancel();
            onError(th2);
        }
    }

    @Override // u30.c
    public void onSubscribe(u30.d dVar) {
        if (SubscriptionHelper.setOnce(this, dVar)) {
            try {
                this.onSubscribe.accept(this);
            } catch (Throwable th2) {
                i10.a.b(th2);
                dVar.cancel();
                onError(th2);
            }
        }
    }

    @Override // u30.d
    public void request(long j11) {
        get().request(j11);
    }
}
