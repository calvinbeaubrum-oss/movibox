package com.facebook.ads.redexgen.uinode;

import com.facebook.ads.RewardData;
import com.facebook.ads.internal.protocol.AdPlacementType;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.b9, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1902b9 implements InterfaceC09590p {
    public int A00;
    public long A01;
    public RewardData A02;

    public final void A00(int i11) {
        this.A00 = i11;
    }

    public final void A01(long j11) {
        this.A01 = j11;
    }

    public final void A02(RewardData rewardData) {
        this.A02 = rewardData;
    }

    public abstract int A0G();

    public abstract C1F A0H();

    public abstract boolean A0I();

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC09590p
    public final AdPlacementType A7e() {
        return AdPlacementType.REWARDED_VIDEO;
    }
}
