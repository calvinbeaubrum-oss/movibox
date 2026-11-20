package com.facebook.ads.redexgen.uinode;

import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class EL {
    public static byte[] A05;
    public static String[] A06 = {"ys79rflcZR", "JvXVVVa5NcPDQ", "Q89GAQFZPNwANkfCdiKH1gvUr6", "fZOyMOuChjfI9gOKYd90JCIRk18sz1rD", "OOW8UfRJew081BUdbBG5Pxzf0VO", "xPmLQSFy3SjaACTv6gu", "e8kFvK5VJCM4F", "4YvHW6"};
    public final InterfaceC1343Gr A00;
    public final InterfaceC1345Gt A01;
    public final InterfaceC1345Gt A02;
    public final HK A03;
    public final I3 A04;

    static {
        A01();
    }

    public EL(HK hk2, InterfaceC1345Gt interfaceC1345Gt) {
        this(hk2, interfaceC1345Gt, null, null, null);
    }

    public EL(HK hk2, InterfaceC1345Gt interfaceC1345Gt, InterfaceC1345Gt interfaceC1345Gt2, InterfaceC1343Gr interfaceC1343Gr, I3 i11) {
        AbstractC1351Ha.A01(interfaceC1345Gt);
        this.A03 = hk2;
        this.A02 = interfaceC1345Gt;
        this.A01 = interfaceC1345Gt2;
        this.A00 = interfaceC1343Gr;
        this.A04 = i11;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            int i15 = (bArrCopyOfRange[i14] - i13) - 26;
            String[] strArr = A06;
            if (strArr[1].length() != strArr[6].length()) {
                throw new RuntimeException();
            }
            A06[5] = "z6hEl1VDyGriGJRg";
            bArrCopyOfRange[i14] = (byte) i15;
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A05 = new byte[]{126, -115, -128, 124, -113, -128, 95, 124, -113, 124, 110, -124, -119, -122};
    }

    public final HK A02() {
        return this.A03;
    }

    public final C1717Vk A03(boolean z11) {
        InterfaceC1345Gt interfaceC1345Gt = this.A01;
        InterfaceC1346Gu interfaceC1346GuA4X = interfaceC1345Gt != null ? interfaceC1345Gt.A4X() : new C1729Vw();
        if (z11) {
            return new C1717Vk(this.A03, C1730Vx.A02, interfaceC1346GuA4X, null, 1, null);
        }
        if (0 != 0) {
            throw new NullPointerException(A00(0, 14, 1));
        }
        C1718Vl c1718Vl = new C1718Vl(this.A03, 2097152L);
        InterfaceC1346Gu interfaceC1346GuA4X2 = this.A02.A4X();
        I3 i11 = this.A04;
        if (i11 != null) {
            interfaceC1346GuA4X2 = new C1722Vp(interfaceC1346GuA4X2, i11, -1000);
        }
        return new C1717Vk(this.A03, interfaceC1346GuA4X2, interfaceC1346GuA4X, c1718Vl, 1, null);
    }

    public final I3 A04() {
        I3 i11 = this.A04;
        return i11 != null ? i11 : new I3();
    }
}
