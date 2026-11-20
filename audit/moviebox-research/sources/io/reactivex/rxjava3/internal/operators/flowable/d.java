package io.reactivex.rxjava3.internal.operators.flowable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class d<K, T> extends j10.a<K, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FlowableGroupBy$State<T, K> f67374c;

    public d(K k11, FlowableGroupBy$State<T, K> flowableGroupBy$State) {
        super(k11);
        this.f67374c = flowableGroupBy$State;
    }

    public static <T, K> d<K, T> h(K k11, int i11, FlowableGroupBy$GroupBySubscriber<?, K, T> flowableGroupBy$GroupBySubscriber, boolean z11) {
        return new d<>(k11, new FlowableGroupBy$State(i11, flowableGroupBy$GroupBySubscriber, k11, z11));
    }

    @Override // io.reactivex.rxjava3.core.e
    public void g(u30.c<? super T> cVar) {
        this.f67374c.subscribe(cVar);
    }

    public void onComplete() {
        this.f67374c.onComplete();
    }

    public void onError(Throwable th2) {
        this.f67374c.onError(th2);
    }

    public void onNext(T t11) {
        this.f67374c.onNext(t11);
    }
}
