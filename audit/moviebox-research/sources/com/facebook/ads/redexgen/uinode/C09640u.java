package com.facebook.ads.redexgen.uinode;

import com.facebook.ads.internal.protocol.AdPlacementType;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.0u, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C09640u {
    public static InterfaceC09590p A00;

    public final InterfaceC09590p A00(C1795Yn c1795Yn, AdPlacementType adPlacementType) {
        InterfaceC09590p interfaceC09590p = A00;
        if (interfaceC09590p != null) {
            return interfaceC09590p;
        }
        switch (C09630t.A00[adPlacementType.ordinal()]) {
            case 1:
                return new C1916bN();
            case 2:
                return new C1915bM();
            case 3:
                return new C1913bK(c1795Yn);
            case 4:
                return new C1304Fb(c1795Yn);
            case 5:
                return new FY();
            default:
                return null;
        }
    }
}
