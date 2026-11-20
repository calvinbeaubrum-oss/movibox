package io.reactivex.rxjava3.internal.operators.observable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class c<T> extends io.reactivex.rxjava3.internal.operators.observable.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k10.f<? super T> f67423b;

    /* JADX INFO: compiled from: source.java */
    public static final class a<T> extends io.reactivex.rxjava3.internal.observers.a<T, T> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final k10.f<? super T> f67424g;

        public a(io.reactivex.rxjava3.core.o<? super T> oVar, k10.f<? super T> fVar) {
            super(oVar);
            this.f67424g = fVar;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // io.reactivex.rxjava3.core.o
        public void onNext(T t11) {
            this.f67340a.onNext((Object) t11);
            if (this.f67344f == 0) {
                try {
                    this.f67424g.accept(t11);
                } catch (Throwable th2) {
                    c(th2);
                }
            }
        }

        @Override // m10.g
        public T poll() throws Throwable {
            T tPoll = this.f67342c.poll();
            if (tPoll != null) {
                this.f67424g.accept(tPoll);
            }
            return tPoll;
        }

        @Override // m10.c
        public int requestFusion(int i11) {
            return d(i11);
        }
    }

    public c(io.reactivex.rxjava3.core.m<T> mVar, k10.f<? super T> fVar) {
        super(mVar);
        this.f67423b = fVar;
    }

    @Override // io.reactivex.rxjava3.core.j
    public void z(io.reactivex.rxjava3.core.o<? super T> oVar) {
        this.f67422a.subscribe(new a(oVar, this.f67423b));
    }
}
