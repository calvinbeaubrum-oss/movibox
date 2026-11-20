package com.facebook.ads.redexgen.uinode;

import com.facebook.ads.internal.protocol.AdErrorType;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.al, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1878al extends KT {
    public final /* synthetic */ C1915bM A00;
    public final /* synthetic */ C09911v A01;
    public final /* synthetic */ FQ A02;

    public C1878al(FQ fq2, C09911v c09911v, C1915bM c1915bM) {
        this.A02 = fq2;
        this.A01 = c09911v;
        this.A00 = c1915bM;
    }

    @Override // com.facebook.ads.redexgen.uinode.KT
    public final void A06() {
        this.A02.A0Q(this.A01);
        this.A02.A0N(this.A00);
        this.A02.A00 = null;
        C1401Jb c1401JbA00 = C1401Jb.A00(AdErrorType.INTERSTITIAL_AD_TIMEOUT);
        this.A02.A0B.A0E().A4t(c1401JbA00.A03().getErrorCode(), c1401JbA00.A04());
        this.A02.A06.A0G(c1401JbA00);
    }
}
