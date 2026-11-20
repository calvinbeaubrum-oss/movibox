package com.facebook.ads.redexgen.uinode;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Sc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1632Sc implements InterfaceC1544Os {
    public final /* synthetic */ C1631Sb A00;

    public C1632Sc(C1631Sb c1631Sb) {
        this.A00 = c1631Sb;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1544Os
    public final void ADb(View view) {
        if (this.A00.A09) {
            this.A00.A07 = false;
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1544Os
    public final void ADd(View view) {
        TS ts2 = (TS) view;
        ts2.A16();
        if (this.A00.A09) {
            this.A00.A07 = true;
        }
        if (this.A00.A04.A0Z() && ((Integer) ts2.getTag(-1593835536)).intValue() == 0) {
            this.A00.A04.A0U();
        }
    }
}
