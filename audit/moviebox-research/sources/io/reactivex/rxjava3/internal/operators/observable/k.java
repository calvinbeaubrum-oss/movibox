package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class k<T> extends io.reactivex.rxjava3.internal.operators.observable.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k10.h<? super Throwable, ? extends io.reactivex.rxjava3.core.m<? extends T>> f67435b;

    /* JADX INFO: compiled from: source.java */
    public static final class a<T> implements io.reactivex.rxjava3.core.o<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final io.reactivex.rxjava3.core.o<? super T> f67436a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final k10.h<? super Throwable, ? extends io.reactivex.rxjava3.core.m<? extends T>> f67437b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final SequentialDisposable f67438c = new SequentialDisposable();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f67439d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f67440f;

        public a(io.reactivex.rxjava3.core.o<? super T> oVar, k10.h<? super Throwable, ? extends io.reactivex.rxjava3.core.m<? extends T>> hVar) {
            this.f67436a = oVar;
            this.f67437b = hVar;
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onComplete() {
            if (this.f67440f) {
                return;
            }
            this.f67440f = true;
            this.f67439d = true;
            this.f67436a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onError(Throwable th2) {
            if (this.f67439d) {
                if (this.f67440f) {
                    p10.a.q(th2);
                    return;
                } else {
                    this.f67436a.onError(th2);
                    return;
                }
            }
            this.f67439d = true;
            try {
                io.reactivex.rxjava3.core.m<? extends T> mVarApply = this.f67437b.apply(th2);
                if (mVarApply != null) {
                    mVarApply.subscribe(this);
                    return;
                }
                NullPointerException nullPointerException = new NullPointerException("Observable is null");
                nullPointerException.initCause(th2);
                this.f67436a.onError(nullPointerException);
            } catch (Throwable th3) {
                i10.a.b(th3);
                this.f67436a.onError(new CompositeException(th2, th3));
            }
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onNext(T t11) {
            if (this.f67440f) {
                return;
            }
            this.f67436a.onNext(t11);
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onSubscribe(h10.b bVar) {
            this.f67438c.replace(bVar);
        }
    }

    public k(io.reactivex.rxjava3.core.m<T> mVar, k10.h<? super Throwable, ? extends io.reactivex.rxjava3.core.m<? extends T>> hVar) {
        super(mVar);
        this.f67435b = hVar;
    }

    @Override // io.reactivex.rxjava3.core.j
    public void z(io.reactivex.rxjava3.core.o<? super T> oVar) {
        a aVar = new a(oVar, this.f67435b);
        oVar.onSubscribe(aVar.f67438c);
        this.f67422a.subscribe(aVar);
    }
}
