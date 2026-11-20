package com.mbridge.msdk.e.a;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class k extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BlockingQueue<p<?>> f43797a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final j f43798b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b f43799c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final t f43800d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile boolean f43801e = false;

    public k(BlockingQueue<p<?>> blockingQueue, j jVar, b bVar, t tVar) {
        this.f43797a = blockingQueue;
        this.f43798b = jVar;
        this.f43799c = bVar;
        this.f43800d = tVar;
    }

    public final void a() {
        this.f43801e = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                p<?> pVarTake = this.f43797a.take();
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                pVarTake.b(3);
                try {
                    try {
                        if (pVarTake.m()) {
                            pVarTake.c("network-discard-cancelled");
                            pVarTake.v();
                        } else {
                            TrafficStats.setThreadStatsTag(pVarTake.h());
                            m mVarA = this.f43798b.a(pVarTake);
                            if (mVarA.f43806e && pVarTake.u()) {
                                pVarTake.c("not-modified");
                                pVarTake.v();
                            } else {
                                r<?> rVarA = pVarTake.a(mVarA);
                                if (pVarTake.p() && rVarA.f43844b != null) {
                                    this.f43799c.a(pVarTake.j(), rVarA.f43844b);
                                }
                                pVarTake.t();
                                this.f43800d.a(pVarTake, rVarA);
                                pVarTake.a(rVarA);
                            }
                        }
                    } catch (Throwable th2) {
                        pVarTake.b(4);
                        throw th2;
                    }
                } catch (z e11) {
                    e11.a(SystemClock.elapsedRealtime() - jElapsedRealtime);
                    this.f43800d.a(pVarTake, e11);
                    pVarTake.v();
                } catch (Exception e12) {
                    aa.a(e12, "Unhandled exception %s", e12.toString());
                    y yVar = new y(e12);
                    yVar.a(SystemClock.elapsedRealtime() - jElapsedRealtime);
                    this.f43800d.a(pVarTake, yVar);
                    pVarTake.v();
                }
                pVarTake.b(4);
            } catch (InterruptedException unused) {
                if (this.f43801e) {
                    Thread.currentThread().interrupt();
                    return;
                }
                aa.c("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}
