package com.facebook.ads.redexgen.uinode;

import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class EE implements XV {
    public final int A00;
    public final int A01;
    public final long A02;
    public final long A03;
    public final long A04;

    public EE(long j11, long j12, By by) {
        this.A04 = j12;
        this.A01 = by.A02;
        this.A00 = by.A00;
        if (j11 == -1) {
            this.A02 = -1L;
            this.A03 = C.TIME_UNSET;
        } else {
            this.A02 = j11 - j12;
            this.A03 = A88(j11);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.C1
    public final long A6r() {
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.uinode.C1
    public final C0 A7t(long j11) {
        long j12 = this.A02;
        if (j12 == -1) {
            return new C0(new C2(0L, this.A04));
        }
        long j13 = (((long) this.A00) * j11) / 8000000;
        int i11 = this.A01;
        long jA0E = IF.A0E((j13 / ((long) i11)) * ((long) i11), 0L, j12 - ((long) i11));
        long j14 = this.A04 + jA0E;
        long jA88 = A88(j14);
        C2 c11 = new C2(jA88, j14);
        if (jA88 < j11) {
            long j15 = this.A02;
            int i12 = this.A01;
            if (jA0E != j15 - ((long) i12)) {
                long j16 = ((long) i12) + j14;
                return new C0(c11, new C2(A88(j16), j16));
            }
        }
        return new C0(c11);
    }

    @Override // com.facebook.ads.redexgen.uinode.XV
    public final long A88(long j11) {
        return ((Math.max(0L, j11 - this.A04) * 1000000) * 8) / ((long) this.A00);
    }

    @Override // com.facebook.ads.redexgen.uinode.C1
    public final boolean A9I() {
        return this.A02 != -1;
    }
}
