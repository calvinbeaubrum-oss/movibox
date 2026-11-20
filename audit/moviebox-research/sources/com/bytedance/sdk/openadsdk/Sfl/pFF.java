package com.bytedance.sdk.openadsdk.Sfl;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class pFF {
    private sc ExN;
    private int We;
    private Qj pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private ScheduledExecutorService f27243sc = null;
    private long zY = 0;

    /* JADX INFO: compiled from: source.java */
    public interface sc {
    }

    public pFF(Qj qj2, int i11) {
        this.pFF = qj2;
        this.We = i11;
    }

    public boolean pFF() {
        ScheduledExecutorService scheduledExecutorService = this.f27243sc;
        if (scheduledExecutorService != null) {
            return scheduledExecutorService.isShutdown();
        }
        return true;
    }

    public void sc() {
        ScheduledExecutorService scheduledExecutorService = this.f27243sc;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdown();
        }
    }

    public void sc(int i11) {
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1);
        this.f27243sc = scheduledExecutorServiceNewScheduledThreadPool;
        scheduledExecutorServiceNewScheduledThreadPool.scheduleAtFixedRate(new Runnable() { // from class: com.bytedance.sdk.openadsdk.Sfl.pFF.1
            @Override // java.lang.Runnable
            public void run() {
                System.currentTimeMillis();
                long unused = pFF.this.zY;
                if (System.currentTimeMillis() - pFF.this.zY > pFF.this.We) {
                    pFF.this.f27243sc.shutdown();
                    if (pFF.this.pFF != null) {
                        pFF.this.pFF.pFF(0, "Automatic detection of stuck");
                    }
                    if (pFF.this.ExN != null) {
                        sc unused2 = pFF.this.ExN;
                    }
                }
            }
        }, 0L, i11, TimeUnit.MILLISECONDS);
    }

    public void sc(long j11) {
        this.zY = j11;
    }
}
