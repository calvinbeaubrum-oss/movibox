package com.danikula.videocache;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f32370a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f32374e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f32375f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f32377h;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f32371b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f32372c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile int f32373d = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile long f32376g = -1;

    public m(a aVar) {
        this.f32370a = (a) l.c(aVar);
        aVar.F(this);
    }

    public void a(long j11) {
        this.f32370a.E(j11);
        this.f32370a.C(j11);
    }

    public boolean b() {
        return this.f32375f;
    }

    public void c() {
        synchronized (this.f32371b) {
            q.c("-------get new data, notify wait~");
            this.f32375f = false;
            this.f32371b.notifyAll();
        }
    }

    public int d(byte[] bArr, long j11, int i11, String str) throws ProxyCacheException {
        n.a(bArr, j11, i11);
        while (!this.f32370a.isCompleted() && !this.f32370a.H(j11, i11, str) && !this.f32374e) {
            this.f32377h = true;
            h();
        }
        if (this.f32377h) {
            q.e("isWaited， isAvailable = " + this.f32370a.H(j11, i11, str) + " ,offset = " + j11);
        }
        this.f32377h = false;
        int iD = this.f32370a.D(bArr, j11, i11, str);
        if (iD > 0) {
            com.transsnet.downloader.util.e.f61155a.b("4");
        }
        if (this.f32376g < 0 || (j11 - this.f32376g > 512000 && iD > 0)) {
            this.f32376g = j11;
            q.f("ProxyCache read， isCompleted = " + this.f32370a.isCompleted() + " ,offset = " + j11);
        }
        return iD;
    }

    public void e() {
        synchronized (this.f32372c) {
            q.a("Shutdown proxy");
            try {
                this.f32374e = true;
                this.f32370a.close();
            } catch (Throwable th2) {
                q.a("Shutdown proxy, error = " + th2);
            }
        }
    }

    public void f() {
        q.e("----start");
        this.f32374e = false;
    }

    public void g() {
        q.e("--stop");
        this.f32374e = true;
        c();
    }

    public final void h() {
        synchronized (this.f32371b) {
            try {
                this.f32375f = true;
                this.f32371b.wait(1000L);
                this.f32375f = false;
            } catch (Throwable th2) {
                q.b("waitForSourceData error， error = " + th2);
                th2.printStackTrace();
            }
        }
    }
}
