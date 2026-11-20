package com.facebook.ads.redexgen.uinode;

import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ti, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1664Ti implements InterfaceC1507Nh {
    public final WeakReference<BK> A00;

    public C1664Ti(BK bk2) {
        this.A00 = new WeakReference<>(bk2);
    }

    public /* synthetic */ C1664Ti(BK bk2, BP bp2) {
        this(bk2);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1507Nh
    public final void ABh(boolean z11) {
        BK bk2 = this.A00.get();
        if (bk2 != null) {
            bk2.A04 = z11;
            bk2.A04();
        }
    }
}
