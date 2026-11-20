package com.google.common.util.concurrent;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class TimeoutFuture<V> extends k.a<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public s<V> f38907a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ScheduledFuture<?> f38908b;

    /* JADX INFO: compiled from: source.java */
    public static final class Fire<V> implements Runnable {
        TimeoutFuture<V> timeoutFutureRef;

        public Fire(TimeoutFuture<V> timeoutFuture) {
            this.timeoutFutureRef = timeoutFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            s<? extends V> sVar;
            TimeoutFuture<V> timeoutFuture = this.timeoutFutureRef;
            if (timeoutFuture == null || (sVar = timeoutFuture.f38907a) == null) {
                return;
            }
            this.timeoutFutureRef = null;
            if (sVar.isDone()) {
                timeoutFuture.setFuture(sVar);
                return;
            }
            try {
                ScheduledFuture scheduledFuture = timeoutFuture.f38908b;
                timeoutFuture.f38908b = null;
                String str = "Timed out";
                if (scheduledFuture != null) {
                    try {
                        long jAbs = Math.abs(scheduledFuture.getDelay(TimeUnit.MILLISECONDS));
                        if (jAbs > 10) {
                            str = "Timed out (timeout delayed by " + jAbs + " ms after scheduled time)";
                        }
                    } catch (Throwable th2) {
                        timeoutFuture.setException(new TimeoutFutureException(str));
                        throw th2;
                    }
                }
                timeoutFuture.setException(new TimeoutFutureException(str + ": " + sVar));
                sVar.cancel(true);
            } catch (Throwable th3) {
                sVar.cancel(true);
                throw th3;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class TimeoutFutureException extends TimeoutException {
        public TimeoutFutureException(String str) {
            super(str);
        }

        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            setStackTrace(new StackTraceElement[0]);
            return this;
        }
    }

    public TimeoutFuture(s<V> sVar) {
        this.f38907a = (s) com.google.common.base.m.p(sVar);
    }

    public static <V> s<V> e(s<V> sVar, long j11, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        TimeoutFuture timeoutFuture = new TimeoutFuture(sVar);
        Fire fire = new Fire(timeoutFuture);
        timeoutFuture.f38908b = scheduledExecutorService.schedule(fire, j11, timeUnit);
        sVar.addListener(fire, MoreExecutors.a());
        return timeoutFuture;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public void afterDone() {
        maybePropagateCancellationTo(this.f38907a);
        ScheduledFuture<?> scheduledFuture = this.f38908b;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.f38907a = null;
        this.f38908b = null;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public String pendingToString() {
        s<V> sVar = this.f38907a;
        ScheduledFuture<?> scheduledFuture = this.f38908b;
        if (sVar == null) {
            return null;
        }
        String str = "inputFuture=[" + sVar + "]";
        if (scheduledFuture == null) {
            return str;
        }
        long delay = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
        if (delay <= 0) {
            return str;
        }
        return str + ", remaining delay=[" + delay + " ms]";
    }
}
