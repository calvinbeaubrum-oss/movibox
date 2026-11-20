package g10;

import io.reactivex.rxjava3.core.Scheduler;
import java.util.concurrent.Callable;
import k10.h;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile h<Callable<Scheduler>, Scheduler> f65380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile h<Scheduler, Scheduler> f65381b;

    public static <T, R> R a(h<T, R> hVar, T t11) {
        try {
            return hVar.apply(t11);
        } catch (Throwable th2) {
            throw i10.a.a(th2);
        }
    }

    public static Scheduler b(h<Callable<Scheduler>, Scheduler> hVar, Callable<Scheduler> callable) {
        Scheduler scheduler = (Scheduler) a(hVar, callable);
        if (scheduler != null) {
            return scheduler;
        }
        throw new NullPointerException("Scheduler Callable returned null");
    }

    public static Scheduler c(Callable<Scheduler> callable) {
        try {
            Scheduler schedulerCall = callable.call();
            if (schedulerCall != null) {
                return schedulerCall;
            }
            throw new NullPointerException("Scheduler Callable returned null");
        } catch (Throwable th2) {
            throw i10.a.a(th2);
        }
    }

    public static Scheduler d(Callable<Scheduler> callable) {
        if (callable == null) {
            throw new NullPointerException("scheduler == null");
        }
        h<Callable<Scheduler>, Scheduler> hVar = f65380a;
        return hVar == null ? c(callable) : b(hVar, callable);
    }

    public static Scheduler e(Scheduler scheduler) {
        if (scheduler == null) {
            throw new NullPointerException("scheduler == null");
        }
        h<Scheduler, Scheduler> hVar = f65381b;
        return hVar == null ? scheduler : (Scheduler) a(hVar, scheduler);
    }
}
