package com.bytedance.sdk.component.Qj;

import android.os.Looper;
import android.text.TextUtils;
import com.applovin.sdk.AppLovinMediationProvider;
import com.bytedance.sdk.component.utils.Tf;
import com.google.android.gms.common.api.Api;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
class sc extends ThreadPoolExecutor {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private String f26563sc;

    /* JADX INFO: renamed from: com.bytedance.sdk.component.Qj.sc$sc, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0246sc {
        private RejectedExecutionHandler Qj;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private String f26566sc = "io";
        private int pFF = 1;
        private long zY = 30;
        private TimeUnit We = TimeUnit.SECONDS;
        private int ExN = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        private BlockingQueue<Runnable> TRI = null;

        /* JADX INFO: renamed from: qr, reason: collision with root package name */
        private ThreadFactory f26565qr = null;
        private int Ol = 5;

        public C0246sc pFF(int i11) {
            this.Ol = i11;
            return this;
        }

        public C0246sc sc(int i11) {
            this.pFF = i11;
            return this;
        }

        public C0246sc sc(long j11) {
            this.zY = j11;
            return this;
        }

        public C0246sc sc(String str) {
            this.f26566sc = str;
            return this;
        }

        public C0246sc sc(BlockingQueue<Runnable> blockingQueue) {
            this.TRI = blockingQueue;
            return this;
        }

        public C0246sc sc(RejectedExecutionHandler rejectedExecutionHandler) {
            this.Qj = rejectedExecutionHandler;
            return this;
        }

        public C0246sc sc(ThreadFactory threadFactory) {
            this.f26565qr = threadFactory;
            return this;
        }

        public C0246sc sc(TimeUnit timeUnit) {
            this.We = timeUnit;
            return this;
        }

        public sc sc() {
            if (this.f26565qr == null) {
                this.f26565qr = ExN.sc().createThreadFactory(this.Ol, this.f26566sc);
            }
            if (this.Qj == null) {
                this.Qj = TRI.Qj();
            }
            if (this.TRI == null) {
                this.TRI = new LinkedBlockingQueue();
            }
            return new sc(this.f26566sc, this.pFF, this.ExN, this.zY, this.We, this.TRI, this.f26565qr, this.Qj);
        }
    }

    public sc(String str, int i11, int i12, long j11, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i11, i12, j11, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler);
        this.f26563sc = str;
    }

    private void sc(Runnable runnable) {
        try {
            super.execute(runnable);
        } catch (OutOfMemoryError e11) {
            sc(runnable, e11);
        } catch (Throwable th2) {
            sc(runnable, th2);
        }
    }

    private void sc(Runnable runnable, OutOfMemoryError outOfMemoryError) {
        sc(runnable, (Throwable) outOfMemoryError);
    }

    private void sc(Runnable runnable, Throwable th2) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            try {
                runnable.run();
            } catch (Throwable th3) {
                Tf.sc("", "try exc failed", th3);
            }
        }
    }

    private void sc(BlockingQueue<Runnable> blockingQueue, int i11) {
        if (getCorePoolSize() == i11 || blockingQueue == null || blockingQueue.size() > 0) {
            return;
        }
        try {
            setCorePoolSize(i11);
            getCorePoolSize();
            getMaximumPoolSize();
        } catch (Exception e11) {
            e11.getMessage();
        }
    }

    private void sc(BlockingQueue<Runnable> blockingQueue, int i11, int i12) {
        if (getCorePoolSize() == i11 || blockingQueue == null || blockingQueue.size() < i12) {
            return;
        }
        try {
            setCorePoolSize(i11);
            getCorePoolSize();
            getMaximumPoolSize();
        } catch (Exception e11) {
            e11.getMessage();
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void afterExecute(Runnable runnable, Throwable th2) {
        BlockingQueue<Runnable> queue;
        super.afterExecute(runnable, th2);
        if (!TRI.qr() || TextUtils.isEmpty(this.f26563sc) || (queue = getQueue()) == null) {
            return;
        }
        String str = this.f26563sc;
        str.hashCode();
        switch (str) {
            case "io":
                sc(queue, 2);
                break;
            case "log":
                sc(queue, 4);
                break;
            case "aidl":
                sc(queue, 2);
                break;
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(final Runnable runnable) {
        BlockingQueue<Runnable> queue;
        if (runnable instanceof Qj) {
            sc(new pFF((Qj) runnable, this));
        } else {
            sc(new pFF(new Qj(AppLovinMediationProvider.UNKNOWN) { // from class: com.bytedance.sdk.component.Qj.sc.1
                @Override // java.lang.Runnable
                public void run() {
                    runnable.run();
                }
            }, this));
        }
        if (!TRI.qr() || TextUtils.isEmpty(this.f26563sc) || (queue = getQueue()) == null) {
            return;
        }
        String str = this.f26563sc;
        str.hashCode();
        switch (str) {
            case "io":
                sc(queue, TRI.f26557sc + 2, getCorePoolSize() * 2);
                break;
            case "log":
                sc(queue, 8, 8);
                break;
            case "aidl":
                sc(queue, 5, 5);
                break;
        }
    }

    public String sc() {
        return this.f26563sc;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public void shutdown() {
        if ("io".equals(this.f26563sc) || "aidl".equals(this.f26563sc)) {
            return;
        }
        super.shutdown();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        return ("io".equals(this.f26563sc) || "aidl".equals(this.f26563sc)) ? Collections.emptyList() : super.shutdownNow();
    }
}
