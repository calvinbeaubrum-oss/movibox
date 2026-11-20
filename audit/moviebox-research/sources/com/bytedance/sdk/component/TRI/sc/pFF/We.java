package com.bytedance.sdk.component.TRI.sc.pFF;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.component.TRI.sc.ExN;
import com.bytedance.sdk.component.TRI.sc.Qj;
import java.util.Comparator;
import java.util.concurrent.Executor;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class We {
    private volatile com.bytedance.sdk.component.TRI.sc.pFF.zY.zY Ol;
    private final PriorityBlockingQueue<com.bytedance.sdk.component.TRI.sc.We.sc> Tf;
    private final Comparator<com.bytedance.sdk.component.TRI.sc.We.sc> UFX;
    private volatile Handler WH;
    public volatile boolean pFF = false;
    public volatile boolean zY = false;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static final We f26609sc = new We();
    public static final com.bytedance.sdk.component.TRI.sc.pFF.sc.sc We = new com.bytedance.sdk.component.TRI.sc.pFF.sc.sc();
    public static final AtomicLong ExN = new AtomicLong(0);
    public static final AtomicLong TRI = new AtomicLong(0);

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    public static final long f26608qr = System.currentTimeMillis();
    public static long Qj = 0;

    private We() {
        Comparator<com.bytedance.sdk.component.TRI.sc.We.sc> comparator = new Comparator<com.bytedance.sdk.component.TRI.sc.We.sc>() { // from class: com.bytedance.sdk.component.TRI.sc.pFF.We.1
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
            public int compare(com.bytedance.sdk.component.TRI.sc.We.sc scVar, com.bytedance.sdk.component.TRI.sc.We.sc scVar2) {
                return We.this.sc(scVar, scVar2);
            }
        };
        this.UFX = comparator;
        this.Tf = new PriorityBlockingQueue<>(8, comparator);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int sc(com.bytedance.sdk.component.TRI.sc.We.sc scVar, com.bytedance.sdk.component.TRI.sc.We.sc scVar2) {
        long jSc;
        long jPFF;
        long jPFF2;
        long jSc2;
        if (scVar == null) {
            return scVar2 == null ? 0 : -1;
        }
        if (scVar2 == null) {
            return 1;
        }
        if (scVar.ExN() != scVar2.ExN()) {
            return scVar.ExN() - scVar2.ExN();
        }
        if (scVar.sc() != null) {
            jSc = scVar.sc().sc();
            jPFF = scVar.sc().pFF();
        } else {
            jSc = 0;
            jPFF = 0;
        }
        if (scVar2.sc() != null) {
            jSc2 = scVar2.sc().sc();
            jPFF2 = scVar2.sc().pFF();
        } else {
            jPFF2 = 0;
            jSc2 = 0;
        }
        if (jSc == 0 || jSc2 == 0) {
            return 0;
        }
        long j11 = jSc - jSc2;
        if (Math.abs(j11) > 2147483647L) {
            return 0;
        }
        if (j11 != 0) {
            return (int) j11;
        }
        if (jPFF == 0 || jPFF2 == 0) {
            return 0;
        }
        return (int) (jPFF - jPFF2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(ExN exN, long j11) {
        com.bytedance.sdk.component.TRI.sc.pFF.zY.zY zYVar = this.Ol;
        if (exN == null || zYVar == null) {
            return;
        }
        com.bytedance.sdk.component.TRI.sc.pFF.sc.sc scVar = We;
        zYVar.sc(exN.sc(scVar.pFF(j11)), true);
        scVar.MxZ();
    }

    private void sc(final ExN exN, com.bytedance.sdk.component.TRI.sc.We.sc scVar) {
        if (exN != null) {
            try {
                if (exN.qr()) {
                    final long jPFF = (scVar == null || scVar.sc() == null) ? 0L : scVar.sc().pFF();
                    if (jPFF == 1) {
                        Qj = System.currentTimeMillis();
                    }
                    AtomicLong atomicLongFT = We.fT();
                    com.bytedance.sdk.component.TRI.sc.zY.pFF.sc(atomicLongFT, 1);
                    if (atomicLongFT.get() == 200) {
                        if (Looper.getMainLooper() != Looper.myLooper()) {
                            sc(exN, jPFF);
                            return;
                        }
                        Executor executorWe = exN.We();
                        if (executorWe == null) {
                            executorWe = exN.ExN();
                        }
                        if (executorWe != null) {
                            executorWe.execute(new com.bytedance.sdk.component.TRI.sc.ExN.ExN("report") { // from class: com.bytedance.sdk.component.TRI.sc.pFF.We.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    We.this.sc(exN, jPFF);
                                }
                            });
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public void ExN() {
        com.bytedance.sdk.component.TRI.sc.zY.pFF.sc(We.cJ(), 1);
        final com.bytedance.sdk.component.TRI.sc.pFF.zY.zY zYVar = this.Ol;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            if (zYVar != null) {
                zYVar.zY(2);
                return;
            }
            return;
        }
        ExN exNDE = Qj.qr().dE();
        if (exNDE != null) {
            Executor executorWe = exNDE.We();
            if (executorWe == null) {
                executorWe = exNDE.ExN();
            }
            if (executorWe != null) {
                executorWe.execute(new com.bytedance.sdk.component.TRI.sc.ExN.ExN("flush") { // from class: com.bytedance.sdk.component.TRI.sc.pFF.We.3
                    @Override // java.lang.Runnable
                    public void run() {
                        com.bytedance.sdk.component.TRI.sc.pFF.zY.zY zYVar2 = zYVar;
                        if (zYVar2 != null) {
                            zYVar2.zY(2);
                        }
                    }
                });
            }
        }
    }

    public boolean We() {
        try {
            if (this.Ol != null || com.bytedance.sdk.component.TRI.sc.pFF.pFF()) {
                return false;
            }
            synchronized (this) {
                if (this.Ol != null) {
                    return false;
                }
                this.Ol = new com.bytedance.sdk.component.TRI.sc.pFF.zY.zY(this.Tf);
                this.Ol.start();
                return true;
            }
        } catch (Throwable th2) {
            th2.getMessage();
            return false;
        }
    }

    public void pFF() {
        We();
        ExN();
    }

    public PriorityBlockingQueue<com.bytedance.sdk.component.TRI.sc.We.sc> sc() {
        return this.Tf;
    }

    public void sc(Handler handler) {
        this.WH = handler;
    }

    public void sc(com.bytedance.sdk.component.TRI.sc.We.sc scVar, int i11) {
        We();
        ExN exNDE = Qj.qr().dE();
        com.bytedance.sdk.component.TRI.sc.pFF.zY.zY zYVar = this.Ol;
        if (zYVar != null) {
            sc(exNDE, scVar);
            zYVar.sc(scVar, scVar.ExN() == 4);
        }
    }

    public void zY() {
        if (this.Ol == null || !this.Ol.isAlive()) {
            return;
        }
        synchronized (this) {
            try {
                if (this.Ol != null && this.Ol.isAlive()) {
                    if (this.WH != null) {
                        this.WH.removeCallbacksAndMessages(null);
                    }
                    this.Ol.sc(false);
                    this.Ol.quitSafely();
                    this.Ol = null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
