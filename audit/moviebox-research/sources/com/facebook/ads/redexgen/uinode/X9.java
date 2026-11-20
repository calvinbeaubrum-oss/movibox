package com.facebook.ads.redexgen.uinode;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.exoplayer2.thirdparty.Format;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class X9 implements InterfaceC1259Cy {
    public static String[] A0C = {"jvuSXyRxFwWN5M53JxqXTqjBlHPmO5yS", "Nx6fwt5mIYqSRgPxQoB61NXpIqViXreb", "NbRu72XFqCPxMxVeHFzrnyrjREaihhdr", "Z3KBXmMomO9rJfjLZz1JQz2Kw0Fx28Ab", "zLbRIBf4nYWkQfyOEtwQDAQMGMEl8", "zvpubyWaUoinARhzufpjCqD1DbWF7ekR", "kxIGpaDKqbCPDUN5La7nQCmFVSx", "CqFgkkKKOYx1Bj1EdbgCjsaN4ksOOdQn"};
    public int A00;
    public int A01;
    public int A02;
    public long A03;
    public long A04;
    public Format A05;
    public C4 A06;
    public String A07;
    public boolean A08;
    public final C1375Hy A09;
    public final C1376Hz A0A;
    public final String A0B;

    public X9() {
        this(null);
    }

    public X9(String str) {
        C1375Hy c1375Hy = new C1375Hy(new byte[128]);
        this.A09 = c1375Hy;
        this.A0A = new C1376Hz(c1375Hy.A00);
        this.A02 = 0;
        this.A0B = str;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0047  */
    private void A00() {
        this.A09.A07(0);
        AP apA09 = AQ.A09(this.A09);
        if (this.A05 == null || apA09.A00 != this.A05.A05) {
            Format formatA07 = Format.A07(this.A07, apA09.A05, null, -1, -1, apA09.A00, apA09.A03, null, null, 0, this.A0B);
            this.A05 = formatA07;
            this.A06.A5n(formatA07);
        } else {
            int i11 = apA09.A03;
            int i12 = this.A05.A0C;
            if (A0C[6].length() != 27) {
                throw new RuntimeException();
            }
            String[] strArr = A0C;
            strArr[2] = "rmTuGOWOeoxLIH1QLptnusvxizN1V0jV";
            strArr[5] = "2RMufqWRuZFq3WutxyrHt00cbPeHqbYj";
            if (i11 != i12 || apA09.A05 != this.A05.A0O) {
                Format formatA08 = Format.A07(this.A07, apA09.A05, null, -1, -1, apA09.A00, apA09.A03, null, null, 0, this.A0B);
                this.A05 = formatA08;
                this.A06.A5n(formatA08);
            }
        }
        this.A01 = apA09.A01;
        this.A03 = (((long) apA09.A02) * 1000000) / ((long) this.A05.A0C);
    }

    private boolean A01(C1376Hz c1376Hz) {
        while (true) {
            if (c1376Hz.A04() <= 0) {
                return false;
            }
            if (this.A08) {
                int iA0E = c1376Hz.A0E();
                if (iA0E == 119) {
                    this.A08 = false;
                    return true;
                }
                this.A08 = iA0E == 11;
            } else {
                this.A08 = c1376Hz.A0E() == 11;
            }
        }
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
        while (true) {
            int iA04 = c1376Hz.A04();
            if (A0C[3].charAt(28) != '2') {
                throw new RuntimeException();
            }
            A0C[6] = "j4ZJ9Sb1FxDogpbJuhr4W7MrwTg";
            if (iA04 > 0) {
                switch (this.A02) {
                    case 0:
                        if (A01(c1376Hz)) {
                            this.A02 = 1;
                            this.A0A.A00[0] = Ascii.VT;
                            byte[] bArr = this.A0A.A00;
                            String[] strArr = A0C;
                            if (strArr[0].charAt(28) == strArr[7].charAt(28)) {
                                A0C[4] = "thGmrgzi8Rkjtt3yqKW2WPJBde0Fj";
                                bArr[1] = 119;
                                this.A00 = 2;
                            } else {
                                bArr[1] = 119;
                                this.A00 = 2;
                            }
                        }
                        break;
                    case 1:
                        if (A02(c1376Hz, this.A0A.A00, 128)) {
                            A00();
                            this.A0A.A0Y(0);
                            this.A06.AFR(this.A0A, 128);
                            this.A02 = 2;
                        }
                        break;
                    case 2:
                        int iMin = Math.min(c1376Hz.A04(), this.A01 - this.A00);
                        this.A06.AFR(c1376Hz, iMin);
                        int i11 = this.A00 + iMin;
                        this.A00 = i11;
                        int i12 = this.A01;
                        if (i11 == i12) {
                            this.A06.AFS(this.A04, 1, i12, 0, null);
                            this.A04 += this.A03;
                            this.A02 = 0;
                        }
                        break;
                }
            } else {
                return;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1259Cy
    public final void A4p(InterfaceC1235Bu interfaceC1235Bu, DC dc2) {
        dc2.A05();
        this.A07 = dc2.A04();
        this.A06 = interfaceC1235Bu.AGi(dc2.A03(), 1);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1259Cy
    public final void ADs() {
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1259Cy
    public final void ADt(long j11, boolean z11) {
        this.A04 = j11;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1259Cy
    public final void AFg() {
        this.A02 = 0;
        this.A00 = 0;
        this.A08 = false;
    }
}
