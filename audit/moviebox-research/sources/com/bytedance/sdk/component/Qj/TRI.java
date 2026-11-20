package com.bytedance.sdk.component.Qj;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class TRI extends ExN {
    private static volatile ThreadPoolExecutor ExN;
    private static volatile ThreadPoolExecutor Ol;
    private static volatile ThreadPoolExecutor Qj;
    private static volatile ThreadPoolExecutor TRI;
    private static volatile ScheduledExecutorService UFX;
    private static volatile ThreadPoolExecutor WH;
    public static zY pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private static volatile ThreadPoolExecutor f26556qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static final int f26557sc = Runtime.getRuntime().availableProcessors();
    public static int zY = 120;
    public static boolean We = true;

    public static ExecutorService ExN() {
        if (WH == null) {
            synchronized (TRI.class) {
                try {
                    if (WH == null) {
                        sc scVarSc = new sc.C0246sc().sc("aidl").pFF(10).sc(2).sc(30L).sc(TimeUnit.SECONDS).sc(new PriorityBlockingQueue()).sc(Qj()).sc(ExN.sc().createThreadFactory(10, "aidl")).sc();
                        WH = scVarSc;
                        scVarSc.allowCoreThreadTimeOut(true);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return WH;
    }

    public static void ExN(Qj qj2) {
        if (f26556qr == null) {
            pFF(5);
        }
        if (qj2 == null || f26556qr == null) {
            return;
        }
        f26556qr.execute(qj2);
    }

    public static zY Ol() {
        return pFF;
    }

    public static RejectedExecutionHandler Qj() {
        return new RejectedExecutionHandler() { // from class: com.bytedance.sdk.component.Qj.TRI.1
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            }
        };
    }

    public static ScheduledExecutorService TRI() {
        if (UFX == null) {
            synchronized (TRI.class) {
                try {
                    if (UFX == null) {
                        UFX = Executors.newSingleThreadScheduledExecutor(ExN.sc().createThreadFactory(5, "scheduled"));
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return UFX;
    }

    public static ExecutorService WH() {
        if (Ol == null) {
            synchronized (TRI.class) {
                try {
                    if (Ol == null) {
                        sc scVarSc = new sc.C0246sc().sc("computation").sc(3).pFF(10).sc(20L).sc(TimeUnit.SECONDS).sc(new PriorityBlockingQueue()).sc(Qj()).sc(ExN.sc().createThreadFactory(10, "computation")).sc();
                        Ol = scVarSc;
                        scVarSc.allowCoreThreadTimeOut(true);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return Ol;
    }

    public static ExecutorService We() {
        if (Qj == null) {
            synchronized (TRI.class) {
                try {
                    if (Qj == null) {
                        sc scVarSc = new sc.C0246sc().sc("log").pFF(10).sc(4).sc(20L).sc(TimeUnit.SECONDS).sc(new PriorityBlockingQueue()).sc(Qj()).sc(ExN.sc().createThreadFactory(10, "log")).sc();
                        Qj = scVarSc;
                        scVarSc.allowCoreThreadTimeOut(true);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return Qj;
    }

    public static void We(Qj qj2) {
        if (WH == null) {
            ExN();
        }
        if (qj2 == null || WH == null) {
            return;
        }
        WH.execute(qj2);
    }

    public static ExecutorService pFF() {
        if (ExN == null) {
            synchronized (TRI.class) {
                try {
                    if (ExN == null) {
                        ExN = new sc.C0246sc().sc("init").sc(0).pFF(10).sc(5L).sc(TimeUnit.SECONDS).sc(new SynchronousQueue()).sc(Qj()).sc(ExN.sc().createThreadFactory(10, "init")).sc();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return ExN;
    }

    public static ExecutorService pFF(int i11) {
        if (f26556qr == null) {
            synchronized (TRI.class) {
                try {
                    if (f26556qr == null) {
                        sc scVarSc = new sc.C0246sc().sc("ad").sc(2).pFF(i11).sc(20L).sc(TimeUnit.SECONDS).sc(new LinkedBlockingQueue()).sc(Qj()).sc(ExN.sc().createThreadFactory(i11, "ad")).sc();
                        f26556qr = scVarSc;
                        scVarSc.allowCoreThreadTimeOut(true);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f26556qr;
    }

    public static void pFF(Qj qj2) {
        if (TRI == null) {
            zY();
        }
        if (TRI != null) {
            TRI.execute(qj2);
        }
    }

    public static void pFF(Qj qj2, int i11) {
        if (qj2 != null) {
            qj2.setPriority(i11);
        }
        zY(qj2);
    }

    public static boolean qr() {
        return We;
    }

    public static ExecutorService sc(int i11) {
        if (TRI == null) {
            synchronized (TRI.class) {
                try {
                    if (TRI == null) {
                        sc scVarSc = new sc.C0246sc().sc("io").sc(2).pFF(i11).sc(20L).sc(TimeUnit.SECONDS).sc(new LinkedBlockingQueue()).sc(Qj()).sc(ExN.sc().createThreadFactory(i11, "io")).sc();
                        TRI = scVarSc;
                        scVarSc.allowCoreThreadTimeOut(true);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return TRI;
    }

    public static void sc(Qj qj2) {
        if (ExN == null) {
            pFF();
        }
        if (qj2 == null || ExN == null) {
            return;
        }
        ExN.execute(qj2);
    }

    public static void sc(Qj qj2, int i11) {
        pFF(qj2);
    }

    public static void sc(Qj qj2, int i11, int i12) {
        if (TRI == null) {
            sc(i12);
        }
        if (qj2 == null || TRI == null) {
            return;
        }
        qj2.setPriority(i11);
        TRI.execute(qj2);
    }

    public static void sc(zY zYVar) {
        pFF = zYVar;
    }

    public static void sc(boolean z11) {
        We = z11;
    }

    public static ExecutorService zY() {
        return sc(10);
    }

    public static void zY(int i11) {
        zY = i11;
    }

    public static void zY(Qj qj2) {
        if (Qj == null) {
            We();
        }
        if (qj2 == null || Qj == null) {
            return;
        }
        Qj.execute(qj2);
    }

    public static void zY(Qj qj2, int i11) {
        if (qj2 != null) {
            qj2.setPriority(i11);
        }
        We(qj2);
    }
}
