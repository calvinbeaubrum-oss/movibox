package io.reactivex.rxjava3.internal.operators.observable;

import OooO.OooO0OO;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class ObservableScalarXMap {

    /* JADX INFO: compiled from: source.java */
    public static final class ScalarDisposable<T> extends AtomicInteger implements m10.b<T>, Runnable {
        static final int FUSED = 1;
        static final int ON_COMPLETE = 3;
        static final int ON_NEXT = 2;
        static final int START = 0;
        private static final long serialVersionUID = 3880992722410194083L;
        final io.reactivex.rxjava3.core.o<? super T> observer;
        final T value;

        public ScalarDisposable(io.reactivex.rxjava3.core.o<? super T> oVar, T t11) {
            this.observer = oVar;
            this.value = t11;
        }

        @Override // m10.g
        public void clear() {
            lazySet(3);
        }

        @Override // h10.b
        public void dispose() {
            set(3);
        }

        @Override // h10.b
        public boolean isDisposed() {
            return get() == 3;
        }

        @Override // m10.g
        public boolean isEmpty() {
            return get() != 1;
        }

        @Override // m10.g
        public boolean offer(T t11) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        public boolean offer(T t11, T t12) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        @Override // m10.g
        public T poll() {
            if (get() != 1) {
                return null;
            }
            lazySet(3);
            return this.value;
        }

        @Override // m10.c
        public int requestFusion(int i11) {
            if ((i11 & 1) == 0) {
                return 0;
            }
            lazySet(1);
            return 1;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (get() == 0 && compareAndSet(0, 2)) {
                this.observer.onNext(this.value);
                if (get() == 2) {
                    lazySet(3);
                    this.observer.onComplete();
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class a<T, R> extends io.reactivex.rxjava3.core.j<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f67404a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final k10.h<? super T, ? extends io.reactivex.rxjava3.core.m<? extends R>> f67405b;

        public a(T t11, k10.h<? super T, ? extends io.reactivex.rxjava3.core.m<? extends R>> hVar) {
            this.f67404a = t11;
            this.f67405b = hVar;
        }

        @Override // io.reactivex.rxjava3.core.j
        public void z(io.reactivex.rxjava3.core.o<? super R> oVar) {
            try {
                io.reactivex.rxjava3.core.m<? extends R> mVarApply = this.f67405b.apply(this.f67404a);
                Objects.requireNonNull(mVarApply, "The mapper returned a null ObservableSource");
                io.reactivex.rxjava3.core.m<? extends R> mVar = mVarApply;
                if (!(mVar instanceof k10.k)) {
                    mVar.subscribe(oVar);
                    return;
                }
                try {
                    Object obj = ((k10.k) mVar).get();
                    if (obj == null) {
                        EmptyDisposable.complete(oVar);
                        return;
                    }
                    ScalarDisposable scalarDisposable = new ScalarDisposable(oVar, obj);
                    oVar.onSubscribe(scalarDisposable);
                    scalarDisposable.run();
                } catch (Throwable th2) {
                    i10.a.b(th2);
                    EmptyDisposable.error(th2, oVar);
                }
            } catch (Throwable th3) {
                i10.a.b(th3);
                EmptyDisposable.error(th3, oVar);
            }
        }
    }

    public static <T, U> io.reactivex.rxjava3.core.j<U> a(T t11, k10.h<? super T, ? extends io.reactivex.rxjava3.core.m<? extends U>> hVar) {
        return p10.a.n(new a(t11, hVar));
    }

    public static <T, R> boolean b(io.reactivex.rxjava3.core.m<T> mVar, io.reactivex.rxjava3.core.o<? super R> oVar, k10.h<? super T, ? extends io.reactivex.rxjava3.core.m<? extends R>> hVar) {
        if (!(mVar instanceof k10.k)) {
            return false;
        }
        try {
            OooO0OO.C0001OooO0OO c0001OooO0OO = (Object) ((k10.k) mVar).get();
            if (c0001OooO0OO == null) {
                EmptyDisposable.complete(oVar);
                return true;
            }
            try {
                io.reactivex.rxjava3.core.m<? extends R> mVarApply = hVar.apply(c0001OooO0OO);
                Objects.requireNonNull(mVarApply, "The mapper returned a null ObservableSource");
                io.reactivex.rxjava3.core.m<? extends R> mVar2 = mVarApply;
                if (mVar2 instanceof k10.k) {
                    try {
                        Object obj = ((k10.k) mVar2).get();
                        if (obj == null) {
                            EmptyDisposable.complete(oVar);
                            return true;
                        }
                        ScalarDisposable scalarDisposable = new ScalarDisposable(oVar, obj);
                        oVar.onSubscribe(scalarDisposable);
                        scalarDisposable.run();
                    } catch (Throwable th2) {
                        i10.a.b(th2);
                        EmptyDisposable.error(th2, oVar);
                        return true;
                    }
                } else {
                    mVar2.subscribe(oVar);
                }
                return true;
            } catch (Throwable th3) {
                i10.a.b(th3);
                EmptyDisposable.error(th3, oVar);
                return true;
            }
        } catch (Throwable th4) {
            i10.a.b(th4);
            EmptyDisposable.error(th4, oVar);
            return true;
        }
    }
}
