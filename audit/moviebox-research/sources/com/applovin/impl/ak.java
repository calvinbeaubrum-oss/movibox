package com.applovin.impl;

import com.google.android.gms.location.DeviceOrientationRequest;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ak extends z1 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final long f17721i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final long f17722j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final short f17723k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f17724l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f17725m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private byte[] f17726n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private byte[] f17727o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f17728p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f17729q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f17730r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f17731s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private long f17732t;

    public ak() {
        this(150000L, DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT, (short) 1024);
    }

    public ak(long j11, long j12, short s11) {
        b1.a(j12 <= j11);
        this.f17721i = j11;
        this.f17722j = j12;
        this.f17723k = s11;
        byte[] bArr = xp.f24377f;
        this.f17726n = bArr;
        this.f17727o = bArr;
    }

    private int a(long j11) {
        return (int) ((j11 * ((long) this.f24738b.f21634a)) / 1000000);
    }

    private void a(ByteBuffer byteBuffer, byte[] bArr, int i11) {
        int iMin = Math.min(byteBuffer.remaining(), this.f17730r);
        int i12 = this.f17730r - iMin;
        System.arraycopy(bArr, i11 - i12, this.f17727o, 0, i12);
        byteBuffer.position(byteBuffer.limit() - iMin);
        byteBuffer.get(this.f17727o, i12, iMin);
    }

    private void a(byte[] bArr, int i11) {
        a(i11).put(bArr, 0, i11).flip();
        if (i11 > 0) {
            this.f17731s = true;
        }
    }

    private int b(ByteBuffer byteBuffer) {
        int iLimit = byteBuffer.limit();
        do {
            iLimit -= 2;
            if (iLimit < byteBuffer.position()) {
                return byteBuffer.position();
            }
        } while (Math.abs((int) byteBuffer.getShort(iLimit)) <= this.f17723k);
        int i11 = this.f17724l;
        return ((iLimit / i11) * i11) + i11;
    }

    private int c(ByteBuffer byteBuffer) {
        for (int iPosition = byteBuffer.position(); iPosition < byteBuffer.limit(); iPosition += 2) {
            if (Math.abs((int) byteBuffer.getShort(iPosition)) > this.f17723k) {
                int i11 = this.f17724l;
                return i11 * (iPosition / i11);
            }
        }
        return byteBuffer.limit();
    }

    private void d(ByteBuffer byteBuffer) {
        int iRemaining = byteBuffer.remaining();
        a(iRemaining).put(byteBuffer).flip();
        if (iRemaining > 0) {
            this.f17731s = true;
        }
    }

    private void e(ByteBuffer byteBuffer) {
        int iLimit = byteBuffer.limit();
        int iC = c(byteBuffer);
        int iPosition = iC - byteBuffer.position();
        byte[] bArr = this.f17726n;
        int length = bArr.length;
        int i11 = this.f17729q;
        int i12 = length - i11;
        if (iC < iLimit && iPosition < i12) {
            a(bArr, i11);
            this.f17729q = 0;
            this.f17728p = 0;
            return;
        }
        int iMin = Math.min(iPosition, i12);
        byteBuffer.limit(byteBuffer.position() + iMin);
        byteBuffer.get(this.f17726n, this.f17729q, iMin);
        int i13 = this.f17729q + iMin;
        this.f17729q = i13;
        byte[] bArr2 = this.f17726n;
        if (i13 == bArr2.length) {
            if (this.f17731s) {
                a(bArr2, this.f17730r);
                this.f17732t += (long) ((this.f17729q - (this.f17730r * 2)) / this.f17724l);
            } else {
                this.f17732t += (long) ((i13 - this.f17730r) / this.f17724l);
            }
            a(byteBuffer, this.f17726n, this.f17729q);
            this.f17729q = 0;
            this.f17728p = 2;
        }
        byteBuffer.limit(iLimit);
    }

    private void f(ByteBuffer byteBuffer) {
        int iLimit = byteBuffer.limit();
        byteBuffer.limit(Math.min(iLimit, byteBuffer.position() + this.f17726n.length));
        int iB = b(byteBuffer);
        if (iB == byteBuffer.position()) {
            this.f17728p = 1;
        } else {
            byteBuffer.limit(iB);
            d(byteBuffer);
        }
        byteBuffer.limit(iLimit);
    }

    private void g(ByteBuffer byteBuffer) {
        int iLimit = byteBuffer.limit();
        int iC = c(byteBuffer);
        byteBuffer.limit(iC);
        this.f17732t += (long) (byteBuffer.remaining() / this.f17724l);
        a(byteBuffer, this.f17727o, this.f17730r);
        if (iC < iLimit) {
            a(this.f17727o, this.f17730r);
            this.f17728p = 0;
            byteBuffer.limit(iLimit);
        }
    }

    @Override // com.applovin.impl.p1
    public void a(ByteBuffer byteBuffer) {
        while (byteBuffer.hasRemaining() && !a()) {
            int i11 = this.f17728p;
            if (i11 == 0) {
                f(byteBuffer);
            } else if (i11 == 1) {
                e(byteBuffer);
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException();
                }
                g(byteBuffer);
            }
        }
    }

    public void a(boolean z11) {
        this.f17725m = z11;
    }

    @Override // com.applovin.impl.z1
    public p1.a b(p1.a aVar) throws p1.b {
        if (aVar.f21636c == 2) {
            return this.f17725m ? aVar : p1.a.f21633e;
        }
        throw new p1.b(aVar);
    }

    @Override // com.applovin.impl.z1, com.applovin.impl.p1
    public boolean f() {
        return this.f17725m;
    }

    @Override // com.applovin.impl.z1
    public void g() {
        if (this.f17725m) {
            this.f17724l = this.f24738b.f21637d;
            int iA = a(this.f17721i) * this.f17724l;
            if (this.f17726n.length != iA) {
                this.f17726n = new byte[iA];
            }
            int iA2 = a(this.f17722j) * this.f17724l;
            this.f17730r = iA2;
            if (this.f17727o.length != iA2) {
                this.f17727o = new byte[iA2];
            }
        }
        this.f17728p = 0;
        this.f17732t = 0L;
        this.f17729q = 0;
        this.f17731s = false;
    }

    @Override // com.applovin.impl.z1
    public void h() {
        int i11 = this.f17729q;
        if (i11 > 0) {
            a(this.f17726n, i11);
        }
        if (this.f17731s) {
            return;
        }
        this.f17732t += (long) (this.f17730r / this.f17724l);
    }

    @Override // com.applovin.impl.z1
    public void i() {
        this.f17725m = false;
        this.f17730r = 0;
        byte[] bArr = xp.f24377f;
        this.f17726n = bArr;
        this.f17727o = bArr;
    }

    public long j() {
        return this.f17732t;
    }
}
