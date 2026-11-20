package com.facebook.ads.redexgen.uinode;

import java.util.Arrays;
import org.json.JSONException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Vb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1708Vb implements InterfaceC1615Rl {
    public static byte[] A02;
    public final /* synthetic */ C1794Ym A00;
    public final /* synthetic */ InterfaceC1613Rj A01;

    static {
        A01();
    }

    public C1708Vb(InterfaceC1613Rj interfaceC1613Rj, C1794Ym c1794Ym) {
        this.A01 = interfaceC1613Rj;
        this.A00 = c1794Ym;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 32);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{-120, -121, -125, -106, -105, -108, -121, -127, -123, -111, -112, -120, -117, -119};
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1615Rl
    public final void A45() {
        try {
            C1384Ih.A0R(this.A00).A2Y(this.A01.A6h().optJSONObject(A00(0, 14, 2)));
        } catch (JSONException e11) {
            this.A00.A07().A3c(e11);
        }
    }
}
