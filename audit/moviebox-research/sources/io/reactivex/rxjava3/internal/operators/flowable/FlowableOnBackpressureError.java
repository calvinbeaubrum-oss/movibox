package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class FlowableOnBackpressureError<T> extends a<T, T> {

    /* JADX INFO: compiled from: source.java */
    public static final class BackpressureErrorSubscriber<T> extends AtomicLong implements io.reactivex.rxjava3.core.f<T>, u30.d {
        private static final long serialVersionUID = -3176480756392482682L;
        boolean done;
        final u30.c<? super T> downstream;
        u30.d upstream;

        public BackpressureErrorSubscriber(u30.c<? super T> cVar) {
            this.downstream = cVar;
        }

        @Override // u30.d
        public void cancel() {
            this.upstream.cancel();
        }

        @Override // u30.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.downstream.onComplete();
        }

        @Override // u30.c
        public void onError(Throwable th2) {
            if (this.done) {
                p10.a.q(th2);
            } else {
                this.done = true;
                this.downstream.onError(th2);
            }
        }

        @Override // u30.c
        public void onNext(T t11) {
            if (this.done) {
                return;
            }
            if (get() != 0) {
                this.downstream.onNext(t11);
                io.reactivex.rxjava3.internal.util.a.d(this, 1L);
            } else {
                this.upstream.cancel();
                onError(new MissingBackpressureException("could not emit value due to lack of requests"));
            }
        }

        @Override // u30.c
        public void onSubscribe(u30.d dVar) {
            if (SubscriptionHelper.validate(this.upstream, dVar)) {
                this.upstream = dVar;
                this.downstream.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }

        @Override // u30.d
        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                io.reactivex.rxjava3.internal.util.a.a(this, j11);
            }
        }
    }

    public FlowableOnBackpressureError(io.reactivex.rxjava3.core.e<T> eVar) {
        super(eVar);
    }

    @Override // io.reactivex.rxjava3.core.e
    public void g(u30.c<? super T> cVar) {
        this.f67370b.f(new BackpressureErrorSubscriber(cVar));
    }
}
