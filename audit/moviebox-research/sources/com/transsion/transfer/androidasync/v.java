package com.transsion.transfer.androidasync;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class v extends s implements fy.d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public r f58879d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f58880e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f58881f;

    /* JADX INFO: compiled from: source.java */
    public class a implements fy.a {
        public a() {
        }

        @Override // fy.a
        public void i(Exception exc) {
            v.this.L(exc);
        }
    }

    public void D(r rVar, ByteBufferList byteBufferList) {
        if (this.f58881f) {
            byteBufferList.B();
            return;
        }
        if (byteBufferList != null) {
            this.f58880e += byteBufferList.C();
        }
        c0.a(this, byteBufferList);
        if (byteBufferList != null) {
            this.f58880e -= byteBufferList.C();
        }
    }

    public void M(r rVar) {
        r rVar2 = this.f58879d;
        if (rVar2 != null) {
            rVar2.o(null);
        }
        this.f58879d = rVar;
        rVar.o(this);
        this.f58879d.A(new a());
    }

    @Override // com.transsion.transfer.androidasync.r, com.transsion.transfer.androidasync.u
    public AsyncServer a() {
        return this.f58879d.a();
    }

    @Override // com.transsion.transfer.androidasync.r
    public void close() {
        this.f58881f = true;
        r rVar = this.f58879d;
        if (rVar != null) {
            rVar.close();
        }
    }

    @Override // com.transsion.transfer.androidasync.r
    public boolean e() {
        return this.f58879d.e();
    }

    @Override // com.transsion.transfer.androidasync.r
    public void pause() {
        this.f58879d.pause();
    }

    @Override // com.transsion.transfer.androidasync.r
    public void resume() {
        this.f58879d.resume();
    }

    @Override // com.transsion.transfer.androidasync.r
    public String s() {
        r rVar = this.f58879d;
        if (rVar == null) {
            return null;
        }
        return rVar.s();
    }
}
