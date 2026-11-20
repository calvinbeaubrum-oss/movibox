package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent;

import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractScheduledService implements Service {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Logger f39948b = Logger.getLogger(AbstractScheduledService.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f39949a = new ServiceDelegate(this, null);

    /* JADX INFO: compiled from: source.java */
    public final class ServiceDelegate extends d {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public volatile Future<?> f39950o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public volatile ScheduledExecutorService f39951p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final ReentrantLock f39952q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final Runnable f39953r;

        /* JADX INFO: renamed from: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.AbstractScheduledService$ServiceDelegate$2, reason: invalid class name */
        /* JADX INFO: compiled from: source.java */
        class AnonymousClass2 implements Runnable {
            public AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ServiceDelegate.this.f39952q.lock();
                try {
                    AbstractScheduledService.this.h();
                    AbstractScheduledService.this.e();
                    d unused = AbstractScheduledService.this.f39949a;
                    ScheduledExecutorService unused2 = ServiceDelegate.this.f39951p;
                    Runnable unused3 = ServiceDelegate.this.f39953r;
                    throw null;
                } catch (Throwable th2) {
                    try {
                        ServiceDelegate.this.i(th2);
                        if (ServiceDelegate.this.f39950o != null) {
                            ServiceDelegate.this.f39950o.cancel(false);
                        }
                    } finally {
                        ServiceDelegate.this.f39952q.unlock();
                    }
                }
            }
        }

        /* JADX INFO: compiled from: source.java */
        public class Task implements Runnable {
            public Task() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ServiceDelegate.this.f39952q.lock();
                try {
                    if (ServiceDelegate.this.f39950o.isCancelled()) {
                        ServiceDelegate.this.f39952q.unlock();
                        return;
                    }
                    AbstractScheduledService.this.d();
                } catch (Throwable th2) {
                    try {
                        try {
                            AbstractScheduledService.this.g();
                        } catch (Exception e11) {
                            AbstractScheduledService.f39948b.log(Level.WARNING, "Error while attempting to shut down the service after failure.", (Throwable) e11);
                        }
                        ServiceDelegate.this.i(th2);
                        ServiceDelegate.this.f39950o.cancel(false);
                    } finally {
                        ServiceDelegate.this.f39952q.unlock();
                    }
                }
            }
        }

        public ServiceDelegate() {
            this.f39952q = new ReentrantLock();
            this.f39953r = new Task();
        }

        public /* synthetic */ ServiceDelegate(AbstractScheduledService abstractScheduledService, c cVar) {
            this();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.d
        public final void d() {
            this.f39950o.cancel(false);
            this.f39951p.execute(new Runnable() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.AbstractScheduledService.ServiceDelegate.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ServiceDelegate.this.f39952q.lock();
                        try {
                            if (ServiceDelegate.this.a() != Service.State.STOPPING) {
                                ServiceDelegate.this.f39952q.unlock();
                                return;
                            }
                            AbstractScheduledService.this.g();
                            ServiceDelegate.this.f39952q.unlock();
                            ServiceDelegate.this.k();
                        } catch (Throwable th2) {
                            ServiceDelegate.this.f39952q.unlock();
                            throw th2;
                        }
                    } catch (Throwable th3) {
                        ServiceDelegate.this.i(th3);
                    }
                }
            });
        }

        public String toString() {
            return AbstractScheduledService.this.toString();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class a {
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.Service
    public final Service.State a() {
        return this.f39949a.a();
    }

    public abstract void d() throws Exception;

    public abstract a e();

    public String f() {
        return getClass().getSimpleName();
    }

    public void g() throws Exception {
    }

    public void h() throws Exception {
    }

    public String toString() {
        return f() + " [" + a() + "]";
    }
}
