package io.reactivex.rxjava3.internal.operators.observable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class o<T, B> extends o10.a<B> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ObservableWindowBoundary$WindowBoundaryMainObserver<T, B> f67453b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f67454c;

    public o(ObservableWindowBoundary$WindowBoundaryMainObserver<T, B> observableWindowBoundary$WindowBoundaryMainObserver) {
        this.f67453b = observableWindowBoundary$WindowBoundaryMainObserver;
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onComplete() {
        if (this.f67454c) {
            return;
        }
        this.f67454c = true;
        this.f67453b.innerComplete();
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onError(Throwable th2) {
        if (this.f67454c) {
            p10.a.q(th2);
        } else {
            this.f67454c = true;
            this.f67453b.innerError(th2);
        }
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onNext(B b11) {
        if (this.f67454c) {
            return;
        }
        this.f67453b.innerNext();
    }
}
