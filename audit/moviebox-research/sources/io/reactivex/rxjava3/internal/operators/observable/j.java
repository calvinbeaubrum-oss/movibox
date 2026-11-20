package io.reactivex.rxjava3.internal.operators.observable;

import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class j<T, U> extends io.reactivex.rxjava3.internal.operators.observable.a<T, U> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k10.h<? super T, ? extends U> f67433b;

    /* JADX INFO: compiled from: source.java */
    public static final class a<T, U> extends io.reactivex.rxjava3.internal.observers.a<T, U> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final k10.h<? super T, ? extends U> f67434g;

        public a(io.reactivex.rxjava3.core.o<? super U> oVar, k10.h<? super T, ? extends U> hVar) {
            super(oVar);
            this.f67434g = hVar;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // io.reactivex.rxjava3.core.o
        public void onNext(T t11) {
            if (this.f67343d) {
                return;
            }
            if (this.f67344f != 0) {
                this.f67340a.onNext(null);
                return;
            }
            try {
                U uApply = this.f67434g.apply(t11);
                Objects.requireNonNull(uApply, "The mapper function returned a null value.");
                this.f67340a.onNext((Object) uApply);
            } catch (Throwable th2) {
                c(th2);
            }
        }

        @Override // m10.g
        public U poll() throws Throwable {
            T tPoll = this.f67342c.poll();
            if (tPoll == null) {
                return null;
            }
            U uApply = this.f67434g.apply(tPoll);
            Objects.requireNonNull(uApply, "The mapper function returned a null value.");
            return uApply;
        }

        @Override // m10.c
        public int requestFusion(int i11) {
            return d(i11);
        }
    }

    public j(io.reactivex.rxjava3.core.m<T> mVar, k10.h<? super T, ? extends U> hVar) {
        super(mVar);
        this.f67433b = hVar;
    }

    @Override // io.reactivex.rxjava3.core.j
    public void z(io.reactivex.rxjava3.core.o<? super U> oVar) {
        this.f67422a.subscribe(new a(oVar, this.f67433b));
    }
}
