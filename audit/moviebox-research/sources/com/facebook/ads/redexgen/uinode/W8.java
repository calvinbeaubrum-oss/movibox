package com.facebook.ads.redexgen.uinode;

import com.facebook.ads.internal.exoplayer2.thirdparty.source.TrackGroup;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class W8 implements InterfaceC1331Gf {
    public final float A00;
    public final float A01;
    public final int A02;
    public final int A03;
    public final int A04;
    public final long A05;
    public final InterfaceC1341Gp A06;
    public final InterfaceC1354Hd A07;

    public W8(InterfaceC1341Gp interfaceC1341Gp) {
        this(interfaceC1341Gp, 10000, 25000, 25000, 0.75f, 0.75f, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS, InterfaceC1354Hd.A00);
    }

    public W8(InterfaceC1341Gp interfaceC1341Gp, int i11, int i12, int i13, float f11, float f12, long j11, InterfaceC1354Hd interfaceC1354Hd) {
        this.A06 = interfaceC1341Gp;
        this.A03 = i11;
        this.A02 = i12;
        this.A04 = i13;
        this.A00 = f11;
        this.A01 = f12;
        this.A05 = j11;
        this.A07 = interfaceC1354Hd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1331Gf
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final C1230Bp A4o(TrackGroup trackGroup, int... iArr) {
        return new C1230Bp(trackGroup, iArr, this.A06, this.A03, this.A02, this.A04, this.A00, this.A01, this.A05, this.A07);
    }
}
