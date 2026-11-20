package p007do;

import android.os.SystemClock;
import com.google.common.util.concurrent.s;
import com.google.common.util.concurrent.t;
import com.google.common.util.concurrent.v;
import com.polygamma.ogm.i;
import com.polygamma.ogm.k;
import com.polygamma.ogm.m;
import io.d0;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public abstract class x extends AbstractExecutorService implements v {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ boolean f63512f = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReadWriteLock f63513a = d0.d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicInteger f63514b = new AtomicInteger();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CountDownLatch f63515c = new CountDownLatch(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f63516d = 0;

    public final v a(m mVar, long j11, TimeUnit timeUnit) {
        long millis = timeUnit.toMillis(j11) + SystemClock.uptimeMillis();
        v vVar = new v(mVar, millis);
        c(mVar, millis, false);
        return vVar;
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean awaitTermination(long j11, TimeUnit timeUnit) {
        return this.f63515c.await(j11, timeUnit);
    }

    public void b() {
        if (!f63512f && this.f63516d != 1) {
            throw new AssertionError();
        }
        this.f63515c.countDown();
        this.f63516d = 2;
    }

    public final void c(m mVar, long j11, boolean z11) {
        Lock lock = this.f63513a.readLock();
        lock.lock();
        try {
            if (this.f63516d != 0 || !d(mVar, j11)) {
                throw new RejectedExecutionException();
            }
            if (!z11) {
                this.f63514b.getAndIncrement();
            }
            lock.unlock();
        } catch (Throwable th2) {
            lock.unlock();
            throw th2;
        }
    }

    public abstract boolean d(m mVar, long j11);

    @Override // java.util.concurrent.ScheduledExecutorService
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public final t scheduleAtFixedRate(Runnable runnable, long j11, long j12, TimeUnit timeUnit) {
        k kVar = new k(this, runnable, timeUnit.toMillis(j11), timeUnit.toMillis(j12));
        c(kVar, kVar.f48881c, false);
        return kVar;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        submit(runnable, null);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public final s submit(Runnable runnable, Object obj) {
        m mVar = new m(this, runnable, obj);
        c(mVar, 0L, false);
        return mVar;
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isShutdown() {
        Lock lock = this.f63513a.readLock();
        lock.lock();
        try {
            return !(this.f63516d == 0);
        } finally {
            lock.unlock();
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isTerminated() {
        Lock lock = this.f63513a.readLock();
        lock.lock();
        try {
            return this.f63516d == 2;
        } finally {
            lock.unlock();
        }
    }

    @Override // com.google.common.util.concurrent.v, java.util.concurrent.ScheduledExecutorService
    public final t schedule(Runnable runnable, long j11, TimeUnit timeUnit) {
        return a(new m(this, runnable, null), j11, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture schedule(Runnable runnable, long j11, TimeUnit timeUnit) {
        return a(new m(this, runnable, null), j11, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture schedule(Callable callable, long j11, TimeUnit timeUnit) {
        return a(new m(this, callable), j11, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final t scheduleWithFixedDelay(Runnable runnable, long j11, long j12, TimeUnit timeUnit) {
        i iVar = new i(this, runnable, timeUnit.toMillis(j11), timeUnit.toMillis(j12));
        c(iVar, iVar.f48881c, false);
        return iVar;
    }

    @Override // java.util.concurrent.ExecutorService
    public final void shutdown() {
        Lock lockWriteLock = this.f63513a.writeLock();
        lockWriteLock.lock();
        try {
            if (this.f63516d != 0) {
                return;
            }
            this.f63516d = 1;
            if (this.f63514b.get() == 0) {
                b();
            }
        } finally {
            lockWriteLock.unlock();
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public final List shutdownNow() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.google.common.util.concurrent.u
    public final s submit(Runnable runnable) {
        return submit(runnable, null);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public final s submit(Callable callable) {
        m mVar = new m(this, callable);
        c(mVar, 0L, false);
        return mVar;
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public final Future submit(Runnable runnable) {
        return submit(runnable, null);
    }
}
