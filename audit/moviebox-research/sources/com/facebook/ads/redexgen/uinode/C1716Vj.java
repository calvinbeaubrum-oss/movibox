package com.facebook.ads.redexgen.uinode;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Vj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1716Vj implements InterfaceC1345Gt {
    public static byte[] A06;
    public final int A00;
    public final InterfaceC1343Gr A01;
    public final InterfaceC1345Gt A02;
    public final InterfaceC1345Gt A03;
    public final HK A04;
    public final HM A05;

    static {
        A02();
    }

    public C1716Vj(HK hk2, InterfaceC1345Gt interfaceC1345Gt, InterfaceC1345Gt interfaceC1345Gt2, InterfaceC1343Gr interfaceC1343Gr, int i11, HM hm2) {
        this.A04 = hk2;
        this.A03 = interfaceC1345Gt;
        this.A02 = interfaceC1345Gt2;
        this.A01 = interfaceC1343Gr;
        this.A00 = i11;
        this.A05 = hm2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1345Gt
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final C1717Vk A4X() {
        HK hk2 = this.A04;
        InterfaceC1346Gu interfaceC1346GuA4X = this.A03.A4X();
        InterfaceC1346Gu interfaceC1346GuA4X2 = this.A02.A4X();
        if (0 != 0) {
            throw new NullPointerException(A01(0, 14, 37));
        }
        return new C1717Vk(hk2, interfaceC1346GuA4X, interfaceC1346GuA4X2, null, this.A00, null);
    }

    public static String A01(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 44);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A06 = new byte[]{106, 123, 108, 104, 125, 108, 77, 104, 125, 104, 90, 96, 103, 98};
    }
}
