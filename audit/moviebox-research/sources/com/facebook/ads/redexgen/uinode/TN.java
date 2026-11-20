package com.facebook.ads.redexgen.uinode;

import java.util.Arrays;
import org.json.JSONObject;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class TN implements P2 {
    public static byte[] A01;
    public final /* synthetic */ B3 A00;

    static {
        A01();
    }

    public TN(B3 b11) {
        this.A00 = b11;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 23);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-49, -53, -64, -40};
    }

    @Override // com.facebook.ads.redexgen.uinode.P2
    public final void ADY(String str, JSONObject jSONObject) {
        if (str.equals(A00(0, 4, 72))) {
            this.A00.AGY();
            if (C1384Ih.A1W(this.A00.A07)) {
                this.A00.A07.A0A().ABG();
            }
        }
        this.A00.A0F.A0h(str, jSONObject);
    }
}
