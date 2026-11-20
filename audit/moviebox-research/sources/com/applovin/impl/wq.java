package com.applovin.impl;

import android.os.Handler;
import android.os.SystemClock;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public interface wq {

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Handler f24158a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final wq f24159b;

        public a(Handler handler, wq wqVar) {
            this.f24158a = wqVar != null ? (Handler) b1.a(handler) : null;
            this.f24159b = wqVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(long j11, int i11) {
            ((wq) xp.a(this.f24159b)).a(j11, i11);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(xq xqVar) {
            ((wq) xp.a(this.f24159b)).a(xqVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(Exception exc) {
            ((wq) xp.a(this.f24159b)).b(exc);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(Object obj, long j11) {
            ((wq) xp.a(this.f24159b)).a(obj, j11);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(int i11, long j11) {
            ((wq) xp.a(this.f24159b)).a(i11, j11);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(f9 f9Var, q5 q5Var) {
            ((wq) xp.a(this.f24159b)).a(f9Var);
            ((wq) xp.a(this.f24159b)).a(f9Var, q5Var);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(String str) {
            ((wq) xp.a(this.f24159b)).a(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(String str, long j11, long j12) {
            ((wq) xp.a(this.f24159b)).b(str, j11, j12);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(n5 n5Var) {
            n5Var.a();
            ((wq) xp.a(this.f24159b)).b(n5Var);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(n5 n5Var) {
            ((wq) xp.a(this.f24159b)).d(n5Var);
        }

        public void a(final int i11, final long j11) {
            Handler handler = this.f24158a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.applovin.impl.i80
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f19649a.b(i11, j11);
                    }
                });
            }
        }

        public void a(final f9 f9Var, final q5 q5Var) {
            Handler handler = this.f24158a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.applovin.impl.k80
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f20188a.b(f9Var, q5Var);
                    }
                });
            }
        }

        public void a(final n5 n5Var) {
            n5Var.a();
            Handler handler = this.f24158a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.applovin.impl.l80
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f20364a.c(n5Var);
                    }
                });
            }
        }

        public void a(final Object obj) {
            if (this.f24158a != null) {
                final long jElapsedRealtime = SystemClock.elapsedRealtime();
                this.f24158a.post(new Runnable() { // from class: com.applovin.impl.j80
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f19874a.a(obj, jElapsedRealtime);
                    }
                });
            }
        }

        public void a(final String str) {
            Handler handler = this.f24158a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.applovin.impl.m80
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f20631a.b(str);
                    }
                });
            }
        }

        public void a(final String str, final long j11, final long j12) {
            Handler handler = this.f24158a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.applovin.impl.o80
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f21467a.b(str, j11, j12);
                    }
                });
            }
        }

        public void b(final long j11, final int i11) {
            Handler handler = this.f24158a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.applovin.impl.n80
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f21299a.a(j11, i11);
                    }
                });
            }
        }

        public void b(final n5 n5Var) {
            Handler handler = this.f24158a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.applovin.impl.h80
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f19395a.d(n5Var);
                    }
                });
            }
        }

        public void b(final xq xqVar) {
            Handler handler = this.f24158a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.applovin.impl.p80
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f21673a.a(xqVar);
                    }
                });
            }
        }

        public void b(final Exception exc) {
            Handler handler = this.f24158a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.applovin.impl.q80
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f21912a.a(exc);
                    }
                });
            }
        }
    }

    void a(int i11, long j11);

    void a(long j11, int i11);

    void a(f9 f9Var);

    void a(f9 f9Var, q5 q5Var);

    void a(xq xqVar);

    void a(Object obj, long j11);

    void a(String str);

    void b(n5 n5Var);

    void b(Exception exc);

    void b(String str, long j11, long j12);

    void d(n5 n5Var);
}
