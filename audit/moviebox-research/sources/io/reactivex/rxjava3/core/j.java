package io.reactivex.rxjava3.core;

import com.google.android.gms.common.api.Api;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.internal.observers.LambdaObserver;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableOnBackpressureError;
import io.reactivex.rxjava3.internal.operators.observable.ObservableBuffer;
import io.reactivex.rxjava3.internal.operators.observable.ObservableCreate;
import io.reactivex.rxjava3.internal.operators.observable.ObservableFlatMap;
import io.reactivex.rxjava3.internal.operators.observable.ObservableObserveOn;
import io.reactivex.rxjava3.internal.operators.observable.ObservableRetryBiPredicate;
import io.reactivex.rxjava3.internal.operators.observable.ObservableScalarXMap;
import io.reactivex.rxjava3.internal.operators.observable.ObservableSubscribeOn;
import io.reactivex.rxjava3.internal.operators.observable.ObservableZip;
import io.reactivex.rxjava3.internal.util.ArrayListSupplier;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public abstract class j<T> implements m<T> {

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f67323a;

        static {
            int[] iArr = new int[BackpressureStrategy.values().length];
            f67323a = iArr;
            try {
                iArr[BackpressureStrategy.DROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f67323a[BackpressureStrategy.LATEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f67323a[BackpressureStrategy.MISSING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f67323a[BackpressureStrategy.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static <T> j<T> C(m<T> mVar) {
        Objects.requireNonNull(mVar, "source is null");
        return mVar instanceof j ? p10.a.n((j) mVar) : p10.a.n(new io.reactivex.rxjava3.internal.operators.observable.f(mVar));
    }

    public static <T1, T2, T3, R> j<R> D(m<? extends T1> mVar, m<? extends T2> mVar2, m<? extends T3> mVar3, k10.g<? super T1, ? super T2, ? super T3, ? extends R> gVar) {
        Objects.requireNonNull(mVar, "source1 is null");
        Objects.requireNonNull(mVar2, "source2 is null");
        Objects.requireNonNull(mVar3, "source3 is null");
        Objects.requireNonNull(gVar, "zipper is null");
        return E(Functions.c(gVar), false, d(), mVar, mVar2, mVar3);
    }

    @SafeVarargs
    public static <T, R> j<R> E(k10.h<? super Object[], ? extends R> hVar, boolean z11, int i11, m<? extends T>... mVarArr) {
        Objects.requireNonNull(mVarArr, "sources is null");
        if (mVarArr.length == 0) {
            return h();
        }
        Objects.requireNonNull(hVar, "zipper is null");
        io.reactivex.rxjava3.internal.functions.a.a(i11, "bufferSize");
        return p10.a.n(new ObservableZip(mVarArr, null, hVar, i11, z11));
    }

    public static int d() {
        return e.a();
    }

    public static <T> j<T> f(l<T> lVar) {
        Objects.requireNonNull(lVar, "source is null");
        return p10.a.n(new ObservableCreate(lVar));
    }

    public static <T> j<T> h() {
        return p10.a.n(io.reactivex.rxjava3.internal.operators.observable.d.f67425a);
    }

    public static <T> j<T> i(Throwable th2) {
        Objects.requireNonNull(th2, "throwable is null");
        return j(Functions.b(th2));
    }

    public static <T> j<T> j(k10.k<? extends Throwable> kVar) {
        Objects.requireNonNull(kVar, "supplier is null");
        return p10.a.n(new io.reactivex.rxjava3.internal.operators.observable.e(kVar));
    }

    public static <T> j<T> p(T t11) {
        Objects.requireNonNull(t11, "item is null");
        return p10.a.n(new io.reactivex.rxjava3.internal.operators.observable.i(t11));
    }

    public final j<T> A(Scheduler scheduler) {
        Objects.requireNonNull(scheduler, "scheduler is null");
        return p10.a.n(new ObservableSubscribeOn(this, scheduler));
    }

    public final e<T> B(BackpressureStrategy backpressureStrategy) {
        Objects.requireNonNull(backpressureStrategy, "strategy is null");
        io.reactivex.rxjava3.internal.operators.flowable.c cVar = new io.reactivex.rxjava3.internal.operators.flowable.c(this);
        int i11 = a.f67323a[backpressureStrategy.ordinal()];
        if (i11 == 1) {
            return cVar.d();
        }
        if (i11 == 2) {
            return cVar.e();
        }
        if (i11 != 3) {
            return i11 != 4 ? cVar.b() : p10.a.l(new FlowableOnBackpressureError(cVar));
        }
        return cVar;
    }

    public final j<List<T>> a(int i11) {
        return b(i11, i11);
    }

    public final j<List<T>> b(int i11, int i12) {
        return (j<List<T>>) c(i11, i12, ArrayListSupplier.asSupplier());
    }

    public final <U extends Collection<? super T>> j<U> c(int i11, int i12, k10.k<U> kVar) {
        io.reactivex.rxjava3.internal.functions.a.a(i11, "count");
        io.reactivex.rxjava3.internal.functions.a.a(i12, "skip");
        Objects.requireNonNull(kVar, "bufferSupplier is null");
        return p10.a.n(new ObservableBuffer(this, i11, i12, kVar));
    }

    public final <R> j<R> e(n<? super T, ? extends R> nVar) {
        Objects.requireNonNull(nVar, "composer is null");
        return C(nVar.a(this));
    }

    public final j<T> g(k10.f<? super T> fVar) {
        Objects.requireNonNull(fVar, "onAfterNext is null");
        return p10.a.n(new io.reactivex.rxjava3.internal.operators.observable.c(this, fVar));
    }

    public final <R> j<R> k(k10.h<? super T, ? extends m<? extends R>> hVar) {
        return l(hVar, false);
    }

    public final <R> j<R> l(k10.h<? super T, ? extends m<? extends R>> hVar, boolean z11) {
        return m(hVar, z11, Api.BaseClientBuilder.API_PRIORITY_OTHER);
    }

    public final <R> j<R> m(k10.h<? super T, ? extends m<? extends R>> hVar, boolean z11, int i11) {
        return n(hVar, z11, i11, d());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> j<R> n(k10.h<? super T, ? extends m<? extends R>> hVar, boolean z11, int i11, int i12) {
        Objects.requireNonNull(hVar, "mapper is null");
        io.reactivex.rxjava3.internal.functions.a.a(i11, "maxConcurrency");
        io.reactivex.rxjava3.internal.functions.a.a(i12, "bufferSize");
        if (!(this instanceof m10.e)) {
            return p10.a.n(new ObservableFlatMap(this, hVar, z11, i11, i12));
        }
        Object obj = ((m10.e) this).get();
        return obj == null ? h() : ObservableScalarXMap.a(obj, hVar);
    }

    public final io.reactivex.rxjava3.core.a o() {
        return p10.a.k(new io.reactivex.rxjava3.internal.operators.observable.h(this));
    }

    public final <R> j<R> q(k10.h<? super T, ? extends R> hVar) {
        Objects.requireNonNull(hVar, "mapper is null");
        return p10.a.n(new io.reactivex.rxjava3.internal.operators.observable.j(this, hVar));
    }

    public final j<T> r(Scheduler scheduler) {
        return s(scheduler, false, d());
    }

    public final j<T> s(Scheduler scheduler, boolean z11, int i11) {
        Objects.requireNonNull(scheduler, "scheduler is null");
        io.reactivex.rxjava3.internal.functions.a.a(i11, "bufferSize");
        return p10.a.n(new ObservableObserveOn(this, scheduler, z11, i11));
    }

    @Override // io.reactivex.rxjava3.core.m
    public final void subscribe(o<? super T> oVar) {
        Objects.requireNonNull(oVar, "observer is null");
        try {
            o<? super T> oVarW = p10.a.w(this, oVar);
            Objects.requireNonNull(oVarW, "The RxJavaPlugins.onSubscribe hook returned a null Observer. Please change the handler provided to RxJavaPlugins.setOnObservableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            z(oVarW);
        } catch (NullPointerException e11) {
            throw e11;
        } catch (Throwable th2) {
            i10.a.b(th2);
            p10.a.q(th2);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th2);
            throw nullPointerException;
        }
    }

    public final j<T> t(k10.h<? super Throwable, ? extends m<? extends T>> hVar) {
        Objects.requireNonNull(hVar, "fallbackSupplier is null");
        return p10.a.n(new io.reactivex.rxjava3.internal.operators.observable.k(this, hVar));
    }

    public final j<T> u(k10.d<? super Integer, ? super Throwable> dVar) {
        Objects.requireNonNull(dVar, "predicate is null");
        return p10.a.n(new ObservableRetryBiPredicate(this, dVar));
    }

    public final g<T> v() {
        return p10.a.m(new io.reactivex.rxjava3.internal.operators.observable.l(this));
    }

    public final p<T> w() {
        return p10.a.o(new io.reactivex.rxjava3.internal.operators.observable.m(this, null));
    }

    public final h10.b x(k10.f<? super T> fVar, k10.f<? super Throwable> fVar2) {
        return y(fVar, fVar2, Functions.f67328c);
    }

    public final h10.b y(k10.f<? super T> fVar, k10.f<? super Throwable> fVar2, k10.a aVar) {
        Objects.requireNonNull(fVar, "onNext is null");
        Objects.requireNonNull(fVar2, "onError is null");
        Objects.requireNonNull(aVar, "onComplete is null");
        LambdaObserver lambdaObserver = new LambdaObserver(fVar, fVar2, aVar, Functions.a());
        subscribe(lambdaObserver);
        return lambdaObserver;
    }

    public abstract void z(o<? super T> oVar);
}
