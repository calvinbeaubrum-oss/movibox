package com.mbridge.msdk.e.a;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class c extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BlockingQueue<p<?>> f43777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final BlockingQueue<p<?>> f43778b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b f43779c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final t f43780d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile boolean f43781e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ab f43782f;

    public c(BlockingQueue<p<?>> blockingQueue, BlockingQueue<p<?>> blockingQueue2, b bVar, t tVar) {
        this.f43777a = blockingQueue;
        this.f43778b = blockingQueue2;
        this.f43779c = bVar;
        this.f43780d = tVar;
        this.f43782f = new ab(this, blockingQueue2, tVar);
    }

    public final void a() {
        this.f43781e = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(10);
        this.f43779c.a();
        while (true) {
            try {
                final p<?> pVarTake = this.f43777a.take();
                pVarTake.b(1);
                try {
                    if (pVarTake.m()) {
                        pVarTake.c("cache-discard-canceled");
                    } else {
                        b.a aVarA = this.f43779c.a(pVarTake.j());
                        if (aVarA != null) {
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            if (aVarA.a(jCurrentTimeMillis)) {
                                pVarTake.a(aVarA);
                                if (!this.f43782f.b(pVarTake)) {
                                    this.f43778b.put(pVarTake);
                                }
                            } else {
                                r<?> rVarA = pVarTake.a(new m(200, aVarA.f43769a, false, 0L, aVarA.f43776h));
                                s sVarK = pVarTake.k();
                                if (sVarK != null && !sVarK.a(rVarA, pVarTake)) {
                                    this.f43779c.a(pVarTake.j(), true);
                                    pVarTake.a((b.a) null);
                                    if (!this.f43782f.b(pVarTake)) {
                                        this.f43778b.put(pVarTake);
                                    }
                                } else if (!rVarA.a()) {
                                    this.f43779c.a(pVarTake.j(), true);
                                    pVarTake.a((b.a) null);
                                    if (!this.f43782f.b(pVarTake)) {
                                        this.f43778b.put(pVarTake);
                                    }
                                } else if (aVarA.f43774f < jCurrentTimeMillis) {
                                    pVarTake.a(aVarA);
                                    rVarA.f43846d = true;
                                    if (this.f43782f.b(pVarTake)) {
                                        this.f43780d.a(pVarTake, rVarA);
                                    } else {
                                        this.f43780d.a(pVarTake, rVarA, new Runnable() { // from class: com.mbridge.msdk.e.a.c.1
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                try {
                                                    c.this.f43778b.put(pVarTake);
                                                } catch (InterruptedException unused) {
                                                    Thread.currentThread().interrupt();
                                                }
                                            }
                                        });
                                    }
                                } else {
                                    this.f43780d.a(pVarTake, rVarA);
                                }
                            }
                        } else if (!this.f43782f.b(pVarTake)) {
                            this.f43778b.put(pVarTake);
                        }
                    }
                    pVarTake.b(2);
                } catch (Throwable th2) {
                    pVarTake.b(2);
                    throw th2;
                }
            } catch (InterruptedException unused) {
                if (this.f43781e) {
                    Thread.currentThread().interrupt();
                    return;
                }
                aa.c("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}
