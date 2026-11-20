package com.applovin.impl;

import android.os.Handler;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public interface a7 {

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f17463a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final be.a f17464b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final CopyOnWriteArrayList f17465c;

        /* JADX INFO: renamed from: com.applovin.impl.a7$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public static final class C0175a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Handler f17466a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public a7 f17467b;

            public C0175a(Handler handler, a7 a7Var) {
                this.f17466a = handler;
                this.f17467b = a7Var;
            }
        }

        public a() {
            this(new CopyOnWriteArrayList(), 0, null);
        }

        private a(CopyOnWriteArrayList copyOnWriteArrayList, int i11, be.a aVar) {
            this.f17465c = copyOnWriteArrayList;
            this.f17463a = i11;
            this.f17464b = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(a7 a7Var) {
            a7Var.d(this.f17463a, this.f17464b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(a7 a7Var, int i11) {
            a7Var.e(this.f17463a, this.f17464b);
            a7Var.a(this.f17463a, this.f17464b, i11);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(a7 a7Var, Exception exc) {
            a7Var.a(this.f17463a, this.f17464b, exc);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(a7 a7Var) {
            a7Var.a(this.f17463a, this.f17464b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(a7 a7Var) {
            a7Var.c(this.f17463a, this.f17464b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(a7 a7Var) {
            a7Var.b(this.f17463a, this.f17464b);
        }

        public a a(int i11, be.a aVar) {
            return new a(this.f17465c, i11, aVar);
        }

        public void a() {
            for (C0175a c0175a : this.f17465c) {
                final a7 a7Var = c0175a.f17467b;
                xp.a(c0175a.f17466a, new Runnable() { // from class: com.applovin.impl.ls
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f20534a.a(a7Var);
                    }
                });
            }
        }

        public void a(final int i11) {
            for (C0175a c0175a : this.f17465c) {
                final a7 a7Var = c0175a.f17467b;
                xp.a(c0175a.f17466a, new Runnable() { // from class: com.applovin.impl.ps
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f21846a.a(a7Var, i11);
                    }
                });
            }
        }

        public void a(Handler handler, a7 a7Var) {
            b1.a(handler);
            b1.a(a7Var);
            this.f17465c.add(new C0175a(handler, a7Var));
        }

        public void a(final Exception exc) {
            for (C0175a c0175a : this.f17465c) {
                final a7 a7Var = c0175a.f17467b;
                xp.a(c0175a.f17466a, new Runnable() { // from class: com.applovin.impl.ks
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f20279a.a(a7Var, exc);
                    }
                });
            }
        }

        public void b() {
            for (C0175a c0175a : this.f17465c) {
                final a7 a7Var = c0175a.f17467b;
                xp.a(c0175a.f17466a, new Runnable() { // from class: com.applovin.impl.ms
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f21200a.b(a7Var);
                    }
                });
            }
        }

        public void c() {
            for (C0175a c0175a : this.f17465c) {
                final a7 a7Var = c0175a.f17467b;
                xp.a(c0175a.f17466a, new Runnable() { // from class: com.applovin.impl.ns
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f21421a.c(a7Var);
                    }
                });
            }
        }

        public void d() {
            for (C0175a c0175a : this.f17465c) {
                final a7 a7Var = c0175a.f17467b;
                xp.a(c0175a.f17466a, new Runnable() { // from class: com.applovin.impl.os
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f21617a.d(a7Var);
                    }
                });
            }
        }

        public void e(a7 a7Var) {
            for (C0175a c0175a : this.f17465c) {
                if (c0175a.f17467b == a7Var) {
                    this.f17465c.remove(c0175a);
                }
            }
        }
    }

    void a(int i11, be.a aVar);

    void a(int i11, be.a aVar, int i12);

    void a(int i11, be.a aVar, Exception exc);

    void b(int i11, be.a aVar);

    void c(int i11, be.a aVar);

    void d(int i11, be.a aVar);

    void e(int i11, be.a aVar);
}
