package io.reactivex.rxjava3.internal.functions;

import io.reactivex.rxjava3.exceptions.OnErrorNotImplementedException;
import java.util.Comparator;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class Functions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k10.h<Object, Object> f67326a = new g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Runnable f67327b = new EmptyRunnable();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final k10.a f67328c = new b();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final k10.f<Object> f67329d = new c();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final k10.f<Throwable> f67330e = new e();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final k10.f<Throwable> f67331f = new k();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final k10.i f67332g = new d();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final k10.j<Object> f67333h = new l();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final k10.j<Object> f67334i = new f();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final k10.k<Object> f67335j = new j();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final k10.f<u30.d> f67336k = new i();

    /* JADX INFO: compiled from: source.java */
    public static final class EmptyRunnable implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
        }

        public String toString() {
            return "EmptyRunnable";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public enum NaturalComparator implements Comparator<Object> {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class a<T1, T2, T3, R> implements k10.h<Object[], R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final k10.g<T1, T2, T3, R> f67337a;

        public a(k10.g<T1, T2, T3, R> gVar) {
            this.f67337a = gVar;
        }

        @Override // k10.h
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public R apply(Object[] objArr) throws Throwable {
            if (objArr.length == 3) {
                return this.f67337a.a((T1) objArr[0], (T2) objArr[1], (T3) objArr[2]);
            }
            throw new IllegalArgumentException("Array of size 3 expected but got " + objArr.length);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b implements k10.a {
        @Override // k10.a
        public void run() {
        }

        public String toString() {
            return "EmptyAction";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c implements k10.f<Object> {
        @Override // k10.f
        public void accept(Object obj) {
        }

        public String toString() {
            return "EmptyConsumer";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d implements k10.i {
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e implements k10.f<Throwable> {
        @Override // k10.f
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th2) {
            p10.a.q(th2);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class f implements k10.j<Object> {
        @Override // k10.j
        public boolean test(Object obj) {
            return false;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class g implements k10.h<Object, Object> {
        @Override // k10.h
        public Object apply(Object obj) {
            return obj;
        }

        public String toString() {
            return "IdentityFunction";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class h<T, U> implements Callable<U>, k10.k<U>, k10.h<T, U> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final U f67338a;

        public h(U u11) {
            this.f67338a = u11;
        }

        @Override // k10.h
        public U apply(T t11) {
            return this.f67338a;
        }

        @Override // java.util.concurrent.Callable
        public U call() {
            return this.f67338a;
        }

        @Override // k10.k
        public U get() {
            return this.f67338a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class i implements k10.f<u30.d> {
        @Override // k10.f
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(u30.d dVar) {
            dVar.request(Long.MAX_VALUE);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class j implements k10.k<Object> {
        @Override // k10.k
        public Object get() {
            return null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class k implements k10.f<Throwable> {
        @Override // k10.f
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th2) {
            p10.a.q(new OnErrorNotImplementedException(th2));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class l implements k10.j<Object> {
        @Override // k10.j
        public boolean test(Object obj) {
            return true;
        }
    }

    public static <T> k10.f<T> a() {
        return (k10.f<T>) f67329d;
    }

    public static <T> k10.k<T> b(T t11) {
        return new h(t11);
    }

    public static <T1, T2, T3, R> k10.h<Object[], R> c(k10.g<T1, T2, T3, R> gVar) {
        return new a(gVar);
    }
}
