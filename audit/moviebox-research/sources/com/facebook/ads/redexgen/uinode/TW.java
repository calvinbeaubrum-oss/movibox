package com.facebook.ads.redexgen.uinode;

import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class TW extends KT {
    public final /* synthetic */ TT A00;

    public TW(TT tt2) {
        this.A00 = tt2;
    }

    @Override // com.facebook.ads.redexgen.uinode.KT
    public final void A06() {
        if (!this.A00.A0Z) {
            AbstractC1462Lo.A0F(1000, this.A00.A0M);
        }
        this.A00.postDelayed(this, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
    }
}
