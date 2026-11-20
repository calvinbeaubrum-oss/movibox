package com.facebook.ads.redexgen.uinode;

import java.io.IOException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Co, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1252Co {
    public static String[] A0D = {"0vhu5jxS", "Yr1jkp10QbCUuCnawnVg6DyED3T", "sHPBJpa0rClOKB4ts4mek83zSMf", "023O0ZSY", "oXq1fAkWHKLdk2C1T6ZzlQ7WbkpG5dco", "r27coonoikndR5VwsgZJDPH1Xbh3nrzE", "wA4WoZs0OtPlvEvglX5psUeQApq37N8U", "1wN1LzZhcL4LE4gXrEEsM7fopE3lhqwu"};
    public int A00;
    public int A01;
    public long A02;
    public long A03;
    public long A04;
    public long A05;
    public InterfaceC1235Bu A06;
    public C4 A07;
    public InterfaceC1249Cl A08;
    public C1251Cn A09;
    public boolean A0A;
    public boolean A0B;
    public final C1247Cj A0C = new C1247Cj();

    private int A00(InterfaceC1234Bt interfaceC1234Bt) throws InterruptedException, IOException {
        boolean zA0A = true;
        while (zA0A) {
            if (!this.A0C.A05(interfaceC1234Bt)) {
                this.A01 = 3;
                return -1;
            }
            this.A03 = interfaceC1234Bt.A7i() - this.A04;
            zA0A = A0A(this.A0C.A02(), this.A04, this.A09);
            if (zA0A) {
                this.A04 = interfaceC1234Bt.A7i();
            }
        }
        this.A00 = this.A09.A00.A0C;
        if (!this.A0A) {
            this.A07.A5n(this.A09.A00);
            this.A0A = true;
        }
        if (this.A09.A01 != null) {
            this.A08 = this.A09.A01;
        } else if (interfaceC1234Bt.A7I() == -1) {
            this.A08 = new XD();
        } else {
            C1248Ck c1248CkA01 = this.A0C.A01();
            this.A08 = new XJ(this.A04, interfaceC1234Bt.A7I(), this, c1248CkA01.A01 + c1248CkA01.A00, c1248CkA01.A05);
        }
        this.A09 = null;
        this.A01 = 2;
        this.A0C.A04();
        return 0;
    }

    private int A01(InterfaceC1234Bt interfaceC1234Bt, C1238Bz c1238Bz) throws InterruptedException, IOException {
        long jAEI = this.A08.AEI(interfaceC1234Bt);
        if (jAEI >= 0) {
            c1238Bz.A00 = jAEI;
            return 1;
        }
        if (jAEI < -1) {
            A08(-(2 + jAEI));
        }
        if (!this.A0B) {
            this.A06.AFi(this.A08.A4m());
            this.A0B = true;
        }
        if (this.A03 <= 0 && !this.A0C.A05(interfaceC1234Bt)) {
            this.A01 = 3;
            return -1;
        }
        this.A03 = 0L;
        C1376Hz c1376HzA02 = this.A0C.A02();
        long jA07 = A07(c1376HzA02);
        if (jA07 >= 0) {
            long j11 = this.A02;
            if (j11 + jA07 >= this.A05) {
                long jA03 = A03(j11);
                this.A07.AFR(c1376HzA02, c1376HzA02.A07());
                this.A07.AFS(jA03, 1, c1376HzA02.A07(), 0, null);
                this.A05 = -1L;
            }
        }
        this.A02 += jA07;
        return 0;
    }

    public final int A02(InterfaceC1234Bt interfaceC1234Bt, C1238Bz c1238Bz) throws InterruptedException, IOException {
        switch (this.A01) {
            case 0:
                return A00(interfaceC1234Bt);
            case 1:
                interfaceC1234Bt.AGP((int) this.A04);
                this.A01 = 2;
                return 0;
            case 2:
                return A01(interfaceC1234Bt, c1238Bz);
            default:
                throw new IllegalStateException();
        }
    }

    public final long A03(long j11) {
        return (1000000 * j11) / ((long) this.A00);
    }

    public final long A04(long j11) {
        return (((long) this.A00) * j11) / 1000000;
    }

    public final void A05(long j11, long j12) {
        this.A0C.A03();
        if (j11 != 0) {
            if (this.A01 != 0) {
                this.A05 = this.A08.AGX(j12);
                this.A01 = 2;
                return;
            }
            return;
        }
        boolean z11 = !this.A0B;
        String[] strArr = A0D;
        if (strArr[6].charAt(24) == strArr[7].charAt(24)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0D;
        strArr2[4] = "k4zvnx9t3uHSh6LLctIVLoh0Ftprjk2l";
        strArr2[5] = "HhnKvAaHZTpmoBA85UMRj52n1m1tHG3b";
        A09(z11);
    }

    public final void A06(InterfaceC1235Bu interfaceC1235Bu, C4 c11) {
        this.A06 = interfaceC1235Bu;
        this.A07 = c11;
        A09(true);
    }

    public abstract long A07(C1376Hz c1376Hz);

    public void A08(long j11) {
        this.A02 = j11;
    }

    public void A09(boolean z11) {
        if (z11) {
            this.A09 = new C1251Cn();
            this.A04 = 0L;
            this.A01 = 0;
        } else {
            this.A01 = 1;
        }
        this.A05 = -1L;
        this.A02 = 0L;
    }

    public abstract boolean A0A(C1376Hz c1376Hz, long j11, C1251Cn c1251Cn) throws InterruptedException, IOException;
}
