package com.google.common.util.concurrent;

import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f38941c = Logger.getLogger(i.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f38942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f38943b;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f38944a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Executor f38945b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public a f38946c;

        public a(Runnable runnable, Executor executor, a aVar) {
            this.f38944a = runnable;
            this.f38945b = executor;
            this.f38946c = aVar;
        }
    }

    public static void c(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e11) {
            f38941c.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e11);
        }
    }

    public void a(Runnable runnable, Executor executor) {
        com.google.common.base.m.q(runnable, "Runnable was null.");
        com.google.common.base.m.q(executor, "Executor was null.");
        synchronized (this) {
            try {
                if (this.f38943b) {
                    c(runnable, executor);
                } else {
                    this.f38942a = new a(runnable, executor, this.f38942a);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void b() {
        synchronized (this) {
            try {
                if (this.f38943b) {
                    return;
                }
                this.f38943b = true;
                a aVar = this.f38942a;
                a aVar2 = null;
                this.f38942a = null;
                while (aVar != null) {
                    a aVar3 = aVar.f38946c;
                    aVar.f38946c = aVar2;
                    aVar2 = aVar;
                    aVar = aVar3;
                }
                while (aVar2 != null) {
                    c(aVar2.f38944a, aVar2.f38945b);
                    aVar2 = aVar2.f38946c;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
