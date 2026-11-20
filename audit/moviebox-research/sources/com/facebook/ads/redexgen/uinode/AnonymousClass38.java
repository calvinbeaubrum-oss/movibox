package com.facebook.ads.redexgen.uinode;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.38, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AnonymousClass38 extends C10393r {
    public BQ A00;
    public List<C1567Pp> A01;

    public AnonymousClass38(C1795Yn c1795Yn) {
        super(c1795Yn);
        this.A00 = new BQ(this, 1, null, null, null);
    }

    public final void A1y(RE re2) {
        BQ bq2 = this.A00;
        if (bq2 != null) {
            bq2.A0c(re2);
        }
    }

    public BQ getCarouselCardBehaviorHelper() {
        return this.A00;
    }

    public void setCardsInfo(ArrayList arrayList) {
        this.A01 = arrayList;
        this.A00.A0d(arrayList);
    }
}
