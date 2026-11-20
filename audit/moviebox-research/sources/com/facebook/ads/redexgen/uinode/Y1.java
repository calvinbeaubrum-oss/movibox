package com.facebook.ads.redexgen.uinode;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class Y1 implements InterfaceC1190Ab {
    public boolean A04;
    public boolean A05;
    public int[] A06;
    public int[] A07;
    public ByteBuffer A02 = InterfaceC1190Ab.A00;
    public ByteBuffer A03 = InterfaceC1190Ab.A00;
    public int A00 = -1;
    public int A01 = -1;

    public final void A00(int[] iArr) {
        this.A07 = iArr;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1190Ab
    public final boolean A4Q(int i11, int i12, int i13) throws C1189Aa {
        boolean z11 = !Arrays.equals(this.A07, this.A06);
        int[] iArr = this.A07;
        this.A06 = iArr;
        if (iArr == null) {
            this.A04 = false;
            return z11;
        }
        if (i13 != 2) {
            throw new C1189Aa(i11, i12, i13);
        }
        if (!z11 && this.A01 == i11 && this.A00 == i12) {
            return false;
        }
        this.A01 = i11;
        this.A00 = i12;
        this.A04 = i12 != iArr.length;
        int i14 = 0;
        while (true) {
            int[] iArr2 = this.A06;
            if (i14 >= iArr2.length) {
                return true;
            }
            int i15 = iArr2[i14];
            if (i15 >= i12) {
                throw new C1189Aa(i11, i12, i13);
            }
            this.A04 |= i15 != i14;
            i14++;
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1190Ab
    public final ByteBuffer A7W() {
        ByteBuffer byteBuffer = this.A03;
        this.A03 = InterfaceC1190Ab.A00;
        return byteBuffer;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1190Ab
    public final int A7X() {
        int[] iArr = this.A06;
        return iArr == null ? this.A00 : iArr.length;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1190Ab
    public final int A7Y() {
        return 2;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1190Ab
    public final int A7Z() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1190Ab
    public final boolean A8w() {
        return this.A04;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1190Ab
    public final boolean A91() {
        return this.A05 && this.A03 == InterfaceC1190Ab.A00;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1190Ab
    public final void AEE() {
        this.A05 = true;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1190Ab
    public final void AEF(ByteBuffer byteBuffer) {
        AbstractC1351Ha.A04(this.A06 != null);
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int length = this.A06.length * ((iLimit - iPosition) / (this.A00 * 2)) * 2;
        if (this.A02.capacity() < length) {
            this.A02 = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
        } else {
            this.A02.clear();
        }
        while (iPosition < iLimit) {
            for (int i11 : this.A06) {
                this.A02.putShort(byteBuffer.getShort((i11 * 2) + iPosition));
            }
            iPosition += this.A00 * 2;
        }
        byteBuffer.position(iLimit);
        this.A02.flip();
        this.A03 = this.A02;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1190Ab
    public final void flush() {
        this.A03 = InterfaceC1190Ab.A00;
        this.A05 = false;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1190Ab
    public final void reset() {
        flush();
        this.A02 = InterfaceC1190Ab.A00;
        this.A00 = -1;
        this.A01 = -1;
        this.A06 = null;
        this.A07 = null;
        this.A04 = false;
    }
}
