package com.facebook.ads.redexgen.uinode;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class XA implements InterfaceC1233Bs {
    public static byte[] A04;
    public static String[] A05 = {"89ZAS4gKAvfsCOhGFLRndaPlzH5Jylu0", "WDj0w8iYShPhw5JkNLQVjMzFidij1YMB", "SZD8V9ebG6DMCxkEToUDQHseHkwYH45y", "flB69VC8Ebs69L5nDVZVAs6kLxLMfW9p", "Dc9Giep11FBAOEJK", "fiVRhSZcsaoyqUlEeIiHO4czNXpaN55t", "HHz5E2PDkz6p7na9zQig", "GASwop9kiLfFsL9tAHZWlbr16muWtU3x"};
    public static final InterfaceC1236Bv A06;
    public static final int A07;
    public boolean A00;
    public final long A01;
    public final X9 A02;
    public final C1376Hz A03;

    static {
        A01();
        A06 = new XB();
        A07 = IF.A08(A00(0, 3, 105));
    }

    public XA() {
        this(0L);
    }

    public XA(long j11) {
        this.A01 = j11;
        this.A02 = new X9();
        this.A03 = new C1376Hz(2786);
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 70);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{-8, -13, -30};
        if (A05[3].charAt(6) != 'C') {
            throw new RuntimeException();
        }
        A05[6] = "Dcf";
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1233Bs
    public final void A8o(InterfaceC1235Bu interfaceC1235Bu) {
        this.A02.A4p(interfaceC1235Bu, new DC(0, 1));
        interfaceC1235Bu.A5Y();
        interfaceC1235Bu.AFi(new C1765Xj(C.TIME_UNSET));
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1233Bs
    public final int AEH(InterfaceC1234Bt interfaceC1234Bt, C1238Bz c1238Bz) throws InterruptedException, IOException {
        int i11 = interfaceC1234Bt.read(this.A03.A00, 0, 2786);
        if (i11 == -1) {
            return -1;
        }
        this.A03.A0Y(0);
        this.A03.A0X(i11);
        if (!this.A00) {
            this.A02.ADt(this.A01, true);
            this.A00 = true;
        }
        this.A02.A4R(this.A03);
        return 0;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1233Bs
    public final void AFh(long j11, long j12) {
        this.A00 = false;
        this.A02.AFg();
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1233Bs
    public final boolean AGR(InterfaceC1234Bt interfaceC1234Bt) throws InterruptedException, IOException {
        C1376Hz c1376Hz = new C1376Hz(10);
        int i11 = 0;
        while (true) {
            interfaceC1234Bt.ADv(c1376Hz.A00, 0, 10);
            c1376Hz.A0Y(0);
            if (c1376Hz.A0G() != A07) {
                break;
            }
            c1376Hz.A0Z(3);
            int iA0D = c1376Hz.A0D();
            i11 += iA0D + 10;
            interfaceC1234Bt.A3W(iA0D);
        }
        interfaceC1234Bt.AFM();
        interfaceC1234Bt.A3W(i11);
        int i12 = i11;
        int i13 = 0;
        while (true) {
            interfaceC1234Bt.ADv(c1376Hz.A00, 0, 5);
            c1376Hz.A0Y(0);
            if (c1376Hz.A0I() != 2935) {
                i13 = 0;
                interfaceC1234Bt.AFM();
                i12++;
                if (i12 - i11 >= 8192) {
                    return false;
                }
                interfaceC1234Bt.A3W(i12);
            } else {
                i13++;
                if (i13 >= 4) {
                    return true;
                }
                int iA05 = AQ.A05(c1376Hz.A00);
                if (iA05 == -1) {
                    return false;
                }
                interfaceC1234Bt.A3W(iA05 - 5);
            }
        }
    }
}
