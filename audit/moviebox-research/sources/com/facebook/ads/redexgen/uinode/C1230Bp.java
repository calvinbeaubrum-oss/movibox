package com.facebook.ads.redexgen.uinode;

import com.facebook.ads.internal.exoplayer2.thirdparty.source.TrackGroup;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Bp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1230Bp extends W7 {
    public float A00;
    public int A01;
    public int A02;
    public long A03;
    public final float A04;
    public final float A05;
    public final long A06;
    public final long A07;
    public final long A08;
    public final long A09;
    public final InterfaceC1341Gp A0A;
    public final InterfaceC1354Hd A0B;

    public C1230Bp(TrackGroup trackGroup, int[] iArr, InterfaceC1341Gp interfaceC1341Gp, long j11, long j12, long j13, float f11, float f12, long j14, InterfaceC1354Hd interfaceC1354Hd) {
        super(trackGroup, iArr);
        this.A0A = interfaceC1341Gp;
        this.A07 = j11 * 1000;
        this.A06 = j12 * 1000;
        this.A08 = 1000 * j13;
        this.A04 = f11;
        this.A05 = f12;
        this.A09 = j14;
        this.A0B = interfaceC1354Hd;
        this.A00 = 1.0f;
        this.A01 = 1;
        this.A03 = C.TIME_UNSET;
        this.A02 = A00(Long.MIN_VALUE);
    }

    private int A00(long j11) {
        long jA67 = (long) (this.A0A.A67() * this.A04);
        int i11 = 0;
        for (int i12 = 0; i12 < super.A03; i12++) {
            if (j11 == Long.MIN_VALUE || !A00(i12, j11)) {
                if (Math.round(A76(i12).A04 * this.A00) <= jA67) {
                    return i12;
                }
                i11 = i12;
            }
        }
        return i11;
    }

    @Override // com.facebook.ads.redexgen.uinode.W7, com.facebook.ads.redexgen.uinode.InterfaceC1332Gg
    public final void A5U() {
        this.A03 = C.TIME_UNSET;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1332Gg
    public final int A7v() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.uinode.W7, com.facebook.ads.redexgen.uinode.InterfaceC1332Gg
    public final void ACc(float f11) {
        this.A00 = f11;
    }
}
