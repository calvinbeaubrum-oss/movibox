package com.facebook.ads.redexgen.uinode;

import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class FV extends AbstractC1898b5 {
    public static byte[] A00 = null;
    public static final long serialVersionUID = 5751287062553772012L;

    static {
        A04();
    }

    public FV(List<C1G> list) {
        super(list);
    }

    public static FV A02(JSONObject jSONObject, C1795Yn c1795Yn) {
        FV fv2 = new FV(AbstractC1898b5.A08(jSONObject, c1795Yn, new C1897b4()));
        fv2.A16(jSONObject);
        fv2.A0b(A03(0, 6, 27));
        return fv2;
    }

    public static String A03(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 8);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A00 = new byte[]{-123, -124, -111, -111, -120, -107};
    }

    @Override // com.facebook.ads.redexgen.uinode.C1F
    public final int A0F() {
        return 0;
    }

    @Override // com.facebook.ads.redexgen.uinode.C1F
    public final int A0G() {
        return 0;
    }
}
