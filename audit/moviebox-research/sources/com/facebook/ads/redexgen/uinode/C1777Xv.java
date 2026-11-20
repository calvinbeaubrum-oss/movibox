package com.facebook.ads.redexgen.uinode;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Xv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1777Xv implements InterfaceC1190Ab {
    public static String[] A06 = {"LkLK", "abA9PNMrvscgwbqokpbH2", "wszIi3vfQywtet5OFqyTWUvoUYNS5ktb", "liexkOjxlVrdDutCVl0EvpIg3k3OXdWT", "uDjcyehsvUvWAc8oFKsUcicvrdYrbu", "Yx0xuqb7ConKzBOp6wI44fmqMUTcgjwu", "2AEFdY1ASteFDfy1ihWDcuoiihyMOIox", "2HHuLOzdt0KrTaQRoJg3USXKVGpaMcoz"};
    public boolean A05;
    public int A02 = -1;
    public int A00 = -1;
    public int A01 = 0;
    public ByteBuffer A03 = InterfaceC1190Ab.A00;
    public ByteBuffer A04 = InterfaceC1190Ab.A00;

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1190Ab
    public final boolean A4Q(int i11, int i12, int i13) throws C1189Aa {
        if (i13 != 3 && i13 != 2 && i13 != Integer.MIN_VALUE && i13 != 1073741824) {
            throw new C1189Aa(i11, i12, i13);
        }
        if (this.A02 != i11 || this.A00 != i12 || this.A01 != i13) {
            this.A02 = i11;
            this.A00 = i12;
            this.A01 = i13;
            return true;
        }
        String[] strArr = A06;
        if (strArr[5].charAt(14) == strArr[3].charAt(14)) {
            throw new RuntimeException();
        }
        A06[4] = "26RCfMYW5Do9ItFOuFHGepjFl0G7YQ";
        return false;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1190Ab
    public final ByteBuffer A7W() {
        ByteBuffer byteBuffer = this.A04;
        this.A04 = InterfaceC1190Ab.A00;
        return byteBuffer;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1190Ab
    public final int A7X() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1190Ab
    public final int A7Y() {
        return 2;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1190Ab
    public final int A7Z() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1190Ab
    public final boolean A8w() {
        int i11 = this.A01;
        return (i11 == 0 || i11 == 2) ? false : true;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1190Ab
    public final boolean A91() {
        return this.A05 && this.A04 == InterfaceC1190Ab.A00;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1190Ab
    public final void AEE() {
        this.A05 = true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1190Ab
    public final void AEF(ByteBuffer byteBuffer) {
        int i11;
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i12 = iLimit - iPosition;
        switch (this.A01) {
            case Integer.MIN_VALUE:
                i11 = (i12 / 3) * 2;
                break;
            case 3:
                i11 = i12 * 2;
                break;
            case 1073741824:
                i11 = i12 / 2;
                break;
            default:
                throw new IllegalStateException();
        }
        if (this.A03.capacity() < i11) {
            ByteBuffer byteBufferOrder = ByteBuffer.allocateDirect(i11).order(ByteOrder.nativeOrder());
            String[] strArr = A06;
            if (strArr[5].charAt(14) == strArr[3].charAt(14)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A06;
            strArr2[6] = "hXv0xOe0fZxBP6BjMdwou1g9whaCh4Nv";
            strArr2[7] = "rvzJSg8TnEJLrC3bKKMSDNtobyDED6VD";
            this.A03 = byteBufferOrder;
        } else {
            this.A03.clear();
        }
        switch (this.A01) {
            case Integer.MIN_VALUE:
                while (iPosition < iLimit) {
                    this.A03.put(byteBuffer.get(iPosition + 1));
                    this.A03.put(byteBuffer.get(iPosition + 2));
                    iPosition += 3;
                }
                byteBuffer.position(byteBuffer.limit());
                this.A03.flip();
                this.A04 = this.A03;
                return;
            case 3:
                while (iPosition < iLimit) {
                    this.A03.put((byte) 0);
                    ByteBuffer byteBuffer2 = this.A03;
                    byte b11 = (byte) ((byteBuffer.get(iPosition) & 255) - 128);
                    if (A06[1].length() != 4) {
                        String[] strArr3 = A06;
                        strArr3[5] = "93yfqVEE4BL66fKyhULGxcexfiDPz3ma";
                        strArr3[3] = "pJFS3cGyfO0gWrhajAAEFVsdSj1hVUV9";
                        byteBuffer2.put(b11);
                        iPosition++;
                    } else {
                        byteBuffer2.put(b11);
                        iPosition++;
                    }
                }
                byteBuffer.position(byteBuffer.limit());
                this.A03.flip();
                this.A04 = this.A03;
                return;
            case 1073741824:
                while (iPosition < iLimit) {
                    this.A03.put(byteBuffer.get(iPosition + 2));
                    this.A03.put(byteBuffer.get(iPosition + 3));
                    iPosition += 4;
                }
                byteBuffer.position(byteBuffer.limit());
                this.A03.flip();
                this.A04 = this.A03;
                return;
            default:
                throw new IllegalStateException();
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1190Ab
    public final void flush() {
        this.A04 = InterfaceC1190Ab.A00;
        this.A05 = false;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1190Ab
    public final void reset() {
        flush();
        this.A02 = -1;
        this.A00 = -1;
        this.A01 = 0;
        this.A03 = InterfaceC1190Ab.A00;
    }
}
