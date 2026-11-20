package com.facebook.ads.redexgen.uinode;

import java.io.IOException;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class CF {
    public int A00;
    public int A01;
    public int A02;
    public long A03;
    public boolean A04;
    public final byte[] A05 = new byte[10];

    public final void A00() {
        this.A04 = false;
    }

    public final void A01(InterfaceC1234Bt interfaceC1234Bt, int i11, int i12) throws InterruptedException, IOException {
        if (!this.A04) {
            interfaceC1234Bt.ADv(this.A05, 0, 10);
            interfaceC1234Bt.AFM();
            if (AQ.A06(this.A05) == -1) {
                return;
            }
            this.A04 = true;
            this.A02 = 0;
        }
        if (this.A02 == 0) {
            this.A00 = i11;
            this.A01 = 0;
        }
        this.A01 += i12;
    }

    public final void A02(CE ce2) {
        if (!this.A04 || this.A02 <= 0) {
            return;
        }
        ce2.A0W.AFS(this.A03, this.A00, this.A01, 0, ce2.A0V);
        this.A02 = 0;
    }

    public final void A03(CE ce2, long j11) {
        if (this.A04) {
            int i11 = this.A02;
            int i12 = i11 + 1;
            this.A02 = i12;
            if (i11 == 0) {
                this.A03 = j11;
            }
            if (i12 < 16) {
                return;
            }
            ce2.A0W.AFS(this.A03, this.A00, this.A01, 0, ce2.A0V);
            this.A02 = 0;
        }
    }
}
