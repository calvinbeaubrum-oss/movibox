package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent;

import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class z {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f40041c = Logger.getLogger(z.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f40042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f40043b;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f40044a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Executor f40045b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public a f40046c;

        public a(Runnable runnable, Executor executor, a aVar) {
            this.f40044a = runnable;
            this.f40045b = executor;
            this.f40046c = aVar;
        }
    }

    public static void c(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e11) {
            f40041c.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e11);
        }
    }

    public void a(Runnable runnable, Executor executor) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.o(runnable, "Runnable was null.");
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.o(executor, "Executor was null.");
        synchronized (this) {
            try {
                if (this.f40043b) {
                    c(runnable, executor);
                } else {
                    this.f40042a = new a(runnable, executor, this.f40042a);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void b() {
        synchronized (this) {
            try {
                if (this.f40043b) {
                    return;
                }
                this.f40043b = true;
                a aVar = this.f40042a;
                a aVar2 = null;
                this.f40042a = null;
                while (aVar != null) {
                    a aVar3 = aVar.f40046c;
                    aVar.f40046c = aVar2;
                    aVar2 = aVar;
                    aVar = aVar3;
                }
                while (aVar2 != null) {
                    c(aVar2.f40044a, aVar2.f40045b);
                    aVar2 = aVar2.f40046c;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
