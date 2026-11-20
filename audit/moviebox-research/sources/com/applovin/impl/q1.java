package com.applovin.impl;

import android.os.Handler;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public interface q1 {

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Handler f21886a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final q1 f21887b;

        public a(Handler handler, q1 q1Var) {
            this.f21886a = q1Var != null ? (Handler) b1.a(handler) : null;
            this.f21887b = q1Var;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(int i11, long j11, long j12) {
            ((q1) xp.a(this.f21887b)).b(i11, j11, j12);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(long j11) {
            ((q1) xp.a(this.f21887b)).a(j11);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(boolean z11) {
            ((q1) xp.a(this.f21887b)).a(z11);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(f9 f9Var, q5 q5Var) {
            ((q1) xp.a(this.f21887b)).b(f9Var);
            ((q1) xp.a(this.f21887b)).b(f9Var, q5Var);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(String str) {
            ((q1) xp.a(this.f21887b)).b(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(String str, long j11, long j12) {
            ((q1) xp.a(this.f21887b)).a(str, j11, j12);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(n5 n5Var) {
            n5Var.a();
            ((q1) xp.a(this.f21887b)).c(n5Var);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(Exception exc) {
            ((q1) xp.a(this.f21887b)).c(exc);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(n5 n5Var) {
            ((q1) xp.a(this.f21887b)).a(n5Var);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(Exception exc) {
            ((q1) xp.a(this.f21887b)).a(exc);
        }

        public void a(final f9 f9Var, final q5 q5Var) {
            Handler handler = this.f21886a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.applovin.impl.v10
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f23728a.b(f9Var, q5Var);
                    }
                });
            }
        }

        public void a(final n5 n5Var) {
            n5Var.a();
            Handler handler = this.f21886a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.applovin.impl.q10
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f21888a.c(n5Var);
                    }
                });
            }
        }

        public void a(final Exception exc) {
            Handler handler = this.f21886a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.applovin.impl.n10
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f21223a.c(exc);
                    }
                });
            }
        }

        public void a(final String str) {
            Handler handler = this.f21886a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.applovin.impl.o10
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f21450a.b(str);
                    }
                });
            }
        }

        public void a(final String str, final long j11, final long j12) {
            Handler handler = this.f21886a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.applovin.impl.m10
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f20565a.b(str, j11, j12);
                    }
                });
            }
        }

        public void b(final int i11, final long j11, final long j12) {
            Handler handler = this.f21886a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.applovin.impl.r10
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f22022a.a(i11, j11, j12);
                    }
                });
            }
        }

        public void b(final long j11) {
            Handler handler = this.f21886a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.applovin.impl.p10
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f21638a.a(j11);
                    }
                });
            }
        }

        public void b(final n5 n5Var) {
            Handler handler = this.f21886a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.applovin.impl.t10
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f23165a.d(n5Var);
                    }
                });
            }
        }

        public void b(final Exception exc) {
            Handler handler = this.f21886a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.applovin.impl.u10
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f23498a.d(exc);
                    }
                });
            }
        }

        public void b(final boolean z11) {
            Handler handler = this.f21886a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.applovin.impl.s10
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f22225a.a(z11);
                    }
                });
            }
        }
    }

    void a(long j11);

    void a(n5 n5Var);

    void a(Exception exc);

    void a(String str, long j11, long j12);

    void a(boolean z11);

    void b(int i11, long j11, long j12);

    void b(f9 f9Var);

    void b(f9 f9Var, q5 q5Var);

    void b(String str);

    void c(n5 n5Var);

    void c(Exception exc);
}
