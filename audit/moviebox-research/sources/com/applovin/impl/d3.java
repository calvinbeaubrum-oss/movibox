package com.applovin.impl;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class d3 extends z1 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int[] f18342i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int[] f18343j;

    @Override // com.applovin.impl.p1
    public void a(ByteBuffer byteBuffer) {
        int[] iArr = (int[]) b1.a(this.f18343j);
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        ByteBuffer byteBufferA = a(((iLimit - iPosition) / this.f24738b.f21637d) * this.f24739c.f21637d);
        while (iPosition < iLimit) {
            for (int i11 : iArr) {
                byteBufferA.putShort(byteBuffer.getShort((i11 * 2) + iPosition));
            }
            iPosition += this.f24738b.f21637d;
        }
        byteBuffer.position(iLimit);
        byteBufferA.flip();
    }

    public void a(int[] iArr) {
        this.f18342i = iArr;
    }

    @Override // com.applovin.impl.z1
    public p1.a b(p1.a aVar) throws p1.b {
        int[] iArr = this.f18342i;
        if (iArr == null) {
            return p1.a.f21633e;
        }
        if (aVar.f21636c != 2) {
            throw new p1.b(aVar);
        }
        boolean z11 = aVar.f21635b != iArr.length;
        int i11 = 0;
        while (i11 < iArr.length) {
            int i12 = iArr[i11];
            if (i12 >= aVar.f21635b) {
                throw new p1.b(aVar);
            }
            z11 |= i12 != i11;
            i11++;
        }
        return z11 ? new p1.a(aVar.f21634a, iArr.length, 2) : p1.a.f21633e;
    }

    @Override // com.applovin.impl.z1
    public void g() {
        this.f18343j = this.f18342i;
    }

    @Override // com.applovin.impl.z1
    public void i() {
        this.f18343j = null;
        this.f18342i = null;
    }
}
