package io.reactivex.rxjava3.internal.schedulers;

import androidx.compose.animation.core.j0;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class a extends Scheduler {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f67499e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final RxThreadFactory f67500f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f67501g = g(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx3.computation-threads", 0).intValue());

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final c f67502h;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ThreadFactory f67503c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicReference<b> f67504d;

    /* JADX INFO: renamed from: io.reactivex.rxjava3.internal.schedulers.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0713a extends Scheduler.Worker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l10.b f67505a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final h10.a f67506b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final l10.b f67507c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final c f67508d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public volatile boolean f67509f;

        public C0713a(c cVar) {
            this.f67508d = cVar;
            l10.b bVar = new l10.b();
            this.f67505a = bVar;
            h10.a aVar = new h10.a();
            this.f67506b = aVar;
            l10.b bVar2 = new l10.b();
            this.f67507c = bVar2;
            bVar2.c(bVar);
            bVar2.c(aVar);
        }

        @Override // h10.b
        public void dispose() {
            if (this.f67509f) {
                return;
            }
            this.f67509f = true;
            this.f67507c.dispose();
        }

        @Override // h10.b
        public boolean isDisposed() {
            return this.f67509f;
        }

        @Override // io.reactivex.rxjava3.core.Scheduler.Worker
        public h10.b schedule(Runnable runnable) {
            return this.f67509f ? EmptyDisposable.INSTANCE : this.f67508d.a(runnable, 0L, TimeUnit.MILLISECONDS, this.f67505a);
        }

        @Override // io.reactivex.rxjava3.core.Scheduler.Worker
        public h10.b schedule(Runnable runnable, long j11, TimeUnit timeUnit) {
            return this.f67509f ? EmptyDisposable.INSTANCE : this.f67508d.a(runnable, j11, timeUnit, this.f67506b);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f67510a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c[] f67511b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f67512c;

        public b(int i11, ThreadFactory threadFactory) {
            this.f67510a = i11;
            this.f67511b = new c[i11];
            for (int i12 = 0; i12 < i11; i12++) {
                this.f67511b[i12] = new c(threadFactory);
            }
        }

        public c a() {
            int i11 = this.f67510a;
            if (i11 == 0) {
                return a.f67502h;
            }
            c[] cVarArr = this.f67511b;
            long j11 = this.f67512c;
            this.f67512c = 1 + j11;
            return cVarArr[(int) (j11 % ((long) i11))];
        }

        public void b() {
            for (c cVar : this.f67511b) {
                cVar.dispose();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c extends e {
        public c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        c cVar = new c(new RxThreadFactory("RxComputationShutdown"));
        f67502h = cVar;
        cVar.dispose();
        RxThreadFactory rxThreadFactory = new RxThreadFactory("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx3.computation-priority", 5).intValue())), true);
        f67500f = rxThreadFactory;
        b bVar = new b(0, rxThreadFactory);
        f67499e = bVar;
        bVar.b();
    }

    public a() {
        this(f67500f);
    }

    public a(ThreadFactory threadFactory) {
        this.f67503c = threadFactory;
        this.f67504d = new AtomicReference<>(f67499e);
        h();
    }

    public static int g(int i11, int i12) {
        return (i12 <= 0 || i12 > i11) ? i11 : i12;
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public Scheduler.Worker c() {
        return new C0713a(this.f67504d.get().a());
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public h10.b e(Runnable runnable, long j11, TimeUnit timeUnit) {
        return this.f67504d.get().a().b(runnable, j11, timeUnit);
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public h10.b f(Runnable runnable, long j11, long j12, TimeUnit timeUnit) {
        return this.f67504d.get().a().c(runnable, j11, j12, timeUnit);
    }

    public void h() {
        b bVar = new b(f67501g, this.f67503c);
        if (j0.a(this.f67504d, f67499e, bVar)) {
            return;
        }
        bVar.b();
    }
}
