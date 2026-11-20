package com.vungle.warren;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.vungle.warren.tasks.runnable.JobRunnable;
import com.vungle.warren.utility.NetworkProvider;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class VungleJobRunner implements y00.h {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Handler f61866i = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f61867j = VungleJobRunner.class.getSimpleName();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z00.b f61868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final NetworkProvider f61869b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public y00.f f61870c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Executor f61871d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f61874g = Long.MAX_VALUE;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final NetworkProvider.b f61875h = new a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<b> f61872e = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Runnable f61873f = new PendingRunnable(new WeakReference(this));

    /* JADX INFO: compiled from: source.java */
    public static class PendingRunnable implements Runnable {
        WeakReference<VungleJobRunner> runner;

        public PendingRunnable(WeakReference<VungleJobRunner> weakReference) {
            this.runner = weakReference;
        }

        @Override // java.lang.Runnable
        public void run() {
            VungleJobRunner vungleJobRunner = this.runner.get();
            if (vungleJobRunner != null) {
                vungleJobRunner.d();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a implements NetworkProvider.b {
        public a() {
        }

        @Override // com.vungle.warren.utility.NetworkProvider.b
        public void a(int i11) {
            VungleJobRunner.this.d();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f61877a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public y00.g f61878b;

        public b(long j11, y00.g gVar) {
            this.f61877a = j11;
            this.f61878b = gVar;
        }
    }

    public VungleJobRunner(@NonNull y00.f fVar, @NonNull Executor executor, @Nullable z00.b bVar, @NonNull NetworkProvider networkProvider) {
        this.f61870c = fVar;
        this.f61871d = executor;
        this.f61868a = bVar;
        this.f61869b = networkProvider;
    }

    @Override // y00.h
    public synchronized void a(@NonNull y00.g gVar) {
        try {
            y00.g gVarA = gVar.a();
            String strD = gVarA.d();
            long jB = gVarA.b();
            gVarA.k(0L);
            if (gVarA.h()) {
                for (b bVar : this.f61872e) {
                    if (bVar.f61878b.d().equals(strD)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("replacing pending job with new ");
                        sb2.append(strD);
                        this.f61872e.remove(bVar);
                    }
                }
            }
            this.f61872e.add(new b(SystemClock.uptimeMillis() + jB, gVarA));
            d();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // y00.h
    public synchronized void b(@NonNull String str) {
        try {
            ArrayList arrayList = new ArrayList();
            for (b bVar : this.f61872e) {
                if (bVar.f61878b.d().equals(str)) {
                    arrayList.add(bVar);
                }
            }
            this.f61872e.removeAll(arrayList);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized void d() {
        try {
            long jUptimeMillis = SystemClock.uptimeMillis();
            long jMin = Long.MAX_VALUE;
            long j11 = 0;
            for (b bVar : this.f61872e) {
                if (jUptimeMillis >= bVar.f61877a) {
                    boolean z11 = true;
                    if (bVar.f61878b.g() == 1 && this.f61869b.e() == -1) {
                        j11++;
                        z11 = false;
                    }
                    if (z11) {
                        this.f61872e.remove(bVar);
                        this.f61871d.execute(new JobRunnable(bVar.f61878b, this.f61870c, this, this.f61868a));
                    }
                } else {
                    jMin = Math.min(jMin, bVar.f61877a);
                }
            }
            if (jMin != Long.MAX_VALUE && jMin != this.f61874g) {
                f61866i.removeCallbacks(this.f61873f);
                f61866i.postAtTime(this.f61873f, f61867j, jMin);
            }
            this.f61874g = jMin;
            if (j11 > 0) {
                this.f61869b.d(this.f61875h);
            } else {
                this.f61869b.j(this.f61875h);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
