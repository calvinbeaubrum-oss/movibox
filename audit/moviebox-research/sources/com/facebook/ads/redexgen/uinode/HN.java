package com.facebook.ads.redexgen.uinode;

import com.facebook.ads.sync.SyncModifiableBundle;
import java.util.Map;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class HN implements S1 {
    public final C1373Hw A00;
    public final S6 A01;

    public HN(C1373Hw c1373Hw, S6 s11) {
        this.A00 = c1373Hw;
        this.A01 = s11;
    }

    @Override // com.facebook.ads.redexgen.uinode.S1
    public void A3Z(Map<InterfaceC1613Rj, S6> map, Map<SyncModifiableBundle, EnumC1623Rt> map2) {
        map.put(this.A00, this.A01);
    }
}
