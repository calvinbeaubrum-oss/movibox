package com.facebook.ads.redexgen.uinode;

import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class WN extends AH {
    public static final Object A09 = new Object();
    public final long A00;
    public final long A01;
    public final long A02;
    public final long A03;
    public final long A04;
    public final long A05;
    public final Object A06;
    public final boolean A07;
    public final boolean A08;

    public WN(long j11, long j12, long j13, long j14, long j15, long j16, boolean z11, boolean z12, Object obj) {
        this.A01 = j11;
        this.A05 = j12;
        this.A00 = j13;
        this.A03 = j14;
        this.A04 = j15;
        this.A02 = j16;
        this.A08 = z11;
        this.A07 = z12;
        this.A06 = obj;
    }

    public WN(long j11, long j12, long j13, long j14, boolean z11, boolean z12, Object obj) {
        this(C.TIME_UNSET, C.TIME_UNSET, j11, j12, j13, j14, z11, z12, obj);
    }

    public WN(long j11, boolean z11, boolean z12, Object obj) {
        this(j11, j11, 0L, 0L, z11, z12, obj);
    }

    @Override // com.facebook.ads.redexgen.uinode.AH
    public final int A00() {
        return 1;
    }

    @Override // com.facebook.ads.redexgen.uinode.AH
    public final int A01() {
        return 1;
    }

    @Override // com.facebook.ads.redexgen.uinode.AH
    public final int A04(Object obj) {
        return A09.equals(obj) ? 0 : -1;
    }

    @Override // com.facebook.ads.redexgen.uinode.AH
    public final AF A0A(int i11, AF af2, boolean z11) {
        AbstractC1351Ha.A00(i11, 0, 1);
        return af2.A0B(null, z11 ? A09 : null, 0, this.A00, -this.A04);
    }

    @Override // com.facebook.ads.redexgen.uinode.AH
    public final AG A0D(int i11, AG ag2, boolean z11, long j11) {
        AbstractC1351Ha.A00(i11, 0, 1);
        Object obj = z11 ? this.A06 : null;
        long j12 = this.A02;
        boolean z12 = this.A07;
        if (z12 && j11 != 0) {
            long j13 = this.A03;
            if (j13 == C.TIME_UNSET) {
                j12 = C.TIME_UNSET;
            } else {
                j12 += j11;
                if (j12 > j13) {
                    j12 = C.TIME_UNSET;
                }
            }
        }
        return ag2.A04(obj, this.A01, this.A05, this.A08, z12, j12, this.A03, 0, 0, this.A04);
    }
}
