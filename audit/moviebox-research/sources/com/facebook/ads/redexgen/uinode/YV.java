package com.facebook.ads.redexgen.uinode;

import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class YV implements RI {
    public static byte[] A01;
    public final C1794Ym A00;

    static {
        A01();
    }

    public YV(C1794Ym c1794Ym) {
        this.A00 = c1794Ym;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 127);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-2, -45, -20, -24, -45, -10, Ascii.NAK, Ascii.NAK, Ascii.DC2, -45, -8, Ascii.NAK, Ascii.ESC, Ascii.SUB, Ascii.SI, Ascii.DC4, Ascii.CR, -45, -6, Ascii.NAK, 17, Ascii.VT, Ascii.DC4, 102, 100, 86, 99, Ascii.RS, 82, 88, 86, 95, 101};
    }

    @Override // com.facebook.ads.redexgen.uinode.RI
    public final Map<String, String> A5o(boolean z11) {
        HashMap map = new HashMap();
        if (!C6E.A00().A04()) {
            map.put(A00(0, 23, 39), C11508l.A00().A01(this.A00, true).A03());
        }
        map.put(A00(23, 10, 114), AbstractC11538o.A06(new C8K(this.A00), this.A00, z11));
        return map;
    }
}
