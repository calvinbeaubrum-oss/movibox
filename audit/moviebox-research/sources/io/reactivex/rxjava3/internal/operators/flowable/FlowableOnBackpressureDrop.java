package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class FlowableOnBackpressureDrop<T> extends a<T, T> implements k10.f<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k10.f<? super T> f67363c;

    /* JADX INFO: compiled from: source.java */
    public static final class BackpressureDropSubscriber<T> extends AtomicLong implements io.reactivex.rxjava3.core.f<T>, u30.d {
        private static final long serialVersionUID = -6246093802440953054L;
        boolean done;
        final u30.c<? super T> downstream;
        final k10.f<? super T> onDrop;
        u30.d upstream;

        public BackpressureDropSubscriber(u30.c<? super T> cVar, k10.f<? super T> fVar) {
            this.downstream = cVar;
            this.onDrop = fVar;
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
                return;
            }
            try {
                this.onDrop.accept(t11);
            } catch (Throwable th2) {
                i10.a.b(th2);
                cancel();
                onError(th2);
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

    public FlowableOnBackpressureDrop(io.reactivex.rxjava3.core.e<T> eVar) {
        super(eVar);
        this.f67363c = this;
    }

    @Override // k10.f
    public void accept(T t11) {
    }

    @Override // io.reactivex.rxjava3.core.e
    public void g(u30.c<? super T> cVar) {
        this.f67370b.f(new BackpressureDropSubscriber(cVar, this.f67363c));
    }
}
