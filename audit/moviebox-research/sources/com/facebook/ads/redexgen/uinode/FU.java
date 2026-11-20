package com.facebook.ads.redexgen.uinode;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class FU extends AbstractC1898b5 implements Serializable {
    public static byte[] A00 = null;
    public static final long serialVersionUID = 5751287062553772011L;

    static {
        A04();
    }

    public FU(List<C1G> list) {
        super(list);
    }

    public static FU A02(JSONObject jSONObject, C1795Yn c1795Yn) {
        FU fu2 = new FU(AbstractC1898b5.A08(jSONObject, c1795Yn, new C1895b2()));
        fu2.A16(jSONObject);
        fu2.A0b(A03(0, 12, 67));
        return fu2;
    }

    public static String A03(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 98);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A00 = new byte[]{72, 79, 85, 68, 83, 82, 85, 72, 85, 72, 64, 77};
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
