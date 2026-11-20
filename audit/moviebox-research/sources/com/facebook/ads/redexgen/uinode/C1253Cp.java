package com.facebook.ads.redexgen.uinode;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Cp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1253Cp {
    public static String[] A04 = {"1Xip6MK3UX39SbdrhQxDlLsVDK2jyOlR", "AU2BHKQnn2fYqPG5g1tvrnNHtccLtsvW", "5fujN1flEc5Me9dyDOpwJW6OKLh1geLG", "d2hyRAFooTRyki1bdAaACMGjhokH1kbm", "1id0n4LmWumjAHQEVAwGAQFe8ZjykTcE", "nyz5FVBYTM1P8JU78hecVl8rttPnaVCa", "YJ", "Rq"};
    public int A00;
    public int A01;
    public final int A02;
    public final byte[] A03;

    public C1253Cp(byte[] bArr) {
        this.A03 = bArr;
        this.A02 = bArr.length;
    }

    private void A00() {
        int i11;
        int i12 = this.A01;
        AbstractC1351Ha.A04(i12 >= 0 && (i12 < (i11 = this.A02) || (i12 == i11 && this.A00 == 0)));
    }

    public final int A01() {
        return (this.A01 * 8) + this.A00;
    }

    public final int A02(int i11) {
        int i12 = this.A01;
        int iMin = Math.min(i11, 8 - this.A00);
        int i13 = i12 + 1;
        int i14 = ((this.A03[i12] & 255) >> this.A00) & (255 >> (8 - iMin));
        while (iMin < i11) {
            i14 |= (this.A03[i13] & 255) << iMin;
            iMin += 8;
            i13++;
        }
        int i15 = i14 & ((-1) >>> (32 - i11));
        A03(i11);
        return i15;
    }

    public final void A03(int i11) {
        int i12 = i11 / 8;
        int i13 = this.A01 + i12;
        this.A01 = i13;
        int i14 = this.A00 + (i11 - (i12 * 8));
        this.A00 = i14;
        if (i14 > 7) {
            this.A01 = i13 + 1;
            this.A00 = i14 - 8;
        }
        A00();
        String[] strArr = A04;
        if (strArr[6].length() != strArr[7].length()) {
            throw new RuntimeException();
        }
        A04[2] = "0KTU32mldvOu3DR9Ufqh7FWixRDNtvi7";
    }

    public final boolean A04() {
        boolean z11 = (((this.A03[this.A01] & 255) >> this.A00) & 1) == 1;
        A03(1);
        return z11;
    }
}
