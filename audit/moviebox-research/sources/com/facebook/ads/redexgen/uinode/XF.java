package com.facebook.ads.redexgen.uinode;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class XF implements InterfaceC1233Bs {
    public static byte[] A03;
    public static final InterfaceC1236Bv A04;
    public InterfaceC1235Bu A00;
    public AbstractC1252Co A01;
    public boolean A02;

    static {
        A02();
        A04 = new XG();
    }

    public static C1376Hz A00(C1376Hz c1376Hz) {
        c1376Hz.A0Y(0);
        return c1376Hz;
    }

    public static String A01(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 37);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A03 = new byte[]{108, -121, -113, -110, -117, -118, 70, -102, -107, 70, -118, -117, -102, -117, -104, -109, -113, -108, -117, 70, -120, -113, -102, -103, -102, -104, -117, -121, -109, 70, -102, -97, -106, -117};
    }

    private boolean A03(InterfaceC1234Bt interfaceC1234Bt) throws InterruptedException, IOException {
        C1248Ck c1248Ck = new C1248Ck();
        if (!c1248Ck.A03(interfaceC1234Bt, true) || (c1248Ck.A04 & 2) != 2) {
            return false;
        }
        int iMin = Math.min(c1248Ck.A00, 8);
        C1376Hz c1376Hz = new C1376Hz(iMin);
        interfaceC1234Bt.ADv(c1376Hz.A00, 0, iMin);
        if (XH.A04(A00(c1376Hz))) {
            this.A01 = new XH();
        } else if (XC.A06(A00(c1376Hz))) {
            this.A01 = new XC();
        } else {
            if (!XE.A04(A00(c1376Hz))) {
                return false;
            }
            this.A01 = new XE();
        }
        return true;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1233Bs
    public final void A8o(InterfaceC1235Bu interfaceC1235Bu) {
        this.A00 = interfaceC1235Bu;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1233Bs
    public final int AEH(InterfaceC1234Bt interfaceC1234Bt, C1238Bz c1238Bz) throws InterruptedException, IOException {
        if (this.A01 == null) {
            if (!A03(interfaceC1234Bt)) {
                throw new C11849v(A01(0, 34, 1));
            }
            interfaceC1234Bt.AFM();
        }
        if (!this.A02) {
            C4 c4AGi = this.A00.AGi(0, 1);
            this.A00.A5Y();
            this.A01.A06(this.A00, c4AGi);
            this.A02 = true;
        }
        return this.A01.A02(interfaceC1234Bt, c1238Bz);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1233Bs
    public final void AFh(long j11, long j12) {
        AbstractC1252Co abstractC1252Co = this.A01;
        if (abstractC1252Co != null) {
            abstractC1252Co.A05(j11, j12);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1233Bs
    public final boolean AGR(InterfaceC1234Bt interfaceC1234Bt) throws InterruptedException, IOException {
        try {
            return A03(interfaceC1234Bt);
        } catch (C11849v unused) {
            return false;
        }
    }
}
