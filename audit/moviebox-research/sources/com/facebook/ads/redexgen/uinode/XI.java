package com.facebook.ads.redexgen.uinode;

import java.io.IOException;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class XI implements InterfaceC1249Cl, C1 {
    public static String[] A05 = {"RxrevBHwZunvWtoC5v6V", "BM7NoIYIDKALVkWYBFUm4mgKfD4surZT", "wT545zonAETVeqcNIpSLQKDSBA4psZtT", "O6YerNOVuBIV8g4cn8DH", "f7xxxnJira03VIlY2bxNtwSQeXyrwxct", "8kRv9b0m26r6Uh6XKMOB9WasCMU5o07v", "0W8GSaK37PxtOyOV4bIEUVoiYe2UqjRN", "TYUMHNguvpgJeUJ5Wme9D9z4"};
    public long A00 = -1;
    public long A01 = -1;
    public long[] A02;
    public long[] A03;
    public final /* synthetic */ XH A04;

    public XI(XH xh2) {
        this.A04 = xh2;
    }

    public final void A00(long j11) {
        this.A00 = j11;
    }

    public final void A01(C1376Hz c1376Hz) {
        c1376Hz.A0Z(1);
        int iA0G = c1376Hz.A0G() / 18;
        this.A02 = new long[iA0G];
        this.A03 = new long[iA0G];
        for (int i11 = 0; i11 < iA0G; i11++) {
            this.A02[i11] = c1376Hz.A0L();
            this.A03[i11] = c1376Hz.A0L();
            c1376Hz.A0Z(2);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1249Cl
    public final C1 A4m() {
        return this;
    }

    @Override // com.facebook.ads.redexgen.uinode.C1
    public final long A6r() {
        return this.A04.A01.A01();
    }

    @Override // com.facebook.ads.redexgen.uinode.C1
    public final C0 A7t(long j11) {
        int iA0B = IF.A0B(this.A02, this.A04.A04(j11), true, true);
        long jA03 = this.A04.A03(this.A02[iA0B]);
        C2 c11 = new C2(jA03, this.A00 + this.A03[iA0B]);
        if (jA03 < j11) {
            long[] jArr = this.A02;
            if (iA0B != jArr.length - 1) {
                return new C0(c11, new C2(this.A04.A03(jArr[iA0B + 1]), this.A00 + this.A03[iA0B + 1]));
            }
        }
        return new C0(c11);
    }

    @Override // com.facebook.ads.redexgen.uinode.C1
    public final boolean A9I() {
        return true;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1249Cl
    public final long AEI(InterfaceC1234Bt interfaceC1234Bt) throws InterruptedException, IOException {
        long j11 = this.A01;
        if (j11 < 0) {
            return -1L;
        }
        long j12 = -(j11 + 2);
        this.A01 = -1L;
        if (A05[5].charAt(9) != '6') {
            throw new RuntimeException();
        }
        String[] strArr = A05;
        strArr[0] = "MeEp95NFLxRX8bxkfA2m";
        strArr[3] = "RwTpOb1Sie1PnKrI5U9E";
        return j12;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1249Cl
    public final long AGX(long j11) {
        long jA04 = this.A04.A04(j11);
        this.A01 = this.A02[IF.A0B(this.A02, jA04, true, true)];
        return jA04;
    }
}
