package com.facebook.ads.redexgen.uinode;

import com.facebook.ads.internal.exoplayer2.thirdparty.Format;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class X4 implements InterfaceC1259Cy {
    public int A00;
    public int A01;
    public int A03;
    public long A04;
    public long A05;
    public Format A06;
    public C4 A07;
    public String A08;
    public final String A0A;
    public final C1376Hz A09 = new C1376Hz(new byte[18]);
    public int A02 = 0;

    public X4(String str) {
        this.A0A = str;
    }

    private void A00() {
        byte[] bArr = this.A09.A00;
        if (this.A06 == null) {
            Format formatA03 = B1.A03(bArr, this.A08, this.A0A, null);
            this.A06 = formatA03;
            this.A07.A5n(formatA03);
        }
        this.A01 = B1.A01(bArr);
        this.A04 = (int) ((((long) B1.A02(bArr)) * 1000000) / ((long) this.A06.A0C));
    }

    private boolean A01(C1376Hz c1376Hz) {
        while (c1376Hz.A04() > 0) {
            int i11 = this.A03 << 8;
            this.A03 = i11;
            int iA0E = i11 | c1376Hz.A0E();
            this.A03 = iA0E;
            if (B1.A07(iA0E)) {
                this.A09.A00[0] = (byte) ((this.A03 >> 24) & 255);
                this.A09.A00[1] = (byte) ((this.A03 >> 16) & 255);
                this.A09.A00[2] = (byte) ((this.A03 >> 8) & 255);
                this.A09.A00[3] = (byte) (this.A03 & 255);
                this.A00 = 4;
                this.A03 = 0;
                return true;
            }
        }
        return false;
    }

    private boolean A02(C1376Hz c1376Hz, byte[] bArr, int i11) {
        int iMin = Math.min(c1376Hz.A04(), i11 - this.A00);
        c1376Hz.A0c(bArr, this.A00, iMin);
        int i12 = this.A00 + iMin;
        this.A00 = i12;
        return i12 == i11;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1259Cy
    public final void A4R(C1376Hz c1376Hz) {
        while (c1376Hz.A04() > 0) {
            switch (this.A02) {
                case 0:
                    if (A01(c1376Hz)) {
                        this.A02 = 1;
                    }
                    break;
                case 1:
                    if (A02(c1376Hz, this.A09.A00, 18)) {
                        A00();
                        this.A09.A0Y(0);
                        this.A07.AFR(this.A09, 18);
                        this.A02 = 2;
                    }
                    break;
                case 2:
                    int iMin = Math.min(c1376Hz.A04(), this.A01 - this.A00);
                    this.A07.AFR(c1376Hz, iMin);
                    int i11 = this.A00 + iMin;
                    this.A00 = i11;
                    int i12 = this.A01;
                    if (i11 == i12) {
                        this.A07.AFS(this.A05, 1, i12, 0, null);
                        this.A05 += this.A04;
                        this.A02 = 0;
                    }
                    break;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1259Cy
    public final void A4p(InterfaceC1235Bu interfaceC1235Bu, DC dc2) {
        dc2.A05();
        this.A08 = dc2.A04();
        this.A07 = interfaceC1235Bu.AGi(dc2.A03(), 1);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1259Cy
    public final void ADs() {
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1259Cy
    public final void ADt(long j11, boolean z11) {
        this.A05 = j11;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1259Cy
    public final void AFg() {
        this.A02 = 0;
        this.A00 = 0;
        this.A03 = 0;
    }
}
