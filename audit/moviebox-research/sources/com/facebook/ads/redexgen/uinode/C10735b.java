package com.facebook.ads.redexgen.uinode;

import android.content.Context;
import com.facebook.ads.internal.api.BidderTokenProviderApi;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.5b, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C10735b implements BidderTokenProviderApi {
    public final C6T A00 = new C6T();

    public final C6T A00() {
        return this.A00;
    }

    @Override // com.facebook.ads.internal.api.BidderTokenProviderApi
    public final String getBidderToken(Context context) {
        return this.A00.A06(C10745c.A09(context));
    }
}
