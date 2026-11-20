package com.facebook.ads.redexgen.uinode;

import com.facebook.ads.AdError;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.av, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1888av implements C6U {
    public static String[] A05 = {"udExhBBZigXHD765", "VCbgsgLtwNII3DWSf3Df", "sJ3cSki5Ts1gkpIy0", "hudoenMQ7OfQJqKUwYviTAHkC5956B", "3GiDDKpH2PPu7", "VAV0OzmNbR17K1ZAu", "eIBPlY8UdwZIA15YBWaPzTw3Re1i6Niv", "w6ShnqqW6c5InpRu2fdQvGfdyx0XiT7r"};
    public final /* synthetic */ AbstractC1898b5 A00;
    public final /* synthetic */ InterfaceC09771h A01;
    public final /* synthetic */ C09781i A02;
    public final /* synthetic */ C1795Yn A03;
    public final /* synthetic */ boolean A04;

    public C1888av(C09781i c09781i, C1795Yn c1795Yn, boolean z11, AbstractC1898b5 abstractC1898b5, InterfaceC09771h interfaceC09771h) {
        this.A02 = c09781i;
        this.A03 = c1795Yn;
        this.A04 = z11;
        this.A00 = abstractC1898b5;
        this.A01 = interfaceC09771h;
    }

    private void A00(boolean z11) {
        if (!z11) {
            this.A01.AAe(AdError.CACHE_ERROR);
            return;
        }
        C1795Yn c1795Yn = this.A03;
        String[] strArr = A05;
        if (strArr[7].length() != strArr[6].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A05;
        strArr2[5] = "ua1Hqbcww3qJrVJ6O";
        strArr2[2] = "2U70GzBDbPON7gkn8";
        if (C1384Ih.A1O(c1795Yn) && this.A04) {
            this.A02.A02.add(PC.A01(this.A03, this.A00, 1, new C1889aw(this)));
        } else {
            this.A01.AAf();
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.C6U
    public final void AB2() {
        A00(false);
    }

    @Override // com.facebook.ads.redexgen.uinode.C6U
    public final void ABB() {
        A00(true);
    }
}
