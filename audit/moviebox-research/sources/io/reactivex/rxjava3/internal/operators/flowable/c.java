package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.m;
import io.reactivex.rxjava3.core.o;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class c<T> extends io.reactivex.rxjava3.core.e<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m<T> f67371b;

    /* JADX INFO: compiled from: source.java */
    public static final class a<T> implements o<T>, u30.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final u30.c<? super T> f67372a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public h10.b f67373b;

        public a(u30.c<? super T> cVar) {
            this.f67372a = cVar;
        }

        @Override // u30.d
        public void cancel() {
            this.f67373b.dispose();
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onComplete() {
            this.f67372a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onError(Throwable th2) {
            this.f67372a.onError(th2);
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onNext(T t11) {
            this.f67372a.onNext(t11);
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onSubscribe(h10.b bVar) {
            this.f67373b = bVar;
            this.f67372a.onSubscribe(this);
        }

        @Override // u30.d
        public void request(long j11) {
        }
    }

    public c(m<T> mVar) {
        this.f67371b = mVar;
    }

    @Override // io.reactivex.rxjava3.core.e
    public void g(u30.c<? super T> cVar) {
        this.f67371b.subscribe(new a(cVar));
    }
}
