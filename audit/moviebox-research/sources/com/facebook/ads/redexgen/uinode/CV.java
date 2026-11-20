package com.facebook.ads.redexgen.uinode;

import com.facebook.ads.internal.exoplayer2.thirdparty.drm.DrmInitData;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class CV {
    public static String[] A0A = {"VV6EzFzDFGyxh7278LhkWh1nAnO", "a", "RIeoUtwh2k0Lp", "KiUc8yTTjWF6Y9v", "6tIA8m5WM2YSgVpCAFtgKZOFEkm", "A00z45", "ej2X1eDppCFfwh6aI5B812e88v7VHLnd", "obdd9bh"};
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public CP A04;
    public C1242Ce A05;
    public final C4 A06;
    public final C1244Cg A07 = new C1244Cg();
    public final C1376Hz A09 = new C1376Hz(1);
    public final C1376Hz A08 = new C1376Hz();

    public CV(C4 c11) {
        this.A06 = c11;
    }

    private C1243Cf A00() {
        int i11 = this.A07.A07.A02;
        if (this.A07.A08 == null) {
            return this.A05.A00(i11);
        }
        C1244Cg c1244Cg = this.A07;
        if (A0A[2].length() == 16) {
            throw new RuntimeException();
        }
        A0A[2] = "yH";
        return c1244Cg.A08;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A01() {
        if (this.A07.A0A) {
            C1376Hz c1376Hz = this.A07.A09;
            C1243Cf c1243CfA00 = A00();
            if (c1243CfA00.A00 != 0) {
                c1376Hz.A0Z(c1243CfA00.A00);
            }
            if (this.A07.A0H[this.A01]) {
                c1376Hz.A0Z(c1376Hz.A0I() * 6);
            }
        }
    }

    public final int A03() {
        C1376Hz c1376Hz;
        int length;
        if (!this.A07.A0A) {
            return 0;
        }
        C1243Cf c1243CfA00 = A00();
        if (A0A[5].length() != 6) {
            throw new RuntimeException();
        }
        A0A[1] = "c";
        if (c1243CfA00.A00 != 0) {
            c1376Hz = this.A07.A09;
            length = c1243CfA00.A00;
        } else {
            byte[] bArr = c1243CfA00.A04;
            this.A08.A0b(bArr, bArr.length);
            c1376Hz = this.A08;
            length = bArr.length;
        }
        boolean z11 = this.A07.A0H[this.A01];
        this.A09.A00[0] = (byte) ((z11 ? 128 : 0) | length);
        this.A09.A0Y(0);
        this.A06.AFR(this.A09, 1);
        this.A06.AFR(c1376Hz, length);
        if (!z11) {
            return length + 1;
        }
        C1376Hz c1376Hz2 = this.A07.A09;
        int iA0I = c1376Hz2.A0I();
        c1376Hz2.A0Z(-2);
        int i11 = (iA0I * 6) + 2;
        this.A06.AFR(c1376Hz2, i11);
        return length + 1 + i11;
    }

    public final void A04() {
        this.A07.A01();
        this.A01 = 0;
        this.A02 = 0;
        this.A00 = 0;
        this.A03 = 0;
    }

    public final void A05(long j11) {
        long jA01 = C9W.A01(j11);
        for (int i11 = this.A01; i11 < this.A07.A00 && this.A07.A00(i11) < jA01; i11++) {
            if (this.A07.A0I[i11]) {
                this.A03 = i11;
            }
        }
    }

    public final void A06(DrmInitData drmInitData) {
        C1243Cf c1243CfA00 = this.A05.A00(this.A07.A07.A02);
        this.A06.A5n(this.A05.A07.A0I(drmInitData.A02(c1243CfA00 != null ? c1243CfA00.A02 : null)));
    }

    public final void A07(C1242Ce c1242Ce, CP cp2) {
        this.A05 = (C1242Ce) AbstractC1351Ha.A01(c1242Ce);
        this.A04 = (CP) AbstractC1351Ha.A01(cp2);
        this.A06.A5n(c1242Ce.A07);
        A04();
    }

    public final boolean A08() {
        this.A01++;
        int i11 = this.A00 + 1;
        this.A00 = i11;
        int[] iArr = this.A07.A0E;
        int i12 = this.A02;
        if (i11 != iArr[i12]) {
            return true;
        }
        this.A02 = i12 + 1;
        this.A00 = 0;
        return false;
    }
}
