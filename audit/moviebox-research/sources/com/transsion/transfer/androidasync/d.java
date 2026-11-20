package com.transsion.transfer.androidasync;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Semaphore f58518a = new Semaphore(0);

    public void a() throws InterruptedException {
        ThreadQueue orCreateThreadQueue = ThreadQueue.getOrCreateThreadQueue(Thread.currentThread());
        d dVar = orCreateThreadQueue.waiter;
        orCreateThreadQueue.waiter = this;
        Semaphore semaphore = orCreateThreadQueue.queueSemaphore;
        try {
            if (this.f58518a.tryAcquire()) {
                return;
            }
            while (true) {
                Runnable runnableRemove = orCreateThreadQueue.remove();
                if (runnableRemove == null) {
                    semaphore.acquire(Math.max(1, semaphore.availablePermits()));
                    if (this.f58518a.tryAcquire()) {
                        return;
                    }
                } else {
                    runnableRemove.run();
                }
            }
        } finally {
            orCreateThreadQueue.waiter = dVar;
        }
    }

    public void b() {
        this.f58518a.release();
        ThreadQueue.release(this);
    }

    public boolean c(long j11, TimeUnit timeUnit) throws InterruptedException {
        long jConvert = TimeUnit.MILLISECONDS.convert(j11, timeUnit);
        ThreadQueue orCreateThreadQueue = ThreadQueue.getOrCreateThreadQueue(Thread.currentThread());
        d dVar = orCreateThreadQueue.waiter;
        orCreateThreadQueue.waiter = this;
        Semaphore semaphore = orCreateThreadQueue.queueSemaphore;
        try {
            if (this.f58518a.tryAcquire()) {
                return true;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            while (true) {
                Runnable runnableRemove = orCreateThreadQueue.remove();
                if (runnableRemove != null) {
                    runnableRemove.run();
                } else {
                    if (!semaphore.tryAcquire(Math.max(1, semaphore.availablePermits()), jConvert, TimeUnit.MILLISECONDS)) {
                        return false;
                    }
                    if (this.f58518a.tryAcquire()) {
                        return true;
                    }
                    if (System.currentTimeMillis() - jCurrentTimeMillis >= jConvert) {
                        return false;
                    }
                }
            }
        } finally {
            orCreateThreadQueue.waiter = dVar;
        }
    }
}
