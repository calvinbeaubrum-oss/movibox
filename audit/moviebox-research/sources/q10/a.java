package q10;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.schedulers.ExecutorScheduler;
import io.reactivex.rxjava3.internal.schedulers.IoScheduler;
import io.reactivex.rxjava3.internal.schedulers.TrampolineScheduler;
import java.util.concurrent.Executor;
import k10.k;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Scheduler f74216a = p10.a.h(new h());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Scheduler f74217b = p10.a.e(new b());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Scheduler f74218c = p10.a.f(new c());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Scheduler f74219d = TrampolineScheduler.g();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Scheduler f74220e = p10.a.g(new f());

    /* JADX INFO: renamed from: q10.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0813a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Scheduler f74221a = new io.reactivex.rxjava3.internal.schedulers.a();
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b implements k<Scheduler> {
        @Override // k10.k
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Scheduler get() {
            return C0813a.f74221a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c implements k<Scheduler> {
        @Override // k10.k
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Scheduler get() {
            return d.f74222a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Scheduler f74222a = new IoScheduler();
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Scheduler f74223a = new io.reactivex.rxjava3.internal.schedulers.d();
    }

    /* JADX INFO: compiled from: source.java */
    public static final class f implements k<Scheduler> {
        @Override // k10.k
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Scheduler get() {
            return e.f74223a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Scheduler f74224a = new io.reactivex.rxjava3.internal.schedulers.g();
    }

    /* JADX INFO: compiled from: source.java */
    public static final class h implements k<Scheduler> {
        @Override // k10.k
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Scheduler get() {
            return g.f74224a;
        }
    }

    public static Scheduler a(Executor executor) {
        return new ExecutorScheduler(executor, false, false);
    }

    public static Scheduler b() {
        return p10.a.r(f74218c);
    }

    public static Scheduler c() {
        return p10.a.t(f74216a);
    }
}
