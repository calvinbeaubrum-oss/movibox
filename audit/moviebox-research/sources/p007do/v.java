package p007do;

import android.os.SystemClock;
import com.google.common.util.concurrent.t;
import com.polygamma.ogm.m;
import java.util.concurrent.Delayed;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class v implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f63510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f63511b;

    public v(m mVar, long j11) {
        this.f63510a = mVar;
        this.f63511b = j11;
    }

    @Override // com.google.common.util.concurrent.s
    public final void addListener(Runnable runnable, Executor executor) {
        this.f63510a.f48883a.a(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z11) {
        return this.f63510a.cancel(z11);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Delayed delayed) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return Long.compare(getDelay(timeUnit), delayed.getDelay(timeUnit));
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        return this.f63510a.get();
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j11, TimeUnit timeUnit) {
        return this.f63510a.get(j11, timeUnit);
    }

    @Override // java.util.concurrent.Delayed
    public final long getDelay(TimeUnit timeUnit) {
        return timeUnit.convert(this.f63511b - SystemClock.uptimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f63510a.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.f63510a.isDone();
    }
}
