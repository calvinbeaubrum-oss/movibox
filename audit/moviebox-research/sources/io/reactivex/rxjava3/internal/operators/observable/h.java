package io.reactivex.rxjava3.internal.operators.observable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class h<T> extends io.reactivex.rxjava3.core.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.rxjava3.core.m<T> f67429a;

    /* JADX INFO: compiled from: source.java */
    public static final class a<T> implements io.reactivex.rxjava3.core.o<T>, h10.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final io.reactivex.rxjava3.core.b f67430a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public h10.b f67431b;

        public a(io.reactivex.rxjava3.core.b bVar) {
            this.f67430a = bVar;
        }

        @Override // h10.b
        public void dispose() {
            this.f67431b.dispose();
        }

        @Override // h10.b
        public boolean isDisposed() {
            return this.f67431b.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onComplete() {
            this.f67430a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onError(Throwable th2) {
            this.f67430a.onError(th2);
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onNext(T t11) {
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onSubscribe(h10.b bVar) {
            this.f67431b = bVar;
            this.f67430a.onSubscribe(this);
        }
    }

    public h(io.reactivex.rxjava3.core.m<T> mVar) {
        this.f67429a = mVar;
    }

    @Override // io.reactivex.rxjava3.core.a
    public void b(io.reactivex.rxjava3.core.b bVar) {
        this.f67429a.subscribe(new a(bVar));
    }
}
