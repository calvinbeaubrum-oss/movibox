package com.google.firebase.crashlytics.internal.send;

import android.annotation.SuppressLint;
import cg.g;
import cg.i;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.l;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.crashlytics.internal.common.Utils;
import com.google.firebase.crashlytics.internal.common.j;
import com.google.firebase.crashlytics.internal.common.t;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import gk.f;
import java.util.Locale;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public final class ReportQueue {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f40553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f40554b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f40555c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f40556d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final BlockingQueue<Runnable> f40557e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ThreadPoolExecutor f40558f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final g<CrashlyticsReport> f40559g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final t f40560h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f40561i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f40562j;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes6.dex */
    public final class ReportRunnable implements Runnable {
        private final j reportWithSessionId;
        private final TaskCompletionSource<j> tcs;

        private ReportRunnable(j jVar, TaskCompletionSource<j> taskCompletionSource) {
            this.reportWithSessionId = jVar;
            this.tcs = taskCompletionSource;
        }

        @Override // java.lang.Runnable
        public void run() {
            ReportQueue.this.p(this.reportWithSessionId, this.tcs);
            ReportQueue.this.f40560h.c();
            double dG = ReportQueue.this.g();
            f.f().b("Delay for: " + String.format(Locale.US, "%.2f", Double.valueOf(dG / 1000.0d)) + " s for report: " + this.reportWithSessionId.d());
            ReportQueue.q(dG);
        }
    }

    public ReportQueue(double d11, double d12, long j11, g<CrashlyticsReport> gVar, t tVar) {
        this.f40553a = d11;
        this.f40554b = d12;
        this.f40555c = j11;
        this.f40559g = gVar;
        this.f40560h = tVar;
        int i11 = (int) d11;
        this.f40556d = i11;
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(i11);
        this.f40557e = arrayBlockingQueue;
        this.f40558f = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, arrayBlockingQueue);
        this.f40561i = 0;
        this.f40562j = 0L;
    }

    public ReportQueue(g<CrashlyticsReport> gVar, ok.d dVar, t tVar) {
        this(dVar.f72461f, dVar.f72462g, ((long) dVar.f72463h) * 1000, gVar, tVar);
    }

    public static void q(double d11) {
        try {
            Thread.sleep((long) d11);
        } catch (InterruptedException unused) {
        }
    }

    public final double g() {
        return Math.min(3600000.0d, (60000.0d / this.f40553a) * Math.pow(this.f40554b, h()));
    }

    public final int h() {
        if (this.f40562j == 0) {
            this.f40562j = o();
        }
        int iO = (int) ((o() - this.f40562j) / this.f40555c);
        int iMin = l() ? Math.min(100, this.f40561i + iO) : Math.max(0, this.f40561i - iO);
        if (this.f40561i != iMin) {
            this.f40561i = iMin;
            this.f40562j = o();
        }
        return iMin;
    }

    public TaskCompletionSource<j> i(j jVar, boolean z11) {
        synchronized (this.f40557e) {
            try {
                TaskCompletionSource<j> taskCompletionSource = new TaskCompletionSource<>();
                if (!z11) {
                    p(jVar, taskCompletionSource);
                    return taskCompletionSource;
                }
                this.f40560h.b();
                if (!k()) {
                    h();
                    f.f().b("Dropping report due to queue being full: " + jVar.d());
                    this.f40560h.a();
                    taskCompletionSource.trySetResult(jVar);
                    return taskCompletionSource;
                }
                f.f().b("Enqueueing report: " + jVar.d());
                f.f().b("Queue size: " + this.f40557e.size());
                this.f40558f.execute(new ReportRunnable(jVar, taskCompletionSource));
                f.f().b("Closing task for report: " + jVar.d());
                taskCompletionSource.trySetResult(jVar);
                return taskCompletionSource;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @SuppressLint({"DiscouragedApi"})
    public void j() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(new Runnable() { // from class: com.google.firebase.crashlytics.internal.send.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f40572a.m(countDownLatch);
            }
        }).start();
        Utils.e(countDownLatch, 2L, TimeUnit.SECONDS);
    }

    public final boolean k() {
        return this.f40557e.size() < this.f40556d;
    }

    public final boolean l() {
        return this.f40557e.size() == this.f40556d;
    }

    public final /* synthetic */ void m(CountDownLatch countDownLatch) {
        l.a(this.f40559g, Priority.HIGHEST);
        countDownLatch.countDown();
    }

    public final /* synthetic */ void n(TaskCompletionSource taskCompletionSource, j jVar, Exception exc) {
        if (exc != null) {
            taskCompletionSource.trySetException(exc);
        } else {
            j();
            taskCompletionSource.trySetResult(jVar);
        }
    }

    public final long o() {
        return System.currentTimeMillis();
    }

    public final void p(final j jVar, final TaskCompletionSource<j> taskCompletionSource) {
        f.f().b("Sending report through Google DataTransport: " + jVar.d());
        this.f40559g.b(cg.d.g(jVar.b()), new i() { // from class: com.google.firebase.crashlytics.internal.send.c
            @Override // cg.i
            public final void a(Exception exc) {
                this.f40569a.n(taskCompletionSource, jVar, exc);
            }
        });
    }
}
