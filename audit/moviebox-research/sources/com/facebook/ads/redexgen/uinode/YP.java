package com.facebook.ads.redexgen.uinode;

import com.facebook.ads.internal.bridge.gms.AdvertisingId;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class YP implements InterfaceC11267j {
    public final /* synthetic */ AdvertisingId A00;
    public final /* synthetic */ YO A01;

    public YP(YO yo2, AdvertisingId advertisingId) {
        this.A01 = yo2;
        this.A00 = advertisingId;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC11267j
    public final boolean A97() {
        return this.A00.isLimitAdTracking();
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC11267j
    public final String getId() {
        return this.A00.getId();
    }
}
