package ul;

import android.os.Process;
import android.system.Os;
import android.system.OsConstants;
import androidx.annotation.Nullable;
import com.google.firebase.perf.util.Timer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ql.a f78573g = ql.a.e();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final long f78574h = TimeUnit.SECONDS.toMicros(1);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public ScheduledFuture f78579e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f78580f = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentLinkedQueue<com.google.firebase.perf.v1.d> f78575a = new ConcurrentLinkedQueue<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ScheduledExecutorService f78576b = Executors.newSingleThreadScheduledExecutor();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f78577c = "/proc/" + Integer.toString(Process.myPid()) + "/stat";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f78578d = e();

    public static boolean f(long j11) {
        return j11 <= 0;
    }

    public void c(Timer timer) {
        i(timer);
    }

    public final long d(long j11) {
        return Math.round((j11 / this.f78578d) * f78574h);
    }

    public final long e() {
        return Os.sysconf(OsConstants._SC_CLK_TCK);
    }

    public final /* synthetic */ void g(Timer timer) {
        com.google.firebase.perf.v1.d dVarM = m(timer);
        if (dVarM != null) {
            this.f78575a.add(dVarM);
        }
    }

    public final /* synthetic */ void h(Timer timer) {
        com.google.firebase.perf.v1.d dVarM = m(timer);
        if (dVarM != null) {
            this.f78575a.add(dVarM);
        }
    }

    public final synchronized void i(final Timer timer) {
        try {
            this.f78576b.schedule(new Runnable() { // from class: ul.b
                @Override // java.lang.Runnable
                public final void run() {
                    this.f78571a.g(timer);
                }
            }, 0L, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e11) {
            f78573g.j("Unable to collect Cpu Metric: " + e11.getMessage());
        }
    }

    public final synchronized void j(long j11, final Timer timer) {
        this.f78580f = j11;
        try {
            this.f78579e = this.f78576b.scheduleAtFixedRate(new Runnable() { // from class: ul.a
                @Override // java.lang.Runnable
                public final void run() {
                    this.f78569a.h(timer);
                }
            }, 0L, j11, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e11) {
            f78573g.j("Unable to start collecting Cpu Metrics: " + e11.getMessage());
        }
    }

    public void k(long j11, Timer timer) {
        long j12 = this.f78578d;
        if (j12 == -1 || j12 == 0 || f(j11)) {
            return;
        }
        if (this.f78579e == null) {
            j(j11, timer);
        } else if (this.f78580f != j11) {
            l();
            j(j11, timer);
        }
    }

    public void l() {
        ScheduledFuture scheduledFuture = this.f78579e;
        if (scheduledFuture == null) {
            return;
        }
        scheduledFuture.cancel(false);
        this.f78579e = null;
        this.f78580f = -1L;
    }

    @Nullable
    public final com.google.firebase.perf.v1.d m(Timer timer) {
        if (timer == null) {
            return null;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(this.f78577c));
            try {
                long currentTimestampMicros = timer.getCurrentTimestampMicros();
                String[] strArrSplit = bufferedReader.readLine().split(" ");
                com.google.firebase.perf.v1.d dVarBuild = com.google.firebase.perf.v1.d.U().K(currentTimestampMicros).L(d(Long.parseLong(strArrSplit[14]) + Long.parseLong(strArrSplit[16]))).M(d(Long.parseLong(strArrSplit[13]) + Long.parseLong(strArrSplit[15]))).build();
                bufferedReader.close();
                return dVarBuild;
            } catch (Throwable th2) {
                try {
                    bufferedReader.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        } catch (IOException e11) {
            f78573g.j("Unable to read 'proc/[pid]/stat' file: " + e11.getMessage());
            return null;
        } catch (ArrayIndexOutOfBoundsException e12) {
            e = e12;
            f78573g.j("Unexpected '/proc/[pid]/stat' file format encountered: " + e.getMessage());
            return null;
        } catch (NullPointerException e13) {
            e = e13;
            f78573g.j("Unexpected '/proc/[pid]/stat' file format encountered: " + e.getMessage());
            return null;
        } catch (NumberFormatException e14) {
            e = e14;
            f78573g.j("Unexpected '/proc/[pid]/stat' file format encountered: " + e.getMessage());
            return null;
        }
    }
}
