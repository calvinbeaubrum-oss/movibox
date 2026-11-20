package io.reactivex.rxjava3.internal.operators.observable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class g<K, T> extends n10.a<K, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ObservableGroupBy$State<T, K> f67428b;

    public g(K k11, ObservableGroupBy$State<T, K> observableGroupBy$State) {
        super(k11);
        this.f67428b = observableGroupBy$State;
    }

    public static <T, K> g<K, T> F(K k11, int i11, ObservableGroupBy$GroupByObserver<?, K, T> observableGroupBy$GroupByObserver, boolean z11) {
        return new g<>(k11, new ObservableGroupBy$State(i11, observableGroupBy$GroupByObserver, k11, z11));
    }

    public void onComplete() {
        this.f67428b.onComplete();
    }

    public void onError(Throwable th2) {
        this.f67428b.onError(th2);
    }

    public void onNext(T t11) {
        this.f67428b.onNext(t11);
    }

    @Override // io.reactivex.rxjava3.core.j
    public void z(io.reactivex.rxjava3.core.o<? super T> oVar) {
        this.f67428b.subscribe(oVar);
    }
}
