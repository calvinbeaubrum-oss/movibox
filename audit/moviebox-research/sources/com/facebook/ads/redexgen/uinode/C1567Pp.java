package com.facebook.ads.redexgen.uinode;

import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Pp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1567Pp {
    public static byte[] A03;
    public final int A00;
    public final int A01;
    public final C1G A02;

    static {
        A01();
    }

    public C1567Pp(int i11, int i12, C1G c1g) {
        this.A01 = i11;
        this.A00 = i12;
        this.A02 = c1g;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 75);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{-27, -29, -12, -26, -27, -16, -10, Ascii.FF, 10, Ascii.ESC, Ascii.CR, Ascii.DC2, Ascii.ETB, Ascii.CR};
    }

    public final int A02() {
        return this.A01;
    }

    public final C1G A03() {
        return this.A02;
    }

    public final Map<String, String> A04() {
        HashMap map = new HashMap();
        StringBuilder sbAppend = new StringBuilder().append(this.A01);
        String strA00 = A00(0, 0, 12);
        map.put(A00(7, 7, 94), sbAppend.append(strA00).toString());
        map.put(A00(0, 7, 55), this.A00 + strA00);
        return map;
    }
}
