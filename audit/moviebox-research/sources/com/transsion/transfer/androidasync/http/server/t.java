package com.transsion.transfer.androidasync.http.server;

import com.transsion.transfer.androidasync.c0;
import com.transsion.transfer.androidasync.u;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class t implements gy.a<Void> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f58812a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f58813b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.transsion.transfer.androidasync.r f58814c;

    public t(String str) {
        this.f58813b = str;
    }

    @Override // gy.a
    public void B(com.transsion.transfer.androidasync.r rVar, fy.a aVar) {
        this.f58814c = rVar;
        rVar.A(aVar);
        rVar.o(new fy.d.a());
    }

    @Override // gy.a
    public void H(com.transsion.transfer.androidasync.http.j jVar, u uVar, fy.a aVar) {
        c0.c(this.f58814c, uVar, aVar);
        if (this.f58814c.e()) {
            this.f58814c.resume();
        }
    }

    @Override // gy.a
    public boolean J() {
        return false;
    }

    @Override // gy.a
    public String c() {
        return this.f58813b;
    }

    @Override // gy.a
    public int length() {
        return this.f58812a;
    }
}
