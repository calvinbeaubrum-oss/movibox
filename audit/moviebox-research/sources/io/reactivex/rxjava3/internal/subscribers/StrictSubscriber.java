package io.reactivex.rxjava3.internal.subscribers;

import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class StrictSubscriber<T> extends AtomicInteger implements io.reactivex.rxjava3.core.f<T>, u30.d {
    private static final long serialVersionUID = -4945028590049415624L;
    volatile boolean done;
    final u30.c<? super T> downstream;
    final AtomicThrowable error = new AtomicThrowable();
    final AtomicLong requested = new AtomicLong();
    final AtomicReference<u30.d> upstream = new AtomicReference<>();
    final AtomicBoolean once = new AtomicBoolean();

    public StrictSubscriber(u30.c<? super T> cVar) {
        this.downstream = cVar;
    }

    @Override // u30.d
    public void cancel() {
        if (this.done) {
            return;
        }
        SubscriptionHelper.cancel(this.upstream);
    }

    @Override // u30.c
    public void onComplete() {
        this.done = true;
        io.reactivex.rxjava3.internal.util.d.a(this.downstream, this, this.error);
    }

    @Override // u30.c
    public void onError(Throwable th2) {
        this.done = true;
        io.reactivex.rxjava3.internal.util.d.b(this.downstream, th2, this, this.error);
    }

    @Override // u30.c
    public void onNext(T t11) {
        io.reactivex.rxjava3.internal.util.d.c(this.downstream, t11, this, this.error);
    }

    @Override // u30.c
    public void onSubscribe(u30.d dVar) {
        if (this.once.compareAndSet(false, true)) {
            this.downstream.onSubscribe(this);
            SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, dVar);
        } else {
            dVar.cancel();
            cancel();
            onError(new IllegalStateException("§2.12 violated: onSubscribe must be called at most once"));
        }
    }

    @Override // u30.d
    public void request(long j11) {
        if (j11 > 0) {
            SubscriptionHelper.deferredRequest(this.upstream, this.requested, j11);
            return;
        }
        cancel();
        onError(new IllegalArgumentException("§3.9 violated: positive request amount required but it was " + j11));
    }
}
