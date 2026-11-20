package p10;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.b;
import io.reactivex.rxjava3.core.e;
import io.reactivex.rxjava3.core.g;
import io.reactivex.rxjava3.core.j;
import io.reactivex.rxjava3.core.o;
import io.reactivex.rxjava3.core.p;
import io.reactivex.rxjava3.core.q;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.exceptions.OnErrorNotImplementedException;
import io.reactivex.rxjava3.exceptions.UndeliverableException;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.Objects;
import k10.c;
import k10.f;
import k10.h;
import k10.k;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile f<? super Throwable> f73487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile h<? super Runnable, ? extends Runnable> f73488b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile h<? super k<Scheduler>, ? extends Scheduler> f73489c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile h<? super k<Scheduler>, ? extends Scheduler> f73490d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile h<? super k<Scheduler>, ? extends Scheduler> f73491e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile h<? super k<Scheduler>, ? extends Scheduler> f73492f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile h<? super Scheduler, ? extends Scheduler> f73493g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile h<? super Scheduler, ? extends Scheduler> f73494h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile h<? super e, ? extends e> f73495i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static volatile h<? super j, ? extends j> f73496j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static volatile h<? super g, ? extends g> f73497k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static volatile h<? super p, ? extends p> f73498l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static volatile h<? super io.reactivex.rxjava3.core.a, ? extends io.reactivex.rxjava3.core.a> f73499m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static volatile c<? super e, ? super u30.c, ? extends u30.c> f73500n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static volatile c<? super g, ? super io.reactivex.rxjava3.core.h, ? extends io.reactivex.rxjava3.core.h> f73501o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static volatile c<? super j, ? super o, ? extends o> f73502p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static volatile c<? super p, ? super q, ? extends q> f73503q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static volatile c<? super io.reactivex.rxjava3.core.a, ? super b, ? extends b> f73504r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static volatile boolean f73505s;

    public static <T, U, R> R a(c<T, U, R> cVar, T t11, U u11) {
        try {
            return cVar.apply(t11, u11);
        } catch (Throwable th2) {
            throw ExceptionHelper.g(th2);
        }
    }

    public static <T, R> R b(h<T, R> hVar, T t11) {
        try {
            return hVar.apply(t11);
        } catch (Throwable th2) {
            throw ExceptionHelper.g(th2);
        }
    }

    public static Scheduler c(h<? super k<Scheduler>, ? extends Scheduler> hVar, k<Scheduler> kVar) {
        Object objB = b(hVar, kVar);
        Objects.requireNonNull(objB, "Scheduler Supplier result can't be null");
        return (Scheduler) objB;
    }

    public static Scheduler d(k<Scheduler> kVar) {
        try {
            Scheduler scheduler = kVar.get();
            Objects.requireNonNull(scheduler, "Scheduler Supplier result can't be null");
            return scheduler;
        } catch (Throwable th2) {
            throw ExceptionHelper.g(th2);
        }
    }

    public static Scheduler e(k<Scheduler> kVar) {
        Objects.requireNonNull(kVar, "Scheduler Supplier can't be null");
        h<? super k<Scheduler>, ? extends Scheduler> hVar = f73489c;
        return hVar == null ? d(kVar) : c(hVar, kVar);
    }

    public static Scheduler f(k<Scheduler> kVar) {
        Objects.requireNonNull(kVar, "Scheduler Supplier can't be null");
        h<? super k<Scheduler>, ? extends Scheduler> hVar = f73491e;
        return hVar == null ? d(kVar) : c(hVar, kVar);
    }

    public static Scheduler g(k<Scheduler> kVar) {
        Objects.requireNonNull(kVar, "Scheduler Supplier can't be null");
        h<? super k<Scheduler>, ? extends Scheduler> hVar = f73492f;
        return hVar == null ? d(kVar) : c(hVar, kVar);
    }

    public static Scheduler h(k<Scheduler> kVar) {
        Objects.requireNonNull(kVar, "Scheduler Supplier can't be null");
        h<? super k<Scheduler>, ? extends Scheduler> hVar = f73490d;
        return hVar == null ? d(kVar) : c(hVar, kVar);
    }

    public static boolean i(Throwable th2) {
        return (th2 instanceof OnErrorNotImplementedException) || (th2 instanceof MissingBackpressureException) || (th2 instanceof IllegalStateException) || (th2 instanceof NullPointerException) || (th2 instanceof IllegalArgumentException) || (th2 instanceof CompositeException);
    }

    public static boolean j() {
        return f73505s;
    }

    public static io.reactivex.rxjava3.core.a k(io.reactivex.rxjava3.core.a aVar) {
        h<? super io.reactivex.rxjava3.core.a, ? extends io.reactivex.rxjava3.core.a> hVar = f73499m;
        return hVar != null ? (io.reactivex.rxjava3.core.a) b(hVar, aVar) : aVar;
    }

    public static <T> e<T> l(e<T> eVar) {
        h<? super e, ? extends e> hVar = f73495i;
        return hVar != null ? (e) b(hVar, eVar) : eVar;
    }

    public static <T> g<T> m(g<T> gVar) {
        h<? super g, ? extends g> hVar = f73497k;
        return hVar != null ? (g) b(hVar, gVar) : gVar;
    }

    public static <T> j<T> n(j<T> jVar) {
        h<? super j, ? extends j> hVar = f73496j;
        return hVar != null ? (j) b(hVar, jVar) : jVar;
    }

    public static <T> p<T> o(p<T> pVar) {
        h<? super p, ? extends p> hVar = f73498l;
        return hVar != null ? (p) b(hVar, pVar) : pVar;
    }

    public static boolean p() {
        return false;
    }

    public static void q(Throwable th2) {
        f<? super Throwable> fVar = f73487a;
        if (th2 == null) {
            th2 = ExceptionHelper.b("onError called with a null Throwable.");
        } else if (!i(th2)) {
            th2 = new UndeliverableException(th2);
        }
        if (fVar != null) {
            try {
                fVar.accept(th2);
                return;
            } catch (Throwable th3) {
                th3.printStackTrace();
                z(th3);
            }
        }
        th2.printStackTrace();
        z(th2);
    }

    public static Scheduler r(Scheduler scheduler) {
        h<? super Scheduler, ? extends Scheduler> hVar = f73494h;
        return hVar == null ? scheduler : (Scheduler) b(hVar, scheduler);
    }

    public static Runnable s(Runnable runnable) {
        Objects.requireNonNull(runnable, "run is null");
        h<? super Runnable, ? extends Runnable> hVar = f73488b;
        return hVar == null ? runnable : (Runnable) b(hVar, runnable);
    }

    public static Scheduler t(Scheduler scheduler) {
        h<? super Scheduler, ? extends Scheduler> hVar = f73493g;
        return hVar == null ? scheduler : (Scheduler) b(hVar, scheduler);
    }

    public static b u(io.reactivex.rxjava3.core.a aVar, b bVar) {
        c<? super io.reactivex.rxjava3.core.a, ? super b, ? extends b> cVar = f73504r;
        return cVar != null ? (b) a(cVar, aVar, bVar) : bVar;
    }

    public static <T> io.reactivex.rxjava3.core.h<? super T> v(g<T> gVar, io.reactivex.rxjava3.core.h<? super T> hVar) {
        c<? super g, ? super io.reactivex.rxjava3.core.h, ? extends io.reactivex.rxjava3.core.h> cVar = f73501o;
        return cVar != null ? (io.reactivex.rxjava3.core.h) a(cVar, gVar, hVar) : hVar;
    }

    public static <T> o<? super T> w(j<T> jVar, o<? super T> oVar) {
        c<? super j, ? super o, ? extends o> cVar = f73502p;
        return cVar != null ? (o) a(cVar, jVar, oVar) : oVar;
    }

    public static <T> q<? super T> x(p<T> pVar, q<? super T> qVar) {
        c<? super p, ? super q, ? extends q> cVar = f73503q;
        return cVar != null ? (q) a(cVar, pVar, qVar) : qVar;
    }

    public static <T> u30.c<? super T> y(e<T> eVar, u30.c<? super T> cVar) {
        c<? super e, ? super u30.c, ? extends u30.c> cVar2 = f73500n;
        return cVar2 != null ? (u30.c) a(cVar2, eVar, cVar) : cVar;
    }

    public static void z(Throwable th2) {
        Thread threadCurrentThread = Thread.currentThread();
        threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th2);
    }
}
