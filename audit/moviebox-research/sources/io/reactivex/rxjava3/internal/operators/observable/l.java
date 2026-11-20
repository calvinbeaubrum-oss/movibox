package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class l<T> extends io.reactivex.rxjava3.core.g<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.rxjava3.core.m<T> f67441a;

    /* JADX INFO: compiled from: source.java */
    public static final class a<T> implements io.reactivex.rxjava3.core.o<T>, h10.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final io.reactivex.rxjava3.core.h<? super T> f67442a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public h10.b f67443b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public T f67444c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f67445d;

        public a(io.reactivex.rxjava3.core.h<? super T> hVar) {
            this.f67442a = hVar;
        }

        @Override // h10.b
        public void dispose() {
            this.f67443b.dispose();
        }

        @Override // h10.b
        public boolean isDisposed() {
            return this.f67443b.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onComplete() {
            if (this.f67445d) {
                return;
            }
            this.f67445d = true;
            T t11 = this.f67444c;
            this.f67444c = null;
            if (t11 == null) {
                this.f67442a.onComplete();
            } else {
                this.f67442a.onSuccess(t11);
            }
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onError(Throwable th2) {
            if (this.f67445d) {
                p10.a.q(th2);
            } else {
                this.f67445d = true;
                this.f67442a.onError(th2);
            }
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onNext(T t11) {
            if (this.f67445d) {
                return;
            }
            if (this.f67444c == null) {
                this.f67444c = t11;
                return;
            }
            this.f67445d = true;
            this.f67443b.dispose();
            this.f67442a.onError(new IllegalArgumentException("Sequence contains more than one element!"));
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onSubscribe(h10.b bVar) {
            if (DisposableHelper.validate(this.f67443b, bVar)) {
                this.f67443b = bVar;
                this.f67442a.onSubscribe(this);
            }
        }
    }

    public l(io.reactivex.rxjava3.core.m<T> mVar) {
        this.f67441a = mVar;
    }

    @Override // io.reactivex.rxjava3.core.g
    public void b(io.reactivex.rxjava3.core.h<? super T> hVar) {
        this.f67441a.subscribe(new a(hVar));
    }
}
