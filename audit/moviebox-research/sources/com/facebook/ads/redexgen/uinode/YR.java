package com.facebook.ads.redexgen.uinode;

import java.util.Map;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class YR implements InterfaceC11257i {
    public final C11237f A00;

    public YR(C11237f c11237f) {
        this.A00 = c11237f;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC11257i
    public final Map<String, String> A4n() {
        return C11428d.A01(this.A00);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC11257i
    public final Map<String, String> A61() {
        return C8J.A02();
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC11257i
    public final String A7F() {
        return C8J.A00();
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC11257i
    public final String A7H() {
        return C6E.A00().A03();
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC11257i
    public final boolean A94() {
        return C1437Kp.A00().A03();
    }
}
