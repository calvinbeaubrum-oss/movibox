package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent;

import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class TimeoutFuture<V> extends AbstractFuture.g<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public i0<V> f39972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Future<?> f39973b;

    /* JADX INFO: compiled from: source.java */
    public static final class Fire<V> implements Runnable {
        TimeoutFuture<V> timeoutFutureRef;

        public Fire(TimeoutFuture<V> timeoutFuture) {
            this.timeoutFutureRef = timeoutFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            i0<? extends V> i0Var;
            TimeoutFuture<V> timeoutFuture = this.timeoutFutureRef;
            if (timeoutFuture == null || (i0Var = timeoutFuture.f39972a) == null) {
                return;
            }
            this.timeoutFutureRef = null;
            if (i0Var.isDone()) {
                timeoutFuture.setFuture(i0Var);
                return;
            }
            try {
                timeoutFuture.setException(new TimeoutException("Future timed out: " + i0Var));
            } finally {
                i0Var.cancel(true);
            }
        }
    }

    public TimeoutFuture(i0<V> i0Var) {
        this.f39972a = (i0) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(i0Var);
    }

    public static <V> i0<V> c(i0<V> i0Var, long j11, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        TimeoutFuture timeoutFuture = new TimeoutFuture(i0Var);
        Fire fire = new Fire(timeoutFuture);
        timeoutFuture.f39973b = scheduledExecutorService.schedule(fire, j11, timeUnit);
        i0Var.addListener(fire, MoreExecutors.a());
        return timeoutFuture;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.AbstractFuture
    public void afterDone() {
        maybePropagateCancellationTo(this.f39972a);
        Future<?> future = this.f39973b;
        if (future != null) {
            future.cancel(false);
        }
        this.f39972a = null;
        this.f39973b = null;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.AbstractFuture
    public String pendingToString() {
        i0<V> i0Var = this.f39972a;
        if (i0Var == null) {
            return null;
        }
        return "inputFuture=[" + i0Var + "]";
    }
}
