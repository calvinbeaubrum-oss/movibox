package com.facebook.ads.redexgen.uinode;

import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import java.io.IOException;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class WV implements FB {
    public static String[] A03 = {"2iJQWlRsUDoPLtxxhE0wL9Cx9C7nOBrU", "oJgjoNY6hjjHJmelHDlI5xZuIY2b67h", "lPiJTezOZt4yDoox6bX3l7R6F2XzCVNN", "wrWzKGBonHGMzL1uPVOM3eUURFaMzKwB", "aBcbXNoo2m3wtFqQFSiOk3RFoevM7GVG", "GcCP7ZOQcwM7LeXwSBQclRy3S6aYmmD", "JUPsbTU3PQNYOt9vjPoPUzbQPtEFF22Q", "21kt6KXNgOdDUktVBInrV9GyhB6eLfYq"};
    public boolean A00;
    public final FB A01;
    public final /* synthetic */ CI A02;

    public WV(CI ci2, FB fb2) {
        this.A02 = ci2;
        this.A01 = fb2;
    }

    public final void A00() {
        this.A00 = false;
    }

    @Override // com.facebook.ads.redexgen.uinode.FB
    public final boolean A9C() {
        return !this.A02.A03() && this.A01.A9C();
    }

    @Override // com.facebook.ads.redexgen.uinode.FB
    public final void AAM() throws IOException {
        this.A01.AAM();
    }

    @Override // com.facebook.ads.redexgen.uinode.FB
    public final int AEK(C11789p c11789p, C1773Xr c1773Xr, boolean z11) {
        if (this.A02.A03()) {
            return -3;
        }
        if (this.A00) {
            c1773Xr.A02(4);
            return -4;
        }
        int iAEK = this.A01.AEK(c11789p, c1773Xr, z11);
        if (iAEK == -5) {
            Format format = c11789p.A00;
            if (format.A06 != 0 || format.A07 != 0) {
                c11789p.A00 = format.A0G(this.A02.A01 != 0 ? 0 : format.A06, this.A02.A00 == Long.MIN_VALUE ? format.A07 : 0);
            }
            return -5;
        }
        if (this.A02.A00 == Long.MIN_VALUE || ((iAEK != -4 || c1773Xr.A00 < this.A02.A00) && !(iAEK == -3 && this.A02.A6D() == Long.MIN_VALUE))) {
            return iAEK;
        }
        c1773Xr.A07();
        c1773Xr.A02(4);
        this.A00 = true;
        return -4;
    }

    @Override // com.facebook.ads.redexgen.uinode.FB
    public final int AGO(long j11) {
        if (!this.A02.A03()) {
            return this.A01.AGO(j11);
        }
        if (A03[7].charAt(6) == 'T') {
            throw new RuntimeException();
        }
        A03[0] = "I7Vle9theSHJs2vfg5SYnPGKFT8j8RVM";
        return -3;
    }
}
