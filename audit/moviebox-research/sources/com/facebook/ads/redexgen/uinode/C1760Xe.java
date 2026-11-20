package com.facebook.ads.redexgen.uinode;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Xe, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1760Xe implements InterfaceC1233Bs {
    public static byte[] A0F;
    public static String[] A0G = {"QnLOeuXESrCaGCWmeMmr3ccgSJivirlh", "YhzsmTzzzxhtyY2gbPt9z7nrByNpJ8AG", "zwujZ5tU8kb2uxp5tp3MFQMZqwl6Xl8T", "kc6RUJmY0MGel4Ws9MlGHroinjQjp2AB", "ZiGWNZua4Zts1sNsjYBSU4OXsNo5k01z", "vZczIWNBPrLvTkXGahgR3lrPVHA61MAE", "WEnNwLMqAaXyN6vSaeVfRhJYgSEHaora", "u0NJWOpvT5UyzhfOPQB88kiisy6mVL7a"};
    public static final InterfaceC1236Bv A0H;
    public static final int A0I;
    public int A00;
    public int A02;
    public int A03;
    public long A05;
    public InterfaceC1235Bu A06;
    public C1762Xg A07;
    public C1757Xb A08;
    public boolean A09;
    public final C1376Hz A0C = new C1376Hz(4);
    public final C1376Hz A0B = new C1376Hz(9);
    public final C1376Hz A0E = new C1376Hz(11);
    public final C1376Hz A0D = new C1376Hz();
    public final C1759Xd A0A = new C1759Xd();
    public int A01 = 1;
    public long A04 = C.TIME_UNSET;

    static {
        A03();
        A0H = new C1761Xf();
        A0I = IF.A08(A01(0, 3, 61));
    }

    private C1376Hz A00(InterfaceC1234Bt interfaceC1234Bt) throws InterruptedException, IOException {
        if (this.A02 > this.A0D.A05()) {
            C1376Hz c1376Hz = this.A0D;
            c1376Hz.A0b(new byte[Math.max(c1376Hz.A05() * 2, this.A02)], 0);
        } else {
            this.A0D.A0Y(0);
        }
        this.A0D.A0X(this.A02);
        interfaceC1234Bt.readFully(this.A0D.A00, 0, this.A02);
        return this.A0D;
    }

    public static String A01(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0F, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 84);
        }
        return new String(bArrCopyOfRange);
    }

    private void A02() {
        long j11;
        if (!this.A09) {
            this.A06.AFi(new C1765Xj(C.TIME_UNSET));
            this.A09 = true;
        }
        if (this.A04 == C.TIME_UNSET) {
            if (this.A0A.A0D() == C.TIME_UNSET) {
                long j12 = this.A05;
                String[] strArr = A0G;
                if (strArr[5].charAt(20) != strArr[0].charAt(20)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0G;
                strArr2[7] = "L5UStG7DYoKpX710PXz3zQwSbfDogpGa";
                strArr2[6] = "NY6hXsIFzv8ItyXdU8z07IBZswL3MGXa";
                j11 = -j12;
            } else {
                j11 = 0;
            }
            this.A04 = j11;
        }
    }

    public static void A03() {
        A0F = new byte[]{-41, -35, -25};
    }

    private void A04(InterfaceC1234Bt interfaceC1234Bt) throws InterruptedException, IOException {
        interfaceC1234Bt.AGP(this.A00);
        this.A00 = 0;
        this.A01 = 3;
    }

    private boolean A05(InterfaceC1234Bt interfaceC1234Bt) throws InterruptedException, IOException {
        if (!interfaceC1234Bt.AEM(this.A0B.A00, 0, 9, true)) {
            return false;
        }
        this.A0B.A0Y(0);
        this.A0B.A0Z(4);
        int iA0E = this.A0B.A0E();
        boolean z11 = (iA0E & 4) != 0;
        boolean z12 = (iA0E & 1) != 0;
        if (z11 && this.A07 == null) {
            this.A07 = new C1762Xg(this.A06.AGi(8, 1));
        }
        if (z12 && this.A08 == null) {
            this.A08 = new C1757Xb(this.A06.AGi(9, 2));
        }
        this.A06.A5Y();
        this.A00 = (this.A0B.A08() - 9) + 4;
        this.A01 = 2;
        return true;
    }

    private boolean A06(InterfaceC1234Bt interfaceC1234Bt) throws InterruptedException, IOException {
        boolean z11 = true;
        int i11 = this.A03;
        if (i11 == 8 && this.A07 != null) {
            A02();
            C1762Xg c1762Xg = this.A07;
            C1376Hz c1376HzA00 = A00(interfaceC1234Bt);
            long j11 = this.A04;
            String[] strArr = A0G;
            if (strArr[2].charAt(9) == strArr[1].charAt(9)) {
                throw new RuntimeException();
            }
            A0G[4] = "14LyfFoDFqyov0bzU05kIxDiosYU9C09";
            c1762Xg.A00(c1376HzA00, j11 + this.A05);
        } else if (i11 == 9 && this.A08 != null) {
            A02();
            this.A08.A00(A00(interfaceC1234Bt), this.A04 + this.A05);
        } else if (i11 != 18 || this.A09) {
            interfaceC1234Bt.AGP(this.A02);
            z11 = false;
        } else {
            this.A0A.A00(A00(interfaceC1234Bt), this.A05);
            long jA0D = this.A0A.A0D();
            if (jA0D != C.TIME_UNSET) {
                this.A06.AFi(new C1765Xj(jA0D));
                this.A09 = true;
            }
        }
        this.A00 = 4;
        this.A01 = 2;
        return z11;
    }

    private boolean A07(InterfaceC1234Bt interfaceC1234Bt) throws InterruptedException, IOException {
        if (!interfaceC1234Bt.AEM(this.A0E.A00, 0, 11, true)) {
            return false;
        }
        this.A0E.A0Y(0);
        this.A03 = this.A0E.A0E();
        this.A02 = this.A0E.A0G();
        this.A05 = this.A0E.A0G();
        this.A05 = (((long) (this.A0E.A0E() << 24)) | this.A05) * 1000;
        this.A0E.A0Z(3);
        this.A01 = 4;
        return true;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1233Bs
    public final void A8o(InterfaceC1235Bu interfaceC1235Bu) {
        this.A06 = interfaceC1235Bu;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1233Bs
    public final int AEH(InterfaceC1234Bt interfaceC1234Bt, C1238Bz c1238Bz) throws InterruptedException, IOException {
        while (true) {
            switch (this.A01) {
                case 1:
                    if (!A05(interfaceC1234Bt)) {
                        return -1;
                    }
                    break;
                    break;
                case 2:
                    A04(interfaceC1234Bt);
                    break;
                case 3:
                    if (!A07(interfaceC1234Bt)) {
                        return -1;
                    }
                    break;
                    break;
                case 4:
                    if (A06(interfaceC1234Bt)) {
                        return 0;
                    }
                    break;
                default:
                    throw new IllegalStateException();
            }
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1233Bs
    public final void AFh(long j11, long j12) {
        this.A01 = 1;
        this.A04 = C.TIME_UNSET;
        this.A00 = 0;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1233Bs
    public final boolean AGR(InterfaceC1234Bt interfaceC1234Bt) throws InterruptedException, IOException {
        interfaceC1234Bt.ADv(this.A0C.A00, 0, 3);
        this.A0C.A0Y(0);
        if (this.A0C.A0G() != A0I) {
            return false;
        }
        interfaceC1234Bt.ADv(this.A0C.A00, 0, 2);
        this.A0C.A0Y(0);
        if ((this.A0C.A0I() & 250) != 0) {
            return false;
        }
        interfaceC1234Bt.ADv(this.A0C.A00, 0, 4);
        this.A0C.A0Y(0);
        int iA08 = this.A0C.A08();
        interfaceC1234Bt.AFM();
        interfaceC1234Bt.A3W(iA08);
        interfaceC1234Bt.ADv(this.A0C.A00, 0, 4);
        this.A0C.A0Y(0);
        return this.A0C.A08() == 0;
    }
}
