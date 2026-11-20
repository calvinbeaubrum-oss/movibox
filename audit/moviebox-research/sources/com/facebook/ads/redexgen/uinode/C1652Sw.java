package com.facebook.ads.redexgen.uinode;

import android.text.TextUtils;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Sw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1652Sw extends RD {
    public final /* synthetic */ AbstractC1648Ss A00;

    public C1652Sw(AbstractC1648Ss abstractC1648Ss) {
        this.A00 = abstractC1648Ss;
    }

    @Override // com.facebook.ads.redexgen.uinode.RD
    public final void A03() {
        if (this.A00.A06.A07()) {
            return;
        }
        this.A00.A06.A05();
        if (TextUtils.isEmpty(this.A00.A01.A12())) {
            return;
        }
        this.A00.A04.A9g(this.A00.A01.A12(), new C1508Ni().A03(this.A00.A0A).A02(this.A00.A06).A04(this.A00.A01.A0O()).A05());
        C1U.A07(this.A00.A01.A0y(), this.A00.A03);
        this.A00.A03.A0E().A2k();
        C2O.A00(this.A00.A01.A0N());
        this.A00.A08.A43(this.A00.A09.A7B());
    }
}
