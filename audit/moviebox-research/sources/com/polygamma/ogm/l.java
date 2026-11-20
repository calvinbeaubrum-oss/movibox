package com.polygamma.ogm;

import android.os.SystemClock;
import java.util.Objects;
import java.util.concurrent.Delayed;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import p007do.x;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public abstract class l extends m implements com.google.common.util.concurrent.t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f48881c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ x f48882d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(x xVar, Runnable runnable, long j11) {
        super(xVar, runnable, null);
        this.f48882d = xVar;
        Objects.requireNonNull(runnable);
        com.google.common.base.m.d(j11 >= 0);
        this.f48881c = SystemClock.uptimeMillis() + j11;
    }

    public abstract long a();

    @Override // java.lang.Comparable
    public final int compareTo(Delayed delayed) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return Long.compare(getDelay(timeUnit), delayed.getDelay(timeUnit));
    }

    @Override // java.util.concurrent.Delayed
    public final long getDelay(TimeUnit timeUnit) {
        return timeUnit.convert(this.f48881c - SystemClock.uptimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override // java.util.concurrent.FutureTask, java.util.concurrent.RunnableFuture, java.lang.Runnable
    public void run() {
        if (super.runAndReset()) {
            long jA = a();
            try {
                x xVar = this.f48882d;
                boolean z11 = x.f63512f;
                xVar.c(this, jA, true);
                this.f48881c = jA;
            } catch (RejectedExecutionException unused) {
                super.cancel(false);
            }
        }
    }
}
