package io.reactivex.rxjava3.internal.subscribers;

import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.i;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class InnerQueuedSubscriber<T> extends AtomicReference<u30.d> implements io.reactivex.rxjava3.core.f<T>, u30.d {
    private static final long serialVersionUID = 22876611072430776L;
    volatile boolean done;
    int fusionMode;
    final int limit;
    final a<T> parent;
    final int prefetch;
    long produced;
    volatile m10.g<T> queue;

    public InnerQueuedSubscriber(a<T> aVar, int i11) {
        this.prefetch = i11;
        this.limit = i11 - (i11 >> 2);
    }

    @Override // u30.d
    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    public boolean isDone() {
        return this.done;
    }

    @Override // u30.c
    public void onComplete() {
        throw null;
    }

    @Override // u30.c
    public void onError(Throwable th2) {
        throw null;
    }

    @Override // u30.c
    public void onNext(T t11) {
        if (this.fusionMode != 0) {
            throw null;
        }
        throw null;
    }

    @Override // u30.c
    public void onSubscribe(u30.d dVar) {
        if (SubscriptionHelper.setOnce(this, dVar)) {
            if (dVar instanceof m10.d) {
                m10.d dVar2 = (m10.d) dVar;
                int iRequestFusion = dVar2.requestFusion(3);
                if (iRequestFusion == 1) {
                    this.fusionMode = iRequestFusion;
                    this.queue = dVar2;
                    this.done = true;
                    throw null;
                }
                if (iRequestFusion == 2) {
                    this.fusionMode = iRequestFusion;
                    this.queue = dVar2;
                    i.f(dVar, this.prefetch);
                    return;
                }
            }
            this.queue = i.c(this.prefetch);
            i.f(dVar, this.prefetch);
        }
    }

    public m10.g<T> queue() {
        return this.queue;
    }

    @Override // u30.d
    public void request(long j11) {
        if (this.fusionMode != 1) {
            long j12 = this.produced + j11;
            if (j12 < this.limit) {
                this.produced = j12;
            } else {
                this.produced = 0L;
                get().request(j12);
            }
        }
    }

    public void setDone() {
        this.done = true;
    }
}
