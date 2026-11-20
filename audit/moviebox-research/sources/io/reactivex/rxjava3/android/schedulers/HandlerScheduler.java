package io.reactivex.rxjava3.android.schedulers;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import io.reactivex.rxjava3.core.Scheduler;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public final class HandlerScheduler extends Scheduler {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f67311c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f67312d;

    /* JADX INFO: compiled from: source.java */
    public static final class ScheduledRunnable implements Runnable, h10.b {
        private final Runnable delegate;
        private volatile boolean disposed;
        private final Handler handler;

        public ScheduledRunnable(Handler handler, Runnable runnable) {
            this.handler = handler;
            this.delegate = runnable;
        }

        @Override // h10.b
        public void dispose() {
            this.handler.removeCallbacks(this);
            this.disposed = true;
        }

        @Override // h10.b
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.delegate.run();
            } catch (Throwable th2) {
                p10.a.q(th2);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    public static final class a extends Scheduler.Worker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f67313a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f67314b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile boolean f67315c;

        public a(Handler handler, boolean z11) {
            this.f67313a = handler;
            this.f67314b = z11;
        }

        @Override // h10.b
        public void dispose() {
            this.f67315c = true;
            this.f67313a.removeCallbacksAndMessages(this);
        }

        @Override // h10.b
        public boolean isDisposed() {
            return this.f67315c;
        }

        @Override // io.reactivex.rxjava3.core.Scheduler.Worker
        @SuppressLint({"NewApi"})
        public h10.b schedule(Runnable runnable, long j11, TimeUnit timeUnit) {
            if (runnable == null) {
                throw new NullPointerException("run == null");
            }
            if (timeUnit == null) {
                throw new NullPointerException("unit == null");
            }
            if (this.f67315c) {
                return io.reactivex.rxjava3.disposables.a.a();
            }
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(this.f67313a, p10.a.s(runnable));
            Message messageObtain = Message.obtain(this.f67313a, scheduledRunnable);
            messageObtain.obj = this;
            if (this.f67314b) {
                messageObtain.setAsynchronous(true);
            }
            this.f67313a.sendMessageDelayed(messageObtain, timeUnit.toMillis(j11));
            if (!this.f67315c) {
                return scheduledRunnable;
            }
            this.f67313a.removeCallbacks(scheduledRunnable);
            return io.reactivex.rxjava3.disposables.a.a();
        }
    }

    public HandlerScheduler(Handler handler, boolean z11) {
        this.f67311c = handler;
        this.f67312d = z11;
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public Scheduler.Worker c() {
        return new a(this.f67311c, this.f67312d);
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    @SuppressLint({"NewApi"})
    public h10.b e(Runnable runnable, long j11, TimeUnit timeUnit) {
        if (runnable == null) {
            throw new NullPointerException("run == null");
        }
        if (timeUnit == null) {
            throw new NullPointerException("unit == null");
        }
        ScheduledRunnable scheduledRunnable = new ScheduledRunnable(this.f67311c, p10.a.s(runnable));
        Message messageObtain = Message.obtain(this.f67311c, scheduledRunnable);
        if (this.f67312d) {
            messageObtain.setAsynchronous(true);
        }
        this.f67311c.sendMessageDelayed(messageObtain, timeUnit.toMillis(j11));
        return scheduledRunnable;
    }
}
