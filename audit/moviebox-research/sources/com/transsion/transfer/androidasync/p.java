package com.transsion.transfer.androidasync;

import com.google.android.gms.common.api.Api;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class p implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public u f58850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f58851b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public fy.j f58853d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f58855f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ByteBufferList f58852c = new ByteBufferList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f58854e = Api.BaseClientBuilder.API_PRIORITY_OTHER;

    public p(u uVar) {
        l(uVar);
    }

    @Override // com.transsion.transfer.androidasync.u
    public AsyncServer a() {
        return this.f58850a.a();
    }

    @Override // com.transsion.transfer.androidasync.u
    public void f() {
        if (a().o() != Thread.currentThread()) {
            a().D(new Runnable() { // from class: com.transsion.transfer.androidasync.n
                @Override // java.lang.Runnable
                public final void run() {
                    this.f58848a.f();
                }
            });
            return;
        }
        synchronized (this.f58852c) {
            try {
                if (this.f58852c.r()) {
                    this.f58855f = true;
                } else {
                    this.f58850a.f();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void g(boolean z11) {
        this.f58851b = z11;
        if (z11) {
            return;
        }
        o();
    }

    public boolean h() {
        return this.f58852c.r() || this.f58851b;
    }

    public void i(ByteBufferList byteBufferList) {
    }

    public int j() {
        return this.f58852c.C();
    }

    @Override // com.transsion.transfer.androidasync.u
    public fy.j k() {
        return this.f58853d;
    }

    public void l(u uVar) {
        this.f58850a = uVar;
        uVar.p(new fy.j() { // from class: com.transsion.transfer.androidasync.o
            @Override // fy.j
            public final void a() {
                this.f58849a.o();
            }
        });
    }

    @Override // com.transsion.transfer.androidasync.u
    public void m(ByteBufferList byteBufferList) {
        if (a().o() == Thread.currentThread()) {
            i(byteBufferList);
            if (!h()) {
                this.f58850a.m(byteBufferList);
            }
            synchronized (this.f58852c) {
                byteBufferList.f(this.f58852c);
            }
            return;
        }
        synchronized (this.f58852c) {
            try {
                if (this.f58852c.C() >= this.f58854e) {
                    return;
                }
                i(byteBufferList);
                byteBufferList.f(this.f58852c);
                a().D(new Runnable() { // from class: com.transsion.transfer.androidasync.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f58847a.o();
                    }
                });
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void n(int i11) {
        this.f58854e = i11;
    }

    public final void o() {
        boolean zS;
        fy.j jVar;
        if (this.f58851b) {
            return;
        }
        synchronized (this.f58852c) {
            this.f58850a.m(this.f58852c);
            zS = this.f58852c.s();
        }
        if (zS && this.f58855f) {
            this.f58850a.f();
        }
        if (!zS || (jVar = this.f58853d) == null) {
            return;
        }
        jVar.a();
    }

    @Override // com.transsion.transfer.androidasync.u
    public void p(fy.j jVar) {
        this.f58853d = jVar;
    }

    @Override // com.transsion.transfer.androidasync.u
    public void y(fy.a aVar) {
        this.f58850a.y(aVar);
    }
}
