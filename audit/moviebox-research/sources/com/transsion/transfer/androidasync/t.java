package com.transsion.transfer.androidasync;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class t implements fy.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public fy.d f58861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f58862b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ByteBufferList f58863c = new ByteBufferList();

    @Override // fy.d
    public void D(r rVar, ByteBufferList byteBufferList) {
        do {
            byteBufferList.g(this.f58863c, Math.min(byteBufferList.C(), this.f58862b - this.f58863c.C()));
            byteBufferList.C();
            if (!a(rVar)) {
                break;
            }
        } while (this.f58861a != null);
        byteBufferList.C();
    }

    public final boolean a(r rVar) {
        if (this.f58862b > this.f58863c.C()) {
            return false;
        }
        fy.d dVar = this.f58861a;
        this.f58861a = null;
        dVar.D(rVar, this.f58863c);
        return true;
    }

    public void b(int i11, fy.d dVar) {
        this.f58862b = i11;
        this.f58861a = dVar;
        this.f58863c.B();
    }
}
