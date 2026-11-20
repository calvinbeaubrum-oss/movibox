package ul;

import androidx.annotation.Nullable;
import com.google.firebase.perf.util.StorageUnit;
import com.google.firebase.perf.util.Timer;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class l {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ql.a f78596f = ql.a.e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScheduledExecutorService f78597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentLinkedQueue<com.google.firebase.perf.v1.b> f78598b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Runtime f78599c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public ScheduledFuture f78600d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f78601e;

    public l() {
        this(Executors.newSingleThreadScheduledExecutor(), Runtime.getRuntime());
    }

    public l(ScheduledExecutorService scheduledExecutorService, Runtime runtime) {
        this.f78600d = null;
        this.f78601e = -1L;
        this.f78597a = scheduledExecutorService;
        this.f78598b = new ConcurrentLinkedQueue<>();
        this.f78599c = runtime;
    }

    public static boolean e(long j11) {
        return j11 <= 0;
    }

    public void c(Timer timer) {
        h(timer);
    }

    public final int d() {
        return com.google.firebase.perf.util.k.c(StorageUnit.BYTES.toKilobytes(this.f78599c.totalMemory() - this.f78599c.freeMemory()));
    }

    public final /* synthetic */ void f(Timer timer) {
        com.google.firebase.perf.v1.b bVarL = l(timer);
        if (bVarL != null) {
            this.f78598b.add(bVarL);
        }
    }

    public final /* synthetic */ void g(Timer timer) {
        com.google.firebase.perf.v1.b bVarL = l(timer);
        if (bVarL != null) {
            this.f78598b.add(bVarL);
        }
    }

    public final synchronized void h(final Timer timer) {
        try {
            this.f78597a.schedule(new Runnable() { // from class: ul.k
                @Override // java.lang.Runnable
                public final void run() {
                    this.f78594a.f(timer);
                }
            }, 0L, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e11) {
            f78596f.j("Unable to collect Memory Metric: " + e11.getMessage());
        }
    }

    public final synchronized void i(long j11, final Timer timer) {
        this.f78601e = j11;
        try {
            this.f78600d = this.f78597a.scheduleAtFixedRate(new Runnable() { // from class: ul.j
                @Override // java.lang.Runnable
                public final void run() {
                    this.f78592a.g(timer);
                }
            }, 0L, j11, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e11) {
            f78596f.j("Unable to start collecting Memory Metrics: " + e11.getMessage());
        }
    }

    public void j(long j11, Timer timer) {
        if (e(j11)) {
            return;
        }
        if (this.f78600d == null) {
            i(j11, timer);
        } else if (this.f78601e != j11) {
            k();
            i(j11, timer);
        }
    }

    public void k() {
        ScheduledFuture scheduledFuture = this.f78600d;
        if (scheduledFuture == null) {
            return;
        }
        scheduledFuture.cancel(false);
        this.f78600d = null;
        this.f78601e = -1L;
    }

    @Nullable
    public final com.google.firebase.perf.v1.b l(Timer timer) {
        if (timer == null) {
            return null;
        }
        return com.google.firebase.perf.v1.b.T().K(timer.getCurrentTimestampMicros()).L(d()).build();
    }
}
