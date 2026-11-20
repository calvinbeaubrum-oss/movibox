package com.facebook.ads.redexgen.uinode;

import com.facebook.ads.VideoStartReason;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class EU extends AbstractC1572Pu {
    public final /* synthetic */ C10795h A00;

    public EU(C10795h c10795h) {
        this.A00 = c10795h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.uinode.AbstractC11578s
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final void A03(C9H c9h) {
        this.A00.A00.onCompleted();
        if (C1384Ih.A1H(this.A00.A00.getContext())) {
            this.A00.A00.play(VideoStartReason.AUTO_STARTED);
        }
    }
}
