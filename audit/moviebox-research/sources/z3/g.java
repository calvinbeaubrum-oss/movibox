package z3;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f81778a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f81779b;

    public g() {
        this(d.f81767a);
    }

    public g(d dVar) {
        this.f81778a = dVar;
    }

    public synchronized void a() throws InterruptedException {
        while (!this.f81779b) {
            wait();
        }
    }

    public synchronized boolean b(long j11) throws InterruptedException {
        try {
            if (j11 <= 0) {
                return this.f81779b;
            }
            long jElapsedRealtime = this.f81778a.elapsedRealtime();
            long j12 = j11 + jElapsedRealtime;
            if (j12 < jElapsedRealtime) {
                a();
            } else {
                while (!this.f81779b && jElapsedRealtime < j12) {
                    wait(j12 - jElapsedRealtime);
                    jElapsedRealtime = this.f81778a.elapsedRealtime();
                }
            }
            return this.f81779b;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void c() {
        boolean z11 = false;
        while (!this.f81779b) {
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
        z11 = this.f81779b;
        this.f81779b = false;
        return z11;
    }

    public synchronized boolean e() {
        return this.f81779b;
    }

    public synchronized boolean f() {
        if (this.f81779b) {
            return false;
        }
        this.f81779b = true;
        notifyAll();
        return true;
    }
}
