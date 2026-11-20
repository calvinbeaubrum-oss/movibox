package pl.droidsonroids.gif;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f73919a;

    public synchronized void a() throws InterruptedException {
        while (!this.f73919a) {
            wait();
        }
    }

    public synchronized void b() {
        this.f73919a = false;
    }

    public synchronized void c() {
        boolean z11 = this.f73919a;
        this.f73919a = true;
        if (!z11) {
            notify();
        }
    }

    public synchronized void d(boolean z11) {
        try {
            if (z11) {
                c();
            } else {
                b();
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
