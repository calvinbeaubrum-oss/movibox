package com.facebook.ads.redexgen.uinode;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class SX extends RD {
    public static String[] A06 = {"9EcwbXL", "xSjvPMkgWWioBuUjephCpzaMcXmM2sD", "H", "Z0OwbQNEejaaYPjBGD9d9AX", "LifEXsQyKShCOMizwIOXiweZ0", "XJXBCYBKjtegaNwUZmi8zWUKmanAO", "UJgIUi3fLAa", "b39pUeydvHz6vxm1zIrt3qO8a47iYX"};
    public final /* synthetic */ J2 A00;
    public final /* synthetic */ C1454Lg A01;
    public final /* synthetic */ C1567Pp A02;
    public final /* synthetic */ SV A03;
    public final /* synthetic */ String A04;
    public final /* synthetic */ Map A05;

    public SX(SV sv2, String str, C1567Pp c1567Pp, J2 j11, Map map, C1454Lg c1454Lg) {
        this.A03 = sv2;
        this.A04 = str;
        this.A02 = c1567Pp;
        this.A00 = j11;
        this.A05 = map;
        this.A01 = c1454Lg;
    }

    @Override // com.facebook.ads.redexgen.uinode.RD
    public final void A03() {
        if (this.A03.A02.A0Z()) {
            return;
        }
        String str = this.A04;
        if (A06[0].length() != 7) {
            throw new RuntimeException();
        }
        A06[7] = "G0eOJNFPtps4qsYKpGpuAXPxSINW56";
        if (TextUtils.isEmpty(str) || this.A03.A05.get(this.A02.A02())) {
            return;
        }
        this.A00.A9g(this.A04, new C1508Ni(this.A05).A03(this.A03.A03).A02(this.A01).A05());
        C1U.A07(this.A03.A00, this.A03.A06);
        this.A03.A05.put(this.A02.A02(), true);
    }
}
