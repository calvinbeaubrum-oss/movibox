package com.applovin.impl;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class go {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f19269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Timer f19270b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f19271c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f19272d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Runnable f19273e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f19274f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Object f19275g = new Object();

    /* JADX INFO: compiled from: source.java */
    public class a extends TimerTask {
        public a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                go.this.f19273e.run();
                synchronized (go.this.f19275g) {
                    go.this.f19270b = null;
                }
            } catch (Throwable th2) {
                try {
                    if (go.this.f19269a != null) {
                        go.this.f19269a.J();
                        if (com.applovin.impl.sdk.n.a()) {
                            go.this.f19269a.J().a("Timer", "Encountered error while executing timed task", th2);
                        }
                        go.this.f19269a.E().a("Timer", "executingTimedTask", th2);
                    }
                } finally {
                    synchronized (go.this.f19275g) {
                        go.this.f19270b = null;
                    }
                }
            }
        }
    }

    private go(com.applovin.impl.sdk.j jVar, Runnable runnable) {
        this.f19269a = jVar;
        this.f19273e = runnable;
    }

    public static go a(long j11, com.applovin.impl.sdk.j jVar, Runnable runnable) {
        if (j11 < 0) {
            throw new IllegalArgumentException("Cannot create a scheduled timer. Invalid fire time passed in: " + j11 + InstructionFileId.DOT);
        }
        if (runnable == null) {
            throw new IllegalArgumentException("Cannot create a scheduled timer. Runnable is null.");
        }
        go goVar = new go(jVar, runnable);
        goVar.f19271c = System.currentTimeMillis();
        goVar.f19272d = j11;
        try {
            Timer timer = new Timer();
            goVar.f19270b = timer;
            timer.schedule(goVar.b(), j11);
        } catch (OutOfMemoryError e11) {
            jVar.J();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.J().a("Timer", "Failed to create timer due to OOM error", e11);
            }
        }
        return goVar;
    }

    private TimerTask b() {
        return new a();
    }

    public void a() {
        synchronized (this.f19275g) {
            Timer timer = this.f19270b;
            if (timer != null) {
                try {
                    timer.cancel();
                    this.f19270b = null;
                } catch (Throwable th2) {
                    try {
                        com.applovin.impl.sdk.j jVar = this.f19269a;
                        if (jVar != null) {
                            jVar.J();
                            if (com.applovin.impl.sdk.n.a()) {
                                this.f19269a.J();
                                if (com.applovin.impl.sdk.n.a()) {
                                    this.f19269a.J().a("Timer", "Encountered error while cancelling timer", th2);
                                }
                            }
                        }
                        this.f19270b = null;
                    } catch (Throwable th3) {
                        this.f19270b = null;
                        this.f19274f = 0L;
                        throw th3;
                    }
                }
                this.f19274f = 0L;
            }
        }
    }

    public long c() {
        if (this.f19270b == null) {
            return this.f19272d - this.f19274f;
        }
        return this.f19272d - (System.currentTimeMillis() - this.f19271c);
    }

    public void d() {
        synchronized (this.f19275g) {
            Timer timer = this.f19270b;
            if (timer != null) {
                try {
                    timer.cancel();
                    this.f19274f = Math.max(1L, System.currentTimeMillis() - this.f19271c);
                    this.f19270b = null;
                } catch (Throwable th2) {
                    try {
                        com.applovin.impl.sdk.j jVar = this.f19269a;
                        if (jVar != null) {
                            jVar.J();
                            if (com.applovin.impl.sdk.n.a()) {
                                this.f19269a.J();
                                if (com.applovin.impl.sdk.n.a()) {
                                    this.f19269a.J().a("Timer", "Encountered error while pausing timer", th2);
                                }
                            }
                        }
                        this.f19270b = null;
                    } catch (Throwable th3) {
                        this.f19270b = null;
                        throw th3;
                    }
                }
            }
        }
    }

    public void e() {
        synchronized (this.f19275g) {
            long j11 = this.f19274f;
            if (j11 > 0) {
                try {
                    long j12 = this.f19272d - j11;
                    this.f19272d = j12;
                    if (j12 < 0) {
                        this.f19272d = 0L;
                    }
                    Timer timer = new Timer();
                    this.f19270b = timer;
                    timer.schedule(b(), this.f19272d);
                    this.f19271c = System.currentTimeMillis();
                    this.f19274f = 0L;
                } catch (Throwable th2) {
                    try {
                        com.applovin.impl.sdk.j jVar = this.f19269a;
                        if (jVar != null) {
                            jVar.J();
                            if (com.applovin.impl.sdk.n.a()) {
                                this.f19269a.J();
                                if (com.applovin.impl.sdk.n.a()) {
                                    this.f19269a.J().a("Timer", "Encountered error while resuming timer", th2);
                                }
                            }
                        }
                        this.f19274f = 0L;
                    } catch (Throwable th3) {
                        this.f19274f = 0L;
                        throw th3;
                    }
                }
            }
        }
    }
}
