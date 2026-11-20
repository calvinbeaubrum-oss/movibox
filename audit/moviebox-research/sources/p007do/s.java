package p007do;

import android.os.Build;
import android.os.SystemClock;
import com.polygamma.ogm.c;
import com.polygamma.ogm.m;
import java.util.Timer;
import java.util.concurrent.ForkJoinPool;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class s extends x {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Timer f63505g = new Timer();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ForkJoinPool f63506h;

    public s() {
        this.f63506h = Build.VERSION.SDK_INT >= 24 ? ForkJoinPool.commonPool() : new ForkJoinPool((Math.max(Runtime.getRuntime().availableProcessors(), 1) * 2) + 1);
    }

    @Override // p007do.x
    public final void b() {
        try {
            this.f63505g.cancel();
            if (Build.VERSION.SDK_INT < 24) {
                this.f63506h.shutdown();
            }
        } finally {
            super.b();
        }
    }

    @Override // p007do.x
    public final boolean d(m mVar, long j11) {
        if (j11 == 0) {
            this.f63506h.execute(mVar);
            return true;
        }
        long jUptimeMillis = j11 - SystemClock.uptimeMillis();
        if (jUptimeMillis != 0) {
            this.f63505g.schedule(new c(this, mVar), jUptimeMillis);
            return true;
        }
        this.f63506h.execute(mVar);
        return true;
    }
}
