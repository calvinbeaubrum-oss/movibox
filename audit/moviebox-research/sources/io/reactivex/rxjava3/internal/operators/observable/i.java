package io.reactivex.rxjava3.internal.operators.observable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class i<T> extends io.reactivex.rxjava3.core.j<T> implements m10.e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f67432a;

    public i(T t11) {
        this.f67432a = t11;
    }

    @Override // m10.e, k10.k
    public T get() {
        return this.f67432a;
    }

    @Override // io.reactivex.rxjava3.core.j
    public void z(io.reactivex.rxjava3.core.o<? super T> oVar) {
        ObservableScalarXMap.ScalarDisposable scalarDisposable = new ObservableScalarXMap.ScalarDisposable(oVar, this.f67432a);
        oVar.onSubscribe(scalarDisposable);
        scalarDisposable.run();
    }
}
