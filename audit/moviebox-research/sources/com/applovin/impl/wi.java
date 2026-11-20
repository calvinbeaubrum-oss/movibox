package com.applovin.impl;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class wi extends z1 {
    @Override // com.applovin.impl.p1
    public void a(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i11 = iLimit - iPosition;
        int i12 = this.f24738b.f21636c;
        if (i12 == 3) {
            i11 *= 2;
        } else if (i12 == 4) {
            i11 /= 2;
        } else if (i12 != 268435456) {
            if (i12 != 536870912) {
                if (i12 != 805306368) {
                    throw new IllegalStateException();
                }
                i11 /= 2;
            } else {
                i11 /= 3;
                i11 *= 2;
            }
        }
        ByteBuffer byteBufferA = a(i11);
        int i13 = this.f24738b.f21636c;
        if (i13 == 3) {
            while (iPosition < iLimit) {
                byteBufferA.put((byte) 0);
                byteBufferA.put((byte) ((byteBuffer.get(iPosition) & 255) - 128));
                iPosition++;
            }
        } else if (i13 == 4) {
            while (iPosition < iLimit) {
                short sA = (short) (xp.a(byteBuffer.getFloat(iPosition), -1.0f, 1.0f) * 32767.0f);
                byteBufferA.put((byte) (sA & 255));
                byteBufferA.put((byte) ((sA >> 8) & 255));
                iPosition += 4;
            }
        } else if (i13 == 268435456) {
            while (iPosition < iLimit) {
                byteBufferA.put(byteBuffer.get(iPosition + 1));
                byteBufferA.put(byteBuffer.get(iPosition));
                iPosition += 2;
            }
        } else if (i13 == 536870912) {
            while (iPosition < iLimit) {
                byteBufferA.put(byteBuffer.get(iPosition + 1));
                byteBufferA.put(byteBuffer.get(iPosition + 2));
                iPosition += 3;
            }
        } else {
            if (i13 != 805306368) {
                throw new IllegalStateException();
            }
            while (iPosition < iLimit) {
                byteBufferA.put(byteBuffer.get(iPosition + 2));
                byteBufferA.put(byteBuffer.get(iPosition + 3));
                iPosition += 4;
            }
        }
        byteBuffer.position(byteBuffer.limit());
        byteBufferA.flip();
    }

    @Override // com.applovin.impl.z1
    public p1.a b(p1.a aVar) throws p1.b {
        int i11 = aVar.f21636c;
        if (i11 == 3 || i11 == 2 || i11 == 268435456 || i11 == 536870912 || i11 == 805306368 || i11 == 4) {
            return i11 != 2 ? new p1.a(aVar.f21634a, aVar.f21635b, 2) : p1.a.f21633e;
        }
        throw new p1.b(aVar);
    }
}
