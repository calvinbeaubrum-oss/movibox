package io.reactivex.rxjava3.internal.subscribers;

import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import k10.j;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class ForEachWhileSubscriber<T> extends AtomicReference<u30.d> implements io.reactivex.rxjava3.core.f<T>, h10.b {
    private static final long serialVersionUID = -4403180040475402120L;
    boolean done;
    final k10.a onComplete;
    final k10.f<? super Throwable> onError;
    final j<? super T> onNext;

    public ForEachWhileSubscriber(j<? super T> jVar, k10.f<? super Throwable> fVar, k10.a aVar) {
        this.onNext = jVar;
        this.onError = fVar;
        this.onComplete = aVar;
    }

    @Override // h10.b
    public void dispose() {
        SubscriptionHelper.cancel(this);
    }

    @Override // h10.b
    public boolean isDisposed() {
        return get() == SubscriptionHelper.CANCELLED;
    }

    @Override // u30.c
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        try {
            this.onComplete.run();
        } catch (Throwable th2) {
            i10.a.b(th2);
            p10.a.q(th2);
        }
    }

    @Override // u30.c
    public void onError(Throwable th2) {
        if (this.done) {
            p10.a.q(th2);
            return;
        }
        this.done = true;
        try {
            this.onError.accept(th2);
        } catch (Throwable th3) {
            i10.a.b(th3);
            p10.a.q(new CompositeException(th2, th3));
        }
    }

    @Override // u30.c
    public void onNext(T t11) {
        if (this.done) {
            return;
        }
        try {
            if (this.onNext.test(t11)) {
                return;
            }
            dispose();
            onComplete();
        } catch (Throwable th2) {
            i10.a.b(th2);
            dispose();
            onError(th2);
        }
    }

    @Override // u30.c
    public void onSubscribe(u30.d dVar) {
        SubscriptionHelper.setOnce(this, dVar, Long.MAX_VALUE);
    }
}
