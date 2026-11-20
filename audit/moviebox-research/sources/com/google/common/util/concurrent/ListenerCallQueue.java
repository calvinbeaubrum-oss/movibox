package com.google.common.util.concurrent;

import androidx.core.app.NotificationCompat;
import com.google.common.collect.q0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class ListenerCallQueue<L> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Logger f38894b = Logger.getLogger(ListenerCallQueue.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<PerListenerQueue<L>> f38895a = Collections.synchronizedList(new ArrayList());

    /* JADX INFO: compiled from: source.java */
    public static final class PerListenerQueue<L> implements Runnable {
        final Executor executor;
        boolean isThreadScheduled;
        final L listener;
        final Queue<a<L>> waitQueue = q0.a();
        final Queue<Object> labelQueue = q0.a();

        public PerListenerQueue(L l11, Executor executor) {
            this.listener = (L) com.google.common.base.m.p(l11);
            this.executor = (Executor) com.google.common.base.m.p(executor);
        }

        public synchronized void add(a<L> aVar, Object obj) {
            this.waitQueue.add(aVar);
            this.labelQueue.add(obj);
        }

        public void dispatch() {
            boolean z11;
            synchronized (this) {
                try {
                    if (this.isThreadScheduled) {
                        z11 = false;
                    } else {
                        z11 = true;
                        this.isThreadScheduled = true;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (z11) {
                try {
                    this.executor.execute(this);
                } catch (RuntimeException e11) {
                    synchronized (this) {
                        this.isThreadScheduled = false;
                        ListenerCallQueue.f38894b.log(Level.SEVERE, "Exception while running callbacks for " + this.listener + " on " + this.executor, (Throwable) e11);
                        throw e11;
                    }
                }
            }
        }

        /* JADX WARN: Bottom block not found for handler: all -> 0x0059 */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0024, code lost:
        
            r2.a(r9.listener);
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x002c, code lost:
        
            r2 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x002d, code lost:
        
            com.google.common.util.concurrent.ListenerCallQueue.f38894b.log(java.util.logging.Level.SEVERE, "Exception while executing callback: " + r9.listener + " " + r3, (java.lang.Throwable) r2);
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() throws Throwable {
            Throwable th2;
            boolean z11;
            while (true) {
                boolean z12 = true;
                try {
                    synchronized (this) {
                        try {
                            com.google.common.base.m.v(this.isThreadScheduled);
                            a<L> aVarPoll = this.waitQueue.poll();
                            Object objPoll = this.labelQueue.poll();
                            if (aVarPoll == null) {
                                this.isThreadScheduled = false;
                                try {
                                    return;
                                } catch (Throwable th3) {
                                    th2 = th3;
                                    z11 = false;
                                    while (true) {
                                        throw th2;
                                    }
                                }
                            }
                        } catch (Throwable th4) {
                            th2 = th4;
                            z11 = true;
                        }
                    }
                    try {
                        throw th2;
                    } catch (Throwable th5) {
                        boolean z13 = z11;
                        th = th5;
                        z12 = z13;
                        if (z12) {
                            synchronized (this) {
                                this.isThreadScheduled = false;
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface a<L> {
        void a(L l11);
    }

    public void b() {
        for (int i11 = 0; i11 < this.f38895a.size(); i11++) {
            this.f38895a.get(i11).dispatch();
        }
    }

    public void c(a<L> aVar) {
        d(aVar, aVar);
    }

    public final void d(a<L> aVar, Object obj) {
        com.google.common.base.m.q(aVar, NotificationCompat.CATEGORY_EVENT);
        com.google.common.base.m.q(obj, "label");
        synchronized (this.f38895a) {
            try {
                Iterator<PerListenerQueue<L>> it = this.f38895a.iterator();
                while (it.hasNext()) {
                    it.next().add(aVar, obj);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
