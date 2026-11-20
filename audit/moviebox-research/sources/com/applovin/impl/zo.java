package com.applovin.impl;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class zo extends z1 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f24900i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f24901j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f24902k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f24903l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private byte[] f24904m = xp.f24377f;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f24905n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f24906o;

    public void a(int i11, int i12) {
        this.f24900i = i11;
        this.f24901j = i12;
    }

    @Override // com.applovin.impl.p1
    public void a(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i11 = iLimit - iPosition;
        if (i11 == 0) {
            return;
        }
        int iMin = Math.min(i11, this.f24903l);
        this.f24906o += (long) (iMin / this.f24738b.f21637d);
        this.f24903l -= iMin;
        byteBuffer.position(iPosition + iMin);
        if (this.f24903l > 0) {
            return;
        }
        int i12 = i11 - iMin;
        int length = (this.f24905n + i12) - this.f24904m.length;
        ByteBuffer byteBufferA = a(length);
        int iA = xp.a(length, 0, this.f24905n);
        byteBufferA.put(this.f24904m, 0, iA);
        int iA2 = xp.a(length - iA, 0, i12);
        byteBuffer.limit(byteBuffer.position() + iA2);
        byteBufferA.put(byteBuffer);
        byteBuffer.limit(iLimit);
        int i13 = i12 - iA2;
        int i14 = this.f24905n - iA;
        this.f24905n = i14;
        byte[] bArr = this.f24904m;
        System.arraycopy(bArr, iA, bArr, 0, i14);
        byteBuffer.get(this.f24904m, this.f24905n, i13);
        this.f24905n += i13;
        byteBufferA.flip();
    }

    @Override // com.applovin.impl.z1
    public p1.a b(p1.a aVar) throws p1.b {
        if (aVar.f21636c != 2) {
            throw new p1.b(aVar);
        }
        this.f24902k = true;
        return (this.f24900i == 0 && this.f24901j == 0) ? p1.a.f21633e : aVar;
    }

    @Override // com.applovin.impl.z1, com.applovin.impl.p1
    public boolean c() {
        return super.c() && this.f24905n == 0;
    }

    @Override // com.applovin.impl.z1, com.applovin.impl.p1
    public ByteBuffer d() {
        int i11;
        if (super.c() && (i11 = this.f24905n) > 0) {
            a(i11).put(this.f24904m, 0, this.f24905n).flip();
            this.f24905n = 0;
        }
        return super.d();
    }

    @Override // com.applovin.impl.z1
    public void g() {
        if (this.f24902k) {
            this.f24902k = false;
            int i11 = this.f24901j;
            int i12 = this.f24738b.f21637d;
            this.f24904m = new byte[i11 * i12];
            this.f24903l = this.f24900i * i12;
        }
        this.f24905n = 0;
    }

    @Override // com.applovin.impl.z1
    public void h() {
        if (this.f24902k) {
            int i11 = this.f24905n;
            if (i11 > 0) {
                this.f24906o += (long) (i11 / this.f24738b.f21637d);
            }
            this.f24905n = 0;
        }
    }

    @Override // com.applovin.impl.z1
    public void i() {
        this.f24904m = xp.f24377f;
    }

    public long j() {
        return this.f24906o;
    }

    public void k() {
        this.f24906o = 0L;
    }
}
