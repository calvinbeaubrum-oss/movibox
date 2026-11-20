package com.google.common.util.concurrent;

import java.util.Objects;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractScheduledService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Logger f38871b = Logger.getLogger(AbstractScheduledService.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f38872a = new ServiceDelegate(this, null);

    /* JADX INFO: compiled from: source.java */
    public final class ServiceDelegate extends c {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public volatile a f38873p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final ReentrantLock f38874q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final Runnable f38875r;

        /* JADX INFO: compiled from: source.java */
        public class Task implements Runnable {
            public Task() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ServiceDelegate.this.f38874q.lock();
                try {
                    a aVar = ServiceDelegate.this.f38873p;
                    Objects.requireNonNull(aVar);
                    if (aVar.isCancelled()) {
                        ServiceDelegate.this.f38874q.unlock();
                        return;
                    }
                    AbstractScheduledService.this.b();
                } catch (Throwable th2) {
                    try {
                        z.b(th2);
                        try {
                            AbstractScheduledService.this.d();
                        } catch (Exception e11) {
                            z.b(e11);
                            AbstractScheduledService.f38871b.log(Level.WARNING, "Error while attempting to shut down the service after failure.", (Throwable) e11);
                        }
                        ServiceDelegate.this.d(th2);
                        a aVar2 = ServiceDelegate.this.f38873p;
                        Objects.requireNonNull(aVar2);
                        aVar2.cancel(false);
                    } catch (Throwable th3) {
                        ServiceDelegate.this.f38874q.unlock();
                        throw th3;
                    }
                }
                ServiceDelegate.this.f38874q.unlock();
            }
        }

        public ServiceDelegate() {
            this.f38874q = new ReentrantLock();
            this.f38875r = new Task();
        }

        public /* synthetic */ ServiceDelegate(AbstractScheduledService abstractScheduledService, b bVar) {
            this();
        }

        public String toString() {
            return AbstractScheduledService.this.toString();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void cancel(boolean z11);

        boolean isCancelled();
    }

    public abstract void b() throws Exception;

    public String c() {
        return getClass().getSimpleName();
    }

    public void d() throws Exception {
    }

    public final Service$State e() {
        return this.f38872a.e();
    }

    public String toString() {
        return c() + " [" + e() + "]";
    }
}
