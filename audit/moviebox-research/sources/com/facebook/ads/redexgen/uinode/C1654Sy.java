package com.facebook.ads.redexgen.uinode;

import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Sy, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1654Sy extends KT {
    public final /* synthetic */ C1653Sx A00;

    public C1654Sy(C1653Sx c1653Sx) {
        this.A00 = c1653Sx;
    }

    @Override // com.facebook.ads.redexgen.uinode.KT
    public final void A06() {
        AbstractC1462Lo.A0F(1000, this.A00.A0H);
        this.A00.postDelayed(this, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
    }
}
