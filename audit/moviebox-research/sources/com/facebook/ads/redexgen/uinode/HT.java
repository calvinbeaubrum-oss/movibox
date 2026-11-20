package com.facebook.ads.redexgen.uinode;

import com.facebook.ads.sync.SyncModifiableBundle;
import java.util.Map;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class HT implements S1 {
    public final EnumC1623Rt A00;
    public final AnonymousClass74 A01;

    public HT(AnonymousClass74 anonymousClass74, EnumC1623Rt enumC1623Rt) {
        this.A01 = anonymousClass74;
        this.A00 = enumC1623Rt;
    }

    @Override // com.facebook.ads.redexgen.uinode.S1
    public void A3Z(Map<InterfaceC1613Rj, S6> map, Map<SyncModifiableBundle, EnumC1623Rt> map2) {
        map2.put(null, this.A00);
    }
}
