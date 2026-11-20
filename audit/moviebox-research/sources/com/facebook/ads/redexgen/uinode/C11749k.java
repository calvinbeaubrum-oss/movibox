package com.facebook.ads.redexgen.uinode;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9k, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C11749k {
    public int A00;
    public int A01;
    public C11859w A02;
    public boolean A03;

    public C11749k() {
    }

    public final void A03(int i11) {
        this.A01 += i11;
    }

    public final void A04(int i11) {
        if (this.A03 && this.A00 != 4) {
            AbstractC1351Ha.A03(i11 == 4);
        } else {
            this.A03 = true;
            this.A00 = i11;
        }
    }

    public final void A05(C11859w c11859w) {
        this.A02 = c11859w;
        this.A01 = 0;
        this.A03 = false;
    }

    public final boolean A06(C11859w c11859w) {
        return c11859w != this.A02 || this.A01 > 0 || this.A03;
    }
}
