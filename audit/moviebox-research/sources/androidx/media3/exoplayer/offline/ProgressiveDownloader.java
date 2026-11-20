package androidx.media3.exoplayer.offline;

import androidx.annotation.Nullable;
import androidx.media3.common.PriorityTaskManager;
import androidx.media3.common.b0;
import androidx.media3.common.util.RunnableFutureTask;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class ProgressiveDownloader implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f10864a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c4.g f10865b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final androidx.media3.datasource.cache.a f10866c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final androidx.media3.datasource.cache.i f10867d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final PriorityTaskManager f10868e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public o.a f10869f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile RunnableFutureTask<Void, IOException> f10870g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f10871h;

    public ProgressiveDownloader(b0 b0Var, androidx.media3.datasource.cache.a.c cVar, Executor executor) {
        this.f10864a = (Executor) z3.a.e(executor);
        z3.a.e(b0Var.f8951b);
        c4.g gVarA = new c4.g.b().i(b0Var.f8951b.f9047a).f(b0Var.f8951b.f9051e).b(4).a();
        this.f10865b = gVarA;
        androidx.media3.datasource.cache.a aVarB = cVar.b();
        this.f10866c = aVarB;
        this.f10867d = new androidx.media3.datasource.cache.i(aVarB, gVarA, null, new androidx.media3.datasource.cache.i.a() { // from class: androidx.media3.exoplayer.offline.s
            @Override // androidx.media3.datasource.cache.i.a
            public final void a(long j11, long j12, long j13) {
                this.f10919a.d(j11, j12, j13);
            }
        });
        this.f10868e = cVar.g();
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0021 */
    @Override // androidx.media3.exoplayer.offline.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(@Nullable o.a aVar) throws InterruptedException, IOException {
        this.f10869f = aVar;
        PriorityTaskManager priorityTaskManager = this.f10868e;
        if (priorityTaskManager != null) {
            priorityTaskManager.a(-1000);
        }
        boolean z11 = false;
        while (!z11) {
            if (this.f10871h) {
                break;
            }
            this.f10870g = new RunnableFutureTask<Void, IOException>() { // from class: androidx.media3.exoplayer.offline.ProgressiveDownloader.1
                @Override // androidx.media3.common.util.RunnableFutureTask
                public void cancelWork() {
                    ProgressiveDownloader.this.f10867d.b();
                }

                @Override // androidx.media3.common.util.RunnableFutureTask
                public Void doWork() throws IOException {
                    ProgressiveDownloader.this.f10867d.a();
                    return null;
                }
            };
            PriorityTaskManager priorityTaskManager2 = this.f10868e;
            if (priorityTaskManager2 != null) {
                priorityTaskManager2.b(-1000);
            }
            this.f10864a.execute(this.f10870g);
            try {
                this.f10870g.get();
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
        ((RunnableFutureTask) z3.a.e(this.f10870g)).blockUntilFinished();
        PriorityTaskManager priorityTaskManager3 = this.f10868e;
        if (priorityTaskManager3 != null) {
            priorityTaskManager3.d(-1000);
        }
    }

    @Override // androidx.media3.exoplayer.offline.o
    public void cancel() {
        this.f10871h = true;
        RunnableFutureTask<Void, IOException> runnableFutureTask = this.f10870g;
        if (runnableFutureTask != null) {
            runnableFutureTask.cancel(true);
        }
    }

    public final void d(long j11, long j12, long j13) {
        o.a aVar = this.f10869f;
        if (aVar == null) {
            return;
        }
        aVar.onProgress(j11, j12, (j11 == -1 || j11 == 0) ? -1.0f : (j12 * 100.0f) / j11);
    }

    @Override // androidx.media3.exoplayer.offline.o
    public void remove() {
        this.f10866c.e().e(this.f10866c.f().a(this.f10865b));
    }
}
