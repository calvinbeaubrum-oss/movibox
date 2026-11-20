package com.facebook.ads.redexgen.uinode;

import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class FT extends AbstractC1898b5 {
    public static byte[] A00 = null;
    public static String[] A01 = {"jMc", "F9KJU5nWCxEJfH1MtrJPQ98rlg2xhqhb", "7jNlYgKw34wypv3TsOCVRM97qni1IFkS", "W5gvHzH3tQhCbbf1Q7sr07NWbFeRHxz0", "QDsxhdyObZs2LD8uuSUlwesP8VUImdt4", "RqkZZA1TQwwc7Sj8gFRGBwQRvCLKOG1p", "3", "FXFS7BhAGvbRYPXLgdilxhgSLH2Ol13Z"};
    public static final long serialVersionUID = 5751287062553772012L;

    static {
        A04();
    }

    public FT(List<C1G> list) {
        super(list);
    }

    public static FT A02(JSONObject jSONObject, C1795Yn c1795Yn) {
        FT ft2 = new FT(AbstractC1898b5.A08(jSONObject, c1795Yn, new C1894b1()));
        ft2.A16(jSONObject);
        ft2.A0b(A03(0, 6, 46));
        return ft2;
    }

    public static String A03(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i11, i11 + i12);
        int i14 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A01[0].length() == 16) {
                throw new RuntimeException();
            }
            A01[0] = "basKOcZiobbMvO07tra14WeVIAzrAzDF";
            if (i14 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 105);
            i14++;
        }
    }

    public static void A04() {
        A00 = new byte[]{5, -8, Ascii.VT, 0, Ascii.CR, -4};
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
