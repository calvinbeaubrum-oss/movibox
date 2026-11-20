package com.facebook.ads.redexgen.uinode;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class D7 {
    public static byte[] A02;
    public final List<Format> A00;
    public final C4[] A01;

    static {
        A01();
    }

    public D7(List<Format> list) {
        this.A00 = list;
        this.A01 = new C4[list.size()];
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 56);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{-107, -70, -62, -83, -72, -75, -80, 108, -81, -72, -69, -65, -79, -80, 108, -81, -83, -68, -64, -75, -69, -70, 108, -71, -75, -71, -79, 108, -64, -59, -68, -79, 108, -68, -66, -69, -62, -75, -80, -79, -80, -122, 108, -17, -2, -2, -6, -9, -15, -17, 2, -9, -3, -4, -67, -15, -13, -17, -69, -60, -66, -58, -4, Ascii.VT, Ascii.VT, 7, 4, -2, -4, Ascii.SI, 4, 10, 9, -54, -2, 0, -4, -56, -46, -53, -45};
    }

    public final void A02(long j11, C1376Hz c1376Hz) {
        AbstractC1325Fy.A03(j11, c1376Hz, this.A01);
    }

    public final void A03(InterfaceC1235Bu interfaceC1235Bu, DC dc2) {
        for (int i11 = 0; i11 < this.A01.length; i11++) {
            dc2.A05();
            C4 c4AGi = interfaceC1235Bu.AGi(dc2.A03(), 3);
            Format format = this.A00.get(i11);
            String str = format.A0O;
            AbstractC1351Ha.A05(A00(43, 19, 86).equals(str) || A00(62, 19, 99).equals(str), A00(0, 43, 20) + str);
            c4AGi.A5n(Format.A08(format.A0M != null ? format.A0M : dc2.A04(), str, null, -1, format.A0D, format.A0N, format.A03, null));
            this.A01[i11] = c4AGi;
        }
    }
}
