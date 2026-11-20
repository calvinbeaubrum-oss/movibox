package com.applovin.impl;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class c9 extends z1 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f18143i = Float.floatToIntBits(Float.NaN);

    private static void a(int i11, ByteBuffer byteBuffer) {
        int iFloatToIntBits = Float.floatToIntBits((float) (((double) i11) * 4.656612875245797E-10d));
        if (iFloatToIntBits == f18143i) {
            iFloatToIntBits = Float.floatToIntBits(0.0f);
        }
        byteBuffer.putInt(iFloatToIntBits);
    }

    @Override // com.applovin.impl.p1
    public void a(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferA;
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i11 = iLimit - iPosition;
        int i12 = this.f24738b.f21636c;
        if (i12 == 536870912) {
            byteBufferA = a((i11 / 3) * 4);
            while (iPosition < iLimit) {
                a(((byteBuffer.get(iPosition) & 255) << 8) | ((byteBuffer.get(iPosition + 1) & 255) << 16) | ((byteBuffer.get(iPosition + 2) & 255) << 24), byteBufferA);
                iPosition += 3;
            }
        } else {
            if (i12 != 805306368) {
                throw new IllegalStateException();
            }
            byteBufferA = a(i11);
            while (iPosition < iLimit) {
                a((byteBuffer.get(iPosition) & 255) | ((byteBuffer.get(iPosition + 1) & 255) << 8) | ((byteBuffer.get(iPosition + 2) & 255) << 16) | ((byteBuffer.get(iPosition + 3) & 255) << 24), byteBufferA);
                iPosition += 4;
            }
        }
        byteBuffer.position(byteBuffer.limit());
        byteBufferA.flip();
    }

    @Override // com.applovin.impl.z1
    public p1.a b(p1.a aVar) throws p1.b {
        int i11 = aVar.f21636c;
        if (xp.f(i11)) {
            return i11 != 4 ? new p1.a(aVar.f21634a, aVar.f21635b, 4) : p1.a.f21633e;
        }
        throw new p1.b(aVar);
    }
}
