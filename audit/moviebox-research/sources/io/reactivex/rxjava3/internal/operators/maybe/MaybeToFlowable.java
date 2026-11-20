package io.reactivex.rxjava3.internal.operators.maybe;

import h10.b;
import io.reactivex.rxjava3.core.e;
import io.reactivex.rxjava3.core.h;
import io.reactivex.rxjava3.core.i;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import u30.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class MaybeToFlowable<T> extends e<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i<T> f67379b;

    /* JADX INFO: compiled from: source.java */
    public static final class MaybeToFlowableSubscriber<T> extends DeferredScalarSubscription<T> implements h<T> {
        private static final long serialVersionUID = 7603343402964826922L;
        b upstream;

        public MaybeToFlowableSubscriber(c<? super T> cVar) {
            super(cVar);
        }

        @Override // io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription, io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription, u30.d
        public void cancel() {
            super.cancel();
            this.upstream.dispose();
        }

        @Override // io.reactivex.rxjava3.core.h
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.h
        public void onError(Throwable th2) {
            this.downstream.onError(th2);
        }

        @Override // io.reactivex.rxjava3.core.h
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.rxjava3.core.h
        public void onSuccess(T t11) {
            complete(t11);
        }
    }

    public MaybeToFlowable(i<T> iVar) {
        this.f67379b = iVar;
    }

    @Override // io.reactivex.rxjava3.core.e
    public void g(c<? super T> cVar) {
        this.f67379b.a(new MaybeToFlowableSubscriber(cVar));
    }
}
