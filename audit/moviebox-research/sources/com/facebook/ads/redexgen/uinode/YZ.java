package com.facebook.ads.redexgen.uinode;

import com.facebook.ads.internal.dynamicloading.DynamicLoader;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class YZ extends KT {
    public final /* synthetic */ C1794Ym A00;

    public YZ(C1794Ym c1794Ym) {
        this.A00 = c1794Ym;
    }

    @Override // com.facebook.ads.redexgen.uinode.KT
    public final void A06() {
        DynamicLoader dynamicLoader = DynamicLoaderFactory.getDynamicLoader();
        if (dynamicLoader != null) {
            dynamicLoader.createBidderTokenProviderApi().getBidderToken(this.A00);
        }
    }
}
