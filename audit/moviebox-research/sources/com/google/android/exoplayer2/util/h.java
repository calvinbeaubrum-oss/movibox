package com.google.android.exoplayer2.util;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f35574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f35575b;

    public h() {
        this(e.f35556a);
    }

    public h(e eVar) {
        this.f35574a = eVar;
    }

    public synchronized void a() throws InterruptedException {
        while (!this.f35575b) {
            wait();
        }
    }

    public synchronized boolean b(long j11) throws InterruptedException {
        try {
            if (j11 <= 0) {
                return this.f35575b;
            }
            long jElapsedRealtime = this.f35574a.elapsedRealtime();
            long j12 = j11 + jElapsedRealtime;
            if (j12 < jElapsedRealtime) {
                a();
            } else {
                while (!this.f35575b && jElapsedRealtime < j12) {
                    wait(j12 - jElapsedRealtime);
                    jElapsedRealtime = this.f35574a.elapsedRealtime();
                }
            }
            return this.f35575b;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void c() {
        boolean z11 = false;
        while (!this.f35575b) {
            try {
                wait();
            } catch (InterruptedException unused) {
                z11 = true;
            }
        }
        if (z11) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized boolean d() {
        boolean z11;
        z11 = this.f35575b;
        this.f35575b = false;
        return z11;
    }

    public synchronized boolean e() {
        return this.f35575b;
    }

    public synchronized boolean f() {
        if (this.f35575b) {
            return false;
        }
        this.f35575b = true;
        notifyAll();
        return true;
    }
}
