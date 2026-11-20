package com.applovin.impl;

import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class tm {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final ExecutorService f23390o = Executors.newFixedThreadPool(4);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f23391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.applovin.impl.sdk.n f23392b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ScheduledThreadPoolExecutor f23393c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ScheduledThreadPoolExecutor f23394d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ScheduledThreadPoolExecutor f23395e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ScheduledThreadPoolExecutor f23396f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ScheduledThreadPoolExecutor f23397g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ScheduledThreadPoolExecutor f23398h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ScheduledThreadPoolExecutor f23399i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Map f23400j = new HashMap();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final List f23401k = new ArrayList(5);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Object f23402l = new Object();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f23403m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f23404n;

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f23405a;

        static {
            int[] iArr = new int[b.values().length];
            f23405a = iArr;
            try {
                iArr[b.CORE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f23405a[b.CACHING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f23405a[b.MEDIATION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f23405a[b.TIMEOUT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public enum b {
        CORE,
        CACHING,
        MEDIATION,
        TIMEOUT,
        OTHER
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f23412a;

        /* JADX INFO: compiled from: source.java */
        public class a implements Thread.UncaughtExceptionHandler {
            public a() {
            }

            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th2) {
                com.applovin.impl.sdk.n unused = tm.this.f23392b;
                if (com.applovin.impl.sdk.n.a()) {
                    tm.this.f23392b.a("TaskManager", "Caught unhandled exception", th2);
                }
            }
        }

        public c(String str) {
            this.f23412a = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "AppLovinSdk:" + this.f23412a);
            thread.setDaemon(true);
            thread.setPriority(((Integer) tm.this.f23391a.a(sj.W)).intValue());
            thread.setUncaughtExceptionHandler(new a());
            return thread;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.applovin.impl.sdk.j f23415a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f23416b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final com.applovin.impl.sdk.n f23417c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final yl f23418d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final b f23419f;

        public d(com.applovin.impl.sdk.j jVar, yl ylVar, b bVar) {
            this.f23415a = jVar;
            this.f23417c = jVar.J();
            this.f23416b = ylVar.c();
            this.f23418d = ylVar;
            this.f23419f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                z3.a();
                if (!this.f23415a.x0() || this.f23418d.d()) {
                    ScheduledFuture scheduledFutureB = this.f23418d.b(Thread.currentThread(), ((Long) this.f23415a.a(sj.E)).longValue());
                    this.f23418d.run();
                    if (scheduledFutureB != null) {
                        scheduledFutureB.cancel(false);
                    }
                } else {
                    if (com.applovin.impl.sdk.n.a()) {
                        this.f23417c.d(this.f23416b, "Task re-scheduled...");
                    }
                    this.f23415a.j0().a(this.f23418d, this.f23419f, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
                }
                if (com.applovin.impl.sdk.n.a()) {
                    this.f23417c.d(this.f23416b, this.f23419f + " queue finished task " + this.f23418d.c());
                }
            } catch (Throwable th2) {
                try {
                    if (com.applovin.impl.sdk.n.a()) {
                        this.f23417c.a(this.f23416b, "Task failed execution", th2);
                    }
                    this.f23418d.a(th2);
                } finally {
                    if (com.applovin.impl.sdk.n.a()) {
                        this.f23417c.d(this.f23416b, this.f23419f + " queue finished task " + this.f23418d.c());
                    }
                }
            }
        }
    }

    public tm(com.applovin.impl.sdk.j jVar) {
        this.f23391a = jVar;
        this.f23392b = jVar.J();
        this.f23404n = ((Boolean) jVar.a(sj.Z)).booleanValue();
        this.f23393c = b("auxiliary_operations", ((Integer) jVar.a(sj.U)).intValue());
        this.f23394d = b("shared_thread_pool", ((Integer) jVar.a(sj.T)).intValue());
        this.f23395e = b("core", ((Integer) jVar.a(sj.f22911a0)).intValue());
        this.f23397g = b("caching", ((Integer) jVar.a(sj.f22918b0)).intValue());
        this.f23398h = b("mediation", ((Integer) jVar.a(sj.f22926c0)).intValue());
        this.f23396f = b("timeout", ((Integer) jVar.a(sj.f22934d0)).intValue());
        this.f23399i = b("other", ((Integer) jVar.a(sj.f22941e0)).intValue());
    }

    private ScheduledThreadPoolExecutor a(d dVar) {
        int i11 = a.f23405a[dVar.f23419f.ordinal()];
        if (i11 == 1) {
            return this.f23395e;
        }
        if (i11 == 2) {
            return this.f23397g;
        }
        if (i11 != 3) {
            return i11 != 4 ? this.f23399i : this.f23396f;
        }
        return this.f23398h;
    }

    private void a(final d dVar, long j11, boolean z11) {
        final ScheduledThreadPoolExecutor scheduledThreadPoolExecutorA = this.f23404n ? a(dVar) : this.f23394d;
        if (j11 <= 0) {
            scheduledThreadPoolExecutorA.submit(dVar);
        } else if (z11) {
            x1.a(j11, this.f23391a, new Runnable() { // from class: com.applovin.impl.j60
                @Override // java.lang.Runnable
                public final void run() {
                    scheduledThreadPoolExecutorA.execute(dVar);
                }
            });
        } else {
            scheduledThreadPoolExecutorA.schedule(dVar, j11, TimeUnit.MILLISECONDS);
        }
    }

    private ScheduledThreadPoolExecutor b(String str, int i11) {
        return new ScheduledThreadPoolExecutor(i11, new c(str));
    }

    private boolean b(d dVar) {
        if (dVar.f23418d.d()) {
            return false;
        }
        synchronized (this.f23402l) {
            try {
                if (this.f23403m) {
                    return false;
                }
                this.f23401k.add(dVar);
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public List a(List list, ExecutorService executorService) {
        try {
            if (com.applovin.impl.sdk.n.a()) {
                this.f23392b.a("TaskManager", "Awaiting " + list.size() + " tasks...");
            }
            return executorService.invokeAll(list);
        } catch (Throwable th2) {
            if (!com.applovin.impl.sdk.n.a()) {
                return null;
            }
            this.f23392b.a("TaskManager", "Awaiting tasks were interrupted", th2);
            return null;
        }
    }

    public ExecutorService a() {
        return this.f23404n ? this.f23399i : this.f23393c;
    }

    public ExecutorService a(String str, int i11) {
        return Executors.newFixedThreadPool(i11, new c(str));
    }

    public void a(yl ylVar) {
        if (ylVar == null) {
            throw new IllegalArgumentException("No task specified");
        }
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.f23404n ? this.f23395e : this.f23394d;
        try {
            if (yp.h()) {
                scheduledThreadPoolExecutor.submit(new d(this.f23391a, ylVar, b.CORE));
                return;
            }
            ScheduledFuture scheduledFutureB = ylVar.b(Thread.currentThread(), ((Long) this.f23391a.a(sj.E)).longValue());
            ylVar.run();
            if (scheduledFutureB != null) {
                scheduledFutureB.cancel(false);
            }
        } catch (Throwable th2) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f23392b.a(ylVar.c(), "Task failed execution", th2);
            }
            ylVar.a(th2);
        }
    }

    public void a(yl ylVar, pe peVar) {
        String strB = peVar.b();
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutorB = (ScheduledThreadPoolExecutor) this.f23400j.get(strB);
        if (scheduledThreadPoolExecutorB == null) {
            scheduledThreadPoolExecutorB = b(strB, 1);
            this.f23400j.put(strB, scheduledThreadPoolExecutorB);
        }
        scheduledThreadPoolExecutorB.submit(new d(this.f23391a, ylVar, b.MEDIATION));
    }

    public void a(yl ylVar, b bVar) {
        a(ylVar, bVar, 0L);
    }

    public void a(yl ylVar, b bVar, long j11) {
        a(ylVar, bVar, j11, false);
    }

    public void a(yl ylVar, b bVar, long j11, boolean z11) {
        if (ylVar == null) {
            throw new IllegalArgumentException("No task specified");
        }
        if (j11 < 0) {
            throw new IllegalArgumentException("Invalid delay (millis) specified: " + j11);
        }
        d dVar = new d(this.f23391a, ylVar, bVar);
        if (!b(dVar)) {
            a(dVar, j11, z11);
        } else if (com.applovin.impl.sdk.n.a()) {
            this.f23392b.d(ylVar.c(), "Task execution delayed until after init");
        }
    }

    public void a(Runnable runnable, b bVar) {
        if (!this.f23404n) {
            this.f23393c.submit(runnable);
            return;
        }
        com.applovin.impl.sdk.j jVar = this.f23391a;
        d dVar = new d(jVar, new jn(jVar, "auxiliaryOperation", runnable), bVar);
        a(dVar).submit(dVar);
    }

    public ExecutorService b() {
        return this.f23404n ? this.f23397g : f23390o;
    }

    public ScheduledFuture b(yl ylVar, b bVar, long j11) {
        return this.f23404n ? a(new d(this.f23391a, ylVar, bVar)).schedule(ylVar, j11, TimeUnit.MILLISECONDS) : this.f23393c.schedule(ylVar, j11, TimeUnit.MILLISECONDS);
    }

    public Executor c() {
        return this.f23404n ? this.f23395e : this.f23394d;
    }

    public boolean d() {
        return this.f23403m;
    }

    public void e() {
        synchronized (this.f23402l) {
            try {
                this.f23403m = true;
                for (d dVar : this.f23401k) {
                    a(dVar.f23418d, dVar.f23419f);
                }
                this.f23401k.clear();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void f() {
        synchronized (this.f23402l) {
            this.f23403m = false;
        }
    }
}
