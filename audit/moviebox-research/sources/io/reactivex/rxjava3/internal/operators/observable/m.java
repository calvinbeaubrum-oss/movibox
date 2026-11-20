package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.q;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class m<T> extends io.reactivex.rxjava3.core.p<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.rxjava3.core.m<? extends T> f67446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f67447b;

    /* JADX INFO: compiled from: source.java */
    public static final class a<T> implements io.reactivex.rxjava3.core.o<T>, h10.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final q<? super T> f67448a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final T f67449b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public h10.b f67450c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public T f67451d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f67452f;

        public a(q<? super T> qVar, T t11) {
            this.f67448a = qVar;
            this.f67449b = t11;
        }

        @Override // h10.b
        public void dispose() {
            this.f67450c.dispose();
        }

        @Override // h10.b
        public boolean isDisposed() {
            return this.f67450c.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onComplete() {
            if (this.f67452f) {
                return;
            }
            this.f67452f = true;
            T t11 = this.f67451d;
            this.f67451d = null;
            if (t11 == null) {
                t11 = this.f67449b;
            }
            if (t11 != null) {
                this.f67448a.onSuccess(t11);
            } else {
                this.f67448a.onError(new NoSuchElementException());
            }
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onError(Throwable th2) {
            if (this.f67452f) {
                p10.a.q(th2);
            } else {
                this.f67452f = true;
                this.f67448a.onError(th2);
            }
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onNext(T t11) {
            if (this.f67452f) {
                return;
            }
            if (this.f67451d == null) {
                this.f67451d = t11;
                return;
            }
            this.f67452f = true;
            this.f67450c.dispose();
            this.f67448a.onError(new IllegalArgumentException("Sequence contains more than one element!"));
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onSubscribe(h10.b bVar) {
            if (DisposableHelper.validate(this.f67450c, bVar)) {
                this.f67450c = bVar;
                this.f67448a.onSubscribe(this);
            }
        }
    }

    public m(io.reactivex.rxjava3.core.m<? extends T> mVar, T t11) {
        this.f67446a = mVar;
        this.f67447b = t11;
    }

    @Override // io.reactivex.rxjava3.core.p
    public void b(q<? super T> qVar) {
        this.f67446a.subscribe(new a(qVar, this.f67447b));
    }
}
