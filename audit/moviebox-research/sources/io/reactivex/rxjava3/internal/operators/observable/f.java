package io.reactivex.rxjava3.internal.operators.observable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class f<T> extends io.reactivex.rxjava3.core.j<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.rxjava3.core.m<T> f67427a;

    public f(io.reactivex.rxjava3.core.m<T> mVar) {
        this.f67427a = mVar;
    }

    @Override // io.reactivex.rxjava3.core.j
    public void z(io.reactivex.rxjava3.core.o<? super T> oVar) {
        this.f67427a.subscribe(oVar);
    }
}
