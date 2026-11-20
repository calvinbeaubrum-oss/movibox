package com.bytedance.sdk.component.Qj.zY;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.applovin.sdk.AppLovinMediationProvider;
import com.bytedance.sdk.component.utils.Tf;
import com.google.android.gms.common.api.Api;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class TRI extends ThreadPoolExecutor {
    private int ExN;
    private LinkedHashMap<String, com.bytedance.sdk.component.Qj.zY.sc.sc> Qj;
    private int TRI;
    private int We;
    private int pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private boolean f26572qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final String f26573sc;
    private int zY;

    /* JADX INFO: compiled from: source.java */
    public static class sc {

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private String f26578sc = "cache";
        private int pFF = 4;
        private int zY = 100;
        private int We = 0;
        private long ExN = 30000;
        private boolean TRI = false;

        /* JADX INFO: renamed from: qr, reason: collision with root package name */
        private TimeUnit f26577qr = TimeUnit.MILLISECONDS;
        private int Qj = -1;
        private int Ol = 20;
        private boolean WH = false;
        private BlockingQueue<Runnable> UFX = new PriorityBlockingQueue();
        private ThreadFactory Tf = null;

        public sc ExN(int i11) {
            this.Qj = i11;
            return this;
        }

        public sc We(int i11) {
            this.Ol = i11;
            return this;
        }

        public sc pFF(int i11) {
            this.zY = i11;
            return this;
        }

        public sc pFF(boolean z11) {
            this.WH = z11;
            return this;
        }

        public sc sc(int i11) {
            this.pFF = i11;
            return this;
        }

        public sc sc(long j11) {
            this.ExN = j11;
            return this;
        }

        public sc sc(String str) {
            this.f26578sc = str;
            return this;
        }

        public sc sc(boolean z11) {
            this.TRI = z11;
            return this;
        }

        public TRI sc() {
            if (this.Tf == null) {
                this.Tf = new We(this.f26578sc);
            }
            if (this.pFF < 0) {
                this.pFF = 8;
            }
            if (this.pFF == 0) {
                this.UFX = new SynchronousQueue();
            }
            if (this.UFX == null) {
                this.UFX = new LinkedBlockingQueue();
            }
            if (this.zY > 100) {
                this.zY = 100;
            }
            int i11 = this.zY;
            int i12 = this.pFF;
            if (i11 < i12) {
                this.zY = i12;
            }
            if (this.Ol < 0) {
                this.Ol = 20;
            }
            if (this.Ol > 100) {
                this.Ol = 100;
            }
            return new TRI(this);
        }

        public sc zY(int i11) {
            this.We = i11;
            return this;
        }
    }

    private TRI(sc scVar) {
        super(scVar.pFF, Api.BaseClientBuilder.API_PRIORITY_OTHER, scVar.ExN, scVar.f26577qr, (BlockingQueue<Runnable>) scVar.UFX, scVar.Tf);
        this.f26572qr = false;
        String unused = scVar.f26578sc;
        int unused2 = scVar.pFF;
        int unused3 = scVar.zY;
        long unused4 = scVar.ExN;
        int unused5 = scVar.We;
        int unused6 = scVar.Ol;
        boolean unused7 = scVar.WH;
        BlockingQueue unused8 = scVar.UFX;
        this.f26573sc = scVar.f26578sc;
        this.We = scVar.pFF;
        this.ExN = scVar.zY;
        this.TRI = scVar.We;
        allowCoreThreadTimeOut(scVar.TRI);
        this.pFF = scVar.Qj;
        this.zY = scVar.Ol;
        this.f26572qr = scVar.WH;
        if (qr()) {
            final int i11 = this.zY + 4;
            this.Qj = new LinkedHashMap<String, com.bytedance.sdk.component.Qj.zY.sc.sc>(i11, 0.75f, true) { // from class: com.bytedance.sdk.component.Qj.zY.TRI.1
                @Override // java.util.LinkedHashMap
                public boolean removeEldestEntry(Map.Entry<String, com.bytedance.sdk.component.Qj.zY.sc.sc> entry) {
                    return size() > i11;
                }
            };
        }
    }

    private void ExN() {
        try {
            if (this.We != 0 && getCorePoolSize() > this.We && getQueue().size() == 0) {
                setCorePoolSize(this.We);
            }
        } catch (Exception e11) {
            e11.getMessage();
        }
    }

    private void TRI() {
        if (getCompletedTaskCount() > this.pFF) {
            ExN exNSc = zY.sc();
            if (exNSc != null) {
                exNSc.sc(this);
            }
            this.pFF = -1;
        }
    }

    private void We() {
        try {
            if (this.We != 0 && getCorePoolSize() < this.ExN) {
                int size = getQueue().size();
                if (getActiveCount() < this.We || size < this.TRI) {
                    return;
                }
                setCorePoolSize(this.ExN);
            }
        } catch (Exception e11) {
            e11.getMessage();
        }
    }

    private boolean qr() {
        return this.pFF > 0;
    }

    private void sc(pFF pff) {
        LinkedHashMap<String, com.bytedance.sdk.component.Qj.zY.sc.sc> linkedHashMap = this.Qj;
        if (linkedHashMap != null) {
            com.bytedance.sdk.component.Qj.zY.sc.sc scVar = linkedHashMap.get(pff.pFF());
            if (scVar == null) {
                synchronized (linkedHashMap) {
                    try {
                        scVar = linkedHashMap.get(pff.pFF());
                        if (scVar == null) {
                            scVar = new com.bytedance.sdk.component.Qj.zY.sc.sc();
                            linkedHashMap.put(pff.pFF(), scVar);
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
            scVar.sc(pff);
        }
    }

    private void sc(Runnable runnable, Throwable th2) {
        try {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                runnable.run();
                return;
            }
            Handler handlerZY = zY.zY();
            if (handlerZY != null) {
                handlerZY.post(runnable);
            }
        } catch (Throwable th3) {
            Tf.sc("PAGThreadPoolExecutor", "try exc failed", th3);
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void afterExecute(Runnable runnable, Throwable th2) {
        boolean z11 = runnable instanceof pFF;
        if (z11) {
            ((pFF) runnable).zY(SystemClock.elapsedRealtime());
            try {
                if (qr() && this.Qj != null) {
                    sc((pFF) runnable);
                    TRI();
                }
            } catch (Exception e11) {
                Tf.sc("PAGThreadPoolExecutor", e11.getMessage());
            }
        }
        super.afterExecute(runnable, th2);
        if (z11) {
            pFF pff = (pFF) runnable;
            pff.pFF();
            pff.sc();
            pff.zY();
            pff.We();
            pff.ExN();
        }
        ExN();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void beforeExecute(Thread thread, Runnable runnable) {
        if (runnable instanceof pFF) {
            ((pFF) runnable).pFF(SystemClock.elapsedRealtime());
        }
        super.beforeExecute(thread, runnable);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        com.bytedance.sdk.component.Qj.zY.sc scVarPFF;
        if (!(runnable instanceof pFF)) {
            runnable = new pFF(AppLovinMediationProvider.UNKNOWN, runnable) { // from class: com.bytedance.sdk.component.Qj.zY.TRI.3
                @Override // java.lang.Runnable
                public void run() {
                    Runnable runnableQj = Qj();
                    if (runnableQj != null) {
                        runnableQj.run();
                    }
                }
            };
        }
        if (!"cache".equals(this.f26573sc)) {
            String name = Thread.currentThread().getName();
            if (!TextUtils.isEmpty(name) && name.startsWith(We.sc(this.f26573sc)) && (scVarPFF = zY.pFF()) != null) {
                scVarPFF.sc(this, (pFF) runnable);
            }
        }
        ((pFF) runnable).sc(SystemClock.elapsedRealtime());
        try {
            super.execute(runnable);
            We();
        } catch (Throwable th2) {
            sc(runnable, th2);
        }
    }

    public String pFF() {
        return this.f26573sc;
    }

    public LinkedHashMap<String, com.bytedance.sdk.component.Qj.zY.sc.sc> sc() {
        return this.Qj;
    }

    public void sc(sc scVar) {
        try {
            if (scVar.pFF >= 0 && this.We != scVar.pFF) {
                int i11 = scVar.pFF;
                this.We = i11;
                setCorePoolSize(i11);
            }
            this.ExN = scVar.zY;
            this.TRI = scVar.We;
            allowCoreThreadTimeOut(scVar.TRI);
            this.pFF = scVar.Qj;
            this.zY = scVar.Ol;
            this.f26572qr = scVar.WH;
        } catch (Throwable th2) {
            Tf.sc("PAGThreadPoolExecutor", th2.getMessage());
        }
        String unused = scVar.f26578sc;
        int unused2 = scVar.pFF;
        int unused3 = scVar.zY;
        long unused4 = scVar.ExN;
        int unused5 = scVar.We;
        int unused6 = scVar.Ol;
        boolean unused7 = scVar.WH;
        BlockingQueue unused8 = scVar.UFX;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public void shutdown() {
        if ("aidl".equals(this.f26573sc)) {
            return;
        }
        super.shutdown();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        return "aidl".equals(this.f26573sc) ? Collections.emptyList() : super.shutdownNow();
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        int iSc;
        String strPFF;
        runnable.getClass();
        final RunnableFuture runnableFutureNewTaskFor = newTaskFor(runnable, null);
        if (runnable instanceof pFF) {
            pFF pff = (pFF) runnable;
            iSc = pff.sc();
            strPFF = pff.pFF();
        } else {
            iSc = 6;
            strPFF = "";
        }
        if (iSc == 0 || TextUtils.isEmpty(strPFF)) {
            new RuntimeException();
        }
        execute(new pFF(iSc, strPFF) { // from class: com.bytedance.sdk.component.Qj.zY.TRI.2
            @Override // java.lang.Runnable
            public void run() {
                runnableFutureNewTaskFor.run();
            }
        });
        return runnableFutureNewTaskFor;
    }

    public boolean zY() {
        return this.f26572qr;
    }
}
