package io.reactivex.rxjava3.internal.operators.flowable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class FlowableOnBackpressureLatest<T> extends a<T, T> {

    /* JADX INFO: compiled from: source.java */
    public static final class BackpressureLatestSubscriber<T> extends AbstractBackpressureThrottlingSubscriber<T, T> {
        private static final long serialVersionUID = 163080509307634843L;

        public BackpressureLatestSubscriber(u30.c<? super T> cVar) {
            super(cVar);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // io.reactivex.rxjava3.internal.operators.flowable.AbstractBackpressureThrottlingSubscriber, u30.c
        public void onNext(T t11) {
            this.current.lazySet((R) t11);
            drain();
        }
    }

    public FlowableOnBackpressureLatest(io.reactivex.rxjava3.core.e<T> eVar) {
        super(eVar);
    }

    @Override // io.reactivex.rxjava3.core.e
    public void g(u30.c<? super T> cVar) {
        this.f67370b.f(new BackpressureLatestSubscriber(cVar));
    }
}
