package com.facebook.ads.redexgen.uinode;

import com.facebook.ads.internal.exoplayer2.thirdparty.Format;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Wx, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1753Wx implements InterfaceC1259Cy {
    public static String[] A0C = {"M8nxhoQeDkjHEk3tjnypaUsJeky9pUPe", "22wDV1USJ2tZABUEWkFG7fElxPqoDepQ", "WSXmuBny7XXEQ4s813c9BSbsqOjqSskJ", "KVrLQEQFGtTXAXMopyF5dj", "jUO9kFQXOuNF5MkzWpfFf35Wzr3tp3jj", "UgJN", "fATsZHYNQKGGAXuN", "X77CUtb4yEwh8nH4MH"};
    public int A00;
    public int A01;
    public int A02;
    public long A03;
    public long A04;
    public C4 A05;
    public String A06;
    public boolean A07;
    public boolean A08;
    public final By A09;
    public final C1376Hz A0A;
    public final String A0B;

    public C1753Wx() {
        this(null);
    }

    public C1753Wx(String str) {
        this.A02 = 0;
        C1376Hz c1376Hz = new C1376Hz(4);
        this.A0A = c1376Hz;
        c1376Hz.A00[0] = -1;
        this.A09 = new By();
        this.A0B = str;
    }

    private void A00(C1376Hz c1376Hz) {
        byte[] bArr = c1376Hz.A00;
        int iA07 = c1376Hz.A07();
        for (int iA06 = c1376Hz.A06(); iA06 < iA07; iA06++) {
            boolean z11 = (bArr[iA06] & 255) == 255;
            boolean z12 = this.A08 && (bArr[iA06] & 224) == 224;
            this.A08 = z11;
            if (z12) {
                c1376Hz.A0Y(iA06 + 1);
                this.A08 = false;
                this.A0A.A00[1] = bArr[iA06];
                this.A00 = 2;
                this.A02 = 1;
                return;
            }
        }
        c1376Hz.A0Y(iA07);
    }

    private void A01(C1376Hz c1376Hz) {
        int iMin = Math.min(c1376Hz.A04(), this.A01 - this.A00);
        this.A05.AFR(c1376Hz, iMin);
        int i11 = this.A00 + iMin;
        this.A00 = i11;
        int i12 = this.A01;
        if (i11 < i12) {
            return;
        }
        C4 c11 = this.A05;
        if (A0C[2].charAt(7) == 'H') {
            throw new RuntimeException();
        }
        String[] strArr = A0C;
        strArr[4] = "Ix3a1KSHqy7cK1t6WtGmlZzK6PY1tVDv";
        strArr[1] = "TW6fubs4zpuEa3cAWqrpZRXJHWdUZhrV";
        c11.AFS(this.A04, 1, i12, 0, null);
        this.A04 += this.A03;
        this.A00 = 0;
        this.A02 = 0;
    }

    private void A02(C1376Hz c1376Hz) {
        int iMin = Math.min(c1376Hz.A04(), 4 - this.A00);
        c1376Hz.A0c(this.A0A.A00, this.A00, iMin);
        int i11 = this.A00 + iMin;
        this.A00 = i11;
        if (i11 < 4) {
            return;
        }
        this.A0A.A0Y(0);
        if (!By.A04(this.A0A.A08(), this.A09)) {
            this.A00 = 0;
            this.A02 = 1;
            return;
        }
        this.A01 = this.A09.A02;
        if (!this.A07) {
            this.A03 = (((long) this.A09.A04) * 1000000) / ((long) this.A09.A03);
            this.A05.A5n(Format.A07(this.A06, this.A09.A06, null, -1, 4096, this.A09.A01, this.A09.A03, null, null, 0, this.A0B));
            this.A07 = true;
        }
        this.A0A.A0Y(0);
        this.A05.AFR(this.A0A, 4);
        this.A02 = 2;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1259Cy
    public final void A4R(C1376Hz c1376Hz) {
        while (c1376Hz.A04() > 0) {
            switch (this.A02) {
                case 0:
                    A00(c1376Hz);
                    break;
                case 1:
                    A02(c1376Hz);
                    break;
                case 2:
                    A01(c1376Hz);
                    break;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1259Cy
    public final void A4p(InterfaceC1235Bu interfaceC1235Bu, DC dc2) {
        dc2.A05();
        this.A06 = dc2.A04();
        this.A05 = interfaceC1235Bu.AGi(dc2.A03(), 1);
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
