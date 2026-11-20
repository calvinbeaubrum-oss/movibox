package com.transsion.player.shorttv.preload;

import androidx.annotation.Nullable;
import androidx.media3.common.PriorityTaskManager;
import androidx.media3.common.b0;
import androidx.media3.common.util.RunnableFutureTask;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class VideoProgressiveDownloader implements androidx.media3.exoplayer.offline.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f54783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c4.g f54784b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final androidx.media3.datasource.cache.a f54785c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final androidx.media3.datasource.cache.i f54786d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final PriorityTaskManager f54787e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public androidx.media3.exoplayer.offline.o.a f54788f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile RunnableFutureTask<Void, IOException> f54789g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f54790h;

    public VideoProgressiveDownloader(b0 b0Var, androidx.media3.datasource.cache.a.c cVar, Executor executor) {
        this.f54783a = (Executor) z3.a.e(executor);
        z3.a.e(b0Var.f8951b);
        c4.g gVarA = new c4.g.b().i(b0Var.f8951b.f9047a).f(b0Var.f8951b.f9051e).b(4).a();
        this.f54784b = gVarA;
        androidx.media3.datasource.cache.a aVarB = cVar.b();
        this.f54785c = aVarB;
        this.f54786d = new androidx.media3.datasource.cache.i(aVarB, gVarA, null, new androidx.media3.datasource.cache.i.a() { // from class: com.transsion.player.shorttv.preload.o
            @Override // androidx.media3.datasource.cache.i.a
            public final void a(long j11, long j12, long j13) {
                this.f54821a.d(j11, j12, j13);
            }
        });
        this.f54787e = cVar.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(long j11, long j12, long j13) {
        androidx.media3.exoplayer.offline.o.a aVar = this.f54788f;
        if (aVar == null) {
            return;
        }
        aVar.onProgress(j11, j12, (j11 == -1 || j11 == 0) ? -1.0f : (j12 * 100.0f) / j11);
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0021 */
    @Override // androidx.media3.exoplayer.offline.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(@Nullable androidx.media3.exoplayer.offline.o.a aVar) throws InterruptedException, IOException {
        this.f54788f = aVar;
        PriorityTaskManager priorityTaskManager = this.f54787e;
        if (priorityTaskManager != null) {
            priorityTaskManager.a(-1000);
        }
        boolean z11 = false;
        while (!z11) {
            if (this.f54790h) {
                break;
            }
            this.f54789g = new RunnableFutureTask<Void, IOException>() { // from class: com.transsion.player.shorttv.preload.VideoProgressiveDownloader.1
                @Override // androidx.media3.common.util.RunnableFutureTask
                public void cancelWork() {
                    VideoProgressiveDownloader.this.f54786d.b();
                }

                @Override // androidx.media3.common.util.RunnableFutureTask
                public Void doWork() throws IOException {
                    VideoProgressiveDownloader.this.f54786d.a();
                    return null;
                }
            };
            PriorityTaskManager priorityTaskManager2 = this.f54787e;
            if (priorityTaskManager2 != null) {
                priorityTaskManager2.b(-1000);
            }
            this.f54783a.execute(this.f54789g);
            try {
                this.f54789g.get();
                z11 = true;
            } catch (ExecutionException e11) {
                Throwable th2 = (Throwable) z3.a.e(e11.getCause());
                if (!(th2 instanceof PriorityTaskManager.PriorityTooLowException)) {
                    if (th2 instanceof IOException) {
                        throw ((IOException) th2);
                    }
                    u0.m1(th2);
                }
            }
        }
        ((RunnableFutureTask) z3.a.e(this.f54789g)).blockUntilFinished();
        PriorityTaskManager priorityTaskManager3 = this.f54787e;
        if (priorityTaskManager3 != null) {
            priorityTaskManager3.d(-1000);
        }
    }

    @Override // androidx.media3.exoplayer.offline.o
    public void cancel() {
        this.f54790h = true;
        RunnableFutureTask<Void, IOException> runnableFutureTask = this.f54789g;
        if (runnableFutureTask != null) {
            runnableFutureTask.cancel(true);
        }
    }

    @Override // androidx.media3.exoplayer.offline.o
    public void remove() {
    }
}
