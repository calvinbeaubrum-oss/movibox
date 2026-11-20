package com.facebook.ads.redexgen.uinode;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.cH, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1960cH {
    public static C1960cH A02 = null;
    public final C1972cT A00;
    public final C1970cR A01;

    public C1960cH(AbstractC1976cY abstractC1976cY, C1970cR c1970cR, C1972cT c1972cT) {
        this.A00 = c1972cT;
        this.A01 = c1970cR;
        abstractC1976cY.A02(new H2(c1970cR));
    }

    public static C1960cH A00(AbstractC1976cY abstractC1976cY, InterfaceC1980cc interfaceC1980cc, HB hb2) {
        C1960cH c1960cH = A02;
        if (c1960cH != null) {
            return c1960cH;
        }
        C1972cT c1972cT = new C1972cT();
        return new C1960cH(abstractC1976cY, new C1970cR(interfaceC1980cc, new HL(), hb2, c1972cT, new Handler(Looper.getMainLooper())), c1972cT);
    }

    public final void A01(cX cXVar) {
        this.A01.A09(cXVar);
    }

    public final void A02(InterfaceC1974cV interfaceC1974cV) {
        this.A01.A0A(interfaceC1974cV);
    }

    public final void A03(DspViewableNode dspViewableNode) {
        this.A00.A01(dspViewableNode);
    }

    public final void A04(DspViewableNode dspViewableNode, C1978ca c1978ca) {
        this.A00.A02(dspViewableNode, c1978ca);
    }
}
